package org.example.util;

public class EnglishAlphabetUtil {

    public static final int UPPER_CASE_MIN = 'A';
    public static final int UPPER_CASE_MAX = 'Z';
    public static final int LOWER_CASE_MIN = 'a';
    public static final int LOWER_CASE_MAX = 'z';
    public static final int SIZE = 26;

    private EnglishAlphabetUtil() {
    }

    public static boolean isLetter(char c) {
        return isLower(c) || isUpper(c);
    }

    public static Boolean isUpper(char c) {
        return c >= 65 && c <= 90;
    }

    public static Boolean isLower(char c) {
        return c >= 97 && c <= 122;
    }

}
