import java.util.*;

public class Auto {

	private String ownerName;
	private String autoType;
	private double maxSpeed;
	private double tankCapacity;
	
	public Auto() {
		
		ownerName = "";
		autoType = "";
		
	}
	
	public Auto(String ownerName, String autoType) {
		
		this.ownerName = ownerName;
		this.autoType = autoType;
		
	}
	
	public void set() {
		
		Scanner input = new Scanner(System.in);
		
		if(ownerName == "" && autoType == "") {
			
			System.out.print("Set the owner name: ");
			ownerName = input.nextLine();

			System.out.print("Set the auto type: ");
			autoType = input.nextLine();
		
		}

		System.out.print("Set the max speed (mph): ");
		maxSpeed = input.nextDouble();
		
		System.out.print("Set the tank capacity (gallons): ");
		tankCapacity = input.nextDouble();
		
	}
	
	public void display() {
		
		System.out.println("Owner Name: " + ownerName);
		System.out.println("Auto Type: " + autoType);
		System.out.println("Max Speed (mph): " + maxSpeed);
		System.out.println("Tank Capacity (gallons): " + tankCapacity);
		
	}
	
	public static void main(String[] args) {
		
		Auto auto1 = new Auto();
		System.out.println("auto1 set() method");
		auto1.set();
		System.out.println("\nauto1 display() method");
		auto1.display();
		
		Auto auto2 = new Auto("Auto Owner 2", "Midsize Luxury");
		System.out.println("\nauto2 set() method");
		auto2.set();
		System.out.println("\nauto2 display() method");
		auto2.display();
		
		Truck truck1 = new Truck();
		System.out.println("\ntruck1 set() method");
		truck1.set();
		System.out.println("\ntruck1 display() method");
		truck1.display();
		
	}

}

class Truck extends Auto {
	
	private boolean cargo;
	private String cargoType;
	double loadCapacity;
	
	public Truck() {
		
		cargoType = "";
		
	}
	
	@Override
	public void set() {
		
		super.set();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Has cargo? (True/False): ");
		cargo = input.nextBoolean();
		
		if(cargo == true) {
		
			System.out.print("Set the cargo type: ");
			cargoType = input.next();
			
		}
		
		System.out.print("Set the load capacity (tons): ");
		loadCapacity = input.nextDouble();
		
	}
	
	@Override
	public void display() {
		
		super.display();
		System.out.println("Has Cargo?: " + cargo);
		System.out.println("Cargo Type: " + cargoType);
		System.out.println("Load Capacity (tons): " + loadCapacity);
		
	}
	
}

/* INPUT:
 * auto1 input:
 * Set the owner name: Auto Owner 1
 * Set the auto type: Midsize Sedan
 * Set the max speed (mph): 150
 * Set the tank capacity (gallons): 11.5
 * 
 * auto2 input:
 * Set the max speed (mph): 155
 * Set the tank capacity (gallons): 12
 * 
 * truck1 input:
 * Set the owner name: Truck Owner
 * Set the auto type: Box Truck
 * Set the max speed (mph): 70
 * Set the tank capacity (gallons): 40
 * Has cargo (True/False): False
 * Set the load capacity (tons): 6.2
 * 
 * alternate truck1 input:
 * Set the owner name: Alternate Truck Owner
 * Set the auto type: Pickup Truck
 * Set the max speed (mph): 120
 * Set the tank capacity (gallons): 26
 * Has cargo? (True/False): True
 * Set the cargo type: Furniture
 * Set the load capacity (tons): 1.5
 * 
 ************************************************************************************************** 
 * 
 * OUTPUT:
 * auto1 set() method
 * Set the owner name: Auto Owner 1
 * Set the auto type: Midsize Sedan
 * Set the max speed (mph): 150
 * Set the tank capacity (gallons): 11.5
 * 
 * auto1 display() method
 * Owner Name: Auto Owner 1
 * Auto Type: Midsize Sedan
 * Max Speed (mph): 150.0
 * Tank Capacity (gallons): 11.5
 * 
 * auto2 set() method
 * Set the max speed (mph): 155
 * Set the tank capacity (gallons): 12 
 * 
 * auto2 display() method
 * Owner Name: Auto Owner 2
 * Auto Type: Midsize Luxury
 * Max Speed (mph): 155.0
 * Tank Capacity (gallons): 12.0
 * 
 * truck1 set() method
 * Set the owner name: Truck Owner
 * Set the auto type: Box Truck
 * Set the max speed (mph): 70
 * Set the tank capacity (gallons): 40
 * Has cargo? (True/False): False 
 * Set the load capacity (tons): 6.2
 * 
 * truck1 display() method
 * Owner Name: Truck Owner
 * Auto Type: Box Truck
 * Max Speed (mph): 70.0
 * Tank Capacity (gallons): 40.0
 * Has Cargo?: false
 * Cargo Type: 
 * Load Capacity (tons): 6.2
 * 
 ***************************************************************************************************
 * 
 * alternate truck1 output:
 * truck1 set() method
 * Set the owner name: Alternate Truck Owner
 * Set the auto type: Pickup Truck
 * Set the max speed (mph): 120
 * Set the tank capacity (gallons): 26
 * Has cargo? (True/False): True
 * Set the cargo type: Furniture
 * Set the load capacity (tons): 1.5
 * 
 * truck1 display() method
 * Owner Name: Alternate Truck Owner
 * Auto Type: Pickup Truck
 * Max Speed (mph): 120.0
 * Tank Capacity (gallons): 26.0
 * Has Cargo?: true
 * Cargo Type: Furniture
 * Load Capacity (tons): 1.5 
 * 
 */ 