package com.domobile.lockbean;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.theme.C1084a;
import com.domobile.applock.theme.C1102c;
import com.domobile.applock.theme.DefaultNumBoardInitialer;
import com.domobile.imagelock.C1318c;
import com.domobile.imagelock.LockPatternView;
import com.domobile.widget.NumBoardButton;
import java.util.ArrayList;
import java.util.Collections;

public class C1372k extends C0960e implements OnClickListener, OnLongClickListener {
    public static final int[] f2963f = new int[]{R.id.numboard_num0_button, R.id.numboard_num1_button, R.id.numboard_num2_button, R.id.numboard_num3_button, R.id.numboard_num4_button, R.id.numboard_num5_button, R.id.numboard_num6_button, R.id.numboard_num7_button, R.id.numboard_num8_button, R.id.numboard_num9_button};
    public static final int[] f2964g = new int[]{R.color.nums_color1, R.color.nums_color2, R.color.nums_color3, R.color.nums_color4, R.color.nums_color5, R.color.nums_color6, R.color.nums_color7, R.color.nums_color8, R.color.nums_color9, R.color.nums_color10, R.color.nums_color11};
    public int f2965h;
    private ImageButton f2966i;
    private ImageButton f2967j;
    private TextView f2968k;
    private ViewGroup f2969l;
    private ViewGroup f2970m;
    private View f2971n;
    private String f2972o;
    private boolean f2973p;
    private Vibrator f2974q;
    private C1084a f2975r;
    private boolean f2976s;
    private int f2977t;

    public C1372k(Context context, View view, int i) {
        this(context, view, i, false);
    }

    public C1372k(Context context, View view, int i, boolean z) {
        this.f2973p = false;
        this.f2965h = 0;
        this.f2975r = null;
        this.f2976s = true;
        this.f2977t = 0;
        this.b = view;
        this.a = context;
        this.e = z;
        this.f2965h = i;
        this.f2975r = i > 0 ? new DefaultNumBoardInitialer() : C1102c.m2401d(this.a);
        if (this.b != null) {
            m3458a(this.b);
        }
    }

    public static int m3456a(Context context) {
        int a = (int) C1150y.m2562a((long) C1150y.m2663y(context), 0, (long) (f2964g.length - 1));
        return a == 0 ? 0 : context.getResources().getColor(f2964g[a]);
    }

    public void m3457a(TextWatcher textWatcher) {
        this.f2968k.addTextChangedListener(textWatcher);
    }

    public void m3458a(View view) {
        this.b = view;
        this.f2972o = C1150y.m2620e(this.a);
        this.f2973p = C1318c.m3243a(this.a);
        this.f2974q = (Vibrator) this.a.getSystemService("vibrator");
        this.c = (ImageView) m1732b((int) R.id.numboard_appicon_imageview);
        this.d = (TextView) m1732b((int) R.id.numboard_appname_textview);
        this.f2968k = (TextView) m1732b((int) R.id.numboard_pwd_edittext);
        this.f2966i = (ImageButton) m1732b((int) R.id.numboard_sure_button);
        this.f2967j = (ImageButton) m1732b((int) R.id.numboard_exit_button);
        this.f2969l = (ViewGroup) m1732b((int) R.id.numboard_numslayout);
        this.f2970m = (ViewGroup) m1732b((int) R.id.numboard_infoslayout);
        this.f2971n = m1732b((int) R.id.numboard_whole_layout);
        m1732b((int) R.id.numboard_delete_button).setOnClickListener(this);
        m1732b((int) R.id.numboard_delete_button).setOnLongClickListener(this);
        for (int b : f2963f) {
            m1732b(b).setOnClickListener(this);
        }
        this.f2968k.setCursorVisible(false);
        this.f2968k.setFocusable(false);
        if (!TextUtils.isEmpty(C1150y.m2624f(this.a))) {
            this.f2968k.setHint(C1150y.m2624f(this.a));
        }
        this.c.setImageResource(R.drawable.icon);
        m1733b(this.a.getString(R.string.app_name));
        this.f2975r.mo2482a(this.a, this, this.e, new Object[0]);
        boolean z = m3461a() && this.f2965h == 0;
        m3460a(z);
    }

    public void m3459a(ArrayList<String> arrayList, ArrayList<BitmapDrawable> arrayList2) {
        int min = Math.min(arrayList.size(), f2963f.length);
        for (int i = 0; i < min; i++) {
            View b = m1732b(f2963f[i]);
            try {
                Object obj = (String) arrayList.get(i);
                ((NumBoardButton) b).m3539a(obj, (BitmapDrawable) arrayList2.get(Integer.parseInt(obj)));
            } catch (Exception e) {
                b.setTag(b);
            }
        }
    }

    public void m3460a(boolean z) {
        int i;
        if (this.f2965h <= 1 && this.f2975r.mo2485a()) {
            i = C1150y.m2566a(this.a).f439n;
            if (i != this.f2977t) {
                this.f2968k.getBackground().setColorFilter(i, Mode.SRC_ATOP);
                this.f2968k.setTextColor(i);
                this.f2968k.setHintTextColor(Color.argb(119, Color.red(i), Color.green(i), Color.blue(i)));
            }
        }
        if (this.f2976s || z) {
            this.f2976s = z;
            int length = f2963f.length;
            Object arrayList = new ArrayList();
            for (i = 0; i < length; i++) {
                arrayList.add(String.valueOf(i));
            }
            if (z) {
                Collections.shuffle(arrayList);
            }
            this.f2975r.mo2484a(this, arrayList);
        }
    }

    public boolean m3461a() {
        return C1150y.m2614c(this.a, "key_random_numboard") && C1150y.m2539D(this.a);
    }

    public void m3462b() {
        this.f2972o = C1150y.m2620e(this.a);
        this.f2973p = C1318c.m3243a(this.a);
    }

    public void m3463b(boolean z) {
        if (this.f2966i != null) {
            this.f2966i.setVisibility(z ? 0 : 8);
        }
    }

    public void m3464c() {
        for (int b : f2963f) {
            ((NumBoardButton) m1732b(b)).m3538a();
        }
    }

    public void m3465d() {
        this.f2968k.setText("");
    }

    public void m3466e() {
        if (this.f2968k.getTextColors() != null) {
            this.f2968k.setTextColor(this.f2968k.getTextColors().getDefaultColor());
        }
    }

    public void m3467f() {
        this.f2967j.setVisibility(8);
    }

    public void m3468g() {
        this.f2967j.setVisibility(0);
    }

    public String m3469j() {
        return this.f2968k.getText().toString();
    }

    public TextView m3470k() {
        return this.f2968k;
    }

    public View m3471l() {
        return this.f2971n;
    }

    public ViewGroup m3472m() {
        return this.f2970m;
    }

    public ViewGroup m3473n() {
        return this.f2969l;
    }

    public ImageButton m3474o() {
        return this.f2966i;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.numboard_num0_button:
            case R.id.numboard_num1_button:
            case R.id.numboard_num2_button:
            case R.id.numboard_num3_button:
            case R.id.numboard_num4_button:
            case R.id.numboard_num5_button:
            case R.id.numboard_num6_button:
            case R.id.numboard_num7_button:
            case R.id.numboard_num8_button:
            case R.id.numboard_num9_button:
                this.f2968k.append((String) view.getTag());
                if (this.f2973p) {
                    this.f2974q.vibrate(LockPatternView.f2779a, -1);
                    return;
                }
                return;
            case R.id.numboard_delete_button:
                String charSequence = this.f2968k.getText().toString();
                if (charSequence.length() > 0) {
                    this.f2968k.setText(charSequence.substring(0, charSequence.length() - 1));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean onLongClick(View view) {
        if (view.getId() == R.id.numboard_delete_button) {
            this.f2968k.setText("");
        }
        return false;
    }

    public ImageButton m3475p() {
        return this.f2967j;
    }
}
