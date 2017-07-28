package com.facebook.ads.internal.p018m;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.C1462f;

public class C1730t {
    public static String m4977a() {
        if (TextUtils.isEmpty(C1462f.m3759a())) {
            return "https://www.facebook.com/";
        }
        return String.format("https://www.%s.facebook.com", new Object[]{C1462f.m3759a()});
    }

    public static void m4978a(WebView webView) {
        webView.loadUrl("about:blank");
        webView.clearCache(true);
    }

    @TargetApi(21)
    public static void m4979b(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            return;
        }
        try {
            WebSettings.class.getMethod("setMixedContentMode", new Class[0]).invoke(settings, new Object[]{Integer.valueOf(0)});
        } catch (Exception e) {
        }
    }
}
