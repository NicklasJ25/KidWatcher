package com.google.android.exoplayer2.p057g.p062e;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.Collections;
import java.util.List;

final class C2180c implements C2159e {
    private final List<C2167b> f6129a;

    public C2180c(List<C2167b> list) {
        this.f6129a = Collections.unmodifiableList(list);
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
        return j >= 0 ? this.f6129a : Collections.emptyList();
    }
}
