package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ib implements hd {
    static final /* synthetic */ boolean f9392b = (!ib.class.desiredAssertionStatus());
    private static ib f9393c = new ib();
    final HashMap<hc, List<hc>> f9394a = new HashMap();

    private ib() {
    }

    public static ib m11642a() {
        return f9393c;
    }

    private void m11643d(hc hcVar) {
        int i = 0;
        synchronized (this.f9394a) {
            List list = (List) this.f9394a.get(hcVar);
            int i2;
            if (list != null) {
                int i3;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (list.get(i4) == hcVar) {
                        i3 = 1;
                        list.remove(i4);
                        break;
                    }
                }
                i3 = 0;
                if (list.isEmpty()) {
                    this.f9394a.remove(hcVar);
                }
                i2 = i3;
            } else {
                i2 = 0;
            }
            if (!f9392b && r0 == 0 && hcVar.m11344d()) {
                throw new AssertionError();
            }
            if (!hcVar.mo3728a().m11872d()) {
                hc a = hcVar.mo3726a(je.m11867a(hcVar.mo3728a().m11869a()));
                list = (List) this.f9394a.get(a);
                if (list != null) {
                    while (i < list.size()) {
                        if (list.get(i) == hcVar) {
                            list.remove(i);
                            break;
                        }
                        i++;
                    }
                    if (list.isEmpty()) {
                        this.f9394a.remove(a);
                    }
                }
            }
        }
    }

    public void mo3734a(hc hcVar) {
        m11643d(hcVar);
    }

    public void m11645b(hc hcVar) {
        synchronized (this.f9394a) {
            List list = (List) this.f9394a.get(hcVar);
            if (list == null) {
                list = new ArrayList();
                this.f9394a.put(hcVar, list);
            }
            list.add(hcVar);
            if (!hcVar.mo3728a().m11872d()) {
                hc a = hcVar.mo3726a(je.m11867a(hcVar.mo3728a().m11869a()));
                list = (List) this.f9394a.get(a);
                if (list == null) {
                    list = new ArrayList();
                    this.f9394a.put(a, list);
                }
                list.add(hcVar);
            }
            hcVar.m11339a(true);
            hcVar.m11336a((hd) this);
        }
    }

    public void m11646c(hc hcVar) {
        synchronized (this.f9394a) {
            List list = (List) this.f9394a.get(hcVar);
            if (!(list == null || list.isEmpty())) {
                if (hcVar.mo3728a().m11872d()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        hc hcVar2 = (hc) list.get(size);
                        if (!hashSet.contains(hcVar2.mo3728a())) {
                            hashSet.add(hcVar2.mo3728a());
                            hcVar2.m11342b();
                        }
                    }
                } else {
                    ((hc) list.get(0)).m11342b();
                }
            }
        }
    }
}
