package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.facebook.ads.internal.p022h.C1599g;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public class C1727r {

    public interface C1526a {
        Collection<String> mo2721A();

        String mo2704y();

        C1726q mo2722z();
    }

    public static Collection<String> m4952a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        Set hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean m4953a(Context context, C1526a c1526a) {
        C1726q z = c1526a.mo2722z();
        if (z == null || z == C1726q.NONE) {
            return false;
        }
        Collection<String> A = c1526a.mo2721A();
        if (A == null || A.isEmpty()) {
            return false;
        }
        boolean z2;
        for (String a : A) {
            if (C1727r.m4954a(context, a)) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2 != (z == C1726q.INSTALLED)) {
            return false;
        }
        Object y = c1526a.mo2704y();
        if (TextUtils.isEmpty(y)) {
            return true;
        }
        C1599g.m4464a(context).m4484f(y, null);
        return true;
    }

    public static boolean m4954a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        } catch (RuntimeException e2) {
            return false;
        }
    }
}
