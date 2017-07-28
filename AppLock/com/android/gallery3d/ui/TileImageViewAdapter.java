package com.android.gallery3d.ui;

import android.graphics.BitmapRegionDecoder;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.ui.TileImageView.Model;

public class TileImageViewAdapter implements Model {
    private static final String TAG = "TileImageViewAdapter";
    protected int mImageHeight;
    protected int mImageWidth;
    protected int mLevelCount;
    protected boolean mOwnScreenNail;
    protected BitmapRegionDecoder mRegionDecoder;
    protected ScreenNail mScreenNail;

    private int calculateLevelCount() {
        return Math.max(0, Utils.ceilLog2(((float) this.mImageWidth) / ((float) this.mScreenNail.getWidth())));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getTileWithoutReusingBitmap(int r10, int r11, int r12, int r13, int r14) {
        /*
        r9 = this;
        r0 = 0;
        r8 = 1;
        r1 = r14 << r10;
        r2 = r13 << r10;
        r3 = new android.graphics.Rect;
        r4 = r11 - r1;
        r5 = r12 - r1;
        r6 = r11 + r2;
        r6 = r6 + r1;
        r2 = r2 + r12;
        r1 = r1 + r2;
        r3.<init>(r4, r5, r6, r1);
        monitor-enter(r9);
        r2 = r9.mRegionDecoder;	 Catch:{ all -> 0x0054 }
        if (r2 != 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r9);	 Catch:{ all -> 0x0054 }
    L_0x001a:
        return r0;
    L_0x001b:
        r4 = new android.graphics.Rect;	 Catch:{ all -> 0x0054 }
        r1 = 0;
        r5 = 0;
        r6 = r9.mImageWidth;	 Catch:{ all -> 0x0054 }
        r7 = r9.mImageHeight;	 Catch:{ all -> 0x0054 }
        r4.<init>(r1, r5, r6, r7);	 Catch:{ all -> 0x0054 }
        r1 = r4.intersect(r3);	 Catch:{ all -> 0x0054 }
        com.android.gallery3d.common.Utils.assertTrue(r1);	 Catch:{ all -> 0x0054 }
        monitor-exit(r9);	 Catch:{ all -> 0x0054 }
        r1 = new android.graphics.BitmapFactory$Options;
        r1.<init>();
        r5 = android.graphics.Bitmap.Config.ARGB_8888;
        r1.inPreferredConfig = r5;
        r1.inPreferQualityOverSpeed = r8;
        r5 = r8 << r10;
        r1.inSampleSize = r5;
        monitor-enter(r2);
        r1 = r2.decodeRegion(r4, r1);	 Catch:{ all -> 0x0057 }
        monitor-exit(r2);	 Catch:{ all -> 0x0057 }
        if (r1 != 0) goto L_0x004c;
    L_0x0045:
        r2 = "TileImageViewAdapter";
        r5 = "fail in decoding region";
        com.android.gallery3d.ui.Log.m459w(r2, r5);
    L_0x004c:
        r2 = r3.equals(r4);
        if (r2 == 0) goto L_0x005a;
    L_0x0052:
        r0 = r1;
        goto L_0x001a;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0057 }
        throw r0;
    L_0x005a:
        r2 = r14 * 2;
        r2 = r2 + r13;
        r5 = android.graphics.Bitmap.Config.ARGB_8888;
        r2 = android.graphics.Bitmap.createBitmap(r2, r2, r5);
        r5 = new android.graphics.Canvas;
        r5.<init>(r2);
        r6 = r4.left;
        r7 = r3.left;
        r6 = r6 - r7;
        r6 = r6 >> r10;
        r6 = (float) r6;
        r4 = r4.top;
        r3 = r3.top;
        r3 = r4 - r3;
        r3 = r3 >> r10;
        r3 = (float) r3;
        r5.drawBitmap(r1, r6, r3, r0);
        r0 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.TileImageViewAdapter.getTileWithoutReusingBitmap(int, int, int, int, int):android.graphics.Bitmap");
    }

    public synchronized void clear() {
        this.mScreenNail = null;
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mLevelCount = 0;
        this.mRegionDecoder = null;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public int getLevelCount() {
        return this.mLevelCount;
    }

    public ScreenNail getScreenNail() {
        return this.mScreenNail;
    }

    @android.annotation.TargetApi(11)
    public android.graphics.Bitmap getTile(int r9, int r10, int r11, int r12, int r13, com.android.gallery3d.data.BitmapPool r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.fixSplitterBlock(BlockFinish.java:63)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:34)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = com.android.gallery3d.common.ApiHelper.HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r0 = r8.getTileWithoutReusingBitmap(r9, r10, r11, r12, r13);
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r13 << r9;
        r1 = r12 << r9;
        r2 = new android.graphics.Rect;
        r3 = r10 - r0;
        r4 = r11 - r0;
        r5 = r10 + r1;
        r5 = r5 + r0;
        r1 = r1 + r11;
        r0 = r0 + r1;
        r2.<init>(r3, r4, r5, r0);
        monitor-enter(r8);
        r3 = r8.mRegionDecoder;
        if (r3 != 0) goto L_0x0026;
    L_0x0020:
        r0 = 0;
        monitor-exit(r8);
        goto L_0x0008;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0026:
        r0 = new android.graphics.Rect;
        r1 = 0;
        r4 = 0;
        r5 = r8.mImageWidth;
        r6 = r8.mImageHeight;
        r0.<init>(r1, r4, r5, r6);
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x0079;
    L_0x0037:
        r0 = 1;
        r1 = r0;
    L_0x0039:
        monitor-exit(r8);
        if (r14 != 0) goto L_0x007c;
    L_0x003c:
        r0 = 0;
    L_0x003d:
        if (r0 == 0) goto L_0x0081;
    L_0x003f:
        if (r1 == 0) goto L_0x0045;
    L_0x0041:
        r1 = 0;
        r0.eraseColor(r1);
    L_0x0045:
        r4 = new android.graphics.BitmapFactory$Options;
        r4.<init>();
        r1 = android.graphics.Bitmap.Config.ARGB_8888;
        r4.inPreferredConfig = r1;
        r1 = 1;
        r4.inPreferQualityOverSpeed = r1;
        r1 = 1;
        r1 = r1 << r9;
        r4.inSampleSize = r1;
        r4.inBitmap = r0;
        monitor-enter(r3);	 Catch:{ all -> 0x00a5 }
        r0 = r3.decodeRegion(r2, r4);	 Catch:{ all -> 0x008b, all -> 0x0091 }
        monitor-exit(r3);	 Catch:{ all -> 0x008b, all -> 0x0091 }
        r1 = r4.inBitmap;
        if (r1 == r0) goto L_0x006f;
    L_0x0061:
        r1 = r4.inBitmap;
        if (r1 == 0) goto L_0x006f;
    L_0x0065:
        if (r14 == 0) goto L_0x006c;
    L_0x0067:
        r1 = r4.inBitmap;
        r14.recycle(r1);
    L_0x006c:
        r1 = 0;
        r4.inBitmap = r1;
    L_0x006f:
        if (r0 != 0) goto L_0x0008;
    L_0x0071:
        r1 = "TileImageViewAdapter";
        r2 = "fail in decoding region";
        com.android.gallery3d.ui.Log.m459w(r1, r2);
        goto L_0x0008;
    L_0x0079:
        r0 = 0;
        r1 = r0;
        goto L_0x0039;
    L_0x007c:
        r0 = r14.getBitmap();
        goto L_0x003d;
    L_0x0081:
        r0 = r13 * 2;
        r0 = r0 + r12;
        r1 = android.graphics.Bitmap.Config.ARGB_8888;
        r0 = android.graphics.Bitmap.createBitmap(r0, r0, r1);
        goto L_0x0045;
    L_0x008b:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x008f:
        monitor-exit(r3);	 Catch:{ all -> 0x00aa }
        throw r0;	 Catch:{ all -> 0x008b, all -> 0x0091 }
    L_0x0091:
        r0 = move-exception;
    L_0x0092:
        r2 = r4.inBitmap;
        if (r2 == r1) goto L_0x00a4;
    L_0x0096:
        r1 = r4.inBitmap;
        if (r1 == 0) goto L_0x00a4;
    L_0x009a:
        if (r14 == 0) goto L_0x00a1;
    L_0x009c:
        r1 = r4.inBitmap;
        r14.recycle(r1);
    L_0x00a1:
        r1 = 0;
        r4.inBitmap = r1;
    L_0x00a4:
        throw r0;
    L_0x00a5:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0092;
    L_0x00aa:
        r0 = move-exception;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.TileImageViewAdapter.getTile(int, int, int, int, int, com.android.gallery3d.data.BitmapPool):android.graphics.Bitmap");
    }

    public synchronized void setRegionDecoder(BitmapRegionDecoder bitmapRegionDecoder) {
        this.mRegionDecoder = (BitmapRegionDecoder) Utils.checkNotNull(bitmapRegionDecoder);
        this.mImageWidth = bitmapRegionDecoder.getWidth();
        this.mImageHeight = bitmapRegionDecoder.getHeight();
        this.mLevelCount = calculateLevelCount();
    }

    public synchronized void setScreenNail(ScreenNail screenNail, int i, int i2) {
        Utils.checkNotNull(screenNail);
        this.mScreenNail = screenNail;
        this.mImageWidth = i;
        this.mImageHeight = i2;
        this.mRegionDecoder = null;
        this.mLevelCount = 0;
    }
}
