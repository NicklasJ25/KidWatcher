package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.oo.C3110a;
import com.google.android.gms.internal.op.C3112a;
import com.google.android.gms.internal.ov.C3113a;
import com.google.android.gms.internal.qn.C3176a;
import com.google.android.gms.internal.vg.C3255a;
import com.google.android.gms.internal.xu.C3268a;
import java.util.LinkedList;
import java.util.List;

@wh
class sw {
    private final List<C3245a> f10629a = new LinkedList();

    interface C3245a {
        void mo4017a(sx sxVar);
    }

    class C32511 extends C3112a {
        final /* synthetic */ sw f10615a;

        class C32461 implements C3245a {
            C32461(C32511 c32511) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10631a != null) {
                    sxVar.f10631a.mo3853a();
                }
            }
        }

        class C32483 implements C3245a {
            C32483(C32511 c32511) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10631a != null) {
                    sxVar.f10631a.mo3855b();
                }
            }
        }

        class C32494 implements C3245a {
            C32494(C32511 c32511) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10631a != null) {
                    sxVar.f10631a.mo3856c();
                }
            }
        }

        class C32505 implements C3245a {
            C32505(C32511 c32511) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10631a != null) {
                    sxVar.f10631a.mo3857d();
                }
            }
        }

        C32511(sw swVar) {
            this.f10615a = swVar;
        }

        public void mo3853a() {
            this.f10615a.f10629a.add(new C32461(this));
        }

        public void mo3854a(final int i) {
            this.f10615a.f10629a.add(new C3245a(this) {
                public void mo4017a(sx sxVar) {
                    if (sxVar.f10631a != null) {
                        sxVar.f10631a.mo3854a(i);
                    }
                }
            });
            zh.m15051a("Pooled interstitial failed to load.");
        }

        public void mo3855b() {
            this.f10615a.f10629a.add(new C32483(this));
        }

        public void mo3856c() {
            this.f10615a.f10629a.add(new C32494(this));
            zh.m15051a("Pooled interstitial loaded.");
        }

        public void mo3857d() {
            this.f10615a.f10629a.add(new C32505(this));
        }
    }

    class C32532 extends C3113a {
        final /* synthetic */ sw f10618a;

        C32532(sw swVar) {
            this.f10618a = swVar;
        }

        public void mo3861a(final String str, final String str2) {
            this.f10618a.f10629a.add(new C3245a(this) {
                public void mo4017a(sx sxVar) {
                    if (sxVar.f10632b != null) {
                        sxVar.f10632b.mo3861a(str, str2);
                    }
                }
            });
        }
    }

    class C32563 extends C3255a {
        final /* synthetic */ sw f10620a;

        C32563(sw swVar) {
            this.f10620a = swVar;
        }

        public void mo4018a(final vf vfVar) {
            this.f10620a.f10629a.add(new C3245a(this) {
                public void mo4017a(sx sxVar) {
                    if (sxVar.f10633c != null) {
                        sxVar.f10633c.mo4018a(vfVar);
                    }
                }
            });
        }
    }

    class C32584 extends C3176a {
        final /* synthetic */ sw f10622a;

        C32584(sw swVar) {
            this.f10622a = swVar;
        }

        public void mo3918a(final qm qmVar) {
            this.f10622a.f10629a.add(new C3245a(this) {
                public void mo4017a(sx sxVar) {
                    if (sxVar.f10634d != null) {
                        sxVar.f10634d.mo3918a(qmVar);
                    }
                }
            });
        }
    }

    class C32605 extends C3110a {
        final /* synthetic */ sw f10623a;

        class C32591 implements C3245a {
            C32591(C32605 c32605) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10635e != null) {
                    sxVar.f10635e.mo3852a();
                }
            }
        }

        C32605(sw swVar) {
            this.f10623a = swVar;
        }

        public void mo3852a() {
            this.f10623a.f10629a.add(new C32591(this));
        }
    }

    class C32696 extends C3268a {
        final /* synthetic */ sw f10626a;

        class C32611 implements C3245a {
            C32611(C32696 c32696) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10636f != null) {
                    sxVar.f10636f.mo4019a();
                }
            }
        }

        class C32622 implements C3245a {
            C32622(C32696 c32696) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10636f != null) {
                    sxVar.f10636f.mo4022b();
                }
            }
        }

        class C32633 implements C3245a {
            C32633(C32696 c32696) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10636f != null) {
                    sxVar.f10636f.mo4023c();
                }
            }
        }

        class C32644 implements C3245a {
            C32644(C32696 c32696) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10636f != null) {
                    sxVar.f10636f.mo4024d();
                }
            }
        }

        class C32666 implements C3245a {
            C32666(C32696 c32696) {
            }

            public void mo4017a(sx sxVar) {
                if (sxVar.f10636f != null) {
                    sxVar.f10636f.mo4025e();
                }
            }
        }

        C32696(sw swVar) {
            this.f10626a = swVar;
        }

        public void mo4019a() {
            this.f10626a.f10629a.add(new C32611(this));
        }

        public void mo4020a(final int i) {
            this.f10626a.f10629a.add(new C3245a(this) {
                public void mo4017a(sx sxVar) {
                    if (sxVar.f10636f != null) {
                        sxVar.f10636f.mo4020a(i);
                    }
                }
            });
        }

        public void mo4021a(final xr xrVar) {
            this.f10626a.f10629a.add(new C3245a(this) {
                public void mo4017a(sx sxVar) {
                    if (sxVar.f10636f != null) {
                        sxVar.f10636f.mo4021a(xrVar);
                    }
                }
            });
        }

        public void mo4022b() {
            this.f10626a.f10629a.add(new C32622(this));
        }

        public void mo4023c() {
            this.f10626a.f10629a.add(new C32633(this));
        }

        public void mo4024d() {
            this.f10626a.f10629a.add(new C32644(this));
        }

        public void mo4025e() {
            this.f10626a.f10629a.add(new C32666(this));
        }
    }

    sw() {
    }

    void m13812a(zzm com_google_android_gms_ads_internal_zzm) {
        com_google_android_gms_ads_internal_zzm.zza(new C32511(this));
        com_google_android_gms_ads_internal_zzm.zza(new C32532(this));
        com_google_android_gms_ads_internal_zzm.zza(new C32563(this));
        com_google_android_gms_ads_internal_zzm.zza(new C32584(this));
        com_google_android_gms_ads_internal_zzm.zza(new C32605(this));
        com_google_android_gms_ads_internal_zzm.zza(new C32696(this));
    }

    void m13813a(final sx sxVar) {
        Handler handler = zl.f11678a;
        for (final C3245a c3245a : this.f10629a) {
            handler.post(new Runnable(this) {
                public void run() {
                    try {
                        c3245a.mo4017a(sxVar);
                    } catch (Throwable e) {
                        aad.m8424c("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
        this.f10629a.clear();
    }
}
