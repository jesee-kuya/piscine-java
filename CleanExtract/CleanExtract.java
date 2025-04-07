public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            String trimmed = part.strip();
            int firstDot = trimmed.indexOf('.');
            int lastDot = trimmed.lastIndexOf('.');

            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String extracted = trimmed.substring(firstDot + 1, lastDot).strip();
                if (!extracted.isEmpty()) {
                    result.append(extracted).append(" ");
                }
            }
        }

        return result.toString().strip();
    }
}
