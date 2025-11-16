package models;

public class DigitalVideoDisc extends Disc {

	public DigitalVideoDisc(String title) {
		super(title, "", 0.0, "", 0);
	}

	public DigitalVideoDisc(String category, String title, double cost) {
		super(title, category, cost, "", 0);
	}

	public DigitalVideoDisc(String director, String category, String title, double cost) {
		super(title, category, cost, director, 0);
	}

	public DigitalVideoDisc(String director, String category, String title, int length, double cost) {
		super(title, category, cost, director, length);
	}

	@Override
	public String toString() {
		return "DVD[" + getId() + "]" + ". [Title]: " + getTitle() + ", [Cost]: " + getCost()
				+ " [Length]: " + getLength() + " [Category]: " + getCategory() + " [Director]: " + getDirector();
	}
}
