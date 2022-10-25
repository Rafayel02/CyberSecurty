package org.example.ecc;

public class ECCMain {

    public static void main(String[] args) {

        System.out.println(1 ^ 1 ^ 1);

        String encode = ECC.encode("001010011");

        System.out.println(encode);

    }

}
