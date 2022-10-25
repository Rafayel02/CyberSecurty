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

        System.out.print("Encode/Decode (1/2): ");
        int method = Integer.parseInt(scanner.nextLine());

        if (method == 1) {
            System.out.print("Input text: ");
            final String text = scanner.nextLine();

            System.out.println("Encoded: " + parzPoxarinumAlgorithm.encode(text));
        } else if (method == 2) {
            System.out.print("Input text: ");
            final String text = scanner.nextLine();

            System.out.println("Decoded: " + parzPoxarinumAlgorithm.decode(text));
        } else {
            System.out.println("Please select valid option");
        }

    }

}