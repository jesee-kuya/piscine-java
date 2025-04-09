import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            return; // If we don't have both input and output files, return without doing anything.
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        // Read the content from the input file
        String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));

        // Capitalize each word in the content
        String capitalizedContent = capitalizeWords(content);

        // Write the capitalized content to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(capitalizedContent);
        }
    }

    private static String capitalizeWords(String input) {
        // Split input into words, capitalize each word, and join them back together
        String[] words = input.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1))
                           .append(" ");
            }
        }

        // Remove the trailing space at the end
        return capitalized.toString().trim();
    }
}
