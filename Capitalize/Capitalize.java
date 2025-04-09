import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Please provide input and output file paths");
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String capitalizedLine = capitalizeLine(line);
                writer.write(capitalizedLine);
                writer.newLine();
            }
        }
    }

    private static String capitalizeLine(String line) {
        if (line == null || line.isEmpty()) {
            return line;
        }

        StringBuilder result = new StringBuilder();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                if (i > 0) {
                    result.append(" ");
                }
                result.append(capitalizeWord(words[i]));
            }
        }
        return result.toString();
    }

    private static String capitalizeWord(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }
}