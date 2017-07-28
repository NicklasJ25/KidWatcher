package com.facebook.ads.internal.view.p035c.p039b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import com.facebook.ads.internal.view.p035c.p036a.C1774s;

@TargetApi(12)
public class C1803d implements C1784m {
    private final Handler f4480a;
    private View f4481b;
    @Nullable
    private C1802a f4482c;
    @Nullable
    private C1864k f4483d;
    private final C1765i f4484e = new C17941(this);
    private final C1767k f4485f = new C17962(this);
    private final C1759c f4486g = new C17973(this);
    private final C1511s<C1774s> f4487h = new C18014(this);

    class C17941 extends C1765i {
        final /* synthetic */ C1803d f4468a;

        C17941(C1803d c1803d) {
            this.f4468a = c1803d;
        }

        public void m5077a(C1764h c1764h) {
            this.f4468a.f4480a.removeCallbacksAndMessages(null);
            this.f4468a.f4481b.clearAnimation();
            this.f4468a.f4481b.setAlpha(1.0f);
            this.f4468a.f4481b.setVisibility(0);
        }
    }

    class C17962 extends C1767k {
        final /* synthetic */ C1803d f4470a;

        class C17951 extends AnimatorListenerAdapter {
            final /* synthetic */ C17962 f4469a;

            C17951(C17962 c17962) {
                this.f4469a = c17962;
            }

            public void onAnimationEnd(Animator animator) {
                this.f4469a.f4470a.f4481b.setVisibility(8);
            }
        }

        C17962(C1803d c1803d) {
            this.f4470a = c1803d;
        }

        public void m5079a(C1766j c1766j) {
            if (this.f4470a.f4482c == C1802a.FADE_OUT_ON_PLAY) {
                this.f4470a.f4482c = null;
                this.f4470a.f4481b.animate().alpha(0.0f).setDuration(2000).setListener(new C17951(this));
                return;
            }
            this.f4470a.f4480a.removeCallbacksAndMessages(null);
            this.f4470a.f4481b.clearAnimation();
            this.f4470a.f4481b.setAlpha(0.0f);
            this.f4470a.f4481b.setVisibility(8);
        }
    }

    class C17973 extends C1759c {
        final /* synthetic */ C1803d f4471a;

        C17973(C1803d c1803d) {
            this.f4471a = c1803d;
        }

        public void m5081a(C1758b c1758b) {
            if (this.f4471a.f4482c != C1802a.INVSIBLE) {
                this.f4471a.f4481b.setAlpha(1.0f);
                this.f4471a.f4481b.setVisibility(0);
            }
        }
    }

    class C18014 extends C1511s<C1774s> {
        final /* synthetic */ C1803d f4475a;

        class C18001 extends AnimatorListenerAdapter {
            final /* synthetic */ C18014 f4474a;

            class C17991 implements Runnable {
                final /* synthetic */ C18001 f4473a;

                class C17981 extends AnimatorListenerAdapter {
                    final /* synthetic */ C17991 f4472a;

                    C17981(C17991 c17991) {
                        this.f4472a = c17991;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f4472a.f4473a.f4474a.f4475a.f4481b.setVisibility(8);
                    }
                }

                C17991(C18001 c18001) {
                    this.f4473a = c18001;
                }

                public void run() {
                    this.f4473a.f4474a.f4475a.f4481b.animate().alpha(0.0f).setDuration(500).setListener(new C17981(this));
                }
            }

            C18001(C18014 c18014) {
                this.f4474a = c18014;
            }

            public void onAnimationEnd(Animator animator) {
                this.f4474a.f4475a.f4480a.postDelayed(new C17991(this), 2000);
            }
        }

        C18014(C1803d c1803d) {
            this.f4475a = c1803d;
        }

        public Class<C1774s> mo2709a() {
            return C1774s.class;
        }

        public void m5084a(C1774s c1774s) {
            if (this.f4475a.f4483d != null && c1774s.m5049b().getAction() == 0) {
                this.f4475a.f4480a.removeCallbacksAndMessages(null);
                this.f4475a.f4481b.setVisibility(0);
                this.f4475a.f4481b.animate().alpha(1.0f).setDuration(500).setListener(new C18001(this));
            }
        }
    }

    public enum C1802a {
        VISIBLE,
        INVSIBLE,
        FADE_OUT_ON_PLAY
    }

    public C1803d(View view, C1802a c1802a) {
        this.f4481b = view;
        this.f4482c = c1802a;
        this.f4480a = new Handler();
        this.f4481b.clearAnimation();
        if (c1802a == C1802a.INVSIBLE) {
            this.f4481b.setAlpha(0.0f);
            this.f4481b.setVisibility(8);
            return;
        }
        this.f4481b.setAlpha(1.0f);
        this.f4481b.setVisibility(0);
    }

    public void m5090a(View view, C1802a c1802a) {
        this.f4481b = view;
        this.f4482c = c1802a;
        this.f4481b.clearAnimation();
        if (c1802a == C1802a.INVSIBLE) {
            this.f4481b.setAlpha(0.0f);
            this.f4481b.setVisibility(8);
            return;
        }
        this.f4481b.setAlpha(1.0f);
        this.f4481b.setVisibility(0);
    }

    public void mo2783a(C1864k c1864k) {
        c1864k.getEventBus().m4513a(this.f4484e);
        c1864k.getEventBus().m4513a(this.f4485f);
        c1864k.getEventBus().m4513a(this.f4487h);
        c1864k.getEventBus().m4513a(this.f4486g);
        this.f4483d = c1864k;
    }
}
