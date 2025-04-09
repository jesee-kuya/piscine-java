import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        Arrays.sort(args);
        if (args.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0 ; i < args.length; i++) {
            if (i != args.length - 1) {
             System.out.print(args[i]);
             System.out.print(" ");
            }else {
                System.out.println(args[i]);
            }
        }
    }
}