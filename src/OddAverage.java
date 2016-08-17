
public class OddAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(computeOddAverage(25));
		
	}
	
	public static double computeOddAverage(int N) {
		
		int i = 0;
		int sum = 0;
		int number = 0;
		
		while(i <= N) {
			
			if(i%2 != 0) {
				
				sum += i;
				number++;
				
			}
			
			i++;
		}
		
		return (double)(sum/number);
	}

}
