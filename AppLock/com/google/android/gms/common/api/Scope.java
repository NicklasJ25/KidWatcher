package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Scope extends zza implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new C2477p();
    final int f7261a;
    private final String f7262b;

    Scope(int i, String str) {
        C2513c.m7935a(str, (Object) "scopeUri must not be null or empty");
        this.f7261a = i;
        this.f7262b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m7724a() {
        return this.f7262b;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f7262b.equals(((Scope) obj).f7262b);
    }

    public int hashCode() {
        return this.f7262b.hashCode();
    }

    public String toString() {
        return this.f7262b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2477p.m7801a(this, parcel, i);
    }
}
