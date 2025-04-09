import java.io.*;
import java.util.Scanner;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        } catch (IOException e) {
        }
    }
}
