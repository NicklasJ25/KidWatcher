package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.Callable;

@wh
public class aav {
    public aat m8574a(Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable ed edVar, zzqh com_google_android_gms_internal_zzqh) {
        final Context context2 = context;
        final zzeg com_google_android_gms_internal_zzeg2 = com_google_android_gms_internal_zzeg;
        final boolean z3 = z;
        final boolean z4 = z2;
        final ed edVar2 = edVar;
        final zzqh com_google_android_gms_internal_zzqh2 = com_google_android_gms_internal_zzqh;
        return (aat) zz.m15285a(new Callable<aat>(this) {
            final /* synthetic */ aav f7702g;

            public aat m8572a() {
                return this.f7702g.m8575a(context2, com_google_android_gms_internal_zzeg2, z3, z4, edVar2, com_google_android_gms_internal_zzqh2, null, null, null);
            }

            public /* synthetic */ Object call() {
                return m8572a();
            }
        });
    }

    public aat m8575a(Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable ed edVar, zzqh com_google_android_gms_internal_zzqh, qj qjVar, zzu com_google_android_gms_ads_internal_zzu, zze com_google_android_gms_ads_internal_zze) {
        final Context context2 = context;
        final zzeg com_google_android_gms_internal_zzeg2 = com_google_android_gms_internal_zzeg;
        final boolean z3 = z;
        final boolean z4 = z2;
        final ed edVar2 = edVar;
        final zzqh com_google_android_gms_internal_zzqh2 = com_google_android_gms_internal_zzqh;
        final qj qjVar2 = qjVar;
        final zzu com_google_android_gms_ads_internal_zzu2 = com_google_android_gms_ads_internal_zzu;
        final zze com_google_android_gms_ads_internal_zze2 = com_google_android_gms_ads_internal_zze;
        return (aat) zz.m15285a(new Callable<aat>(this) {
            public aat m8573a() {
                aat com_google_android_gms_internal_aaw = new aaw(aay.m8643a(context2, com_google_android_gms_internal_zzeg2, z3, z4, edVar2, com_google_android_gms_internal_zzqh2, qjVar2, com_google_android_gms_ads_internal_zzu2, com_google_android_gms_ads_internal_zze2));
                com_google_android_gms_internal_aaw.setWebViewClient(zzw.zzcO().mo4250a(com_google_android_gms_internal_aaw, z4));
                com_google_android_gms_internal_aaw.setWebChromeClient(zzw.zzcO().mo4255c(com_google_android_gms_internal_aaw));
                return com_google_android_gms_internal_aaw;
            }

            public /* synthetic */ Object call() {
                return m8573a();
            }
        });
    }
}
