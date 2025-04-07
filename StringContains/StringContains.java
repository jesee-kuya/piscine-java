public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        return s == null ? false : subString == null ? false : s.contains(subString);
    }
}