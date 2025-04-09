import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return; // If no file argument, return without doing anything.
        }

        String outputFilePath = args[0];
        
        try (OutputStream outputStream = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[4096]; // 4KB buffer for efficient reading
            int bytesRead;
            while ((bytesRead = System.in.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
