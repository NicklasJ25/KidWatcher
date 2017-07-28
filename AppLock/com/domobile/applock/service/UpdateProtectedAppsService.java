package com.domobile.applock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p017d.C1213a;
import java.io.File;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;

public class UpdateProtectedAppsService extends Service {

    public class C1067a implements C0607f {
        final /* synthetic */ UpdateProtectedAppsService f1995a;
        private Context f1996b;
        private String f1997c;

        public C1067a(UpdateProtectedAppsService updateProtectedAppsService, Context context, String str) {
            this.f1995a = updateProtectedAppsService;
            this.f1996b = context;
            this.f1997c = str;
        }

        public C1275d mo2363a() {
            C1275d c1275d = new C1275d(this.f1997c);
            c1275d.f2625c = "GET";
            c1275d.f2624b = "utf-8";
            return c1275d;
        }

        public void mo2364a(String str) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(str);
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray2.getString(i);
                        if (C1150y.m2639k(this.f1996b, string)) {
                            jSONArray.put(string);
                        }
                    }
                }
                C1148d.m2518a(str, C1213a.m2848b(this.f1996b, "com.domobile.applock.plugins.protected_cached_apps"));
                C1148d.m2518a(jSONArray.toString(), C1213a.m2848b(this.f1996b, "com.domobile.applock.plugins.protected_apps"));
                C1148d.m2520b(this.f1996b, "protected_plugins_json_url", (Object) this.f1997c);
            } catch (Exception e) {
            } finally {
                this.f1995a.m2255a();
            }
        }
    }

    private void m2255a() {
        if (UpdateService.f2005a) {
            stopForeground(true);
        }
        stopSelf();
    }

    public static void m2256a(Context context, String str) {
        Object obj = null;
        JSONArray jSONArray = new JSONArray(C3613c.m15742f(new File(C1213a.m2848b(context, "com.domobile.applock.plugins.protected_cached_apps"))));
        JSONArray jSONArray2 = null;
        JSONArray jSONArray3;
        try {
            jSONArray3 = new JSONArray(C3613c.m15742f(new File(C1213a.m2848b(context, "com.domobile.applock.plugins.protected_apps"))));
            jSONArray2 = jSONArray3 == null ? new JSONArray() : jSONArray3;
        } catch (Exception e) {
            if (null == null) {
                jSONArray2 = new JSONArray();
            }
        } catch (Throwable th) {
            if (null == null) {
                jSONArray3 = new JSONArray();
            }
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(str, jSONArray.getString(i))) {
                    obj = 1;
                    jSONArray2.put(str);
                    break;
                }
            }
        }
        if (obj != null) {
            C1148d.m2518a(jSONArray2.toString(), C1213a.m2848b(context, "com.domobile.applock.plugins.protected_apps"));
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (UpdateService.f2005a) {
            startForeground(R.id.notify_foreground, C1150y.m2555T(this));
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("com.domobile.elock.EXTRA_DATA_STRING");
            C1148d.m2516a(new C1276e(), new C1067a(this, this, stringExtra));
        } else {
            m2255a();
        }
        return onStartCommand;
    }
}
