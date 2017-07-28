package com.android.gallery3d.data;

import android.content.Context;
import com.android.gallery3d.common.BlobCache;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.BytesBufferPool.BytesBuffer;
import com.android.gallery3d.util.CacheManager;
import com.android.gallery3d.util.GalleryUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ImageCacheService {
    private static final String IMAGE_CACHE_FILE = "imgcache";
    private static final int IMAGE_CACHE_MAX_BYTES = 209715200;
    private static final int IMAGE_CACHE_MAX_ENTRIES = 5000;
    private static final int IMAGE_CACHE_VERSION = 7;
    private static final String TAG = "ImageCacheService";
    private BlobCache mCache;

    public ImageCacheService(Context context) {
        this.mCache = CacheManager.getCache(context, IMAGE_CACHE_FILE, IMAGE_CACHE_MAX_ENTRIES, IMAGE_CACHE_MAX_BYTES, 7);
    }

    private static boolean isSameKey(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (bArr2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] makeKey(Path path, int i) {
        return GalleryUtils.getBytes(path.toString() + "+" + i);
    }

    public void clearImageData(Path path, int i) {
        long crc64Long = Utils.crc64Long(makeKey(path, i));
        synchronized (this.mCache) {
            try {
                this.mCache.clearEntry(crc64Long);
            } catch (IOException e) {
            }
        }
    }

    public boolean getImageData(Path path, int i, BytesBuffer bytesBuffer) {
        return false;
    }

    public void putImageData(Path path, int i, byte[] bArr) {
        byte[] makeKey = makeKey(path, i);
        long crc64Long = Utils.crc64Long(makeKey);
        ByteBuffer allocate = ByteBuffer.allocate(makeKey.length + bArr.length);
        allocate.put(makeKey);
        allocate.put(bArr);
        synchronized (this.mCache) {
            try {
                this.mCache.insert(crc64Long, allocate.array());
            } catch (IOException e) {
            }
        }
    }
}
