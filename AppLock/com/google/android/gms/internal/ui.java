package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zza;
import com.google.android.gms.internal.uc.C3321a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@wh
public final class ui extends C3321a {
    private final MediationAdapter f10879a;
    private uj f10880b;

    public ui(MediationAdapter mediationAdapter) {
        this.f10879a = mediationAdapter;
    }

    private Bundle m14182a(String str, zzec com_google_android_gms_internal_zzec, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.f10879a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (com_google_android_gms_internal_zzec != null) {
                    bundle.putInt("tagForChildDirectedTreatment", com_google_android_gms_internal_zzec.f11883g);
                }
            }
            return bundle;
        } catch (Throwable th) {
            aad.m8424c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C2309a mo4062a() {
        if (this.f10879a instanceof MediationBannerAdapter) {
            try {
                return C2312b.m7327a(((MediationBannerAdapter) this.f10879a).getBannerView());
            } catch (Throwable th) {
                aad.m8424c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo4063a(C2309a c2309a) {
        try {
            ((OnContextChangedListener) this.f10879a).onContextChanged((Context) C2312b.m7328a(c2309a));
        } catch (Throwable th) {
            aad.m8419a("Could not inform adapter of changed context", th);
        }
    }

    public void mo4064a(C2309a c2309a, yk ykVar, List<String> list) {
        String str;
        if (this.f10879a instanceof InitializableMediationRewardedVideoAdAdapter) {
            aad.m8421b("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f10879a;
                List arrayList = new ArrayList();
                for (String str2 : list) {
                    arrayList.add(m14182a(str2, null, null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) C2312b.m7328a(c2309a), new yl(ykVar), arrayList);
            } catch (Throwable th) {
                aad.m8424c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            str2 = "MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            throw new RemoteException();
        }
    }

    public void mo4065a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, ud udVar) {
        mo4067a(c2309a, com_google_android_gms_internal_zzec, str, null, udVar);
    }

    public void mo4066a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, yk ykVar, String str2) {
        if (this.f10879a instanceof MediationRewardedVideoAdAdapter) {
            aad.m8421b("Initialize rewarded video adapter.");
            try {
                Bundle bundle;
                MediationAdRequest mediationAdRequest;
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f10879a;
                Bundle a = m14182a(str2, com_google_android_gms_internal_zzec, null);
                if (com_google_android_gms_internal_zzec != null) {
                    uh uhVar = new uh(com_google_android_gms_internal_zzec.f11878b == -1 ? null : new Date(com_google_android_gms_internal_zzec.f11878b), com_google_android_gms_internal_zzec.f11880d, com_google_android_gms_internal_zzec.f11881e != null ? new HashSet(com_google_android_gms_internal_zzec.f11881e) : null, com_google_android_gms_internal_zzec.f11887k, com_google_android_gms_internal_zzec.f11882f, com_google_android_gms_internal_zzec.f11883g, com_google_android_gms_internal_zzec.f11894r);
                    if (com_google_android_gms_internal_zzec.f11889m != null) {
                        bundle = com_google_android_gms_internal_zzec.f11889m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                        mediationAdRequest = uhVar;
                    } else {
                        bundle = null;
                        Object obj = uhVar;
                    }
                } else {
                    bundle = null;
                    mediationAdRequest = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) C2312b.m7328a(c2309a), mediationAdRequest, str, new yl(ykVar), a, bundle);
            } catch (Throwable th) {
                aad.m8424c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4067a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar) {
        if (this.f10879a instanceof MediationInterstitialAdapter) {
            aad.m8421b("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f10879a;
                mediationInterstitialAdapter.requestInterstitialAd((Context) C2312b.m7328a(c2309a), new uj(udVar), m14182a(str, com_google_android_gms_internal_zzec, str2), new uh(com_google_android_gms_internal_zzec.f11878b == -1 ? null : new Date(com_google_android_gms_internal_zzec.f11878b), com_google_android_gms_internal_zzec.f11880d, com_google_android_gms_internal_zzec.f11881e != null ? new HashSet(com_google_android_gms_internal_zzec.f11881e) : null, com_google_android_gms_internal_zzec.f11887k, com_google_android_gms_internal_zzec.f11882f, com_google_android_gms_internal_zzec.f11883g, com_google_android_gms_internal_zzec.f11894r), com_google_android_gms_internal_zzec.f11889m != null ? com_google_android_gms_internal_zzec.f11889m.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                aad.m8424c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4068a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
        if (this.f10879a instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.f10879a;
                um umVar = new um(com_google_android_gms_internal_zzec.f11878b == -1 ? null : new Date(com_google_android_gms_internal_zzec.f11878b), com_google_android_gms_internal_zzec.f11880d, com_google_android_gms_internal_zzec.f11881e != null ? new HashSet(com_google_android_gms_internal_zzec.f11881e) : null, com_google_android_gms_internal_zzec.f11887k, com_google_android_gms_internal_zzec.f11882f, com_google_android_gms_internal_zzec.f11883g, com_google_android_gms_internal_zzhc, list, com_google_android_gms_internal_zzec.f11894r);
                Bundle bundle = com_google_android_gms_internal_zzec.f11889m != null ? com_google_android_gms_internal_zzec.f11889m.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.f10880b = new uj(udVar);
                mediationNativeAdapter.requestNativeAd((Context) C2312b.m7328a(c2309a), this.f10880b, m14182a(str, com_google_android_gms_internal_zzec, str2), umVar, bundle);
            } catch (Throwable th) {
                aad.m8424c("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4069a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, ud udVar) {
        mo4070a(c2309a, com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzec, str, null, udVar);
    }

    public void mo4070a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar) {
        if (this.f10879a instanceof MediationBannerAdapter) {
            aad.m8421b("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f10879a;
                mediationBannerAdapter.requestBannerAd((Context) C2312b.m7328a(c2309a), new uj(udVar), m14182a(str, com_google_android_gms_internal_zzec, str2), zza.zza(com_google_android_gms_internal_zzeg.f11899e, com_google_android_gms_internal_zzeg.f11896b, com_google_android_gms_internal_zzeg.f11895a), new uh(com_google_android_gms_internal_zzec.f11878b == -1 ? null : new Date(com_google_android_gms_internal_zzec.f11878b), com_google_android_gms_internal_zzec.f11880d, com_google_android_gms_internal_zzec.f11881e != null ? new HashSet(com_google_android_gms_internal_zzec.f11881e) : null, com_google_android_gms_internal_zzec.f11887k, com_google_android_gms_internal_zzec.f11882f, com_google_android_gms_internal_zzec.f11883g, com_google_android_gms_internal_zzec.f11894r), com_google_android_gms_internal_zzec.f11889m != null ? com_google_android_gms_internal_zzec.f11889m.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                aad.m8424c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4071a(zzec com_google_android_gms_internal_zzec, String str) {
        mo4072a(com_google_android_gms_internal_zzec, str, null);
    }

    public void mo4072a(zzec com_google_android_gms_internal_zzec, String str, String str2) {
        if (this.f10879a instanceof MediationRewardedVideoAdAdapter) {
            aad.m8421b("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f10879a;
                mediationRewardedVideoAdAdapter.loadAd(new uh(com_google_android_gms_internal_zzec.f11878b == -1 ? null : new Date(com_google_android_gms_internal_zzec.f11878b), com_google_android_gms_internal_zzec.f11880d, com_google_android_gms_internal_zzec.f11881e != null ? new HashSet(com_google_android_gms_internal_zzec.f11881e) : null, com_google_android_gms_internal_zzec.f11887k, com_google_android_gms_internal_zzec.f11882f, com_google_android_gms_internal_zzec.f11883g, com_google_android_gms_internal_zzec.f11894r), m14182a(str, com_google_android_gms_internal_zzec, str2), com_google_android_gms_internal_zzec.f11889m != null ? com_google_android_gms_internal_zzec.f11889m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                aad.m8424c("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo4073b() {
        if (this.f10879a instanceof MediationInterstitialAdapter) {
            aad.m8421b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f10879a).showInterstitial();
            } catch (Throwable th) {
                aad.m8424c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo4074c() {
        try {
            this.f10879a.onDestroy();
        } catch (Throwable th) {
            aad.m8424c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo4075d() {
        try {
            this.f10879a.onPause();
        } catch (Throwable th) {
            aad.m8424c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo4076e() {
        try {
            this.f10879a.onResume();
        } catch (Throwable th) {
            aad.m8424c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo4077f() {
        if (this.f10879a instanceof MediationRewardedVideoAdAdapter) {
            aad.m8421b("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f10879a).showVideo();
            } catch (Throwable th) {
                aad.m8424c("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public boolean mo4078g() {
        if (this.f10879a instanceof MediationRewardedVideoAdAdapter) {
            aad.m8421b("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f10879a).isInitialized();
            } catch (Throwable th) {
                aad.m8424c("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public uf mo4079h() {
        NativeAdMapper a = this.f10880b.m14206a();
        return a instanceof NativeAppInstallAdMapper ? new uk((NativeAppInstallAdMapper) a) : null;
    }

    public ug mo4080i() {
        NativeAdMapper a = this.f10880b.m14206a();
        return a instanceof NativeContentAdMapper ? new ul((NativeContentAdMapper) a) : null;
    }

    public Bundle mo4081j() {
        if (this.f10879a instanceof abg) {
            return ((abg) this.f10879a).m8751a();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
        aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle mo4082k() {
        if (this.f10879a instanceof abh) {
            return ((abh) this.f10879a).getInterstitialAdapterInfo();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.f10879a.getClass().getCanonicalName());
        aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle mo4083l() {
        return new Bundle();
    }

    public boolean mo4084m() {
        return this.f10879a instanceof InitializableMediationRewardedVideoAdAdapter;
    }
}
