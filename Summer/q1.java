
public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sumSquares(1,5));
		System.out.println(sumSquares(-2,2));

	}

	public static int sumSquares(int x, int y) {

		int i = x;
		int sumSquare = 0;

		while(i <= y) {

			sumSquare += Math.pow(i,2);

			i++;

		}

		return sumSquare;

	}

}
