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
        boolean capitalizeNext = true;

        for (char ch : line.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                result.append(ch);
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(ch));
                    capitalizeNext = false;
                } else {
                    result.append(Character.toLowerCase(ch));
                }
            }
        }
        return result.toString();
    }
}