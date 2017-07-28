package com.google.android.gms.internal;

public class ki extends jy {
    private static final ki f9630a = new ki();

    private ki() {
    }

    public static ki m12184d() {
        return f9630a;
    }

    public int m12185a(ke keVar, ke keVar2) {
        return kg.m12176a(keVar.m12169c(), keVar.m12170d().mo3783f(), keVar2.m12169c(), keVar2.m12170d().mo3783f());
    }

    public ke mo3809a(js jsVar, kf kfVar) {
        return new ke(jsVar, new kl("[PRIORITY-POST]", kfVar));
    }

    public boolean mo3810a(kf kfVar) {
        return !kfVar.mo3783f().mo3778b();
    }

    public ke mo3811b() {
        return mo3809a(js.m12006b(), kf.f9552d);
    }

    public String mo3812c() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12185a((ke) obj, (ke) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof ki;
    }

    public int hashCode() {
        return 3155577;
    }

    public String toString() {
        return "PriorityIndex";
    }
}
