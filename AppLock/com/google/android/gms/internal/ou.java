package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ub.C3318a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface ou extends IInterface {

    public static abstract class C3133a extends Binder implements ou {

        private static class C3132a implements ou {
            private IBinder f10143a;

            C3132a(IBinder iBinder) {
                this.f10143a = iBinder;
            }

            public IBinder mo3866a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ubVar != null) {
                        iBinder = ubVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10143a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder mo3867a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i, int i2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ubVar != null) {
                        iBinder = ubVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f10143a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10143a;
            }
        }

        public static ou m13001a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ou)) ? new C3132a(iBinder) : (ou) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzeg com_google_android_gms_internal_zzeg = null;
            C2309a a;
            IBinder a2;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    a = C2311a.m7326a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzeg = (zzeg) zzeg.CREATOR.createFromParcel(parcel);
                    }
                    a2 = mo3866a(a, com_google_android_gms_internal_zzeg, parcel.readString(), C3318a.m14052a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    a = C2311a.m7326a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzeg = (zzeg) zzeg.CREATOR.createFromParcel(parcel);
                    }
                    a2 = mo3867a(a, com_google_android_gms_internal_zzeg, parcel.readString(), C3318a.m14052a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder mo3866a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i);

    IBinder mo3867a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i, int i2);
}
