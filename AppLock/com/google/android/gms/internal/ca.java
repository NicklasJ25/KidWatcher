package com.google.android.gms.internal;

public final class ca {
    private static ca f8187a;
    private final bx f8188b = new bx();
    private final by f8189c = new by();

    static {
        m9277a(new ca());
    }

    private ca() {
    }

    public static bx m9276a() {
        return m9279c().f8188b;
    }

    protected static void m9277a(ca caVar) {
        synchronized (ca.class) {
            f8187a = caVar;
        }
    }

    public static by m9278b() {
        return m9279c().f8189c;
    }

    private static ca m9279c() {
        ca caVar;
        synchronized (ca.class) {
            caVar = f8187a;
        }
        return caVar;
    }
}
