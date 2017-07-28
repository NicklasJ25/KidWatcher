package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.ng.C3095b;

@wh
public class nr {
    private final Runnable f10052a = new C31041(this);
    private final Object f10053b = new Object();
    @Nullable
    private nt f10054c;
    @Nullable
    private Context f10055d;
    @Nullable
    private nw f10056e;

    class C31041 implements Runnable {
        final /* synthetic */ nr f10048a;

        C31041(nr nrVar) {
            this.f10048a = nrVar;
        }

        public void run() {
            this.f10048a.m12844c();
        }
    }

    class C31052 implements C3095b {
        final /* synthetic */ nr f10049a;

        C31052(nr nrVar) {
            this.f10049a = nrVar;
        }

        public void mo3849a(boolean z) {
            if (z) {
                this.f10049a.m12841b();
            } else {
                this.f10049a.m12844c();
            }
        }
    }

    class C31063 implements C2527b {
        final /* synthetic */ nr f10050a;

        C31063(nr nrVar) {
            this.f10050a = nrVar;
        }

        public void mo3346a(int i) {
            synchronized (this.f10050a.f10053b) {
                this.f10050a.f10056e = null;
                this.f10050a.f10053b.notifyAll();
            }
        }

        public void mo3347a(@Nullable Bundle bundle) {
            synchronized (this.f10050a.f10053b) {
                try {
                    this.f10050a.f10056e = this.f10050a.f10054c.mo3338k();
                } catch (Throwable e) {
                    aad.m8422b("Unable to obtain a cache service instance.", e);
                    this.f10050a.m12844c();
                }
                this.f10050a.f10053b.notifyAll();
            }
        }
    }

    class C31074 implements C2528c {
        final /* synthetic */ nr f10051a;

        C31074(nr nrVar) {
            this.f10051a = nrVar;
        }

        public void mo3348a(@NonNull ConnectionResult connectionResult) {
            synchronized (this.f10051a.f10053b) {
                this.f10051a.f10056e = null;
                if (this.f10051a.f10054c != null) {
                    this.f10051a.f10054c = null;
                    zzw.zzdc().m15278b();
                }
                this.f10051a.f10053b.notifyAll();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12841b() {
        /*
        r3 = this;
        r1 = r3.f10053b;
        monitor-enter(r1);
        r0 = r3.f10055d;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.f10054c;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = new com.google.android.gms.internal.nr$3;	 Catch:{ all -> 0x0024 }
        r0.<init>(r3);	 Catch:{ all -> 0x0024 }
        r2 = new com.google.android.gms.internal.nr$4;	 Catch:{ all -> 0x0024 }
        r2.<init>(r3);	 Catch:{ all -> 0x0024 }
        r0 = r3.m12846a(r0, r2);	 Catch:{ all -> 0x0024 }
        r3.f10054c = r0;	 Catch:{ all -> 0x0024 }
        r0 = r3.f10054c;	 Catch:{ all -> 0x0024 }
        r0.m7987n();	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        goto L_0x000c;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nr.b():void");
    }

    private void m12844c() {
        synchronized (this.f10053b) {
            if (this.f10054c == null) {
                return;
            }
            if (this.f10054c.m7977b() || this.f10054c.m7978c()) {
                this.f10054c.m7966a();
            }
            this.f10054c = null;
            this.f10056e = null;
            Binder.flushPendingCommands();
            zzw.zzdc().m15278b();
        }
    }

    protected nt m12846a(C2527b c2527b, C2528c c2528c) {
        return new nt(this.f10055d, zzw.zzdc().m15277a(), c2527b, c2528c);
    }

    public zzdp m12847a(zzds com_google_android_gms_internal_zzds) {
        zzdp com_google_android_gms_internal_zzdp;
        synchronized (this.f10053b) {
            if (this.f10056e == null) {
                com_google_android_gms_internal_zzdp = new zzdp();
            } else {
                try {
                    com_google_android_gms_internal_zzdp = this.f10056e.mo3850a(com_google_android_gms_internal_zzds);
                } catch (Throwable e) {
                    aad.m8422b("Unable to call into cache service.", e);
                    com_google_android_gms_internal_zzdp = new zzdp();
                }
            }
        }
        return com_google_android_gms_internal_zzdp;
    }

    public void m12848a() {
        if (((Boolean) qb.da.m13225c()).booleanValue()) {
            synchronized (this.f10053b) {
                m12841b();
                zzw.zzcM();
                zl.f11678a.removeCallbacks(this.f10052a);
                zzw.zzcM();
                zl.f11678a.postDelayed(this.f10052a, ((Long) qb.db.m13225c()).longValue());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m12849a(android.content.Context r3) {
        /*
        r2 = this;
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = r2.f10053b;
        monitor-enter(r1);
        r0 = r2.f10055d;	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        goto L_0x0002;
    L_0x000c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        throw r0;
    L_0x000f:
        r0 = r3.getApplicationContext();	 Catch:{ all -> 0x000c }
        r2.f10055d = r0;	 Catch:{ all -> 0x000c }
        r0 = com.google.android.gms.internal.qb.cZ;	 Catch:{ all -> 0x000c }
        r0 = r0.m13225c();	 Catch:{ all -> 0x000c }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x000c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x0028;
    L_0x0023:
        r2.m12841b();	 Catch:{ all -> 0x000c }
    L_0x0026:
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        goto L_0x0002;
    L_0x0028:
        r0 = com.google.android.gms.internal.qb.cY;	 Catch:{ all -> 0x000c }
        r0 = r0.m13225c();	 Catch:{ all -> 0x000c }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x000c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x0026;
    L_0x0036:
        r0 = new com.google.android.gms.internal.nr$2;	 Catch:{ all -> 0x000c }
        r0.<init>(r2);	 Catch:{ all -> 0x000c }
        r2.m12850a(r0);	 Catch:{ all -> 0x000c }
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nr.a(android.content.Context):void");
    }

    protected void m12850a(C3095b c3095b) {
        zzw.zzcP().m12783a(c3095b);
    }
}
