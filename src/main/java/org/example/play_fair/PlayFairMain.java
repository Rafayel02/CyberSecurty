package org.example.play_fair;

import java.util.Scanner;

public class PlayFairMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // state engineering university of armenia
        System.out.print("Input key sentence: ");
        String keyText = scanner.nextLine();

        PlayFairAlgorithm playFair = PlayFairAlgorithm.getInstance().withKey(keyText);
        System.out.println("Key matrix: \n" + playFair.getKeyMatrixAsString() + "\n");

        System.out.print("Encode/Decode (1/2): ");
        int method = Integer.parseInt(scanner.nextLine());

        if (method == 1) {
            System.out.print("Input text: ");
            String text = scanner.nextLine();

            // cpenstkbaavveekk
            System.out.println("Encoded: " + playFair.encode(text));
        } else if (method == 2) {
            System.out.print("Input text: ");
            String text = scanner.nextLine();

            PlayFairAlgorithm playFairDecoder = PlayFairAlgorithm.getInstance().withKey(keyText);
            System.out.println("Decoded: " + playFairDecoder.decode(text));
        } else {
            System.out.println("Please select valid option");
        }
    }

}
