package com.google.android.exoplayer2.p043j;

public final class C2255d {
    private boolean f6422a;

    public synchronized boolean m7034a() {
        boolean z = true;
        synchronized (this) {
            if (this.f6422a) {
                z = false;
            } else {
                this.f6422a = true;
                notifyAll();
            }
        }
        return z;
    }

    public synchronized boolean m7035b() {
        boolean z;
        z = this.f6422a;
        this.f6422a = false;
        return z;
    }

    public synchronized void m7036c() {
        while (!this.f6422a) {
            wait();
        }
    }
}
