package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.atomic.AtomicBoolean;

@wh
public class ys {
    final AtomicBoolean f11504a = new AtomicBoolean(false);
    private final Object f11505b = new Object();
    @Nullable
    private String f11506c = null;

    private Object m14934a(Class cls, Context context) {
        Object obj = null;
        try {
            obj = cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Exception e) {
            m14937a(e, "getInstance");
        }
        return obj;
    }

    private Object m14935a(String str, Context context) {
        Object obj = null;
        try {
            Class loadClass = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
            obj = loadClass.getDeclaredMethod(str, new Class[0]).invoke(m14934a(loadClass, context), new Object[0]);
        } catch (Exception e) {
            m14937a(e, str);
        }
        return obj;
    }

    private void m14936a(Context context, String str, Bundle bundle) {
        try {
            Class loadClass = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
            Object a = m14934a(loadClass, context);
            loadClass.getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class}).invoke(a, new Object[]{"am", str, bundle});
        } catch (Exception e) {
            m14937a(e, "logEventInternal");
        }
    }

    private void m14937a(Exception exception, String str) {
        if (!this.f11504a.get()) {
            aad.m8422b(new StringBuilder(String.valueOf(str).length() + 190).append("Invoke Scion method ").append(str).append(" error, the Google Mobile Ads SDK will not integrate with Scion. Admob/Scion integration requires the latest Scion SDK jar, but Scion SDK is either missing or out of date").toString(), exception);
            zzw.zzcQ().m15000a((Throwable) exception, "ScionApiAdapter.logInvokeScionApiError");
            this.f11504a.set(true);
        }
    }

    private void m14938b(Context context, String str, String str2) {
        try {
            Class loadClass = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
            Object a = m14934a(loadClass, context);
            loadClass.getDeclaredMethod(str2, new Class[]{String.class}).invoke(a, new Object[]{str});
        } catch (Exception e) {
            m14937a(e, str2);
        }
    }

    private Bundle m14939g(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("_aeid", str);
        return bundle;
    }

    @Nullable
    public String m14940a(Context context) {
        if (!m14943a()) {
            return null;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
            return (String) loadClass.getDeclaredMethod("getCurrentScreenName", new Class[0]).invoke(m14934a(loadClass, context), new Object[0]);
        } catch (Exception e) {
            m14937a(e, "getCurrentScreenName");
            return null;
        }
    }

    public void m14941a(Context context, String str) {
        if (m14943a()) {
            m14938b(context, str, "beginAdUnitExposure");
        }
    }

    public void m14942a(Context context, String str, String str2) {
        if (m14943a() && (context instanceof Activity)) {
            if (!TextUtils.isEmpty(str2)) {
                str = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append("_").append(str2).toString();
            }
            try {
                Class loadClass = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context});
                Activity activity = (Activity) context;
                loadClass.getDeclaredMethod("setCurrentScreen", new Class[]{Activity.class, String.class, String.class}).invoke(invoke, new Object[]{activity, str, context.getPackageName()});
            } catch (Exception e) {
                m14937a(e, "setCurrentScreen");
            }
        }
    }

    public boolean m14943a() {
        return ((Boolean) qb.au.m13225c()).booleanValue() && !this.f11504a.get();
    }

    @Nullable
    public String m14944b(Context context) {
        if (!m14943a()) {
            return null;
        }
        synchronized (this.f11505b) {
            if (this.f11506c != null) {
                String str = this.f11506c;
                return str;
            }
            this.f11506c = (String) m14935a("getGmpAppId", context);
            str = this.f11506c;
            return str;
        }
    }

    public void m14945b(Context context, String str) {
        if (m14943a()) {
            m14938b(context, str, "endAdUnitExposure");
        }
    }

    public boolean m14946b() {
        return ((Boolean) qb.av.m13225c()).booleanValue() && m14943a();
    }

    @Nullable
    public String m14947c(Context context) {
        return !m14943a() ? null : (String) m14935a("getAppInstanceId", context);
    }

    public void m14948c(Context context, String str) {
        if (m14943a()) {
            Bundle g = m14939g(context, str);
            g.putString("_r", "1");
            m14936a(context, "_ac", g);
        }
    }

    public boolean m14949c() {
        return ((Boolean) qb.aw.m13225c()).booleanValue() && m14943a();
    }

    @Nullable
    public String m14950d(Context context) {
        if (!m14943a()) {
            return null;
        }
        Object a = m14935a("generateEventId", context);
        return a != null ? a.toString() : null;
    }

    public void m14951d(Context context, String str) {
        if (m14943a()) {
            m14936a(context, "_ai", m14939g(context, str));
        }
    }

    public boolean m14952d() {
        return ((Boolean) qb.ax.m13225c()).booleanValue() && m14943a();
    }

    public void m14953e(Context context, String str) {
        if (m14943a()) {
            m14936a(context, "_aq", m14939g(context, str));
        }
    }

    public boolean m14954e() {
        return ((Boolean) qb.aA.m13225c()).booleanValue() && m14943a();
    }

    public void m14955f(Context context, String str) {
        if (m14943a()) {
            m14936a(context, "_aa", m14939g(context, str));
        }
    }
}
