package com.domobile.applock.livelock.p006a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import com.domobile.applock.R;
import com.domobile.applock.livelock.p014b.C0978c;
import com.domobile.applock.livelock.p014b.C0979d;
import com.domobile.applock.livelock.view.IconDecorView;
import com.domobile.applock.livelock.view.LiveBgView;
import com.domobile.applock.livelock.view.LivePatternView;
import com.domobile.applock.p013f.C0903a;
import com.domobile.lockbean.C0960e;

@TargetApi(14)
public class C0967c extends C0960e {
    private C0979d f1576f;
    private boolean f1577g = false;
    private LiveBgView f1578h;
    private IconDecorView f1579i;
    private LivePatternView f1580j;

    public C0967c(@NonNull Context context, @NonNull C0979d c0979d, boolean z) {
        this.a = context;
        this.f1576f = c0979d;
        this.f1577g = z;
        C0978c.m1849a().m1854a(context, c0979d.f1609a);
        m1801e();
    }

    private void m1801e() {
        this.b = View.inflate(this.a, this.f1577g ? R.layout.live_pattern_lock_land : R.layout.live_pattern_lock_port, null);
        this.f1578h = (LiveBgView) m1732b((int) R.id.liveBgView);
        this.f1579i = (IconDecorView) m1732b((int) R.id.iconDecorView);
        this.f1580j = (LivePatternView) m1732b((int) R.id.pattern_board_patternview);
        this.f1578h.setLandscape(this.f1577g);
        this.f1578h.setPortFrameList(this.f1576f.f1610b);
        this.f1578h.setLandFrameList(this.f1576f.f1611c);
        this.f1579i.setDecorParams(C0978c.m1849a().m1853a(this.f1577g));
        this.f1579i.setFrameList(this.f1576f.f1612d);
        this.f1580j.setFrameList(this.f1576f.f1617i);
        this.f1580j.setLineList(this.f1576f.f1618j);
        this.f1580j.setLineSize(this.f1576f.f1619k);
    }

    public LivePatternView m1802a() {
        return this.f1580j;
    }

    public void mo2455a(Drawable drawable) {
        this.f1579i.setAppIcon(C0903a.m1591a(drawable));
    }

    public synchronized void m1804b() {
        m1806d();
        this.f1578h.m1893a();
        this.f1579i.m1876a();
        this.f1580j.m1967a();
    }

    public synchronized void m1805c() {
        this.f1578h.m1894b();
        this.f1579i.m1877b();
        this.f1580j.m1970b();
    }

    public synchronized void m1806d() {
        m1805c();
        C0978c.m1849a().m1856b();
    }
}
