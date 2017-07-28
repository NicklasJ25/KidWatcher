package com.google.android.exoplayer2.p056i;

import android.content.Context;
import com.google.android.exoplayer2.p056i.C2222f.C2228a;

public final class C2236l implements C2228a {
    private final Context f6366a;
    private final C2233r<? super C2222f> f6367b;
    private final C2228a f6368c;

    public C2236l(Context context, C2233r<? super C2222f> c2233r, C2228a c2228a) {
        this.f6366a = context.getApplicationContext();
        this.f6367b = c2233r;
        this.f6368c = c2228a;
    }

    public C2236l(Context context, String str, C2233r<? super C2222f> c2233r) {
        this(context, (C2233r) c2233r, new C2240n(str, c2233r));
    }

    public /* synthetic */ C2222f mo3106a() {
        return m6982b();
    }

    public C2235k m6982b() {
        return new C2235k(this.f6366a, this.f6367b, this.f6368c.mo3106a());
    }
}
