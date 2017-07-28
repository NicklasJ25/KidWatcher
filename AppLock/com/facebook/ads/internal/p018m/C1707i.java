package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.p025c.C1541a;
import com.facebook.ads.internal.p025c.C1542b;
import com.facebook.ads.internal.p025c.C1544c;
import com.facebook.ads.internal.p025c.C1544c.C1543a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1707i {
    private final String f4259a;
    private boolean f4260b;
    private final Context f4261c;
    private final C1597f f4262d;
    private final C1715a f4263e;
    private final C1541a f4264f;
    private int f4265g;
    private int f4266h;
    private final C1695c f4267i;

    public interface C1715a {
        boolean mo2822a();

        boolean mo2823b();

        boolean mo2824c();

        int getCurrentPosition();

        boolean getGlobalVisibleRect(Rect rect);

        long getInitialBufferTime();

        int getMeasuredHeight();

        int getMeasuredWidth();

        float getVolume();
    }

    protected enum C1716b {
        PLAY(0),
        SKIP(1),
        TIME(2),
        MRC(3),
        PAUSE(4),
        RESUME(5),
        MUTE(6),
        UNMUTE(7),
        VIEWABLE_IMPRESSION(10);
        
        public final int f4321j;

        private C1716b(int i) {
            this.f4321j = i;
        }
    }

    public C1707i(Context context, C1597f c1597f, C1715a c1715a, String str) {
        this(context, c1597f, c1715a, str, null);
    }

    public C1707i(Context context, C1597f c1597f, C1715a c1715a, String str, @Nullable Bundle bundle) {
        this.f4260b = true;
        this.f4265g = 0;
        this.f4266h = 0;
        this.f4261c = context;
        this.f4262d = c1597f;
        this.f4263e = c1715a;
        this.f4259a = str;
        List arrayList = new ArrayList();
        final C1597f c1597f2 = c1597f;
        final String str2 = str;
        arrayList.add(new C1542b(this, 0.5d, -1.0d, 2.0d, true) {
            final /* synthetic */ C1707i f4307g;

            protected void mo2778a(boolean z, boolean z2, C1544c c1544c) {
                c1597f2.mo2743c(str2, this.f4307g.m4888a(C1716b.MRC));
            }
        });
        c1597f2 = c1597f;
        str2 = str;
        arrayList.add(new C1542b(this, 1.0E-7d, -1.0d, 0.001d, false) {
            final /* synthetic */ C1707i f4310g;

            protected void mo2778a(boolean z, boolean z2, C1544c c1544c) {
                c1597f2.mo2743c(str2, this.f4310g.m4888a(C1716b.VIEWABLE_IMPRESSION));
            }
        });
        if (bundle != null) {
            this.f4264f = new C1541a(context, (View) c1715a, arrayList, bundle.getBundle("adQualityManager"));
            this.f4265g = bundle.getInt("lastProgressTimeMS");
            this.f4266h = bundle.getInt("lastBoundaryTimeMS");
        } else {
            this.f4264f = new C1541a(context, (View) c1715a, arrayList);
        }
        this.f4267i = new C1695c(new Handler(), this);
    }

    private Map<String, String> m4888a(C1716b c1716b) {
        return m4889a(c1716b, this.f4263e.getCurrentPosition());
    }

    private Map<String, String> m4889a(C1716b c1716b, int i) {
        Map<String, String> c = m4895c(i);
        c.put("action", String.valueOf(c1716b.f4321j));
        return c;
    }

    private void m4891a(int i, boolean z) {
        if (((double) i) > 0.0d && i >= this.f4265g) {
            if (i > this.f4265g) {
                this.f4264f.m4270a((double) (((float) (i - this.f4265g)) / 1000.0f), (double) m4902d());
                this.f4265g = i;
                if (i - this.f4266h >= 5000) {
                    this.f4262d.mo2743c(this.f4259a, m4889a(C1716b.TIME, i));
                    this.f4266h = this.f4265g;
                    this.f4264f.m4269a();
                    return;
                }
            }
            if (z) {
                this.f4262d.mo2743c(this.f4259a, m4889a(C1716b.TIME, i));
            }
        }
    }

    private void m4892a(Map<String, String> map) {
        map.put("exoplayer", String.valueOf(this.f4263e.mo2823b()));
        map.put("prep", Long.toString(this.f4263e.getInitialBufferTime()));
    }

    private void m4893a(Map<String, String> map, int i) {
        map.put("ptime", String.valueOf(((float) this.f4266h) / 1000.0f));
        map.put("time", String.valueOf(((float) i) / 1000.0f));
    }

    private void m4894b(Map<String, String> map) {
        C1544c b = this.f4264f.m4271b();
        C1543a b2 = b.m4284b();
        map.put("vwa", String.valueOf(b2.m4277c()));
        map.put("vwm", String.valueOf(b2.m4276b()));
        map.put("vwmax", String.valueOf(b2.m4278d()));
        map.put("vtime_ms", String.valueOf(b2.m4280f() * 1000.0d));
        map.put("mcvt_ms", String.valueOf(b2.m4281g() * 1000.0d));
        C1543a c = b.m4286c();
        map.put("vla", String.valueOf(c.m4277c()));
        map.put("vlm", String.valueOf(c.m4276b()));
        map.put("vlmax", String.valueOf(c.m4278d()));
        map.put("atime_ms", String.valueOf(c.m4280f() * 1000.0d));
        map.put("mcat_ms", String.valueOf(c.m4281g() * 1000.0d));
    }

    private Map<String, String> m4895c(int i) {
        Map hashMap = new HashMap();
        C1718k.m4932a(hashMap, this.f4263e.mo2822a(), !this.f4263e.mo2824c());
        m4892a(hashMap);
        m4894b(hashMap);
        m4893a(hashMap, i);
        m4896c(hashMap);
        return hashMap;
    }

    private void m4896c(Map<String, String> map) {
        Rect rect = new Rect();
        this.f4263e.getGlobalVisibleRect(rect);
        map.put("pt", String.valueOf(rect.top));
        map.put("pl", String.valueOf(rect.left));
        map.put("ph", String.valueOf(this.f4263e.getMeasuredHeight()));
        map.put("pw", String.valueOf(this.f4263e.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.f4261c.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        map.put("vph", String.valueOf(displayMetrics.heightPixels));
        map.put("vpw", String.valueOf(displayMetrics.widthPixels));
    }

    public void m4897a(int i) {
        m4891a(i, false);
    }

    public void m4898a(int i, int i2) {
        m4891a(i, true);
        this.f4266h = i2;
        this.f4265g = i2;
        this.f4264f.m4269a();
    }

    public void m4899b() {
        this.f4261c.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f4267i);
    }

    public void m4900b(int i) {
        m4891a(i, true);
        this.f4266h = 0;
        this.f4265g = 0;
        this.f4264f.m4269a();
    }

    public void m4901c() {
        this.f4261c.getContentResolver().unregisterContentObserver(this.f4267i);
    }

    protected float m4902d() {
        return C1718k.m4931a(this.f4261c) * this.f4263e.getVolume();
    }

    public void m4903e() {
        if (((double) m4902d()) < 0.05d) {
            if (this.f4260b) {
                m4904f();
                this.f4260b = false;
            }
        } else if (!this.f4260b) {
            m4905g();
            this.f4260b = true;
        }
    }

    public void m4904f() {
        this.f4262d.mo2743c(this.f4259a, m4888a(C1716b.MUTE));
    }

    public void m4905g() {
        this.f4262d.mo2743c(this.f4259a, m4888a(C1716b.UNMUTE));
    }

    public void m4906h() {
        this.f4262d.mo2743c(this.f4259a, m4888a(C1716b.SKIP));
    }

    public void m4907i() {
        this.f4262d.mo2743c(this.f4259a, m4888a(C1716b.PAUSE));
    }

    public void m4908j() {
        this.f4262d.mo2743c(this.f4259a, m4888a(C1716b.RESUME));
    }

    public Bundle m4909k() {
        m4898a(m4910l(), m4910l());
        Bundle bundle = new Bundle();
        bundle.putInt("lastProgressTimeMS", this.f4265g);
        bundle.putInt("lastBoundaryTimeMS", this.f4266h);
        bundle.putBundle("adQualityManager", this.f4264f.m4272c());
        return bundle;
    }

    public int m4910l() {
        return this.f4265g;
    }
}
