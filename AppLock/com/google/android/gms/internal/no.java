package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.security.MessageDigest;

@wh
public class no extends nj {
    private MessageDigest f10035b;
    private final int f10036c;
    private final int f10037d;

    public no(int i) {
        int i2 = i / 8;
        if (i % 8 > 0) {
            i2++;
        }
        this.f10036c = i2;
        this.f10037d = i;
    }

    public byte[] mo3848a(String str) {
        byte[] bArr;
        synchronized (this.a) {
            this.f10035b = m12805a();
            if (this.f10035b == null) {
                bArr = new byte[0];
            } else {
                this.f10035b.reset();
                this.f10035b.update(str.getBytes(Charset.forName("UTF-8")));
                Object digest = this.f10035b.digest();
                bArr = new byte[(digest.length > this.f10036c ? this.f10036c : digest.length)];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
                if (this.f10037d % 8 > 0) {
                    int i;
                    long j = 0;
                    for (i = 0; i < bArr.length; i++) {
                        if (i > 0) {
                            j <<= 8;
                        }
                        j += (long) (bArr[i] & 255);
                    }
                    j >>>= 8 - (this.f10037d % 8);
                    for (i = this.f10036c - 1; i >= 0; i--) {
                        bArr[i] = (byte) ((int) (255 & j));
                        j >>>= 8;
                    }
                }
            }
        }
        return bArr;
    }
}
