package org.example.parz_poxarinum;

import org.example.util.EnglishAlphabetUtil;

import java.util.ArrayList;
import java.util.List;

public class ParzPoxarinumAlgorithm {

    private String key;

    private ParzPoxarinumAlgorithm() {
    }

    public static ParzPoxarinumAlgorithm getInstance() {
        return new ParzPoxarinumAlgorithm();
    }

    public ParzPoxarinumAlgorithm withKey(final String text) {
        final List<Character> charList = new ArrayList<>();

        for (char c : text.toLowerCase().toCharArray()) {
            if (!charList.contains(c)) {
                if (EnglishAlphabetUtil.isLetter(c)) charList.add(c);
            }
        }

        final StringBuilder keyStart = new StringBuilder();
        for (Character character : charList) keyStart.append(character);

        final String keyStartText = keyStart.toString();
        final StringBuilder keyEnd = new StringBuilder();

        for (int i = 97; i <= 122; i++) {
            boolean contains = false;
            for (char c : keyStartText.toCharArray()) {
                if (i == c) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                keyEnd.append((char) i);
            }
        }

        this.key = keyStartText + keyEnd;

        return this;
    }

    public String getKey() {
        return this.key;
    }

    public String encode(final String text) {
        final StringBuilder result = new StringBuilder();

        final char[] keyList = key.toCharArray();

        for (char c : text.toCharArray()) {
            if (EnglishAlphabetUtil.isLetter(c)) {
                result.append(keyList[c - 97]);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String decode(final String text) {
        final StringBuilder result = new StringBuilder();

        final char[] keyList = key.toCharArray();

        for (char c : text.toCharArray()) {
            boolean contains = false;
            for (int i = 0; i < keyList.length; i++) {
                if (keyList[i] == c) {
                    result.append((char) (97 + i));
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                result.append(c);
            }
        }

        return result.toString();
    }

}
