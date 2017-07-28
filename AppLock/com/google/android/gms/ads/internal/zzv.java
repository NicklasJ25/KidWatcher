package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.mm;
import com.google.android.gms.internal.mn;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.oo;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.ot.C2359a;
import com.google.android.gms.internal.ov;
import com.google.android.gms.internal.ox;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qn;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vk;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.xu;
import com.google.android.gms.internal.zk;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@wh
public class zzv extends C2359a {
    private final zzqh f7058a;
    private final zzeg f7059b;
    private final Future<mm> f7060c = m7585d();
    private final Context f7061d;
    private final C2407b f7062e;
    @Nullable
    private WebView f7063f = new WebView(this.f7061d);
    @Nullable
    private op f7064g;
    @Nullable
    private mm f7065h;
    private AsyncTask<Void, Void, String> f7066i;

    class C24031 extends WebViewClient {
        final /* synthetic */ zzv f7050a;

        C24031(zzv com_google_android_gms_ads_internal_zzv) {
            this.f7050a = com_google_android_gms_ads_internal_zzv;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (this.f7050a.f7064g != null) {
                try {
                    this.f7050a.f7064g.mo3854a(0);
                } catch (Throwable e) {
                    aad.m8424c("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(this.f7050a.m7591b())) {
                return false;
            }
            if (str.startsWith((String) qb.cI.m13225c())) {
                if (this.f7050a.f7064g != null) {
                    try {
                        this.f7050a.f7064g.mo3854a(3);
                    } catch (Throwable e) {
                        aad.m8424c("Could not call AdListener.onAdFailedToLoad().", e);
                    }
                }
                this.f7050a.m7590a(0);
                return true;
            } else if (str.startsWith((String) qb.cJ.m13225c())) {
                if (this.f7050a.f7064g != null) {
                    try {
                        this.f7050a.f7064g.mo3854a(0);
                    } catch (Throwable e2) {
                        aad.m8424c("Could not call AdListener.onAdFailedToLoad().", e2);
                    }
                }
                this.f7050a.m7590a(0);
                return true;
            } else if (str.startsWith((String) qb.cK.m13225c())) {
                if (this.f7050a.f7064g != null) {
                    try {
                        this.f7050a.f7064g.mo3856c();
                    } catch (Throwable e22) {
                        aad.m8424c("Could not call AdListener.onAdLoaded().", e22);
                    }
                }
                this.f7050a.m7590a(this.f7050a.m7588a(str));
                return true;
            } else if (str.startsWith("gmsg://")) {
                return true;
            } else {
                if (this.f7050a.f7064g != null) {
                    try {
                        this.f7050a.f7064g.mo3855b();
                    } catch (Throwable e222) {
                        aad.m8424c("Could not call AdListener.onAdLeftApplication().", e222);
                    }
                }
                this.f7050a.m7583c(this.f7050a.m7579b(str));
                return true;
            }
        }
    }

    class C24042 implements OnTouchListener {
        final /* synthetic */ zzv f7051a;

        C24042(zzv com_google_android_gms_ads_internal_zzv) {
            this.f7051a = com_google_android_gms_ads_internal_zzv;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f7051a.f7065h != null) {
                try {
                    this.f7051a.f7065h.m12566a(motionEvent);
                } catch (Throwable e) {
                    aad.m8424c("Unable to process ad data", e);
                }
            }
            return false;
        }
    }

    class C24053 implements Callable<mm> {
        final /* synthetic */ zzv f7052a;

        C24053(zzv com_google_android_gms_ads_internal_zzv) {
            this.f7052a = com_google_android_gms_ads_internal_zzv;
        }

        public mm m7567a() {
            return new mm(this.f7052a.f7058a.f12081a, this.f7052a.f7061d, false);
        }

        public /* synthetic */ Object call() {
            return m7567a();
        }
    }

    private class C2406a extends AsyncTask<Void, Void, String> {
        final /* synthetic */ zzv f7053a;

        private C2406a(zzv com_google_android_gms_ads_internal_zzv) {
            this.f7053a = com_google_android_gms_ads_internal_zzv;
        }

        protected String m7568a(Void... voidArr) {
            Throwable e;
            try {
                this.f7053a.f7065h = (mm) this.f7053a.f7060c.get(((Long) qb.cN.m13225c()).longValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                aad.m8424c("Failed to load ad data", e);
            } catch (ExecutionException e3) {
                e = e3;
                aad.m8424c("Failed to load ad data", e);
            } catch (TimeoutException e4) {
                aad.m8426e("Timed out waiting for ad data");
            }
            return this.f7053a.m7589a();
        }

        protected void m7569a(String str) {
            if (this.f7053a.f7063f != null && str != null) {
                this.f7053a.f7063f.loadUrl(str);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7568a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7569a((String) obj);
        }
    }

    private static class C2407b {
        private final String f7054a;
        private final Map<String, String> f7055b = new TreeMap();
        private String f7056c;
        private String f7057d;

        public C2407b(String str) {
            this.f7054a = str;
        }

        public String m7570a() {
            return this.f7057d;
        }

        public void m7571a(zzec com_google_android_gms_internal_zzec, zzqh com_google_android_gms_internal_zzqh) {
            this.f7056c = com_google_android_gms_internal_zzec.f11886j.f11919n;
            Bundle bundle = com_google_android_gms_internal_zzec.f11889m != null ? com_google_android_gms_internal_zzec.f11889m.getBundle(AdMobAdapter.class.getName()) : null;
            if (bundle != null) {
                String str = (String) qb.cM.m13225c();
                for (String str2 : bundle.keySet()) {
                    if (str.equals(str2)) {
                        this.f7057d = bundle.getString(str2);
                    } else if (str2.startsWith("csa_")) {
                        this.f7055b.put(str2.substring("csa_".length()), bundle.getString(str2));
                    }
                }
                this.f7055b.put("SDKVersion", com_google_android_gms_internal_zzqh.f12081a);
            }
        }

        public String m7572b() {
            return this.f7056c;
        }

        public String m7573c() {
            return this.f7054a;
        }

        public Map<String, String> m7574d() {
            return this.f7055b;
        }
    }

    public zzv(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzqh com_google_android_gms_internal_zzqh) {
        this.f7061d = context;
        this.f7058a = com_google_android_gms_internal_zzqh;
        this.f7059b = com_google_android_gms_internal_zzeg;
        this.f7062e = new C2407b(str);
        m7582c();
    }

    private String m7579b(String str) {
        if (this.f7065h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f7065h.m12567b(parse, this.f7061d);
        } catch (Throwable e) {
            aad.m8424c("Unable to process ad data", e);
        } catch (Throwable e2) {
            aad.m8424c("Unable to parse ad click url", e2);
        }
        return parse.toString();
    }

    private void m7582c() {
        m7590a(0);
        this.f7063f.setVerticalScrollBarEnabled(false);
        this.f7063f.getSettings().setJavaScriptEnabled(true);
        this.f7063f.setWebViewClient(new C24031(this));
        this.f7063f.setOnTouchListener(new C24042(this));
    }

    private void m7583c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f7061d.startActivity(intent);
    }

    private Future<mm> m7585d() {
        return zk.m15080a(new C24053(this));
    }

    int m7588a(String str) {
        int i = 0;
        Object queryParameter = Uri.parse(str).getQueryParameter("height");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                i = ol.m12979a().m8398a(this.f7061d, Integer.parseInt(queryParameter));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    String m7589a() {
        String valueOf;
        Uri a;
        Throwable e;
        String valueOf2;
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) qb.cL.m13225c());
        builder.appendQueryParameter("query", this.f7062e.m7572b());
        builder.appendQueryParameter("pubId", this.f7062e.m7573c());
        Map d = this.f7062e.m7574d();
        for (String valueOf3 : d.keySet()) {
            builder.appendQueryParameter(valueOf3, (String) d.get(valueOf3));
        }
        Uri build = builder.build();
        if (this.f7065h != null) {
            try {
                a = this.f7065h.m12565a(build, this.f7061d);
            } catch (mn e2) {
                e = e2;
                aad.m8424c("Unable to process ad data", e);
                a = build;
                valueOf2 = String.valueOf(m7591b());
                valueOf3 = String.valueOf(a.getEncodedQuery());
                return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
            } catch (RemoteException e3) {
                e = e3;
                aad.m8424c("Unable to process ad data", e);
                a = build;
                valueOf2 = String.valueOf(m7591b());
                valueOf3 = String.valueOf(a.getEncodedQuery());
                return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
            }
            valueOf2 = String.valueOf(m7591b());
            valueOf3 = String.valueOf(a.getEncodedQuery());
            return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
        }
        a = build;
        valueOf2 = String.valueOf(m7591b());
        valueOf3 = String.valueOf(a.getEncodedQuery());
        return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
    }

    void m7590a(int i) {
        if (this.f7063f != null) {
            this.f7063f.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    String m7591b() {
        String str;
        CharSequence a = this.f7062e.m7570a();
        if (TextUtils.isEmpty(a)) {
            str = "www.google.com";
        } else {
            CharSequence charSequence = a;
        }
        String valueOf = String.valueOf("https://");
        String str2 = (String) qb.cL.m13225c();
        return new StringBuilder((String.valueOf(valueOf).length() + String.valueOf(str).length()) + String.valueOf(str2).length()).append(valueOf).append(str).append(str2).toString();
    }

    public void destroy() {
        C2513c.m7940b("destroy must be called on the main UI thread.");
        this.f7066i.cancel(true);
        this.f7060c.cancel(true);
        this.f7063f.destroy();
        this.f7063f = null;
    }

    @Nullable
    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
        C2513c.m7940b("pause must be called on the main UI thread.");
    }

    public void resume() {
        C2513c.m7940b("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    public void stopLoading() {
    }

    public void zza(oo ooVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(op opVar) {
        this.f7064g = opVar;
    }

    public void zza(ov ovVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(ox oxVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(qn qnVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(vg vgVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(vk vkVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(xu xuVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public void zza(zzfc com_google_android_gms_internal_zzfc) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzft com_google_android_gms_internal_zzft) {
        throw new IllegalStateException("Unused method");
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        C2513c.m7933a(this.f7063f, (Object) "This Search Ad has already been torn down");
        this.f7062e.m7571a(com_google_android_gms_internal_zzec, this.f7058a);
        this.f7066i = new C2406a().execute(new Void[0]);
        return true;
    }

    public C2309a zzbB() {
        C2513c.m7940b("getAdFrame must be called on the main UI thread.");
        return C2312b.m7327a(this.f7063f);
    }

    public zzeg zzbC() {
        return this.f7059b;
    }

    public void zzbE() {
        throw new IllegalStateException("Unused method");
    }

    @Nullable
    public pb zzbF() {
        return null;
    }
}
