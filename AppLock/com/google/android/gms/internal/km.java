package com.google.android.gms.internal;

public class km extends jy {
    private static final km f9637a = new km();

    private km() {
    }

    public static km m12201d() {
        return f9637a;
    }

    public int m12202a(ke keVar, ke keVar2) {
        int compareTo = keVar.m12170d().compareTo(keVar2.m12170d());
        return compareTo == 0 ? keVar.m12169c().m12009a(keVar2.m12169c()) : compareTo;
    }

    public ke mo3809a(js jsVar, kf kfVar) {
        return new ke(jsVar, kfVar);
    }

    public boolean mo3810a(kf kfVar) {
        return true;
    }

    public ke mo3811b() {
        return new ke(js.m12006b(), kf.f9552d);
    }

    public String mo3812c() {
        return ".value";
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12202a((ke) obj, (ke) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof km;
    }

    public int hashCode() {
        return 4;
    }

    public String toString() {
        return "ValueIndex";
    }
}
