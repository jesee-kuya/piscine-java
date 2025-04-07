public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            String trimmed = part.strip();
            long dotCount = trimmed.chars().filter(c -> c == '.').count();

            if (dotCount >= 2) {
                int firstDot = trimmed.indexOf('.');
                int lastDot = trimmed.lastIndexOf('.');
                String inner = trimmed.substring(firstDot + 1, lastDot).strip();
                if (!inner.isEmpty()) {
                    result.append(inner).append(" ");
                }
            } else if (dotCount == 1) {
                // Remove the single dot and include the rest
                String cleaned = trimmed.replace(".", "").strip();
                if (!cleaned.isEmpty()) {
                    result.append(cleaned).append(" ");
                }
            } else if (!trimmed.isEmpty()) {
                result.append(trimmed).append(" ");
            }
        }

        return result.toString().strip();
    }
}
