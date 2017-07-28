package com.domobile.p001a.p002a;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.p066a.C3525a;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

public class C0579g {
    public static PublicKey m537a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C0570a.m498a(str)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        } catch (Throwable e22) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(e22);
        }
    }

    public static boolean m538a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return C0579g.m539a(C0579g.m537a(str), str2, str3);
        }
        Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
        return false;
    }

    public static boolean m539a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(C0570a.m498a(str2))) {
                return true;
            }
            Log.e("IABUtil/Security", "Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            Log.e("IABUtil/Security", "Signature exception.");
            return false;
        } catch (C3525a e4) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            return false;
        }
    }
}
