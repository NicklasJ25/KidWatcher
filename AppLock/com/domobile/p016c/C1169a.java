package com.domobile.p016c;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class C1169a {
    public static final String m2675a(String str, String str2) {
        return C1169a.m2677a(str.getBytes(), str2.getBytes());
    }

    private static final String m2676a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(Integer.toHexString((b & 255) + 256).substring(1).toUpperCase());
        }
        return stringBuffer.toString();
    }

    private static final String m2677a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "DES");
        Cipher instance = Cipher.getInstance("DES");
        instance.init(1, secretKeySpec);
        return C1169a.m2676a(instance.doFinal(bArr));
    }

    public static final byte[] m2678a(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }

    public static final String m2679b(String str, String str2) {
        return new String(C1169a.m2680b(C1169a.m2678a(str), str2.getBytes()));
    }

    private static final byte[] m2680b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "DES");
        try {
            Cipher instance = Cipher.getInstance("DES");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
