package com.google.android.gms.internal;

import com.google.firebase.database.C3576f;
import java.util.HashMap;
import java.util.Map;

public class hl {
    private static final hl f9285a = new hl();
    private final Map<ha, Map<String, hj>> f9286b = new HashMap();

    public static hj m11483a(ha haVar, hk hkVar, C3576f c3576f) {
        return f9285a.m11484b(haVar, hkVar, c3576f);
    }

    private hj m11484b(ha haVar, hk hkVar, C3576f c3576f) {
        hj hjVar;
        haVar.m11317b();
        String str = hkVar.f9281a;
        String str2 = hkVar.f9283c;
        str2 = new StringBuilder((String.valueOf(str).length() + 9) + String.valueOf(str2).length()).append("https://").append(str).append("/").append(str2).toString();
        synchronized (this.f9286b) {
            if (!this.f9286b.containsKey(haVar)) {
                this.f9286b.put(haVar, new HashMap());
            }
            Map map = (Map) this.f9286b.get(haVar);
            if (map.containsKey(str2)) {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
            hjVar = new hj(hkVar, haVar, c3576f);
            map.put(str2, hjVar);
        }
        return hjVar;
    }
}
