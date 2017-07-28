package com.google.firebase.database;

import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.jz;
import com.google.android.gms.internal.ke;
import java.util.Iterator;

public class C3535a {
    private final jz f12148a;
    private final C3574d f12149b;

    C3535a(C3574d c3574d, jz jzVar) {
        this.f12148a = jzVar;
        this.f12149b = c3574d;
    }

    public C3535a m15455a(String str) {
        return new C3535a(this.f12149b.m15581a(str), jz.m12107a(this.f12148a.m12112a().mo3772a(new hh(str))));
    }

    public Object m15456a() {
        return this.f12148a.m12112a().mo3786a();
    }

    public Object m15457a(boolean z) {
        return this.f12148a.m12112a().mo3775a(z);
    }

    public C3574d m15458b() {
        return this.f12149b;
    }

    public String m15459c() {
        return this.f12149b.m15582b();
    }

    public Iterable<C3535a> m15460d() {
        final Iterator it = this.f12148a.iterator();
        return new Iterable<C3535a>(this) {
            final /* synthetic */ C3535a f12147b;

            class C35331 implements Iterator<C3535a> {
                final /* synthetic */ C35341 f12145a;

                C35331(C35341 c35341) {
                    this.f12145a = c35341;
                }

                public C3535a m15453a() {
                    ke keVar = (ke) it.next();
                    return new C3535a(this.f12145a.f12147b.f12149b.m15581a(keVar.m12169c().m12010d()), jz.m12107a(keVar.m12170d()));
                }

                public boolean hasNext() {
                    return it.hasNext();
                }

                public /* synthetic */ Object next() {
                    return m15453a();
                }

                public void remove() {
                    throw new UnsupportedOperationException("remove called on immutable collection");
                }
            }

            public Iterator<C3535a> iterator() {
                return new C35331(this);
            }
        };
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12149b.m15582b());
        String valueOf2 = String.valueOf(this.f12148a.m12112a().mo3775a(true));
        return new StringBuilder((String.valueOf(valueOf).length() + 33) + String.valueOf(valueOf2).length()).append("DataSnapshot { key = ").append(valueOf).append(", value = ").append(valueOf2).append(" }").toString();
    }
}
