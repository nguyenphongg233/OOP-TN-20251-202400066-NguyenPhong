package models;

public class Track {
    private String title;
    private int length; 

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public String toString() {
        return "Track: " + this.title + " - Length: " + this.length + "s";
    }
}