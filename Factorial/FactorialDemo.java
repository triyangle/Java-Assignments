
import java.util.*;

public class FactorialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter a non-negative integer to calculate the factorial of: ");
		Scanner input = new Scanner(System.in);
		int inputNumber = input.nextInt();
		
		System.out.println(inputNumber + "! = " + factorial(inputNumber));
		
	}
	
	public static long factorial(int number) {
		
		switch(number) {
		
			case 0: return 1;
			default: return number*factorial(number-1);
		
		}
		
	}

}

/* Input 1:
 * Enter a non-negative integer to calculate the factorial of: 5
 * Output 1:
 * Enter a non-negative integer to calculate the factorial of: 5
 * 5! = 120
 * 
 * Input 2:
 * Enter a non-negative integer to calculate the factorial of: 7
 * Output 2:
 * Enter a non-negative integer to calculate the factorial of: 7
 * 7! = 5040
 * 
 * Input 3:
 * Enter a non-negative integer to calculate the factorial of: 10
 * Output 3:
 * Enter a non-negative integer to calculate the factorial of: 10
 * 10! = 3628800
 * 
 */
