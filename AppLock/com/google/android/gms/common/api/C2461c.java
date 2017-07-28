package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.C2481b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.api.C2456a.C2416a.C2418c;
import com.google.android.gms.common.api.C2456a.C2447e;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.internal.C2539m.C2538a;
import com.google.android.gms.internal.C2742c;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.C2977i;
import com.google.android.gms.internal.C3276t;
import com.google.android.gms.internal.ad;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.el;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.en;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class C2461c {
    private static final Set<C2461c> f7291a = Collections.newSetFromMap(new WeakHashMap());

    public static final class C2458a {
        private Account f7272a;
        private final Set<Scope> f7273b = new HashSet();
        private final Set<Scope> f7274c = new HashSet();
        private int f7275d;
        private View f7276e;
        private String f7277f;
        private String f7278g;
        private final Map<C2456a<?>, C2538a> f7279h = new ArrayMap();
        private final Context f7280i;
        private final Map<C2456a<?>, C2416a> f7281j = new ArrayMap();
        private ad f7282k;
        private int f7283l = -1;
        private C2460c f7284m;
        private Looper f7285n;
        private C2481b f7286o = C2481b.m7820a();
        private C2448b<? extends em, en> f7287p = el.f8837c;
        private final ArrayList<C2459b> f7288q = new ArrayList();
        private final ArrayList<C2460c> f7289r = new ArrayList();
        private boolean f7290s = false;

        public C2458a(@NonNull Context context) {
            this.f7280i = context;
            this.f7285n = context.getMainLooper();
            this.f7277f = context.getPackageName();
            this.f7278g = context.getClass().getName();
        }

        private static <C extends C2451f, O> C m7754a(C2448b<C, O> c2448b, Object obj, Context context, Looper looper, C2539m c2539m, C2459b c2459b, C2460c c2460c) {
            return c2448b.mo3464a(context, looper, c2539m, obj, c2459b, c2460c);
        }

        private void m7755a(C2461c c2461c) {
            C2742c.m9268a(this.f7282k).m9271a(this.f7283l, c2461c, this.f7284m);
        }

        private C2461c m7756c() {
            C2539m a = m7759a();
            C2456a c2456a = null;
            Map e = a.m8051e();
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Object obj = null;
            for (C2456a c2456a2 : this.f7281j.keySet()) {
                C2456a c2456a22;
                Object obj2 = this.f7281j.get(c2456a22);
                boolean z = e.get(c2456a22) != null;
                arrayMap.put(c2456a22, Boolean.valueOf(z));
                C2459b c2977i = new C2977i(c2456a22, z);
                arrayList.add(c2977i);
                C2447e b = c2456a22.m7750b();
                C2451f a2 = C2458a.m7754a(b, obj2, this.f7280i, this.f7285n, a, c2977i, c2977i);
                arrayMap2.put(c2456a22.m7751c(), a2);
                Object obj3 = b.m7732a() == 1 ? obj2 != null ? 1 : null : obj;
                if (!a2.m7743f()) {
                    c2456a22 = c2456a;
                } else if (c2456a != null) {
                    String valueOf = String.valueOf(c2456a22.m7752d());
                    String valueOf2 = String.valueOf(c2456a.m7752d());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                obj = obj3;
                c2456a = c2456a22;
            }
            if (c2456a != null) {
                if (obj != null) {
                    valueOf = String.valueOf(c2456a.m7752d());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 82).append("With using ").append(valueOf).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                }
                C2513c.m7939a(this.f7272a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c2456a.m7752d());
                C2513c.m7939a(this.f7273b.equals(this.f7274c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c2456a.m7752d());
            }
            return new C3276t(this.f7280i, new ReentrantLock(), this.f7285n, a, this.f7286o, this.f7287p, arrayMap, this.f7288q, this.f7289r, arrayMap2, this.f7283l, C3276t.m13842a(arrayMap2.values(), true), arrayList, false);
        }

        public C2458a m7757a(Account account) {
            this.f7272a = account;
            return this;
        }

        public C2458a m7758a(@NonNull C2456a<? extends C2418c> c2456a) {
            C2513c.m7933a((Object) c2456a, (Object) "Api must not be null");
            this.f7281j.put(c2456a, null);
            Collection a = c2456a.m7749a().m7733a(null);
            this.f7274c.addAll(a);
            this.f7273b.addAll(a);
            return this;
        }

        public C2539m m7759a() {
            en enVar = en.f8843a;
            if (this.f7281j.containsKey(el.f8841g)) {
                enVar = (en) this.f7281j.get(el.f8841g);
            }
            return new C2539m(this.f7272a, this.f7273b, this.f7279h, this.f7275d, this.f7276e, this.f7277f, this.f7278g, enVar);
        }

        public C2461c m7760b() {
            C2513c.m7942b(!this.f7281j.isEmpty(), "must call addApi() to add at least one API");
            C2461c c = m7756c();
            synchronized (C2461c.f7291a) {
                C2461c.f7291a.add(c);
            }
            if (this.f7283l >= 0) {
                m7755a(c);
            }
            return c;
        }
    }

    public interface C2459b {
        void mo3496a(int i);

        void mo3497a(@Nullable Bundle bundle);
    }

    public interface C2460c {
        void mo3498a(@NonNull ConnectionResult connectionResult);
    }

    public Looper mo4028a() {
        throw new UnsupportedOperationException();
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo4029a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void mo4030a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo3869a(@NonNull C2460c c2460c);

    public void mo4031a(at atVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo3870a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void mo3871b();

    public abstract void mo3872b(@NonNull C2460c c2460c);

    public void mo4032b(at atVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo3873c();
}
