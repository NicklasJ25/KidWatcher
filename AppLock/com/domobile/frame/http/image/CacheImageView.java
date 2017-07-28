package com.domobile.frame.http.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.frame.p000a.C1257b.C0422e;
import com.domobile.frame.p000a.C1257b.C1254d;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p016c.C1170b;
import java.io.File;

public class CacheImageView extends ImageView implements C0421b, C1254d, C0422e {
    private Drawable f2629a;
    private C0421b f2630b;
    private C0422e f2631c;
    private C1254d f2632d;
    private boolean f2633e = false;
    private boolean f2634f = true;

    public CacheImageView(Context context) {
        super(context);
        this.f2629a = ResourcesCompat.getDrawable(context.getResources(), C1161e.transparent, null);
    }

    public CacheImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CacheImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public CacheImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public BitmapDrawable mo2069a(Object obj) {
        try {
            if (this.f2630b != null) {
                return this.f2630b.mo2069a(obj);
            }
            if (obj instanceof Uri) {
                return C1257b.m2966a(getContext().getApplicationContext()).m2978a((Uri) obj);
            }
            return null;
        } catch (Exception e) {
        }
    }

    public CacheImageView m3043a(Drawable drawable) {
        this.f2629a = drawable;
        return this;
    }

    public CacheImageView m3044a(C0421b c0421b) {
        this.f2630b = c0421b;
        return this;
    }

    public CacheImageView m3045a(C0422e c0422e) {
        this.f2631c = c0422e;
        return this;
    }

    public CacheImageView m3046a(boolean z) {
        this.f2633e = z;
        return this;
    }

    public boolean m3047a() {
        return this.f2633e;
    }

    public boolean mo2525a(BitmapDrawable bitmapDrawable) {
        return this.f2632d != null && this.f2632d.mo2525a(bitmapDrawable);
    }

    public boolean mo2070a(CacheImageView cacheImageView, BitmapDrawable bitmapDrawable) {
        return this.f2631c != null && this.f2631c.mo2070a(cacheImageView, bitmapDrawable);
    }

    public BitmapDrawable mo2526b(Object obj) {
        return this.f2632d != null ? this.f2632d.mo2526b(obj) : null;
    }

    public void m3051b() {
        C1257b.m2966a(getAppContext()).m2982a(this, getTag());
    }

    public void m3052b(boolean z) {
        this.f2634f = z;
    }

    public File mo2527c(Object obj) {
        if (this.f2632d != null) {
            return this.f2632d.mo2527c(obj);
        }
        try {
            if (this.f2634f && (obj instanceof Uri)) {
                return C1257b.m2967a(getAppContext(), C1170b.m2685b(obj.toString()));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Context getAppContext() {
        return super.getContext().getApplicationContext();
    }

    public C0421b getDecoder() {
        return this.f2630b;
    }

    public Drawable getPlaceHolder() {
        return this.f2629a;
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
            try {
                m3051b();
            } catch (Exception e2) {
            }
        }
    }

    public void setImage(Object obj) {
        setTag(obj);
        C1257b.m2966a(getAppContext()).m2982a(this, obj);
    }
}
