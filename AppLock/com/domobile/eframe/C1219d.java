package com.domobile.eframe;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.BlankActivity;
import com.domobile.applock.C1150y;
import com.facebook.ads.C1466h;
import com.google.android.gms.ads.InterstitialAd;

public class C1219d {
    public InterstitialAd f2401a;
    public C1466h f2402b;
    private AppLockApplication f2403c;
    private Context f2404d;
    private Handler f2405e;
    private boolean f2406f = false;

    private class C1218a extends Handler {
        final /* synthetic */ C1219d f2399a;
        private int f2400b = 0;

        public C1218a(C1219d c1219d, Looper looper) {
            this.f2399a = c1219d;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (this.f2399a.f2403c.m590d() != null) {
                this.f2399a.m2861g();
            } else if (this.f2400b < 10) {
                this.f2400b++;
                sendEmptyMessageDelayed(0, 500);
            }
        }
    }

    public C1219d(Context context) {
        this.f2402b = new C1466h(context, "970977059658692_970997496323315");
        this.f2404d = context;
    }

    public C1219d(Context context, String str) {
        this.f2401a = new InterstitialAd(context);
        this.f2401a.setAdUnitId(str);
        this.f2404d = context;
    }

    private void m2861g() {
        if (this.f2401a != null) {
            this.f2401a.show();
        } else if (this.f2402b != null) {
            this.f2402b.m3797c();
        }
    }

    public void m2862a() {
        this.f2406f = true;
        if (this.f2404d != null) {
            this.f2404d.startActivity(new Intent(this.f2404d, BlankActivity.class));
            this.f2403c = C1150y.m2566a(this.f2404d.getApplicationContext());
            this.f2405e = new C1218a(this, this.f2403c.getMainLooper());
            this.f2405e.sendEmptyMessageDelayed(0, 500);
        }
    }

    public boolean m2863b() {
        return this.f2401a != null ? this.f2401a.isLoaded() : this.f2402b != null ? this.f2402b.m3796b() : false;
    }

    public boolean m2864c() {
        return this.f2401a != null ? this.f2401a.isLoading() : this.f2402b != null;
    }

    public boolean m2865d() {
        return this.f2406f;
    }

    public void m2866e() {
    }

    public void m2867f() {
    }
}
