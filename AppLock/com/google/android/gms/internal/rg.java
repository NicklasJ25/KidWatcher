package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface rg extends IInterface {

    public static abstract class C3211a extends Binder implements rg {

        private static class C3210a implements rg {
            private IBinder f10503a;

            C3210a(IBinder iBinder) {
                this.f10503a = iBinder;
            }

            public IBinder mo3978a(C2309a c2309a, C2309a c2309a2, C2309a c2309a3, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeStrongBinder(c2309a2 != null ? c2309a2.asBinder() : null);
                    if (c2309a3 != null) {
                        iBinder = c2309a3.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10503a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10503a;
            }
        }

        public static rg m13603a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof rg)) ? new C3210a(iBinder) : (rg) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    IBinder a = mo3978a(C2311a.m7326a(parcel.readStrongBinder()), C2311a.m7326a(parcel.readStrongBinder()), C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder mo3978a(C2309a c2309a, C2309a c2309a2, C2309a c2309a3, int i);
}
