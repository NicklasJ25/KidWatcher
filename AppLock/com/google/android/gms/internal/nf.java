package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@wh
public class nf {
    private final Object f9977a = new Object();
    private int f9978b;
    private List<ne> f9979c = new LinkedList();

    @Nullable
    public ne m12766a() {
        ne neVar = null;
        int i = 0;
        synchronized (this.f9977a) {
            if (this.f9979c.size() == 0) {
                aad.m8421b("Queue empty");
                return null;
            } else if (this.f9979c.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (ne neVar2 : this.f9979c) {
                    ne neVar3;
                    int i4;
                    int i5 = neVar2.m12764i();
                    if (i5 > i2) {
                        i = i5;
                        neVar3 = neVar2;
                        i4 = i3;
                    } else {
                        i4 = i;
                        neVar3 = neVar;
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    neVar = neVar3;
                    i = i4;
                }
                this.f9979c.remove(i);
                return neVar;
            } else {
                neVar2 = (ne) this.f9979c.get(0);
                neVar2.m12760e();
                return neVar2;
            }
        }
    }

    public boolean m12767a(ne neVar) {
        boolean z;
        synchronized (this.f9977a) {
            if (this.f9979c.contains(neVar)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean m12768b(ne neVar) {
        synchronized (this.f9977a) {
            Iterator it = this.f9979c.iterator();
            while (it.hasNext()) {
                ne neVar2 = (ne) it.next();
                if (!((Boolean) qb.ac.m13225c()).booleanValue() || zzw.zzcQ().m15008b()) {
                    if (((Boolean) qb.ae.m13225c()).booleanValue() && !zzw.zzcQ().m15010c() && neVar != neVar2 && neVar2.m12759d().equals(neVar.m12759d())) {
                        it.remove();
                        return true;
                    }
                } else if (neVar != neVar2 && neVar2.m12756b().equals(neVar.m12756b())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void m12769c(ne neVar) {
        synchronized (this.f9977a) {
            if (this.f9979c.size() >= 10) {
                aad.m8421b("Queue is full, current size = " + this.f9979c.size());
                this.f9979c.remove(0);
            }
            int i = this.f9978b;
            this.f9978b = i + 1;
            neVar.m12753a(i);
            this.f9979c.add(neVar);
        }
    }
}
