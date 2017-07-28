package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.C2481b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.common.internal.C2547r.C2518a;
import com.google.android.gms.common.zzc;
import java.util.Set;

public abstract class C2519q<T extends IInterface> extends C2517l<T> implements C2451f, C2518a {
    private final C2539m f7421e;
    private final Set<Scope> f7422f;
    private final Account f7423g;

    class C25451 implements C2527b {
        final /* synthetic */ C2459b f7460a;

        C25451(C2459b c2459b) {
            this.f7460a = c2459b;
        }

        public void mo3346a(int i) {
            this.f7460a.mo3496a(i);
        }

        public void mo3347a(@Nullable Bundle bundle) {
            this.f7460a.mo3497a(bundle);
        }
    }

    class C25462 implements C2528c {
        final /* synthetic */ C2460c f7461a;

        C25462(C2460c c2460c) {
            this.f7461a = c2460c;
        }

        public void mo3348a(@NonNull ConnectionResult connectionResult) {
            this.f7461a.mo3498a(connectionResult);
        }
    }

    protected C2519q(Context context, Looper looper, int i, C2539m c2539m, C2459b c2459b, C2460c c2460c) {
        this(context, looper, C2549s.m8086a(context), C2481b.m7820a(), i, c2539m, (C2459b) C2513c.m7932a((Object) c2459b), (C2460c) C2513c.m7932a((Object) c2460c));
    }

    protected C2519q(Context context, Looper looper, C2549s c2549s, C2481b c2481b, int i, C2539m c2539m, C2459b c2459b, C2460c c2460c) {
        super(context, looper, c2549s, c2481b, i, C2519q.m8000a(c2459b), C2519q.m8001a(c2460c), c2539m.m8053g());
        this.f7421e = c2539m;
        this.f7423g = c2539m.m8046a();
        this.f7422f = m8002b(c2539m.m8050d());
    }

    @Nullable
    private static C2527b m8000a(C2459b c2459b) {
        return c2459b == null ? null : new C25451(c2459b);
    }

    @Nullable
    private static C2528c m8001a(C2460c c2460c) {
        return c2460c == null ? null : new C25462(c2460c);
    }

    private Set<Scope> m8002b(@NonNull Set<Scope> set) {
        Set<Scope> a = m8003a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    @NonNull
    protected Set<Scope> m8003a(@NonNull Set<Scope> set) {
        return set;
    }

    public final Account mo3332p() {
        return this.f7423g;
    }

    public zzc[] mo3333q() {
        return new zzc[0];
    }

    protected final Set<Scope> mo3334x() {
        return this.f7422f;
    }
}
