package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface mq extends IInterface {

    public static abstract class C3058a extends Binder implements mq {

        private static class C3059a implements mq {
            private IBinder f9850a;

            C3059a(IBinder iBinder) {
                this.f9850a = iBinder;
            }

            public C2309a mo3820a(C2309a c2309a, C2309a c2309a2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (c2309a2 != null) {
                        iBinder = c2309a2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f9850a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C2309a a = C2311a.m7326a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String mo3821a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    this.f9850a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String mo3822a(C2309a c2309a, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeString(str);
                    this.f9850a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String mo3823a(C2309a c2309a, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    this.f9850a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3824a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeString(str);
                    this.f9850a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3825a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f9850a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean mo3826a(C2309a c2309a) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f9850a.transact(3, obtain, obtain2, 0);
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

            public boolean mo3827a(String str, boolean z) {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f9850a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9850a;
            }

            public C2309a mo3828b(C2309a c2309a, C2309a c2309a2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (c2309a2 != null) {
                        iBinder = c2309a2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f9850a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    C2309a a = C2311a.m7326a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean mo3829b(C2309a c2309a) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f9850a.transact(4, obtain, obtain2, 0);
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

            public String mo3830c(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f9850a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3831d(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f9850a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C3058a() {
            attachInterface(this, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        }

        public static mq m12580a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof mq)) ? new C3059a(iBinder) : (mq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            int i3 = 0;
            String a;
            boolean a2;
            C2309a a3;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a = mo3821a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    mo3825a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a2 = mo3826a(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a2 = mo3829b(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    mo3824a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a3 = mo3820a(C2311a.m7326a(parcel.readStrongBinder()), C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3 != null ? a3.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a = mo3830c(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a = mo3822a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    mo3831d(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a3 = mo3828b(C2311a.m7326a(parcel.readStrongBinder()), C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a3 != null) {
                        iBinder = a3.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a2 = mo3827a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    a = mo3823a(C2311a.m7326a(parcel.readStrongBinder()), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C2309a mo3820a(C2309a c2309a, C2309a c2309a2);

    String mo3821a();

    String mo3822a(C2309a c2309a, String str);

    String mo3823a(C2309a c2309a, byte[] bArr);

    void mo3824a(String str);

    void mo3825a(String str, String str2);

    boolean mo3826a(C2309a c2309a);

    boolean mo3827a(String str, boolean z);

    C2309a mo3828b(C2309a c2309a, C2309a c2309a2);

    boolean mo3829b(C2309a c2309a);

    String mo3830c(C2309a c2309a);

    void mo3831d(C2309a c2309a);
}
