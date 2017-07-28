package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.ub.C3318a;
import java.util.Map;

@wh
public final class tz extends C3318a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f10865a;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> uc m14053c(String str) {
        try {
            Class cls = Class.forName(str, false, tz.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new un(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.f10865a.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new ui((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                aad.m8426e(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return m14054d(str);
        }
    }

    private uc m14054d(String str) {
        try {
            aad.m8421b("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new ui(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new ui(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new ui(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                MediationAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new un(customEventAdapter, (CustomEventExtras) this.f10865a.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            aad.m8424c(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
    }

    public uc mo4060a(String str) {
        return m14053c(str);
    }

    public void m14056a(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f10865a = map;
    }

    public boolean mo4061b(String str) {
        boolean z = false;
        try {
            z = CustomEvent.class.isAssignableFrom(Class.forName(str, false, tz.class.getClassLoader()));
        } catch (Throwable th) {
            aad.m8426e(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
        }
        return z;
    }
}
