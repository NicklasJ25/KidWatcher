package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.vf;
import com.google.android.gms.internal.wh;
import com.google.android.gms.p065a.C2309a.C2311a;
import com.google.android.gms.p065a.C2312b;

@wh
public final class GInAppPurchaseManagerInfoParcel extends zza implements ReflectedParcelable {
    public static final Creator<GInAppPurchaseManagerInfoParcel> CREATOR = new zza();
    public final vf zzPn;
    public final Context zzPo;
    public final zzj zzPp;
    public final zzk zzvL;

    public GInAppPurchaseManagerInfoParcel(Context context, zzk com_google_android_gms_ads_internal_purchase_zzk, vf vfVar, zzj com_google_android_gms_ads_internal_purchase_zzj) {
        this.zzPo = context;
        this.zzvL = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzPn = vfVar;
        this.zzPp = com_google_android_gms_ads_internal_purchase_zzj;
    }

    GInAppPurchaseManagerInfoParcel(IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.zzvL = (zzk) C2312b.m7328a(C2311a.m7326a(iBinder));
        this.zzPn = (vf) C2312b.m7328a(C2311a.m7326a(iBinder2));
        this.zzPo = (Context) C2312b.m7328a(C2311a.m7326a(iBinder3));
        this.zzPp = (zzj) C2312b.m7328a(C2311a.m7326a(iBinder4));
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder m7441a() {
        return C2312b.m7327a(this.zzPp).asBinder();
    }

    IBinder m7442b() {
        return C2312b.m7327a(this.zzvL).asBinder();
    }

    IBinder m7443c() {
        return C2312b.m7327a(this.zzPn).asBinder();
    }

    IBinder m7444d() {
        return C2312b.m7327a(this.zzPo).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m7445a(this, parcel, i);
    }
}
