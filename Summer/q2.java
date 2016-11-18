import java.util.ArrayList;
import java.util.*;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Double> theList = new ArrayList<Double>();
		theList.add(1.5);
		theList.add(2.0);
		theList.add(3.2);
		theList.add(4.8);
		System.out.println(sumList(theList));


	}

	public static double sumList(ArrayList<Double> list) {

		double sum = 0;

		/*for(int i = 0; i <= (list.size()-1); i++) {

			sum += list.get(i);

		}*/

		for(double number: list) {

			sum += number;

		}

		return sum;

	}

}
