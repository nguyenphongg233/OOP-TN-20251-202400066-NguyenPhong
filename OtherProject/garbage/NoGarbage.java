package garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "instance.txt"; 
        
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b); 
        }
        
        String outputString = outputStringBuilder.toString(); 
        
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian (với StringBuilder): " + (endTime - startTime) + " ms");
    }
}