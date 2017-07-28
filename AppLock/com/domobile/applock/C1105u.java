package com.domobile.applock;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.domobile.eframe.ui.C1242a;
import com.domobile.eframe.ui.C1242a.C1104a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.C1372k;

public class C1105u extends C0400d implements C1104a {
    private int f2114a = 0;
    private C1372k f2115e;
    private AppLockApplication f2116f;
    private View f2117g = null;

    class C11031 implements Runnable {
        final /* synthetic */ C1105u f2113a;

        C11031(C1105u c1105u) {
            this.f2113a = c1105u;
        }

        public void run() {
            this.f2113a.a_(0);
        }
    }

    private void m2412a(ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount > -1; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m2412a((ViewGroup) childAt);
            } else {
                childAt.invalidate();
            }
        }
    }

    public void mo2493b(int i) {
        try {
            this.f2116f.f439n = this.mActivity.getResources().getColor(C1372k.f2964g[i]);
            m2412a(this.f2115e.m3473n());
            this.f2115e.m3460a(false);
            if (C1150y.m2539D(this.mActivity)) {
                C1148d.m2520b(this.mActivity, "lock_numboard_color", (Object) Integer.valueOf(i));
            }
        } catch (Exception e) {
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.verify, null);
        View inflate = layoutInflater.inflate(R.layout.numboard, null);
        ((ViewGroup) findViewById(R.id.numboard_parent)).addView(inflate);
        Resources resources = this.mActivity.getResources();
        int[] iArr = new int[C1372k.f2964g.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = ResourcesCompat.getColor(resources, C1372k.f2964g[i], null);
        }
        this.f2114a = C1148d.m2499a(this.mActivity, "lock_numboard_color", 0);
        View c1242a = new C1242a(this.mActivity);
        c1242a.setLayoutParams(new LayoutParams(-1, this.mActivity.getResources().getDimensionPixelSize(R.dimen.pick_lockbg_color_picker_height)));
        c1242a.setInitialColor(this.f2114a);
        c1242a.setColorListener(this);
        c1242a.setIgnoreAlpha(true);
        c1242a.setColors(iArr);
        this.f2115e = new C1372k(this.mActivity, inflate, 1, false);
        inflate = this.f2115e.m3472m();
        inflate.setPadding(inflate.getPaddingLeft(), 0, inflate.getPaddingRight(), inflate.getPaddingBottom());
        this.f2115e.m3472m().removeAllViews();
        this.f2115e.m3472m().addView(c1242a);
        this.f2115e.m3472m().setMinimumHeight(this.mActivity.getResources().getDimensionPixelSize(R.dimen.pick_lockbg_numboard_minHeight));
        ((LinearLayout) this.f2115e.m3472m()).setGravity(48);
        findViewById(R.id.locker_board_more).setVisibility(8);
        this.mActionBar.m3000a(new C11031(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.numboard_color);
        this.f2116f = C1150y.m2566a(this.mActivity);
        C1150y.m2605b(this.mActivity, (int) R.string.event_pick_numboard_color);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f2116f.f439n = C1372k.m3456a(this.mActivity);
    }

    public void ui(int i, Message message) {
    }
}
