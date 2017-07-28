package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.abw.C2672a;

public interface abx extends IInterface {

    public static abstract class C2680a extends Binder implements abx {

        private static class C2679a implements abx {
            private IBinder f7872a;

            C2679a(IBinder iBinder) {
                this.f7872a = iBinder;
            }

            public void mo3478a(abw com_google_android_gms_internal_abw) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_abw != null) {
                        iBinder = com_google_android_gms_internal_abw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f7872a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void mo3479a(abw com_google_android_gms_internal_abw, zzzm com_google_android_gms_internal_zzzm) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_abw != null) {
                        iBinder = com_google_android_gms_internal_abw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (com_google_android_gms_internal_zzzm != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzzm.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7872a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f7872a;
            }

            public void mo3480b(abw com_google_android_gms_internal_abw) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_abw != null) {
                        iBinder = com_google_android_gms_internal_abw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f7872a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void mo3481c(abw com_google_android_gms_internal_abw) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_abw != null) {
                        iBinder = com_google_android_gms_internal_abw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f7872a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void mo3482d(abw com_google_android_gms_internal_abw) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_abw != null) {
                        iBinder = com_google_android_gms_internal_abw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f7872a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static abx m8912a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof abx)) ? new C2679a(iBinder) : (abx) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    mo3479a(C2672a.m8845a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzzm) zzzm.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    mo3478a(C2672a.m8845a(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    mo3480b(C2672a.m8845a(parcel.readStrongBinder()));
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    mo3481c(C2672a.m8845a(parcel.readStrongBinder()));
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    mo3482d(C2672a.m8845a(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo3478a(abw com_google_android_gms_internal_abw);

    void mo3479a(abw com_google_android_gms_internal_abw, zzzm com_google_android_gms_internal_zzzm);

    void mo3480b(abw com_google_android_gms_internal_abw);

    void mo3481c(abw com_google_android_gms_internal_abw);

    void mo3482d(abw com_google_android_gms_internal_abw);
}
