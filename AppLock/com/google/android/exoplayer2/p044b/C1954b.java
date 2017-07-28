package com.google.android.exoplayer2.p044b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer2.p043j.C2273r;

public final class C1954b {
    public byte[] f5110a;
    public byte[] f5111b;
    public int f5112c;
    public int[] f5113d;
    public int[] f5114e;
    public int f5115f;
    private final CryptoInfo f5116g;

    public C1954b() {
        this.f5116g = C2273r.f6478a >= 16 ? m5696b() : null;
    }

    @TargetApi(16)
    private CryptoInfo m5696b() {
        return new CryptoInfo();
    }

    @TargetApi(16)
    private void m5697c() {
        this.f5116g.set(this.f5115f, this.f5113d, this.f5114e, this.f5111b, this.f5110a, this.f5112c);
    }

    @TargetApi(16)
    public CryptoInfo m5698a() {
        return this.f5116g;
    }

    public void m5699a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f5115f = i;
        this.f5113d = iArr;
        this.f5114e = iArr2;
        this.f5111b = bArr;
        this.f5110a = bArr2;
        this.f5112c = i2;
        if (C2273r.f6478a >= 16) {
            m5697c();
        }
    }
}
