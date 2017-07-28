package com.google.android.gms.internal;

import com.google.firebase.C3531b;

public class hb extends ha {
    public synchronized void m11330a(C3531b c3531b) {
        this.j = c3531b;
    }

    public synchronized void m11331a(boolean z) {
        m11319d();
        this.h = z;
    }

    public synchronized void mo3700c(String str) {
        m11319d();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.e = str;
    }
}
