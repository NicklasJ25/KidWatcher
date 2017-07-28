package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.ui.TileImageView.Model;
import java.util.ArrayList;

public class BitmapTileProvider implements Model {
    private final Config mConfig;
    private final int mImageHeight;
    private final int mImageWidth;
    private final Bitmap[] mMipmaps;
    private boolean mRecycled = false;
    private final ScreenNail mScreenNail;

    public BitmapTileProvider(Bitmap bitmap, int i) {
        this.mImageWidth = bitmap.getWidth();
        this.mImageHeight = bitmap.getHeight();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bitmap);
        while (true) {
            if (bitmap.getWidth() > i || bitmap.getHeight() > i) {
                bitmap = BitmapUtils.resizeBitmapByScale(bitmap, 0.5f, false);
                arrayList.add(bitmap);
            } else {
                this.mScreenNail = new BitmapScreenNail((Bitmap) arrayList.remove(arrayList.size() - 1));
                this.mMipmaps = (Bitmap[]) arrayList.toArray(new Bitmap[arrayList.size()]);
                this.mConfig = Config.ARGB_8888;
                return;
            }
        }
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public int getLevelCount() {
        return this.mMipmaps.length;
    }

    public ScreenNail getScreenNail() {
        return this.mScreenNail;
    }

    public Bitmap getTile(int i, int i2, int i3, int i4, int i5, BitmapPool bitmapPool) {
        int i6 = i2 >> i;
        int i7 = i3 >> i;
        int i8 = i4 + (i5 * 2);
        Bitmap bitmap = bitmapPool == null ? null : bitmapPool.getBitmap();
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i8, i8, this.mConfig);
        } else {
            bitmap.eraseColor(0);
        }
        new Canvas(bitmap).drawBitmap(this.mMipmaps[i], (float) ((-i6) + i5), (float) ((-i7) + i5), null);
        return bitmap;
    }

    public void recycle() {
        if (!this.mRecycled) {
            this.mRecycled = true;
            for (Bitmap recycleSilently : this.mMipmaps) {
                BitmapUtils.recycleSilently(recycleSilently);
            }
            if (this.mScreenNail != null) {
                this.mScreenNail.recycle();
            }
        }
    }
}
