package com.facebook.ads.internal.p030j.p031a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class C1624g implements C1623r {
    private void m4572a(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String str2 : (List) map.get(str)) {
                    mo2756a(str + ":" + str2);
                }
            }
        }
    }

    public void mo2755a(C1631n c1631n) {
        if (c1631n != null) {
            mo2756a("=== HTTP Response ===");
            mo2756a("Receive url: " + c1631n.m4589b());
            mo2756a("Status: " + c1631n.m4588a());
            m4572a(c1631n.m4590c());
            mo2756a("Content:\n" + c1631n.m4592e());
        }
    }

    public void mo2756a(String str) {
        System.out.println(str);
    }

    public void mo2757a(HttpURLConnection httpURLConnection, Object obj) {
        mo2756a("=== HTTP Request ===");
        mo2756a(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            mo2756a("Content: " + ((String) obj));
        }
        m4572a(httpURLConnection.getRequestProperties());
    }

    public boolean mo2758a() {
        return false;
    }
}
