package com.facebook.ads.internal.p020a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1729s;
import java.util.Map;

public class C1471d extends C1468a {
    private static final String f3417a = C1471d.class.getSimpleName();
    private final Context f3418b;
    private final String f3419c;
    private final Uri f3420d;
    private final Map<String, String> f3421e;

    public C1471d(Context context, String str, Uri uri, Map<String, String> map) {
        this.f3418b = context;
        this.f3419c = str;
        this.f3420d = uri;
        this.f3421e = map;
    }

    public C1720a mo2641a() {
        return C1720a.OPEN_LINK;
    }

    public void mo2642b() {
        m3799a(this.f3418b, this.f3419c, this.f3421e);
        try {
            C1729s.m4970a(this.f3418b, Uri.parse(this.f3420d.getQueryParameter("link")), this.f3419c);
        } catch (Throwable e) {
            Log.d(f3417a, "Failed to open link url: " + this.f3420d.toString(), e);
        }
    }
}
