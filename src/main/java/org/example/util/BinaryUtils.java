package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class BinaryUtils {

    public static String XOR_LIST(List<String> values) {
        if (values.size() == 0) {
            return "";
        }

        if (values.size() == 2) {
            return XOR(values.get(0), values.get(1));
        }

        List<String> newValues = new ArrayList<>(values);
        String lastValue = newValues.get(newValues.size() - 1);
        newValues.remove(lastValue);

        return XOR(XOR_LIST(newValues), lastValue);
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

    public static String bacasel(String a) {
        StringBuilder res = new StringBuilder();

        for (char c : a.toCharArray()) {
            if (c == '1') {
                res.append('0');
            } else if (c == '0') {
                res.append('1');
            }
        }

        return res.toString();
    }

    /**
     * Only equal length case
     */
    public static String vektorakan(String a, String b) {
        StringBuilder res = new StringBuilder();

        char[] first = a.toCharArray();
        char[] second = b.toCharArray();

        for (int i = 0; i < first.length; i++) {
            if (first[i] == '0' || second[i] == '0') {
                res.append('0');
            } else {
                res.append('1');
            }
        }

        return res.toString();
    }

    /**
     * Only equal length case
     */
    public static String skalyar(String a, String b) {
        String vektorakan = vektorakan(a, b);

        int oneCount = 0;
        for (char c : vektorakan.toCharArray()) {
            if (c == '1') {
                oneCount++;
            }
        }

        if (oneCount % 2 == 0) {
            return "0";
        }

        return "1";
    }


}
