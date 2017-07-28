package com.domobile.applock.fake;

import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0933d.C0926b;
import com.domobile.applock.fake.C0933d.C0932a;
import com.domobile.lockbean.C0964f;

public class FCFakeViewInitialer implements C0906c {
    public View mo2438a(View view) {
        return view.findViewById(R.id.fake_fc_teach);
    }

    public void mo2439a(Context context, View view, String str, Object... objArr) {
        final Context context2 = context;
        final String str2 = str;
        final View view2 = view;
        final Object[] objArr2 = objArr;
        view.postDelayed(new Runnable(this) {
            final /* synthetic */ FCFakeViewInitialer f1366e;

            public void run() {
                View c0936e = new C0936e(context2);
                c0936e.setLayoutParams(new LayoutParams(-1, -1));
                c0936e.m1664a(context2.getString(R.string.aerr_application, new Object[]{C0964f.m1755a(context2, str2)})).m1663a(17039370, null);
                ((ViewGroup) view2.findViewById(R.id.verify_fakeview)).addView(c0936e);
                View findViewById = view2.findViewById(R.id.verify_foreground1);
                View findViewById2 = view2.findViewById(R.id.verify_foreground2);
                OnTouchListener c0932a;
                if (objArr2.length <= 0 || !(objArr2[0] instanceof C0926b)) {
                    c0932a = new C0932a(new C0926b(context2, c0936e));
                    c0936e.getOkButton().setOnTouchListener(c0932a);
                    findViewById.setOnTouchListener(c0932a);
                    findViewById2.setOnTouchListener(c0932a);
                } else {
                    C0926b c0926b = (C0926b) objArr2[0];
                    c0932a = new C0932a(c0926b);
                    c0936e.getOkButton().setOnTouchListener(c0932a);
                    findViewById.setOnTouchListener(c0932a);
                    findViewById2.setOnTouchListener(c0932a);
                    c0926b.f1411c = c0936e;
                }
                c0936e.m1667b();
            }
        }, 50);
    }

    public void mo2440b(View view) {
        int color = view.getResources().getColor(R.color.fc_fakeview_forground_color);
        view.findViewById(R.id.verify_foreground1).setBackgroundColor(color);
        view.findViewById(R.id.verify_foreground2).setBackgroundColor(color);
        view.findViewById(R.id.verify_fakeview).setVisibility(0);
    }
}
