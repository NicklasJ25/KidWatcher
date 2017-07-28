package com.facebook.ads.internal.p020a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1727r;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1731u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1470c extends C1468a {
    private static final String f3412a = C1470c.class.getSimpleName();
    private final Context f3413b;
    private final String f3414c;
    private final Uri f3415d;
    private final Map<String, String> f3416e;

    public C1470c(Context context, String str, Uri uri, Map<String, String> map) {
        this.f3413b = context;
        this.f3414c = str;
        this.f3415d = uri;
        this.f3416e = map;
    }

    private Intent m3803a(C1731u c1731u) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!(TextUtils.isEmpty(c1731u.m4981a()) || TextUtils.isEmpty(c1731u.m4982b()))) {
            intent.setComponent(new ComponentName(c1731u.m4981a(), c1731u.m4982b()));
        }
        if (!TextUtils.isEmpty(c1731u.m4983c())) {
            intent.setData(Uri.parse(c1731u.m4983c()));
        }
        return intent;
    }

    private Intent m3804b(C1731u c1731u) {
        if (TextUtils.isEmpty(c1731u.m4981a())) {
            return null;
        }
        if (!C1727r.m4954a(this.f3413b, c1731u.m4981a())) {
            return null;
        }
        CharSequence c = c1731u.m4983c();
        if (!TextUtils.isEmpty(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        PackageManager packageManager = this.f3413b.getPackageManager();
        if (TextUtils.isEmpty(c1731u.m4982b()) && TextUtils.isEmpty(c)) {
            return packageManager.getLaunchIntentForPackage(c1731u.m4981a());
        }
        Intent a = m3803a(c1731u);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, 65536);
        if (a.getComponent() == null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(c1731u.m4981a())) {
                    a.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        return (queryIntentActivities.isEmpty() || a.getComponent() == null) ? null : a;
    }

    private List<C1731u> m3805f() {
        Object queryParameter = this.f3415d.getQueryParameter("appsite_data");
        if (TextUtils.isEmpty(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        List<C1731u> arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                C1731u a = C1731u.m4980a(optJSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            Log.w(f3412a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    public C1720a mo2641a() {
        return C1720a.OPEN_STORE;
    }

    public void mo2642b() {
        m3799a(this.f3413b, this.f3414c, this.f3416e);
        List<Intent> d = m3809d();
        if (d != null) {
            for (Intent startActivity : d) {
                try {
                    this.f3413b.startActivity(startActivity);
                    return;
                } catch (Throwable e) {
                    Log.d(f3412a, "Failed to open app intent, falling back", e);
                }
            }
        }
        m3810e();
    }

    protected Uri m3808c() {
        Object queryParameter = this.f3415d.getQueryParameter("store_url");
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        String queryParameter2 = this.f3415d.getQueryParameter("store_id");
        return Uri.parse(String.format("market://details?id=%s", new Object[]{queryParameter2}));
    }

    protected List<Intent> m3809d() {
        List<C1731u> f = m3805f();
        List<Intent> arrayList = new ArrayList();
        if (f != null) {
            for (C1731u b : f) {
                Intent b2 = m3804b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    public void m3810e() {
        try {
            C1729s.m4970a(this.f3413b, m3808c(), this.f3414c);
        } catch (Throwable e) {
            Log.d(f3412a, "Failed to open market url: " + this.f3415d.toString(), e);
            String queryParameter = this.f3415d.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                try {
                    C1729s.m4970a(this.f3413b, Uri.parse(queryParameter), this.f3414c);
                } catch (Throwable e2) {
                    Log.d(f3412a, "Failed to open fallback url: " + queryParameter, e2);
                }
            }
        }
    }
}
