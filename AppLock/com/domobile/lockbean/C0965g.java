package com.domobile.lockbean;

import android.content.Context;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.chamber.p009c.C0810f;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.frame.p000a.C1258c;

public abstract class C0965g extends C0964f {
    private String f1569t = "";
    private int f1570u;
    private String f1571v = "";
    private int f1572w = 0;
    private int f1573x = 0;

    public C0965g(Context context, String str, boolean z) {
        super(context, str, z);
    }

    private void mo2413e() {
        this.f1569t = null;
        this.f1572w = 0;
        this.f1573x = 0;
    }

    private void mo2469f() {
        if (!TextUtils.isEmpty(this.f1571v)) {
            C1258c.m2987b("**** 错误,保存照片 ****");
            C1150y.m2622e(this.h, this.f1571v);
            C1150y.m2609b(this.h, true);
            this.f1571v = "";
        }
    }

    public void mo2459a() {
        super.mo2459a();
    }

    public void mo2460a(String str, boolean z) {
        super.mo2460a(str, z);
        mo2413e();
    }

    public void mo2461a(boolean z, boolean z2, boolean z3, long j) {
        super.mo2461a(z, z2, z3, j);
        mo2469f();
    }

    protected void m1784b(String str) {
        if (TextUtils.isEmpty(this.f1569t)) {
            this.f1569t = C1150y.m2620e(this.h);
        }
        if (C1150y.m2608b(this.h, str, this.f1569t)) {
            C1150y.m2588a(this.h, str.length());
            mo2463n();
            return;
        }
        if (this.f1570u == 0) {
            this.f1570u = C1150y.m2659v(this.h);
        }
        if (this.f1570u != 0) {
            if (this.f1570u == str.length()) {
                mo2464o();
            }
            if (this.f1573x < 3) {
                int length = str.length();
                if (length == this.f1570u && length > this.f1572w) {
                    this.f1573x++;
                }
                this.f1572w = length;
                if (this.f1573x == 3) {
                    C1258c.m2987b("**** 输错3次,保存记录 ****");
                    C1150y.m2589a(this.h, System.currentTimeMillis());
                }
            }
        }
    }

    public void mo2462d() {
        mo2413e();
        super.mo2462d();
        this.f1571v = "";
    }

    public void mo2463n() {
        C1150y.m2589a(this.h, 0);
        C0814g.m1299a(this.f1571v);
        this.f1571v = "";
        super.mo2463n();
        mo2413e();
    }

    public void mo2464o() {
        super.mo2464o();
        if (C1150y.m2658u(this.h) && TextUtils.isEmpty(this.f1571v)) {
            C1258c.m2987b("**** 输入错误,拍照 ****");
            this.f1571v = C0814g.m1295a(this.h);
            C0810f.m1290a(this.h).mo2423a(this.f1571v);
        }
    }
}
