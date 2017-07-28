package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public final class mm {
    private final mq f9844a;

    public mm(String str, Context context, boolean z) {
        this.f9844a = mp.m12594a(str, context, z);
    }

    public Uri m12565a(Uri uri, Context context) {
        C2309a a = this.f9844a.mo3820a(C2312b.m7327a((Object) uri), C2312b.m7327a((Object) context));
        if (a != null) {
            return (Uri) C2312b.m7328a(a);
        }
        throw new mn();
    }

    public void m12566a(MotionEvent motionEvent) {
        this.f9844a.mo3831d(C2312b.m7327a((Object) motionEvent));
    }

    public Uri m12567b(Uri uri, Context context) {
        C2309a b = this.f9844a.mo3828b(C2312b.m7327a((Object) uri), C2312b.m7327a((Object) context));
        if (b != null) {
            return (Uri) C2312b.m7328a(b);
        }
        throw new mn();
    }
}
