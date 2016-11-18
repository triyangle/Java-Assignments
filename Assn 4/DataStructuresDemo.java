
import java.util.*;

/*
 * ArrayList: An ArrayList is one of the 2 concrete classes of the List interface.
 * As a List, an ArrayList defines an ordered collection with duplicate elements allowed.
 * An ArrayList stores elements in an array which is dynamically created.
 * If the array capacity is exceeded, a new larger array is created and the elements from the old array are copied into the new one.
 * As such, as more elements are added to an ArrayList, it's capacity grows automatically.
 * However, an ArrayList does not shrink automatically.
 *
 * HashMap: A HashMap is one of the concrete classes of the Map interface.
 * A HashMap maps keys to elements in no specific order.
 * Additionally, as a Map, a HashMap cannot contain duplicate keys.
 * The keys of a Map can be of any object type.
 * A HashMap is generally quite efficient for locating a value, inserting an entry, and deleting an entry.
 *
 * Set: The Set interface is a subtype of the Collections interface.
 * An instance of Set may not contain any duplicate elements.
 * Three concrete classes of the Set interface include the HashSet, LinkedHashSet, and TreeSet.
 * A HashSet stores elements in a random order while a LinkedHashSet stores elements in the order in which they were inserted.
 * A TreeSet stores elements in a sorted order.
 *
 */

public class DataStructuresDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arrayList = new ArrayList<>();

		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(8);

		System.out.println("ArrayList: " + arrayList);

		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("1st", 0);
		hashMap.put("2nd", 1);
		hashMap.put("3rd", 1);
		hashMap.put("4th", 2);
		hashMap.put("5th", 3);
		hashMap.put("6th", 5);
		hashMap.put("7th", 8);

		System.out.println("HashMap: " + hashMap);

		Set<Integer> linkedHashSet = new LinkedHashSet<>(arrayList);

		System.out.println("LinkedHashSet: " + linkedHashSet);

	}

}

/* OUTPUT:
 * ArrayList: [0, 1, 1, 2, 3, 5, 8]
 * HashMap: {1st=0, 3rd=1, 2nd=1, 4th=2, 5th=3, 6th=5, 7th=8} //output may vary as ordering of elements is random
 * LinkedHashSet: [0, 1, 2, 3, 5, 8]
 *
 */
