package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class C2512b {

    public static final class C2511a {
        private final List<String> f7395a;
        private final Object f7396b;

        private C2511a(Object obj) {
            this.f7396b = C2513c.m7932a(obj);
            this.f7395a = new ArrayList();
        }

        public C2511a m7928a(String str, Object obj) {
            List list = this.f7395a;
            String str2 = (String) C2513c.m7932a((Object) str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f7396b.getClass().getSimpleName()).append('{');
            int size = this.f7395a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f7395a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m7929a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C2511a m7930a(Object obj) {
        return new C2511a(obj);
    }

    public static boolean m7931a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
