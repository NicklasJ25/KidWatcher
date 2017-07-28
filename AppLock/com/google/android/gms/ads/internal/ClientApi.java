package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.ot;
import com.google.android.gms.internal.ow.C2325a;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rf;
import com.google.android.gms.internal.td;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.va;
import com.google.android.gms.internal.vh;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.xp;
import com.google.android.gms.internal.xs;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@Keep
@DynamiteApi
@wh
public class ClientApi extends C2325a {
    public or createAdLoaderBuilder(C2309a c2309a, String str, ub ubVar, int i) {
        Context context = (Context) C2312b.m7328a(c2309a);
        return new zzl(context, str, ubVar, new zzqh(10260000, i, true, zzw.zzcM().m15165l(context)), zze.zzcc());
    }

    public va createAdOverlay(C2309a c2309a) {
        return new zze((Activity) C2312b.m7328a(c2309a));
    }

    public ot createBannerAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i) {
        Context context = (Context) C2312b.m7328a(c2309a);
        return new zzg(context, com_google_android_gms_internal_zzeg, str, ubVar, new zzqh(10260000, i, true, zzw.zzcM().m15165l(context)), zze.zzcc());
    }

    public vh createInAppPurchaseManager(C2309a c2309a) {
        return new com.google.android.gms.ads.internal.purchase.zze((Activity) C2312b.m7328a(c2309a));
    }

    public ot createInterstitialAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i) {
        Context context = (Context) C2312b.m7328a(c2309a);
        qb.m13268a(context);
        zzqh com_google_android_gms_internal_zzqh = new zzqh(10260000, i, true, zzw.zzcM().m15165l(context));
        boolean equals = "reward_mb".equals(com_google_android_gms_internal_zzeg.f11895a);
        Object obj = ((equals || !((Boolean) qb.aW.m13225c()).booleanValue()) && !(equals && ((Boolean) qb.aX.m13225c()).booleanValue())) ? null : 1;
        if (obj != null) {
            return new td(context, str, ubVar, com_google_android_gms_internal_zzqh, zze.zzcc());
        }
        return new zzm(context, com_google_android_gms_internal_zzeg, str, ubVar, com_google_android_gms_internal_zzqh, zze.zzcc());
    }

    public rf createNativeAdViewDelegate(C2309a c2309a, C2309a c2309a2) {
        return new rc((FrameLayout) C2312b.m7328a(c2309a), (FrameLayout) C2312b.m7328a(c2309a2));
    }

    public xs createRewardedVideoAd(C2309a c2309a, ub ubVar, int i) {
        Context context = (Context) C2312b.m7328a(c2309a);
        return new xp(context, zze.zzcc(), ubVar, new zzqh(10260000, i, true, zzw.zzcM().m15165l(context)));
    }

    public ot createSearchAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, int i) {
        Context context = (Context) C2312b.m7328a(c2309a);
        return new zzv(context, com_google_android_gms_internal_zzeg, str, new zzqh(10260000, i, true, zzw.zzcM().m15165l(context)));
    }

    @Nullable
    public oy getMobileAdsSettingsManager(C2309a c2309a) {
        return null;
    }

    public oy getMobileAdsSettingsManagerWithClientJarVersion(C2309a c2309a, int i) {
        Context context = (Context) C2312b.m7328a(c2309a);
        return zzq.zza(context, new zzqh(10260000, i, true, zzw.zzcM().m15165l(context)));
    }
}
