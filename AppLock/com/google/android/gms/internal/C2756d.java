package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2471m;
import com.google.android.gms.common.api.C2475n;
import com.google.android.gms.p004b.C2428e;
import com.google.android.gms.p004b.C2429f;
import java.util.Set;

public final class C2756d {
    private final ArrayMap<acd<?>, ConnectionResult> f8345a = new ArrayMap();
    private final C2429f<Void> f8346b = new C2429f();
    private int f8347c;
    private boolean f8348d = false;

    public C2756d(Iterable<? extends C2475n<?>> iterable) {
        for (C2475n b : iterable) {
            this.f8345a.put(b.m7795b(), null);
        }
        this.f8347c = this.f8345a.keySet().size();
    }

    public Set<acd<?>> m9735a() {
        return this.f8345a.keySet();
    }

    public void m9736a(acd<?> com_google_android_gms_internal_acd_, ConnectionResult connectionResult) {
        this.f8345a.put(com_google_android_gms_internal_acd_, connectionResult);
        this.f8347c--;
        if (!connectionResult.m7713b()) {
            this.f8348d = true;
        }
        if (this.f8347c != 0) {
            return;
        }
        if (this.f8348d) {
            this.f8346b.m7680a(new C2471m(this.f8345a));
            return;
        }
        this.f8346b.m7681a(null);
    }

    public C2428e<Void> m9737b() {
        return this.f8346b.m7679a();
    }

    public void m9738c() {
        this.f8346b.m7681a(null);
    }
}
