package org.apache.p068a.p069a;

import java.io.File;

public class C3614d {
    public static final String f12312a = Character.toString('.');
    private static final char f12313b = File.separatorChar;
    private static final char f12314c;

    static {
        if (C3614d.m15749a()) {
            f12314c = '/';
        } else {
            f12314c = '\\';
        }
    }

    public static int m15748a(String str) {
        return str == null ? -1 : Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    static boolean m15749a() {
        return f12313b == '\\';
    }

    public static int m15750b(String str) {
        if (str == null) {
            return -1;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return C3614d.m15748a(str) <= lastIndexOf ? lastIndexOf : -1;
    }

    public static String m15751c(String str) {
        return str == null ? null : str.substring(C3614d.m15748a(str) + 1);
    }

    public static String m15752d(String str) {
        if (str == null) {
            return null;
        }
        int b = C3614d.m15750b(str);
        return b == -1 ? "" : str.substring(b + 1);
    }
}
