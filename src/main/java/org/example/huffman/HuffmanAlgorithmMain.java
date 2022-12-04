package org.example.huffman;

public class HuffmanAlgorithmMain {

    public static void main(String[] args) {
        String text = "This page is an overview of Kubernetes.";

        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm();

        System.out.println("Initial text: " + text);
        String encrypted = huffmanAlgorithm.encrypt(text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + huffmanAlgorithm.decrypt(encrypted));
    }

}
