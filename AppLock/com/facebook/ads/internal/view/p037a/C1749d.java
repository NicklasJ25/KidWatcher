package com.facebook.ads.internal.view.p037a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p018m.C1730t;
import com.facebook.ads.internal.p018m.C1735x;
import com.facebook.ads.internal.view.C1748a;
import java.util.HashSet;
import java.util.Set;

@TargetApi(19)
public class C1749d extends C1748a {
    private static final String f4409a = C1749d.class.getSimpleName();
    private static final Set<String> f4410b = new HashSet(2);
    private C1747a f4411c;
    private C1735x f4412d;
    private long f4413e = -1;
    private long f4414f = -1;
    private long f4415g = -1;
    private long f4416h = -1;

    class C17451 extends WebChromeClient {
        final /* synthetic */ C1749d f4405a;

        C17451(C1749d c1749d) {
            this.f4405a = c1749d;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (!TextUtils.isEmpty(message) && consoleMessage.messageLevel() == MessageLevel.LOG) {
                this.f4405a.f4412d.m4995a(message);
            }
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            this.f4405a.f4412d.m4994a();
            if (this.f4405a.f4411c != null) {
                this.f4405a.f4411c.mo2815a(i);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (this.f4405a.f4411c != null) {
                this.f4405a.f4411c.mo2817b(str);
            }
        }
    }

    class C17462 extends WebViewClient {
        final /* synthetic */ C1749d f4406a;

        C17462(C1749d c1749d) {
            this.f4406a = c1749d;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f4406a.f4411c != null) {
                this.f4406a.f4411c.mo2818c(str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.f4406a.f4411c != null) {
                this.f4406a.f4411c.mo2816a(str);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if (!C1749d.f4410b.contains(parse.getScheme())) {
                try {
                    this.f4406a.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
                    return true;
                } catch (Throwable e) {
                    Log.w(C1749d.f4409a, "Activity not found to handle URI.", e);
                } catch (Throwable e2) {
                    Log.e(C1749d.f4409a, "Unknown exception occurred when trying to handle URI.", e2);
                }
            }
            return false;
        }
    }

    public interface C1747a {
        void mo2815a(int i);

        void mo2816a(String str);

        void mo2817b(String str);

        void mo2818c(String str);
    }

    static {
        f4410b.add("http");
        f4410b.add("https");
    }

    public C1749d(Context context) {
        super(context);
        m5024f();
    }

    public static boolean m5020a(String str) {
        return f4410b.contains(str);
    }

    private void m5024f() {
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        this.f4412d = new C1735x(this);
    }

    private void m5025g() {
        if (this.f4414f > -1 && this.f4415g > -1 && this.f4416h > -1) {
            this.f4412d.m4996a(false);
        }
    }

    protected WebChromeClient mo2779a() {
        return new C17451(this);
    }

    public void m5027a(long j) {
        if (this.f4413e < 0) {
            this.f4413e = j;
        }
    }

    protected WebViewClient mo2780b() {
        return new C17462(this);
    }

    public void m5029b(long j) {
        if (this.f4414f < 0) {
            this.f4414f = j;
        }
        m5025g();
    }

    public void m5030b(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException e) {
            loadUrl("javascript:" + str);
        }
    }

    public void m5031c(long j) {
        if (this.f4416h < 0) {
            this.f4416h = j;
        }
        m5025g();
    }

    public void destroy() {
        C1730t.m4978a(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.f4414f;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return copyBackForwardList.getSize() > 0 ? copyBackForwardList.getItemAtIndex(0).getUrl() : getUrl();
    }

    public long getLoadFinishMs() {
        return this.f4416h;
    }

    public long getResponseEndMs() {
        return this.f4413e;
    }

    public long getScrollReadyMs() {
        return this.f4415g;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4415g < 0 && computeVerticalScrollRange() > getHeight()) {
            this.f4415g = System.currentTimeMillis();
            m5025g();
        }
    }

    public void setListener(C1747a c1747a) {
        this.f4411c = c1747a;
    }
}
