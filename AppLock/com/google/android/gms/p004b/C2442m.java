package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class C2442m<TResult> {
    private final Object f7246a = new Object();
    private Queue<C2436l<TResult>> f7247b;
    private boolean f7248c;

    C2442m() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7696a(@android.support.annotation.NonNull com.google.android.gms.p004b.C2428e<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.f7246a;
        monitor-enter(r1);
        r0 = r2.f7247b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f7248c;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.f7248c = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.f7246a;
        monitor-enter(r1);
        r0 = r2.f7247b;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.google.android.gms.p004b.C2436l) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.f7248c = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.mo3305a(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.m.a(com.google.android.gms.b.e):void");
    }

    public void m7697a(@NonNull C2436l<TResult> c2436l) {
        synchronized (this.f7246a) {
            if (this.f7247b == null) {
                this.f7247b = new ArrayDeque();
            }
            this.f7247b.add(c2436l);
        }
    }
}
