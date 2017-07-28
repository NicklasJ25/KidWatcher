package com.facebook.ads.internal.p018m;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.view.Window;
import java.util.HashMap;
import java.util.Map;

public class C1719m {
    private static final String f4327a = C1719m.class.getSimpleName();

    private C1719m() {
    }

    public static Map<String, String> m4933a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("kgr", String.valueOf(C1719m.m4935b(context)));
            if (context == null || !(context instanceof Activity)) {
                Log.v(f4327a, "Invalid Activity context in window interactive check, assuming interactive.");
                return hashMap;
            }
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                int i = window.getAttributes().flags;
                hashMap.put("wt", Integer.toString(window.getAttributes().type));
                hashMap.put("wfdkg", (AccessibilityEventCompat.TYPE_WINDOWS_CHANGED & i) > 0 ? "1" : "0");
                hashMap.put("wfswl", (524288 & i) > 0 ? "1" : "0");
            } else {
                Log.v(f4327a, "Invalid window in window interactive check, assuming interactive.");
            }
            return hashMap;
        } catch (Exception e) {
            Log.e(f4327a, "Exception in window info check", e);
            C1737z.m4998a(e, context);
        }
    }

    public static boolean m4934a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f4327a, "Invalid Window info in window interactive check, assuming not obstructed by Keyguard.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        if (str != null && str.equals("1")) {
            return false;
        }
        if (str2 != null && str2.equals("1")) {
            return false;
        }
        str = (String) map.get("kgr");
        boolean z = str != null && str.equals("true");
        return z;
    }

    public static boolean m4935b(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean m4936b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f4327a, "Invalid Window info in window interactive check, assuming is not a Lockscreen.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        String str3 = (String) map.get("kgr");
        return str != null && str.equals("1") && str2 != null && str2.equals("1") && str3 != null && str3.equals("true");
    }

    public static boolean m4937c(Context context) {
        return !C1719m.m4934a(C1719m.m4933a(context));
    }
}
