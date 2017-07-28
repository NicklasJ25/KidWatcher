package com.google.android.gms.internal;

import com.android.gallery3d.exif.ExifTag.GpsLongitudeRef;
import java.util.HashMap;

public class bs extends bq<Integer, Object> {
    public String f8087a;
    public long f8088b;
    public String f8089c;
    public String f8090d;
    public String f8091e;

    public bs() {
        this.f8087a = GpsLongitudeRef.EAST;
        this.f8088b = -1;
        this.f8089c = GpsLongitudeRef.EAST;
        this.f8090d = GpsLongitudeRef.EAST;
        this.f8091e = GpsLongitudeRef.EAST;
    }

    public bs(String str) {
        this();
        mo3511a(str);
    }

    protected HashMap<Integer, Object> mo3510a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f8087a);
        hashMap.put(Integer.valueOf(4), this.f8091e);
        hashMap.put(Integer.valueOf(3), this.f8090d);
        hashMap.put(Integer.valueOf(2), this.f8089c);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f8088b));
        return hashMap;
    }

    protected void mo3511a(String str) {
        HashMap b = bq.m9190b(str);
        if (b != null) {
            this.f8087a = b.get(Integer.valueOf(0)) == null ? GpsLongitudeRef.EAST : (String) b.get(Integer.valueOf(0));
            this.f8088b = b.get(Integer.valueOf(1)) == null ? -1 : ((Long) b.get(Integer.valueOf(1))).longValue();
            this.f8089c = b.get(Integer.valueOf(2)) == null ? GpsLongitudeRef.EAST : (String) b.get(Integer.valueOf(2));
            this.f8090d = b.get(Integer.valueOf(3)) == null ? GpsLongitudeRef.EAST : (String) b.get(Integer.valueOf(3));
            this.f8091e = b.get(Integer.valueOf(4)) == null ? GpsLongitudeRef.EAST : (String) b.get(Integer.valueOf(4));
        }
    }
}
