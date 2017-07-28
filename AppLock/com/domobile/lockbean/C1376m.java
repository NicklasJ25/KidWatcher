package com.domobile.lockbean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.applock.VerifyActivity;
import com.domobile.applock.theme.C1084a;
import com.domobile.applock.theme.C1102c;
import com.domobile.applock.theme.DefaultNumBoardInitialer;
import com.domobile.imagelock.LockPatternView;

public class C1376m extends C0960e implements OnClickListener {
    public boolean f2989f;
    private View f2990g;
    private C1084a f2991h;
    private LockPatternView f2992i;
    private TextView f2993j;

    public C1376m(Context context, View view, boolean z) {
        this(context, view, z, false);
    }

    public C1376m(Context context, View view, boolean z, boolean z2) {
        this.f2989f = false;
        this.a = context;
        this.b = view;
        this.e = z;
        this.f2989f = z2;
        this.f2991h = this.f2989f ? new DefaultNumBoardInitialer() : C1102c.m2401d(this.a);
        if (this.b != null) {
            m3493a(this.b);
        }
    }

    public void m3491a() {
        if (this.a instanceof Activity) {
            Activity activity = (Activity) this.a;
            Intent intent = new Intent(this.a, VerifyActivity.class);
            if (activity.getIntent().getExtras() != null) {
                intent.putExtras(activity.getIntent().getExtras());
            }
            intent.putExtra("FORCE_NUMLOCK", true);
            intent.putExtra("FORCE_PATTERN", false);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public void m3492a(int i) {
        if (this.f2993j != null) {
            this.f2993j.setText(i);
        }
    }

    public void m3493a(View view) {
        this.b = view;
        this.c = (ImageView) m1732b((int) R.id.numboard_appicon_imageview);
        this.f2993j = (TextView) m1732b((int) R.id.pattern_board_headerText);
        this.f2992i = (LockPatternView) m1732b((int) R.id.pattern_board_patternview);
        this.f2992i.setForceKeepOriginTheme(this.f2989f);
        this.c.setImageResource(R.drawable.icon);
        m1734c(R.string.app_name);
        this.f2990g = m1732b((int) R.id.pattern_board_change_to_number_lock_button);
        if (this.f2990g != null) {
            this.f2990g.setOnClickListener(this);
        }
        this.f2991h.mo2483a(this.a, this, this.e, new Object[0]);
    }

    public View m3494b() {
        return this.f2990g;
    }

    public LockPatternView m3495c() {
        return this.f2992i;
    }

    public void m3496c(String str) {
        if (this.f2993j != null) {
            this.f2993j.setText(str);
        }
    }

    public void m3497d(int i) {
        if (this.f2993j != null) {
            this.f2993j.setTextColor(i);
        }
    }

    public void m3498e(int i) {
        if (this.f2993j != null) {
            this.f2993j.setVisibility(i);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.pattern_board_change_to_number_lock_button) {
            m3491a();
        }
    }
}
