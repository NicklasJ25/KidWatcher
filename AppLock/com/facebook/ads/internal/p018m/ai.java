package com.facebook.ads.internal.p018m;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.C1462f;
import com.facebook.ads.internal.C1584g;
import com.facebook.ads.internal.p028g.C1583i;
import com.facebook.ads.internal.p030j.p031a.C1618a;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ai {
    private static String f4224a = null;
    private static final Set<String> f4225b = new HashSet(1);
    private static final Set<String> f4226c = new HashSet(2);

    public enum C1691a {
        UNKNOWN(0),
        NONE(0),
        MOBILE_INTERNET(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4);
        
        public final int f4223g;

        private C1691a(int i) {
            this.f4223g = i;
        }
    }

    static {
        f4225b.add("1ww8E0AYsR2oX5lndk2hwp2Uosk=\n");
        f4226c.add("toZ2GRnRjC9P5VVUdCpOrFH8lfQ=\n");
        f4226c.add("3lKvjNsfmrn+WmfDhvr2iVh/yRs=\n");
        f4226c.add("B08QtE4yLCdli4rptyqAEczXOeA=\n");
        f4226c.add("XZXI6anZbdKf+taURdnyUH5ipgM=\n");
    }

    public static C1618a m4825a(Context context) {
        return ai.m4826a(context, null);
    }

    public static C1618a m4826a(Context context, C1584g c1584g) {
        C1618a c1618a = new C1618a();
        ai.m4828a(context, c1618a, c1584g);
        return c1618a;
    }

    private static String m4827a(Context context, String str, String str2) {
        Class cls = Class.forName(str);
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            String str3 = (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
            return str3;
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    private static void m4828a(Context context, C1618a c1618a, C1584g c1584g) {
        c1618a.m4562c(30000);
        c1618a.m4560b(3);
        c1618a.m4545a("user-agent", ai.m4834c(context, c1584g) + " [FBAN/AudienceNetworkForAndroid;FBSN/" + "Android" + ";FBSV/" + C1583i.f3920a + ";FBAB/" + C1583i.f3923d + ";FBAV/" + C1583i.f3925f + ";FBBV/" + C1583i.f3926g + ";FBVS/" + "4.23.0" + ";FBLC/" + Locale.getDefault().toString() + "]");
    }

    public static boolean m4829a() {
        Object a = C1462f.m3759a();
        return !TextUtils.isEmpty(a) && a.endsWith(".sb");
    }

    public static C1618a m4830b() {
        return ai.m4825a(null);
    }

    public static C1618a m4831b(Context context) {
        return ai.m4832b(context, null);
    }

    public static C1618a m4832b(Context context, C1584g c1584g) {
        C1618a c1618a = new C1618a();
        ai.m4828a(context, c1618a, c1584g);
        if (!ai.m4829a()) {
            c1618a.m4561b(f4226c);
            c1618a.m4554a(f4225b);
        }
        return c1618a;
    }

    public static C1691a m4833c(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return C1691a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return C1691a.NONE;
        }
        if (activeNetworkInfo.getType() != 0) {
            return C1691a.MOBILE_INTERNET;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return C1691a.MOBILE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return C1691a.MOBILE_3G;
            case 13:
                return C1691a.MOBILE_4G;
            default:
                return C1691a.UNKNOWN;
        }
    }

    private static String m4834c(Context context, C1584g c1584g) {
        if (context == null) {
            return "Unknown";
        }
        if (c1584g == C1584g.NATIVE_250 || c1584g == C1584g.NATIVE_UNKNOWN || c1584g == null) {
            return System.getProperty("http.agent");
        }
        if (f4224a != null) {
            return f4224a;
        }
        synchronized (ai.class) {
            if (f4224a != null) {
                String str = f4224a;
                return str;
            }
            if (VERSION.SDK_INT >= 17) {
                try {
                    f4224a = ai.m4835d(context);
                    str = f4224a;
                    return str;
                } catch (Exception e) {
                }
            }
            try {
                f4224a = ai.m4827a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f4224a = ai.m4827a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f4224a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
            return f4224a;
        }
    }

    @TargetApi(17)
    private static String m4835d(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
