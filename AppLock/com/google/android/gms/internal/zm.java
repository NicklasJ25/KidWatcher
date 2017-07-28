package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzw;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@TargetApi(8)
@wh
public class zm {

    @TargetApi(9)
    public static class C3482a extends zm {
        public C3482a() {
            super();
        }

        public int mo4247a() {
            return 6;
        }

        public boolean mo4248a(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int mo4249b() {
            return 7;
        }
    }

    @TargetApi(11)
    public static class C3484b extends C3482a {
        public aau mo4250a(aat com_google_android_gms_internal_aat, boolean z) {
            return new abc(com_google_android_gms_internal_aat, z);
        }

        public Set<String> mo4251a(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public boolean mo4248a(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean mo4252a(final Context context, final WebSettings webSettings) {
            super.mo4252a(context, webSettings);
            return ((Boolean) zz.m15285a(new Callable<Boolean>(this) {
                public Boolean m15194a() {
                    if (context.getCacheDir() != null) {
                        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                        webSettings.setAppCacheMaxSize(0);
                        webSettings.setAppCacheEnabled(true);
                    }
                    webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                    webSettings.setDatabaseEnabled(true);
                    webSettings.setDomStorageEnabled(true);
                    webSettings.setDisplayZoomControls(false);
                    webSettings.setBuiltInZoomControls(true);
                    webSettings.setSupportZoom(true);
                    webSettings.setAllowContentAccess(false);
                    return Boolean.valueOf(true);
                }

                public /* synthetic */ Object call() {
                    return m15194a();
                }
            })).booleanValue();
        }

        public boolean mo4253a(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        public boolean mo4254b(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public WebChromeClient mo4255c(aat com_google_android_gms_internal_aat) {
            return new abb(com_google_android_gms_internal_aat);
        }

        public boolean mo4256c(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    public static class C3485c extends C3484b {
        public String mo4257a(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient mo4255c(aat com_google_android_gms_internal_aat) {
            return new abd(com_google_android_gms_internal_aat);
        }
    }

    @TargetApi(16)
    public static class C3486f extends C3485c {
        public void mo4258a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                mo4260a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }

        public void mo4259a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void mo4260a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean mo4252a(Context context, WebSettings webSettings) {
            super.mo4252a(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }
    }

    @TargetApi(17)
    public static class C3487d extends C3486f {
        public Drawable mo4261a(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        public String mo4262a(Context context) {
            return aaa.m8384a().m8387c(context);
        }

        public boolean mo4252a(Context context, WebSettings webSettings) {
            super.mo4252a(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }

        public void mo4263b(Context context) {
            aaa.m8384a().m8386b(context);
            zzw.zzcQ().m15035x();
        }
    }

    @TargetApi(18)
    public static class C3488e extends C3487d {
        public boolean mo4264a(View view) {
            return super.mo4264a(view) || view.getWindowId() != null;
        }

        public int mo4265c() {
            return 14;
        }
    }

    @TargetApi(19)
    public static class C3489g extends C3488e {
        public boolean mo4264a(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams mo4266d() {
            return new LayoutParams(-1, -1);
        }
    }

    @TargetApi(21)
    public static class C3490h extends C3489g {
        public aau mo4250a(aat com_google_android_gms_internal_aat, boolean z) {
            return new abf(com_google_android_gms_internal_aat, z);
        }

        public CookieManager mo4267c(Context context) {
            try {
                return CookieManager.getInstance();
            } catch (Throwable e) {
                aad.m8422b("Failed to obtain CookieManager.", e);
                zzw.zzcQ().m15000a(e, "ApiLevelUtil.getCookieManager");
                return null;
            }
        }
    }

    private zm() {
    }

    public static zm m15167a(int i) {
        return i >= 21 ? new C3490h() : i >= 19 ? new C3489g() : i >= 18 ? new C3488e() : i >= 17 ? new C3487d() : i >= 16 ? new C3486f() : i >= 14 ? new C3485c() : i >= 11 ? new C3484b() : i >= 9 ? new C3482a() : new zm();
    }

    public int mo4247a() {
        return 0;
    }

    public Drawable mo4261a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public aau mo4250a(aat com_google_android_gms_internal_aat, boolean z) {
        return new aau(com_google_android_gms_internal_aat, z);
    }

    public String mo4262a(Context context) {
        return "";
    }

    public String mo4257a(SslError sslError) {
        return "";
    }

    public Set<String> mo4251a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void mo4258a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            mo4260a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void mo4259a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void mo4260a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean mo4248a(Request request) {
        return false;
    }

    public boolean mo4252a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean mo4264a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean mo4253a(Window window) {
        return false;
    }

    public boolean m15181a(aat com_google_android_gms_internal_aat) {
        if (com_google_android_gms_internal_aat == null) {
            return false;
        }
        com_google_android_gms_internal_aat.onPause();
        return true;
    }

    public int mo4249b() {
        return 1;
    }

    public void mo4263b(Context context) {
        zzw.zzcQ().m15035x();
    }

    public boolean mo4254b(View view) {
        return false;
    }

    public boolean m15185b(aat com_google_android_gms_internal_aat) {
        if (com_google_android_gms_internal_aat == null) {
            return false;
        }
        com_google_android_gms_internal_aat.onResume();
        return true;
    }

    public int mo4265c() {
        return 5;
    }

    public CookieManager mo4267c(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable e) {
            aad.m8422b("Failed to obtain CookieManager.", e);
            zzw.zzcQ().m15000a(e, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public WebChromeClient mo4255c(aat com_google_android_gms_internal_aat) {
        return null;
    }

    public boolean mo4256c(View view) {
        return false;
    }

    public LayoutParams mo4266d() {
        return new LayoutParams(-2, -2);
    }
}
