package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.na.C3084a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@wh
class aay extends WebView implements OnGlobalLayoutListener, DownloadListener, aat {
    private qh f7720A;
    private qi f7721B;
    private WeakReference<OnClickListener> f7722C;
    private zze f7723D;
    private boolean f7724E;
    private aab f7725F;
    private int f7726G = -1;
    private int f7727H = -1;
    private int f7728I = -1;
    private int f7729J = -1;
    private Map<String, sr> f7730K;
    private final WindowManager f7731L;
    boolean f7732a = false;
    private final C2649a f7733b;
    private final Object f7734c = new Object();
    @Nullable
    private final ed f7735d;
    private final zzqh f7736e;
    private final zzu f7737f;
    private final com.google.android.gms.ads.internal.zze f7738g;
    private aau f7739h;
    private zze f7740i;
    private zzeg f7741j;
    private boolean f7742k;
    private boolean f7743l;
    private boolean f7744m;
    private boolean f7745n;
    private Boolean f7746o;
    private int f7747p;
    private boolean f7748q = true;
    private String f7749r = "";
    private aaz f7750s;
    private boolean f7751t;
    private boolean f7752u;
    private qw f7753v;
    private int f7754w;
    private int f7755x;
    private qh f7756y;
    private qh f7757z;

    class C26471 implements sc {
        final /* synthetic */ aay f7715a;

        C26471(aay com_google_android_gms_internal_aay) {
            this.f7715a = com_google_android_gms_internal_aay;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (map != null) {
                String str = (String) map.get("height");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        synchronized (this.f7715a.f7734c) {
                            if (this.f7715a.f7755x != parseInt) {
                                this.f7715a.f7755x = parseInt;
                                this.f7715a.requestLayout();
                            }
                        }
                    } catch (Throwable e) {
                        aad.m8424c("Exception occurred while getting webview content height", e);
                    }
                }
            }
        }
    }

    class C26482 implements Runnable {
        final /* synthetic */ aay f7716a;

        C26482(aay com_google_android_gms_internal_aay) {
            this.f7716a = com_google_android_gms_internal_aay;
        }

        public void run() {
            super.destroy();
        }
    }

    @wh
    public static class C2649a extends MutableContextWrapper {
        private Activity f7717a;
        private Context f7718b;
        private Context f7719c;

        public C2649a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Activity m8631a() {
            return this.f7717a;
        }

        public Context m8632b() {
            return this.f7719c;
        }

        public Object getSystemService(String str) {
            return this.f7719c.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.f7718b = context.getApplicationContext();
            this.f7717a = context instanceof Activity ? (Activity) context : null;
            this.f7719c = context;
            super.setBaseContext(this.f7718b);
        }

        public void startActivity(Intent intent) {
            if (this.f7717a != null) {
                this.f7717a.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f7718b.startActivity(intent);
        }
    }

    protected aay(C2649a c2649a, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable ed edVar, zzqh com_google_android_gms_internal_zzqh, qj qjVar, zzu com_google_android_gms_ads_internal_zzu, com.google.android.gms.ads.internal.zze com_google_android_gms_ads_internal_zze) {
        super(c2649a);
        this.f7733b = c2649a;
        this.f7741j = com_google_android_gms_internal_zzeg;
        this.f7744m = z;
        this.f7747p = -1;
        this.f7735d = edVar;
        this.f7736e = com_google_android_gms_internal_zzqh;
        this.f7737f = com_google_android_gms_ads_internal_zzu;
        this.f7738g = com_google_android_gms_ads_internal_zze;
        this.f7731L = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzw.zzcM().m15119a((Context) c2649a, com_google_android_gms_internal_zzqh.f12081a, settings);
        zzw.zzcO().mo4252a(getContext(), settings);
        setDownloadListener(this);
        m8636M();
        if (C2590o.m8310e()) {
            addJavascriptInterface(new aba(this), "googleAdsJsInterface");
        }
        C2590o.m8306a();
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.f7725F = new aab(this.f7733b.m8631a(), this, this, null);
        m8645a(qjVar);
        zzw.zzcO().mo4263b((Context) c2649a);
    }

    private void m8633J() {
        synchronized (this.f7734c) {
            this.f7746o = zzw.zzcQ().m15023l();
            if (this.f7746o == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    m8667a(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    m8667a(Boolean.valueOf(false));
                }
            }
        }
    }

    private void m8634K() {
        qf.m13288a(this.f7721B.m13298a(), this.f7757z, "aeh2");
    }

    private void m8635L() {
        qf.m13288a(this.f7721B.m13298a(), this.f7757z, "aebb2");
    }

    private void m8636M() {
        synchronized (this.f7734c) {
            if (this.f7744m || this.f7741j.f11898d) {
                int i = VERSION.SDK_INT;
                aad.m8421b("Enabling hardware acceleration on an overlay.");
                m8638O();
            } else if (VERSION.SDK_INT < 18) {
                aad.m8421b("Disabling hardware acceleration on an AdView.");
                m8637N();
            } else {
                aad.m8421b("Enabling hardware acceleration on an AdView.");
                m8638O();
            }
        }
    }

    private void m8637N() {
        synchronized (this.f7734c) {
            if (!this.f7745n) {
                zzw.zzcO().mo4256c((View) this);
            }
            this.f7745n = true;
        }
    }

    private void m8638O() {
        synchronized (this.f7734c) {
            if (this.f7745n) {
                zzw.zzcO().mo4254b((View) this);
            }
            this.f7745n = false;
        }
    }

    private void m8639P() {
        synchronized (this.f7734c) {
            if (!this.f7724E) {
                this.f7724E = true;
                zzw.zzcQ().m15036y();
            }
        }
    }

    private void m8640Q() {
        synchronized (this.f7734c) {
            this.f7730K = null;
        }
    }

    private void m8641R() {
        if (this.f7721B != null) {
            qj a = this.f7721B.m13298a();
            if (a != null && zzw.zzcQ().m15017f() != null) {
                zzw.zzcQ().m15017f().m13283a(a);
            }
        }
    }

    static aay m8643a(Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable ed edVar, zzqh com_google_android_gms_internal_zzqh, qj qjVar, zzu com_google_android_gms_ads_internal_zzu, com.google.android.gms.ads.internal.zze com_google_android_gms_ads_internal_zze) {
        return new aay(new C2649a(context), com_google_android_gms_internal_zzeg, z, z2, edVar, com_google_android_gms_internal_zzqh, qjVar, com_google_android_gms_ads_internal_zzu, com_google_android_gms_ads_internal_zze);
    }

    private void m8645a(qj qjVar) {
        m8641R();
        this.f7721B = new qi(new qj(true, "make_wv", this.f7741j.f11895a));
        this.f7721B.m13298a().m13303a(qjVar);
        this.f7757z = qf.m13285a(this.f7721B.m13298a());
        this.f7721B.m13299a("native:view_create", this.f7757z);
        this.f7720A = null;
        this.f7756y = null;
    }

    private void m8648e(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        mo3403a("onAdVisibilityChanged", hashMap);
    }

    public boolean mo3386A() {
        boolean z;
        synchronized (this.f7734c) {
            z = this.f7754w > 0;
        }
        return z;
    }

    public void mo3387B() {
        this.f7725F.m8390a();
    }

    public void mo3388C() {
        if (this.f7720A == null) {
            this.f7720A = qf.m13285a(this.f7721B.m13298a());
            this.f7721B.m13299a("native:view_load", this.f7720A);
        }
    }

    public OnClickListener mo3389D() {
        return (OnClickListener) this.f7722C.get();
    }

    public qw mo3390E() {
        qw qwVar;
        synchronized (this.f7734c) {
            qwVar = this.f7753v;
        }
        return qwVar;
    }

    public void mo3391F() {
        setBackgroundColor(0);
    }

    public boolean m8655G() {
        if (!mo3424l().m8558b() && !mo3424l().m8559c()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics a = zzw.zzcM().m15101a(this.f7731L);
        int b = ol.m12979a().m8411b(a, a.widthPixels);
        int b2 = ol.m12979a().m8411b(a, a.heightPixels);
        Activity f = mo3418f();
        if (f == null || f.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            int[] a2 = zzw.zzcM().m15135a(f);
            i2 = ol.m12979a().m8411b(a, a2[0]);
            i = ol.m12979a().m8411b(a, a2[1]);
        }
        if (this.f7727H == b && this.f7726G == b2 && this.f7728I == i2 && this.f7729J == i) {
            return false;
        }
        boolean z = (this.f7727H == b && this.f7726G == b2) ? false : true;
        this.f7727H = b;
        this.f7726G = b2;
        this.f7728I = i2;
        this.f7729J = i;
        new ux(this).m14273a(b, b2, i2, i, a.density, this.f7731L.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean m8656H() {
        Boolean bool;
        synchronized (this.f7734c) {
            bool = this.f7746o;
        }
        return bool;
    }

    sc m8657I() {
        return new C26471(this);
    }

    public WebView mo3392a() {
        return this;
    }

    public void mo3393a(int i) {
        if (i == 0) {
            m8635L();
        }
        m8634K();
        if (this.f7721B.m13298a() != null) {
            this.f7721B.m13298a().m13305a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.f7736e.f12081a);
        mo3403a("onhide", hashMap);
    }

    public void mo3394a(Context context) {
        this.f7733b.setBaseContext(context);
        this.f7725F.m8391a(this.f7733b.m8631a());
    }

    public void mo3395a(Context context, zzeg com_google_android_gms_internal_zzeg, qj qjVar) {
        synchronized (this.f7734c) {
            this.f7725F.m8392b();
            mo3394a(context);
            this.f7740i = null;
            this.f7741j = com_google_android_gms_internal_zzeg;
            this.f7744m = false;
            this.f7742k = false;
            this.f7749r = "";
            this.f7747p = -1;
            zzw.zzcO().m15185b((aat) this);
            loadUrl("about:blank");
            this.f7739h.m8569m();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.f7748q = true;
            this.f7732a = false;
            this.f7750s = null;
            m8645a(qjVar);
            this.f7751t = false;
            this.f7754w = 0;
            zzw.zzdj().m13743a((aat) this);
            m8640Q();
        }
    }

    public void mo3396a(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.f7734c) {
            this.f7740i = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void mo3397a(aaz com_google_android_gms_internal_aaz) {
        synchronized (this.f7734c) {
            if (this.f7750s != null) {
                aad.m8423c("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.f7750s = com_google_android_gms_internal_aaz;
        }
    }

    public void mo3398a(C3084a c3084a) {
        synchronized (this.f7734c) {
            this.f7751t = c3084a.f9933m;
        }
        m8648e(c3084a.f9933m);
    }

    public void mo3399a(qw qwVar) {
        synchronized (this.f7734c) {
            this.f7753v = qwVar;
        }
    }

    public void mo3400a(zzeg com_google_android_gms_internal_zzeg) {
        synchronized (this.f7734c) {
            this.f7741j = com_google_android_gms_internal_zzeg;
            requestLayout();
        }
    }

    void m8667a(Boolean bool) {
        synchronized (this.f7734c) {
            this.f7746o = bool;
        }
        zzw.zzcQ().m14998a(bool);
    }

    public void mo3401a(String str) {
        synchronized (this.f7734c) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                zzw.zzcQ().m15000a(th, "AdWebViewImpl.loadUrlUnsafe");
                aad.m8424c("Could not call loadUrl. ", th);
            }
        }
    }

    @TargetApi(19)
    protected void m8669a(String str, ValueCallback<String> valueCallback) {
        synchronized (this.f7734c) {
            if (mo3435r()) {
                aad.m8426e("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void mo3402a(String str, sc scVar) {
        if (this.f7739h != null) {
            this.f7739h.m8552a(str, scVar);
        }
    }

    public void mo3384a(String str, String str2) {
        m8686d(new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    public void mo3403a(String str, Map<String, ?> map) {
        try {
            mo3410b(str, zzw.zzcM().m15114a((Map) map));
        } catch (JSONException e) {
            aad.m8426e("Could not convert parameters to JSON.");
        }
    }

    public void mo3385a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        mo3384a(str, jSONObject.toString());
    }

    public void mo3404a(boolean z) {
        synchronized (this.f7734c) {
            this.f7744m = z;
            m8636M();
        }
    }

    public View mo3405b() {
        return this;
    }

    public void mo3406b(int i) {
        synchronized (this.f7734c) {
            this.f7747p = i;
            if (this.f7740i != null) {
                this.f7740i.setRequestedOrientation(this.f7747p);
            }
        }
    }

    public void mo3407b(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.f7734c) {
            this.f7723D = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void mo3408b(String str) {
        synchronized (this.f7734c) {
            if (str == null) {
                str = "";
            }
            this.f7749r = str;
        }
    }

    public void mo3409b(String str, sc scVar) {
        if (this.f7739h != null) {
            this.f7739h.m8557b(str, scVar);
        }
    }

    public void mo3410b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        aad.m8421b(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        m8686d(stringBuilder.toString());
    }

    public void mo3411b(boolean z) {
        synchronized (this.f7734c) {
            if (this.f7740i != null) {
                this.f7740i.zza(this.f7739h.m8558b(), z);
            } else {
                this.f7742k = z;
            }
        }
    }

    public void mo3412c() {
        m8634K();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f7736e.f12081a);
        mo3403a("onhide", hashMap);
    }

    protected void m8683c(String str) {
        synchronized (this.f7734c) {
            if (mo3435r()) {
                aad.m8426e("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void mo3413c(boolean z) {
        synchronized (this.f7734c) {
            this.f7748q = z;
        }
    }

    public void mo3414d() {
        if (this.f7756y == null) {
            qf.m13288a(this.f7721B.m13298a(), this.f7757z, "aes2");
            this.f7756y = qf.m13285a(this.f7721B.m13298a());
            this.f7721B.m13299a("native:view_show", this.f7756y);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f7736e.f12081a);
        mo3403a("onshow", hashMap);
    }

    protected void m8686d(String str) {
        if (C2590o.m8312g()) {
            if (m8656H() == null) {
                m8633J();
            }
            if (m8656H().booleanValue()) {
                m8669a(str, null);
                return;
            }
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            m8683c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        m8683c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public void mo3415d(boolean z) {
        synchronized (this.f7734c) {
            this.f7754w = (z ? 1 : -1) + this.f7754w;
            if (this.f7754w <= 0 && this.f7740i != null) {
                this.f7740i.zzhM();
            }
        }
    }

    public void destroy() {
        synchronized (this.f7734c) {
            m8641R();
            this.f7725F.m8392b();
            if (this.f7740i != null) {
                this.f7740i.close();
                this.f7740i.onDestroy();
                this.f7740i = null;
            }
            this.f7739h.m8569m();
            if (this.f7743l) {
                return;
            }
            zzw.zzdj().m13743a((aat) this);
            m8640Q();
            this.f7743l = true;
            zh.m15051a("Initiating WebView self destruct sequence in 3...");
            this.f7739h.m8563g();
        }
    }

    public void mo3417e() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzw.zzcM().m15160h()));
        hashMap.put("app_volume", String.valueOf(zzw.zzcM().m15157g()));
        hashMap.put("device_volume", String.valueOf(zzw.zzcM().m15163j(getContext())));
        mo3403a("volume", hashMap);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.f7734c;
        monitor-enter(r1);
        r0 = r2.mo3435r();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.internal.aad.m8426e(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.aay.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public Activity mo3418f() {
        return this.f7733b.m8631a();
    }

    protected void finalize() {
        try {
            synchronized (this.f7734c) {
                if (!this.f7743l) {
                    this.f7739h.m8569m();
                    zzw.zzdj().m13743a((aat) this);
                    m8640Q();
                    m8639P();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public Context mo3419g() {
        return this.f7733b.m8632b();
    }

    public com.google.android.gms.ads.internal.zze mo3420h() {
        return this.f7738g;
    }

    public zze mo3421i() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.f7734c) {
            com_google_android_gms_ads_internal_overlay_zze = this.f7740i;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zze mo3422j() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.f7734c) {
            com_google_android_gms_ads_internal_overlay_zze = this.f7723D;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zzeg mo3423k() {
        zzeg com_google_android_gms_internal_zzeg;
        synchronized (this.f7734c) {
            com_google_android_gms_internal_zzeg = this.f7741j;
        }
        return com_google_android_gms_internal_zzeg;
    }

    public aau mo3424l() {
        return this.f7739h;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.f7734c) {
            if (mo3435r()) {
                aad.m8426e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f7734c) {
            if (mo3435r()) {
                aad.m8426e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.f7734c) {
            if (mo3435r()) {
                aad.m8426e("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    zzw.zzcQ().m15000a(th, "AdWebViewImpl.loadUrl");
                    aad.m8424c("Could not call loadUrl. ", th);
                }
            }
        }
    }

    public boolean mo3428m() {
        boolean z;
        synchronized (this.f7734c) {
            z = this.f7742k;
        }
        return z;
    }

    public ed mo3429n() {
        return this.f7735d;
    }

    public zzqh mo3430o() {
        return this.f7736e;
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.f7734c) {
            super.onAttachedToWindow();
            if (!mo3435r()) {
                this.f7725F.m8393c();
            }
            boolean z2 = this.f7751t;
            if (mo3424l() == null || !mo3424l().m8559c()) {
                z = z2;
            } else if (!this.f7752u) {
                OnGlobalLayoutListener d = mo3424l().m8560d();
                if (d != null) {
                    zzw.zzdk().m8460a(mo3405b(), d);
                }
                OnScrollChangedListener e = mo3424l().m8561e();
                if (e != null) {
                    zzw.zzdk().m8461a(mo3405b(), e);
                }
                this.f7752u = true;
            }
            m8648e(z);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.f7734c) {
            if (!mo3435r()) {
                this.f7725F.m8394d();
            }
            super.onDetachedFromWindow();
            if (this.f7752u && mo3424l() != null && mo3424l().m8559c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener d = mo3424l().m8560d();
                if (d != null) {
                    zzw.zzcO().mo4260a(getViewTreeObserver(), d);
                }
                OnScrollChangedListener e = mo3424l().m8561e();
                if (e != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(e);
                }
                this.f7752u = false;
            }
        }
        m8648e(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzw.zzcM().m15117a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            aad.m8421b(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!mo3435r()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (mo3424l() != null && mo3424l().m8570n() != null) {
                    mo3424l().m8570n().mo3267a();
                }
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) qb.aE.m13225c()).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if ((motionEvent.getActionMasked() == 8 ? 1 : 0) != 0 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onGlobalLayout() {
        boolean G = m8655G();
        zze i = mo3421i();
        if (i != null && G) {
            i.zzhJ();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"DrawAllocation"})
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.f7734c;
        monitor-enter(r4);
        r1 = r9.mo3435r();	 Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x0019;
    L_0x0012:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
    L_0x0018:
        return;
    L_0x0019:
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x002e }
        if (r1 != 0) goto L_0x0029;
    L_0x001f:
        r1 = r9.f7744m;	 Catch:{ all -> 0x002e }
        if (r1 != 0) goto L_0x0029;
    L_0x0023:
        r1 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r1 = r1.f11902h;	 Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x0031;
    L_0x0029:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x0018;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        throw r0;
    L_0x0031:
        r1 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r1 = r1.f11903i;	 Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x0082;
    L_0x0037:
        r0 = com.google.android.gms.internal.qb.cs;	 Catch:{ all -> 0x002e }
        r0 = r0.m13225c();	 Catch:{ all -> 0x002e }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x002e }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x002e }
        if (r0 != 0) goto L_0x004b;
    L_0x0045:
        r0 = com.google.android.gms.common.util.C2590o.m8310e();	 Catch:{ all -> 0x002e }
        if (r0 != 0) goto L_0x0050;
    L_0x004b:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x0018;
    L_0x0050:
        r0 = "/contentHeight";
        r1 = r9.m8657I();	 Catch:{ all -> 0x002e }
        r9.mo3402a(r0, r1);	 Catch:{ all -> 0x002e }
        r0 = "(function() {  var height = -1;  if (document.body) { height = document.body.offsetHeight;}  else if (document.documentElement) {      height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  window.googleAdsJsInterface.notify(url);  })();";
        r9.m8686d(r0);	 Catch:{ all -> 0x002e }
        r0 = r9.f7733b;	 Catch:{ all -> 0x002e }
        r0 = r0.getResources();	 Catch:{ all -> 0x002e }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x002e }
        r0 = r0.density;	 Catch:{ all -> 0x002e }
        r1 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x002e }
        r2 = r9.f7755x;	 Catch:{ all -> 0x002e }
        switch(r2) {
            case -1: goto L_0x007d;
            default: goto L_0x0073;
        };	 Catch:{ all -> 0x002e }
    L_0x0073:
        r2 = r9.f7755x;	 Catch:{ all -> 0x002e }
        r2 = (float) r2;	 Catch:{ all -> 0x002e }
        r0 = r0 * r2;
        r0 = (int) r0;	 Catch:{ all -> 0x002e }
    L_0x0078:
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x0018;
    L_0x007d:
        r0 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x002e }
        goto L_0x0078;
    L_0x0082:
        r1 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r1 = r1.f11898d;	 Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x00a0;
    L_0x0088:
        r0 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x002e }
        r0.<init>();	 Catch:{ all -> 0x002e }
        r1 = r9.f7731L;	 Catch:{ all -> 0x002e }
        r1 = r1.getDefaultDisplay();	 Catch:{ all -> 0x002e }
        r1.getMetrics(r0);	 Catch:{ all -> 0x002e }
        r1 = r0.widthPixels;	 Catch:{ all -> 0x002e }
        r0 = r0.heightPixels;	 Catch:{ all -> 0x002e }
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x0018;
    L_0x00a0:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x002e }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x002e }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x002e }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x002e }
        if (r2 == r6) goto L_0x00b4;
    L_0x00b2:
        if (r2 != r8) goto L_0x014b;
    L_0x00b4:
        r2 = r3;
    L_0x00b5:
        if (r5 == r6) goto L_0x00b9;
    L_0x00b7:
        if (r5 != r8) goto L_0x00ba;
    L_0x00b9:
        r0 = r1;
    L_0x00ba:
        r5 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r5 = r5.f11900f;	 Catch:{ all -> 0x002e }
        if (r5 > r2) goto L_0x00c6;
    L_0x00c0:
        r2 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r2 = r2.f11897c;	 Catch:{ all -> 0x002e }
        if (r2 <= r0) goto L_0x0135;
    L_0x00c6:
        r0 = r9.f7733b;	 Catch:{ all -> 0x002e }
        r0 = r0.getResources();	 Catch:{ all -> 0x002e }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x002e }
        r0 = r0.density;	 Catch:{ all -> 0x002e }
        r2 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r2 = r2.f11900f;	 Catch:{ all -> 0x002e }
        r2 = (float) r2;	 Catch:{ all -> 0x002e }
        r2 = r2 / r0;
        r2 = (int) r2;	 Catch:{ all -> 0x002e }
        r5 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r5 = r5.f11897c;	 Catch:{ all -> 0x002e }
        r5 = (float) r5;	 Catch:{ all -> 0x002e }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x002e }
        r3 = (float) r3;	 Catch:{ all -> 0x002e }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x002e }
        r1 = (float) r1;	 Catch:{ all -> 0x002e }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x002e }
        r1 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002e }
        r6.<init>(r1);	 Catch:{ all -> 0x002e }
        r1 = "Not enough space to show ad. Needs ";
        r1 = r6.append(r1);	 Catch:{ all -> 0x002e }
        r1 = r1.append(r2);	 Catch:{ all -> 0x002e }
        r2 = "x";
        r1 = r1.append(r2);	 Catch:{ all -> 0x002e }
        r1 = r1.append(r5);	 Catch:{ all -> 0x002e }
        r2 = " dp, but only has ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x002e }
        r1 = r1.append(r3);	 Catch:{ all -> 0x002e }
        r2 = "x";
        r1 = r1.append(r2);	 Catch:{ all -> 0x002e }
        r0 = r1.append(r0);	 Catch:{ all -> 0x002e }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x002e }
        r0 = r0.toString();	 Catch:{ all -> 0x002e }
        com.google.android.gms.internal.aad.m8426e(r0);	 Catch:{ all -> 0x002e }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x002e }
        if (r0 == r7) goto L_0x012d;
    L_0x0129:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x002e }
    L_0x012d:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x002e }
    L_0x0132:
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x0018;
    L_0x0135:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x002e }
        if (r0 == r7) goto L_0x013f;
    L_0x013b:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x002e }
    L_0x013f:
        r0 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r0 = r0.f11900f;	 Catch:{ all -> 0x002e }
        r1 = r9.f7741j;	 Catch:{ all -> 0x002e }
        r1 = r1.f11897c;	 Catch:{ all -> 0x002e }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x002e }
        goto L_0x0132;
    L_0x014b:
        r2 = r0;
        goto L_0x00b5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.aay.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!mo3435r()) {
            try {
                C2590o.m8306a();
                super.onPause();
            } catch (Throwable e) {
                aad.m8422b("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!mo3435r()) {
            try {
                C2590o.m8306a();
                super.onResume();
            } catch (Throwable e) {
                aad.m8422b("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (mo3424l().m8559c()) {
            synchronized (this.f7734c) {
                if (this.f7753v != null) {
                    this.f7753v.mo3949a(motionEvent);
                }
            }
        } else if (this.f7735d != null) {
            this.f7735d.m10562a(motionEvent);
        }
        return mo3435r() ? false : super.onTouchEvent(motionEvent);
    }

    public boolean mo3433p() {
        boolean z;
        synchronized (this.f7734c) {
            z = this.f7744m;
        }
        return z;
    }

    public int mo3434q() {
        int i;
        synchronized (this.f7734c) {
            i = this.f7747p;
        }
        return i;
    }

    public boolean mo3435r() {
        boolean z;
        synchronized (this.f7734c) {
            z = this.f7743l;
        }
        return z;
    }

    public void mo3436s() {
        synchronized (this.f7734c) {
            zh.m15051a("Destroying WebView!");
            m8639P();
            zl.f11678a.post(new C26482(this));
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f7722C = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof aau) {
            this.f7739h = (aau) webViewClient;
        }
    }

    public void stopLoading() {
        if (!mo3435r()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                aad.m8422b("Could not stop loading webview.", e);
            }
        }
    }

    public boolean mo3442t() {
        boolean z;
        synchronized (this.f7734c) {
            z = this.f7748q;
        }
        return z;
    }

    public boolean mo3443u() {
        boolean z;
        synchronized (this.f7734c) {
            z = this.f7732a;
        }
        return z;
    }

    public String mo3444v() {
        String str;
        synchronized (this.f7734c) {
            str = this.f7749r;
        }
        return str;
    }

    public aas mo3445w() {
        return null;
    }

    public qh mo3446x() {
        return this.f7757z;
    }

    public qi mo3447y() {
        return this.f7721B;
    }

    public aaz mo3448z() {
        aaz com_google_android_gms_internal_aaz;
        synchronized (this.f7734c) {
            com_google_android_gms_internal_aaz = this.f7750s;
        }
        return com_google_android_gms_internal_aaz;
    }

    public void zzbV() {
        synchronized (this.f7734c) {
            this.f7732a = true;
            if (this.f7737f != null) {
                this.f7737f.zzbV();
            }
        }
    }

    public void zzbW() {
        synchronized (this.f7734c) {
            this.f7732a = false;
            if (this.f7737f != null) {
                this.f7737f.zzbW();
            }
        }
    }
}
