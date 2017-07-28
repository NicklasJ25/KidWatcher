package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public class zzmr extends zza {
    public static final Creator<zzmr> CREATOR = new wr();
    public final boolean f12063a;
    public final boolean f12064b;
    public final boolean f12065c;

    public zzmr(boolean z, boolean z2, boolean z3) {
        this.f12063a = z;
        this.f12064b = z2;
        this.f12065c = z3;
    }

    public Bundle m15389a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.f12063a);
        bundle.putBoolean("default_iap_supported", this.f12064b);
        bundle.putBoolean("app_streaming_supported", this.f12065c);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        wr.m14546a(this, parcel, i);
    }
}
