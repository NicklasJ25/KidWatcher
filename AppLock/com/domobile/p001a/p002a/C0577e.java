package com.domobile.p001a.p002a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C0577e {
    Map<String, C0580h> f375a = new HashMap();
    Map<String, C0578f> f376b = new HashMap();

    C0577e() {
    }

    public C0580h m528a(String str) {
        return (C0580h) this.f375a.get(str);
    }

    void m529a(C0578f c0578f) {
        this.f376b.put(c0578f.m535b(), c0578f);
    }

    void m530a(C0580h c0580h) {
        this.f375a.put(c0580h.m541b(), c0580h);
    }

    public C0578f m531b(String str) {
        return (C0578f) this.f376b.get(str);
    }

    public boolean m532c(String str) {
        return this.f376b.containsKey(str);
    }

    List<String> m533d(String str) {
        List<String> arrayList = new ArrayList();
        for (C0578f c0578f : this.f376b.values()) {
            if (c0578f.m534a().equals(str)) {
                arrayList.add(c0578f.m535b());
            }
        }
        return arrayList;
    }
}
