package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
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
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.ad;
import com.facebook.ads.internal.p018m.af;

public class C1786a extends C1785n {
    private final C1783a f4455b;

    public static class C1783a extends RelativeLayout {
        private final String f4446a;
        private final String f4447b;
        private final String f4448c;
        private final DisplayMetrics f4449d;
        private ImageView f4450e;
        private TextView f4451f;
        private boolean f4452g = false;

        class C17781 implements OnTouchListener {
            final /* synthetic */ C1783a f4437a;

            C17781(C1783a c1783a) {
                this.f4437a = c1783a;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!this.f4437a.f4452g) {
                    this.f4437a.m5057d();
                } else if (!TextUtils.isEmpty(this.f4437a.f4447b)) {
                    C1729s.m4970a(this.f4437a.getContext(), Uri.parse(this.f4437a.f4447b), this.f4437a.f4448c);
                }
                return true;
            }
        }

        public C1783a(Context context, String str, String str2, float[] fArr, String str3) {
            super(context);
            this.f4446a = str;
            this.f4447b = str2;
            this.f4448c = str3;
            this.f4449d = context.getResources().getDisplayMetrics();
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
            gradientDrawable.setAlpha(178);
            gradientDrawable.setCornerRadii(new float[]{fArr[0] * this.f4449d.density, fArr[0] * this.f4449d.density, fArr[1] * this.f4449d.density, fArr[1] * this.f4449d.density, fArr[2] * this.f4449d.density, fArr[2] * this.f4449d.density, fArr[3] * this.f4449d.density, fArr[3] * this.f4449d.density});
            if (VERSION.SDK_INT >= 16) {
                setBackground(gradientDrawable);
            } else {
                setBackgroundDrawable(gradientDrawable);
            }
            m5050a();
            m5054b();
            m5056c();
            setMinimumWidth(Math.round(20.0f * this.f4449d.density));
            setMinimumHeight(Math.round(18.0f * this.f4449d.density));
        }

        private void m5050a() {
            setOnTouchListener(new C17781(this));
        }

        private void m5054b() {
            Context context = getContext();
            this.f4450e = new ImageView(context);
            this.f4450e.setImageBitmap(af.m4817a(context, ad.IC_AD_CHOICES));
            addView(this.f4450e);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.f4449d.density * 16.0f), Math.round(this.f4449d.density * 16.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            layoutParams.setMargins(Math.round(4.0f * this.f4449d.density), Math.round(this.f4449d.density * 2.0f), Math.round(this.f4449d.density * 2.0f), Math.round(this.f4449d.density * 2.0f));
            this.f4450e.setLayoutParams(layoutParams);
        }

        private void m5056c() {
            this.f4451f = new TextView(getContext());
            addView(this.f4451f);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = 0;
            layoutParams.leftMargin = (int) (20.0f * this.f4449d.density);
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            this.f4451f.setLayoutParams(layoutParams);
            this.f4451f.setSingleLine();
            this.f4451f.setText(this.f4446a);
            this.f4451f.setTextSize(10.0f);
            this.f4451f.setTextColor(-4341303);
        }

        private void m5057d() {
            Paint paint = new Paint();
            paint.setTextSize(this.f4451f.getTextSize());
            int round = Math.round(paint.measureText(this.f4446a) + (4.0f * this.f4449d.density));
            final int width = getWidth();
            round += width;
            this.f4452g = true;
            Animation c17792 = new Animation(this) {
                final /* synthetic */ C1783a f4440c;

                protected void applyTransformation(float f, Transformation transformation) {
                    int i = (int) (((float) width) + (((float) (round - width)) * f));
                    this.f4440c.getLayoutParams().width = i;
                    this.f4440c.requestLayout();
                    this.f4440c.f4451f.getLayoutParams().width = i - width;
                    this.f4440c.f4451f.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            c17792.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ C1783a f4445c;

                class C17811 implements Runnable {
                    final /* synthetic */ C17823 f4442a;

                    class C17801 extends Animation {
                        final /* synthetic */ C17811 f4441a;

                        C17801(C17811 c17811) {
                            this.f4441a = c17811;
                        }

                        protected void applyTransformation(float f, Transformation transformation) {
                            int i = (int) (((float) round) + (((float) (width - round)) * f));
                            this.f4441a.f4442a.f4445c.getLayoutParams().width = i;
                            this.f4441a.f4442a.f4445c.requestLayout();
                            this.f4441a.f4442a.f4445c.f4451f.getLayoutParams().width = i - width;
                            this.f4441a.f4442a.f4445c.f4451f.requestLayout();
                        }

                        public boolean willChangeBounds() {
                            return true;
                        }
                    }

                    C17811(C17823 c17823) {
                        this.f4442a = c17823;
                    }

                    public void run() {
                        if (this.f4442a.f4445c.f4452g) {
                            this.f4442a.f4445c.f4452g = false;
                            Animation c17801 = new C17801(this);
                            c17801.setDuration(300);
                            c17801.setFillAfter(true);
                            this.f4442a.f4445c.startAnimation(c17801);
                        }
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    new Handler().postDelayed(new C17811(this), 3000);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            c17792.setDuration(300);
            c17792.setFillAfter(true);
            startAnimation(c17792);
        }
    }

    public C1786a(Context context, String str, String str2, float[] fArr) {
        super(context);
        this.f4455b = new C1783a(context, "AdChoices", str, fArr, str2);
        addView(this.f4455b);
    }
}
