package com.google.android.gms.internal;

import java.util.HashMap;

public class ey extends bq<Integer, Long> {
    public Long f8861a;
    public Long f8862b;

    public ey(String str) {
        mo3511a(str);
    }

    protected HashMap<Integer, Long> mo3510a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f8861a);
        hashMap.put(Integer.valueOf(1), this.f8862b);
        return hashMap;
    }

    protected void mo3511a(String str) {
        HashMap b = bq.m9190b(str);
        if (b != null) {
            this.f8861a = (Long) b.get(Integer.valueOf(0));
            this.f8862b = (Long) b.get(Integer.valueOf(1));
        }
    }
}
