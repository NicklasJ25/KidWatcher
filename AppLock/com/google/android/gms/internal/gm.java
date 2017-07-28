package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public class gm {
    public static Long m11072a(Object obj) {
        return obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj instanceof Long ? (Long) obj : null;
    }

    public static String m11073a(List<String> list) {
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : list) {
            if (obj == null) {
                stringBuilder.append("/");
            }
            obj = null;
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static List<String> m11074a(String str) {
        List<String> arrayList = new ArrayList();
        String[] split = str.split("/");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public static void m11075a(boolean z) {
        m11076a(z, "", new Object[0]);
    }

    public static void m11076a(boolean z, String str, Object... objArr) {
        if (!z) {
            String str2 = "hardAssert failed: ";
            String valueOf = String.valueOf(String.format(str, objArr));
            throw new AssertionError(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
