package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Status extends zza implements C2445g, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new C2478q();
    public static final Status zzazA = new Status(15);
    public static final Status zzazB = new Status(16);
    public static final Status zzazC = new Status(17);
    public static final Status zzazD = new Status(18);
    public static final Status zzazx = new Status(0);
    public static final Status zzazy = new Status(14);
    public static final Status zzazz = new Status(8);
    final int f7263a;
    private final int f7264b;
    private final String f7265c;
    private final PendingIntent f7266d;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f7263a = i;
        this.f7264b = i2;
        this.f7265c = str;
        this.f7266d = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public Status mo3313a() {
        return this;
    }

    PendingIntent m7727b() {
        return this.f7266d;
    }

    @Nullable
    public String m7728c() {
        return this.f7265c;
    }

    public boolean m7729d() {
        return this.f7264b <= 0;
    }

    public int m7730e() {
        return this.f7264b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f7263a == status.f7263a && this.f7264b == status.f7264b && C2512b.m7931a(this.f7265c, status.f7265c) && C2512b.m7931a(this.f7266d, status.f7266d);
    }

    public String m7731f() {
        return this.f7265c != null ? this.f7265c : C2457b.m7753a(this.f7264b);
    }

    public int hashCode() {
        return C2512b.m7929a(Integer.valueOf(this.f7263a), Integer.valueOf(this.f7264b), this.f7265c, this.f7266d);
    }

    public String toString() {
        return C2512b.m7930a((Object) this).m7928a("statusCode", m7731f()).m7928a("resolution", this.f7266d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2478q.m7804a(this, parcel, i);
    }
}
