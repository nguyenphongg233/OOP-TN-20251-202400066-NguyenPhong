package models;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(String title, String category, double cost, String director, int length) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() { return director; }
    public int getLength() { return length; }

    @Override
    public String toString() {
        return "Disc [" + getId() + "] [" + getTitle() + "] [" + getCost() + "] [" + getCategory() + "] [" + director + "] [" + length + "]";
    }
}
