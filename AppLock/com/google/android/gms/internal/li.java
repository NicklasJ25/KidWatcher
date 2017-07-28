package com.google.android.gms.internal;

import com.google.firebase.database.C3537c;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class li {
    private static final Pattern f9705a = Pattern.compile("[\\[\\]\\.#$]");
    private static final Pattern f9706b = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static void m12300a(hh hhVar) {
        if (!m12304b(hhVar)) {
            String str = "Invalid write location: ";
            String valueOf = String.valueOf(hhVar.toString());
            throw new C3537c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static void m12301a(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Entry entry : map.entrySet()) {
                    m12305c((String) entry.getKey());
                    m12301a(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object a : (List) obj) {
                m12301a(a);
            }
        }
    }

    public static void m12302a(String str) {
        if (!m12306d(str)) {
            throw new C3537c(new StringBuilder(String.valueOf(str).length() + 101).append("Invalid Firebase Database path: ").append(str).append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void m12303b(String str) {
        if (str.startsWith(".info")) {
            m12302a(str.substring(5));
        } else if (str.startsWith("/.info")) {
            m12302a(str.substring(6));
        } else {
            m12302a(str);
        }
    }

    private static boolean m12304b(hh hhVar) {
        js d = hhVar.m11387d();
        return d == null || !d.m12010d().startsWith(".");
    }

    public static void m12305c(String str) {
        if (!m12307e(str)) {
            throw new C3537c(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }

    private static boolean m12306d(String str) {
        return !f9705a.matcher(str).find();
    }

    private static boolean m12307e(String str) {
        return str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || !(str.startsWith(".") || f9706b.matcher(str).find()));
    }
}
