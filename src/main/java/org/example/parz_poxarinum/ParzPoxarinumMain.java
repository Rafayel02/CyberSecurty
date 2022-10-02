package org.example.parz_poxarinum;

import java.util.Scanner;

public class ParzPoxarinumMain {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // state engineering university of armenia
        System.out.print("Input key sentence: ");
        final String keySentence = scanner.nextLine();

        final ParzPoxarinumAlgorithm parzPoxarinumAlgorithm = ParzPoxarinumAlgorithm.getInstance().withKey(keySentence);

        System.out.println("The key is: " + parzPoxarinumAlgorithm.getKey());

        System.out.print("Input text.txt: ");
        final String text = scanner.nextLine();

        final String encodedText = parzPoxarinumAlgorithm.encode(text);
        System.out.println("Encoded: " + encodedText);
        System.out.println("Decoded: " + parzPoxarinumAlgorithm.decode(encodedText));
    }

}