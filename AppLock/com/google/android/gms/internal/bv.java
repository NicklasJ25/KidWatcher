package com.google.android.gms.internal;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.google.android.gms.internal.abq.C2668a;
import com.google.android.gms.internal.bo.C2708a;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class bv {
    protected static volatile abq f8162a = null;
    private static final ConditionVariable f8163d = new ConditionVariable();
    private static volatile Random f8164e = null;
    protected volatile Boolean f8165b;
    private ez f8166c;

    class C27331 implements Runnable {
        final /* synthetic */ bv f8161a;

        C27331(bv bvVar) {
            this.f8161a = bvVar;
        }

        public void run() {
            if (this.f8161a.f8165b == null) {
                synchronized (bv.f8163d) {
                    if (this.f8161a.f8165b != null) {
                        return;
                    }
                    boolean booleanValue = ((Boolean) qb.bH.m13225c()).booleanValue();
                    if (booleanValue) {
                        try {
                            bv.f8162a = new abq(this.f8161a.f8166c.m10718a(), "ADSHIELD", null);
                        } catch (Throwable th) {
                            booleanValue = false;
                        }
                    }
                    this.f8161a.f8165b = Boolean.valueOf(booleanValue);
                    bv.f8163d.open();
                }
            }
        }
    }

    public bv(ez ezVar) {
        this.f8166c = ezVar;
        m9228a(ezVar.m10722c());
    }

    private void m9228a(Executor executor) {
        executor.execute(new C27331(this));
    }

    private static Random m9230c() {
        if (f8164e == null) {
            synchronized (bv.class) {
                if (f8164e == null) {
                    f8164e = new Random();
                }
            }
        }
        return f8164e;
    }

    public int m9231a() {
        try {
            return VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : m9230c().nextInt();
        } catch (RuntimeException e) {
            return m9230c().nextInt();
        }
    }

    public void m9232a(int i, int i2, long j) {
        try {
            f8163d.block();
            if (this.f8165b.booleanValue() && f8162a != null && this.f8166c.m10728i()) {
                mb c2708a = new C2708a();
                c2708a.f7990a = this.f8166c.m10718a().getPackageName();
                c2708a.f7991b = Long.valueOf(j);
                C2668a a = f8162a.m8835a(mb.m9124a(c2708a));
                a.m8812b(i2);
                a.m8809a(i);
                a.m8808a(this.f8166c.m10726g());
            }
        } catch (Exception e) {
        }
    }
}
