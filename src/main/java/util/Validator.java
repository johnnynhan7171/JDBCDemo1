package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String VALID_INPUT_NUMBER = "[0-9]+";
    private static final String VALID_INPUT_MENU = "[1-4]";

    public static boolean validInput(String input){
        Pattern pattern = Pattern.compile(VALID_INPUT_MENU);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isNumber(String input){
        Pattern pattern = Pattern.compile(VALID_INPUT_NUMBER);
        return pattern.matcher(input).matches();
    }
}
