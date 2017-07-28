package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zzmk.C3513a;

@wh
public class wi {

    public interface C2361a {
        void zza(C3457a c3457a);
    }

    public zg m14494a(Context context, C3513a c3513a, C2361a c2361a) {
        zg wvVar = c3513a.f11945b.f11879c.getBundle("sdk_less_server_data") != null ? new wv(context, c3513a, c2361a) : new wj(context, c3513a, c2361a);
        wvVar.zziP();
        return wvVar;
    }
}
