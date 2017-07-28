package com.domobile.applock.chamber.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.domobile.applock.C0400d;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p009c.C0795c;
import com.domobile.applock.chamber.p010b.C0778a;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.applock.chamber.view.DoWebView;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.p003a.C0630k;
import com.domobile.frame.p000a.C1258c;
import java.io.File;
import java.net.URISyntaxException;

public class C0842c extends C0400d implements OnRefreshListener, DownloadListener {
    private static final LayoutParams f1163k = new LayoutParams(-1, -1);
    public ValueCallback<Uri[]> f1164a;
    private EditText f1165e;
    private SwipeRefreshLayout f1166f;
    private ProgressBar f1167g;
    private DoWebView f1168h;
    private View f1169i;
    private View f1170j;
    private FrameLayout f1171l;
    private CustomViewCallback f1172m;

    class C08381 implements OnEditorActionListener {
        final /* synthetic */ C0842c f1160a;

        C08381(C0842c c0842c) {
            this.f1160a = c0842c;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 2) {
                String obj = this.f1160a.f1165e.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.f1160a.m1393a(obj);
                    this.f1160a.m1405g();
                }
            }
            return false;
        }
    }

    private class C0839a extends WebChromeClient {
        final /* synthetic */ C0842c f1161a;

        private C0839a(C0842c c0842c) {
            this.f1161a = c0842c;
        }

        public void m1388a(ValueCallback<Uri[]> valueCallback, String str) {
            this.f1161a.f1164a = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (TextUtils.isEmpty(str)) {
                intent.setType(GalleryUtils.MIME_TYPE_ALL);
            } else {
                intent.setType(str);
            }
            this.f1161a.startActivityForResult(Intent.createChooser(intent, ""), 100);
        }

        public View getVideoLoadingProgressView() {
            View frameLayout = new FrameLayout(this.f1161a.getContext());
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            return frameLayout;
        }

        public void onHideCustomView() {
            this.f1161a.m1403f();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                this.f1161a.f1167g.setVisibility(8);
                return;
            }
            this.f1161a.f1167g.setVisibility(0);
            this.f1161a.f1167g.setProgress(i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
            C1258c.m2987b("onReceivedIcon");
            C0793b.m1223a(this.f1161a.mActivity, Uri.parse(webView.getUrl()).getHost(), bitmap);
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            C1258c.m2987b("onReceivedTitle");
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            this.f1161a.m1390a(view, customViewCallback);
        }

        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            String str = null;
            if (!(fileChooserParams == null || fileChooserParams.getAcceptTypes() == null || fileChooserParams.getAcceptTypes().length <= 0)) {
                str = fileChooserParams.getAcceptTypes()[0];
            }
            m1388a(valueCallback, str);
            return true;
        }
    }

    private class C0840b extends WebViewClient {
        final /* synthetic */ C0842c f1162a;

        private C0840b(C0842c c0842c) {
            this.f1162a = c0842c;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1258c.m2987b(" onPageFinished:" + str);
            this.f1162a.f1165e.setText(str);
            this.f1162a.f1166f.setRefreshing(false);
            this.f1162a.b.invalidateOptionsMenu();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            C1258c.m2987b(" onPageStarted:" + str);
            this.f1162a.f1165e.setText(str);
            this.f1162a.f1169i.setVisibility(8);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            C1258c.m2987b(" onReceivedError:" + webResourceError);
            this.f1162a.f1166f.setRefreshing(false);
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
                    if (this.f1162a.getContext().getPackageManager().getLaunchIntentForPackage(r0.getPackage()) != null) {
                        this.f1162a.startActivity(r0);
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("market://details?id=" + r0.getPackage()));
                        this.f1162a.startActivity(intent);
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith("market://")) {
                try {
                    r0 = Intent.parseUri(str, 1);
                    if (r0 != null) {
                        this.f1162a.startActivity(r0);
                    }
                    return true;
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    this.f1162a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return true;
        }
    }

    static class C0841c extends FrameLayout {
        public C0841c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    private void m1390a(View view, CustomViewCallback customViewCallback) {
        if (this.f1170j != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.mActivity.getWindow().getDecorView();
        this.f1171l = new C0841c(getContext());
        this.f1171l.addView(view, f1163k);
        frameLayout.addView(this.f1171l, f1163k);
        this.f1170j = view;
        m1394a(false);
        this.f1172m = customViewCallback;
        this.mActivity.setRequestedOrientation(0);
    }

    private void m1393a(@NonNull String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            this.f1168h.loadUrl(str);
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0 || str.substring(lastIndexOf).length() - 1 <= 0) {
            this.f1168h.loadUrl(C0793b.m1235e(this.mActivity, str));
            return;
        }
        this.f1168h.loadUrl("http://" + str);
    }

    private void m1394a(boolean z) {
        this.mActivity.getWindow().setFlags(z ? 0 : 1024, 1024);
    }

    private void m1395b() {
        this.b.m54a("");
        Toolbar r = this.b.m66r();
        r.setContentInsetStartWithNavigation(0);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View inflate = View.inflate(this.mActivity, R.layout.layout_browser_main_header, null);
        r.addView(inflate, layoutParams);
        this.f1165e = (EditText) inflate.findViewById(R.id.edtInput);
        this.f1165e.setOnEditorActionListener(new C08381(this));
    }

    private void m1398c() {
        this.f1167g = (ProgressBar) findViewById(R.id.pbLoadProgress);
        this.f1169i = findViewById(R.id.vgHintLayer);
        this.f1166f = (SwipeRefreshLayout) findViewById(R.id.vgRefreshLayout);
        m110a(this.f1166f);
        this.f1166f.setEnabled(true);
        this.f1166f.setOnRefreshListener(this);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m1400d() {
        this.f1168h = (DoWebView) findViewById(R.id.mWebView);
        C0793b.m1225a(this.f1168h);
        WebSettings settings = this.f1168h.getSettings();
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
        this.f1168h.setWebViewClient(new C0840b());
        this.f1168h.setWebChromeClient(new C0839a());
        this.f1168h.setDownloadListener(this);
    }

    private boolean m1402e() {
        if (this.f1170j != null) {
            m1403f();
            return true;
        } else if (!this.f1168h.canGoBack()) {
            return false;
        } else {
            this.f1168h.goBack();
            this.b.invalidateOptionsMenu();
            return true;
        }
    }

    private void m1403f() {
        if (this.f1170j != null) {
            m1394a(true);
            ((FrameLayout) this.mActivity.getWindow().getDecorView()).removeView(this.f1171l);
            this.f1171l = null;
            this.f1170j = null;
            this.f1172m.onCustomViewHidden();
            this.f1168h.setVisibility(0);
            this.mActivity.setRequestedOrientation(1);
        }
    }

    private void m1405g() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.b.getSystemService("input_method");
        View currentFocus = this.b.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_browser_main, null);
        m1398c();
        m1400d();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (this.f1164a != null) {
                Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                if (data == null) {
                    this.f1164a.onReceiveValue(null);
                    this.f1164a = null;
                    return;
                }
                Object a = C0614e.m703a(this.mActivity, data);
                if (TextUtils.isEmpty(a)) {
                    this.f1164a.onReceiveValue(null);
                    this.f1164a = null;
                    return;
                }
                data = Uri.fromFile(new File(a));
                if (VERSION.SDK_INT >= 21) {
                    this.f1164a.onReceiveValue(new Uri[]{data});
                } else {
                    this.f1164a.onReceiveValue(new Uri[]{data});
                }
                this.f1164a = null;
            }
        } else if (i == 101 && i2 == -1 && intent != null) {
            this.f1168h.loadUrl(intent.getStringExtra("EXTRA_URL"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m1395b();
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.browser_main_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        super.onDestroy();
        C0793b.m1225a(this.f1168h);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.f1287a = C0630k.m753a();
        fileInfo.f1288b = C0793b.m1222a(str, str3);
        fileInfo.f1289c = C0793b.m1233d(this.mActivity, fileInfo.f1288b);
        fileInfo.f1290d = str;
        if (j < 0) {
            j = 0;
        }
        fileInfo.f1291e = j;
        fileInfo.f1292f = System.currentTimeMillis();
        C1258c.m2987b("onDownloadStart:" + fileInfo.toString());
        C0781d.m1196a(fileInfo);
        C0795c.m1241a().m1246a(fileInfo);
        BrowserHostActivity.m1307a(this.mActivity);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? m1402e() : super.onKeyDown(i, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_action_bookmark) {
            BookmarkInfo bookmarkInfo = new BookmarkInfo();
            bookmarkInfo.f1281a = C0630k.m753a();
            bookmarkInfo.f1282b = this.f1168h.getUrl();
            bookmarkInfo.f1283c = this.f1168h.getTitle();
            bookmarkInfo.f1284d = System.currentTimeMillis() + "";
            bookmarkInfo.f1285e = bookmarkInfo.f1284d;
            C0778a.m1188c(bookmarkInfo);
            this.b.invalidateOptionsMenu();
            return true;
        } else if (itemId == R.id.menu_action_forward) {
            if (!this.f1168h.canGoForward()) {
                return true;
            }
            this.f1168h.goForward();
            return true;
        } else if (itemId == R.id.menu_action_refresh) {
            this.f1168h.reload();
            return true;
        } else if (itemId == R.id.menu_action_bookmarks) {
            this.b.m80e();
            BrowserHostActivity.m1310a((Fragment) this, 101);
            return true;
        } else if (itemId != R.id.menu_action_downloads) {
            return false;
        } else {
            this.b.m80e();
            BrowserHostActivity.m1307a(this.mActivity);
            return true;
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.menu_action_bookmark);
        String url = this.f1168h.getUrl();
        if (TextUtils.isEmpty(url)) {
            findItem.setIcon(R.drawable.icon_bookmark_add);
            findItem.getIcon().setAlpha(85);
            findItem.setEnabled(false);
        } else if (C0778a.m1184a(url)) {
            findItem.setIcon(R.drawable.icon_bookmark_added);
            findItem.getIcon().setAlpha(255);
            findItem.setEnabled(false);
        } else {
            findItem.setIcon(R.drawable.icon_bookmark_add);
            findItem.setEnabled(true);
        }
        menu.findItem(R.id.menu_action_forward).setVisible(this.f1168h.canGoForward());
    }

    public void onRefresh() {
        this.f1168h.reload();
    }
}
