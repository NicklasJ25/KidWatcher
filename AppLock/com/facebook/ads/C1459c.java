package com.facebook.ads;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.C1903l.C1898a;
import com.facebook.ads.internal.p018m.C1729s;

public class C1459c extends RelativeLayout {
    private final Context f3357a;
    private final C1903l f3358b;
    private final DisplayMetrics f3359c;
    private boolean f3360d = false;
    private TextView f3361e;
    private String f3362f;

    public C1459c(Context context, final C1903l c1903l, boolean z) {
        super(context);
        this.f3357a = context;
        this.f3358b = c1903l;
        this.f3359c = this.f3357a.getResources().getDisplayMetrics();
        if (!this.f3358b.m5413d() || this.f3358b.m5403a().mo2687h()) {
            this.f3362f = this.f3358b.m5421l();
            if (TextUtils.isEmpty(this.f3362f)) {
                this.f3362f = "AdChoices";
            }
            C1898a j = this.f3358b.m5419j();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ C1459c f3348b;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    if (!this.f3348b.f3360d) {
                        this.f3348b.m3749a();
                    } else if (!TextUtils.isEmpty(this.f3348b.f3358b.m5420k())) {
                        C1729s.m4970a(this.f3348b.f3357a, Uri.parse(this.f3348b.f3358b.m5420k()), c1903l.m5427r());
                    }
                    return true;
                }
            });
            this.f3361e = new TextView(this.f3357a);
            addView(this.f3361e);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z || j == null) {
                this.f3360d = true;
            } else {
                layoutParams2.addRule(11, m3748a(j).getId());
                layoutParams2.width = 0;
                layoutParams.width = Math.round(((float) (j.m5368b() + 4)) * this.f3359c.density);
                layoutParams.height = Math.round(((float) (j.m5369c() + 2)) * this.f3359c.density);
                this.f3360d = false;
            }
            setLayoutParams(layoutParams);
            layoutParams2.addRule(15, -1);
            this.f3361e.setLayoutParams(layoutParams2);
            this.f3361e.setSingleLine();
            this.f3361e.setText(this.f3362f);
            this.f3361e.setTextSize(10.0f);
            this.f3361e.setTextColor(-4341303);
            return;
        }
        setVisibility(8);
    }

    private ImageView m3748a(C1898a c1898a) {
        ImageView imageView = new ImageView(this.f3357a);
        addView(imageView);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) c1898a.m5368b()) * this.f3359c.density), Math.round(((float) c1898a.m5369c()) * this.f3359c.density));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(4.0f * this.f3359c.density), Math.round(this.f3359c.density * 2.0f), Math.round(this.f3359c.density * 2.0f), Math.round(this.f3359c.density * 2.0f));
        imageView.setLayoutParams(layoutParams);
        C1903l.m5376a(c1898a, imageView);
        return imageView;
    }

    private void m3749a() {
        Paint paint = new Paint();
        paint.setTextSize(this.f3361e.getTextSize());
        int round = Math.round(paint.measureText(this.f3362f) + (4.0f * this.f3359c.density));
        final int width = getWidth();
        round += width;
        this.f3360d = true;
        Animation c14552 = new Animation(this) {
            final /* synthetic */ C1459c f3351c;

            protected void applyTransformation(float f, Transformation transformation) {
                int i = (int) (((float) width) + (((float) (round - width)) * f));
                this.f3351c.getLayoutParams().width = i;
                this.f3351c.requestLayout();
                this.f3351c.f3361e.getLayoutParams().width = i - width;
                this.f3351c.f3361e.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        c14552.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ C1459c f3356c;

            class C14571 implements Runnable {
                final /* synthetic */ C14583 f3353a;

                class C14561 extends Animation {
                    final /* synthetic */ C14571 f3352a;

                    C14561(C14571 c14571) {
                        this.f3352a = c14571;
                    }

                    protected void applyTransformation(float f, Transformation transformation) {
                        int i = (int) (((float) round) + (((float) (width - round)) * f));
                        this.f3352a.f3353a.f3356c.getLayoutParams().width = i;
                        this.f3352a.f3353a.f3356c.requestLayout();
                        this.f3352a.f3353a.f3356c.f3361e.getLayoutParams().width = i - width;
                        this.f3352a.f3353a.f3356c.f3361e.requestLayout();
                    }

                    public boolean willChangeBounds() {
                        return true;
                    }
                }

                C14571(C14583 c14583) {
                    this.f3353a = c14583;
                }

                public void run() {
                    if (this.f3353a.f3356c.f3360d) {
                        this.f3353a.f3356c.f3360d = false;
                        Animation c14561 = new C14561(this);
                        c14561.setDuration(300);
                        c14561.setFillAfter(true);
                        this.f3353a.f3356c.startAnimation(c14561);
                    }
                }
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new C14571(this), 3000);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        c14552.setDuration(300);
        c14552.setFillAfter(true);
        startAnimation(c14552);
    }
}
