package com.google.android.gms.internal;

import com.google.android.gms.internal.wk.C3396a;
import com.google.android.gms.internal.wt.C3403a;
import java.lang.ref.WeakReference;

@wh
public final class wo extends C3403a {
    private final WeakReference<C3396a> f11195a;

    public wo(C3396a c3396a) {
        this.f11195a = new WeakReference(c3396a);
    }

    public void mo4187a(zzmn com_google_android_gms_internal_zzmn) {
        C3396a c3396a = (C3396a) this.f11195a.get();
        if (c3396a != null) {
            c3396a.mo4183a(com_google_android_gms_internal_zzmn);
        }
    }
}
