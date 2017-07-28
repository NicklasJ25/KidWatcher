package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.C2482c;
import com.google.android.gms.common.C2489m;
import com.google.android.gms.common.C2492h;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.stats.C2574a;
import com.google.android.gms.internal.ms;
import com.google.android.gms.internal.ms.C3063a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    C2492h f6711a;
    ms f6712b;
    boolean f6713c;
    Object f6714d;
    C2323a f6715e;
    final long f6716f;
    private final Context f6717g;

    public static final class Info {
        private final String f6705a;
        private final boolean f6706b;

        public Info(String str, boolean z) {
            this.f6705a = str;
            this.f6706b = z;
        }

        public String getId() {
            return this.f6705a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f6706b;
        }

        public String toString() {
            String str = this.f6705a;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.f6706b).toString();
        }
    }

    static class C2323a extends Thread {
        CountDownLatch f6707a = new CountDownLatch(1);
        boolean f6708b = false;
        private WeakReference<AdvertisingIdClient> f6709c;
        private long f6710d;

        public C2323a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f6709c = new WeakReference(advertisingIdClient);
            this.f6710d = j;
            start();
        }

        private void m7348c() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f6709c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f6708b = true;
            }
        }

        public void m7349a() {
            this.f6707a.countDown();
        }

        public boolean m7350b() {
            return this.f6708b;
        }

        public void run() {
            try {
                if (!this.f6707a.await(this.f6710d, TimeUnit.MILLISECONDS)) {
                    m7348c();
                }
            } catch (InterruptedException e) {
                m7348c();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z) {
        this.f6714d = new Object();
        C2513c.m7932a((Object) context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.f6717g = context;
        } else {
            this.f6717g = context;
        }
        this.f6713c = false;
        this.f6716f = j;
    }

    static C2492h m7351a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (C2480k.m7807b().mo3314a(context)) {
                case 0:
                case 2:
                    ServiceConnection c2492h = new C2492h();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (C2574a.m8252a().m8256a(context, intent, c2492h, 1)) {
                            return c2492h;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new C2482c(9);
        }
    }

    static ms m7352a(Context context, C2492h c2492h) {
        try {
            return C3063a.m12623a(c2492h.m7877a(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void m7353a() {
        synchronized (this.f6714d) {
            if (this.f6715e != null) {
                this.f6715e.m7349a();
                try {
                    this.f6715e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f6716f > 0) {
                this.f6715e = new C2323a(this, this.f6716f);
            }
        }
    }

    private void m7354a(Info info, boolean z, float f, Throwable th) {
        if (Math.random() <= ((double) f)) {
            final String uri = m7355a(info, z, th).toString();
            new Thread(this) {
                public void run() {
                    new zza().zzu(uri);
                }
            }.start();
        }
    }

    public static Info getAdvertisingIdInfo(Context context) {
        Info info;
        float f = 0.0f;
        boolean z = false;
        try {
            Context g = C2489m.m7870g(context);
            if (g != null) {
                SharedPreferences sharedPreferences = g.getSharedPreferences("google_ads_flags", 1);
                z = sharedPreferences.getBoolean("gads:ad_id_app_context:enabled", false);
                f = sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
            }
        } catch (Throwable e) {
            Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", e);
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z);
        try {
            advertisingIdClient.m7356a(false);
            info = advertisingIdClient.getInfo();
            advertisingIdClient.m7354a(info, z, f, null);
            return info;
        } catch (Throwable th) {
            info = th;
            advertisingIdClient.m7354a(null, z, f, info);
            return null;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    Uri m7355a(Info info, boolean z, Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString("app_context", z ? "1" : "0");
        if (info != null) {
            bundle.putString("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            bundle.putString("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            bundle.putString("error", th.getClass().getName());
        }
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : bundle.keySet()) {
            buildUpon.appendQueryParameter(str, bundle.getString(str));
        }
        return buildUpon.build();
    }

    protected void m7356a(boolean z) {
        C2513c.m7944c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f6713c) {
                finish();
            }
            this.f6711a = m7351a(this.f6717g);
            this.f6712b = m7352a(this.f6717g, this.f6711a);
            this.f6713c = true;
            if (z) {
                m7353a();
            }
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.C2513c.m7944c(r0);
        monitor-enter(r3);
        r0 = r3.f6717g;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.f6711a;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.f6713c;	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.C2574a.m8252a();	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        r1 = r3.f6717g;	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        r2 = r3.f6711a;	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        r0.m8254a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
    L_0x001f:
        r0 = 0;
        r3.f6713c = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.f6712b = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.f6711a = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
    L_0x0036:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() {
        Info info;
        C2513c.m7944c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f6713c) {
                synchronized (this.f6714d) {
                    if (this.f6715e == null || !this.f6715e.m7350b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m7356a(false);
                    if (!this.f6713c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C2513c.m7932a(this.f6711a);
            C2513c.m7932a(this.f6712b);
            info = new Info(this.f6712b.mo3835a(), this.f6712b.mo3838a(true));
        }
        m7353a();
        return info;
    }

    public void start() {
        m7356a(true);
    }
}
