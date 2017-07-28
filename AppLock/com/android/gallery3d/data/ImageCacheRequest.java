package com.android.gallery3d.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.data.BytesBufferPool.BytesBuffer;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;

public abstract class ImageCacheRequest implements Job<Bitmap> {
    private static final String TAG = "ImageCacheRequest";
    protected GalleryApp mApplication;
    private Path mPath;
    private int mTargetSize;
    private int mType;

    public ImageCacheRequest(GalleryApp galleryApp, Path path, int i, int i2) {
        this.mApplication = galleryApp;
        this.mPath = path;
        this.mType = i;
        this.mTargetSize = i2;
    }

    private String debugTag() {
        StringBuilder append = new StringBuilder().append(this.mPath).append(",");
        String str = this.mType == 1 ? "THUMB" : this.mType == 2 ? "MICROTHUMB" : "?";
        return append.append(str).toString();
    }

    public abstract Bitmap onDecodeOriginal(JobContext jobContext, int i);

    public Bitmap run(JobContext jobContext) {
        BytesBufferPool bytesBufferPool = null;
        ImageCacheService imageCacheService = this.mApplication.getImageCacheService();
        BytesBuffer bytesBuffer = MediaItem.getBytesBufferPool().get();
        try {
            boolean imageData = imageCacheService.getImageData(this.mPath, this.mType, bytesBuffer);
            if (jobContext.isCancelled()) {
                return bytesBufferPool;
            }
            Bitmap decode;
            if (imageData) {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                decode = this.mType == 2 ? DecodeUtils.decode(jobContext, bytesBuffer.data, bytesBuffer.offset, bytesBuffer.length, options, MediaItem.getMicroThumbPool()) : DecodeUtils.decode(jobContext, bytesBuffer.data, bytesBuffer.offset, bytesBuffer.length, options, MediaItem.getThumbPool());
                if (decode == null && !jobContext.isCancelled()) {
                    Log.m448w(TAG, "decode cached failed " + debugTag());
                }
                MediaItem.getBytesBufferPool().recycle(bytesBuffer);
                return decode;
            }
            MediaItem.getBytesBufferPool().recycle(bytesBuffer);
            decode = onDecodeOriginal(jobContext, this.mType);
            if (jobContext.isCancelled()) {
                return null;
            }
            if (decode == null) {
                Log.m448w(TAG, "decode orig failed " + debugTag());
                return null;
            }
            decode = this.mType == 2 ? BitmapUtils.resizeAndCropCenter(decode, this.mTargetSize, true) : BitmapUtils.resizeDownBySideLength(decode, this.mTargetSize, true);
            if (jobContext.isCancelled()) {
                return null;
            }
            byte[] compressToBytes = BitmapUtils.compressToBytes(decode);
            if (jobContext.isCancelled()) {
                return null;
            }
            imageCacheService.putImageData(this.mPath, this.mType, compressToBytes);
            return decode;
        } finally {
            bytesBufferPool = MediaItem.getBytesBufferPool();
            bytesBufferPool.recycle(bytesBuffer);
        }
    }
}
