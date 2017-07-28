package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.bn.C2705a;
import com.google.android.gms.internal.bp.C2711a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class cj extends df {
    private static final String f8217s = cj.class.getSimpleName();
    private Info f8218t;

    protected cj(Context context) {
        super(context, "");
    }

    public static cj m9332b(Context context) {
        df.m9319a(context, true);
        return new cj(context);
    }

    protected C2711a mo3524a(Context context, View view) {
        return null;
    }

    public String m9334a(String str, String str2) {
        return bt.m9200a(str, str2, true);
    }

    public void m9335a(Info info) {
        this.f8218t = info;
    }

    protected void mo3527a(ez ezVar, C2711a c2711a, C2705a c2705a) {
        if (!ezVar.m10727h()) {
            m9328a(mo3528b(ezVar, c2711a, c2705a));
        } else if (this.f8218t != null) {
            String id = this.f8218t.getId();
            if (!TextUtils.isEmpty(id)) {
                c2711a.aa = fb.m10741a(id);
                c2711a.ab = Integer.valueOf(5);
                c2711a.ac = Boolean.valueOf(this.f8218t.isLimitAdTrackingEnabled());
            }
            this.f8218t = null;
        }
    }

    protected List<Callable<Void>> mo3528b(ez ezVar, C2711a c2711a, C2705a c2705a) {
        List<Callable<Void>> arrayList = new ArrayList();
        if (ezVar.m10722c() == null) {
            return arrayList;
        }
        ez ezVar2 = ezVar;
        arrayList.add(new fz(ezVar2, eh.m10608p(), eh.m10609q(), c2711a, ezVar.m10737r(), 24));
        return arrayList;
    }
}
