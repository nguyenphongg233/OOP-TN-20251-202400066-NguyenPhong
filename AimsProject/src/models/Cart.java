package models;

public class Cart {
	private static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc[] itemsInCart = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0; // number of items currently in cart, 0-based count
	
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBER_ORDERED){
			System.out.print("The cart is almost full\n");
			return;
		}
		itemsInCart[qtyOrdered++] = disc;
		System.out.print("The disc has been added sucessfully\n");
	}
	public void addDVD(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length > MAX_NUMBER_ORDERED){
			System.out.print("The cart is almost full\n");
			return;
		}
		for(int i = 0;i < dvdList.length;i++) {
			itemsInCart[qtyOrdered++] = dvdList[i];
		}
		System.out.print("The discs have been added sucessfully\n");
	}
	public void addDVD(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 > MAX_NUMBER_ORDERED){
			System.out.print("The cart is almost full\n");
			return;
		}
		itemsInCart[qtyOrdered++] = dvd1;
		itemsInCart[qtyOrdered++] = dvd2;
		System.out.print("The discs have been added sucessfully\n");
	}
	public void removeDVD(DigitalVideoDisc disc) {
		if(qtyOrdered == 0) {
			System.out.print("The cart is empty\n");
			return;
		}
		for(int i = 0; i < qtyOrdered; i++) {
			if(disc == itemsInCart[i]) {
				// replace found item with last item and clear last slot
				itemsInCart[i] = itemsInCart[qtyOrdered - 1];
				itemsInCart[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.print("The disc has been removed sucessfully\n");
				return;
			}
		}
		System.out.print("The disc does not exist\n");
	}
	public double calculateTotalCost() { 
        double totalCost = 0.0; 
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsInCart[i] != null) {
				totalCost += itemsInCart[i].getCost();
			}
		}
        return totalCost;
    }
	public void print() { 
		if(qtyOrdered == 0) {
			System.out.print("The cart is empty\n");
			return;
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items (" + qtyOrdered + "):");
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc dvd = itemsInCart[i];
			System.out.println("DVD[" + dvd.getId() + "]" +". [Title]: " + dvd.getTitle() + 
							   ", [Cost]: " + dvd.getCost() + " [Length]: " + dvd.getLength() + " [Category]: " + dvd.getCategory() + " [Director]: " + dvd.getDirector());
		}
		System.out.println("Total cost: " + calculateTotalCost());
		System.out.println("***************************************************");
	}
}
