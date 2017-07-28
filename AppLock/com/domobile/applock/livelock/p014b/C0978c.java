package com.domobile.applock.livelock.p014b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.LruCache;
import android.widget.FrameLayout.LayoutParams;
import com.domobile.applock.C1140x.C1139g;

@TargetApi(14)
public class C0978c {
    private static C0978c f1604a;
    private final C0977a f1605b = new C0977a(((int) Runtime.getRuntime().maxMemory()) / 8);
    private String f1606c;
    private Resources f1607d;
    private String f1608e = "hdpi";

    public static class C0977a extends LruCache<String, Bitmap> {
        public C0977a(int i) {
            super(i);
        }

        protected int m1847a(String str, Bitmap bitmap) {
            return (bitmap == null || bitmap.isRecycled()) ? super.sizeOf(str, bitmap) : bitmap.getWidth() * bitmap.getHeight();
        }

        protected void m1848a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            if (z && bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            m1848a(z, (String) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m1847a((String) obj, (Bitmap) obj2);
        }
    }

    private C0978c() {
    }

    public static synchronized C0978c m1849a() {
        C0978c c0978c;
        synchronized (C0978c.class) {
            if (f1604a == null) {
                f1604a = new C0978c();
            }
            c0978c = f1604a;
        }
        return c0978c;
    }

    @NonNull
    public static Resources m1850b(@NonNull Context context, @NonNull String str) {
        try {
            return context.getPackageManager().getResourcesForApplication(str);
        } catch (NameNotFoundException e) {
            return context.getResources();
        }
    }

    @Nullable
    public Bitmap m1851a(String str) {
        Bitmap bitmap = (Bitmap) this.f1605b.get(str);
        if (bitmap == null) {
            bitmap = m1855b(str);
            if (bitmap != null) {
                this.f1605b.put(str, bitmap);
            }
        }
        return bitmap;
    }

    @Nullable
    public Bitmap m1852a(String str, Options options) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(this.f1607d.openRawResource(this.f1607d.getIdentifier(str, "drawable", this.f1606c)), null, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public LayoutParams m1853a(boolean z) {
        int identifier = this.f1607d.getIdentifier(z ? "style_appicon_decorview_land" : "style_appicon_decorview_port", "style", this.f1606c);
        this.f1607d.getResourceName(identifier);
        TypedArray obtainStyledAttributes = this.f1607d.newTheme().obtainStyledAttributes(identifier, C1139g.CustomeUnlockSkinView);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(16, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(17, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(18, 0);
        obtainStyledAttributes.recycle();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.topMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize3;
        layoutParams.bottomMargin = dimensionPixelSize4;
        return layoutParams;
    }

    public void m1854a(Context context, String str) {
        this.f1606c = str;
        this.f1607d = C0978c.m1850b(context, str);
    }

    @Nullable
    public Bitmap m1855b(String str) {
        try {
            return BitmapFactory.decodeStream(this.f1607d.openRawResource(this.f1607d.getIdentifier(str, "drawable", this.f1606c)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void m1856b() {
        this.f1605b.evictAll();
    }

    @Nullable
    public Drawable m1857c(String str) {
        Drawable drawable = null;
        try {
            drawable = ResourcesCompat.getDrawable(this.f1607d, this.f1607d.getIdentifier(str, "drawable", this.f1606c), null);
        } catch (Exception e) {
        }
        return drawable;
    }

    public LayoutParams m1858c() {
        int identifier = this.f1607d.getIdentifier("style_appicon_imageview", "style", this.f1606c);
        this.f1607d.getResourceName(identifier);
        TypedArray obtainStyledAttributes = this.f1607d.newTheme().obtainStyledAttributes(identifier, C1139g.CustomeUnlockSkinView);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(13, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(16, 0);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(17, 0);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(18, 0);
        obtainStyledAttributes.recycle();
        LayoutParams layoutParams = new LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.leftMargin = dimensionPixelSize3;
        layoutParams.topMargin = dimensionPixelSize4;
        layoutParams.rightMargin = dimensionPixelSize5;
        layoutParams.bottomMargin = dimensionPixelSize6;
        return layoutParams;
    }

    public Rect m1859d() {
        Rect rect = new Rect();
        try {
            int identifier = this.f1607d.getIdentifier("style_password_bg", "style", this.f1606c);
            this.f1607d.getResourceName(identifier);
            TypedArray obtainStyledAttributes = this.f1607d.newTheme().obtainStyledAttributes(identifier, C1139g.CustomeUnlockSkinView);
            rect.left = obtainStyledAttributes.getDimensionPixelSize(7, 0);
            rect.right = obtainStyledAttributes.getDimensionPixelSize(9, 0);
            rect.top = obtainStyledAttributes.getDimensionPixelSize(8, 0);
            rect.bottom = obtainStyledAttributes.getDimensionPixelSize(10, 0);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
        }
        return rect;
    }
}
