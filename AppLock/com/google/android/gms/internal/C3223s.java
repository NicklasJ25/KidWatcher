package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.internal.C2859f.C2676a;
import java.util.Collections;

public class C3223s implements C3165u {
    private final C3349v f10527a;

    public C3223s(C3349v c3349v) {
        this.f10527a = c3349v;
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3900a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void mo3901a() {
        this.f10527a.m14342g();
        this.f10527a.f10989g.f10651d = Collections.emptySet();
    }

    public void mo3902a(int i) {
    }

    public void mo3903a(Bundle bundle) {
    }

    public void mo3904a(ConnectionResult connectionResult, C2456a<?> c2456a, boolean z) {
    }

    public boolean mo3905b() {
        return true;
    }

    public void mo3906c() {
        this.f10527a.m14340e();
    }
}
