package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface fo extends IInterface {

    public static abstract class C2864a extends Binder implements fo {

        private static class C2863a implements fo {
            private IBinder f8930a;

            C2863a(IBinder iBinder) {
                this.f8930a = iBinder;
            }

            public void mo3589a(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f8930a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3590a(C2309a c2309a, zzbnn com_google_android_gms_internal_zzbnn) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzbnn != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzbnn.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8930a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3591a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeString(str);
                    this.f8930a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3592a(String str, long j, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8930a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f8930a;
            }

            public void mo3593b(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f8930a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3594b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeString(str);
                    this.f8930a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static fo m10793a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fo)) ? new C2863a(iBinder) : (fo) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            switch (i) {
                case 1:
                    zzbnn com_google_android_gms_internal_zzbnn;
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    C2309a a = C2311a.m7326a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzbnn = (zzbnn) zzbnn.CREATOR.createFromParcel(parcel);
                    }
                    mo3590a(a, com_google_android_gms_internal_zzbnn);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    mo3591a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    mo3589a(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    mo3593b(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    mo3594b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    String readString = parcel.readString();
                    long readLong = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo3592a(readString, readLong, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo3589a(C2309a c2309a);

    void mo3590a(C2309a c2309a, zzbnn com_google_android_gms_internal_zzbnn);

    void mo3591a(String str);

    void mo3592a(String str, long j, Bundle bundle);

    void mo3593b(C2309a c2309a);

    void mo3594b(String str);
}
