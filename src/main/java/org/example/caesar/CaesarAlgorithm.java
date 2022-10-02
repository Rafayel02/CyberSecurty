package org.example.caesar;

public class CaesarAlgorithm {

    private CaesarAlgorithm() {
    }

    public static String encode(final String text, final int count) {
        final StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 65 && c <= 90) {
                int nextValue = c + count;
                if (nextValue > 90) {
                    nextValue = 65 + (nextValue - 90) - 1;
                } else if (nextValue < 65) {
                    nextValue = 90 - (65 - nextValue) + 1;
                }
                result.append((char) nextValue);
            } else if (c >= 97 && c <= 122) {
                int nextValue = c + count;
                if (nextValue > 122) {
                    nextValue = 97 + (nextValue - 122) - 1;
                } else if (nextValue < 97) {
                    nextValue = 122 - (97 - nextValue) + 1;
                }
                result.append((char) nextValue);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decode(final String text, final int count) {
        return encode(text, -count);
    }

}
