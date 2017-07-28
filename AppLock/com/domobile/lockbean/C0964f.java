package com.domobile.lockbean;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.FingerPrintActivity;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0906c;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.service.LockService;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1342b;
import com.domobile.libs_ads.C1350e;
import com.domobile.widget.FingerPrintStateView;
import com.domobile.widget.UnlockGiftView;

public abstract class C0964f implements OnClickListener {
    public String f1546a;
    public boolean f1547b = false;
    public boolean f1548c = false;
    public boolean f1549d = false;
    public Animation f1550e;
    public AppLockApplication f1551f = null;
    public C1150y f1552g = null;
    public Context f1553h;
    public Handler f1554i;
    public LayoutInflater f1555j;
    public WindowManager f1556k;
    public LayoutParams f1557l;
    public View f1558m;
    public View f1559n;
    public View f1560o;
    public FingerPrintStateView f1561p;
    C1350e f1562q = null;
    public boolean f1563r = false;
    public boolean f1564s = false;
    private UnlockGiftView f1565t;
    private View f1566u;
    private int f1567v = 0;
    private boolean f1568w;

    class C13661 extends C0415f {
        final /* synthetic */ C0964f f2947a;

        C13661(C0964f c0964f) {
            this.f2947a = c0964f;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2947a.f1554i.sendEmptyMessage(102);
        }

        public void onAnimationStart(Animation animation) {
            if (this.f2947a.f1558m != null && this.f2947a.f1558m.getParent() != null) {
                this.f2947a.f1556k.removeView(this.f2947a.f1558m);
            }
        }
    }

    class C13672 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ C0964f f2948a;

        C13672(C0964f c0964f) {
            this.f2948a = c0964f;
        }

        public void onAnimationEnd(View view) {
            this.f2948a.f1554i.sendEmptyMessage(106);
        }
    }

    public class C1368a extends Handler {
        final /* synthetic */ C0964f f2949a;

        public C1368a(C0964f c0964f, Looper looper) {
            this.f2949a = c0964f;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 100:
                    C1375l.m3480b(this.f2949a.f1553h, this.f2949a.f1546a);
                    return;
                case 102:
                    this.f2949a.mo2465a(this.f2949a.f1563r);
                    return;
                case 103:
                    if (message.obj != null && (message.obj instanceof C0906c)) {
                        ((C0906c) message.obj).mo2439a(this.f2949a.f1553h, this.f2949a.f1559n, this.f2949a.f1546a, this.f2949a);
                        return;
                    }
                    return;
                case 104:
                    this.f2949a.mo2468c();
                    this.f2949a.m1770g();
                    return;
                case 105:
                    boolean z2 = this.f2949a.f1566u.getVisibility() == 0;
                    if (this.f2949a.f1562q == null) {
                        ViewGroup viewGroup = (ViewGroup) this.f2949a.f1559n.findViewById(R.id.adview_layout);
                        viewGroup.setVisibility(0);
                        C0964f c0964f = this.f2949a;
                        Context context = this.f2949a.f1553h;
                        if (z2) {
                            z = false;
                        }
                        c0964f.f1562q = new C1350e(context, z);
                        viewGroup.addView(this.f2949a.f1562q, new ViewGroup.LayoutParams(-1, -1));
                        if (z2) {
                            sendEmptyMessageDelayed(message.what, 500);
                            return;
                        }
                        return;
                    } else if (z2) {
                        sendEmptyMessageDelayed(message.what, 500);
                        return;
                    } else if (this.f2949a.f1562q != null) {
                        this.f2949a.f1562q.m3356a();
                        return;
                    } else {
                        return;
                    }
                case 106:
                    if (this.f2949a.f1558m != null && this.f2949a.f1558m.getParent() != null) {
                        this.f2949a.f1556k.removeView(this.f2949a.f1558m);
                        return;
                    }
                    return;
                case 108:
                    C1148d.m2489A(this.f2949a.f1553h, "com.domobile.applock.ACTION_CALL_STATE_IDLE");
                    return;
                default:
                    return;
            }
        }
    }

    public C0964f(Context context, String str, boolean z) {
        this.f1553h = context;
        this.f1547b = z;
        this.f1546a = str;
        this.f1555j = LayoutInflater.from(this.f1553h);
        this.f1554i = new C1368a(this, context.getMainLooper());
        mo2459a();
    }

    public static String m1755a(Context context, String str) {
        try {
            if ("com.domobile.elock.appdetail".equals(str)) {
                return context.getString(R.string.app_details);
            }
            if ("com.domobile.elock.device_admin".equals(str)) {
                return context.getString(R.string.device_admin);
            }
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return context.getString(R.string.app_name);
        }
    }

    private void mo2413e() {
        Throwable th;
        Object obj = 1;
        Object obj2 = null;
        UnlockGiftView unlockGiftView = this.f1565t;
        boolean z = TextUtils.equals(this.f1546a, "com.android.vending") || this.f1547b;
        unlockGiftView.setNeverShow(z);
        if (LockService.f1931a) {
            int i = this.f1547b ? 2010 : 2003;
            try {
                if (!(i == this.f1557l.type || this.f1559n.getParent() == null)) {
                    try {
                        this.f1556k.removeView(this.f1559n);
                        obj2 = 1;
                    } catch (Exception e) {
                        int i2 = 1;
                        this.f1557l.type = i;
                        if (obj2 == null) {
                            m1769d(this.f1568w);
                        } else {
                            m1769d(C1150y.m2594a(this.f1556k, this.f1559n, this.f1557l));
                        }
                        if (i != 2010) {
                            this.f1554i.removeMessages(108);
                        } else {
                            this.f1554i.sendEmptyMessageDelayed(108, 90000);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        this.f1557l.type = i;
                        if (obj == null) {
                            m1769d(this.f1568w);
                        } else {
                            m1769d(C1150y.m2594a(this.f1556k, this.f1559n, this.f1557l));
                        }
                        if (i != 2010) {
                            this.f1554i.removeMessages(108);
                        } else {
                            this.f1554i.sendEmptyMessageDelayed(108, 90000);
                        }
                        throw th;
                    }
                }
                this.f1557l.type = i;
                if (obj2 != null) {
                    m1769d(C1150y.m2594a(this.f1556k, this.f1559n, this.f1557l));
                } else {
                    m1769d(this.f1568w);
                }
                if (i == 2010) {
                    this.f1554i.sendEmptyMessageDelayed(108, 90000);
                } else {
                    this.f1554i.removeMessages(108);
                }
            } catch (Exception e2) {
                this.f1557l.type = i;
                if (obj2 == null) {
                    m1769d(C1150y.m2594a(this.f1556k, this.f1559n, this.f1557l));
                } else {
                    m1769d(this.f1568w);
                }
                if (i != 2010) {
                    this.f1554i.sendEmptyMessageDelayed(108, 90000);
                } else {
                    this.f1554i.removeMessages(108);
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                obj = null;
                th = th4;
                this.f1557l.type = i;
                if (obj == null) {
                    m1769d(C1150y.m2594a(this.f1556k, this.f1559n, this.f1557l));
                } else {
                    m1769d(this.f1568w);
                }
                if (i != 2010) {
                    this.f1554i.sendEmptyMessageDelayed(108, 90000);
                } else {
                    this.f1554i.removeMessages(108);
                }
                throw th;
            }
        }
    }

    private void mo2469f() {
        m1769d(false);
        this.f1565t.setVisibility(4);
        this.f1554i.removeMessages(108);
    }

    private void m1758p() {
        try {
            ((ViewGroup) this.f1559n.findViewById(R.id.adview_layout)).removeAllViews();
        } catch (Exception e) {
        } finally {
            this.f1562q = null;
        }
    }

    public View m1759a(int i) {
        return this.f1559n.findViewById(i);
    }

    public void mo2459a() {
        this.f1552g = C1150y.m2598b(this.f1553h);
        this.f1551f = C1150y.m2566a(this.f1553h);
        this.f1567v = C1148d.ai(this.f1553h);
        this.f1556k = (WindowManager) this.f1553h.getSystemService("window");
        this.f1557l = new LayoutParams();
        this.f1557l.type = 2003;
        this.f1557l.format = 1;
        this.f1557l.flags = 67368;
        this.f1557l.gravity = 51;
        this.f1557l.x = 0;
        this.f1557l.y = 0;
        m1774k();
    }

    public void mo2460a(String str, boolean z) {
        this.f1546a = str;
        this.f1547b = z;
        mo2413e();
    }

    public abstract void mo2465a(boolean z);

    public void mo2461a(boolean z, boolean z2, boolean z3, long j) {
        mo2469f();
    }

    public abstract void mo2466b();

    public void mo2467b(boolean z) {
        this.f1565t.m3572a(z);
    }

    public abstract void mo2468c();

    public void m1767c(boolean z) {
        this.f1554i.removeMessages(104);
        this.f1554i.removeMessages(105);
        this.f1554i.removeMessages(103);
        this.f1554i.removeMessages(102);
        this.f1554i.removeMessages(106);
        this.f1554i.removeMessages(100);
        C0933d.m1652a(m1759a((int) R.id.fake_view_toplayout));
        C0933d.m1652a(m1759a((int) R.id.fake_fc_toplayout));
        m1758p();
        if (z && !"com.android.systemui".equals(this.f1546a)) {
            C1148d.m2489A(this.f1553h, "com.domobile.elock.ACTION_KILL_BACKGROUND_PROCESS");
        }
    }

    public void mo2462d() {
        mo2413e();
        C1150y.m2644n(this.f1553h, "unlock_show");
    }

    protected void m1769d(boolean z) {
        this.f1568w = z;
        View a = m1759a((int) R.id.permission_toplayer_warnig);
        if (!z || this.f1547b || "com.android.settings".equals(this.f1546a)) {
            a.setVisibility(8);
            return;
        }
        a.setOnClickListener(this);
        a.setVisibility(0);
    }

    public void m1770g() {
        if (!this.f1552g.f2233r) {
            this.f1551f.f435j = null;
        } else if (this.f1551f.f435j == null && C1365d.m3438a((PowerManager) this.f1553h.getSystemService("power"))) {
            this.f1551f.f435j = new C1360c(this.f1553h, this.f1561p, null);
            if (this.f1548c && this.f1549d) {
                m1771h();
            }
        }
    }

    public void m1771h() {
        if (this.f1551f.f435j != null) {
            this.f1549d = false;
            this.f1551f.f435j.m3426a(this);
            if (this.f1551f.f437l) {
                this.f1551f.f435j.m3425a();
            } else {
                FingerPrintActivity.m616a(this.f1551f);
            }
        } else if (this.f1561p != null) {
            this.f1561p.setVisibility(8);
        }
    }

    public void m1772i() {
        if (this.f1551f.f435j != null) {
            this.f1551f.f435j.m3431e();
        }
    }

    public void m1773j() {
        this.f1561p = (FingerPrintStateView) m1759a((int) R.id.locker_board_fingerprint);
        ((MarginLayoutParams) this.f1561p.getLayoutParams()).topMargin = this.f1567v;
        if (this.f1551f.f435j != null && this.f1551f.f435j.f2928b != null) {
            this.f1551f.f435j.f2928b.m3443a(this.f1561p);
        }
    }

    public void m1774k() {
        this.f1566u = m1759a((int) R.id.verify_fakeview);
        this.f1565t = (UnlockGiftView) m1759a((int) R.id.unlock_page_gift);
        ((MarginLayoutParams) this.f1565t.getLayoutParams()).topMargin = this.f1567v / 2;
        this.f1550e = AnimationUtils.loadAnimation(this.f1553h, R.anim.disappear);
        this.f1550e.setAnimationListener(new C13661(this));
    }

    protected void m1775l() {
        if (C1150y.m2645n(this.f1553h) && C1342b.m3341f(this.f1553h) == 1) {
            int h = C1342b.m3345h(this.f1553h) + 1;
            int g = C1342b.m3343g(this.f1553h);
            if (C1342b.m3347i(this.f1553h)) {
                this.f1565t.setNeverShow(true);
                this.f1554i.sendEmptyMessageDelayed(105, 50);
                C1342b.m3346h(this.f1553h, h);
            } else if (h >= g) {
                this.f1565t.setNeverShow(true);
                C1342b.m3346h(this.f1553h, 0);
                this.f1554i.sendEmptyMessageDelayed(105, 50);
            } else {
                C1342b.m3346h(this.f1553h, h);
            }
        }
    }

    public void m1776m() {
        if (this.f1558m != null) {
            ViewCompat.animate(this.f1558m.findViewById(R.id.number_lock_menus_cardview)).setListener(new C13672(this)).alpha(0.0f).setDuration(300).start();
        }
    }

    public void mo2463n() {
        Intent intent = new Intent("com.domobile.elock.verify_pass");
        intent.putExtra("verify_package", this.f1546a);
        C1148d.m2510a(this.f1553h, intent);
        mo2461a(true, false, true, 0);
    }

    public void mo2464o() {
    }

    public void onClick(View view) {
        if (view.getId() == R.id.number_lock_menus_layout) {
            m1776m();
        } else if (view.getId() == R.id.permission_toplayer_warnig) {
            try {
                this.f1553h.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.fromParts("package", this.f1553h.getPackageName(), null)).setFlags(268435456));
            } catch (Exception e) {
            }
        }
    }
}
