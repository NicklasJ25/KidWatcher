package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public interface ej {

    public static class C2847a {
        public byte[] f8827a;
        public String f8828b;
        public long f8829c;
        public long f8830d;
        public long f8831e;
        public long f8832f;
        public Map<String, String> f8833g = Collections.emptyMap();

        public boolean m10622a() {
            return this.f8831e < System.currentTimeMillis();
        }

        public boolean m10623b() {
            return this.f8832f < System.currentTimeMillis();
        }
    }

    C2847a mo3460a(String str);

    void mo3461a();

    void mo3462a(String str, C2847a c2847a);
}
