package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2513c;
import java.util.Iterator;

public class ct {
    final String f8282a;
    final String f8283b;
    final String f8284c;
    final long f8285d;
    final long f8286e;
    final zzato f8287f;

    ct(dk dkVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        C2513c.m7934a(str2);
        C2513c.m7934a(str3);
        this.f8282a = str2;
        this.f8283b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f8284c = str;
        this.f8285d = j;
        this.f8286e = j2;
        if (this.f8286e != 0 && this.f8286e > this.f8285d) {
            dkVar.m10034f().m9817z().m9775a("Event created with reverse previous/current timestamps. appId", dc.m9779a(str2));
        }
        this.f8287f = m9649a(dkVar, bundle);
    }

    private ct(dk dkVar, String str, String str2, String str3, long j, long j2, zzato com_google_android_gms_internal_zzato) {
        C2513c.m7934a(str2);
        C2513c.m7934a(str3);
        C2513c.m7932a((Object) com_google_android_gms_internal_zzato);
        this.f8282a = str2;
        this.f8283b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f8284c = str;
        this.f8285d = j;
        this.f8286e = j2;
        if (this.f8286e != 0 && this.f8286e > this.f8285d) {
            dkVar.m10034f().m9817z().m9775a("Event created with reverse previous/current timestamps. appId", dc.m9779a(str2));
        }
        this.f8287f = com_google_android_gms_internal_zzato;
    }

    static zzato m9649a(dk dkVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new zzato(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                dkVar.m10034f().m9815x().m9774a("Param name can't be null");
                it.remove();
            } else {
                Object a = dkVar.m10043o().m10391a(str, bundle2.get(str));
                if (a == null) {
                    dkVar.m10034f().m9817z().m9775a("Param value can't be null", str);
                    it.remove();
                } else {
                    dkVar.m10043o().m10396a(bundle2, str, a);
                }
            }
        }
        return new zzato(bundle2);
    }

    ct m9650a(dk dkVar, long j) {
        return new ct(dkVar, this.f8284c, this.f8282a, this.f8283b, this.f8285d, j, this.f8287f);
    }

    public String toString() {
        String str = this.f8282a;
        String str2 = this.f8283b;
        String valueOf = String.valueOf(this.f8287f);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
