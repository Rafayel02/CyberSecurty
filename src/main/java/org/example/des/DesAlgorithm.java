package org.example.des;

import static org.example.des.DesUtil.*;
import static org.example.util.BinaryUtils.XOR;

/**
 * © Ռաֆայել Շահնազարյան Դավիթի Երևան 2022
 * <p>
 * Այս լուծումը մշակվել է Հայաստանի Ազգային Պոլիտեխնիկական Համալսարանում
 * «Տեղեկատվության գաղտնագրային և թաքնագրային պաշտպանություն» առարկայի
 * ընթացքում։ Ծրագրային ապահովումը վերաբերվում է 'S-DES' ալգորիթմին։
 * Մշակված հատվածը կիրառելու դեպքում հեղիանկների անունները նշելը պարտադիր է։
 **/
public class DesAlgorithm {

    private String key1;
    private String key2;

    public String encrypt(String key, String data) {
        makeKeys(key);

        String fx1 = encryptFunction(IP(data), this.key1);
        String[] divide = divide(fx1);

        String fx2 = encryptFunction(divide[1] + divide[0], this.key2);

        return IP_INVERSE(fx2);
    }

    private String encryptFunction(String data, String key) {
        String[] divide1 = divide(data);

        String ep = EP(divide1[1]);

        String xor1 = XOR(ep, key);

        String[] divide2 = divide(xor1);

        String s0 = S0(divide2[0]);
        String s1 = S1(divide2[1]);

        String p4 = P4(s0 + s1);

        return XOR(divide1[0], p4) + divide1[1];
    }

    public String decrypt(String key, String data) {
        return null;
    }

    public String[] divide(String data) {
        String[] result = new String[2];
        result[0] = data.substring(0, data.length() / 2);
        result[1] = data.substring(data.length() / 2);
        return result;
    }

    private void makeKeys(String key) {
        String p10 = P10(key);
        String[] divide = divide(p10);

        String left = LEFT_SHIFT(divide[0], 1);
        String right = LEFT_SHIFT(divide[1], 1);

        this.key1 = P8(left + right);

        left = LEFT_SHIFT(left, 2);
        right = LEFT_SHIFT(right, 2);

        this.key2 = P8(left + right);
    }
}
