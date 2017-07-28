package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.internal.C2513c;

public class C2977i implements C2459b, C2460c {
    public final C2456a<?> f9387a;
    private final boolean f9388b;
    private C2996j f9389c;

    public C2977i(C2456a<?> c2456a, boolean z) {
        this.f9387a = c2456a;
        this.f9388b = z;
    }

    private void m11636a() {
        C2513c.m7933a(this.f9389c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public void mo3496a(int i) {
        m11636a();
        this.f9389c.mo3496a(i);
    }

    public void mo3497a(@Nullable Bundle bundle) {
        m11636a();
        this.f9389c.mo3497a(bundle);
    }

    public void mo3498a(@NonNull ConnectionResult connectionResult) {
        m11636a();
        this.f9389c.mo4157a(connectionResult, this.f9387a, this.f9388b);
    }

    public void m11640a(C2996j c2996j) {
        this.f9389c = c2996j;
    }
}
