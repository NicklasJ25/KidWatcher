package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ud.C3310a;
import com.google.android.gms.internal.uf.C3325a;
import com.google.android.gms.internal.ug.C3327a;
import com.google.android.gms.internal.yk.C3452a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;
import java.util.List;

public interface uc extends IInterface {

    public static abstract class C3321a extends Binder implements uc {

        private static class C3320a implements uc {
            private IBinder f10867a;

            C3320a(IBinder iBinder) {
                this.f10867a = iBinder;
            }

            public C2309a mo4062a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C2309a a = C2311a.m7326a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4063a(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f10867a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4064a(C2309a c2309a, yk ykVar, List<String> list) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (ykVar != null) {
                        iBinder = ykVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeStringList(list);
                    this.f10867a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4065a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, ud udVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (udVar != null) {
                        iBinder = udVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10867a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4066a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, yk ykVar, String str2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ykVar != null) {
                        iBinder = ykVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str2);
                    this.f10867a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4067a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (udVar != null) {
                        iBinder = udVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10867a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4068a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (udVar != null) {
                        iBinder = udVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (com_google_android_gms_internal_zzhc != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzhc.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    this.f10867a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4069a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, ud udVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (udVar != null) {
                        iBinder = udVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10867a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4070a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (udVar != null) {
                        iBinder = udVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10867a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4071a(zzec com_google_android_gms_internal_zzec, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f10867a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4072a(zzec com_google_android_gms_internal_zzec, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f10867a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10867a;
            }

            public void mo4073b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4074c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4075d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4076e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4077f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean mo4078g() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(13, obtain, obtain2, 0);
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

            public uf mo4079h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    uf a = C3325a.m14150a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ug mo4080i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    ug a = C3327a.m14181a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle mo4081j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle mo4082k() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle mo4083l() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean mo4084m() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10867a.transact(22, obtain, obtain2, 0);
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
        }

        public C3321a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static uc m14106a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof uc)) ? new C3320a(iBinder) : (uc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            IBinder iBinder = null;
            boolean g;
            Bundle j;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4069a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C3310a.m13990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    C2309a a = mo4062a();
                    parcel2.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4065a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C3310a.m13990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4073b();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4074c();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4070a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), C3310a.m13990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4067a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), C3310a.m13990a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4075d();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4076e();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4066a(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C3452a.m14890a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4071a(parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4077f();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    g = mo4078g();
                    parcel2.writeNoException();
                    if (g) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    zzhc com_google_android_gms_internal_zzhc;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    C2309a a2 = C2311a.m7326a(parcel.readStrongBinder());
                    zzec com_google_android_gms_internal_zzec = parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null;
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    ud a3 = C3310a.m13990a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzhc = (zzhc) zzhc.CREATOR.createFromParcel(parcel);
                    }
                    mo4068a(a2, com_google_android_gms_internal_zzec, readString, readString2, a3, com_google_android_gms_internal_zzhc, parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    uf h = mo4079h();
                    parcel2.writeNoException();
                    if (h != null) {
                        iBinder = h.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    ug i4 = mo4080i();
                    parcel2.writeNoException();
                    if (i4 != null) {
                        iBinder = i4.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = mo4081j();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = mo4082k();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = mo4083l();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4072a(parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4063a(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    g = mo4084m();
                    parcel2.writeNoException();
                    if (g) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo4064a(C2311a.m7326a(parcel.readStrongBinder()), C3452a.m14890a(parcel.readStrongBinder()), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C2309a mo4062a();

    void mo4063a(C2309a c2309a);

    void mo4064a(C2309a c2309a, yk ykVar, List<String> list);

    void mo4065a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, ud udVar);

    void mo4066a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, yk ykVar, String str2);

    void mo4067a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar);

    void mo4068a(C2309a c2309a, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar, zzhc com_google_android_gms_internal_zzhc, List<String> list);

    void mo4069a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, ud udVar);

    void mo4070a(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, String str2, ud udVar);

    void mo4071a(zzec com_google_android_gms_internal_zzec, String str);

    void mo4072a(zzec com_google_android_gms_internal_zzec, String str, String str2);

    void mo4073b();

    void mo4074c();

    void mo4075d();

    void mo4076e();

    void mo4077f();

    boolean mo4078g();

    uf mo4079h();

    ug mo4080i();

    Bundle mo4081j();

    Bundle mo4082k();

    Bundle mo4083l();

    boolean mo4084m();
}
