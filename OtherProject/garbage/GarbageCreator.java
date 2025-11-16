package garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        // Thay "test.exe" bằng đường dẫn đến một file lớn trên máy bạn
        String filename = "Instance.txt"; 

        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            java.nio.file.Path p = Paths.get(filename);
            if (!Files.exists(p)) {
                System.out.println("File not found: " + filename);
                return;
            }

            inputBytes = Files.readAllBytes(p);
            startTime = System.currentTimeMillis();

            String outputString = ""; // Chuỗi rỗng ban đầu
            for (byte b : inputBytes) {
                outputString += (char) b; // Nối chuỗi bằng +, tạo rác liên tục
            }

            endTime = System.currentTimeMillis();
            System.out.println("Time (with +): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("I/O error reading file '" + filename + "': " + e.getMessage());
        }
    }
}