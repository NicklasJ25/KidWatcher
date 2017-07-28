package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzacs.C3510a;

public class zzacn extends zza {
    public static final Creator<zzacn> CREATOR = new ay();
    final int f11754a;
    private final zzacp f11755b;

    zzacn(int i, zzacp com_google_android_gms_internal_zzacp) {
        this.f11754a = i;
        this.f11755b = com_google_android_gms_internal_zzacp;
    }

    private zzacn(zzacp com_google_android_gms_internal_zzacp) {
        this.f11754a = 1;
        this.f11755b = com_google_android_gms_internal_zzacp;
    }

    public static zzacn m15286a(C3510a<?, ?> c3510a) {
        if (c3510a instanceof zzacp) {
            return new zzacn((zzacp) c3510a);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    zzacp m15287a() {
        return this.f11755b;
    }

    public C3510a<?, ?> m15288b() {
        if (this.f11755b != null) {
            return this.f11755b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        ay.m9077a(this, parcel, i);
    }
}
