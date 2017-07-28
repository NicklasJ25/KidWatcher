package com.google.android.gms.internal;

import java.util.concurrent.Future;

@wh
public abstract class zg implements zn<Future> {
    private final Runnable f6773a;
    private volatile Thread f6774b;
    private boolean f6775c;

    class C34611 implements Runnable {
        final /* synthetic */ zg f11622a;

        C34611(zg zgVar) {
            this.f11622a = zgVar;
        }

        public final void run() {
            this.f11622a.f6774b = Thread.currentThread();
            this.f11622a.zzco();
        }
    }

    public zg() {
        this.f6773a = new C34611(this);
        this.f6775c = false;
    }

    public zg(boolean z) {
        this.f6773a = new C34611(this);
        this.f6775c = z;
    }

    public final void cancel() {
        onStop();
        if (this.f6774b != null) {
            this.f6774b.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzco();

    public /* synthetic */ Object zziP() {
        return zzkG();
    }

    public final Future zzkG() {
        return this.f6775c ? zk.m15078a(1, this.f6773a) : zk.m15079a(this.f6773a);
    }
}
