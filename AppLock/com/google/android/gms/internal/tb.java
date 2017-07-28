package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import java.util.Iterator;
import java.util.LinkedList;

@wh
class tb {
    private final LinkedList<C3277a> f10681a = new LinkedList();
    private zzec f10682b;
    private final String f10683c;
    private final int f10684d;
    private boolean f10685e;

    class C3277a {
        zzm f10674a;
        @Nullable
        zzec f10675b;
        sw f10676c;
        long f10677d;
        boolean f10678e;
        boolean f10679f;
        final /* synthetic */ tb f10680g;

        C3277a(tb tbVar, sv svVar) {
            this.f10680g = tbVar;
            this.f10674a = svVar.m13766b(tbVar.f10683c);
            this.f10676c = new sw();
            this.f10676c.m13812a(this.f10674a);
        }

        C3277a(tb tbVar, sv svVar, zzec com_google_android_gms_internal_zzec) {
            this(tbVar, svVar);
            this.f10675b = com_google_android_gms_internal_zzec;
        }

        boolean m13871a() {
            if (this.f10678e) {
                return false;
            }
            this.f10679f = this.f10674a.zzb(sy.m13824b(this.f10675b != null ? this.f10675b : this.f10680g.f10682b));
            this.f10678e = true;
            this.f10677d = zzw.zzcS().mo3360a();
            return true;
        }
    }

    tb(zzec com_google_android_gms_internal_zzec, String str, int i) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzec);
        C2513c.m7932a((Object) str);
        this.f10682b = com_google_android_gms_internal_zzec;
        this.f10683c = str;
        this.f10684d = i;
    }

    C3277a m13874a(@Nullable zzec com_google_android_gms_internal_zzec) {
        if (com_google_android_gms_internal_zzec != null) {
            this.f10682b = com_google_android_gms_internal_zzec;
        }
        return (C3277a) this.f10681a.remove();
    }

    zzec m13875a() {
        return this.f10682b;
    }

    void m13876a(sv svVar, zzec com_google_android_gms_internal_zzec) {
        this.f10681a.add(new C3277a(this, svVar, com_google_android_gms_internal_zzec));
    }

    boolean m13877a(sv svVar) {
        C3277a c3277a = new C3277a(this, svVar);
        this.f10681a.add(c3277a);
        return c3277a.m13871a();
    }

    int m13878b() {
        return this.f10684d;
    }

    String m13879c() {
        return this.f10683c;
    }

    int m13880d() {
        return this.f10681a.size();
    }

    int m13881e() {
        Iterator it = this.f10681a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((C3277a) it.next()).f10678e ? i + 1 : i;
        }
        return i;
    }

    int m13882f() {
        Iterator it = this.f10681a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((C3277a) it.next()).m13871a() ? i + 1 : i;
        }
        return i;
    }

    void m13883g() {
        this.f10685e = true;
    }

    boolean m13884h() {
        return this.f10685e;
    }
}
