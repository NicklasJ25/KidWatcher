package com.google.android.gms.internal;

import java.util.Comparator;

public abstract class jy implements Comparator<ke> {
    public static jy m12099a(String str) {
        if (str.equals(".value")) {
            return km.m12201d();
        }
        if (str.equals(".key")) {
            return ka.m12154d();
        }
        if (!str.equals(".priority")) {
            return new kh(new hh(str));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }

    public int m12100a(ke keVar, ke keVar2, boolean z) {
        return z ? compare(keVar2, keVar) : compare(keVar, keVar2);
    }

    public ke m12101a() {
        return ke.m12167a();
    }

    public abstract ke mo3809a(js jsVar, kf kfVar);

    public abstract boolean mo3810a(kf kfVar);

    public boolean m12104a(kf kfVar, kf kfVar2) {
        return compare(new ke(js.m12004a(), kfVar), new ke(js.m12004a(), kfVar2)) != 0;
    }

    public abstract ke mo3811b();

    public abstract String mo3812c();
}
