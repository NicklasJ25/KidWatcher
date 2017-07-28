package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@wh
public class zu {
    Map<Integer, Bitmap> f11746a = new ConcurrentHashMap();
    private AtomicInteger f11747b = new AtomicInteger(0);

    public int m15279a(Bitmap bitmap) {
        if (bitmap == null) {
            aad.m8421b("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        this.f11746a.put(Integer.valueOf(this.f11747b.get()), bitmap);
        return this.f11747b.getAndIncrement();
    }

    public Bitmap m15280a(Integer num) {
        return (Bitmap) this.f11746a.get(num);
    }

    public void m15281b(Integer num) {
        this.f11746a.remove(num);
    }
}
