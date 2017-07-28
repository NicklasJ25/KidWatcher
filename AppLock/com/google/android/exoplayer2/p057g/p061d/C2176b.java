package com.google.android.exoplayer2.p057g.p061d;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.Collections;
import java.util.List;

final class C2176b implements C2159e {
    public static final C2176b f6118a = new C2176b();
    private final List<C2167b> f6119b;

    private C2176b() {
        this.f6119b = Collections.emptyList();
    }

    public C2176b(C2167b c2167b) {
        this.f6119b = Collections.singletonList(c2167b);
    }

    public int mo3051a(long j) {
        return j < 0 ? 0 : -1;
    }

    public long mo3052a(int i) {
        C2252a.m7022a(i == 0);
        return 0;
    }

    public int mo3053b() {
        return 1;
    }

    public List<C2167b> mo3054b(long j) {
        return j >= 0 ? this.f6119b : Collections.emptyList();
    }
}
