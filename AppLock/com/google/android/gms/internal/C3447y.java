package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2475n;
import com.google.android.gms.internal.C2859f.C2676a;

public class C3447y<O extends C2416a> extends C3140p {
    private final C2475n<O> f11447a;

    public C3447y(C2475n<O> c2475n) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f11447a = c2475n;
    }

    public Looper mo4028a() {
        return this.f11447a.m7799e();
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo4029a(@NonNull T t) {
        return this.f11447a.m7794a(t);
    }

    public void mo4031a(at atVar) {
    }

    public void mo4032b(at atVar) {
    }
}
