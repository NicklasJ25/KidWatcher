package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;

public abstract class BitmapLoader implements FutureListener<Bitmap> {
    private static final int STATE_ERROR = 3;
    private static final int STATE_INIT = 0;
    private static final int STATE_LOADED = 2;
    private static final int STATE_RECYCLED = 4;
    private static final int STATE_REQUESTED = 1;
    private static final String TAG = "BitmapLoader";
    private Bitmap mBitmap;
    private int mState = 0;
    private Future<Bitmap> mTask;

    public synchronized void cancelLoad() {
        if (this.mState == 1) {
            this.mState = 0;
            if (this.mTask != null) {
                this.mTask.cancel();
            }
        }
    }

    public synchronized Bitmap getBitmap() {
        return this.mBitmap;
    }

    public synchronized boolean isRecycled() {
        return this.mState == 4;
    }

    public synchronized boolean isRequestInProgress() {
        boolean z = true;
        synchronized (this) {
            if (this.mState != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFutureDone(com.android.gallery3d.util.Future<android.graphics.Bitmap> r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = 0;
        r2.mTask = r0;	 Catch:{ all -> 0x0036 }
        r0 = r3.get();	 Catch:{ all -> 0x0036 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0036 }
        r2.mBitmap = r0;	 Catch:{ all -> 0x0036 }
        r0 = r2.mState;	 Catch:{ all -> 0x0036 }
        r1 = 4;
        if (r0 != r1) goto L_0x001f;
    L_0x0011:
        r0 = r2.mBitmap;	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r0 = r2.mBitmap;	 Catch:{ all -> 0x0036 }
        r2.recycleBitmap(r0);	 Catch:{ all -> 0x0036 }
        r0 = 0;
        r2.mBitmap = r0;	 Catch:{ all -> 0x0036 }
    L_0x001d:
        monitor-exit(r2);	 Catch:{ all -> 0x0036 }
    L_0x001e:
        return;
    L_0x001f:
        r0 = r3.isCancelled();	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x0039;
    L_0x0025:
        r0 = r2.mBitmap;	 Catch:{ all -> 0x0036 }
        if (r0 != 0) goto L_0x0039;
    L_0x0029:
        r0 = r2.mState;	 Catch:{ all -> 0x0036 }
        r1 = 1;
        if (r0 != r1) goto L_0x0034;
    L_0x002e:
        r0 = r2.submitBitmapTask(r2);	 Catch:{ all -> 0x0036 }
        r2.mTask = r0;	 Catch:{ all -> 0x0036 }
    L_0x0034:
        monitor-exit(r2);	 Catch:{ all -> 0x0036 }
        goto L_0x001e;
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0036 }
        throw r0;
    L_0x0039:
        r0 = r2.mBitmap;	 Catch:{ all -> 0x0036 }
        if (r0 != 0) goto L_0x0047;
    L_0x003d:
        r0 = 3;
    L_0x003e:
        r2.mState = r0;	 Catch:{ all -> 0x0036 }
        monitor-exit(r2);	 Catch:{ all -> 0x0036 }
        r0 = r2.mBitmap;
        r2.onLoadComplete(r0);
        goto L_0x001e;
    L_0x0047:
        r0 = 2;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.BitmapLoader.onFutureDone(com.android.gallery3d.util.Future):void");
    }

    protected abstract void onLoadComplete(Bitmap bitmap);

    public synchronized void recycle() {
        this.mState = 4;
        if (this.mBitmap != null) {
            recycleBitmap(this.mBitmap);
            this.mBitmap = null;
        }
        if (this.mTask != null) {
            this.mTask.cancel();
        }
    }

    protected abstract void recycleBitmap(Bitmap bitmap);

    public synchronized void startLoad() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.mTask == null) {
                this.mTask = submitBitmapTask(this);
            }
        }
    }

    protected abstract Future<Bitmap> submitBitmapTask(FutureListener<Bitmap> futureListener);
}
