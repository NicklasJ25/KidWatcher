package com.google.android.gms.dynamite;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface C2610b extends IInterface {

    public static abstract class C2612a extends Binder implements C2610b {

        private static class C2611a implements C2610b {
            private IBinder f7587a;

            C2611a(IBinder iBinder) {
                this.f7587a = iBinder;
            }

            public C2309a mo3369a(C2309a c2309a, String str, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.f7587a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C2309a a = C2311a.m7326a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f7587a;
            }
        }

        public static C2610b m8363a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2610b)) ? new C2611a(iBinder) : (C2610b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    C2309a a = mo3369a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C2309a mo3369a(C2309a c2309a, String str, byte[] bArr);
}
