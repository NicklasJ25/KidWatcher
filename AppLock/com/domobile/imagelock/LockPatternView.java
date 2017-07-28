package com.domobile.imagelock;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.theme.C1102c;
import com.domobile.frame.p000a.C1148d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LockPatternView extends View {
    public static final long[] f2779a = new long[]{0, 1, 26, 30};
    private static final int f2780c = Color.parseColor("#FFFFFF");
    private Bitmap f2781A;
    private Bitmap f2782B;
    private Bitmap f2783C;
    private Bitmap f2784D;
    private Bitmap f2785E;
    private final Path f2786F;
    private final Rect f2787G;
    private int f2788H;
    private int f2789I;
    private int f2790J;
    private int f2791K;
    private final Matrix f2792L;
    private final Matrix f2793M;
    private Vibrator f2794N;
    private int f2795O;
    private int f2796P;
    private boolean f2797Q;
    private C1150y f2798R;
    public Runnable f2799b;
    private boolean f2800d;
    private Paint f2801e;
    private Paint f2802f;
    private int f2803g;
    private int f2804h;
    private C0950c f2805i;
    private ArrayList<C1308a> f2806j;
    private boolean[][] f2807k;
    private C1308a f2808l;
    private float f2809m;
    private float f2810n;
    private long f2811o;
    private C1309b f2812p;
    private boolean f2813q;
    private boolean f2814r;
    private boolean f2815s;
    private boolean f2816t;
    private boolean f2817u;
    private float f2818v;
    private float f2819w;
    private int f2820x;
    private float f2821y;
    private float f2822z;

    public interface C0950c {
        void mo2450a();

        void mo2451a(List<C1308a> list);

        void mo2452b();

        void mo2453b(List<C1308a> list);
    }

    class C13061 implements Runnable {
        final /* synthetic */ LockPatternView f2766a;

        C13061(LockPatternView lockPatternView) {
            this.f2766a = lockPatternView;
        }

        public void run() {
            this.f2766a.m3209b();
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C13071();
        private final String f2767a;
        private final int f2768b;
        private final boolean f2769c;
        private final boolean f2770d;
        private final boolean f2771e;

        static class C13071 implements Creator<SavedState> {
            C13071() {
            }

            public SavedState m3174a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3175a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3174a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3175a(i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f2767a = parcel.readString();
            this.f2768b = parcel.readInt();
            this.f2769c = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f2770d = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f2771e = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        private SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.f2767a = str;
            this.f2768b = i;
            this.f2769c = z;
            this.f2770d = z2;
            this.f2771e = z3;
        }

        public String m3176a() {
            return this.f2767a;
        }

        public int m3177b() {
            return this.f2768b;
        }

        public boolean m3178c() {
            return this.f2769c;
        }

        public boolean m3179d() {
            return this.f2770d;
        }

        public boolean m3180e() {
            return this.f2771e;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2767a);
            parcel.writeInt(this.f2768b);
            parcel.writeValue(Boolean.valueOf(this.f2769c));
            parcel.writeValue(Boolean.valueOf(this.f2770d));
            parcel.writeValue(Boolean.valueOf(this.f2771e));
        }
    }

    public static class C1308a {
        static C1308a[][] f2772c = ((C1308a[][]) Array.newInstance(C1308a.class, new int[]{3, 3}));
        public int f2773a;
        public int f2774b;

        static {
            for (int i = 0; i < 3; i++) {
                for (int i2 = 0; i2 < 3; i2++) {
                    f2772c[i][i2] = new C1308a(i, i2);
                }
            }
        }

        private C1308a(int i, int i2) {
            C1308a.m3182b(i, i2);
            this.f2773a = i;
            this.f2774b = i2;
        }

        public static synchronized C1308a m3181a(int i, int i2) {
            C1308a c1308a;
            synchronized (C1308a.class) {
                C1308a.m3182b(i, i2);
                c1308a = f2772c[i][i2];
            }
            return c1308a;
        }

        private static void m3182b(int i, int i2) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row must be in range 0-2");
            } else if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }

        public int m3183a() {
            return this.f2773a;
        }

        public int m3184b() {
            return this.f2774b;
        }

        public String toString() {
            return "(row=" + this.f2773a + ",clmn=" + this.f2774b + ")";
        }
    }

    public enum C1309b {
        Correct,
        Animate,
        Wrong
    }

    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2800d = false;
        this.f2801e = new Paint(7);
        this.f2802f = new Paint(1);
        this.f2803g = 0;
        this.f2804h = 0;
        this.f2806j = new ArrayList(9);
        this.f2807k = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3});
        this.f2809m = -1.0f;
        this.f2810n = -1.0f;
        this.f2812p = C1309b.Correct;
        this.f2813q = true;
        this.f2814r = false;
        this.f2815s = false;
        this.f2816t = true;
        this.f2817u = false;
        this.f2818v = 0.1f;
        this.f2819w = 0.6f;
        this.f2820x = 128;
        this.f2786F = new Path();
        this.f2787G = new Rect();
        this.f2792L = new Matrix();
        this.f2793M = new Matrix();
        this.f2795O = -1;
        this.f2796P = -1;
        this.f2797Q = false;
        this.f2799b = new C13061(this);
        this.f2798R = C1150y.m2598b(context);
        this.f2803g = context.getResources().getDimensionPixelSize(R.dimen.lock_pattern_dot_size);
        this.f2804h = context.getResources().getDimensionPixelSize(R.dimen.lock_pattern_dot_size_activated);
        m3190a(context);
        this.f2794N = (Vibrator) context.getSystemService("vibrator");
        this.f2791K = 0;
        setClickable(true);
        if (this.f2802f == null) {
            this.f2802f = new Paint();
        }
        this.f2802f.setAntiAlias(true);
        this.f2802f.setDither(true);
        this.f2802f.setColor(this.f2795O);
        this.f2802f.setAlpha(this.f2820x);
        this.f2802f.setStyle(Style.STROKE);
        this.f2802f.setStrokeJoin(Join.ROUND);
        this.f2802f.setStrokeCap(Cap.ROUND);
        Bitmap[] bitmapArr = new Bitmap[]{this.f2781A, this.f2782B, this.f2783C, this.f2784D, this.f2785E};
        this.f2790J = C1148d.m2498a(getContext(), 72.0f);
        for (Bitmap width : bitmapArr) {
            try {
                int max = Math.max(this.f2788H, width.getWidth());
                this.f2788H = max;
                this.f2789I = max;
            } catch (Exception e) {
            }
        }
    }

    private float m3185a(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.f2821y)) + (this.f2821y / 2.0f);
    }

    private int m3186a(float f) {
        float f2 = this.f2822z;
        float f3 = f2 * this.f2819w;
        float paddingTop = ((f2 - f3) / 2.0f) + ((float) getPaddingTop());
        for (int i = 0; i < 3; i++) {
            float f4 = (((float) i) * f2) + paddingTop;
            if (f >= f4 && f <= f4 + f3) {
                return i;
            }
        }
        return -1;
    }

    private int m3187a(int i, int i2) {
        return Math.min(i2, MeasureSpec.getSize(i));
    }

    private Bitmap m3188a(Context context, String str, int i) {
        return C1102c.m2398c(context, str, i);
    }

    private C1308a m3189a(float f, float f2) {
        C1308a c1308a = null;
        int i = 1;
        C1308a b = m3196b(f, f2);
        if (b == null) {
            return null;
        }
        ArrayList arrayList = this.f2806j;
        if (!arrayList.isEmpty()) {
            int i2;
            c1308a = (C1308a) arrayList.get(arrayList.size() - 1);
            int i3 = b.f2773a - c1308a.f2773a;
            int i4 = b.f2774b - c1308a.f2774b;
            int i5 = c1308a.f2773a;
            int i6 = c1308a.f2774b;
            if (Math.abs(i3) == 2 && Math.abs(i4) != 1) {
                i5 = (i3 > 0 ? 1 : -1) + c1308a.f2773a;
            }
            if (Math.abs(i4) != 2 || Math.abs(i3) == 1) {
                i2 = i6;
            } else {
                i2 = c1308a.f2774b;
                if (i4 <= 0) {
                    i = -1;
                }
                i2 += i;
            }
            c1308a = C1308a.m3181a(i5, i2);
        }
        if (!(c1308a == null || this.f2807k[c1308a.f2773a][c1308a.f2774b])) {
            m3193a(c1308a);
        }
        m3193a(b);
        if (this.f2816t) {
            this.f2794N.vibrate(f2779a, -1);
        }
        return b;
    }

    private void m3190a(Context context) {
        Object packageName;
        m3206a();
        if (this.f2797Q) {
            packageName = context.getPackageName();
        } else {
            String a = C1102c.m2385a(context);
        }
        this.f2781A = m3188a(context, packageName, R.drawable.btn_code_lock_default_holo);
        this.f2782B = m3188a(context, packageName, R.drawable.btn_code_lock_touched_holo);
        this.f2783C = m3188a(context, packageName, R.drawable.indicator_code_lock_point_area_default_holo);
        this.f2784D = m3188a(context, packageName, R.drawable.indicator_code_lock_point_area_green_holo);
        this.f2785E = m3188a(context, packageName, R.drawable.indicator_code_lock_point_area_red_holo);
        if (this.f2797Q) {
            this.f2795O = -1;
        } else if (TextUtils.equals(getContext().getPackageName(), packageName)) {
            this.f2795O = C1150y.m2566a(getContext()).f439n;
            if (this.f2795O == 0) {
                this.f2795O = -1;
            }
        } else {
            this.f2795O = ((Integer) C1102c.m2402d(context, packageName, R.color.pattern_line_default)).intValue();
        }
        this.f2796P = ((Integer) C1102c.m2402d(context, packageName, R.color.pattern_line_error)).intValue();
        this.f2820x = C1102c.m2404e(context, packageName, R.integer.pattern_line_alpha);
    }

    private void m3191a(Canvas canvas, int i, int i2, boolean z, boolean z2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!z || (this.f2814r && this.f2812p != C1309b.Wrong)) {
            bitmap = this.f2783C;
            bitmap2 = this.f2781A;
        } else if (this.f2817u) {
            bitmap = this.f2784D;
            bitmap2 = this.f2782B;
        } else if (this.f2812p == C1309b.Wrong) {
            bitmap = this.f2785E;
            bitmap2 = this.f2781A;
        } else if (this.f2812p == C1309b.Correct || this.f2812p == C1309b.Animate) {
            bitmap = this.f2784D;
            bitmap2 = this.f2781A;
        } else {
            throw new IllegalStateException("unknown display mode " + this.f2812p);
        }
        int i3 = this.f2788H;
        int i4 = this.f2789I;
        float f = this.f2821y;
        float f2 = (float) this.f2790J;
        f = ((f - f2) - (((float) i3) - f2)) / 2.0f;
        float f3 = ((this.f2822z - f2) - (((float) i3) - f2)) / 2.0f;
        float min = Math.min(f2 / ((float) i3), 1.0f);
        float min2 = Math.min(f2 / ((float) i4), 1.0f);
        this.f2793M.setTranslate(((float) i) + f, ((float) i2) + f3);
        this.f2793M.preTranslate((float) (this.f2788H / 2), (float) (this.f2789I / 2));
        this.f2793M.preScale(min, min2);
        this.f2793M.preTranslate((float) ((-this.f2788H) / 2), (float) ((-this.f2789I) / 2));
        if (bitmap == null || bitmap2 == null) {
            float f4 = (((float) i) + f) + ((float) (i3 / 2));
            float f5 = (((float) i2) + f3) + ((float) (i3 / 2));
            if (z2 && z) {
                this.f2801e.setColor(this.f2796P);
            } else if (this.f2815s) {
                this.f2801e.setColor(f2780c);
            }
            if (!z || this.f2814r) {
                canvas.drawCircle(f4, f5, (float) (this.f2803g / 2), this.f2801e);
            } else {
                canvas.drawCircle(f4, f5, (float) (this.f2804h / 2), this.f2801e);
            }
            this.f2801e.setColor(this.f2795O);
            return;
        }
        canvas.drawBitmap(bitmap, this.f2793M, this.f2801e);
        canvas.drawBitmap(bitmap2, this.f2793M, this.f2801e);
    }

    private void m3192a(MotionEvent motionEvent) {
        C1308a c = m3198c(motionEvent.getX(), motionEvent.getY());
        if (!this.f2815s && motionEvent.getEventTime() - motionEvent.getDownTime() > 600 && this.f2808l != null && this.f2808l.equals(c)) {
            setInStealthMode(this.f2798R.f2223h);
            this.f2794N.vibrate(f2779a, -1);
            this.f2808l = null;
            invalidate();
        } else if (!(this.f2808l == null || this.f2808l.equals(c))) {
            this.f2808l = null;
        }
        int historySize = motionEvent.getHistorySize();
        int i = 0;
        while (i < historySize + 1) {
            float historicalX = i < historySize ? motionEvent.getHistoricalX(i) : motionEvent.getX();
            float historicalY = i < historySize ? motionEvent.getHistoricalY(i) : motionEvent.getY();
            int size = this.f2806j.size();
            C1308a a = m3189a(historicalX, historicalY);
            int size2 = this.f2806j.size();
            if (a != null && size2 == 1) {
                this.f2817u = true;
                m3201g();
            }
            if (Math.abs(historicalX - this.f2809m) + Math.abs(historicalY - this.f2810n) > this.f2821y * 0.01f) {
                float f = this.f2809m;
                float f2 = this.f2810n;
                this.f2809m = historicalX;
                this.f2810n = historicalY;
                if (!this.f2817u || size2 <= 0) {
                    invalidate();
                } else {
                    float f3;
                    float f4;
                    float f5;
                    ArrayList arrayList = this.f2806j;
                    float f6 = (this.f2821y * this.f2818v) * 0.5f;
                    c = (C1308a) arrayList.get(size2 - 1);
                    float a2 = m3185a(c.f2774b);
                    float b = m3194b(c.f2773a);
                    Rect rect = this.f2787G;
                    if (a2 < historicalX) {
                        f3 = historicalX;
                        f4 = a2;
                    } else {
                        f3 = a2;
                        f4 = historicalX;
                    }
                    if (b < historicalY) {
                        historicalX = b;
                    } else {
                        historicalX = historicalY;
                        historicalY = b;
                    }
                    rect.set((int) (f4 - f6), (int) (historicalX - f6), (int) (f3 + f6), (int) (historicalY + f6));
                    if (a2 < f) {
                        historicalY = f;
                    } else {
                        historicalY = a2;
                        a2 = f;
                    }
                    if (b < f2) {
                        f5 = f2;
                        f2 = b;
                        b = f5;
                    }
                    rect.union((int) (a2 - f6), (int) (f2 - f6), (int) (historicalY + f6), (int) (b + f6));
                    if (a != null) {
                        historicalX = m3185a(a.f2774b);
                        historicalY = m3194b(a.f2773a);
                        if (size2 >= 2) {
                            c = (C1308a) arrayList.get((size2 - 1) - (size2 - size));
                            f2 = m3185a(c.f2774b);
                            b = m3194b(c.f2773a);
                            if (historicalX < f2) {
                                f5 = f2;
                                f2 = historicalX;
                                historicalX = f5;
                            }
                            if (historicalY < b) {
                                f5 = historicalX;
                                historicalX = historicalY;
                                historicalY = f5;
                            } else {
                                f5 = historicalY;
                                historicalY = historicalX;
                                historicalX = b;
                                b = f5;
                            }
                        } else {
                            b = historicalY;
                            f2 = historicalX;
                            f5 = historicalY;
                            historicalY = historicalX;
                            historicalX = f5;
                        }
                        f = this.f2821y / 2.0f;
                        a2 = this.f2822z / 2.0f;
                        rect.set((int) (f2 - f), (int) (historicalX - a2), (int) (historicalY + f), (int) (b + a2));
                    }
                    invalidate(rect);
                }
            }
            i++;
        }
    }

    private void m3193a(C1308a c1308a) {
        this.f2807k[c1308a.m3183a()][c1308a.m3184b()] = true;
        this.f2806j.add(c1308a);
        m3200f();
    }

    private float m3194b(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.f2822z)) + (this.f2822z / 2.0f);
    }

    private int m3195b(float f) {
        float f2 = this.f2821y;
        float f3 = f2 * this.f2819w;
        float paddingLeft = ((f2 - f3) / 2.0f) + ((float) getPaddingLeft());
        for (int i = 0; i < 3; i++) {
            float f4 = (((float) i) * f2) + paddingLeft;
            if (f >= f4 && f <= f4 + f3) {
                return i;
            }
        }
        return -1;
    }

    private C1308a m3196b(float f, float f2) {
        int a = m3186a(f2);
        if (a < 0) {
            return null;
        }
        int b = m3195b(f);
        return (b < 0 || this.f2807k[a][b]) ? null : C1308a.m3181a(a, b);
    }

    private void m3197b(MotionEvent motionEvent) {
        this.f2808l = null;
        if (!this.f2806j.isEmpty()) {
            this.f2817u = false;
            m3202h();
            invalidate();
        }
    }

    private C1308a m3198c(float f, float f2) {
        int a = m3186a(f2);
        if (a < 0) {
            return null;
        }
        int b = m3195b(f);
        return b >= 0 ? C1308a.m3181a(a, b) : null;
    }

    private void m3199c(MotionEvent motionEvent) {
        if (!this.f2815s) {
            setInStealthMode(!this.f2798R.f2223h);
        }
        m3204j();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        C1308a a = m3189a(x, y);
        if (a != null) {
            this.f2808l = a;
            this.f2817u = true;
            this.f2812p = C1309b.Correct;
            m3201g();
        } else if (this.f2817u) {
            this.f2817u = false;
            m3203i();
        }
        if (a != null) {
            float a2 = m3185a(a.f2774b);
            float b = m3194b(a.f2773a);
            float f = this.f2821y / 2.0f;
            float f2 = this.f2822z / 2.0f;
            invalidate((int) (a2 - f), (int) (b - f2), (int) (a2 + f), (int) (b + f2));
        }
        this.f2809m = x;
        this.f2810n = y;
    }

    private void m3200f() {
        if (this.f2805i != null) {
            this.f2805i.mo2453b(this.f2806j);
        }
    }

    private void m3201g() {
        if (this.f2805i != null) {
            this.f2805i.mo2450a();
        }
    }

    private void m3202h() {
        if (this.f2805i != null) {
            this.f2805i.mo2451a(this.f2806j);
        }
    }

    private void m3203i() {
        if (this.f2805i != null) {
            this.f2805i.mo2452b();
        }
    }

    private void m3204j() {
        this.f2806j.clear();
        m3205k();
        this.f2812p = C1309b.Correct;
        invalidate();
    }

    private void m3205k() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f2807k[i][i2] = false;
            }
        }
    }

    public void m3206a() {
        removeCallbacks(this.f2799b);
        if (this.f2781A != null) {
            this.f2781A.recycle();
        }
        if (this.f2782B != null) {
            this.f2782B.recycle();
        }
        if (this.f2783C != null) {
            this.f2783C.recycle();
        }
        if (this.f2784D != null) {
            this.f2784D.recycle();
        }
        if (this.f2785E != null) {
            this.f2785E.recycle();
        }
    }

    public void m3207a(long j) {
        removeCallbacks(this.f2799b);
        postDelayed(this.f2799b, j);
    }

    public void m3208a(C1309b c1309b, List<C1308a> list) {
        this.f2806j.clear();
        this.f2806j.addAll(list);
        m3205k();
        for (C1308a c1308a : list) {
            this.f2807k[c1308a.m3183a()][c1308a.m3184b()] = true;
        }
        setDisplayMode(c1309b);
    }

    public void m3209b() {
        try {
            m3204j();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void m3210c() {
        this.f2813q = true;
    }

    public void m3211d() {
        m3207a(2000);
    }

    public void m3212e() {
        removeCallbacks(this.f2799b);
    }

    protected int getSuggestedMinimumHeight() {
        return C1148d.m2498a(getContext(), 76.0f) * 4;
    }

    protected int getSuggestedMinimumWidth() {
        return C1148d.m2498a(getContext(), 76.0f) * 4;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f2783C != null && !this.f2783C.isRecycled()) {
            int elapsedRealtime;
            int i;
            C1308a c1308a;
            float a;
            float b;
            int i2;
            int i3;
            ArrayList arrayList = this.f2806j;
            int size = arrayList.size();
            boolean[][] zArr = this.f2807k;
            if (this.f2812p == C1309b.Animate) {
                elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.f2811o)) % ((size + 1) * PositionController.CAPTURE_ANIMATION_TIME);
                int i4 = elapsedRealtime / PositionController.CAPTURE_ANIMATION_TIME;
                m3205k();
                for (i = 0; i < i4; i++) {
                    c1308a = (C1308a) arrayList.get(i);
                    zArr[c1308a.m3183a()][c1308a.m3184b()] = true;
                }
                Object obj = (i4 <= 0 || i4 >= size) ? null : 1;
                if (obj != null) {
                    float f = ((float) (elapsedRealtime % PositionController.CAPTURE_ANIMATION_TIME)) / 700.0f;
                    c1308a = (C1308a) arrayList.get(i4 - 1);
                    float a2 = m3185a(c1308a.f2774b);
                    float b2 = m3194b(c1308a.f2773a);
                    c1308a = (C1308a) arrayList.get(i4);
                    a = (m3185a(c1308a.f2774b) - a2) * f;
                    b = (m3194b(c1308a.f2773a) - b2) * f;
                    this.f2809m = a2 + a;
                    this.f2810n = b + b2;
                }
                invalidate();
            }
            float f2 = this.f2821y;
            float f3 = this.f2822z;
            this.f2802f.setStrokeWidth((this.f2818v * f2) * 0.5f);
            Path path = this.f2786F;
            path.rewind();
            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();
            for (i2 = 0; i2 < 3; i2++) {
                float f4 = ((float) paddingTop) + (((float) i2) * f3);
                for (i3 = 0; i3 < 3; i3++) {
                    m3191a(canvas, (int) (((float) paddingLeft) + (((float) i3) * f2)), (int) f4, false, false);
                }
            }
            boolean z = this.f2812p == C1309b.Wrong;
            Object obj2 = (!this.f2814r || z) ? 1 : null;
            Paint paint = this.f2802f;
            int i5 = z ? this.f2796P : this.f2815s ? f2780c : this.f2795O;
            paint.setColor(i5);
            if (obj2 != null) {
                for (elapsedRealtime = 0; elapsedRealtime < size - 1; elapsedRealtime++) {
                    c1308a = (C1308a) arrayList.get(elapsedRealtime + 1);
                    if (!zArr[c1308a.f2773a][c1308a.f2774b]) {
                        break;
                    }
                }
            }
            if (obj2 != null) {
                Object obj3 = null;
                for (i = 0; i < size; i++) {
                    c1308a = (C1308a) arrayList.get(i);
                    if (!zArr[c1308a.f2773a][c1308a.f2774b]) {
                        break;
                    }
                    obj3 = 1;
                    a = m3185a(c1308a.f2774b);
                    b = m3194b(c1308a.f2773a);
                    if (i == 0) {
                        path.moveTo(a, b);
                    } else {
                        path.lineTo(a, b);
                    }
                }
                if ((this.f2817u || this.f2812p == C1309b.Animate) && r4 != null) {
                    path.lineTo(this.f2809m, this.f2810n);
                }
                canvas.drawPath(path, this.f2802f);
            }
            for (i2 = 0; i2 < 3; i2++) {
                float f5 = ((float) paddingTop) + (((float) i2) * f3);
                for (i3 = 0; i3 < 3; i3++) {
                    m3191a(canvas, (int) (((float) paddingLeft) + (((float) i3) * f2)), (int) f5, zArr[i2][i3], z);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int a = m3187a(i, suggestedMinimumWidth);
        suggestedMinimumWidth = m3187a(i2, suggestedMinimumHeight);
        switch (this.f2791K) {
            case 0:
                suggestedMinimumWidth = Math.min(a, suggestedMinimumWidth);
                a = suggestedMinimumWidth;
                break;
            case 1:
                suggestedMinimumWidth = Math.min(a, suggestedMinimumWidth);
                break;
            case 2:
                a = Math.min(a, suggestedMinimumWidth);
                break;
        }
        setMeasuredDimension(a, suggestedMinimumWidth);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m3208a(C1309b.Correct, C1318c.m3242a(savedState.m3176a()));
        this.f2812p = C1309b.values()[savedState.m3177b()];
        this.f2813q = savedState.m3178c();
        this.f2814r = savedState.m3179d();
        this.f2816t = savedState.m3180e();
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), C1318c.m3244c(this.f2806j), this.f2812p.ordinal(), this.f2813q, this.f2814r, this.f2816t);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f2821y = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.f2822z = ((float) ((i2 - getPaddingLeft()) - getPaddingRight())) / 3.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f2813q || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m3199c(motionEvent);
                return true;
            case 1:
                m3197b(motionEvent);
                return true;
            case 2:
                m3192a(motionEvent);
                return true;
            case 3:
                this.f2808l = null;
                if (!this.f2817u) {
                    return true;
                }
                this.f2817u = false;
                m3204j();
                m3203i();
                return true;
            default:
                return false;
        }
    }

    public void setDisplayMode(C1309b c1309b) {
        this.f2812p = c1309b;
        if (c1309b == C1309b.Animate) {
            if (this.f2806j.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            this.f2811o = SystemClock.elapsedRealtime();
            C1308a c1308a = (C1308a) this.f2806j.get(0);
            this.f2809m = m3185a(c1308a.m3184b());
            this.f2810n = m3194b(c1308a.m3183a());
            m3205k();
        }
        invalidate();
    }

    public void setForceKeepOriginTheme(boolean z) {
        Object obj = this.f2797Q == z ? 1 : null;
        this.f2797Q = z;
        if (obj == null) {
            m3190a(getContext());
        }
    }

    public void setInChooseMode(boolean z) {
        this.f2815s = z;
        if (z) {
            this.f2802f.setColor(f2780c);
        }
    }

    public void setInStealthMode(boolean z) {
        this.f2814r = z;
    }

    public void setOnPatternListener(C0950c c0950c) {
        this.f2805i = c0950c;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.f2816t = z;
    }
}
