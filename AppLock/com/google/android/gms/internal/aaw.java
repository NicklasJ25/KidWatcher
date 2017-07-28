package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.internal.na.C3084a;
import java.util.Map;
import org.json.JSONObject;

@wh
class aaw extends FrameLayout implements aat {
    private static final int f7712a = Color.argb(0, 0, 0, 0);
    private final aat f7713b;
    private final aas f7714c;

    public aaw(aat com_google_android_gms_internal_aat) {
        super(com_google_android_gms_internal_aat.getContext());
        this.f7713b = com_google_android_gms_internal_aat;
        this.f7714c = new aas(com_google_android_gms_internal_aat.mo3419g(), this, this);
        aau l = this.f7713b.mo3424l();
        if (l != null) {
            l.m8546a((aat) this);
        }
        addView(this.f7713b.mo3405b());
    }

    public boolean mo3386A() {
        return this.f7713b.mo3386A();
    }

    public void mo3387B() {
        this.f7713b.mo3387B();
    }

    public void mo3388C() {
        this.f7713b.mo3388C();
    }

    public OnClickListener mo3389D() {
        return this.f7713b.mo3389D();
    }

    @Nullable
    public qw mo3390E() {
        return this.f7713b.mo3390E();
    }

    public void mo3391F() {
        setBackgroundColor(f7712a);
        this.f7713b.setBackgroundColor(f7712a);
    }

    public WebView mo3392a() {
        return this.f7713b.mo3392a();
    }

    public void mo3393a(int i) {
        this.f7713b.mo3393a(i);
    }

    public void mo3394a(Context context) {
        this.f7713b.mo3394a(context);
    }

    public void mo3395a(Context context, zzeg com_google_android_gms_internal_zzeg, qj qjVar) {
        this.f7714c.m8475c();
        this.f7713b.mo3395a(context, com_google_android_gms_internal_zzeg, qjVar);
    }

    public void mo3396a(zze com_google_android_gms_ads_internal_overlay_zze) {
        this.f7713b.mo3396a(com_google_android_gms_ads_internal_overlay_zze);
    }

    public void mo3397a(aaz com_google_android_gms_internal_aaz) {
        this.f7713b.mo3397a(com_google_android_gms_internal_aaz);
    }

    public void mo3398a(C3084a c3084a) {
        this.f7713b.mo3398a(c3084a);
    }

    public void mo3399a(@Nullable qw qwVar) {
        this.f7713b.mo3399a(qwVar);
    }

    public void mo3400a(zzeg com_google_android_gms_internal_zzeg) {
        this.f7713b.mo3400a(com_google_android_gms_internal_zzeg);
    }

    public void mo3401a(String str) {
        this.f7713b.mo3401a(str);
    }

    public void mo3402a(String str, sc scVar) {
        this.f7713b.mo3402a(str, scVar);
    }

    public void mo3384a(String str, String str2) {
        this.f7713b.mo3384a(str, str2);
    }

    public void mo3403a(String str, Map<String, ?> map) {
        this.f7713b.mo3403a(str, (Map) map);
    }

    public void mo3385a(String str, JSONObject jSONObject) {
        this.f7713b.mo3385a(str, jSONObject);
    }

    public void mo3404a(boolean z) {
        this.f7713b.mo3404a(z);
    }

    public View mo3405b() {
        return this;
    }

    public void mo3406b(int i) {
        this.f7713b.mo3406b(i);
    }

    public void mo3407b(zze com_google_android_gms_ads_internal_overlay_zze) {
        this.f7713b.mo3407b(com_google_android_gms_ads_internal_overlay_zze);
    }

    public void mo3408b(String str) {
        this.f7713b.mo3408b(str);
    }

    public void mo3409b(String str, sc scVar) {
        this.f7713b.mo3409b(str, scVar);
    }

    public void mo3410b(String str, JSONObject jSONObject) {
        this.f7713b.mo3410b(str, jSONObject);
    }

    public void mo3411b(boolean z) {
        this.f7713b.mo3411b(z);
    }

    public void mo3412c() {
        this.f7713b.mo3412c();
    }

    public void mo3413c(boolean z) {
        this.f7713b.mo3413c(z);
    }

    public void mo3414d() {
        this.f7713b.mo3414d();
    }

    public void mo3415d(boolean z) {
        this.f7713b.mo3415d(z);
    }

    public void destroy() {
        this.f7713b.destroy();
    }

    public void mo3417e() {
        this.f7713b.mo3417e();
    }

    public Activity mo3418f() {
        return this.f7713b.mo3418f();
    }

    public Context mo3419g() {
        return this.f7713b.mo3419g();
    }

    public com.google.android.gms.ads.internal.zze mo3420h() {
        return this.f7713b.mo3420h();
    }

    public zze mo3421i() {
        return this.f7713b.mo3421i();
    }

    public zze mo3422j() {
        return this.f7713b.mo3422j();
    }

    public zzeg mo3423k() {
        return this.f7713b.mo3423k();
    }

    public aau mo3424l() {
        return this.f7713b.mo3424l();
    }

    public void loadData(String str, String str2, String str3) {
        this.f7713b.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f7713b.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.f7713b.loadUrl(str);
    }

    public boolean mo3428m() {
        return this.f7713b.mo3428m();
    }

    public ed mo3429n() {
        return this.f7713b.mo3429n();
    }

    public zzqh mo3430o() {
        return this.f7713b.mo3430o();
    }

    public void onPause() {
        this.f7714c.m8474b();
        this.f7713b.onPause();
    }

    public void onResume() {
        this.f7713b.onResume();
    }

    public boolean mo3433p() {
        return this.f7713b.mo3433p();
    }

    public int mo3434q() {
        return this.f7713b.mo3434q();
    }

    public boolean mo3435r() {
        return this.f7713b.mo3435r();
    }

    public void mo3436s() {
        this.f7714c.m8475c();
        this.f7713b.mo3436s();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f7713b.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f7713b.setOnTouchListener(onTouchListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f7713b.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f7713b.setWebViewClient(webViewClient);
    }

    public void stopLoading() {
        this.f7713b.stopLoading();
    }

    public boolean mo3442t() {
        return this.f7713b.mo3442t();
    }

    public boolean mo3443u() {
        return this.f7713b.mo3443u();
    }

    public String mo3444v() {
        return this.f7713b.mo3444v();
    }

    public aas mo3445w() {
        return this.f7714c;
    }

    public qh mo3446x() {
        return this.f7713b.mo3446x();
    }

    public qi mo3447y() {
        return this.f7713b.mo3447y();
    }

    public aaz mo3448z() {
        return this.f7713b.mo3448z();
    }

    public void zzbV() {
        this.f7713b.zzbV();
    }

    public void zzbW() {
        this.f7713b.zzbW();
    }
}
