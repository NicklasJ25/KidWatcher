package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jc {
    private final he f9490a;
    private final jp f9491b;

    public jc(ha haVar) {
        this.f9490a = haVar.m11325j();
        this.f9491b = haVar.m11314a("EventRaiser");
    }

    public void m11849a(List<? extends iz> list) {
        if (this.f9491b.m11961a()) {
            this.f9491b.m11960a("Raising " + list.size() + " event(s)", new Object[0]);
        }
        final ArrayList arrayList = new ArrayList(list);
        this.f9490a.mo3600a(new Runnable(this) {
            final /* synthetic */ jc f9489b;

            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    iz izVar = (iz) it.next();
                    if (this.f9489b.f9491b.m11961a()) {
                        jp a = this.f9489b.f9491b;
                        String str = "Raising ";
                        String valueOf = String.valueOf(izVar.toString());
                        a.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                    }
                    izVar.mo3755b();
                }
            }
        });
    }
}
