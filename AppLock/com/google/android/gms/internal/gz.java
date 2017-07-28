package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;
import java.util.concurrent.Callable;

public class gz implements Callable {
    private final ez f9163a;
    private final C2711a f9164b;

    public gz(ez ezVar, C2711a c2711a) {
        this.f9163a = ezVar;
        this.f9164b = c2711a;
    }

    public Void m11292a() {
        if (this.f9163a.m10732m() != null) {
            this.f9163a.m10732m().get();
        }
        mb l = this.f9163a.m10731l();
        if (l != null) {
            try {
                synchronized (this.f9164b) {
                    mb.m9122a(this.f9164b, mb.m9124a(l));
                }
            } catch (ma e) {
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m11292a();
    }
}
