package com.google.android.exoplayer2.p057g.p061d;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2164c;
import com.google.android.exoplayer2.p057g.C2167b;

public final class C2175a extends C2164c {
    private final C2263k f6117a = new C2263k();

    public C2175a() {
        super("Tx3gDecoder");
    }

    protected C2159e mo3062a(byte[] bArr, int i) {
        this.f6117a.m7068a(bArr, i);
        int h = this.f6117a.m7080h();
        return h == 0 ? C2176b.f6118a : new C2176b(new C2167b(this.f6117a.m7077e(h)));
    }
}
