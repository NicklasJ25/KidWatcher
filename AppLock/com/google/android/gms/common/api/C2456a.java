package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.internal.C2503v;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2517l.C2530f;
import com.google.android.gms.common.internal.C2539m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class C2456a<O extends C2416a> {
    private final C2448b<?, O> f7267a;
    private final C2454i<?, O> f7268b = null;
    private final C2452g<?> f7269c;
    private final C2455j<?> f7270d;
    private final String f7271e;

    public interface C2416a {

        public interface C2417a extends C2416a {
        }

        public interface C2418c extends C2416a {
        }

        public interface C2419d extends C2417a, C2418c {
        }

        public static final class C2446b implements C2418c {
            private C2446b() {
            }
        }
    }

    public static abstract class C2447e<T extends C2449c, O> {
        public int m7732a() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> m7733a(O o) {
            return Collections.emptyList();
        }
    }

    public static abstract class C2448b<T extends C2451f, O> extends C2447e<T, O> {
        public abstract T mo3464a(Context context, Looper looper, C2539m c2539m, O o, C2459b c2459b, C2460c c2460c);
    }

    public interface C2449c {
    }

    public static class C2450d<C extends C2449c> {
    }

    public interface C2451f extends C2449c {
        void m7735a();

        void m7736a(C2530f c2530f);

        void m7737a(C2503v c2503v, Set<Scope> set);

        void m7738a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean m7739b();

        boolean m7740c();

        boolean mo3584d();

        boolean m7742e();

        boolean m7743f();

        Intent m7744g();

        @Nullable
        IBinder m7745h();
    }

    public static final class C2452g<C extends C2451f> extends C2450d<C> {
    }

    public interface C2453h<T extends IInterface> extends C2449c {
        T m7746a(IBinder iBinder);

        String m7747a();

        String m7748b();
    }

    public static abstract class C2454i<T extends C2453h, O> extends C2447e<T, O> {
    }

    public static final class C2455j<C extends C2453h> extends C2450d<C> {
    }

    public <C extends C2451f> C2456a(String str, C2448b<C, O> c2448b, C2452g<C> c2452g) {
        C2513c.m7933a((Object) c2448b, (Object) "Cannot construct an Api with a null ClientBuilder");
        C2513c.m7933a((Object) c2452g, (Object) "Cannot construct an Api with a null ClientKey");
        this.f7271e = str;
        this.f7267a = c2448b;
        this.f7269c = c2452g;
        this.f7270d = null;
    }

    public C2447e<?, O> m7749a() {
        return this.f7267a;
    }

    public C2448b<?, O> m7750b() {
        C2513c.m7938a(this.f7267a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f7267a;
    }

    public C2450d<?> m7751c() {
        if (this.f7269c != null) {
            return this.f7269c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public String m7752d() {
        return this.f7271e;
    }
}
