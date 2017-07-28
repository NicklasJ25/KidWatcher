package com.facebook.ads.internal.p022h;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class C1610r<T extends C1511s, E extends C1609q> {
    private final Map<Class<E>, List<WeakReference<T>>> f3997a = new HashMap();
    private final Queue<E> f3998b = new ArrayDeque();

    private void m4510a(List<WeakReference<T>> list) {
        if (list != null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                WeakReference weakReference = (WeakReference) list.get(i2);
                if (weakReference.get() != null) {
                    int i3 = i + 1;
                    list.set(i, weakReference);
                    i = i3;
                }
            }
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
        }
    }

    private void m4511b(E e) {
        if (this.f3997a != null) {
            List list = (List) this.f3997a.get(e.getClass());
            if (list != null) {
                m4510a(list);
                if (!list.isEmpty()) {
                    for (WeakReference weakReference : new ArrayList(list)) {
                        C1511s c1511s = (C1511s) weakReference.get();
                        if (c1511s != null && c1511s.m4006b(e)) {
                            c1511s.mo2710a(e);
                        }
                    }
                }
            }
        }
    }

    public synchronized void m4512a(E e) {
        if (this.f3998b.isEmpty()) {
            this.f3998b.add(e);
            while (!this.f3998b.isEmpty()) {
                m4511b((C1609q) this.f3998b.peek());
                this.f3998b.remove();
            }
        } else {
            this.f3998b.add(e);
        }
    }

    public synchronized boolean m4513a(T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            Class a = t.mo2709a();
            if (this.f3997a.get(a) == null) {
                this.f3997a.put(a, new ArrayList());
            }
            List list = (List) this.f3997a.get(a);
            m4510a(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((WeakReference) list.get(i)).get() == t) {
                    z = false;
                    break;
                }
            }
            z = list.add(new WeakReference(t));
        }
        return z;
    }

    public synchronized boolean m4514b(@Nullable T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            List list = (List) this.f3997a.get(t.mo2709a());
            if (list == null) {
                z = false;
            } else {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (((WeakReference) list.get(i)).get() == t) {
                        ((WeakReference) list.get(i)).clear();
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        return z;
    }
}
