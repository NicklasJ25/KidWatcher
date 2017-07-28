package com.domobile.lockbean;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.domobile.applock.BlankActivity;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0906c;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.fake.DefaultFakeViewInitialer;
import com.domobile.applock.theme.C1102c;
import com.domobile.frame.C0635g;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p016c.C1170b;

public class C1375l extends C0965g {
    public boolean f2983t = false;
    public boolean f2984u = false;
    private C1372k f2985v;
    private C1372k f2986w;
    private C1372k f2987x;
    private C0635g f2988y = new C13742(this);

    class C13742 extends C0635g {
        final /* synthetic */ C1375l f2982a;

        C13742(C1375l c1375l) {
            this.f2982a = c1375l;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f2982a.f2985v != null) {
                this.f2982a.m1784b(this.f2982a.f2985v.m3469j());
            }
        }
    }

    public C1375l(Context context, String str, boolean z) {
        super(context, str, z);
    }

    private void m3477a(C1372k c1372k) {
        if (c1372k != null) {
            c1372k.m1731a(this.a);
        }
    }

    public static boolean m3478a(Context context, Handler handler, View view, String str, Object... objArr) {
        try {
            C0906c c0906c = (C0906c) Class.forName(C1150y.m2629h(context)).newInstance();
            if (c0906c instanceof DefaultFakeViewInitialer) {
                c0906c.mo2440b(view);
                return false;
            }
            handler.sendMessageDelayed(handler.obtainMessage(103, c0906c), 100);
            c0906c.mo2440b(view);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean m3479a(View view, boolean z) {
        Context context = view.getContext();
        if (!C1102c.m2406e(context, context.getPackageName())) {
            return true;
        }
        Object d = C1150y.m2617d(context, z);
        if (TextUtils.isEmpty(d)) {
            return false;
        }
        C1148d.m2514a(view, new BitmapDrawable(context.getResources(), d));
        return true;
    }

    public static void m3480b(Context context, String str) {
        Intent intent = new Intent(context, BlankActivity.class);
        intent.putExtra("com.domobile.elock.packagename", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static String m3481c(Context context, String str) {
        return C1170b.m2685b(str + C1150y.aa(context)).toUpperCase();
    }

    private C1372k m3482e(boolean z) {
        C1372k c1372k = new C1372k(this.h, null, 0, z);
        int a = C1102c.m2380a(z, 1);
        View inflate = this.j.inflate(C1102c.m2381a(this.h, C1102c.m2385a(this.h), a), null);
        c1372k.m3458a(inflate);
        c1372k.m3457a(this.f2988y);
        c1372k.m3475p().setOnClickListener(this);
        inflate = inflate.findViewById(R.id.locker_board_more);
        if (inflate != null) {
            inflate.setVisibility(4);
            C1102c.m2393a(inflate, 0, -1, -1, -1);
            C1102c.m2384a(inflate, 1, -10);
        }
        return c1372k;
    }

    public void mo2459a() {
        this.n = this.j.inflate(R.layout.verify, null);
        this.o = m1759a((int) R.id.verify_anim_view);
        super.mo2459a();
    }

    public void mo2460a(String str, boolean z) {
        super.mo2460a(str, z);
        if (this.f2985v != null) {
            this.f2985v.m3465d();
        }
        m3477a(this.f2985v);
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
                final /* synthetic */ C1375l f2981d;

                public void run() {
                    if (!this.f2981d.c) {
                        View a = this.f2981d.m1759a((int) R.id.fake_view_forground);
                        if (a != null) {
                            a.setVisibility(0);
                        }
                        if (!z || z2) {
                            this.f2981d.mo2465a(z3);
                            return;
                        }
                        this.f2981d.n.setBackgroundColor(0);
                        this.f2981d.o.startAnimation(this.f2981d.e);
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
        if (this.f2987x != null && this.f2986w != null) {
            if (!(this.m == null || this.m.getParent() == null)) {
                this.k.removeView(this.m);
            }
            this.s = z;
            this.f2985v = z ? this.f2987x : this.f2986w;
            this.f2985v.m3465d();
            this.f2985v.m3462b();
            super.mo2467b(z);
            View h = this.f2985v.m1735h();
            ViewGroup viewGroup = (ViewGroup) m1759a((int) R.id.numboard_parent);
            viewGroup.removeAllViews();
            viewGroup.addView(h);
            m1773j();
            ImageButton p = this.f2985v.m3475p();
            if (this.b) {
                p.setEnabled(false);
                p.setImageResource(0);
            } else {
                p.setEnabled(true);
                p.setImageDrawable(C1102c.m2395b(this.h, C1102c.m2385a(this.h), R.drawable.num_button_exit));
            }
            this.o.setBackgroundColor(this.h.getResources().getColor(R.color.default_fakeview_forground_color));
            C1375l.m3479a(this.f2985v.m3471l(), z);
            m3477a(this.f2985v);
        }
    }

    public void mo2468c() {
        this.i.sendEmptyMessage(106);
        this.f2986w = m3482e(false);
        this.f2987x = m3482e(true);
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
                if (this.f2985v == null) {
                    this.i.sendEmptyMessageDelayed(104, 100);
                    return;
                }
                m1770g();
                this.f2985v.m3462b();
                this.f2985v.m3460a(this.f2985v.m3461a());
            } catch (Throwable th) {
                th.printStackTrace();
                this.f.f427b = false;
                this.c = this.f.f427b;
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.numboard_exit_button) {
            super.onClick(view);
        } else if (!this.b) {
            C1150y.m2613c(this.h);
        }
    }
}
