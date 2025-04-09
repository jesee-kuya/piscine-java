import java.io.*;
import java.util.Scanner;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            // Silently ignore missing files as per requirements
        }
    }
}