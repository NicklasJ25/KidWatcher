package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.uc.C3321a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@wh
public final class un<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C3321a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f10894a;
    private final NETWORK_EXTRAS f10895b;

    public un(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f10894a = mediationAdapter;
        this.f10895b = network_extras;
    }

    private SERVER_PARAMETERS m14239a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                aad.m8424c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f10894a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public C2309a mo4062a() {
        if (this.f10894a instanceof MediationBannerAdapter) {
            try {
                return C2312b.m7327a(((MediationBannerAdapter) this.f10894a).getBannerView());
            } catch (Throwable th) {
                aad.m8424c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f10894a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo4063a(C2309a c2309a) {
    }

    public void mo4064a(C2309a c2309a, yk ykVar, List<String> list) {
    }

    public void mo4065a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, ud udVar) {
        mo4067a(c2309a, com_google_android_gms_internal_zzec, str, null, udVar);
    }

    public void mo4066a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, yk ykVar, String str2) {
    }

    public void mo4067a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar) {
        if (this.f10894a instanceof MediationInterstitialAdapter) {
            aad.m8421b("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f10894a).requestInterstitialAd(new uo(udVar), (Activity) C2312b.m7328a(c2309a), m14239a(str, com_google_android_gms_internal_zzec.f11883g, str2), up.m14267a(com_google_android_gms_internal_zzec), this.f10895b);
            } catch (Throwable th) {
                aad.m8424c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f10894a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4068a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
    }

    public void mo4069a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, ud udVar) {
        mo4070a(c2309a, com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzec, str, null, udVar);
    }

    public void mo4070a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar) {
        if (this.f10894a instanceof MediationBannerAdapter) {
            aad.m8421b("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.f10894a).requestBannerAd(new uo(udVar), (Activity) C2312b.m7328a(c2309a), m14239a(str, com_google_android_gms_internal_zzec.f11883g, str2), up.m14266a(com_google_android_gms_internal_zzeg), up.m14267a(com_google_android_gms_internal_zzec), this.f10895b);
            } catch (Throwable th) {
                aad.m8424c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f10894a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4071a(zzec com_google_android_gms_internal_zzec, String str) {
    }

    public void mo4072a(zzec com_google_android_gms_internal_zzec, String str, String str2) {
    }

    public void mo4073b() {
        if (this.f10894a instanceof MediationInterstitialAdapter) {
            aad.m8421b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f10894a).showInterstitial();
            } catch (Throwable th) {
                aad.m8424c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f10894a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo4074c() {
        try {
            this.f10894a.destroy();
        } catch (Throwable th) {
            aad.m8424c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo4075d() {
        throw new RemoteException();
    }

    public void mo4076e() {
        throw new RemoteException();
    }

    public void mo4077f() {
    }

    public boolean mo4078g() {
        return true;
    }

    public uf mo4079h() {
        return null;
    }

    public ug mo4080i() {
        return null;
    }

    public Bundle mo4081j() {
        return new Bundle();
    }

    public Bundle mo4082k() {
        return new Bundle();
    }

    public Bundle mo4083l() {
        return new Bundle();
    }

    public boolean mo4084m() {
        return false;
    }
}
