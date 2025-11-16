
package models;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, double cost, String director, String artist) {
        super(title, category, cost, director, 0);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

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
        for (Track track : tracks) total += track.getLength();
        return total;
    }

    @Override
    public String toString() {
        return "CD [" + getId() + "] [" + getTitle() + "] [" + getCost() + "] [" + getDirector() + "] [" + artist + "] "
                + "Total Length: " + totalLength() + "s\n" + "Tracks: " + tracks;
    }
}