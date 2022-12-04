package org.example.rc4;

import java.util.Objects;
import java.util.Scanner;

public class Rc4Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter key: ");
        String key = scanner.nextLine();

        while (Objects.equals(key, "")) {
            System.out.print("Enter valid key: ");
            key = scanner.nextLine();
        }

        System.out.println("Encrypted: " + Rc4Algorithm.encrypt(text, key));

        scanner.close();
    }

}
