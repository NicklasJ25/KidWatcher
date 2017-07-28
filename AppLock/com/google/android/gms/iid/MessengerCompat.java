package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.iid.C2626a.C2628a;

public class MessengerCompat implements ReflectedParcelable {
    public static final Creator<MessengerCompat> CREATOR = new C26251();
    Messenger f7604a;
    C2626a f7605b;

    class C26251 implements Creator<MessengerCompat> {
        C26251() {
        }

        public MessengerCompat m8374a(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] m8375a(int i) {
            return new MessengerCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m8374a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m8375a(i);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f7604a = new Messenger(iBinder);
        } else {
            this.f7605b = C2628a.m8380a(iBinder);
        }
    }

    public IBinder m8376a() {
        return this.f7604a != null ? this.f7604a.getBinder() : this.f7605b.asBinder();
    }

    public void m8377a(Message message) {
        if (this.f7604a != null) {
            this.f7604a.send(message);
        } else {
            this.f7605b.mo3375a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = m8376a().equals(((MessengerCompat) obj).m8376a());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return m8376a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f7604a != null) {
            parcel.writeStrongBinder(this.f7604a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f7605b.asBinder());
        }
    }
}
