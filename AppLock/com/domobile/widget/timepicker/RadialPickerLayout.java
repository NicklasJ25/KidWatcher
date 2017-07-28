package com.domobile.widget.timepicker;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.domobile.applock.R;

public class RadialPickerLayout extends FrameLayout implements OnTouchListener {
    private AnimatorSet f3132A;
    private Handler f3133B = new Handler();
    private final int f3134a;
    private final int f3135b;
    private int f3136c;
    private C1419c f3137d;
    private C1415a f3138e;
    private boolean f3139f;
    private int f3140g;
    private int f3141h;
    private boolean f3142i;
    private boolean f3143j;
    private int f3144k;
    private C1417b f3145l;
    private C1416a f3146m;
    private C1425e f3147n;
    private C1425e f3148o;
    private C1422d f3149p;
    private C1422d f3150q;
    private View f3151r;
    private int[] f3152s;
    private boolean f3153t;
    private int f3154u = -1;
    private boolean f3155v;
    private boolean f3156w;
    private int f3157x;
    private float f3158y;
    private float f3159z;

    class C14131 implements Runnable {
        final /* synthetic */ RadialPickerLayout f3129a;

        C14131(RadialPickerLayout radialPickerLayout) {
            this.f3129a = radialPickerLayout;
        }

        public void run() {
            this.f3129a.f3146m.setAmOrPmPressed(this.f3129a.f3154u);
            this.f3129a.f3146m.invalidate();
        }
    }

    public interface C1415a {
        void mo2615a(int i, int i2, boolean z);
    }

    public RadialPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
        this.f3134a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3135b = ViewConfiguration.getTapTimeout();
        this.f3155v = false;
        this.f3145l = new C1417b(context);
        addView(this.f3145l);
        this.f3146m = new C1416a(context);
        addView(this.f3146m);
        this.f3147n = new C1425e(context);
        addView(this.f3147n);
        this.f3148o = new C1425e(context);
        addView(this.f3148o);
        this.f3149p = new C1422d(context);
        addView(this.f3149p);
        this.f3150q = new C1422d(context);
        addView(this.f3150q);
        m3590a();
        this.f3136c = -1;
        this.f3153t = true;
        this.f3151r = new View(context);
        this.f3151r.setLayoutParams(new LayoutParams(-1, -1));
        this.f3151r.setBackgroundColor(getResources().getColor(R.color.transparent_black));
        this.f3151r.setVisibility(4);
        addView(this.f3151r);
        this.f3139f = false;
    }

    private int m3585a(float f, float f2, boolean z, Boolean[] boolArr) {
        int currentItemShowing = getCurrentItemShowing();
        return currentItemShowing == 0 ? this.f3149p.m3617a(f, f2, z, boolArr) : currentItemShowing == 1 ? this.f3150q.m3617a(f, f2, z, boolArr) : -1;
    }

    private int m3586a(int i, boolean z, boolean z2, boolean z3) {
        if (i == -1) {
            return -1;
        }
        C1422d c1422d;
        int i2;
        int currentItemShowing = getCurrentItemShowing();
        int i3 = (z2 || currentItemShowing != 1) ? 0 : 1;
        int b = i3 != 0 ? m3593b(i) : m3598d(i, 0);
        if (currentItemShowing == 0) {
            c1422d = this.f3149p;
            i2 = 30;
        } else {
            c1422d = this.f3150q;
            i2 = 6;
        }
        c1422d.m3618a(b, z, z3);
        c1422d.invalidate();
        if (currentItemShowing != 0) {
            if (b == 360 && currentItemShowing == 1) {
                i3 = 0;
            }
            i3 = b;
        } else if (!this.f3142i) {
            if (b == 0) {
                i3 = 360;
            }
            i3 = b;
        } else if (b == 0 && z) {
            i3 = 360;
        } else {
            if (b == 360 && !z) {
                i3 = 0;
            }
            i3 = b;
        }
        i2 = i3 / i2;
        return (currentItemShowing != 0 || !this.f3142i || z || i3 == 0) ? i2 : i2 + 12;
    }

    private void m3590a() {
        this.f3152s = new int[361];
        int i = 0;
        int i2 = 8;
        int i3 = 1;
        for (int i4 = 0; i4 < 361; i4++) {
            this.f3152s[i4] = i;
            if (i3 == i2) {
                i3 = i + 6;
                i2 = i3 == 360 ? 7 : i3 % 30 == 0 ? 14 : 4;
                i = i3;
                i3 = 1;
            } else {
                i3++;
            }
        }
    }

    private boolean m3591a(int i) {
        return this.f3142i && i <= 12 && i != 0;
    }

    private int m3593b(int i) {
        return this.f3152s == null ? -1 : this.f3152s[i];
    }

    private void m3595b(int i, int i2) {
        if (i == 0) {
            m3597c(0, i2);
            this.f3149p.m3618a((i2 % 12) * 30, m3591a(i2), false);
            this.f3149p.invalidate();
        } else if (i == 1) {
            m3597c(1, i2);
            this.f3150q.m3618a(i2 * 6, false, false);
            this.f3150q.invalidate();
        }
    }

    private void m3597c(int i, int i2) {
        if (i == 0) {
            this.f3140g = i2;
        } else if (i == 1) {
            this.f3141h = i2;
        } else if (i != 2) {
        } else {
            if (i2 == 0) {
                this.f3140g %= 12;
            } else if (i2 == 1) {
                this.f3140g = (this.f3140g % 12) + 12;
            }
        }
    }

    private int m3598d(int i, int i2) {
        int i3 = (i / 30) * 30;
        int i4 = i3 + 30;
        return i2 == 1 ? i4 : i2 == -1 ? i == i3 ? i3 - 30 : i3 : i - i3 >= i4 - i ? i4 : i3;
    }

    private int getCurrentlyShowingValue() {
        int currentItemShowing = getCurrentItemShowing();
        return currentItemShowing == 0 ? this.f3140g : currentItemShowing == 1 ? this.f3141h : -1;
    }

    public void m3600a(int i, int i2) {
        m3595b(0, i);
        m3595b(1, i2);
    }

    public void m3601a(int i, boolean z) {
        int i2 = 1;
        if (i == 0 || i == 1) {
            int currentItemShowing = getCurrentItemShowing();
            this.f3144k = i;
            if (!z || i == currentItemShowing) {
                currentItemShowing = i == 0 ? 1 : 0;
                if (i != 1) {
                    i2 = 0;
                }
                ViewCompat.setAlpha(this.f3147n, (float) currentItemShowing);
                ViewCompat.setAlpha(this.f3149p, (float) currentItemShowing);
                ViewCompat.setAlpha(this.f3148o, (float) i2);
                ViewCompat.setAlpha(this.f3150q, (float) i2);
                return;
            }
            Animator[] animatorArr = new ObjectAnimator[4];
            if (i == 1) {
                animatorArr[0] = this.f3147n.getDisappearAnimator();
                animatorArr[1] = this.f3149p.getDisappearAnimator();
                animatorArr[2] = this.f3148o.getReappearAnimator();
                animatorArr[3] = this.f3150q.getReappearAnimator();
            } else if (i == 0) {
                animatorArr[0] = this.f3147n.getReappearAnimator();
                animatorArr[1] = this.f3149p.getReappearAnimator();
                animatorArr[2] = this.f3148o.getDisappearAnimator();
                animatorArr[3] = this.f3150q.getDisappearAnimator();
            }
            if (this.f3132A != null && this.f3132A.isRunning()) {
                this.f3132A.end();
            }
            this.f3132A = new AnimatorSet();
            this.f3132A.playTogether(animatorArr);
            this.f3132A.start();
            return;
        }
        Log.e("RadialPickerLayout", "TimePicker does not support view at index " + i);
    }

    public void m3602a(Context context, C1419c c1419c, int i, int i2, boolean z) {
        if (this.f3139f) {
            Log.e("RadialPickerLayout", "Time has already been initialized.");
            return;
        }
        this.f3137d = c1419c;
        this.f3142i = z;
        this.f3143j = this.f3142i;
        this.f3145l.m3608a(context, this.f3143j);
        this.f3145l.invalidate();
        if (!this.f3143j) {
            this.f3146m.m3606a(context, i < 12 ? 0 : 1);
            this.f3146m.invalidate();
        }
        Resources resources = context.getResources();
        int[] iArr = new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] iArr2 = new int[]{0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] iArr3 = new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        String[] strArr = new String[12];
        String[] strArr2 = new String[12];
        String[] strArr3 = new String[12];
        for (int i3 = 0; i3 < 12; i3++) {
            strArr[i3] = z ? String.format("%02d", new Object[]{Integer.valueOf(iArr2[i3])}) : String.format("%d", new Object[]{Integer.valueOf(iArr[i3])});
            strArr2[i3] = String.format("%d", new Object[]{Integer.valueOf(iArr[i3])});
            strArr3[i3] = String.format("%02d", new Object[]{Integer.valueOf(iArr3[i3])});
        }
        C1425e c1425e = this.f3147n;
        if (!z) {
            strArr2 = null;
        }
        c1425e.m3625a(resources, strArr, strArr2, this.f3143j, true);
        this.f3147n.invalidate();
        this.f3148o.m3625a(resources, strArr3, null, this.f3143j, false);
        this.f3148o.invalidate();
        m3597c(0, i);
        m3597c(1, i2);
        this.f3149p.m3620a(context, this.f3143j, z, true, (i % 12) * 30, m3591a(i));
        this.f3150q.m3620a(context, this.f3143j, false, false, i2 * 6, false);
        this.f3139f = true;
    }

    void m3603a(Context context, boolean z) {
        this.f3145l.m3609b(context, z);
        this.f3146m.m3607a(context, z);
        this.f3147n.m3624a(context, z);
        this.f3148o.m3624a(context, z);
        this.f3149p.m3619a(context, z);
        this.f3150q.m3619a(context, z);
    }

    public boolean m3604a(boolean z) {
        int i = 0;
        if (this.f3156w && !z) {
            return false;
        }
        this.f3153t = z;
        View view = this.f3151r;
        if (z) {
            i = 4;
        }
        view.setVisibility(i);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        accessibilityEvent.getText().clear();
        Time time = new Time();
        time.hour = getHours();
        time.minute = getMinutes();
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), time.normalize(true), this.f3142i ? 129 : 1));
        return true;
    }

    public int getCurrentItemShowing() {
        if (this.f3144k == 0 || this.f3144k == 1) {
            return this.f3144k;
        }
        Log.e("RadialPickerLayout", "Current item showing was unfortunately set to " + this.f3144k);
        return -1;
    }

    public int getHours() {
        return this.f3140g;
    }

    public int getIsCurrentlyAmOrPm() {
        return this.f3140g < 12 ? 0 : this.f3140g < 24 ? 1 : -1;
    }

    public int getMinutes() {
        return this.f3141h;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(8192);
    }

    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        size = Math.min(size, size2);
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, mode), MeasureSpec.makeMeasureSpec(size, mode2));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        final Boolean[] boolArr = new Boolean[]{Boolean.valueOf(false)};
        SystemClock.uptimeMillis();
        int a;
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.f3153t) {
                    return true;
                }
                this.f3158y = x;
                this.f3159z = y;
                this.f3136c = -1;
                this.f3155v = false;
                this.f3156w = true;
                if (this.f3143j) {
                    this.f3154u = -1;
                } else {
                    this.f3154u = this.f3146m.m3605a(x, y);
                }
                if (this.f3154u == 0 || this.f3154u == 1) {
                    this.f3137d.m3616c();
                    this.f3157x = -1;
                    this.f3133B.postDelayed(new C14131(this), (long) this.f3135b);
                    return true;
                }
                this.f3157x = m3585a(x, y, false, boolArr);
                if (this.f3157x == -1) {
                    return true;
                }
                this.f3137d.m3616c();
                this.f3133B.postDelayed(new Runnable(this) {
                    final /* synthetic */ RadialPickerLayout f3131b;

                    public void run() {
                        this.f3131b.f3155v = true;
                        int a = this.f3131b.m3586a(this.f3131b.f3157x, boolArr[0].booleanValue(), false, true);
                        this.f3131b.f3136c = a;
                        this.f3131b.f3138e.mo2615a(this.f3131b.getCurrentItemShowing(), a, false);
                    }
                }, (long) this.f3135b);
                return true;
            case 1:
                if (this.f3153t) {
                    this.f3133B.removeCallbacksAndMessages(null);
                    this.f3156w = false;
                    if (this.f3154u == 0 || this.f3154u == 1) {
                        a = this.f3146m.m3605a(x, y);
                        this.f3146m.setAmOrPmPressed(-1);
                        this.f3146m.invalidate();
                        if (a == this.f3154u) {
                            this.f3146m.setAmOrPm(a);
                            if (getIsCurrentlyAmOrPm() != a) {
                                this.f3138e.mo2615a(2, this.f3154u, false);
                                m3597c(2, a);
                            }
                        }
                        this.f3154u = -1;
                        break;
                    }
                    if (this.f3157x != -1) {
                        int a2 = m3585a(x, y, this.f3155v, boolArr);
                        if (a2 != -1) {
                            a = m3586a(a2, boolArr[0].booleanValue(), !this.f3155v, false);
                            if (getCurrentItemShowing() == 0 && !this.f3142i) {
                                a2 = getIsCurrentlyAmOrPm();
                                if (a2 == 0 && a == 12) {
                                    a = 0;
                                } else if (a2 == 1 && a != 12) {
                                    a += 12;
                                }
                            }
                            m3597c(getCurrentItemShowing(), a);
                            this.f3138e.mo2615a(getCurrentItemShowing(), a, true);
                        }
                    }
                    this.f3155v = false;
                    return true;
                }
                Log.d("RadialPickerLayout", "Input was disabled, but received ACTION_UP.");
                this.f3138e.mo2615a(3, 1, false);
                return true;
            case 2:
                if (this.f3153t) {
                    float abs = Math.abs(y - this.f3159z);
                    float abs2 = Math.abs(x - this.f3158y);
                    if (this.f3155v || abs2 > ((float) this.f3134a) || abs > ((float) this.f3134a)) {
                        if (this.f3154u == 0 || this.f3154u == 1) {
                            this.f3133B.removeCallbacksAndMessages(null);
                            if (this.f3146m.m3605a(x, y) != this.f3154u) {
                                this.f3146m.setAmOrPmPressed(-1);
                                this.f3146m.invalidate();
                                this.f3154u = -1;
                                break;
                            }
                        } else if (this.f3157x != -1) {
                            this.f3155v = true;
                            this.f3133B.removeCallbacksAndMessages(null);
                            a = m3585a(x, y, true, boolArr);
                            if (a == -1) {
                                return true;
                            }
                            a = m3586a(a, boolArr[0].booleanValue(), false, true);
                            if (a == this.f3136c) {
                                return true;
                            }
                            this.f3137d.m3616c();
                            this.f3136c = a;
                            this.f3138e.mo2615a(getCurrentItemShowing(), a, false);
                            return true;
                        }
                    }
                }
                Log.e("RadialPickerLayout", "Input was disabled, but received ACTION_MOVE.");
                return true;
                break;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        int i2 = i == 4096 ? 1 : i == 8192 ? -1 : 0;
        if (i2 == 0) {
            return false;
        }
        int i3;
        int currentlyShowingValue = getCurrentlyShowingValue();
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            i3 = 30;
            currentlyShowingValue %= 12;
        } else {
            i3 = currentItemShowing == 1 ? 6 : 0;
        }
        i2 = m3598d(currentlyShowingValue * i3, i2) / i3;
        if (currentItemShowing != 0) {
            currentlyShowingValue = 55;
            i3 = 0;
        } else if (this.f3142i) {
            currentlyShowingValue = 23;
            i3 = 0;
        } else {
            currentlyShowingValue = 12;
            i3 = 1;
        }
        if (i2 <= currentlyShowingValue) {
            i3 = i2 < i3 ? currentlyShowingValue : i2;
        }
        m3595b(currentItemShowing, i3);
        this.f3138e.mo2615a(currentItemShowing, i3, false);
        return true;
    }

    public void setAmOrPm(int i) {
        this.f3146m.setAmOrPm(i);
        this.f3146m.invalidate();
        m3597c(2, i);
    }

    public void setOnValueSelectedListener(C1415a c1415a) {
        this.f3138e = c1415a;
    }
}
