import java.util.ArrayList;

public class PrimeFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		getFactors(calcPrimeFactors(15));
		
	}
	
	public static ArrayList calcPrimeFactors(int input) {
		
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		
		for(int factor = 2; factor < input; factor++) {
			
			//System.out.println(factor);
			
			boolean isPrimeFactor = false;
			
			if(input % factor == 0) {
				
				for(int prime = 2; prime <= factor; prime++) {
					
					if(factor % prime == 0 && factor!= prime) {
						
						isPrimeFactor = false;
						break;
						
					} else {
					
						isPrimeFactor = true;
					
					}
					
				}
				
				if(isPrimeFactor) {

					primeFactors.add(factor);
					
				}

			}
			
			
		}
		
		return primeFactors;
		
	}
	
	public static void getFactors(ArrayList primeList) {
		
		for(int i = 0; i < primeList.size(); i++) {
			
			System.out.println(primeList.get(i));
			
		}
		
	}

}
