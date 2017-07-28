package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.wh;

@wh
public class zzf {
    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzNN == 4 && adOverlayInfoParcel.zzNG == null) {
            if (adOverlayInfoParcel.zzNF != null) {
                adOverlayInfoParcel.zzNF.onAdClicked();
            }
            zzw.zzcJ().zza(context, adOverlayInfoParcel.zzNE, adOverlayInfoParcel.zzNM);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzvn.f12084d);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!C2590o.m8314i()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzw.zzcM().m15117a(context, intent);
    }
}
