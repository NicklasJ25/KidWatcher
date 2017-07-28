package com.domobile.lockbean;

import android.content.Context;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.chamber.p009c.C0810f;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.frame.p000a.C1258c;

public abstract class C0970h extends C0964f {
    private String f1586t = "";
    private int f1587u = 0;

    public C0970h(Context context, String str, boolean z) {
        super(context, str, z);
    }

    private void m1811e() {
        this.f1587u = 0;
    }

    private void m1812f() {
        if (!TextUtils.isEmpty(this.f1586t)) {
            C1258c.m2987b("**** 错误,保存照片 ****");
            C1150y.m2622e(this.h, this.f1586t);
            C1150y.m2609b(this.h, true);
            this.f1586t = "";
        }
    }

    public void mo2459a() {
        super.mo2459a();
    }

    public void mo2460a(String str, boolean z) {
        super.mo2460a(str, z);
        m1811e();
    }

    public void mo2461a(boolean z, boolean z2, boolean z3, long j) {
        super.mo2461a(z, z2, z3, j);
        m1812f();
    }

    public void mo2462d() {
        m1811e();
        super.mo2462d();
        this.f1586t = "";
    }

    public void mo2463n() {
        C1150y.m2589a(this.h, 0);
        C0814g.m1299a(this.f1586t);
        this.f1586t = "";
        super.mo2463n();
        m1811e();
    }

    public void mo2464o() {
        super.mo2464o();
        if (this.f1587u < 3) {
            this.f1587u++;
            if (this.f1587u == 3) {
                C1258c.m2987b("**** 输错3次,保存记录 ****");
                C1150y.m2589a(this.h, System.currentTimeMillis());
            }
        }
        if (C1150y.m2658u(this.h) && TextUtils.isEmpty(this.f1586t)) {
            C1258c.m2987b("**** 输入错误,拍照 ****");
            this.f1586t = C0814g.m1295a(this.h);
            C0810f.m1290a(this.h).mo2423a(this.f1586t);
        }
    }
}
