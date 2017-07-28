package com.domobile.lockbean;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.theme.C1102c;
import com.domobile.imagelock.C1318c;
import com.domobile.imagelock.LinearLayoutWithDefaultTouchRecepient;
import com.domobile.imagelock.LockPatternView;
import com.domobile.imagelock.LockPatternView.C0950c;
import com.domobile.imagelock.LockPatternView.C1308a;
import com.domobile.imagelock.LockPatternView.C1309b;
import java.util.List;

public class C1381n extends C0970h implements OnClickListener {
    private C1376m f3004t;
    private C1376m f3005u;
    private C1376m f3006v;
    private LockPatternView f3007w;
    private C1318c f3008x;
    private View f3009y;
    private C0950c f3010z = new C13771(this);

    class C13771 implements C0950c {
        final /* synthetic */ C1381n f2994a;

        C13771(C1381n c1381n) {
            this.f2994a = c1381n;
        }

        public void mo2450a() {
            if (this.f2994a.f3007w != null) {
                this.f2994a.f3007w.m3212e();
            }
        }

        public void mo2451a(List<C1308a> list) {
            if (this.f2994a.f3008x == null || !this.f2994a.f3008x.m3246a((List) list)) {
                if (this.f2994a.f3007w != null) {
                    this.f2994a.m3504a(C1380a.NeedToUnlockWrong);
                    this.f2994a.f3007w.m3211d();
                }
                this.f2994a.mo2464o();
                return;
            }
            this.f2994a.mo2463n();
            this.f2994a.f3007w.m3211d();
        }

        public void mo2452b() {
            if (this.f2994a.f3007w != null) {
                this.f2994a.f3007w.m3212e();
            }
        }

        public void mo2453b(List<C1308a> list) {
        }
    }

    private enum C1380a {
        NeedToUnlock,
        NeedToUnlockWrong,
        LockedOut
    }

    public C1381n(Context context, String str, boolean z) {
        super(context, str, z);
    }

    private void m3504a(C1380a c1380a) {
        if (this.f3007w != null) {
            switch (c1380a) {
                case NeedToUnlock:
                    this.f3007w.setEnabled(true);
                    this.f3007w.m3210c();
                    return;
                case NeedToUnlockWrong:
                    this.f3007w.setDisplayMode(C1309b.Wrong);
                    this.f3007w.setEnabled(true);
                    this.f3007w.m3210c();
                    return;
                case LockedOut:
                    this.f3007w.m3209b();
                    this.f3007w.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    private C1376m m3507e(boolean z) {
        C1376m c1376m = new C1376m(this.h, null, z);
        int a = C1102c.m2380a(z, 2);
        View inflate = this.j.inflate(C1102c.m2381a(this.h, C1102c.m2385a(this.h), a), null);
        c1376m.m3493a(inflate);
        c1376m.m3495c().setTactileFeedbackEnabled(C1318c.m3243a(this.h));
        c1376m.m3495c().setOnPatternListener(this.f3010z);
        m3504a(C1380a.NeedToUnlock);
        View findViewById = inflate.findViewById(R.id.pattern_board_change_to_number_lock_button);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        inflate = inflate.findViewById(R.id.locker_board_more);
        if (inflate != null) {
            inflate.setVisibility(4);
            C1102c.m2393a(inflate, 0, -1, -1, -1);
            C1102c.m2384a(inflate, 1, -10);
        }
        return c1376m;
    }

    private void m3508e() {
        if (this.f3004t != null) {
            this.f3004t.m1731a(this.a);
        }
    }

    public void mo2459a() {
        this.f3008x = new C1318c(this.h);
        this.n = this.j.inflate(R.layout.pattern_lock_port, null);
        this.o = m1759a((int) R.id.pattern_lock_animview);
        super.mo2459a();
    }

    public void mo2460a(String str, boolean z) {
        super.mo2460a(str, z);
        m3508e();
    }

    public void mo2465a(boolean z) {
        if (!this.c) {
            try {
                if (this.f3004t != null) {
                    this.f3004t.m3495c().m3209b();
                }
                if (!(this.m == null || this.m.getParent() == null)) {
                    this.k.removeView(this.m);
                }
                if (this.n.getParent() != null) {
                    this.k.removeView(this.n);
                }
                m1767c(z);
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
                final /* synthetic */ C1381n f2998d;

                public void run() {
                    if (!this.f2998d.c) {
                        View a = this.f2998d.m1759a((int) R.id.fake_view_forground);
                        if (a != null) {
                            a.setVisibility(0);
                        }
                        if (!z || z2) {
                            this.f2998d.mo2465a(z3);
                            return;
                        }
                        this.f2998d.n.setBackgroundColor(0);
                        if (this.f2998d.o == null || this.f2998d.e == null) {
                            this.f2998d.mo2465a(z3);
                            return;
                        }
                        this.f2998d.o.startAnimation(this.f2998d.e);
                        this.f2998d.m1776m();
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
        if (this.f3006v != null && this.f3005u != null) {
            this.s = z;
            this.f3004t = z ? this.f3006v : this.f3005u;
            this.f3007w = this.f3004t.m3495c();
            this.f3007w.m3209b();
            super.mo2467b(z);
            if (!(this.m == null || this.m.getParent() == null)) {
                this.k.removeView(this.m);
            }
            ViewGroup viewGroup = (ViewGroup) m1759a((int) R.id.pattern_board_container);
            viewGroup.removeAllViews();
            viewGroup.addView(this.f3004t.m1735h());
            m1773j();
            ((LinearLayoutWithDefaultTouchRecepient) m1759a((int) R.id.topLayout)).setDefaultTouchRecepient(this.f3007w);
            Resources resources = this.h.getResources();
            this.f3009y = this.n.findViewById(R.id.numboard_whole_layout);
            this.o.setBackgroundColor(resources.getColor(R.color.default_fakeview_forground_color));
            C1375l.m3479a(this.f3009y, z);
            m3508e();
            this.o.setVisibility(0);
        }
    }

    public void mo2468c() {
        this.f3006v = m3507e(true);
        this.f3005u = m3507e(false);
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
                if (this.f3004t == null) {
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
