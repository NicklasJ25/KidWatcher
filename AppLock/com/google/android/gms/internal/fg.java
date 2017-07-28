package com.google.android.gms.internal;

import com.android.gallery3d.exif.ExifTag.GpsLongitudeRef;
import com.google.android.gms.internal.bn.C2705a;
import com.google.android.gms.internal.bp.C2711a;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;

public class fg extends ml {
    private static volatile bs f8911i = null;
    private static final Object f8912j = new Object();
    private C2705a f8913k = null;

    public fg(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2, C2705a c2705a) {
        super(ezVar, str, str2, c2711a, i, i2);
        this.f8913k = c2705a;
    }

    public static Boolean m10752a(C2705a c2705a) {
        boolean z = false;
        if (!fb.m10744b(m10754b(c2705a))) {
            return Boolean.valueOf(false);
        }
        if (!(c2705a == null || c2705a.f7982a == null || c2705a.f7982a.f7984a.intValue() != 3)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private void m10753a(int i) {
        boolean z = false;
        Method method = this.f;
        Object[] objArr = new Object[2];
        objArr[0] = this.b.m10718a();
        if (i == 2) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        f8911i = new bs((String) method.invoke(null, objArr));
        if (fb.m10744b(f8911i.f8087a) || f8911i.f8087a.equals(GpsLongitudeRef.EAST)) {
            switch (i) {
                case 3:
                    String f = m10758f();
                    if (!fb.m10744b(f)) {
                        f8911i.f8087a = f;
                        return;
                    }
                    return;
                case 4:
                    f8911i.f8087a = this.f8913k.f7983b.f7985a;
                    return;
                default:
                    return;
            }
        }
    }

    public static String m10754b(C2705a c2705a) {
        return (c2705a == null || c2705a.f7983b == null || fb.m10744b(c2705a.f7983b.f7985a)) ? null : c2705a.f7983b.f7985a;
    }

    private boolean m10755c() {
        return f8911i == null || fb.m10744b(f8911i.f8087a) || f8911i.f8087a.equals(GpsLongitudeRef.EAST);
    }

    private int m10756d() {
        return !fb.m10744b(m10754b(this.f8913k)) ? 4 : (m10752a(this.f8913k).booleanValue() && m10757e()) ? 3 : 2;
    }

    private boolean m10757e() {
        return this.b.m10730k() && ((Boolean) qb.bQ.m13225c()).booleanValue() && ((Boolean) qb.bR.m13225c()).booleanValue() && ((Boolean) qb.bP.m13225c()).booleanValue();
    }

    private String m10758f() {
        try {
            if (this.b.m10732m() != null) {
                this.b.m10732m().get();
            }
            C2711a l = this.b.m10731l();
            if (!(l == null || l.f8064w == null)) {
                return l.f8064w;
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
        return null;
    }

    protected void mo3587a() {
        if (m10755c()) {
            synchronized (f8912j) {
                int d = m10756d();
                if (d == 3) {
                    this.b.m10733n();
                }
                m10753a(d);
            }
        }
        synchronized (this.e) {
            if (f8911i != null) {
                this.e.f8064w = f8911i.f8087a;
                this.e.f8018C = Long.valueOf(f8911i.f8088b);
                this.e.f8017B = f8911i.f8089c;
                this.e.f8028M = f8911i.f8090d;
                this.e.f8029N = f8911i.f8091e;
            }
        }
    }
}
