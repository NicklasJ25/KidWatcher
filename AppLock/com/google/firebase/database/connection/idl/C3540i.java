package com.google.firebase.database.connection.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;
import java.util.List;

public interface C3540i extends IInterface {

    public static abstract class C3541a extends Binder implements C3540i {

        private static class C3568a implements C3540i {
            private IBinder f12171a;

            C3568a(IBinder iBinder) {
                this.f12171a = iBinder;
            }

            public void mo4281a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    this.f12171a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4282a(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f12171a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4283a(List<String> list, C2309a c2309a, boolean z, long j) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f12171a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4284a(List<String> list, List<zzn> list2, C2309a c2309a, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    obtain.writeStringList(list);
                    obtain.writeTypedList(list2);
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeLong(j);
                    this.f12171a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4285a(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f12171a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f12171a;
            }

            public void mo4286b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    this.f12171a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C3541a() {
            attachInterface(this, "com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
        }

        public static C3540i m15478a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C3540i)) ? new C3568a(iBinder) : (C3540i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    List createStringArrayList = parcel.createStringArrayList();
                    C2309a a = C2311a.m7326a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo4283a(createStringArrayList, a, z, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    mo4284a(parcel.createStringArrayList(), parcel.createTypedArrayList(zzn.CREATOR), C2311a.m7326a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    mo4281a();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    mo4286b();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo4285a(z);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    mo4282a(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo4281a();

    void mo4282a(C2309a c2309a);

    void mo4283a(List<String> list, C2309a c2309a, boolean z, long j);

    void mo4284a(List<String> list, List<zzn> list2, C2309a c2309a, long j);

    void mo4285a(boolean z);

    void mo4286b();
}
