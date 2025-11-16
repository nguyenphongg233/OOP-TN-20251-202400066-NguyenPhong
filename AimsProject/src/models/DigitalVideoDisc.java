package models;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private double cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public double getCost() {
		return cost;
	}
	
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	public DigitalVideoDisc(String category,String title,double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String director,String category,String title,double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.director = director;
		this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String director,String category,String title,int length,double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.director = director;
		this.length = length;
		this.id = ++nbDigitalVideoDiscs;
	}
}
