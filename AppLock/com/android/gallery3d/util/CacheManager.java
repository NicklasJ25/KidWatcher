package com.android.gallery3d.util;

import android.content.Context;
import com.android.gallery3d.common.BlobCache;
import java.io.IOException;
import java.util.HashMap;

public class CacheManager {
    private static final String KEY_CACHE_UP_TO_DATE = "cache-up-to-date";
    private static final String TAG = "CacheManager";
    private static HashMap<String, BlobCache> sCacheMap = new HashMap();
    private static boolean sOldCheckDone = false;

    public static BlobCache getCache(Context context, String str, int i, int i2, int i3) {
        BlobCache blobCache;
        synchronized (sCacheMap) {
            if (!sOldCheckDone) {
                removeOldFilesIfNecessary(context);
                sOldCheckDone = true;
            }
            blobCache = (BlobCache) sCacheMap.get(str);
            if (blobCache == null) {
                try {
                    BlobCache blobCache2 = new BlobCache(context.getExternalCacheDir().getAbsolutePath() + "/" + str, i, i2, false, i3);
                    try {
                        sCacheMap.put(str, blobCache2);
                        blobCache = blobCache2;
                    } catch (Throwable e) {
                        blobCache = blobCache2;
                        Throwable th = e;
                        Log.m465e(TAG, "Cannot instantiate cache!", th);
                        return blobCache;
                    }
                } catch (IOException e2) {
                    th = e2;
                    Log.m465e(TAG, "Cannot instantiate cache!", th);
                    return blobCache;
                }
            }
        }
        return blobCache;
    }

    public static void removeOldFilesIfNecessary(Context context) {
        try {
            String str = context.getExternalCacheDir().getAbsolutePath() + "/";
            BlobCache.deleteFiles(str + "imgcache");
            BlobCache.deleteFiles(str + "rev_geocoding");
            BlobCache.deleteFiles(str + "bookmark");
        } catch (Exception e) {
        }
    }
}
