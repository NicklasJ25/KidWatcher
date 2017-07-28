package com.domobile.applock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout.LayoutParams;
import com.domobile.frame.C0399d;
import com.domobile.frame.C0415f;

public abstract class C0741f extends C0399d implements Runnable {
    public final int f950a = PointerIconCompat.TYPE_CONTEXT_MENU;
    private View f951b;
    private ViewGroup f952c;
    private boolean f953d;

    class C09021 extends C0415f {
        final /* synthetic */ C0741f f1359a;

        C09021(C0741f c0741f) {
            this.f1359a = c0741f;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1359a.f953d = false;
            this.f1359a.mo2412d();
        }

        public void onAnimationStart(Animation animation) {
            this.f1359a.f953d = true;
        }
    }

    private void mo2410b() {
        this.f951b = this.mActivity.getLayoutInflater().inflate((this.mActivity.getResources().getConfiguration().orientation == 2 ? 1 : null) != null ? R.layout.number_lock_top_menus_land : R.layout.number_lock_top_menus, null);
        this.f951b.findViewById(R.id.number_lock_menus_forget_passwd).setOnClickListener(this);
        this.f951b.findViewById(R.id.number_lock_menus_layout).setOnClickListener(this);
        this.f952c.addView(this.f951b, new LayoutParams(-1, -1));
        this.f951b.findViewById(R.id.number_lock_menus_cardview).startAnimation(AnimationUtils.loadAnimation(this.mActivity, R.anim.custom_dialog_appear));
    }

    private void mo2411c() {
        if (!this.f953d) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, R.anim.custom_dialog_disappear);
            loadAnimation.setAnimationListener(new C09021(this));
            this.f951b.findViewById(R.id.number_lock_menus_cardview).startAnimation(loadAnimation);
        }
    }

    private void mo2412d() {
        this.f951b.post(this);
    }

    public void m1040a() {
        View findViewById = findViewById(R.id.locker_board_more);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == PointerIconCompat.TYPE_CONTEXT_MENU && i2 == -1) {
            this.mActivity.finish();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.number_lock_menus_layout) {
            mo2411c();
        } else if (view.getId() == R.id.locker_board_more) {
            mo2410b();
        } else if (view.getId() == R.id.number_lock_menus_forget_passwd) {
            startActivityForResult(new Intent(this.mActivity, RetrievePasswordActivity.class), PointerIconCompat.TYPE_CONTEXT_MENU);
        } else {
            super.onClick(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f952c = (ViewGroup) this.mActivity.findViewById(R.id.activity_verify_cotent);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f951b = null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || this.f951b == null || this.f951b.getParent() == null) {
            return false;
        }
        mo2411c();
        return true;
    }

    public void onPause() {
        super.onPause();
        if (this.f951b != null) {
            this.f952c.postDelayed(this, 200);
        }
    }

    public void run() {
        if (this.f952c != null && this.f951b != null) {
            this.f952c.removeView(this.f951b);
        }
    }
}
