package com.google.android.exoplayer2.p045c;

import java.util.ArrayList;
import java.util.List;

public final class C1994c implements C1964i {
    private static List<Class<? extends C1966f>> f5309a;

    public C1994c() {
        synchronized (C1994c.class) {
            if (f5309a == null) {
                List arrayList = new ArrayList();
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.b.d").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.d.e").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e2) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.d.f").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e3) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.c.c").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e4) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.c").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e5) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.a").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e6) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.p").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e7) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.a.b").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e8) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.e.c").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e9) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.n").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e10) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.g.a").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e11) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(C1966f.class));
                } catch (ClassNotFoundException e12) {
                }
                f5309a = arrayList;
            }
        }
    }

    public C1966f[] mo2939a() {
        C1966f[] c1966fArr = new C1966f[f5309a.size()];
        int i = 0;
        while (i < c1966fArr.length) {
            try {
                c1966fArr[i] = (C1966f) ((Class) f5309a.get(i)).getConstructor(new Class[0]).newInstance(new Object[0]);
                i++;
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error creating default extractor", e);
            }
        }
        return c1966fArr;
    }
}
