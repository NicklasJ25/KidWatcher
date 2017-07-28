package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@wh
public final class xd {
    private zzmp f11321A;
    private boolean f11322B = false;
    private String f11323C;
    private List<String> f11324D;
    private boolean f11325E;
    private String f11326F;
    private zzor f11327G;
    private boolean f11328H;
    private final zzmk f11329I;
    private String f11330a;
    private String f11331b;
    private String f11332c;
    private List<String> f11333d;
    private String f11334e;
    private String f11335f;
    private String f11336g;
    private List<String> f11337h;
    private long f11338i = -1;
    private boolean f11339j = false;
    private final long f11340k = -1;
    private List<String> f11341l;
    private long f11342m = -1;
    private int f11343n = -1;
    private boolean f11344o = false;
    private boolean f11345p = false;
    private boolean f11346q = false;
    private boolean f11347r = true;
    private boolean f11348s = true;
    private String f11349t = "";
    private boolean f11350u = false;
    private boolean f11351v = false;
    private zzoo f11352w;
    private List<String> f11353x;
    private List<String> f11354y;
    private boolean f11355z = false;

    public xd(zzmk com_google_android_gms_internal_zzmk, String str) {
        this.f11331b = str;
        this.f11329I = com_google_android_gms_internal_zzmk;
    }

    private void m14707A(Map<String, List<String>> map) {
        this.f11322B |= m14719d(map, "X-Afma-Auto-Collect-Location");
    }

    private void m14708B(Map<String, List<String>> map) {
        List c = m14716c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.f11324D = c;
        }
    }

    private void m14709C(Map<String, List<String>> map) {
        Object a = m14713a(map, "X-Afma-Auto-Protection-Configuration");
        if (a == null || TextUtils.isEmpty(a)) {
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.f11335f)) {
                buildUpon.appendQueryParameter("debugDialog", this.f11335f);
            }
            boolean booleanValue = ((Boolean) qb.f10297j.m13225c()).booleanValue();
            String[] strArr = new String[1];
            String valueOf = String.valueOf(buildUpon.toString());
            String valueOf2 = String.valueOf("navigationURL");
            strArr[0] = new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append(valueOf).append("&").append(valueOf2).append("={NAVIGATION_URL}").toString();
            this.f11321A = new zzmp(booleanValue, Arrays.asList(strArr));
            return;
        }
        try {
            this.f11321A = zzmp.m15388a(new JSONObject(a));
        } catch (Throwable e) {
            aad.m8424c("Error parsing configuration JSON", e);
            this.f11321A = new zzmp();
        }
    }

    private void m14710D(Map<String, List<String>> map) {
        this.f11323C = m14713a(map, "Set-Cookie");
    }

    private void m14711E(Map<String, List<String>> map) {
        Object a = m14713a(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(a)) {
            try {
                this.f11327G = zzor.m15396a(new JSONObject(a));
            } catch (Throwable e) {
                aad.m8424c("Error parsing safe browsing header", e);
            }
        }
    }

    private void m14712F(Map<String, List<String>> map) {
        Object a = m14713a(map, "X-Afma-Pool");
        if (!TextUtils.isEmpty(a)) {
            try {
                this.f11328H = new JSONObject(a).getBoolean("never_pool");
            } catch (Throwable e) {
                aad.m8424c("Error parsing interstitial pool header", e);
            }
        }
    }

    static String m14713a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long m14714b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                aad.m8426e(new StringBuilder((String.valueOf(str).length() + 36) + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    private void m14715b(Map<String, List<String>> map) {
        this.f11330a = m14713a(map, "X-Afma-Ad-Size");
    }

    static List<String> m14716c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m14717c(Map<String, List<String>> map) {
        this.f11326F = m14713a(map, "X-Afma-Ad-Slot-Size");
    }

    private void m14718d(Map<String, List<String>> map) {
        List c = m14716c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f11333d = c;
        }
    }

    private boolean m14719d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void m14720e(Map<String, List<String>> map) {
        this.f11334e = m14713a(map, "X-Afma-Debug-Signals");
    }

    private void m14721f(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f11335f = (String) list.get(0);
        }
    }

    private void m14722g(Map<String, List<String>> map) {
        List c = m14716c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f11337h = c;
        }
    }

    private void m14723h(Map<String, List<String>> map) {
        long b = m14714b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f11338i = b;
        }
    }

    private void m14724i(Map<String, List<String>> map) {
        this.f11336g = m14713a(map, "X-Afma-ActiveView");
    }

    private void m14725j(Map<String, List<String>> map) {
        this.f11345p = "native".equals(m14713a(map, "X-Afma-Ad-Format"));
    }

    private void m14726k(Map<String, List<String>> map) {
        this.f11344o |= m14719d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void m14727l(Map<String, List<String>> map) {
        this.f11339j |= m14719d(map, "X-Afma-Mediation");
    }

    private void m14728m(Map<String, List<String>> map) {
        this.f11325E |= m14719d(map, "X-Afma-Render-In-Browser");
    }

    private void m14729n(Map<String, List<String>> map) {
        List c = m14716c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f11341l = c;
        }
    }

    private void m14730o(Map<String, List<String>> map) {
        long b = m14714b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f11342m = b;
        }
    }

    private void m14731p(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f11343n = zzw.zzcO().mo4249b();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f11343n = zzw.zzcO().mo4247a();
            }
        }
    }

    private void m14732q(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.f11346q = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m14733r(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f11347r = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m14734s(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f11348s = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m14735t(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.f11349t = (String) list.get(0);
        }
    }

    private void m14736u(Map<String, List<String>> map) {
        String a = m14713a(map, "X-Afma-Fluid");
        if (a != null && a.equals("height")) {
            this.f11350u = true;
        }
    }

    private void m14737v(Map<String, List<String>> map) {
        this.f11351v = "native_express".equals(m14713a(map, "X-Afma-Ad-Format"));
    }

    private void m14738w(Map<String, List<String>> map) {
        this.f11352w = zzoo.m15393a(m14713a(map, "X-Afma-Rewards"));
    }

    private void m14739x(Map<String, List<String>> map) {
        if (this.f11353x == null) {
            this.f11353x = m14716c(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    private void m14740y(Map<String, List<String>> map) {
        if (this.f11354y == null) {
            this.f11354y = m14716c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    private void m14741z(Map<String, List<String>> map) {
        this.f11355z |= m14719d(map, "X-Afma-Use-Displayed-Impression");
    }

    public zzmn m14742a(long j) {
        return new zzmn(this.f11329I, this.f11331b, this.f11332c, this.f11333d, this.f11337h, this.f11338i, this.f11339j, -1, this.f11341l, this.f11342m, this.f11343n, this.f11330a, j, this.f11335f, this.f11336g, this.f11344o, this.f11345p, this.f11346q, this.f11347r, false, this.f11349t, this.f11350u, this.f11351v, this.f11352w, this.f11353x, this.f11354y, this.f11355z, this.f11321A, this.f11322B, this.f11323C, this.f11324D, this.f11325E, this.f11326F, this.f11327G, this.f11334e, this.f11348s, this.f11328H);
    }

    public void m14743a(String str, Map<String, List<String>> map, String str2) {
        this.f11332c = str2;
        m14744a((Map) map);
    }

    public void m14744a(Map<String, List<String>> map) {
        m14715b(map);
        m14717c(map);
        m14718d(map);
        m14720e(map);
        m14721f(map);
        m14722g(map);
        m14723h(map);
        m14727l(map);
        m14729n(map);
        m14730o(map);
        m14731p(map);
        m14724i(map);
        m14732q(map);
        m14726k(map);
        m14725j(map);
        m14733r(map);
        m14734s(map);
        m14735t(map);
        m14736u(map);
        m14737v(map);
        m14738w(map);
        m14739x(map);
        m14740y(map);
        m14741z(map);
        m14707A(map);
        m14710D(map);
        m14709C(map);
        m14708B(map);
        m14711E(map);
        m14728m(map);
        m14712F(map);
    }
}
