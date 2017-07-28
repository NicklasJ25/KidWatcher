package com.domobile.frame.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p015b.C1168b.C1160d;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1166j;

public class C1301e implements OnDismissListener {
    private Drawable f2736A;
    private BroadcastReceiver f2737B = new C12933(this);
    int f2738a = Integer.MAX_VALUE;
    private Context f2739b;
    private PopupWindow f2740c;
    private ListAdapter f2741d;
    private C1294a f2742e;
    private boolean f2743f = false;
    private boolean f2744g = false;
    private View f2745h;
    private int f2746i = 0;
    private DataSetObserver f2747j;
    private View f2748k;
    private OnDismissListener f2749l;
    private OnItemClickListener f2750m;
    private OnItemSelectedListener f2751n;
    private final C1299f f2752o = new C1299f();
    private final C1298e f2753p = new C1298e();
    private final C1297d f2754q = new C1297d();
    private final C1295b f2755r = new C1295b();
    private Runnable f2756s;
    private Handler f2757t = new Handler();
    private Rect f2758u = new Rect();
    private boolean f2759v;
    private int f2760w = -1;
    private int f2761x;
    private boolean f2762y = false;
    private Drawable f2763z;

    class C12911 implements Runnable {
        final /* synthetic */ C1301e f2725a;

        C12911(C1301e c1301e) {
            this.f2725a = c1301e;
        }

        public void run() {
            View a = this.f2725a.m3161a();
            if (a != null && a.getWindowToken() != null) {
                this.f2725a.m3168b();
            }
        }
    }

    class C12922 implements OnItemSelectedListener {
        final /* synthetic */ C1301e f2726a;

        C12922(C1301e c1301e) {
            this.f2726a = c1301e;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C1294a a = this.f2726a.f2742e;
                if (a != null) {
                    a.f2728a = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C12933 extends BroadcastReceiver {
        final /* synthetic */ C1301e f2727a;

        C12933(C1301e c1301e) {
            this.f2727a = c1301e;
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.domobile.frame.action.ACTION_SCREEN_ORINET_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("com.domobile.frame.EXTRA_ORIENTATION", -1);
                if (this.f2727a.f2760w != intExtra) {
                    this.f2727a.f2760w = intExtra;
                    this.f2727a.f2762y = false;
                    this.f2727a.m3170c();
                }
            }
        }
    }

    private static class C1294a extends ListView {
        private boolean f2728a;
        private boolean f2729b;

        public C1294a(Context context, boolean z) {
            super(context, null, 16842861);
            this.f2729b = z;
            setCacheColorHint(0);
        }

        public boolean hasFocus() {
            return this.f2729b || super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return this.f2729b || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f2729b || super.isFocused();
        }

        public boolean isInTouchMode() {
            return (this.f2729b && this.f2728a) || super.isInTouchMode();
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        }
    }

    private class C1295b implements Runnable {
        final /* synthetic */ C1301e f2730a;

        private C1295b(C1301e c1301e) {
            this.f2730a = c1301e;
        }

        public void run() {
            this.f2730a.m3171d();
        }
    }

    private class C1296c extends DataSetObserver {
        final /* synthetic */ C1301e f2731a;

        private C1296c(C1301e c1301e) {
            this.f2731a = c1301e;
        }

        public void onChanged() {
            if (this.f2731a.m3172e()) {
                this.f2731a.m3168b();
            }
        }

        public void onInvalidated() {
            this.f2731a.m3170c();
        }
    }

    private class C1297d implements OnScrollListener {
        final /* synthetic */ C1301e f2732a;

        private C1297d(C1301e c1301e) {
            this.f2732a = c1301e;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && this.f2732a.f2740c.getContentView() != null) {
                this.f2732a.f2757t.removeCallbacks(this.f2732a.f2752o);
                this.f2732a.f2752o.run();
            }
        }
    }

    private class C1298e implements OnTouchListener {
        final /* synthetic */ C1301e f2733a;

        private C1298e(C1301e c1301e) {
            this.f2733a = c1301e;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            this.f2733a.m3170c();
            return true;
        }
    }

    private class C1299f implements Runnable {
        final /* synthetic */ C1301e f2734a;

        private C1299f(C1301e c1301e) {
            this.f2734a = c1301e;
        }

        public void run() {
            if (this.f2734a.f2742e != null && this.f2734a.f2742e.getCount() > this.f2734a.f2742e.getChildCount() && this.f2734a.f2742e.getChildCount() <= this.f2734a.f2738a) {
                this.f2734a.f2740c.setInputMethodMode(2);
                this.f2734a.m3168b();
            }
        }
    }

    private class C1300g implements Runnable {
        final /* synthetic */ C1301e f2735a;

        private C1300g(C1301e c1301e) {
            this.f2735a = c1301e;
        }

        public void run() {
            this.f2735a.m3168b();
        }
    }

    public C1301e(Context context, AttributeSet attributeSet, int i) {
        this.f2739b = context;
        this.f2740c = new PopupWindow(context, attributeSet, i);
        this.f2740c.setInputMethodMode(1);
        Resources resources = this.f2739b.getResources();
        this.f2761x = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C1160d.menu_popup_maxwidth));
        this.f2763z = C1148d.m2502a(resources, C1161e.dialog_full_holo_light);
        this.f2736A = C1148d.m2502a(resources, C1161e.popupwindow_divider_holo_light);
    }

    private int m3154b(ListAdapter listAdapter) {
        ViewGroup frameLayout = new FrameLayout(this.f2739b);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        View view = null;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            View view3 = listAdapter.getView(i, view2, frameLayout);
            view3.measure(makeMeasureSpec, makeMeasureSpec2);
            i++;
            i3 = Math.max(i3, view3.getMeasuredWidth());
            i2 = itemViewType;
            view = view3;
        }
        return i3;
    }

    private void m3159g() {
        if (this.f2745h != null) {
            ViewParent parent = this.f2745h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2745h);
            }
        }
    }

    private int m3160h() {
        int measuredHeight;
        int i = 0;
        LayoutParams layoutParams;
        View view;
        if (this.f2742e == null) {
            Context context = this.f2739b;
            this.f2756s = new C12911(this);
            this.f2742e = new C1294a(context, !this.f2759v);
            this.f2742e.setOverScrollMode(2);
            this.f2742e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f2742e.setSelector(C1161e.transparent);
            C1148d.m2514a(this.f2742e, this.f2763z);
            this.f2742e.setDivider(this.f2736A);
            this.f2742e.setDividerHeight(1);
            this.f2742e.setFocusable(true);
            this.f2742e.setAdapter(this.f2741d);
            this.f2742e.setFocusableInTouchMode(true);
            this.f2742e.setOnScrollListener(this.f2754q);
            this.f2742e.setOnItemClickListener(this.f2750m);
            if (this.f2751n != null) {
                this.f2742e.setOnItemSelectedListener(this.f2751n);
            }
            this.f2742e.setOnItemSelectedListener(new C12922(this));
            View view2 = this.f2742e;
            View view3 = this.f2745h;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2746i) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(-2, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                View linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(1);
                linearLayout2.addView(view2, new LayoutParams(0, -1));
                view = linearLayout2;
                measuredHeight = 0;
            }
            this.f2740c.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2740c.getContentView();
            view = this.f2745h;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f2740c.getBackground();
        if (background != null) {
            background.getPadding(this.f2758u);
            i = this.f2758u.bottom + this.f2758u.top;
        }
        int measuredHeight2 = this.f2742e.getMeasuredHeight();
        if (measuredHeight2 > 0) {
            measuredHeight += i;
        }
        return measuredHeight + measuredHeight2;
    }

    public View m3161a() {
        return this.f2748k;
    }

    public void m3162a(int i) {
        try {
            this.f2763z = C1148d.m2502a(this.f2739b.getResources(), i);
        } catch (Exception e) {
            this.f2763z = null;
        }
    }

    public void m3163a(View view) {
        this.f2748k = view;
    }

    public void m3164a(OnItemClickListener onItemClickListener) {
        this.f2750m = onItemClickListener;
    }

    public void m3165a(ListAdapter listAdapter) {
        if (this.f2747j == null) {
            this.f2747j = new C1296c();
        } else if (this.f2741d != null) {
            this.f2741d.unregisterDataSetObserver(this.f2747j);
        }
        this.f2741d = listAdapter;
        if (this.f2741d != null) {
            listAdapter.registerDataSetObserver(this.f2747j);
        }
        if (this.f2742e != null) {
            this.f2742e.setAdapter(this.f2741d);
        }
    }

    public void m3166a(OnDismissListener onDismissListener) {
        this.f2749l = onDismissListener;
    }

    public void m3167a(boolean z) {
        this.f2759v = true;
        this.f2740c.setFocusable(z);
    }

    public void m3168b() {
        if (!this.f2740c.isShowing()) {
            int i;
            m3160h();
            View a = m3161a();
            int[] iArr = new int[2];
            a.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + a.getWidth(), iArr[1] + a.getHeight());
            int i2 = rect.left;
            int i3 = rect.bottom;
            DisplayMetrics displayMetrics = this.f2739b.getResources().getDisplayMetrics();
            int i4 = displayMetrics.widthPixels;
            int i5 = displayMetrics.heightPixels;
            int applyDimension = (int) TypedValue.applyDimension(1, 30.0f, displayMetrics);
            if (rect.top > i5 - rect.bottom) {
                i = 1;
            } else {
                boolean z = false;
            }
            i3 = (i != 0 ? rect.top : i5 - rect.bottom) - applyDimension;
            this.f2740c.setOnDismissListener(this);
            this.f2742e.setVerticalScrollBarEnabled(false);
            this.f2742e.measure(i4, i3);
            i5 = this.f2742e.getMeasuredHeight();
            applyDimension = m3154b(this.f2741d);
            this.f2740c.setBackgroundDrawable(new BitmapDrawable());
            this.f2740c.setHeight(Math.min(i3, i5));
            this.f2740c.setWidth(Math.min(applyDimension, this.f2761x));
            PopupWindow popupWindow = this.f2740c;
            C1166j c1166j;
            if (i != 0) {
                c1166j = C1147a.f2203V;
                i3 = C1166j.domo_menu_animations_popup;
            } else {
                c1166j = C1147a.f2203V;
                i3 = C1166j.domo_menu_animations_popdown;
            }
            popupWindow.setAnimationStyle(i3);
            ViewGroup.LayoutParams layoutParams = this.f2742e.getLayoutParams();
            layoutParams.width = Math.min(applyDimension, this.f2761x);
            layoutParams.height = this.f2740c.getHeight();
            this.f2742e.setLayoutParams(layoutParams);
            i5 = this.f2739b.getResources().getDimensionPixelSize(C1160d.PaddingSizeSmaller);
            i = i != 0 ? rect.top - this.f2740c.getHeight() : rect.bottom;
            if ((rect.left + this.f2740c.getWidth()) + i5 >= i4 && rect.right > this.f2740c.getWidth()) {
                i2 = (rect.right - this.f2740c.getWidth()) - i5;
            } else if (rect.centerX() > this.f2740c.getWidth() / 2) {
                i2 = (rect.left + (rect.width() / 2)) - (this.f2740c.getWidth() / 2);
            }
            this.f2740c.setTouchInterceptor(this.f2753p);
            PopupWindow popupWindow2 = this.f2740c;
            boolean z2 = (this.f2744g || this.f2743f) ? false : true;
            popupWindow2.setOutsideTouchable(z2);
            this.f2742e.setSelection(-1);
            if (!((this.f2739b instanceof Activity) && ((Activity) this.f2739b).isFinishing())) {
                this.f2740c.showAtLocation(a, 0, i2, i);
            }
            if (!this.f2759v || this.f2742e.isInTouchMode()) {
                m3171d();
            }
            if (!this.f2759v) {
                this.f2757t.post(this.f2755r);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.domobile.frame.action.ACTION_SCREEN_ORINET_CHANGED");
            this.f2739b.registerReceiver(this.f2737B, intentFilter);
        }
    }

    public void m3169b(int i) {
        try {
            this.f2736A = C1148d.m2502a(this.f2739b.getResources(), i);
        } catch (Exception e) {
            this.f2736A = null;
        }
    }

    public void m3170c() {
        C1148d.m2509a(this.f2739b, this.f2737B);
        this.f2740c.dismiss();
        m3159g();
        this.f2740c.setContentView(null);
        this.f2742e = null;
        this.f2757t.removeCallbacks(this.f2752o);
    }

    public void m3171d() {
        C1294a c1294a = this.f2742e;
        if (c1294a != null) {
            c1294a.f2728a = true;
            c1294a.requestLayout();
        }
    }

    public boolean m3172e() {
        return this.f2740c.isShowing();
    }

    public ListView m3173f() {
        return this.f2742e;
    }

    public void onDismiss() {
        if (this.f2762y) {
            this.f2762y = false;
            this.f2757t.postDelayed(new C1300g(), 200);
        } else if (this.f2749l != null) {
            this.f2749l.onDismiss();
        }
    }
}
