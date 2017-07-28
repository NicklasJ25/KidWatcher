package com.android.gallery3d.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.anim.CanvasAnimation;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.ui.GLRoot.OnGLIdleListener;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.MotionEventHelper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class GLRootView extends GLSurfaceView implements Renderer, GLRoot {
    private static final boolean DEBUG_DRAWING_STAT = false;
    private static final boolean DEBUG_FPS = false;
    private static final boolean DEBUG_INVALIDATE = false;
    private static final boolean DEBUG_PROFILE = false;
    private static final boolean DEBUG_PROFILE_SLOW_ONLY = false;
    private static final int FLAG_INITIALIZED = 1;
    private static final int FLAG_NEED_LAYOUT = 2;
    private static final String TAG = "GLRootView";
    private final ArrayList<CanvasAnimation> mAnimations;
    private GLCanvas mCanvas;
    private int mCompensation;
    private Matrix mCompensationMatrix;
    private GLView mContentView;
    private int mDisplayRotation;
    private final GalleryEGLConfigChooser mEglConfigChooser;
    private boolean mFirstDraw;
    private int mFlags;
    private int mFrameCount;
    private long mFrameCountingStart;
    private boolean mFreeze;
    private final Condition mFreezeCondition;
    private GL11 mGL;
    private final ArrayDeque<OnGLIdleListener> mIdleListeners;
    private final IdleRunner mIdleRunner;
    private boolean mInDownState;
    private int mInvalidateColor;
    private long mLastDrawFinishTime;
    private OrientationSource mOrientationSource;
    private final ReentrantLock mRenderLock;
    private volatile boolean mRenderRequested;
    private Runnable mRequestRenderOnAnimationFrame;

    class C05391 implements Runnable {
        C05391() {
        }

        public void run() {
            GLRootView.this.superRequestRender();
        }
    }

    class C05402 implements Runnable {
        C05402() {
        }

        public void run() {
            GLRootView.this.getRootView().findViewById(C0488R.id.gl_root_cover).setVisibility(8);
        }
    }

    private class IdleRunner implements Runnable {
        private boolean mActive;

        private IdleRunner() {
            this.mActive = false;
        }

        public void enable() {
            if (!this.mActive) {
                this.mActive = true;
                GLRootView.this.queueEvent(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = com.android.gallery3d.ui.GLRootView.this;
            r1 = r0.mIdleListeners;
            monitor-enter(r1);
            r0 = 0;
            r3.mActive = r0;	 Catch:{ all -> 0x0075 }
            r0 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0075 }
            r0 = r0.mIdleListeners;	 Catch:{ all -> 0x0075 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r1);	 Catch:{ all -> 0x0075 }
        L_0x0017:
            return;
        L_0x0018:
            r0 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0075 }
            r0 = r0.mIdleListeners;	 Catch:{ all -> 0x0075 }
            r0 = r0.removeFirst();	 Catch:{ all -> 0x0075 }
            r0 = (com.android.gallery3d.ui.GLRoot.OnGLIdleListener) r0;	 Catch:{ all -> 0x0075 }
            monitor-exit(r1);	 Catch:{ all -> 0x0075 }
            r1 = com.android.gallery3d.ui.GLRootView.this;
            r1 = r1.mRenderLock;
            r1.lock();
            r1 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0078 }
            r1 = r1.mCanvas;	 Catch:{ all -> 0x0078 }
            r2 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0078 }
            r2 = r2.mRenderRequested;	 Catch:{ all -> 0x0078 }
            r1 = r0.onGLIdle(r1, r2);	 Catch:{ all -> 0x0078 }
            r2 = com.android.gallery3d.ui.GLRootView.this;
            r2 = r2.mRenderLock;
            r2.unlock();
            r2 = com.android.gallery3d.ui.GLRootView.this;
            r2 = r2.mIdleListeners;
            monitor-enter(r2);
            if (r1 == 0) goto L_0x0059;
        L_0x0050:
            r1 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0072 }
            r1 = r1.mIdleListeners;	 Catch:{ all -> 0x0072 }
            r1.addLast(r0);	 Catch:{ all -> 0x0072 }
        L_0x0059:
            r0 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0072 }
            r0 = r0.mRenderRequested;	 Catch:{ all -> 0x0072 }
            if (r0 != 0) goto L_0x0070;
        L_0x0061:
            r0 = com.android.gallery3d.ui.GLRootView.this;	 Catch:{ all -> 0x0072 }
            r0 = r0.mIdleListeners;	 Catch:{ all -> 0x0072 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
            if (r0 != 0) goto L_0x0070;
        L_0x006d:
            r3.enable();	 Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r2);	 Catch:{ all -> 0x0072 }
            goto L_0x0017;
        L_0x0072:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0072 }
            throw r0;
        L_0x0075:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0075 }
            throw r0;
        L_0x0078:
            r0 = move-exception;
            r1 = com.android.gallery3d.ui.GLRootView.this;
            r1 = r1.mRenderLock;
            r1.unlock();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.GLRootView.IdleRunner.run():void");
        }
    }

    public GLRootView(Context context) {
        this(context, null);
    }

    public GLRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrameCount = 0;
        this.mFrameCountingStart = 0;
        this.mInvalidateColor = 0;
        this.mCompensationMatrix = new Matrix();
        this.mFlags = 2;
        this.mRenderRequested = false;
        this.mEglConfigChooser = new GalleryEGLConfigChooser();
        this.mAnimations = new ArrayList();
        this.mIdleListeners = new ArrayDeque();
        this.mIdleRunner = new IdleRunner();
        this.mRenderLock = new ReentrantLock();
        this.mFreezeCondition = this.mRenderLock.newCondition();
        this.mInDownState = false;
        this.mFirstDraw = true;
        this.mRequestRenderOnAnimationFrame = new C05391();
        this.mFlags |= 1;
        setBackgroundDrawable(null);
        setEGLConfigChooser(this.mEglConfigChooser);
        setRenderer(this);
        if (ApiHelper.USE_888_PIXEL_FORMAT) {
            getHolder().setFormat(3);
        } else {
            getHolder().setFormat(4);
        }
    }

    private void layoutContentPane() {
        int displayRotation;
        int compensation;
        this.mFlags &= -3;
        int width = getWidth();
        int height = getHeight();
        if (this.mOrientationSource != null) {
            displayRotation = this.mOrientationSource.getDisplayRotation();
            compensation = this.mOrientationSource.getCompensation();
        } else {
            compensation = 0;
            displayRotation = 0;
        }
        if (this.mCompensation != compensation) {
            this.mCompensation = compensation;
            if (this.mCompensation % FadeTexture.DURATION != 0) {
                this.mCompensationMatrix.setRotate((float) this.mCompensation);
                this.mCompensationMatrix.preTranslate((float) ((-width) / 2), (float) ((-height) / 2));
                this.mCompensationMatrix.postTranslate((float) (height / 2), (float) (width / 2));
            } else {
                this.mCompensationMatrix.setRotate((float) this.mCompensation, (float) (width / 2), (float) (height / 2));
            }
        }
        this.mDisplayRotation = displayRotation;
        if (this.mCompensation % FadeTexture.DURATION != 0) {
            compensation = width;
        } else {
            compensation = height;
            height = width;
        }
        Log.m455i(TAG, "layout content pane " + height + "x" + compensation + " (compensation " + this.mCompensation + ")");
        if (this.mContentView != null && height != 0 && compensation != 0) {
            this.mContentView.layout(0, 0, height, compensation);
        }
    }

    private void onDrawFrameLocked(GL10 gl10) {
        this.mCanvas.deleteRecycledResources();
        UploadedTexture.resetUploadLimit();
        this.mRenderRequested = false;
        if ((this.mFlags & 2) != 0) {
            layoutContentPane();
        }
        this.mCanvas.save(-1);
        rotateCanvas(-this.mCompensation);
        if (this.mContentView != null) {
            this.mContentView.render(this.mCanvas);
        }
        this.mCanvas.restore();
        if (!this.mAnimations.isEmpty()) {
            long j = AnimationTime.get();
            int size = this.mAnimations.size();
            for (int i = 0; i < size; i++) {
                ((CanvasAnimation) this.mAnimations.get(i)).setStartTime(j);
            }
            this.mAnimations.clear();
        }
        if (UploadedTexture.uploadLimitReached()) {
            requestRender();
        }
        synchronized (this.mIdleListeners) {
            if (!this.mIdleListeners.isEmpty()) {
                this.mIdleRunner.enable();
            }
        }
    }

    private void outputFps() {
        long nanoTime = System.nanoTime();
        if (this.mFrameCountingStart == 0) {
            this.mFrameCountingStart = nanoTime;
        } else if (nanoTime - this.mFrameCountingStart > 1000000000) {
            Log.m451d(TAG, "fps: " + ((((double) this.mFrameCount) * 1.0E9d) / ((double) (nanoTime - this.mFrameCountingStart))));
            this.mFrameCountingStart = nanoTime;
            this.mFrameCount = 0;
        }
        this.mFrameCount++;
    }

    private void rotateCanvas(int i) {
        if (i != 0) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            this.mCanvas.translate((float) width, (float) height);
            this.mCanvas.rotate((float) i, 0.0f, 0.0f, 1.0f);
            if (i % FadeTexture.DURATION != 0) {
                this.mCanvas.translate((float) (-height), (float) (-width));
            } else {
                this.mCanvas.translate((float) (-width), (float) (-height));
            }
        }
    }

    private void superRequestRender() {
        super.requestRender();
    }

    public void addOnGLIdleListener(OnGLIdleListener onGLIdleListener) {
        synchronized (this.mIdleListeners) {
            this.mIdleListeners.addLast(onGLIdleListener);
            this.mIdleRunner.enable();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInDownState = false;
            } else if (!(this.mInDownState || action == 0)) {
            }
            if (this.mCompensation != 0) {
                motionEvent = MotionEventHelper.transformEvent(motionEvent, this.mCompensationMatrix);
            }
            this.mRenderLock.lock();
            try {
                if (this.mContentView != null && this.mContentView.dispatchTouchEvent(r5)) {
                    z = true;
                }
                if (action == 0 && r0) {
                    this.mInDownState = true;
                }
                this.mRenderLock.unlock();
            } catch (Throwable th) {
                this.mRenderLock.unlock();
            }
        }
        return z;
    }

    protected void finalize() {
        try {
            unfreeze();
        } finally {
            super.finalize();
        }
    }

    public void freeze() {
        this.mRenderLock.lock();
        this.mFreeze = true;
        this.mRenderLock.unlock();
    }

    public int getCompensation() {
        return this.mCompensation;
    }

    public Matrix getCompensationMatrix() {
        return this.mCompensationMatrix;
    }

    public int getDisplayRotation() {
        return this.mDisplayRotation;
    }

    public void lockRenderThread() {
        this.mRenderLock.lock();
    }

    protected void onDetachedFromWindow() {
        unfreeze();
        super.onDetachedFromWindow();
    }

    public void onDrawFrame(GL10 gl10) {
        AnimationTime.update();
        this.mRenderLock.lock();
        while (this.mFreeze) {
            this.mFreezeCondition.awaitUninterruptibly();
        }
        try {
            onDrawFrameLocked(gl10);
            if (this.mFirstDraw) {
                this.mFirstDraw = false;
                post(new C05402());
            }
        } finally {
            this.mRenderLock.unlock();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            requestLayoutContentPane();
        }
    }

    public void onPause() {
        unfreeze();
        super.onPause();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.m455i(TAG, "onSurfaceChanged: " + i + "x" + i2 + ", gl10: " + gl10.toString());
        Process.setThreadPriority(-4);
        GalleryUtils.setRenderThread();
        Utils.assertTrue(this.mGL == ((GL11) gl10));
        this.mCanvas.setSize(i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GL11 gl11 = (GL11) gl10;
        if (this.mGL != null) {
            Log.m455i(TAG, "GLObject has changed from " + this.mGL + " to " + gl11);
        }
        this.mRenderLock.lock();
        try {
            this.mGL = gl11;
            this.mCanvas = new GLCanvasImpl(gl11);
            BasicTexture.invalidateAllTextures();
            setRenderMode(0);
        } finally {
            this.mRenderLock.unlock();
        }
    }

    public void registerLaunchedAnimation(CanvasAnimation canvasAnimation) {
        this.mAnimations.add(canvasAnimation);
    }

    public void requestLayoutContentPane() {
        this.mRenderLock.lock();
        try {
            if (this.mContentView == null || (this.mFlags & 2) != 0) {
                this.mRenderLock.unlock();
            } else if ((this.mFlags & 1) == 0) {
                this.mRenderLock.unlock();
            } else {
                this.mFlags |= 2;
                requestRender();
                this.mRenderLock.unlock();
            }
        } catch (Throwable th) {
            this.mRenderLock.unlock();
        }
    }

    public void requestRender() {
        if (!this.mRenderRequested) {
            this.mRenderRequested = true;
            if (ApiHelper.HAS_POST_ON_ANIMATION) {
                postOnAnimation(this.mRequestRenderOnAnimationFrame);
            } else {
                super.requestRender();
            }
        }
    }

    public void requestRenderForced() {
        superRequestRender();
    }

    public void setContentPane(GLView gLView) {
        if (this.mContentView != gLView) {
            if (this.mContentView != null) {
                if (this.mInDownState) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.mContentView.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    this.mInDownState = false;
                }
                this.mContentView.detachFromRoot();
                BasicTexture.yieldAllTextures();
            }
            this.mContentView = gLView;
            if (gLView != null) {
                gLView.attachToRoot(this);
                requestLayoutContentPane();
            }
        }
    }

    @TargetApi(16)
    public void setLightsOutMode(boolean z) {
        if (ApiHelper.HAS_SET_SYSTEM_UI_VISIBILITY) {
            int i = 0;
            if (z) {
                i = 1;
                if (ApiHelper.HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE) {
                    i = 261;
                }
            }
            setSystemUiVisibility(i);
        }
    }

    public void setOrientationSource(OrientationSource orientationSource) {
        this.mOrientationSource = orientationSource;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        unfreeze();
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        unfreeze();
        super.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        unfreeze();
        super.surfaceDestroyed(surfaceHolder);
    }

    public void unfreeze() {
        this.mRenderLock.lock();
        this.mFreeze = false;
        this.mFreezeCondition.signalAll();
        this.mRenderLock.unlock();
    }

    public void unlockRenderThread() {
        this.mRenderLock.unlock();
    }
}
