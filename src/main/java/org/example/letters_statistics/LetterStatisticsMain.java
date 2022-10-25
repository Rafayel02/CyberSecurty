package org.example.letters_statistics;

import org.example.simple_substitution.SimpleSubstitutionAlgorithm;
import org.example.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LetterStatisticsMain {

    public static void main(String[] args) throws IOException {
        final File file = new File("/Users/rshakhnazari/Desktop/CyberSecurity/src/main/java/org/example/lezvi_vichakagrutyun/text.txt");
        final String text = FileUtil.getFileContent(file);

        // before
        final Map<Character, Double> simpleTextResult = LetterStatisticsCalculator.calculate(text);

        final String encode = SimpleSubstitutionAlgorithm
                .getInstance()
                .withKey("state engineering university of armenia")
                .encode(text);

        // after
        final Map<Character, Double> encodedTextResult = LetterStatisticsCalculator.calculate(encode);

//        System.out.println("Not sorted: \n" + LezviVichakagrutyunCalculator.compareResults(simpleTextResult, encodedTextResult, false));

        System.out.println("Sorted by percentage: \n" + LetterStatisticsCalculator.compareResults(simpleTextResult, encodedTextResult, true));
    }

}
