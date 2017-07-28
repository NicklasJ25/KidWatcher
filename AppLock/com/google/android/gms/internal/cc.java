package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.bp.C2711a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class cc {

    static class C2743a implements C2527b, C2528c {
        protected cd f8190a;
        private final String f8191b;
        private final String f8192c;
        private final LinkedBlockingQueue<C2711a> f8193d;
        private final HandlerThread f8194e = new HandlerThread("GassClient");

        public C2743a(Context context, String str, String str2) {
            this.f8191b = str;
            this.f8192c = str2;
            this.f8194e.start();
            this.f8190a = new cd(context, this.f8194e.getLooper(), this, this);
            this.f8193d = new LinkedBlockingQueue();
            m9287c();
        }

        public C2711a m9281a() {
            return m9285b(5000);
        }

        public void mo3346a(int i) {
            try {
                this.f8193d.put(new C2711a());
            } catch (InterruptedException e) {
            }
        }

        public void mo3347a(Bundle bundle) {
            cg b = m9286b();
            if (b != null) {
                try {
                    this.f8193d.put(b.mo3522a(new zzaqi(this.f8191b, this.f8192c)).m15348b());
                } catch (Throwable th) {
                } finally {
                    m9288d();
                    this.f8194e.quit();
                }
            }
        }

        public void mo3348a(ConnectionResult connectionResult) {
            try {
                this.f8193d.put(new C2711a());
            } catch (InterruptedException e) {
            }
        }

        public C2711a m9285b(int i) {
            C2711a c2711a;
            try {
                c2711a = (C2711a) this.f8193d.poll((long) i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                c2711a = null;
            }
            return c2711a == null ? new C2711a() : c2711a;
        }

        protected cg m9286b() {
            try {
                return this.f8190a.mo3338k();
            } catch (IllegalStateException e) {
                return null;
            } catch (DeadObjectException e2) {
                return null;
            }
        }

        protected void m9287c() {
            this.f8190a.m7987n();
        }

        public void m9288d() {
            if (this.f8190a == null) {
                return;
            }
            if (this.f8190a.m7977b() || this.f8190a.m7978c()) {
                this.f8190a.m7966a();
            }
        }
    }

    public static C2711a m9289a(Context context, String str, String str2) {
        return new C2743a(context, str, str2).m9281a();
    }
}
