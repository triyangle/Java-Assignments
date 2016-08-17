
public class InPlaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//initializes an array with odd # of elements and one with even # of elements
		int[] oddArray = {1, 3, 5, 7, 9};
		int[] evenArray = {0, 2, 4, 6, 8, 10};
		
		//invokes in_place for both arrays
		in_place(oddArray);
		in_place(evenArray);
		
		//prints the elements of both arrays after reversing elements
		System.out.println(java.util.Arrays.toString(oddArray));
		System.out.println(java.util.Arrays.toString(evenArray));

	}
	
	public static void in_place(int[] arr) {
		
		for(int i = 0; i < (arr.length / 2); i++) {
		
			//sets the ith element to a temp variable
			int temp = arr[i];
			
			//swaps the ith element counting from the front with the ith element counting from the end
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
			
		}
		
	}

}

/* OUTPUT:
 * [9, 7, 5, 3, 1]
 * [10, 8, 6, 4, 2, 0]
 * 
 */