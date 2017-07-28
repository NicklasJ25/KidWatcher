package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.domobile.applock.chamber.model.FileInfo;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2586k;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.aac.C2632a;
import com.google.android.gms.internal.qp.C3177a;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class zl {
    public static final Handler f11678a = new zi(Looper.getMainLooper());
    private final Object f11679b = new Object();
    private boolean f11680c = true;
    private String f11681d;
    private boolean f11682e = false;
    private ti f11683f;

    private final class C3480a extends BroadcastReceiver {
        final /* synthetic */ zl f11677a;

        private C3480a(zl zlVar) {
            this.f11677a = zlVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.f11677a.f11680c = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f11677a.f11680c = false;
            }
        }
    }

    private JSONArray m15086a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m15088a(jSONArray, a);
        }
        return jSONArray;
    }

    private JSONObject m15087a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m15089a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private void m15088a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m15087a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m15114a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m15086a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m15113a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void m15089a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m15087a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m15114a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m15086a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m15086a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private boolean m15090a(KeyguardManager keyguardManager) {
        return keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode();
    }

    private boolean m15091a(PowerManager powerManager) {
        return powerManager == null || powerManager.isScreenOn();
    }

    public static void m15093b(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zk.m15079a(runnable);
        }
    }

    private Bitmap m15094c(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                aad.m8426e("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            aad.m8422b("Fail to capture the webview", e);
            return null;
        }
    }

    private Bitmap m15095d(@NonNull View view) {
        Bitmap drawingCache;
        Throwable e;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            drawingCache = view.getDrawingCache();
            drawingCache = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                aad.m8422b("Fail to capture the web view", e);
                return drawingCache;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            drawingCache = null;
            e = th;
            aad.m8422b("Fail to capture the web view", e);
            return drawingCache;
        }
        return drawingCache;
    }

    private boolean m15096n(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    public Bitmap m15097a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public Uri m15098a(Uri uri, String str, String str2) {
        return m15099a(uri.toString(), str, str2);
    }

    public Uri m15099a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(str.substring(0, indexOf + 1)).append(str2).append("=").append(str3).append("&").append(str.substring(indexOf + 1)).toString()) : Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public Bundle m15100a(nh nhVar) {
        if (nhVar == null) {
            return null;
        }
        if (!((Boolean) qb.ac.m13225c()).booleanValue() && !((Boolean) qb.ae.m13225c()).booleanValue()) {
            return null;
        }
        if (zzw.zzcQ().m15008b() && zzw.zzcQ().m15010c()) {
            return null;
        }
        String b;
        String c;
        String str;
        if (nhVar.m12799f()) {
            nhVar.m12797d();
        }
        ne c2 = nhVar.m12796c();
        if (c2 != null) {
            b = c2.m12756b();
            c = c2.m12758c();
            String d = c2.m12759d();
            if (b != null) {
                zzw.zzcQ().m14993a(b);
            }
            if (d != null) {
                zzw.zzcQ().m15005b(d);
                str = b;
                b = c;
                c = d;
            } else {
                str = b;
                b = c;
                c = d;
            }
        } else {
            b = null;
            str = zzw.zzcQ().m15021j();
            c = zzw.zzcQ().m15022k();
        }
        Bundle bundle = new Bundle(1);
        if (!(c == null || !((Boolean) qb.ae.m13225c()).booleanValue() || zzw.zzcQ().m15010c())) {
            bundle.putString("v_fp_vertical", c);
        }
        if (!(str == null || !((Boolean) qb.ac.m13225c()).booleanValue() || zzw.zzcQ().m15008b())) {
            bundle.putString("fingerprint", str);
            if (!str.equals(b)) {
                bundle.putString("v_fp", b);
            }
        }
        return !bundle.isEmpty() ? bundle : null;
    }

    public DisplayMetrics m15101a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow m15102a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public ti m15103a(Context context, zzqh com_google_android_gms_internal_zzqh) {
        ti tiVar;
        synchronized (this.f11679b) {
            if (this.f11683f == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f11683f = new ti(context, com_google_android_gms_internal_zzqh, (String) qb.f10288b.m13225c());
            }
            tiVar = this.f11683f;
        }
        return tiVar;
    }

    public String m15104a(Context context, View view, zzeg com_google_android_gms_internal_zzeg) {
        String str = null;
        if (((Boolean) qb.at.m13225c()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", com_google_android_gms_internal_zzeg.f11899e);
                jSONObject2.put("height", com_google_android_gms_internal_zzeg.f11896b);
                jSONObject.put(Columns.SIZE, jSONObject2);
                jSONObject.put("activity", m15155f(context));
                if (!com_google_android_gms_internal_zzeg.f11898d) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                aad.m8424c("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String m15105a(Context context, ed edVar, String str, View view) {
        if (edVar != null) {
            try {
                Uri parse = Uri.parse(str);
                if (edVar.m10569d(parse)) {
                    parse = edVar.m10560a(parse, context, view);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String m15106a(final Context context, String str) {
        String str2;
        synchronized (this.f11679b) {
            if (this.f11681d != null) {
                str2 = this.f11681d;
            } else if (str == null) {
                str2 = m15138b();
            } else {
                try {
                    this.f11681d = zzw.zzcO().mo4262a(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.f11681d)) {
                    if (ol.m12979a().m8413b()) {
                        this.f11681d = m15146c(context);
                    } else {
                        this.f11681d = null;
                        f11678a.post(new Runnable(this) {
                            final /* synthetic */ zl f11674b;

                            public void run() {
                                synchronized (this.f11674b.f11679b) {
                                    this.f11674b.f11681d = this.f11674b.m15146c(context);
                                    this.f11674b.f11679b.notifyAll();
                                }
                            }
                        });
                        while (this.f11681d == null) {
                            try {
                                this.f11679b.wait();
                            } catch (InterruptedException e2) {
                                this.f11681d = m15138b();
                                String str3 = "Interrupted, use default user agent: ";
                                str2 = String.valueOf(this.f11681d);
                                aad.m8426e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                            }
                        }
                    }
                }
                str2 = String.valueOf(this.f11681d);
                this.f11681d = new StringBuilder((String.valueOf(str2).length() + 11) + String.valueOf(str).length()).append(str2).append(" (Mobile; ").append(str).append(")").toString();
                str2 = this.f11681d;
            }
        }
        return str2;
    }

    public String m15107a(aat com_google_android_gms_internal_aat, String str) {
        return m15105a(com_google_android_gms_internal_aat.getContext(), com_google_android_gms_internal_aat.mo3429n(), str, com_google_android_gms_internal_aat.mo3405b());
    }

    public String m15108a(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public String m15109a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public String m15110a(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{Uri.encode((String) map.get(str2))}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public Map<String, String> m15111a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzw.zzcO().mo4251a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public Map<String, Integer> m15112a(View view, WindowManager windowManager) {
        DisplayMetrics a = m15101a(windowManager);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        int[] iArr = new int[2];
        Map<String, Integer> hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        return hashMap;
    }

    JSONArray m15113a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m15088a(jSONArray, a);
        }
        return jSONArray;
    }

    public JSONObject m15114a(Map<String, ?> map) {
        String valueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String valueOf2 : map.keySet()) {
                m15089a(jSONObject, valueOf2, map.get(valueOf2));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str = "Could not convert map to JSON: ";
            valueOf2 = String.valueOf(e.getMessage());
            throw new JSONException(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public void m15115a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void m15116a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m15117a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @TargetApi(18)
    public void m15118a(Context context, Uri uri) {
        try {
            Bundle bundle = new Bundle();
            if (((Boolean) qb.dd.m13225c()).booleanValue() && C2590o.m8311f()) {
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(new Intent("android.intent.action.VIEW", uri).putExtras(bundle));
            String valueOf = String.valueOf(uri.toString());
            aad.m8421b(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Opening ").append(valueOf).append(" in a new browser.").toString());
        } catch (Throwable e) {
            aad.m8422b("No browser is found.", e);
        }
    }

    public void m15119a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m15106a(context, str));
    }

    public void m15120a(final Context context, @Nullable final String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            bundle.putString("device", zzw.zzcM().m15154e());
            bundle.putString("eids", TextUtils.join(",", qb.m13267a()));
        }
        ol.m12979a().m8405a(context, str, str2, bundle, z, new C2632a(this) {
            public void mo3376a(String str) {
                zzw.zzcM().m15141b(context, str, str);
            }
        });
    }

    public void m15121a(Context context, String str, List<String> list) {
        for (String zvVar : list) {
            new zv(context, str, zvVar).zziP();
        }
    }

    public void m15122a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m15123a(context, str, z, httpURLConnection, false);
    }

    public void m15123a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m15106a(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public void m15124a(final Context context, final List<String> list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(mh.m12561a((Activity) context))) {
            return;
        }
        if (list == null) {
            zh.m15051a("Cannot ping urls: empty list.");
        } else if (qp.m13332a(context)) {
            final qp qpVar = new qp();
            qpVar.m13335a(new C3177a(this) {
            });
            qpVar.m13336b((Activity) context);
        } else {
            zh.m15051a("Cannot ping url because custom tabs is not supported");
        }
    }

    public void m15125a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f11678a.post(runnable);
        }
    }

    public void m15126a(List<String> list, String str) {
        for (String zvVar : list) {
            new zv(zvVar, str).zziP();
        }
    }

    public boolean m15127a() {
        return this.f11680c;
    }

    boolean m15128a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @TargetApi(24)
    public boolean m15129a(Activity activity, Configuration configuration) {
        aac a = ol.m12979a();
        int a2 = a.m8398a((Context) activity, configuration.screenHeightDp);
        int a3 = a.m8398a((Context) activity, configuration.screenWidthDp);
        DisplayMetrics a4 = m15101a((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = a4.heightPixels;
        int i2 = a4.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        identifier = ((Integer) qb.dm.m13225c()).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        return m15128a(i, dimensionPixelSize + a2, identifier) && m15128a(i2, a3, identifier);
    }

    public boolean m15130a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            aad.m8426e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            aad.m8426e(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            aad.m8426e(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            aad.m8426e(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            aad.m8426e(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            aad.m8426e(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            aad.m8426e(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        aad.m8426e(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean m15131a(Context context, String str, String str2) {
        return bm.m9120b(context).m9113a(str2, str) == 0;
    }

    public boolean m15132a(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return m15133a(view, powerManager, keyguardManager);
    }

    public boolean m15133a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = zzw.zzcM().m15127a() || !m15090a(keyguardManager);
        return view.getVisibility() == 0 && view.isShown() && m15091a(powerManager) && z && (!((Boolean) qb.bm.m13225c()).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect()));
    }

    public boolean m15134a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public int[] m15135a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m15156f();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public int m15136b(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    public int m15137b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            aad.m8426e(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    String m15138b() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String m15139b(Context context, String str) {
        try {
            return new String(C2586k.m8302a(context.openFileInput(str), true), "UTF-8");
        } catch (Throwable e) {
            aad.m8422b("Error reading from internal storage.", e);
            return "";
        }
    }

    public void m15140b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m15141b(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m15121a(context, str, arrayList);
    }

    public void m15142b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) qb.br.m13225c()).booleanValue()) {
            m15120a(context, str, str2, bundle, z);
        }
    }

    public boolean m15143b(Context context) {
        if (this.f11682e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new C3480a(), intentFilter);
        this.f11682e = true;
        return true;
    }

    public int[] m15144b(Activity activity) {
        int[] a = m15135a(activity);
        return new int[]{ol.m12979a().m8410b((Context) activity, a[0]), ol.m12979a().m8410b((Context) activity, a[1])};
    }

    public String m15145c() {
        return UUID.randomUUID().toString();
    }

    protected String m15146c(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Exception e) {
            return m15138b();
        }
    }

    public void m15147c(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Throwable e) {
            aad.m8422b("Error writing to file in internal storage.", e);
        }
    }

    public boolean m15148c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] m15149c(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m15156f();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public Builder m15150d(Context context) {
        return new Builder(context);
    }

    public String m15151d() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public int[] m15152d(Activity activity) {
        int[] c = m15149c(activity);
        return new int[]{ol.m12979a().m8410b((Context) activity, c[0]), ol.m12979a().m8410b((Context) activity, c[1])};
    }

    public ps m15153e(Context context) {
        return new ps(context);
    }

    public String m15154e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    public String m15155f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    protected int[] m15156f() {
        return new int[]{0, 0};
    }

    public float m15157g() {
        zzq zzcp = zzw.zzdg().zzcp();
        return (zzcp == null || !zzcp.zzcr()) ? 1.0f : zzcp.zzcq();
    }

    public boolean m15158g(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && m15096n(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap m15159h(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bitmap d;
        try {
            if (((Boolean) qb.bV.m13225c()).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    d = m15095d(window.getDecorView().getRootView());
                }
                d = null;
            } else {
                d = m15094c(((Activity) context).getWindow().getDecorView());
            }
        } catch (Throwable e) {
            aad.m8422b("Fail to capture screen shot", e);
        }
        return d;
    }

    public boolean m15160h() {
        zzq zzcp = zzw.zzdg().zzcp();
        return zzcp != null ? zzcp.zzcs() : false;
    }

    public AudioManager m15161i(Context context) {
        return (AudioManager) context.getSystemService(FileInfo.MIME_AUDIO);
    }

    public Bundle m15162i() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) qb.f10266F.m13225c()).booleanValue()) {
                Parcelable memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) qb.f10267G.m13225c()).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", zzw.zzcQ().m15037z());
        } catch (Throwable e) {
            aad.m8424c("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public float m15163j(Context context) {
        AudioManager i = m15161i(context);
        if (i == null) {
            return 0.0f;
        }
        int streamMaxVolume = i.getStreamMaxVolume(3);
        return streamMaxVolume != 0 ? ((float) i.getStreamVolume(3)) / ((float) streamMaxVolume) : 0.0f;
    }

    public int m15164k(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    public boolean m15165l(Context context) {
        try {
            context.getClassLoader().loadClass(ClientApi.class.getName());
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            aad.m8422b("Error loading class.", th);
            zzw.zzcQ().m15000a(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public Bundle m15166m(Context context) {
        nh a = zzw.zzcQ().m14988a(context);
        return a == null ? null : m15100a(a);
    }
}
