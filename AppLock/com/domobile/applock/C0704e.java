package com.domobile.applock;

import android.os.Bundle;

public abstract class C0704e extends C0400d {

    class C08911 implements Runnable {
        final /* synthetic */ C0704e f1327a;

        C08911(C0704e c0704e) {
            this.f1327a = c0704e;
        }

        public void run() {
            this.f1327a.a_(0);
        }
    }

    public boolean mo2400b() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mo2400b()) {
            this.mActionBar.m3001a(new C08911(this), 400);
        }
    }

    public void onResume() {
        super.onResume();
        this.mActionBar.m3006b(false);
    }
}
