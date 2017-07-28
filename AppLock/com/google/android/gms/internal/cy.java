package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface cy extends IInterface {

    public static abstract class C2755a extends Binder implements cy {

        private static class C2754a implements cy {
            private IBinder f8335a;

            C2754a(IBinder iBinder) {
                this.f8335a = iBinder;
            }

            public List<zzauq> mo3552a(zzatd com_google_android_gms_internal_zzatd, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f8335a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    List<zzauq> createTypedArrayList = obtain2.createTypedArrayList(zzauq.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<zzatg> mo3553a(String str, String str2, zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    List<zzatg> createTypedArrayList = obtain2.createTypedArrayList(zzatg.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<zzatg> mo3554a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f8335a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    List<zzatg> createTypedArrayList = obtain2.createTypedArrayList(zzatg.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<zzauq> mo3555a(String str, String str2, String str3, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f8335a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    List<zzauq> createTypedArrayList = obtain2.createTypedArrayList(zzauq.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<zzauq> mo3556a(String str, String str2, boolean z, zzatd com_google_android_gms_internal_zzatd) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    List<zzauq> createTypedArrayList = obtain2.createTypedArrayList(zzauq.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3557a(long j, String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f8335a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3558a(zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3559a(zzatg com_google_android_gms_internal_zzatg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3560a(zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3561a(zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3562a(zzatq com_google_android_gms_internal_zzatq, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f8335a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo3563a(zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzauq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzauq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] mo3564a(zzatq com_google_android_gms_internal_zzatq, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f8335a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f8335a;
            }

            public void mo3565b(zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String mo3566c(zzatd com_google_android_gms_internal_zzatd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (com_google_android_gms_internal_zzatd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzatd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8335a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2755a() {
            attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }

        public static cy m9700a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cy)) ? new C2754a(iBinder) : (cy) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            List a;
            String c;
            String readString;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3561a(parcel.readInt() != 0 ? (zzatq) zzatq.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3563a(parcel.readInt() != 0 ? (zzauq) zzauq.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3558a(parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3562a(parcel.readInt() != 0 ? (zzatq) zzatq.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3565b(parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzatd com_google_android_gms_internal_zzatd = parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a = mo3552a(com_google_android_gms_internal_zzatd, z);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    byte[] a2 = mo3564a(parcel.readInt() != 0 ? (zzatq) zzatq.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(a2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3557a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    c = mo3566c(parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3560a(parcel.readInt() != 0 ? (zzatg) zzatg.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    mo3559a(parcel.readInt() != 0 ? (zzatg) zzatg.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a = mo3556a(readString, readString2, z, parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a);
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    c = parcel.readString();
                    String readString3 = parcel.readString();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a = mo3555a(c, readString3, readString, z);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    a = mo3553a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzatd) zzatd.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a);
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    a = mo3554a(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    List<zzauq> mo3552a(zzatd com_google_android_gms_internal_zzatd, boolean z);

    List<zzatg> mo3553a(String str, String str2, zzatd com_google_android_gms_internal_zzatd);

    List<zzatg> mo3554a(String str, String str2, String str3);

    List<zzauq> mo3555a(String str, String str2, String str3, boolean z);

    List<zzauq> mo3556a(String str, String str2, boolean z, zzatd com_google_android_gms_internal_zzatd);

    void mo3557a(long j, String str, String str2, String str3);

    void mo3558a(zzatd com_google_android_gms_internal_zzatd);

    void mo3559a(zzatg com_google_android_gms_internal_zzatg);

    void mo3560a(zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd);

    void mo3561a(zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd);

    void mo3562a(zzatq com_google_android_gms_internal_zzatq, String str, String str2);

    void mo3563a(zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd);

    byte[] mo3564a(zzatq com_google_android_gms_internal_zzatq, String str);

    void mo3565b(zzatd com_google_android_gms_internal_zzatd);

    String mo3566c(zzatd com_google_android_gms_internal_zzatd);
}
