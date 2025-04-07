public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            String trimmed = part.strip();

            // Find first and last dot positions
            int firstDot = trimmed.indexOf('.');
            int lastDot = trimmed.lastIndexOf('.');

            // If both dots exist and are not the same, extract between them
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String betweenDots = trimmed.substring(firstDot + 1, lastDot).strip();
                if (!betweenDots.isEmpty()) {
                    result.append(betweenDots).append(" ");
                }
            } else {
                // Otherwise, ignore empty/invalid parts
                if (!trimmed.isEmpty()) {
                    result.append(trimmed).append(" ");
                }
            }
        }

        return result.toString().strip();
    }
}
