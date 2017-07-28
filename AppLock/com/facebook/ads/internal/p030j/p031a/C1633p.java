package com.facebook.ads.internal.p030j.p031a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C1633p implements Map<String, String> {
    private Map<String, String> f4043a = new HashMap();

    public C1633p m4595a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    public String m4596a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f4043a.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str);
            String str2 = (String) this.f4043a.get(str2);
            if (str2 != null) {
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public String m4597a(Object obj) {
        return (String) this.f4043a.get(obj);
    }

    public String m4598a(String str, String str2) {
        return (String) this.f4043a.put(str, str2);
    }

    public String m4599b(Object obj) {
        return (String) this.f4043a.remove(obj);
    }

    public byte[] m4600b() {
        byte[] bArr = null;
        try {
            bArr = m4596a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public void clear() {
        this.f4043a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f4043a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f4043a.containsValue(obj);
    }

    public Set<Entry<String, String>> entrySet() {
        return this.f4043a.entrySet();
    }

    public /* synthetic */ Object get(Object obj) {
        return m4597a(obj);
    }

    public boolean isEmpty() {
        return this.f4043a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f4043a.keySet();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m4598a((String) obj, (String) obj2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f4043a.putAll(map);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m4599b(obj);
    }

    public int size() {
        return this.f4043a.size();
    }

    public Collection<String> values() {
        return this.f4043a.values();
    }
}
