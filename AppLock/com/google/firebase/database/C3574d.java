package com.google.firebase.database;

import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.lh;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.lj;
import com.google.android.gms.p004b.C2428e;
import java.net.URLEncoder;

public class C3574d extends C3573j {

    public interface C3041a {
        void mo3818a(C3536b c3536b, C3574d c3574d);
    }

    C3574d(hj hjVar, hh hhVar) {
        super(hjVar, hhVar);
    }

    private C2428e<Void> m15578a(Object obj, kf kfVar, C3041a c3041a) {
        li.m12300a(m15576c());
        hw.m11596a(m15576c(), obj);
        Object a = lj.m12319a(obj);
        li.m12301a(a);
        final kf a2 = kg.m12178a(a, kfVar);
        final lf a3 = lh.m12292a(c3041a);
        this.a.m11475a(new Runnable(this) {
            final /* synthetic */ C3574d f12189c;

            public void run() {
                this.f12189c.a.m11472a(this.f12189c.m15576c(), a2, (C3041a) a3.m12287b());
            }
        });
        return (C2428e) a3.m12286a();
    }

    public C2428e<Void> m15579a(Object obj) {
        return m15578a(obj, kj.m12191a(null), null);
    }

    public C3574d m15580a() {
        hh f = m15576c().m11389f();
        return f != null ? new C3574d(this.a, f) : null;
    }

    public C3574d m15581a(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (m15576c().m11391h()) {
            li.m12303b(str);
        } else {
            li.m12302a(str);
        }
        return new C3574d(this.a, m15576c().m11381a(new hh(str)));
    }

    public String m15582b() {
        return m15576c().m11391h() ? null : m15576c().m11390g().m12010d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3574d) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        C3574d a = m15580a();
        if (a == null) {
            return this.a.toString();
        }
        String valueOf;
        try {
            valueOf = String.valueOf(a.toString());
            String valueOf2 = String.valueOf(URLEncoder.encode(m15582b(), "UTF-8").replace("+", "%20"));
            return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("/").append(valueOf2).toString();
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Failed to URLEncode key: ";
            valueOf = String.valueOf(m15582b());
            throw new C3537c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }
}
