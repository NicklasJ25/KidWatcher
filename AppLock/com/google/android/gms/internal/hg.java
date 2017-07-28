package com.google.android.gms.internal;

import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.jq.C3008a;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

enum hg implements hi {
    INSTANCE;

    public gp mo3605a(ha haVar, gl glVar, gn gnVar, C2900a c2900a) {
        return new gq(haVar.m11322g(), gnVar, c2900a);
    }

    public gw mo3606a(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public he mo3607a(ha haVar) {
        return new hu(Executors.defaultThreadFactory(), ht.f9185a);
    }

    public im mo3608a(ha haVar, String str) {
        return null;
    }

    public jq mo3609a(ha haVar, C3008a c3008a, List<String> list) {
        return new jo(c3008a, list);
    }

    public hm mo3610b(ha haVar) {
        final jp a = haVar.m11314a("RunLoop");
        return new lb(this) {
            public void mo3603a(Throwable th) {
                a.m11958a(lb.m10813b(th), th);
            }
        };
    }

    public String mo3611c(ha haVar) {
        String property = System.getProperty("java.vm.name", "Unknown JVM");
        String property2 = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder((String.valueOf(property2).length() + 1) + String.valueOf(property).length()).append(property2).append("/").append(property).toString();
    }
}
