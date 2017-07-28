package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface cg extends IInterface {

    public static abstract class C2745a extends Binder implements cg {

        private static class C2744a implements cg {
            private IBinder f8195a;

            C2744a(IBinder iBinder) {
                this.f8195a = iBinder;
            }

            public zzaqk mo3522a(zzaqi com_google_android_gms_internal_zzaqi) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.gass.internal.IGassService");
                    if (com_google_android_gms_internal_zzaqi != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaqi.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8195a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzaqk com_google_android_gms_internal_zzaqk = obtain2.readInt() != 0 ? (zzaqk) zzaqk.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzaqk;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f8195a;
            }
        }

        public static cg m9303a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cg)) ? new C2744a(iBinder) : (cg) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.gass.internal.IGassService");
                    zzaqk a = mo3522a(parcel.readInt() != 0 ? (zzaqi) zzaqi.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.gass.internal.IGassService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzaqk mo3522a(zzaqi com_google_android_gms_internal_zzaqi);
}
