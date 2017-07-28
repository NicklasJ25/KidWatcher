package com.google.android.gms.internal;

import com.android.gallery3d.exif.ExifTag.GpsLongitudeRef;
import com.google.android.gms.internal.bp.C2711a;

public class ff extends ml {
    private static volatile String f8909i = null;
    private static final Object f8910j = new Object();

    public ff(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        this.e.f8065x = GpsLongitudeRef.EAST;
        if (f8909i == null) {
            synchronized (f8910j) {
                if (f8909i == null) {
                    f8909i = (String) this.f.invoke(null, new Object[]{this.b.m10718a()});
                }
            }
        }
        synchronized (this.e) {
            this.e.f8065x = br.m9193a(f8909i.getBytes(), true);
        }
    }
}
