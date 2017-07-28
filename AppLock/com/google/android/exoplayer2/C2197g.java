package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C2129e.C1841a;
import com.google.android.exoplayer2.C2129e.C2116c;
import com.google.android.exoplayer2.C2150p.C2299a;
import com.google.android.exoplayer2.C2150p.C2300b;
import com.google.android.exoplayer2.C2218h.C2199b;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p055f.C2145d;
import com.google.android.exoplayer2.p063h.C2208h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class C2197g implements C2129e {
    private final Handler f6193a;
    private final C2218h<?> f6194b;
    private final CopyOnWriteArraySet<C1841a> f6195c;
    private final C2300b f6196d;
    private final C2299a f6197e;
    private boolean f6198f;
    private boolean f6199g;
    private int f6200h;
    private int f6201i;
    private boolean f6202j;
    private C2150p f6203k;
    private Object f6204l;
    private C2199b f6205m;
    private int f6206n;
    private long f6207o;

    class C21551 extends Handler {
        final /* synthetic */ C2197g f6031a;

        C21551(C2197g c2197g) {
            this.f6031a = c2197g;
        }

        public void handleMessage(Message message) {
            this.f6031a.m6829a(message);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public C2197g(C1947m[] c1947mArr, C2208h<?> c2208h, C2096j c2096j) {
        Log.i("ExoPlayerImpl", "Init 2.0.3");
        C2252a.m7020a((Object) c1947mArr);
        C2252a.m7024b(c1947mArr.length > 0);
        this.f6199g = false;
        this.f6200h = 1;
        this.f6195c = new CopyOnWriteArraySet();
        this.f6196d = new C2300b();
        this.f6197e = new C2299a();
        this.f6193a = new C21551(this);
        this.f6205m = new C2199b(0, 0);
        this.f6194b = new C2218h(c1947mArr, c2208h, c2096j, this.f6199g, this.f6193a, this.f6205m);
    }

    public int mo3066a() {
        return this.f6200h;
    }

    public void mo3067a(int i) {
        if (this.f6203k == null) {
            this.f6206n = i;
            this.f6207o = -9223372036854775807L;
            this.f6198f = true;
            return;
        }
        C2252a.m7019a(i, 0, this.f6203k.mo3039a());
        this.f6201i++;
        this.f6206n = i;
        this.f6207o = 0;
        this.f6194b.m6933a(this.f6203k.m6565a(i, this.f6196d).f6593f, -9223372036854775807L);
    }

    public void m6827a(int i, long j) {
        if (j == -9223372036854775807L) {
            mo3067a(i);
        } else if (this.f6203k == null) {
            this.f6206n = i;
            this.f6207o = j;
            this.f6198f = true;
        } else {
            C2252a.m7019a(i, 0, this.f6203k.mo3039a());
            this.f6201i++;
            this.f6206n = i;
            this.f6207o = j;
            this.f6203k.m6565a(i, this.f6196d);
            int i2 = this.f6196d.f6593f;
            long c = this.f6196d.m7277c() + j;
            long a = this.f6203k.m6563a(i2, this.f6197e).m7270a();
            while (a != -9223372036854775807L && c >= a && i2 < this.f6196d.f6594g) {
                c -= a;
                i2++;
                a = this.f6203k.m6563a(i2, this.f6197e).m7270a();
            }
            this.f6194b.m6933a(i2, C1961b.m5733b(c));
            Iterator it = this.f6195c.iterator();
            while (it.hasNext()) {
                ((C1841a) it.next()).mo2795e();
            }
        }
    }

    public void mo3068a(long j) {
        m6827a(mo3080g(), j);
    }

    void m6829a(Message message) {
        Iterator it;
        switch (message.what) {
            case 1:
                this.f6200h = message.arg1;
                it = this.f6195c.iterator();
                while (it.hasNext()) {
                    ((C1841a) it.next()).mo2790a(this.f6199g, this.f6200h);
                }
                return;
            case 2:
                this.f6202j = message.arg1 != 0;
                it = this.f6195c.iterator();
                while (it.hasNext()) {
                    ((C1841a) it.next()).mo2792b(this.f6202j);
                }
                return;
            case 3:
                int i = this.f6201i - 1;
                this.f6201i = i;
                if (i == 0) {
                    this.f6205m = (C2199b) message.obj;
                    it = this.f6195c.iterator();
                    while (it.hasNext()) {
                        ((C1841a) it.next()).mo2795e();
                    }
                    return;
                }
                return;
            case 4:
                if (this.f6201i == 0) {
                    this.f6205m = (C2199b) message.obj;
                    it = this.f6195c.iterator();
                    while (it.hasNext()) {
                        ((C1841a) it.next()).mo2795e();
                    }
                    return;
                }
                return;
            case 5:
                Pair pair = (Pair) message.obj;
                this.f6203k = (C2150p) pair.first;
                this.f6204l = pair.second;
                if (this.f6198f) {
                    this.f6198f = false;
                    m6827a(this.f6206n, this.f6207o);
                }
                it = this.f6195c.iterator();
                while (it.hasNext()) {
                    ((C1841a) it.next()).mo2788a(this.f6203k, this.f6204l);
                }
                return;
            case 6:
                C2109d c2109d = (C2109d) message.obj;
                Iterator it2 = this.f6195c.iterator();
                while (it2.hasNext()) {
                    ((C1841a) it2.next()).mo2787a(c2109d);
                }
                return;
            default:
                return;
        }
    }

    public void mo3069a(C1841a c1841a) {
        this.f6195c.add(c1841a);
    }

    public void mo3070a(C2145d c2145d) {
        m6832a(c2145d, true, true);
    }

    public void m6832a(C2145d c2145d, boolean z, boolean z2) {
        if (z2 && !(this.f6203k == null && this.f6204l == null)) {
            this.f6203k = null;
            this.f6204l = null;
            Iterator it = this.f6195c.iterator();
            while (it.hasNext()) {
                ((C1841a) it.next()).mo2788a(null, null);
            }
        }
        this.f6194b.m6935a(c2145d, z);
    }

    public void mo3071a(boolean z) {
        if (this.f6199g != z) {
            this.f6199g = z;
            this.f6194b.m6938a(z);
            Iterator it = this.f6195c.iterator();
            while (it.hasNext()) {
                ((C1841a) it.next()).mo2790a(z, this.f6200h);
            }
        }
    }

    public void mo3072a(C2116c... c2116cArr) {
        this.f6194b.m6939a(c2116cArr);
    }

    public void mo3073b(C1841a c1841a) {
        this.f6195c.remove(c1841a);
    }

    public void mo3074b(C2116c... c2116cArr) {
        this.f6194b.m6942b(c2116cArr);
    }

    public boolean mo3075b() {
        return this.f6199g;
    }

    public void mo3076c() {
        mo3067a(mo3080g());
    }

    public void mo3077d() {
        this.f6194b.m6932a();
    }

    public void mo3078e() {
        this.f6194b.m6940b();
        this.f6193a.removeCallbacksAndMessages(null);
    }

    public C2150p mo3079f() {
        return this.f6203k;
    }

    public int mo3080g() {
        return (this.f6203k == null || this.f6201i > 0) ? this.f6206n : this.f6203k.m6563a(this.f6205m.f6226a, this.f6197e).f6585c;
    }

    public long mo3081h() {
        return this.f6203k == null ? -9223372036854775807L : this.f6203k.m6565a(mo3080g(), this.f6196d).m7276b();
    }

    public long mo3082i() {
        if (this.f6203k == null || this.f6201i > 0) {
            return this.f6207o;
        }
        this.f6203k.m6563a(this.f6205m.f6226a, this.f6197e);
        return this.f6197e.m7273c() + C1961b.m5732a(this.f6205m.f6228c);
    }

    public long mo3083j() {
        if (this.f6203k == null || this.f6201i > 0) {
            return this.f6207o;
        }
        this.f6203k.m6563a(this.f6205m.f6226a, this.f6197e);
        return this.f6197e.m7273c() + C1961b.m5732a(this.f6205m.f6229d);
    }

    public int mo3084k() {
        long j = 100;
        if (this.f6203k == null) {
            return 0;
        }
        int i;
        long j2 = mo3083j();
        long h = mo3081h();
        if (j2 == -9223372036854775807L || h == -9223372036854775807L) {
            i = 0;
        } else {
            if (h != 0) {
                j = (100 * j2) / h;
            }
            i = (int) j;
        }
        return i;
    }
}
