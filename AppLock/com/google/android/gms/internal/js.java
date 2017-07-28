package com.google.android.gms.internal;

public class js implements Comparable<js> {
    static final /* synthetic */ boolean f9557a = (!js.class.desiredAssertionStatus());
    private static final js f9558c = new js("[MIN_KEY]");
    private static final js f9559d = new js("[MAX_KEY]");
    private static final js f9560e = new js(".priority");
    private static final js f9561f = new js(".info");
    private final String f9562b;

    private static class C3010a extends js {
        private final int f9563b;

        C3010a(String str, int i) {
            super(str);
            this.f9563b = i;
        }

        protected boolean mo3790f() {
            return true;
        }

        protected int mo3791g() {
            return this.f9563b;
        }

        public String toString() {
            String b = this.f9562b;
            return new StringBuilder(String.valueOf(b).length() + 20).append("IntegerChildName(\"").append(b).append("\")").toString();
        }
    }

    private js(String str) {
        this.f9562b = str;
    }

    public static js m12004a() {
        return f9558c;
    }

    public static js m12005a(String str) {
        Integer d = lh.m12299d(str);
        if (d != null) {
            return new C3010a(str, d.intValue());
        }
        if (str.equals(".priority")) {
            return f9560e;
        }
        if (f9557a || !str.contains("/")) {
            return new js(str);
        }
        throw new AssertionError();
    }

    public static js m12006b() {
        return f9559d;
    }

    public static js m12008c() {
        return f9560e;
    }

    public int m12009a(js jsVar) {
        if (this == jsVar) {
            return 0;
        }
        if (this == f9558c || jsVar == f9559d) {
            return -1;
        }
        if (jsVar == f9558c || this == f9559d) {
            return 1;
        }
        if (!mo3790f()) {
            return jsVar.mo3790f() ? 1 : this.f9562b.compareTo(jsVar.f9562b);
        } else {
            if (!jsVar.mo3790f()) {
                return -1;
            }
            int a = lh.m12290a(mo3791g(), jsVar.mo3791g());
            return a == 0 ? lh.m12290a(this.f9562b.length(), jsVar.f9562b.length()) : a;
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m12009a((js) obj);
    }

    public String m12010d() {
        return this.f9562b;
    }

    public boolean m12011e() {
        return this == f9560e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof js)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.f9562b.equals(((js) obj).f9562b);
    }

    protected boolean mo3790f() {
        return false;
    }

    protected int mo3791g() {
        return 0;
    }

    public int hashCode() {
        return this.f9562b.hashCode();
    }

    public String toString() {
        String str = this.f9562b;
        return new StringBuilder(String.valueOf(str).length() + 12).append("ChildKey(\"").append(str).append("\")").toString();
    }
}
