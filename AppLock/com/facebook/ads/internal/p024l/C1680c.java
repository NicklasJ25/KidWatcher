package com.facebook.ads.internal.p024l;

import android.text.TextUtils;
import com.facebook.ads.C1462f;

public class C1680c {
    public static String m4790a() {
        if (TextUtils.isEmpty(C1462f.m3759a())) {
            return "https://graph.facebook.com/network_ads_common";
        }
        return String.format("https://graph.%s.facebook.com/network_ads_common", new Object[]{C1462f.m3759a()});
    }

    public static String m4791b() {
        if (TextUtils.isEmpty(C1462f.m3759a())) {
            return "https://www.facebook.com/adnw_logging/";
        }
        return String.format("https://www.%s.facebook.com/adnw_logging/", new Object[]{C1462f.m3759a()});
    }
}
