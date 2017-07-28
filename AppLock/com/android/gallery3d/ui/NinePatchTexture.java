package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;

public class NinePatchTexture extends ResourceTexture {
    private static final String TAG = "NinePatchTexture";
    private NinePatchChunk mChunk;
    private SmallCache<NinePatchInstance> mInstanceCache = new SmallCache();

    private static class SmallCache<V> {
        private static final int CACHE_SIZE = 16;
        private static final int CACHE_SIZE_START_MOVE = 8;
        private int mCount;
        private int[] mKey;
        private V[] mValue;

        private SmallCache() {
            this.mKey = new int[16];
            this.mValue = new Object[16];
        }

        public void clear() {
            for (int i = 0; i < this.mCount; i++) {
                this.mValue[i] = null;
            }
            this.mCount = 0;
        }

        public V get(int i) {
            int i2 = 0;
            while (i2 < this.mCount) {
                if (this.mKey[i2] == i) {
                    if (this.mCount > 8 && i2 > 0) {
                        int i3 = this.mKey[i2];
                        this.mKey[i2] = this.mKey[i2 - 1];
                        this.mKey[i2 - 1] = i3;
                        Object obj = this.mValue[i2];
                        this.mValue[i2] = this.mValue[i2 - 1];
                        this.mValue[i2 - 1] = obj;
                    }
                    return this.mValue[i2];
                }
                i2++;
            }
            return null;
        }

        public V put(int i, V v) {
            if (this.mCount == 16) {
                V v2 = this.mValue[15];
                this.mKey[15] = i;
                this.mValue[15] = v;
                return v2;
            }
            this.mKey[this.mCount] = i;
            this.mValue[this.mCount] = v;
            this.mCount++;
            return null;
        }

        public int size() {
            return this.mCount;
        }

        public V valueAt(int i) {
            return this.mValue[i];
        }
    }

    public NinePatchTexture(Context context, int i) {
        super(context, i);
    }

    private NinePatchInstance findInstance(GLCanvas gLCanvas, int i, int i2) {
        int i3 = (i << 16) | i2;
        NinePatchInstance ninePatchInstance = (NinePatchInstance) this.mInstanceCache.get(i3);
        if (ninePatchInstance != null) {
            return ninePatchInstance;
        }
        NinePatchInstance ninePatchInstance2 = new NinePatchInstance(this, i, i2);
        ninePatchInstance = (NinePatchInstance) this.mInstanceCache.put(i3, ninePatchInstance2);
        if (ninePatchInstance != null) {
            ninePatchInstance.recycle(gLCanvas);
        }
        return ninePatchInstance2;
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        if (!isLoaded()) {
            this.mInstanceCache.clear();
        }
        if (i3 != 0 && i4 != 0) {
            findInstance(gLCanvas, i3, i4).draw(gLCanvas, this, i, i2);
        }
    }

    public NinePatchChunk getNinePatchChunk() {
        if (this.mChunk == null) {
            onGetBitmap();
        }
        return this.mChunk;
    }

    public Rect getPaddings() {
        if (this.mChunk == null) {
            onGetBitmap();
        }
        return this.mChunk.mPaddings;
    }

    protected Bitmap onGetBitmap() {
        if (this.mBitmap != null) {
            return this.mBitmap;
        }
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), this.mResId, options);
        this.mBitmap = decodeResource;
        setSize(decodeResource.getWidth(), decodeResource.getHeight());
        this.mChunk = decodeResource.getNinePatchChunk() == null ? null : NinePatchChunk.deserialize(decodeResource.getNinePatchChunk());
        if (this.mChunk != null) {
            return decodeResource;
        }
        throw new RuntimeException("invalid nine-patch image: " + this.mResId);
    }

    public void recycle() {
        super.recycle();
        GLCanvas gLCanvas = this.mCanvasRef;
        if (gLCanvas != null) {
            int size = this.mInstanceCache.size();
            for (int i = 0; i < size; i++) {
                ((NinePatchInstance) this.mInstanceCache.valueAt(i)).recycle(gLCanvas);
            }
            this.mInstanceCache.clear();
        }
    }
}
