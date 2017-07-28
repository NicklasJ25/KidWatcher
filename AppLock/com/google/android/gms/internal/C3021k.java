package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.ac.C2683a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class C3021k implements ac {
    private final Context f9597a;
    private final C3276t f9598b;
    private final Looper f9599c;
    private final C3349v f9600d;
    private final C3349v f9601e;
    private final Map<C2450d<?>, C3349v> f9602f;
    private final Set<ao> f9603g = Collections.newSetFromMap(new WeakHashMap());
    private final C2451f f9604h;
    private Bundle f9605i;
    private ConnectionResult f9606j = null;
    private ConnectionResult f9607k = null;
    private boolean f9608l = false;
    private final Lock f9609m;
    private int f9610n = 0;

    class C30181 implements Runnable {
        final /* synthetic */ C3021k f9594a;

        public void run() {
            this.f9594a.f9609m.lock();
            try {
                this.f9594a.m12142g();
            } finally {
                this.f9594a.f9609m.unlock();
            }
        }
    }

    private class C3019a implements C2683a {
        final /* synthetic */ C3021k f9595a;

        private C3019a(C3021k c3021k) {
            this.f9595a = c3021k;
        }

        public void mo3800a(int i, boolean z) {
            this.f9595a.f9609m.lock();
            try {
                if (this.f9595a.f9608l || this.f9595a.f9607k == null || !this.f9595a.f9607k.m7713b()) {
                    this.f9595a.f9608l = false;
                    this.f9595a.m12127a(i, z);
                    return;
                }
                this.f9595a.f9608l = true;
                this.f9595a.f9601e.mo3496a(i);
                this.f9595a.f9609m.unlock();
            } finally {
                this.f9595a.f9609m.unlock();
            }
        }

        public void mo3801a(@Nullable Bundle bundle) {
            this.f9595a.f9609m.lock();
            try {
                this.f9595a.m12128a(bundle);
                this.f9595a.f9606j = ConnectionResult.zzayj;
                this.f9595a.m12142g();
            } finally {
                this.f9595a.f9609m.unlock();
            }
        }

        public void mo3802a(@NonNull ConnectionResult connectionResult) {
            this.f9595a.f9609m.lock();
            try {
                this.f9595a.f9606j = connectionResult;
                this.f9595a.m12142g();
            } finally {
                this.f9595a.f9609m.unlock();
            }
        }
    }

    private class C3020b implements C2683a {
        final /* synthetic */ C3021k f9596a;

        private C3020b(C3021k c3021k) {
            this.f9596a = c3021k;
        }

        public void mo3800a(int i, boolean z) {
            this.f9596a.f9609m.lock();
            try {
                if (this.f9596a.f9608l) {
                    this.f9596a.f9608l = false;
                    this.f9596a.m12127a(i, z);
                    return;
                }
                this.f9596a.f9608l = true;
                this.f9596a.f9600d.mo3496a(i);
                this.f9596a.f9609m.unlock();
            } finally {
                this.f9596a.f9609m.unlock();
            }
        }

        public void mo3801a(@Nullable Bundle bundle) {
            this.f9596a.f9609m.lock();
            try {
                this.f9596a.f9607k = ConnectionResult.zzayj;
                this.f9596a.m12142g();
            } finally {
                this.f9596a.f9609m.unlock();
            }
        }

        public void mo3802a(@NonNull ConnectionResult connectionResult) {
            this.f9596a.f9609m.lock();
            try {
                this.f9596a.f9607k = connectionResult;
                this.f9596a.m12142g();
            } finally {
                this.f9596a.f9609m.unlock();
            }
        }
    }

    private C3021k(Context context, C3276t c3276t, Lock lock, Looper looper, C2480k c2480k, Map<C2450d<?>, C2451f> map, Map<C2450d<?>, C2451f> map2, C2539m c2539m, C2448b<? extends em, en> c2448b, C2451f c2451f, ArrayList<C2977i> arrayList, ArrayList<C2977i> arrayList2, Map<C2456a<?>, Boolean> map3, Map<C2456a<?>, Boolean> map4) {
        this.f9597a = context;
        this.f9598b = c3276t;
        this.f9609m = lock;
        this.f9599c = looper;
        this.f9604h = c2451f;
        this.f9600d = new C3349v(context, this.f9598b, lock, looper, c2480k, map2, null, map4, null, arrayList2, new C3019a());
        this.f9601e = new C3349v(context, this.f9598b, lock, looper, c2480k, map, c2539m, map3, c2448b, arrayList, new C3020b());
        Map arrayMap = new ArrayMap();
        for (C2450d put : map2.keySet()) {
            arrayMap.put(put, this.f9600d);
        }
        for (C2450d put2 : map.keySet()) {
            arrayMap.put(put2, this.f9601e);
        }
        this.f9602f = Collections.unmodifiableMap(arrayMap);
    }

    public static C3021k m12125a(Context context, C3276t c3276t, Lock lock, Looper looper, C2480k c2480k, Map<C2450d<?>, C2451f> map, C2539m c2539m, Map<C2456a<?>, Boolean> map2, C2448b<? extends em, en> c2448b, ArrayList<C2977i> arrayList) {
        C2451f c2451f = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (Entry entry : map.entrySet()) {
            C2451f c2451f2 = (C2451f) entry.getValue();
            if (c2451f2.m7743f()) {
                c2451f = c2451f2;
            }
            if (c2451f2.mo3584d()) {
                arrayMap.put((C2450d) entry.getKey(), c2451f2);
            } else {
                arrayMap2.put((C2450d) entry.getKey(), c2451f2);
            }
        }
        C2513c.m7938a(!arrayMap.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (C2456a c2456a : map2.keySet()) {
            C2450d c = c2456a.m7751c();
            if (arrayMap.containsKey(c)) {
                arrayMap3.put(c2456a, (Boolean) map2.get(c2456a));
            } else if (arrayMap2.containsKey(c)) {
                arrayMap4.put(c2456a, (Boolean) map2.get(c2456a));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2977i c2977i = (C2977i) it.next();
            if (arrayMap3.containsKey(c2977i.f9387a)) {
                arrayList2.add(c2977i);
            } else if (arrayMap4.containsKey(c2977i.f9387a)) {
                arrayList3.add(c2977i);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new C3021k(context, c3276t, lock, looper, c2480k, arrayMap, arrayMap2, c2539m, c2448b, c2451f, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private void m12127a(int i, boolean z) {
        this.f9598b.mo3800a(i, z);
        this.f9607k = null;
        this.f9606j = null;
    }

    private void m12128a(Bundle bundle) {
        if (this.f9605i == null) {
            this.f9605i = bundle;
        } else if (bundle != null) {
            this.f9605i.putAll(bundle);
        }
    }

    private void m12129a(ConnectionResult connectionResult) {
        switch (this.f9610n) {
            case 1:
                break;
            case 2:
                this.f9598b.mo3802a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m12144i();
        this.f9610n = 0;
    }

    private static boolean m12135b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m7713b();
    }

    private boolean m12136b(C2676a<? extends C2445g, ? extends C2449c> c2676a) {
        C2450d b = c2676a.mo3473b();
        C2513c.m7942b(this.f9602f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((C3349v) this.f9602f.get(b)).equals(this.f9601e);
    }

    private void m12141f() {
        this.f9607k = null;
        this.f9606j = null;
        this.f9600d.mo3804a();
        this.f9601e.mo3804a();
    }

    private void m12142g() {
        if (C3021k.m12135b(this.f9606j)) {
            if (C3021k.m12135b(this.f9607k) || m12145j()) {
                m12143h();
            } else if (this.f9607k == null) {
            } else {
                if (this.f9610n == 1) {
                    m12144i();
                    return;
                }
                m12129a(this.f9607k);
                this.f9600d.mo3806b();
            }
        } else if (this.f9606j != null && C3021k.m12135b(this.f9607k)) {
            this.f9601e.mo3806b();
            m12129a(this.f9606j);
        } else if (this.f9606j != null && this.f9607k != null) {
            ConnectionResult connectionResult = this.f9606j;
            if (this.f9601e.f10988f < this.f9600d.f10988f) {
                connectionResult = this.f9607k;
            }
            m12129a(connectionResult);
        }
    }

    private void m12143h() {
        switch (this.f9610n) {
            case 1:
                break;
            case 2:
                this.f9598b.mo3801a(this.f9605i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m12144i();
        this.f9610n = 0;
    }

    private void m12144i() {
        for (ao a : this.f9603g) {
            a.m8982a();
        }
        this.f9603g.clear();
    }

    private boolean m12145j() {
        return this.f9607k != null && this.f9607k.m7714c() == 4;
    }

    @Nullable
    private PendingIntent m12146k() {
        return this.f9604h == null ? null : PendingIntent.getActivity(this.f9597a, this.f9598b.m13870k(), this.f9604h.m7744g(), 134217728);
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3803a(@NonNull T t) {
        if (!m12136b((C2676a) t)) {
            return this.f9600d.mo3803a((C2676a) t);
        }
        if (!m12145j()) {
            return this.f9601e.mo3803a((C2676a) t);
        }
        t.m8871a(new Status(4, null, m12146k()));
        return t;
    }

    public void mo3804a() {
        this.f9610n = 2;
        this.f9608l = false;
        m12141f();
    }

    public void mo3805a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f9601e.mo3805a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f9600d.mo3805a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public void mo3806b() {
        this.f9607k = null;
        this.f9606j = null;
        this.f9610n = 0;
        this.f9600d.mo3806b();
        this.f9601e.mo3806b();
        m12144i();
    }

    public boolean mo3807c() {
        boolean z = true;
        this.f9609m.lock();
        try {
            if (!(this.f9600d.mo3807c() && (m12153e() || m12145j() || this.f9610n == 1))) {
                z = false;
            }
            this.f9609m.unlock();
            return z;
        } catch (Throwable th) {
            this.f9609m.unlock();
        }
    }

    public void mo3808d() {
        this.f9600d.mo3808d();
        this.f9601e.mo3808d();
    }

    public boolean m12153e() {
        return this.f9601e.mo3807c();
    }
}
