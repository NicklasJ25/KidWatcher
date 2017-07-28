package com.google.android.gms.internal;

import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2463d.C2462a;
import com.google.android.gms.common.api.C2470l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p004b.C2429f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class C3081n {
    private final Map<C2675h<?>, Boolean> f9917a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<C2429f<?>, Boolean> f9918b = Collections.synchronizedMap(new WeakHashMap());

    private void m12722a(boolean z, Status status) {
        synchronized (this.f9917a) {
            Map hashMap = new HashMap(this.f9917a);
        }
        synchronized (this.f9918b) {
            Map hashMap2 = new HashMap(this.f9918b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((C2675h) entry.getKey()).m8862b(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C2429f) entry2.getKey()).m7682b(new C2470l(status));
            }
        }
    }

    void m12723a(final C2675h<? extends C2445g> c2675h, boolean z) {
        this.f9917a.put(c2675h, Boolean.valueOf(z));
        c2675h.mo3471a(new C2462a(this) {
            final /* synthetic */ C3081n f9916b;

            public void mo3846a(Status status) {
                this.f9916b.f9917a.remove(c2675h);
            }
        });
    }

    boolean m12724a() {
        return (this.f9917a.isEmpty() && this.f9918b.isEmpty()) ? false : true;
    }

    public void m12725b() {
        m12722a(false, C3424x.f11268a);
    }

    public void m12726c() {
        m12722a(true, au.f7942a);
    }
}
