package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@wh
public class og {
    public static final og f10083a = new og();

    protected og() {
    }

    public static og m12904a() {
        return f10083a;
    }

    public zzec m12905a(Context context, pe peVar) {
        Date a = peVar.m13072a();
        long time = a != null ? a.getTime() : -1;
        String b = peVar.m13075b();
        int c = peVar.m13076c();
        Collection d = peVar.m13078d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = peVar.m13073a(context);
        int l = peVar.m13086l();
        Location e = peVar.m13079e();
        Bundle b2 = peVar.m13074b(AdMobAdapter.class);
        boolean f = peVar.m13080f();
        String g = peVar.m13081g();
        SearchAdRequest i = peVar.m13083i();
        zzfp com_google_android_gms_internal_zzfp = i != null ? new zzfp(i) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = ol.m12979a().m8403a(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new zzec(7, time, b2, c, unmodifiableList, a2, l, f, g, com_google_android_gms_internal_zzfp, e, b, peVar.m13085k(), peVar.m13087m(), Collections.unmodifiableList(new ArrayList(peVar.m13088n())), peVar.m13082h(), str, peVar.m13089o());
    }

    public zzoa m12906a(Context context, pe peVar, String str) {
        return new zzoa(m12905a(context, peVar), str);
    }
}
