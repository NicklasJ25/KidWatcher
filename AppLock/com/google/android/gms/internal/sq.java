package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@wh
public class sq implements Iterable<sp> {
    private final List<sp> f10587a = new LinkedList();

    private sp m13740c(aat com_google_android_gms_internal_aat) {
        Iterator it = zzw.zzdj().iterator();
        while (it.hasNext()) {
            sp spVar = (sp) it.next();
            if (spVar.f10584a == com_google_android_gms_internal_aat) {
                return spVar;
            }
        }
        return null;
    }

    public int m13741a() {
        return this.f10587a.size();
    }

    public void m13742a(sp spVar) {
        this.f10587a.add(spVar);
    }

    public boolean m13743a(aat com_google_android_gms_internal_aat) {
        sp c = m13740c(com_google_android_gms_internal_aat);
        if (c == null) {
            return false;
        }
        c.f10585b.mo4016b();
        return true;
    }

    public void m13744b(sp spVar) {
        this.f10587a.remove(spVar);
    }

    public boolean m13745b(aat com_google_android_gms_internal_aat) {
        return m13740c(com_google_android_gms_internal_aat) != null;
    }

    public Iterator<sp> iterator() {
        return this.f10587a.iterator();
    }
}
