public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            String trimmed = part.strip();
            int firstDot = trimmed.indexOf('.');
            int lastDot = trimmed.lastIndexOf('.');

            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String inner = trimmed.substring(firstDot + 1, lastDot).strip();
                if (!inner.isEmpty()) {
                    result.append(inner).append(" ");
                }
            } else if (!trimmed.contains(".")) {
                // If there are no dots at all, consider it a clean sentence
                result.append(trimmed).append(" ");
            }
        }

        return result.toString().strip();
    }
}
