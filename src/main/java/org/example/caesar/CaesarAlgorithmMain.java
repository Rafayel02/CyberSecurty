package org.example.caesar;

import java.util.Scanner;

public class CaesarAlgorithmMain {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Input your test: ");
        final String text = scanner.nextLine();

        System.out.print("Input count to siift: ");
        final int count = scanner.nextInt();

        System.out.printf("Inputted text: %s\n", text);
        final String encodedText = CaesarAlgorithm.encode(text, count);
        System.out.println("Encoded: " + encodedText);
        System.out.println("Decoded: " + CaesarAlgorithm.decode(encodedText, count));

        scanner.close();
    }

}
