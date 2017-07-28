package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.InputStream;

@wh
public class zzdp extends zza {
    public static final Creator<zzdp> CREATOR = new ns();
    @Nullable
    private ParcelFileDescriptor f11869a;

    public zzdp() {
        this(null);
    }

    public zzdp(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.f11869a = parcelFileDescriptor;
    }

    public synchronized boolean m15375a() {
        return this.f11869a != null;
    }

    @Nullable
    public synchronized InputStream m15376b() {
        InputStream inputStream = null;
        synchronized (this) {
            if (this.f11869a != null) {
                inputStream = new AutoCloseInputStream(this.f11869a);
                this.f11869a = null;
            }
        }
        return inputStream;
    }

    synchronized ParcelFileDescriptor m15377c() {
        return this.f11869a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ns.m12851a(this, parcel, i);
    }
}
