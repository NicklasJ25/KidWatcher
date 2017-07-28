package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class StatsEvent extends zza implements ReflectedParcelable {
    public abstract long mo3356a();

    public abstract int mo3357b();

    public abstract long mo3358c();

    public abstract String mo3359d();

    public String toString() {
        long a = mo3356a();
        String valueOf = String.valueOf("\t");
        int b = mo3357b();
        String valueOf2 = String.valueOf("\t");
        long c = mo3358c();
        String valueOf3 = String.valueOf(mo3359d());
        return new StringBuilder(((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(a).append(valueOf).append(b).append(valueOf2).append(c).append(valueOf3).toString();
    }
}
