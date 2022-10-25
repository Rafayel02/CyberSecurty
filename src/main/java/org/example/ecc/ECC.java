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

        System.out.println(Arrays.toString(dividedItems));

        for (int i = 0; i < dividedItems.length; i++) {
            char[] chars = dividedItems[i].toCharArray();
            dividedItems[i] = dividedItems[i] + (Integer.parseInt(String.valueOf(chars[0])) ^ Integer.parseInt(String.valueOf(chars[1])) ^ Integer.parseInt(String.valueOf(chars[2])));
        }

        System.out.println(Arrays.toString(dividedItems));

        return "";
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

}
