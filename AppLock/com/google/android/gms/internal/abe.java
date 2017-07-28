package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@TargetApi(11)
@wh
public class abe extends aau {
    public abe(aat com_google_android_gms_internal_aat, boolean z) {
        super(com_google_android_gms_internal_aat, z);
    }

    protected WebResourceResponse m8749a(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", zzw.zzcM().m15106a(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zs(context).m15274a(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }

    protected WebResourceResponse m8750a(WebView webView, String str, @Nullable Map<String, String> map) {
        Exception e;
        String valueOf;
        if (webView instanceof aat) {
            aat com_google_android_gms_internal_aat = (aat) webView;
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (com_google_android_gms_internal_aat.mo3424l() != null) {
                com_google_android_gms_internal_aat.mo3424l().m8571o();
            }
            String str2 = com_google_android_gms_internal_aat.mo3423k().f11898d ? (String) qb.f10279S.m13225c() : com_google_android_gms_internal_aat.mo3433p() ? (String) qb.f10278R.m13225c() : (String) qb.f10277Q.m13225c();
            try {
                return m8749a(com_google_android_gms_internal_aat.getContext(), com_google_android_gms_internal_aat.mo3430o().f12081a, str2);
            } catch (IOException e2) {
                e = e2;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                aad.m8426e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                aad.m8426e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (InterruptedException e4) {
                e = e4;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                aad.m8426e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (TimeoutException e5) {
                e = e5;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                aad.m8426e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
        }
        aad.m8426e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }
}
