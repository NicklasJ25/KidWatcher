package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1707i.C1715a;
import com.facebook.ads.internal.p018m.C1717j;
import com.facebook.ads.internal.p018m.ai;
import com.facebook.ads.internal.p018m.ai.C1691a;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.p022h.C1609q;
import com.facebook.ads.internal.p022h.C1610r;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1760d;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import com.facebook.ads.internal.view.p035c.p036a.C1771p;
import com.facebook.ads.internal.view.p035c.p036a.C1772q;
import com.facebook.ads.internal.view.p035c.p036a.C1773r;
import com.facebook.ads.internal.view.p035c.p036a.C1774s;
import com.facebook.ads.internal.view.p035c.p036a.C1775t;
import com.facebook.ads.internal.view.p035c.p036a.C1776v;
import com.facebook.ads.internal.view.p035c.p036a.C1777w;
import com.facebook.ads.internal.view.p035c.p039b.C1784m;
import com.facebook.ads.internal.view.p035c.p039b.C1785n;
import com.facebook.ads.internal.view.p035c.p040c.C1840c;
import com.facebook.ads.internal.view.p035c.p040c.C1843a;
import com.facebook.ads.internal.view.p035c.p040c.C1846b;
import com.facebook.ads.internal.view.p035c.p040c.C1847d;
import com.facebook.ads.internal.view.p035c.p040c.C1848e;
import java.util.ArrayList;
import java.util.List;

public class C1864k extends RelativeLayout implements C1715a, C1848e {
    private static final C1768l f4672i = new C1768l();
    private static final C1760d f4673j = new C1760d();
    private static final C1758b f4674k = new C1758b();
    private static final C1769n f4675l = new C1769n();
    private static final C1772q f4676m = new C1772q();
    private static final C1764h f4677n = new C1764h();
    private static final C1773r f4678o = new C1773r();
    private static final C1766j f4679p = new C1766j();
    private static final C1775t f4680q = new C1775t();
    private static final C1777w f4681r = new C1777w();
    private static final C1776v f4682s = new C1776v();
    private final C1610r<C1511s, C1609q> f4683a;
    protected final C1840c f4684b;
    private final List<C1784m> f4685c;
    private boolean f4686d;
    @Deprecated
    private boolean f4687e;
    @Deprecated
    private boolean f4688f;
    private C1717j f4689g;
    private boolean f4690h;
    private final Handler f4691t;
    private final OnTouchListener f4692u;

    class C18791 implements Runnable {
        final /* synthetic */ C1864k f4755a;

        C18791(C1864k c1864k) {
            this.f4755a = c1864k;
        }

        public void run() {
            if (!this.f4755a.f4686d) {
                this.f4755a.f4683a.m4512a(C1864k.f4675l);
                this.f4755a.f4691t.postDelayed(this, 250);
            }
        }
    }

    class C18802 implements OnTouchListener {
        final /* synthetic */ C1864k f4756a;

        C18802(C1864k c1864k) {
            this.f4756a = c1864k;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4756a.f4683a.m4512a(new C1774s(view, motionEvent));
            return true;
        }
    }

    public C1864k(@Nullable Context context) {
        this(context, null);
    }

    public C1864k(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1864k(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4685c = new ArrayList();
        this.f4686d = false;
        this.f4687e = false;
        this.f4688f = false;
        this.f4689g = C1717j.UNKNOWN;
        this.f4690h = false;
        this.f4692u = new C18802(this);
        if (C1668j.m4718a(getContext())) {
            this.f4684b = new C1843a(getContext());
        } else {
            this.f4684b = new C1846b(getContext());
        }
        this.f4684b.setRequestedVolume(1.0f);
        this.f4684b.setVideoStateChangeListener(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView((View) this.f4684b, layoutParams);
        this.f4691t = new Handler();
        this.f4683a = new C1610r();
        setOnTouchListener(this.f4692u);
    }

    public void m5248a(int i) {
        this.f4684b.seekTo(i);
    }

    public void mo2820a(int i, int i2) {
        this.f4683a.m4512a(new C1771p(i, i2));
    }

    public void m5250a(C1784m c1784m) {
        this.f4685c.add(c1784m);
    }

    public void mo2821a(C1847d c1847d) {
        if (c1847d == C1847d.PREPARED) {
            this.f4683a.m4512a(f4672i);
            if (m5260i() && !this.f4686d) {
                mo2828d();
            }
        } else if (c1847d == C1847d.ERROR) {
            this.f4686d = true;
            this.f4683a.m4512a(f4673j);
        } else if (c1847d == C1847d.PLAYBACK_COMPLETED) {
            this.f4686d = true;
            this.f4691t.removeCallbacksAndMessages(null);
            this.f4683a.m4512a(f4674k);
        } else if (c1847d == C1847d.STARTED) {
            this.f4683a.m4512a(f4679p);
            this.f4691t.removeCallbacksAndMessages(null);
            this.f4691t.postDelayed(new C18791(this), 250);
        } else if (c1847d == C1847d.PAUSED) {
            this.f4683a.m4512a(f4677n);
            this.f4691t.removeCallbacksAndMessages(null);
        } else if (c1847d == C1847d.IDLE) {
            this.f4683a.m4512a(f4678o);
            this.f4691t.removeCallbacksAndMessages(null);
        }
    }

    public boolean mo2822a() {
        return m5260i();
    }

    public boolean mo2823b() {
        return C1668j.m4718a(getContext());
    }

    public boolean mo2824c() {
        return this.f4690h;
    }

    public void mo2828d() {
        if (this.f4686d && this.f4684b.getState() == C1847d.PLAYBACK_COMPLETED) {
            this.f4686d = false;
        }
        this.f4684b.start();
    }

    public void m5256e() {
        this.f4684b.pause();
    }

    public void m5257f() {
        getEventBus().m4512a(f4676m);
        this.f4684b.mo2793c();
    }

    public void m5258g() {
        this.f4684b.mo2794d();
    }

    public int getCurrentPosition() {
        return this.f4684b.getCurrentPosition();
    }

    public int getDuration() {
        return this.f4684b.getDuration();
    }

    @NonNull
    public C1610r<C1511s, C1609q> getEventBus() {
        return this.f4683a;
    }

    public long getInitialBufferTime() {
        return this.f4684b.getInitialBufferTime();
    }

    public C1717j getIsAutoPlayFromServer() {
        return this.f4689g;
    }

    public C1847d getState() {
        return this.f4684b.getState();
    }

    public TextureView getTextureView() {
        return (TextureView) this.f4684b;
    }

    public int getVideoHeight() {
        return this.f4684b.getVideoHeight();
    }

    public View getVideoView() {
        return this.f4684b.getView();
    }

    public int getVideoWidth() {
        return this.f4684b.getVideoWidth();
    }

    public float getVolume() {
        return this.f4684b.getVolume();
    }

    public void m5259h() {
        this.f4684b.mo2789a(true);
    }

    protected boolean m5260i() {
        boolean z = this.f4687e && (!this.f4688f || ai.m4833c(getContext()) == C1691a.MOBILE_INTERNET);
        return getIsAutoPlayFromServer() == C1717j.UNKNOWN ? z : getIsAutoPlayFromServer() == C1717j.ON;
    }

    protected void onAttachedToWindow() {
        this.f4683a.m4512a(f4682s);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        this.f4683a.m4512a(f4681r);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAutoplay(boolean z) {
        this.f4687e = z;
    }

    public void setControlsAnchorView(View view) {
        if (this.f4684b != null) {
            this.f4684b.setControlsAnchorView(view);
        }
    }

    public void setIsAutoPlayFromServer(C1717j c1717j) {
        this.f4689g = c1717j;
    }

    @Deprecated
    public void setIsAutoplayOnMobile(boolean z) {
        this.f4688f = z;
    }

    public void setIsFullScreen(boolean z) {
        this.f4690h = z;
        this.f4684b.setFullScreen(z);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(String str) {
        this.f4684b.setVideoMPD(str);
    }

    public void setVideoURI(Uri uri) {
        for (C1784m c1784m : this.f4685c) {
            if (c1784m instanceof C1785n) {
                C1785n c1785n = (C1785n) c1784m;
                if (c1785n.getParent() == null) {
                    addView(c1785n);
                    c1785n.mo2783a(this);
                }
            } else {
                c1784m.mo2783a(this);
            }
        }
        this.f4686d = false;
        this.f4684b.setup(uri);
    }

    public void setVideoURI(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVolume(float f) {
        this.f4684b.setRequestedVolume(f);
        getEventBus().m4512a(f4680q);
    }
}
