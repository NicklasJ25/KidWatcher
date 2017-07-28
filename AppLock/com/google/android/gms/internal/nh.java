package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2590o;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@wh
public class nh extends Thread {
    private boolean f10003a = false;
    private boolean f10004b = false;
    private boolean f10005c = false;
    private final Object f10006d;
    private final nf f10007e;
    private final wg f10008f;
    private final int f10009g;
    private final int f10010h;
    private final int f10011i;
    private final int f10012j;
    private final int f10013k;
    private final int f10014l;
    private final int f10015m;
    private final int f10016n;
    private final String f10017o;

    @wh
    class C3099a {
        final int f10001a;
        final int f10002b;

        C3099a(nh nhVar, int i, int i2) {
            this.f10001a = i;
            this.f10002b = i2;
        }
    }

    public nh(nf nfVar, wg wgVar) {
        this.f10007e = nfVar;
        this.f10008f = wgVar;
        this.f10006d = new Object();
        this.f10010h = ((Integer) qb.f10284X.m13225c()).intValue();
        this.f10011i = ((Integer) qb.f10285Y.m13225c()).intValue();
        this.f10012j = ((Integer) qb.f10286Z.m13225c()).intValue();
        this.f10013k = ((Integer) qb.aa.m13225c()).intValue();
        this.f10014l = ((Integer) qb.ad.m13225c()).intValue();
        this.f10015m = ((Integer) qb.af.m13225c()).intValue();
        this.f10016n = ((Integer) qb.ag.m13225c()).intValue();
        this.f10009g = ((Integer) qb.ab.m13225c()).intValue();
        this.f10017o = (String) qb.ai.m13225c();
        setName("ContentFetchTask");
    }

    C3099a m12786a(@Nullable View view, ne neVar) {
        int i = 0;
        if (view == null) {
            return new C3099a(this, 0, 0);
        }
        Context b = zzw.zzcP().m12784b();
        if (b != null) {
            String str = (String) view.getTag(b.getResources().getIdentifier((String) qb.ah.m13225c(), "id", b.getPackageName()));
            if (!(TextUtils.isEmpty(this.f10017o) || str == null || !str.equals(this.f10017o))) {
                return new C3099a(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C3099a(this, 0, 0);
            }
            neVar.m12757b(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new C3099a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof aat)) {
            neVar.m12762g();
            return m12793a((WebView) view, neVar, globalVisibleRect) ? new C3099a(this, 0, 1) : new C3099a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C3099a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                C3099a a = m12786a(viewGroup.getChildAt(i3), neVar);
                i2 += a.f10001a;
                i += a.f10002b;
            }
            return new C3099a(this, i2, i);
        }
    }

    public void m12787a() {
        synchronized (this.f10006d) {
            if (this.f10003a) {
                aad.m8421b("Content hash thread already started, quiting...");
                return;
            }
            this.f10003a = true;
            start();
        }
    }

    void m12788a(@Nullable Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                zzw.zzcQ().m15000a(th, "ContentFetchTask.extractContent");
                aad.m8421b("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                m12792a(view);
            }
        }
    }

    void m12789a(ne neVar, WebView webView, String str, boolean z) {
        neVar.m12761f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    neVar.m12754a(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String valueOf = String.valueOf(webView.getTitle());
                    neVar.m12754a(new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (neVar.m12755a()) {
                this.f10007e.m12768b(neVar);
            }
        } catch (JSONException e) {
            aad.m8421b("Json string may be malformed.");
        } catch (Throwable th) {
            aad.m8419a("Failed to get webview content.", th);
            this.f10008f.mo4182a(th, "ContentFetchTask.processWebViewContent");
        }
    }

    boolean m12790a(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean m12791a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean m12792a(@Nullable final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ nh f9994b;

            public void run() {
                this.f9994b.m12794b(view);
            }
        });
        return true;
    }

    @TargetApi(19)
    boolean m12793a(final WebView webView, final ne neVar, final boolean z) {
        if (!C2590o.m8312g()) {
            return false;
        }
        neVar.m12762g();
        webView.post(new Runnable(this) {
            ValueCallback<String> f9996a = new C30971(this);
            final /* synthetic */ nh f10000e;

            class C30971 implements ValueCallback<String> {
                final /* synthetic */ C30982 f9995a;

                C30971(C30982 c30982) {
                    this.f9995a = c30982;
                }

                public void m12785a(String str) {
                    this.f9995a.f10000e.m12789a(neVar, webView, str, z);
                }

                public /* synthetic */ void onReceiveValue(Object obj) {
                    m12785a((String) obj);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f9996a);
                    } catch (Throwable th) {
                        this.f9996a.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    void m12794b(View view) {
        try {
            ne neVar = new ne(this.f10010h, this.f10011i, this.f10012j, this.f10013k, this.f10014l, this.f10015m, this.f10016n);
            C3099a a = m12786a(view, neVar);
            neVar.m12763h();
            if (a.f10001a != 0 || a.f10002b != 0) {
                if (a.f10002b != 0 || neVar.m12765j() != 0) {
                    if (a.f10002b != 0 || !this.f10007e.m12767a(neVar)) {
                        this.f10007e.m12769c(neVar);
                    }
                }
            }
        } catch (Throwable e) {
            aad.m8422b("Exception in fetchContentOnUIThread", e);
            this.f10008f.mo4182a(e, "ContentFetchTask.fetchContent");
        }
    }

    boolean m12795b() {
        try {
            Context b = zzw.zzcP().m12784b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (m12790a(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && m12791a(b)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzw.zzcQ().m15000a(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    public ne m12796c() {
        return this.f10007e.m12766a();
    }

    public void m12797d() {
        synchronized (this.f10006d) {
            this.f10004b = false;
            this.f10006d.notifyAll();
            aad.m8421b("ContentFetchThread: wakeup");
        }
    }

    public void m12798e() {
        synchronized (this.f10006d) {
            this.f10004b = true;
            aad.m8421b("ContentFetchThread: paused, mPause = " + this.f10004b);
        }
    }

    public boolean m12799f() {
        return this.f10004b;
    }

    public void run() {
        while (true) {
            try {
                if (m12795b()) {
                    Activity a = zzw.zzcP().m12781a();
                    if (a == null) {
                        aad.m8421b("ContentFetchThread: no activity. Sleeping.");
                        m12798e();
                    } else {
                        m12788a(a);
                    }
                } else {
                    aad.m8421b("ContentFetchTask: sleeping");
                    m12798e();
                }
                Thread.sleep((long) (this.f10009g * 1000));
            } catch (Throwable e) {
                aad.m8422b("Error in ContentFetchTask", e);
            } catch (Throwable e2) {
                aad.m8422b("Error in ContentFetchTask", e2);
                this.f10008f.mo4182a(e2, "ContentFetchTask.run");
            }
            synchronized (this.f10006d) {
                while (this.f10004b) {
                    try {
                        aad.m8421b("ContentFetchTask: waiting");
                        this.f10006d.wait();
                    } catch (InterruptedException e3) {
                    }
                }
            }
        }
    }
}
