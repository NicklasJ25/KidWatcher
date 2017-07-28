package com.domobile.imagelock;

import android.content.Context;
import android.util.Base64;
import com.domobile.applock.C1150y;
import com.domobile.imagelock.LockPatternView.C1308a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class C1318c {
    private final Context f2844a;

    public C1318c(Context context) {
        this.f2844a = context;
    }

    public static List<C1308a> m3242a(String str) {
        List<C1308a> a = C1317b.m3241a();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            a.add(C1308a.m3181a(b / 3, b % 3));
        }
        return a;
    }

    public static boolean m3243a(Context context) {
        if (!C1150y.m2591a(context, "vibrate_pattern_lock")) {
            C1150y.m2582a(context, "vibrate_pattern_lock", Boolean.valueOf(!C1150y.m2619d(context, "enable_visible_pattern")));
        }
        return C1150y.m2592a(context, "vibrate_pattern_lock", true);
    }

    public static String m3244c(List<C1308a> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            C1308a c1308a = (C1308a) list.get(i);
            bArr[i] = (byte) (c1308a.m3184b() + (c1308a.m3183a() * 3));
        }
        return new String(bArr);
    }

    static byte[] m3245d(List<C1308a> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            C1308a c1308a = (C1308a) list.get(i);
            bArr[i] = (byte) (c1308a.m3184b() + (c1308a.m3183a() * 3));
        }
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            return bArr;
        }
    }

    public boolean m3246a(List<C1308a> list) {
        String Z = C1150y.m2561Z(this.f2844a);
        return "".equals(Z) ? true : Arrays.equals(Base64.decode(Z, 0), C1318c.m3245d(list));
    }

    public void m3247b(List<C1308a> list) {
        C1150y.m2656t(this.f2844a, Base64.encodeToString(C1318c.m3245d(list), 0));
    }
}
