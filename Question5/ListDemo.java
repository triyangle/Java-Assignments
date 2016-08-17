
import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> intList = new ArrayList<>();
		
		intList.add(0);
		intList.add(1);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(5);
		intList.add(8);
		intList.add(10);
		intList.add(8);
		intList.add(11);
		intList.add(13);
		intList.add(0);
		
		ListIterator<Integer> listIterator = intList.listIterator();
	
		while(listIterator.hasNext()) {
			
			System.out.print(listIterator.next() + " ");
			
		}
		
		System.out.println();
		
		List<String> stringList = new ArrayList<>();
		
		stringList.add("California");
		stringList.add("Nevada");
		stringList.add("New York");
		stringList.add("Utah");
		stringList.add("Washington");
		stringList.add("Illinois");
		stringList.add("Oregon");
		stringList.add("California");
		stringList.add("New York");
		stringList.add("Washington");
		stringList.add("Michigan");
		stringList.add("New Mexico");
		stringList.add("Alaska");
		
		for(String state: stringList) {
			
			System.out.print(state + " ");
			
		}
		
		System.out.println();
		
		Set<Integer> intSet = new LinkedHashSet<>(intList);
		
		System.out.println(intSet);
		
		Set<String> stringSet = new LinkedHashSet<>(stringList);
		
		System.out.println(stringSet);
		
	}

}

/* OUTPUT:
 * 0 1 1 2 3 5 8 10 8 11 13 0 
 * California Nevada New York Utah Washington Illinois Oregon California New York Washington Michigan New Mexico Alaska  
 * [0, 1, 2, 3, 5, 8, 10, 11, 13]
 * [California, Nevada, New York, Utah, Washington, Illinois, Oregon, Michigan, New Mexico, Alaska]
 * 
 */
