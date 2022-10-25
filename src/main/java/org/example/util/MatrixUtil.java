package org.example.util;

import java.util.Arrays;

public class MatrixUtil {

    private MatrixUtil() {
    }

    public static String getCharArrayAsString(final char[][] array, final boolean inline) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            char[] matrix = array[i];
            stringBuilder.append(Arrays.toString(matrix));
            if (i != array.length - 1) {
                if (inline) {
                    stringBuilder.append(", ");
                } else {
                    stringBuilder.append("\n");
                }
            }
        }

        return stringBuilder.toString();
    }

}
