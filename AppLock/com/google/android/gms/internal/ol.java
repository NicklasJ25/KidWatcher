package com.google.android.gms.internal;

@wh
public class ol {
    private static final Object f10128a = new Object();
    private static ol f10129b;
    private final aac f10130c = new aac();
    private final ok f10131d = new ok(new od(), new oc(), new pj(), new rr(), new xw(), new vm(), new uz());

    static {
        m12980a(new ol());
    }

    protected ol() {
    }

    public static aac m12979a() {
        return m12982c().f10130c;
    }

    protected static void m12980a(ol olVar) {
        synchronized (f10128a) {
            f10129b = olVar;
        }
    }

    public static ok m12981b() {
        return m12982c().f10131d;
    }

    private static ol m12982c() {
        ol olVar;
        synchronized (f10128a) {
            olVar = f10129b;
        }
        return olVar;
    }
}
