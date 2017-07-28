package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.ar;

public final class C2464e {
    public static C2463d<Status> m7779a(Status status) {
        C2513c.m7933a((Object) status, (Object) "Result must not be null");
        C2463d arVar = new ar(Looper.getMainLooper());
        arVar.m8859a((C2445g) status);
        return arVar;
    }
}
