package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ox extends IInterface {

    public static abstract class C3124a extends Binder implements ox {

        private static class C3136a implements ox {
            private IBinder f10146a;

            C3136a(IBinder iBinder) {
                this.f10146a = iBinder;
            }

            public IBinder asBinder() {
                return this.f10146a;
            }

            public long mo3864b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    this.f10146a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C3124a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        }

        public static ox m12984a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ox)) ? new C3136a(iBinder) : (ox) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    long b = mo3864b();
                    parcel2.writeNoException();
                    parcel2.writeLong(b);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    long mo3864b();
}
