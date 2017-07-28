package com.domobile.applock;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.lockbean.C1372k;
import com.domobile.widget.NumBoardButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class C1155z extends C0400d implements OnCheckedChangeListener {
    private SwitchCompat f2248a;
    private C1372k f2249e;
    private ArrayList<String> f2250f = new ArrayList();
    private ArrayList<BitmapDrawable> f2251g = new ArrayList();
    private Runnable f2252h = new C11544(this);

    class C11511 implements Runnable {
        final /* synthetic */ C1155z f2242a;

        C11511(C1155z c1155z) {
            this.f2242a = c1155z;
        }

        public void run() {
            new Thread(this.f2242a.f2252h).start();
        }
    }

    class C11533 implements OnDismissListener {
        final /* synthetic */ C1155z f2246a;

        C11533(C1155z c1155z) {
            this.f2246a = c1155z;
        }

        public void onDismiss() {
            this.f2246a.f2248a.setChecked(false);
        }
    }

    class C11544 implements Runnable {
        final /* synthetic */ C1155z f2247a;

        C11544(C1155z c1155z) {
            this.f2247a = c1155z;
        }

        public void run() {
            int i = 0;
            while (i < 40) {
                Object arrayList = new ArrayList(this.f2247a.f2250f);
                Collections.shuffle(arrayList);
                int i2 = i + 1;
                this.f2247a.m2669a(arrayList, i);
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                }
                i = i2;
            }
        }
    }

    private void m2669a(final ArrayList<String> arrayList, final int i) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ C1155z f2245c;

            public void run() {
                if (i == 0) {
                    this.f2245c.f2249e.m3464c();
                }
                this.f2245c.f2249e.m3459a(arrayList, this.f2245c.f2251g);
            }
        });
    }

    private void m2671b() {
        String charSequence = this.b.h.getTitle().toString();
        charSequence = this.mActivity.getString(R.string.startup, new Object[]{charSequence});
        C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.be_success, new Object[]{charSequence}));
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.random_numboard_layout, null);
        View inflate = layoutInflater.inflate(R.layout.random_numboard_pref_layout, null);
        View findViewById = inflate.findViewById(16908288);
        findViewById.setBackgroundColor(0);
        findViewById.setOnClickListener(this);
        View inflate2 = layoutInflater.inflate(R.layout.best_numboard, null);
        ((ViewGroup) findViewById(R.id.numboard_parent)).addView(inflate2);
        this.f2249e = new C1372k(this.mActivity, inflate2, 2);
        findViewById = this.f2249e.m3472m();
        findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        this.f2249e.m3472m().removeAllViews();
        this.f2249e.m3472m().addView(inflate);
        ((LayoutParams) inflate.getLayoutParams()).weight = 1.0f;
        this.f2249e.m3472m().setMinimumHeight(this.mActivity.getResources().getDimensionPixelSize(R.dimen.pick_lockbg_numboard_minHeight));
        ((LinearLayout) this.f2249e.m3472m()).setGravity(48);
        this.f2249e.m1735h().findViewById(R.id.locker_board_more).setVisibility(8);
        this.f2249e.m3470k().setVisibility(8);
        inflate.findViewById(16908294).setVisibility(8);
        ((TextView) inflate.findViewById(16908310)).setText(R.string.setting_random_numboard);
        ((TextView) inflate.findViewById(16908304)).setText(R.string.setting_random_numboard_summary);
        this.f2248a = new SwitchCompat(this.mActivity);
        C1148d.m2514a(this.f2248a, null);
        this.f2248a.setLayoutParams(new LayoutParams(-2, -2));
        this.f2248a.setChecked(C1150y.m2614c(this.mActivity, "key_random_numboard"));
        this.f2248a.setOnCheckedChangeListener(this);
        ((ViewGroup) inflate.findViewById(16908312)).addView(this.f2248a);
        this.rootView.postDelayed(new C11511(this), 1000);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            C1288c a_ = a_(0);
            if (a_ != null) {
                a_.m3107a(new C11533(this));
                return;
            }
        }
        C1148d.m2520b(this.mActivity, "key_random_numboard", (Object) Boolean.valueOf(z));
        if (z) {
            m2671b();
        }
    }

    public void onClick(View view) {
        if (view.getId() == 16908288) {
            this.f2248a.performClick();
        } else {
            super.onClick(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity.setRequestedOrientation(1);
        this.b.m56b(R.string.setting_random_numboard);
        this.b.h.setBackgroundColor(Color.parseColor("#44232323"));
        for (int i = 0; i < 10; i++) {
            this.f2250f.add(String.valueOf(i));
            this.f2251g.add(NumBoardButton.m3535a(this.mActivity, (String) this.f2250f.get(i)));
        }
        C1150y.m2605b(this.mActivity, (int) R.string.event_random_numboard_setting);
    }

    public void onDestroy() {
        super.onDestroy();
        Iterator it = this.f2251g.iterator();
        while (it.hasNext()) {
            try {
                ((BitmapDrawable) it.next()).getBitmap().recycle();
            } catch (Exception e) {
            }
        }
        this.f2251g.clear();
    }

    public void ui(int i, Message message) {
    }
}
