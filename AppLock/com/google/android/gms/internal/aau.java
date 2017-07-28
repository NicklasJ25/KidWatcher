package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzw;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@wh
public class aau extends WebViewClient {
    private static final String[] f7666c = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] f7667d = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private boolean f7668A;
    private boolean f7669B;
    private boolean f7670C;
    private int f7671D;
    protected aat f7672a;
    @Nullable
    protected yp f7673b;
    private final HashMap<String, List<sc>> f7674e;
    private final Object f7675f;
    private ny f7676g;
    private zzh f7677h;
    private C2340a f7678i;
    private C2643b f7679j;
    private rx f7680k;
    private C2377c f7681l;
    private boolean f7682m;
    private se f7683n;
    private sg f7684o;
    private boolean f7685p;
    private boolean f7686q;
    private OnGlobalLayoutListener f7687r;
    private OnScrollChangedListener f7688s;
    private boolean f7689t;
    private zzq f7690u;
    private final uw f7691v;
    private zzf f7692w;
    private us f7693x;
    private uy f7694y;
    private C2375e f7695z;

    public interface C2340a {
        void mo3168a(aat com_google_android_gms_internal_aat, boolean z);
    }

    public interface C2375e {
        void mo3267a();
    }

    public interface C2377c {
        void mo3268a();
    }

    class C26411 implements Runnable {
        final /* synthetic */ aau f7662a;

        C26411(aau com_google_android_gms_internal_aau) {
            this.f7662a = com_google_android_gms_internal_aau;
        }

        public void run() {
            if (this.f7662a.f7673b != null) {
                yp ypVar = this.f7662a.f7673b;
                aat com_google_android_gms_internal_aat = this.f7662a.f7672a;
            }
        }
    }

    class C26422 implements Runnable {
        final /* synthetic */ aau f7663a;

        C26422(aau com_google_android_gms_internal_aau) {
            this.f7663a = com_google_android_gms_internal_aau;
        }

        public void run() {
            this.f7663a.f7672a.mo3387B();
            zze i = this.f7663a.f7672a.mo3421i();
            if (i != null) {
                i.zzhG();
            }
            if (this.f7663a.f7681l != null) {
                this.f7663a.f7681l.mo3268a();
                this.f7663a.f7681l = null;
            }
        }
    }

    public interface C2643b {
        void mo4180a(aat com_google_android_gms_internal_aat);
    }

    private static class C2644d implements zzh {
        private aat f7664a;
        private zzh f7665b;

        public C2644d(aat com_google_android_gms_internal_aat, zzh com_google_android_gms_ads_internal_overlay_zzh) {
            this.f7664a = com_google_android_gms_internal_aat;
            this.f7665b = com_google_android_gms_ads_internal_overlay_zzh;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzbN() {
            this.f7665b.zzbN();
            this.f7664a.mo3412c();
        }

        public void zzbO() {
            this.f7665b.zzbO();
            this.f7664a.mo3414d();
        }
    }

    public aau(aat com_google_android_gms_internal_aat, boolean z) {
        this(com_google_android_gms_internal_aat, z, new uw(com_google_android_gms_internal_aat, com_google_android_gms_internal_aat.mo3419g(), new ps(com_google_android_gms_internal_aat.getContext())), null);
    }

    aau(aat com_google_android_gms_internal_aat, boolean z, uw uwVar, us usVar) {
        this.f7674e = new HashMap();
        this.f7675f = new Object();
        this.f7682m = false;
        this.f7672a = com_google_android_gms_internal_aat;
        this.f7685p = z;
        this.f7691v = uwVar;
        this.f7693x = usVar;
    }

    private String m8535a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private void m8536a(Context context, String str, String str2, String str3) {
        if (((Boolean) qb.bs.m13225c()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", m8535a(str3));
            zzw.zzcM().m15120a(context, this.f7672a.mo3430o().f12081a, "gmob-apps", bundle, true);
        }
    }

    private static boolean m8537b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m8538p() {
        if (this.f7679j != null) {
            this.f7679j.mo4180a(this.f7672a);
            this.f7679j = null;
        }
    }

    public zzf m8539a() {
        return this.f7692w;
    }

    public void m8540a(int i, int i2) {
        if (this.f7693x != null) {
            this.f7693x.m14293c(i, i2);
        }
    }

    public void m8541a(int i, int i2, boolean z) {
        this.f7691v.m14316a(i, i2);
        if (this.f7693x != null) {
            this.f7693x.m14287a(i, i2, z);
        }
    }

    public void m8542a(Uri uri) {
        String path = uri.getPath();
        List<sc> list = (List) this.f7674e.get(path);
        if (list != null) {
            Map a = zzw.zzcM().m15111a(uri);
            if (aad.m8420a(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                zh.m15051a(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : a.keySet()) {
                    str = (String) a.get(path2);
                    zh.m15051a(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (sc a2 : list) {
                a2.mo3260a(this.f7672a, a);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        zh.m15051a(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    public final void m8543a(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.f7675f) {
            this.f7686q = true;
            this.f7672a.mo3387B();
            this.f7687r = onGlobalLayoutListener;
            this.f7688s = onScrollChangedListener;
        }
    }

    public void m8544a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean b = this.f7693x != null ? this.f7693x.m14292b() : false;
        com.google.android.gms.ads.internal.overlay.zzf zzcK = zzw.zzcK();
        Context context = this.f7672a.getContext();
        if (!b) {
            z = true;
        }
        zzcK.zza(context, adOverlayInfoParcel, z);
        if (this.f7673b != null && adOverlayInfoParcel.url == null && adOverlayInfoParcel.zzNE != null) {
            String str = adOverlayInfoParcel.zzNE.url;
        }
    }

    public final void m8545a(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean p = this.f7672a.mo3433p();
        ny nyVar = (!p || this.f7672a.mo3423k().f11898d) ? this.f7676g : null;
        if (!p) {
            com_google_android_gms_ads_internal_overlay_zzh = this.f7677h;
        }
        m8544a(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, nyVar, com_google_android_gms_ads_internal_overlay_zzh, this.f7690u, this.f7672a.mo3430o()));
    }

    public void m8546a(aat com_google_android_gms_internal_aat) {
        this.f7672a = com_google_android_gms_internal_aat;
    }

    public void m8547a(C2340a c2340a) {
        this.f7678i = c2340a;
    }

    public void m8548a(C2643b c2643b) {
        this.f7679j = c2643b;
    }

    public void m8549a(C2377c c2377c) {
        this.f7681l = c2377c;
    }

    public void m8550a(C2375e c2375e) {
        this.f7695z = c2375e;
    }

    public void m8551a(ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, rx rxVar, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, se seVar, @Nullable sg sgVar, zzf com_google_android_gms_ads_internal_zzf, uy uyVar, @Nullable yp ypVar) {
        if (com_google_android_gms_ads_internal_zzf == null) {
            com_google_android_gms_ads_internal_zzf = new zzf(this.f7672a.getContext());
        }
        this.f7693x = new us(this.f7672a, uyVar);
        this.f7673b = ypVar;
        m8552a("/appEvent", new rw(rxVar));
        m8552a("/backButton", sb.f10539l);
        m8552a("/refresh", sb.f10540m);
        m8552a("/canOpenURLs", sb.f10529b);
        m8552a("/canOpenIntents", sb.f10530c);
        m8552a("/click", sb.f10531d);
        m8552a("/close", sb.f10532e);
        m8552a("/customClose", sb.f10534g);
        m8552a("/instrument", sb.f10545r);
        m8552a("/delayPageLoaded", sb.f10547t);
        m8552a("/delayPageClosed", sb.f10548u);
        m8552a("/getLocationInfo", sb.f10549v);
        m8552a("/httpTrack", sb.f10535h);
        m8552a("/log", sb.f10536i);
        m8552a("/mraid", new sj(com_google_android_gms_ads_internal_zzf, this.f7693x));
        m8552a("/mraidLoaded", this.f7691v);
        m8552a("/open", new sk(seVar, com_google_android_gms_ads_internal_zzf, this.f7693x));
        m8552a("/precache", sb.f10544q);
        m8552a("/touch", sb.f10538k);
        m8552a("/video", sb.f10541n);
        m8552a("/videoMeta", sb.f10542o);
        m8552a("/appStreaming", sb.f10533f);
        if (zzw.zzdl().m14943a()) {
            m8552a("/logScionEvent", sb.f10543p);
        }
        if (sgVar != null) {
            m8552a("/setInterstitialProperties", new sf(sgVar));
        }
        this.f7676g = nyVar;
        this.f7677h = com_google_android_gms_ads_internal_overlay_zzh;
        this.f7680k = rxVar;
        this.f7683n = seVar;
        this.f7690u = com_google_android_gms_ads_internal_overlay_zzq;
        this.f7692w = com_google_android_gms_ads_internal_zzf;
        this.f7694y = uyVar;
        this.f7684o = sgVar;
        m8553a(z);
    }

    public void m8552a(String str, sc scVar) {
        synchronized (this.f7675f) {
            List list = (List) this.f7674e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f7674e.put(str, list);
            }
            list.add(scVar);
        }
    }

    public void m8553a(boolean z) {
        this.f7682m = z;
    }

    public final void m8554a(boolean z, int i) {
        ny nyVar = (!this.f7672a.mo3433p() || this.f7672a.mo3423k().f11898d) ? this.f7676g : null;
        m8544a(new AdOverlayInfoParcel(nyVar, this.f7677h, this.f7690u, this.f7672a, z, i, this.f7672a.mo3430o()));
    }

    public final void m8555a(boolean z, int i, String str) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean p = this.f7672a.mo3433p();
        ny nyVar = (!p || this.f7672a.mo3423k().f11898d) ? this.f7676g : null;
        if (!p) {
            com_google_android_gms_ads_internal_overlay_zzh = new C2644d(this.f7672a, this.f7677h);
        }
        m8544a(new AdOverlayInfoParcel(nyVar, com_google_android_gms_ads_internal_overlay_zzh, this.f7680k, this.f7690u, this.f7672a, z, i, str, this.f7672a.mo3430o(), this.f7683n));
    }

    public final void m8556a(boolean z, int i, String str, String str2) {
        boolean p = this.f7672a.mo3433p();
        ny nyVar = (!p || this.f7672a.mo3423k().f11898d) ? this.f7676g : null;
        m8544a(new AdOverlayInfoParcel(nyVar, p ? null : new C2644d(this.f7672a, this.f7677h), this.f7680k, this.f7690u, this.f7672a, z, i, str, str2, this.f7672a.mo3430o(), this.f7683n));
    }

    public void m8557b(String str, sc scVar) {
        synchronized (this.f7675f) {
            List list = (List) this.f7674e.get(str);
            if (list == null) {
                return;
            }
            list.remove(scVar);
        }
    }

    public boolean m8558b() {
        boolean z;
        synchronized (this.f7675f) {
            z = this.f7685p;
        }
        return z;
    }

    public boolean m8559c() {
        boolean z;
        synchronized (this.f7675f) {
            z = this.f7686q;
        }
        return z;
    }

    public OnGlobalLayoutListener m8560d() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.f7675f) {
            onGlobalLayoutListener = this.f7687r;
        }
        return onGlobalLayoutListener;
    }

    public OnScrollChangedListener m8561e() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.f7675f) {
            onScrollChangedListener = this.f7688s;
        }
        return onScrollChangedListener;
    }

    public boolean m8562f() {
        boolean z;
        synchronized (this.f7675f) {
            z = this.f7689t;
        }
        return z;
    }

    public void m8563g() {
        synchronized (this.f7675f) {
            zh.m15051a("Loading blank page in WebView, 2...");
            this.f7668A = true;
            this.f7672a.mo3401a("about:blank");
        }
    }

    public void m8564h() {
        if (this.f7673b != null) {
            zl.f11678a.post(new C26411(this));
        }
    }

    public void m8565i() {
        synchronized (this.f7675f) {
            this.f7689t = true;
        }
        this.f7671D++;
        m8568l();
    }

    public void m8566j() {
        this.f7671D--;
        m8568l();
    }

    public void m8567k() {
        this.f7670C = true;
        m8568l();
    }

    public final void m8568l() {
        if (this.f7678i != null && ((this.f7669B && this.f7671D <= 0) || this.f7670C)) {
            this.f7678i.mo3168a(this.f7672a, !this.f7670C);
            this.f7678i = null;
        }
        this.f7672a.mo3388C();
    }

    public final void m8569m() {
        if (this.f7673b != null) {
            this.f7673b = null;
        }
        synchronized (this.f7675f) {
            this.f7674e.clear();
            this.f7676g = null;
            this.f7677h = null;
            this.f7678i = null;
            this.f7679j = null;
            this.f7680k = null;
            this.f7682m = false;
            this.f7685p = false;
            this.f7686q = false;
            this.f7689t = false;
            this.f7683n = null;
            this.f7690u = null;
            this.f7681l = null;
            if (this.f7693x != null) {
                this.f7693x.m14289a(true);
                this.f7693x = null;
            }
        }
    }

    public C2375e m8570n() {
        return this.f7695z;
    }

    public final void m8571o() {
        synchronized (this.f7675f) {
            this.f7682m = false;
            this.f7685p = true;
            zzw.zzcM().m15125a(new C26422(this));
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        zh.m15051a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m8542a(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f7675f) {
            if (this.f7668A) {
                zh.m15051a("Blank page loaded, 1...");
                this.f7672a.mo3436s();
                return;
            }
            this.f7669B = true;
            m8538p();
            m8568l();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= f7666c.length) ? String.valueOf(i) : f7666c[(-i) - 1];
        m8536a(this.f7672a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f7667d.length) ? String.valueOf(primaryError) : f7667d[primaryError];
            m8536a(this.f7672a.getContext(), "ssl_err", valueOf, zzw.zzcO().mo4257a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            zzds a = zzds.m15379a(str);
            if (a == null) {
                return null;
            }
            zzdp a2 = zzw.zzcR().m12847a(a);
            return (a2 == null || !a2.m15375a()) ? null : new WebResourceResponse("", "", a2.m15376b());
        } catch (Throwable th) {
            zzw.zzcQ().m15000a(th, "AdWebViewClient.shouldInterceptRequest");
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        zh.m15051a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m8542a(parse);
        } else if (this.f7682m && webView == this.f7672a.mo3392a() && m8537b(parse)) {
            if (this.f7676g != null && ((Boolean) qb.aq.m13225c()).booleanValue()) {
                this.f7676g.onAdClicked();
                this.f7676g = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.f7672a.mo3392a().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(str);
            aad.m8426e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri;
            try {
                ed n = this.f7672a.mo3429n();
                if (n != null && n.m10568c(parse)) {
                    parse = n.m10560a(parse, this.f7672a.getContext(), this.f7672a.mo3405b());
                }
                uri = parse;
            } catch (ee e) {
                String str3 = "Unable to append parameter to URL: ";
                str2 = String.valueOf(str);
                aad.m8426e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                uri = parse;
            }
            if (this.f7692w == null || this.f7692w.zzcd()) {
                m8545a(new zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.f7692w.zzx(str);
            }
        }
        return true;
    }
}
