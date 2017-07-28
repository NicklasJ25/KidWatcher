package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class jz implements Iterable<ke> {
    private static final ga<ke> f9590a = new ga(Collections.emptyList(), null);
    private final kf f9591b;
    private ga<ke> f9592c;
    private final jy f9593d;

    private jz(kf kfVar, jy jyVar) {
        this.f9593d = jyVar;
        this.f9591b = kfVar;
        this.f9592c = null;
    }

    private jz(kf kfVar, jy jyVar, ga<ke> gaVar) {
        this.f9593d = jyVar;
        this.f9591b = kfVar;
        this.f9592c = gaVar;
    }

    public static jz m12107a(kf kfVar) {
        return new jz(kfVar, ki.m12184d());
    }

    public static jz m12108a(kf kfVar, jy jyVar) {
        return new jz(kfVar, jyVar);
    }

    private void m12109e() {
        if (this.f9592c != null) {
            return;
        }
        if (this.f9593d.equals(ka.m12154d())) {
            this.f9592c = f9590a;
            return;
        }
        List arrayList = new ArrayList();
        Object obj = null;
        for (ke keVar : this.f9591b) {
            obj = (obj != null || this.f9593d.mo3810a(keVar.m12170d())) ? 1 : null;
            arrayList.add(new ke(keVar.m12169c(), keVar.m12170d()));
        }
        if (obj != null) {
            this.f9592c = new ga(arrayList, this.f9593d);
        } else {
            this.f9592c = f9590a;
        }
    }

    public js m12110a(js jsVar, kf kfVar, jy jyVar) {
        if (this.f9593d.equals(ka.m12154d()) || this.f9593d.equals(jyVar)) {
            m12109e();
            if (this.f9592c == f9590a) {
                return this.f9591b.mo3777b(jsVar);
            }
            ke keVar = (ke) this.f9592c.m10957c(new ke(jsVar, kfVar));
            return keVar != null ? keVar.m12169c() : null;
        } else {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
    }

    public jz m12111a(js jsVar, kf kfVar) {
        kf a = this.f9591b.mo3774a(jsVar, kfVar);
        if (this.f9592c == f9590a && !this.f9593d.mo3810a(kfVar)) {
            return new jz(a, this.f9593d, f9590a);
        }
        if (this.f9592c == null || this.f9592c == f9590a) {
            return new jz(a, this.f9593d, null);
        }
        ga a2 = this.f9592c.m10953a(new ke(jsVar, this.f9591b.mo3780c(jsVar)));
        if (!kfVar.mo3778b()) {
            a2 = a2.m10955b(new ke(jsVar, kfVar));
        }
        return new jz(a, this.f9593d, a2);
    }

    public kf m12112a() {
        return this.f9591b;
    }

    public boolean m12113a(jy jyVar) {
        return this.f9593d.equals(jyVar);
    }

    public jz m12114b(kf kfVar) {
        return new jz(this.f9591b.mo3788b(kfVar), this.f9593d, this.f9592c);
    }

    public Iterator<ke> m12115b() {
        m12109e();
        return this.f9592c == f9590a ? this.f9591b.mo3784i() : this.f9592c.m10958c();
    }

    public ke m12116c() {
        if (!(this.f9591b instanceof jt)) {
            return null;
        }
        m12109e();
        if (this.f9592c != f9590a) {
            return (ke) this.f9592c.m10954a();
        }
        js g = ((jt) this.f9591b).m12040g();
        return new ke(g, this.f9591b.mo3780c(g));
    }

    public ke m12117d() {
        if (!(this.f9591b instanceof jt)) {
            return null;
        }
        m12109e();
        if (this.f9592c != f9590a) {
            return (ke) this.f9592c.m10956b();
        }
        js h = ((jt) this.f9591b).m12041h();
        return new ke(h, this.f9591b.mo3780c(h));
    }

    public Iterator<ke> iterator() {
        m12109e();
        return this.f9592c == f9590a ? this.f9591b.iterator() : this.f9592c.iterator();
    }
}
