package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.android.gallery3d.app.GalleryContext;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.common.LongSparseArray;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.data.DecodeUtils;
import com.android.gallery3d.ui.GLRoot.OnGLIdleListener;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.ThreadPool;
import com.android.gallery3d.util.ThreadPool.CancelListener;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

public class TileImageView extends GLView {
    private static int BITMAP_SIZE = 0;
    public static final int SIZE_UNKNOWN = -1;
    private static final int STATE_ACTIVATED = 1;
    private static final int STATE_DECODED = 8;
    private static final int STATE_DECODE_FAIL = 16;
    private static final int STATE_DECODING = 4;
    private static final int STATE_IN_QUEUE = 2;
    private static final int STATE_RECYCLED = 64;
    private static final int STATE_RECYCLING = 32;
    private static final String TAG = "TileImageView";
    private static final int TILE_BORDER = 1;
    private static int TILE_SIZE = 0;
    private static final int UPLOAD_LIMIT = 1;
    private static BitmapPool sTilePool;
    private final Rect[] mActiveRange = new Rect[]{new Rect(), new Rect()};
    private final LongSparseArray<Tile> mActiveTiles = new LongSparseArray();
    private boolean mBackgroundTileUploaded;
    protected int mCenterX;
    protected int mCenterY;
    private final TileQueue mDecodeQueue = new TileQueue();
    protected int mImageHeight = -1;
    protected int mImageWidth = -1;
    private boolean mIsTextureFreed;
    private int mLevel = 0;
    protected int mLevelCount;
    private Model mModel;
    private int mOffsetX;
    private int mOffsetY;
    private final TileQueue mRecycledQueue = new TileQueue();
    private boolean mRenderComplete;
    protected int mRotation;
    protected float mScale;
    private ScreenNail mScreenNail;
    private final RectF mSourceRect = new RectF();
    private final RectF mTargetRect = new RectF();
    private final ThreadPool mThreadPool;
    private Future<Void> mTileDecoder;
    private final Rect mTileRange = new Rect();
    private final TileUploader mTileUploader = new TileUploader();
    private final TileQueue mUploadQueue = new TileQueue();
    private int mUploadQuota;

    public interface Model {
        int getImageHeight();

        int getImageWidth();

        int getLevelCount();

        ScreenNail getScreenNail();

        Bitmap getTile(int i, int i2, int i3, int i4, int i5, BitmapPool bitmapPool);
    }

    private class Tile extends UploadedTexture {
        public Bitmap mDecodedTile;
        public Tile mNext;
        public int mTileLevel;
        public volatile int mTileState = 1;
        public int mX;
        public int mY;

        public Tile(int i, int i2, int i3) {
            this.mX = i;
            this.mY = i2;
            this.mTileLevel = i3;
        }

        boolean decode() {
            try {
                this.mDecodedTile = DecodeUtils.ensureGLCompatibleBitmap(TileImageView.this.mModel.getTile(this.mTileLevel, this.mX, this.mY, TileImageView.TILE_SIZE, 1, TileImageView.sTilePool));
            } catch (Throwable th) {
                Log.m460w(TileImageView.TAG, "fail to decode tile", th);
            }
            return this.mDecodedTile != null;
        }

        public Tile getParentTile() {
            if (this.mTileLevel + 1 == TileImageView.this.mLevelCount) {
                return null;
            }
            int access$500 = TileImageView.TILE_SIZE << (this.mTileLevel + 1);
            return TileImageView.this.getTile((this.mX / access$500) * access$500, access$500 * (this.mY / access$500), this.mTileLevel + 1);
        }

        public int getTextureHeight() {
            return TileImageView.TILE_SIZE + 2;
        }

        public int getTextureWidth() {
            return TileImageView.TILE_SIZE + 2;
        }

        protected void onFreeBitmap(Bitmap bitmap) {
            if (TileImageView.sTilePool != null) {
                TileImageView.sTilePool.recycle(bitmap);
            }
        }

        protected Bitmap onGetBitmap() {
            Utils.assertTrue(this.mTileState == 8);
            setSize(Math.min(TileImageView.BITMAP_SIZE, ((TileImageView.this.mImageWidth - this.mX) >> this.mTileLevel) + 1), Math.min(TileImageView.BITMAP_SIZE, ((TileImageView.this.mImageHeight - this.mY) >> this.mTileLevel) + 1));
            Bitmap bitmap = this.mDecodedTile;
            this.mDecodedTile = null;
            this.mTileState = 1;
            return bitmap;
        }

        public String toString() {
            return String.format("tile(%s, %s, %s / %s)", new Object[]{Integer.valueOf(this.mX / TileImageView.TILE_SIZE), Integer.valueOf(this.mY / TileImageView.TILE_SIZE), Integer.valueOf(TileImageView.this.mLevel), Integer.valueOf(TileImageView.this.mLevelCount)});
        }

        public void update(int i, int i2, int i3) {
            this.mX = i;
            this.mY = i2;
            this.mTileLevel = i3;
            invalidateContent();
        }
    }

    private class TileDecoder implements Job<Void> {
        private CancelListener mNotifier;

        class C05481 implements CancelListener {
            C05481() {
            }

            public void onCancel() {
                synchronized (TileImageView.this) {
                    TileImageView.this.notifyAll();
                }
            }
        }

        private TileDecoder() {
            this.mNotifier = new C05481();
        }

        public Void run(JobContext jobContext) {
            jobContext.setMode(0);
            jobContext.setCancelListener(this.mNotifier);
            while (!jobContext.isCancelled()) {
                synchronized (TileImageView.this) {
                    Tile pop = TileImageView.this.mDecodeQueue.pop();
                    if (pop == null && !jobContext.isCancelled()) {
                        Utils.waitWithoutInterrupt(TileImageView.this);
                    }
                }
                if (pop != null && TileImageView.this.decodeTile(pop)) {
                    TileImageView.this.queueForUpload(pop);
                }
            }
            return null;
        }
    }

    private static class TileQueue {
        private Tile mHead;

        private TileQueue() {
        }

        public void clean() {
            this.mHead = null;
        }

        public Tile pop() {
            Tile tile = this.mHead;
            if (tile != null) {
                this.mHead = tile.mNext;
            }
            return tile;
        }

        public boolean push(Tile tile) {
            boolean z = this.mHead == null;
            tile.mNext = this.mHead;
            this.mHead = tile;
            return z;
        }
    }

    private class TileUploader implements OnGLIdleListener {
        AtomicBoolean mActive;

        private TileUploader() {
            this.mActive = new AtomicBoolean(false);
        }

        public boolean onGLIdle(GLCanvas gLCanvas, boolean z) {
            if (z) {
                return true;
            }
            Tile tile = null;
            int i = 1;
            while (i > 0) {
                synchronized (TileImageView.this) {
                    Tile pop = TileImageView.this.mUploadQueue.pop();
                }
                if (pop == null) {
                    tile = pop;
                    break;
                } else if (pop.isContentValid()) {
                    tile = pop;
                } else {
                    boolean isLoaded = pop.isLoaded();
                    Utils.assertTrue(pop.mTileState == 8);
                    pop.updateContent(gLCanvas);
                    if (!isLoaded) {
                        pop.draw(gLCanvas, 0, 0);
                    }
                    i--;
                    tile = pop;
                }
            }
            if (tile == null) {
                this.mActive.set(false);
            }
            return tile != null;
        }
    }

    public TileImageView(GalleryContext galleryContext) {
        BitmapPool bitmapPool = null;
        this.mThreadPool = galleryContext.getThreadPool();
        this.mTileDecoder = this.mThreadPool.submit(new TileDecoder());
        if (TILE_SIZE == 0) {
            if (GalleryUtils.isHighResolution(galleryContext.getAndroidContext())) {
                TILE_SIZE = 510;
            } else {
                TILE_SIZE = 254;
            }
            BITMAP_SIZE = TILE_SIZE + 2;
            if (ApiHelper.HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER) {
                bitmapPool = new BitmapPool(BITMAP_SIZE, BITMAP_SIZE, 128);
            }
            sTilePool = bitmapPool;
        }
    }

    private void activateTile(int i, int i2, int i3) {
        long makeTileKey = makeTileKey(i, i2, i3);
        Tile tile = (Tile) this.mActiveTiles.get(makeTileKey);
        if (tile == null) {
            this.mActiveTiles.put(makeTileKey, obtainTile(i, i2, i3));
        } else if (tile.mTileState == 2) {
            tile.mTileState = 1;
        }
    }

    static boolean drawTile(Tile tile, GLCanvas gLCanvas, RectF rectF, RectF rectF2) {
        BasicTexture basicTexture;
        while (!basicTexture.isContentValid()) {
            BasicTexture parentTile = basicTexture.getParentTile();
            if (parentTile == null) {
                return false;
            }
            if (basicTexture.mX == parentTile.mX) {
                rectF.left /= 2.0f;
                rectF.right /= 2.0f;
            } else {
                rectF.left = (((float) TILE_SIZE) + rectF.left) / 2.0f;
                rectF.right = (((float) TILE_SIZE) + rectF.right) / 2.0f;
            }
            if (basicTexture.mY == parentTile.mY) {
                rectF.top /= 2.0f;
                rectF.bottom /= 2.0f;
            } else {
                rectF.top = (((float) TILE_SIZE) + rectF.top) / 2.0f;
                rectF.bottom = (((float) TILE_SIZE) + rectF.bottom) / 2.0f;
            }
            basicTexture = parentTile;
        }
        rectF.offset(1.0f, 1.0f);
        gLCanvas.drawTexture(basicTexture, rectF, rectF2);
        return true;
    }

    private void getRange(Rect rect, int i, int i2, int i3, float f, int i4) {
        double toRadians = Math.toRadians((double) (-i4));
        double width = (double) getWidth();
        double height = (double) getHeight();
        double cos = Math.cos(toRadians);
        toRadians = Math.sin(toRadians);
        int ceil = (int) Math.ceil(Math.max(Math.abs((cos * width) - (toRadians * height)), Math.abs((cos * width) + (toRadians * height))));
        int ceil2 = (int) Math.ceil(Math.max(Math.abs((toRadians * width) + (cos * height)), Math.abs((toRadians * width) - (cos * height))));
        int floor = (int) Math.floor((double) (((float) i) - (((float) ceil) / (2.0f * f))));
        int floor2 = (int) Math.floor((double) (((float) i2) - (((float) ceil2) / (2.0f * f))));
        int i5 = TILE_SIZE << i3;
        Rect rect2 = rect;
        rect2.set(Math.max(0, (floor / i5) * i5), Math.max(0, (floor2 / i5) * i5), Math.min(this.mImageWidth, (int) Math.ceil((double) (((float) floor) + (((float) ceil) / f)))), Math.min(this.mImageHeight, (int) Math.ceil((double) ((((float) ceil2) / f) + ((float) floor2)))));
    }

    private void getRange(Rect rect, int i, int i2, int i3, int i4) {
        getRange(rect, i, i2, i3, 1.0f / ((float) (1 << (i3 + 1))), i4);
    }

    private Tile getTile(int i, int i2, int i3) {
        return (Tile) this.mActiveTiles.get(makeTileKey(i, i2, i3));
    }

    private boolean isScreenNailAnimating() {
        return (this.mScreenNail instanceof TiledScreenNail) && ((TiledScreenNail) this.mScreenNail).isAnimating();
    }

    private void layoutTiles(int i, int i2, float f, int i3) {
        int i4;
        int width = getWidth();
        int height = getHeight();
        this.mLevel = Utils.clamp(Utils.floorLog2(1.0f / f), 0, this.mLevelCount);
        if (this.mLevel != this.mLevelCount) {
            Rect rect = this.mTileRange;
            getRange(rect, i, i2, this.mLevel, f, i3);
            this.mOffsetX = Math.round((((float) width) / 2.0f) + (((float) (rect.left - i)) * f));
            this.mOffsetY = Math.round((((float) height) / 2.0f) + (((float) (rect.top - i2)) * f));
            i4 = ((float) (1 << this.mLevel)) * f > 0.75f ? this.mLevel - 1 : this.mLevel;
        } else {
            i4 = this.mLevel - 2;
            this.mOffsetX = Math.round((((float) width) / 2.0f) - (((float) i) * f));
            this.mOffsetY = Math.round((((float) height) / 2.0f) - (((float) i2) * f));
        }
        int max = Math.max(0, Math.min(i4, this.mLevelCount - 2));
        width = Math.min(max + 2, this.mLevelCount);
        Rect[] rectArr = this.mActiveRange;
        for (int i5 = max; i5 < width; i5++) {
            getRange(rectArr[i5 - max], i, i2, i5, i3);
        }
        if (i3 % 90 == 0) {
            int size;
            int i6;
            int i7;
            synchronized (this) {
                this.mDecodeQueue.clean();
                this.mUploadQueue.clean();
                this.mBackgroundTileUploaded = false;
                size = this.mActiveTiles.size();
                i6 = 0;
                while (i6 < size) {
                    Tile tile = (Tile) this.mActiveTiles.valueAt(i6);
                    i7 = tile.mTileLevel;
                    if (i7 < max || i7 >= width || !rectArr[i7 - max].contains(tile.mX, tile.mY)) {
                        this.mActiveTiles.removeAt(i6);
                        i6--;
                        size--;
                        recycleTile(tile);
                    }
                    size = size;
                    i6++;
                }
            }
            for (i4 = max; i4 < width; i4++) {
                i7 = TILE_SIZE << i4;
                Rect rect2 = rectArr[i4 - max];
                i6 = rect2.top;
                int i8 = rect2.bottom;
                for (size = i6; size < i8; size += i7) {
                    int i9 = rect2.right;
                    for (i6 = rect2.left; i6 < i9; i6 += i7) {
                        activateTile(i6, size, i4);
                    }
                }
            }
            invalidate();
        }
    }

    private static long makeTileKey(int i, int i2, int i3) {
        return (((((long) i) << 16) | ((long) i2)) << 16) | ((long) i3);
    }

    private synchronized Tile obtainTile(int i, int i2, int i3) {
        Tile pop;
        pop = this.mRecycledQueue.pop();
        if (pop != null) {
            pop.mTileState = 1;
            pop.update(i, i2, i3);
        } else {
            pop = new Tile(i, i2, i3);
        }
        return pop;
    }

    private void uploadBackgroundTiles(GLCanvas gLCanvas) {
        this.mBackgroundTileUploaded = true;
        int size = this.mActiveTiles.size();
        for (int i = 0; i < size; i++) {
            Tile tile = (Tile) this.mActiveTiles.valueAt(i);
            if (!tile.isContentValid()) {
                queueForDecode(tile);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean decodeTile(com.android.gallery3d.ui.TileImageView.Tile r5) {
        /*
        r4 = this;
        r0 = 0;
        monitor-enter(r4);
        r1 = r5.mTileState;	 Catch:{ all -> 0x0038 }
        r2 = 2;
        if (r1 == r2) goto L_0x0009;
    L_0x0007:
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
    L_0x0008:
        return r0;
    L_0x0009:
        r1 = 4;
        r5.mTileState = r1;	 Catch:{ all -> 0x0038 }
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        r1 = r5.decode();
        monitor-enter(r4);
        r2 = r5.mTileState;	 Catch:{ all -> 0x0035 }
        r3 = 32;
        if (r2 != r3) goto L_0x003b;
    L_0x0018:
        r1 = 64;
        r5.mTileState = r1;	 Catch:{ all -> 0x0035 }
        r1 = r5.mDecodedTile;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x002e;
    L_0x0020:
        r1 = sTilePool;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x002b;
    L_0x0024:
        r1 = sTilePool;	 Catch:{ all -> 0x0035 }
        r2 = r5.mDecodedTile;	 Catch:{ all -> 0x0035 }
        r1.recycle(r2);	 Catch:{ all -> 0x0035 }
    L_0x002b:
        r1 = 0;
        r5.mDecodedTile = r1;	 Catch:{ all -> 0x0035 }
    L_0x002e:
        r1 = r4.mRecycledQueue;	 Catch:{ all -> 0x0035 }
        r1.push(r5);	 Catch:{ all -> 0x0035 }
        monitor-exit(r4);	 Catch:{ all -> 0x0035 }
        goto L_0x0008;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        if (r1 == 0) goto L_0x0044;
    L_0x003d:
        r0 = 8;
    L_0x003f:
        r5.mTileState = r0;	 Catch:{ all -> 0x0035 }
        monitor-exit(r4);	 Catch:{ all -> 0x0035 }
        r0 = r1;
        goto L_0x0008;
    L_0x0044:
        r0 = 16;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.TileImageView.decodeTile(com.android.gallery3d.ui.TileImageView$Tile):boolean");
    }

    public void drawTile(GLCanvas gLCanvas, int i, int i2, int i3, float f, float f2, float f3) {
        RectF rectF = this.mSourceRect;
        RectF rectF2 = this.mTargetRect;
        rectF2.set(f, f2, f + f3, f2 + f3);
        rectF.set(0.0f, 0.0f, (float) TILE_SIZE, (float) TILE_SIZE);
        Tile tile = getTile(i, i2, i3);
        if (tile != null) {
            if (!tile.isContentValid()) {
                if (tile.mTileState == 8) {
                    if (this.mUploadQuota > 0) {
                        this.mUploadQuota--;
                        tile.updateContent(gLCanvas);
                    } else {
                        this.mRenderComplete = false;
                    }
                } else if (tile.mTileState != 16) {
                    this.mRenderComplete = false;
                    queueForDecode(tile);
                }
            }
            if (drawTile(tile, gLCanvas, rectF, rectF2)) {
                return;
            }
        }
        if (this.mScreenNail != null) {
            int i4 = TILE_SIZE << i3;
            float width = ((float) this.mScreenNail.getWidth()) / ((float) this.mImageWidth);
            float height = ((float) this.mScreenNail.getHeight()) / ((float) this.mImageHeight);
            rectF.set(((float) i) * width, ((float) i2) * height, width * ((float) (i + i4)), ((float) (i4 + i2)) * height);
            this.mScreenNail.draw(gLCanvas, rectF, rectF2);
        }
    }

    public void freeTextures() {
        this.mIsTextureFreed = true;
        if (this.mTileDecoder != null) {
            this.mTileDecoder.cancel();
            this.mTileDecoder.get();
            this.mTileDecoder = null;
        }
        int size = this.mActiveTiles.size();
        for (int i = 0; i < size; i++) {
            ((Tile) this.mActiveTiles.valueAt(i)).recycle();
        }
        this.mActiveTiles.clear();
        this.mTileRange.set(0, 0, 0, 0);
        synchronized (this) {
            this.mUploadQueue.clean();
            this.mDecodeQueue.clean();
            Tile pop = this.mRecycledQueue.pop();
            while (pop != null) {
                pop.recycle();
                pop = this.mRecycledQueue.pop();
            }
        }
        setScreenNail(null);
        if (sTilePool != null) {
            sTilePool.clear();
        }
    }

    public void getImageCenter(Point point) {
        int i;
        int i2;
        int width = getWidth();
        int height = getHeight();
        if (this.mRotation % FadeTexture.DURATION == 0) {
            i = (this.mImageWidth / 2) - this.mCenterX;
            i2 = (this.mImageHeight / 2) - this.mCenterY;
        } else {
            i = (this.mImageHeight / 2) - this.mCenterY;
            i2 = (this.mImageWidth / 2) - this.mCenterX;
        }
        point.x = Math.round((((float) i) * this.mScale) + (((float) width) / 2.0f));
        point.y = Math.round((((float) i2) * this.mScale) + (((float) height) / 2.0f));
    }

    protected synchronized void invalidateTiles() {
        this.mDecodeQueue.clean();
        this.mUploadQueue.clean();
        int size = this.mActiveTiles.size();
        for (int i = 0; i < size; i++) {
            recycleTile((Tile) this.mActiveTiles.valueAt(i));
        }
        this.mActiveTiles.clear();
    }

    public void notifyModelInvalidated() {
        invalidateTiles();
        if (this.mModel == null) {
            this.mScreenNail = null;
            this.mImageWidth = 0;
            this.mImageHeight = 0;
            this.mLevelCount = 0;
        } else {
            setScreenNail(this.mModel.getScreenNail());
            this.mImageWidth = this.mModel.getImageWidth();
            this.mImageHeight = this.mModel.getImageHeight();
            this.mLevelCount = this.mModel.getLevelCount();
        }
        layoutTiles(this.mCenterX, this.mCenterY, this.mScale, this.mRotation);
        invalidate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            layoutTiles(this.mCenterX, this.mCenterY, this.mScale, this.mRotation);
        }
    }

    public void prepareTextures() {
        ScreenNail screenNail = null;
        if (this.mTileDecoder == null) {
            this.mTileDecoder = this.mThreadPool.submit(new TileDecoder());
        }
        if (this.mIsTextureFreed) {
            layoutTiles(this.mCenterX, this.mCenterY, this.mScale, this.mRotation);
            this.mIsTextureFreed = false;
            if (this.mModel != null) {
                screenNail = this.mModel.getScreenNail();
            }
            setScreenNail(screenNail);
        }
    }

    synchronized void queueForDecode(Tile tile) {
        if (tile.mTileState == 1) {
            tile.mTileState = 2;
            if (this.mDecodeQueue.push(tile)) {
                notifyAll();
            }
        }
    }

    void queueForUpload(Tile tile) {
        synchronized (this) {
            this.mUploadQueue.push(tile);
        }
        if (this.mTileUploader.mActive.compareAndSet(false, true)) {
            getGLRoot().addOnGLIdleListener(this.mTileUploader);
        }
    }

    synchronized void recycleTile(Tile tile) {
        if (tile.mTileState == 4) {
            tile.mTileState = 32;
        } else {
            tile.mTileState = 64;
            if (tile.mDecodedTile != null) {
                if (sTilePool != null) {
                    sTilePool.recycle(tile.mDecodedTile);
                }
                tile.mDecodedTile = null;
            }
            this.mRecycledQueue.push(tile);
        }
    }

    protected void render(GLCanvas gLCanvas) {
        this.mUploadQuota = 1;
        this.mRenderComplete = true;
        int i = this.mLevel;
        int i2 = this.mRotation;
        int i3 = i2 != 0 ? 2 : 0;
        if (i3 != 0) {
            gLCanvas.save(i3);
            if (i2 != 0) {
                int width = getWidth() / 2;
                int height = getHeight() / 2;
                gLCanvas.translate((float) width, (float) height);
                gLCanvas.rotate((float) i2, 0.0f, 0.0f, 1.0f);
                gLCanvas.translate((float) (-width), (float) (-height));
            }
        }
        try {
            if (i != this.mLevelCount && !isScreenNailAnimating()) {
                if (this.mScreenNail != null) {
                    this.mScreenNail.noDraw();
                }
                int i4 = TILE_SIZE << i;
                float f = ((float) i4) * this.mScale;
                Rect rect = this.mTileRange;
                int i5 = rect.top;
                int i6 = 0;
                while (i5 < rect.bottom) {
                    float f2 = ((float) this.mOffsetY) + (((float) i6) * f);
                    height = rect.left;
                    int i7 = 0;
                    while (height < rect.right) {
                        drawTile(gLCanvas, height, i5, i, ((float) this.mOffsetX) + (((float) i7) * f), f2, f);
                        height += i4;
                        i7++;
                    }
                    i5 += i4;
                    i6++;
                }
            } else if (this.mScreenNail != null) {
                this.mScreenNail.draw(gLCanvas, this.mOffsetX, this.mOffsetY, Math.round(((float) this.mImageWidth) * this.mScale), Math.round(((float) this.mImageHeight) * this.mScale));
                if (isScreenNailAnimating()) {
                    invalidate();
                }
            }
            if (i3 != 0) {
                gLCanvas.restore();
            }
            if (!this.mRenderComplete) {
                invalidate();
            } else if (!this.mBackgroundTileUploaded) {
                uploadBackgroundTiles(gLCanvas);
            }
        } catch (Throwable th) {
            if (i3 != 0) {
                gLCanvas.restore();
            }
        }
    }

    public void setModel(Model model) {
        this.mModel = model;
        if (model != null) {
            notifyModelInvalidated();
        }
    }

    public boolean setPosition(int i, int i2, float f, int i3) {
        if (this.mCenterX == i && this.mCenterY == i2 && this.mScale == f && this.mRotation == i3) {
            return false;
        }
        this.mCenterX = i;
        this.mCenterY = i2;
        this.mScale = f;
        this.mRotation = i3;
        layoutTiles(i, i2, f, i3);
        invalidate();
        return true;
    }

    public void setScreenNail(ScreenNail screenNail) {
        this.mScreenNail = screenNail;
    }
}
