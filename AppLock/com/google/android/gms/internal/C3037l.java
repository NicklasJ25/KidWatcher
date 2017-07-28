package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2475n;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.internal.C3424x.C3421a;

public final class C3037l<O extends C2416a> extends C2475n<O> {
    private final C2451f f9688b;
    private final C2977i f9689c;
    private final C2539m f9690d;
    private final C2448b<? extends em, en> f9691e;

    public C3037l(@NonNull Context context, C2456a<O> c2456a, Looper looper, @NonNull C2451f c2451f, @NonNull C2977i c2977i, C2539m c2539m, C2448b<? extends em, en> c2448b) {
        super(context, c2456a, looper);
        this.f9688b = c2451f;
        this.f9689c = c2977i;
        this.f9690d = c2539m;
        this.f9691e = c2448b;
        this.a.m14660a((C2475n) this);
    }

    public C2451f mo3815a(Looper looper, C3421a<O> c3421a) {
        this.f9689c.m11640a((C2996j) c3421a);
        return this.f9688b;
    }

    public ap mo3816a(Context context, Handler handler) {
        return new ap(context, handler, this.f9690d, this.f9691e);
    }

    public C2451f m12278f() {
        return this.f9688b;
    }
}
