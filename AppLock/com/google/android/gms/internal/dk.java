package com.google.android.gms.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.internal.cq.C2749a;
import com.google.android.gms.internal.cq.C2750b;
import com.google.android.gms.internal.dc.C2759a;
import com.google.android.gms.internal.dd.C2762a;
import com.google.android.gms.internal.ea.C2837b;
import com.google.android.gms.internal.eb.C2839a;
import com.google.android.gms.internal.eb.C2840b;
import com.google.android.gms.internal.eb.C2841c;
import com.google.android.gms.internal.eb.C2842d;
import com.google.android.gms.internal.eb.C2843e;
import com.google.android.gms.internal.eb.C2845g;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class dk {
    private static volatile dk f8466b;
    private boolean f8467A;
    private Boolean f8468B;
    private long f8469C;
    private FileLock f8470D;
    private FileChannel f8471E;
    private List<Long> f8472F;
    private int f8473G;
    private int f8474H;
    private long f8475I = -1;
    private final long f8476J;
    protected long f8477a;
    private final Context f8478c;
    private final cp f8479d;
    private final dg f8480e;
    private final dc f8481f;
    private final dj f8482g;
    private final dt f8483h;
    private final di f8484i;
    private final AppMeasurement f8485j;
    private final FirebaseAnalytics f8486k;
    private final dy f8487l;
    private final cq f8488m;
    private final da f8489n;
    private final dd f8490o;
    private final C2580e f8491p;
    private final dq f8492q;
    private final dr f8493r;
    private final cs f8494s;
    private final dp f8495t;
    private final cz f8496u;
    private final de f8497v;
    private final dv f8498w;
    private final cn f8499x;
    private final ck f8500y;
    private final boolean f8501z;

    class C27761 implements Runnable {
        final /* synthetic */ dk f8456a;

        C27761(dk dkVar) {
            this.f8456a = dkVar;
        }

        public void run() {
            this.f8456a.m10028c();
        }
    }

    class C27783 implements C2762a {
        final /* synthetic */ dk f8459a;

        C27783(dk dkVar) {
            this.f8459a = dkVar;
        }

        public void mo3567a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.f8459a.m10002a(i, th, bArr);
        }
    }

    class C27794 implements C2762a {
        final /* synthetic */ dk f8460a;

        C27794(dk dkVar) {
            this.f8460a = dkVar;
        }

        public void mo3567a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.f8460a.m10013a(str, i, th, bArr, map);
        }
    }

    private class C2780a implements C2750b {
        C2843e f8461a;
        List<Long> f8462b;
        List<C2840b> f8463c;
        long f8464d;
        final /* synthetic */ dk f8465e;

        private C2780a(dk dkVar) {
            this.f8465e = dkVar;
        }

        private long m9969a(C2840b c2840b) {
            return ((c2840b.f8762c.longValue() / 1000) / 60) / 60;
        }

        public void mo3568a(C2843e c2843e) {
            C2513c.m7932a((Object) c2843e);
            this.f8461a = c2843e;
        }

        boolean m9971a() {
            return this.f8463c == null || this.f8463c.isEmpty();
        }

        public boolean mo3569a(long j, C2840b c2840b) {
            C2513c.m7932a((Object) c2840b);
            if (this.f8463c == null) {
                this.f8463c = new ArrayList();
            }
            if (this.f8462b == null) {
                this.f8462b = new ArrayList();
            }
            if (this.f8463c.size() > 0 && m9969a((C2840b) this.f8463c.get(0)) != m9969a(c2840b)) {
                return false;
            }
            long g = this.f8464d + ((long) c2840b.m9131g());
            if (g >= ((long) this.f8465e.m10030d().ag())) {
                return false;
            }
            this.f8464d = g;
            this.f8463c.add(c2840b);
            this.f8462b.add(Long.valueOf(j));
            return this.f8463c.size() < this.f8465e.m10030d().ah();
        }
    }

    dk(C2790do c2790do) {
        C2513c.m7932a((Object) c2790do);
        this.f8478c = c2790do.f8557a;
        this.f8491p = c2790do.m10094n(this);
        this.f8476J = this.f8491p.mo3360a();
        this.f8479d = c2790do.m10080a(this);
        dg b = c2790do.m10082b(this);
        b.m9449S();
        this.f8480e = b;
        dc c = c2790do.m10083c(this);
        c.m9449S();
        this.f8481f = c;
        m10034f().m9784B().m9775a("App measurement is starting up, version", Long.valueOf(m10030d().m9489V()));
        m10030d().m9490W();
        m10034f().m9784B().m9774a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        dy j = c2790do.m10090j(this);
        j.m9449S();
        this.f8487l = j;
        cs q = c2790do.m10097q(this);
        q.m9449S();
        this.f8494s = q;
        cz r = c2790do.m10098r(this);
        r.m9449S();
        this.f8496u = r;
        m10030d().m9490W();
        String x = r.m9732x();
        if (m10043o().m10441m(x)) {
            m10034f().m9784B().m9774a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        } else {
            C2759a B = m10034f().m9784B();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            x = String.valueOf(x);
            B.m9774a(x.length() != 0 ? str.concat(x) : new String(str));
        }
        m10034f().m9785C().m9774a("Debug-level message logging enabled");
        cq k = c2790do.m10091k(this);
        k.m9449S();
        this.f8488m = k;
        da l = c2790do.m10092l(this);
        l.m9449S();
        this.f8489n = l;
        cn u = c2790do.m10101u(this);
        u.m9449S();
        this.f8499x = u;
        this.f8500y = c2790do.m10102v(this);
        dd m = c2790do.m10093m(this);
        m.m9449S();
        this.f8490o = m;
        dq o = c2790do.m10095o(this);
        o.m9449S();
        this.f8492q = o;
        dr p = c2790do.m10096p(this);
        p.m9449S();
        this.f8493r = p;
        dp i = c2790do.m10089i(this);
        i.m9449S();
        this.f8495t = i;
        dv t = c2790do.m10100t(this);
        t.m9449S();
        this.f8498w = t;
        this.f8497v = c2790do.m10099s(this);
        this.f8485j = c2790do.m10088h(this);
        this.f8486k = c2790do.m10087g(this);
        dt e = c2790do.m10085e(this);
        e.m9449S();
        this.f8483h = e;
        di f = c2790do.m10086f(this);
        f.m9449S();
        this.f8484i = f;
        dj d = c2790do.m10084d(this);
        d.m9449S();
        this.f8482g = d;
        if (this.f8473G != this.f8474H) {
            m10034f().m9815x().m9776a("Not all components initialized", Integer.valueOf(this.f8473G), Integer.valueOf(this.f8474H));
        }
        this.f8501z = true;
        this.f8479d.m9490W();
        if (this.f8478c.getApplicationContext() instanceof Application) {
            int i2 = VERSION.SDK_INT;
            m10040l().m10171x();
        } else {
            m10034f().m9817z().m9774a("Application context is not an Application");
        }
        this.f8482g.m9938a(new C27761(this));
    }

    private boolean m9973Q() {
        m9985C();
        m10001a();
        return m10044p().m9561I() || !TextUtils.isEmpty(m10044p().m9555C());
    }

    @WorkerThread
    private void m9974R() {
        m9985C();
        m10001a();
        if (m9998P()) {
            long abs;
            if (this.f8477a > 0) {
                abs = 3600000 - Math.abs(m10048t().mo3361b() - this.f8477a);
                if (abs > 0) {
                    m10034f().m9786D().m9775a("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    m10053y().m9852b();
                    m10054z().m10354x();
                    return;
                }
                this.f8477a = 0;
            }
            if (m10026b() && m9973Q()) {
                abs = m9975S();
                if (abs == 0) {
                    m10053y().m9852b();
                    m10054z().m10354x();
                    return;
                } else if (m10046r().m9847x()) {
                    long a = m10032e().f8408e.m9858a();
                    long al = m10030d().al();
                    if (!m10043o().m10400a(a, al)) {
                        abs = Math.max(abs, a + al);
                    }
                    m10053y().m9852b();
                    abs -= m10048t().mo3360a();
                    if (abs <= 0) {
                        abs = m10030d().ap();
                        m10032e().f8406c.m9859a(m10048t().mo3360a());
                    }
                    m10034f().m9786D().m9775a("Upload scheduled in approximately ms", Long.valueOf(abs));
                    m10054z().m10331a(abs);
                    return;
                } else {
                    m10053y().m9851a();
                    m10054z().m10354x();
                    return;
                }
            }
            m10053y().m9852b();
            m10054z().m10354x();
        }
    }

    private long m9975S() {
        long an;
        long a = m10048t().mo3360a();
        long as = m10030d().as();
        Object obj = (m10044p().m9562J() || m10044p().m9556D()) ? 1 : null;
        if (obj != null) {
            CharSequence av = m10030d().av();
            an = (TextUtils.isEmpty(av) || ".none.".equals(av)) ? m10030d().an() : m10030d().ao();
        } else {
            an = m10030d().am();
        }
        long a2 = m10032e().f8406c.m9858a();
        long a3 = m10032e().f8407d.m9858a();
        long max = Math.max(m10044p().m9559G(), m10044p().m9560H());
        if (max == 0) {
            return 0;
        }
        max = a - Math.abs(max - a);
        a3 = a - Math.abs(a3 - a);
        a2 = Math.max(a - Math.abs(a2 - a), a3);
        a = max + as;
        if (obj != null && a2 > 0) {
            a = Math.min(max, a2) + an;
        }
        if (!m10043o().m10400a(a2, an)) {
            a = a2 + an;
        }
        if (a3 == 0 || a3 < max) {
            return a;
        }
        for (int i = 0; i < m10030d().au(); i++) {
            a += ((long) (1 << i)) * m10030d().at();
            if (a > a3) {
                return a;
            }
        }
        return 0;
    }

    public static dk m9976a(Context context) {
        C2513c.m7932a((Object) context);
        C2513c.m7932a(context.getApplicationContext());
        if (f8466b == null) {
            synchronized (dk.class) {
                if (f8466b == null) {
                    f8466b = new C2790do(context).m10081a();
                }
            }
        }
        return f8466b;
    }

    private void m9977a(dm dmVar) {
        if (dmVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private boolean m9978a(ct ctVar) {
        if (ctVar.f8287f == null) {
            return false;
        }
        Iterator it = ctVar.f8287f.iterator();
        while (it.hasNext()) {
            if ("_r".equals((String) it.next())) {
                return true;
            }
        }
        return m10038j().m9902c(ctVar.f8282a, ctVar.f8283b) && m10044p().m9565a(m9991I(), ctVar.f8282a, false, false, false, false, false).f8264e < ((long) m10030d().m9501c(ctVar.f8282a));
    }

    private boolean m9979a(String str, long j) {
        m10044p().m9610x();
        try {
            dk dkVar = this;
            C2780a c2780a = new C2780a();
            m10044p().m9580a(str, j, this.f8475I, c2780a);
            if (c2780a.m9971a()) {
                m10044p().m9611y();
                m10044p().m9612z();
                return false;
            }
            int i;
            boolean z = false;
            C2843e c2843e = c2780a.f8461a;
            c2843e.f8782b = new C2840b[c2780a.f8463c.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < c2780a.f8463c.size()) {
                boolean z2;
                Object obj;
                if (m10038j().m9899b(c2780a.f8461a.f8795o, ((C2840b) c2780a.f8463c.get(i3)).f8761b)) {
                    m10034f().m9817z().m9776a("Dropping blacklisted raw event. appId", dc.m9779a(c2780a.f8461a.f8795o), ((C2840b) c2780a.f8463c.get(i3)).f8761b);
                    obj = (m10043o().m10444o(c2780a.f8461a.f8795o) || m10043o().m10446p(c2780a.f8461a.f8795o)) ? 1 : null;
                    if (obj != null || "_err".equals(((C2840b) c2780a.f8463c.get(i3)).f8761b)) {
                        i = i2;
                        z2 = z;
                    } else {
                        m10043o().m10394a(11, "_ev", ((C2840b) c2780a.f8463c.get(i3)).f8761b, 0);
                        i = i2;
                        z2 = z;
                    }
                } else {
                    int i4;
                    boolean z3;
                    boolean c = m10038j().m9902c(c2780a.f8461a.f8795o, ((C2840b) c2780a.f8463c.get(i3)).f8761b);
                    if (c || m10043o().m10448q(((C2840b) c2780a.f8463c.get(i3)).f8761b)) {
                        C2841c[] c2841cArr;
                        C2841c c2841c;
                        C2840b c2840b;
                        Object obj2 = null;
                        Object obj3 = null;
                        if (((C2840b) c2780a.f8463c.get(i3)).f8760a == null) {
                            ((C2840b) c2780a.f8463c.get(i3)).f8760a = new C2841c[0];
                        }
                        C2841c[] c2841cArr2 = ((C2840b) c2780a.f8463c.get(i3)).f8760a;
                        int length = c2841cArr2.length;
                        int i5 = 0;
                        while (i5 < length) {
                            C2841c c2841c2 = c2841cArr2[i5];
                            if ("_c".equals(c2841c2.f8766a)) {
                                c2841c2.f8768c = Long.valueOf(1);
                                obj2 = 1;
                                obj = obj3;
                            } else if ("_r".equals(c2841c2.f8766a)) {
                                c2841c2.f8768c = Long.valueOf(1);
                                obj = 1;
                            } else {
                                obj = obj3;
                            }
                            i5++;
                            obj3 = obj;
                        }
                        if (obj2 == null && c) {
                            m10034f().m9786D().m9775a("Marking event as conversion", ((C2840b) c2780a.f8463c.get(i3)).f8761b);
                            c2841cArr = (C2841c[]) Arrays.copyOf(((C2840b) c2780a.f8463c.get(i3)).f8760a, ((C2840b) c2780a.f8463c.get(i3)).f8760a.length + 1);
                            c2841c = new C2841c();
                            c2841c.f8766a = "_c";
                            c2841c.f8768c = Long.valueOf(1);
                            c2841cArr[c2841cArr.length - 1] = c2841c;
                            ((C2840b) c2780a.f8463c.get(i3)).f8760a = c2841cArr;
                        }
                        if (obj3 == null) {
                            m10034f().m9786D().m9775a("Marking event as real-time", ((C2840b) c2780a.f8463c.get(i3)).f8761b);
                            c2841cArr = (C2841c[]) Arrays.copyOf(((C2840b) c2780a.f8463c.get(i3)).f8760a, ((C2840b) c2780a.f8463c.get(i3)).f8760a.length + 1);
                            c2841c = new C2841c();
                            c2841c.f8766a = "_r";
                            c2841c.f8768c = Long.valueOf(1);
                            c2841cArr[c2841cArr.length - 1] = c2841c;
                            ((C2840b) c2780a.f8463c.get(i3)).f8760a = c2841cArr;
                        }
                        boolean z4 = true;
                        if (m10044p().m9565a(m9991I(), c2780a.f8461a.f8795o, false, false, false, false, true).f8264e > ((long) m10030d().m9501c(c2780a.f8461a.f8795o))) {
                            c2840b = (C2840b) c2780a.f8463c.get(i3);
                            i4 = 0;
                            while (i4 < c2840b.f8760a.length) {
                                if ("_r".equals(c2840b.f8760a[i4].f8766a)) {
                                    obj3 = new C2841c[(c2840b.f8760a.length - 1)];
                                    if (i4 > 0) {
                                        System.arraycopy(c2840b.f8760a, 0, obj3, 0, i4);
                                    }
                                    if (i4 < obj3.length) {
                                        System.arraycopy(c2840b.f8760a, i4 + 1, obj3, i4, obj3.length - i4);
                                    }
                                    c2840b.f8760a = obj3;
                                    z4 = z;
                                } else {
                                    i4++;
                                }
                            }
                            z4 = z;
                        }
                        if (dy.m10374a(((C2840b) c2780a.f8463c.get(i3)).f8761b) && c && m10044p().m9565a(m9991I(), c2780a.f8461a.f8795o, false, false, true, false, false).f8262c > ((long) m10030d().m9498b(c2780a.f8461a.f8795o))) {
                            m10034f().m9817z().m9775a("Too many conversions. Not logging as conversion. appId", dc.m9779a(c2780a.f8461a.f8795o));
                            c2840b = (C2840b) c2780a.f8463c.get(i3);
                            Object obj4 = null;
                            C2841c c2841c3 = null;
                            C2841c[] c2841cArr3 = c2840b.f8760a;
                            int length2 = c2841cArr3.length;
                            int i6 = 0;
                            while (i6 < length2) {
                                c2841c = c2841cArr3[i6];
                                if ("_c".equals(c2841c.f8766a)) {
                                    obj3 = obj4;
                                } else if ("_err".equals(c2841c.f8766a)) {
                                    C2841c c2841c4 = c2841c3;
                                    int i7 = 1;
                                    c2841c = c2841c4;
                                } else {
                                    c2841c = c2841c3;
                                    obj3 = obj4;
                                }
                                i6++;
                                obj4 = obj3;
                                c2841c3 = c2841c;
                            }
                            if (obj4 != null && c2841c3 != null) {
                                c2841cArr3 = new C2841c[(c2840b.f8760a.length - 1)];
                                int i8 = 0;
                                C2841c[] c2841cArr4 = c2840b.f8760a;
                                int length3 = c2841cArr4.length;
                                i6 = 0;
                                while (i6 < length3) {
                                    C2841c c2841c5 = c2841cArr4[i6];
                                    if (c2841c5 != c2841c3) {
                                        i4 = i8 + 1;
                                        c2841cArr3[i8] = c2841c5;
                                    } else {
                                        i4 = i8;
                                    }
                                    i6++;
                                    i8 = i4;
                                }
                                c2840b.f8760a = c2841cArr3;
                                z3 = z4;
                            } else if (c2841c3 != null) {
                                c2841c3.f8766a = "_err";
                                c2841c3.f8768c = Long.valueOf(10);
                                z3 = z4;
                            } else {
                                m10034f().m9815x().m9775a("Did not find conversion parameter. appId", dc.m9779a(c2780a.f8461a.f8795o));
                            }
                        }
                        z3 = z4;
                    } else {
                        z3 = z;
                    }
                    i4 = i2 + 1;
                    c2843e.f8782b[i2] = (C2840b) c2780a.f8463c.get(i3);
                    i = i4;
                    z2 = z3;
                }
                i3++;
                i2 = i;
                z = z2;
            }
            if (i2 < c2780a.f8463c.size()) {
                c2843e.f8782b = (C2840b[]) Arrays.copyOf(c2843e.f8782b, i2);
            }
            c2843e.f8773A = m9980a(c2780a.f8461a.f8795o, c2780a.f8461a.f8783c, c2843e.f8782b);
            c2843e.f8785e = Long.valueOf(Format.OFFSET_SAMPLE_RELATIVE);
            c2843e.f8786f = Long.valueOf(Long.MIN_VALUE);
            for (C2840b c2840b2 : c2843e.f8782b) {
                if (c2840b2.f8762c.longValue() < c2843e.f8785e.longValue()) {
                    c2843e.f8785e = c2840b2.f8762c;
                }
                if (c2840b2.f8762c.longValue() > c2843e.f8786f.longValue()) {
                    c2843e.f8786f = c2840b2.f8762c;
                }
            }
            String str2 = c2780a.f8461a.f8795o;
            cl b = m10044p().m9589b(str2);
            if (b == null) {
                m10034f().m9815x().m9775a("Bundling raw events w/o app info. appId", dc.m9779a(c2780a.f8461a.f8795o));
            } else if (c2843e.f8782b.length > 0) {
                long h = b.m9417h();
                c2843e.f8788h = h != 0 ? Long.valueOf(h) : null;
                long g = b.m9414g();
                if (g != 0) {
                    h = g;
                }
                c2843e.f8787g = h != 0 ? Long.valueOf(h) : null;
                b.m9435r();
                c2843e.f8803w = Integer.valueOf((int) b.m9431o());
                b.m9396a(c2843e.f8785e.longValue());
                b.m9400b(c2843e.f8786f.longValue());
                c2843e.f8804x = b.m9443z();
                m10044p().m9576a(b);
            }
            if (c2843e.f8782b.length > 0) {
                m10030d().m9490W();
                C2837b a = m10038j().m9893a(c2780a.f8461a.f8795o);
                if (a != null && a.f8745a != null) {
                    c2843e.f8779G = a.f8745a;
                } else if (TextUtils.isEmpty(c2780a.f8461a.f8805y)) {
                    c2843e.f8779G = Long.valueOf(-1);
                } else {
                    m10034f().m9817z().m9775a("Did not find measurement config or missing version info. appId", dc.m9779a(c2780a.f8461a.f8795o));
                }
                m10044p().m9586a(c2843e, z);
            }
            m10044p().m9583a(c2780a.f8462b);
            m10044p().m9608i(str2);
            m10044p().m9611y();
            boolean z5 = c2843e.f8782b.length > 0;
            m10044p().m9612z();
            return z5;
        } catch (Throwable th) {
            m10044p().m9612z();
        }
    }

    private C2839a[] m9980a(String str, C2845g[] c2845gArr, C2840b[] c2840bArr) {
        C2513c.m7934a(str);
        return m9983A().m9464a(str, c2840bArr, c2845gArr);
    }

    private void m9981b(dn dnVar) {
        if (dnVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!dnVar.m9447Q()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    @WorkerThread
    private void m9982c(zzatd com_google_android_gms_internal_zzatd) {
        Object obj = 1;
        m9985C();
        m10001a();
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        C2513c.m7934a(com_google_android_gms_internal_zzatd.f11797a);
        cl b = m10044p().m9589b(com_google_android_gms_internal_zzatd.f11797a);
        String b2 = m10032e().m9878b(com_google_android_gms_internal_zzatd.f11797a);
        Object obj2 = null;
        if (b == null) {
            cl clVar = new cl(this, com_google_android_gms_internal_zzatd.f11797a);
            clVar.m9397a(m10032e().m9884y());
            clVar.m9404c(b2);
            b = clVar;
            obj2 = 1;
        } else if (!b2.equals(b.m9408e())) {
            b.m9404c(b2);
            b.m9397a(m10032e().m9884y());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b) || com_google_android_gms_internal_zzatd.f11798b.equals(b.m9405d()))) {
            b.m9401b(com_google_android_gms_internal_zzatd.f11798b);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11807k) || com_google_android_gms_internal_zzatd.f11807k.equals(b.m9411f()))) {
            b.m9407d(com_google_android_gms_internal_zzatd.f11807k);
            obj2 = 1;
        }
        if (!(com_google_android_gms_internal_zzatd.f11801e == 0 || com_google_android_gms_internal_zzatd.f11801e == b.m9425l())) {
            b.m9406d(com_google_android_gms_internal_zzatd.f11801e);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11799c) || com_google_android_gms_internal_zzatd.f11799c.equals(b.m9419i()))) {
            b.m9410e(com_google_android_gms_internal_zzatd.f11799c);
            obj2 = 1;
        }
        if (com_google_android_gms_internal_zzatd.f11806j != b.m9421j()) {
            b.m9403c(com_google_android_gms_internal_zzatd.f11806j);
            obj2 = 1;
        }
        if (!(com_google_android_gms_internal_zzatd.f11800d == null || com_google_android_gms_internal_zzatd.f11800d.equals(b.m9423k()))) {
            b.m9413f(com_google_android_gms_internal_zzatd.f11800d);
            obj2 = 1;
        }
        if (com_google_android_gms_internal_zzatd.f11802f != b.m9427m()) {
            b.m9409e(com_google_android_gms_internal_zzatd.f11802f);
            obj2 = 1;
        }
        if (com_google_android_gms_internal_zzatd.f11804h != b.m9430n()) {
            b.m9398a(com_google_android_gms_internal_zzatd.f11804h);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11803g) || com_google_android_gms_internal_zzatd.f11803g.equals(b.m9442y()))) {
            b.m9416g(com_google_android_gms_internal_zzatd.f11803g);
            obj2 = 1;
        }
        if (com_google_android_gms_internal_zzatd.f11808l != b.m9394A()) {
            b.m9432o(com_google_android_gms_internal_zzatd.f11808l);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            m10044p().m9576a(b);
        }
    }

    public cn m9983A() {
        m9981b(this.f8499x);
        return this.f8499x;
    }

    public ck m9984B() {
        m9977a(this.f8500y);
        return this.f8500y;
    }

    @WorkerThread
    public void m9985C() {
        m10036h().mo3532e();
    }

    FileChannel m9986D() {
        return this.f8471E;
    }

    @WorkerThread
    void m9987E() {
        m9985C();
        m10001a();
        if (m9998P() && m9988F()) {
            m10016a(m9999a(m9986D()), m10052x().m9701A());
        }
    }

    @WorkerThread
    boolean m9988F() {
        m9985C();
        try {
            this.f8471E = new RandomAccessFile(new File(m10047s().getFilesDir(), this.f8488m.m9554B()), "rw").getChannel();
            this.f8470D = this.f8471E.tryLock();
            if (this.f8470D != null) {
                m10034f().m9786D().m9774a("Storage concurrent access okay");
                return true;
            }
            m10034f().m9815x().m9774a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            m10034f().m9815x().m9775a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            m10034f().m9815x().m9775a("Failed to access storage lock file", e2);
        }
    }

    @WorkerThread
    public boolean m9989G() {
        boolean z = false;
        m9985C();
        m10001a();
        if (m10030d().m9492Y()) {
            return false;
        }
        Boolean Z = m10030d().m9493Z();
        if (Z != null) {
            z = Z.booleanValue();
        } else if (!m10030d().aa()) {
            z = true;
        }
        return m10032e().m9881c(z);
    }

    long m9990H() {
        return this.f8476J;
    }

    long m9991I() {
        return ((((m10048t().mo3360a() + m10032e().m9869A()) / 1000) / 60) / 60) / 24;
    }

    void m9992J() {
        m10030d().m9490W();
    }

    void m9993K() {
        m10030d().m9490W();
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    protected boolean m9994L() {
        m9985C();
        return this.f8472F != null;
    }

    @WorkerThread
    public void m9995M() {
        int i = 0;
        m9985C();
        m10001a();
        m10030d().m9490W();
        Boolean D = m10032e().m9872D();
        if (D == null) {
            m10034f().m9817z().m9774a("Upload data called on the client side before use of service was decided");
        } else if (D.booleanValue()) {
            m10034f().m9815x().m9774a("Upload called in the client side when service should be used");
        } else if (this.f8477a > 0) {
            m9974R();
        } else if (m9994L()) {
            m10034f().m9817z().m9774a("Uploading requested multiple times");
        } else if (m10046r().m9847x()) {
            long a = m10048t().mo3360a();
            m10018a(a - m10030d().ak());
            long a2 = m10032e().f8406c.m9858a();
            if (a2 != 0) {
                m10034f().m9785C().m9775a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a - a2)));
            }
            String C = m10044p().m9555C();
            if (TextUtils.isEmpty(C)) {
                this.f8475I = -1;
                String b = m10044p().m9591b(a - m10030d().ak());
                if (!TextUtils.isEmpty(b)) {
                    cl b2 = m10044p().m9589b(b);
                    if (b2 != null) {
                        m10003a(b2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f8475I == -1) {
                this.f8475I = m10044p().m9563K();
            }
            List<Pair> a3 = m10044p().m9568a(C, m10030d().m9511h(C), m10030d().m9513i(C));
            if (!a3.isEmpty()) {
                C2843e c2843e;
                Object obj;
                List subList;
                for (Pair pair : a3) {
                    c2843e = (C2843e) pair.first;
                    if (!TextUtils.isEmpty(c2843e.f8799s)) {
                        obj = c2843e.f8799s;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < a3.size(); i2++) {
                        c2843e = (C2843e) ((Pair) a3.get(i2)).first;
                        if (!TextUtils.isEmpty(c2843e.f8799s) && !c2843e.f8799s.equals(obj)) {
                            subList = a3.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = a3;
                C2842d c2842d = new C2842d();
                c2842d.f8771a = new C2843e[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < c2842d.f8771a.length) {
                    c2842d.f8771a[i] = (C2843e) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    c2842d.f8771a[i].f8798r = Long.valueOf(m10030d().m9489V());
                    c2842d.f8771a[i].f8784d = Long.valueOf(a);
                    c2842d.f8771a[i].f8806z = Boolean.valueOf(m10030d().m9490W());
                    i++;
                }
                Object b3 = m10034f().m9792a(2) ? dy.m10378b(c2842d) : null;
                byte[] a4 = m10043o().m10410a(c2842d);
                String aj = m10030d().aj();
                try {
                    URL url = new URL(aj);
                    m10014a(arrayList);
                    m10032e().f8407d.m9859a(a);
                    Object obj2 = "?";
                    if (c2842d.f8771a.length > 0) {
                        obj2 = c2842d.f8771a[0].f8795o;
                    }
                    m10034f().m9786D().m9777a("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(a4.length), b3);
                    m10046r().m9824a(C, url, a4, null, new C27783(this));
                } catch (MalformedURLException e) {
                    m10034f().m9815x().m9776a("Failed to parse upload URL. Not uploading. appId", dc.m9779a(C), aj);
                }
            }
        } else {
            m10034f().m9817z().m9774a("Network not connected, ignoring upload request");
            m9974R();
        }
    }

    void m9996N() {
        this.f8474H++;
    }

    @WorkerThread
    void m9997O() {
        m9985C();
        m10001a();
        if (!this.f8467A) {
            m10034f().m9784B().m9774a("This instance being marked as an uploader");
            m9987E();
        }
        this.f8467A = true;
    }

    @WorkerThread
    boolean m9998P() {
        m9985C();
        m10001a();
        return this.f8467A;
    }

    @WorkerThread
    int m9999a(FileChannel fileChannel) {
        int i = 0;
        m9985C();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m10034f().m9815x().m9774a("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    i = allocate.getInt();
                } else if (read != -1) {
                    m10034f().m9817z().m9775a("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
            } catch (IOException e) {
                m10034f().m9815x().m9775a("Failed to read from channel", e);
            }
        }
        return i;
    }

    @WorkerThread
    zzatd m10000a(String str) {
        cl b = m10044p().m9589b(str);
        if (b == null || TextUtils.isEmpty(b.m9419i())) {
            m10034f().m9785C().m9775a("No app data available; dropping", str);
            return null;
        }
        try {
            String str2 = bm.m9120b(m10047s()).m9118b(str, 0).versionName;
            if (!(b.m9419i() == null || b.m9419i().equals(str2))) {
                m10034f().m9817z().m9775a("App version does not match; dropping. appId", dc.m9779a(str));
                return null;
            }
        } catch (NameNotFoundException e) {
        }
        return new zzatd(str, b.m9405d(), b.m9419i(), b.m9421j(), b.m9423k(), b.m9425l(), b.m9427m(), null, b.m9430n(), false, b.m9411f(), b.m9394A(), 0, 0);
    }

    void m10001a() {
        if (!this.f8501z) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    @WorkerThread
    protected void m10002a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        m9985C();
        m10001a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f8472F;
        this.f8472F = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                m10032e().f8406c.m9859a(m10048t().mo3360a());
                m10032e().f8407d.m9859a(0);
                m9974R();
                m10034f().m9786D().m9776a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                m10044p().m9610x();
                for (Long longValue : list) {
                    m10044p().m9574a(longValue.longValue());
                }
                m10044p().m9611y();
                m10044p().m9612z();
                if (m10046r().m9847x() && m9973Q()) {
                    m9995M();
                } else {
                    this.f8475I = -1;
                    m9974R();
                }
                this.f8477a = 0;
                return;
            } catch (SQLiteException e) {
                m10034f().m9815x().m9775a("Database error while trying to delete uploaded bundles", e);
                this.f8477a = m10048t().mo3361b();
                m10034f().m9786D().m9775a("Disable upload, time", Long.valueOf(this.f8477a));
                return;
            } catch (Throwable th2) {
                m10044p().m9612z();
            }
        }
        m10034f().m9786D().m9776a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        m10032e().f8407d.m9859a(m10048t().mo3360a());
        if (i == 503 || i == 429) {
            i2 = 1;
        }
        if (i2 != 0) {
            m10032e().f8408e.m9859a(m10048t().mo3360a());
        }
        m9974R();
    }

    void m10003a(cl clVar) {
        Map map = null;
        if (TextUtils.isEmpty(clVar.m9405d())) {
            m10013a(clVar.m9399b(), 204, null, null, null);
            return;
        }
        String a = m10030d().m9497a(clVar.m9405d(), clVar.m9402c());
        try {
            URL url = new URL(a);
            m10034f().m9786D().m9775a("Fetching remote configuration", clVar.m9399b());
            C2837b a2 = m10038j().m9893a(clVar.m9399b());
            CharSequence b = m10038j().m9897b(clVar.m9399b());
            if (!(a2 == null || TextUtils.isEmpty(b))) {
                map = new ArrayMap();
                map.put("If-Modified-Since", b);
            }
            m10046r().m9823a(clVar.m9399b(), url, map, new C27794(this));
        } catch (MalformedURLException e) {
            m10034f().m9815x().m9776a("Failed to parse config URL. Not fetching. appId", dc.m9779a(clVar.m9399b()), a);
        }
    }

    void m10004a(ct ctVar, zzatd com_google_android_gms_internal_zzatd) {
        m9985C();
        m10001a();
        C2513c.m7932a((Object) ctVar);
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        C2513c.m7934a(ctVar.f8282a);
        C2513c.m7941b(ctVar.f8282a.equals(com_google_android_gms_internal_zzatd.f11797a));
        C2843e c2843e = new C2843e();
        c2843e.f8781a = Integer.valueOf(1);
        c2843e.f8789i = "android";
        c2843e.f8795o = com_google_android_gms_internal_zzatd.f11797a;
        c2843e.f8794n = com_google_android_gms_internal_zzatd.f11800d;
        c2843e.f8796p = com_google_android_gms_internal_zzatd.f11799c;
        c2843e.f8775C = Integer.valueOf((int) com_google_android_gms_internal_zzatd.f11806j);
        c2843e.f8797q = Long.valueOf(com_google_android_gms_internal_zzatd.f11801e);
        c2843e.f8805y = com_google_android_gms_internal_zzatd.f11798b;
        c2843e.f8802v = com_google_android_gms_internal_zzatd.f11802f == 0 ? null : Long.valueOf(com_google_android_gms_internal_zzatd.f11802f);
        Pair a = m10032e().m9875a(com_google_android_gms_internal_zzatd.f11797a);
        if (!TextUtils.isEmpty((CharSequence) a.first)) {
            c2843e.f8799s = (String) a.first;
            c2843e.f8800t = (Boolean) a.second;
        } else if (!m10051w().m9623a(this.f8478c)) {
            String string = Secure.getString(this.f8478c.getContentResolver(), "android_id");
            if (string == null) {
                m10034f().m9817z().m9775a("null secure ID. appId", dc.m9779a(c2843e.f8795o));
                string = "null";
            } else if (string.isEmpty()) {
                m10034f().m9817z().m9775a("empty secure ID. appId", dc.m9779a(c2843e.f8795o));
            }
            c2843e.f8778F = string;
        }
        c2843e.f8791k = m10051w().m9646x();
        c2843e.f8790j = m10051w().m9647y();
        c2843e.f8793m = Integer.valueOf((int) m10051w().m9648z());
        c2843e.f8792l = m10051w().m9621A();
        c2843e.f8798r = null;
        c2843e.f8784d = null;
        c2843e.f8785e = null;
        c2843e.f8786f = null;
        c2843e.f8780H = Long.valueOf(com_google_android_gms_internal_zzatd.f11808l);
        cl b = m10044p().m9589b(com_google_android_gms_internal_zzatd.f11797a);
        if (b == null) {
            b = new cl(this, com_google_android_gms_internal_zzatd.f11797a);
            b.m9397a(m10032e().m9884y());
            b.m9407d(com_google_android_gms_internal_zzatd.f11807k);
            b.m9401b(com_google_android_gms_internal_zzatd.f11798b);
            b.m9404c(m10032e().m9878b(com_google_android_gms_internal_zzatd.f11797a));
            b.m9412f(0);
            b.m9396a(0);
            b.m9400b(0);
            b.m9410e(com_google_android_gms_internal_zzatd.f11799c);
            b.m9403c(com_google_android_gms_internal_zzatd.f11806j);
            b.m9413f(com_google_android_gms_internal_zzatd.f11800d);
            b.m9406d(com_google_android_gms_internal_zzatd.f11801e);
            b.m9409e(com_google_android_gms_internal_zzatd.f11802f);
            b.m9398a(com_google_android_gms_internal_zzatd.f11804h);
            b.m9432o(com_google_android_gms_internal_zzatd.f11808l);
            m10044p().m9576a(b);
        }
        c2843e.f8801u = b.m9402c();
        c2843e.f8774B = b.m9411f();
        List a2 = m10044p().m9567a(com_google_android_gms_internal_zzatd.f11797a);
        c2843e.f8783c = new C2845g[a2.size()];
        for (int i = 0; i < a2.size(); i++) {
            C2845g c2845g = new C2845g();
            c2843e.f8783c[i] = c2845g;
            c2845g.f8811b = ((dx) a2.get(i)).f8703c;
            c2845g.f8810a = Long.valueOf(((dx) a2.get(i)).f8704d);
            m10043o().m10398a(c2845g, ((dx) a2.get(i)).f8705e);
        }
        try {
            if (m10044p().m9584a(ctVar, m10044p().m9564a(c2843e), m9978a(ctVar))) {
                this.f8477a = 0;
            }
        } catch (IOException e) {
            m10034f().m9815x().m9776a("Data loss. Failed to insert raw event metadata. appId", dc.m9779a(c2843e.f8795o), e);
        }
    }

    void m10005a(dn dnVar) {
        this.f8473G++;
    }

    void m10006a(zzatd com_google_android_gms_internal_zzatd) {
        m9985C();
        m10001a();
        C2513c.m7934a(com_google_android_gms_internal_zzatd.f11797a);
        m9982c(com_google_android_gms_internal_zzatd);
    }

    @WorkerThread
    void m10007a(zzatd com_google_android_gms_internal_zzatd, long j) {
        cl b = m10044p().m9589b(com_google_android_gms_internal_zzatd.f11797a);
        if (!(b == null || b.m9405d() == null || b.m9405d().equals(com_google_android_gms_internal_zzatd.f11798b))) {
            m10034f().m9817z().m9775a("New GMP App Id passed in. Removing cached database data. appId", dc.m9779a(b.m9399b()));
            m10044p().m9605g(b.m9399b());
            b = null;
        }
        if (b != null && b.m9419i() != null && !b.m9419i().equals(com_google_android_gms_internal_zzatd.f11799c)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", b.m9419i());
            m10010a(new zzatq("_au", new zzato(bundle), "auto", j), com_google_android_gms_internal_zzatd);
        }
    }

    @WorkerThread
    void m10008a(zzatg com_google_android_gms_internal_zzatg) {
        zzatd a = m10000a(com_google_android_gms_internal_zzatg.f11812b);
        if (a != null) {
            m10009a(com_google_android_gms_internal_zzatg, a);
        }
    }

    @WorkerThread
    void m10009a(zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        C2513c.m7934a(com_google_android_gms_internal_zzatg.f11812b);
        C2513c.m7932a(com_google_android_gms_internal_zzatg.f11813c);
        C2513c.m7932a(com_google_android_gms_internal_zzatg.f11814d);
        C2513c.m7934a(com_google_android_gms_internal_zzatg.f11814d.f11831b);
        m9985C();
        m10001a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b)) {
            if (com_google_android_gms_internal_zzatd.f11804h) {
                zzatg com_google_android_gms_internal_zzatg2 = new zzatg(com_google_android_gms_internal_zzatg);
                m10044p().m9610x();
                try {
                    Object obj;
                    zzatg d = m10044p().m9598d(com_google_android_gms_internal_zzatg2.f11812b, com_google_android_gms_internal_zzatg2.f11814d.f11831b);
                    if (d != null && d.f11816f) {
                        com_google_android_gms_internal_zzatg2.f11813c = d.f11813c;
                        com_google_android_gms_internal_zzatg2.f11815e = d.f11815e;
                        com_google_android_gms_internal_zzatg2.f11817g = d.f11817g;
                        com_google_android_gms_internal_zzatg2.f11820j = d.f11820j;
                        obj = null;
                    } else if (TextUtils.isEmpty(com_google_android_gms_internal_zzatg2.f11817g)) {
                        zzauq com_google_android_gms_internal_zzauq = com_google_android_gms_internal_zzatg2.f11814d;
                        com_google_android_gms_internal_zzatg2.f11814d = new zzauq(com_google_android_gms_internal_zzauq.f11831b, com_google_android_gms_internal_zzatg2.f11815e, com_google_android_gms_internal_zzauq.m15354a(), com_google_android_gms_internal_zzauq.f11836g);
                        com_google_android_gms_internal_zzatg2.f11816f = true;
                        int i = 1;
                    } else {
                        obj = null;
                    }
                    if (com_google_android_gms_internal_zzatg2.f11816f) {
                        zzauq com_google_android_gms_internal_zzauq2 = com_google_android_gms_internal_zzatg2.f11814d;
                        dx dxVar = new dx(com_google_android_gms_internal_zzatg2.f11812b, com_google_android_gms_internal_zzatg2.f11813c, com_google_android_gms_internal_zzauq2.f11831b, com_google_android_gms_internal_zzauq2.f11832c, com_google_android_gms_internal_zzauq2.m15354a());
                        if (m10044p().m9585a(dxVar)) {
                            m10034f().m9785C().m9777a("User property updated immediately", com_google_android_gms_internal_zzatg2.f11812b, dxVar.f8703c, dxVar.f8705e);
                        } else {
                            m10034f().m9815x().m9777a("(2)Too many active user properties, ignoring", dc.m9779a(com_google_android_gms_internal_zzatg2.f11812b), dxVar.f8703c, dxVar.f8705e);
                        }
                        if (!(obj == null || com_google_android_gms_internal_zzatg2.f11820j == null)) {
                            m10024b(new zzatq(com_google_android_gms_internal_zzatg2.f11820j, com_google_android_gms_internal_zzatg2.f11815e), com_google_android_gms_internal_zzatd);
                        }
                    }
                    if (m10044p().m9587a(com_google_android_gms_internal_zzatg2)) {
                        m10034f().m9785C().m9777a("Conditional property added", com_google_android_gms_internal_zzatg2.f11812b, com_google_android_gms_internal_zzatg2.f11814d.f11831b, com_google_android_gms_internal_zzatg2.f11814d.m15354a());
                    } else {
                        m10034f().m9815x().m9777a("Too many conditional properties, ignoring", dc.m9779a(com_google_android_gms_internal_zzatg2.f11812b), com_google_android_gms_internal_zzatg2.f11814d.f11831b, com_google_android_gms_internal_zzatg2.f11814d.m15354a());
                    }
                    m10044p().m9611y();
                } finally {
                    m10044p().m9612z();
                }
            } else {
                m9982c(com_google_android_gms_internal_zzatd);
            }
        }
    }

    @WorkerThread
    void m10010a(zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        C2513c.m7934a(com_google_android_gms_internal_zzatd.f11797a);
        m9985C();
        m10001a();
        String str = com_google_android_gms_internal_zzatd.f11797a;
        long j = com_google_android_gms_internal_zzatq.f11829d;
        if (!m10043o().m10403a(com_google_android_gms_internal_zzatq, com_google_android_gms_internal_zzatd)) {
            return;
        }
        if (com_google_android_gms_internal_zzatd.f11804h) {
            m10044p().m9610x();
            try {
                for (zzatg com_google_android_gms_internal_zzatg : m10044p().m9569a(str, j)) {
                    if (com_google_android_gms_internal_zzatg != null) {
                        m10034f().m9785C().m9777a("User property timed out", com_google_android_gms_internal_zzatg.f11812b, com_google_android_gms_internal_zzatg.f11814d.f11831b, com_google_android_gms_internal_zzatg.f11814d.m15354a());
                        if (com_google_android_gms_internal_zzatg.f11818h != null) {
                            m10024b(new zzatq(com_google_android_gms_internal_zzatg.f11818h, j), com_google_android_gms_internal_zzatd);
                        }
                        m10044p().m9600e(str, com_google_android_gms_internal_zzatg.f11814d.f11831b);
                    }
                }
                List<zzatg> b = m10044p().m9592b(str, j);
                List<zzatq> arrayList = new ArrayList(b.size());
                for (zzatg com_google_android_gms_internal_zzatg2 : b) {
                    if (com_google_android_gms_internal_zzatg2 != null) {
                        m10034f().m9785C().m9777a("User property expired", com_google_android_gms_internal_zzatg2.f11812b, com_google_android_gms_internal_zzatg2.f11814d.f11831b, com_google_android_gms_internal_zzatg2.f11814d.m15354a());
                        m10044p().m9595b(str, com_google_android_gms_internal_zzatg2.f11814d.f11831b);
                        if (com_google_android_gms_internal_zzatg2.f11822l != null) {
                            arrayList.add(com_google_android_gms_internal_zzatg2.f11822l);
                        }
                        m10044p().m9600e(str, com_google_android_gms_internal_zzatg2.f11814d.f11831b);
                    }
                }
                for (zzatq com_google_android_gms_internal_zzatq2 : arrayList) {
                    m10024b(new zzatq(com_google_android_gms_internal_zzatq2, j), com_google_android_gms_internal_zzatd);
                }
                b = m10044p().m9570a(str, com_google_android_gms_internal_zzatq.f11826a, j);
                List<zzatq> arrayList2 = new ArrayList(b.size());
                for (zzatg com_google_android_gms_internal_zzatg3 : b) {
                    if (com_google_android_gms_internal_zzatg3 != null) {
                        zzauq com_google_android_gms_internal_zzauq = com_google_android_gms_internal_zzatg3.f11814d;
                        dx dxVar = new dx(com_google_android_gms_internal_zzatg3.f11812b, com_google_android_gms_internal_zzatg3.f11813c, com_google_android_gms_internal_zzauq.f11831b, j, com_google_android_gms_internal_zzauq.m15354a());
                        if (m10044p().m9585a(dxVar)) {
                            m10034f().m9785C().m9777a("User property triggered", com_google_android_gms_internal_zzatg3.f11812b, dxVar.f8703c, dxVar.f8705e);
                        } else {
                            m10034f().m9815x().m9777a("Too many active user properties, ignoring", dc.m9779a(com_google_android_gms_internal_zzatg3.f11812b), dxVar.f8703c, dxVar.f8705e);
                        }
                        if (com_google_android_gms_internal_zzatg3.f11820j != null) {
                            arrayList2.add(com_google_android_gms_internal_zzatg3.f11820j);
                        }
                        com_google_android_gms_internal_zzatg3.f11814d = new zzauq(dxVar);
                        com_google_android_gms_internal_zzatg3.f11816f = true;
                        m10044p().m9587a(com_google_android_gms_internal_zzatg3);
                    }
                }
                m10024b(com_google_android_gms_internal_zzatq, com_google_android_gms_internal_zzatd);
                for (zzatq com_google_android_gms_internal_zzatq22 : arrayList2) {
                    m10024b(new zzatq(com_google_android_gms_internal_zzatq22, j), com_google_android_gms_internal_zzatd);
                }
                m10044p().m9611y();
            } finally {
                m10044p().m9612z();
            }
        } else {
            m9982c(com_google_android_gms_internal_zzatd);
        }
    }

    @WorkerThread
    void m10011a(zzatq com_google_android_gms_internal_zzatq, String str) {
        cl b = m10044p().m9589b(str);
        if (b == null || TextUtils.isEmpty(b.m9419i())) {
            m10034f().m9785C().m9775a("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = bm.m9120b(m10047s()).m9118b(str, 0).versionName;
            if (!(b.m9419i() == null || b.m9419i().equals(str2))) {
                m10034f().m9817z().m9775a("App version does not match; dropping event. appId", dc.m9779a(str));
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(com_google_android_gms_internal_zzatq.f11826a)) {
                m10034f().m9817z().m9775a("Could not find package. appId", dc.m9779a(str));
            }
        }
        zzatq com_google_android_gms_internal_zzatq2 = com_google_android_gms_internal_zzatq;
        m10010a(com_google_android_gms_internal_zzatq2, new zzatd(str, b.m9405d(), b.m9419i(), b.m9421j(), b.m9423k(), b.m9425l(), b.m9427m(), null, b.m9430n(), false, b.m9411f(), b.m9394A(), 0, 0));
    }

    @WorkerThread
    void m10012a(zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd) {
        int i = 0;
        m9985C();
        m10001a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b)) {
            if (com_google_android_gms_internal_zzatd.f11804h) {
                int e = m10043o().m10426e(com_google_android_gms_internal_zzauq.f11831b);
                String a;
                if (e != 0) {
                    a = m10043o().m10392a(com_google_android_gms_internal_zzauq.f11831b, m10030d().m9532z(), true);
                    if (com_google_android_gms_internal_zzauq.f11831b != null) {
                        i = com_google_android_gms_internal_zzauq.f11831b.length();
                    }
                    m10043o().m10394a(e, "_ev", a, i);
                    return;
                }
                e = m10043o().m10414b(com_google_android_gms_internal_zzauq.f11831b, com_google_android_gms_internal_zzauq.m15354a());
                if (e != 0) {
                    a = m10043o().m10392a(com_google_android_gms_internal_zzauq.f11831b, m10030d().m9532z(), true);
                    Object a2 = com_google_android_gms_internal_zzauq.m15354a();
                    if (a2 != null && ((a2 instanceof String) || (a2 instanceof CharSequence))) {
                        i = String.valueOf(a2).length();
                    }
                    m10043o().m10394a(e, "_ev", a, i);
                    return;
                }
                Object c = m10043o().m10420c(com_google_android_gms_internal_zzauq.f11831b, com_google_android_gms_internal_zzauq.m15354a());
                if (c != null) {
                    dx dxVar = new dx(com_google_android_gms_internal_zzatd.f11797a, com_google_android_gms_internal_zzauq.f11836g, com_google_android_gms_internal_zzauq.f11831b, com_google_android_gms_internal_zzauq.f11832c, c);
                    m10034f().m9785C().m9776a("Setting user property", dxVar.f8703c, c);
                    m10044p().m9610x();
                    try {
                        m9982c(com_google_android_gms_internal_zzatd);
                        boolean a3 = m10044p().m9585a(dxVar);
                        m10044p().m9611y();
                        if (a3) {
                            m10034f().m9785C().m9776a("User property set", dxVar.f8703c, dxVar.f8705e);
                        } else {
                            m10034f().m9815x().m9776a("Too many unique user properties are set. Ignoring user property", dxVar.f8703c, dxVar.f8705e);
                            m10043o().m10394a(9, null, null, 0);
                        }
                        m10044p().m9612z();
                        return;
                    } catch (Throwable th) {
                        m10044p().m9612z();
                    }
                } else {
                    return;
                }
            }
            m9982c(com_google_android_gms_internal_zzatd);
        }
    }

    @WorkerThread
    void m10013a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        m9985C();
        m10001a();
        C2513c.m7934a(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        m10044p().m9610x();
        try {
            cl b = m10044p().m9589b(str);
            int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (b == null) {
                m10034f().m9817z().m9775a("App does not exist in onConfigFetched. appId", dc.m9779a(str));
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (m10038j().m9893a(str) == null && !m10038j().m9896a(str, null, null)) {
                        m10044p().m9612z();
                        return;
                    }
                } else if (!m10038j().m9896a(str, bArr, str2)) {
                    m10044p().m9612z();
                    return;
                }
                b.m9415g(m10048t().mo3360a());
                m10044p().m9576a(b);
                if (i == 404) {
                    m10034f().m9783A().m9775a("Config not found. Using empty config. appId", str);
                } else {
                    m10034f().m9786D().m9776a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (m10046r().m9847x() && m9973Q()) {
                    m9995M();
                } else {
                    m9974R();
                }
            } else {
                b.m9418h(m10048t().mo3360a());
                m10044p().m9576a(b);
                m10034f().m9786D().m9776a("Fetching config failed. code, error", Integer.valueOf(i), th);
                m10038j().m9901c(str);
                m10032e().f8407d.m9859a(m10048t().mo3360a());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    m10032e().f8408e.m9859a(m10048t().mo3360a());
                }
                m9974R();
            }
            m10044p().m9611y();
        } finally {
            m10044p().m9612z();
        }
    }

    protected void m10014a(List<Long> list) {
        C2513c.m7941b(!list.isEmpty());
        if (this.f8472F != null) {
            m10034f().m9815x().m9774a("Set uploading progress before finishing the previous upload");
        } else {
            this.f8472F = new ArrayList(list);
        }
    }

    public void m10015a(boolean z) {
        m9974R();
    }

    @WorkerThread
    boolean m10016a(int i, int i2) {
        m9985C();
        if (i > i2) {
            m10034f().m9815x().m9776a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (m10017a(i2, m9986D())) {
                m10034f().m9786D().m9776a("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                m10034f().m9815x().m9776a("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    boolean m10017a(int i, FileChannel fileChannel) {
        m9985C();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m10034f().m9815x().m9774a("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            m10034f().m9815x().m9775a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            m10034f().m9815x().m9775a("Failed to write to channel", e);
            return false;
        }
    }

    boolean m10018a(long j) {
        return m9979a(null, j);
    }

    public String m10019b(final String str) {
        Object e;
        try {
            return (String) m10036h().m9936a(new Callable<String>(this) {
                final /* synthetic */ dk f8458b;

                public String m9966a() {
                    cl b = this.f8458b.m10044p().m9589b(str);
                    if (b != null) {
                        return b.m9402c();
                    }
                    this.f8458b.m10034f().m9817z().m9774a("App info was null when attempting to get app instance id");
                    return null;
                }

                public /* synthetic */ Object call() {
                    return m9966a();
                }
            }).get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
        } catch (InterruptedException e3) {
            e = e3;
        } catch (ExecutionException e4) {
            e = e4;
        }
        m10034f().m9815x().m9776a("Failed to get app instance id. appId", dc.m9779a(str), e);
        return null;
    }

    @WorkerThread
    public void m10020b(zzatd com_google_android_gms_internal_zzatd) {
        m9985C();
        m10001a();
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        C2513c.m7934a(com_google_android_gms_internal_zzatd.f11797a);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b)) {
            if (com_google_android_gms_internal_zzatd.f11804h) {
                long j = com_google_android_gms_internal_zzatd.f11809m;
                if (j == 0) {
                    j = m10048t().mo3360a();
                }
                int i = com_google_android_gms_internal_zzatd.f11810n;
                if (!(i == 0 || i == 1)) {
                    m10034f().m9817z().m9776a("Incorrect app type, assuming installed app. appId, appType", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), Integer.valueOf(i));
                    i = 0;
                }
                m10044p().m9610x();
                try {
                    m10007a(com_google_android_gms_internal_zzatd, j);
                    m9982c(com_google_android_gms_internal_zzatd);
                    cu cuVar = null;
                    if (i == 0) {
                        cuVar = m10044p().m9566a(com_google_android_gms_internal_zzatd.f11797a, "_f");
                    } else if (i == 1) {
                        cuVar = m10044p().m9566a(com_google_android_gms_internal_zzatd.f11797a, "_v");
                    }
                    if (cuVar == null) {
                        long j2 = (1 + (j / 3600000)) * 3600000;
                        if (i == 0) {
                            m10012a(new zzauq("_fot", j, Long.valueOf(j2), "auto"), com_google_android_gms_internal_zzatd);
                            m10029c(com_google_android_gms_internal_zzatd, j);
                        } else if (i == 1) {
                            m10012a(new zzauq("_fvt", j, Long.valueOf(j2), "auto"), com_google_android_gms_internal_zzatd);
                            m10021b(com_google_android_gms_internal_zzatd, j);
                        }
                        m10031d(com_google_android_gms_internal_zzatd, j);
                    } else if (com_google_android_gms_internal_zzatd.f11805i) {
                        m10033e(com_google_android_gms_internal_zzatd, j);
                    }
                    m10044p().m9611y();
                } finally {
                    m10044p().m9612z();
                }
            } else {
                m9982c(com_google_android_gms_internal_zzatd);
            }
        }
    }

    @WorkerThread
    void m10021b(zzatd com_google_android_gms_internal_zzatd, long j) {
        m9985C();
        m10001a();
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        bundle.putLong("_r", 1);
        m10010a(new zzatq("_v", new zzato(bundle), "auto", j), com_google_android_gms_internal_zzatd);
    }

    @WorkerThread
    void m10022b(zzatg com_google_android_gms_internal_zzatg) {
        zzatd a = m10000a(com_google_android_gms_internal_zzatg.f11812b);
        if (a != null) {
            m10023b(com_google_android_gms_internal_zzatg, a);
        }
    }

    @WorkerThread
    void m10023b(zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        C2513c.m7934a(com_google_android_gms_internal_zzatg.f11812b);
        C2513c.m7932a(com_google_android_gms_internal_zzatg.f11814d);
        C2513c.m7934a(com_google_android_gms_internal_zzatg.f11814d.f11831b);
        m9985C();
        m10001a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b)) {
            if (com_google_android_gms_internal_zzatd.f11804h) {
                m10044p().m9610x();
                try {
                    m9982c(com_google_android_gms_internal_zzatd);
                    zzatg d = m10044p().m9598d(com_google_android_gms_internal_zzatg.f11812b, com_google_android_gms_internal_zzatg.f11814d.f11831b);
                    if (d != null) {
                        m10034f().m9785C().m9776a("Removing conditional user property", com_google_android_gms_internal_zzatg.f11812b, com_google_android_gms_internal_zzatg.f11814d.f11831b);
                        m10044p().m9600e(com_google_android_gms_internal_zzatg.f11812b, com_google_android_gms_internal_zzatg.f11814d.f11831b);
                        if (d.f11816f) {
                            m10044p().m9595b(com_google_android_gms_internal_zzatg.f11812b, com_google_android_gms_internal_zzatg.f11814d.f11831b);
                        }
                        if (com_google_android_gms_internal_zzatg.f11822l != null) {
                            Bundle bundle = null;
                            if (com_google_android_gms_internal_zzatg.f11822l.f11827b != null) {
                                bundle = com_google_android_gms_internal_zzatg.f11822l.f11827b.m15353b();
                            }
                            m10024b(m10043o().m10390a(com_google_android_gms_internal_zzatg.f11822l.f11826a, bundle, d.f11813c, com_google_android_gms_internal_zzatg.f11822l.f11829d, true, false), com_google_android_gms_internal_zzatd);
                        }
                    } else {
                        m10034f().m9817z().m9776a("Conditional user property doesn't exist", dc.m9779a(com_google_android_gms_internal_zzatg.f11812b), com_google_android_gms_internal_zzatg.f11814d.f11831b);
                    }
                    m10044p().m9611y();
                } finally {
                    m10044p().m9612z();
                }
            } else {
                m9982c(com_google_android_gms_internal_zzatd);
            }
        }
    }

    @WorkerThread
    void m10024b(zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        C2513c.m7934a(com_google_android_gms_internal_zzatd.f11797a);
        long nanoTime = System.nanoTime();
        m9985C();
        m10001a();
        String str = com_google_android_gms_internal_zzatd.f11797a;
        if (!m10043o().m10403a(com_google_android_gms_internal_zzatq, com_google_android_gms_internal_zzatd)) {
            return;
        }
        if (!com_google_android_gms_internal_zzatd.f11804h) {
            m9982c(com_google_android_gms_internal_zzatd);
        } else if (m10038j().m9899b(str, com_google_android_gms_internal_zzatq.f11826a)) {
            m10034f().m9817z().m9776a("Dropping blacklisted event. appId", dc.m9779a(str), com_google_android_gms_internal_zzatq.f11826a);
            r2 = (m10043o().m10444o(str) || m10043o().m10446p(str)) ? 1 : null;
            if (r2 == null && !"_err".equals(com_google_android_gms_internal_zzatq.f11826a)) {
                m10043o().m10394a(11, "_ev", com_google_android_gms_internal_zzatq.f11826a, 0);
            }
            if (r2 != null) {
                cl b = m10044p().m9589b(str);
                if (b != null) {
                    if (Math.abs(m10048t().mo3360a() - Math.max(b.m9434q(), b.m9433p())) > m10030d().ad()) {
                        m10034f().m9785C().m9774a("Fetching config for blacklisted app");
                        m10003a(b);
                    }
                }
            }
        } else {
            if (m10034f().m9792a(2)) {
                m10034f().m9786D().m9775a("Logging event", com_google_android_gms_internal_zzatq);
            }
            m10044p().m9610x();
            try {
                Bundle b2 = com_google_android_gms_internal_zzatq.f11827b.m15353b();
                m9982c(com_google_android_gms_internal_zzatd);
                if ("_iap".equals(com_google_android_gms_internal_zzatq.f11826a) || "ecommerce_purchase".equals(com_google_android_gms_internal_zzatq.f11826a)) {
                    long round;
                    r2 = b2.getString("currency");
                    if ("ecommerce_purchase".equals(com_google_android_gms_internal_zzatq.f11826a)) {
                        double d = b2.getDouble("value") * 1000000.0d;
                        if (d == 0.0d) {
                            d = ((double) b2.getLong("value")) * 1000000.0d;
                        }
                        if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                            m10034f().m9817z().m9776a("Data lost. Currency value is too big. appId", dc.m9779a(str), Double.valueOf(d));
                            m10044p().m9611y();
                            m10044p().m9612z();
                            return;
                        }
                        round = Math.round(d);
                    } else {
                        round = b2.getLong("value");
                    }
                    if (!TextUtils.isEmpty(r2)) {
                        String toUpperCase = r2.toUpperCase(Locale.US);
                        if (toUpperCase.matches("[A-Z]{3}")) {
                            String valueOf = String.valueOf("_ltv_");
                            toUpperCase = String.valueOf(toUpperCase);
                            String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                            dx c = m10044p().m9597c(str, concat);
                            if (c == null || !(c.f8705e instanceof Long)) {
                                m10044p().m9578a(str, m10030d().m9505e(str) - 1);
                                c = new dx(str, com_google_android_gms_internal_zzatq.f11828c, concat, m10048t().mo3360a(), Long.valueOf(round));
                            } else {
                                c = new dx(str, com_google_android_gms_internal_zzatq.f11828c, concat, m10048t().mo3360a(), Long.valueOf(round + ((Long) c.f8705e).longValue()));
                            }
                            if (!m10044p().m9585a(c)) {
                                m10034f().m9815x().m9777a("Too many unique user properties are set. Ignoring user property. appId", dc.m9779a(str), c.f8703c, c.f8705e);
                                m10043o().m10394a(9, null, null, 0);
                            }
                        }
                    }
                }
                boolean a = dy.m10374a(com_google_android_gms_internal_zzatq.f11826a);
                boolean equals = "_err".equals(com_google_android_gms_internal_zzatq.f11826a);
                C2749a a2 = m10044p().m9565a(m9991I(), str, true, a, false, equals, false);
                long H = a2.f8261b - m10030d().m9475H();
                if (H > 0) {
                    if (H % 1000 == 1) {
                        m10034f().m9815x().m9776a("Data loss. Too many events logged. appId, count", dc.m9779a(str), Long.valueOf(a2.f8261b));
                    }
                    m10043o().m10394a(16, "_ev", com_google_android_gms_internal_zzatq.f11826a, 0);
                    m10044p().m9611y();
                    return;
                }
                cu cuVar;
                if (a) {
                    H = a2.f8260a - m10030d().m9476I();
                    if (H > 0) {
                        if (H % 1000 == 1) {
                            m10034f().m9815x().m9776a("Data loss. Too many public events logged. appId, count", dc.m9779a(str), Long.valueOf(a2.f8260a));
                        }
                        m10043o().m10394a(16, "_ev", com_google_android_gms_internal_zzatq.f11826a, 0);
                        m10044p().m9611y();
                        m10044p().m9612z();
                        return;
                    }
                }
                if (equals) {
                    H = a2.f8263d - ((long) m10030d().m9494a(com_google_android_gms_internal_zzatd.f11797a));
                    if (H > 0) {
                        if (H == 1) {
                            m10034f().m9815x().m9776a("Too many error events logged. appId, count", dc.m9779a(str), Long.valueOf(a2.f8263d));
                        }
                        m10044p().m9611y();
                        m10044p().m9612z();
                        return;
                    }
                }
                m10043o().m10396a(b2, "_o", com_google_android_gms_internal_zzatq.f11828c);
                if (m10043o().m10441m(str)) {
                    m10043o().m10396a(b2, "_dbg", Long.valueOf(1));
                    m10043o().m10396a(b2, "_r", Long.valueOf(1));
                }
                H = m10044p().m9596c(str);
                if (H > 0) {
                    m10034f().m9817z().m9776a("Data lost. Too many events stored on disk, deleted. appId", dc.m9779a(str), Long.valueOf(H));
                }
                ct ctVar = new ct(this, com_google_android_gms_internal_zzatq.f11828c, str, com_google_android_gms_internal_zzatq.f11826a, com_google_android_gms_internal_zzatq.f11829d, 0, b2);
                cu a3 = m10044p().m9566a(str, ctVar.f8283b);
                if (a3 == null) {
                    long j = m10044p().m9609j(str);
                    m10030d().m9474G();
                    if (j >= 500) {
                        m10034f().m9815x().m9777a("Too many event names used, ignoring event. appId, name, supported count", dc.m9779a(str), ctVar.f8283b, Integer.valueOf(m10030d().m9474G()));
                        m10043o().m10394a(8, null, null, 0);
                        m10044p().m9612z();
                        return;
                    }
                    cuVar = new cu(str, ctVar.f8283b, 0, 0, ctVar.f8285d);
                } else {
                    ctVar = ctVar.m9650a(this, a3.f8292e);
                    cuVar = a3.m9652a(ctVar.f8285d);
                }
                m10044p().m9577a(cuVar);
                m10004a(ctVar, com_google_android_gms_internal_zzatd);
                m10044p().m9611y();
                if (m10034f().m9792a(2)) {
                    m10034f().m9786D().m9775a("Event recorded", ctVar);
                }
                m10044p().m9612z();
                m9974R();
                m10034f().m9786D().m9775a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
            } finally {
                m10044p().m9612z();
            }
        }
    }

    @WorkerThread
    void m10025b(zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd) {
        m9985C();
        m10001a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b)) {
            if (com_google_android_gms_internal_zzatd.f11804h) {
                m10034f().m9785C().m9775a("Removing user property", com_google_android_gms_internal_zzauq.f11831b);
                m10044p().m9610x();
                try {
                    m9982c(com_google_android_gms_internal_zzatd);
                    m10044p().m9595b(com_google_android_gms_internal_zzatd.f11797a, com_google_android_gms_internal_zzauq.f11831b);
                    m10044p().m9611y();
                    m10034f().m9785C().m9775a("User property removed", com_google_android_gms_internal_zzauq.f11831b);
                } finally {
                    m10044p().m9612z();
                }
            } else {
                m9982c(com_google_android_gms_internal_zzatd);
            }
        }
    }

    @WorkerThread
    protected boolean m10026b() {
        boolean z = false;
        m10001a();
        m9985C();
        if (this.f8468B == null || this.f8469C == 0 || !(this.f8468B == null || this.f8468B.booleanValue() || Math.abs(m10048t().mo3361b() - this.f8469C) <= 1000)) {
            this.f8469C = m10048t().mo3361b();
            m10030d().m9490W();
            if (m10043o().m10438k("android.permission.INTERNET") && m10043o().m10438k("android.permission.ACCESS_NETWORK_STATE") && (bm.m9120b(m10047s()).m9115a() || (dh.m9887a(m10047s(), false) && ds.m10278a(m10047s(), false)))) {
                z = true;
            }
            this.f8468B = Boolean.valueOf(z);
            if (this.f8468B.booleanValue()) {
                this.f8468B = Boolean.valueOf(m10043o().m10433h(m10052x().m9733y()));
            }
        }
        return this.f8468B.booleanValue();
    }

    @WorkerThread
    public byte[] m10027b(@NonNull zzatq com_google_android_gms_internal_zzatq, @Size(min = 1) String str) {
        m10001a();
        m9985C();
        m9993K();
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        C2513c.m7934a(str);
        C2842d c2842d = new C2842d();
        m10044p().m9610x();
        try {
            cl b = m10044p().m9589b(str);
            byte[] bArr;
            if (b == null) {
                m10034f().m9785C().m9775a("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (b.m9430n()) {
                long j;
                C2843e c2843e = new C2843e();
                c2842d.f8771a = new C2843e[]{c2843e};
                c2843e.f8781a = Integer.valueOf(1);
                c2843e.f8789i = "android";
                c2843e.f8795o = b.m9399b();
                c2843e.f8794n = b.m9423k();
                c2843e.f8796p = b.m9419i();
                c2843e.f8775C = Integer.valueOf((int) b.m9421j());
                c2843e.f8797q = Long.valueOf(b.m9425l());
                c2843e.f8805y = b.m9405d();
                c2843e.f8802v = Long.valueOf(b.m9427m());
                Pair a = m10032e().m9875a(b.m9399b());
                if (!TextUtils.isEmpty((CharSequence) a.first)) {
                    c2843e.f8799s = (String) a.first;
                    c2843e.f8800t = (Boolean) a.second;
                }
                c2843e.f8791k = m10051w().m9646x();
                c2843e.f8790j = m10051w().m9647y();
                c2843e.f8793m = Integer.valueOf((int) m10051w().m9648z());
                c2843e.f8792l = m10051w().m9621A();
                c2843e.f8801u = b.m9402c();
                c2843e.f8774B = b.m9411f();
                List a2 = m10044p().m9567a(b.m9399b());
                c2843e.f8783c = new C2845g[a2.size()];
                for (int i = 0; i < a2.size(); i++) {
                    C2845g c2845g = new C2845g();
                    c2843e.f8783c[i] = c2845g;
                    c2845g.f8811b = ((dx) a2.get(i)).f8703c;
                    c2845g.f8810a = Long.valueOf(((dx) a2.get(i)).f8704d);
                    m10043o().m10398a(c2845g, ((dx) a2.get(i)).f8705e);
                }
                Bundle b2 = com_google_android_gms_internal_zzatq.f11827b.m15353b();
                if ("_iap".equals(com_google_android_gms_internal_zzatq.f11826a)) {
                    b2.putLong("_c", 1);
                    m10034f().m9785C().m9774a("Marking in-app purchase as real-time");
                    b2.putLong("_r", 1);
                }
                b2.putString("_o", com_google_android_gms_internal_zzatq.f11828c);
                if (m10043o().m10441m(c2843e.f8795o)) {
                    m10043o().m10396a(b2, "_dbg", Long.valueOf(1));
                    m10043o().m10396a(b2, "_r", Long.valueOf(1));
                }
                cu a3 = m10044p().m9566a(str, com_google_android_gms_internal_zzatq.f11826a);
                if (a3 == null) {
                    m10044p().m9577a(new cu(str, com_google_android_gms_internal_zzatq.f11826a, 1, 0, com_google_android_gms_internal_zzatq.f11829d));
                    j = 0;
                } else {
                    j = a3.f8292e;
                    m10044p().m9577a(a3.m9652a(com_google_android_gms_internal_zzatq.f11829d).m9651a());
                }
                ct ctVar = new ct(this, com_google_android_gms_internal_zzatq.f11828c, str, com_google_android_gms_internal_zzatq.f11826a, com_google_android_gms_internal_zzatq.f11829d, j, b2);
                C2840b c2840b = new C2840b();
                c2843e.f8782b = new C2840b[]{c2840b};
                c2840b.f8762c = Long.valueOf(ctVar.f8285d);
                c2840b.f8761b = ctVar.f8283b;
                c2840b.f8763d = Long.valueOf(ctVar.f8286e);
                c2840b.f8760a = new C2841c[ctVar.f8287f.m15351a()];
                Iterator it = ctVar.f8287f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    C2841c c2841c = new C2841c();
                    int i3 = i2 + 1;
                    c2840b.f8760a[i2] = c2841c;
                    c2841c.f8766a = str2;
                    m10043o().m10397a(c2841c, ctVar.f8287f.m15352a(str2));
                    i2 = i3;
                }
                c2843e.f8773A = m9980a(b.m9399b(), c2843e.f8783c, c2843e.f8782b);
                c2843e.f8785e = c2840b.f8762c;
                c2843e.f8786f = c2840b.f8762c;
                long h = b.m9417h();
                c2843e.f8788h = h != 0 ? Long.valueOf(h) : null;
                long g = b.m9414g();
                if (g != 0) {
                    h = g;
                }
                c2843e.f8787g = h != 0 ? Long.valueOf(h) : null;
                b.m9435r();
                c2843e.f8803w = Integer.valueOf((int) b.m9431o());
                c2843e.f8798r = Long.valueOf(m10030d().m9489V());
                c2843e.f8784d = Long.valueOf(m10048t().mo3360a());
                c2843e.f8806z = Boolean.TRUE;
                b.m9396a(c2843e.f8785e.longValue());
                b.m9400b(c2843e.f8786f.longValue());
                m10044p().m9576a(b);
                m10044p().m9611y();
                m10044p().m9612z();
                try {
                    bArr = new byte[c2842d.m9131g()];
                    lu a4 = lu.m12365a(bArr);
                    c2842d.mo3506a(a4);
                    a4.m12409b();
                    return m10043o().m10411a(bArr);
                } catch (IOException e) {
                    m10034f().m9815x().m9776a("Data loss. Failed to bundle and serialize. appId", dc.m9779a(str), e);
                    return null;
                }
            } else {
                m10034f().m9785C().m9775a("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                m10044p().m9612z();
                return bArr;
            }
        } finally {
            m10044p().m9612z();
        }
    }

    @WorkerThread
    protected void m10028c() {
        m9985C();
        m10044p().m9557E();
        if (m10032e().f8406c.m9858a() == 0) {
            m10032e().f8406c.m9859a(m10048t().mo3360a());
        }
        if (m10026b()) {
            m10030d().m9490W();
            if (!TextUtils.isEmpty(m10052x().m9733y())) {
                String B = m10032e().m9870B();
                if (B == null) {
                    m10032e().m9880c(m10052x().m9733y());
                } else if (!B.equals(m10052x().m9733y())) {
                    m10034f().m9784B().m9774a("Rechecking which service to use due to a GMP App Id change");
                    m10032e().m9873E();
                    this.f8493r.m10238C();
                    this.f8493r.m10236A();
                    m10032e().m9880c(m10052x().m9733y());
                }
            }
            m10030d().m9490W();
            if (!TextUtils.isEmpty(m10052x().m9733y())) {
                m10040l().m10173z();
            }
        } else if (m9989G()) {
            if (!m10043o().m10438k("android.permission.INTERNET")) {
                m10034f().m9815x().m9774a("App is missing INTERNET permission");
            }
            if (!m10043o().m10438k("android.permission.ACCESS_NETWORK_STATE")) {
                m10034f().m9815x().m9774a("App is missing ACCESS_NETWORK_STATE permission");
            }
            m10030d().m9490W();
            if (!bm.m9120b(m10047s()).m9115a()) {
                if (!dh.m9887a(m10047s(), false)) {
                    m10034f().m9815x().m9774a("AppMeasurementReceiver not registered/enabled");
                }
                if (!ds.m10278a(m10047s(), false)) {
                    m10034f().m9815x().m9774a("AppMeasurementService not registered/enabled");
                }
            }
            m10034f().m9815x().m9774a("Uploading is not possible. App measurement disabled");
        }
        m9974R();
    }

    @WorkerThread
    void m10029c(zzatd com_google_android_gms_internal_zzatd, long j) {
        m9985C();
        m10001a();
        cl b = m10044p().m9589b(com_google_android_gms_internal_zzatd.f11797a);
        if (!(b == null || !TextUtils.isEmpty(b.m9405d()) || com_google_android_gms_internal_zzatd == null || TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b))) {
            b.m9415g(0);
            m10044p().m9576a(b);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        bundle.putLong("_r", 1);
        bundle.putLong("_uwa", 0);
        bundle.putLong("_pfo", 0);
        bundle.putLong("_sys", 0);
        bundle.putLong("_sysu", 0);
        if (m10047s().getPackageManager() == null) {
            m10034f().m9815x().m9775a("PackageManager is null, first open report might be inaccurate. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a));
        } else {
            PackageInfo b2;
            ApplicationInfo a;
            try {
                b2 = bm.m9120b(m10047s()).m9118b(com_google_android_gms_internal_zzatd.f11797a, 0);
            } catch (NameNotFoundException e) {
                m10034f().m9815x().m9776a("Package info is null, first open report might be inaccurate. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), e);
                b2 = null;
            }
            if (!(b2 == null || b2.firstInstallTime == 0 || b2.firstInstallTime == b2.lastUpdateTime)) {
                bundle.putLong("_uwa", 1);
            }
            try {
                a = bm.m9120b(m10047s()).m9114a(com_google_android_gms_internal_zzatd.f11797a, 0);
            } catch (NameNotFoundException e2) {
                m10034f().m9815x().m9776a("Application info is null, first open report might be inaccurate. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), e2);
                a = null;
            }
            if (a != null) {
                if ((a.flags & 1) != 0) {
                    bundle.putLong("_sys", 1);
                }
                if ((a.flags & 128) != 0) {
                    bundle.putLong("_sysu", 1);
                }
            }
        }
        long h = m10044p().m9606h(com_google_android_gms_internal_zzatd.f11797a);
        if (h >= 0) {
            bundle.putLong("_pfo", h);
        }
        m10010a(new zzatq("_f", new zzato(bundle), "auto", j), com_google_android_gms_internal_zzatd);
    }

    public cp m10030d() {
        return this.f8479d;
    }

    @WorkerThread
    void m10031d(zzatd com_google_android_gms_internal_zzatd, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        m10010a(new zzatq("_e", new zzato(bundle), "auto", j), com_google_android_gms_internal_zzatd);
    }

    public dg m10032e() {
        m9977a(this.f8480e);
        return this.f8480e;
    }

    @WorkerThread
    void m10033e(zzatd com_google_android_gms_internal_zzatd, long j) {
        m10010a(new zzatq("_cd", new zzato(new Bundle()), "auto", j), com_google_android_gms_internal_zzatd);
    }

    public dc m10034f() {
        m9981b(this.f8481f);
        return this.f8481f;
    }

    public dc m10035g() {
        return (this.f8481f == null || !this.f8481f.m9447Q()) ? null : this.f8481f;
    }

    public dj m10036h() {
        m9981b(this.f8482g);
        return this.f8482g;
    }

    public dt m10037i() {
        m9981b(this.f8483h);
        return this.f8483h;
    }

    public di m10038j() {
        m9981b(this.f8484i);
        return this.f8484i;
    }

    dj m10039k() {
        return this.f8482g;
    }

    public dp m10040l() {
        m9981b(this.f8495t);
        return this.f8495t;
    }

    public AppMeasurement m10041m() {
        return this.f8485j;
    }

    public FirebaseAnalytics m10042n() {
        return this.f8486k;
    }

    public dy m10043o() {
        m9977a(this.f8487l);
        return this.f8487l;
    }

    public cq m10044p() {
        m9981b(this.f8488m);
        return this.f8488m;
    }

    public da m10045q() {
        m9981b(this.f8489n);
        return this.f8489n;
    }

    public dd m10046r() {
        m9981b(this.f8490o);
        return this.f8490o;
    }

    public Context m10047s() {
        return this.f8478c;
    }

    public C2580e m10048t() {
        return this.f8491p;
    }

    public dq m10049u() {
        m9981b(this.f8492q);
        return this.f8492q;
    }

    public dr m10050v() {
        m9981b(this.f8493r);
        return this.f8493r;
    }

    public cs m10051w() {
        m9981b(this.f8494s);
        return this.f8494s;
    }

    public cz m10052x() {
        m9981b(this.f8496u);
        return this.f8496u;
    }

    public de m10053y() {
        if (this.f8497v != null) {
            return this.f8497v;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public dv m10054z() {
        m9981b(this.f8498w);
        return this.f8498w;
    }
}
