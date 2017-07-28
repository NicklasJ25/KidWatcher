package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.vf.C2353a;

public interface vg extends IInterface {

    public static abstract class C3255a extends Binder implements vg {

        private static class C3356a implements vg {
            private IBinder f11009a;

            C3356a(IBinder iBinder) {
                this.f11009a = iBinder;
            }

            public void mo4018a(vf vfVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    obtain.writeStrongBinder(vfVar != null ? vfVar.asBinder() : null);
                    this.f11009a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11009a;
            }
        }

        public C3255a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        public static vg m13783a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof vg)) ? new C3356a(iBinder) : (vg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    mo4018a(C2353a.zzW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo4018a(vf vfVar);
}
