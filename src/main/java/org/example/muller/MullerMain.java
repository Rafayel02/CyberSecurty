package org.example.muller;

import org.example.veradasavorum.VeradasavorumAlgorithm;

import java.util.Scanner;

public class MullerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(
                "Please choose mode\n" +
                        "1. Encrypt \n" +
                        "2. Decrypt \n" +
                        "Mode: "
        );

        int mode = Integer.parseInt(scanner.nextLine());


        System.out.print("Input data: ");
        String data = scanner.nextLine();

        if (mode == 1) {
            while (data.length() != 4) {
                System.out.print("Input data with 4 length: ");
                data = scanner.nextLine();
            }
            System.out.println("Encrypted: " + MullerAlgorithm.encrypt(data));
        } else if (mode == 2) {
            while (data.length() != 8) {
                System.out.print("Input data with 8 length: ");
                data = scanner.nextLine();
            }
            System.out.println("Decrypted: " + MullerAlgorithm.decrypt(data));
        }


        scanner.close();
    }

}
