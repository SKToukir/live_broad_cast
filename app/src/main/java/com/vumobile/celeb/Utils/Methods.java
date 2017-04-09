package com.vumobile.celeb.Utils;

import java.util.Random;

/**
 * Created by toukirul on 9/4/2017.
 */

public class Methods {

    public static long getSerialnumber(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
}
