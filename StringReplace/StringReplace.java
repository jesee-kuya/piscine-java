public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        return s == null ? null : target == null ? s : replacement == null ? s : s.replace(target, replacement);
    }

    public static String replace(String s, char target, char replacement) {
        return s == null ? null : target == '\0' ? s : replacement == '\0' ? s : s.replace(target, replacement);
    }
}