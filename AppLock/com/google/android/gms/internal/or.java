package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.op.C3112a;
import com.google.android.gms.internal.oq.C2384a;
import com.google.android.gms.internal.ox.C3124a;
import com.google.android.gms.internal.rn.C3216a;
import com.google.android.gms.internal.ro.C3218a;
import com.google.android.gms.internal.rp.C3220a;
import com.google.android.gms.internal.rq.C3222a;

public interface or extends IInterface {

    public static abstract class C2385a extends Binder implements or {

        private static class C3128a implements or {
            private IBinder f10140a;

            C3128a(IBinder iBinder) {
                this.f10140a = iBinder;
            }

            public IBinder asBinder() {
                return this.f10140a;
            }

            public void zza(rn rnVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(rnVar != null ? rnVar.asBinder() : null);
                    this.f10140a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ro roVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(roVar != null ? roVar.asBinder() : null);
                    this.f10140a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzhc com_google_android_gms_internal_zzhc) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (com_google_android_gms_internal_zzhc != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzhc.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f10140a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, rq rqVar, rp rpVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(rqVar != null ? rqVar.asBinder() : null);
                    if (rpVar != null) {
                        iBinder = rpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10140a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(op opVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(opVar != null ? opVar.asBinder() : null);
                    this.f10140a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(ox oxVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(oxVar != null ? oxVar.asBinder() : null);
                    this.f10140a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public oq zzck() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.f10140a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    oq zzn = C2384a.zzn(obtain2.readStrongBinder());
                    return zzn;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2385a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static or zzo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof or)) ? new C3128a(iBinder) : (or) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzhc com_google_android_gms_internal_zzhc = null;
            switch (i) {
                case 1:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    oq zzck = zzck();
                    parcel2.writeNoException();
                    if (zzck != null) {
                        asBinder = zzck.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(C3112a.m12880a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(C3216a.m13645a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(C3218a.m13648a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(parcel.readString(), C3222a.m13654a(parcel.readStrongBinder()), C3220a.m13651a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzhc = (zzhc) zzhc.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzhc);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(C3124a.m12984a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(rn rnVar);

    void zza(ro roVar);

    void zza(zzhc com_google_android_gms_internal_zzhc);

    void zza(String str, rq rqVar, rp rpVar);

    void zzb(op opVar);

    void zzb(ox oxVar);

    oq zzck();
}
