package com.android.gallery3d.data;

import android.graphics.Bitmap;
import com.android.gallery3d.common.Utils;
import java.util.ArrayList;

public class BitmapPool {
    private static final String TAG = "BitmapPool";
    private final int mHeight;
    private final boolean mOneSize;
    private final ArrayList<Bitmap> mPool;
    private final int mPoolLimit;
    private final int mWidth;

    public BitmapPool(int i) {
        this.mWidth = -1;
        this.mHeight = -1;
        this.mPoolLimit = i;
        this.mPool = new ArrayList(i);
        this.mOneSize = false;
    }

    public BitmapPool(int i, int i2, int i3) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mPoolLimit = i3;
        this.mPool = new ArrayList(i3);
        this.mOneSize = true;
    }

    public synchronized void clear() {
        this.mPool.clear();
    }

    public synchronized Bitmap getBitmap() {
        int size;
        Utils.assertTrue(this.mOneSize);
        size = this.mPool.size();
        return size > 0 ? (Bitmap) this.mPool.remove(size - 1) : null;
    }

    public synchronized Bitmap getBitmap(int i, int i2) {
        Bitmap bitmap;
        Utils.assertTrue(!this.mOneSize);
        for (int size = this.mPool.size() - 1; size >= 0; size--) {
            bitmap = (Bitmap) this.mPool.get(size);
            if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                bitmap = (Bitmap) this.mPool.remove(size);
                break;
            }
        }
        bitmap = null;
        return bitmap;
    }

    public boolean isOneSize() {
        return this.mOneSize;
    }

    public void recycle(Bitmap bitmap) {
        if (bitmap != null) {
            if (!this.mOneSize || (bitmap.getWidth() == this.mWidth && bitmap.getHeight() == this.mHeight)) {
                synchronized (this) {
                    if (this.mPool.size() >= this.mPoolLimit) {
                        this.mPool.remove(0);
                    }
                    this.mPool.add(bitmap);
                }
                return;
            }
            bitmap.recycle();
        }
    }
}
