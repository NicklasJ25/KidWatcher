package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.zzp.C2350a;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.aau;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.va.C2347a;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zg;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zo;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.Collections;
import java.util.Map;

@wh
public class zze extends C2347a implements zzv {
    static final int f6777a = Color.argb(0, 0, 0, 0);
    AdOverlayInfoParcel f6778b;
    aat f6779c;
    zzc f6780d;
    zzp f6781e;
    boolean f6782f = false;
    FrameLayout f6783g;
    CustomViewCallback f6784h;
    boolean f6785i = false;
    boolean f6786j = false;
    C2344b f6787k;
    boolean f6788l = false;
    int f6789m = 0;
    zzm f6790n;
    private final Activity f6791o;
    private final Object f6792p = new Object();
    private Runnable f6793q;
    private boolean f6794r;
    private boolean f6795s;
    private boolean f6796t = false;
    private boolean f6797u = false;
    private boolean f6798v = true;

    class C23411 implements C2340a {
        C23411(zze com_google_android_gms_ads_internal_overlay_zze) {
        }

        public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
            com_google_android_gms_internal_aat.mo3414d();
        }
    }

    class C23422 implements Runnable {
        final /* synthetic */ zze f6768a;

        C23422(zze com_google_android_gms_ads_internal_overlay_zze) {
            this.f6768a = com_google_android_gms_ads_internal_overlay_zze;
        }

        public void run() {
            this.f6768a.m7407b();
        }
    }

    @wh
    private static final class C2343a extends Exception {
        public C2343a(String str) {
            super(str);
        }
    }

    @wh
    static class C2344b extends RelativeLayout {
        zo f6769a;
        boolean f6770b;

        public C2344b(Context context, String str, String str2) {
            super(context);
            this.f6769a = new zo(context, str);
            this.f6769a.m15235b(str2);
        }

        void m7401a() {
            this.f6770b = true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!this.f6770b) {
                this.f6769a.m15233a(motionEvent);
            }
            return false;
        }
    }

    @wh
    private class C2346c extends zg {
        final /* synthetic */ zze f6776a;

        private C2346c(zze com_google_android_gms_ads_internal_overlay_zze) {
            this.f6776a = com_google_android_gms_ads_internal_overlay_zze;
        }

        public void onStop() {
        }

        public void zzco() {
            Bitmap a = zzw.zzdh().m15280a(Integer.valueOf(this.f6776a.f6778b.zzNQ.zztP));
            if (a != null) {
                final Drawable a2 = zzw.zzcO().mo4261a(this.f6776a.f6791o, a, this.f6776a.f6778b.zzNQ.zztN, this.f6776a.f6778b.zzNQ.zztO);
                zl.f11678a.post(new Runnable(this) {
                    final /* synthetic */ C2346c f6772b;

                    public void run() {
                        this.f6772b.f6776a.f6791o.getWindow().setBackgroundDrawable(a2);
                    }
                });
            }
        }
    }

    @wh
    public static class zzc {
        public final int index;
        public final ViewGroup parent;
        public final LayoutParams zzNB;
        public final Context zzqn;

        public zzc(aat com_google_android_gms_internal_aat) {
            this.zzNB = com_google_android_gms_internal_aat.getLayoutParams();
            ViewParent parent = com_google_android_gms_internal_aat.getParent();
            this.zzqn = com_google_android_gms_internal_aat.mo3419g();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new C2343a("Could not get the parent of the WebView for an overlay.");
            }
            this.parent = (ViewGroup) parent;
            this.index = this.parent.indexOfChild(com_google_android_gms_internal_aat.mo3405b());
            this.parent.removeView(com_google_android_gms_internal_aat.mo3405b());
            com_google_android_gms_internal_aat.mo3404a(true);
        }
    }

    public zze(Activity activity) {
        this.f6791o = activity;
        this.f6790n = new zzt();
    }

    protected void m7404a() {
        if (this.f6791o.isFinishing() && !this.f6796t) {
            this.f6796t = true;
            if (this.f6779c != null) {
                m7405a(this.f6789m);
                synchronized (this.f6792p) {
                    if (!this.f6794r && this.f6779c.mo3386A()) {
                        this.f6793q = new C23422(this);
                        zl.f11678a.postDelayed(this.f6793q, ((Long) qb.aS.m13225c()).longValue());
                        return;
                    }
                }
            }
            m7407b();
        }
    }

    protected void m7405a(int i) {
        this.f6779c.mo3393a(i);
    }

    protected void m7406a(boolean z) {
        if (!this.f6795s) {
            this.f6791o.requestWindowFeature(1);
        }
        Window window = this.f6791o.getWindow();
        if (window == null) {
            throw new C2343a("Invalid activity, no window available.");
        }
        boolean a = (C2590o.m8317l() && ((Boolean) qb.dn.m13225c()).booleanValue()) ? zzw.zzcM().m15129a(this.f6791o, this.f6791o.getResources().getConfiguration()) : true;
        Object obj = (this.f6778b.zzNQ == null || !this.f6778b.zzNQ.zztL) ? null : 1;
        if (!(this.f6786j && obj == null) && a) {
            window.setFlags(1024, 1024);
        }
        aau l = this.f6778b.zzNH.mo3424l();
        boolean b = l != null ? l.m8558b() : false;
        this.f6788l = false;
        if (b) {
            if (this.f6778b.orientation == zzw.zzcO().mo4247a()) {
                this.f6788l = this.f6791o.getResources().getConfiguration().orientation == 1;
            } else if (this.f6778b.orientation == zzw.zzcO().mo4249b()) {
                this.f6788l = this.f6791o.getResources().getConfiguration().orientation == 2;
            }
        }
        aad.m8421b("Delay onShow to next orientation change: " + this.f6788l);
        setRequestedOrientation(this.f6778b.orientation);
        if (zzw.zzcO().mo4253a(window)) {
            aad.m8421b("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.f6786j) {
            this.f6787k.setBackgroundColor(f6777a);
        } else {
            this.f6787k.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.f6791o.setContentView(this.f6787k);
        zzbo();
        if (z) {
            this.f6779c = zzw.zzcN().m8575a(this.f6791o, this.f6778b.zzNH.mo3423k(), true, b, null, this.f6778b.zzvn, null, null, this.f6778b.zzNH.mo3420h());
            this.f6779c.mo3424l().m8551a(null, null, this.f6778b.zzNI, this.f6778b.zzNM, true, this.f6778b.zzNO, null, this.f6778b.zzNH.mo3424l().m8539a(), null, null);
            this.f6779c.mo3424l().m8547a(new C23411(this));
            if (this.f6778b.url != null) {
                this.f6779c.loadUrl(this.f6778b.url);
            } else if (this.f6778b.zzNL != null) {
                this.f6779c.loadDataWithBaseURL(this.f6778b.zzNJ, this.f6778b.zzNL, "text/html", "UTF-8", null);
            } else {
                throw new C2343a("No URL or HTML to display in ad overlay.");
            }
            if (this.f6778b.zzNH != null) {
                this.f6778b.zzNH.mo3407b(this);
            }
        } else {
            this.f6779c = this.f6778b.zzNH;
            this.f6779c.mo3394a(this.f6791o);
        }
        this.f6779c.mo3396a(this);
        ViewParent parent = this.f6779c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f6779c.mo3405b());
        }
        if (this.f6786j) {
            this.f6779c.mo3391F();
        }
        this.f6787k.addView(this.f6779c.mo3405b(), -1, -1);
        if (!(z || this.f6788l)) {
            m7408c();
        }
        zzy(b);
        if (this.f6779c.mo3428m()) {
            zza(b, true);
        }
        com.google.android.gms.ads.internal.zze h = this.f6779c.mo3420h();
        zzn com_google_android_gms_ads_internal_overlay_zzn = h != null ? h.zzsO : null;
        if (com_google_android_gms_ads_internal_overlay_zzn != null) {
            this.f6790n = com_google_android_gms_ads_internal_overlay_zzn.zza(this.f6791o, this.f6779c, this.f6787k);
        } else {
            aad.m8426e("Appstreaming controller is null.");
        }
    }

    void m7407b() {
        if (!this.f6797u) {
            this.f6797u = true;
            if (this.f6779c != null) {
                this.f6787k.removeView(this.f6779c.mo3405b());
                if (this.f6780d != null) {
                    this.f6779c.mo3394a(this.f6780d.zzqn);
                    this.f6779c.mo3404a(false);
                    this.f6780d.parent.addView(this.f6779c.mo3405b(), this.f6780d.index, this.f6780d.zzNB);
                    this.f6780d = null;
                } else if (this.f6791o.getApplicationContext() != null) {
                    this.f6779c.mo3394a(this.f6791o.getApplicationContext());
                }
                this.f6779c = null;
            }
            if (this.f6778b != null && this.f6778b.zzNG != null) {
                this.f6778b.zzNG.zzbN();
            }
        }
    }

    protected void m7408c() {
        this.f6779c.mo3414d();
    }

    public void close() {
        this.f6789m = 2;
        this.f6791o.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onBackPressed() {
        this.f6789m = 0;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        this.f6791o.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f6785i = z;
        try {
            this.f6778b = AdOverlayInfoParcel.zzb(this.f6791o.getIntent());
            if (this.f6778b == null) {
                throw new C2343a("Could not get info for ad overlay.");
            }
            if (this.f6778b.zzvn.f12083c > 7500000) {
                this.f6789m = 3;
            }
            if (this.f6791o.getIntent() != null) {
                this.f6798v = this.f6791o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f6778b.zzNQ != null) {
                this.f6786j = this.f6778b.zzNQ.zztK;
            } else {
                this.f6786j = false;
            }
            if (((Boolean) qb.bU.m13225c()).booleanValue() && this.f6786j && this.f6778b.zzNQ.zztP != -1) {
                new C2346c().zziP();
            }
            if (bundle == null) {
                if (this.f6778b.zzNG != null && this.f6798v) {
                    this.f6778b.zzNG.zzbO();
                }
                if (!(this.f6778b.zzNN == 1 || this.f6778b.zzNF == null)) {
                    this.f6778b.zzNF.onAdClicked();
                }
            }
            this.f6787k = new C2344b(this.f6791o, this.f6778b.zzNP, this.f6778b.zzvn.f12081a);
            this.f6787k.setId(1000);
            switch (this.f6778b.zzNN) {
                case 1:
                    m7406a(false);
                    return;
                case 2:
                    this.f6780d = new zzc(this.f6778b.zzNH);
                    m7406a(false);
                    return;
                case 3:
                    m7406a(true);
                    return;
                case 4:
                    if (this.f6785i) {
                        this.f6789m = 3;
                        this.f6791o.finish();
                        return;
                    } else if (!zzw.zzcJ().zza(this.f6791o, this.f6778b.zzNE, this.f6778b.zzNM)) {
                        this.f6789m = 3;
                        this.f6791o.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C2343a("Could not determine ad overlay type.");
            }
        } catch (C2343a e) {
            aad.m8426e(e.getMessage());
            this.f6789m = 3;
            this.f6791o.finish();
        }
    }

    public void onDestroy() {
        if (this.f6779c != null) {
            this.f6787k.removeView(this.f6779c.mo3405b());
        }
        m7404a();
    }

    public void onPause() {
        zzhD();
        if (this.f6778b.zzNG != null) {
            this.f6778b.zzNG.onPause();
        }
        if (!(((Boolean) qb.f10291do.m13225c()).booleanValue() || this.f6779c == null || (this.f6791o.isFinishing() && this.f6780d != null))) {
            zzw.zzcO().m15181a(this.f6779c);
        }
        m7404a();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.f6778b != null && this.f6778b.zzNN == 4) {
            if (this.f6785i) {
                this.f6789m = 3;
                this.f6791o.finish();
            } else {
                this.f6785i = true;
            }
        }
        if (this.f6778b.zzNG != null) {
            this.f6778b.zzNG.onResume();
        }
        if (!((Boolean) qb.f10291do.m13225c()).booleanValue()) {
            if (this.f6779c == null || this.f6779c.mo3435r()) {
                aad.m8426e("The webview does not exist. Ignoring action.");
            } else {
                zzw.zzcO().m15185b(this.f6779c);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f6785i);
    }

    public void onStart() {
        if (!((Boolean) qb.f10291do.m13225c()).booleanValue()) {
            return;
        }
        if (this.f6779c == null || this.f6779c.mo3435r()) {
            aad.m8426e("The webview does not exist. Ignoring action.");
        } else {
            zzw.zzcO().m15185b(this.f6779c);
        }
    }

    public void onStop() {
        if (((Boolean) qb.f10291do.m13225c()).booleanValue() && this.f6779c != null && (!this.f6791o.isFinishing() || this.f6780d == null)) {
            zzw.zzcO().m15181a(this.f6779c);
        }
        m7404a();
    }

    public void setRequestedOrientation(int i) {
        this.f6791o.setRequestedOrientation(i);
    }

    public void zza(View view, CustomViewCallback customViewCallback) {
        this.f6783g = new FrameLayout(this.f6791o);
        this.f6783g.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6783g.addView(view, -1, -1);
        this.f6791o.setContentView(this.f6783g);
        zzbo();
        this.f6784h = customViewCallback;
        this.f6782f = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.f6781e != null) {
            this.f6781e.zza(z, z2);
        }
    }

    public void zzbo() {
        this.f6795s = true;
    }

    public void zzg(aat com_google_android_gms_internal_aat, Map<String, String> map) {
    }

    public void zzhD() {
        if (this.f6778b != null && this.f6782f) {
            setRequestedOrientation(this.f6778b.orientation);
        }
        if (this.f6783g != null) {
            this.f6791o.setContentView(this.f6787k);
            zzbo();
            this.f6783g.removeAllViews();
            this.f6783g = null;
        }
        if (this.f6784h != null) {
            this.f6784h.onCustomViewHidden();
            this.f6784h = null;
        }
        this.f6782f = false;
    }

    public void zzhE() {
        this.f6789m = 1;
        this.f6791o.finish();
    }

    public boolean zzhF() {
        boolean z = true;
        this.f6789m = 0;
        if (this.f6779c != null) {
            if (!this.f6779c.mo3442t()) {
                z = false;
            }
            if (!z) {
                this.f6779c.mo3403a("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void zzhG() {
        this.f6787k.removeView(this.f6781e);
        zzy(true);
    }

    public void zzhJ() {
        if (this.f6788l) {
            this.f6788l = false;
            m7408c();
        }
    }

    public void zzhL() {
        this.f6787k.m7401a();
    }

    public void zzhM() {
        synchronized (this.f6792p) {
            this.f6794r = true;
            if (this.f6793q != null) {
                zl.f11678a.removeCallbacks(this.f6793q);
                zl.f11678a.post(this.f6793q);
            }
        }
    }

    public void zzo(C2309a c2309a) {
        if (((Boolean) qb.dn.m13225c()).booleanValue() && C2590o.m8317l()) {
            if (zzw.zzcM().m15129a(this.f6791o, (Configuration) C2312b.m7328a(c2309a))) {
                this.f6791o.getWindow().addFlags(1024);
                this.f6791o.getWindow().clearFlags(2048);
                return;
            }
            this.f6791o.getWindow().addFlags(2048);
            this.f6791o.getWindow().clearFlags(1024);
        }
    }

    public void zzy(boolean z) {
        int intValue = ((Integer) qb.dp.m13225c()).intValue();
        C2350a c2350a = new C2350a();
        c2350a.f6821e = 50;
        c2350a.f6817a = z ? intValue : 0;
        c2350a.f6818b = z ? 0 : intValue;
        c2350a.f6819c = 0;
        c2350a.f6820d = intValue;
        this.f6781e = new zzp(this.f6791o, c2350a, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f6781e.zza(z, this.f6778b.zzNK);
        this.f6787k.addView(this.f6781e, layoutParams);
    }
}
