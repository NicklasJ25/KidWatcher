package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface oq extends IInterface {

    public static abstract class C2384a extends Binder implements oq {

        private static class C3127a implements oq {
            private IBinder f10139a;

            C3127a(IBinder iBinder) {
                this.f10139a = iBinder;
            }

            public IBinder asBinder() {
                return this.f10139a;
            }

            public String getMediationAdapterClassName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.f10139a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.f10139a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzec com_google_android_gms_internal_zzec) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f10139a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2384a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
        }

        public static oq zzn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof oq)) ? new C3127a(iBinder) : (oq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    zzf(parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    parcel2.writeNoException();
                    parcel2.writeString(mediationAdapterClassName);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean isLoading = isLoading();
                    parcel2.writeNoException();
                    parcel2.writeInt(isLoading ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getMediationAdapterClassName();

    boolean isLoading();

    void zzf(zzec com_google_android_gms_internal_zzec);
}
