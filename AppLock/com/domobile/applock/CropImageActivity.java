package com.domobile.applock;

import android.graphics.Bitmap;
import com.domobile.cropimage.C0591d;
import com.domobile.frame.p000a.C1148d;

public class CropImageActivity extends C0591d {
    public void mo2358a(Bitmap bitmap) {
        if (C1083t.m2306a(this, bitmap, bitmap.getHeight() < bitmap.getWidth())) {
            C1148d.m2489A(this, "com.domobile.elock.ACTION_RELOAD_LOCK_BGIMAGES");
        }
        finish();
    }
}
