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
import com.domobile.applock.livelock.view.LiveNumberView;
import com.domobile.applock.livelock.view.LiveNumberView.C0961b;
import com.domobile.applock.livelock.view.PasswordView;
import com.domobile.applock.livelock.view.PwdBgView;
import com.domobile.applock.p013f.C0903a;
import com.domobile.lockbean.C0960e;

@TargetApi(14)
public class C0962a extends C0960e implements C0961b {
    private C0979d f1533f;
    private boolean f1534g = false;
    private boolean f1535h = false;
    private LiveBgView f1536i;
    private IconDecorView f1537j;
    private PwdBgView f1538k;
    private PasswordView f1539l;
    private LiveNumberView f1540m;
    private C0742a f1541n;

    public interface C0742a {
        void mo2409a(String str);

        void mo2413e();
    }

    public C0962a(@NonNull Context context, @NonNull C0979d c0979d, boolean z, boolean z2) {
        this.a = context;
        this.f1533f = c0979d;
        this.f1534g = z2;
        this.f1535h = z;
        C0978c.m1849a().m1854a(context, c0979d.f1609a);
        m1741j();
    }

    private void m1741j() {
        this.b = View.inflate(this.a, this.f1534g ? R.layout.live_mumber_lock_land : R.layout.live_mumber_lock_port, null);
        this.f1536i = (LiveBgView) m1732b((int) R.id.liveBgView);
        this.f1537j = (IconDecorView) m1732b((int) R.id.iconDecorView);
        this.f1538k = (PwdBgView) m1732b((int) R.id.pwdBgView);
        this.f1539l = (PasswordView) m1732b((int) R.id.passwordView);
        this.f1540m = (LiveNumberView) m1732b((int) R.id.liveNumberView);
        this.f1536i.setLandscape(this.f1534g);
        this.f1536i.setPortFrameList(this.f1533f.f1610b);
        this.f1536i.setLandFrameList(this.f1533f.f1611c);
        this.f1537j.setDecorParams(C0978c.m1849a().m1853a(this.f1534g));
        this.f1537j.setFrameList(this.f1533f.f1612d);
        this.f1538k.setFrameList(this.f1533f.f1614f);
        this.f1539l.setFrameList(this.f1533f.f1613e);
        this.f1540m.setRandomNumBoard(this.f1535h);
        this.f1540m.setNormFrameList(this.f1533f.f1615g);
        this.f1540m.setDownFrameList(this.f1533f.f1616h);
        this.f1540m.setOnNumberBoardClickListener(this);
    }

    public synchronized void m1742a() {
        m1749c();
        this.f1536i.m1893a();
        this.f1537j.m1876a();
        this.f1538k.m2001a();
        this.f1539l.m1985a();
        this.f1540m.m1919a();
    }

    public void mo2454a(int i) {
        this.f1539l.m1986a(i);
        if (this.f1541n != null) {
            this.f1541n.mo2409a(this.f1539l.getPassword());
        }
    }

    public void mo2455a(Drawable drawable) {
        this.f1537j.setAppIcon(C0903a.m1591a(drawable));
    }

    public void m1745a(C0742a c0742a) {
        this.f1541n = c0742a;
    }

    public void m1746a(boolean z) {
        this.f1540m.setTactileFeedbackEnabled(z);
    }

    public synchronized void m1747b() {
        this.f1536i.m1894b();
        this.f1537j.m1877b();
        this.f1538k.m2002b();
        this.f1539l.m1989d();
        this.f1540m.m1920b();
    }

    public void m1748b(boolean z) {
        this.f1535h = z;
        this.f1540m.setRandomNumBoard(z);
    }

    public synchronized void m1749c() {
        m1747b();
        C0978c.m1849a().m1856b();
        System.gc();
    }

    public void m1750d() {
        this.f1539l.m1988c();
    }

    public void mo2456e() {
        if (this.f1541n != null) {
            this.f1541n.mo2413e();
        }
    }

    public void mo2457f() {
        this.f1539l.m1987b();
        if (this.f1541n != null) {
            this.f1541n.mo2409a(this.f1539l.getPassword());
        }
    }

    public void mo2458g() {
        m1750d();
    }
}
