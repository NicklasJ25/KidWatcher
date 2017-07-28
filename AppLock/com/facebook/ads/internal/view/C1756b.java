package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p018m.C1694b;
import com.facebook.ads.internal.p018m.C1711g;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1730t;
import com.facebook.ads.internal.p034k.C1671a;
import com.facebook.ads.internal.p034k.C1671a.C1669a;
import java.util.HashMap;
import java.util.Map;

public class C1756b extends C1748a {
    private static final String f4428a = C1756b.class.getSimpleName();
    private final C1447b f4429b;
    private C1711g f4430c = new C1711g();
    private C1671a f4431d;

    public interface C1447b {
        void mo2622a();

        void mo2623a(int i);

        void mo2624a(String str, Map<String, String> map);

        void mo2625b();
    }

    class C17512 extends WebChromeClient {
        final /* synthetic */ C1756b f4419a;

        C17512(C1756b c1756b) {
            this.f4419a = c1756b;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    class C17523 extends WebViewClient {
        final /* synthetic */ C1756b f4420a;

        C17523(C1756b c1756b) {
            this.f4420a = c1756b;
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Map hashMap = new HashMap();
            this.f4420a.f4431d.m4760a(hashMap);
            hashMap.put("touch", C1729s.m4963a(this.f4420a.getTouchData()));
            this.f4420a.f4429b.mo2624a(str, hashMap);
            return true;
        }
    }

    public class C1753a {
        final /* synthetic */ C1756b f4421a;
        private final String f4422b = C1753a.class.getSimpleName();

        public C1753a(C1756b c1756b) {
            this.f4421a = c1756b;
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f4422b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C1729s.m4963a(C1694b.m4844a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!this.f4421a.m5018e()) {
                this.f4421a.f4429b.mo2622a();
                if (this.f4421a.f4431d != null) {
                    this.f4421a.f4431d.m4758a();
                }
            }
        }
    }

    public C1756b(Context context, final C1447b c1447b, int i) {
        super(context);
        this.f4429b = c1447b;
        getSettings().setSupportZoom(false);
        addJavascriptInterface(new C1753a(this), "AdControl");
        this.f4431d = new C1671a(this, i, new C1669a(this) {
            final /* synthetic */ C1756b f4418b;

            public void mo2782a() {
                this.f4418b.f4430c.m4918a();
                c1447b.mo2625b();
            }
        });
    }

    protected WebChromeClient mo2779a() {
        return new C17512(this);
    }

    public void m5039a(int i, int i2) {
        this.f4431d.m4759a(i);
        this.f4431d.m4762b(i2);
    }

    protected WebViewClient mo2780b() {
        return new C17523(this);
    }

    public void destroy() {
        if (this.f4431d != null) {
            this.f4431d.m4761b();
            this.f4431d = null;
        }
        C1730t.m4978a(this);
        super.destroy();
    }

    public Map<String, String> getTouchData() {
        return this.f4430c.m4924e();
    }

    public C1671a getViewabilityChecker() {
        return this.f4431d;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f4430c.m4919a(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f4429b != null) {
            this.f4429b.mo2623a(i);
        }
        if (this.f4431d == null) {
            return;
        }
        if (i == 0) {
            this.f4431d.m4758a();
        } else if (i == 8) {
            this.f4431d.m4761b();
        }
    }
}
