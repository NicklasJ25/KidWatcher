package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@wh
class aak {
    private final Object f7645a = new Object();
    private final List<Runnable> f7646b = new ArrayList();
    private final List<Runnable> f7647c = new ArrayList();
    private boolean f7648d = false;

    private void m8446c(Runnable runnable) {
        zk.m15079a(runnable);
    }

    private void m8447d(Runnable runnable) {
        aac.f7622a.post(runnable);
    }

    public void m8448a() {
        synchronized (this.f7645a) {
            if (this.f7648d) {
                return;
            }
            for (Runnable c : this.f7646b) {
                m8446c(c);
            }
            for (Runnable c2 : this.f7647c) {
                m8447d(c2);
            }
            this.f7646b.clear();
            this.f7647c.clear();
            this.f7648d = true;
        }
    }

    public void m8449a(Runnable runnable) {
        synchronized (this.f7645a) {
            if (this.f7648d) {
                m8446c(runnable);
            } else {
                this.f7646b.add(runnable);
            }
        }
    }

    public void m8450b(Runnable runnable) {
        synchronized (this.f7645a) {
            if (this.f7648d) {
                m8447d(runnable);
            } else {
                this.f7647c.add(runnable);
            }
        }
    }
}
