package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2581f;
import com.google.android.gms.internal.pb.C2652a;
import java.util.HashMap;
import java.util.Map;

@wh
public class aaz extends C2652a {
    private final aat f7763a;
    private final Object f7764b = new Object();
    private final float f7765c;
    private int f7766d;
    private pc f7767e;
    private boolean f7768f;
    private boolean f7769g;
    private float f7770h;
    private boolean f7771i = true;
    private float f7772j;

    public aaz(aat com_google_android_gms_internal_aat, float f) {
        this.f7763a = com_google_android_gms_internal_aat;
        this.f7765c = f;
    }

    private void m8721a(final int i, final int i2) {
        zzw.zzcM().m15125a(new Runnable(this) {
            final /* synthetic */ aaz f7762c;

            public void run() {
                boolean z = false;
                synchronized (this.f7762c.f7764b) {
                    boolean z2 = i != i2;
                    boolean z3 = !this.f7762c.f7768f && i2 == 1;
                    boolean z4 = z2 && i2 == 1;
                    boolean z5 = z2 && i2 == 2;
                    z2 = z2 && i2 == 3;
                    aaz com_google_android_gms_internal_aaz = this.f7762c;
                    if (this.f7762c.f7768f || z3) {
                        z = true;
                    }
                    com_google_android_gms_internal_aaz.f7768f = z;
                    if (this.f7762c.f7767e == null) {
                        return;
                    }
                    if (z3) {
                        try {
                            this.f7762c.f7767e.mo3877a();
                        } catch (Throwable e) {
                            aad.m8424c("Unable to call onVideoStart()", e);
                        }
                    }
                    if (z4) {
                        try {
                            this.f7762c.f7767e.mo3878b();
                        } catch (Throwable e2) {
                            aad.m8424c("Unable to call onVideoPlay()", e2);
                        }
                    }
                    if (z5) {
                        try {
                            this.f7762c.f7767e.mo3879c();
                        } catch (Throwable e22) {
                            aad.m8424c("Unable to call onVideoPause()", e22);
                        }
                    }
                    if (z2) {
                        try {
                            this.f7762c.f7767e.mo3880d();
                        } catch (Throwable e222) {
                            aad.m8424c("Unable to call onVideoEnd()", e222);
                        }
                    }
                }
            }
        });
    }

    private void m8722a(String str) {
        m8723a(str, null);
    }

    private void m8723a(String str, @Nullable Map<String, String> map) {
        final Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzw.zzcM().m15125a(new Runnable(this) {
            final /* synthetic */ aaz f7759b;

            public void run() {
                this.f7759b.f7763a.mo3403a("pubVideoCmd", hashMap);
            }
        });
    }

    public void mo3449a() {
        m8722a("play");
    }

    public void m8729a(float f, int i, boolean z, float f2) {
        int i2;
        synchronized (this.f7764b) {
            this.f7770h = f;
            this.f7769g = z;
            i2 = this.f7766d;
            this.f7766d = i;
            this.f7772j = f2;
        }
        m8721a(i2, i);
    }

    public void mo3450a(pc pcVar) {
        synchronized (this.f7764b) {
            this.f7767e = pcVar;
        }
    }

    public void mo3451a(boolean z) {
        m8722a(z ? "mute" : "unmute");
    }

    public void mo3452b() {
        m8722a("pause");
    }

    public void m8733b(boolean z) {
        synchronized (this.f7764b) {
            this.f7771i = z;
        }
        m8723a("initialState", C2581f.m8285b((Object) "muteStart", z ? "1" : "0"));
    }

    public boolean mo3453c() {
        boolean z;
        synchronized (this.f7764b) {
            z = this.f7769g;
        }
        return z;
    }

    public int mo3454d() {
        int i;
        synchronized (this.f7764b) {
            i = this.f7766d;
        }
        return i;
    }

    public float mo3455e() {
        return this.f7765c;
    }

    public float mo3456f() {
        float f;
        synchronized (this.f7764b) {
            f = this.f7770h;
        }
        return f;
    }

    public float mo3457g() {
        float f;
        synchronized (this.f7764b) {
            f = this.f7772j;
        }
        return f;
    }
}
