package org.example.des;

import java.util.Arrays;

public class DesUtil {

    private static final int[] P10 = new int[]{3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    private static final int[] P8 = new int[]{6, 3, 7, 4, 8, 5, 10, 9};
    private static final int[] P4 = new int[]{2, 4, 3, 1};
    private static final int[] IP = new int[]{2, 6, 3, 1, 4, 8, 5, 7};
    private static final int[] IP_INVERSE = new int[]{4, 1, 3, 5, 7, 2, 8, 6};
    private static final int[] EP = new int[]{4, 1, 2, 3, 2, 3, 4, 1};

    private static final String[][] S0 = new String[][]{
            {"01", "00", "11", "10"},
            {"11", "10", "01", "00"},
            {"00", "10", "01", "11"},
            {"11", "01", "11", "10"}
    };

    private static final String[][] S1 = {
            {"00", "01", "10", "11"},
            {"10", "00", "01", "11"},
            {"11", "00", "01", "00"},
            {"10", "01", "00", "11"}
    };

    private DesUtil() {
    }

    public static String P10(String input) {
        StringBuilder output = new StringBuilder();
        char[] dataChars = input.toCharArray();
        for (int i : P10) output.append(dataChars[i - 1]);
        return output.toString();
    }

    public static String P8(String input) {
        StringBuilder output = new StringBuilder();
        char[] dataChars = input.toCharArray();
        for (int i : P8) {
            output.append(dataChars[i - 1]);
        }
        return output.toString();
    }

    public static String P4(String input) {
        StringBuilder output = new StringBuilder();
        char[] dataChars = input.toCharArray();
        for (int i : P4) output.append(dataChars[i - 1]);
        return output.toString();
    }

    public static String IP(String input) {
        StringBuilder output = new StringBuilder();
        char[] dataChars = input.toCharArray();
        for (int i : IP) output.append(dataChars[i - 1]);
        return output.toString();
    }

    public static String IP_INVERSE(String input) {
        StringBuilder output = new StringBuilder();
        char[] dataChars = input.toCharArray();
        for (int i : IP_INVERSE) output.append(dataChars[i - 1]);
        return output.toString();
    }

    public static String EP(String input) {
        StringBuilder output = new StringBuilder();
        char[] dataChars = input.toCharArray();
        for (int i : EP) output.append(dataChars[i - 1]);
        return output.toString();
    }

    public static String S0(String input) {
        char[] dataChars = input.toCharArray();
        int row = Integer.parseInt(dataChars[0] + "" + dataChars[3], 2);
        int column = Integer.parseInt(dataChars[1] + "" + dataChars[2], 2);
        return S0[row][column];
    }

    public static String S1(String input) {
        char[] dataChars = input.toCharArray();
        int row = Integer.parseInt(dataChars[0] + "" + dataChars[3], 2);
        int column = Integer.parseInt(dataChars[1] + "" + dataChars[2], 2);
        return S1[row][column];
    }

    public static String LEFT_SHIFT(String input, int count) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < count; j++) {
            char[] dataChars = input.toCharArray();
            int[] shiftedArray = new int[dataChars.length];

            for (int i = 1; i < dataChars.length; i++) {
                shiftedArray[i - 1] = dataChars[i];
                if (i == dataChars.length - 1) {
                    shiftedArray[i] = dataChars[0];
                }
            }

            for (int c : shiftedArray) {
                result.append((char) c);
            }
            input = result.toString();
            result = new StringBuilder();
        }

        return input;
    }


    public static String XOR(String a, String b) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                res.append("0");
            } else {
                res.append("1");
            }
        }

        return res.toString();
    }

}

