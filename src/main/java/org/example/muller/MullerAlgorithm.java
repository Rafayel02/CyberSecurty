package org.example.muller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.util.BinaryUtils.*;
import static org.example.util.StringUtil.charsToString;

public class MullerAlgorithm {

    private static final char[][] STATIC_GRID = {
            {'1', '1', '1', '1', '1', '1', '1', '1'}, // 1
            {'1', '1', '1', '1', '0', '0', '0', '0'}, // x0
            {'1', '1', '0', '0', '1', '1', '0', '0'}, // x1
            {'1', '0', '1', '0', '1', '0', '1', '0'}, // x2
    };

    private static final Map<Integer, List<Integer>> ID_MAPPING = Map.of(
            3, List.of(1, 2),
            2, List.of(1, 3),
            1, List.of(3, 2)
    );

    public static String encrypt(String data) {
        char[] chars = data.toCharArray();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '1') {
                list.add(charsToString(STATIC_GRID[i]));
            }
        }

        return XOR_LIST(list);
    }

    public static String decrypt(String data) {
        String forX2 = getFor(3, data);
        String forX1 = getFor(2, data);
        String forX0 = getFor(1, data);

        List<String> list = new ArrayList<>();
        if (forX2.toCharArray()[0] == '1') {
            list.add(charsToString(STATIC_GRID[3]));
        }
        if (forX1.toCharArray()[0] == '1') {
            list.add(charsToString(STATIC_GRID[2]));
        }
        if (forX0.toCharArray()[0] == '1') {
            list.add(charsToString(STATIC_GRID[1]));
        }

        String s = XOR_LIST(list);

        System.out.println("Actual data: " + s);

        String xor = XOR(s, data);
        int oneCount = 0;

        for (char c : xor.toCharArray()) {
            if (c == '1') {
                oneCount++;
            }
        }

        int for1;

        if (oneCount < 4) {
            for1 = 0;
            System.out.println("Mistake: " + xor);
        } else {
            for1 = 1;
            System.out.println("Many mistakes");
        }

        return for1 + forX0 + forX1 + forX2;
    }

    private static String getFor(int i, String data) {
        List<Integer> integers = ID_MAPPING.get(i);
        String f = charsToString(STATIC_GRID[integers.get(0)]);
        String fb = bacasel(f);

        String s = charsToString(STATIC_GRID[integers.get(1)]);
        String sb = bacasel(s);

        String vektorakan1 = vektorakan(f, s);
        String vektorakan2 = vektorakan(f, sb);
        String vektorakan3 = vektorakan(s, fb);
        String vektorakan4 = vektorakan(sb, fb);

        List<String> skalyars = List.of(
                skalyar(vektorakan1, data),
                skalyar(vektorakan2, data),
                skalyar(vektorakan3, data),
                skalyar(vektorakan4, data)
        );

        int oneCount = 0;
        for (String skalyar : skalyars) {
            if (skalyar.toCharArray()[0] == '1') {
                oneCount++;
            }
        }

        if (oneCount >= 2) {
            return "1";
        }

        return "0";
    }

}
