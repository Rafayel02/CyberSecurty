package org.example.parz_poxarinum;

import java.util.Scanner;

public class ParzPoxarinumMain {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);


        // state engineering university of armenia
        System.out.print("Input key sentence: ");
        final String keySentence = scanner.nextLine();

        ParzPoxarinumAlgorithm.getInstance().withKey(keySentence);
    }

}