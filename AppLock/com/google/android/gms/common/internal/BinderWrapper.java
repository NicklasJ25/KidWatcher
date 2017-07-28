package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C25021();
    private IBinder f7383a;

    class C25021 implements Creator<BinderWrapper> {
        C25021() {
        }

        public BinderWrapper m7907a(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public BinderWrapper[] m7908a(int i) {
            return new BinderWrapper[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7907a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7908a(i);
        }
    }

    public BinderWrapper() {
        this.f7383a = null;
    }

    private BinderWrapper(Parcel parcel) {
        this.f7383a = null;
        this.f7383a = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f7383a);
    }
}
