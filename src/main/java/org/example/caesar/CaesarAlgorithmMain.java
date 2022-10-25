package org.example.caesar;

import java.util.Scanner;

public class CaesarAlgorithmMain {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // 1 - encode, 2 - decode
        System.out.print("Encode/Decode/hatarkum (1/2/3): ");
        int method = Integer.parseInt(scanner.nextLine());

        if (method == 1) {
            System.out.print("Input text: ");
            final String text = scanner.nextLine();

            System.out.print("Input key count: ");
            final int count = Integer.parseInt(scanner.nextLine());

            System.out.println("Encoded: " + CaesarAlgorithm.encode(text, count) + "\n");
        } else if (method == 2) {
            System.out.print("Input text: ");
            final String encoded = scanner.nextLine();

            System.out.print("Input key count: ");
            final int decodeCount = Integer.parseInt(scanner.nextLine());

            System.out.println("Decoded: " + CaesarAlgorithm.decode(encoded, decodeCount));
        } else if (method == 3) {
            System.out.print("Input text: ");
            final String text = scanner.nextLine();

            System.out.println("All possible cases: " + CaesarAlgorithm.getAllCases(text));
        } else {
            System.out.println("Please select valid option");
        }

    }

}
