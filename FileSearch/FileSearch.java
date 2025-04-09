import java.io.File;

public class FileSearch {

    // Method to search for the file starting from the 'documents' folder
    public static String searchFile(String fileName) {
        // Define the root folder as 'documents' at the root of the current directory
        File rootFolder = new File("documents");

        // Start searching the folder recursively and get the result
        String result = searchInFolder(rootFolder, fileName);

        // If the file is found, return its relative path from the 'documents' directory
        if (result != null) {
            // Make sure the returned path starts with 'documents/'
            String relativePath = result.substring(new File("documents").getAbsolutePath().length() + 1);
            return "documents/" + relativePath;  // Add 'documents/' at the start of the path
        }

        // If the file is not found, return null
        return null;
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
                    // If the file matches the name, return its absolute path
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
