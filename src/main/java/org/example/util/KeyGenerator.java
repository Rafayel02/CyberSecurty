package org.example.util;

import java.util.ArrayList;
import java.util.List;

import static org.example.util.EnglishAlphabetUtil.*;

public class KeyGenerator {

    // The method will ignore upper cases
    public static String generate(final String text) {
        final List<Character> charList = new ArrayList<>();

        for (char c : text.toLowerCase().toCharArray()) {
            if (!charList.contains(c)) {
                if (isLetter(c)) charList.add(c);
            }
        }

        final StringBuilder keyStart = new StringBuilder();
        for (Character character : charList) keyStart.append(character);

        final String keyStartText = keyStart.toString();
        final StringBuilder keyEnd = new StringBuilder();

        for (int i = LOWER_CASE_MIN; i <= LOWER_CASE_MAX; i++) {
            boolean contains = false;
            for (char c : keyStartText.toCharArray()) {
                if (i == c) {
                    contains = true;
                    break;
                }
            }
            if (!contains) keyEnd.append((char) i);
        }

        return keyStartText + keyEnd;
    }

}
