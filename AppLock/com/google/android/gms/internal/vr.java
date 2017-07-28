package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;

@wh
public abstract class vr extends zg {
    protected final C2360a f11031a;
    protected final Context f11032b;
    protected final Object f11033c = new Object();
    protected final Object f11034d = new Object();
    protected final C3457a f11035e;
    protected zzmn f11036f;

    class C33641 implements Runnable {
        final /* synthetic */ vr f11027a;

        C33641(vr vrVar) {
            this.f11027a = vrVar;
        }

        public void run() {
            this.f11027a.onStop();
        }
    }

    protected static final class C3366a extends Exception {
        private final int f11030a;

        public C3366a(String str, int i) {
            super(str);
            this.f11030a = i;
        }

        public int m14369a() {
            return this.f11030a;
        }
    }

    protected vr(Context context, C3457a c3457a, C2360a c2360a) {
        super(true);
        this.f11032b = context;
        this.f11035e = c3457a;
        this.f11036f = c3457a.f11510b;
        this.f11031a = c2360a;
    }

    protected abstract yy mo4174a(int i);

    protected abstract void mo4175a(long j);

    protected void m14372a(yy yyVar) {
        this.f11031a.zzb(yyVar);
    }

    public void onStop() {
    }

    public void zzco() {
        int a;
        synchronized (this.f11033c) {
            aad.m8421b("AdRendererBackgroundTask started.");
            int i = this.f11035e.f11513e;
            try {
                mo4175a(SystemClock.elapsedRealtime());
            } catch (C3366a e) {
                a = e.m14369a();
                if (a == 3 || a == -1) {
                    aad.m8425d(e.getMessage());
                } else {
                    aad.m8426e(e.getMessage());
                }
                if (this.f11036f == null) {
                    this.f11036f = new zzmn(a);
                } else {
                    this.f11036f = new zzmn(a, this.f11036f.f12045k);
                }
                zl.f11678a.post(new C33641(this));
                i = a;
            }
            final yy a2 = mo4174a(i);
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ vr f11029b;

                public void run() {
                    synchronized (this.f11029b.f11033c) {
                        this.f11029b.m14372a(a2);
                    }
                }
            });
        }
    }
}
