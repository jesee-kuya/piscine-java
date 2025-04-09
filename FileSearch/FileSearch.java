import java.io.File;

public class FileSearch {

    // Method to search for the file starting from the 'documents' folder
    public static String searchFile(String fileName) {
        // Define the root folder as 'documents' at the root of the current directory
        File rootFolder = new File("documents");
        
        // Start searching the folder recursively
        return searchInFolder(rootFolder, fileName);
    }

    // Helper method to search the file in the folder recursively
    private static String searchInFolder(File folder, String fileName) {
        // Check if the folder exists and is a directory
        if (folder.exists() && folder.isDirectory()) {
            // List all files and subfolders inside the folder
            File[] files = folder.listFiles();

            // If the folder is empty, return null
            if (files != null) {
                // Iterate through all files and subfolders
                for (File file : files) {
                    // If the file matches the name, return its path
                    if (file.isFile() && file.getName().equals(fileName)) {
                        return file.getAbsolutePath();
                    }

                    // If it's a folder, recurse into the subfolder
                    if (file.isDirectory()) {
                        String result = searchInFolder(file, fileName);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
        }
        // If the file is not found, return null
        return null;
    }

    public static void main(String[] args) {
        // Example usage of the searchFile function
        String fileName = "testfile.txt";
        String result = searchFile(fileName);
        
        if (result != null) {
            System.out.println("File found at: " + result);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}
