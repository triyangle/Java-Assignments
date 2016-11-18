
public class FanDemo {

	public static void main(String[] args) {

		//creates Fan objects
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();

		//sets the fields for each fan
		fan1.setSpeed(Fan.FAST);
		fan1.setRadius(10.0);
		fan1.setColor("yellow");
		fan1.setOn(true);

		fan2.setSpeed(Fan.MEDIUM);
		fan2.setRadius(5.0);
		fan2.setColor("blue");
		fan2.setOn(false);

		//prints out the fields of each fan
		System.out.println("Fan1: speed = " + fan1.getSpeed() + ", radius = " + fan1.getRadius() +
				", color = " + fan1.getColor() + ", on = " + fan1.isOn());

		System.out.println("Fan2: speed = " + fan2.getSpeed() + ", radius = " + fan2.getRadius() +
				", color = " + fan2.getColor() + ", on = " + fan2.isOn());

	}

}

class Fan {

	static final int SLOW = 1;
	static final int MEDIUM = 2;
	static final int FAST = 3;

	private int speed;
	private boolean on;
	private double radius;
	private String color;

	//creates a default fan
	public Fan() {

		speed = SLOW;
		on = false;
		radius = 5.0;
		color = "blue";

	}

	public int getSpeed() {

		return speed;

	}

	public void setSpeed(int newSpeed) {

		speed = newSpeed;

	}

	public boolean isOn() {

		return on;

	}

	public void setOn(boolean newState) {

		on = newState;

	}

	public double getRadius() {

		return radius;

	}

	public void setRadius(double newRadius) {

		radius = newRadius;

	}

	public String getColor() {

		return color;

	}

	public void setColor(String newColor) {

		color = newColor;

	}

}

/* OUTPUT:
 * Fan1: speed = 3, radius = 10.0, color = yellow, on = true
 * Fan2: speed = 2, radius = 5.0, color = blue, on = false
 *
 */
