/*
	@version 1.0 07/18/2014
	@author William Yang

	File name: InventoryApplication.java
	Program purpose: This program is to implement a simple GUI inventory system for an electronics store.

	Revision history:
	Date		Programmer		Change ID	Description
	07/18/2014	William Yang	1			Initial creation
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class InventoryApplication {

	public static void main(String[] args) {

		InventorySystem inventory;
		inventory = new InventorySystem();
		inventory.init();
		inventory.run();

	}

}

class InventorySystem {

	private static int merchandiseCount = 4096;
	private String storeName = "Foothill";
	private eMerchandiseItem [] items;
	private int itemCount;

	public InventorySystem() {

		items = new eMerchandiseItem [merchandiseCount];
	}

	public InventorySystem(String storeName) {

		this.storeName = storeName;
		items = new eMerchandiseItem [merchandiseCount];
	}

	public static int getMerchandiseCount() {

		return merchandiseCount;
	}

	public void setCount(int itemCount) {

		this.itemCount = itemCount;
	}

	public int getCount() {

		return itemCount;
	}

	public void setStoreName(String storeName) {

		this.storeName = storeName;
	}

	public String getStoreName() {

		return storeName;
	}

	public void setEMercahndiseItem(eMerchandiseItem[] items){

		this.items = items;
	}

	public eMerchandiseItem[] getEMerchandiseItem() {

		return items;
	}

	public eMerchandiseItem findItem(String target) {

		sort();

		int first = 0;
		int last = items.length -1 ;
		int mid ;
		//searches based on merchandiseID
		while(items[last] == null) {

			--last;
		}

		while (first <= last) {

			mid = (first+last)/2;

			if (target.compareTo((items[mid].getMerchandiseID())) == 0) {

				return items[mid];   // found a match, return the index where the match is found

			} else {

			if ((target.compareTo(items[mid].getMerchandiseID())) > 0) {

				first = mid+1;

			} else {
				last = mid-1;
			}
			}
		}

		return null;  // not found

	}

	public void sort() {

		int walker ;
		eMerchandiseItem tmp;

		for (int i = 0; i < items.length - 1; i++){


			for(walker = items.length - 1; walker > i; walker--) {

				//if null reference, decrease number of walker
				if(items[walker] == null) {

				} else {

				if((items[walker].getMerchandiseID().compareTo(items[walker - 1].getMerchandiseID())) < 0) {

					tmp = items[walker];
					items[walker] = items[walker - 1];
					items[walker - 1] = tmp;

				}

				}
			}
		}

	}

	public void init ( ) {

		BufferedReader  br = null;
		try {
			br = new BufferedReader (new FileReader ("data1.txt"));
			String line;
			String delim = "[:]+" ;
			Order [] orders;
			int count = 0, quantity, orderCount;
			String		ID, description;
			double		price;

			while ( (line = br.readLine ()) != null) {
				// first reading the first line to get eMerchandiseItem's info
				String [] fields = line.split (delim);

				ID = fields[0];
				description = fields[1];
				price = Double.parseDouble(fields[2]);
				quantity = Integer.parseInt (fields[3]);
				orderCount = Integer.parseInt (fields[4]);

				items[count] = new eMerchandiseItem(ID, description, price, quantity,orderCount);
				// now reading the orders based on orderCount
				String	customer, city, orderNumber;
				int 	orderQuantity;

				if (orderCount > 0) {
					orders = new Order [orderCount] ;
					for (int i=0; i< orderCount; i++) {
						line = br.readLine();
						fields = line.split("[;]+") ;

						customer      = fields[0];
						city          = fields[1];
						orderNumber   = fields[2];
						orderQuantity = Integer.parseInt(fields[3]);

						orders[i] = new Order (customer,city,orderNumber,orderQuantity);
					}  // end of for loop
					// set the orders for the merchandise item
					items[count].setOrders (orders);
				}
				count++;  // increment the index count for the eMerchandiseItem array
			} // end of while loop

			setCount (count);  // invoke setCount to set the number of eMerchandiseItem objects being loaded to the array
			br.close ( );

		} catch (IOException  e) {  e.printStackTrace();  }
	}

	public void run() {

		boolean stillRunning = true;
		int choice = 0;

		while(stillRunning) {

			String [] choices = {"List all merchandise", "Add merchandise", "Query merchandise", "Process order", "Quit"};
			String buffer = (String)JOptionPane.showInputDialog(null, "Please select an option:", "Foothill Inventory System", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

			//assigns different numbers to each choice
			if(buffer == "List all merchandise") {

				choice = 1;

			} else {

			if(buffer == "Add merchandise") {

				choice = 2;

			} else {

			if(buffer == "Query merchandise") {

				choice = 3;

			} else {

			if(buffer == "Process order") {

				choice = 4;

			} else {

			if(buffer == "Quit") {

				choice = 5;

			} else {

			if(buffer == null) {

				choice = 6;

			}
			}

			}
			}
			}

			}

			//sets different cases to their corresponding functions
			switch(choice) {

			case 1: sort();
					listItems();
					break;
			case 2: addItem();
					break;
			case 3: queryItem();
					break;
			case 4: processOrder();
					break;
			case 5:
			case 6:	stillRunning = handleQuit(stillRunning);
					break;
			default:

			}
		}
	}

	public boolean handleQuit(boolean stillRunning) {

		//exits program
		stillRunning = false;

		System.exit(0);

		return stillRunning;

	}

	public void listItems() {

		//sorts items before listing
		sort();

		//list each item in array that is not a null reference
		for(int i = 0; items[i] != null; ++i) {

			JOptionPane.showMessageDialog(null, (items[i].toString()), "List Items", JOptionPane.INFORMATION_MESSAGE);
		}



	}

	public void addItem() {

		String buffer = "";

		eMerchandiseItem input;
		String newDescription = "";
		double newPrice = 0.0;
		int newQuantity = 0;
		int newTotalOrders = 0;

		buffer = JOptionPane.showInputDialog(null, "Please enter a Merchandise ID:", "Add Item", JOptionPane.INFORMATION_MESSAGE);

		input = findItem(buffer);

		//if input does not return a null reference, asks for the quantity to add for the existing item
		if(input != null) {

			String quantityBuffer = JOptionPane.showInputDialog(null, "Please enter the quantity to add for item " + buffer + ":", "Add Item", JOptionPane.INFORMATION_MESSAGE);

			newQuantity = Integer.parseInt(quantityBuffer);

			input.setQuantity((input.getQuantity()) + newQuantity);

		} else {

		//checks if the inventory is full or not
		if(items[merchandiseCount - 1] != null) {

			JOptionPane.showMessageDialog(null, "Inventory full!!!", "Add Item", JOptionPane.ERROR_MESSAGE);

		//creates a new item if the inventory has space
		} else {

			newDescription = JOptionPane.showInputDialog(null, "Please enter the description for the new item " + buffer + ":", "Add Item", JOptionPane.INFORMATION_MESSAGE);
			newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the price for the new item " + buffer + " ($):", "Add Item", JOptionPane.INFORMATION_MESSAGE));
			newQuantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the quantity for the new item " + buffer + ":", "Add Item", JOptionPane.INFORMATION_MESSAGE));
			newTotalOrders = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the total orders for the new item " + buffer + ":", "Add Item", JOptionPane.INFORMATION_MESSAGE));

			eMerchandiseItem newItem = new eMerchandiseItem(buffer, newDescription, newPrice, newQuantity, newTotalOrders);

			items[getCount()] = newItem;
			setCount(getCount() + 1);

			sort();

		}
		}


}

	public void queryItem() {

		String buffer;
		eMerchandiseItem input;

		buffer = JOptionPane.showInputDialog(null, "Please enter a Merchandise ID:", "Query Item", JOptionPane.INFORMATION_MESSAGE);

		input = findItem(buffer);


		if(input != null) {

			JOptionPane.showMessageDialog(null, input.toString(), "Query Item", JOptionPane.INFORMATION_MESSAGE);

		//if input is a null reference, returns an error message
		} else {

			JOptionPane.showMessageDialog(null, "Item does not exist!", "Query Item", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void processOrder() {

		eMerchandiseItem input;

		String buffer = JOptionPane.showInputDialog(null, "Please enter a Merchandise ID:", "Process Order", JOptionPane.INFORMATION_MESSAGE);

		input = findItem(buffer);

		//invokes handleOrder when input is not null
		if(input != null) {

			input.handleOrder();

		} else {

			JOptionPane.showMessageDialog(null, "Item does not exist!", "Process Order", JOptionPane.ERROR_MESSAGE);

		}
		}



}

class eMerchandiseItem {

	private String merchandiseID;
	private String description;
	private double price;
	private int quantity;
	private int totalOrders;
	private Order [] orders;

	public eMerchandiseItem() {

	}

	public eMerchandiseItem(String merchandiseID, String description, double price, int quantity, int totalOrders) {

		this.merchandiseID = merchandiseID;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.totalOrders = totalOrders;
	}

	private Order findOrder(String searchNumber){

		//searches based on order number
		if(orders != null) { //if there are no orders for an item, returns null

			for (int i = 0; i < orders.length; ++i) {

				if (orders[i].getOrderNumber().compareTo(searchNumber) == 0) {

					return orders[i];
				}
			}
		}

	    return null;  // not found
	}

	public void handleOrder() {

		String buffer = JOptionPane.showInputDialog(null, "Please enter an order number:", "Handle Order", JOptionPane.INFORMATION_MESSAGE);

		Order handleOrder = findOrder(buffer);

		//processes order if the findOrder does not return null
		if(handleOrder != null) {

			if(getQuantity() > handleOrder.getOrderQuantity()) {

				setQuantity(((getQuantity()) - (handleOrder.getOrderQuantity())));
				handleOrder.setOrderNumber("-1");

			} else {

				JOptionPane.showMessageDialog(null, "Not enough quantity to process order!", "Handle Order", JOptionPane.ERROR_MESSAGE);
			}

		} else {

			JOptionPane.showMessageDialog(null, "Order does not exist!", "Handle Order", JOptionPane.ERROR_MESSAGE);
		}




	}

	public void setOrders(Order [] orders) {

		this.orders = orders;
	}

	public Order [] getOrders() {

		return orders;
	}

	public void setMerchandiseID(String merchandiseID) {

		this.merchandiseID = merchandiseID;
	}

	public String getMerchandiseID() {

		return merchandiseID;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getDescription() {

		return description;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public double getPrice() {

		return price;
	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public int getQuantity() {

		return quantity;
	}

	public void setTotalOrders(int totalOrders) {

		this.totalOrders = totalOrders;
	}

	public int getTotalOrders() {

		return totalOrders;
	}

	public String toString() {


		//outputs each variable an eMerchandiseItem
		String output = "";

		output += String.format("%-1s", "Merchandise ID: ");
		output += String.format("%1s%n", merchandiseID);
		output += String.format("%-1s", "Description: ");
		output += String.format("%1s%n", description);
		output += String.format("%-1s", "Price: ");
		output += String.format("$%1.2f%n", price);
		output += String.format("%-1s", "Quantity: ");
		output += String.format("%1s%n", quantity);
		output += String.format("%-1s", "Total Orders: ");
		output += String.format("%1s%n", totalOrders);

		return output;
	}

}

class Order {

	private String orderNumber;
	private int orderQuantity;
	private String customerName;
	private String deliveryCity;

	public Order() {

	}

	public Order(String customerName, String deliveryCity, String orderNumber, int orderQuantity) {

		this.orderNumber = orderNumber;
		this.orderQuantity = orderQuantity;
		this.customerName = customerName;
		this.deliveryCity = deliveryCity;
	}

	public void setOrderNumber(String orderNumber) {

		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {

		return orderNumber;
	}

	public void setOrderQuantity(int orderQuantity) {

		this.orderQuantity = orderQuantity;
	}

	public int getOrderQuantity() {

		return orderQuantity;
	}

	public void setCustomerName(String customerName) {

		this.customerName = customerName;
	}

	public String getCustomername() {

		return customerName;
	}

	public void setDeliveryCity(String deliveryCity) {

		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryCity() {

		return deliveryCity;
	}

	public String toString() {

		String output = "";

		output += String.format("%-18s", "Order Number:");
		output += String.format("%15s%n", orderNumber);
		output += String.format("%-18s", "Order Quantity:");
		output += String.format("%15s%n", orderQuantity);
		output += String.format("%-18s", "Customer Name:");
		output += String.format("$%15s%n", customerName);
		output += String.format("%-18s", "Delivery City:");
		output += String.format("%15s%n", deliveryCity);

		return output;
	}
}
