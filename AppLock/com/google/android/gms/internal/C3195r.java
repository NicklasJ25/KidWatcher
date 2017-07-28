package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2450d;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2503v;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2517l.C2530f;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.internal.C2539m.C2538a;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.C3349v.C3162a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class C3195r implements C3165u {
    private final C3349v f10446a;
    private final Lock f10447b;
    private final Context f10448c;
    private final C2480k f10449d;
    private ConnectionResult f10450e;
    private int f10451f;
    private int f10452g = 0;
    private int f10453h;
    private final Bundle f10454i = new Bundle();
    private final Set<C2450d> f10455j = new HashSet();
    private em f10456k;
    private boolean f10457l;
    private boolean f10458m;
    private boolean f10459n;
    private C2503v f10460o;
    private boolean f10461p;
    private boolean f10462q;
    private final C2539m f10463r;
    private final Map<C2456a<?>, Boolean> f10464s;
    private final C2448b<? extends em, en> f10465t;
    private ArrayList<Future<?>> f10466u = new ArrayList();

    class C31851 implements Runnable {
        final /* synthetic */ C3195r f10430a;

        C31851(C3195r c3195r) {
            this.f10430a = c3195r;
        }

        public void run() {
            this.f10430a.f10449d.m7819d(this.f10430a.f10448c);
        }
    }

    private static class C3186a implements C2530f {
        private final WeakReference<C3195r> f10431a;
        private final C2456a<?> f10432b;
        private final boolean f10433c;

        public C3186a(C3195r c3195r, C2456a<?> c2456a, boolean z) {
            this.f10431a = new WeakReference(c3195r);
            this.f10432b = c2456a;
            this.f10433c = z;
        }

        public void mo3342a(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            C3195r c3195r = (C3195r) this.f10431a.get();
            if (c3195r != null) {
                if (Looper.myLooper() == c3195r.f10446a.f10989g.mo4028a()) {
                    z = true;
                }
                C2513c.m7938a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                c3195r.f10447b.lock();
                try {
                    if (c3195r.m13520b(0)) {
                        if (!connectionResult.m7713b()) {
                            c3195r.m13519b(connectionResult, this.f10432b, this.f10433c);
                        }
                        if (c3195r.m13527d()) {
                            c3195r.m13528e();
                        }
                        c3195r.f10447b.unlock();
                    }
                } finally {
                    c3195r.f10447b.unlock();
                }
            }
        }
    }

    private abstract class C3189f implements Runnable {
        final /* synthetic */ C3195r f10437b;

        private C3189f(C3195r c3195r) {
            this.f10437b = c3195r;
        }

        @WorkerThread
        protected abstract void mo3973a();

        @WorkerThread
        public void run() {
            this.f10437b.f10447b.lock();
            try {
                if (!Thread.interrupted()) {
                    mo3973a();
                    this.f10437b.f10447b.unlock();
                }
            } catch (RuntimeException e) {
                this.f10437b.f10446a.m14335a(e);
            } finally {
                this.f10437b.f10447b.unlock();
            }
        }
    }

    private class C3190b extends C3189f {
        final /* synthetic */ C3195r f10438a;
        private final Map<C2451f, C3186a> f10439c;

        public C3190b(C3195r c3195r, Map<C2451f, C3186a> map) {
            this.f10438a = c3195r;
            super();
            this.f10439c = map;
        }

        @WorkerThread
        public void mo3973a() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (C2451f c2451f : this.f10439c.keySet()) {
                if (!c2451f.m7742e()) {
                    i = 0;
                    i4 = i5;
                } else if (!((C3186a) this.f10439c.get(c2451f)).f10433c) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = this.f10438a.f10449d.mo3314a(this.f10438a.f10448c);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.f10438a.f10458m) {
                    this.f10438a.f10456k.mo3585l();
                }
                for (C2451f c2451f2 : this.f10439c.keySet()) {
                    final C2530f c2530f = (C2530f) this.f10439c.get(c2451f2);
                    if (!c2451f2.m7742e() || i3 == 0) {
                        c2451f2.m7736a(c2530f);
                    } else {
                        this.f10438a.f10446a.m14334a(new C3162a(this, this.f10438a) {
                            public void mo3899a() {
                                c2530f.mo3342a(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i3, null);
            this.f10438a.f10446a.m14334a(new C3162a(this, this.f10438a) {
                final /* synthetic */ C3190b f10435b;

                public void mo3899a() {
                    this.f10435b.f10438a.m13525c(connectionResult);
                }
            });
        }
    }

    private class C3191c extends C3189f {
        final /* synthetic */ C3195r f10440a;
        private final ArrayList<C2451f> f10441c;

        public C3191c(C3195r c3195r, ArrayList<C2451f> arrayList) {
            this.f10440a = c3195r;
            super();
            this.f10441c = arrayList;
        }

        @WorkerThread
        public void mo3973a() {
            this.f10440a.f10446a.f10989g.f10651d = this.f10440a.m13538j();
            Iterator it = this.f10441c.iterator();
            while (it.hasNext()) {
                ((C2451f) it.next()).m7737a(this.f10440a.f10460o, this.f10440a.f10446a.f10989g.f10651d);
            }
        }
    }

    private static class C3193d extends ep {
        private final WeakReference<C3195r> f10444a;

        C3193d(C3195r c3195r) {
            this.f10444a = new WeakReference(c3195r);
        }

        @BinderThread
        public void mo3494a(final zzbaw com_google_android_gms_internal_zzbaw) {
            final C3195r c3195r = (C3195r) this.f10444a.get();
            if (c3195r != null) {
                c3195r.f10446a.m14334a(new C3162a(this, c3195r) {
                    public void mo3899a() {
                        c3195r.m13513a(com_google_android_gms_internal_zzbaw);
                    }
                });
            }
        }
    }

    private class C3194e implements C2459b, C2460c {
        final /* synthetic */ C3195r f10445a;

        private C3194e(C3195r c3195r) {
            this.f10445a = c3195r;
        }

        public void mo3496a(int i) {
        }

        public void mo3497a(Bundle bundle) {
            this.f10445a.f10456k.mo3583a(new C3193d(this.f10445a));
        }

        public void mo3498a(@NonNull ConnectionResult connectionResult) {
            this.f10445a.f10447b.lock();
            try {
                if (this.f10445a.m13521b(connectionResult)) {
                    this.f10445a.m13535h();
                    this.f10445a.m13528e();
                } else {
                    this.f10445a.m13525c(connectionResult);
                }
                this.f10445a.f10447b.unlock();
            } catch (Throwable th) {
                this.f10445a.f10447b.unlock();
            }
        }
    }

    public C3195r(C3349v c3349v, C2539m c2539m, Map<C2456a<?>, Boolean> map, C2480k c2480k, C2448b<? extends em, en> c2448b, Lock lock, Context context) {
        this.f10446a = c3349v;
        this.f10463r = c2539m;
        this.f10464s = map;
        this.f10449d = c2480k;
        this.f10465t = c2448b;
        this.f10447b = lock;
        this.f10448c = context;
    }

    private void m13513a(zzbaw com_google_android_gms_internal_zzbaw) {
        if (m13520b(0)) {
            ConnectionResult a = com_google_android_gms_internal_zzbaw.m15371a();
            if (a.m7713b()) {
                zzaf b = com_google_android_gms_internal_zzbaw.m15372b();
                ConnectionResult b2 = b.m8191b();
                if (b2.m7713b()) {
                    this.f10459n = true;
                    this.f10460o = b.m8190a();
                    this.f10461p = b.m8192c();
                    this.f10462q = b.m8193d();
                    m13528e();
                    return;
                }
                String valueOf = String.valueOf(b2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m13525c(b2);
            } else if (m13521b(a)) {
                m13535h();
                m13528e();
            } else {
                m13525c(a);
            }
        }
    }

    private void m13514a(boolean z) {
        if (this.f10456k != null) {
            if (this.f10456k.m7739b() && z) {
                this.f10456k.mo3338k();
            }
            this.f10456k.m7735a();
            this.f10460o = null;
        }
    }

    private boolean m13515a(int i, boolean z, ConnectionResult connectionResult) {
        return (!z || m13516a(connectionResult)) ? this.f10450e == null || i < this.f10451f : false;
    }

    private boolean m13516a(ConnectionResult connectionResult) {
        return connectionResult.m7712a() || this.f10449d.mo3319b(connectionResult.m7714c()) != null;
    }

    private void m13519b(ConnectionResult connectionResult, C2456a<?> c2456a, boolean z) {
        int a = c2456a.m7749a().m7732a();
        if (m13515a(a, z, connectionResult)) {
            this.f10450e = connectionResult;
            this.f10451f = a;
        }
        this.f10446a.f10984b.put(c2456a.m7751c(), connectionResult);
    }

    private boolean m13520b(int i) {
        if (this.f10452g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f10446a.f10989g.m13869j());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.f10453h);
        valueOf = String.valueOf(m13523c(this.f10452g));
        String valueOf2 = String.valueOf(m13523c(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m13525c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m13521b(ConnectionResult connectionResult) {
        return this.f10457l && !connectionResult.m7712a();
    }

    private String m13523c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m13525c(ConnectionResult connectionResult) {
        m13536i();
        m13514a(!connectionResult.m7712a());
        this.f10446a.m14332a(connectionResult);
        this.f10446a.f10990h.mo3802a(connectionResult);
    }

    private boolean m13527d() {
        this.f10453h--;
        if (this.f10453h > 0) {
            return false;
        }
        if (this.f10453h < 0) {
            Log.w("GoogleApiClientConnecting", this.f10446a.f10989g.m13869j());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m13525c(new ConnectionResult(8, null));
            return false;
        } else if (this.f10450e == null) {
            return true;
        } else {
            this.f10446a.f10988f = this.f10451f;
            m13525c(this.f10450e);
            return false;
        }
    }

    private void m13528e() {
        if (this.f10453h == 0) {
            if (!this.f10458m || this.f10459n) {
                m13531f();
            }
        }
    }

    private void m13531f() {
        ArrayList arrayList = new ArrayList();
        this.f10452g = 1;
        this.f10453h = this.f10446a.f10983a.size();
        for (C2450d c2450d : this.f10446a.f10983a.keySet()) {
            if (!this.f10446a.f10984b.containsKey(c2450d)) {
                arrayList.add((C2451f) this.f10446a.f10983a.get(c2450d));
            } else if (m13527d()) {
                m13533g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f10466u.add(C3383w.m14451a().submit(new C3191c(this, arrayList)));
        }
    }

    private void m13533g() {
        this.f10446a.m14341f();
        C3383w.m14451a().execute(new C31851(this));
        if (this.f10456k != null) {
            if (this.f10461p) {
                this.f10456k.mo3582a(this.f10460o, this.f10462q);
            }
            m13514a(false);
        }
        for (C2450d c2450d : this.f10446a.f10984b.keySet()) {
            ((C2451f) this.f10446a.f10983a.get(c2450d)).m7735a();
        }
        this.f10446a.f10990h.mo3801a(this.f10454i.isEmpty() ? null : this.f10454i);
    }

    private void m13535h() {
        this.f10458m = false;
        this.f10446a.f10989g.f10651d = Collections.emptySet();
        for (C2450d c2450d : this.f10455j) {
            if (!this.f10446a.f10984b.containsKey(c2450d)) {
                this.f10446a.f10984b.put(c2450d, new ConnectionResult(17, null));
            }
        }
    }

    private void m13536i() {
        Iterator it = this.f10466u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f10466u.clear();
    }

    private Set<Scope> m13538j() {
        if (this.f10463r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f10463r.m8049c());
        Map e = this.f10463r.m8051e();
        for (C2456a c2456a : e.keySet()) {
            if (!this.f10446a.f10984b.containsKey(c2456a.m7751c())) {
                hashSet.addAll(((C2538a) e.get(c2456a)).f7442a);
            }
        }
        return hashSet;
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3900a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void mo3901a() {
        this.f10446a.f10984b.clear();
        this.f10458m = false;
        this.f10450e = null;
        this.f10452g = 0;
        this.f10457l = true;
        this.f10459n = false;
        this.f10461p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C2456a c2456a : this.f10464s.keySet()) {
            C2451f c2451f = (C2451f) this.f10446a.f10983a.get(c2456a.m7751c());
            int i2 = (c2456a.m7749a().m7732a() == 1 ? 1 : 0) | i;
            boolean booleanValue = ((Boolean) this.f10464s.get(c2456a)).booleanValue();
            if (c2451f.mo3584d()) {
                this.f10458m = true;
                if (booleanValue) {
                    this.f10455j.add(c2456a.m7751c());
                } else {
                    this.f10457l = false;
                }
            }
            hashMap.put(c2451f, new C3186a(this, c2456a, booleanValue));
            i = i2;
        }
        if (i != 0) {
            this.f10458m = false;
        }
        if (this.f10458m) {
            this.f10463r.m8047a(Integer.valueOf(this.f10446a.f10989g.m13870k()));
            C2459b c3194e = new C3194e();
            this.f10456k = (em) this.f10465t.mo3464a(this.f10448c, this.f10446a.f10989g.mo4028a(), this.f10463r, this.f10463r.m8054h(), c3194e, c3194e);
        }
        this.f10453h = this.f10446a.f10983a.size();
        this.f10466u.add(C3383w.m14451a().submit(new C3190b(this, hashMap)));
    }

    public void mo3902a(int i) {
        m13525c(new ConnectionResult(8, null));
    }

    public void mo3903a(Bundle bundle) {
        if (m13520b(1)) {
            if (bundle != null) {
                this.f10454i.putAll(bundle);
            }
            if (m13527d()) {
                m13533g();
            }
        }
    }

    public void mo3904a(ConnectionResult connectionResult, C2456a<?> c2456a, boolean z) {
        if (m13520b(1)) {
            m13519b(connectionResult, c2456a, z);
            if (m13527d()) {
                m13533g();
            }
        }
    }

    public boolean mo3905b() {
        m13536i();
        m13514a(true);
        this.f10446a.m14332a(null);
        return true;
    }

    public void mo3906c() {
    }
}
