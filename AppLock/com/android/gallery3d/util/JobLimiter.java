package com.android.gallery3d.util;

import com.android.gallery3d.common.Utils;
import com.android.gallery3d.util.ThreadPool.Job;
import java.util.LinkedList;

public class JobLimiter implements FutureListener {
    private static final int STATE_CANCELLED = 2;
    private static final int STATE_DONE = 1;
    private static final int STATE_INIT = 0;
    private static final String TAG = "JobLimiter";
    private final LinkedList<JobWrapper<?>> mJobs = new LinkedList();
    private int mLimit;
    private final ThreadPool mPool;

    private static class JobWrapper<T> implements Future<T>, Job<T> {
        private Future<T> mDelegate;
        private Job<T> mJob;
        private FutureListener<T> mListener;
        private T mResult;
        private int mState = 0;

        public JobWrapper(Job<T> job, FutureListener<T> futureListener) {
            this.mJob = job;
            this.mListener = futureListener;
        }

        public void cancel() {
            FutureListener futureListener = null;
            synchronized (this) {
                if (this.mState != 1) {
                    futureListener = this.mListener;
                    this.mJob = null;
                    this.mListener = null;
                    if (this.mDelegate != null) {
                        this.mDelegate.cancel();
                        this.mDelegate = null;
                    }
                }
                this.mState = 2;
                this.mResult = null;
                notifyAll();
            }
            if (futureListener != null) {
                futureListener.onFutureDone(this);
            }
        }

        public synchronized T get() {
            while (this.mState == 0) {
                Utils.waitWithoutInterrupt(this);
            }
            return this.mResult;
        }

        public synchronized boolean isCancelled() {
            return this.mState == 2;
        }

        public boolean isDone() {
            return this.mState != 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T run(com.android.gallery3d.util.ThreadPool.JobContext r8) {
            /*
            r7 = this;
            r6 = 2;
            r1 = 0;
            monitor-enter(r7);
            r0 = r7.mState;	 Catch:{ all -> 0x001a }
            if (r0 != r6) goto L_0x0009;
        L_0x0007:
            monitor-exit(r7);	 Catch:{ all -> 0x001a }
        L_0x0008:
            return r1;
        L_0x0009:
            r0 = r7.mJob;	 Catch:{ all -> 0x001a }
            monitor-exit(r7);	 Catch:{ all -> 0x001a }
            r0 = r0.run(r8);	 Catch:{ Throwable -> 0x001d }
        L_0x0010:
            monitor-enter(r7);
            r2 = r7.mState;	 Catch:{ all -> 0x0017 }
            if (r2 != r6) goto L_0x0038;
        L_0x0015:
            monitor-exit(r7);	 Catch:{ all -> 0x0017 }
            goto L_0x0008;
        L_0x0017:
            r0 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0017 }
            throw r0;
        L_0x001a:
            r0 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x001a }
            throw r0;
        L_0x001d:
            r2 = move-exception;
            r3 = "JobLimiter";
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "error executing job: ";
            r4 = r4.append(r5);
            r0 = r4.append(r0);
            r0 = r0.toString();
            com.android.gallery3d.util.Log.m471w(r3, r0, r2);
            r0 = r1;
            goto L_0x0010;
        L_0x0038:
            r1 = 1;
            r7.mState = r1;	 Catch:{ all -> 0x0017 }
            r1 = r7.mListener;	 Catch:{ all -> 0x0017 }
            r2 = 0;
            r7.mListener = r2;	 Catch:{ all -> 0x0017 }
            r2 = 0;
            r7.mJob = r2;	 Catch:{ all -> 0x0017 }
            r7.mResult = r0;	 Catch:{ all -> 0x0017 }
            r7.notifyAll();	 Catch:{ all -> 0x0017 }
            monitor-exit(r7);	 Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x004e;
        L_0x004b:
            r1.onFutureDone(r7);
        L_0x004e:
            r1 = r0;
            goto L_0x0008;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.util.JobLimiter.JobWrapper.run(com.android.gallery3d.util.ThreadPool$JobContext):T");
        }

        public synchronized void setFuture(Future<T> future) {
            if (this.mState == 0) {
                this.mDelegate = future;
            }
        }

        public void waitDone() {
            get();
        }
    }

    public JobLimiter(ThreadPool threadPool, int i) {
        this.mPool = (ThreadPool) Utils.checkNotNull(threadPool);
        this.mLimit = i;
    }

    private void submitTasksIfAllowed() {
        while (this.mLimit > 0 && !this.mJobs.isEmpty()) {
            JobWrapper jobWrapper = (JobWrapper) this.mJobs.removeFirst();
            if (!jobWrapper.isCancelled()) {
                this.mLimit--;
                jobWrapper.setFuture(this.mPool.submit(jobWrapper, this));
            }
        }
    }

    public synchronized void onFutureDone(Future future) {
        this.mLimit++;
        submitTasksIfAllowed();
    }

    public synchronized <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        Future jobWrapper;
        jobWrapper = new JobWrapper((Job) Utils.checkNotNull(job), futureListener);
        this.mJobs.addLast(jobWrapper);
        submitTasksIfAllowed();
        return jobWrapper;
    }
}
