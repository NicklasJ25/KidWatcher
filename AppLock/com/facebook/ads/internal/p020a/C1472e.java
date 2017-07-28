package com.facebook.ads.internal.p020a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.p022h.C1600h;
import java.util.Map;

public class C1472e extends C1468a {
    private static final String f3422a = C1472e.class.getSimpleName();
    private final Context f3423b;
    private final String f3424c;
    private final Uri f3425d;
    private final Map<String, String> f3426e;

    public C1472e(Context context, String str, Uri uri, Map<String, String> map) {
        this.f3423b = context;
        this.f3424c = str;
        this.f3425d = uri;
        this.f3426e = map;
    }

    public C1720a mo2641a() {
        return null;
    }

    public void mo2642b() {
        C1599g a = C1599g.m4464a(this.f3423b);
        C1600h c1600h = C1600h.IMMEDIATE;
        Object queryParameter = this.f3425d.getQueryParameter("priority");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                c1600h = C1600h.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception e) {
            }
        }
        a.m4475a(this.f3424c, this.f3426e, this.f3425d.getQueryParameter("type"), c1600h);
    }
}
