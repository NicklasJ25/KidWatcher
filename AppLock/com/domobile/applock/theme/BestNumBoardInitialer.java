package com.domobile.applock.theme;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.C1372k;
import com.domobile.lockbean.C1376m;
import com.domobile.widget.NumBoardButton;
import java.util.ArrayList;

public class BestNumBoardInitialer extends C1084a {
    private void m2318a(Context context, Resources resources, View view, String str, View view2, View view3) {
        C1102c.m2387a(context, resources, view3);
        C1102c.m2387a(context, resources, view2);
        View findViewById = view.findViewById(R.id.locker_board_more);
        if (findViewById != null) {
            ((ImageView) findViewById).setImageResource(R.drawable.toolbar_more);
            C1102c.m2387a(context, resources, findViewById);
        }
        C1102c.m2387a(context, resources, view.findViewById(R.id.locker_board_fingerprint));
    }

    private void m2319a(Context context, View view, int i, String str, Resources resources, int i2, boolean z) {
        View view2 = (ImageButton) view.findViewById(i);
        C1102c.m2389a(context, (ImageView) view2, str, i2);
        if (view2 instanceof NumBoardButton) {
            ((NumBoardButton) view2).setNeedDrawNumber(z);
            ((NumBoardButton) view2).setIgnoreCustomedColor(this.c > 1);
            return;
        }
        C1102c.m2387a(context, resources, view2);
    }

    public void mo2482a(Context context, C1372k c1372k, boolean z, Object... objArr) {
        super.mo2482a(context, c1372k, z, objArr);
        String a = mo2486a(context);
        Resources h = C1102c.m2410h(context, a);
        View h2 = c1372k.m1735h();
        boolean a2 = mo2485a();
        m2319a(context, h2, R.id.numboard_exit_button, a, h, R.drawable.num_button_exit, a2);
        m2319a(context, h2, R.id.numboard_back_button, a, h, R.drawable.num_button_exit, a2);
        m2319a(context, h2, R.id.numboard_delete_button, a, h, R.drawable.num_button_del, a2);
        View k = c1372k.m3470k();
        C1102c.m2387a(context, h, (View) k.getParent());
        C1102c.m2387a(context, h, k);
        C1102c.m2387a(context, h, c1372k.m3473n());
        m2318a(context, h, h2, a, h2.findViewById(R.id.numboard_appicon_slot), c1372k.m1736i());
        C1102c.m2387a(context, h, h2.findViewById(R.id.numboard_below_appinfo));
        C1102c.m2387a(context, h, h2.findViewById(R.id.numboard_whole_layout));
        mo2487a(context, h2, h, false, z);
    }

    public void mo2483a(Context context, C1376m c1376m, boolean z, Object... objArr) {
        super.mo2483a(context, c1376m, z, objArr);
        String a = mo2486a(context);
        Resources h = C1102c.m2410h(context, a);
        View h2 = c1376m.m1735h();
        m2318a(context, h, h2, a, h2.findViewById(R.id.numboard_appicon_slot), c1376m.m1736i());
        C1102c.m2387a(context, h, h2.findViewById(R.id.numboard_whole_layout));
        C1102c.m2387a(context, h, h2.findViewById(R.id.numboard_below_appinfo));
        C1102c.m2387a(context, h, h2.findViewById(R.id.pattern_board_patternview));
        mo2487a(context, h2, h, true, z);
    }

    public void mo2484a(C1372k c1372k, ArrayList<String> arrayList) {
        View h = c1372k.m1735h();
        Context context = h.getContext();
        String a = mo2486a(context);
        boolean a2 = mo2485a();
        int min = Math.min(arrayList.size(), C1372k.f2963f.length);
        for (int i = 0; i < min; i++) {
            View findViewById = h.findViewById(C1372k.f2963f[i]);
            try {
                String str = (String) arrayList.get(i);
                findViewById.setTag(str);
                int parseInt = Integer.parseInt(str);
                if (findViewById instanceof ImageButton) {
                    C1102c.m2389a(context, (ImageButton) findViewById, a, a[parseInt]);
                    if (a2 && (findViewById instanceof NumBoardButton)) {
                        ((NumBoardButton) findViewById).setNeedDrawNumber(true);
                        ((NumBoardButton) findViewById).setIgnoreCustomedColor(this.c > 1);
                    }
                } else {
                    ((Button) findViewById).setText(str);
                    C1148d.m2514a(findViewById, C1102c.m2395b(context, a, a[parseInt]));
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean mo2485a() {
        return false;
    }
}
