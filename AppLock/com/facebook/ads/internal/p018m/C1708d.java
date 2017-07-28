package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.android.gallery3d.data.MediaSet;
import com.facebook.ads.internal.p018m.C1708d;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1696u;
import com.facebook.ads.internal.view.p035c.p036a.C1701m;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import com.facebook.ads.internal.view.p035c.p036a.C1771p;
import com.facebook.ads.internal.view.p035c.p036a.C1772q;
import com.facebook.ads.internal.view.p035c.p036a.C1773r;
import com.facebook.ads.internal.view.p035c.p036a.C1775t;
import com.facebook.ads.internal.view.p035c.p036a.C1776v;
import com.facebook.ads.internal.view.p035c.p036a.C1777w;

public class C1708d extends C1707i {
    public int f4268a;
    private final C1696u f4269b = new C16971(this);
    private final C1511s<C1772q> f4270c = new C17036(this);
    private final C1511s<C1764h> f4271d = new C17047(this);
    private final C1511s<C1766j> f4272e = new C17058(this);
    private final C1511s<C1769n> f4273f = new C17069(this);
    private final C1511s<C1758b> f4274g = new C1511s<C1758b>(this) {
        final /* synthetic */ C1708d f4244a;

        {
            this.f4244a = r1;
        }

        public Class<C1758b> mo2709a() {
            return C1758b.class;
        }

        public void m4857a(C1758b c1758b) {
            int currentPosition = this.f4244a.f4280m.getCurrentPosition();
            if (this.f4244a.f4268a > 0 && currentPosition == this.f4244a.f4280m.getDuration() && this.f4244a.f4280m.getDuration() > this.f4244a.f4268a) {
                return;
            }
            if (!(currentPosition == 0 && this.f4244a.f4280m.mo2823b()) && this.f4244a.f4280m.getDuration() >= currentPosition + MediaSet.MEDIAITEM_BATCH_FETCH_COUNT) {
                this.f4244a.m4900b(currentPosition);
            } else {
                this.f4244a.m4900b(this.f4244a.f4280m.getDuration());
            }
        }
    };
    private final C1511s<C1771p> f4275h = new C1511s<C1771p>(this) {
        final /* synthetic */ C1708d f4245a;

        {
            this.f4245a = r1;
        }

        public Class<C1771p> mo2709a() {
            return C1771p.class;
        }

        public void m4860a(C1771p c1771p) {
            this.f4245a.m4898a(c1771p.m5046a(), c1771p.m5047b());
        }
    };
    private final C1511s<C1776v> f4276i = new C16982(this);
    private final C1511s<C1777w> f4277j = new C16993(this);
    private final C1511s<C1773r> f4278k = new C17004(this);
    private final C1701m f4279l = new C17025(this);
    private final C1864k f4280m;
    private boolean f4281n = false;

    class C16971 extends C1696u {
        static final /* synthetic */ boolean f4246a = (!C1708d.class.desiredAssertionStatus());
        final /* synthetic */ C1708d f4247b;

        C16971(C1708d c1708d) {
            this.f4247b = c1708d;
        }

        public void m4863a(C1775t c1775t) {
            if (!f4246a && this.f4247b == null) {
                throw new AssertionError();
            } else if (this.f4247b != null) {
                this.f4247b.m4903e();
            }
        }
    }

    class C16982 extends C1511s<C1776v> {
        final /* synthetic */ C1708d f4248a;

        C16982(C1708d c1708d) {
            this.f4248a = c1708d;
        }

        public Class<C1776v> mo2709a() {
            return C1776v.class;
        }

        public void m4866a(C1776v c1776v) {
            this.f4248a.m4899b();
        }
    }

    class C16993 extends C1511s<C1777w> {
        final /* synthetic */ C1708d f4249a;

        C16993(C1708d c1708d) {
            this.f4249a = c1708d;
        }

        public Class<C1777w> mo2709a() {
            return C1777w.class;
        }

        public void m4869a(C1777w c1777w) {
            this.f4249a.m4901c();
        }
    }

    class C17004 extends C1511s<C1773r> {
        final /* synthetic */ C1708d f4250a;

        C17004(C1708d c1708d) {
            this.f4250a = c1708d;
        }

        public Class<C1773r> mo2709a() {
            return C1773r.class;
        }

        public void m4872a(C1773r c1773r) {
            this.f4250a.m4898a(this.f4250a.m4910l(), this.f4250a.m4910l());
        }
    }

    class C17025 extends C1701m {
        final /* synthetic */ C1708d f4251a;

        C17025(C1708d c1708d) {
            this.f4251a = c1708d;
        }

        public void m4875a(C1768l c1768l) {
            this.f4251a.f4268a = this.f4251a.f4280m.getDuration();
        }
    }

    class C17036 extends C1511s<C1772q> {
        static final /* synthetic */ boolean f4252a = (!C1708d.class.desiredAssertionStatus());
        final /* synthetic */ C1708d f4253b;

        C17036(C1708d c1708d) {
            this.f4253b = c1708d;
        }

        public Class<C1772q> mo2709a() {
            return C1772q.class;
        }

        public void m4878a(C1772q c1772q) {
            if (!f4252a && this.f4253b == null) {
                throw new AssertionError();
            } else if (this.f4253b != null) {
                this.f4253b.m4906h();
            }
        }
    }

    class C17047 extends C1511s<C1764h> {
        static final /* synthetic */ boolean f4254a = (!C1708d.class.desiredAssertionStatus());
        final /* synthetic */ C1708d f4255b;

        C17047(C1708d c1708d) {
            this.f4255b = c1708d;
        }

        public Class<C1764h> mo2709a() {
            return C1764h.class;
        }

        public void m4881a(C1764h c1764h) {
            if (!f4254a && this.f4255b == null) {
                throw new AssertionError();
            } else if (this.f4255b != null) {
                this.f4255b.m4907i();
            }
        }
    }

    class C17058 extends C1511s<C1766j> {
        static final /* synthetic */ boolean f4256a = (!C1708d.class.desiredAssertionStatus());
        final /* synthetic */ C1708d f4257b;

        C17058(C1708d c1708d) {
            this.f4257b = c1708d;
        }

        public Class<C1766j> mo2709a() {
            return C1766j.class;
        }

        public void m4884a(C1766j c1766j) {
            if (!f4256a && this.f4257b == null) {
                throw new AssertionError();
            } else if (this.f4257b != null) {
                if (this.f4257b.f4281n) {
                    this.f4257b.m4908j();
                } else {
                    this.f4257b.f4281n = true;
                }
            }
        }
    }

    class C17069 extends C1511s<C1769n> {
        final /* synthetic */ C1708d f4258a;

        C17069(C1708d c1708d) {
            this.f4258a = c1708d;
        }

        public Class<C1769n> mo2709a() {
            return C1769n.class;
        }

        public void m4887a(C1769n c1769n) {
            if (this.f4258a.f4268a <= 0 || this.f4258a.f4280m.getCurrentPosition() != this.f4258a.f4280m.getDuration() || this.f4258a.f4280m.getDuration() <= this.f4258a.f4268a) {
                this.f4258a.m4897a(this.f4258a.f4280m.getCurrentPosition());
            }
        }
    }

    public C1708d(Context context, C1597f c1597f, C1864k c1864k, String str) {
        super(context, c1597f, c1864k, str);
        this.f4280m = c1864k;
        c1864k.getEventBus().m4513a(this.f4269b);
        c1864k.getEventBus().m4513a(this.f4273f);
        c1864k.getEventBus().m4513a(this.f4270c);
        c1864k.getEventBus().m4513a(this.f4272e);
        c1864k.getEventBus().m4513a(this.f4271d);
        c1864k.getEventBus().m4513a(this.f4274g);
        c1864k.getEventBus().m4513a(this.f4275h);
        c1864k.getEventBus().m4513a(this.f4276i);
        c1864k.getEventBus().m4513a(this.f4277j);
        c1864k.getEventBus().m4513a(this.f4279l);
        c1864k.getEventBus().m4513a(this.f4278k);
    }

    public C1708d(Context context, C1597f c1597f, C1864k c1864k, String str, @Nullable Bundle bundle) {
        super(context, c1597f, c1864k, str, bundle);
        this.f4280m = c1864k;
        c1864k.getEventBus().m4513a(this.f4269b);
        c1864k.getEventBus().m4513a(this.f4273f);
        c1864k.getEventBus().m4513a(this.f4270c);
        c1864k.getEventBus().m4513a(this.f4272e);
        c1864k.getEventBus().m4513a(this.f4271d);
        c1864k.getEventBus().m4513a(this.f4274g);
        c1864k.getEventBus().m4513a(this.f4276i);
        c1864k.getEventBus().m4513a(this.f4277j);
        c1864k.getEventBus().m4513a(this.f4278k);
    }

    public void m4914a() {
        this.f4280m.getEventBus().m4514b(this.f4269b);
        this.f4280m.getEventBus().m4514b(this.f4273f);
        this.f4280m.getEventBus().m4514b(this.f4270c);
        this.f4280m.getEventBus().m4514b(this.f4272e);
        this.f4280m.getEventBus().m4514b(this.f4271d);
        this.f4280m.getEventBus().m4514b(this.f4274g);
        this.f4280m.getEventBus().m4514b(this.f4276i);
        this.f4280m.getEventBus().m4514b(this.f4277j);
        this.f4280m.getEventBus().m4514b(this.f4279l);
        this.f4280m.getEventBus().m4514b(this.f4278k);
    }
}
