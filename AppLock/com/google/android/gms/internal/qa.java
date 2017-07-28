package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import java.util.concurrent.Callable;

@wh
public class qa {
    private final Object f10256a = new Object();
    private final ConditionVariable f10257b = new ConditionVariable();
    private volatile boolean f10258c = false;
    @Nullable
    private SharedPreferences f10259d = null;

    public <T> T m13264a(final pw<T> pwVar) {
        if (this.f10257b.block(5000)) {
            if (!this.f10258c) {
                synchronized (this.f10256a) {
                    if (!this.f10258c) {
                        T b = pwVar.m13224b();
                        return b;
                    }
                }
            }
            return zz.m15285a(new Callable<T>(this) {
                final /* synthetic */ qa f10255b;

                public T call() {
                    return pwVar.mo3898a(this.f10255b.f10259d);
                }
            });
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m13265a(android.content.Context r4) {
        /*
        r3 = this;
        r0 = r3.f10258c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r1 = r3.f10256a;
        monitor-enter(r1);
        r0 = r3.f10258c;	 Catch:{ all -> 0x000e }
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0004;
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        throw r0;
    L_0x0011:
        r0 = com.google.android.gms.common.C2489m.m7870g(r4);	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x001e;
    L_0x0017:
        r0 = r3.f10257b;	 Catch:{ all -> 0x000e }
        r0.open();	 Catch:{ all -> 0x000e }
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0004;
    L_0x001e:
        r2 = com.google.android.gms.ads.internal.zzw.zzcW();	 Catch:{ all -> 0x0032 }
        r0 = r2.m13241a(r0);	 Catch:{ all -> 0x0032 }
        r3.f10259d = r0;	 Catch:{ all -> 0x0032 }
        r0 = 1;
        r3.f10258c = r0;	 Catch:{ all -> 0x0032 }
        r0 = r3.f10257b;	 Catch:{ all -> 0x000e }
        r0.open();	 Catch:{ all -> 0x000e }
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0004;
    L_0x0032:
        r0 = move-exception;
        r2 = r3.f10257b;	 Catch:{ all -> 0x000e }
        r2.open();	 Catch:{ all -> 0x000e }
        throw r0;	 Catch:{ all -> 0x000e }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.qa.a(android.content.Context):void");
    }
}
