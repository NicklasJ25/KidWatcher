package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zzmp;

@wh
public class zzf {
    private final Context f6948a;
    private final zzmp f6949b;
    private boolean f6950c;

    public zzf(Context context) {
        this(context, false);
    }

    public zzf(Context context, @Nullable C3457a c3457a) {
        this.f6948a = context;
        if (c3457a == null || c3457a.f11510b.f12024G == null) {
            this.f6949b = new zzmp();
        } else {
            this.f6949b = c3457a.f11510b.f12024G;
        }
    }

    public zzf(Context context, boolean z) {
        this.f6948a = context;
        this.f6949b = new zzmp(z);
    }

    public void recordClick() {
        this.f6950c = true;
    }

    public boolean zzcd() {
        return !this.f6949b.f12061a || this.f6950c;
    }

    public void zzx(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        aad.m8425d("Action was blocked because no touch was detected.");
        if (this.f6949b.f12061a && this.f6949b.f12062b != null) {
            for (String str2 : this.f6949b.f12062b) {
                if (!TextUtils.isEmpty(str2)) {
                    zzw.zzcM().m15141b(this.f6948a, "", str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }
}
