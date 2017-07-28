package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@wh
public class py {
    private final Collection<pw> f10246a = new ArrayList();
    private final Collection<pw<String>> f10247b = new ArrayList();
    private final Collection<pw<String>> f10248c = new ArrayList();

    public List<String> m13236a() {
        List<String> arrayList = new ArrayList();
        for (pw c : this.f10247b) {
            String str = (String) c.m13225c();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void m13237a(pw pwVar) {
        this.f10246a.add(pwVar);
    }

    public List<String> m13238b() {
        List<String> a = m13236a();
        for (pw c : this.f10248c) {
            String str = (String) c.m13225c();
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }

    public void m13239b(pw<String> pwVar) {
        this.f10247b.add(pwVar);
    }

    public void m13240c(pw<String> pwVar) {
        this.f10248c.add(pwVar);
    }
}
