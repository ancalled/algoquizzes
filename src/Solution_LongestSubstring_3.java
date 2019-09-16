import java.util.HashMap;
import java.util.Map;


//Runtime: 7 ms, faster than 82.26% of Java online submissions for Longest Substring Without Repeating Characters.
//        Memory Usage: 37.1 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.


public class Solution_LongestSubstring_3 {

    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0) return 0;

        int maxSize = 1;
        int start = 0;

        Map<Character, Integer> freq = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (freq.containsKey(c)) {
                if (freq.size() > maxSize) {
                    maxSize = freq.size();
                }

                int idx = indexOf(str, c, start, end);
                if (idx >= 0) {
                    for (int i = start; i <= idx; i++) {
                        char toRem = str.charAt(i);
                        if (c != toRem) {
                            freq.remove(toRem);
                        }
                    }
                    start = idx + 1;
                }

            } else {
                freq.put(c, 1);
            }
        }

        if (freq.size() > maxSize) {
            maxSize = freq.size();
        }

        return maxSize;
    }

    private int indexOf(String string, char c, int start, int end) {
        for (int i = start; i < end; i++) {
            if (c == string.charAt(i)) return i;
        }

        return -1;
    }


    public static void main(String[] args) {
//        String ex = "abcabcbb";
//        String ex = "bbbbb";
//        String ex = "pwwkew";
//        String ex = " ";    // 1
//        String ex = "";    // 0
//        String ex = "au";
//        String ex = "aab";
//        String ex = "qrsvbspk";
//        String ex = "aabaab!bb";
        String ex = "bpfbhmipx";

        int i = new Solution_LongestSubstring_3().lengthOfLongestSubstring(ex);
        System.out.println(i);

    }

}
