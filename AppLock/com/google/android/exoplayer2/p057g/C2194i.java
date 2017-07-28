package com.google.android.exoplayer2.p057g;

import com.google.android.exoplayer2.p044b.C1957e;

public final class C2194i extends C1957e implements Comparable<C2194i> {
    public long f6181d;

    public C2194i() {
        super(1);
    }

    public int m6812a(C2194i c2194i) {
        long j = this.c - c2194i.c;
        return j == 0 ? 0 : j > 0 ? 1 : -1;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m6812a((C2194i) obj);
    }
}
