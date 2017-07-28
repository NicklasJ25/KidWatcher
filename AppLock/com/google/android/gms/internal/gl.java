package com.google.android.gms.internal;

import java.util.concurrent.ScheduledExecutorService;

public class gl {
    private final ScheduledExecutorService f9029a;
    private final gk f9030b;
    private final jq f9031c;
    private final boolean f9032d;
    private final String f9033e;
    private final String f9034f;

    public gl(jq jqVar, gk gkVar, ScheduledExecutorService scheduledExecutorService, boolean z, String str, String str2) {
        this.f9031c = jqVar;
        this.f9030b = gkVar;
        this.f9029a = scheduledExecutorService;
        this.f9032d = z;
        this.f9033e = str;
        this.f9034f = str2;
    }

    public jq m11066a() {
        return this.f9031c;
    }

    public gk m11067b() {
        return this.f9030b;
    }

    public ScheduledExecutorService m11068c() {
        return this.f9029a;
    }

    public boolean m11069d() {
        return this.f9032d;
    }

    public String m11070e() {
        return this.f9033e;
    }

    public String m11071f() {
        return this.f9034f;
    }
}
