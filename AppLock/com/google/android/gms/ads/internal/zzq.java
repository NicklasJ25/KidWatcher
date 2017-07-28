package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.oy.C2397a;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yb;
import com.google.android.gms.internal.zo;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public class zzq extends C2397a {
    private static final Object f7023b = new Object();
    @Nullable
    private static zzq f7024c;
    private final Context f7025a;
    private final Object f7026d = new Object();
    private boolean f7027e;
    private boolean f7028f;
    private float f7029g = -1.0f;
    private zzqh f7030h;

    zzq(Context context, zzqh com_google_android_gms_internal_zzqh) {
        this.f7025a = context;
        this.f7030h = com_google_android_gms_internal_zzqh;
        this.f7027e = false;
    }

    public static zzq zza(Context context, zzqh com_google_android_gms_internal_zzqh) {
        zzq com_google_android_gms_ads_internal_zzq;
        synchronized (f7023b) {
            if (f7024c == null) {
                f7024c = new zzq(context.getApplicationContext(), com_google_android_gms_internal_zzqh);
            }
            com_google_android_gms_ads_internal_zzq = f7024c;
        }
        return com_google_android_gms_ads_internal_zzq;
    }

    @Nullable
    public static zzq zzcp() {
        zzq com_google_android_gms_ads_internal_zzq;
        synchronized (f7023b) {
            com_google_android_gms_ads_internal_zzq = f7024c;
        }
        return com_google_android_gms_ads_internal_zzq;
    }

    zo m7558a(Context context) {
        return new zo(context);
    }

    public void initialize() {
        synchronized (f7023b) {
            if (this.f7027e) {
                aad.m8426e("Mobile ads is initialized already.");
                return;
            }
            this.f7027e = true;
            qb.m13268a(this.f7025a);
            zzw.zzcQ().m14994a(this.f7025a, this.f7030h);
            zzw.zzcR().m12849a(this.f7025a);
        }
    }

    public void setAppMuted(boolean z) {
        synchronized (this.f7026d) {
            this.f7028f = z;
        }
    }

    public void setAppVolume(float f) {
        synchronized (this.f7026d) {
            this.f7029g = f;
        }
    }

    public void zzb(C2309a c2309a, String str) {
        if (c2309a == null) {
            aad.m8423c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) C2312b.m7328a(c2309a);
        if (context == null) {
            aad.m8423c("Context is null. Failed to open debug menu.");
            return;
        }
        zo a = m7558a(context);
        a.m15234a(str);
        a.m15235b(this.f7030h.f12081a);
        a.m15231a();
    }

    public void zzc(String str, C2309a c2309a) {
        if (!TextUtils.isEmpty(str)) {
            final Runnable runnable;
            int i;
            qb.m13268a(this.f7025a);
            int booleanValue = ((Boolean) qb.cD.m13225c()).booleanValue() | ((Boolean) qb.aH.m13225c()).booleanValue();
            if (((Boolean) qb.aH.m13225c()).booleanValue()) {
                runnable = (Runnable) C2312b.m7328a(c2309a);
                runnable = new Runnable(this) {
                    final /* synthetic */ zzq f7022b;

                    class C23951 implements Runnable {
                        final /* synthetic */ C23961 f7020a;

                        C23951(C23961 c23961) {
                            this.f7020a = c23961;
                        }

                        public void run() {
                            yb.m14852a(this.f7020a.f7022b.f7025a, runnable);
                        }
                    }

                    public void run() {
                        zzw.zzcM().m15125a(new C23951(this));
                    }
                };
                i = 1;
            } else {
                runnable = null;
                i = booleanValue;
            }
            if (i != 0) {
                zzw.zzdi().zza(this.f7025a, this.f7030h, str, runnable);
            }
        }
    }

    public float zzcq() {
        float f;
        synchronized (this.f7026d) {
            f = this.f7029g;
        }
        return f;
    }

    public boolean zzcr() {
        boolean z;
        synchronized (this.f7026d) {
            z = this.f7029g >= 0.0f;
        }
        return z;
    }

    public boolean zzcs() {
        boolean z;
        synchronized (this.f7026d) {
            z = this.f7028f;
        }
        return z;
    }

    public void zzy(String str) {
        qb.m13268a(this.f7025a);
        if (!TextUtils.isEmpty(str) && ((Boolean) qb.cD.m13225c()).booleanValue()) {
            zzw.zzdi().zza(this.f7025a, this.f7030h, str, null);
        }
    }
}
