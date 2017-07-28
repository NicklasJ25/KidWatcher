package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.firebase.C3531b;
import java.util.concurrent.atomic.AtomicReference;

public class lk {
    private static final AtomicReference<lk> f9716a = new AtomicReference();

    lk(Context context) {
    }

    public static lk m12322a(Context context) {
        f9716a.compareAndSet(null, new lk(context));
        return (lk) f9716a.get();
    }

    public void m12323a(@NonNull C3531b c3531b) {
    }
}
