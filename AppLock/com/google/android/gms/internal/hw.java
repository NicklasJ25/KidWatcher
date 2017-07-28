package com.google.android.gms.internal;

import com.google.firebase.database.C3537c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class hw {
    private final List<String> f9371a = new ArrayList();
    private int f9372b = 0;

    private hw(hh hhVar) {
        int i = 0;
        Iterator it = hhVar.iterator();
        while (it.hasNext()) {
            this.f9371a.add(((js) it.next()).m12010d());
        }
        this.f9372b = Math.max(1, this.f9371a.size());
        while (i < this.f9371a.size()) {
            this.f9372b = m11593a((CharSequence) this.f9371a.get(i)) + this.f9372b;
            i++;
        }
        m11599b();
    }

    private static int m11593a(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= '') {
                i2++;
            } else if (charAt <= '߿') {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private String m11594a() {
        CharSequence charSequence = (String) this.f9371a.remove(this.f9371a.size() - 1);
        this.f9372b -= m11593a(charSequence);
        if (this.f9371a.size() > 0) {
            this.f9372b--;
        }
        return charSequence;
    }

    private static String m11595a(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append(str);
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    public static void m11596a(hh hhVar, Object obj) {
        new hw(hhVar).m11597a(obj);
    }

    private void m11597a(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    m11598a(str);
                    m11597a(map.get(str));
                    m11594a();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                m11598a(Integer.toString(i));
                m11597a(list.get(i));
                m11594a();
            }
        }
    }

    private void m11598a(String str) {
        if (this.f9371a.size() > 0) {
            this.f9372b++;
        }
        this.f9371a.add(str);
        this.f9372b += m11593a((CharSequence) str);
        m11599b();
    }

    private void m11599b() {
        if (this.f9372b > 768) {
            String valueOf = String.valueOf("Data has a key path longer than 768 bytes (");
            throw new C3537c(new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append(this.f9372b).append(").").toString());
        } else if (this.f9371a.size() > 32) {
            String valueOf2 = String.valueOf("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            String valueOf3 = String.valueOf(m11600c());
            throw new C3537c(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }

    private String m11600c() {
        if (this.f9371a.size() == 0) {
            return "";
        }
        String valueOf = String.valueOf(m11595a("/", this.f9371a));
        return new StringBuilder(String.valueOf(valueOf).length() + 10).append("in path '").append(valueOf).append("'").toString();
    }
}
