/*
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 

	}
	
	public static void sort(eMerchandiseItem [] sortItems) {
		
		int smallest, walker ;
		eMerchandiseItem tmp = new eMerchandiseItem();

		for(int first = 0; first < sortItems.length - 1; first++) {
			
			smallest = first;
			
			for(walker = first + 1; walker < sortItems.length - 1; walker++) {
				
				if((sortItems[walker].getMerchandiseID()).compareTo(sortItems[smallest].getMerchandiseID()) < 0) {
					
					smallest = walker;
				}
				
				tmp = sortItems[first];
				sortItems[first] = sortItems[smallest];
				sortItems[smallest] = tmp;
			}

		}
		
		System.out.print(sortItems[0].getMerchandiseID());
		
	}
	
	

}

class eMerchandiseItem {
	
	private String merchandiseID;
	private String description;
	private double price;
	private int quantity;
	private int totalOrders;
	//private Order [] orders;
	
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
	
	}
	
	//public void setOrders(Order [] orders) {
		
	//	this.orders = orders;
	//}
	
	//public Order [] getOrders() {
		
	//	return orders;
	//}
	
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
		
		String output = "";
		output += merchandiseID;
		
		return output;
	}
	
}*/