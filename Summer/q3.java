
public class q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[20][10];
		initArray(arr); // initialize the array
		System.out.println(arr[3][5]);   // prints 15 (3 * 5)
		System.out.println(arr[17][4]);  // prints 68 (17 * 4)


	}

	public static void initArray(int [][] array) {

		for(int i = 0; i < array.length; i++) {

			for(int j = 0; j < array[0].length; j++) {

				array[i][j] = i*j;

			}

		}

	}

}
