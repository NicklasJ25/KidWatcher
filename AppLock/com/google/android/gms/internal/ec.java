package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.bn.C2705a;
import com.google.android.gms.internal.bp.C2711a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ec extends df {
    private static final String f8816s = ec.class.getSimpleName();

    protected ec(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static ec m10554a(String str, Context context, boolean z) {
        df.m9319a(context, z);
        return new ec(context, str, z);
    }

    protected List<Callable<Void>> mo3528b(ez ezVar, C2711a c2711a, C2705a c2705a) {
        if (ezVar.m10722c() == null || !this.o) {
            return super.mo3528b(ezVar, c2711a, c2705a);
        }
        int r = ezVar.m10737r();
        List<Callable<Void>> arrayList = new ArrayList();
        arrayList.addAll(super.mo3528b(ezVar, c2711a, c2705a));
        arrayList.add(new fz(ezVar, eh.m10608p(), eh.m10609q(), c2711a, r, 24));
        return arrayList;
    }
}
