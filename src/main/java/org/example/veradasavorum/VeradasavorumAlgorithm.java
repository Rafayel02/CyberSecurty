package org.example.veradasavorum;

import org.example.util.EnglishAlphabetUtil;

import java.util.Arrays;

/**
 * © Ռաֆայել Շահնազարյան Դավիթի Երևան 2022
 * <p>
 * Այս լուծումը մշակվել է Հայաստանի Ազգային Պոլիտեխնիկական Համալսարանում
 * «Տեղեկատվության գաղտնագրային և թաքնագրային պաշտպանություն» առարկայի
 * ընթացքում։ Ծրագրային ապահովումը վերաբերվում է 'Վերադասավորման' ալգորիթմին։
 * Մշակված հատվածը կիրառելու դեպքում հեղիանկների անունները նշելը պարտադիր է։
 **/
public class VeradasavorumAlgorithm {

    public static String decrypt(String text, int keyLength) {
        char[][] matrix = new char[text.length() / keyLength][keyLength];

        char[] chars = text.toCharArray();

        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < text.length() / keyLength; j++) {
                matrix[j][i] = chars[i * (text.length() / keyLength) + j];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length() / keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                result.append(matrix[i][j]);
            }
        }

        while (result.toString().toCharArray()[result.length() - 1] == 'z') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static String encrypt(String sentence, int keyLength) {
        StringBuilder cleanUpSentence = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if (EnglishAlphabetUtil.isLetter(c)) {
                cleanUpSentence.append(c);
            }
        }
        if (cleanUpSentence.length() % keyLength != 0) {
            cleanUpSentence.append("z".repeat(Math.max(0, (5 - cleanUpSentence.length() % keyLength))));
        }
        sentence = cleanUpSentence.toString();

        char[][] matrix = new char[sentence.length() / keyLength][keyLength];

        char[] chars = sentence.toCharArray();

        for (int i = 0; i < sentence.length() / keyLength; i++) {
            System.arraycopy(chars, i * keyLength, matrix[i], 0, keyLength);
        }

        System.out.println(Arrays.deepToString(matrix));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < sentence.length() / keyLength; j++) {
                result.append(matrix[j][i]);
            }
        }

        return result.toString();
    }

}
