package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface mr extends IInterface {

    public static abstract class C3061a extends Binder implements mr {

        private static class C3060a implements mr {
            private IBinder f9851a;

            C3060a(IBinder iBinder) {
                this.f9851a = iBinder;
            }

            public IBinder mo3833a(String str, C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f9851a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9851a;
            }

            public IBinder mo3834b(String str, C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f9851a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static mr m12614a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof mr)) ? new C3060a(iBinder) : (mr) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
                    a = mo3833a(parcel.readString(), C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
                    a = mo3834b(parcel.readString(), C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder mo3833a(String str, C2309a c2309a);

    IBinder mo3834b(String str, C2309a c2309a);
}
