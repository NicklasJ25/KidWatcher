package com.domobile.applock.chamber.controller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
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
import com.domobile.applock.chamber.model.SocialInfo;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p010b.C0782e;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.p003a.C0615f;
import com.domobile.frame.p000a.C1258c;
import com.domobile.widget.webview.NestedScrollWebView;
import java.io.File;
import java.net.URISyntaxException;

public class SocialVisitActivity extends C0386c {
    private static final LayoutParams f1127e = new LayoutParams(-1, -1);
    public ValueCallback<Uri[]> f1128d;
    private ProgressBar f1129k;
    private NestedScrollWebView f1130l;
    private AppBarLayout f1131m;
    private View f1132n;
    private FrameLayout f1133o;
    private CustomViewCallback f1134p;
    private SocialInfo f1135q;
    private Handler f1136r = new Handler(Looper.getMainLooper());

    class C08241 implements OnClickListener {
        final /* synthetic */ SocialVisitActivity f1116a;

        C08241(SocialVisitActivity socialVisitActivity) {
            this.f1116a = socialVisitActivity;
        }

        public void onClick(View view) {
            this.f1116a.mo2042a();
        }
    }

    class C08252 implements Runnable {
        final /* synthetic */ SocialVisitActivity f1117a;

        C08252(SocialVisitActivity socialVisitActivity) {
            this.f1117a = socialVisitActivity;
        }

        public void run() {
            this.f1117a.f1130l.loadUrl(this.f1117a.f1135q.m1531d());
        }
    }

    private class C0829a extends WebChromeClient {
        final /* synthetic */ SocialVisitActivity f1125a;

        private C0829a(SocialVisitActivity socialVisitActivity) {
            this.f1125a = socialVisitActivity;
        }

        public void m1347a(ValueCallback<Uri[]> valueCallback, String str) {
            this.f1125a.f1128d = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (TextUtils.isEmpty(str)) {
                intent.setType(GalleryUtils.MIME_TYPE_ALL);
            } else {
                intent.setType(str);
            }
            this.f1125a.startActivityForResult(Intent.createChooser(intent, ""), 100);
        }

        public View getVideoLoadingProgressView() {
            View frameLayout = new FrameLayout(this.f1125a);
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
            Intent intent = new Intent(this.f1125a, BrowserWindowActivity.class);
            intent.putExtra("EXTRA_URL", string);
            this.f1125a.startActivity(intent);
            return true;
        }

        public void onHideCustomView() {
            this.f1125a.m1351G();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                this.f1125a.f1129k.setVisibility(8);
                return;
            }
            this.f1125a.f1129k.setVisibility(0);
            this.f1125a.f1129k.setProgress(i);
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
            this.f1125a.m1353a(view, customViewCallback);
        }

        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            String str = null;
            if (!(fileChooserParams == null || fileChooserParams.getAcceptTypes() == null || fileChooserParams.getAcceptTypes().length <= 0)) {
                str = fileChooserParams.getAcceptTypes()[0];
            }
            m1347a(valueCallback, str);
            return true;
        }
    }

    private class C0830b extends WebViewClient {
        final /* synthetic */ SocialVisitActivity f1126a;

        private C0830b(SocialVisitActivity socialVisitActivity) {
            this.f1126a = socialVisitActivity;
        }

        private boolean m1348a(WebView webView, @NonNull String str, @Nullable WebResourceRequest webResourceRequest) {
            C1258c.m2987b(" shouldOverrideUrlLoading:" + str);
            this.f1126a.m1350F();
            if (str.startsWith("http://") || str.startsWith("https://")) {
                webView.loadUrl(str);
            } else if (str.startsWith("intent://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (this.f1126a.getPackageManager().getLaunchIntentForPackage(r0.getPackage()) != null) {
                        this.f1126a.startActivity(r0);
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("market://details?id=" + r0.getPackage()));
                        this.f1126a.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith("market://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (r0 != null) {
                        this.f1126a.startActivity(r0);
                    }
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    this.f1126a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return true;
        }

        private WebResourceResponse m1349b(WebView webView, @NonNull String str, @Nullable WebResourceRequest webResourceRequest) {
            return null;
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            super.onFormResubmission(webView, message, message2);
            C1258c.m2987b(" onFormResubmission:");
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1258c.m2987b(" onPageFinished:" + str);
            this.f1126a.m1366o();
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
            return m1349b(webView, webResourceRequest.getUrl().toString(), null);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return m1349b(webView, str, null);
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return m1348a(webView, webResourceRequest.getUrl().toString(), webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return m1348a(webView, str, null);
        }
    }

    static class C0831c extends FrameLayout {
        public C0831c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    private void m1350F() {
        if (TextUtils.isEmpty(this.f1135q.f1301c)) {
            this.f1130l.loadUrl(this.f1135q.m1532e());
        }
    }

    private void m1351G() {
        if (this.f1132n != null) {
            m1356b(true);
            ((FrameLayout) getWindow().getDecorView()).removeView(this.f1133o);
            this.f1133o = null;
            this.f1132n = null;
            this.f1134p.onCustomViewHidden();
            this.f1130l.setVisibility(0);
            setRequestedOrientation(1);
        }
    }

    private void m1353a(View view, CustomViewCallback customViewCallback) {
        if (this.f1132n != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        this.f1133o = new C0831c(this);
        this.f1133o.addView(view, f1127e);
        frameLayout.addView(this.f1133o, f1127e);
        this.f1132n = view;
        m1356b(false);
        this.f1134p = customViewCallback;
        setRequestedOrientation(0);
    }

    private void m1356b(boolean z) {
        getWindow().setFlags(z ? 0 : 1024, 1024);
    }

    private void m1361h() {
        this.f1135q = (SocialInfo) getIntent().getParcelableExtra("EXTRA_SOCIAL_INFO");
    }

    private void m1362k() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(this.f1135q.m1527a((Context) this));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new C08241(this));
        this.f1131m = (AppBarLayout) findViewById(R.id.appBarLayout);
    }

    private void m1363l() {
        this.f1129k = (ProgressBar) findViewById(R.id.pbLoadProgress);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m1364m() {
        this.f1130l = (NestedScrollWebView) findViewById(R.id.mWebView);
        WebSettings settings = this.f1130l.getSettings();
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
        this.f1130l.addJavascriptInterface(this, SocialInfo.JS_PREFIX);
        this.f1130l.setWebViewClient(new C0830b());
        this.f1130l.setWebChromeClient(new C0829a());
        C0793b.m1225a(this.f1130l);
    }

    private void m1365n() {
        this.f1130l.loadUrl(this.f1135q.m1530c());
    }

    private void m1366o() {
        if (!TextUtils.isEmpty(this.f1135q.f1301c)) {
            if (this.f1135q.f1300b == 11) {
                this.f1136r.removeCallbacksAndMessages(null);
                this.f1136r.postDelayed(new C08252(this), 2000);
                return;
            }
            this.f1130l.loadUrl(this.f1135q.m1531d());
        }
    }

    public View mo2359g() {
        return getLayoutInflater().inflate(R.layout.activity_social_visit, null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && this.f1128d != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (data == null) {
                this.f1128d.onReceiveValue(null);
                this.f1128d = null;
                return;
            }
            Object a = C0614e.m703a((Context) this, data);
            if (TextUtils.isEmpty(a)) {
                this.f1128d.onReceiveValue(null);
                this.f1128d = null;
                return;
            }
            data = Uri.fromFile(new File(a));
            if (VERSION.SDK_INT >= 21) {
                this.f1128d.onReceiveValue(new Uri[]{data});
            } else {
                this.f1128d.onReceiveValue(new Uri[]{data});
            }
            this.f1128d = null;
        }
    }

    public void onBackPressed() {
        if (this.f1132n != null) {
            m1351G();
        } else if (this.f1130l.canGoBack()) {
            this.f1130l.goBack();
            invalidateOptionsMenu();
        } else {
            mo2042a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m1361h();
        m1362k();
        m1363l();
        m1364m();
        m1365n();
        C1150y.m2605b((Context) this, (int) R.string.event_social_visit);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.social_visit_menus, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        C0793b.m1225a(this.f1130l);
    }

    @JavascriptInterface
    public void onJsInputAccount(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ SocialVisitActivity f1121b;

            public void run() {
                C1258c.m2987b("account:" + str);
                try {
                    if (!TextUtils.isEmpty(str.trim())) {
                        this.f1121b.f1135q.f1301c = str;
                        C0782e.m1211c(this.f1121b.f1135q);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @JavascriptInterface
    public void onJsInputHtml(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ SocialVisitActivity f1119b;

            public void run() {
                C1258c.m2987b("html:" + str);
                C0614e.m701a(str, C0615f.f548a + File.separator + "123" + File.separator + "test4.txt");
            }
        });
    }

    @JavascriptInterface
    public void onJsInputUser(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ SocialVisitActivity f1124c;

            public void run() {
                if (TextUtils.isEmpty(this.f1124c.f1135q.f1302d)) {
                    this.f1124c.f1135q.f1302d = str;
                    C0782e.m1207a(this.f1124c.f1135q.f1299a, str);
                }
                String str = "";
                try {
                    if (this.f1124c.f1135q.f1300b == 10) {
                        int indexOf = str2.indexOf("\"");
                        str = str2.substring(indexOf + 1, str2.lastIndexOf("\""));
                    } else {
                        str = str2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f1124c.f1135q.f1305g = str;
                    C0782e.m1210b(this.f1124c.f1135q.f1299a, str);
                }
                C1258c.m2987b("nickname:" + str + " avatar:" + str);
            }
        });
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
        this.f1130l.reload();
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
