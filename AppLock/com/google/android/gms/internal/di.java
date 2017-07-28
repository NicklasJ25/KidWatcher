package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.internal.ea.C2836a;
import com.google.android.gms.internal.ea.C2837b;
import com.google.android.gms.internal.ea.C2838c;
import com.google.android.gms.measurement.AppMeasurement.C3517a;
import java.io.IOException;
import java.util.Map;

public class di extends dn {
    private final Map<String, Map<String, String>> f8431a = new ArrayMap();
    private final Map<String, Map<String, Boolean>> f8432b = new ArrayMap();
    private final Map<String, Map<String, Boolean>> f8433c = new ArrayMap();
    private final Map<String, C2837b> f8434d = new ArrayMap();
    private final Map<String, String> f8435e = new ArrayMap();

    di(dk dkVar) {
        super(dkVar);
    }

    @WorkerThread
    private C2837b m9889a(String str, byte[] bArr) {
        if (bArr == null) {
            return new C2837b();
        }
        lt a = lt.m12332a(bArr);
        C2837b c2837b = new C2837b();
        try {
            c2837b.mo3509b(a);
            mo3548u().m9786D().m9776a("Parsed config. version, gmp_app_id", c2837b.f8745a, c2837b.f8746b);
            return c2837b;
        } catch (IOException e) {
            mo3548u().m9817z().m9776a("Unable to merge remote config. appId", dc.m9779a(str), e);
            return null;
        }
    }

    private Map<String, String> m9890a(C2837b c2837b) {
        Map<String, String> arrayMap = new ArrayMap();
        if (!(c2837b == null || c2837b.f8748d == null)) {
            for (C2838c c2838c : c2837b.f8748d) {
                if (c2838c != null) {
                    arrayMap.put(c2838c.f8752a, c2838c.f8753b);
                }
            }
        }
        return arrayMap;
    }

    private void m9891a(String str, C2837b c2837b) {
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        if (!(c2837b == null || c2837b.f8749e == null)) {
            for (C2836a c2836a : c2837b.f8749e) {
                if (c2836a != null) {
                    String str2 = (String) C3517a.f12109a.get(c2836a.f8742a);
                    if (str2 != null) {
                        c2836a.f8742a = str2;
                    }
                    arrayMap.put(c2836a.f8742a, c2836a.f8743b);
                    arrayMap2.put(c2836a.f8742a, c2836a.f8744c);
                }
            }
        }
        this.f8432b.put(str, arrayMap);
        this.f8433c.put(str, arrayMap2);
    }

    @WorkerThread
    private void m9892d(String str) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        if (this.f8434d.get(str) == null) {
            byte[] d = mo3543p().m9599d(str);
            if (d == null) {
                this.f8431a.put(str, null);
                this.f8432b.put(str, null);
                this.f8433c.put(str, null);
                this.f8434d.put(str, null);
                this.f8435e.put(str, null);
                return;
            }
            C2837b a = m9889a(str, d);
            this.f8431a.put(str, m9890a(a));
            m9891a(str, a);
            this.f8434d.put(str, a);
            this.f8435e.put(str, null);
        }
    }

    @WorkerThread
    protected C2837b m9893a(String str) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        m9892d(str);
        return (C2837b) this.f8434d.get(str);
    }

    @WorkerThread
    String m9894a(String str, String str2) {
        mo3532e();
        m9892d(str);
        Map map = (Map) this.f8431a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected void mo3551a() {
    }

    @WorkerThread
    protected boolean m9896a(String str, byte[] bArr, String str2) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2837b a = m9889a(str, bArr);
        if (a == null) {
            return false;
        }
        m9891a(str, a);
        this.f8434d.put(str, a);
        this.f8435e.put(str, str2);
        this.f8431a.put(str, m9890a(a));
        mo3534g().m9463a(str, a.f8750f);
        try {
            a.f8750f = null;
            byte[] bArr2 = new byte[a.m9131g()];
            a.mo3506a(lu.m12365a(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            mo3548u().m9817z().m9776a("Unable to serialize reduced-size config. Storing full config instead. appId", dc.m9779a(str), e);
        }
        mo3543p().m9581a(str, bArr);
        return true;
    }

    @WorkerThread
    protected String m9897b(String str) {
        mo3532e();
        return (String) this.f8435e.get(str);
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    @WorkerThread
    boolean m9899b(String str, String str2) {
        mo3532e();
        m9892d(str);
        if (mo3544q().m10444o(str) && dy.m10382l(str2)) {
            return true;
        }
        if (mo3544q().m10446p(str) && dy.m10374a(str2)) {
            return true;
        }
        Map map = (Map) this.f8432b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    @WorkerThread
    protected void m9901c(String str) {
        mo3532e();
        this.f8435e.put(str, null);
    }

    @WorkerThread
    boolean m9902c(String str, String str2) {
        mo3532e();
        m9892d(str);
        Map map = (Map) this.f8433c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
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
}
