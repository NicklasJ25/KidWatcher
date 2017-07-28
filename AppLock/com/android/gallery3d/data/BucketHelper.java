package com.android.gallery3d.data;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class BucketHelper {
    private static final String BUCKET_GROUP_BY = "1) GROUP BY 1,(2";
    private static final String BUCKET_GROUP_BY_IN_ONE_TABLE = "1) GROUP BY (1";
    private static final String BUCKET_ORDER_BY = "MAX(datetaken) DESC";
    private static final String EXTERNAL_MEDIA = "external";
    private static final int INDEX_BUCKET_ID = 0;
    private static final int INDEX_BUCKET_NAME = 2;
    private static final int INDEX_DATE_TAKEN = 1;
    private static final int INDEX_MEDIA_TYPE = 1;
    private static final String[] PROJECTION_BUCKET = new String[]{"bucket_id", "media_type", "bucket_display_name"};
    private static final String[] PROJECTION_BUCKET_IN_ONE_TABLE = new String[]{"bucket_id", "MAX(datetaken)", "bucket_display_name"};
    private static final String TAG = "BucketHelper";

    static class C05261 implements Comparator<BucketEntry> {
        C05261() {
        }

        public int compare(BucketEntry bucketEntry, BucketEntry bucketEntry2) {
            return bucketEntry2.dateTaken - bucketEntry.dateTaken;
        }
    }

    public static class BucketEntry {
        public int bucketId;
        public String bucketName;
        public int dateTaken;

        public BucketEntry(int i, String str) {
            this.bucketId = i;
            this.bucketName = Utils.ensureNotNull(str);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BucketEntry)) {
                return false;
            }
            return this.bucketId == ((BucketEntry) obj).bucketId;
        }

        public int hashCode() {
            return this.bucketId;
        }
    }

    BucketHelper() {
    }

    public static String getBucketName(ContentResolver contentResolver, int i) {
        String bucketNameInTable;
        if (ApiHelper.HAS_MEDIA_PROVIDER_FILES_TABLE) {
            bucketNameInTable = getBucketNameInTable(contentResolver, getFilesContentUri(), i);
            return bucketNameInTable == null ? "" : bucketNameInTable;
        } else {
            bucketNameInTable = getBucketNameInTable(contentResolver, Media.EXTERNAL_CONTENT_URI, i);
            if (bucketNameInTable != null) {
                return bucketNameInTable;
            }
            bucketNameInTable = getBucketNameInTable(contentResolver, Video.Media.EXTERNAL_CONTENT_URI, i);
            return bucketNameInTable == null ? "" : bucketNameInTable;
        }
    }

    private static String getBucketNameInTable(ContentResolver contentResolver, Uri uri, int i) {
        String str = null;
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(uri.buildUpon().appendQueryParameter("limit", "1").build(), PROJECTION_BUCKET_IN_ONE_TABLE, "bucket_id = ?", new String[]{String.valueOf(i)}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    str = query.getString(2);
                    return str;
                }
            } finally {
                Utils.closeSilently(query);
            }
        }
        Utils.closeSilently(query);
        return str;
    }

    @TargetApi(11)
    private static Uri getFilesContentUri() {
        return Files.getContentUri(EXTERNAL_MEDIA);
    }

    public static BucketEntry[] loadBucketEntries(JobContext jobContext, ContentResolver contentResolver, int i) {
        return ApiHelper.HAS_MEDIA_PROVIDER_FILES_TABLE ? loadBucketEntriesFromFilesTable(jobContext, contentResolver, i) : loadBucketEntriesFromImagesAndVideoTable(jobContext, contentResolver, i);
    }

    private static BucketEntry[] loadBucketEntriesFromFilesTable(JobContext jobContext, ContentResolver contentResolver, int i) {
        Uri filesContentUri = getFilesContentUri();
        Cursor query = contentResolver.query(filesContentUri, PROJECTION_BUCKET, BUCKET_GROUP_BY, null, BUCKET_ORDER_BY);
        if (query == null) {
            Log.w(TAG, "cannot open local database: " + filesContentUri);
            return new BucketEntry[0];
        }
        ArrayList arrayList = new ArrayList();
        int i2 = (i & 2) != 0 ? 2 : 0;
        if ((i & 4) != 0) {
            i2 |= 8;
        }
        while (query.moveToNext()) {
            try {
                if (((1 << query.getInt(1)) & i2) != 0) {
                    BucketEntry bucketEntry = new BucketEntry(query.getInt(0), query.getString(2));
                    if (!arrayList.contains(bucketEntry)) {
                        arrayList.add(bucketEntry);
                    }
                }
                if (jobContext.isCancelled()) {
                    return null;
                }
            } finally {
                Utils.closeSilently(query);
            }
        }
        Utils.closeSilently(query);
        return (BucketEntry[]) arrayList.toArray(new BucketEntry[arrayList.size()]);
    }

    private static BucketEntry[] loadBucketEntriesFromImagesAndVideoTable(JobContext jobContext, ContentResolver contentResolver, int i) {
        HashMap hashMap = new HashMap(64);
        if ((i & 2) != 0) {
            updateBucketEntriesFromTable(jobContext, contentResolver, Media.EXTERNAL_CONTENT_URI, hashMap);
        }
        if ((i & 4) != 0) {
            updateBucketEntriesFromTable(jobContext, contentResolver, Video.Media.EXTERNAL_CONTENT_URI, hashMap);
        }
        BucketEntry[] bucketEntryArr = (BucketEntry[]) hashMap.values().toArray(new BucketEntry[hashMap.size()]);
        Arrays.sort(bucketEntryArr, new C05261());
        return bucketEntryArr;
    }

    private static void updateBucketEntriesFromTable(JobContext jobContext, ContentResolver contentResolver, Uri uri, HashMap<Integer, BucketEntry> hashMap) {
        Cursor query = contentResolver.query(uri, PROJECTION_BUCKET_IN_ONE_TABLE, BUCKET_GROUP_BY_IN_ONE_TABLE, null, null);
        if (query == null) {
            Log.w(TAG, "cannot open media database: " + uri);
            return;
        }
        while (query.moveToNext()) {
            try {
                int i = query.getInt(0);
                int i2 = query.getInt(1);
                BucketEntry bucketEntry = (BucketEntry) hashMap.get(Integer.valueOf(i));
                if (bucketEntry == null) {
                    bucketEntry = new BucketEntry(i, query.getString(2));
                    hashMap.put(Integer.valueOf(i), bucketEntry);
                    bucketEntry.dateTaken = i2;
                } else {
                    bucketEntry.dateTaken = Math.max(bucketEntry.dateTaken, i2);
                }
            } finally {
                Utils.closeSilently(query);
            }
        }
    }
}
