
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		calcPalindrome("racecar");

	}

	public static void calcPalindrome(String input) {

		int length = input.length();
		int midway = input.length() / 2;

		int palindromeCount = 0;

		for(int i = 0; i < midway; i++) {

			if(input.charAt(i) == input.charAt(length - 1 - i)) {

				palindromeCount++;

			}

		}

		if(palindromeCount == midway) {

			System.out.println("Is a palindrome");

		} else {

			System.out.println("Is not a palindrome");

		}

	}

}
