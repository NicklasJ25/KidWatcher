package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.wh;

@wh
public class zzb {
    Object f6873a;
    private final Context f6874b;
    private final boolean f6875c;

    public zzb(Context context) {
        this(context, true);
    }

    public zzb(Context context, boolean z) {
        this.f6874b = context;
        this.f6875c = z;
    }

    public void destroy() {
        this.f6873a = null;
    }

    public void zzV(IBinder iBinder) {
        try {
            this.f6873a = this.f6874b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            if (this.f6875c) {
                aad.m8426e("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public Bundle zza(String str, String str2, String str3) {
        try {
            Class loadClass = this.f6874b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.f6873a), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            if (this.f6875c) {
                aad.m8424c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public int zzb(int i, String str, String str2) {
        try {
            Class loadClass = this.f6874b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("isBillingSupported", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f6873a), new Object[]{Integer.valueOf(i), str, str2})).intValue();
        } catch (Throwable e) {
            if (this.f6875c) {
                aad.m8424c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public int zzm(String str, String str2) {
        try {
            Class loadClass = this.f6874b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f6873a), new Object[]{Integer.valueOf(3), str, str2})).intValue();
        } catch (Throwable e) {
            if (this.f6875c) {
                aad.m8424c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzn(String str, String str2) {
        try {
            Class loadClass = this.f6874b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.f6873a), new Object[]{Integer.valueOf(3), str, "inapp", str2});
        } catch (Throwable e) {
            if (this.f6875c) {
                aad.m8424c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
