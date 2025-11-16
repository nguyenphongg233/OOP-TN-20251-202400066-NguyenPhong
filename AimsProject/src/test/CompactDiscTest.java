
package test;

import models.CompactDisc;
import models.Track;

public class CompactDiscTest {

    public static void main(String[] args) {
        CompactDisc cd = new CompactDisc("Greatest Hits", "Pop", 15.99, "Director Name", "Artist Name");

        Track track1 = new Track("Track 1", 180); 
        Track track2 = new Track("Track 2", 210); 
        Track track3 = new Track("Track 3", 150); 

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        System.out.println("---After adding tracks---");
        System.out.println(cd);
        System.out.println("Total length (check): " + cd.totalLength() + "s ");

        System.out.println("--- Try adding track 1 again ---");
        cd.addTrack(track1); 

        System.out.println("--- Try removing track 2 ---");
        cd.removeTrack(track2);
        System.out.println(cd);

        System.out.println("--- Try removing track 2 again ---");
        cd.removeTrack(track2); 
    }
}