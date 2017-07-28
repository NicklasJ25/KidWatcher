package com.google.android.exoplayer2.p057g;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C1949a;
import com.google.android.exoplayer2.C2109d;
import com.google.android.exoplayer2.C2251i;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2258h;
import java.util.Collections;
import java.util.List;

public final class C2196k extends C1949a implements Callback {
    private final Handler f6182a;
    private final C2195a f6183b;
    private final C2192h f6184c;
    private final C2251i f6185d;
    private boolean f6186e;
    private boolean f6187f;
    private C2156f f6188g;
    private C2194i f6189h;
    private C2160j f6190i;
    private C2160j f6191j;
    private int f6192k;

    public interface C2195a {
        void mo3120a(List<C2167b> list);
    }

    public C2196k(C2195a c2195a, Looper looper) {
        this(c2195a, looper, C2192h.f6180a);
    }

    public C2196k(C2195a c2195a, Looper looper, C2192h c2192h) {
        super(3);
        this.f6183b = (C2195a) C2252a.m7020a((Object) c2195a);
        this.f6182a = looper == null ? null : new Handler(looper, this);
        this.f6184c = c2192h;
        this.f6185d = new C2251i();
    }

    private void m6814a(List<C2167b> list) {
        if (this.f6182a != null) {
            this.f6182a.obtainMessage(0, list).sendToTarget();
        } else {
            m6815b(list);
        }
    }

    private void m6815b(List<C2167b> list) {
        this.f6183b.mo3120a(list);
    }

    private long m6816t() {
        return (this.f6192k == -1 || this.f6192k >= this.f6190i.mo3053b()) ? Format.OFFSET_SAMPLE_RELATIVE : this.f6190i.mo3052a(this.f6192k);
    }

    private void m6817u() {
        m6814a(Collections.emptyList());
    }

    public int mo2911a(Format format) {
        return this.f6184c.mo3063a(format) ? 3 : C2258h.m7045c(format.f4947e) ? 1 : 0;
    }

    public void mo2912a(long j, long j2) {
        if (!this.f6187f) {
            if (this.f6191j == null) {
                this.f6188g.mo3044a(j);
                try {
                    this.f6191j = (C2160j) this.f6188g.mo2934b();
                } catch (Exception e) {
                    throw C2109d.m6416a(e, m5625p());
                }
            }
            if (mo2902d() == 2) {
                boolean z = false;
                if (this.f6190i != null) {
                    long t = m6816t();
                    while (t <= j) {
                        this.f6192k++;
                        t = m6816t();
                        z = true;
                    }
                }
                if (this.f6191j != null) {
                    if (this.f6191j.m5694c()) {
                        if (!z && m6816t() == Format.OFFSET_SAMPLE_RELATIVE) {
                            if (this.f6190i != null) {
                                this.f6190i.mo3055d();
                                this.f6190i = null;
                            }
                            this.f6191j.mo3055d();
                            this.f6191j = null;
                            this.f6187f = true;
                        }
                    } else if (this.f6191j.a <= j) {
                        if (this.f6190i != null) {
                            this.f6190i.mo3055d();
                        }
                        this.f6190i = this.f6191j;
                        this.f6191j = null;
                        this.f6192k = this.f6190i.mo3051a(j);
                        z = true;
                    }
                }
                if (z) {
                    m6814a(this.f6190i.mo3054b(j));
                }
                while (!this.f6186e) {
                    if (this.f6189h == null) {
                        this.f6189h = (C2194i) this.f6188g.mo2932a();
                        if (this.f6189h == null) {
                            return;
                        }
                    }
                    int a = m5601a(this.f6185d, this.f6189h);
                    if (a == -4) {
                        this.f6189h.m5693c(Integer.MIN_VALUE);
                        if (this.f6189h.m5694c()) {
                            this.f6186e = true;
                        } else {
                            try {
                                this.f6189h.f6181d = this.f6185d.f6414a.f4963u;
                                this.f6189h.m5709e();
                            } catch (Exception e2) {
                                throw C2109d.m6416a(e2, m5625p());
                            }
                        }
                        this.f6188g.mo2933a(this.f6189h);
                        this.f6189h = null;
                    } else if (a == -3) {
                        return;
                    }
                }
            }
        }
    }

    protected void mo2913a(long j, boolean z) {
        this.f6186e = false;
        this.f6187f = false;
        if (this.f6190i != null) {
            this.f6190i.mo3055d();
            this.f6190i = null;
        }
        if (this.f6191j != null) {
            this.f6191j.mo3055d();
            this.f6191j = null;
        }
        this.f6189h = null;
        m6817u();
        this.f6188g.mo2935c();
    }

    protected void mo3065a(Format[] formatArr) {
        if (this.f6188g != null) {
            this.f6188g.mo2936d();
            this.f6189h = null;
        }
        this.f6188g = this.f6184c.mo3064b(formatArr[0]);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m6815b((List) message.obj);
                return true;
            default:
                return false;
        }
    }

    protected void mo2917o() {
        if (this.f6190i != null) {
            this.f6190i.mo3055d();
            this.f6190i = null;
        }
        if (this.f6191j != null) {
            this.f6191j.mo3055d();
            this.f6191j = null;
        }
        this.f6188g.mo2936d();
        this.f6188g = null;
        this.f6189h = null;
        m6817u();
        super.mo2917o();
    }

    public boolean mo2918r() {
        return true;
    }

    public boolean mo2919s() {
        return this.f6187f;
    }
}
