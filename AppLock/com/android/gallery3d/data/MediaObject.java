package com.android.gallery3d.data;

import android.content.Context;
import android.net.Uri;

public abstract class MediaObject {
    public static final int CACHE_FLAG_FULL = 2;
    public static final int CACHE_FLAG_NO = 0;
    public static final int CACHE_FLAG_SCREENNAIL = 1;
    public static final int CACHE_STATUS_CACHED_FULL = 3;
    public static final int CACHE_STATUS_CACHED_SCREENNAIL = 2;
    public static final int CACHE_STATUS_CACHING = 1;
    public static final int CACHE_STATUS_NOT_CACHED = 0;
    public static final long INVALID_DATA_VERSION = -1;
    public static final int MEDIA_TYPE_ALL = 6;
    public static final String MEDIA_TYPE_ALL_STRING = "all";
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final String MEDIA_TYPE_IMAGE_STRING = "image";
    public static final int MEDIA_TYPE_UNKNOWN = 1;
    public static final int MEDIA_TYPE_VIDEO = 4;
    public static final String MEDIA_TYPE_VIDEO_STRING = "video";
    public static final int SUPPORT_ACTION = 32768;
    public static final int SUPPORT_ALL = -1;
    public static final int SUPPORT_BACK = 16384;
    public static final int SUPPORT_CACHE = 256;
    public static final int SUPPORT_CAMERA_SHORTCUT = 65536;
    public static final int SUPPORT_CROP = 8;
    public static final int SUPPORT_DELETE = 1;
    public static final int SUPPORT_EDIT = 512;
    public static final int SUPPORT_FULL_IMAGE = 64;
    public static final int SUPPORT_IMPORT = 2048;
    public static final int SUPPORT_INFO = 1024;
    public static final int SUPPORT_PLAY = 128;
    public static final int SUPPORT_ROTATE = 2;
    public static final int SUPPORT_SETAS = 32;
    public static final int SUPPORT_SHARE = 4;
    public static final int SUPPORT_SHOW_ON_MAP = 16;
    public static final int SUPPORT_TRIM = 4096;
    public static final int SUPPORT_UNLOCK = 8192;
    private static final String TAG = "MediaObject";
    private static long sVersionSerial = 0;
    protected long mDataVersion;
    protected final Path mPath;

    public interface PanoramaSupportCallback {
        void panoramaInfoAvailable(MediaObject mediaObject, boolean z, boolean z2);
    }

    public MediaObject(Path path, long j) {
        path.setObject(this);
        this.mPath = path;
        this.mDataVersion = j;
    }

    public static int getTypeFromString(String str) {
        if (MEDIA_TYPE_ALL_STRING.equals(str)) {
            return 6;
        }
        if ("image".equals(str)) {
            return 2;
        }
        if ("video".equals(str)) {
            return 4;
        }
        throw new IllegalArgumentException(str);
    }

    public static String getTypeString(int i) {
        switch (i) {
            case 2:
                return "image";
            case 4:
                return "video";
            case 6:
                return MEDIA_TYPE_ALL_STRING;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static synchronized long nextVersionNumber() {
        long j;
        synchronized (MediaObject.class) {
            j = sVersionSerial + 1;
            sVersionSerial = j;
        }
        return j;
    }

    public boolean Import() {
        throw new UnsupportedOperationException();
    }

    public void cache(int i) {
        throw new UnsupportedOperationException();
    }

    public void clearCachedPanoramaSupport() {
    }

    public void delete() {
        throw new UnsupportedOperationException();
    }

    public int getCacheFlag() {
        return 0;
    }

    public long getCacheSize() {
        throw new UnsupportedOperationException();
    }

    public int getCacheStatus() {
        throw new UnsupportedOperationException();
    }

    public Uri getContentUri() {
        Log.m442e(TAG, "Class " + getClass().getName() + "should implement getContentUri.");
        Log.m442e(TAG, "The object was created from path: " + getPath());
        throw new UnsupportedOperationException();
    }

    public long getDataVersion() {
        return this.mDataVersion;
    }

    public MediaDetails getDetails() {
        return new MediaDetails();
    }

    public int getMediaType() {
        return 1;
    }

    public void getPanoramaSupport(PanoramaSupportCallback panoramaSupportCallback) {
        panoramaSupportCallback.panoramaInfoAvailable(this, false, false);
    }

    public Path getPath() {
        return this.mPath;
    }

    public Uri getPlayUri() {
        throw new UnsupportedOperationException();
    }

    public int getSupportedOperations() {
        return 0;
    }

    public void rotate(Context context, int i) {
        throw new UnsupportedOperationException();
    }
}
