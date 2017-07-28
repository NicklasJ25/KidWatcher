package com.facebook.ads.internal.p020a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1729s;

public class C1473f extends C1468a {
    private static final String f3427a = C1473f.class.getSimpleName();
    private final Context f3428b;
    private final String f3429c;
    private final Uri f3430d;

    public C1473f(Context context, String str, Uri uri) {
        this.f3428b = context;
        this.f3429c = str;
        this.f3430d = uri;
    }

    public C1720a mo2641a() {
        return C1720a.OPEN_LINK;
    }

    public void mo2642b() {
        try {
            Log.w("REDIRECTACTION: ", this.f3430d.toString());
            C1729s.m4970a(this.f3428b, this.f3430d, this.f3429c);
        } catch (Throwable e) {
            Log.d(f3427a, "Failed to open link url: " + this.f3430d.toString(), e);
        }
    }
}
