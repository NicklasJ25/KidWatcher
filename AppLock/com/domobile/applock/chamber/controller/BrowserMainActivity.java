package com.domobile.applock.chamber.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.DownloadListener;
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.applock.C0386c;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p009c.C0795c;
import com.domobile.applock.chamber.p010b.C0778a;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.p003a.C0630k;
import com.domobile.frame.p000a.C1258c;
import com.domobile.widget.webview.NestedScrollWebView;
import java.io.File;
import java.net.URISyntaxException;

public class BrowserMainActivity extends C0386c implements DownloadListener {
    private static final LayoutParams f1095p = new LayoutParams(-1, -1);
    public ValueCallback<Uri[]> f1096d;
    private EditText f1097e;
    private ProgressBar f1098k;
    private NestedScrollWebView f1099l;
    private AppBarLayout f1100m;
    private View f1101n;
    private View f1102o;
    private FrameLayout f1103q;
    private CustomViewCallback f1104r;

    class C08151 implements OnClickListener {
        final /* synthetic */ BrowserMainActivity f1091a;

        C08151(BrowserMainActivity browserMainActivity) {
            this.f1091a = browserMainActivity;
        }

        public void onClick(View view) {
            this.f1091a.mo2042a();
        }
    }

    class C08162 implements OnEditorActionListener {
        final /* synthetic */ BrowserMainActivity f1092a;

        C08162(BrowserMainActivity browserMainActivity) {
            this.f1092a = browserMainActivity;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 2) {
                String obj = this.f1092a.f1097e.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.f1092a.m1321b(obj);
                    this.f1092a.m1330n();
                }
            }
            return false;
        }
    }

    private class C0817a extends WebChromeClient {
        final /* synthetic */ BrowserMainActivity f1093a;

        private C0817a(BrowserMainActivity browserMainActivity) {
            this.f1093a = browserMainActivity;
        }

        public void m1315a(ValueCallback<Uri[]> valueCallback, String str) {
            this.f1093a.f1096d = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (TextUtils.isEmpty(str)) {
                intent.setType(GalleryUtils.MIME_TYPE_ALL);
            } else {
                intent.setType(str);
            }
            this.f1093a.startActivityForResult(Intent.createChooser(intent, ""), 100);
        }

        public View getVideoLoadingProgressView() {
            View frameLayout = new FrameLayout(this.f1093a);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            return frameLayout;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Message obtainMessage = webView.getHandler().obtainMessage();
            webView.requestFocusNodeHref(obtainMessage);
            String string = obtainMessage.getData().getString("url");
            Intent intent = new Intent(this.f1093a, BrowserWindowActivity.class);
            intent.putExtra("EXTRA_URL", string);
            this.f1093a.startActivity(intent);
            return true;
        }

        public void onHideCustomView() {
            this.f1093a.m1329m();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                this.f1093a.f1098k.setVisibility(8);
                return;
            }
            this.f1093a.f1098k.setVisibility(0);
            this.f1093a.f1098k.setProgress(i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
            C1258c.m2987b("onReceivedIcon");
            C0793b.m1223a(this.f1093a, Uri.parse(webView.getUrl()).getHost(), bitmap);
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            C1258c.m2987b("onReceivedTitle");
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            this.f1093a.m1317a(view, customViewCallback);
        }

        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            String str = null;
            if (!(fileChooserParams == null || fileChooserParams.getAcceptTypes() == null || fileChooserParams.getAcceptTypes().length <= 0)) {
                str = fileChooserParams.getAcceptTypes()[0];
            }
            m1315a(valueCallback, str);
            return true;
        }
    }

    private class C0818b extends WebViewClient {
        final /* synthetic */ BrowserMainActivity f1094a;

        private C0818b(BrowserMainActivity browserMainActivity) {
            this.f1094a = browserMainActivity;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1258c.m2987b(" onPageFinished:" + str);
            this.f1094a.f1097e.setText(str);
            this.f1094a.invalidateOptionsMenu();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            C1258c.m2987b(" onPageStarted:" + str);
            this.f1094a.f1097e.setText(str);
            this.f1094a.f1101n.setVisibility(8);
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
            if (str.startsWith("http://") || str.startsWith("https://")) {
                webView.loadUrl(str);
            } else if (str.startsWith("intent://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (this.f1094a.getPackageManager().getLaunchIntentForPackage(r0.getPackage()) != null) {
                        this.f1094a.startActivity(r0);
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("market://details?id=" + r0.getPackage()));
                        this.f1094a.startActivity(intent);
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith("market://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (r0 != null) {
                        this.f1094a.startActivity(r0);
                    }
                    return true;
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    this.f1094a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return true;
        }
    }

    static class C0819c extends FrameLayout {
        public C0819c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    private void m1317a(View view, CustomViewCallback customViewCallback) {
        if (this.f1102o != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        this.f1103q = new C0819c(this);
        this.f1103q.addView(view, f1095p);
        frameLayout.addView(this.f1103q, f1095p);
        this.f1102o = view;
        m1322b(false);
        this.f1104r = customViewCallback;
        setRequestedOrientation(0);
    }

    private void m1321b(@NonNull String str) {
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://")) {
            this.f1099l.loadUrl(str);
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0 || str.substring(lastIndexOf).length() - 1 <= 0) {
            this.f1099l.loadUrl(C0793b.m1235e(this, str));
            return;
        }
        this.f1099l.loadUrl("http://" + str);
    }

    private void m1322b(boolean z) {
        getWindow().setFlags(z ? 0 : 1024, 1024);
    }

    private void m1326h() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) "");
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new C08151(this));
        this.f1097e = (EditText) findViewById(R.id.edtInput);
        this.f1097e.setOnEditorActionListener(new C08162(this));
        this.f1100m = (AppBarLayout) findViewById(R.id.appBarLayout);
    }

    private void m1327k() {
        this.f1098k = (ProgressBar) findViewById(R.id.pbLoadProgress);
        this.f1101n = findViewById(R.id.vgHintLayer);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m1328l() {
        this.f1099l = (NestedScrollWebView) findViewById(R.id.mWebView);
        WebSettings settings = this.f1099l.getSettings();
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
        this.f1099l.setWebViewClient(new C0818b());
        this.f1099l.setWebChromeClient(new C0817a());
        this.f1099l.setDownloadListener(this);
        C0793b.m1225a(this.f1099l);
    }

    private void m1329m() {
        if (this.f1102o != null) {
            m1322b(true);
            ((FrameLayout) getWindow().getDecorView()).removeView(this.f1103q);
            this.f1103q = null;
            this.f1102o = null;
            this.f1104r.onCustomViewHidden();
            this.f1099l.setVisibility(0);
            setRequestedOrientation(1);
        }
    }

    private void m1330n() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
        }
    }

    public void mo2042a() {
        super.mo2042a();
    }

    public View mo2359g() {
        return getLayoutInflater().inflate(R.layout.activity_browser_main, null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (this.f1096d != null) {
                Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                if (data == null) {
                    this.f1096d.onReceiveValue(null);
                    this.f1096d = null;
                    return;
                }
                Object a = C0614e.m703a((Context) this, data);
                if (TextUtils.isEmpty(a)) {
                    this.f1096d.onReceiveValue(null);
                    this.f1096d = null;
                    return;
                }
                data = Uri.fromFile(new File(a));
                if (VERSION.SDK_INT >= 21) {
                    this.f1096d.onReceiveValue(new Uri[]{data});
                } else {
                    this.f1096d.onReceiveValue(new Uri[]{data});
                }
                this.f1096d = null;
            }
        } else if (i == 101 && i2 == -1 && intent != null) {
            this.f1099l.loadUrl(intent.getStringExtra("EXTRA_URL"));
        }
    }

    public void onBackPressed() {
        if (this.f1102o != null) {
            m1329m();
        } else if (this.f1099l.canGoBack()) {
            this.f1099l.goBack();
            invalidateOptionsMenu();
        } else {
            mo2042a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m1326h();
        m1327k();
        m1328l();
        C1150y.m2605b((Context) this, (int) R.string.event_browser_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.browser_main_menus, menu);
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.f1287a = C0630k.m753a();
        fileInfo.f1288b = C0793b.m1222a(str, str3);
        fileInfo.f1289c = C0793b.m1233d(this, fileInfo.f1288b);
        fileInfo.f1290d = str;
        fileInfo.f1291e = j;
        fileInfo.f1292f = System.currentTimeMillis();
        C1258c.m2987b("onDownloadStart:" + fileInfo.toString());
        if (C0795c.m1241a().m1246a(fileInfo)) {
            C0781d.m1196a(fileInfo);
            BrowserHostActivity.m1307a(this);
        }
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
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_action_bookmark) {
            BookmarkInfo bookmarkInfo = new BookmarkInfo();
            bookmarkInfo.f1281a = C0630k.m753a();
            bookmarkInfo.f1282b = this.f1099l.getUrl();
            bookmarkInfo.f1283c = this.f1099l.getTitle();
            bookmarkInfo.f1284d = System.currentTimeMillis() + "";
            bookmarkInfo.f1285e = bookmarkInfo.f1284d;
            C0778a.m1188c(bookmarkInfo);
            invalidateOptionsMenu();
        } else if (itemId == R.id.menu_action_forward) {
            if (this.f1099l.canGoForward()) {
                this.f1099l.goForward();
            }
        } else if (itemId == R.id.menu_action_refresh) {
            this.f1099l.reload();
        } else if (itemId == R.id.menu_action_bookmarks) {
            m80e();
            BrowserHostActivity.m1306a((Activity) this, 101);
        } else if (itemId == R.id.menu_action_downloads) {
            m80e();
            BrowserHostActivity.m1307a(this);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.menu_action_bookmark);
        String url = this.f1099l.getUrl();
        if (TextUtils.isEmpty(url)) {
            findItem.setIcon(R.drawable.icon_bookmark_add);
            findItem.getIcon().setAlpha(85);
            findItem.setEnabled(false);
        } else if (C0778a.m1184a(url)) {
            findItem.setIcon(R.drawable.icon_bookmark_added);
            findItem.setEnabled(false);
        } else {
            findItem.setIcon(R.drawable.icon_bookmark_add);
            findItem.getIcon().setAlpha(255);
            findItem.setEnabled(true);
        }
        menu.findItem(R.id.menu_action_forward).setVisible(this.f1099l.canGoForward());
        return true;
    }

    protected void onStop() {
        m80e();
        super.onStop();
    }
}
