package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import com.google.android.gms.internal.aam.C2638b;
import com.google.android.gms.internal.tf.C3278a;
import java.util.Map;

@wh
public class ti {
    private final Object f10760a;
    private final Context f10761b;
    private final String f10762c;
    private final zzqh f10763d;
    private zq<tf> f10764e;
    private zq<tf> f10765f;
    @Nullable
    private C3308d f10766g;
    private int f10767h;

    static class C3298a {
        static int f10743a = 60000;
        static int f10744b = 10000;
    }

    public static class C3299b<T> implements zq<T> {
        public void mo4041a(T t) {
        }
    }

    public static class C3303c extends aan<tj> {
        private final Object f10747d = new Object();
        private final C3308d f10748e;
        private boolean f10749f;

        class C33001 implements C2380c<tj> {
            C33001(C3303c c3303c) {
            }

            public void m13936a(tj tjVar) {
                zh.m15051a("Ending javascript session.");
                ((tk) tjVar).mo4044a();
            }

            public /* synthetic */ void mo3272a(Object obj) {
                m13936a((tj) obj);
            }
        }

        class C33012 implements C2380c<tj> {
            final /* synthetic */ C3303c f10745a;

            C33012(C3303c c3303c) {
                this.f10745a = c3303c;
            }

            public void m13938a(tj tjVar) {
                zh.m15051a("Releasing engine reference.");
                this.f10745a.f10748e.i_();
            }

            public /* synthetic */ void mo3272a(Object obj) {
                m13938a((tj) obj);
            }
        }

        class C33023 implements C2637a {
            final /* synthetic */ C3303c f10746a;

            C33023(C3303c c3303c) {
                this.f10746a = c3303c;
            }

            public void mo3379a() {
                this.f10746a.f10748e.i_();
            }
        }

        public C3303c(C3308d c3308d) {
            this.f10748e = c3308d;
        }

        public void g_() {
            synchronized (this.f10747d) {
                if (this.f10749f) {
                    return;
                }
                this.f10749f = true;
                mo3380a(new C33001(this), new C2638b());
                mo3380a(new C33012(this), new C33023(this));
            }
        }
    }

    public static class C3308d extends aan<tf> {
        private final Object f10755d = new Object();
        private zq<tf> f10756e;
        private boolean f10757f;
        private int f10758g;

        class C33073 implements C2380c<tf> {
            final /* synthetic */ C3308d f10754a;

            C33073(C3308d c3308d) {
                this.f10754a = c3308d;
            }

            public void m13945a(final tf tfVar) {
                zzw.zzcM().m15125a(new Runnable(this) {
                    final /* synthetic */ C33073 f10753b;

                    public void run() {
                        this.f10753b.f10754a.f10756e.mo4041a(tfVar);
                        tfVar.mo4034a();
                    }
                });
            }

            public /* synthetic */ void mo3272a(Object obj) {
                m13945a((tf) obj);
            }
        }

        public C3308d(zq<tf> zqVar) {
            this.f10756e = zqVar;
            this.f10757f = false;
            this.f10758g = 0;
        }

        public void m13948c() {
            boolean z = true;
            synchronized (this.f10755d) {
                if (this.f10758g < 0) {
                    z = false;
                }
                C2513c.m7937a(z);
                zh.m15051a("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.f10757f = true;
                m13949d();
            }
        }

        protected void m13949d() {
            synchronized (this.f10755d) {
                C2513c.m7937a(this.f10758g >= 0);
                if (this.f10757f && this.f10758g == 0) {
                    zh.m15051a("No reference is left (including root). Cleaning up engine.");
                    mo3380a(new C33073(this), new C2638b());
                } else {
                    zh.m15051a("There are still references to the engine. Not destroying.");
                }
            }
        }

        public C3303c h_() {
            final C3303c c3303c = new C3303c(this);
            synchronized (this.f10755d) {
                mo3380a(new C2380c<tf>(this) {
                    public void m13942a(tf tfVar) {
                        zh.m15051a("Getting a new session for JS Engine.");
                        c3303c.mo3381a(tfVar.mo4038b());
                    }

                    public /* synthetic */ void mo3272a(Object obj) {
                        m13942a((tf) obj);
                    }
                }, new C2637a(this) {
                    public void mo3379a() {
                        zh.m15051a("Rejecting reference for JS Engine.");
                        c3303c.mo4042a();
                    }
                });
                C2513c.m7937a(this.f10758g >= 0);
                this.f10758g++;
            }
            return c3303c;
        }

        protected void i_() {
            boolean z = true;
            synchronized (this.f10755d) {
                if (this.f10758g < 1) {
                    z = false;
                }
                C2513c.m7937a(z);
                zh.m15051a("Releasing 1 reference for JS Engine");
                this.f10758g--;
                m13949d();
            }
        }
    }

    public static class C3309e extends aan<tj> {
        private C3303c f10759d;

        public C3309e(C3303c c3303c) {
            this.f10759d = c3303c;
        }

        public void mo4042a() {
            this.f10759d.mo4042a();
        }

        public void mo3380a(C2380c<tj> c2380c, C2637a c2637a) {
            this.f10759d.mo3380a(c2380c, c2637a);
        }

        public void m13952a(tj tjVar) {
            this.f10759d.mo3381a(tjVar);
        }

        public /* synthetic */ void mo3381a(Object obj) {
            m13952a((tj) obj);
        }

        public int mo4043b() {
            return this.f10759d.mo4043b();
        }

        public void finalize() {
            this.f10759d.g_();
            this.f10759d = null;
        }
    }

    public ti(Context context, zzqh com_google_android_gms_internal_zzqh, String str) {
        this.f10760a = new Object();
        this.f10767h = 1;
        this.f10762c = str;
        this.f10761b = context.getApplicationContext();
        this.f10763d = com_google_android_gms_internal_zzqh;
        this.f10764e = new C3299b();
        this.f10765f = new C3299b();
    }

    public ti(Context context, zzqh com_google_android_gms_internal_zzqh, String str, zq<tf> zqVar, zq<tf> zqVar2) {
        this(context, com_google_android_gms_internal_zzqh, str);
        this.f10764e = zqVar;
        this.f10765f = zqVar2;
    }

    private C3308d m13959c(@Nullable final ed edVar) {
        final C3308d c3308d = new C3308d(this.f10765f);
        zzw.zzcM().m15125a(new Runnable(this) {
            final /* synthetic */ ti f10738c;

            public void run() {
                final tf a = this.f10738c.m13965a(this.f10738c.f10761b, this.f10738c.f10763d, edVar);
                a.mo4036a(new C3278a(this) {
                    final /* synthetic */ C32951 f10727b;

                    class C32891 implements Runnable {
                        final /* synthetic */ C32901 f10725a;

                        class C32881 implements Runnable {
                            final /* synthetic */ C32891 f10724a;

                            C32881(C32891 c32891) {
                                this.f10724a = c32891;
                            }

                            public void run() {
                                a.mo4034a();
                            }
                        }

                        C32891(C32901 c32901) {
                            this.f10725a = c32901;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.f10725a;
                            r0 = r0.f10727b;
                            r0 = r0.f10738c;
                            r1 = r0.f10760a;
                            monitor-enter(r1);
                            r0 = r3.f10725a;	 Catch:{ all -> 0x0043 }
                            r0 = r0.f10727b;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.mo4043b();	 Catch:{ all -> 0x0043 }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.f10725a;	 Catch:{ all -> 0x0043 }
                            r0 = r0.f10727b;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.mo4043b();	 Catch:{ all -> 0x0043 }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.f10725a;	 Catch:{ all -> 0x0043 }
                            r0 = r0.f10727b;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0.mo4042a();	 Catch:{ all -> 0x0043 }
                            r0 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x0043 }
                            r2 = new com.google.android.gms.internal.ti$1$1$1$1;	 Catch:{ all -> 0x0043 }
                            r2.<init>(r3);	 Catch:{ all -> 0x0043 }
                            r0.m15125a(r2);	 Catch:{ all -> 0x0043 }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.internal.zh.m15051a(r0);	 Catch:{ all -> 0x0043 }
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            goto L_0x0026;
                        L_0x0043:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ti.1.1.1.run():void");
                        }
                    }

                    public void mo4033a() {
                        zl.f11678a.postDelayed(new C32891(this), (long) C3298a.f10744b);
                    }
                });
                a.mo3402a("/jsLoaded", new sc(this) {
                    final /* synthetic */ C32951 f10729b;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void mo3260a(com.google.android.gms.internal.aat r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.f10729b;
                        r0 = r0.f10738c;
                        r1 = r0.f10760a;
                        monitor-enter(r1);
                        r0 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.mo4043b();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.mo4043b();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f10738c;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.f10767h = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f10738c;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f10764e;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.mo4041a(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.mo3381a(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f10738c;	 Catch:{ all -> 0x0051 }
                        r2 = r3.f10729b;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.f10766g = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.internal.zh.m15051a(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ti.1.2.a(com.google.android.gms.internal.aat, java.util.Map):void");
                    }
                });
                final zy zyVar = new zy();
                sc c32923 = new sc(this) {
                    final /* synthetic */ C32951 f10732c;

                    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                        synchronized (this.f10732c.f10738c.f10760a) {
                            aad.m8425d("JS Engine is requesting an update");
                            if (this.f10732c.f10738c.f10767h == 0) {
                                aad.m8425d("Starting reload.");
                                this.f10732c.f10738c.f10767h = 2;
                                this.f10732c.f10738c.m13967a(edVar);
                            }
                            a.mo3409b("/requestReload", (sc) zyVar.m15283a());
                        }
                    }
                };
                zyVar.m15284a(c32923);
                a.mo3402a("/requestReload", c32923);
                if (this.f10738c.f10762c.endsWith(".js")) {
                    a.mo4037a(this.f10738c.f10762c);
                } else if (this.f10738c.f10762c.startsWith("<html>")) {
                    a.mo4040c(this.f10738c.f10762c);
                } else {
                    a.mo4039b(this.f10738c.f10762c);
                }
                zl.f11678a.postDelayed(new Runnable(this) {
                    final /* synthetic */ C32951 f10735b;

                    class C32931 implements Runnable {
                        final /* synthetic */ C32944 f10733a;

                        C32931(C32944 c32944) {
                            this.f10733a = c32944;
                        }

                        public void run() {
                            a.mo4034a();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.f10735b;
                        r0 = r0.f10738c;
                        r1 = r0.f10760a;
                        monitor-enter(r1);
                        r0 = r3.f10735b;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.mo4043b();	 Catch:{ all -> 0x003b }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.f10735b;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.mo4043b();	 Catch:{ all -> 0x003b }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.f10735b;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0.mo4042a();	 Catch:{ all -> 0x003b }
                        r0 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x003b }
                        r2 = new com.google.android.gms.internal.ti$1$4$1;	 Catch:{ all -> 0x003b }
                        r2.<init>(r3);	 Catch:{ all -> 0x003b }
                        r0.m15125a(r2);	 Catch:{ all -> 0x003b }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.internal.zh.m15051a(r0);	 Catch:{ all -> 0x003b }
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        goto L_0x0020;
                    L_0x003b:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ti.1.4.run():void");
                    }
                }, (long) C3298a.f10743a);
            }
        });
        return c3308d;
    }

    protected tf m13965a(Context context, zzqh com_google_android_gms_internal_zzqh, @Nullable ed edVar) {
        return new th(context, com_google_android_gms_internal_zzqh, edVar, null);
    }

    public C3303c m13966a() {
        return m13968b(null);
    }

    protected C3308d m13967a(@Nullable ed edVar) {
        final C3308d c = m13959c(edVar);
        c.mo3380a(new C2380c<tf>(this) {
            final /* synthetic */ ti f10740b;

            public void m13931a(tf tfVar) {
                synchronized (this.f10740b.f10760a) {
                    this.f10740b.f10767h = 0;
                    if (!(this.f10740b.f10766g == null || c == this.f10740b.f10766g)) {
                        zh.m15051a("New JS engine is loaded, marking previous one as destroyable.");
                        this.f10740b.f10766g.m13948c();
                    }
                    this.f10740b.f10766g = c;
                }
            }

            public /* synthetic */ void mo3272a(Object obj) {
                m13931a((tf) obj);
            }
        }, new C2637a(this) {
            final /* synthetic */ ti f10742b;

            public void mo3379a() {
                synchronized (this.f10742b.f10760a) {
                    this.f10742b.f10767h = 1;
                    zh.m15051a("Failed loading new engine. Marking new engine destroyable.");
                    c.m13948c();
                }
            }
        });
        return c;
    }

    public C3303c m13968b(@Nullable ed edVar) {
        C3303c h_;
        synchronized (this.f10760a) {
            if (this.f10766g == null || this.f10766g.mo4043b() == -1) {
                this.f10767h = 2;
                this.f10766g = m13967a(edVar);
                h_ = this.f10766g.h_();
            } else if (this.f10767h == 0) {
                h_ = this.f10766g.h_();
            } else if (this.f10767h == 1) {
                this.f10767h = 2;
                m13967a(edVar);
                h_ = this.f10766g.h_();
            } else if (this.f10767h == 2) {
                h_ = this.f10766g.h_();
            } else {
                h_ = this.f10766g.h_();
            }
        }
        return h_;
    }
}
