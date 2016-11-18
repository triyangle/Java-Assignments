
public class PiFraction {

	public static void main(String[] args) {

		piFraction(.000001);

	}

	public static void piFraction(double gap) {

		for(double den = 0; ; den++) {

			for(double num = 0; num < (gap + Math.PI) * den ; num++) {

				if(Math.abs(num / den - Math.PI) < gap) {

					System.out.println(num + "/" + den + "=" + num / den);
					return;
				}

			}

		}

	}

}
