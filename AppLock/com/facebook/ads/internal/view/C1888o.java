package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C1888o extends View {
    private C1887n f4770a;

    public C1888o(Context context, C1887n c1887n) {
        super(context);
        this.f4770a = c1887n;
        setLayoutParams(new LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i) {
        if (this.f4770a != null) {
            this.f4770a.mo2841a(i);
        }
    }
}
