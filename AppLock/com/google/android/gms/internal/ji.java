package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ji {
    static final /* synthetic */ boolean f9527a = (!ji.class.desiredAssertionStatus());
    private final Map<js, ix> f9528b = new HashMap();

    public List<ix> m11907a() {
        return new ArrayList(this.f9528b.values());
    }

    public void m11908a(ix ixVar) {
        C2995a b = ixVar.m11834b();
        js a = ixVar.m11833a();
        if (!f9527a && b != C2995a.CHILD_ADDED && b != C2995a.CHILD_CHANGED && b != C2995a.CHILD_REMOVED) {
            throw new AssertionError("Only child changes supported for tracking");
        } else if (!f9527a && ixVar.m11833a().m12011e()) {
            throw new AssertionError();
        } else if (this.f9528b.containsKey(a)) {
            ix ixVar2 = (ix) this.f9528b.get(a);
            C2995a b2 = ixVar2.m11834b();
            if (b == C2995a.CHILD_ADDED && b2 == C2995a.CHILD_REMOVED) {
                this.f9528b.put(ixVar.m11833a(), ix.m11825a(a, ixVar.m11835c(), ixVar2.m11835c()));
            } else if (b == C2995a.CHILD_REMOVED && b2 == C2995a.CHILD_ADDED) {
                this.f9528b.remove(a);
            } else if (b == C2995a.CHILD_REMOVED && b2 == C2995a.CHILD_CHANGED) {
                this.f9528b.put(a, ix.m11829b(a, ixVar2.m11836d()));
            } else if (b == C2995a.CHILD_CHANGED && b2 == C2995a.CHILD_ADDED) {
                this.f9528b.put(a, ix.m11824a(a, ixVar.m11835c()));
            } else if (b == C2995a.CHILD_CHANGED && b2 == C2995a.CHILD_CHANGED) {
                this.f9528b.put(a, ix.m11825a(a, ixVar.m11835c(), ixVar2.m11836d()));
            } else {
                String valueOf = String.valueOf(ixVar);
                String valueOf2 = String.valueOf(ixVar2);
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 48) + String.valueOf(valueOf2).length()).append("Illegal combination of changes: ").append(valueOf).append(" occurred after ").append(valueOf2).toString());
            }
        } else {
            this.f9528b.put(ixVar.m11833a(), ixVar);
        }
    }
}
