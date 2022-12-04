package org.example.veradasavorum;

import java.util.Arrays;
import java.util.Scanner;

public class VeradasavorumMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Key length: ");
        int keyLength = Integer.parseInt(scanner.nextLine());

        while (keyLength < 2 || keyLength > 26) {
            System.out.println("Wrong input!");

            System.out.print("Key length: ");
            keyLength = Integer.parseInt(scanner.nextLine());
        }
        System.out.print(
                "Please choose mode\n" +
                        "1. Encrypt \n" +
                        "2. Decrypt \n" +
                        "Mode: "
        );

        int mode = Integer.parseInt(scanner.nextLine());

        if (mode == 1) {
            System.out.println("Encrypted: " + VeradasavorumAlgorithm.encrypt(sentence, keyLength));
        } else if (mode == 2) {
            System.out.println(VeradasavorumAlgorithm.decrypt(sentence, keyLength));
        }

        scanner.close();
    }


}
