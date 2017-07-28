package com.google.android.gms.internal;

import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.gw.C2926b;
import com.google.android.gms.internal.hp.C2941b;
import com.google.android.gms.internal.hr.C2940c;
import com.google.android.gms.internal.hr.C2971a;
import com.google.android.gms.internal.it.C2942b;
import com.google.android.gms.internal.it.C2949a;
import com.google.firebase.database.C0623m;
import com.google.firebase.database.C3535a;
import com.google.firebase.database.C3536b;
import com.google.firebase.database.C3574d;
import com.google.firebase.database.C3574d.C3041a;
import com.google.firebase.database.C3576f;
import com.google.firebase.database.C3587l;
import com.google.firebase.database.C3587l.C3585a;
import com.google.firebase.database.C3587l.C3586b;
import com.google.firebase.database.C3588n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class hj implements C2900a {
    static final /* synthetic */ boolean f9261b = (!hj.class.desiredAssertionStatus());
    public long f9262a = 0;
    private final hk f9263c;
    private final le f9264d = new le(new la(), 0);
    private final gp f9265e;
    private ho f9266f;
    private hp f9267g;
    private it<List<C2955a>> f9268h;
    private boolean f9269i = false;
    private final jc f9270j;
    private final ha f9271k;
    private final jp f9272l;
    private final jp f9273m;
    private final jp f9274n;
    private long f9275o = 1;
    private hr f9276p;
    private hr f9277q;
    private C3576f f9278r;
    private boolean f9279s = false;
    private long f9280t = 0;

    class C29441 implements Runnable {
        final /* synthetic */ hj f9223a;

        C29441(hj hjVar) {
            this.f9223a = hjVar;
        }

        public void run() {
            this.f9223a.m11461c();
        }
    }

    class C29474 implements C2926b {
        final /* synthetic */ hj f9229a;

        C29474(hj hjVar) {
            this.f9229a = hjVar;
        }
    }

    class C29549 implements C2940c {
        final /* synthetic */ hj f9241a;

        C29549(hj hjVar) {
            this.f9241a = hjVar;
        }

        public void mo3708a(je jeVar, hs hsVar) {
        }

        public void mo3709a(final je jeVar, hs hsVar, go goVar, final C2971a c2971a) {
            this.f9241a.m11475a(new Runnable(this) {
                final /* synthetic */ C29549 f9240c;

                public void run() {
                    kf a = this.f9240c.f9241a.f9266f.m11496a(jeVar.m11869a());
                    if (!a.mo3778b()) {
                        this.f9240c.f9241a.m11449a(this.f9240c.f9241a.f9276p.m11570a(jeVar.m11869a(), a));
                        c2971a.mo3723a(null);
                    }
                }
            });
        }
    }

    private static class C2955a implements Comparable<C2955a> {
        private hh f9242a;
        private C3585a f9243b;
        private C0623m f9244c;
        private C2956b f9245d;
        private long f9246e;
        private boolean f9247f;
        private int f9248g;
        private C3536b f9249h;
        private long f9250i;
        private kf f9251j;
        private kf f9252k;
        private kf f9253l;

        public int m11430a(C2955a c2955a) {
            return this.f9246e < c2955a.f9246e ? -1 : this.f9246e == c2955a.f9246e ? 0 : 1;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m11430a((C2955a) obj);
        }
    }

    private enum C2956b {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    hj(hk hkVar, ha haVar, C3576f c3576f) {
        this.f9263c = hkVar;
        this.f9271k = haVar;
        this.f9278r = c3576f;
        this.f9272l = this.f9271k.m11314a("RepoOperation");
        this.f9273m = this.f9271k.m11314a("Transaction");
        this.f9274n = this.f9271k.m11314a("DataOperation");
        this.f9270j = new jc(this.f9271k);
        this.f9265e = haVar.m11313a(new gn(hkVar.f9281a, hkVar.f9283c, hkVar.f9282b), this);
        m11475a(new C29441(this));
    }

    private hh m11431a(hh hhVar) {
        it b = m11453b(hhVar);
        hh b2 = b.m11810b();
        m11458b(m11460c(b), b2);
        return b2;
    }

    private hh m11432a(hh hhVar, final int i) {
        hh b = m11453b(hhVar).m11810b();
        if (this.f9273m.m11961a()) {
            jp jpVar = this.f9272l;
            String valueOf = String.valueOf(hhVar);
            String valueOf2 = String.valueOf(b);
            jpVar.m11960a(new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(valueOf2).length()).append("Aborting transactions for path: ").append(valueOf).append(". Affected: ").append(valueOf2).toString(), new Object[0]);
        }
        it a = this.f9268h.m11802a(hhVar);
        a.m11808a(new C2949a<List<C2955a>>(this) {
            final /* synthetic */ hj f9233b;

            public boolean mo3712a(it<List<C2955a>> itVar) {
                this.f9233b.m11447a((it) itVar, i);
                return false;
            }
        });
        m11447a(a, i);
        a.m11805a(new C2942b<List<C2955a>>(this) {
            final /* synthetic */ hj f9235b;

            public void mo3711a(it<List<C2955a>> itVar) {
                this.f9235b.m11447a((it) itVar, i);
            }
        });
        return b;
    }

    private kf m11435a(hh hhVar, List<Long> list) {
        kf b = this.f9277q.m11579b(hhVar, (List) list);
        return b == null ? jx.m12080j() : b;
    }

    private void m11437a(long j, hh hhVar, C3536b c3536b) {
        if (c3536b == null || c3536b.m15466a() != -25) {
            List a = this.f9277q.m11566a(j, !(c3536b == null), true, this.f9264d);
            if (a.size() > 0) {
                m11431a(hhVar);
            }
            m11449a(a);
        }
    }

    private void m11445a(im imVar) {
        List<hv> a = imVar.mo3742a();
        Map a2 = hn.m11494a(this.f9264d);
        long j = Long.MIN_VALUE;
        for (final hv hvVar : a) {
            gs anonymousClass11 = new gs(this) {
                final /* synthetic */ hj f9205b;

                public void mo3707a(String str, String str2) {
                    C3536b a = hj.m11454b(str, str2);
                    this.f9205b.m11448a("Persisted write", hvVar.m11588b(), a);
                    this.f9205b.m11437a(hvVar.m11587a(), hvVar.m11588b(), a);
                }
            };
            if (j >= hvVar.m11587a()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            long a3 = hvVar.m11587a();
            this.f9275o = hvVar.m11587a() + 1;
            if (hvVar.m11591e()) {
                if (this.f9272l.m11961a()) {
                    this.f9272l.m11960a("Restoring overwrite with id " + hvVar.m11587a(), new Object[0]);
                }
                this.f9265e.mo3674a(hvVar.m11588b().m11386c(), hvVar.m11589c().mo3775a(true), anonymousClass11);
                this.f9277q.m11572a(hvVar.m11588b(), hvVar.m11589c(), hn.m11492a(hvVar.m11589c(), a2), hvVar.m11587a(), true, false);
            } else {
                if (this.f9272l.m11961a()) {
                    this.f9272l.m11960a("Restoring merge with id " + hvVar.m11587a(), new Object[0]);
                }
                this.f9265e.mo3678a(hvVar.m11588b().m11386c(), hvVar.m11590d().m11284a(true), anonymousClass11);
                this.f9277q.m11569a(hvVar.m11588b(), hvVar.m11590d(), hn.m11490a(hvVar.m11590d(), a2), hvVar.m11587a(), false);
            }
            j = a3;
        }
    }

    private void m11446a(it<List<C2955a>> itVar) {
        if (((List) itVar.m11803a()) != null) {
            List<C2955a> c = m11460c((it) itVar);
            if (f9261b || c.size() > 0) {
                Boolean valueOf;
                Boolean valueOf2 = Boolean.valueOf(true);
                for (C2955a d : c) {
                    if (d.f9245d != C2956b.RUN) {
                        valueOf = Boolean.valueOf(false);
                        break;
                    }
                }
                valueOf = valueOf2;
                if (valueOf.booleanValue()) {
                    m11450a((List) c, itVar.m11810b());
                    return;
                }
                return;
            }
            throw new AssertionError();
        } else if (itVar.m11812c()) {
            itVar.m11811b(new C2942b<List<C2955a>>(this) {
                final /* synthetic */ hj f9215a;

                {
                    this.f9215a = r1;
                }

                public void mo3711a(it<List<C2955a>> itVar) {
                    this.f9215a.m11446a((it) itVar);
                }
            });
        }
    }

    private void m11447a(it<List<C2955a>> itVar, int i) {
        List list = (List) itVar.m11803a();
        List arrayList = new ArrayList();
        if (list != null) {
            C3536b a;
            List<Runnable> arrayList2 = new ArrayList();
            if (i == -9) {
                a = C3536b.m15462a("overriddenBySet");
            } else {
                lh.m12296a(i == -25, "Unknown transaction abort reason: " + i);
                a = C3536b.m15461a(-25);
            }
            int i2 = 0;
            int i3 = -1;
            while (i2 < list.size()) {
                int i4;
                final C2955a c2955a = (C2955a) list.get(i2);
                if (c2955a.f9245d == C2956b.SENT_NEEDS_ABORT) {
                    i4 = i3;
                } else if (c2955a.f9245d == C2956b.SENT) {
                    if (f9261b || i3 == i2 - 1) {
                        c2955a.f9245d = C2956b.SENT_NEEDS_ABORT;
                        c2955a.f9249h = a;
                        i4 = i2;
                    } else {
                        throw new AssertionError();
                    }
                } else if (f9261b || c2955a.f9245d == C2956b.RUN) {
                    m11471a(new hx(this, c2955a.f9244c, je.m11867a(c2955a.f9242a)));
                    if (i == -9) {
                        arrayList.addAll(this.f9277q.m11566a(c2955a.f9250i, true, false, this.f9264d));
                    } else {
                        lh.m12296a(i == -25, "Unknown transaction abort reason: " + i);
                    }
                    arrayList2.add(new Runnable(this) {
                        public void run() {
                            c2955a.f9243b.m15596a(a, false, null);
                        }
                    });
                    i4 = i3;
                } else {
                    throw new AssertionError();
                }
                i2++;
                i3 = i4;
            }
            if (i3 == -1) {
                itVar.m11807a(null);
            } else {
                itVar.m11807a(list.subList(0, i3 + 1));
            }
            m11449a(arrayList);
            for (Runnable b : arrayList2) {
                m11482b(b);
            }
        }
    }

    private void m11448a(String str, hh hhVar, C3536b c3536b) {
        if (c3536b != null && c3536b.m15466a() != -1 && c3536b.m15466a() != -25) {
            jp jpVar = this.f9272l;
            String valueOf = String.valueOf(hhVar.toString());
            String valueOf2 = String.valueOf(c3536b.toString());
            jpVar.m11957a(new StringBuilder(((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append(str).append(" at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
        }
    }

    private void m11449a(List<? extends iz> list) {
        if (!list.isEmpty()) {
            this.f9270j.m11849a((List) list);
        }
    }

    private void m11450a(final List<C2955a> list, final hh hhVar) {
        List arrayList = new ArrayList();
        for (C2955a c : list) {
            arrayList.add(Long.valueOf(c.f9250i));
        }
        kf a = m11435a(hhVar, arrayList);
        String d = a.mo3781d();
        kf kfVar = a;
        for (C2955a c2 : list) {
            if (f9261b || c2.f9245d == C2956b.RUN) {
                c2.f9245d = C2956b.SENT;
                c2.f9248g = c2.f9248g + 1;
                kfVar = kfVar.mo3773a(hh.m11377a(hhVar, c2.f9242a), c2.f9252k);
            } else {
                throw new AssertionError();
            }
        }
        this.f9265e.mo3675a(hhVar.m11386c(), kfVar.mo3775a(true), d, new gs(this) {
            final /* synthetic */ hj f9221d;

            public void mo3707a(String str, String str2) {
                int i = 0;
                C3536b a = hj.m11454b(str, str2);
                this.f9221d.m11448a("Transaction", hhVar, a);
                List arrayList = new ArrayList();
                if (a == null) {
                    List arrayList2 = new ArrayList();
                    for (final C2955a c2955a : list) {
                        c2955a.f9245d = C2956b.COMPLETED;
                        arrayList.addAll(this.f9221d.f9277q.m11566a(c2955a.f9250i, false, false, this.f9221d.f9264d));
                        final C3535a a2 = C3588n.m15600a(C3588n.m15601a(this, c2955a.f9242a), jz.m12107a(c2955a.f9253l));
                        arrayList2.add(new Runnable(this) {
                            public void run() {
                                c2955a.f9243b.m15596a(null, true, a2);
                            }
                        });
                        this.f9221d.m11471a(new hx(this.f9221d, c2955a.f9244c, je.m11867a(c2955a.f9242a)));
                    }
                    this.f9221d.m11456b(this.f9221d.f9268h.m11802a(hhVar));
                    this.f9221d.m11467f();
                    this.m11449a(arrayList);
                    while (i < arrayList2.size()) {
                        this.f9221d.m11482b((Runnable) arrayList2.get(i));
                        i++;
                    }
                    return;
                }
                if (a.m15466a() == -1) {
                    for (C2955a c2955a2 : list) {
                        if (c2955a2.f9245d == C2956b.SENT_NEEDS_ABORT) {
                            c2955a2.f9245d = C2956b.NEEDS_ABORT;
                        } else {
                            c2955a2.f9245d = C2956b.RUN;
                        }
                    }
                } else {
                    for (C2955a c2955a22 : list) {
                        c2955a22.f9245d = C2956b.NEEDS_ABORT;
                        c2955a22.f9249h = a;
                    }
                }
                this.f9221d.m11431a(hhVar);
            }
        });
    }

    private void m11451a(final List<C2955a> list, it<List<C2955a>> itVar) {
        List list2 = (List) itVar.m11803a();
        if (list2 != null) {
            list.addAll(list2);
        }
        itVar.m11811b(new C2942b<List<C2955a>>(this) {
            final /* synthetic */ hj f9231b;

            public void mo3711a(it<List<C2955a>> itVar) {
                this.f9231b.m11451a(list, (it) itVar);
            }
        });
    }

    private it<List<C2955a>> m11453b(hh hhVar) {
        it<List<C2955a>> itVar = this.f9268h;
        while (!hhVar.m11391h() && itVar.m11803a() == null) {
            itVar = itVar.m11802a(new hh(hhVar.m11387d()));
            hhVar = hhVar.m11388e();
        }
        return itVar;
    }

    private static C3536b m11454b(String str, String str2) {
        return str != null ? C3536b.m15463a(str, str2) : null;
    }

    private void m11456b(it<List<C2955a>> itVar) {
        Object obj = (List) itVar.m11803a();
        if (obj != null) {
            int i = 0;
            while (i < obj.size()) {
                int i2;
                if (((C2955a) obj.get(i)).f9245d == C2956b.COMPLETED) {
                    obj.remove(i);
                    i2 = i;
                } else {
                    i2 = i + 1;
                }
                i = i2;
            }
            if (obj.size() > 0) {
                itVar.m11807a(obj);
            } else {
                itVar.m11807a(null);
            }
        }
        itVar.m11811b(new C2942b<List<C2955a>>(this) {
            final /* synthetic */ hj f9222a;

            {
                this.f9222a = r1;
            }

            public void mo3711a(it<List<C2955a>> itVar) {
                this.f9222a.m11456b((it) itVar);
            }
        });
    }

    private void m11457b(js jsVar, Object obj) {
        if (jsVar.equals(gy.f9160b)) {
            this.f9264d.m12285a(((Long) obj).longValue());
        }
        hh hhVar = new hh(gy.f9159a, jsVar);
        try {
            kf a = kg.m12177a(obj);
            this.f9266f.m11497a(hhVar, a);
            m11449a(this.f9276p.m11570a(hhVar, a));
        } catch (Throwable e) {
            this.f9272l.m11958a("Failed to parse info update", e);
        }
    }

    private void m11458b(List<C2955a> list, hh hhVar) {
        if (!list.isEmpty()) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (C2955a c : list) {
                arrayList2.add(Long.valueOf(c.f9250i));
            }
            for (final C2955a c2955a : list) {
                hh a = hh.m11377a(hhVar, c2955a.f9242a);
                ArrayList arrayList3 = new ArrayList();
                if (f9261b || a != null) {
                    Object obj;
                    C3536b k;
                    if (c2955a.f9245d == C2956b.NEEDS_ABORT) {
                        obj = 1;
                        k = c2955a.f9249h;
                        if (k.m15466a() != -25) {
                            arrayList3.addAll(this.f9277q.m11566a(c2955a.f9250i, true, false, this.f9264d));
                        }
                    } else if (c2955a.f9245d != C2956b.RUN) {
                        k = null;
                        obj = null;
                    } else if (c2955a.f9248g >= 25) {
                        obj = 1;
                        k = C3536b.m15462a("maxretries");
                        arrayList3.addAll(this.f9277q.m11566a(c2955a.f9250i, true, false, this.f9264d));
                    } else {
                        C3586b a2;
                        kf a3 = m11435a(c2955a.f9242a, arrayList2);
                        c2955a.f9251j = a3;
                        try {
                            a2 = c2955a.f9243b.m15595a(C3588n.m15602a(a3));
                            k = null;
                        } catch (Throwable th) {
                            C3536b a4 = C3536b.m15465a(th);
                            a2 = C3587l.m15599a();
                            k = a4;
                        }
                        if (a2.m15597a()) {
                            Long valueOf = Long.valueOf(c2955a.f9250i);
                            Map a5 = hn.m11494a(this.f9264d);
                            kf b = a2.m15598b();
                            kf a6 = hn.m11492a(b, a5);
                            c2955a.f9252k = b;
                            c2955a.f9253l = a6;
                            c2955a.f9250i = m11462d();
                            arrayList2.remove(valueOf);
                            arrayList3.addAll(this.f9277q.m11572a(c2955a.f9242a, b, a6, c2955a.f9250i, c2955a.f9247f, false));
                            arrayList3.addAll(this.f9277q.m11566a(valueOf.longValue(), true, false, this.f9264d));
                            k = null;
                            obj = null;
                        } else {
                            obj = 1;
                            arrayList3.addAll(this.f9277q.m11566a(c2955a.f9250i, true, false, this.f9264d));
                        }
                    }
                    m11449a((List) arrayList3);
                    if (obj != null) {
                        c2955a.f9245d = C2956b.COMPLETED;
                        final C3535a a7 = C3588n.m15600a(C3588n.m15601a(this, c2955a.f9242a), jz.m12107a(c2955a.f9251j));
                        m11475a(new Runnable(this) {
                            final /* synthetic */ hj f9225b;

                            public void run() {
                                this.f9225b.m11471a(new hx(this.f9225b, c2955a.f9244c, je.m11867a(c2955a.f9242a)));
                            }
                        });
                        arrayList.add(new Runnable(this) {
                            public void run() {
                                c2955a.f9243b.m15596a(k, false, a7);
                            }
                        });
                    }
                } else {
                    throw new AssertionError();
                }
            }
            m11456b(this.f9268h);
            for (int i = 0; i < arrayList.size(); i++) {
                m11482b((Runnable) arrayList.get(i));
            }
            m11467f();
        }
    }

    private List<C2955a> m11460c(it<List<C2955a>> itVar) {
        List arrayList = new ArrayList();
        m11451a(arrayList, (it) itVar);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void m11461c() {
        this.f9271k.m11329n().mo3597a(new C29474(this));
        this.f9265e.mo3669a();
        im b = this.f9271k.m11316b(this.f9263c.f9281a);
        this.f9266f = new ho();
        this.f9267g = new hp();
        this.f9268h = new it();
        this.f9276p = new hr(this.f9271k, new il(), new C29549(this));
        this.f9277q = new hr(this.f9271k, b, new C2940c(this) {
            final /* synthetic */ hj f9203a;

            {
                this.f9203a = r1;
            }

            public void mo3708a(je jeVar, hs hsVar) {
                this.f9203a.f9265e.mo3676a(jeVar.m11869a().m11386c(), jeVar.m11870b().m11862k());
            }

            public void mo3709a(je jeVar, hs hsVar, go goVar, final C2971a c2971a) {
                this.f9203a.f9265e.mo3677a(jeVar.m11869a().m11386c(), jeVar.m11870b().m11862k(), goVar, hsVar != null ? Long.valueOf(hsVar.m11581a()) : null, new gs(this) {
                    final /* synthetic */ AnonymousClass10 f9202b;

                    public void mo3707a(String str, String str2) {
                        this.f9202b.f9203a.m11449a(c2971a.mo3723a(hj.m11454b(str, str2)));
                    }
                });
            }
        });
        m11445a(b);
        m11457b(gy.f9161c, Boolean.valueOf(false));
        m11457b(gy.f9162d, Boolean.valueOf(false));
    }

    private long m11462d() {
        long j = this.f9275o;
        this.f9275o = 1 + j;
        return j;
    }

    private void m11465e() {
        hp a = hn.m11491a(this.f9267g, hn.m11494a(this.f9264d));
        final List arrayList = new ArrayList();
        a.m11500a(hh.m11376a(), new C2941b(this) {
            final /* synthetic */ hj f9214b;

            public void mo3710a(hh hhVar, kf kfVar) {
                arrayList.addAll(this.f9214b.f9277q.m11570a(hhVar, kfVar));
                this.f9214b.m11431a(this.f9214b.m11432a(hhVar, -9));
            }
        });
        this.f9267g = new hp();
        m11449a(arrayList);
    }

    private void m11467f() {
        it itVar = this.f9268h;
        m11456b(itVar);
        m11446a(itVar);
    }

    public void mo3713a() {
        m11473a(gy.f9162d, Boolean.valueOf(true));
    }

    public void m11471a(hc hcVar) {
        m11449a(gy.f9159a.equals(hcVar.mo3728a().m11869a().m11387d()) ? this.f9276p.m11580b(hcVar) : this.f9277q.m11580b(hcVar));
    }

    public void m11472a(hh hhVar, kf kfVar, C3041a c3041a) {
        if (this.f9272l.m11961a()) {
            jp jpVar = this.f9272l;
            String valueOf = String.valueOf(hhVar);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 5).append("set: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f9274n.m11961a()) {
            jpVar = this.f9274n;
            valueOf = String.valueOf(hhVar);
            String valueOf2 = String.valueOf(kfVar);
            jpVar.m11960a(new StringBuilder((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()).append("set: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        kf a = hn.m11492a(kfVar, hn.m11494a(this.f9264d));
        final long d = m11462d();
        m11449a(this.f9277q.m11572a(hhVar, kfVar, a, d, true, true));
        final hh hhVar2 = hhVar;
        final C3041a c3041a2 = c3041a;
        this.f9265e.mo3674a(hhVar.m11386c(), kfVar.mo3775a(true), new gs(this) {
            final /* synthetic */ hj f9212d;

            public void mo3707a(String str, String str2) {
                C3536b a = hj.m11454b(str, str2);
                this.f9212d.m11448a("setValue", hhVar2, a);
                this.f9212d.m11437a(d, hhVar2, a);
                this.f9212d.m11474a(c3041a2, a, hhVar2);
            }
        });
        m11431a(m11432a(hhVar, -9));
    }

    public void m11473a(js jsVar, Object obj) {
        m11457b(jsVar, obj);
    }

    void m11474a(final C3041a c3041a, final C3536b c3536b, hh hhVar) {
        if (c3041a != null) {
            js g = hhVar.m11390g();
            final C3574d a = (g == null || !g.m12011e()) ? C3588n.m15601a(this, hhVar) : C3588n.m15601a(this, hhVar.m11389f());
            m11482b(new Runnable(this) {
                public void run() {
                    c3041a.mo3818a(c3536b, a);
                }
            });
        }
    }

    public void m11475a(Runnable runnable) {
        this.f9271k.m11318c();
        this.f9271k.m11326k().mo3601a(runnable);
    }

    public void mo3714a(List<String> list, Object obj, boolean z, Long l) {
        List a;
        hh hhVar = new hh((List) list);
        if (this.f9272l.m11961a()) {
            jp jpVar = this.f9272l;
            String valueOf = String.valueOf(hhVar);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 14).append("onDataUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f9274n.m11961a()) {
            jpVar = this.f9272l;
            valueOf = String.valueOf(hhVar);
            String valueOf2 = String.valueOf(obj);
            jpVar.m11960a(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(valueOf2).length()).append("onDataUpdate: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        this.f9262a++;
        if (l != null) {
            try {
                hs hsVar = new hs(l.longValue());
                if (z) {
                    Map hashMap = new HashMap();
                    for (Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new hh((String) entry.getKey()), kg.m12177a(entry.getValue()));
                    }
                    a = this.f9277q.m11576a(hhVar, hashMap, hsVar);
                } else {
                    a = this.f9277q.m11571a(hhVar, kg.m12177a(obj), hsVar);
                }
            } catch (Throwable e) {
                this.f9272l.m11958a("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            Map hashMap2 = new HashMap();
            for (Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new hh((String) entry2.getKey()), kg.m12177a(entry2.getValue()));
            }
            a = this.f9277q.m11575a(hhVar, hashMap2);
        } else {
            a = this.f9277q.m11570a(hhVar, kg.m12177a(obj));
        }
        if (a.size() > 0) {
            m11431a(hhVar);
        }
        m11449a(a);
    }

    public void mo3715a(List<String> list, List<gr> list2, Long l) {
        hh hhVar = new hh((List) list);
        if (this.f9272l.m11961a()) {
            jp jpVar = this.f9272l;
            String valueOf = String.valueOf(hhVar);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 20).append("onRangeMergeUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f9274n.m11961a()) {
            jpVar = this.f9272l;
            valueOf = String.valueOf(hhVar);
            String valueOf2 = String.valueOf(list2);
            jpVar.m11960a(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append("onRangeMergeUpdate: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        this.f9262a++;
        List arrayList = new ArrayList(list2.size());
        for (gr kkVar : list2) {
            arrayList.add(new kk(kkVar));
        }
        List a = l != null ? this.f9277q.m11574a(hhVar, arrayList, new hs(l.longValue())) : this.f9277q.m11573a(hhVar, arrayList);
        if (a.size() > 0) {
            m11431a(hhVar);
        }
        m11449a(a);
    }

    public void mo3716a(Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            m11457b(js.m12005a((String) entry.getKey()), entry.getValue());
        }
    }

    public void mo3717a(boolean z) {
        m11473a(gy.f9161c, Boolean.valueOf(z));
    }

    public void mo3718b() {
        m11473a(gy.f9162d, Boolean.valueOf(false));
        m11465e();
    }

    public void m11481b(hc hcVar) {
        js d = hcVar.mo3728a().m11869a().m11387d();
        List a = (d == null || !d.equals(gy.f9159a)) ? this.f9277q.m11567a(hcVar) : this.f9276p.m11567a(hcVar);
        m11449a(a);
    }

    public void m11482b(Runnable runnable) {
        this.f9271k.m11318c();
        this.f9271k.m11325j().mo3600a(runnable);
    }

    public String toString() {
        return this.f9263c.toString();
    }
}
