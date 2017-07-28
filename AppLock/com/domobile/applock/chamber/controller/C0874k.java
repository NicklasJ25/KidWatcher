package com.domobile.applock.chamber.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.applock.C0400d;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.SocialInfo;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.view.DoWebView;
import com.domobile.applock.p003a.C0614e;
import com.domobile.frame.p000a.C1258c;
import java.io.File;
import java.net.URISyntaxException;

public class C0874k extends C0400d implements OnRefreshListener {
    private static final LayoutParams f1258h = new LayoutParams(-1, -1);
    public ValueCallback<Uri[]> f1259a;
    private ProgressBar f1260e;
    private DoWebView f1261f;
    private View f1262g;
    private FrameLayout f1263i;
    private CustomViewCallback f1264j;
    private SocialInfo f1265k;
    private Handler f1266l = new Handler(Looper.getMainLooper());
    private String f1267m = "";

    class C08691 implements Runnable {
        final /* synthetic */ C0874k f1253a;

        C08691(C0874k c0874k) {
            this.f1253a = c0874k;
        }

        public void run() {
            this.f1253a.f1261f.loadUrl(this.f1253a.f1265k.m1531d());
        }
    }

    private class C0871a extends WebChromeClient {
        final /* synthetic */ C0874k f1256a;

        private C0871a(C0874k c0874k) {
            this.f1256a = c0874k;
        }

        public void m1478a(ValueCallback<Uri[]> valueCallback, String str) {
            this.f1256a.f1259a = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (TextUtils.isEmpty(str)) {
                intent.setType(GalleryUtils.MIME_TYPE_ALL);
            } else {
                intent.setType(str);
            }
            this.f1256a.startActivityForResult(Intent.createChooser(intent, ""), 100);
        }

        public View getVideoLoadingProgressView() {
            View frameLayout = new FrameLayout(this.f1256a.getContext());
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            return frameLayout;
        }

        public void onHideCustomView() {
            this.f1256a.m1497i();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                this.f1256a.f1260e.setVisibility(8);
                return;
            }
            this.f1256a.f1260e.setVisibility(0);
            this.f1256a.f1260e.setProgress(i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
            C1258c.m2987b("onReceivedIcon");
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            C1258c.m2987b("onReceivedTitle");
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            this.f1256a.m1481a(view, customViewCallback);
        }

        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            String str = null;
            if (!(fileChooserParams == null || fileChooserParams.getAcceptTypes() == null || fileChooserParams.getAcceptTypes().length <= 0)) {
                str = fileChooserParams.getAcceptTypes()[0];
            }
            m1478a(valueCallback, str);
            return true;
        }
    }

    private class C0872b extends WebViewClient {
        final /* synthetic */ C0874k f1257a;

        private C0872b(C0874k c0874k) {
            this.f1257a = c0874k;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1258c.m2987b(" onPageFinished:" + str);
            this.f1257a.b.invalidateOptionsMenu();
            this.f1257a.m1493f();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            C1258c.m2987b(" onPageStarted:" + str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            C1258c.m2987b(" onReceivedError:" + webResourceError);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C1258c.m2987b(" shouldOverrideUrlLoading:" + str);
            if (str == null) {
                return false;
            }
            this.f1257a.m1494g();
            if (str.startsWith("http://") || str.startsWith("https://")) {
                webView.loadUrl(str);
            } else if (str.startsWith("intent://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (this.f1257a.getContext().getPackageManager().getLaunchIntentForPackage(r0.getPackage()) != null) {
                        this.f1257a.startActivity(r0);
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("market://details?id=" + r0.getPackage()));
                        this.f1257a.startActivity(intent);
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith("market://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (r0 != null) {
                        this.f1257a.startActivity(r0);
                    }
                    return true;
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    this.f1257a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return true;
        }
    }

    static class C0873c extends FrameLayout {
        public C0873c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    private void m1481a(View view, CustomViewCallback customViewCallback) {
        if (this.f1262g != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.mActivity.getWindow().getDecorView();
        this.f1263i = new C0873c(getContext());
        this.f1263i.addView(view, f1258h);
        frameLayout.addView(this.f1263i, f1258h);
        this.f1262g = view;
        m1483a(false);
        this.f1264j = customViewCallback;
        this.mActivity.setRequestedOrientation(0);
    }

    private void m1483a(boolean z) {
        this.mActivity.getWindow().setFlags(z ? 0 : 1024, 1024);
    }

    private boolean m1485b() {
        if (this.f1262g != null) {
            m1497i();
            return true;
        } else if (!this.f1261f.canGoBack()) {
            return false;
        } else {
            this.f1261f.goBack();
            return true;
        }
    }

    private void m1486c() {
        this.f1260e = (ProgressBar) findViewById(R.id.pbLoadProgress);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m1488d() {
        this.f1261f = (DoWebView) findViewById(R.id.mWebView);
        C0793b.m1225a(this.f1261f);
        WebSettings settings = this.f1261f.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        settings.setBuiltInZoomControls(true);
        settings.setSupportMultipleWindows(true);
        settings.setGeolocationEnabled(true);
        settings.setDisplayZoomControls(false);
        this.f1261f.addJavascriptInterface(this, SocialInfo.JS_PREFIX);
        this.f1261f.setWebViewClient(new C0872b());
        this.f1261f.setWebChromeClient(new C0871a());
    }

    private void m1490e() {
        this.f1261f.loadUrl(this.f1265k.m1530c());
    }

    private void m1493f() {
        if (!TextUtils.isEmpty(this.f1265k.f1301c)) {
            if (this.f1265k.f1300b == 11) {
                this.f1266l.removeCallbacksAndMessages(null);
                this.f1266l.postDelayed(new C08691(this), 2000);
                return;
            }
            this.f1261f.loadUrl(this.f1265k.m1531d());
        }
    }

    private void m1494g() {
        if (TextUtils.isEmpty(this.f1265k.f1301c) && TextUtils.isEmpty(this.f1267m)) {
            this.f1261f.loadUrl(this.f1265k.m1532e());
        }
    }

    private void m1496h() {
    }

    private void m1497i() {
        if (this.f1262g != null) {
            m1483a(true);
            ((FrameLayout) this.mActivity.getWindow().getDecorView()).removeView(this.f1263i);
            this.f1263i = null;
            this.f1262g = null;
            this.f1264j.onCustomViewHidden();
            this.f1261f.setVisibility(0);
            this.mActivity.setRequestedOrientation(1);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_social_visit, null);
        m1486c();
        m1488d();
        m1490e();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && this.f1259a != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (data == null) {
                this.f1259a.onReceiveValue(null);
                this.f1259a = null;
                return;
            }
            Object a = C0614e.m703a(this.mActivity, data);
            if (TextUtils.isEmpty(a)) {
                this.f1259a.onReceiveValue(null);
                this.f1259a = null;
                return;
            }
            data = Uri.fromFile(new File(a));
            if (VERSION.SDK_INT >= 21) {
                this.f1259a.onReceiveValue(new Uri[]{data});
            } else {
                this.f1259a.onReceiveValue(new Uri[]{data});
            }
            this.f1259a = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1265k = (SocialInfo) getArguments().getParcelable("EXTRA_SOCIAL_INFO");
        if (this.f1265k != null) {
            this.b.m54a(this.f1265k.m1527a(this.mActivity));
        }
        this.b.m66r().setNavigationIcon((int) R.drawable.icon_close_white);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.social_visit_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        super.onDestroy();
        C0793b.m1225a(this.f1261f);
    }

    @JavascriptInterface
    public void onJsInputAccount(final String str) {
        this.b.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C0874k f1255b;

            public void run() {
                C1258c.m2987b("account:" + str);
                this.f1255b.f1267m = str;
                this.f1255b.m1496h();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? m1485b() : super.onKeyDown(i, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_action_refresh) {
            return false;
        }
        this.f1261f.loadUrl(this.f1265k.m1532e());
        return true;
    }

    public void onRefresh() {
        this.f1261f.reload();
    }
}
