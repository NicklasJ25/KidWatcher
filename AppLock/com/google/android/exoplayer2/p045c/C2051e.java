package com.google.android.exoplayer2.p045c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import java.io.EOFException;

public final class C2051e implements C2025o {
    public int mo2976a(C1985g c1985g, int i, boolean z) {
        int a = c1985g.mo2959a(i);
        if (a != -1) {
            return a;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void mo2977a(long j, int i, int i2, int i3, byte[] bArr) {
    }

    public void mo2978a(Format format) {
    }

    public void mo2979a(C2263k c2263k, int i) {
        c2263k.m7075d(i);
    }
}
