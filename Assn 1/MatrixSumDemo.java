
public class MatrixSumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initializes a 2d array testMatrix
		int[][] testMatrix = { 
				{1,2,3,4},
				{2,3,4,5},
				{3,4,5,6},
				{4,5,6,7}
		};
		
		//prints result of sumMatrix with testMatrix as an argument
		System.out.println(sumMatrix(testMatrix));
		
	}
	
	public static double sumMatrix(int[][] m) {
		
		double sum = 0;
		
		//adds each element in the 2d array to sum
		for(int rows = 0; rows < m.length; rows++) {
			
			for(int cols = 0; cols < m[0].length; cols++) {
				
				sum += m[rows][cols];
				
			}
			
		}
		
		return sum;
		
	}

}

/* OUPUT:
 * 64.0
 * 
 */
