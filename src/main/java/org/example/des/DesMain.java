package org.example.des;

import java.util.Scanner;

public class DesMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input 10 bit key: ");
        String key = scanner.nextLine();

        while (key.length() != 10) {
            System.out.print("Input 10 bit key (The length should be 10): ");
            key = scanner.nextLine();
        }

        System.out.print(
                "Please choose mode\n" +
                        "1. Encrypt \n" +
                        "2. Decrypt \n" +
                        "Mode: "
        );

        int mode = Integer.parseInt(scanner.nextLine());

        System.out.print("Input 8 bit data: ");
        StringBuilder data = new StringBuilder(scanner.nextLine());

        while (data.length() > 8) {
            System.out.print("Input 8 bit data (The length should be less then 8): ");
            data = new StringBuilder(scanner.nextLine());
        }

        while (data.length() != 8) {
            data.insert(0, "0");
        }

        DesAlgorithm desAlgorithm = new DesAlgorithm();

        if (mode == 1) {
            System.out.println("Encrypted: " + desAlgorithm.encrypt(key, data.toString()));
        } else if (mode == 2) {
            System.out.println("Decrypted: " + desAlgorithm.decrypt(key, data.toString()));
        }

        scanner.close();
    }

}
