package com.google.android.exoplayer2.p056i;

import android.content.Context;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;

public final class C2235k implements C2222f {
    private final C2222f f6361a;
    private final C2222f f6362b;
    private final C2222f f6363c;
    private final C2222f f6364d;
    private C2222f f6365e;

    public C2235k(Context context, C2233r<? super C2222f> c2233r, C2222f c2222f) {
        this.f6361a = (C2222f) C2252a.m7020a((Object) c2222f);
        this.f6362b = new C2242o(c2233r);
        this.f6363c = new C2223c(context, c2233r);
        this.f6364d = new C2227e(context, c2233r);
    }

    public int mo3094a(byte[] bArr, int i, int i2) {
        return this.f6365e.mo3094a(bArr, i, i2);
    }

    public long mo3095a(C2230h c2230h) {
        C2252a.m7024b(this.f6365e == null);
        String scheme = c2230h.f6333a.getScheme();
        if (C2273r.m7134a(c2230h.f6333a)) {
            if (c2230h.f6333a.getPath().startsWith("/android_asset/")) {
                this.f6365e = this.f6363c;
            } else {
                this.f6365e = this.f6362b;
            }
        } else if ("asset".equals(scheme)) {
            this.f6365e = this.f6363c;
        } else if ("content".equals(scheme)) {
            this.f6365e = this.f6364d;
        } else {
            this.f6365e = this.f6361a;
        }
        return this.f6365e.mo3095a(c2230h);
    }

    public void mo3096a() {
        if (this.f6365e != null) {
            try {
                this.f6365e.mo3096a();
            } finally {
                this.f6365e = null;
            }
        }
    }
}
