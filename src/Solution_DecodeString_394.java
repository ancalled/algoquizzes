import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_DecodeString_394 {

    private static Pattern PATTERN = Pattern.compile("([0-9]+)\\[([^\\[\\]]+)\\]");

    public String decodeString(String input) {
        String line = input;
        while (true) {
            Matcher m = PATTERN.matcher(line);

            if (m.find()) {
                int times = Integer.parseInt(m.group(1));
                String word = m.group(2);
                String replacement = nTimes(word, times);
                line = m.replaceFirst(replacement);
            } else {
                break;
            }
        }

        return line;

    }

    private String nTimes(String word, int times) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < times; i++) {
            b.append(word);
        }
        return b.toString();
    }

    public static void main(String[] args) {
//        String input = "3[a]2[bc]";
        String input = "3[a2[c]]";
        String result = new Solution_DecodeString_394().decodeString(input);
        System.out.println(result);
    }
}
