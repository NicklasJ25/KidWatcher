package com.facebook.ads.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1462f;
import com.facebook.ads.C1463g;
import com.facebook.ads.internal.p018m.C1486l;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.aa;
import com.facebook.ads.internal.p018m.ah;
import com.facebook.ads.internal.p018m.aj;
import com.facebook.ads.internal.p021b.C1475c;
import com.facebook.ads.internal.p021b.C1478e;
import com.facebook.ads.internal.p021b.C1490a;
import com.facebook.ads.internal.p021b.C1492b;
import com.facebook.ads.internal.p021b.C1493d;
import com.facebook.ads.internal.p021b.C1500z;
import com.facebook.ads.internal.p021b.C1503j;
import com.facebook.ads.internal.p021b.C1516x;
import com.facebook.ads.internal.p021b.ab;
import com.facebook.ads.internal.p021b.ac;
import com.facebook.ads.internal.p021b.ad;
import com.facebook.ads.internal.p021b.ae;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.p024l.C1675a;
import com.facebook.ads.internal.p024l.C1679b;
import com.facebook.ads.internal.p024l.C1679b.C1539a;
import com.facebook.ads.internal.p024l.C1684f;
import com.facebook.ads.internal.p026e.C1556a;
import com.facebook.ads.internal.p028g.C1572a;
import com.facebook.ads.internal.p028g.C1576d;
import com.facebook.ads.internal.p028g.C1577e;
import com.facebook.ads.internal.p028g.C1580f;
import com.facebook.ads.internal.p028g.C1582h;
import com.facebook.ads.internal.p034k.C1671a;
import com.facebook.ads.p019a.C1452a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1540b implements C1539a {
    private static final String f3717b = C1540b.class.getSimpleName();
    private static final Handler f3718h = new Handler(Looper.getMainLooper());
    private static boolean f3719i = false;
    protected C1464c f3720a;
    private final Context f3721c;
    private final String f3722d;
    private final C1675a f3723e;
    private final C1679b f3724f;
    private final Handler f3725g = new Handler();
    private final Runnable f3726j;
    private final Runnable f3727k;
    private volatile boolean f3728l;
    private boolean f3729m;
    private volatile boolean f3730n;
    private C1490a f3731o;
    private C1490a f3732p;
    private View f3733q;
    private C1576d f3734r;
    private C1580f f3735s;
    private C1584g f3736t;
    private C1558e f3737u;
    private C1463g f3738v;
    private int f3739w;
    private final C1489c f3740x;
    private boolean f3741y;
    private final C1597f f3742z;

    class C14848 implements Runnable {
        final /* synthetic */ C1540b f3474a;

        C14848(C1540b c1540b) {
            this.f3474a = c1540b;
        }

        public void run() {
            try {
                this.f3474a.m4252j();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C14859 implements C1452a {
        final /* synthetic */ C1540b f3475a;

        C14859(C1540b c1540b) {
            this.f3475a = c1540b;
        }

        public void mo2665a(C1516x c1516x) {
            this.f3475a.f3732p = c1516x;
            this.f3475a.f3730n = false;
            this.f3475a.f3720a.mo2636a((C1490a) c1516x);
        }

        public void mo2666a(C1516x c1516x, View view) {
            this.f3475a.f3720a.mo2635a(view);
        }

        public void mo2667a(C1516x c1516x, C1460d c1460d) {
            this.f3475a.f3720a.mo2637a(new C1555d(c1460d.m3756a(), c1460d.m3757b()));
        }

        public void mo2668b(C1516x c1516x) {
            this.f3475a.f3720a.mo2634a();
        }

        public void mo2669c(C1516x c1516x) {
            this.f3475a.f3720a.mo2638b();
        }

        public void mo2670d(C1516x c1516x) {
            this.f3475a.f3720a.m3777e();
        }
    }

    private static final class C1487a extends C1486l<C1540b> {
        public C1487a(C1540b c1540b) {
            super(c1540b);
        }

        public void run() {
            C1540b c1540b = (C1540b) m3873a();
            if (c1540b != null) {
                c1540b.f3728l = false;
                c1540b.m4247h();
            }
        }
    }

    private static final class C1488b extends C1486l<C1540b> {
        public C1488b(C1540b c1540b) {
            super(c1540b);
        }

        public void run() {
            C1540b c1540b = (C1540b) m3873a();
            if (c1540b != null) {
                c1540b.m4254k();
            }
        }
    }

    private class C1489c extends BroadcastReceiver {
        final /* synthetic */ C1540b f3477a;

        private C1489c(C1540b c1540b) {
            this.f3477a = c1540b;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f3477a.m4255l();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.f3477a.m4254k();
            }
        }
    }

    public C1540b(Context context, String str, C1584g c1584g, C1675a c1675a, C1463g c1463g, C1558e c1558e, int i, boolean z) {
        this.f3721c = context;
        this.f3722d = str;
        this.f3736t = c1584g;
        this.f3723e = c1675a;
        this.f3738v = c1463g;
        this.f3737u = c1558e;
        this.f3739w = i;
        this.f3740x = new C1489c();
        this.f3724f = new C1679b(context);
        this.f3724f.m4789a((C1539a) this);
        this.f3726j = new C1487a(this);
        this.f3727k = new C1488b(this);
        this.f3729m = z;
        m4242e();
        try {
            CookieManager.getInstance();
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Throwable e) {
            Log.w(f3717b, "Failed to initialize CookieManager.", e);
        }
        C1556a.m4324a(context).m4325a();
        this.f3742z = C1599g.m4464a(context);
    }

    private Map<String, String> m4224a(long j) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    private void m4226a(C1490a c1490a) {
        if (c1490a != null) {
            c1490a.mo2680b();
        }
    }

    private void m4227a(ab abVar, C1576d c1576d, C1572a c1572a, Map<String, Object> map) {
        final long currentTimeMillis = System.currentTimeMillis();
        final ab abVar2 = abVar;
        final C1572a c1572a2 = c1572a;
        Runnable c14804 = new Runnable(this) {
            final /* synthetic */ C1540b f3463d;

            public void run() {
                this.f3463d.m4226a(abVar2);
                if (abVar2 instanceof C1500z) {
                    C1729s.m4971a(this.f3463d.f3721c, ah.m4824a(((C1500z) abVar2).mo2705z()) + " Failed. Ad request timed out");
                }
                Map a = this.f3463d.m4224a(currentTimeMillis);
                a.put("error", "-1");
                a.put("msg", "timeout");
                this.f3463d.m4234a(c1572a2.m4377a(C1582h.REQUEST), a);
                this.f3463d.m4249i();
            }
        };
        this.f3725g.postDelayed(c14804, (long) c1576d.m4383a().m4396i());
        final Runnable runnable = c14804;
        final long j = currentTimeMillis;
        final C1572a c1572a3 = c1572a;
        abVar.mo2676a(this.f3721c, new ac(this) {
            boolean f3464a = false;
            boolean f3465b = false;
            boolean f3466c = false;
            final /* synthetic */ C1540b f3470g;

            public void mo2661a(ab abVar) {
                if (abVar == this.f3470g.f3731o) {
                    this.f3470g.f3725g.removeCallbacks(runnable);
                    this.f3470g.f3732p = abVar;
                    this.f3470g.f3720a.mo2636a((C1490a) abVar);
                    if (!this.f3464a) {
                        this.f3464a = true;
                        this.f3470g.m4234a(c1572a3.m4377a(C1582h.REQUEST), this.f3470g.m4224a(j));
                    }
                }
            }

            public void mo2662a(ab abVar, C1460d c1460d) {
                if (abVar == this.f3470g.f3731o) {
                    this.f3470g.f3725g.removeCallbacks(runnable);
                    this.f3470g.m4226a((C1490a) abVar);
                    if (!this.f3464a) {
                        this.f3464a = true;
                        Map a = this.f3470g.m4224a(j);
                        a.put("error", String.valueOf(c1460d.m3756a()));
                        a.put("msg", String.valueOf(c1460d.m3757b()));
                        this.f3470g.m4234a(c1572a3.m4377a(C1582h.REQUEST), a);
                    }
                    this.f3470g.m4249i();
                }
            }

            public void mo2663b(ab abVar) {
                if (!this.f3465b) {
                    this.f3465b = true;
                    this.f3470g.m4234a(c1572a3.m4377a(C1582h.IMPRESSION), null);
                }
            }

            public void mo2664c(ab abVar) {
                if (!this.f3466c) {
                    this.f3466c = true;
                    this.f3470g.m4234a(c1572a3.m4377a(C1582h.CLICK), null);
                }
                if (this.f3470g.f3720a != null) {
                    this.f3470g.f3720a.mo2634a();
                }
            }
        }, this.f3742z, map);
    }

    private void m4228a(ad adVar, C1576d c1576d, Map<String, Object> map) {
        adVar.mo2724a(this.f3721c, new ae(this) {
            final /* synthetic */ C1540b f3449a;

            {
                this.f3449a = r1;
            }

            public void mo2643a() {
                this.f3449a.f3720a.m3779g();
            }

            public void mo2644a(ad adVar) {
                this.f3449a.f3732p = adVar;
                this.f3449a.f3720a.mo2636a((C1490a) adVar);
            }

            public void mo2645a(ad adVar, C1460d c1460d) {
                this.f3449a.f3720a.mo2637a(new C1555d(C1474a.INTERNAL_ERROR, null));
                this.f3449a.m4226a((C1490a) adVar);
                this.f3449a.m4249i();
            }

            public void mo2646b(ad adVar) {
                this.f3449a.f3720a.mo2634a();
            }

            public void mo2647c(ad adVar) {
                this.f3449a.f3720a.mo2638b();
            }

            public void mo2648d(ad adVar) {
                this.f3449a.f3720a.m3778f();
            }

            public void mo2649e(ad adVar) {
                this.f3449a.f3720a.m3780h();
            }

            public void mo2650f(ad adVar) {
                this.f3449a.f3720a.m3781i();
            }
        }, map);
    }

    private void m4229a(final C1492b c1492b, C1576d c1576d, Map<String, Object> map) {
        final Runnable anonymousClass11 = new Runnable(this) {
            final /* synthetic */ C1540b f3451b;

            public void run() {
                this.f3451b.m4226a(c1492b);
                this.f3451b.m4249i();
            }
        };
        this.f3725g.postDelayed(anonymousClass11, (long) c1576d.m4383a().m4396i());
        c1492b.mo2708a(this.f3721c, this.f3738v, new C1475c(this) {
            final /* synthetic */ C1540b f3453b;

            public void mo2651a(C1492b c1492b) {
                this.f3453b.f3720a.mo2638b();
            }

            public void mo2652a(C1492b c1492b, View view) {
                if (c1492b == this.f3453b.f3731o) {
                    this.f3453b.f3725g.removeCallbacks(anonymousClass11);
                    C1490a g = this.f3453b.f3732p;
                    this.f3453b.f3732p = c1492b;
                    this.f3453b.f3733q = view;
                    if (this.f3453b.f3730n) {
                        this.f3453b.f3720a.mo2635a(view);
                        this.f3453b.m4226a(g);
                        this.f3453b.m4254k();
                        return;
                    }
                    this.f3453b.f3720a.mo2636a((C1490a) c1492b);
                }
            }

            public void mo2653a(C1492b c1492b, C1460d c1460d) {
                if (c1492b == this.f3453b.f3731o) {
                    this.f3453b.f3725g.removeCallbacks(anonymousClass11);
                    this.f3453b.m4226a((C1490a) c1492b);
                    this.f3453b.m4249i();
                }
            }

            public void mo2654b(C1492b c1492b) {
                this.f3453b.f3720a.mo2634a();
            }
        }, map);
    }

    private void m4230a(final C1493d c1493d, C1576d c1576d, Map<String, Object> map) {
        final Runnable c14772 = new Runnable(this) {
            final /* synthetic */ C1540b f3457b;

            public void run() {
                this.f3457b.m4226a(c1493d);
                this.f3457b.m4249i();
            }
        };
        this.f3725g.postDelayed(c14772, (long) c1576d.m4383a().m4396i());
        c1493d.mo2713a(this.f3721c, new C1478e(this) {
            final /* synthetic */ C1540b f3459b;

            public void mo2655a(C1493d c1493d) {
                if (c1493d == this.f3459b.f3731o) {
                    this.f3459b.f3725g.removeCallbacks(c14772);
                    this.f3459b.f3732p = c1493d;
                    this.f3459b.f3720a.mo2636a((C1490a) c1493d);
                    this.f3459b.m4254k();
                }
            }

            public void mo2656a(C1493d c1493d, C1460d c1460d) {
                if (c1493d == this.f3459b.f3731o) {
                    this.f3459b.f3725g.removeCallbacks(c14772);
                    this.f3459b.m4226a((C1490a) c1493d);
                    this.f3459b.m4249i();
                    this.f3459b.f3720a.mo2637a(new C1555d(c1460d.m3756a(), c1460d.m3757b()));
                }
            }

            public void mo2657a(C1493d c1493d, String str, boolean z) {
                this.f3459b.f3720a.mo2634a();
                Object obj = !TextUtils.isEmpty(str) ? 1 : null;
                if (z && obj != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (!(this.f3459b.f3735s.f3906d instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.setData(Uri.parse(str));
                    this.f3459b.f3735s.f3906d.startActivity(intent);
                }
            }

            public void mo2658b(C1493d c1493d) {
                this.f3459b.f3720a.mo2638b();
            }

            public void mo2659c(C1493d c1493d) {
                this.f3459b.f3720a.mo2639c();
            }

            public void mo2660d(C1493d c1493d) {
                this.f3459b.f3720a.mo2640d();
            }
        }, map, this.f3742z);
    }

    private void m4231a(C1516x c1516x, C1576d c1576d, Map<String, Object> map) {
        c1516x.mo2711a(this.f3721c, new C14859(this), map, this.f3742z);
    }

    private void m4234a(List<String> list, Map<String, String> map) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                new aj(map).execute(new String[]{str});
            }
        }
    }

    private void m4242e() {
        if (!this.f3729m) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f3721c.registerReceiver(this.f3740x, intentFilter);
            this.f3741y = true;
        }
    }

    private void m4244f() {
        if (this.f3741y) {
            try {
                this.f3721c.unregisterReceiver(this.f3740x);
                this.f3741y = false;
            } catch (Throwable e) {
                C1723o.m4943a(C1722n.m4940a(e, "Error unregistering screen state receiever"));
            }
        }
    }

    private C1675a m4246g() {
        return this.f3723e != null ? this.f3723e : this.f3738v == null ? C1675a.NATIVE : this.f3738v == C1463g.f3397b ? C1675a.INTERSTITIAL : C1675a.BANNER;
    }

    private void m4247h() {
        this.f3735s = new C1580f(this.f3721c, this.f3722d, this.f3738v, this.f3736t, this.f3737u, this.f3739w, C1462f.m3761a(this.f3721c));
        this.f3724f.m4788a(this.f3735s);
    }

    private synchronized void m4249i() {
        f3718h.post(new C14848(this));
    }

    private void m4252j() {
        this.f3731o = null;
        C1576d c1576d = this.f3734r;
        C1572a c = c1576d.m4386c();
        if (c == null) {
            this.f3720a.mo2637a(C1474a.NO_FILL.m3820a(""));
            m4254k();
            return;
        }
        String a = c.m4376a();
        C1490a a2 = C1503j.m3978a(a, c1576d.m4383a().m4388a());
        if (a2 == null) {
            Log.e(f3717b, "Adapter does not exist: " + a);
            m4249i();
        } else if (m4246g() != a2.mo2672a()) {
            this.f3720a.mo2637a(C1474a.INTERNAL_ERROR.m3820a(""));
        } else {
            this.f3731o = a2;
            Map hashMap = new HashMap();
            C1577e a3 = c1576d.m4383a();
            hashMap.put("data", c.m4378b());
            hashMap.put("definition", a3);
            if (this.f3735s == null) {
                this.f3720a.mo2637a(C1474a.UNKNOWN_ERROR.m3820a("environment is empty"));
                return;
            }
            switch (a2.mo2672a()) {
                case INTERSTITIAL:
                    m4230a((C1493d) a2, c1576d, hashMap);
                    return;
                case BANNER:
                    m4229a((C1492b) a2, c1576d, hashMap);
                    return;
                case NATIVE:
                    m4227a((ab) a2, c1576d, c, hashMap);
                    return;
                case INSTREAM:
                    m4231a((C1516x) a2, c1576d, hashMap);
                    return;
                case REWARDED_VIDEO:
                    hashMap.put("placement_id", this.f3722d);
                    m4228a((ad) a2, c1576d, hashMap);
                    return;
                default:
                    Log.e(f3717b, "attempt unexpected adapter type");
                    return;
            }
        }
    }

    private void m4254k() {
        if (!this.f3729m && !this.f3728l) {
            switch (m4246g()) {
                case INTERSTITIAL:
                    if (!aa.m4802a(this.f3721c)) {
                        this.f3725g.postDelayed(this.f3727k, 1000);
                        break;
                    }
                    break;
                case BANNER:
                    boolean a = C1671a.m4743a(this.f3733q, this.f3734r == null ? 1 : this.f3734r.m4383a().m4392e()).m4763a();
                    if (!(this.f3733q == null || a)) {
                        this.f3725g.postDelayed(this.f3727k, 1000);
                        return;
                    }
                default:
                    return;
            }
            long b = this.f3734r == null ? 30000 : this.f3734r.m4383a().m4389b();
            if (b > 0) {
                this.f3725g.postDelayed(this.f3726j, b);
                this.f3728l = true;
            }
        }
    }

    private void m4255l() {
        if (this.f3728l) {
            this.f3725g.removeCallbacks(this.f3726j);
            this.f3728l = false;
        }
    }

    private Handler m4257m() {
        return !C1540b.m4260n() ? this.f3725g : f3718h;
    }

    private static synchronized boolean m4260n() {
        boolean z;
        synchronized (C1540b.class) {
            z = f3719i;
        }
        return z;
    }

    public C1577e m4262a() {
        return this.f3734r == null ? null : this.f3734r.m4383a();
    }

    public void m4263a(C1464c c1464c) {
        this.f3720a = c1464c;
    }

    public synchronized void mo2726a(final C1555d c1555d) {
        m4257m().post(new Runnable(this) {
            final /* synthetic */ C1540b f3472b;

            public void run() {
                this.f3472b.f3720a.mo2637a(c1555d);
                if (!this.f3472b.f3729m && !this.f3472b.f3728l) {
                    switch (c1555d.m4322a().m3819a()) {
                        case 1000:
                        case PointerIconCompat.TYPE_HAND /*1002*/:
                            switch (this.f3472b.m4246g()) {
                                case BANNER:
                                    this.f3472b.f3725g.postDelayed(this.f3472b.f3726j, 30000);
                                    this.f3472b.f3728l = true;
                                    return;
                                default:
                                    return;
                            }
                        default:
                            return;
                    }
                }
            }
        });
    }

    public synchronized void mo2727a(final C1684f c1684f) {
        m4257m().post(new Runnable(this) {
            final /* synthetic */ C1540b f3455b;

            public void run() {
                C1576d b = c1684f.m4798b();
                if (b == null || b.m4383a() == null) {
                    throw new IllegalStateException("invalid placement in response");
                }
                this.f3455b.f3734r = b;
                this.f3455b.m4249i();
            }
        });
    }

    public void m4266b() {
        m4247h();
    }

    public void m4267c() {
        if (this.f3732p == null) {
            throw new IllegalStateException("no adapter ready to start");
        } else if (this.f3730n) {
            throw new IllegalStateException("ad already started");
        } else {
            this.f3730n = true;
            switch (this.f3732p.mo2672a()) {
                case INTERSTITIAL:
                    ((C1493d) this.f3732p).mo2714c();
                    return;
                case BANNER:
                    if (this.f3733q != null) {
                        this.f3720a.mo2635a(this.f3733q);
                        m4254k();
                        return;
                    }
                    return;
                case NATIVE:
                    ab abVar = (ab) this.f3732p;
                    if (abVar.mo2683d()) {
                        this.f3720a.mo2840a(abVar);
                        return;
                    }
                    throw new IllegalStateException("ad is not ready or already displayed");
                case INSTREAM:
                    ((C1516x) this.f3732p).mo2712f();
                    return;
                case REWARDED_VIDEO:
                    ((ad) this.f3732p).mo2725d();
                    return;
                default:
                    Log.e(f3717b, "start unexpected adapter type");
                    return;
            }
        }
    }

    public void m4268d() {
        m4244f();
        if (this.f3730n) {
            m4255l();
            m4226a(this.f3732p);
            this.f3733q = null;
            this.f3730n = false;
        }
    }
}
