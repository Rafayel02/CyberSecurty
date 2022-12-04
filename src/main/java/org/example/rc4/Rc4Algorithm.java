package org.example.rc4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rc4Algorithm {

    public static String encrypt(String text, String key) {
        int[] s = new int[256];

        for (int i = 0; i < 256; i++) s[i] = i;

        int j = 0;
        char[] chars = key.toCharArray();
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + chars[i % chars.length]) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        List<Integer> keyList = PRGA(text, s);

        StringBuilder stringBuilder = new StringBuilder();

        char[] textChars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            char c = (char) (keyList.get(i) ^ textChars[i]);
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    private static List<Integer> PRGA(String text, int[] s) {
        int i = 0;
        int j = 0;
        int textSize = text.length();

        List<Integer> keyList = new ArrayList<>();

        for (int e = 0; e < textSize; e++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            int k = s[(s[i] + s[j]) % 256];
            keyList.add(k);
        }

        return keyList;
    }

}
