package com.google.android.gms.internal;

import com.google.android.gms.internal.jq.C3008a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class jp {
    private final jq f9543a;
    private final String f9544b;
    private final String f9545c;

    public jp(jq jqVar, String str) {
        this(jqVar, str, null);
    }

    public jp(jq jqVar, String str, String str2) {
        this.f9543a = jqVar;
        this.f9544b = str;
        this.f9545c = str2;
    }

    private static String m11954a(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private long m11955b() {
        return System.currentTimeMillis();
    }

    private String m11956b(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.f9545c == null) {
            return str;
        }
        String str2 = this.f9545c;
        return new StringBuilder((String.valueOf(str2).length() + 3) + String.valueOf(str).length()).append(str2).append(" - ").append(str).toString();
    }

    public void m11957a(String str) {
        m11963b(str, null);
    }

    public void m11958a(String str, Throwable th) {
        String valueOf = String.valueOf(m11956b(str, new Object[0]));
        String valueOf2 = String.valueOf(m11954a(th));
        this.f9543a.mo3766b(C3008a.ERROR, this.f9544b, new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("\n").append(valueOf2).toString(), m11955b());
    }

    public void m11959a(String str, Throwable th, Object... objArr) {
        if (m11961a()) {
            String b = m11956b(str, objArr);
            if (th != null) {
                String valueOf = String.valueOf(m11954a(th));
                b = new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(valueOf).length()).append(b).append("\n").append(valueOf).toString();
            }
            this.f9543a.mo3766b(C3008a.DEBUG, this.f9544b, b, m11955b());
        }
    }

    public void m11960a(String str, Object... objArr) {
        m11959a(str, null, objArr);
    }

    public boolean m11961a() {
        return this.f9543a.mo3765a().ordinal() <= C3008a.DEBUG.ordinal();
    }

    public void m11962b(String str) {
        this.f9543a.mo3766b(C3008a.INFO, this.f9544b, m11956b(str, new Object[0]), m11955b());
    }

    public void m11963b(String str, Throwable th) {
        String b = m11956b(str, new Object[0]);
        if (th != null) {
            String valueOf = String.valueOf(m11954a(th));
            b = new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(valueOf).length()).append(b).append("\n").append(valueOf).toString();
        }
        this.f9543a.mo3766b(C3008a.WARN, this.f9544b, b, m11955b());
    }
}
