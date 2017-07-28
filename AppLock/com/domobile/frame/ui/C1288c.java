package com.domobile.frame.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.gallery3d.data.MediaSet;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p015b.C1168b.C1157a;
import com.domobile.p015b.C1168b.C1159c;
import com.domobile.p015b.C1168b.C1160d;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1166j;
import com.domobile.p015b.C1168b.C1167k;

public class C1288c implements OnClickListener {
    private Animation f2674A;
    private boolean f2675B = true;
    private boolean f2676C = false;
    private boolean f2677D = false;
    private boolean f2678E = false;
    private Runnable f2679F = new C12844(this);
    private C0415f f2680G = new C12855(this);
    public TextView f2681a;
    public TextView f2682b;
    private View f2683c;
    private WindowManager f2684d;
    private LayoutParams f2685e;
    private Activity f2686f;
    private View f2687g;
    private View f2688h;
    private View f2689i;
    private View f2690j;
    private View f2691k;
    private ListView f2692l;
    private ImageView f2693m;
    private LinearLayout f2694n;
    private ScrollView f2695o;
    private OnClickListener f2696p;
    private TextView f2697q;
    private TextView f2698r;
    private TextView f2699s;
    private OnClickListener f2700t;
    private OnClickListener f2701u;
    private OnClickListener f2702v;
    private OnDismissListener f2703w;
    private boolean f2704x;
    private Animation f2705y;
    private Animation f2706z;

    class C12811 implements OnClickListener {
        final /* synthetic */ C1288c f2664a;

        C12811(C1288c c1288c) {
            this.f2664a = c1288c;
        }

        public void onClick(View view) {
            if (this.f2664a.f2678E) {
                this.f2664a.m3125e();
            }
        }
    }

    class C12822 implements OnKeyListener {
        final /* synthetic */ C1288c f2665a;

        C12822(C1288c c1288c) {
            this.f2665a = c1288c;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 4 || keyEvent.getRepeatCount() != 0 || !this.f2665a.f2704x) {
                return false;
            }
            this.f2665a.m3125e();
            return true;
        }
    }

    class C12833 implements Runnable {
        final /* synthetic */ C1288c f2666a;

        C12833(C1288c c1288c) {
            this.f2666a = c1288c;
        }

        public void run() {
            this.f2666a.f2689i.startAnimation(this.f2666a.f2674A);
            this.f2666a.f2690j.setBackgroundColor(0);
        }
    }

    class C12844 implements Runnable {
        final /* synthetic */ C1288c f2667a;

        C12844(C1288c c1288c) {
            this.f2667a = c1288c;
        }

        public void run() {
            try {
                if ((this.f2667a.f2686f == null || !this.f2667a.f2686f.isFinishing()) && this.f2667a.f2683c != null) {
                    this.f2667a.f2684d.addView(this.f2667a.f2687g, this.f2667a.f2685e);
                    this.f2667a.f2689i.startAnimation(this.f2667a.f2706z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C12855 extends C0415f {
        final /* synthetic */ C1288c f2668a;

        C12855(C1288c c1288c) {
            this.f2668a = c1288c;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2668a.f2676C = false;
            if (animation == this.f2668a.f2706z) {
                if (this.f2668a.f2675B) {
                    this.f2668a.f2690j.setBackgroundResource(C1161e.dim_dialog_background_holo_light);
                    this.f2668a.f2690j.startAnimation(this.f2668a.f2705y);
                    this.f2668a.f2691k.invalidate();
                }
                if (this.f2668a.f2677D) {
                    this.f2668a.m3125e();
                }
            } else if (animation == this.f2668a.f2674A) {
                this.f2668a.m3084f();
                if (this.f2668a.f2696p != null) {
                    this.f2668a.f2696p.onClick(null);
                }
                this.f2668a.f2696p = null;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (animation == this.f2668a.f2674A) {
                this.f2668a.f2676C = true;
            }
        }
    }

    class C12866 implements Runnable {
        final /* synthetic */ C1288c f2669a;

        C12866(C1288c c1288c) {
            this.f2669a = c1288c;
        }

        public void run() {
            try {
                if (this.f2669a.m3087g()) {
                    this.f2669a.f2684d.removeView(this.f2669a.f2687g);
                    if (this.f2669a.f2703w != null) {
                        this.f2669a.f2703w.onDismiss();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public C1288c(Activity activity) {
        this.f2686f = activity;
        mo2529b();
    }

    private void m3084f() {
        this.f2687g.post(new C12866(this));
    }

    private View mo2530g(int i) {
        return this.f2687g.findViewById(i);
    }

    private boolean m3087g() {
        return (this.f2687g == null || this.f2687g.getParent() == null) ? false : true;
    }

    public Context m3100a() {
        return this.f2686f == null ? this.f2683c.getContext() : this.f2686f;
    }

    public C1288c m3101a(int i) {
        return m3109a(m3100a().getString(i));
    }

    public C1288c m3102a(int i, OnClickListener onClickListener) {
        return m3110a(m3100a().getString(i), onClickListener);
    }

    public C1288c m3103a(Drawable drawable) {
        if (drawable == null) {
            this.f2693m.setVisibility(8);
            if (TextUtils.isEmpty(this.f2681a.getText())) {
                this.f2688h.setVisibility(8);
            }
        } else {
            this.f2681a.setPadding(0, 0, 0, 0);
            this.f2693m.setAdjustViewBounds(true);
            this.f2688h.setVisibility(0);
        }
        return this;
    }

    public C1288c m3104a(OnClickListener onClickListener, boolean z) {
        if (z) {
            this.f2700t = onClickListener;
        } else {
            this.f2697q.setOnClickListener(onClickListener);
        }
        return this;
    }

    public C1288c m3105a(View view) {
        this.f2694n.removeAllViews();
        this.f2694n.setVisibility(0);
        this.f2694n.addView(view, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        ((LinearLayout.LayoutParams) this.f2694n.getLayoutParams()).weight = 1.0f;
        return this;
    }

    public C1288c m3106a(BaseAdapter baseAdapter, int i, OnItemClickListener onItemClickListener) {
        this.f2694n.setVisibility(0);
        this.f2694n.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f2692l.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f2692l.setChoiceMode(1);
        this.f2692l.setOnItemClickListener(onItemClickListener);
        this.f2692l.setVisibility(0);
        this.f2682b.setVisibility(8);
        this.f2692l.setAdapter(baseAdapter);
        if (i > -1) {
            this.f2692l.setSelection(i);
            this.f2692l.setItemChecked(i, true);
        }
        return this;
    }

    public C1288c m3107a(OnDismissListener onDismissListener) {
        this.f2703w = onDismissListener;
        return this;
    }

    public C1288c mo2528a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f2682b.setVisibility(8);
        } else {
            this.f2682b.setVisibility(0);
            this.f2694n.setVisibility(0);
            this.f2682b.setText(charSequence);
            int i = (int) (((double) C1148d.m2500a((WindowManager) m3100a().getSystemService("window")).y) * 0.4d);
            this.f2682b.measure(MeasureSpec.makeMeasureSpec(this.f2691k.getLayoutParams().width, 1073741824), MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
            if (this.f2682b.getMeasuredHeight() >= i) {
                this.f2695o.getLayoutParams().height = i;
            }
        }
        return this;
    }

    public C1288c m3109a(String str) {
        if (TextUtils.isEmpty(str) && this.f2693m.getDrawable() == null) {
            this.f2688h.setVisibility(8);
        } else {
            this.f2688h.setVisibility(0);
        }
        this.f2681a.setText(str);
        return this;
    }

    public C1288c m3110a(String str, OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f2698r.setVisibility(8);
        } else {
            this.f2698r.setText(str.toUpperCase());
            this.f2698r.setVisibility(0);
        }
        this.f2701u = onClickListener;
        return this;
    }

    public C1288c m3111a(boolean z) {
        this.f2675B = z;
        return this;
    }

    public C1288c m3112a(final String[] strArr, int i, final Drawable[] drawableArr, OnItemClickListener onItemClickListener, final boolean z) {
        return strArr == null ? this : m3106a(new BaseAdapter(this) {
            final /* synthetic */ C1288c f2673d;

            public int getCount() {
                return strArr.length;
            }

            public Object getItem(int i) {
                return strArr[i];
            }

            public long getItemId(int i) {
                return (long) i;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View checkedTextView;
                if (view == null) {
                    Resources resources = this.f2673d.m3100a().getResources();
                    int dimensionPixelSize = resources.getDimensionPixelSize(C1160d.alert_dialog_single_choice_checked_mark_padding);
                    int dimensionPixelSize2 = resources.getDimensionPixelSize(C1160d.alert_dialog_single_choice_checked_mark_height);
                    checkedTextView = new CheckedTextView(this.f2673d.m3100a());
                    int i2 = C1161e.btn_check_holo_light;
                    if (!z) {
                        i2 = C1161e.transparent;
                    }
                    checkedTextView.setCheckMarkDrawable(i2);
                    checkedTextView.setGravity(16);
                    checkedTextView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    checkedTextView.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize2));
                    checkedTextView.setTextSize(20.0f);
                    checkedTextView.setSingleLine();
                } else {
                    checkedTextView = view;
                }
                CheckedTextView checkedTextView2 = (CheckedTextView) checkedTextView;
                checkedTextView2.setText(strArr[i]);
                if (drawableArr != null && i < drawableArr.length) {
                    checkedTextView2.setCompoundDrawablesWithIntrinsicBounds(drawableArr[i], null, null, null);
                }
                return checkedTextView;
            }
        }, i, onItemClickListener);
    }

    public C1288c m3113b(int i) {
        return m3103a(m3100a().getResources().getDrawable(i));
    }

    public C1288c m3114b(int i, OnClickListener onClickListener) {
        return m3116b(m3100a().getString(i), onClickListener);
    }

    public C1288c m3115b(View view) {
        ((ViewGroup) this.f2691k).removeAllViews();
        this.f2691k.setBackgroundColor(0);
        ((CardView) this.f2691k).setCardBackgroundColor(0);
        ((CardView) this.f2691k).setPreventCornerOverlap(false);
        ((CardView) this.f2691k).setCardElevation(0.0f);
        ((CardView) this.f2691k).setRadius(0.0f);
        ((ViewGroup) this.f2691k).addView(view);
        return this;
    }

    public C1288c m3116b(String str, OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f2697q.setVisibility(8);
        } else {
            this.f2697q.setText(str.toUpperCase());
            this.f2697q.setVisibility(0);
        }
        this.f2700t = onClickListener;
        return this;
    }

    public C1288c m3117b(boolean z) {
        this.f2704x = z;
        return this;
    }

    public void mo2529b() {
        Resources resources = m3100a().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float min = (float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int ceil = (int) Math.ceil((double) (min / displayMetrics.density));
        this.f2687g = LayoutInflater.from(m3100a()).inflate(C1163g.custom_dialog_holo, null);
        this.f2689i = mo2530g(C1162f.custom_dialog_animView);
        this.f2690j = mo2530g(C1162f.custom_dialog_panelLayout);
        this.f2691k = mo2530g(C1162f.custom_dialog_parentPanel);
        this.f2688h = mo2530g(C1162f.custom_dialog_topPanel);
        this.f2693m = (ImageView) mo2530g(C1162f.custom_dialog_icon);
        this.f2681a = (TextView) mo2530g(C1162f.custom_dialog_title);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f2691k.getLayoutParams();
        float f = (min - ((float) marginLayoutParams.leftMargin)) - ((float) marginLayoutParams.rightMargin);
        if (ceil > 380 && ceil <= MediaSet.MEDIAITEM_BATCH_FETCH_COUNT) {
            f = (float) resources.getDimensionPixelSize(C1160d.alert_dialog_max_width);
        } else if (ceil > MediaSet.MEDIAITEM_BATCH_FETCH_COUNT) {
            f = (float) Math.ceil((double) (0.7f * min));
        }
        marginLayoutParams.width = (int) f;
        this.f2692l = (ListView) mo2530g(C1162f.custom_dialog_list);
        this.f2682b = (TextView) mo2530g(C1162f.custom_dialog_message);
        this.f2695o = (ScrollView) mo2530g(C1162f.custom_dialog_scrollView);
        this.f2694n = (LinearLayout) mo2530g(C1162f.custom_dialog_middlePanel);
        this.f2697q = (TextView) mo2530g(C1162f.custom_dialog_ok);
        this.f2699s = (TextView) mo2530g(C1162f.custom_dialog_mid_button);
        this.f2698r = (TextView) mo2530g(C1162f.custom_dialog_cancel);
        this.f2697q.setOnClickListener(this);
        this.f2699s.setOnClickListener(this);
        this.f2698r.setOnClickListener(this);
        this.f2687g.setFocusableInTouchMode(true);
        this.f2687g.setFocusable(true);
        this.f2687g.requestFocus();
        this.f2691k.setOnClickListener(this);
        this.f2687g.setOnClickListener(new C12811(this));
        this.f2687g.setOnKeyListener(new C12822(this));
        this.f2705y = AnimationUtils.loadAnimation(m3100a(), 17432576);
        this.f2705y.setDuration(300);
        this.f2706z = AnimationUtils.loadAnimation(m3100a(), C1157a.custom_dialog_appear);
        this.f2674A = AnimationUtils.loadAnimation(m3100a(), C1157a.custom_dialog_disappear);
        this.f2706z.setAnimationListener(this.f2680G);
        this.f2674A.setAnimationListener(this.f2680G);
        this.f2684d = (WindowManager) m3100a().getSystemService("window");
        this.f2685e = new LayoutParams();
        this.f2685e.type = 1000;
        this.f2685e.format = 1;
        this.f2685e.flags = 32;
        this.f2685e.format = -3;
        this.f2685e.height = -1;
        this.f2685e.width = -1;
        this.f2685e.gravity = 17;
        this.f2685e.softInputMode = 16;
        m3128f(C1166j.custom_dialog_holo_light);
    }

    public C1288c m3119c(boolean z) {
        this.f2678E = z;
        return this;
    }

    public void m3120c(@DrawableRes int i) {
        this.f2681a.setPadding(0, 0, 0, 0);
        this.f2688h.setVisibility(0);
        this.f2693m.setAdjustViewBounds(true);
        this.f2693m.setImageResource(i);
        this.f2693m.setVisibility(0);
    }

    public boolean m3121c() {
        return (this.f2687g == null || this.f2687g.getParent() == null) ? false : true;
    }

    public synchronized C1288c m3122d() {
        C1288c c1288c;
        this.f2677D = false;
        if (this.f2683c == null) {
            this.f2683c = this.f2686f.getWindow().getDecorView();
        }
        if ((this.f2686f == null || !this.f2686f.isFinishing()) && this.f2683c != null) {
            if (this.f2684d == null) {
                mo2529b();
            }
            if (!m3121c()) {
                this.f2683c.post(this.f2679F);
            }
            c1288c = this;
        } else {
            c1288c = this;
        }
        return c1288c;
    }

    public C1288c m3123d(int i) {
        return mo2528a(m3100a().getString(i));
    }

    @Deprecated
    public void m3124d(boolean z) {
    }

    public void m3125e() {
        this.f2677D = true;
        if (this.f2684d != null && m3121c() && !this.f2676C) {
            this.f2687g.post(new C12833(this));
        }
    }

    public void m3126e(int i) {
        ((FrameLayout.LayoutParams) this.f2691k.getLayoutParams()).leftMargin = i;
        ((FrameLayout.LayoutParams) this.f2691k.getLayoutParams()).rightMargin = i;
    }

    @Deprecated
    public void m3127e(boolean z) {
    }

    public void m3128f(int i) {
        if (i != 0) {
            Resources resources = m3100a().getResources();
            TypedArray obtainStyledAttributes = m3100a().obtainStyledAttributes(i, C1167k.CustomDialog);
            ((CardView) this.f2691k).setCardBackgroundColor(ResourcesCompat.getColor(resources, obtainStyledAttributes.getResourceId(C1167k.CustomDialog_dialogFullBackgroundColor, C1159c.cardview_light_background), null));
            this.f2681a.setTextColor(obtainStyledAttributes.getColor(C1167k.CustomDialog_dialogTitleTextColor, ResourcesCompat.getColor(resources, C1159c.Theme_Default_textColorHoloBlue, null)));
            this.f2681a.setShadowLayer(1.0f, 0.0f, 1.0f, obtainStyledAttributes.getColor(C1167k.CustomDialog_dialogTitleShadowColor, ResourcesCompat.getColor(resources, C1159c.Theme_Default_textColorHoloBlue, null)));
            this.f2682b.setTextColor(obtainStyledAttributes.getColor(C1167k.CustomDialog_dialogMessageTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f2698r.setTextColor(obtainStyledAttributes.getColor(C1167k.CustomDialog_dialogLeftButtonTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f2698r.setBackgroundResource(obtainStyledAttributes.getResourceId(C1167k.CustomDialog_dialogLeftButtonBackground, C1161e.background_button_flat));
            this.f2699s.setTextColor(obtainStyledAttributes.getColor(C1167k.CustomDialog_dialogMiddleButtonTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f2699s.setBackgroundResource(obtainStyledAttributes.getResourceId(C1167k.CustomDialog_dialogMiddleButtonBackground, C1161e.background_button_flat));
            this.f2697q.setTextColor(obtainStyledAttributes.getColor(C1167k.CustomDialog_dialogRightButtonTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f2699s.setBackgroundResource(obtainStyledAttributes.getResourceId(C1167k.CustomDialog_dialogRightButtonBackground, C1161e.background_button_flat));
            obtainStyledAttributes.recycle();
        }
    }

    public void onClick(View view) {
        if (view == this.f2697q) {
            m3125e();
            this.f2696p = this.f2700t;
        } else if (view == this.f2698r) {
            m3125e();
            this.f2696p = this.f2701u;
        } else if (view == this.f2699s) {
            m3125e();
            this.f2696p = this.f2702v;
        }
    }
}
