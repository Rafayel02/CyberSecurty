package org.example.hamming;

import java.util.LinkedList;
import java.util.Scanner;

public class HammingMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input binary data: ");
        String data = scanner.nextLine();

        // 1011
        LinkedList<Hamming.BitNode> encodedBits = Hamming.encode(data);
        System.out.println("Encoded: " + Hamming.bitsAsString(encodedBits));

        System.out.println("Error index: " + Hamming.findErrorIndex(encodedBits));

        Hamming.changeBit(encodedBits, 4);
        System.out.println("Changed: " + Hamming.bitsAsString(encodedBits));

        System.out.println("Error index: " + Hamming.findErrorIndex(encodedBits));

        Hamming.correct(encodedBits);
        System.out.println("Corrected: " + Hamming.bitsAsString(encodedBits));

    }

}
