package ch2.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_SEPARATOR = ",|:";

    public int[] parse(String input) {
        if (input == null || input.isBlank()) {
            return new int[0];
        }

        String customSeparator = getCustomSeparator(input);

        if (!customSeparator.equals("")) {
            input = input.substring(4);
        }

        String regex = customSeparator.equals("") ? DEFAULT_SEPARATOR : (DEFAULT_SEPARATOR + "|" + customSeparator);

        return Arrays.stream(input.split(regex))
                .mapToInt(InputParser::transformToPositiveInteger)
                .toArray();
    }

    private static int transformToPositiveInteger(String n) {
        int number = Integer.parseInt(n);
        if (number < 0) throw new RuntimeException();
        return number;
    }

    private static String getCustomSeparator(String input) {
        String pattern = "//(.)\n(.*)";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);

        if (matcher.matches()) {
            return  matcher.group(1);
        }

        return "";
    }

}
