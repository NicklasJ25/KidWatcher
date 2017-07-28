package com.android.gallery3d.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.DownloadCache.Entry;
import com.android.gallery3d.util.ThreadPool.CancelListener;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.io.Closeable;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;

public class UriImage extends MediaItem {
    private static final int STATE_DOWNLOADED = 2;
    private static final int STATE_DOWNLOADING = 1;
    private static final int STATE_ERROR = -1;
    private static final int STATE_INIT = 0;
    private static final String TAG = "UriImage";
    private GalleryApp mApplication;
    private Entry mCacheEntry;
    private final String mContentType;
    private ParcelFileDescriptor mFileDescriptor;
    private int mHeight;
    private int mRotation;
    private int mState = 0;
    private final Uri mUri;
    private int mWidth;

    class C05331 implements CancelListener {
        C05331() {
        }

        public void onCancel() {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    private class BitmapJob implements Job<Bitmap> {
        private int mType;

        protected BitmapJob(int i) {
            this.mType = i;
        }

        public Bitmap run(JobContext jobContext) {
            if (!UriImage.this.prepareInputFile(jobContext)) {
                return null;
            }
            int targetSize = MediaItem.getTargetSize(this.mType);
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            Bitmap decodeThumbnail = DecodeUtils.decodeThumbnail(jobContext, UriImage.this.mFileDescriptor.getFileDescriptor(), options, targetSize, this.mType);
            return (jobContext.isCancelled() || decodeThumbnail == null) ? null : this.mType == 2 ? BitmapUtils.resizeAndCropCenter(decodeThumbnail, targetSize, true) : BitmapUtils.resizeDownBySideLength(decodeThumbnail, targetSize, true);
        }
    }

    private class RegionDecoderJob implements Job<BitmapRegionDecoder> {
        private RegionDecoderJob() {
        }

        public BitmapRegionDecoder run(JobContext jobContext) {
            if (!UriImage.this.prepareInputFile(jobContext)) {
                return null;
            }
            BitmapRegionDecoder createBitmapRegionDecoder = DecodeUtils.createBitmapRegionDecoder(jobContext, UriImage.this.mFileDescriptor.getFileDescriptor(), false);
            UriImage.this.mWidth = createBitmapRegionDecoder.getWidth();
            UriImage.this.mHeight = createBitmapRegionDecoder.getHeight();
            return createBitmapRegionDecoder;
        }
    }

    public UriImage(GalleryApp galleryApp, Path path, Uri uri, String str) {
        super(path, MediaObject.nextVersionNumber());
        this.mUri = uri;
        this.mApplication = (GalleryApp) Utils.checkNotNull(galleryApp);
        this.mContentType = str;
    }

    private boolean isSharable() {
        return "file".equals(this.mUri.getScheme());
    }

    private void openFileOrDownloadTempFile(JobContext jobContext) {
        int openOrDownloadInner = openOrDownloadInner(jobContext);
        synchronized (this) {
            this.mState = openOrDownloadInner;
            if (!(this.mState == 2 || this.mFileDescriptor == null)) {
                Utils.closeSilently(this.mFileDescriptor);
                this.mFileDescriptor = null;
            }
            notifyAll();
        }
    }

    private int openOrDownloadInner(JobContext jobContext) {
        String scheme = this.mUri.getScheme();
        if ("content".equals(scheme) || "android.resource".equals(scheme) || "file".equals(scheme)) {
            try {
                if (MediaItem.MIME_TYPE_JPEG.equalsIgnoreCase(this.mContentType)) {
                    Closeable openInputStream = this.mApplication.getContentResolver().openInputStream(this.mUri);
                    this.mRotation = Exif.getOrientation(openInputStream);
                    Utils.closeSilently(openInputStream);
                }
                this.mFileDescriptor = this.mApplication.getContentResolver().openFileDescriptor(this.mUri, "r");
                return jobContext.isCancelled() ? 0 : 2;
            } catch (Throwable e) {
                Log.m449w(TAG, "fail to open: " + this.mUri, e);
                return -1;
            }
        }
        try {
            URL toURL = new URI(this.mUri.toString()).toURL();
            this.mCacheEntry = this.mApplication.getDownloadCache().download(jobContext, toURL);
            if (jobContext.isCancelled()) {
                return 0;
            }
            if (this.mCacheEntry == null) {
                Log.m448w(TAG, "download failed " + toURL);
                return -1;
            }
            if (MediaItem.MIME_TYPE_JPEG.equalsIgnoreCase(this.mContentType)) {
                Closeable fileInputStream = new FileInputStream(this.mCacheEntry.cacheFile);
                this.mRotation = Exif.getOrientation(fileInputStream);
                Utils.closeSilently(fileInputStream);
            }
            this.mFileDescriptor = ParcelFileDescriptor.open(this.mCacheEntry.cacheFile, 268435456);
            return 2;
        } catch (Throwable e2) {
            Log.m449w(TAG, "download error", e2);
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean prepareInputFile(com.android.gallery3d.util.ThreadPool.JobContext r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        r2 = new com.android.gallery3d.data.UriImage$1;
        r2.<init>();
        r5.setCancelListener(r2);
    L_0x000a:
        monitor-enter(r4);
        r2 = r5.isCancelled();	 Catch:{ all -> 0x0026 }
        if (r2 == 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r4);	 Catch:{ all -> 0x0026 }
    L_0x0012:
        return r0;
    L_0x0013:
        r2 = r4.mState;	 Catch:{ all -> 0x0026 }
        if (r2 != 0) goto L_0x001f;
    L_0x0017:
        r2 = 1;
        r4.mState = r2;	 Catch:{ all -> 0x0026 }
        monitor-exit(r4);	 Catch:{ all -> 0x0026 }
        r4.openFileOrDownloadTempFile(r5);
        goto L_0x000a;
    L_0x001f:
        r2 = r4.mState;	 Catch:{ all -> 0x0026 }
        r3 = -1;
        if (r2 != r3) goto L_0x0029;
    L_0x0024:
        monitor-exit(r4);	 Catch:{ all -> 0x0026 }
        goto L_0x0012;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r2 = r4.mState;	 Catch:{ all -> 0x0026 }
        r3 = 2;
        if (r2 != r3) goto L_0x0031;
    L_0x002e:
        monitor-exit(r4);	 Catch:{ all -> 0x0026 }
        r0 = r1;
        goto L_0x0012;
    L_0x0031:
        r4.wait();	 Catch:{ InterruptedException -> 0x0036 }
    L_0x0034:
        monitor-exit(r4);	 Catch:{ all -> 0x0026 }
        goto L_0x000a;
    L_0x0036:
        r2 = move-exception;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.data.UriImage.prepareInputFile(com.android.gallery3d.util.ThreadPool$JobContext):boolean");
    }

    protected void finalize() {
        try {
            if (this.mFileDescriptor != null) {
                Utils.closeSilently(this.mFileDescriptor);
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public Uri getContentUri() {
        return this.mUri;
    }

    public MediaDetails getDetails() {
        MediaDetails details = super.getDetails();
        if (!(this.mWidth == 0 || this.mHeight == 0)) {
            details.addDetail(5, Integer.valueOf(this.mWidth));
            details.addDetail(6, Integer.valueOf(this.mHeight));
        }
        if (this.mContentType != null) {
            details.addDetail(9, this.mContentType);
        }
        if ("file".equals(this.mUri.getScheme())) {
            String path = this.mUri.getPath();
            details.addDetail(200, path);
            MediaDetails.extractExifInfo(details, path);
        }
        return details;
    }

    public int getHeight() {
        return 0;
    }

    public int getMediaType() {
        return 2;
    }

    public String getMimeType() {
        return this.mContentType;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getSupportedOperations() {
        int i = 544;
        if (isSharable()) {
            i = 548;
        }
        return BitmapUtils.isSupportedByRegionDecoder(this.mContentType) ? i | 64 : i;
    }

    public int getWidth() {
        return 0;
    }

    public Job<Bitmap> requestImage(int i) {
        return new BitmapJob(i);
    }

    public Job<BitmapRegionDecoder> requestLargeImage() {
        return new RegionDecoderJob();
    }
}
