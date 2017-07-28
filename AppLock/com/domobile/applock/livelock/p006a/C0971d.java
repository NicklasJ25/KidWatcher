package com.domobile.applock.livelock.p006a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.livelock.p014b.C0979d;
import com.domobile.applock.livelock.p014b.C0980e;
import com.domobile.applock.livelock.view.LivePatternView;
import com.domobile.applock.theme.C1102c;
import com.domobile.imagelock.C1318c;
import com.domobile.imagelock.LockPatternView.C0950c;
import com.domobile.imagelock.LockPatternView.C1308a;
import com.domobile.lockbean.C0970h;
import com.domobile.lockbean.C1375l;
import java.util.List;

public class C0971d extends C0970h {
    private C0979d f1588t;
    private C1318c f1589u;
    private C0967c f1590v;
    private LivePatternView f1591w;
    private C0950c f1592x = new C09692(this);

    class C09692 implements C0950c {
        final /* synthetic */ C0971d f1585a;

        C09692(C0971d c0971d) {
            this.f1585a = c0971d;
        }

        public void mo2450a() {
            if (this.f1585a.f1591w != null) {
                this.f1585a.f1591w.m1973e();
            }
        }

        public void mo2451a(List<C1308a> list) {
            if (this.f1585a.f1589u == null || !this.f1585a.f1589u.m3246a((List) list)) {
                if (this.f1585a.f1591w != null) {
                    this.f1585a.f1591w.setDisplayMode(1);
                    this.f1585a.f1591w.m1972d();
                }
                this.f1585a.mo2464o();
                return;
            }
            this.f1585a.mo2463n();
            this.f1585a.f1591w.m1972d();
        }

        public void mo2452b() {
            if (this.f1585a.f1591w != null) {
                this.f1585a.f1591w.m1973e();
            }
        }

        public void mo2453b(List<C1308a> list) {
        }
    }

    public C0971d(Context context, String str, boolean z) {
        super(context, str, z);
    }

    private C0967c m1821e(boolean z) {
        C0967c c0967c = new C0967c(this.h, this.f1588t, z);
        this.f1591w = c0967c.m1802a();
        this.f1591w.setOnPatternListener(this.f1592x);
        this.f1591w.setTactileFeedbackEnabled(C1318c.m3243a(this.h));
        this.f1591w.m1971c();
        View h = c0967c.m1735h();
        View findViewById = h.findViewById(R.id.pattern_board_change_to_number_lock_button);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        findViewById = h.findViewById(R.id.locker_board_more);
        if (findViewById != null) {
            findViewById.setVisibility(4);
            C1102c.m2393a(findViewById, 0, -1, -1, -1);
            C1102c.m2384a(findViewById, 1, -10);
        }
        C1102c.m2387a(this.h, this.h.getResources(), h.findViewById(R.id.locker_board_fingerprint));
        C1102c.m2387a(this.h, this.h.getResources(), h.findViewById(R.id.pattern_board_patternview));
        return c0967c;
    }

    public void mo2459a() {
        this.f1589u = new C1318c(this.h);
        this.n = this.j.inflate(R.layout.pattern_lock_port, null);
        this.o = m1759a((int) R.id.pattern_lock_animview);
        this.s = C1102c.m2405e(this.h);
        this.f1588t = C0980e.m1860a(this.h);
        super.mo2459a();
    }

    public void mo2460a(String str, boolean z) {
        super.mo2460a(str, z);
        if (this.f1590v != null) {
            this.f1590v.m1802a().m1971c();
            this.f1590v.m1731a(str);
            this.f1590v.m1804b();
        }
    }

    public void mo2465a(boolean z) {
        if (!this.c) {
            try {
                if (this.f1590v != null) {
                    this.f1590v.m1802a().m1971c();
                }
                if (!(this.m == null || this.m.getParent() == null)) {
                    this.k.removeView(this.m);
                }
                if (this.n.getParent() != null) {
                    this.k.removeView(this.n);
                }
                m1767c(z);
                if (this.f1590v != null) {
                    this.f1590v.m1806d();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mo2461a(final boolean z, final boolean z2, final boolean z3, long j) {
        super.mo2461a(z, z2, z3, j);
        this.f.f426a = false;
        this.c = this.f.f426a;
        if (!this.b && z2) {
            C1150y.m2613c(this.h);
        }
        m1772i();
        this.r = z3;
        ((ViewGroup) m1759a((int) R.id.adview_layout)).removeAllViews();
        if (this.n.getParent() == null) {
            m1767c(z3);
        } else if (j != 0 || z || z2) {
            this.n.postDelayed(new Runnable(this) {
                final /* synthetic */ C0971d f1584d;

                public void run() {
                    if (!this.f1584d.c) {
                        View a = this.f1584d.m1759a((int) R.id.fake_view_forground);
                        if (a != null) {
                            a.setVisibility(0);
                        }
                        if (!z || z2) {
                            this.f1584d.mo2465a(z3);
                            return;
                        }
                        this.f1584d.n.setBackgroundColor(0);
                        if (this.f1584d.o == null || this.f1584d.e == null) {
                            this.f1584d.mo2465a(z3);
                            return;
                        }
                        this.f1584d.o.startAnimation(this.f1584d.e);
                        this.f1584d.m1776m();
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
        if (this.f1590v != null) {
            this.f1590v.m1805c();
            this.f1590v = null;
        }
        this.f1590v = m1821e(this.s);
        super.mo2467b(z);
        View h = this.f1590v.m1735h();
        ViewGroup viewGroup = (ViewGroup) m1759a((int) R.id.pattern_board_container);
        viewGroup.removeAllViews();
        viewGroup.addView(h);
        m1773j();
        this.f1590v.m1731a(this.a);
        this.f1590v.m1804b();
    }

    public void mo2468c() {
        if (this.f.f426a) {
            mo2467b(C1102c.m2405e(this.h));
        }
    }

    public void mo2462d() {
        boolean z = true;
        super.mo2462d();
        if (!this.f.f426a) {
            try {
                this.f.f426a = true;
                this.c = this.f.f426a;
                boolean e = C1102c.m2405e(this.h);
                if (e != this.s) {
                    mo2467b(e);
                }
                if (this.n.getParent() == null) {
                    m1769d(!C1150y.m2594a(this.k, this.n, this.l));
                }
                if (this.f1590v == null) {
                    this.i.sendEmptyMessageDelayed(104, 100);
                } else {
                    m1770g();
                }
                if (C1375l.m3478a(this.h, this.i, this.n, this.a, this)) {
                    z = false;
                }
                this.d = z;
                if (this.d) {
                    m1771h();
                }
                m1775l();
            } catch (Throwable th) {
                th.printStackTrace();
                this.f.f426a = false;
                this.c = this.f.f426a;
            }
        }
    }
}
