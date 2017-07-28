package com.android.gallery3d.util;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static final int CORE_POOL_SIZE = 4;
    public static final JobContext JOB_CONTEXT_STUB = new JobContextStub();
    private static final int KEEP_ALIVE_TIME = 10;
    private static final int MAX_POOL_SIZE = 8;
    public static final int MODE_CPU = 1;
    public static final int MODE_NETWORK = 2;
    public static final int MODE_NONE = 0;
    private static final String TAG = "ThreadPool";
    ResourceCounter mCpuCounter;
    private final Executor mExecutor;
    ResourceCounter mNetworkCounter;

    public interface Job<T> {
        T run(JobContext jobContext);
    }

    public interface CancelListener {
        void onCancel();
    }

    public interface JobContext {
        boolean isCancelled();

        void setCancelListener(CancelListener cancelListener);

        boolean setMode(int i);
    }

    private static class JobContextStub implements JobContext {
        private JobContextStub() {
        }

        public boolean isCancelled() {
            return false;
        }

        public void setCancelListener(CancelListener cancelListener) {
        }

        public boolean setMode(int i) {
            return true;
        }
    }

    private static class ResourceCounter {
        public int value;

        public ResourceCounter(int i) {
            this.value = i;
        }
    }

    private class Worker<T> implements Future<T>, JobContext, Runnable {
        private static final String TAG = "Worker";
        private CancelListener mCancelListener;
        private volatile boolean mIsCancelled;
        private boolean mIsDone;
        private Job<T> mJob;
        private FutureListener<T> mListener;
        private int mMode;
        private T mResult;
        private ResourceCounter mWaitOnResource;

        public Worker(Job<T> job, FutureListener<T> futureListener) {
            this.mJob = job;
            this.mListener = futureListener;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean acquireResource(com.android.gallery3d.util.ThreadPool.ResourceCounter r2) {
            /*
            r1 = this;
        L_0x0000:
            monitor-enter(r1);
            r0 = r1.mIsCancelled;	 Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x000b;
        L_0x0005:
            r0 = 0;
            r1.mWaitOnResource = r0;	 Catch:{ all -> 0x0021 }
            r0 = 0;
            monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        L_0x000a:
            return r0;
        L_0x000b:
            r1.mWaitOnResource = r2;	 Catch:{ all -> 0x0021 }
            monitor-exit(r1);	 Catch:{ all -> 0x0021 }
            monitor-enter(r2);
            r0 = r2.value;	 Catch:{ all -> 0x0029 }
            if (r0 <= 0) goto L_0x0024;
        L_0x0013:
            r0 = r2.value;	 Catch:{ all -> 0x0029 }
            r0 = r0 + -1;
            r2.value = r0;	 Catch:{ all -> 0x0029 }
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            monitor-enter(r1);
            r0 = 0;
            r1.mWaitOnResource = r0;	 Catch:{ all -> 0x002c }
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            r0 = 1;
            goto L_0x000a;
        L_0x0021:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0021 }
            throw r0;
        L_0x0024:
            r2.wait();	 Catch:{ InterruptedException -> 0x002f }
        L_0x0027:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            goto L_0x0000;
        L_0x0029:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            throw r0;
        L_0x002c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            throw r0;
        L_0x002f:
            r0 = move-exception;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.util.ThreadPool.Worker.acquireResource(com.android.gallery3d.util.ThreadPool$ResourceCounter):boolean");
        }

        private ResourceCounter modeToCounter(int i) {
            return i == 1 ? ThreadPool.this.mCpuCounter : i == 2 ? ThreadPool.this.mNetworkCounter : null;
        }

        private void releaseResource(ResourceCounter resourceCounter) {
            synchronized (resourceCounter) {
                resourceCounter.value++;
                resourceCounter.notifyAll();
            }
        }

        public synchronized void cancel() {
            if (!this.mIsCancelled) {
                this.mIsCancelled = true;
                if (this.mWaitOnResource != null) {
                    synchronized (this.mWaitOnResource) {
                        this.mWaitOnResource.notifyAll();
                    }
                }
                if (this.mCancelListener != null) {
                    this.mCancelListener.onCancel();
                }
            }
        }

        public synchronized T get() {
            while (!this.mIsDone) {
                try {
                    wait();
                } catch (Throwable e) {
                    Log.w(TAG, "ingore exception", e);
                }
            }
            return this.mResult;
        }

        public boolean isCancelled() {
            return this.mIsCancelled;
        }

        public synchronized boolean isDone() {
            return this.mIsDone;
        }

        public void run() {
            Object obj = null;
            if (setMode(1)) {
                try {
                    obj = this.mJob.run(this);
                } catch (Throwable th) {
                    Log.w(TAG, "Exception in running a job", th);
                }
            }
            synchronized (this) {
                setMode(0);
                this.mResult = obj;
                this.mIsDone = true;
                notifyAll();
            }
            if (this.mListener != null) {
                this.mListener.onFutureDone(this);
            }
        }

        public synchronized void setCancelListener(CancelListener cancelListener) {
            this.mCancelListener = cancelListener;
            if (this.mIsCancelled && this.mCancelListener != null) {
                this.mCancelListener.onCancel();
            }
        }

        public boolean setMode(int i) {
            ResourceCounter modeToCounter = modeToCounter(this.mMode);
            if (modeToCounter != null) {
                releaseResource(modeToCounter);
            }
            this.mMode = 0;
            modeToCounter = modeToCounter(i);
            if (modeToCounter != null) {
                if (!acquireResource(modeToCounter)) {
                    return false;
                }
                this.mMode = i;
            }
            return true;
        }

        public void waitDone() {
            get();
        }
    }

    public ThreadPool() {
        this(4, 8);
    }

    public ThreadPool(int i, int i2) {
        this.mCpuCounter = new ResourceCounter(2);
        this.mNetworkCounter = new ResourceCounter(2);
        this.mExecutor = new ThreadPoolExecutor(i, i2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("thread-pool", 10));
    }

    public <T> Future<T> submit(Job<T> job) {
        return submit(job, null);
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        Object worker = new Worker(job, futureListener);
        this.mExecutor.execute(worker);
        return worker;
    }
}
