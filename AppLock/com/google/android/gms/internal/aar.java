package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@wh
abstract class aar {
    private final WeakReference<View> f7655a;

    public aar(View view) {
        this.f7655a = new WeakReference(view);
    }

    public final void m8462a() {
        ViewTreeObserver c = m8466c();
        if (c != null) {
            mo3382a(c);
        }
    }

    protected abstract void mo3382a(ViewTreeObserver viewTreeObserver);

    public final void m8464b() {
        ViewTreeObserver c = m8466c();
        if (c != null) {
            mo3383b(c);
        }
    }

    protected abstract void mo3383b(ViewTreeObserver viewTreeObserver);

    protected ViewTreeObserver m8466c() {
        View view = (View) this.f7655a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        return (viewTreeObserver == null || !viewTreeObserver.isAlive()) ? null : viewTreeObserver;
    }
}
