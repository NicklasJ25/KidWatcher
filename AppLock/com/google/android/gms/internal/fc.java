package com.google.android.gms.internal;

import java.util.HashMap;

public class fc extends bq<Integer, Long> {
    public Long f8900a;

    public fc(String str) {
        mo3511a(str);
    }

    protected HashMap<Integer, Long> mo3510a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f8900a);
        return hashMap;
    }

    protected void mo3511a(String str) {
        HashMap b = bq.m9190b(str);
        if (b != null) {
            this.f8900a = (Long) b.get(Integer.valueOf(0));
        }
    }
}
