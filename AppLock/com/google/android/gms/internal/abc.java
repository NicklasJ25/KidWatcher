package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
@wh
public class abc extends abe {
    public abc(aat com_google_android_gms_internal_aat, boolean z) {
        super(com_google_android_gms_internal_aat, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return m8750a(webView, str, null);
    }
}
