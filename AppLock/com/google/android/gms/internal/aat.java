package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.na.C2640b;
import java.util.Map;
import org.json.JSONObject;

@wh
public interface aat extends zzu, C2640b, tj {
    boolean mo3386A();

    void mo3387B();

    void mo3388C();

    @Nullable
    OnClickListener mo3389D();

    qw mo3390E();

    void mo3391F();

    WebView mo3392a();

    void mo3393a(int i);

    void mo3394a(Context context);

    void mo3395a(Context context, zzeg com_google_android_gms_internal_zzeg, qj qjVar);

    void mo3396a(zze com_google_android_gms_ads_internal_overlay_zze);

    void mo3397a(aaz com_google_android_gms_internal_aaz);

    void mo3399a(qw qwVar);

    void mo3400a(zzeg com_google_android_gms_internal_zzeg);

    void mo3401a(String str);

    void mo3384a(String str, String str2);

    void mo3403a(String str, Map<String, ?> map);

    void mo3385a(String str, JSONObject jSONObject);

    void mo3404a(boolean z);

    View mo3405b();

    void mo3406b(int i);

    void mo3407b(zze com_google_android_gms_ads_internal_overlay_zze);

    void mo3408b(String str);

    void mo3411b(boolean z);

    void mo3412c();

    void mo3413c(boolean z);

    void mo3414d();

    void mo3415d(boolean z);

    void destroy();

    void mo3417e();

    Activity mo3418f();

    Context mo3419g();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    com.google.android.gms.ads.internal.zze mo3420h();

    zze mo3421i();

    zze mo3422j();

    zzeg mo3423k();

    @Nullable
    aau mo3424l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    boolean mo3428m();

    void measure(int i, int i2);

    ed mo3429n();

    zzqh mo3430o();

    void onPause();

    void onResume();

    boolean mo3433p();

    int mo3434q();

    boolean mo3435r();

    void mo3436s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    boolean mo3442t();

    boolean mo3443u();

    String mo3444v();

    @Nullable
    aas mo3445w();

    @Nullable
    qh mo3446x();

    qi mo3447y();

    @Nullable
    aaz mo3448z();
}
