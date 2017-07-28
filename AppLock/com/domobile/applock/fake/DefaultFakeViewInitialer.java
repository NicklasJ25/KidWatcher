package com.domobile.applock.fake;

import android.content.Context;
import android.view.View;
import com.domobile.applock.R;
import com.domobile.lockbean.C0964f;

public class DefaultFakeViewInitialer implements C0906c {
    public View mo2438a(View view) {
        return null;
    }

    public void mo2439a(Context context, View view, String str, final Object... objArr) {
        view.postDelayed(new Runnable(this) {
            final /* synthetic */ DefaultFakeViewInitialer f1361b;

            public void run() {
                if (objArr.length > 0 && (objArr[0] instanceof C0964f)) {
                    ((C0964f) objArr[0]).mo2466b();
                }
            }
        }, 50);
    }

    public void mo2440b(View view) {
        view.findViewById(R.id.verify_fakeview).setVisibility(8);
    }
}
