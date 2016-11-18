
public class HW1a {

	public static void main(String[] args) {

		System.out.println(addDigits(781));

	}

	public static int addDigits(int a) {

		int sum = 0;

		while (a != 0) {

			sum += a%10; //sum = sum + a%10;
			a /= 10; //a = a/10
		}

		return sum;

	}

}
