package org.example.lezvi_vichakagrutyun;

import org.example.parz_poxarinum.ParzPoxarinumAlgorithm;
import org.example.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LezviVichakagrutyunMain {

    public static void main(String[] args) throws IOException {
        final File file = new File("/Users/rshakhnazari/Desktop/CyberSecurity/src/main/java/org/example/lezvi_vichakagrutyun/text.txt");
        final String text = FileUtil.getFileContent(file);

        // before
        final Map<Character, Double> simpleTextResult = LezviVichakagrutyunCalculator.calculate(text);

        final String encode = ParzPoxarinumAlgorithm
                .getInstance()
                .withKey("state engineering university of armenia")
                .encode(text);

        // after
        final Map<Character, Double> encodedTextResult = LezviVichakagrutyunCalculator.calculate(encode);

        System.out.println("Not sorted: \n" + LezviVichakagrutyunCalculator.compareResults(simpleTextResult, encodedTextResult, false));

        System.out.println("Sorted by percentage: \n" + LezviVichakagrutyunCalculator.compareResults(simpleTextResult, encodedTextResult, true));
    }

}
