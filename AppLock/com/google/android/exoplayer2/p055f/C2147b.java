package com.google.android.exoplayer2.p055f;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.C2150p;
import com.google.android.exoplayer2.C2150p.C2299a;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p055f.C2145d.C2146a;
import com.google.android.exoplayer2.p056i.C2220b;
import com.google.android.exoplayer2.p056i.C2222f.C2228a;
import java.io.IOException;

public final class C2147b implements C2145d, C2146a {
    private final Uri f6008a;
    private final C2228a f6009b;
    private final C1964i f6010c;
    private final int f6011d;
    private final Handler f6012e;
    private final C2143a f6013f;
    private final C2299a f6014g;
    private C2146a f6015h;
    private C2150p f6016i;
    private boolean f6017j;

    public interface C2143a {
        void m6546a(IOException iOException);
    }

    public static final class C2144b extends C1970k {
        public C2144b(C1966f[] c1966fArr) {
            super("None of the available extractors (" + C2273r.m7131a((Object[]) c1966fArr) + ") could read the stream.");
        }
    }

    public C2147b(Uri uri, C2228a c2228a, C1964i c1964i, int i, Handler handler, C2143a c2143a) {
        this.f6008a = uri;
        this.f6009b = c2228a;
        this.f6010c = c1964i;
        this.f6011d = i;
        this.f6012e = handler;
        this.f6013f = c2143a;
        this.f6014g = new C2299a();
    }

    public C2147b(Uri uri, C2228a c2228a, C1964i c1964i, Handler handler, C2143a c2143a) {
        this(uri, c2228a, c1964i, -1, handler, c2143a);
    }

    public C2140c mo3033a(int i, C2220b c2220b, long j) {
        C2252a.m7022a(i == 0);
        return new C2142a(this.f6008a, this.f6009b.mo3106a(), this.f6010c.mo2939a(), this.f6011d, this.f6012e, this.f6013f, this, c2220b);
    }

    public void mo3034a() {
    }

    public void mo3035a(C2140c c2140c) {
        ((C2142a) c2140c).m6538b();
    }

    public void mo3036a(C2146a c2146a) {
        this.f6015h = c2146a;
        this.f6016i = new C2151g(-9223372036854775807L, false);
        c2146a.mo3037a(this.f6016i, null);
    }

    public void mo3037a(C2150p c2150p, Object obj) {
        boolean z = false;
        if (c2150p.m6563a(0, this.f6014g).m7272b() != -9223372036854775807L) {
            z = true;
        }
        if (!this.f6017j || z) {
            this.f6016i = c2150p;
            this.f6017j = z;
            this.f6015h.mo3037a(this.f6016i, null);
        }
    }

    public void mo3038b() {
        this.f6015h = null;
    }
}
