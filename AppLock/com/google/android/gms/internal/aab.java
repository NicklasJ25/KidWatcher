package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzw;

@wh
public final class aab {
    private final View f7614a;
    private Activity f7615b;
    private boolean f7616c;
    private boolean f7617d;
    private boolean f7618e;
    private OnGlobalLayoutListener f7619f;
    private OnScrollChangedListener f7620g;

    public aab(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f7615b = activity;
        this.f7614a = view;
        this.f7619f = onGlobalLayoutListener;
        this.f7620g = onScrollChangedListener;
    }

    private void m8388e() {
        if (!this.f7616c) {
            if (this.f7619f != null) {
                if (this.f7615b != null) {
                    zzw.zzcM().m15115a(this.f7615b, this.f7619f);
                }
                zzw.zzdk().m8460a(this.f7614a, this.f7619f);
            }
            if (this.f7620g != null) {
                if (this.f7615b != null) {
                    zzw.zzcM().m15116a(this.f7615b, this.f7620g);
                }
                zzw.zzdk().m8461a(this.f7614a, this.f7620g);
            }
            this.f7616c = true;
        }
    }

    private void m8389f() {
        if (this.f7615b != null && this.f7616c) {
            if (!(this.f7619f == null || this.f7615b == null)) {
                zzw.zzcO().mo4258a(this.f7615b, this.f7619f);
            }
            if (!(this.f7620g == null || this.f7615b == null)) {
                zzw.zzcM().m15140b(this.f7615b, this.f7620g);
            }
            this.f7616c = false;
        }
    }

    public void m8390a() {
        this.f7618e = true;
        if (this.f7617d) {
            m8388e();
        }
    }

    public void m8391a(Activity activity) {
        this.f7615b = activity;
    }

    public void m8392b() {
        this.f7618e = false;
        m8389f();
    }

    public void m8393c() {
        this.f7617d = true;
        if (this.f7618e) {
            m8388e();
        }
    }

    public void m8394d() {
        this.f7617d = false;
        m8389f();
    }
}
