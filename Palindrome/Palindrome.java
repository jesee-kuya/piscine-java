public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int count = s.length() - 1;
        s = s.toLowerCase();

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) != s.charAt(count)) {
                return false;
            }
            count--;
        }
        return true;
    }
}