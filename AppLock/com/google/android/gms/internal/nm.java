package com.google.android.gms.internal;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

@wh
public class nm extends nj {
    private MessageDigest f10031b;

    byte m12819a(int i) {
        return (byte) ((((i & 255) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((ViewCompat.MEASURED_STATE_MASK & i) >> 24));
    }

    public byte[] mo3848a(String str) {
        byte[] bArr;
        int i = 4;
        byte[] a = m12821a(str.split(" "));
        this.f10031b = m12805a();
        synchronized (this.a) {
            if (this.f10031b == null) {
                bArr = new byte[0];
            } else {
                this.f10031b.reset();
                this.f10031b.update(a);
                Object digest = this.f10031b.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte[] m12821a(String[] strArr) {
        int i = 0;
        if (strArr.length == 1) {
            return nl.m12816b(nl.m12812a(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                byte[] b = m12822b(nl.m12812a(strArr[i2]));
                bArr[i2 * 2] = b[0];
                bArr[(i2 * 2) + 1] = b[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        while (i < strArr.length) {
            bArr2[i] = m12819a(nl.m12812a(strArr[i]));
            i++;
        }
        return bArr2;
    }

    byte[] m12822b(int i) {
        int i2 = (SupportMenu.USER_MASK & i) ^ ((SupportMenu.CATEGORY_MASK & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }
}
