package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public class re extends Image {
    private final rd f10498a;
    private final Drawable f10499b;
    private final Uri f10500c;
    private final double f10501d;

    public re(rd rdVar) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.f10498a = rdVar;
        try {
            C2309a a = this.f10498a.mo3919a();
            if (a != null) {
                drawable = (Drawable) C2312b.m7328a(a);
                this.f10499b = drawable;
                uri = this.f10498a.mo3920b();
                this.f10500c = uri;
                d = 1.0d;
                d = this.f10498a.mo3921c();
                this.f10501d = d;
            }
        } catch (Throwable e) {
            aad.m8422b("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.f10499b = drawable;
        try {
            uri = this.f10498a.mo3920b();
        } catch (Throwable e2) {
            aad.m8422b("Failed to get uri.", e2);
        }
        this.f10500c = uri;
        d = 1.0d;
        try {
            d = this.f10498a.mo3921c();
        } catch (Throwable e3) {
            aad.m8422b("Failed to get scale.", e3);
        }
        this.f10501d = d;
    }

    public Drawable getDrawable() {
        return this.f10499b;
    }

    public double getScale() {
        return this.f10501d;
    }

    public Uri getUri() {
        return this.f10500c;
    }
}
