package com.google.android.gms.internal;

import com.google.android.gms.internal.jq.C3008a;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class jo implements jq {
    private final Set<String> f9540a;
    private final C3008a f9541b;

    public jo(C3008a c3008a, List<String> list) {
        if (list != null) {
            this.f9540a = new HashSet(list);
        } else {
            this.f9540a = null;
        }
        this.f9541b = c3008a;
    }

    public C3008a mo3765a() {
        return this.f9541b;
    }

    protected String mo3767a(C3008a c3008a, String str, String str2, long j) {
        String valueOf = String.valueOf(new Date(j).toString());
        String valueOf2 = String.valueOf(c3008a);
        return new StringBuilder((((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()).append(valueOf).append(" [").append(valueOf2).append("] ").append(str).append(": ").append(str2).toString();
    }

    protected void mo3768a(String str, String str2) {
        System.err.println(str2);
    }

    protected boolean m11944a(C3008a c3008a, String str) {
        return c3008a.ordinal() >= this.f9541b.ordinal() && (this.f9540a == null || c3008a.ordinal() > C3008a.DEBUG.ordinal() || this.f9540a.contains(str));
    }

    public void mo3766b(C3008a c3008a, String str, String str2, long j) {
        if (m11944a(c3008a, str)) {
            String a = mo3767a(c3008a, str, str2, j);
            switch (c3008a) {
                case ERROR:
                    mo3768a(str, a);
                    return;
                case WARN:
                    mo3769b(str, a);
                    return;
                case INFO:
                    mo3770c(str, a);
                    return;
                case DEBUG:
                    mo3771d(str, a);
                    return;
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }

    protected void mo3769b(String str, String str2) {
        System.out.println(str2);
    }

    protected void mo3770c(String str, String str2) {
        System.out.println(str2);
    }

    protected void mo3771d(String str, String str2) {
        System.out.println(str2);
    }
}
