package com.google.android.gms.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.C2481b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.C2475n;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2503v;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2517l.C2530f;
import com.google.android.gms.common.internal.C2520g;
import com.google.android.gms.common.util.C2576a;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.C2835e.C2834a;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.acb.C2685b;
import com.google.android.gms.internal.acb.C2686c;
import com.google.android.gms.internal.ah.C2688a;
import com.google.android.gms.internal.ap.C2690a;
import com.google.android.gms.p004b.C2428e;
import com.google.android.gms.p004b.C2429f;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class C3424x implements Callback {
    public static final Status f11268a = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status f11269b = new Status(4, "The user must be signed in to make this API call.");
    private static final Object f11270f = new Object();
    private static C3424x f11271g;
    private long f11272c = 5000;
    private long f11273d = 120000;
    private long f11274e = 10000;
    private final Context f11275h;
    private final C2481b f11276i;
    private int f11277j = -1;
    private final AtomicInteger f11278k = new AtomicInteger(1);
    private final AtomicInteger f11279l = new AtomicInteger(0);
    private final Map<acd<?>, C3421a<?>> f11280m = new ConcurrentHashMap(5, 0.75f, 1);
    private C3111o f11281n = null;
    private final Set<acd<?>> f11282o = new C2576a();
    private final Set<acd<?>> f11283p = new C2576a();
    private final Handler f11284q;

    class C34171 implements C2834a {
        final /* synthetic */ C3424x f11243a;

        C34171(C3424x c3424x) {
            this.f11243a = c3424x;
        }

        public void mo4190a(boolean z) {
            this.f11243a.f11284q.sendMessage(this.f11243a.f11284q.obtainMessage(1, Boolean.valueOf(z)));
        }
    }

    public class C3421a<O extends C2416a> implements C2459b, C2460c, C2996j {
        final /* synthetic */ C3424x f11248a;
        private final Queue<acb> f11249b = new LinkedList();
        private final C2451f f11250c;
        private final C2449c f11251d;
        private final acd<O> f11252e;
        private final C3081n f11253f;
        private final Set<C2756d> f11254g = new HashSet();
        private final Map<C2688a<?>, al> f11255h = new HashMap();
        private final int f11256i;
        private final ap f11257j;
        private boolean f11258k;
        private ConnectionResult f11259l = null;

        class C34181 implements Runnable {
            final /* synthetic */ C3421a f11244a;

            C34181(C3421a c3421a) {
                this.f11244a = c3421a;
            }

            public void run() {
                this.f11244a.m14600n();
            }
        }

        class C34192 implements Runnable {
            final /* synthetic */ C3421a f11245a;

            C34192(C3421a c3421a) {
                this.f11245a = c3421a;
            }

            public void run() {
                this.f11245a.m14601o();
            }
        }

        @WorkerThread
        public C3421a(C3424x c3424x, C2475n<O> c2475n) {
            this.f11248a = c3424x;
            this.f11250c = c2475n.mo3815a(c3424x.f11284q.getLooper(), this);
            if (this.f11250c instanceof C2520g) {
                this.f11251d = ((C2520g) this.f11250c).mo3338k();
            } else {
                this.f11251d = this.f11250c;
            }
            this.f11252e = c2475n.m7795b();
            this.f11253f = new C3081n();
            this.f11256i = c2475n.m7797c();
            if (this.f11250c.mo3584d()) {
                this.f11257j = c2475n.mo3816a(c3424x.f11275h, c3424x.f11284q);
            } else {
                this.f11257j = null;
            }
        }

        @WorkerThread
        private void m14597b(acb com_google_android_gms_internal_acb) {
            com_google_android_gms_internal_acb.mo3485a(this.f11253f, m14623k());
            try {
                com_google_android_gms_internal_acb.mo3486a(this);
            } catch (DeadObjectException e) {
                mo3496a(1);
                this.f11250c.m7735a();
            }
        }

        @WorkerThread
        private void m14599c(ConnectionResult connectionResult) {
            for (C2756d a : this.f11254g) {
                a.m9736a(this.f11252e, connectionResult);
            }
            this.f11254g.clear();
        }

        @WorkerThread
        private void m14600n() {
            m14616d();
            m14599c(ConnectionResult.zzayj);
            m14603q();
            Iterator it = this.f11255h.values().iterator();
            while (it.hasNext()) {
                it.next();
                try {
                    C2429f c2429f = new C2429f();
                } catch (DeadObjectException e) {
                    mo3496a(1);
                    this.f11250c.m7735a();
                } catch (RemoteException e2) {
                }
            }
            m14602p();
            m14604r();
        }

        @WorkerThread
        private void m14601o() {
            m14616d();
            this.f11258k = true;
            this.f11253f.m12726c();
            this.f11248a.f11284q.sendMessageDelayed(Message.obtain(this.f11248a.f11284q, 9, this.f11252e), this.f11248a.f11272c);
            this.f11248a.f11284q.sendMessageDelayed(Message.obtain(this.f11248a.f11284q, 11, this.f11252e), this.f11248a.f11273d);
            this.f11248a.f11277j = -1;
        }

        @WorkerThread
        private void m14602p() {
            while (this.f11250c.m7739b() && !this.f11249b.isEmpty()) {
                m14597b((acb) this.f11249b.remove());
            }
        }

        @WorkerThread
        private void m14603q() {
            if (this.f11258k) {
                this.f11248a.f11284q.removeMessages(11, this.f11252e);
                this.f11248a.f11284q.removeMessages(9, this.f11252e);
                this.f11258k = false;
            }
        }

        private void m14604r() {
            this.f11248a.f11284q.removeMessages(12, this.f11252e);
            this.f11248a.f11284q.sendMessageDelayed(this.f11248a.f11284q.obtainMessage(12, this.f11252e), this.f11248a.f11274e);
        }

        @WorkerThread
        public void m14605a() {
            C2513c.m7936a(this.f11248a.f11284q);
            m14610a(C3424x.f11268a);
            this.f11253f.m12725b();
            for (C2688a c2686c : this.f11255h.keySet()) {
                m14611a(new C2686c(c2686c, new C2429f()));
            }
            m14599c(new ConnectionResult(4));
            this.f11250c.m7735a();
        }

        public void mo3496a(int i) {
            if (Looper.myLooper() == this.f11248a.f11284q.getLooper()) {
                m14601o();
            } else {
                this.f11248a.f11284q.post(new C34192(this));
            }
        }

        public void mo3497a(@Nullable Bundle bundle) {
            if (Looper.myLooper() == this.f11248a.f11284q.getLooper()) {
                m14600n();
            } else {
                this.f11248a.f11284q.post(new C34181(this));
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @android.support.annotation.WorkerThread
        public void mo3498a(@android.support.annotation.NonNull com.google.android.gms.common.ConnectionResult r6) {
            /*
            r5 = this;
            r0 = r5.f11248a;
            r0 = r0.f11284q;
            com.google.android.gms.common.internal.C2513c.m7936a(r0);
            r0 = r5.f11257j;
            if (r0 == 0) goto L_0x0012;
        L_0x000d:
            r0 = r5.f11257j;
            r0.m9004b();
        L_0x0012:
            r5.m14616d();
            r0 = r5.f11248a;
            r1 = -1;
            r0.f11277j = r1;
            r5.m14599c(r6);
            r0 = r6.m7714c();
            r1 = 4;
            if (r0 != r1) goto L_0x002d;
        L_0x0025:
            r0 = com.google.android.gms.internal.C3424x.f11269b;
            r5.m14610a(r0);
        L_0x002c:
            return;
        L_0x002d:
            r0 = r5.f11249b;
            r0 = r0.isEmpty();
            if (r0 == 0) goto L_0x0038;
        L_0x0035:
            r5.f11259l = r6;
            goto L_0x002c;
        L_0x0038:
            r1 = com.google.android.gms.internal.C3424x.f11270f;
            monitor-enter(r1);
            r0 = r5.f11248a;	 Catch:{ all -> 0x0060 }
            r0 = r0.f11281n;	 Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0063;
        L_0x0045:
            r0 = r5.f11248a;	 Catch:{ all -> 0x0060 }
            r0 = r0.f11282o;	 Catch:{ all -> 0x0060 }
            r2 = r5.f11252e;	 Catch:{ all -> 0x0060 }
            r0 = r0.contains(r2);	 Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0063;
        L_0x0053:
            r0 = r5.f11248a;	 Catch:{ all -> 0x0060 }
            r0 = r0.f11281n;	 Catch:{ all -> 0x0060 }
            r2 = r5.f11256i;	 Catch:{ all -> 0x0060 }
            r0.m9265b(r6, r2);	 Catch:{ all -> 0x0060 }
            monitor-exit(r1);	 Catch:{ all -> 0x0060 }
            goto L_0x002c;
        L_0x0060:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0060 }
            throw r0;
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0060 }
            r0 = r5.f11248a;
            r1 = r5.f11256i;
            r0 = r0.m14663a(r6, r1);
            if (r0 != 0) goto L_0x002c;
        L_0x006e:
            r0 = r6.m7714c();
            r1 = 18;
            if (r0 != r1) goto L_0x0079;
        L_0x0076:
            r0 = 1;
            r5.f11258k = r0;
        L_0x0079:
            r0 = r5.f11258k;
            if (r0 == 0) goto L_0x009b;
        L_0x007d:
            r0 = r5.f11248a;
            r0 = r0.f11284q;
            r1 = r5.f11248a;
            r1 = r1.f11284q;
            r2 = 9;
            r3 = r5.f11252e;
            r1 = android.os.Message.obtain(r1, r2, r3);
            r2 = r5.f11248a;
            r2 = r2.f11272c;
            r0.sendMessageDelayed(r1, r2);
            goto L_0x002c;
        L_0x009b:
            r0 = new com.google.android.gms.common.api.Status;
            r1 = 17;
            r2 = r5.f11252e;
            r2 = r2.m8951a();
            r2 = java.lang.String.valueOf(r2);
            r3 = java.lang.String.valueOf(r2);
            r3 = r3.length();
            r3 = r3 + 38;
            r4 = new java.lang.StringBuilder;
            r4.<init>(r3);
            r3 = "API: ";
            r3 = r4.append(r3);
            r2 = r3.append(r2);
            r3 = " is not available on this device.";
            r2 = r2.append(r3);
            r2 = r2.toString();
            r0.<init>(r1, r2);
            r5.m14610a(r0);
            goto L_0x002c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.x.a.a(com.google.android.gms.common.ConnectionResult):void");
        }

        public void mo4157a(final ConnectionResult connectionResult, C2456a<?> c2456a, boolean z) {
            if (Looper.myLooper() == this.f11248a.f11284q.getLooper()) {
                mo3498a(connectionResult);
            } else {
                this.f11248a.f11284q.post(new Runnable(this) {
                    final /* synthetic */ C3421a f11247b;

                    public void run() {
                        this.f11247b.mo3498a(connectionResult);
                    }
                });
            }
        }

        @WorkerThread
        public void m14610a(Status status) {
            C2513c.m7936a(this.f11248a.f11284q);
            for (acb a : this.f11249b) {
                a.mo3484a(status);
            }
            this.f11249b.clear();
        }

        @WorkerThread
        public void m14611a(acb com_google_android_gms_internal_acb) {
            C2513c.m7936a(this.f11248a.f11284q);
            if (this.f11250c.m7739b()) {
                m14597b(com_google_android_gms_internal_acb);
                m14604r();
                return;
            }
            this.f11249b.add(com_google_android_gms_internal_acb);
            if (this.f11259l == null || !this.f11259l.m7712a()) {
                m14621i();
            } else {
                mo3498a(this.f11259l);
            }
        }

        @WorkerThread
        public void m14612a(C2756d c2756d) {
            C2513c.m7936a(this.f11248a.f11284q);
            this.f11254g.add(c2756d);
        }

        public C2451f m14613b() {
            return this.f11250c;
        }

        @WorkerThread
        public void m14614b(@NonNull ConnectionResult connectionResult) {
            C2513c.m7936a(this.f11248a.f11284q);
            this.f11250c.m7735a();
            mo3498a(connectionResult);
        }

        public Map<C2688a<?>, al> m14615c() {
            return this.f11255h;
        }

        @WorkerThread
        public void m14616d() {
            C2513c.m7936a(this.f11248a.f11284q);
            this.f11259l = null;
        }

        @WorkerThread
        public ConnectionResult m14617e() {
            C2513c.m7936a(this.f11248a.f11284q);
            return this.f11259l;
        }

        @WorkerThread
        public void m14618f() {
            C2513c.m7936a(this.f11248a.f11284q);
            if (this.f11258k) {
                m14621i();
            }
        }

        @WorkerThread
        public void m14619g() {
            C2513c.m7936a(this.f11248a.f11284q);
            if (this.f11258k) {
                m14603q();
                m14610a(this.f11248a.f11276i.mo3314a(this.f11248a.f11275h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f11250c.m7735a();
            }
        }

        @WorkerThread
        public void m14620h() {
            C2513c.m7936a(this.f11248a.f11284q);
            if (!this.f11250c.m7739b() || this.f11255h.size() != 0) {
                return;
            }
            if (this.f11253f.m12724a()) {
                m14604r();
            } else {
                this.f11250c.m7735a();
            }
        }

        @WorkerThread
        public void m14621i() {
            C2513c.m7936a(this.f11248a.f11284q);
            if (!this.f11250c.m7739b() && !this.f11250c.m7740c()) {
                if (this.f11250c.m7742e() && this.f11248a.f11277j != 0) {
                    this.f11248a.f11277j = this.f11248a.f11276i.mo3314a(this.f11248a.f11275h);
                    if (this.f11248a.f11277j != 0) {
                        mo3498a(new ConnectionResult(this.f11248a.f11277j, null));
                        return;
                    }
                }
                C2690a c3423b = new C3423b(this.f11248a, this.f11250c, this.f11252e);
                if (this.f11250c.mo3584d()) {
                    this.f11257j.m9002a(c3423b);
                }
                this.f11250c.m7736a(c3423b);
            }
        }

        boolean m14622j() {
            return this.f11250c.m7739b();
        }

        public boolean m14623k() {
            return this.f11250c.mo3584d();
        }

        public int m14624l() {
            return this.f11256i;
        }

        em m14625m() {
            return this.f11257j == null ? null : this.f11257j.m8998a();
        }
    }

    private class C3423b implements C2530f, C2690a {
        final /* synthetic */ C3424x f11262a;
        private final C2451f f11263b;
        private final acd<?> f11264c;
        private C2503v f11265d = null;
        private Set<Scope> f11266e = null;
        private boolean f11267f = false;

        public C3423b(C3424x c3424x, C2451f c2451f, acd<?> com_google_android_gms_internal_acd_) {
            this.f11262a = c3424x;
            this.f11263b = c2451f;
            this.f11264c = com_google_android_gms_internal_acd_;
        }

        @WorkerThread
        private void m14627a() {
            if (this.f11267f && this.f11265d != null) {
                this.f11263b.m7737a(this.f11265d, this.f11266e);
            }
        }

        public void mo3342a(@NonNull final ConnectionResult connectionResult) {
            this.f11262a.f11284q.post(new Runnable(this) {
                final /* synthetic */ C3423b f11261b;

                public void run() {
                    if (connectionResult.m7713b()) {
                        this.f11261b.f11267f = true;
                        if (this.f11261b.f11263b.mo3584d()) {
                            this.f11261b.m14627a();
                            return;
                        } else {
                            this.f11261b.f11263b.m7737a(null, Collections.emptySet());
                            return;
                        }
                    }
                    ((C3421a) this.f11261b.f11262a.f11280m.get(this.f11261b.f11264c)).mo3498a(connectionResult);
                }
            });
        }

        @WorkerThread
        public void mo4191a(C2503v c2503v, Set<Scope> set) {
            if (c2503v == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                mo4192b(new ConnectionResult(4));
                return;
            }
            this.f11265d = c2503v;
            this.f11266e = set;
            m14627a();
        }

        @WorkerThread
        public void mo4192b(ConnectionResult connectionResult) {
            ((C3421a) this.f11262a.f11280m.get(this.f11264c)).m14614b(connectionResult);
        }
    }

    private C3424x(Context context, Looper looper, C2481b c2481b) {
        this.f11275h = context;
        this.f11284q = new Handler(looper, this);
        this.f11276i = c2481b;
        this.f11284q.sendMessage(this.f11284q.obtainMessage(6));
    }

    public static C3424x m14636a() {
        C3424x c3424x;
        synchronized (f11270f) {
            C2513c.m7933a(f11271g, (Object) "Must guarantee manager is non-null before using getInstance");
            c3424x = f11271g;
        }
        return c3424x;
    }

    public static C3424x m14637a(Context context) {
        C3424x c3424x;
        synchronized (f11270f) {
            if (f11271g == null) {
                f11271g = new C3424x(context.getApplicationContext(), C3424x.m14649f(), C2481b.m7820a());
            }
            c3424x = f11271g;
        }
        return c3424x;
    }

    @WorkerThread
    private void m14638a(int i, ConnectionResult connectionResult) {
        for (C3421a c3421a : this.f11280m.values()) {
            if (c3421a.m14624l() == i) {
                break;
            }
        }
        C3421a c3421a2 = null;
        if (c3421a2 != null) {
            String valueOf = String.valueOf(this.f11276i.mo3322c(connectionResult.m7714c()));
            String valueOf2 = String.valueOf(connectionResult.m7716e());
            c3421a2.m14610a(new Status(17, new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(valueOf2).length()).append("Error resolution was canceled by the user, original error message: ").append(valueOf).append(": ").append(valueOf2).toString()));
            return;
        }
        Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
    }

    @WorkerThread
    private void m14639a(aj ajVar) {
        C3421a c3421a = (C3421a) this.f11280m.get(ajVar.f7903c.m7795b());
        if (c3421a == null) {
            m14643b(ajVar.f7903c);
            c3421a = (C3421a) this.f11280m.get(ajVar.f7903c.m7795b());
        }
        if (!c3421a.m14623k() || this.f11279l.get() == ajVar.f7902b) {
            c3421a.m14611a(ajVar.f7901a);
            return;
        }
        ajVar.f7901a.mo3484a(f11268a);
        c3421a.m14605a();
    }

    @WorkerThread
    private void m14640a(C2756d c2756d) {
        for (acd com_google_android_gms_internal_acd : c2756d.m9735a()) {
            C3421a c3421a = (C3421a) this.f11280m.get(com_google_android_gms_internal_acd);
            if (c3421a == null) {
                c2756d.m9736a(com_google_android_gms_internal_acd, new ConnectionResult(13));
                return;
            } else if (c3421a.m14622j()) {
                c2756d.m9736a(com_google_android_gms_internal_acd, ConnectionResult.zzayj);
            } else if (c3421a.m14617e() != null) {
                c2756d.m9736a(com_google_android_gms_internal_acd, c3421a.m14617e());
            } else {
                c3421a.m14612a(c2756d);
            }
        }
    }

    @WorkerThread
    private void m14641a(boolean z) {
        this.f11274e = z ? 10000 : 300000;
        this.f11284q.removeMessages(12);
        for (acd obtainMessage : this.f11280m.keySet()) {
            this.f11284q.sendMessageDelayed(this.f11284q.obtainMessage(12, obtainMessage), this.f11274e);
        }
    }

    @WorkerThread
    private void m14643b(C2475n<?> c2475n) {
        acd b = c2475n.m7795b();
        C3421a c3421a = (C3421a) this.f11280m.get(b);
        if (c3421a == null) {
            c3421a = new C3421a(this, c2475n);
            this.f11280m.put(b, c3421a);
        }
        if (c3421a.m14623k()) {
            this.f11283p.add(b);
        }
        c3421a.m14621i();
    }

    private static Looper m14649f() {
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    @WorkerThread
    private void m14652g() {
        C2590o.m8307b();
        if (this.f11275h.getApplicationContext() instanceof Application) {
            C2835e.m10492a((Application) this.f11275h.getApplicationContext());
            C2835e.m10491a().m10494a(new C34171(this));
            if (!C2835e.m10491a().m10495a(true)) {
                this.f11274e = 300000;
            }
        }
    }

    @WorkerThread
    private void m14654h() {
        for (C3421a c3421a : this.f11280m.values()) {
            c3421a.m14616d();
            c3421a.m14621i();
        }
    }

    @WorkerThread
    private void m14656i() {
        for (acd remove : this.f11283p) {
            ((C3421a) this.f11280m.remove(remove)).m14605a();
        }
        this.f11283p.clear();
    }

    PendingIntent m14658a(acd<?> com_google_android_gms_internal_acd_, int i) {
        if (((C3421a) this.f11280m.get(com_google_android_gms_internal_acd_)) == null) {
            return null;
        }
        em m = ((C3421a) this.f11280m.get(com_google_android_gms_internal_acd_)).m14625m();
        return m == null ? null : PendingIntent.getActivity(this.f11275h, i, m.m7744g(), 134217728);
    }

    public C2428e<Void> m14659a(Iterable<? extends C2475n<?>> iterable) {
        C2756d c2756d = new C2756d(iterable);
        for (C2475n b : iterable) {
            C3421a c3421a = (C3421a) this.f11280m.get(b.m7795b());
            if (c3421a != null) {
                if (!c3421a.m14622j()) {
                }
            }
            this.f11284q.sendMessage(this.f11284q.obtainMessage(2, c2756d));
            return c2756d.m9737b();
        }
        c2756d.m9738c();
        return c2756d.m9737b();
    }

    public void m14660a(C2475n<?> c2475n) {
        this.f11284q.sendMessage(this.f11284q.obtainMessage(7, c2475n));
    }

    public <O extends C2416a> void m14661a(C2475n<O> c2475n, int i, C2676a<? extends C2445g, C2449c> c2676a) {
        this.f11284q.sendMessage(this.f11284q.obtainMessage(4, new aj(new C2685b(i, c2676a), this.f11279l.get(), c2475n)));
    }

    public void m14662a(@NonNull C3111o c3111o) {
        synchronized (f11270f) {
            if (this.f11281n != c3111o) {
                this.f11281n = c3111o;
                this.f11282o.clear();
                this.f11282o.addAll(c3111o.m12874e());
            }
        }
    }

    boolean m14663a(ConnectionResult connectionResult, int i) {
        return this.f11276i.m7835a(this.f11275h, connectionResult, i);
    }

    public int m14664b() {
        return this.f11278k.getAndIncrement();
    }

    public void m14665b(ConnectionResult connectionResult, int i) {
        if (!m14663a(connectionResult, i)) {
            this.f11284q.sendMessage(this.f11284q.obtainMessage(5, i, 0, connectionResult));
        }
    }

    void m14666b(@NonNull C3111o c3111o) {
        synchronized (f11270f) {
            if (this.f11281n == c3111o) {
                this.f11281n = null;
                this.f11282o.clear();
            }
        }
    }

    public void m14667c() {
        this.f11284q.sendMessage(this.f11284q.obtainMessage(3));
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m14641a(((Boolean) message.obj).booleanValue());
                break;
            case 2:
                m14640a((C2756d) message.obj);
                break;
            case 3:
                m14654h();
                break;
            case 4:
            case 8:
            case 13:
                m14639a((aj) message.obj);
                break;
            case 5:
                m14638a(message.arg1, (ConnectionResult) message.obj);
                break;
            case 6:
                m14652g();
                break;
            case 7:
                m14643b((C2475n) message.obj);
                break;
            case 9:
                if (this.f11280m.containsKey(message.obj)) {
                    ((C3421a) this.f11280m.get(message.obj)).m14618f();
                    break;
                }
                break;
            case 10:
                m14656i();
                break;
            case 11:
                if (this.f11280m.containsKey(message.obj)) {
                    ((C3421a) this.f11280m.get(message.obj)).m14619g();
                    break;
                }
                break;
            case 12:
                if (this.f11280m.containsKey(message.obj)) {
                    ((C3421a) this.f11280m.get(message.obj)).m14620h();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
