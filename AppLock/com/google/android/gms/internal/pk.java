package com.google.android.gms.internal;

import com.google.android.gms.internal.oq.C2384a;
import com.google.android.gms.internal.or.C2385a;

public class pk extends C2385a {
    private op f10235a;

    private class C3151a extends C2384a {
        final /* synthetic */ pk f10234a;

        class C31501 implements Runnable {
            final /* synthetic */ C3151a f10233a;

            C31501(C3151a c3151a) {
                this.f10233a = c3151a;
            }

            public void run() {
                if (this.f10233a.f10234a.f10235a != null) {
                    try {
                        this.f10233a.f10234a.f10235a.mo3854a(1);
                    } catch (Throwable e) {
                        aad.m8424c("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        }

        private C3151a(pk pkVar) {
            this.f10234a = pkVar;
        }

        public String getMediationAdapterClassName() {
            return null;
        }

        public boolean isLoading() {
            return false;
        }

        public void zzf(zzec com_google_android_gms_internal_zzec) {
            aad.m8423c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            aac.f7622a.post(new C31501(this));
        }
    }

    public void zza(rn rnVar) {
    }

    public void zza(ro roVar) {
    }

    public void zza(zzhc com_google_android_gms_internal_zzhc) {
    }

    public void zza(String str, rq rqVar, rp rpVar) {
    }

    public void zzb(op opVar) {
        this.f10235a = opVar;
    }

    public void zzb(ox oxVar) {
    }

    public oq zzck() {
        return new C3151a();
    }
}
