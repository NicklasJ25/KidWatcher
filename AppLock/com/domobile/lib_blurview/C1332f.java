package com.domobile.lib_blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

public final class C1332f implements C1328b {
    private final RenderScript f2874a;
    private final ScriptIntrinsicBlur f2875b;
    private Allocation f2876c;
    private int f2877d = -1;
    private int f2878e = -1;

    @RequiresApi(api = 17)
    public C1332f(Context context) {
        this.f2874a = RenderScript.create(context);
        this.f2875b = ScriptIntrinsicBlur.create(this.f2874a, Element.U8_4(this.f2874a));
    }

    private boolean m3300a(Bitmap bitmap) {
        return bitmap.getHeight() == this.f2878e && bitmap.getWidth() == this.f2877d;
    }

    @RequiresApi(api = 17)
    public final Bitmap mo2570a(Bitmap bitmap, float f) {
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f2874a, bitmap);
        if (!m3300a(bitmap)) {
            if (this.f2876c != null) {
                this.f2876c.destroy();
            }
            this.f2876c = Allocation.createTyped(this.f2874a, createFromBitmap.getType());
            this.f2877d = bitmap.getWidth();
            this.f2878e = bitmap.getHeight();
        }
        this.f2875b.setRadius(f);
        this.f2875b.setInput(createFromBitmap);
        this.f2875b.forEach(this.f2876c);
        this.f2876c.copyTo(bitmap);
        createFromBitmap.destroy();
        return bitmap;
    }

    public final void mo2571a() {
        this.f2875b.destroy();
        this.f2874a.destroy();
        if (this.f2876c != null) {
            this.f2876c.destroy();
        }
    }

    @NonNull
    public Config mo2572b() {
        return Config.ARGB_8888;
    }
}
