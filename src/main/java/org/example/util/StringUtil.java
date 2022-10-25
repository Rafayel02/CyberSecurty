package org.example.util;

public class StringUtil {

    public static String makeDividable(String text, int number) {
        int remains = text.length() % number;
        if (remains != 0) {
            StringBuilder textBuilder = new StringBuilder(text);
            for (int i = 0; i < remains; i++) {
                textBuilder.insert(0, "0");
            }
            text = textBuilder.toString();
        }
        return text;
    }

}
