package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@wh
public abstract class nj {
    @Nullable
    private static MessageDigest f10023b = null;
    protected Object f10024a = new Object();

    @Nullable
    protected MessageDigest m12805a() {
        MessageDigest messageDigest;
        synchronized (this.f10024a) {
            if (f10023b != null) {
                messageDigest = f10023b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f10023b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f10023b;
            }
        }
        return messageDigest;
    }

    abstract byte[] mo3848a(String str);
}
