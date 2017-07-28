package com.facebook.ads.internal.p018m;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C1449b;
import com.facebook.ads.C1462f;
import com.facebook.ads.C1463g;
import com.facebook.ads.C1467i;
import com.facebook.ads.internal.C1584g;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.view.p037a.C1749d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class C1729s {
    private static final Uri f4355a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final String f4356b = C1729s.class.getSimpleName();
    private static final Map<C1463g, C1584g> f4357c = new HashMap();

    public static class C1728a {
        public String f4352a;
        public String f4353b;
        public boolean f4354c;

        public C1728a(String str, String str2, boolean z) {
            this.f4352a = str;
            this.f4353b = str2;
            this.f4354c = z;
        }
    }

    static {
        f4357c.put(C1463g.f3397b, C1584g.WEBVIEW_INTERSTITIAL_UNKNOWN);
        f4357c.put(C1463g.f3400e, C1584g.WEBVIEW_BANNER_250);
        f4357c.put(C1463g.f3399d, C1584g.WEBVIEW_BANNER_90);
        f4357c.put(C1463g.f3398c, C1584g.WEBVIEW_BANNER_50);
    }

    private static Intent m4955a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setComponent(null);
        if (VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    public static final <P, PR, R> AsyncTask<P, PR, R> m4956a(AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    public static C1584g m4957a(C1463g c1463g) {
        C1584g c1584g = (C1584g) f4357c.get(c1463g);
        return c1584g == null ? C1584g.WEBVIEW_BANNER_LEGACY : c1584g;
    }

    public static C1728a m4958a(ContentResolver contentResolver) {
        C1728a c1728a;
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(f4355a, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c1728a = new C1728a(query.getString(query.getColumnIndex("aid")), query.getString(query.getColumnIndex("androidid")), Boolean.valueOf(query.getString(query.getColumnIndex("limit_tracking"))).booleanValue());
                        if (query != null) {
                            query.close();
                        }
                        return c1728a;
                    }
                } catch (Exception e) {
                    try {
                        c1728a = new C1728a(null, null, false);
                        if (query != null) {
                            query.close();
                        }
                        return c1728a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            c1728a = new C1728a(null, null, false);
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            c1728a = new C1728a(null, null, false);
            if (query != null) {
                query.close();
            }
            return c1728a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return c1728a;
    }

    public static Object m4959a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m4960a(double d) {
        return String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(d)});
    }

    public static String m4961a(long j) {
        return C1729s.m4960a(((double) j) / 1000.0d);
    }

    public static String m4962a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                stringWriter.write(cArr, 0, read);
            } else {
                String stringWriter2 = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return stringWriter2;
            }
        }
    }

    public static String m4963a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String m4964a(JSONObject jSONObject, String str) {
        return C1729s.m4965a(jSONObject, str, null);
    }

    public static String m4965a(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        return "null".equals(optString) ? null : optString;
    }

    public static String m4966a(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            String a = C1729s.m4962a(gZIPInputStream);
            gZIPInputStream.close();
            byteArrayInputStream.close();
            return a;
        } catch (Throwable e) {
            C1723o.m4943a(C1722n.m4940a(e, "Error decompressing data"));
            e.printStackTrace();
            return "";
        }
    }

    public static Method m4967a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method m4968a(String str, String str2, Class<?>... clsArr) {
        try {
            return C1729s.m4967a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static void m4969a(Context context, Uri uri) {
        Intent a = C1729s.m4955a(uri);
        a.addCategory("android.intent.category.BROWSABLE");
        a.addFlags(268435456);
        a.putExtra("com.android.browser.application_id", context.getPackageName());
        a.putExtra("create_new_tab", false);
        context.startActivity(a);
    }

    public static void m4970a(Context context, Uri uri, String str) {
        if (C1749d.m5020a(uri.getScheme()) && C1668j.m4721d(context)) {
            C1729s.m4975b(context, uri, str);
        } else {
            C1729s.m4969a(context, uri);
        }
    }

    public static void m4971a(Context context, String str) {
        if (C1462f.m3761a(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    public static boolean m4972a(Context context) {
        try {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(2).get(0);
            String str = runningTaskInfo.topActivity.getPackageName() + ".UnityPlayerActivity";
            boolean z = runningTaskInfo.topActivity.getClassName() == str || C1729s.m4976b(str);
            Boolean valueOf = Boolean.valueOf(z);
            Log.d("IS_UNITY", Boolean.toString(valueOf.booleanValue()));
            return valueOf.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m4973a(String str, String str2) {
        try {
            Class.forName(str + "." + str2);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static byte[] m4974a(String str) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable e) {
            C1723o.m4943a(C1722n.m4940a(e, "Error compressing data"));
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static void m4975b(Context context, Uri uri, String str) {
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("viewType", C1449b.BROWSER);
        intent.putExtra("browserURL", uri.toString());
        intent.putExtra("clientToken", str);
        intent.putExtra("handlerTime", System.currentTimeMillis());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setClass(context, C1467i.class);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                C1729s.m4969a(context, uri);
            }
        }
    }

    public static boolean m4976b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
