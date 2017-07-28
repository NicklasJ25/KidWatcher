package com.android.gallery3d.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.common.LruCache;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import com.android.gallery3d.util.ThreadPool.CancelListener;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DownloadCache {
    private static final int FREESPACE_IDNEX_DATA = 1;
    private static final int FREESPACE_IDNEX_ID = 0;
    private static final int FREESPACE_INDEX_CONTENT_SIZE = 3;
    private static final int FREESPACE_INDEX_CONTENT_URL = 2;
    private static final String FREESPACE_ORDER_BY = String.format("%s ASC", new Object[]{"last_access"});
    private static final String[] FREESPACE_PROJECTION = new String[]{Columns.ID, DownloadEntry.Columns.DATA, "content_url", DownloadEntry.Columns.CONTENT_SIZE};
    private static final String ID_WHERE = "_id = ?";
    private static final int LRU_CAPACITY = 4;
    private static final int MAX_DELETE_COUNT = 16;
    private static final int QUERY_INDEX_DATA = 1;
    private static final int QUERY_INDEX_ID = 0;
    private static final String[] QUERY_PROJECTION = new String[]{Columns.ID, DownloadEntry.Columns.DATA};
    private static final int SUM_INDEX_SUM = 0;
    private static final String[] SUM_PROJECTION;
    private static final String TABLE_NAME = DownloadEntry.SCHEMA.getTableName();
    private static final String TAG = "DownloadCache";
    private static final String WHERE_HASH_AND_URL = String.format("%s = ? AND %s = ?", new Object[]{"hash_code", "content_url"});
    private final GalleryApp mApplication;
    private final long mCapacity;
    private final SQLiteDatabase mDatabase;
    private final LruCache<String, Entry> mEntryMap = new LruCache(4);
    private boolean mInitialized = false;
    private final File mRoot;
    private final HashMap<String, DownloadTask> mTaskMap = new HashMap();
    private long mTotalBytes = 0;

    private final class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "download.db";
        public static final int DATABASE_VERSION = 2;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            DownloadEntry.SCHEMA.createTables(sQLiteDatabase);
            for (File file : DownloadCache.this.mRoot.listFiles()) {
                if (!file.delete()) {
                    Log.m448w(DownloadCache.TAG, "fail to remove: " + file.getAbsolutePath());
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DownloadEntry.SCHEMA.dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    private class DownloadTask implements FutureListener<File>, Job<File> {
        private Future<File> mFuture;
        private HashSet<TaskProxy> mProxySet = new HashSet();
        private final String mUrl;

        public DownloadTask(String str) {
            this.mUrl = (String) Utils.checkNotNull(str);
        }

        public void addProxy(TaskProxy taskProxy) {
            taskProxy.mTask = this;
            this.mProxySet.add(taskProxy);
        }

        public void onFutureDone(Future<File> future) {
            File file = (File) future.get();
            long j = 0;
            if (file != null) {
                j = DownloadCache.this.insertEntry(this.mUrl, file);
            }
            if (future.isCancelled()) {
                Utils.assertTrue(this.mProxySet.isEmpty());
                return;
            }
            synchronized (DownloadCache.this.mTaskMap) {
                Entry entry = null;
                synchronized (DownloadCache.this.mEntryMap) {
                    if (file != null) {
                        entry = new Entry(j, file);
                        Utils.assertTrue(DownloadCache.this.mEntryMap.put(this.mUrl, entry) == null);
                    }
                }
                Iterator it = this.mProxySet.iterator();
                while (it.hasNext()) {
                    ((TaskProxy) it.next()).setResult(entry);
                }
                DownloadCache.this.mTaskMap.remove(this.mUrl);
                DownloadCache.this.freeSomeSpaceIfNeed(16);
            }
        }

        public void removeProxy(TaskProxy taskProxy) {
            synchronized (DownloadCache.this.mTaskMap) {
                Utils.assertTrue(this.mProxySet.remove(taskProxy));
                if (this.mProxySet.isEmpty()) {
                    this.mFuture.cancel();
                    DownloadCache.this.mTaskMap.remove(this.mUrl);
                }
            }
        }

        public File run(JobContext jobContext) {
            File createTempFile;
            File file;
            Throwable th;
            jobContext.setMode(2);
            try {
                URL url = new URL(this.mUrl);
                createTempFile = File.createTempFile("cache", ".tmp", DownloadCache.this.mRoot);
                try {
                    jobContext.setMode(2);
                    boolean requestDownload = DownloadUtils.requestDownload(jobContext, url, createTempFile);
                    jobContext.setMode(0);
                    if (requestDownload) {
                        jobContext.setMode(0);
                        return createTempFile;
                    }
                    jobContext.setMode(0);
                    if (createTempFile != null) {
                        createTempFile.delete();
                    }
                    return null;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    file = createTempFile;
                    th = th2;
                    try {
                        Log.m443e(DownloadCache.TAG, String.format("fail to download %s", new Object[]{this.mUrl}), th);
                        createTempFile = file;
                        if (createTempFile != null) {
                            createTempFile.delete();
                        }
                        return null;
                    } finally {
                        jobContext.setMode(0);
                    }
                }
            } catch (Exception e2) {
                th = e2;
                file = null;
                Log.m443e(DownloadCache.TAG, String.format("fail to download %s", new Object[]{this.mUrl}), th);
                createTempFile = file;
                if (createTempFile != null) {
                    createTempFile.delete();
                }
                return null;
            }
        }
    }

    public class Entry {
        public File cacheFile;
        protected long mId;

        Entry(long j, File file) {
            this.mId = j;
            this.cacheFile = (File) Utils.checkNotNull(file);
        }
    }

    public static class TaskProxy {
        private Entry mEntry;
        private boolean mIsCancelled = false;
        private DownloadTask mTask;

        class C05291 implements CancelListener {
            C05291() {
            }

            public void onCancel() {
                TaskProxy.this.mTask.removeProxy(TaskProxy.this);
                synchronized (TaskProxy.this) {
                    TaskProxy.this.mIsCancelled = true;
                    TaskProxy.this.notifyAll();
                }
            }
        }

        public synchronized Entry get(JobContext jobContext) {
            jobContext.setCancelListener(new C05291());
            while (!this.mIsCancelled && this.mEntry == null) {
                try {
                    wait();
                } catch (Throwable e) {
                    Log.m449w(DownloadCache.TAG, "ignore interrupt", e);
                }
            }
            jobContext.setCancelListener(null);
            return this.mEntry;
        }

        synchronized void setResult(Entry entry) {
            if (!this.mIsCancelled) {
                this.mEntry = entry;
                notifyAll();
            }
        }
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = String.format("sum(%s)", new Object[]{DownloadEntry.Columns.CONTENT_SIZE});
        SUM_PROJECTION = strArr;
    }

    public DownloadCache(GalleryApp galleryApp, File file, long j) {
        this.mRoot = (File) Utils.checkNotNull(file);
        this.mApplication = (GalleryApp) Utils.checkNotNull(galleryApp);
        this.mCapacity = j;
        this.mDatabase = new DatabaseHelper(galleryApp.getAndroidContext()).getWritableDatabase();
    }

    private Entry findEntryInDatabase(String str) {
        Entry entry = null;
        Cursor query = this.mDatabase.query(TABLE_NAME, QUERY_PROJECTION, WHERE_HASH_AND_URL, new String[]{String.valueOf(Utils.crc64Long(str)), str}, null, null, null);
        try {
            if (query.moveToNext()) {
                File file = new File(query.getString(1));
                long j = (long) query.getInt(0);
                synchronized (this.mEntryMap) {
                    Entry entry2 = (Entry) this.mEntryMap.get(str);
                    if (entry2 == null) {
                        entry = new Entry(j, file);
                        this.mEntryMap.put(str, entry);
                    } else {
                        entry = entry2;
                    }
                }
            } else {
                query.close();
            }
            return entry;
        } finally {
            query.close();
        }
    }

    private synchronized void freeSomeSpaceIfNeed(int i) {
        if (this.mTotalBytes > this.mCapacity) {
            Cursor query = this.mDatabase.query(TABLE_NAME, FREESPACE_PROJECTION, null, null, null, null, FREESPACE_ORDER_BY);
            int i2 = i;
            while (i2 > 0) {
                if (this.mTotalBytes > this.mCapacity && query.moveToNext()) {
                    boolean containsKey;
                    long j = query.getLong(0);
                    String string = query.getString(2);
                    long j2 = query.getLong(3);
                    String string2 = query.getString(1);
                    synchronized (this.mEntryMap) {
                        containsKey = this.mEntryMap.containsKey(string);
                    }
                    if (!containsKey) {
                        i2--;
                        try {
                            this.mTotalBytes -= j2;
                            new File(string2).delete();
                            this.mDatabase.delete(TABLE_NAME, ID_WHERE, new String[]{String.valueOf(j)});
                        } catch (Throwable th) {
                            query.close();
                        }
                    }
                }
            }
            query.close();
        }
    }

    private synchronized void initialize() {
        if (!this.mInitialized) {
            this.mInitialized = true;
            if (!this.mRoot.isDirectory()) {
                this.mRoot.mkdirs();
            }
            if (this.mRoot.isDirectory()) {
                Cursor query = this.mDatabase.query(TABLE_NAME, SUM_PROJECTION, null, null, null, null, null);
                this.mTotalBytes = 0;
                try {
                    if (query.moveToNext()) {
                        this.mTotalBytes = query.getLong(0);
                    }
                    if (this.mTotalBytes > this.mCapacity) {
                        freeSomeSpaceIfNeed(16);
                    }
                } finally {
                    query.close();
                }
            } else {
                throw new RuntimeException("cannot create " + this.mRoot.getAbsolutePath());
            }
        }
    }

    private synchronized long insertEntry(String str, File file) {
        ContentValues contentValues;
        long length = file.length();
        this.mTotalBytes += length;
        contentValues = new ContentValues();
        String valueOf = String.valueOf(Utils.crc64Long(str));
        contentValues.put(DownloadEntry.Columns.DATA, file.getAbsolutePath());
        contentValues.put("hash_code", valueOf);
        contentValues.put("content_url", str);
        contentValues.put(DownloadEntry.Columns.CONTENT_SIZE, Long.valueOf(length));
        contentValues.put(DownloadEntry.Columns.LAST_UPDATED, Long.valueOf(System.currentTimeMillis()));
        return this.mDatabase.insert(TABLE_NAME, "", contentValues);
    }

    private void updateLastAccess(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
        this.mDatabase.update(TABLE_NAME, contentValues, ID_WHERE, new String[]{String.valueOf(j)});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.gallery3d.data.DownloadCache.Entry download(com.android.gallery3d.util.ThreadPool.JobContext r7, java.net.URL r8) {
        /*
        r6 = this;
        r0 = r6.mInitialized;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r6.initialize();
    L_0x0007:
        r1 = r8.toString();
        r2 = r6.mEntryMap;
        monitor-enter(r2);
        r0 = r6.mEntryMap;	 Catch:{ all -> 0x0038 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0038 }
        r0 = (com.android.gallery3d.data.DownloadCache.Entry) r0;	 Catch:{ all -> 0x0038 }
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r4 = r0.mId;	 Catch:{ all -> 0x0038 }
        r6.updateLastAccess(r4);	 Catch:{ all -> 0x0038 }
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
    L_0x001e:
        return r0;
    L_0x001f:
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        r2 = new com.android.gallery3d.data.DownloadCache$TaskProxy;
        r2.<init>();
        r3 = r6.mTaskMap;
        monitor-enter(r3);
        r0 = r6.findEntryInDatabase(r1);	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x003b;
    L_0x002e:
        r4 = r0.mId;	 Catch:{ all -> 0x0035 }
        r6.updateLastAccess(r4);	 Catch:{ all -> 0x0035 }
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        goto L_0x001e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r0 = r6.mTaskMap;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0035 }
        r0 = (com.android.gallery3d.data.DownloadCache.DownloadTask) r0;	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x005c;
    L_0x0045:
        r0 = new com.android.gallery3d.data.DownloadCache$DownloadTask;	 Catch:{ all -> 0x0035 }
        r0.<init>(r1);	 Catch:{ all -> 0x0035 }
        r4 = r6.mTaskMap;	 Catch:{ all -> 0x0035 }
        r4.put(r1, r0);	 Catch:{ all -> 0x0035 }
        r1 = r6.mApplication;	 Catch:{ all -> 0x0035 }
        r1 = r1.getThreadPool();	 Catch:{ all -> 0x0035 }
        r1 = r1.submit(r0, r0);	 Catch:{ all -> 0x0035 }
        r0.mFuture = r1;	 Catch:{ all -> 0x0035 }
    L_0x005c:
        r0.addProxy(r2);	 Catch:{ all -> 0x0035 }
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        r0 = r2.get(r7);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.data.DownloadCache.download(com.android.gallery3d.util.ThreadPool$JobContext, java.net.URL):com.android.gallery3d.data.DownloadCache$Entry");
    }
}
