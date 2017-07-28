package com.facebook.ads.internal.p025c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class C1541a {
    private final View f3743a;
    private final List<C1545d> f3744b;
    private final Context f3745c;
    private C1544c f3746d;

    public C1541a(Context context, View view, List<C1542b> list) {
        this.f3745c = context;
        this.f3743a = view;
        this.f3744b = new ArrayList(list.size());
        for (C1542b c1545d : list) {
            this.f3744b.add(new C1545d(c1545d));
        }
        this.f3746d = new C1544c();
    }

    public C1541a(Context context, View view, List<C1542b> list, Bundle bundle) {
        this.f3745c = context;
        this.f3743a = view;
        this.f3744b = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("TESTS");
        for (int i = 0; i < list.size(); i++) {
            this.f3744b.add(new C1545d((C1542b) list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.f3746d = (C1544c) bundle.getSerializable("STATISTICS");
    }

    public void m4269a() {
        this.f3746d.m4282a();
    }

    public void m4270a(double d, double d2) {
        if (d2 >= 0.0d) {
            this.f3746d.m4285b(d, d2);
        }
        double a = C1546e.m4292a(this.f3743a, this.f3745c);
        this.f3746d.m4283a(d, a);
        for (C1545d a2 : this.f3744b) {
            a2.m4291a(d, a);
        }
    }

    public C1544c m4271b() {
        return this.f3746d;
    }

    public Bundle m4272c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("STATISTICS", this.f3746d);
        ArrayList arrayList = new ArrayList(this.f3744b.size());
        for (C1545d a : this.f3744b) {
            arrayList.add(a.m4290a());
        }
        bundle.putParcelableArrayList("TESTS", arrayList);
        return bundle;
    }
}
