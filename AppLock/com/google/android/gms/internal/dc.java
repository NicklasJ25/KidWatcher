package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.measurement.AppMeasurement;

public class dc extends dn {
    private final String f8359a = mo3550w().m9496a();
    private final char f8360b;
    private final long f8361c = mo3550w().m9489V();
    private final C2759a f8362d;
    private final C2759a f8363e;
    private final C2759a f8364f;
    private final C2759a f8365g;
    private final C2759a f8366h;
    private final C2759a f8367i;
    private final C2759a f8368j;
    private final C2759a f8369k;
    private final C2759a f8370l;

    public class C2759a {
        final /* synthetic */ dc f8354a;
        private final int f8355b;
        private final boolean f8356c;
        private final boolean f8357d;

        C2759a(dc dcVar, int i, boolean z, boolean z2) {
            this.f8354a = dcVar;
            this.f8355b = i;
            this.f8356c = z;
            this.f8357d = z2;
        }

        public void m9774a(String str) {
            this.f8354a.m9791a(this.f8355b, this.f8356c, this.f8357d, str, null, null, null);
        }

        public void m9775a(String str, Object obj) {
            this.f8354a.m9791a(this.f8355b, this.f8356c, this.f8357d, str, obj, null, null);
        }

        public void m9776a(String str, Object obj, Object obj2) {
            this.f8354a.m9791a(this.f8355b, this.f8356c, this.f8357d, str, obj, obj2, null);
        }

        public void m9777a(String str, Object obj, Object obj2, Object obj3) {
            this.f8354a.m9791a(this.f8355b, this.f8356c, this.f8357d, str, obj, obj2, obj3);
        }
    }

    private static class C2760b {
        private final String f8358a;

        public C2760b(@NonNull String str) {
            this.f8358a = str;
        }
    }

    dc(dk dkVar) {
        super(dkVar);
        if (mo3550w().m9491X()) {
            mo3550w().m9490W();
            this.f8360b = 'C';
        } else {
            mo3550w().m9490W();
            this.f8360b = 'c';
        }
        this.f8362d = new C2759a(this, 6, false, false);
        this.f8363e = new C2759a(this, 6, true, false);
        this.f8364f = new C2759a(this, 6, false, true);
        this.f8365g = new C2759a(this, 5, false, false);
        this.f8366h = new C2759a(this, 5, true, false);
        this.f8367i = new C2759a(this, 5, false, true);
        this.f8368j = new C2759a(this, 4, false, false);
        this.f8369k = new C2759a(this, 3, false, false);
        this.f8370l = new C2759a(this, 2, false, false);
    }

    protected static Object m9779a(String str) {
        return str == null ? null : new C2760b(str);
    }

    static String m9780a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return valueOf instanceof C2760b ? ((C2760b) valueOf).f8358a : z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String b = m9782b(AppMeasurement.class.getCanonicalName());
                String b2 = m9782b(dk.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m9782b(className);
                            if (className.equals(b) || className.equals(b2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String m9781a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = m9780a(z, obj);
        Object a2 = m9780a(z, obj2);
        Object a3 = m9780a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    private static String m9782b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public C2759a m9783A() {
        return this.f8367i;
    }

    public C2759a m9784B() {
        return this.f8368j;
    }

    public C2759a m9785C() {
        return this.f8369k;
    }

    public C2759a m9786D() {
        return this.f8370l;
    }

    public String m9787E() {
        Pair a = mo3549v().f8405b.m9863a();
        if (a == null || a == dg.f8404a) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(a.second));
        String str = (String) a.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    protected void mo3551a() {
    }

    protected void m9789a(int i, String str) {
        Log.println(i, this.f8359a, str);
    }

    public void m9790a(int i, String str, Object obj, Object obj2, Object obj3) {
        C2513c.m7932a((Object) str);
        dj k = this.n.m10039k();
        if (k == null) {
            m9789a(6, "Scheduler not set. Not logging error/warn");
        } else if (k.m9447Q()) {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf(GpsMeasureMode.MODE_2_DIMENSIONAL);
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.f8360b;
            long j = this.f8361c;
            String valueOf2 = String.valueOf(m9781a(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > 1024) {
                valueOf = str.substring(0, 1024);
            }
            k.m9938a(new Runnable(this) {
                final /* synthetic */ dc f8353b;

                public void run() {
                    dg e = this.f8353b.n.m10032e();
                    if (e.m9447Q()) {
                        e.f8405b.m9864a(valueOf);
                    } else {
                        this.f8353b.m9789a(6, "Persisted config not initialized. Not logging error/warn");
                    }
                }
            });
        } else {
            m9789a(6, "Scheduler not initialized. Not logging error/warn");
        }
    }

    protected void m9791a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m9792a(i)) {
            m9789a(i, m9781a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            m9790a(i, str, obj, obj2, obj3);
        }
    }

    protected boolean m9792a(int i) {
        return Log.isLoggable(this.f8359a, i);
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    public C2759a m9815x() {
        return this.f8362d;
    }

    public C2759a m9816y() {
        return this.f8363e;
    }

    public C2759a m9817z() {
        return this.f8365g;
    }
}
