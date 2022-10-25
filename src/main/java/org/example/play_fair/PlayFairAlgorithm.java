package org.example.play_fair;

import org.example.util.KeyGenerator;
import org.example.util.MatrixUtil;

import java.util.Arrays;

public class PlayFairAlgorithm {
    private String key;
    private final char[][] keyMatrix = new char[5][5];

    private PlayFairAlgorithm() {
    }

    public static PlayFairAlgorithm getInstance() {
        return new PlayFairAlgorithm();
    }

    public PlayFairAlgorithm withKey(final String text) {
        this.key = KeyGenerator.generate(text);
        initializeMatrix();
        return this;
    }

    public String getKeyMatrixAsString() {
        return MatrixUtil.getCharArrayAsString(this.keyMatrix, false);
    }

    public String encode(final String text) {
        // Clean up text by adding 'z' between double letters, making even and replacing 'j' with 'i'
        final String updatedText = addCharBetweenDoubleLettersAndMakeEven(text);

        // Splitting into matrix the text
        final char[][] textMatrix = getBinaryMatrixFromText(updatedText);

        // Encoding on matrix
        return encodeByMatrix(textMatrix);
    }

    public String decode(final String text) {
        char[][] binaryMatrixFromText = getBinaryMatrixFromText(text);
        String decoded = decodeByMatrix(binaryMatrixFromText);
        char[][] decodedMatrix = getBinaryMatrixFromText(decoded);
        return removeAddedCharacters(decodedMatrix);
    }

    private void initializeMatrix() {
        this.key = this.key.replace("j", "");
        char[] charArray = this.key.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            this.keyMatrix[i / 5][i % 5] = c;
        }
    }

    private String addCharBetweenDoubleLettersAndMakeEven(String text) {
        final StringBuilder result = new StringBuilder();
        char charToAdd = 'z';

        // Replacing 'j' with 'i', if remove this statement 'j' will be always 'j'
        text = text.replace('j', 'i');

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            char current = chars[i];
            // Even case
            char next = (i + 1) >= chars.length ? charToAdd : chars[i + 1];

            if (current != next) {
                result.append(current).append(next);
            } else {
                result.append(current).append(charToAdd);
                i--;
            }
        }

        return result.toString();
    }


    private String removeAddedCharacters(char[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < matrix.length - 1; i++) {
            char[] arr = matrix[i];
            char[] nextArr = matrix[i + 1];

            if ((arr[0] == nextArr[0]) && arr[1] == 'z') {
                stringBuilder.append(arr[0]);
            } else {
                stringBuilder.append(arr[0]).append(arr[1]);
            }

            if (i == matrix.length - 2) {
                if (nextArr[1] == 'z') {
                    stringBuilder.append(nextArr[0]);
                } else {
                    stringBuilder.append(nextArr[0]).append(nextArr[1]);
                }
            }

        }

        return stringBuilder.toString();
    }

    private Coordinates getCoordinatesOf(final char ch) {
        Coordinates coordinates = new Coordinates(-1, -1);
        for (int i = 0; i < keyMatrix.length; i++) {
            char[] row = keyMatrix[i];
            for (int j = 0, rowLength = row.length; j < rowLength; j++) {
                char c = row[j];
                if (c == ch) {
                    coordinates.setRow(i);
                    coordinates.setColumn(j);
                    return coordinates;
                }
            }
        }
        return coordinates;
    }

    private char[][] getBinaryMatrixFromText(final String updatedText) {
        final int rowSize = updatedText.length() / 2;

        final char[][] result = new char[rowSize][2];

        char[] charArray = updatedText.toCharArray();
        int counter = 0;
        for (int i = 0; i < charArray.length; i += 2) {
            result[counter][0] = charArray[i];
            result[counter][1] = charArray[i + 1];
            counter++;
        }

        return result;
    }

    private String encodeByMatrix(char[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] arr : matrix) {
            Coordinates coord1 = getCoordinatesOf(arr[0]);
            Coordinates coord2 = getCoordinatesOf(arr[1]);

            if (!(coord1.isValid() && coord2.isValid())) {
                stringBuilder.append(arr[0]).append(arr[1]);
                continue;
            }

            if (coord1.areInSameLineWith(coord2)) {
                arr[0] = this.keyMatrix[coord1.getRow()][(coord1.getColumn() + 1) % 5];
                arr[1] = this.keyMatrix[coord2.getRow()][(coord2.getColumn() + 1) % 5];
            } else if (coord1.areInSameColumWith(coord2)) {
                arr[0] = this.keyMatrix[(coord1.getRow() + 1) % 5][coord1.getColumn()];
                arr[1] = this.keyMatrix[(coord2.getRow() + 1) % 5][coord2.getColumn()];
            } else {
                arr[0] = this.keyMatrix[coord1.getRow()][coord2.getColumn()];
                arr[1] = this.keyMatrix[coord2.getRow()][coord1.getColumn()];
            }

            stringBuilder.append(arr[0]).append(arr[1]);

        }
        return stringBuilder.toString();
    }

    private String decodeByMatrix(char[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] arr : matrix) {
            Coordinates coord1 = getCoordinatesOf(arr[0]);
            Coordinates coord2 = getCoordinatesOf(arr[1]);

            if (!(coord1.isValid() && coord2.isValid())) {
                stringBuilder.append(arr[0]).append(arr[1]);
                continue;
            }

            if (coord1.areInSameLineWith(coord2)) {
                arr[0] = this.keyMatrix[coord1.getRow()][(coord1.getColumn() + 4) % 5];
                arr[1] = this.keyMatrix[coord2.getRow()][(coord2.getColumn() + 4) % 5];
            } else if (coord1.areInSameColumWith(coord2)) {
                arr[0] = this.keyMatrix[(coord1.getRow() + 4) % 5][coord1.getColumn()];
                arr[1] = this.keyMatrix[(coord2.getRow() + 4) % 5][coord2.getColumn()];
            } else {
                arr[0] = this.keyMatrix[coord1.getRow()][coord2.getColumn()];
                arr[1] = this.keyMatrix[coord2.getRow()][coord1.getColumn()];
            }

            stringBuilder.append(arr[0]).append(arr[1]);

        }
        return stringBuilder.toString();
    }

    public static class Coordinates {
        private int row;
        private int column;

        public Coordinates(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public boolean isValid() {
            return row != -1 && column != -1;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public boolean areInSameLineWith(final Coordinates another) {
            return this.row == another.getRow();
        }

        public boolean areInSameColumWith(final Coordinates another) {
            return this.column == another.getColumn();
        }

    }

}
