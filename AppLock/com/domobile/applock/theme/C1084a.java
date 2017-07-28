package com.domobile.applock.theme;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.domobile.applock.R;
import com.domobile.lockbean.C1372k;
import com.domobile.lockbean.C1376m;
import java.util.ArrayList;

public abstract class C1084a {
    public static final int[] f2050a = new int[]{R.drawable.num_button0, R.drawable.num_button1, R.drawable.num_button2, R.drawable.num_button3, R.drawable.num_button4, R.drawable.num_button5, R.drawable.num_button6, R.drawable.num_button7, R.drawable.num_button8, R.drawable.num_button9};
    public String f2051b = null;
    public int f2052c = 0;

    public String mo2486a(Context context) {
        if (this.f2051b == null) {
            this.f2051b = C1102c.m2385a(context);
        }
        return this.f2051b;
    }

    public void mo2487a(Context context, View view, Resources resources, boolean z, boolean z2) {
    }

    public void mo2482a(Context context, C1372k c1372k, boolean z, Object... objArr) {
        this.f2052c = c1372k.f2965h;
    }

    public void mo2483a(Context context, C1376m c1376m, boolean z, Object... objArr) {
    }

    public abstract void mo2484a(C1372k c1372k, ArrayList<String> arrayList);

    public boolean mo2485a() {
        return false;
    }
}
