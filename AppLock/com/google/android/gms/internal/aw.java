package com.google.android.gms.internal;

public abstract class aw<T> {
    private static final Object f7961c = new Object();
    private static C2702a f7962d = null;
    private static int f7963e = 0;
    private static String f7964f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f7965a;
    protected final T f7966b;
    private T f7967g = null;

    class C26981 extends aw<Boolean> {
        C26981(String str, Boolean bool) {
            super(str, bool);
        }
    }

    class C26992 extends aw<Long> {
        C26992(String str, Long l) {
            super(str, l);
        }
    }

    class C27003 extends aw<Integer> {
        C27003(String str, Integer num) {
            super(str, num);
        }
    }

    class C27014 extends aw<String> {
        C27014(String str, String str2) {
            super(str, str2);
        }
    }

    private interface C2702a {
    }

    protected aw(String str, T t) {
        this.f7965a = str;
        this.f7966b = t;
    }

    public static aw<Integer> m9073a(String str, Integer num) {
        return new C27003(str, num);
    }

    public static aw<Long> m9074a(String str, Long l) {
        return new C26992(str, l);
    }

    public static aw<String> m9075a(String str, String str2) {
        return new C27014(str, str2);
    }

    public static aw<Boolean> m9076a(String str, boolean z) {
        return new C26981(str, Boolean.valueOf(z));
    }
}
