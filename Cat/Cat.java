import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return; // No file specified, do nothing
        }
        
        String filename = args[0];
        File file = new File(filename);
        
        if (!file.exists()) {
            return; // File doesn't exist, do nothing
        }
        
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            // File might have been deleted between exists() check and opening
            return;
        }
    }
}