
//Runtime: 978 ms, faster than 5.00% of Java online submissions for Longest Palindromic Substring.
//        Memory Usage: 36.9 MB, less than 98.79% of Java online submissions for Longest Palindromic Substring.

public class Solution_LongestPalindromic_5 {

    public String longestPalindrome(String str) {
        if (str.isEmpty()) return "";
        if (str.length() == 1) return str;

        String maxPalindrom = "";

        for (int i = 0; i <= str.length() - 2; i++) {
            String mp1 = findMaxPalindromNear(2, i, str);
            if (mp1.length() > maxPalindrom.length()) {
                maxPalindrom = mp1;
            }

            if (i < str.length() - 2) {
                String mp2 = findMaxPalindromNear(3, i, str);
                if (mp2.length() > maxPalindrom.length()) {
                    maxPalindrom = mp2;
                }
            }
        }

        if (maxPalindrom.isEmpty()) {
            maxPalindrom = str.substring(0, 1);
        }
        return maxPalindrom;
    }

    private String findMaxPalindromNear(int size, int start, String str) {
        String maxPalindrom = "";

        while (isPalindrom(str, start, start + size - 1)) {
            maxPalindrom = str.substring(start, start + size);
            if (start - 1 >= 0 && start + size < str.length()) {
                size += 2;
                start--;
            } else {
                break;
            }
        }

        return maxPalindrom;
    }

    private boolean isPalindrom(String str, int start, int end) {
        int size = end - start;
        int mid = size > 1 ? size / 2 : 1;
        for (int i = 0; i < mid; i++) {
            char left = str.charAt(start + i);
            char right = str.charAt(end - i);
            if (left != right) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String str = "babad";
//        String str = "acdabasaba";
        String str = "cbbd";
//        String str = "bb";
        String res = new Solution_LongestPalindromic_5().longestPalindrome(str);
        System.out.println(res);
    }

}

