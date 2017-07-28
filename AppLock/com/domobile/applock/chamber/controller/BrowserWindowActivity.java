package com.domobile.applock.chamber.controller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.applock.C0386c;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.p003a.C0614e;
import com.domobile.frame.p000a.C1258c;
import com.domobile.widget.webview.NestedScrollWebView;
import java.io.File;
import java.net.URISyntaxException;

public class BrowserWindowActivity extends C0386c {
    private static final LayoutParams f1108e = new LayoutParams(-1, -1);
    public ValueCallback<Uri[]> f1109d;
    private ProgressBar f1110k;
    private NestedScrollWebView f1111l;
    private AppBarLayout f1112m;
    private View f1113n;
    private FrameLayout f1114o;
    private CustomViewCallback f1115p;

    class C08201 implements OnClickListener {
        final /* synthetic */ BrowserWindowActivity f1105a;

        C08201(BrowserWindowActivity browserWindowActivity) {
            this.f1105a = browserWindowActivity;
        }

        public void onClick(View view) {
            this.f1105a.mo2042a();
        }
    }

    private class C0821a extends WebChromeClient {
        final /* synthetic */ BrowserWindowActivity f1106a;

        private C0821a(BrowserWindowActivity browserWindowActivity) {
            this.f1106a = browserWindowActivity;
        }

        public void m1333a(ValueCallback<Uri[]> valueCallback, String str) {
            this.f1106a.f1109d = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (TextUtils.isEmpty(str)) {
                intent.setType(GalleryUtils.MIME_TYPE_ALL);
            } else {
                intent.setType(str);
            }
            this.f1106a.startActivityForResult(Intent.createChooser(intent, ""), 100);
        }

        public View getVideoLoadingProgressView() {
            View frameLayout = new FrameLayout(this.f1106a);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            return frameLayout;
        }

        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            C1258c.m2987b("onCreateWindow");
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Message obtainMessage = webView.getHandler().obtainMessage();
            webView.requestFocusNodeHref(obtainMessage);
            String string = obtainMessage.getData().getString("url");
            Intent intent = new Intent(this.f1106a, BrowserWindowActivity.class);
            intent.putExtra("EXTRA_URL", string);
            this.f1106a.startActivity(intent);
            return true;
        }

        public void onHideCustomView() {
            this.f1106a.m1345n();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                this.f1106a.f1110k.setVisibility(8);
                return;
            }
            this.f1106a.f1110k.setVisibility(0);
            this.f1106a.f1110k.setProgress(i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
            C1258c.m2987b("onReceivedIcon");
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            C1258c.m2987b("onReceivedTitle");
            ActionBar supportActionBar = this.f1106a.getSupportActionBar();
            if (supportActionBar != null && !TextUtils.isEmpty(str) && !str.startsWith("http://") && !str.startsWith("https://")) {
                supportActionBar.setTitle((CharSequence) str);
            }
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            this.f1106a.m1337a(view, customViewCallback);
        }

        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            String str = null;
            if (!(fileChooserParams == null || fileChooserParams.getAcceptTypes() == null || fileChooserParams.getAcceptTypes().length <= 0)) {
                str = fileChooserParams.getAcceptTypes()[0];
            }
            m1333a(valueCallback, str);
            return true;
        }
    }

    private class C0822b extends WebViewClient {
        final /* synthetic */ BrowserWindowActivity f1107a;

        private C0822b(BrowserWindowActivity browserWindowActivity) {
            this.f1107a = browserWindowActivity;
        }

        private boolean m1334a(WebView webView, @NonNull String str, @Nullable WebResourceRequest webResourceRequest) {
            C1258c.m2987b(" shouldOverrideUrlLoading:" + str);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                webView.loadUrl(str);
            } else if (str.startsWith("intent://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (this.f1107a.getPackageManager().getLaunchIntentForPackage(r0.getPackage()) != null) {
                        this.f1107a.startActivity(r0);
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("market://details?id=" + r0.getPackage()));
                        this.f1107a.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith("market://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (r0 != null) {
                        this.f1107a.startActivity(r0);
                    }
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    this.f1107a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return true;
        }

        private WebResourceResponse m1335b(WebView webView, @NonNull String str, @Nullable WebResourceRequest webResourceRequest) {
            return null;
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            super.onFormResubmission(webView, message, message2);
            C1258c.m2987b(" onFormResubmission:");
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1258c.m2987b(" onPageFinished:" + str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            C1258c.m2987b(" onPageStarted:" + str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            C1258c.m2987b(" onReceivedError:" + webResourceError);
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
            C1258c.m2987b(" onReceivedLoginRequest:" + str2);
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return m1335b(webView, webResourceRequest.getUrl().toString(), null);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return m1335b(webView, str, null);
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return m1334a(webView, webResourceRequest.getUrl().toString(), webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return m1334a(webView, str, null);
        }
    }

    static class C0823c extends FrameLayout {
        public C0823c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    private void m1337a(View view, CustomViewCallback customViewCallback) {
        if (this.f1113n != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        this.f1114o = new C0823c(this);
        this.f1114o.addView(view, f1108e);
        frameLayout.addView(this.f1114o, f1108e);
        this.f1113n = view;
        m1340b(false);
        this.f1115p = customViewCallback;
        setRequestedOrientation(0);
    }

    private void m1340b(boolean z) {
        getWindow().setFlags(z ? 0 : 1024, 1024);
    }

    private void m1341h() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) "");
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new C08201(this));
        this.f1112m = (AppBarLayout) findViewById(R.id.appBarLayout);
    }

    private void m1342k() {
        this.f1110k = (ProgressBar) findViewById(R.id.pbLoadProgress);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m1343l() {
        this.f1111l = (NestedScrollWebView) findViewById(R.id.mWebView);
        WebSettings settings = this.f1111l.getSettings();
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
        this.f1111l.setWebViewClient(new C0822b());
        this.f1111l.setWebChromeClient(new C0821a());
        C0793b.m1225a(this.f1111l);
    }

    private void m1344m() {
        this.f1111l.loadUrl(getIntent().getStringExtra("EXTRA_URL"));
    }

    private void m1345n() {
        if (this.f1113n != null) {
            m1340b(true);
            ((FrameLayout) getWindow().getDecorView()).removeView(this.f1114o);
            this.f1114o = null;
            this.f1113n = null;
            this.f1115p.onCustomViewHidden();
            this.f1111l.setVisibility(0);
            setRequestedOrientation(1);
        }
    }

    public View mo2359g() {
        return getLayoutInflater().inflate(R.layout.activity_browser_window, null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && this.f1109d != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (data == null) {
                this.f1109d.onReceiveValue(null);
                this.f1109d = null;
                return;
            }
            Object a = C0614e.m703a((Context) this, data);
            if (TextUtils.isEmpty(a)) {
                this.f1109d.onReceiveValue(null);
                this.f1109d = null;
                return;
            }
            data = Uri.fromFile(new File(a));
            if (VERSION.SDK_INT >= 21) {
                this.f1109d.onReceiveValue(new Uri[]{data});
            } else {
                this.f1109d.onReceiveValue(new Uri[]{data});
            }
            this.f1109d = null;
        }
    }

    public void onBackPressed() {
        if (this.f1113n != null) {
            m1345n();
        } else if (this.f1111l.canGoBack()) {
            this.f1111l.goBack();
            invalidateOptionsMenu();
        } else {
            mo2042a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m1341h();
        m1342k();
        m1343l();
        m1344m();
        C1150y.m2605b((Context) this, (int) R.string.event_browser_window);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.browser_window_menus, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        C0793b.m1225a(this.f1111l);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (getApplicationInfo().targetSdkVersion >= 5) {
            keyEvent.startTracking();
        } else {
            onBackPressed();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_action_refresh) {
            return false;
        }
        this.f1111l.reload();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    protected void onStop() {
        m80e();
        super.onStop();
    }
}
