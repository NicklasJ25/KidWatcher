package com.facebook.ads.internal.p020a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p022h.C1599g;
import java.util.Map;

public abstract class C1468a {
    public abstract C1720a mo2641a();

    protected void m3799a(Context context, String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            C1599g a = C1599g.m4464a(context);
            if (this instanceof C1470c) {
                a.m4485g(str, map);
            } else {
                a.mo2742b(str, map);
            }
        }
        C1729s.m4971a(context, "Click logged");
    }

    public abstract void mo2642b();
}
