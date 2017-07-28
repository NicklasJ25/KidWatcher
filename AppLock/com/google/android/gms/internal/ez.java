package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.C2482c;
import com.google.android.gms.common.C2484d;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2461c.C2458a;
import com.google.android.gms.internal.bp.C2711a;
import com.google.android.gms.internal.bp.C2714d;
import com.google.android.gms.internal.ef.C2846a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ez {
    protected static final Object f8866c = new Object();
    protected static final Object f8867e = new Object();
    private static final String f8868h = ez.class.getSimpleName();
    private static C2480k f8869u = null;
    protected Context f8870a;
    protected Context f8871b;
    protected boolean f8872d = false;
    protected boolean f8873f = false;
    protected boolean f8874g = false;
    private ExecutorService f8875i;
    private DexClassLoader f8876j;
    private ef f8877k;
    private byte[] f8878l;
    private volatile AdvertisingIdClient f8879m = null;
    private volatile boolean f8880n = false;
    private Future f8881o = null;
    private volatile C2711a f8882p = null;
    private Future f8883q = null;
    private volatile boolean f8884r = false;
    private bv f8885s;
    private C2461c f8886t = null;
    private Map<Pair<String, String>, mg> f8887v;

    class C28561 implements Runnable {
        final /* synthetic */ ez f8863a;

        C28561(ez ezVar) {
            this.f8863a = ezVar;
        }

        public void run() {
            this.f8863a.m10714s();
        }
    }

    class C28572 implements Runnable {
        final /* synthetic */ ez f8864a;

        C28572(ez ezVar) {
            this.f8864a = ezVar;
        }

        public void run() {
            this.f8864a.m10716u();
            synchronized (ez.f8866c) {
                this.f8864a.f8884r = false;
            }
        }
    }

    class C28583 implements Runnable {
        final /* synthetic */ ez f8865a;

        C28583(ez ezVar) {
            this.f8865a = ezVar;
        }

        public void run() {
            qb.m13268a(this.f8865a.f8870a);
        }
    }

    private ez(Context context) {
        this.f8870a = context;
        this.f8871b = context.getApplicationContext();
        this.f8887v = new HashMap();
    }

    public static ez m10701a(Context context, String str, String str2, boolean z) {
        ez ezVar = new ez(context);
        try {
            ezVar.m10709a(str, str2, z);
            return ezVar;
        } catch (ek e) {
            return null;
        }
    }

    @NonNull
    private File m10702a(String str, File file, String str2) {
        File file2 = new File(String.format("%s/%s.jar", new Object[]{file, str2}));
        if (!file2.exists()) {
            byte[] a = this.f8877k.m10574a(this.f8878l, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(a, 0, a.length);
            fileOutputStream.close();
        }
        return file2;
    }

    private void m10704a(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(f8868h, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    private void m10705a(File file, String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
            if (file3.exists()) {
                long length = file3.length();
                if (length > 0) {
                    byte[] bArr = new byte[((int) length)];
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            if (fileInputStream.read(bArr) <= 0) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                                m10704a(file3);
                                return;
                            }
                            mb c2714d = new C2714d();
                            c2714d.f8078d = VERSION.SDK.getBytes();
                            c2714d.f8077c = str.getBytes();
                            bArr = this.f8877k.m10572a(this.f8878l, bArr).getBytes();
                            c2714d.f8075a = bArr;
                            c2714d.f8076b = bt.m9207a(bArr);
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] a = mb.m9124a(c2714d);
                                fileOutputStream.write(a, 0, a.length);
                                fileOutputStream.close();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                }
                                m10704a(file3);
                            } catch (IOException e4) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                m10704a(file3);
                            } catch (NoSuchAlgorithmException e7) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                m10704a(file3);
                            } catch (C2846a e8) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                m10704a(file3);
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileOutputStream2 = fileOutputStream;
                                th = th3;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                m10704a(file3);
                                throw th;
                            }
                        } catch (IOException e11) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            m10704a(file3);
                        } catch (NoSuchAlgorithmException e12) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            m10704a(file3);
                        } catch (C2846a e13) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            m10704a(file3);
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            m10704a(file3);
                            throw th;
                        }
                    } catch (IOException e14) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        m10704a(file3);
                    } catch (NoSuchAlgorithmException e15) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        m10704a(file3);
                    } catch (C2846a e16) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        m10704a(file3);
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        m10704a(file3);
                        throw th;
                    }
                }
            }
        }
    }

    private void m10706a(String str) {
        this.f8877k = new ef(null);
        try {
            this.f8878l = this.f8877k.m10573a(str);
        } catch (Throwable e) {
            throw new ek(e);
        }
    }

    private void m10707a(boolean z) {
        this.f8880n = z;
        if (z) {
            this.f8881o = this.f8875i.submit(new C28561(this));
        }
    }

    private boolean m10709a(String str, String str2, boolean z) {
        this.f8875i = Executors.newCachedThreadPool();
        m10707a(z);
        m10717v();
        m10715t();
        if (fb.m10743b() && ((Boolean) qb.bN.m13225c()).booleanValue()) {
            throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
        }
        m10706a(str);
        m10712b(str2);
        this.f8885s = new bv(this);
        return true;
    }

    private boolean m10711b(File file, String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
        if (file3.exists()) {
            return false;
        }
        try {
            long length = file2.length();
            if (length <= 0) {
                m10704a(file2);
                return false;
            }
            byte[] bArr = new byte[((int) length)];
            fileInputStream = new FileInputStream(file2);
            try {
                if (fileInputStream.read(bArr) <= 0) {
                    Log.d(f8868h, "Cannot read the cache data.");
                    m10704a(file2);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                    return false;
                }
                C2714d a = C2714d.m9177a(bArr);
                if (str.equals(new String(a.f8077c)) && Arrays.equals(a.f8076b, bt.m9207a(a.f8075a)) && Arrays.equals(a.f8078d, VERSION.SDK.getBytes())) {
                    bArr = this.f8877k.m10574a(this.f8878l, new String(a.f8075a));
                    file3.createNewFile();
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                    try {
                        fileOutputStream3.write(bArr, 0, bArr.length);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileOutputStream3.close();
                            return true;
                        } catch (IOException e3) {
                            return true;
                        }
                    } catch (IOException e4) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        return false;
                    } catch (NoSuchAlgorithmException e7) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (C2846a e8) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                }
                m10704a(file2);
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                }
                return false;
            } catch (IOException e12) {
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (NoSuchAlgorithmException e13) {
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (C2846a e14) {
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (IOException e15) {
            fileOutputStream = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (NoSuchAlgorithmException e16) {
            fileOutputStream = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (C2846a e17) {
            fileOutputStream = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    private boolean m10712b(String str) {
        File file;
        String b;
        File a;
        try {
            File cacheDir = this.f8870a.getCacheDir();
            if (cacheDir == null) {
                cacheDir = this.f8870a.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new ek();
                }
            }
            file = cacheDir;
            b = eh.m10594b();
            a = m10702a(str, file, b);
            m10711b(file, b);
            this.f8876j = new DexClassLoader(a.getAbsolutePath(), file.getAbsolutePath(), null, this.f8870a.getClassLoader());
            m10704a(a);
            m10705a(file, b);
            m10713c(String.format("%s/%s.dex", new Object[]{file, b}));
            return true;
        } catch (Throwable e) {
            throw new ek(e);
        } catch (Throwable e2) {
            throw new ek(e2);
        } catch (Throwable e22) {
            throw new ek(e22);
        } catch (Throwable e222) {
            throw new ek(e222);
        } catch (Throwable th) {
            m10704a(a);
            m10705a(file, b);
            m10713c(String.format("%s/%s.dex", new Object[]{file, b}));
        }
    }

    private void m10713c(String str) {
        m10704a(new File(str));
    }

    private void m10714s() {
        try {
            if (this.f8879m == null && this.f8871b != null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f8871b);
                advertisingIdClient.start();
                this.f8879m = advertisingIdClient;
            }
        } catch (C2482c e) {
            this.f8879m = null;
        } catch (IOException e2) {
            this.f8879m = null;
        } catch (C2484d e3) {
            this.f8879m = null;
        }
    }

    private void m10715t() {
        if (((Boolean) qb.bP.m13225c()).booleanValue()) {
            m10733n();
        }
    }

    private void m10716u() {
        if (this.f8873f) {
            try {
                this.f8882p = cc.m9289a(this.f8870a, this.f8870a.getPackageName(), Integer.toString(this.f8870a.getPackageManager().getPackageInfo(this.f8870a.getPackageName(), 0).versionCode));
            } catch (Throwable th) {
            }
        }
    }

    private void m10717v() {
        boolean z = true;
        this.f8875i.execute(new C28583(this));
        try {
            f8869u = C2480k.m7807b();
            this.f8872d = f8869u.mo3318b(this.f8870a) > 0;
            if (f8869u.mo3314a(this.f8870a) != 0) {
                z = false;
            }
            this.f8873f = z;
            if (this.f8870a.getApplicationContext() != null) {
                this.f8886t = new C2458a(this.f8870a).m7758a(abq.f7837c).m7760b();
            }
        } catch (Throwable th) {
        }
    }

    public Context m10718a() {
        return this.f8870a;
    }

    public Method m10719a(String str, String str2) {
        mg mgVar = (mg) this.f8887v.get(new Pair(str, str2));
        return mgVar == null ? null : mgVar.m12560a();
    }

    public boolean m10720a(String str, String str2, List<Class> list) {
        if (this.f8887v.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f8887v.put(new Pair(str, str2), new mg(this, str, str2, list));
        return true;
    }

    public Context m10721b() {
        return this.f8871b;
    }

    public ExecutorService m10722c() {
        return this.f8875i;
    }

    public DexClassLoader m10723d() {
        return this.f8876j;
    }

    public ef m10724e() {
        return this.f8877k;
    }

    public byte[] m10725f() {
        return this.f8878l;
    }

    public C2461c m10726g() {
        return this.f8886t;
    }

    public boolean m10727h() {
        return this.f8872d;
    }

    public boolean m10728i() {
        return this.f8874g;
    }

    public bv m10729j() {
        return this.f8885s;
    }

    public boolean m10730k() {
        return this.f8873f;
    }

    public C2711a m10731l() {
        return this.f8882p;
    }

    public Future m10732m() {
        return this.f8883q;
    }

    public void m10733n() {
        synchronized (f8866c) {
            if (!this.f8884r) {
                this.f8883q = this.f8875i.submit(new C28572(this));
                this.f8884r = true;
            }
        }
    }

    public AdvertisingIdClient m10734o() {
        if (!this.f8880n) {
            return null;
        }
        if (this.f8879m != null) {
            return this.f8879m;
        }
        if (this.f8881o != null) {
            try {
                this.f8881o.get(2000, TimeUnit.MILLISECONDS);
                this.f8881o = null;
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
                this.f8881o.cancel(true);
            }
        }
        return this.f8879m;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m10735p() {
        /*
        r2 = this;
        r1 = f8867e;	 Catch:{ Throwable -> 0x001e }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x001e }
        r0 = r2.f8874g;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.f8873f;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0020;
    L_0x000d:
        r0 = r2.f8886t;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0020;
    L_0x0011:
        r0 = r2.f8886t;	 Catch:{ all -> 0x001b }
        r0.mo3871b();	 Catch:{ all -> 0x001b }
        r0 = 1;
        r2.f8874g = r0;	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0008;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;	 Catch:{ Throwable -> 0x001e }
    L_0x001e:
        r0 = move-exception;
        goto L_0x0008;
    L_0x0020:
        r0 = 0;
        r2.f8874g = r0;	 Catch:{ all -> 0x001b }
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ez.p():void");
    }

    public void m10736q() {
        synchronized (f8867e) {
            if (this.f8874g && this.f8886t != null) {
                this.f8886t.mo3873c();
                this.f8874g = false;
            }
        }
    }

    public int m10737r() {
        bv j = m10729j();
        return j != null ? j.m9231a() : Integer.MIN_VALUE;
    }
}
