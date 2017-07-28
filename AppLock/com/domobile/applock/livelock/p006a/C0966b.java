package com.domobile.applock.livelock.p006a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.livelock.p006a.C0962a.C0742a;
import com.domobile.applock.livelock.p014b.C0979d;
import com.domobile.applock.livelock.p014b.C0980e;
import com.domobile.applock.theme.C1102c;
import com.domobile.imagelock.C1318c;
import com.domobile.lockbean.C0965g;
import com.domobile.lockbean.C1375l;

public class C0966b extends C0965g implements C0742a {
    private C0962a f1574t;
    private C0979d f1575u;

    public C0966b(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static boolean m1788a(Context context) {
        return C1150y.m2614c(context, "key_random_numboard") && C1150y.m2539D(context);
    }

    private C0962a m1789e(boolean z) {
        C0962a c0962a = new C0962a(this.h, this.f1575u, mo2469f(), z);
        c0962a.m1745a((C0742a) this);
        c0962a.m1746a(C1318c.m3243a(this.h));
        View h = c0962a.m1735h();
        View findViewById = h.findViewById(R.id.locker_board_more);
        if (findViewById != null) {
            findViewById.setVisibility(4);
            C1102c.m2393a(findViewById, 0, -1, -1, -1);
            C1102c.m2384a(findViewById, 1, -10);
        }
        C1102c.m2387a(this.h, this.h.getResources(), h.findViewById(R.id.locker_board_fingerprint));
        return c0962a;
    }

    public void mo2459a() {
        this.n = this.j.inflate(R.layout.verify, null);
        this.o = m1759a((int) R.id.verify_anim_view);
        this.s = C1102c.m2405e(this.h);
        this.f1575u = C0980e.m1860a(this.h);
        super.mo2459a();
    }

    public void mo2409a(String str) {
        m1784b(str);
    }

    public void mo2460a(String str, boolean z) {
        super.mo2460a(str, z);
        if (this.f1574t != null) {
            this.f1574t.m1750d();
            this.f1574t.m1748b(mo2469f());
            this.f1574t.m1746a(C1318c.m3243a(this.h));
            this.f1574t.m1731a(str);
            this.f1574t.m1742a();
        }
    }

    public void mo2465a(boolean z) {
        if (!this.c) {
            try {
                if (!(this.m == null || this.m.getParent() == null)) {
                    this.k.removeView(this.m);
                }
                if (this.n.getParent() != null) {
                    this.k.removeView(this.n);
                }
                m1767c(z);
                if (this.f1574t != null) {
                    this.f1574t.m1749c();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mo2461a(final boolean z, final boolean z2, final boolean z3, long j) {
        super.mo2461a(z, z2, z3, j);
        this.f.f427b = false;
        this.c = this.f.f427b;
        m1772i();
        if (!this.b && z2) {
            C1150y.m2613c(this.h);
        }
        this.r = z3;
        ((ViewGroup) m1759a((int) R.id.adview_layout)).removeAllViews();
        if (this.n.getParent() == null) {
            m1767c(z3);
        } else if (j != 0 || z || z2) {
            this.n.postDelayed(new Runnable(this) {
                final /* synthetic */ C0966b f1545d;

                public void run() {
                    if (!this.f1545d.c) {
                        View a = this.f1545d.m1759a((int) R.id.fake_view_forground);
                        if (a != null) {
                            a.setVisibility(0);
                        }
                        if (!z || z2) {
                            this.f1545d.mo2465a(z3);
                            return;
                        }
                        this.f1545d.n.setBackgroundColor(0);
                        this.f1545d.o.startAnimation(this.f1545d.e);
                    }
                }
            }, j > 0 ? 400 : 0);
        } else {
            View a = m1759a((int) R.id.fake_view_forground);
            if (a != null) {
                a.setVisibility(0);
            }
            mo2465a(z3);
        }
    }

    public void mo2466b() {
        if (C1150y.m2634i(this.h)) {
            C0933d.m1650a(this.h, this.n.findViewById(R.id.verify_fakeview));
            return;
        }
        C0933d.m1651a(this.h, this.n, false);
        m1771h();
    }

    public void mo2467b(boolean z) {
        if (!(this.m == null || this.m.getParent() == null)) {
            this.k.removeView(this.m);
        }
        this.s = z;
        if (this.f1574t != null) {
            this.f1574t.m1747b();
            this.f1574t = null;
        }
        this.f1574t = m1789e(this.s);
        this.f1574t.m1750d();
        super.mo2467b(z);
        View h = this.f1574t.m1735h();
        ViewGroup viewGroup = (ViewGroup) m1759a((int) R.id.numboard_parent);
        viewGroup.removeAllViews();
        viewGroup.addView(h);
        m1773j();
        this.f1574t.m1731a(this.a);
        this.f1574t.m1742a();
    }

    public void mo2468c() {
        this.i.sendEmptyMessage(106);
        if (this.f.f427b) {
            mo2467b(C1102c.m2405e(this.h));
        }
    }

    public void mo2462d() {
        boolean z = true;
        super.mo2462d();
        if (!this.f.f427b) {
            try {
                this.f.f427b = true;
                this.c = this.f.f427b;
                boolean e = C1102c.m2405e(this.h);
                if (e != this.s) {
                    mo2467b(e);
                }
                if (this.n.getParent() == null) {
                    m1769d(!C1150y.m2594a(this.k, this.n, this.l));
                }
                if (C1375l.m3478a(this.h, this.i, this.n, this.a, this)) {
                    z = false;
                }
                this.d = z;
                if (this.d) {
                    m1771h();
                }
                m1775l();
                if (this.f1574t == null) {
                    this.i.sendEmptyMessageDelayed(104, 100);
                    return;
                }
                m1770g();
                this.f1574t.m1750d();
            } catch (Throwable th) {
                th.printStackTrace();
                this.f.f427b = false;
                this.c = this.f.f427b;
            }
        }
    }

    public void mo2413e() {
        if (!this.b) {
            C1150y.m2613c(this.h);
        }
    }

    public boolean mo2469f() {
        return C0966b.m1788a(this.h);
    }
}
