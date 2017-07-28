package com.domobile.applock.fake;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.service.LockService;
import com.domobile.frame.C0415f;

public class C0933d {

    public static class C0926b implements Runnable {
        public Context f1410b;
        public C0936e f1411c;
        public long f1412d;

        public C0926b(Context context) {
            this.f1410b = context;
        }

        public C0926b(Context context, C0936e c0936e) {
            this.f1410b = context;
            this.f1411c = c0936e;
        }

        private void m1637a() {
            ((Vibrator) this.f1410b.getSystemService("vibrator")).vibrate(50);
        }

        public void m1638a(long j) {
            this.f1412d = j;
        }

        public void run() {
            if (this.f1411c != null) {
                this.f1411c.m1668c();
            }
            if (LockService.f1934k != null) {
                if (System.currentTimeMillis() - this.f1412d >= 800 || this.f1411c == null) {
                    LockService.f1934k.mo2466b();
                    m1637a();
                } else {
                    C1150y.m2613c(this.f1410b);
                }
                this.f1411c = null;
            }
        }
    }

    public static class C0932a implements OnTouchListener {
        private C0926b f1433a;
        private int f1434b = 0;
        private long f1435c = 0;

        public C0932a(C0926b c0926b) {
            this.f1433a = c0926b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1433a == null) {
                this.f1433a = new C0926b(view.getContext());
            }
            boolean z = view.getId() == R.id.verify_foreground1 || view.getId() == R.id.verify_foreground2 || view.getId() == R.id.fake_view_toplayout;
            if (motionEvent.getAction() == 0) {
                view.setPressed(true);
                if (view.getId() == R.id.custom_dialog_ok && VERSION.SDK_INT < 21) {
                    view.setBackgroundResource(R.drawable.dialog_btn_single_pressed_holo_light);
                }
                if (System.currentTimeMillis() - this.f1435c > 800) {
                    this.f1434b = 0;
                }
                this.f1435c = (((long) (z ? 4000 : 800)) - 800) + System.currentTimeMillis();
                this.f1434b++;
                view.removeCallbacks(this.f1433a);
                if (this.f1434b >= 2 && !z) {
                    view.postDelayed(this.f1433a, 800);
                }
                this.f1433a.m1638a(this.f1435c);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                view.setPressed(false);
                view.removeCallbacks(this.f1433a);
                if (view.getId() == R.id.custom_dialog_ok && VERSION.SDK_INT < 21) {
                    view.setBackgroundResource(R.drawable.transparent);
                }
                if (!(this.f1433a.f1411c == null || z)) {
                    this.f1433a.m1638a(System.currentTimeMillis() + 800);
                    view.postDelayed(this.f1433a, 800);
                }
            }
            return true;
        }
    }

    public static void m1650a(Context context, View view) {
        view.setVisibility(8);
    }

    public static void m1651a(Context context, final View view, boolean z) {
        View findViewById = view.findViewById(R.id.fake_view_forground);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        findViewById = view.findViewById(R.id.verify_foreground1);
        final View findViewById2 = view.findViewById(R.id.verify_foreground2);
        final Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.lock_pull_up);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.lock_pull_down);
        if (z || C1150y.m2634i(context)) {
            loadAnimation2.setStartOffset(0);
            loadAnimation.setStartOffset(0);
        }
        loadAnimation.setAnimationListener(new C0415f() {
            public void onAnimationEnd(Animation animation) {
                view.findViewById(R.id.verify_fakeview).setVisibility(8);
            }

            public void onAnimationStart(Animation animation) {
                C0933d.m1652a(view.findViewById(R.id.verify_fake_logo));
            }
        });
        loadAnimation2.setAnimationListener(new C0415f() {
            public void onAnimationEnd(Animation animation) {
                view.findViewById(R.id.verify_fakeview).setVisibility(8);
            }
        });
        view.postDelayed(new Runnable() {
            public void run() {
                findViewById.startAnimation(loadAnimation);
                findViewById2.startAnimation(loadAnimation2);
            }
        }, 20);
    }

    public static void m1652a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
