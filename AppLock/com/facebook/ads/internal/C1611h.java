package com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1729s.C1728a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class C1611h {
    public static final String f3999a = C1611h.class.getSimpleName();
    private final String f4000b;
    private final boolean f4001c;
    private final C1588c f4002d;

    private static final class C1586a implements IInterface {
        private IBinder f3953a;

        C1586a(IBinder iBinder) {
            this.f3953a = iBinder;
        }

        public String m4416a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3953a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f3953a;
        }

        public boolean m4417b() {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f3953a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
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

    private static final class C1587b implements ServiceConnection {
        private AtomicBoolean f3954a;
        private final BlockingQueue<IBinder> f3955b;

        private C1587b() {
            this.f3954a = new AtomicBoolean(false);
            this.f3955b = new LinkedBlockingDeque();
        }

        public IBinder m4418a() {
            if (!this.f3954a.compareAndSet(true, true)) {
                return (IBinder) this.f3955b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3955b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public enum C1588c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    private C1611h(String str, boolean z, C1588c c1588c) {
        this.f4000b = str;
        this.f4001c = z;
        this.f4002d = c1588c;
    }

    private static C1611h m4515a(Context context) {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new C1611h(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled(), C1588c.DIRECT);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static C1611h m4516a(Context context, C1728a c1728a) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (c1728a != null && !TextUtils.isEmpty(c1728a.f4353b)) {
            return new C1611h(c1728a.f4353b, c1728a.f4354c, C1588c.FB4A);
        } else {
            C1611h a = C1611h.m4515a(context);
            if (a == null || TextUtils.isEmpty(a.m4519a())) {
                a = C1611h.m4517b(context);
            }
            return (a == null || TextUtils.isEmpty(a.m4519a())) ? C1611h.m4518c(context) : a;
        }
    }

    private static C1611h m4517b(Context context) {
        Method a = C1729s.m4968a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a == null) {
            return null;
        }
        Object a2 = C1729s.m4959a(null, a, context);
        if (a2 == null || ((Integer) a2).intValue() != 0) {
            return null;
        }
        a = C1729s.m4968a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a == null) {
            return null;
        }
        Object a3 = C1729s.m4959a(null, a, context);
        if (a3 == null) {
            return null;
        }
        a = C1729s.m4967a(a3.getClass(), "getId", new Class[0]);
        Method a4 = C1729s.m4967a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        return (a == null || a4 == null) ? null : new C1611h((String) C1729s.m4959a(a3, a, new Object[0]), ((Boolean) C1729s.m4959a(a3, a4, new Object[0])).booleanValue(), C1588c.REFLECTION);
    }

    private static C1611h m4518c(Context context) {
        ServiceConnection c1587b = new C1587b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, c1587b, 1)) {
            C1611h c1611h;
            try {
                C1586a c1586a = new C1586a(c1587b.m4418a());
                c1611h = new C1611h(c1586a.m4416a(), c1586a.m4417b(), C1588c.SERVICE);
                return c1611h;
            } catch (Exception e) {
                c1611h = e;
            } finally {
                context.unbindService(c1587b);
            }
        }
        return null;
    }

    public String m4519a() {
        return this.f4000b;
    }

    public boolean m4520b() {
        return this.f4001c;
    }

    public C1588c m4521c() {
        return this.f4002d;
    }
}
