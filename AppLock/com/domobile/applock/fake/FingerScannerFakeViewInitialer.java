package com.domobile.applock.fake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0933d.C0926b;
import com.domobile.applock.fake.C0933d.C0932a;

public class FingerScannerFakeViewInitialer implements C0906c {
    public View mo2438a(View view) {
        return view.findViewById(R.id.fake_view_teach);
    }

    public void mo2439a(Context context, View view, String str, Object... objArr) {
        ((ViewGroup) view.findViewById(R.id.verify_fakeview)).addView(LayoutInflater.from(context).inflate(R.layout.fake_view, null));
        final View findViewById = view.findViewById(R.id.verify_fake_logo);
        View findViewById2 = view.findViewById(R.id.fake_view_toplayout);
        if (objArr.length <= 0 || !(objArr[0] instanceof C0926b)) {
            OnTouchListener c0932a = new C0932a(null);
            findViewById2.setOnTouchListener(c0932a);
            findViewById.setOnTouchListener(c0932a);
        } else {
            OnTouchListener c0932a2 = new C0932a((C0926b) objArr[0]);
            findViewById.setOnTouchListener(c0932a2);
            findViewById2.setOnTouchListener(c0932a2);
        }
        view.postDelayed(new Runnable(this) {
            final /* synthetic */ FingerScannerFakeViewInitialer f1384b;

            public void run() {
                findViewById.setVisibility(0);
            }
        }, 50);
    }

    public void mo2440b(View view) {
        view.findViewById(R.id.verify_fakeview).setVisibility(0);
        view.findViewById(R.id.verify_foreground1).setBackgroundResource(R.drawable.scanning_background);
        view.findViewById(R.id.verify_foreground2).setBackgroundResource(R.drawable.scanning_background);
    }
}
