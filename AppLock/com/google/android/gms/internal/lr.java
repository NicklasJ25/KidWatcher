package com.google.android.gms.internal;

public class lr {
    private final byte[] f9720a = new byte[256];
    private int f9721b;
    private int f9722c;

    public lr(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.f9720a[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            i = ((i + this.f9720a[i2]) + bArr[i2 % bArr.length]) & 255;
            byte b = this.f9720a[i2];
            this.f9720a[i2] = this.f9720a[i];
            this.f9720a[i] = b;
        }
        this.f9721b = 0;
        this.f9722c = 0;
    }

    public void m12329a(byte[] bArr) {
        int i = this.f9721b;
        int i2 = this.f9722c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f9720a[i]) & 255;
            byte b = this.f9720a[i];
            this.f9720a[i] = this.f9720a[i2];
            this.f9720a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f9720a[(this.f9720a[i] + this.f9720a[i2]) & 255]);
        }
        this.f9721b = i;
        this.f9722c = i2;
    }
}
