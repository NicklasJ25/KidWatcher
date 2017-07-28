package com.google.android.gms.internal;

import java.util.Iterator;

public interface kf extends Comparable<kf>, Iterable<ke> {
    public static final jt f9552d = new C30241();

    class C30241 extends jt {
        C30241() {
        }

        public int mo3794a(kf kfVar) {
            return kfVar == this ? 0 : 1;
        }

        public boolean mo3776a(js jsVar) {
            return false;
        }

        public boolean mo3778b() {
            return false;
        }

        public kf mo3780c(js jsVar) {
            return jsVar.m12011e() ? mo3783f() : jx.m12080j();
        }

        public /* synthetic */ int compareTo(Object obj) {
            return mo3794a((kf) obj);
        }

        public boolean equals(Object obj) {
            return obj == this;
        }

        public kf mo3783f() {
            return this;
        }

        public String toString() {
            return "<Max Node>";
        }
    }

    public enum C3025a {
        V1,
        V2
    }

    kf mo3772a(hh hhVar);

    kf mo3773a(hh hhVar, kf kfVar);

    kf mo3774a(js jsVar, kf kfVar);

    Object mo3786a();

    Object mo3775a(boolean z);

    String mo3787a(C3025a c3025a);

    boolean mo3776a(js jsVar);

    js mo3777b(js jsVar);

    kf mo3788b(kf kfVar);

    boolean mo3778b();

    int mo3779c();

    kf mo3780c(js jsVar);

    String mo3781d();

    boolean mo3782e();

    kf mo3783f();

    Iterator<ke> mo3784i();
}
