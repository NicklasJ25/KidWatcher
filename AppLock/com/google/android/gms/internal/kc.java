package com.google.android.gms.internal;

import com.android.gallery3d.exif.ExifTag.GpsLongitudeRef;
import com.google.android.gms.internal.bp.C2711a;

public class kc extends ml {
    private static volatile String f9619i = null;
    private static final Object f9620j = new Object();

    public kc(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        this.e.f8042a = GpsLongitudeRef.EAST;
        if (f9619i == null) {
            synchronized (f9620j) {
                if (f9619i == null) {
                    f9619i = (String) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f8042a = f9619i;
        }
    }
}
