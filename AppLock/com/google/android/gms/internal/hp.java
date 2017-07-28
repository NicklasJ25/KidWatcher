package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class hp {
    private kf f9294a = null;
    private Map<js, hp> f9295b = null;

    public interface C2941b {
        void mo3710a(hh hhVar, kf kfVar);
    }

    public interface C2960a {
        void mo3721a(js jsVar, hp hpVar);
    }

    public void m11500a(final hh hhVar, final C2941b c2941b) {
        if (this.f9294a != null) {
            c2941b.mo3710a(hhVar, this.f9294a);
        } else {
            m11502a(new C2960a(this) {
                public void mo3721a(js jsVar, hp hpVar) {
                    hpVar.m11500a(hhVar.m11382a(jsVar), c2941b);
                }
            });
        }
    }

    public void m11501a(hh hhVar, kf kfVar) {
        if (hhVar.m11391h()) {
            this.f9294a = kfVar;
            this.f9295b = null;
        } else if (this.f9294a != null) {
            this.f9294a = this.f9294a.mo3773a(hhVar, kfVar);
        } else {
            if (this.f9295b == null) {
                this.f9295b = new HashMap();
            }
            js d = hhVar.m11387d();
            if (!this.f9295b.containsKey(d)) {
                this.f9295b.put(d, new hp());
            }
            ((hp) this.f9295b.get(d)).m11501a(hhVar.m11388e(), kfVar);
        }
    }

    public void m11502a(C2960a c2960a) {
        if (this.f9295b != null) {
            for (Entry entry : this.f9295b.entrySet()) {
                c2960a.mo3721a((js) entry.getKey(), (hp) entry.getValue());
            }
        }
    }
}
