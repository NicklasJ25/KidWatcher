package com.google.android.gms.internal;

public class ka extends jy {
    static final /* synthetic */ boolean f9611a = (!ka.class.desiredAssertionStatus());
    private static final ka f9612b = new ka();

    private ka() {
    }

    public static ka m12154d() {
        return f9612b;
    }

    public int m12155a(ke keVar, ke keVar2) {
        return keVar.m12169c().m12009a(keVar2.m12169c());
    }

    public ke mo3809a(js jsVar, kf kfVar) {
        if (f9611a || (kfVar instanceof kl)) {
            return new ke(js.m12005a((String) kfVar.mo3786a()), jx.m12080j());
        }
        throw new AssertionError();
    }

    public boolean mo3810a(kf kfVar) {
        return true;
    }

    public ke mo3811b() {
        return ke.m12168b();
    }

    public String mo3812c() {
        return ".key";
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12155a((ke) obj, (ke) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof ka;
    }

    public int hashCode() {
        return 37;
    }

    public String toString() {
        return "KeyIndex";
    }
}
