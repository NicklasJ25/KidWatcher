package com.facebook.ads.internal.p018m;

import android.database.ContentObserver;
import android.os.Handler;

class C1695c extends ContentObserver {
    private final C1707i f4243a;

    public C1695c(Handler handler, C1707i c1707i) {
        super(handler);
        this.f4243a = c1707i;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        this.f4243a.m4903e();
    }
}
