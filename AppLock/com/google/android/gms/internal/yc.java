package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.yd.C3451a;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.p065a.C2312b;

@wh
public class yc extends zg implements ye, yh {
    private final C3457a f11459a;
    private final Context f11460b;
    private final yj f11461c;
    private final yh f11462d;
    private final Object f11463e;
    private final String f11464f;
    private final String f11465g;
    private final tq f11466h;
    private final long f11467i;
    private int f11468j = 0;
    private int f11469k = 3;
    private yd f11470l;

    public yc(Context context, String str, String str2, tq tqVar, C3457a c3457a, yj yjVar, yh yhVar, long j) {
        this.f11460b = context;
        this.f11464f = str;
        this.f11465g = str2;
        this.f11466h = tqVar;
        this.f11459a = c3457a;
        this.f11461c = yjVar;
        this.f11463e = new Object();
        this.f11462d = yhVar;
        this.f11467i = j;
    }

    private void m14860a(zzec com_google_android_gms_internal_zzec, uc ucVar) {
        this.f11461c.m14915b().m14895a((yh) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f11464f)) {
                ucVar.mo4072a(com_google_android_gms_internal_zzec, this.f11465g, this.f11466h.f10771a);
            } else {
                ucVar.mo4071a(com_google_android_gms_internal_zzec, this.f11465g);
            }
        } catch (Throwable e) {
            aad.m8424c("Fail to load ad from adapter.", e);
            mo4221a(this.f11464f, 0);
        }
    }

    private void m14862b(long j) {
        while (true) {
            synchronized (this.f11463e) {
                if (this.f11468j != 0) {
                    break;
                } else if (!m14868a(j)) {
                    this.f11470l = new C3451a().m14875a(this.f11469k).m14876a(zzw.zzcS().mo3361b() - j).m14877a(this.f11464f).m14879b(this.f11466h.f10774d).m14878a();
                    return;
                }
            }
        }
        this.f11470l = new C3451a().m14876a(zzw.zzcS().mo3361b() - j).m14875a(1 == this.f11468j ? 6 : this.f11469k).m14877a(this.f11464f).m14879b(this.f11466h.f10774d).m14878a();
    }

    public yd m14864a() {
        yd ydVar;
        synchronized (this.f11463e) {
            ydVar = this.f11470l;
        }
        return ydVar;
    }

    public void mo4219a(int i) {
        mo4221a(this.f11464f, 0);
    }

    public void mo4220a(String str) {
        synchronized (this.f11463e) {
            this.f11468j = 1;
            this.f11463e.notify();
        }
    }

    public void mo4221a(String str, int i) {
        synchronized (this.f11463e) {
            this.f11468j = 2;
            this.f11469k = i;
            this.f11463e.notify();
        }
    }

    protected boolean m14868a(long j) {
        long b = this.f11467i - (zzw.zzcS().mo3361b() - j);
        if (b <= 0) {
            this.f11469k = 4;
            return false;
        }
        try {
            this.f11463e.wait(b);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.f11469k = 5;
            return false;
        }
    }

    public tq m14869b() {
        return this.f11466h;
    }

    public void mo4222c() {
        m14860a(this.f11459a.f11509a.f11994c, this.f11461c.m14914a());
    }

    public void onStop() {
    }

    public void zzco() {
        if (this.f11461c != null && this.f11461c.m14915b() != null && this.f11461c.m14914a() != null) {
            final yg b = this.f11461c.m14915b();
            b.m14895a(null);
            b.m14894a((ye) this);
            final zzec com_google_android_gms_internal_zzec = this.f11459a.f11509a.f11994c;
            final uc a = this.f11461c.m14914a();
            try {
                if (a.mo4078g()) {
                    aac.f7622a.post(new Runnable(this) {
                        final /* synthetic */ yc f11454c;

                        public void run() {
                            this.f11454c.m14860a(com_google_android_gms_internal_zzec, a);
                        }
                    });
                } else {
                    aac.f7622a.post(new Runnable(this) {
                        final /* synthetic */ yc f11458d;

                        public void run() {
                            try {
                                a.mo4066a(C2312b.m7327a(this.f11458d.f11460b), com_google_android_gms_internal_zzec, null, b, this.f11458d.f11465g);
                            } catch (Throwable e) {
                                Throwable th = e;
                                String str = "Fail to initialize adapter ";
                                String valueOf = String.valueOf(this.f11458d.f11464f);
                                aad.m8424c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
                                this.f11458d.mo4221a(this.f11458d.f11464f, 0);
                            }
                        }
                    });
                }
            } catch (Throwable e) {
                aad.m8424c("Fail to check if adapter is initialized.", e);
                mo4221a(this.f11464f, 0);
            }
            m14862b(zzw.zzcS().mo3361b());
            b.m14895a(null);
            b.m14894a(null);
            if (this.f11468j == 1) {
                this.f11462d.mo4220a(this.f11464f);
            } else {
                this.f11462d.mo4221a(this.f11464f, this.f11469k);
            }
        }
    }
}
