package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;

@wh
public class sp extends zg {
    final aat f10584a;
    final sr f10585b;
    private final String f10586c;

    class C32411 implements Runnable {
        final /* synthetic */ sp f10583a;

        C32411(sp spVar) {
            this.f10583a = spVar;
        }

        public void run() {
            zzw.zzdj().m13744b(this.f10583a);
        }
    }

    sp(aat com_google_android_gms_internal_aat, sr srVar, String str) {
        this.f10584a = com_google_android_gms_internal_aat;
        this.f10585b = srVar;
        this.f10586c = str;
        zzw.zzdj().m13742a(this);
    }

    public void onStop() {
        this.f10585b.mo4016b();
    }

    public void zzco() {
        try {
            this.f10585b.mo4015a(this.f10586c);
        } finally {
            zl.f11678a.post(new C32411(this));
        }
    }
}
