package org.example.parz_poxarinum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParzPoxarinumAlgorithm {

    private String key;

    private ParzPoxarinumAlgorithm() {
    }

    public static ParzPoxarinumAlgorithm getInstance() {
        return new ParzPoxarinumAlgorithm();
    }

    public ParzPoxarinumAlgorithm withKey(final String text) {
        final List<Character> charList = new ArrayList<>();

        for (char c : text.toCharArray()) {
            if (!charList.contains(c)) {
                if (isLetter(c)) charList.add(c);
            }
        }

        StringBuilder keyStart = new StringBuilder();
        for (Character character : charList) keyStart.append(character);
        System.out.println(keyStart);

        StringBuilder keyEnd = new StringBuilder();


        return this;
    }

    private boolean isLetter(char c) {
        return c >= 65 && c <= 122;
    }

}
