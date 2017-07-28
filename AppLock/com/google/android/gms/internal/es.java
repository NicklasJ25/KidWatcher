package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.C2503v;
import com.google.android.gms.common.internal.C2503v.C2504a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.ab.C2509a;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.er.C2691a;

public interface es extends IInterface {

    public static abstract class C2855a extends Binder implements es {

        private static class C2854a implements es {
            private IBinder f8853a;

            C2854a(IBinder iBinder) {
                this.f8853a = iBinder;
            }

            public void mo3571a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.f8853a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3572a(int i, Account account, er erVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(erVar != null ? erVar.asBinder() : null);
                    this.f8853a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3573a(C2503v c2503v, int i, boolean z) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(c2503v != null ? c2503v.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f8853a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3574a(zzad com_google_android_gms_common_internal_zzad, ab abVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_common_internal_zzad != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzad.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.f8853a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3575a(zzd com_google_android_gms_common_internal_zzd, er erVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_common_internal_zzd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(erVar != null ? erVar.asBinder() : null);
                    this.f8853a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3576a(er erVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(erVar != null ? erVar.asBinder() : null);
                    this.f8853a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3577a(zzban com_google_android_gms_internal_zzban) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzban != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzban.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8853a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3578a(zzbar com_google_android_gms_internal_zzbar, er erVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzbar != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzbar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(erVar != null ? erVar.asBinder() : null);
                    this.f8853a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3579a(zzbau com_google_android_gms_internal_zzbau, er erVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzbau != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzbau.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(erVar != null ? erVar.asBinder() : null);
                    this.f8853a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3580a(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f8853a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f8853a;
            }

            public void mo3581b(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f8853a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static es m10675a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof es)) ? new C2854a(iBinder) : (es) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            zzbau com_google_android_gms_internal_zzbau = null;
            switch (i) {
                case 2:
                    zzd com_google_android_gms_common_internal_zzd;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzd = (zzd) zzd.CREATOR.createFromParcel(parcel);
                    }
                    mo3575a(com_google_android_gms_common_internal_zzd, C2691a.m8990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    zzban com_google_android_gms_internal_zzban;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzban = (zzban) zzban.CREATOR.createFromParcel(parcel);
                    }
                    mo3577a(com_google_android_gms_internal_zzban);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    mo3580a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    zzad com_google_android_gms_common_internal_zzad;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzad = (zzad) zzad.CREATOR.createFromParcel(parcel);
                    }
                    mo3574a(com_google_android_gms_common_internal_zzad, C2509a.m7924a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    mo3571a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    Account account;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(parcel);
                    }
                    mo3572a(readInt, account, C2691a.m8990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    C2503v a = C2504a.m7910a(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo3573a(a, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    zzbar com_google_android_gms_internal_zzbar;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzbar = (zzbar) zzbar.CREATOR.createFromParcel(parcel);
                    }
                    mo3578a(com_google_android_gms_internal_zzbar, C2691a.m8990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    mo3576a(C2691a.m8990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzbau = (zzbau) zzbau.CREATOR.createFromParcel(parcel);
                    }
                    mo3579a(com_google_android_gms_internal_zzbau, C2691a.m8990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo3581b(z);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo3571a(int i);

    void mo3572a(int i, Account account, er erVar);

    void mo3573a(C2503v c2503v, int i, boolean z);

    void mo3574a(zzad com_google_android_gms_common_internal_zzad, ab abVar);

    void mo3575a(zzd com_google_android_gms_common_internal_zzd, er erVar);

    void mo3576a(er erVar);

    void mo3577a(zzban com_google_android_gms_internal_zzban);

    void mo3578a(zzbar com_google_android_gms_internal_zzbar, er erVar);

    void mo3579a(zzbau com_google_android_gms_internal_zzbau, er erVar);

    void mo3580a(boolean z);

    void mo3581b(boolean z);
}
