package com.domobile.lockbean;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.os.CancellationSignal;
import com.domobile.applock.C1150y;
import com.domobile.applock.p007c.C0754a;
import com.domobile.applock.p007c.C0754a.C0750b;
import com.domobile.applock.p007c.C0754a.C0751c;
import com.domobile.applock.p007c.C0754a.C0752d;
import com.domobile.widget.FingerPrintStateView;

public class C1365d extends C0750b implements Runnable {
    boolean f2940a;
    private final PowerManager f2941b;
    private final C0754a f2942c;
    private final C0743a f2943d;
    private CancellationSignal f2944e;
    private FingerPrintStateView f2945f;
    private Handler f2946g;

    public interface C0743a {
        void mo2410b();

        void mo2411c();

        void mo2412d();
    }

    class C13611 implements Runnable {
        final /* synthetic */ C1365d f2936a;

        C13611(C1365d c1365d) {
            this.f2936a = c1365d;
        }

        public void run() {
            this.f2936a.f2943d.mo2411c();
        }
    }

    class C13622 implements Runnable {
        final /* synthetic */ C1365d f2937a;

        C13622(C1365d c1365d) {
            this.f2937a = c1365d;
        }

        public void run() {
            this.f2937a.f2943d.mo2412d();
        }
    }

    class C13633 implements Runnable {
        final /* synthetic */ C1365d f2938a;

        C13633(C1365d c1365d) {
            this.f2938a = c1365d;
        }

        public void run() {
            this.f2938a.f2943d.mo2410b();
        }
    }

    public static class C1364b {
        private final C0754a f2939a;

        public C1364b(C0754a c0754a) {
            this.f2939a = c0754a;
        }

        public C1365d m3435a(Context context, FingerPrintStateView fingerPrintStateView, C0743a c0743a) {
            return new C1365d(context, this.f2939a, fingerPrintStateView, c0743a);
        }
    }

    @TargetApi(23)
    private C1365d(Context context, C0754a c0754a, FingerPrintStateView fingerPrintStateView, C0743a c0743a) {
        this.f2941b = (PowerManager) context.getSystemService(PowerManager.class);
        this.f2946g = new Handler(context.getMainLooper());
        this.f2942c = c0754a;
        this.f2943d = c0743a;
        this.f2945f = fingerPrintStateView;
    }

    private void m3437a(int i) {
        if (this.f2945f != null) {
            this.f2945f.m3531a(i);
        }
    }

    @TargetApi(20)
    public static boolean m3438a(PowerManager powerManager) {
        return C1150y.O >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    public void mo2574a() {
        m3437a(2);
        this.f2946g.postDelayed(new C13622(this), 400);
    }

    public void mo2575a(int i, CharSequence charSequence) {
        if (!this.f2940a) {
            this.f2946g.postDelayed(new C13611(this), 400);
        }
    }

    public void mo2576a(C0751c c0751c) {
        m3437a(1);
        this.f2946g.postDelayed(new C13633(this), 400);
    }

    public void m3442a(C0752d c0752d) {
        if (m3445b() && C1365d.m3438a(this.f2941b)) {
            try {
                this.f2944e = new CancellationSignal();
                this.f2940a = false;
                this.f2942c.m1093a(c0752d, 0, this.f2944e, this, null);
                if (this.f2945f != null) {
                    this.f2945f.setVisibility(0);
                }
            } catch (Exception e) {
            }
        }
    }

    public void m3443a(FingerPrintStateView fingerPrintStateView) {
        this.f2945f = fingerPrintStateView;
        if (this.f2945f != null && this.f2944e != null && !this.f2944e.isCanceled()) {
            this.f2945f.setVisibility(0);
        }
    }

    public void mo2577b(int i, CharSequence charSequence) {
    }

    public boolean m3445b() {
        return this.f2942c.m1095b() && this.f2942c.m1094a();
    }

    public void m3446c() {
        if (this.f2945f != null) {
            this.f2945f.postDelayed(this, 300);
        }
        if (this.f2944e != null) {
            this.f2940a = true;
            this.f2944e.cancel();
            this.f2944e = null;
        }
    }

    public void run() {
        this.f2945f.setVisibility(8);
    }
}
