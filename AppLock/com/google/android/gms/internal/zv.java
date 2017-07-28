package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;

@wh
public final class zv extends zg {
    private final aae f11748a;
    private final String f11749b;

    public zv(Context context, String str, String str2) {
        this(str2, zzw.zzcM().m15106a(context, str));
    }

    public zv(String str, String str2) {
        this.f11748a = new aae(str2);
        this.f11749b = str;
    }

    public void onStop() {
    }

    public void zzco() {
        this.f11748a.mo3376a(this.f11749b);
    }
}
