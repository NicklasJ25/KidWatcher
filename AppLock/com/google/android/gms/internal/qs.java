package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.rd.C3178a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public class qs extends C3178a {
    private final Drawable f10369a;
    private final Uri f10370b;
    private final double f10371c;

    public qs(Drawable drawable, Uri uri, double d) {
        this.f10369a = drawable;
        this.f10370b = uri;
        this.f10371c = d;
    }

    public C2309a mo3919a() {
        return C2312b.m7327a(this.f10369a);
    }

    public Uri mo3920b() {
        return this.f10370b;
    }

    public double mo3921c() {
        return this.f10371c;
    }
}
