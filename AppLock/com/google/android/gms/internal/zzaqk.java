package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.bp.C2711a;

public final class zzaqk extends zza {
    public static final Creator<zzaqk> CREATOR = new cf();
    public final int f11794a;
    private C2711a f11795b = null;
    private byte[] f11796c;

    zzaqk(int i, byte[] bArr) {
        this.f11794a = i;
        this.f11796c = bArr;
        m15346e();
    }

    private boolean m15344c() {
        return this.f11795b != null;
    }

    private void m15345d() {
        if (!m15344c()) {
            try {
                this.f11795b = C2711a.m9164a(this.f11796c);
                this.f11796c = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        m15346e();
    }

    private void m15346e() {
        if (this.f11795b == null && this.f11796c != null) {
            return;
        }
        if (this.f11795b != null && this.f11796c == null) {
            return;
        }
        if (this.f11795b != null && this.f11796c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.f11795b == null && this.f11796c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public byte[] m15347a() {
        return this.f11796c != null ? this.f11796c : mb.m9124a(this.f11795b);
    }

    public C2711a m15348b() {
        m15345d();
        return this.f11795b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cf.m9298a(this, parcel, i);
    }
}
