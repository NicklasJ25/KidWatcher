package com.google.android.gms.internal;

import java.util.HashMap;

public class ex extends bq<Integer, Object> {
    public Long f8858a;
    public Boolean f8859b;
    public Boolean f8860c;

    public ex(String str) {
        mo3511a(str);
    }

    protected HashMap<Integer, Object> mo3510a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f8858a);
        hashMap.put(Integer.valueOf(1), this.f8859b);
        hashMap.put(Integer.valueOf(2), this.f8860c);
        return hashMap;
    }

    protected void mo3511a(String str) {
        HashMap b = bq.m9190b(str);
        if (b != null) {
            this.f8858a = (Long) b.get(Integer.valueOf(0));
            this.f8859b = (Boolean) b.get(Integer.valueOf(1));
            this.f8860c = (Boolean) b.get(Integer.valueOf(2));
        }
    }
}
