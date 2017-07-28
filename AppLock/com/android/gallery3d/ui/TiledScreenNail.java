package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.data.MediaItem;

public class TiledScreenNail implements ScreenNail {
    private static final long ANIMATION_DONE = -3;
    private static final long ANIMATION_NEEDED = -2;
    private static final long ANIMATION_NOT_NEEDED = -1;
    private static final int DURATION = 180;
    private static final String TAG = "TiledScreenNail";
    private static boolean mDrawPlaceholder = true;
    private static int mPlaceholderColor = -14540254;
    private static int sMaxSide = 640;
    private long mAnimationStartTime = -1;
    private Bitmap mBitmap;
    private int mHeight;
    private TiledTexture mTexture;
    private int mWidth;

    public TiledScreenNail(int i, int i2) {
        setSize(i, i2);
    }

    public TiledScreenNail(Bitmap bitmap) {
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.mBitmap = bitmap;
        this.mTexture = new TiledTexture(bitmap);
    }

    public static void disableDrawPlaceholder() {
        mDrawPlaceholder = false;
    }

    public static void enableDrawPlaceholder() {
        mDrawPlaceholder = true;
    }

    private float getRatio() {
        return Utils.clamp(1.0f - (((float) (AnimationTime.get() - this.mAnimationStartTime)) / 180.0f), 0.0f, 1.0f);
    }

    private static void recycleBitmap(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmapPool != null && bitmap != null) {
            bitmapPool.recycle(bitmap);
        }
    }

    public static void setMaxSide(int i) {
        sMaxSide = i;
    }

    public static void setPlaceholderColor(int i) {
        mPlaceholderColor = i;
    }

    private void setSize(int i, int i2) {
        if (i == 0 || i2 == 0) {
            i = sMaxSide;
            i2 = (sMaxSide * 3) / 4;
        }
        float min = Math.min(1.0f, ((float) sMaxSide) / ((float) Math.max(i, i2)));
        this.mWidth = Math.round(((float) i) * min);
        this.mHeight = Math.round(min * ((float) i2));
    }

    public ScreenNail combine(ScreenNail screenNail) {
        if (screenNail == null) {
            return this;
        }
        if (screenNail instanceof TiledScreenNail) {
            TiledScreenNail tiledScreenNail = (TiledScreenNail) screenNail;
            this.mWidth = tiledScreenNail.mWidth;
            this.mHeight = tiledScreenNail.mHeight;
            if (tiledScreenNail.mTexture != null) {
                recycleBitmap(MediaItem.getThumbPool(), this.mBitmap);
                if (this.mTexture != null) {
                    this.mTexture.recycle();
                }
                this.mBitmap = tiledScreenNail.mBitmap;
                this.mTexture = tiledScreenNail.mTexture;
                tiledScreenNail.mBitmap = null;
                tiledScreenNail.mTexture = null;
            }
            tiledScreenNail.recycle();
            return this;
        }
        recycle();
        return screenNail;
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        if (this.mTexture == null || !this.mTexture.isReady()) {
            if (this.mAnimationStartTime == -1) {
                this.mAnimationStartTime = ANIMATION_NEEDED;
            }
            if (mDrawPlaceholder) {
                gLCanvas.fillRect((float) i, (float) i2, (float) i3, (float) i4, mPlaceholderColor);
                return;
            }
            return;
        }
        if (this.mAnimationStartTime == ANIMATION_NEEDED) {
            this.mAnimationStartTime = AnimationTime.get();
        }
        if (isAnimating()) {
            this.mTexture.drawMixed(gLCanvas, mPlaceholderColor, getRatio(), i, i2, i3, i4);
            return;
        }
        this.mTexture.draw(gLCanvas, i, i2, i3, i4);
    }

    public void draw(GLCanvas gLCanvas, RectF rectF, RectF rectF2) {
        if (this.mTexture == null || !this.mTexture.isReady()) {
            gLCanvas.fillRect(rectF2.left, rectF2.top, rectF2.width(), rectF2.height(), mPlaceholderColor);
            return;
        }
        this.mTexture.draw(gLCanvas, rectF, rectF2);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public TiledTexture getTexture() {
        return this.mTexture;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAnimating() {
        if (this.mTexture == null || !this.mTexture.isReady()) {
            return true;
        }
        if (this.mAnimationStartTime < 0) {
            return false;
        }
        if (AnimationTime.get() - this.mAnimationStartTime < 180) {
            return true;
        }
        this.mAnimationStartTime = ANIMATION_DONE;
        return false;
    }

    public boolean isShowingPlaceholder() {
        return this.mBitmap == null || isAnimating();
    }

    public void noDraw() {
    }

    public void recycle() {
        if (this.mTexture != null) {
            this.mTexture.recycle();
            this.mTexture = null;
        }
        recycleBitmap(MediaItem.getThumbPool(), this.mBitmap);
        this.mBitmap = null;
    }

    public void updatePlaceholderSize(int i, int i2) {
        if (this.mBitmap == null && i != 0 && i2 != 0) {
            setSize(i, i2);
        }
    }
}
