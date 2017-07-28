package com.google.firebase.database.connection.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.firebase.database.connection.idl.C3548f.C3549a;

public interface C3545e extends IInterface {

    public static abstract class C3546a extends Binder implements C3545e {

        private static class C3564a implements C3545e {
            private IBinder f12167a;

            C3564a(IBinder iBinder) {
                this.f12167a = iBinder;
            }

            public void mo4287a(boolean z, C3548f c3548f) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c3548f != null ? c3548f.asBinder() : null);
                    this.f12167a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f12167a;
            }
        }

        public C3546a() {
            attachInterface(this, "com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
        }

        public static C3545e m15494a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C3545e)) ? new C3564a(iBinder) : (C3545e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
                    mo4287a(parcel.readInt() != 0, C3549a.m15498a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo4287a(boolean z, C3548f c3548f);
}
