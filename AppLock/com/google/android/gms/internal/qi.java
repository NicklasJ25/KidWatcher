package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@wh
public class qi {
    private final Map<String, qh> f10335a = new HashMap();
    @Nullable
    private final qj f10336b;

    public qi(@Nullable qj qjVar) {
        this.f10336b = qjVar;
    }

    @Nullable
    public qj m13298a() {
        return this.f10336b;
    }

    public void m13299a(String str, qh qhVar) {
        this.f10335a.put(str, qhVar);
    }

    public void m13300a(String str, String str2, long j) {
        qf.m13287a(this.f10336b, (qh) this.f10335a.get(str2), j, str);
        this.f10335a.put(str, qf.m13286a(this.f10336b, j));
    }
}
