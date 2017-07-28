package com.facebook.ads.internal.p018m;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p030j.p031a.C1618a;
import com.facebook.ads.internal.p030j.p031a.C1631n;
import com.facebook.ads.internal.p030j.p031a.C1633p;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aj extends AsyncTask<String, Void, ak> {
    private static final String f4227a = aj.class.getSimpleName();
    private static final Set<String> f4228b = new HashSet();
    private Map<String, String> f4229c;
    private Map<String, String> f4230d;
    private C1631n f4231e;
    private C1444a f4232f;

    public interface C1444a {
        void mo2620a();

        void mo2621a(ak akVar);
    }

    static {
        f4228b.add("#");
        f4228b.add("null");
    }

    public aj() {
        this(null, null);
    }

    public aj(Map<String, String> map) {
        this(map, null);
    }

    public aj(Map<String, String> map, Map<String, String> map2) {
        Map map3 = null;
        this.f4229c = map != null ? new HashMap(map) : null;
        if (map2 != null) {
            map3 = new HashMap(map2);
        }
        this.f4230d = map3;
    }

    private String m4836a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    private boolean m4837a(String str) {
        C1618a b = ai.m4830b();
        try {
            if (this.f4230d == null || this.f4230d.size() == 0) {
                this.f4231e = b.m4548a(str, null);
            } else {
                C1633p c1633p = new C1633p();
                c1633p.m4595a(this.f4230d);
                this.f4231e = b.m4557b(str, c1633p);
            }
            return this.f4231e != null && this.f4231e.m4588a() == 200;
        } catch (Throwable e) {
            Log.e(f4227a, "Error opening url: " + str, e);
            return false;
        }
    }

    private String m4838b(String str) {
        try {
            str = m4836a(str, "analog", C1729s.m4963a(C1694b.m4844a()));
        } catch (Exception e) {
        }
        return str;
    }

    protected ak m4839a(String... strArr) {
        Object obj = strArr[0];
        if (TextUtils.isEmpty(obj) || f4228b.contains(obj)) {
            return null;
        }
        String b = m4838b(obj);
        if (!(this.f4229c == null || this.f4229c.isEmpty())) {
            String str = b;
            for (Entry entry : this.f4229c.entrySet()) {
                str = m4836a(str, (String) entry.getKey(), (String) entry.getValue());
            }
            b = str;
        }
        int i = 1;
        while (true) {
            int i2 = i + 1;
            if (i > 2) {
                return null;
            }
            if (m4837a(b)) {
                return new ak(this.f4231e);
            }
            i = i2;
        }
    }

    public void m4840a(C1444a c1444a) {
        this.f4232f = c1444a;
    }

    protected void m4841a(ak akVar) {
        if (this.f4232f != null) {
            this.f4232f.mo2621a(akVar);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4839a((String[]) objArr);
    }

    protected void onCancelled() {
        if (this.f4232f != null) {
            this.f4232f.mo2620a();
        }
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4841a((ak) obj);
    }
}
