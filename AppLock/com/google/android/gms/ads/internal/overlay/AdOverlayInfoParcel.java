package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.rx;
import com.google.android.gms.internal.se;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.p065a.C2309a.C2311a;
import com.google.android.gms.p065a.C2312b;

@wh
public final class AdOverlayInfoParcel extends zza implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR = new zzg();
    public final int orientation;
    public final String url;
    public final zzc zzNE;
    public final ny zzNF;
    public final zzh zzNG;
    public final aat zzNH;
    public final rx zzNI;
    public final String zzNJ;
    public final boolean zzNK;
    public final String zzNL;
    public final zzq zzNM;
    public final int zzNN;
    public final se zzNO;
    public final String zzNP;
    public final zzn zzNQ;
    public final zzqh zzvn;

    AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzqh com_google_android_gms_internal_zzqh, IBinder iBinder6, String str4, zzn com_google_android_gms_ads_internal_zzn) {
        this.zzNE = com_google_android_gms_ads_internal_overlay_zzc;
        this.zzNF = (ny) C2312b.m7328a(C2311a.m7326a(iBinder));
        this.zzNG = (zzh) C2312b.m7328a(C2311a.m7326a(iBinder2));
        this.zzNH = (aat) C2312b.m7328a(C2311a.m7326a(iBinder3));
        this.zzNI = (rx) C2312b.m7328a(C2311a.m7326a(iBinder4));
        this.zzNJ = str;
        this.zzNK = z;
        this.zzNL = str2;
        this.zzNM = (zzq) C2312b.m7328a(C2311a.m7326a(iBinder5));
        this.orientation = i;
        this.zzNN = i2;
        this.url = str3;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = (se) C2312b.m7328a(C2311a.m7326a(iBinder6));
        this.zzNP = str4;
        this.zzNQ = com_google_android_gms_ads_internal_zzn;
    }

    public AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqh com_google_android_gms_internal_zzqh) {
        this.zzNE = com_google_android_gms_ads_internal_overlay_zzc;
        this.zzNF = nyVar;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = null;
        this.zzNI = null;
        this.zzNJ = null;
        this.zzNK = false;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = -1;
        this.zzNN = 4;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = null;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public AdOverlayInfoParcel(ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, aat com_google_android_gms_internal_aat, int i, zzqh com_google_android_gms_internal_zzqh, String str, zzn com_google_android_gms_ads_internal_zzn) {
        this.zzNE = null;
        this.zzNF = nyVar;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_aat;
        this.zzNI = null;
        this.zzNJ = null;
        this.zzNK = false;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 1;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = null;
        this.zzNP = str;
        this.zzNQ = com_google_android_gms_ads_internal_zzn;
    }

    public AdOverlayInfoParcel(ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, aat com_google_android_gms_internal_aat, boolean z, int i, zzqh com_google_android_gms_internal_zzqh) {
        this.zzNE = null;
        this.zzNF = nyVar;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_aat;
        this.zzNI = null;
        this.zzNJ = null;
        this.zzNK = z;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 2;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = null;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public AdOverlayInfoParcel(ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, rx rxVar, zzq com_google_android_gms_ads_internal_overlay_zzq, aat com_google_android_gms_internal_aat, boolean z, int i, String str, zzqh com_google_android_gms_internal_zzqh, se seVar) {
        this.zzNE = null;
        this.zzNF = nyVar;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_aat;
        this.zzNI = rxVar;
        this.zzNJ = null;
        this.zzNK = z;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 3;
        this.url = str;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = seVar;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public AdOverlayInfoParcel(ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, rx rxVar, zzq com_google_android_gms_ads_internal_overlay_zzq, aat com_google_android_gms_internal_aat, boolean z, int i, String str, String str2, zzqh com_google_android_gms_internal_zzqh, se seVar) {
        this.zzNE = null;
        this.zzNF = nyVar;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_aat;
        this.zzNI = rxVar;
        this.zzNJ = str2;
        this.zzNK = z;
        this.zzNL = str;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 3;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = seVar;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder m7371a() {
        return C2312b.m7327a(this.zzNF).asBinder();
    }

    IBinder m7372b() {
        return C2312b.m7327a(this.zzNG).asBinder();
    }

    IBinder m7373c() {
        return C2312b.m7327a(this.zzNH).asBinder();
    }

    IBinder m7374d() {
        return C2312b.m7327a(this.zzNI).asBinder();
    }

    IBinder m7375e() {
        return C2312b.m7327a(this.zzNO).asBinder();
    }

    IBinder m7376f() {
        return C2312b.m7327a(this.zzNM).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m7409a(this, parcel, i);
    }
}
