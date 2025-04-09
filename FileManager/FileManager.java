import java.io.*;
import java.nio.file.*;

public class FileManager {

    // Method to create a file with the given name and content
    public static void createFile(String fileName, String content) throws IOException {
        // Create the file if it doesn't exist
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        
        // Write the content to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    // Method to get the content of the file
    public static String getContentFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(fileName);
        
        // Ensure the file exists before reading
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
        } else {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        
        return content.toString();
    }

    // Method to delete the file
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + fileName);
            } else {
                System.out.println("Failed to delete the file: " + fileName);
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage of the functions
            String fileName = "testfile.txt";
            String content = "Hello, this is a test file!";
            
            createFile(fileName, content);
            System.out.println("File content:\n" + getContentFile(fileName));
            deleteFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
