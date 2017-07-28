package com.facebook.ads.internal.p018m;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class C1710f {
    public static final String m4917a(Throwable th) {
        if (th == null) {
            return null;
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }
}
