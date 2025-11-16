package models;

public class Cart {
	private static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc[] itemsInCart = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBER_ORDERED){
			System.out.print("The cart is almost full\n");
			return;
		}
		itemsInCart[++qtyOrdered] = disc;
		System.out.print("The disc has been added sucessfully\n");
	}
	public void addDVD(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length > MAX_NUMBER_ORDERED){
			System.out.print("The cart is almost full\n");
			return;
		}
		for(int i = 0;i < dvdList.length;i++) {
			itemsInCart[++qtyOrdered] = dvdList[i];
		}
		System.out.print("The discs have been added sucessfully\n");
	}
	public void addDVD(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 > MAX_NUMBER_ORDERED){
			System.out.print("The cart is almost full\n");
			return;
		}
		itemsInCart[++qtyOrdered] = dvd1;
		itemsInCart[++qtyOrdered] = dvd2;
		System.out.print("The discs have been added sucessfully\n");
	}
	public void removeDVD(DigitalVideoDisc disc) {
		if(qtyOrdered == 0) {
			System.out.print("The cart is empty\n");
			return;
		}
		for(int i = 1;i <= qtyOrdered;i++) {
			if(disc == itemsInCart[i]) {
				DigitalVideoDisc c = itemsInCart[i];
				itemsInCart[i] = itemsInCart[qtyOrdered];
				itemsInCart[qtyOrdered] = c;
				qtyOrdered--;
				System.out.print("The disc has been removed sucessfully\n");
				return;
			}
		}
		System.out.print("The disc does not exist\n");
	}
	public double calculateTotalCost() { 
        double totalCost = 0.0; 
        for (int i = 1; i <= qtyOrdered; i++) {
            totalCost += itemsInCart[i].getCost();
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
		for (int i = 1; i <= qtyOrdered; i++) {
			System.out.println("DVD[" + itemsInCart[i].getId() + "]" +". [Title]: " + itemsInCart[i].getTitle() + 
							   ", [Cost]: " + itemsInCart[i].getCost() + " [Length]: " + itemsInCart[i].getLength() + " [Category]: " + itemsInCart[i].getCategory() + " [Director]: " + itemsInCart[i].getDirector());
		}
		System.out.println("Total cost: " + calculateTotalCost());
		System.out.println("***************************************************");
	}
}
