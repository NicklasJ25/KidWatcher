package com.domobile.applock.p003a;

import android.util.Base64;
import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class C0610a {
    public static boolean f545a = true;
    private static final byte[] f546b = "2011071120170711".getBytes();

    public static String m692a(String str, String str2) {
        try {
            return Base64.encodeToString(C0610a.m694a(C0610a.m693a(str), f546b, str2.getBytes("UTF-8")), 2);
        } catch (Throwable e) {
            if (f545a) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    private static SecretKeySpec m693a(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        return new SecretKeySpec(instance.digest(), "AES");
    }

    public static byte[] m694a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return instance.doFinal(bArr2);
    }

    public static String m695b(String str, String str2) {
        try {
            return new String(C0610a.m696b(C0610a.m693a(str), f546b, Base64.decode(str2, 2)), "UTF-8");
        } catch (Throwable e) {
            if (f545a) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] m696b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return instance.doFinal(bArr2);
    }
}
