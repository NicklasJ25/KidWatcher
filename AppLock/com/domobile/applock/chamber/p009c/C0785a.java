package com.domobile.applock.chamber.p009c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public abstract class C0785a {
    protected C0784a f1035a;
    protected Context f1036b;
    protected Handler f1037c = new Handler(Looper.getMainLooper());

    class C07831 implements Runnable {
        final /* synthetic */ C0785a f1034a;

        C07831(C0785a c0785a) {
            this.f1034a = c0785a;
        }

        public void run() {
            this.f1034a.f1035a.m1213a();
        }
    }

    public interface C0784a {
        void m1213a();
    }

    public C0785a(Context context) {
        this.f1036b = context;
    }

    protected void m1214a() {
        if (this.f1035a != null) {
            this.f1037c.post(new C07831(this));
        }
    }

    public abstract void mo2423a(String str);
}
