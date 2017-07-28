package com.android.gallery3d.data;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.ui.ScreenNail;
import com.android.gallery3d.util.ThreadPool.Job;

public abstract class MediaItem extends MediaObject {
    private static final int BYTESBUFFER_SIZE = 204800;
    private static final int BYTESBUFFE_POOL_SIZE = 4;
    public static final int CACHED_IMAGE_QUALITY = 95;
    public static final int IMAGE_ERROR = -1;
    public static final int IMAGE_READY = 0;
    public static final int IMAGE_WAIT = 1;
    public static final double INVALID_LATLNG = 0.0d;
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final int TYPE_MICROTHUMBNAIL = 2;
    public static final int TYPE_THUMBNAIL = 1;
    private static final BytesBufferPool sMicroThumbBufferPool = new BytesBufferPool(4, BYTESBUFFER_SIZE);
    private static BitmapPool sMicroThumbPool;
    private static int sMicrothumbnailTargetSize = 200;
    private static final BitmapPool sThumbPool = (ApiHelper.HAS_REUSING_BITMAP_IN_BITMAP_FACTORY ? new BitmapPool(4) : null);
    private static int sThumbnailTargetSize = 640;

    public MediaItem(Path path, long j) {
        super(path, j);
    }

    public static BytesBufferPool getBytesBufferPool() {
        return sMicroThumbBufferPool;
    }

    public static BitmapPool getMicroThumbPool() {
        if (ApiHelper.HAS_REUSING_BITMAP_IN_BITMAP_FACTORY && sMicroThumbPool == null) {
            initializeMicroThumbPool();
        }
        return sMicroThumbPool;
    }

    public static int getTargetSize(int i) {
        switch (i) {
            case 1:
                return sThumbnailTargetSize;
            case 2:
                return sMicrothumbnailTargetSize;
            default:
                throw new RuntimeException("should only request thumb/microthumb from cache");
        }
    }

    public static BitmapPool getThumbPool() {
        return sThumbPool;
    }

    private static void initializeMicroThumbPool() {
        sMicroThumbPool = ApiHelper.HAS_REUSING_BITMAP_IN_BITMAP_FACTORY ? new BitmapPool(sMicrothumbnailTargetSize, sMicrothumbnailTargetSize, 16) : null;
    }

    public static void setThumbnailSizes(int i, int i2) {
        sThumbnailTargetSize = i;
        if (sMicrothumbnailTargetSize != i2) {
            sMicrothumbnailTargetSize = i2;
            initializeMicroThumbPool();
        }
    }

    public long getDateInMs() {
        return 0;
    }

    public Face[] getFaces() {
        return null;
    }

    public String getFilePath() {
        return "";
    }

    public int getFullImageRotation() {
        return getRotation();
    }

    public abstract int getHeight();

    public void getLatLong(double[] dArr) {
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
    }

    public abstract String getMimeType();

    public String getName() {
        return null;
    }

    public int getRotation() {
        return 0;
    }

    public ScreenNail getScreenNail() {
        return null;
    }

    public long getSize() {
        return 0;
    }

    public String[] getTags() {
        return null;
    }

    public abstract int getWidth();

    public abstract Job<Bitmap> requestImage(int i);

    public abstract Job<BitmapRegionDecoder> requestLargeImage();
}
