public class Circle {

	public double x,y;
	public double r;

	Circle()
	{
		x = 2.5; // this.x = 2.5;
		y = 7.5; // this.y = 7.5;
		r = 10.0; // this.r = 10.0;
	}

	Circle(double radius)

	{
		r = radius;
		x = 3.5;
		y = 7.6;
	}

	/*
        Circle(double r)
        {
                this(5.4,6.7,0.0);
                this.r = r;
        }
	 */


	Circle(double l, double m, double o)
	{
		x = l; // this.x = 2.5;
		y = m; // this.y = 7.5;
		r = o; // radius
	}


	Circle(int radius)

	{
		this(5.4,6.7,0.0);
		r = radius;
	}

	Circle(Circle big)

	{
		this(big.x, big.y, big.r);
	}

	public double perimeter() { System.out.println("In perimeter " + r);
	return (2*3.14159*r); }
	public double area() { System.out.print("In area " + x + " ") ;
	return (3.14159*r*r); }

	public static void main(String [] args)

	{
		double area = 3.4;
		float abc = 4.5f;
		Circle object0 = new Circle();
		Circle object1 = new Circle(23.4,4.5,6.7);
		Circle object2 = new Circle(object1);
		Circle object3 = object2; // reference only
		/*
Circle object5;
Circle object6 = new Circle(object5); XXX compiler error ???
		 */
		/*
Circle object3;
object3 = object2;
		 */
		Circle object4 = new Circle(25);
		Circle object5 = new Circle(100.0);

		System.out.println("Object0: " + "area = " + object0.area() +
				" perimeter = " + object0.perimeter());
		System.out.println("object1: " + "r =" + object1.r + " x = "
				+ object1.x + " y = " + object1.y);
		System.out.println("object2.r = " + object2.r + " object3.r = "
				+ object3.r);
		System.out.println("object4.area() = " + object4.area() +
				" object5.perimeter() = " + object5.perimeter());
	}

}

/*
In area 2.5 In perimeter 10.0
Object0: area = 314.159 perimeter = 62.8318
object1: r =6.7 x = 23.4 y = 4.5
object2.r = 6.7 object3.r = 6.7
In area 5.4 In perimeter 100.0
object4.area() = 1963.4937499999999 object5.perimeter() = 628.318
 */
