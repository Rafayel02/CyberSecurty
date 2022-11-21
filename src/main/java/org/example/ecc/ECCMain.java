package org.example.ecc;

public class ECCMain {

    public static void main(String[] args) {

        String encode = ECC.encode("001010011");

        System.out.println("001010011");
        System.out.println(encode);

        String changed = ECC.changeBit(encode, 1);
        System.out.println(changed);

        System.out.println(ECC.hasMistake(encode));
        System.out.println(ECC.hasMistake(changed));

    }

}
