package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@wh
public abstract class qg {
    @wh
    public static final qg f10329a = new C31701();
    @wh
    public static final qg f10330b = new C31712();
    @wh
    public static final qg f10331c = new C31723();

    class C31701 extends qg {
        C31701() {
        }

        public String mo3907a(@Nullable String str, String str2) {
            return str2;
        }
    }

    class C31712 extends qg {
        C31712() {
        }

        public String mo3907a(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    }

    class C31723 extends qg {
        C31723() {
        }

        @Nullable
        private String m13293a(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String mo3907a(@Nullable String str, String str2) {
            String a = m13293a(str);
            String a2 = m13293a(str2);
            return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : new StringBuilder((String.valueOf(a).length() + 1) + String.valueOf(a2).length()).append(a).append(",").append(a2).toString();
        }
    }

    public abstract String mo3907a(@Nullable String str, String str2);

    public final void m13290a(Map<String, String> map, String str, String str2) {
        map.put(str, mo3907a((String) map.get(str), str2));
    }
}
