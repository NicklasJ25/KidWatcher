package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2461c.C2458a;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.C3424x;
import com.google.android.gms.internal.C3424x.C3421a;
import com.google.android.gms.internal.C3447y;
import com.google.android.gms.internal.acc;
import com.google.android.gms.internal.acd;
import com.google.android.gms.internal.ap;
import com.google.android.gms.internal.aq;

public abstract class C2475n<O extends C2416a> {
    protected final C3424x f7300a;
    private final Context f7301b;
    private final C2456a<O> f7302c;
    private final O f7303d;
    private final acd<O> f7304e;
    private final Looper f7305f;
    private final int f7306g;
    private final C2461c f7307h;
    private final aq f7308i;
    private final Account f7309j;

    public static class C2474a {
        public static final C2474a f7296a = new C2473a().m7789a();
        public final aq f7297b;
        public final Account f7298c;
        public final Looper f7299d;

        public static class C2473a {
            private aq f7294a;
            private Looper f7295b;

            public C2473a m7788a(aq aqVar) {
                C2513c.m7933a((Object) aqVar, (Object) "StatusExceptionMapper must not be null.");
                this.f7294a = aqVar;
                return this;
            }

            public C2474a m7789a() {
                if (this.f7294a == null) {
                    this.f7294a = new acc();
                }
                if (this.f7295b == null) {
                    if (Looper.myLooper() != null) {
                        this.f7295b = Looper.myLooper();
                    } else {
                        this.f7295b = Looper.getMainLooper();
                    }
                }
                return new C2474a(this.f7294a, null, this.f7295b);
            }
        }

        private C2474a(aq aqVar, Account account, Looper looper) {
            this.f7297b = aqVar;
            this.f7298c = account;
            this.f7299d = looper;
        }
    }

    protected C2475n(@NonNull Context context, C2456a<O> c2456a, Looper looper) {
        C2513c.m7933a((Object) context, (Object) "Null context is not permitted.");
        C2513c.m7933a((Object) c2456a, (Object) "Api must not be null.");
        C2513c.m7933a((Object) looper, (Object) "Looper must not be null.");
        this.f7301b = context.getApplicationContext();
        this.f7302c = c2456a;
        this.f7303d = null;
        this.f7305f = looper;
        this.f7304e = acd.m8949a(c2456a);
        this.f7307h = new C3447y(this);
        this.f7300a = C3424x.m14637a(this.f7301b);
        this.f7306g = this.f7300a.m14664b();
        this.f7308i = new acc();
        this.f7309j = null;
    }

    public C2475n(@NonNull Context context, C2456a<O> c2456a, O o, C2474a c2474a) {
        C2513c.m7933a((Object) context, (Object) "Null context is not permitted.");
        C2513c.m7933a((Object) c2456a, (Object) "Api must not be null.");
        C2513c.m7933a((Object) c2474a, (Object) "Settings must not be null; use Settings.createDefault() instead.");
        this.f7301b = context.getApplicationContext();
        this.f7302c = c2456a;
        this.f7303d = o;
        this.f7305f = c2474a.f7299d;
        this.f7304e = acd.m8950a(this.f7302c, this.f7303d);
        this.f7307h = new C3447y(this);
        this.f7300a = C3424x.m14637a(this.f7301b);
        this.f7306g = this.f7300a.m14664b();
        this.f7308i = c2474a.f7297b;
        this.f7309j = c2474a.f7298c;
        this.f7300a.m14660a(this);
    }

    @Deprecated
    public C2475n(@NonNull Context context, C2456a<O> c2456a, O o, aq aqVar) {
        this(context, (C2456a) c2456a, (C2416a) o, new C2473a().m7788a(aqVar).m7789a());
    }

    private <A extends C2449c, T extends C2676a<? extends C2445g, A>> T m7790a(int i, @NonNull T t) {
        t.m8869i();
        this.f7300a.m14661a(this, i, t);
        return t;
    }

    @WorkerThread
    public C2451f mo3815a(Looper looper, C3421a<O> c3421a) {
        return this.f7302c.m7750b().mo3464a(this.f7301b, looper, new C2458a(this.f7301b).m7757a(this.f7309j).m7759a(), this.f7303d, c3421a, c3421a);
    }

    public C2456a<O> m7792a() {
        return this.f7302c;
    }

    public ap mo3816a(Context context, Handler handler) {
        return new ap(context, handler);
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T m7794a(@NonNull T t) {
        return m7790a(1, (C2676a) t);
    }

    public acd<O> m7795b() {
        return this.f7304e;
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T m7796b(@NonNull T t) {
        return m7790a(2, (C2676a) t);
    }

    public int m7797c() {
        return this.f7306g;
    }

    public C2461c m7798d() {
        return this.f7307h;
    }

    public Looper m7799e() {
        return this.f7305f;
    }
}
