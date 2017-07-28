package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzw;
import java.lang.ref.WeakReference;

@wh
class aap extends aar implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> f7656a;

    public aap(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f7656a = new WeakReference(onGlobalLayoutListener);
    }

    protected void mo3382a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void mo3383b(ViewTreeObserver viewTreeObserver) {
        zzw.zzcO().mo4260a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f7656a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            m8464b();
        }
    }
}
