package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class ml implements Callable {
    protected final String f8901a = getClass().getSimpleName();
    protected final ez f8902b;
    protected final String f8903c;
    protected final String f8904d;
    protected final C2711a f8905e;
    protected Method f8906f;
    protected final int f8907g;
    protected final int f8908h;

    public ml(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        this.f8902b = ezVar;
        this.f8903c = str;
        this.f8904d = str2;
        this.f8905e = c2711a;
        this.f8907g = i;
        this.f8908h = i2;
    }

    protected abstract void mo3587a();

    public Void m10748b() {
        try {
            long nanoTime = System.nanoTime();
            this.f8906f = this.f8902b.m10719a(this.f8903c, this.f8904d);
            if (this.f8906f != null) {
                mo3587a();
                bv j = this.f8902b.m10729j();
                if (!(j == null || this.f8907g == Integer.MIN_VALUE)) {
                    j.m9232a(this.f8908h, this.f8907g, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m10748b();
    }
}
