package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface wt extends IInterface {

    public static abstract class C3403a extends Binder implements wt {

        private static class C3406a implements wt {
            private IBinder f11197a;

            C3406a(IBinder iBinder) {
                this.f11197a = iBinder;
            }

            public void mo4187a(zzmn com_google_android_gms_internal_zzmn) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (com_google_android_gms_internal_zzmn != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmn.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11197a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11197a;
            }
        }

        public C3403a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
        }

        public static wt m14538a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof wt)) ? new C3406a(iBinder) : (wt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    mo4187a(parcel.readInt() != 0 ? (zzmn) zzmn.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo4187a(zzmn com_google_android_gms_internal_zzmn);
}
