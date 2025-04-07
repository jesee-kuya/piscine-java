import java.util.ArrayList;
import java.util.List;

public class CleanExtract {
    public static String extract(String s) {
        String[] substrings = s.split("\\|");
        List<String> resultParts = new ArrayList<>();
        
        for (String substring : substrings) {
            int firstDot = substring.indexOf('.');
            int lastDot = substring.lastIndexOf('.');
            
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String extracted = substring.substring(firstDot + 1, lastDot).trim();
                if (!extracted.isEmpty()) {
                    resultParts.add(extracted);
                }
            } else if (firstDot != -1 && lastDot != -1 && firstDot == lastDot) {
                // Handle cases where there's only one '.'
                String extracted = substring.substring(firstDot + 1).trim();
                if (!extracted.isEmpty()) {
                    resultParts.add(extracted);
                }
            }
        }
        
        return String.join(" ", resultParts);
    }
}