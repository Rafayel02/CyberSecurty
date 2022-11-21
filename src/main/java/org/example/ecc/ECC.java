package org.example.ecc;

import org.example.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.util.StringUtil.makeDividable;

public class ECC {

    private ECC() {
    }

    public static String encode(String text) {
        // Making dividable to number 3 for dividing into 3 count parts
        text = makeDividable(text, 3);
        String[] dividedItems = divideItems(text);

        for (int i = 0; i < dividedItems.length; i++) {
            char[] chars = dividedItems[i].toCharArray();
            dividedItems[i] = dividedItems[i] + (Integer.parseInt(String.valueOf(chars[0])) ^ Integer.parseInt(String.valueOf(chars[1])) ^ Integer.parseInt(String.valueOf(chars[2])));
        }

        StringBuilder result = new StringBuilder();
        for (String dividedItem : dividedItems) {
            result.append(dividedItem);
        }

        return result.toString();
    }

    private static String[] divideItems(String text) {
        char[] chars = text.toCharArray();

        String[] dividedItems = new String[chars.length / 3];

        int count = 0;
        for (int i = 0; i < chars.length; i += 3) {
            dividedItems[count++] = (String.format("%s%s%s", chars[i], chars[i + 1], chars[i + 2]));
        }

        return dividedItems;
    }

    public static String changeBit(String encode, int i) {
        StringBuilder result = new StringBuilder();
        char[] chars = encode.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (i == j) {
                chars[j] = chars[j] == '1' ? '0' : '1';
                result.append(chars[j]);
                continue;
            }
            char c = chars[j];
            result.append(c);
        }
        return result.toString();
    }

    public static boolean hasMistake(String encode) {
        char[] chars = encode.toCharArray();

        int result = Integer.parseInt(String.valueOf(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            result = result ^ Integer.parseInt(String.valueOf(aChar));
        }

        return result == 1;
    }
}
