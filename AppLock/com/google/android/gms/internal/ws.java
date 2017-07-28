package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.wt.C3403a;

public interface ws extends IInterface {

    public static abstract class C3405a extends Binder implements ws {

        private static class C3404a implements ws {
            private IBinder f11196a;

            C3404a(IBinder iBinder) {
                this.f11196a = iBinder;
            }

            public zzmn mo4188a(zzmk com_google_android_gms_internal_zzmk) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (com_google_android_gms_internal_zzmk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11196a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzmn com_google_android_gms_internal_zzmn = obtain2.readInt() != 0 ? (zzmn) zzmn.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzmn;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4189a(zzmk com_google_android_gms_internal_zzmk, wt wtVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (com_google_android_gms_internal_zzmk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(wtVar != null ? wtVar.asBinder() : null);
                    this.f11196a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11196a;
            }
        }

        public C3405a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static ws m14553a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ws)) ? new C3404a(iBinder) : (ws) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzmk com_google_android_gms_internal_zzmk = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzmk = (zzmk) zzmk.CREATOR.createFromParcel(parcel);
                    }
                    zzmn a = mo4188a(com_google_android_gms_internal_zzmk);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzmk = (zzmk) zzmk.CREATOR.createFromParcel(parcel);
                    }
                    mo4189a(com_google_android_gms_internal_zzmk, C3403a.m14538a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzmn mo4188a(zzmk com_google_android_gms_internal_zzmk);

    void mo4189a(zzmk com_google_android_gms_internal_zzmk, wt wtVar);
}
