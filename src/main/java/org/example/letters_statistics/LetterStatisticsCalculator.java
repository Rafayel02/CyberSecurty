package org.example.letters_statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.util.EnglishAlphabetUtil.*;

/**
 * © Ռաֆայել Շահնազարյան Դավիթի Երևան 2022
 * <p>
 * Այս լուծումը մշակվել է Հայաստանի Ազգային Պոլիտեխնիկական Համալսարանում
 * «Տեղեկատվության գաղտնագրային և թաքնագրային պաշտպանություն» առարկայի
 * ընթացքում։ Ծրագրային ապահովումը վերաբերվում է 'Լեզվի վիճակագրություն' ալգորիթմին։
 * Մշակված հատվածը կիրառելու դեպքում հեղիանկի անունը նշելը պարտադիր է։
 **/
public class LetterStatisticsCalculator {

    private LetterStatisticsCalculator() {
    }

    public static Map<Character, Double> calculate(final File file) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        final Map<Character, Double> result = new HashMap<>();

        for (int i = 97; i <= 122; i++) {
            result.put((char) i, 0D);
        }

        String line = bufferedReader.readLine();

        int allCount = 0;
        while (line != null) {
            for (char c : line.toCharArray()) {
                if (isLetter(c)) {
                    result.put(c, result.get(c) + 1);
                    allCount++;
                }
            }

            line = bufferedReader.readLine();
        }

        for (Map.Entry<Character, Double> entrySet : result.entrySet()) {
            entrySet.setValue(Double.parseDouble(String.format("%.4f", entrySet.getValue() / allCount)));
        }

        return result;
    }

    public static Map<Character, Double> calculate(final String text) {

        final Map<Character, Double> result = new HashMap<>();

        for (int i = LOWER_CASE_MIN; i <= LOWER_CASE_MAX; i++) {
            result.put((char) i, 0D);
        }

        int allCount = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (isLetter(c)) {
                result.put(c, result.get(c) + 1);
                allCount++;
            }
        }

        for (Map.Entry<Character, Double> entrySet : result.entrySet()) {
            entrySet.setValue(entrySet.getValue() / allCount);
        }

        return result;
    }

    public static ComparedViewList compareResults(final Map<Character, Double> first, final Map<Character, Double> second, boolean sort) {
        final ComparedViewList comparedViewList = new ComparedViewList();
        for (Map.Entry<Character, Double> entrySet : first.entrySet()) {
            for (Map.Entry<Character, Double> secondEntrySet : second.entrySet()) {
                if (entrySet.getValue().equals(secondEntrySet.getValue())) {
                    comparedViewList.add(new ComparedViewList.ComparedView(entrySet.getKey(), secondEntrySet.getKey(), entrySet.getValue()));
                    break;
                }
            }
        }

        if (sort) {
            comparedViewList.sort();
        }

        return comparedViewList;
    }

    public static class ComparedViewList {

        private final List<ComparedView> comparedViewList = new ArrayList<>();


        public void add(final ComparedView comparedView) {
            comparedViewList.add(comparedView);
        }

        @Override
        public String toString() {
            final StringBuilder result = new StringBuilder();

            for (ComparedView comparedView : comparedViewList) {
                result.append(comparedView);
                result.append("\n");
            }

            return result.toString();
        }

        public void sort() {
            this.comparedViewList.sort((o1, o2) -> Double.compare(o2.getPercent(), o1.getPercent()));
        }

        public static class ComparedView {
            private final char a;
            private final char b;
            private final double percent;

            public ComparedView(char a, char b, double percent) {
                this.a = a;
                this.b = b;
                this.percent = percent;
            }

            public double getPercent() {
                return percent;
            }

            @Override
            public String toString() {
                return String.format("%s -- %.4f -- %s", a, percent, b);
            }

        }

    }

}
