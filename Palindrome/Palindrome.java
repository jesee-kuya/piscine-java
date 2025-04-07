public class Palindrome {
    public static boolean isPalindrome(String s) {
        int count = s.length() - 1;

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) != s.charAt(count)) {
                return false;
            }
            count--;
        }
        return true;
    }
}