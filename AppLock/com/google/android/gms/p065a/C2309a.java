package com.google.android.gms.p065a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C2309a extends IInterface {

    public static abstract class C2311a extends Binder implements C2309a {

        private static class C2310a implements C2309a {
            private IBinder f6664a;

            C2310a(IBinder iBinder) {
                this.f6664a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6664a;
            }
        }

        public C2311a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C2309a m7326a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2309a)) ? new C2310a(iBinder) : (C2309a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
