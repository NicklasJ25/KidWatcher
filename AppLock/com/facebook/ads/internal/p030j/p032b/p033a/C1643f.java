package com.facebook.ads.internal.p030j.p032b.p033a;

import android.text.TextUtils;
import com.facebook.ads.internal.p030j.p032b.C1666m;

public class C1643f implements C1637c {
    private String m4630b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    public String mo2767a(String str) {
        Object b = m4630b(str);
        String d = C1666m.m4714d(str);
        return TextUtils.isEmpty(b) ? d : d + "." + b;
    }
}
