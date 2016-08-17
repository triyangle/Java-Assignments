
public class Format {

	public static void main(String[] args) {
		int x = 1 ;

		while (x < 5) {

			System.out.format ("%03d%n",  x ) ;

			if(x == 3)

				x++;

			else
				x += 2;

		}

	}

}
