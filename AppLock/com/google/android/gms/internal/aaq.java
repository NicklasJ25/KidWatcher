package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@wh
class aaq extends aar implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> f7657a;

    public aaq(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f7657a = new WeakReference(onScrollChangedListener);
    }

    protected void mo3382a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    protected void mo3383b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f7657a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            m8464b();
        }
    }
}
