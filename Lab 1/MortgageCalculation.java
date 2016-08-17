/*
	@version 1.2 12/24/2014
	@author William Yang

	File name: MortgageCalculation.java
	Program purpose: This program is to implement a simple mortgage calculation program.

	Revision history:
	Date		Programmer		Change ID	Description
	07/02/2014  William Yang    1           Initial creation
	12/24/2014	William Yang	2			Cleaning up code
	9/25/2015	William Yang	3			Adding documentation/cleaning unused code
 */

import java.io.*;

/**
 * The purpose of this program is to implement a simple text based mortgage calculation program that
 * reads user input from the console and prints out the output calculations.
 * 
 * @version 1.2 9/25/15
 * @author William Yang
 * 
 */

public class MortgageCalculation {

	public static final double taxRate = 1.5;

	/**
	 * Initializes several local variables and also modifies them by calling appropriate methods to
	 * obtain user input as well as to calculate and display the output.
	 * 
	 * @param args Unused parameter
	 */
	public static void main(String[] args) {

		String propertyAddress = "";
		double propertyValue = 0.0;
		double interestRate = 0.0;
		int loanDuration = 0;
		double downPayment = 0;

		double loanAmount = 0.0;
		double monthlyRate = 0.0;
		double monthlyPayment = 0.0;
		double propertyTaxPayment = 0.0;
		double totalPayment = 0.0;

		propertyAddress = getAddress("Enter property address: ");
		propertyValue = getDoubleValue("Enter property value: $");
		interestRate = getDoubleValue("Enter annual interest rate (%): ");
		loanDuration = getLoanDuration("Enter number of loan duration (years): ");
		downPayment = getDoubleValue("Enter down payment in percentage (%): ");

		loanAmount = calculateLoanAmount(propertyValue, downPayment);
		monthlyRate = calculateMonthlyRate(interestRate);
		monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyRate, loanDuration);
		propertyTaxPayment = calculateTaxPayment(propertyValue, taxRate);
		totalPayment = calculateTotalPayment(monthlyPayment, loanDuration);

		displayOutput(propertyAddress, propertyValue, downPayment, loanAmount, monthlyPayment, propertyTaxPayment, totalPayment);

	}

	/**
	 * Utilizes a try-catch block to initialize the property address field with the user input.
	 * 
	 * @param prompt The String to display when prompting for user input
	 * @return Tthe property address as a String
	 */
	public static String getAddress(String prompt) {

		String getPropertyAddress = "";

		try {

			String buffer = "";
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

			//read property address
			System.out.print(prompt);

			buffer = br.readLine();
			getPropertyAddress = buffer;

		} catch (IOException e) { e.printStackTrace (); }

		return getPropertyAddress;				
	}

	/**
	 * Utilizes a try-catch block to initialize the double values with user input. Double values include
	 * property value, interest rate, and down payment (as a %).
	 * 
	 * @param prompt The String to display when prompting for user input
	 * @return The user input for the particular prompt as a double
	 */
	public static double getDoubleValue(String prompt) {

		double input = 0.0;

		try {

			String buffer = "";
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

			//read value
			System.out.print(prompt);
			buffer = br.readLine();
			input = Double.parseDouble(buffer);

		} catch (IOException e) { e.printStackTrace (); }

		return input;

	}

	/**
	 * Utilizes a try-catch block to initialize the load duration value with user input.
	 * 
	 * @param prompt The String to display when prompting for user input
	 * @return The input for loan duration value as an int
	 */
	public static int getLoanDuration(String prompt) {

		int getLoanDuration = 0;

		try {

			String buffer = "";
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

			//read loan duration
			System.out.print(prompt);
			buffer = br.readLine();
			getLoanDuration = Integer.parseInt(buffer);

		} catch (IOException e) { e.printStackTrace(); }

		return getLoanDuration;
	}
	
	/**
	 * Calculates the loan amount.
	 * 
	 * @param propertyValue The total property value
	 * @param downPayment The percentage of the total property value that is paid initially paid as down payment
	 * @return The loan amount as a double
	 */
	public static double calculateLoanAmount (double propertyValue, double downPayment) {

		double getLoanAmount = 0.0;

		//calculate loan amount
		getLoanAmount = propertyValue*(1-(downPayment/100));

		return getLoanAmount;

	}

	/**
	 * Calculates the monthly interest rate.
	 * 
	 * @param interestRate The total annual interest rate as a percent
	 * @return The monthly interest rate
	 */
	public static double calculateMonthlyRate(double interestRate) {

		double getMonthlyRate = 0.0;

		//calculate monthly interest rate
		getMonthlyRate = interestRate/100/12;

		return getMonthlyRate;
	}

	/**
	 * Calculates the monthly payments.
	 * 
	 * @param loanAmount The total loan amount
	 * @param monthlyRate The monthly interest rate
	 * @param loanDuration The total loan duration
	 * @return The monthly payment amount
	 */
	public static double calculateMonthlyPayment(double loanAmount, double monthlyRate, int loanDuration) {

		double getMonthlyPayment = 0.0;

		//calculate mortgage monthly payment
		getMonthlyPayment = loanAmount*monthlyRate/(1-1/Math.pow(1+monthlyRate, loanDuration*12));

		return getMonthlyPayment;

	}

	/**
	 * Calculates the total monthly payment including property tax.
	 * 
	 * @param propertyValue The total property value
	 * @param taxRate The annual tax rate
	 * @return The monthly payments including property tax
	 */
	public static double calculateTaxPayment(double propertyValue, double taxRate) {

		double getTaxPayment = 0.0;

		//calculate property tax monthly payment
		getTaxPayment = propertyValue*taxRate/100/12;

		return getTaxPayment;
	}

	/**
	 * Calculates the total payment without property tax over the specified loan duration period.
	 * 
	 * @param monthlyPayment The total monthly payment amounts, not including property tax
	 * @param loanDuration The total duration of the loan, in years
	 * @return The total payment over the loan duration
	 */
	public static double calculateTotalPayment(double monthlyPayment, int loanDuration) {

		double getTotalPayment = 0.0;

		//calculate total payment
		getTotalPayment = monthlyPayment*12*loanDuration;

		return getTotalPayment;

	}

	/**
	 * Prints the output onto the console. Simulates a longer calculation time using Thread.sleep for
	 * 2 seconds.
	 * 
	 * 
	 * @param propertyAddress The property address
	 * @param propertyValue The total property value
	 * @param downPayment The initial down payment amount
	 * @param loanAmount The loan amount
	 * @param monthlyPayment The monthly payments without property tax
	 * @param propertyTaxPayment The monthly payments including property tax
	 * @param totalPayment The total payment over the loan duration
	 */
	public static void displayOutput (String propertyAddress, double propertyValue, double downPayment, 
			double loanAmount, double monthlyPayment, double propertyTaxPayment, double totalPayment) {

		System.out.println("\nMortgage calculator is processing data ... Please wait ...");

		try {

			//sleep for 2 seconds
			Thread.sleep (2000);

		} catch (InterruptedException e) { }

		System.out.println("\n\t\t***************************");
		System.out.println("\t\tMORTGAGE CALCULATOR RESULTS");
		System.out.println("\t\t***************************\n");

		System.out.format("%-45s %31s%n", "Property address:", propertyAddress);
		System.out.format("%-45s$%31.2f%n", "Property value:", propertyValue);
		System.out.format("%-45s$%31.2f%n", "Down payment:", propertyValue*(downPayment/100));
		System.out.format("%-45s$%31.2f%n", "Loan amount:", loanAmount);
		System.out.format("%-45s$%31.2f%n", "Mortgage monthly payment:", monthlyPayment);
		System.out.format("%-45s$%31.2f%n", "Monthly payment (property tax included):", propertyTaxPayment+monthlyPayment);
		System.out.format("%-45s$%31.2f", "Total payment:", totalPayment);

	}

}
