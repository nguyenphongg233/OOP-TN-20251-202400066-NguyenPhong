// Trong com.hust.kstn.models.CompactDisc.java

package models;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc {
    private int id;
    private String title;
    private String category;
    private double cost;
    private String director; 

    private String artist; 
    private List<Track> tracks = new ArrayList<>();

    private static int nbCDs = 0;

    // Constructor
    public CompactDisc(String title, String category, double cost, String director, String artist) {
        nbCDs++;
        this.id = nbCDs;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
        this.artist = artist;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Error: Track '" + track.getTitle() + "' already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            System.out.println("Error: Track '" + track.getTitle() + "' not found in the CD.");
        }
    }

    public int totalLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    @Override
    public String toString() {
        // 
        return "CD [" + this.id + "]["
                + this.title + "] ["
                + this.cost + "]["
                + this.director + "]["
                + this.artist + "]"
                + "Total Length: " + this.totalLength() + "s\n"
                + "Tracks: " + this.tracks;
    }
}