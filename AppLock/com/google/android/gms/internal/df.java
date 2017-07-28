package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.bn.C2705a;
import com.google.android.gms.internal.bp.C2711a;
import com.google.android.gms.internal.bp.C2711a.C2709a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class df extends ci {
    protected static final Object f8208l = new Object();
    protected static volatile ez f8209m = null;
    static boolean f8210n = false;
    private static final String f8211s = df.class.getSimpleName();
    private static long f8212t = 0;
    protected boolean f8213o = false;
    protected String f8214p;
    protected boolean f8215q = false;
    protected boolean f8216r = false;

    protected df(Context context, String str) {
        super(context);
        this.f8214p = str;
        this.f8213o = false;
    }

    protected df(Context context, String str, boolean z) {
        super(context);
        this.f8214p = str;
        this.f8213o = z;
    }

    static fa m9318a(ez ezVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        Throwable e;
        Method a = ezVar.m10719a(eh.m10587J(), eh.m10588K());
        if (a == null || motionEvent == null) {
            throw new ek();
        }
        try {
            return new fa((String) a.invoke(null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new ek(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new ek(e);
        }
    }

    protected static synchronized void m9319a(Context context, boolean z) {
        synchronized (df.class) {
            if (!f8210n) {
                f8212t = fb.m10740a().longValue() / 1000;
                f8209m = m9322b(context, z);
                f8210n = true;
            }
        }
    }

    private static void m9320a(ez ezVar) {
        List singletonList = Collections.singletonList(Context.class);
        ezVar.m10720a(eh.m10608p(), eh.m10609q(), singletonList);
        ezVar.m10720a(eh.m10618z(), eh.m10578A(), singletonList);
        ezVar.m10720a(eh.m10616x(), eh.m10617y(), singletonList);
        ezVar.m10720a(eh.m10602j(), eh.m10603k(), singletonList);
        ezVar.m10720a(eh.m10612t(), eh.m10613u(), singletonList);
        ezVar.m10720a(eh.m10596d(), eh.m10597e(), singletonList);
        ezVar.m10720a(eh.m10589L(), eh.m10590M(), singletonList);
        ezVar.m10720a(eh.m10598f(), eh.m10599g(), singletonList);
        singletonList = Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class});
        ezVar.m10720a(eh.m10587J(), eh.m10588K(), singletonList);
        ezVar.m10720a(eh.m10585H(), eh.m10586I(), singletonList);
        ezVar.m10720a(eh.m10606n(), eh.m10607o(), Collections.emptyList());
        ezVar.m10720a(eh.m10583F(), eh.m10584G(), Collections.emptyList());
        ezVar.m10720a(eh.m10614v(), eh.m10615w(), Collections.emptyList());
        ezVar.m10720a(eh.m10604l(), eh.m10605m(), Collections.emptyList());
        ezVar.m10720a(eh.m10610r(), eh.m10611s(), Collections.emptyList());
        ezVar.m10720a(eh.m10581D(), eh.m10582E(), Collections.emptyList());
        ezVar.m10720a(eh.m10600h(), eh.m10601i(), Arrays.asList(new Class[]{Context.class, Boolean.TYPE}));
        ezVar.m10720a(eh.m10579B(), eh.m10580C(), Arrays.asList(new Class[]{StackTraceElement[].class}));
        ezVar.m10720a(eh.m10591N(), eh.m10592O(), Arrays.asList(new Class[]{View.class}));
    }

    private void m9321a(ez ezVar, C2711a c2711a) {
        C2709a c2709a;
        int i = 1;
        try {
            fa a = m9318a(ezVar, this.a, this.k);
            c2711a.f8055n = a.f8888a;
            c2711a.f8056o = a.f8889b;
            c2711a.f8057p = a.f8890c;
            if (this.j) {
                c2711a.f8019D = a.f8891d;
                c2711a.f8020E = a.f8892e;
            }
            c2709a = new C2709a();
            fa b = mo3526b(this.a);
            c2709a.f8001a = b.f8888a;
            c2709a.f8002b = b.f8889b;
            c2709a.f8008h = b.f8890c;
            if (this.j) {
                c2709a.f8003c = b.f8892e;
                c2709a.f8005e = b.f8891d;
                c2709a.f8007g = Integer.valueOf(b.f8893f.longValue() != 0 ? 1 : 0);
                if (this.d > 0) {
                    c2709a.f8004d = this.k != null ? Long.valueOf(Math.round(((double) this.i) / ((double) this.d))) : null;
                    c2709a.f8006f = Long.valueOf(Math.round(((double) this.h) / ((double) this.d)));
                }
                c2709a.f8010j = b.f8896i;
                c2709a.f8009i = b.f8897j;
                if (b.f8898k.longValue() == 0) {
                    i = 0;
                }
                c2709a.f8011k = Integer.valueOf(i);
                if (this.g > 0) {
                    c2709a.f8012l = Long.valueOf(this.g);
                }
            }
            c2711a.f8038W = c2709a;
        } catch (ek e) {
        }
        if (this.c > 0) {
            c2711a.f8024I = Long.valueOf(this.c);
        }
        if (this.d > 0) {
            c2711a.f8023H = Long.valueOf(this.d);
        }
        if (this.e > 0) {
            c2711a.f8022G = Long.valueOf(this.e);
        }
        if (this.f > 0) {
            c2711a.f8025J = Long.valueOf(this.f);
        }
        try {
            int size = this.b.size() - 1;
            if (size > 0) {
                c2711a.f8039X = new C2709a[size];
                for (i = 0; i < size; i++) {
                    fa a2 = m9318a(ezVar, (MotionEvent) this.b.get(i), this.k);
                    c2709a = new C2709a();
                    c2709a.f8001a = a2.f8888a;
                    c2709a.f8002b = a2.f8889b;
                    c2711a.f8039X[i] = c2709a;
                }
            }
        } catch (ek e2) {
            c2711a.f8039X = null;
        }
    }

    protected static ez m9322b(Context context, boolean z) {
        if (f8209m == null) {
            synchronized (f8208l) {
                if (f8209m == null) {
                    ez a = ez.m10701a(context, eh.m10593a(), eh.m10595c(), z);
                    m9320a(a);
                    f8209m = a;
                }
            }
        }
        return f8209m;
    }

    protected long mo3523a(StackTraceElement[] stackTraceElementArr) {
        Throwable e;
        Method a = f8209m.m10719a(eh.m10579B(), eh.m10580C());
        if (a == null || stackTraceElementArr == null) {
            throw new ek();
        }
        try {
            return new ex((String) a.invoke(null, new Object[]{stackTraceElementArr})).f8858a.longValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new ek(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new ek(e);
        }
    }

    protected C2711a mo3524a(Context context, View view) {
        C2711a c2711a = new C2711a();
        if (!TextUtils.isEmpty(this.f8214p)) {
            c2711a.f8043b = this.f8214p;
        }
        ez b = m9322b(context, this.f8213o);
        b.m10735p();
        m9331b(b, c2711a, view);
        b.m10736q();
        return c2711a;
    }

    protected C2711a mo3525a(Context context, C2705a c2705a) {
        C2711a c2711a = new C2711a();
        if (!TextUtils.isEmpty(this.f8214p)) {
            c2711a.f8043b = this.f8214p;
        }
        ez b = m9322b(context, this.f8213o);
        b.m10735p();
        mo3527a(b, c2711a, c2705a);
        b.m10736q();
        return c2711a;
    }

    protected List<Callable<Void>> m9326a(ez ezVar, C2711a c2711a, View view) {
        ArrayList arrayList = new ArrayList();
        if (ezVar.m10722c() == null) {
            return arrayList;
        }
        int r = ezVar.m10737r();
        arrayList.add(new gz(ezVar, c2711a));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new kc(ezVar, eh.m10614v(), eh.m10615w(), c2711a, r, 1));
        arrayList2 = arrayList;
        arrayList2.add(new fk(ezVar, eh.m10606n(), eh.m10607o(), c2711a, f8212t, r, 25));
        arrayList2 = arrayList;
        arrayList2.add(new fj(ezVar, eh.m10604l(), eh.m10605m(), c2711a, r, 44));
        arrayList2 = arrayList;
        arrayList2.add(new fd(ezVar, eh.m10596d(), eh.m10597e(), c2711a, r, 3));
        arrayList2 = arrayList;
        arrayList2.add(new ia(ezVar, eh.m10610r(), eh.m10611s(), c2711a, r, 22));
        arrayList2 = arrayList;
        arrayList2.add(new fh(ezVar, eh.m10602j(), eh.m10603k(), c2711a, r, 5));
        arrayList2 = arrayList;
        arrayList2.add(new lq(ezVar, eh.m10589L(), eh.m10590M(), c2711a, r, 48));
        if (((Boolean) qb.bL.m13225c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new fe(ezVar, eh.m10598f(), eh.m10599g(), c2711a, r, 49));
        }
        arrayList2 = arrayList;
        arrayList2.add(new lo(ezVar, eh.m10581D(), eh.m10582E(), c2711a, r, 51));
        arrayList2 = arrayList;
        arrayList2.add(new ln(ezVar, eh.m10579B(), eh.m10580C(), c2711a, r, 45, new Throwable().getStackTrace()));
        if (((Boolean) qb.bM.m13225c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new ls(ezVar, eh.m10591N(), eh.m10592O(), c2711a, r, 57, view));
        }
        return arrayList;
    }

    protected void mo3527a(ez ezVar, C2711a c2711a, C2705a c2705a) {
        if (ezVar.m10722c() != null) {
            m9328a(mo3528b(ezVar, c2711a, c2705a));
        }
    }

    protected void m9328a(List<Callable<Void>> list) {
        if (f8209m != null) {
            ExecutorService c = f8209m.m10722c();
            if (c != null && !list.isEmpty()) {
                try {
                    c.invokeAll(list, ((Long) qb.bI.m13225c()).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(f8211s, String.format("class methods got exception: %s", new Object[]{fb.m10742a(e)}));
                }
            }
        }
    }

    protected fa mo3526b(MotionEvent motionEvent) {
        Throwable e;
        Method a = f8209m.m10719a(eh.m10585H(), eh.m10586I());
        if (a == null || motionEvent == null) {
            throw new ek();
        }
        try {
            return new fa((String) a.invoke(null, new Object[]{motionEvent, this.k}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new ek(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new ek(e);
        }
    }

    protected List<Callable<Void>> mo3528b(ez ezVar, C2711a c2711a, C2705a c2705a) {
        int r = ezVar.m10737r();
        List arrayList = new ArrayList();
        List list = arrayList;
        list.add(new fg(ezVar, eh.m10600h(), eh.m10601i(), c2711a, r, 27, c2705a));
        list = arrayList;
        list.add(new fk(ezVar, eh.m10606n(), eh.m10607o(), c2711a, f8212t, r, 25));
        list = arrayList;
        list.add(new kc(ezVar, eh.m10614v(), eh.m10615w(), c2711a, r, 1));
        list = arrayList;
        list.add(new ld(ezVar, eh.m10616x(), eh.m10617y(), c2711a, r, 31));
        list = arrayList;
        list.add(new lp(ezVar, eh.m10583F(), eh.m10584G(), c2711a, r, 33));
        list = arrayList;
        list.add(new ff(ezVar, eh.m10618z(), eh.m10578A(), c2711a, r, 29));
        list = arrayList;
        list.add(new fh(ezVar, eh.m10602j(), eh.m10603k(), c2711a, r, 5));
        list = arrayList;
        list.add(new jb(ezVar, eh.m10612t(), eh.m10613u(), c2711a, r, 12));
        list = arrayList;
        list.add(new fd(ezVar, eh.m10596d(), eh.m10597e(), c2711a, r, 3));
        list = arrayList;
        list.add(new fj(ezVar, eh.m10604l(), eh.m10605m(), c2711a, r, 44));
        list = arrayList;
        list.add(new ia(ezVar, eh.m10610r(), eh.m10611s(), c2711a, r, 22));
        list = arrayList;
        list.add(new lq(ezVar, eh.m10589L(), eh.m10590M(), c2711a, r, 48));
        if (((Boolean) qb.bK.m13225c()).booleanValue()) {
            list = arrayList;
            list.add(new fe(ezVar, eh.m10598f(), eh.m10599g(), c2711a, r, 49));
        }
        list = arrayList;
        list.add(new lo(ezVar, eh.m10581D(), eh.m10582E(), c2711a, r, 51));
        return arrayList;
    }

    protected void m9331b(ez ezVar, C2711a c2711a, View view) {
        m9321a(ezVar, c2711a);
        m9328a(m9326a(ezVar, c2711a, view));
    }
}
