import java.io.*;

public class HW1 {

	public static void main(String[] args) {

		String one = "";
		String two = "";
		String combo = "";

		 try {

			String buffer = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Please enter a string: ");
			buffer = br.readLine();
			one = buffer;

			System.out.print("Please enter a string: ");
			buffer = br.readLine();
			two = buffer;

			br.close();

		} catch (IOException e) { e.printStackTrace(); }

		if(one.compareTo(two) < 0) {
			combo = one + two;

		} else {

			combo = two + one;
		}

		System.out.print(combo);

	}

}
