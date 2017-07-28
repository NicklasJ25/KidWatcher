package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.SystemClock;
import com.android.gallery3d.ui.GLRoot.OnGLIdleListener;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class TiledTexture implements Texture {
    private static final int BORDER_SIZE = 1;
    private static final int CONTENT_SIZE = 254;
    private static final int INIT_CAPACITY = 8;
    private static final int TILE_SIZE = 256;
    private static final long UPLOAD_TILE_LIMIT = 4;
    private static Paint sBitmapPaint;
    private static Canvas sCanvas;
    private static Tile sFreeTileHead = null;
    private static final Object sFreeTileLock = new Object();
    private static Paint sPaint;
    private static Bitmap sUploadBitmap;
    private final RectF mDestRect = new RectF();
    private final int mHeight;
    private final RectF mSrcRect = new RectF();
    private final Tile[] mTiles;
    private int mUploadIndex = 0;
    private final int mWidth;

    private static class Tile extends UploadedTexture {
        public Bitmap bitmap;
        public int contentHeight;
        public int contentWidth;
        public Tile nextFreeTile;
        public int offsetX;
        public int offsetY;

        private Tile() {
        }

        protected void onFreeBitmap(Bitmap bitmap) {
        }

        protected Bitmap onGetBitmap() {
            int i = 1 - this.offsetX;
            int i2 = 1 - this.offsetY;
            int width = this.bitmap.getWidth() + i;
            int height = this.bitmap.getHeight() + i2;
            TiledTexture.sCanvas.drawBitmap(this.bitmap, (float) i, (float) i2, TiledTexture.sBitmapPaint);
            this.bitmap = null;
            if (i > 0) {
                TiledTexture.sCanvas.drawLine((float) (i - 1), 0.0f, (float) (i - 1), 256.0f, TiledTexture.sPaint);
            }
            if (i2 > 0) {
                TiledTexture.sCanvas.drawLine(0.0f, (float) (i2 - 1), 256.0f, (float) (i2 - 1), TiledTexture.sPaint);
            }
            if (width < TiledTexture.CONTENT_SIZE) {
                TiledTexture.sCanvas.drawLine((float) width, 0.0f, (float) width, 256.0f, TiledTexture.sPaint);
            }
            if (height < TiledTexture.CONTENT_SIZE) {
                TiledTexture.sCanvas.drawLine(0.0f, (float) height, 256.0f, (float) height, TiledTexture.sPaint);
            }
            return TiledTexture.sUploadBitmap;
        }

        public void setSize(int i, int i2) {
            this.contentWidth = i;
            this.contentHeight = i2;
            this.mWidth = i + 2;
            this.mHeight = i2 + 2;
            this.mTextureWidth = 256;
            this.mTextureHeight = 256;
        }
    }

    public static class Uploader implements OnGLIdleListener {
        private final GLRoot mGlRoot;
        private boolean mIsQueued = false;
        private final ArrayDeque<TiledTexture> mTextures = new ArrayDeque(8);

        public Uploader(GLRoot gLRoot) {
            this.mGlRoot = gLRoot;
        }

        public synchronized void addTexture(TiledTexture tiledTexture) {
            if (!tiledTexture.isReady()) {
                this.mTextures.addLast(tiledTexture);
                if (!this.mIsQueued) {
                    this.mIsQueued = true;
                    this.mGlRoot.addOnGLIdleListener(this);
                }
            }
        }

        public synchronized void clear() {
            this.mTextures.clear();
        }

        public boolean onGLIdle(GLCanvas gLCanvas, boolean z) {
            boolean z2;
            ArrayDeque arrayDeque = this.mTextures;
            synchronized (this) {
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = 4 + uptimeMillis;
                while (uptimeMillis < j && !arrayDeque.isEmpty()) {
                    if (((TiledTexture) arrayDeque.peekFirst()).uploadNextTile(gLCanvas)) {
                        arrayDeque.removeFirst();
                        this.mGlRoot.requestRender();
                    }
                    uptimeMillis = SystemClock.uptimeMillis();
                }
                this.mIsQueued = !this.mTextures.isEmpty();
                z2 = this.mIsQueued;
            }
            return z2;
        }
    }

    public TiledTexture(Bitmap bitmap) {
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        ArrayList arrayList = new ArrayList();
        int i = this.mWidth;
        for (int i2 = 0; i2 < i; i2 += CONTENT_SIZE) {
            int i3 = this.mHeight;
            for (int i4 = 0; i4 < i3; i4 += CONTENT_SIZE) {
                Tile obtainTile = obtainTile();
                obtainTile.offsetX = i2;
                obtainTile.offsetY = i4;
                obtainTile.bitmap = bitmap;
                obtainTile.setSize(Math.min(CONTENT_SIZE, this.mWidth - i2), Math.min(CONTENT_SIZE, this.mHeight - i4));
                arrayList.add(obtainTile);
            }
        }
        this.mTiles = (Tile[]) arrayList.toArray(new Tile[arrayList.size()]);
    }

    public static void freeResources() {
        sUploadBitmap = null;
        sCanvas = null;
        sBitmapPaint = null;
        sPaint = null;
    }

    private static void freeTile(Tile tile) {
        tile.invalidateContent();
        tile.bitmap = null;
        synchronized (sFreeTileLock) {
            tile.nextFreeTile = sFreeTileHead;
            sFreeTileHead = tile;
        }
    }

    private static void mapRect(RectF rectF, RectF rectF2, float f, float f2, float f3, float f4, float f5, float f6) {
        rectF.set(((rectF2.left - f) * f5) + f3, ((rectF2.top - f2) * f6) + f4, ((rectF2.right - f) * f5) + f3, ((rectF2.bottom - f2) * f6) + f4);
    }

    private static Tile obtainTile() {
        Tile tile;
        synchronized (sFreeTileLock) {
            tile = sFreeTileHead;
            if (tile == null) {
                tile = new Tile();
            } else {
                sFreeTileHead = tile.nextFreeTile;
                tile.nextFreeTile = null;
            }
        }
        return tile;
    }

    public static void prepareResources() {
        sUploadBitmap = Bitmap.createBitmap(256, 256, Config.ARGB_8888);
        sCanvas = new Canvas(sUploadBitmap);
        sBitmapPaint = new Paint(2);
        sBitmapPaint.setXfermode(new PorterDuffXfermode(Mode.SRC));
        sPaint = new Paint();
        sPaint.setXfermode(new PorterDuffXfermode(Mode.SRC));
        sPaint.setColor(0);
    }

    private boolean uploadNextTile(GLCanvas gLCanvas) {
        if (this.mUploadIndex == this.mTiles.length) {
            return true;
        }
        Tile[] tileArr = this.mTiles;
        int i = this.mUploadIndex;
        this.mUploadIndex = i + 1;
        Tile tile = tileArr[i];
        if (tile.bitmap != null) {
            boolean isLoaded = tile.isLoaded();
            tile.updateContent(gLCanvas);
            if (!isLoaded) {
                tile.draw(gLCanvas, 0, 0);
            }
        }
        return this.mUploadIndex == this.mTiles.length;
    }

    public void draw(GLCanvas gLCanvas, int i, int i2) {
        draw(gLCanvas, i, i2, this.mWidth, this.mHeight);
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        RectF rectF = this.mSrcRect;
        RectF rectF2 = this.mDestRect;
        float f = ((float) i3) / ((float) this.mWidth);
        float f2 = ((float) i4) / ((float) this.mHeight);
        for (BasicTexture basicTexture : this.mTiles) {
            rectF.set(0.0f, 0.0f, (float) basicTexture.contentWidth, (float) basicTexture.contentHeight);
            rectF.offset((float) basicTexture.offsetX, (float) basicTexture.offsetY);
            mapRect(rectF2, rectF, 0.0f, 0.0f, (float) i, (float) i2, f, f2);
            rectF.offset((float) (1 - basicTexture.offsetX), (float) (1 - basicTexture.offsetY));
            gLCanvas.drawTexture(basicTexture, this.mSrcRect, this.mDestRect);
        }
    }

    public void draw(GLCanvas gLCanvas, RectF rectF, RectF rectF2) {
        RectF rectF3 = this.mSrcRect;
        RectF rectF4 = this.mDestRect;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF2.left;
        float f4 = rectF2.top;
        float width = rectF2.width() / rectF.width();
        float height = rectF2.height() / rectF.height();
        for (BasicTexture basicTexture : this.mTiles) {
            rectF3.set(0.0f, 0.0f, (float) basicTexture.contentWidth, (float) basicTexture.contentHeight);
            rectF3.offset((float) basicTexture.offsetX, (float) basicTexture.offsetY);
            if (rectF3.intersect(rectF)) {
                mapRect(rectF4, rectF3, f, f2, f3, f4, width, height);
                rectF3.offset((float) (1 - basicTexture.offsetX), (float) (1 - basicTexture.offsetY));
                gLCanvas.drawTexture(basicTexture, rectF3, rectF4);
            }
        }
    }

    public void drawMixed(GLCanvas gLCanvas, int i, float f, int i2, int i3, int i4, int i5) {
        RectF rectF = this.mSrcRect;
        RectF rectF2 = this.mDestRect;
        float f2 = ((float) i4) / ((float) this.mWidth);
        float f3 = ((float) i5) / ((float) this.mHeight);
        for (BasicTexture basicTexture : this.mTiles) {
            rectF.set(0.0f, 0.0f, (float) basicTexture.contentWidth, (float) basicTexture.contentHeight);
            rectF.offset((float) basicTexture.offsetX, (float) basicTexture.offsetY);
            mapRect(rectF2, rectF, 0.0f, 0.0f, (float) i2, (float) i3, f2, f3);
            rectF.offset((float) (1 - basicTexture.offsetX), (float) (1 - basicTexture.offsetY));
            gLCanvas.drawMixed(basicTexture, i, f, this.mSrcRect, this.mDestRect);
        }
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return false;
    }

    public boolean isReady() {
        return this.mUploadIndex == this.mTiles.length;
    }

    public void recycle() {
        for (Tile freeTile : this.mTiles) {
            freeTile(freeTile);
        }
    }
}
