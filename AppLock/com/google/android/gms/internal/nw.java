package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface nw extends IInterface {

    public static abstract class C3109a extends Binder implements nw {

        private static class C3108a implements nw {
            private IBinder f10057a;

            C3108a(IBinder iBinder) {
                this.f10057a = iBinder;
            }

            public zzdp mo3850a(zzds com_google_android_gms_internal_zzds) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.cache.ICacheService");
                    if (com_google_android_gms_internal_zzds != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f10057a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzdp com_google_android_gms_internal_zzdp = obtain2.readInt() != 0 ? (zzdp) zzdp.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzdp;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10057a;
            }
        }

        public static nw m12865a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof nw)) ? new C3108a(iBinder) : (nw) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.cache.ICacheService");
                    zzdp a = mo3850a(parcel.readInt() != 0 ? (zzds) zzds.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.cache.ICacheService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzdp mo3850a(zzds com_google_android_gms_internal_zzds);
}
