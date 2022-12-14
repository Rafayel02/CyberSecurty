package org.example.simple_substitution;

import org.example.util.KeyGenerator;

import static org.example.util.EnglishAlphabetUtil.*;

/**
 * © Ռաֆայել Շահնազարյան Դավիթի Երևան 2022
 * <p>
 * Այս լուծումը մշակվել է Հայաստանի Ազգային Պոլիտեխնիկական Համալսարանում
 * «Տեղեկատվության գաղտնագրային և թաքնագրային պաշտպանություն» առարկայի
 * ընթացքում։ Ծրագրային ապահովումը վերաբերվում է 'Պարզ փոխարինում' ալգորիթմին։
 * Մշակված հատվածը կիրառելու դեպքում հեղիանկի անունը նշելը պարտադիր է։
 **/
public class SimpleSubstitutionAlgorithm {

    private String key;

    private SimpleSubstitutionAlgorithm() {
    }

    public static SimpleSubstitutionAlgorithm getInstance() {
        return new SimpleSubstitutionAlgorithm();
    }

    public SimpleSubstitutionAlgorithm withKey(final String text) {
        this.key = KeyGenerator.generate(text);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public String encode(final String text) {
        final StringBuilder result = new StringBuilder();

        final char[] keyList = key.toCharArray();

        for (char c : text.toLowerCase().toCharArray()) {
            if (isLetter(c)) {
                result.append(keyList[c - LOWER_CASE_MIN]);
            } else result.append(c);
        }

        return result.toString();
    }

    public String decode(final String text) {
        final StringBuilder result = new StringBuilder();

        final char[] keyList = key.toCharArray();

        for (char c : text.toLowerCase().toCharArray()) {
            boolean contains = false;
            for (int i = 0; i < keyList.length; i++) {
                if (keyList[i] == c) {
                    result.append((char) (LOWER_CASE_MIN + i));
                    contains = true;
                    break;
                }
            }
            if (!contains) result.append(c);
        }

        return result.toString();
    }

}
