package com.google.android.gms.internal;

import com.google.android.gms.internal.kf.C3025a;
import java.util.Collections;
import java.util.Iterator;

public class jx extends jt implements kf {
    private static final jx f9589c = new jx();

    private jx() {
    }

    public static jx m12080j() {
        return f9589c;
    }

    public int mo3794a(kf kfVar) {
        return kfVar.mo3778b() ? 0 : -1;
    }

    public kf mo3772a(hh hhVar) {
        return this;
    }

    public kf mo3773a(hh hhVar, kf kfVar) {
        if (hhVar.m11391h()) {
            return kfVar;
        }
        js d = hhVar.m11387d();
        return mo3774a(d, mo3780c(d).mo3773a(hhVar.m11388e(), kfVar));
    }

    public kf mo3774a(js jsVar, kf kfVar) {
        return (kfVar.mo3778b() || jsVar.m12011e()) ? this : new jt().mo3774a(jsVar, kfVar);
    }

    public Object mo3786a() {
        return null;
    }

    public Object mo3775a(boolean z) {
        return null;
    }

    public String mo3787a(C3025a c3025a) {
        return "";
    }

    public boolean mo3776a(js jsVar) {
        return false;
    }

    public js mo3777b(js jsVar) {
        return null;
    }

    public /* synthetic */ kf mo3788b(kf kfVar) {
        return m12093c(kfVar);
    }

    public boolean mo3778b() {
        return true;
    }

    public int mo3779c() {
        return 0;
    }

    public jx m12093c(kf kfVar) {
        return this;
    }

    public kf mo3780c(js jsVar) {
        return this;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return mo3794a((kf) obj);
    }

    public String mo3781d() {
        return "";
    }

    public boolean mo3782e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof jx) {
            return true;
        }
        boolean z = (obj instanceof kf) && ((kf) obj).mo3778b() && mo3783f().equals(((kf) obj).mo3783f());
        return z;
    }

    public kf mo3783f() {
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public Iterator<ke> mo3784i() {
        return Collections.emptyList().iterator();
    }

    public Iterator<ke> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        return "<Empty Node>";
    }
}
