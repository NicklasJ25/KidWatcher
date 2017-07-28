package com.facebook.ads.internal.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p018m.C1730t;

public abstract class C1748a extends WebView {
    private static final String f4407a = C1748a.class.getSimpleName();
    private boolean f4408b;

    public C1748a(Context context) {
        super(context);
        m5015c();
    }

    private void m5015c() {
        setWebChromeClient(mo2779a());
        setWebViewClient(mo2780b());
        C1730t.m4979b(this);
        getSettings().setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        if (VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            } catch (Exception e) {
                Log.w(f4407a, "Failed to initialize CookieManager.");
            }
        }
    }

    protected WebChromeClient mo2779a() {
        return new WebChromeClient();
    }

    protected WebViewClient mo2780b() {
        return new WebViewClient();
    }

    public void destroy() {
        this.f4408b = true;
        super.destroy();
    }

    public boolean m5018e() {
        return this.f4408b;
    }
}
