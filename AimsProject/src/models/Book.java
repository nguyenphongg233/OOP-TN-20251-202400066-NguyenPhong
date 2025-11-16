
package models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private double cost;
    
    private int numOfTokens; 
    private List<BookAuthor> authors = new ArrayList<>();

    private static int nbBooks = 0;

    public Book(String title, String category, double cost, int numOfTokens, List<BookAuthor> authors) {
        // Tự gán ID
        nbBooks++;
        this.id = nbBooks;
        
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.numOfTokens = numOfTokens;
        this.authors = authors;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getCost() { return cost; }
    public int getNumOfTokens() { return numOfTokens; }
    public List<BookAuthor> getAuthors() { return authors; }

    @Override
    public String toString() {
        return "Book [" + this.id + "]["
                + this.title + "] ["
                + this.cost + "]["
                + this.category + "]["
                + this.numOfTokens + "]"
                + "\nAuthors: " + this.authors;
    }

    // Bạn có thể cần thêm các phương thức addAuthor/removeAuthor (tùy chọn)
}