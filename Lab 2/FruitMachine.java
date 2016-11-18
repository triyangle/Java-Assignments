/*
	@version 1.1 12/29/2014
	@author William Yang

	File name: FruitMachine.java
	Program purpose: This program is to simulate a simple "one-armed" bandit slot machine.

	Revision history:
	Date		Programmer		Change ID	Description
	07/08/2014	William Yang	1			Initial creation
	12/29/2014  William Yang    2           Clarifying code
 */

import javax.swing.*;

public class FruitMachine {

	public static void main(String[] args) {

		boolean stillPlaying = true;
		int credit = 0;
		int option = 0;

		while (stillPlaying)  {

			String [] choices = {"Play", "Deposit", "Quit (cash out)"};

			//displays main gui

			String buffer = (String)JOptionPane.showInputDialog(null, "              Welcome to FRUIT MACHINE\n\nYour credit: " + credit + "\nPlease select your option:", "Fruit Machine", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

			//sets different numbers to different options
			if(buffer == "Play") {

				option = 1;

			} else {

			if(buffer == "Deposit") {

				option = 2;

			} else {

			if(buffer == "Quit (cash out)") {

				option = 3;

			} else {

			if(buffer == null) {

				option = 4;
			}
			}
			}

			}

			//sets different cases to their corresponding functions
			switch(option) {

			case 1:  credit += handlePlay(credit);
					 break;
			case 2:  credit += handleDeposit(credit);
					 break;
			case 3:
			case 4:  stillPlaying = handleQuit(credit, stillPlaying);
					 break;
			default: break;

			}
		}

	}

	public static int handleDeposit(int credit) {

		int getNewDeposit = 0;
		int newCredits = 0;
		String buffer;

		//displays an input dialog to get the deposit amount
		buffer = JOptionPane.showInputDialog(null, "Enter a deposit in $:", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);

		//if user clicks cancel or doesn't enter anything, returns 0 for deposit amount
		if(buffer == null || buffer.equals("")) {

			return 0;

		}

		//if user doesn't enter anything, returns 0 for deposit amount
		/*switch(buffer) {
			case "": return 0;
		}
		*/

		getNewDeposit = Integer.parseInt(buffer);

		newCredits = getNewDeposit*4;
		return newCredits;
	}


	public static int handlePlay(int credit) {

		String result = "";
		int letternumber = 0;
		int winCredits = 0;

		if(credit < 4) {
			JOptionPane.showMessageDialog(null, "Sorry, please deposit more credit.", "Fruit Machine", JOptionPane.WARNING_MESSAGE);

		} else {

			winCredits -= 4;

			try {

				JOptionPane.showMessageDialog(null, "Fruit Machine is generating the symbols ... Please wait ...", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);
				Thread.sleep (3000); // sleep for three seconds

			} catch (InterruptedException e) { }

			//gets the symbols for the combination
			while(letternumber < 3) {

				String symbol = "";

				int randomValue = (int)(Math.random()*5);

				//switch statement and nested if-else statement do the same thing
				switch(randomValue) {

				case 0: symbol = "A";
				        break;
				case 1: symbol = "D";
						break;
				case 2: symbol = "J";
						break;
				case 3: symbol = "O";
						break;
				case 4: symbol = "V";
						break;

				}
				/*
				if(randomValue == 0) {
					symbol = "A";

				} else {

				if(randomValue == 1) {
					symbol = "D";

				} else {

				if(randomValue == 2) {
					symbol = "J";

				} else {

				if(randomValue == 3) {
					symbol = "O";

				} else {

				if(randomValue == 4) {
					symbol = "V";
				}
				}
				}
				}
				}*/

			result += symbol;

			++letternumber;

			}
			//displays a message for each case of winning
			//sends a message for losing as default case
			switch(result) {

			case "OOD": winCredits += 10000;
						JOptionPane.showMessageDialog(null, "Congratulaions the winning combination " + result + " was generated. You have won 10000 credits.", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);
						break;
			case "JAV": winCredits += 5000;
						JOptionPane.showMessageDialog(null, "Congratulations the winning combination " + result + " was generated. You have won 5000 credits.", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);
						break;
			case "AAA":
			case "DDD":
			case "JJJ":
			case "OOO":
			case "VVV": winCredits += 200;
						JOptionPane.showMessageDialog(null, "Congratulations the winning combination " + result + " was generated. You have won 200 credits.", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);
						break;
			case "OOA":
			case "OOJ":
			case "OOV":
			case "AOO":
			case "DOO":
			case "JOO":
			case "VOO": winCredits += 100;
			JOptionPane.showMessageDialog(null, "Congratulations the winning combination " + result + " was generated. You have won 100 credits.", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);
						break;
			case "JJA":
			case "JJD":
			case "JJO":
			case "JJV":
			case "AJJ":
			case "DJJ":
			case "OJJ":
			case "VJJ": winCredits += 50;
						JOptionPane.showMessageDialog(null, "Congratulations the winning combination " + result + " was generated. You have won 50 credits.", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);
						break;
			default:    JOptionPane.showMessageDialog(null, "Sorry, the combination " + result + " is not a winning combination. You have not won any credits.", "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);

			}
		}

		return winCredits;

	}

	public static boolean handleQuit(int credit, boolean stillPlaying) {

		stillPlaying = false;
		double cashOut = 0.00;

		cashOut = credit/4.00;

		//displays a goodbye message
		JOptionPane.showMessageDialog(null, "Goodbye!\nCash-Out Value: " + String.format("$%1.2f%n", cashOut), "Fruit Machine", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);

		return stillPlaying;

	}

}
