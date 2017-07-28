package com.android.gallery3d.app;

import android.graphics.Bitmap;
import com.android.gallery3d.app.SlideshowPage.Model;
import com.android.gallery3d.app.SlideshowPage.Slide;
import com.android.gallery3d.data.ContentListener;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import com.android.gallery3d.util.ThreadPool;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class SlideshowDataAdapter implements Model {
    private static final int IMAGE_QUEUE_CAPACITY = 3;
    private static final String TAG = "SlideshowDataAdapter";
    private boolean mDataReady;
    private long mDataVersion = -1;
    private final LinkedList<Slide> mImageQueue = new LinkedList();
    private Path mInitialPath;
    private boolean mIsActive = false;
    private int mLoadIndex = 0;
    private final AtomicBoolean mNeedReload = new AtomicBoolean(false);
    private boolean mNeedReset;
    private int mNextOutput = 0;
    private Future<Void> mReloadTask;
    private final SlideshowSource mSource;
    private final SourceListener mSourceListener = new SourceListener();
    private final ThreadPool mThreadPool;

    class C05201 implements Job<Slide> {
        C05201() {
        }

        public Slide run(JobContext jobContext) {
            jobContext.setMode(0);
            return SlideshowDataAdapter.this.innerNextBitmap();
        }
    }

    private class ReloadTask implements Job<Void> {
        private ReloadTask() {
        }

        public Void run(JobContext jobContext) {
            while (true) {
                synchronized (SlideshowDataAdapter.this) {
                    while (SlideshowDataAdapter.this.mIsActive && (!SlideshowDataAdapter.this.mDataReady || SlideshowDataAdapter.this.mImageQueue.size() >= 3)) {
                        try {
                            SlideshowDataAdapter.this.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
                if (!SlideshowDataAdapter.this.mIsActive) {
                    return null;
                }
                SlideshowDataAdapter.this.mNeedReset = false;
                MediaItem access$500 = SlideshowDataAdapter.this.loadItem();
                if (SlideshowDataAdapter.this.mNeedReset) {
                    synchronized (SlideshowDataAdapter.this) {
                        SlideshowDataAdapter.this.mImageQueue.clear();
                        SlideshowDataAdapter.this.mLoadIndex = SlideshowDataAdapter.this.mNextOutput;
                    }
                } else if (access$500 == null) {
                    synchronized (SlideshowDataAdapter.this) {
                        if (!SlideshowDataAdapter.this.mNeedReload.get()) {
                            SlideshowDataAdapter.this.mDataReady = false;
                        }
                        SlideshowDataAdapter.this.notifyAll();
                    }
                } else {
                    Bitmap bitmap = (Bitmap) access$500.requestImage(1).run(jobContext);
                    if (bitmap != null) {
                        synchronized (SlideshowDataAdapter.this) {
                            SlideshowDataAdapter.this.mImageQueue.addLast(new Slide(access$500, SlideshowDataAdapter.this.mLoadIndex, bitmap));
                            if (SlideshowDataAdapter.this.mImageQueue.size() == 1) {
                                SlideshowDataAdapter.this.notifyAll();
                            }
                        }
                    }
                    SlideshowDataAdapter.access$604(SlideshowDataAdapter.this);
                }
            }
        }
    }

    public interface SlideshowSource {
        void addContentListener(ContentListener contentListener);

        int findItemIndex(Path path, int i);

        MediaItem getMediaItem(int i);

        long reload();

        void removeContentListener(ContentListener contentListener);
    }

    private class SourceListener implements ContentListener {
        private SourceListener() {
        }

        public void onContentDirty() {
            synchronized (SlideshowDataAdapter.this) {
                SlideshowDataAdapter.this.mNeedReload.set(true);
                SlideshowDataAdapter.this.mDataReady = true;
                SlideshowDataAdapter.this.notifyAll();
            }
        }
    }

    public SlideshowDataAdapter(GalleryContext galleryContext, SlideshowSource slideshowSource, int i, Path path) {
        this.mSource = slideshowSource;
        this.mInitialPath = path;
        this.mLoadIndex = i;
        this.mNextOutput = i;
        this.mThreadPool = galleryContext.getThreadPool();
    }

    static /* synthetic */ int access$604(SlideshowDataAdapter slideshowDataAdapter) {
        int i = slideshowDataAdapter.mLoadIndex + 1;
        slideshowDataAdapter.mLoadIndex = i;
        return i;
    }

    private synchronized Slide innerNextBitmap() {
        Slide slide;
        while (this.mIsActive && this.mDataReady && this.mImageQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new AssertionError();
            }
        }
        if (this.mImageQueue.isEmpty()) {
            slide = null;
        } else {
            this.mNextOutput++;
            notifyAll();
            slide = (Slide) this.mImageQueue.removeFirst();
        }
        return slide;
    }

    private MediaItem loadItem() {
        if (this.mNeedReload.compareAndSet(true, false)) {
            long reload = this.mSource.reload();
            if (reload != this.mDataVersion) {
                this.mDataVersion = reload;
                this.mNeedReset = true;
                return null;
            }
        }
        int i = this.mLoadIndex;
        if (this.mInitialPath != null) {
            i = this.mSource.findItemIndex(this.mInitialPath, i);
            this.mInitialPath = null;
        }
        return this.mSource.getMediaItem(i);
    }

    public Future<Slide> nextSlide(FutureListener<Slide> futureListener) {
        return this.mThreadPool.submit(new C05201(), futureListener);
    }

    public void pause() {
        synchronized (this) {
            this.mIsActive = false;
            notifyAll();
        }
        this.mSource.removeContentListener(this.mSourceListener);
        this.mReloadTask.cancel();
        this.mReloadTask.waitDone();
        this.mReloadTask = null;
    }

    public synchronized void resume() {
        this.mIsActive = true;
        this.mSource.addContentListener(this.mSourceListener);
        this.mNeedReload.set(true);
        this.mDataReady = true;
        this.mReloadTask = this.mThreadPool.submit(new ReloadTask());
    }
}
