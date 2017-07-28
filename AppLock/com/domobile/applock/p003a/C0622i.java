package com.domobile.applock.p003a;

import java.util.Random;

public class C0622i {
    private static final int f566a = (("abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ".length() + "0123456789".length()) + "~!@#$%^&*_-+=|?".length());

    public static String m740a(int i) {
        int i2 = 0;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int nextInt = random.nextInt(f566a);
            if (nextInt < "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ".length()) {
                stringBuilder.append("abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ".charAt(nextInt));
                i3 = nextInt < 26 ? i3 | 1 : i3 | 2;
            } else {
                nextInt -= "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ".length();
                if (nextInt < "0123456789".length()) {
                    stringBuilder.append("0123456789".charAt(nextInt));
                    i3 |= 4;
                } else {
                    i4++;
                    if (i4 == 1 || ((double) i4) <= ((double) i) * 0.15d) {
                        stringBuilder.append("~!@#$%^&*_-+=|?".charAt(nextInt - "0123456789".length()));
                        i3 |= 8;
                    } else {
                        i2--;
                    }
                }
            }
            i2++;
        }
        return i3 == 15 ? stringBuilder.toString() : C0622i.m740a(i);
    }
}
