package com.google.android.gms.p065a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C2489m;
import com.google.android.gms.common.internal.C2513c;

public abstract class C2314c<T> {
    private final String f6666a;
    private T f6667b;

    public static class C2313a extends Exception {
        public C2313a(String str) {
            super(str);
        }

        public C2313a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C2314c(String str) {
        this.f6666a = str;
    }

    protected final T m7329a(Context context) {
        if (this.f6667b == null) {
            C2513c.m7932a((Object) context);
            Context g = C2489m.m7870g(context);
            if (g == null) {
                throw new C2313a("Could not get remote context.");
            }
            try {
                this.f6667b = mo3832a((IBinder) g.getClassLoader().loadClass(this.f6666a).newInstance());
            } catch (Throwable e) {
                throw new C2313a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new C2313a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new C2313a("Could not access creator.", e22);
            }
        }
        return this.f6667b;
    }

    protected abstract T mo3832a(IBinder iBinder);
}
