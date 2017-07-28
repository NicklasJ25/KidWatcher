package com.google.firebase.database;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class C3536b {
    private static final Map<Integer, String> f12150a = new HashMap();
    private static final Map<String, Integer> f12151b = new HashMap();
    private final int f12152c;
    private final String f12153d;
    private final String f12154e;

    static {
        f12150a.put(Integer.valueOf(-1), "The transaction needs to be run again with current data");
        f12150a.put(Integer.valueOf(-2), "The server indicated that this operation failed");
        f12150a.put(Integer.valueOf(-3), "This client does not have permission to perform this operation");
        f12150a.put(Integer.valueOf(-4), "The operation had to be aborted due to a network disconnect");
        f12150a.put(Integer.valueOf(-6), "The supplied auth token has expired");
        f12150a.put(Integer.valueOf(-7), "The supplied auth token was invalid");
        f12150a.put(Integer.valueOf(-8), "The transaction had too many retries");
        f12150a.put(Integer.valueOf(-9), "The transaction was overridden by a subsequent set");
        f12150a.put(Integer.valueOf(-10), "The service is unavailable");
        f12150a.put(Integer.valueOf(-11), "User code called from the Firebase Database runloop threw an exception:\n");
        f12150a.put(Integer.valueOf(-24), "The operation could not be performed due to a network error");
        f12150a.put(Integer.valueOf(-25), "The write was canceled by the user.");
        f12150a.put(Integer.valueOf(-999), "An unknown error occurred");
        f12151b.put("datastale", Integer.valueOf(-1));
        f12151b.put("failure", Integer.valueOf(-2));
        f12151b.put("permission_denied", Integer.valueOf(-3));
        f12151b.put("disconnected", Integer.valueOf(-4));
        f12151b.put("expired_token", Integer.valueOf(-6));
        f12151b.put("invalid_token", Integer.valueOf(-7));
        f12151b.put("maxretries", Integer.valueOf(-8));
        f12151b.put("overriddenbyset", Integer.valueOf(-9));
        f12151b.put("unavailable", Integer.valueOf(-10));
        f12151b.put("network_error", Integer.valueOf(-24));
        f12151b.put("write_canceled", Integer.valueOf(-25));
    }

    private C3536b(int i, String str) {
        this(i, str, null);
    }

    private C3536b(int i, String str, String str2) {
        this.f12152c = i;
        this.f12153d = str;
        if (str2 == null) {
            str2 = "";
        }
        this.f12154e = str2;
    }

    public static C3536b m15461a(int i) {
        if (f12150a.containsKey(Integer.valueOf(i))) {
            return new C3536b(i, (String) f12150a.get(Integer.valueOf(i)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i);
    }

    public static C3536b m15462a(String str) {
        return C3536b.m15463a(str, null);
    }

    public static C3536b m15463a(String str, String str2) {
        return C3536b.m15464a(str, str2, null);
    }

    public static C3536b m15464a(String str, String str2, String str3) {
        Integer num = (Integer) f12151b.get(str.toLowerCase());
        Integer valueOf = num == null ? Integer.valueOf(-999) : num;
        return new C3536b(valueOf.intValue(), str2 == null ? (String) f12150a.get(valueOf) : str2, str3);
    }

    public static C3536b m15465a(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String valueOf = String.valueOf((String) f12150a.get(Integer.valueOf(-11)));
        String valueOf2 = String.valueOf(stringWriter.toString());
        return new C3536b(-11, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public int m15466a() {
        return this.f12152c;
    }

    public C3537c m15467b() {
        String str = "Firebase Database error: ";
        String valueOf = String.valueOf(this.f12153d);
        return new C3537c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public String toString() {
        String str = "DatabaseError: ";
        String valueOf = String.valueOf(this.f12153d);
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
