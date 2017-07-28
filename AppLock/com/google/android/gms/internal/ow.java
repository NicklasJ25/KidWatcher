package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.or.C2385a;
import com.google.android.gms.internal.ot.C2359a;
import com.google.android.gms.internal.oy.C2397a;
import com.google.android.gms.internal.rf.C3153a;
import com.google.android.gms.internal.ub.C3318a;
import com.google.android.gms.internal.va.C2347a;
import com.google.android.gms.internal.vh.C2354a;
import com.google.android.gms.internal.xs.C3155a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2309a.C2311a;

public interface ow extends IInterface {

    public static abstract class C2325a extends Binder implements ow {

        private static class C3135a implements ow {
            private IBinder f10145a;

            C3135a(IBinder iBinder) {
                this.f10145a = iBinder;
            }

            public IBinder asBinder() {
                return this.f10145a;
            }

            public or createAdLoaderBuilder(C2309a c2309a, String str, ub ubVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeString(str);
                    if (ubVar != null) {
                        iBinder = ubVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10145a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    or zzo = C2385a.zzo(obtain2.readStrongBinder());
                    return zzo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public va createAdOverlay(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f10145a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    va zzT = C2347a.zzT(obtain2.readStrongBinder());
                    return zzT;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ot createBannerAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ubVar != null) {
                        iBinder = ubVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10145a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ot zzq = C2359a.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public vh createInAppPurchaseManager(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f10145a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    vh zzY = C2354a.zzY(obtain2.readStrongBinder());
                    return zzY;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ot createInterstitialAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ubVar != null) {
                        iBinder = ubVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10145a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    ot zzq = C2359a.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public rf createNativeAdViewDelegate(C2309a c2309a, C2309a c2309a2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (c2309a2 != null) {
                        iBinder = c2309a2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10145a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    rf a = C3153a.m13165a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public xs createRewardedVideoAd(C2309a c2309a, ub ubVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (ubVar != null) {
                        iBinder = ubVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10145a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    xs a = C3155a.m13182a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ot createSearchAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f10145a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    ot zzq = C2359a.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public oy getMobileAdsSettingsManager(C2309a c2309a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    this.f10145a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    oy zzu = C2397a.zzu(obtain2.readStrongBinder());
                    return zzu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public oy getMobileAdsSettingsManagerWithClientJarVersion(C2309a c2309a, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c2309a != null ? c2309a.asBinder() : null);
                    obtain.writeInt(i);
                    this.f10145a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    oy zzu = C2397a.zzu(obtain2.readStrongBinder());
                    return zzu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2325a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
        }

        public static ow asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ow)) ? new C3135a(iBinder) : (ow) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            ot createBannerAdManager;
            oy mobileAdsSettingsManager;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createBannerAdManager(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C3318a.m14052a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createInterstitialAdManager(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C3318a.m14052a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    or createAdLoaderBuilder = createAdLoaderBuilder(C2311a.m7326a(parcel.readStrongBinder()), parcel.readString(), C3318a.m14052a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createAdLoaderBuilder != null) {
                        iBinder = createAdLoaderBuilder.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManager(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    rf createNativeAdViewDelegate = createNativeAdViewDelegate(C2311a.m7326a(parcel.readStrongBinder()), C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createNativeAdViewDelegate != null) {
                        iBinder = createNativeAdViewDelegate.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    xs createRewardedVideoAd = createRewardedVideoAd(C2311a.m7326a(parcel.readStrongBinder()), C3318a.m14052a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createRewardedVideoAd != null) {
                        iBinder = createRewardedVideoAd.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    vh createInAppPurchaseManager = createInAppPurchaseManager(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createInAppPurchaseManager != null) {
                        iBinder = createInAppPurchaseManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    va createAdOverlay = createAdOverlay(C2311a.m7326a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createAdOverlay != null) {
                        iBinder = createAdOverlay.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManagerWithClientJarVersion(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createSearchAdManager(C2311a.m7326a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    or createAdLoaderBuilder(C2309a c2309a, String str, ub ubVar, int i);

    va createAdOverlay(C2309a c2309a);

    ot createBannerAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i);

    vh createInAppPurchaseManager(C2309a c2309a);

    ot createInterstitialAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i);

    rf createNativeAdViewDelegate(C2309a c2309a, C2309a c2309a2);

    xs createRewardedVideoAd(C2309a c2309a, ub ubVar, int i);

    ot createSearchAdManager(C2309a c2309a, zzeg com_google_android_gms_internal_zzeg, String str, int i);

    oy getMobileAdsSettingsManager(C2309a c2309a);

    oy getMobileAdsSettingsManagerWithClientJarVersion(C2309a c2309a, int i);
}
