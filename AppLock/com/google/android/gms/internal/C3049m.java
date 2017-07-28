package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2450d;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2471m;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.internal.C2539m.C2538a;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.p004b.C0625a;
import com.google.android.gms.p004b.C2428e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class C3049m implements ac {
    private final Map<C2450d<?>, C3037l<?>> f9753a = new HashMap();
    private final Map<C2450d<?>, C3037l<?>> f9754b = new HashMap();
    private final Map<C2456a<?>, Boolean> f9755c;
    private final C3424x f9756d;
    private final C3276t f9757e;
    private final Lock f9758f;
    private final Looper f9759g;
    private final C2480k f9760h;
    private final Condition f9761i;
    private final C2539m f9762j;
    private final boolean f9763k;
    private final boolean f9764l;
    private final Queue<C2676a<?, ?>> f9765m = new LinkedList();
    private boolean f9766n;
    private Map<acd<?>, ConnectionResult> f9767o;
    private Map<acd<?>, ConnectionResult> f9768p;
    private C3048b f9769q;
    private ConnectionResult f9770r;

    private class C3047a implements C0625a<Void> {
        final /* synthetic */ C3049m f9750a;

        private C3047a(C3049m c3049m) {
            this.f9750a = c3049m;
        }

        public void mo2380a(@NonNull C2428e<Void> c2428e) {
            this.f9750a.f9758f.lock();
            try {
                if (this.f9750a.f9766n) {
                    if (c2428e.mo3310a()) {
                        this.f9750a.f9767o = new ArrayMap(this.f9750a.f9753a.size());
                        for (C3037l b : this.f9750a.f9753a.values()) {
                            this.f9750a.f9767o.put(b.m7795b(), ConnectionResult.zzayj);
                        }
                    } else if (c2428e.mo3312c() instanceof C2471m) {
                        C2471m c2471m = (C2471m) c2428e.mo3312c();
                        if (this.f9750a.f9764l) {
                            this.f9750a.f9767o = new ArrayMap(this.f9750a.f9753a.size());
                            for (C3037l c3037l : this.f9750a.f9753a.values()) {
                                acd b2 = c3037l.m7795b();
                                ConnectionResult a = c2471m.m7787a(c3037l);
                                if (this.f9750a.m12462a(c3037l, a)) {
                                    this.f9750a.f9767o.put(b2, new ConnectionResult(16));
                                } else {
                                    this.f9750a.f9767o.put(b2, a);
                                }
                            }
                        } else {
                            this.f9750a.f9767o = c2471m.m7786a();
                        }
                        this.f9750a.f9770r = this.f9750a.m12474g();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", c2428e.mo3312c());
                        this.f9750a.f9767o = Collections.emptyMap();
                        this.f9750a.f9770r = new ConnectionResult(8);
                    }
                    if (this.f9750a.f9768p != null) {
                        this.f9750a.f9767o.putAll(this.f9750a.f9768p);
                        this.f9750a.f9770r = this.f9750a.m12474g();
                    }
                    if (this.f9750a.f9770r == null) {
                        this.f9750a.m12470e();
                        this.f9750a.m12473f();
                    } else {
                        this.f9750a.f9766n = false;
                        this.f9750a.f9757e.mo3802a(this.f9750a.f9770r);
                    }
                    this.f9750a.f9761i.signalAll();
                    this.f9750a.f9758f.unlock();
                }
            } finally {
                this.f9750a.f9758f.unlock();
            }
        }
    }

    private class C3048b implements C0625a<Void> {
        final /* synthetic */ C3049m f9751a;
        private ao f9752b;

        void m12456a() {
            this.f9752b.m8982a();
        }

        public void mo2380a(@NonNull C2428e<Void> c2428e) {
            this.f9751a.f9758f.lock();
            try {
                if (this.f9751a.f9766n) {
                    if (c2428e.mo3310a()) {
                        this.f9751a.f9768p = new ArrayMap(this.f9751a.f9754b.size());
                        for (C3037l b : this.f9751a.f9754b.values()) {
                            this.f9751a.f9768p.put(b.m7795b(), ConnectionResult.zzayj);
                        }
                    } else if (c2428e.mo3312c() instanceof C2471m) {
                        C2471m c2471m = (C2471m) c2428e.mo3312c();
                        if (this.f9751a.f9764l) {
                            this.f9751a.f9768p = new ArrayMap(this.f9751a.f9754b.size());
                            for (C3037l c3037l : this.f9751a.f9754b.values()) {
                                acd b2 = c3037l.m7795b();
                                ConnectionResult a = c2471m.m7787a(c3037l);
                                if (this.f9751a.m12462a(c3037l, a)) {
                                    this.f9751a.f9768p.put(b2, new ConnectionResult(16));
                                } else {
                                    this.f9751a.f9768p.put(b2, a);
                                }
                            }
                        } else {
                            this.f9751a.f9768p = c2471m.m7786a();
                        }
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", c2428e.mo3312c());
                        this.f9751a.f9768p = Collections.emptyMap();
                    }
                    if (this.f9751a.mo3807c()) {
                        this.f9751a.f9767o.putAll(this.f9751a.f9768p);
                        if (this.f9751a.m12474g() == null) {
                            this.f9751a.m12470e();
                            this.f9751a.m12473f();
                            this.f9751a.f9761i.signalAll();
                        }
                    }
                    this.f9752b.m8982a();
                    this.f9751a.f9758f.unlock();
                    return;
                }
                this.f9752b.m8982a();
            } finally {
                this.f9751a.f9758f.unlock();
            }
        }
    }

    public C3049m(Context context, Lock lock, Looper looper, C2480k c2480k, Map<C2450d<?>, C2451f> map, C2539m c2539m, Map<C2456a<?>, Boolean> map2, C2448b<? extends em, en> c2448b, ArrayList<C2977i> arrayList, C3276t c3276t, boolean z) {
        this.f9758f = lock;
        this.f9759g = looper;
        this.f9761i = lock.newCondition();
        this.f9760h = c2480k;
        this.f9757e = c3276t;
        this.f9755c = map2;
        this.f9762j = c2539m;
        this.f9763k = z;
        Map hashMap = new HashMap();
        for (C2456a c2456a : map2.keySet()) {
            hashMap.put(c2456a.m7751c(), c2456a);
        }
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2977i c2977i = (C2977i) it.next();
            hashMap2.put(c2977i.f9387a, c2977i);
        }
        Object obj = 1;
        Object obj2 = null;
        Object obj3 = null;
        for (Entry entry : map.entrySet()) {
            Object obj4;
            Object obj5;
            Object obj6;
            C2456a c2456a2 = (C2456a) hashMap.get(entry.getKey());
            C2451f c2451f = (C2451f) entry.getValue();
            if (c2451f.m7742e()) {
                obj4 = 1;
                if (((Boolean) this.f9755c.get(c2456a2)).booleanValue()) {
                    obj5 = obj;
                    obj6 = obj2;
                } else {
                    obj5 = obj;
                    obj6 = 1;
                }
            } else {
                obj4 = obj3;
                obj5 = null;
                obj6 = obj2;
            }
            C3037l c3037l = new C3037l(context, c2456a2, looper, c2451f, (C2977i) hashMap2.get(c2456a2), c2539m, c2448b);
            this.f9753a.put((C2450d) entry.getKey(), c3037l);
            if (c2451f.mo3584d()) {
                this.f9754b.put((C2450d) entry.getKey(), c3037l);
            }
            obj3 = obj4;
            obj = obj5;
            obj2 = obj6;
        }
        boolean z2 = obj3 != null && obj == null && obj2 == null;
        this.f9764l = z2;
        this.f9756d = C3424x.m14636a();
    }

    @Nullable
    private ConnectionResult m12458a(@NonNull C2450d<?> c2450d) {
        this.f9758f.lock();
        try {
            C3037l c3037l = (C3037l) this.f9753a.get(c2450d);
            if (this.f9767o == null || c3037l == null) {
                this.f9758f.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.f9767o.get(c3037l.m7795b());
            return connectionResult;
        } finally {
            this.f9758f.unlock();
        }
    }

    private boolean m12462a(C3037l<?> c3037l, ConnectionResult connectionResult) {
        return !connectionResult.m7713b() && !connectionResult.m7712a() && ((Boolean) this.f9755c.get(c3037l.m7792a())).booleanValue() && c3037l.m12278f().m7742e() && this.f9760h.mo3317a(connectionResult.m7714c());
    }

    private <T extends C2676a<? extends C2445g, ? extends C2449c>> boolean m12466b(@NonNull T t) {
        C2450d b = t.mo3473b();
        ConnectionResult a = m12458a(b);
        if (a == null || a.m7714c() != 4) {
            return false;
        }
        t.m8871a(new Status(4, null, this.f9756d.m14658a(((C3037l) this.f9753a.get(b)).m7795b(), this.f9757e.m13870k())));
        return true;
    }

    private void m12470e() {
        if (this.f9762j == null) {
            this.f9757e.f10651d = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.f9762j.m8049c());
        Map e = this.f9762j.m8051e();
        for (C2456a c2456a : e.keySet()) {
            ConnectionResult a = m12482a(c2456a);
            if (a != null && a.m7713b()) {
                hashSet.addAll(((C2538a) e.get(c2456a)).f7442a);
            }
        }
        this.f9757e.f10651d = hashSet;
    }

    private void m12473f() {
        while (!this.f9765m.isEmpty()) {
            mo3803a((C2676a) this.f9765m.remove());
        }
        this.f9757e.mo3801a(null);
    }

    @Nullable
    private ConnectionResult m12474g() {
        int i = 0;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        for (C3037l c3037l : this.f9753a.values()) {
            C2456a a = c3037l.m7792a();
            ConnectionResult connectionResult3 = (ConnectionResult) this.f9767o.get(c3037l.m7795b());
            if (!connectionResult3.m7713b() && (!((Boolean) this.f9755c.get(a)).booleanValue() || connectionResult3.m7712a() || this.f9760h.mo3317a(connectionResult3.m7714c()))) {
                int a2;
                if (connectionResult3.m7714c() == 4 && this.f9763k) {
                    a2 = a.m7749a().m7732a();
                    if (connectionResult == null || i > a2) {
                        i = a2;
                        connectionResult = connectionResult3;
                    }
                } else {
                    ConnectionResult connectionResult4;
                    int i3;
                    a2 = a.m7749a().m7732a();
                    if (connectionResult2 == null || i2 > a2) {
                        int i4 = a2;
                        connectionResult4 = connectionResult3;
                        i3 = i4;
                    } else {
                        i3 = i2;
                        connectionResult4 = connectionResult2;
                    }
                    i2 = i3;
                    connectionResult2 = connectionResult4;
                }
            }
        }
        return (connectionResult2 == null || connectionResult == null || i2 <= i) ? connectionResult2 : connectionResult;
    }

    @Nullable
    public ConnectionResult m12482a(@NonNull C2456a<?> c2456a) {
        return m12458a(c2456a.m7751c());
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3803a(@NonNull T t) {
        C2450d b = t.mo3473b();
        if (this.f9763k && m12466b((C2676a) t)) {
            return t;
        }
        this.f9757e.f10656i.m9037a((C2675h) t);
        return ((C3037l) this.f9753a.get(b)).m7794a(t);
    }

    public void mo3804a() {
        this.f9758f.lock();
        try {
            if (!this.f9766n) {
                this.f9766n = true;
                this.f9767o = null;
                this.f9768p = null;
                this.f9769q = null;
                this.f9770r = null;
                this.f9756d.m14667c();
                this.f9756d.m14659a(this.f9753a.values()).mo3307a(new bh(this.f9759g), new C3047a());
                this.f9758f.unlock();
            }
        } finally {
            this.f9758f.unlock();
        }
    }

    public void mo3805a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void mo3806b() {
        this.f9758f.lock();
        try {
            this.f9766n = false;
            this.f9767o = null;
            this.f9768p = null;
            if (this.f9769q != null) {
                this.f9769q.m12456a();
                this.f9769q = null;
            }
            this.f9770r = null;
            while (!this.f9765m.isEmpty()) {
                C2676a c2676a = (C2676a) this.f9765m.remove();
                c2676a.m8861a(null);
                c2676a.m8865e();
            }
            this.f9761i.signalAll();
        } finally {
            this.f9758f.unlock();
        }
    }

    public boolean mo3807c() {
        this.f9758f.lock();
        try {
            boolean z = this.f9767o != null && this.f9770r == null;
            this.f9758f.unlock();
            return z;
        } catch (Throwable th) {
            this.f9758f.unlock();
        }
    }

    public void mo3808d() {
    }
}
