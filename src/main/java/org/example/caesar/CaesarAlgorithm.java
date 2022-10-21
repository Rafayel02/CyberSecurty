package org.example.caesar;

import org.example.util.EnglishAlphabetUtil;

import java.util.ArrayList;
import java.util.List;

import static org.example.util.EnglishAlphabetUtil.*;

public class CaesarAlgorithm {

    private CaesarAlgorithm() {
    }

    public static String encode(final String text, final int count) {
        final StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (isUpper(c)) {
                result.append((char) (((c + count - UPPER_CASE_MIN) % SIZE) + UPPER_CASE_MIN));
            } else if (isLower(c)) {
                result.append((char) (((c + count - LOWER_CASE_MIN) % SIZE) + LOWER_CASE_MIN));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decode(final String text, final int count) {
        return encode(text, 26 - count);
    }

    public static List<String> getAllCases(final String decoded) {
        List<String> allValues = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            allValues.add(encode(decoded, (i + 1)));
        }
        return allValues;
    }

}
