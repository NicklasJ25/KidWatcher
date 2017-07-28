package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzw;

@TargetApi(11)
@wh
public class abb extends WebChromeClient {
    private final aat f7788a;

    class C26531 implements OnCancelListener {
        final /* synthetic */ JsResult f7780a;

        C26531(JsResult jsResult) {
            this.f7780a = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f7780a.cancel();
        }
    }

    class C26542 implements OnClickListener {
        final /* synthetic */ JsResult f7781a;

        C26542(JsResult jsResult) {
            this.f7781a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7781a.cancel();
        }
    }

    class C26553 implements OnClickListener {
        final /* synthetic */ JsResult f7782a;

        C26553(JsResult jsResult) {
            this.f7782a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7782a.confirm();
        }
    }

    class C26564 implements OnCancelListener {
        final /* synthetic */ JsPromptResult f7783a;

        C26564(JsPromptResult jsPromptResult) {
            this.f7783a = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f7783a.cancel();
        }
    }

    class C26575 implements OnClickListener {
        final /* synthetic */ JsPromptResult f7784a;

        C26575(JsPromptResult jsPromptResult) {
            this.f7784a = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7784a.cancel();
        }
    }

    class C26586 implements OnClickListener {
        final /* synthetic */ JsPromptResult f7785a;
        final /* synthetic */ EditText f7786b;

        C26586(JsPromptResult jsPromptResult, EditText editText) {
            this.f7785a = jsPromptResult;
            this.f7786b = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7785a.confirm(this.f7786b.getText().toString());
        }
    }

    static /* synthetic */ class C26597 {
        static final /* synthetic */ int[] f7787a = new int[MessageLevel.values().length];

        static {
            try {
                f7787a[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7787a[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7787a[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7787a[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7787a[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public abb(aat com_google_android_gms_internal_aat) {
        this.f7788a = com_google_android_gms_internal_aat;
    }

    private final Context m8743a(WebView webView) {
        if (!(webView instanceof aat)) {
            return webView.getContext();
        }
        aat com_google_android_gms_internal_aat = (aat) webView;
        Context f = com_google_android_gms_internal_aat.mo3418f();
        return f == null ? com_google_android_gms_internal_aat.getContext() : f;
    }

    private static void m8744a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C26553(jsResult)).setNegativeButton(17039360, new C26542(jsResult)).setOnCancelListener(new C26531(jsResult)).create().show();
    }

    private static void m8745a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C26586(jsPromptResult, editText)).setNegativeButton(17039360, new C26575(jsPromptResult)).setOnCancelListener(new C26564(jsPromptResult)).create().show();
    }

    private final boolean m8746a() {
        return zzw.zzcM().m15131a(this.f7788a.getContext(), this.f7788a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || zzw.zzcM().m15131a(this.f7788a.getContext(), this.f7788a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    protected final void m8747a(View view, int i, CustomViewCallback customViewCallback) {
        zze i2 = this.f7788a.mo3421i();
        if (i2 == null) {
            aad.m8426e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        i2.zza(view, customViewCallback);
        i2.setRequestedOrientation(i);
    }

    protected boolean m8748a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                m8745a(context, builder, str2, str3, jsPromptResult);
            } else {
                m8744a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            aad.m8424c("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof aat) {
            zze i = ((aat) webView).mo3421i();
            if (i == null) {
                aad.m8426e("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                i.close();
                return;
            }
        }
        aad.m8426e("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String valueOf = String.valueOf(consoleMessage.message());
        String valueOf2 = String.valueOf(consoleMessage.sourceId());
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(valueOf2).length()).append("JS: ").append(valueOf).append(" (").append(valueOf2).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (valueOf.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C26597.f7787a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                aad.m8423c(valueOf);
                break;
            case 2:
                aad.m8426e(valueOf);
                break;
            case 3:
            case 4:
                aad.m8425d(valueOf);
                break;
            case 5:
                aad.m8421b(valueOf);
                break;
            default:
                aad.m8425d(valueOf);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f7788a.mo3424l());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(str, m8746a(), true);
        }
    }

    public final void onHideCustomView() {
        zze i = this.f7788a.mo3421i();
        if (i == null) {
            aad.m8426e("Could not get ad overlay when hiding custom view.");
        } else {
            i.zzhD();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m8748a(m8743a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m8748a(m8743a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m8748a(m8743a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m8748a(m8743a(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m8747a(view, -1, customViewCallback);
    }
}
