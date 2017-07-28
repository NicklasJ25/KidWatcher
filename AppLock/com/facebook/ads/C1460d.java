package com.facebook.ads;

import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;

public class C1460d {
    public static final C1460d f3363a = new C1460d(1000, "Network Error");
    public static final C1460d f3364b = new C1460d(PointerIconCompat.TYPE_CONTEXT_MENU, "No Fill");
    public static final C1460d f3365c = new C1460d(PointerIconCompat.TYPE_HAND, "Ad was re-loaded too frequently");
    public static final C1460d f3366d = new C1460d(2000, "Server Error");
    public static final C1460d f3367e = new C1460d(2001, "Internal Error");
    public static final C1460d f3368f = new C1460d(3001, "Mediation Error");
    @Deprecated
    public static final C1460d f3369g = new C1460d(2002, "Native ad failed to load due to missing properties");
    private final int f3370h;
    private final String f3371i;

    public C1460d(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "unknown error";
        }
        this.f3370h = i;
        this.f3371i = str;
    }

    public int m3756a() {
        return this.f3370h;
    }

    public String m3757b() {
        return this.f3371i;
    }
}
