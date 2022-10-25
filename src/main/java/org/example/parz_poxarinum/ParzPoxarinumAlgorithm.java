package org.example.parz_poxarinum;

import org.example.util.KeyGenerator;


import static org.example.util.EnglishAlphabetUtil.*;

public class ParzPoxarinumAlgorithm {

    private String key;

    private ParzPoxarinumAlgorithm() {
    }

    public static ParzPoxarinumAlgorithm getInstance() {
        return new ParzPoxarinumAlgorithm();
    }

    public ParzPoxarinumAlgorithm withKey(final String text) {
        this.key = KeyGenerator.generate(text);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public String encode(final String text) {
        final StringBuilder result = new StringBuilder();

        final char[] keyList = key.toCharArray();

        for (char c : text.toLowerCase().toCharArray()) {
            if (isLetter(c)) {
                result.append(keyList[c - LOWER_CASE_MIN]);
            } else result.append(c);
        }

        return result.toString();
    }

    public String decode(final String text) {
        final StringBuilder result = new StringBuilder();

        final char[] keyList = key.toCharArray();

        for (char c : text.toLowerCase().toCharArray()) {
            boolean contains = false;
            for (int i = 0; i < keyList.length; i++) {
                if (keyList[i] == c) {
                    result.append((char) (LOWER_CASE_MIN + i));
                    contains = true;
                    break;
                }
            }
            if (!contains) result.append(c);
        }

        return result.toString();
    }

}
