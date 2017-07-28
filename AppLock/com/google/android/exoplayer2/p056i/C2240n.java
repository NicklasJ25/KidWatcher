package com.google.android.exoplayer2.p056i;

import com.google.android.exoplayer2.p056i.C2237p.C2239a;

public final class C2240n implements C2239a {
    private final String f6387a;
    private final C2233r<? super C2222f> f6388b;
    private final int f6389c;
    private final int f6390d;
    private final boolean f6391e;

    public C2240n(String str, C2233r<? super C2222f> c2233r) {
        this(str, c2233r, 8000, 8000, false);
    }

    public C2240n(String str, C2233r<? super C2222f> c2233r, int i, int i2, boolean z) {
        this.f6387a = str;
        this.f6388b = c2233r;
        this.f6389c = i;
        this.f6390d = i2;
        this.f6391e = z;
    }

    public /* synthetic */ C2222f mo3106a() {
        return m6996b();
    }

    public C2238m m6996b() {
        return new C2238m(this.f6387a, null, this.f6388b, this.f6389c, this.f6390d, this.f6391e);
    }
}
