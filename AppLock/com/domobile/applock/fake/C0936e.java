package com.domobile.applock.fake;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.domobile.applock.C1140x.C1139g;
import com.domobile.applock.R;
import com.domobile.frame.C0415f;

public class C0936e extends FrameLayout implements OnClickListener {
    public TextView f1438a;
    private View f1439b;
    private View f1440c;
    private LinearLayout f1441d;
    private View f1442e;
    private OnClickListener f1443f;
    private Button f1444g;
    private OnClickListener f1445h;
    private Animation f1446i;
    private Animation f1447j;
    private Animation f1448k;
    private boolean f1449l = false;
    private boolean f1450m = false;
    private int f1451n = R.drawable.dialog_btn_single_holo_light;
    private C0415f f1452o = new C09352(this);

    class C09341 implements Runnable {
        final /* synthetic */ C0936e f1436a;

        C09341(C0936e c0936e) {
            this.f1436a = c0936e;
        }

        public void run() {
            this.f1436a.f1439b.startAnimation(this.f1436a.f1448k);
        }
    }

    class C09352 extends C0415f {
        final /* synthetic */ C0936e f1437a;

        C09352(C0936e c0936e) {
            this.f1437a = c0936e;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1437a.f1449l = false;
            if (animation == this.f1437a.f1447j) {
                if (this.f1437a.f1450m) {
                    this.f1437a.m1668c();
                }
            } else if (animation == this.f1437a.f1448k) {
                this.f1437a.m1660e();
                if (this.f1437a.f1443f != null) {
                    this.f1437a.f1443f.onClick(null);
                }
                this.f1437a.f1443f = null;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (animation == this.f1437a.f1448k) {
                this.f1437a.f1449l = true;
            }
        }
    }

    public C0936e(Context context) {
        super(context);
        m1666a();
    }

    private void m1658d() {
        int i = this.f1451n;
        if (VERSION.SDK_INT < 21) {
            this.f1444g.setBackgroundResource(i);
        }
    }

    private void m1660e() {
        setVisibility(8);
    }

    public C0936e m1663a(int i, OnClickListener onClickListener) {
        return m1665a(getContext().getString(i), onClickListener);
    }

    public C0936e m1664a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f1438a.setVisibility(8);
        } else {
            this.f1438a.setVisibility(0);
            this.f1438a.setText(charSequence);
        }
        return this;
    }

    public C0936e m1665a(String str, OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f1444g.setVisibility(8);
        } else {
            this.f1444g.setText(str);
            this.f1444g.setVisibility(0);
        }
        this.f1445h = onClickListener;
        return this;
    }

    public void m1666a() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float min = (float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int ceil = (int) Math.ceil((double) (min / displayMetrics.density));
        addView(LayoutInflater.from(getContext()).inflate(R.layout.fake_fc_dialog, null));
        this.f1439b = findViewById(R.id.custom_dialog_animView);
        this.f1440c = findViewById(R.id.custom_dialog_parentPanel);
        if (ceil > 380 && ceil < 514) {
            this.f1440c.getLayoutParams().width = getContext().getResources().getDimensionPixelSize(R.dimen.alert_dialog_max_width);
        } else if (ceil >= 514) {
            this.f1440c.getLayoutParams().width = (int) Math.ceil((double) (0.7f * min));
        }
        this.f1438a = (TextView) findViewById(R.id.custom_dialog_message);
        this.f1441d = (LinearLayout) findViewById(R.id.custom_dialog_middlePanel);
        this.f1442e = findViewById(R.id.custom_dialog_bottomDivider);
        this.f1444g = (Button) findViewById(R.id.custom_dialog_ok);
        this.f1444g.setOnClickListener(this);
        this.f1446i = AnimationUtils.loadAnimation(getContext(), 17432576);
        this.f1446i.setDuration(300);
        this.f1447j = AnimationUtils.loadAnimation(getContext(), R.anim.custom_dialog_appear);
        this.f1448k = AnimationUtils.loadAnimation(getContext(), R.anim.custom_dialog_disappear);
        this.f1447j.setAnimationListener(this.f1452o);
        this.f1448k.setAnimationListener(this.f1452o);
        if (VERSION.SDK_INT < 21) {
            setDialogStyle(R.style.custom_dialog_holo_dark);
        }
    }

    public synchronized C0936e m1667b() {
        this.f1450m = false;
        m1658d();
        this.f1439b.startAnimation(this.f1447j);
        return this;
    }

    public void m1668c() {
        this.f1450m = true;
        if (!this.f1449l) {
            post(new C09341(this));
        }
    }

    public Button getOkButton() {
        return this.f1444g;
    }

    public void onClick(View view) {
        if (view == this.f1444g) {
            m1668c();
            this.f1443f = this.f1445h;
        }
    }

    public void setDialogStyle(int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C1139g.CustomDialog);
            this.f1438a.setTextColor(obtainStyledAttributes.getColor(4, ContextCompat.getColor(getContext(), 17170444)));
            this.f1442e.setBackgroundResource(obtainStyledAttributes.getResourceId(5, R.drawable.list_divider_holo_light));
            this.f1451n = obtainStyledAttributes.getResourceId(7, R.drawable.dialog_btn_single_holo_light);
            this.f1444g.setTextColor(obtainStyledAttributes.getColor(13, ContextCompat.getColor(getContext(), 17170444)));
            obtainStyledAttributes.recycle();
        }
    }

    public void setMarginHorizontal(int i) {
        ((LayoutParams) this.f1440c.getLayoutParams()).leftMargin = i;
        ((LayoutParams) this.f1440c.getLayoutParams()).rightMargin = i;
    }

    public void setShowBottomDivider(boolean z) {
        this.f1442e.setVisibility(z ? 0 : 8);
    }
}
