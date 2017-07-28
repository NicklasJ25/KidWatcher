package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.wh;

@wh
public abstract class zzk {
    protected boolean m7410a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        C2590o.m8307b();
        return applicationInfo == null || applicationInfo.targetSdkVersion >= 11;
    }

    protected boolean m7411a(aat com_google_android_gms_internal_aat) {
        return com_google_android_gms_internal_aat.mo3423k().f11898d;
    }

    @Nullable
    public abstract zzj zza(Context context, aat com_google_android_gms_internal_aat, int i, boolean z, qj qjVar);
}
