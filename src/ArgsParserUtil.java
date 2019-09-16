

public class ArgsParserUtil {

    public static int[] convertArgs(String input) {
        if (input.matches("^\\[.*\\]$")) {
            input = input.substring(1, input.length() - 1);
            String[] splitted = input.split("[\\s]?,[\\s]?");
            int[] result =  new int[splitted.length];
            for (int i = 0; i < splitted.length; i++) {
                result[i] = Integer.parseInt(splitted[i]);
            }
            return result;
        }
        return new int[0];
    }
}
