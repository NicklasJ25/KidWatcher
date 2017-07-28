package com.android.gallery3d.ui;

import android.graphics.Rect;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.android.gallery3d.anim.Animation;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.common.Utils;
import com.google.android.gms.common.ConnectionResult;

public class SlotView extends GLView {
    private static final int INDEX_NONE = -1;
    public static final int OVERSCROLL_3D = 0;
    public static final int OVERSCROLL_NONE = 2;
    public static final int OVERSCROLL_SYSTEM = 1;
    public static final int RENDER_MORE_FRAME = 2;
    public static final int RENDER_MORE_PASS = 1;
    private static final String TAG = "SlotView";
    private static final boolean WIDE = true;
    private SlotAnimation mAnimation = null;
    private boolean mDownInScrolling;
    private final GestureDetector mGestureDetector;
    private final Handler mHandler;
    private final Layout mLayout = new Layout();
    private Listener mListener;
    private boolean mMoreAnimation = false;
    private int mOverscrollEffect = 0;
    private final Paper mPaper = new Paper();
    private SlotRenderer mRenderer;
    private int[] mRequestRenderSlots = new int[16];
    private final ScrollerHelper mScroller;
    private int mStartIndex = -1;
    private final Rect mTempRect = new Rect();
    private UserInteractionListener mUIListener;

    public interface Listener {
        void onDown(int i);

        void onLongTap(int i);

        void onScrollPositionChanged(int i, int i2);

        void onSingleTapUp(int i);

        void onUp(boolean z);
    }

    public static class SimpleListener implements Listener {
        public void onDown(int i) {
        }

        public void onLongTap(int i) {
        }

        public void onScrollPositionChanged(int i, int i2) {
        }

        public void onSingleTapUp(int i) {
        }

        public void onUp(boolean z) {
        }
    }

    public interface SlotRenderer {
        void onSlotSizeChanged(int i, int i2);

        void onVisibleRangeChanged(int i, int i2);

        void prepareDrawing();

        int renderSlot(GLCanvas gLCanvas, int i, int i2, int i3, int i4);
    }

    private static class IntegerAnimation extends Animation {
        private int mCurrent;
        private boolean mEnabled;
        private int mFrom;
        private int mTarget;

        private IntegerAnimation() {
            this.mCurrent = 0;
            this.mFrom = 0;
            this.mEnabled = false;
        }

        public int get() {
            return this.mCurrent;
        }

        public int getTarget() {
            return this.mTarget;
        }

        protected void onCalculate(float f) {
            this.mCurrent = Math.round(((float) this.mFrom) + (((float) (this.mTarget - this.mFrom)) * f));
            if (f == 1.0f) {
                this.mEnabled = false;
            }
        }

        public void setEnabled(boolean z) {
            this.mEnabled = z;
        }

        public void startAnimateTo(int i) {
            if (!this.mEnabled) {
                this.mCurrent = i;
                this.mTarget = i;
            } else if (i != this.mTarget) {
                this.mFrom = this.mCurrent;
                this.mTarget = i;
                setDuration(FadeTexture.DURATION);
                start();
            }
        }
    }

    public class Layout {
        private int mContentLength;
        private int mHeight;
        private IntegerAnimation mHorizontalPadding = new IntegerAnimation();
        private int mScrollPosition;
        private int mSlotCount;
        private int mSlotGap;
        private int mSlotHeight;
        private int mSlotWidth;
        private Spec mSpec;
        private int mUnitCount;
        private IntegerAnimation mVerticalPadding = new IntegerAnimation();
        private int mVisibleEnd;
        private int mVisibleStart;
        private int mWidth;

        private void initLayoutParameters() {
            if (this.mSpec.slotWidth != -1) {
                this.mSlotGap = 0;
                this.mSlotWidth = this.mSpec.slotWidth;
                this.mSlotHeight = this.mSpec.slotHeight;
            } else {
                int i = this.mWidth > this.mHeight ? this.mSpec.rowsLand : this.mSpec.rowsPort;
                this.mSlotGap = this.mSpec.slotGap;
                this.mSlotHeight = Math.max(1, (this.mHeight - ((i - 1) * this.mSlotGap)) / i);
                this.mSlotWidth = this.mSlotHeight - this.mSpec.slotHeightAdditional;
            }
            if (SlotView.this.mRenderer != null) {
                SlotView.this.mRenderer.onSlotSizeChanged(this.mSlotWidth, this.mSlotHeight);
            }
            int[] iArr = new int[2];
            initLayoutParameters(this.mWidth, this.mHeight, this.mSlotWidth, this.mSlotHeight, iArr);
            this.mVerticalPadding.startAnimateTo(iArr[0]);
            this.mHorizontalPadding.startAnimateTo(iArr[1]);
            updateVisibleSlotRange();
        }

        private void initLayoutParameters(int i, int i2, int i3, int i4, int[] iArr) {
            int i5 = (this.mSlotGap + i2) / (this.mSlotGap + i4);
            if (i5 == 0) {
                i5 = 1;
            }
            this.mUnitCount = i5;
            i5 = Math.min(this.mUnitCount, this.mSlotCount);
            iArr[0] = (i2 - (((i5 - 1) * this.mSlotGap) + (i5 * i4))) / 2;
            i5 = ((this.mSlotCount + this.mUnitCount) - 1) / this.mUnitCount;
            this.mContentLength = ((i5 - 1) * this.mSlotGap) + (i5 * i3);
            iArr[1] = Math.max(0, (i - this.mContentLength) / 2);
        }

        private void setVisibleRange(int i, int i2) {
            if (i != this.mVisibleStart || i2 != this.mVisibleEnd) {
                if (i < i2) {
                    this.mVisibleStart = i;
                    this.mVisibleEnd = i2;
                } else {
                    this.mVisibleEnd = 0;
                    this.mVisibleStart = 0;
                }
                if (SlotView.this.mRenderer != null) {
                    SlotView.this.mRenderer.onVisibleRangeChanged(this.mVisibleStart, this.mVisibleEnd);
                }
            }
        }

        private void updateVisibleSlotRange() {
            int i = this.mScrollPosition;
            setVisibleRange(Math.max(0, (i / (this.mSlotWidth + this.mSlotGap)) * this.mUnitCount), Math.min(this.mSlotCount, (((((i + this.mWidth) + this.mSlotWidth) + this.mSlotGap) - 1) / (this.mSlotWidth + this.mSlotGap)) * this.mUnitCount));
        }

        public boolean advanceAnimation(long j) {
            return this.mVerticalPadding.calculate(j) | this.mHorizontalPadding.calculate(j);
        }

        public int getScrollLimit() {
            int i = this.mContentLength - this.mWidth;
            return i <= 0 ? 0 : i;
        }

        public int getSlotHeight() {
            return this.mSlotHeight;
        }

        public int getSlotIndexByPosition(float f, float f2) {
            int round = (Math.round(f) + this.mScrollPosition) - this.mHorizontalPadding.get();
            int round2 = (Math.round(f2) + 0) - this.mVerticalPadding.get();
            if (round < 0 || round2 < 0) {
                return -1;
            }
            int i = round / (this.mSlotWidth + this.mSlotGap);
            int i2 = round2 / (this.mSlotHeight + this.mSlotGap);
            if (i2 >= this.mUnitCount || round % (this.mSlotWidth + this.mSlotGap) >= this.mSlotWidth || round2 % (this.mSlotHeight + this.mSlotGap) >= this.mSlotHeight) {
                return -1;
            }
            round = (this.mUnitCount * i) + i2;
            return round < this.mSlotCount ? round : -1;
        }

        public Rect getSlotRect(int i, Rect rect) {
            int i2 = i / this.mUnitCount;
            int i3 = i - (this.mUnitCount * i2);
            i2 = (i2 * (this.mSlotWidth + this.mSlotGap)) + this.mHorizontalPadding.get();
            i3 = (i3 * (this.mSlotHeight + this.mSlotGap)) + this.mVerticalPadding.get();
            rect.set(i2, i3, this.mSlotWidth + i2, this.mSlotHeight + i3);
            return rect;
        }

        public int getSlotWidth() {
            return this.mSlotWidth;
        }

        public int getVisibleEnd() {
            return this.mVisibleEnd;
        }

        public int getVisibleStart() {
            return this.mVisibleStart;
        }

        public void setScrollPosition(int i) {
            if (this.mScrollPosition != i) {
                this.mScrollPosition = i;
                updateVisibleSlotRange();
            }
        }

        public void setSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            initLayoutParameters();
        }

        public boolean setSlotCount(int i) {
            if (i == this.mSlotCount) {
                return false;
            }
            if (this.mSlotCount != 0) {
                this.mHorizontalPadding.setEnabled(SlotView.WIDE);
                this.mVerticalPadding.setEnabled(SlotView.WIDE);
            }
            this.mSlotCount = i;
            int target = this.mHorizontalPadding.getTarget();
            int target2 = this.mVerticalPadding.getTarget();
            initLayoutParameters();
            return (target2 == this.mVerticalPadding.getTarget() && target == this.mHorizontalPadding.getTarget()) ? false : SlotView.WIDE;
        }

        public void setSlotSpec(Spec spec) {
            this.mSpec = spec;
        }
    }

    private class MyGestureListener implements OnGestureListener {
        private boolean isDown;

        private MyGestureListener() {
        }

        private void cancelDown(boolean z) {
            if (this.isDown) {
                this.isDown = false;
                SlotView.this.mListener.onUp(z);
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            cancelDown(false);
            int scrollLimit = SlotView.this.mLayout.getScrollLimit();
            if (scrollLimit == 0) {
                return false;
            }
            SlotView.this.mScroller.fling((int) (-f), 0, scrollLimit);
            if (SlotView.this.mUIListener != null) {
                SlotView.this.mUIListener.onUserInteractionBegin();
            }
            SlotView.this.invalidate();
            return SlotView.WIDE;
        }

        public void onLongPress(MotionEvent motionEvent) {
            cancelDown(SlotView.WIDE);
            if (!SlotView.this.mDownInScrolling) {
                SlotView.this.lockRendering();
                try {
                    int slotIndexByPosition = SlotView.this.mLayout.getSlotIndexByPosition(motionEvent.getX(), motionEvent.getY());
                    if (slotIndexByPosition != -1) {
                        SlotView.this.mListener.onLongTap(slotIndexByPosition);
                    }
                    SlotView.this.unlockRendering();
                } catch (Throwable th) {
                    SlotView.this.unlockRendering();
                }
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            cancelDown(false);
            int startScroll = SlotView.this.mScroller.startScroll(Math.round(f), 0, SlotView.this.mLayout.getScrollLimit());
            if (SlotView.this.mOverscrollEffect == 0 && startScroll != 0) {
                SlotView.this.mPaper.overScroll((float) startScroll);
            }
            SlotView.this.invalidate();
            return SlotView.WIDE;
        }

        public void onShowPress(MotionEvent motionEvent) {
            GLRoot gLRoot = SlotView.this.getGLRoot();
            gLRoot.lockRenderThread();
            try {
                if (!this.isDown) {
                    int slotIndexByPosition = SlotView.this.mLayout.getSlotIndexByPosition(motionEvent.getX(), motionEvent.getY());
                    if (slotIndexByPosition != -1) {
                        this.isDown = SlotView.WIDE;
                        SlotView.this.mListener.onDown(slotIndexByPosition);
                    }
                    gLRoot.unlockRenderThread();
                }
            } finally {
                gLRoot.unlockRenderThread();
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            cancelDown(false);
            if (!SlotView.this.mDownInScrolling) {
                int slotIndexByPosition = SlotView.this.mLayout.getSlotIndexByPosition(motionEvent.getX(), motionEvent.getY());
                if (slotIndexByPosition != -1) {
                    SlotView.this.mListener.onSingleTapUp(slotIndexByPosition);
                }
            }
            return SlotView.WIDE;
        }
    }

    public static abstract class SlotAnimation extends Animation {
        protected float mProgress = 0.0f;

        public SlotAnimation() {
            setInterpolator(new DecelerateInterpolator(4.0f));
            setDuration(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }

        public abstract void apply(GLCanvas gLCanvas, int i, Rect rect);

        protected void onCalculate(float f) {
            this.mProgress = f;
        }
    }

    public static class RisingAnimation extends SlotAnimation {
        private static final int RISING_DISTANCE = 128;

        public void apply(GLCanvas gLCanvas, int i, Rect rect) {
            gLCanvas.translate(0.0f, 0.0f, 128.0f * (1.0f - this.mProgress));
        }
    }

    public static class ScatteringAnimation extends SlotAnimation {
        private int PHOTO_DISTANCE = 1000;
        private RelativePosition mCenter;

        public ScatteringAnimation(RelativePosition relativePosition) {
            this.mCenter = relativePosition;
        }

        public void apply(GLCanvas gLCanvas, int i, Rect rect) {
            gLCanvas.translate((this.mCenter.getX() - ((float) rect.centerX())) * (1.0f - this.mProgress), (this.mCenter.getY() - ((float) rect.centerY())) * (1.0f - this.mProgress), ((float) (this.PHOTO_DISTANCE * i)) * (1.0f - this.mProgress));
            gLCanvas.setAlpha(this.mProgress);
        }
    }

    public static class Spec {
        public int rowsLand = -1;
        public int rowsPort = -1;
        public int slotGap = -1;
        public int slotHeight = -1;
        public int slotHeightAdditional = 0;
        public int slotWidth = -1;
    }

    public SlotView(AbstractGalleryActivity abstractGalleryActivity, Spec spec) {
        this.mGestureDetector = new GestureDetector(abstractGalleryActivity, new MyGestureListener());
        this.mScroller = new ScrollerHelper(abstractGalleryActivity);
        this.mHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot());
        setSlotSpec(spec);
    }

    private static int[] expandIntArray(int[] iArr, int i) {
        while (iArr.length < i) {
            iArr = new int[(iArr.length * 2)];
        }
        return iArr;
    }

    private int renderItem(GLCanvas gLCanvas, int i, int i2, boolean z) {
        gLCanvas.save(3);
        Rect slotRect = this.mLayout.getSlotRect(i, this.mTempRect);
        if (z) {
            gLCanvas.multiplyMatrix(this.mPaper.getTransform(slotRect, (float) this.mScrollX), 0);
        } else {
            gLCanvas.translate((float) slotRect.left, (float) slotRect.top, 0.0f);
        }
        if (this.mAnimation != null && this.mAnimation.isActive()) {
            this.mAnimation.apply(gLCanvas, i, slotRect);
        }
        int renderSlot = this.mRenderer.renderSlot(gLCanvas, i, i2, slotRect.right - slotRect.left, slotRect.bottom - slotRect.top);
        gLCanvas.restore();
        return renderSlot;
    }

    private void updateScrollPosition(int i, boolean z) {
        if (z || i != this.mScrollX) {
            this.mScrollX = i;
            this.mLayout.setScrollPosition(i);
            onScrollPositionChanged(i);
        }
    }

    public void addComponent(GLView gLView) {
        throw new UnsupportedOperationException();
    }

    public int getScrollX() {
        return this.mScrollX;
    }

    public int getScrollY() {
        return this.mScrollY;
    }

    public Rect getSlotRect(int i) {
        return this.mLayout.getSlotRect(i, new Rect());
    }

    public Rect getSlotRect(int i, GLView gLView) {
        Rect rect = new Rect();
        gLView.getBoundsOf(this, rect);
        Rect slotRect = getSlotRect(i);
        slotRect.offset(rect.left - getScrollX(), rect.top - getScrollY());
        return slotRect;
    }

    public int getVisibleEnd() {
        return this.mLayout.getVisibleEnd();
    }

    public int getVisibleStart() {
        return this.mLayout.getVisibleStart();
    }

    public void makeSlotVisible(int i) {
        Rect slotRect = this.mLayout.getSlotRect(i, this.mTempRect);
        int i2 = this.mScrollX;
        int width = getWidth();
        int i3 = i2 + width;
        int i4 = slotRect.left;
        int i5 = slotRect.right;
        if (width >= i5 - i4) {
            if (i4 < i2) {
                i2 = i4;
            } else if (i5 > i3) {
                i2 = i5 - width;
            }
        }
        setScrollPosition(i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int visibleStart = (this.mLayout.getVisibleStart() + this.mLayout.getVisibleEnd()) / 2;
            this.mLayout.setSize(i3 - i, i4 - i2);
            makeSlotVisible(visibleStart);
            if (this.mOverscrollEffect == 0) {
                this.mPaper.setSize(i3 - i, i4 - i2);
            }
        }
    }

    protected void onScrollPositionChanged(int i) {
        this.mListener.onScrollPositionChanged(i, this.mLayout.getScrollLimit());
    }

    protected boolean onTouch(MotionEvent motionEvent) {
        if (this.mUIListener != null) {
            this.mUIListener.onUserInteraction();
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownInScrolling = !this.mScroller.isFinished() ? WIDE : false;
                this.mScroller.forceFinished();
                break;
            case 1:
                this.mPaper.onRelease();
                invalidate();
                break;
        }
        return WIDE;
    }

    protected void render(GLCanvas gLCanvas) {
        super.render(gLCanvas);
        if (this.mRenderer != null) {
            int i;
            int scrollLimit;
            boolean advanceAnimation;
            int renderItem;
            this.mRenderer.prepareDrawing();
            long j = AnimationTime.get();
            int advanceAnimation2 = this.mLayout.advanceAnimation(j) | this.mScroller.advanceAnimation(j);
            int i2 = this.mScrollX;
            updateScrollPosition(this.mScroller.getPosition(), false);
            if (this.mOverscrollEffect == 0) {
                i = this.mScrollX;
                scrollLimit = this.mLayout.getScrollLimit();
                if ((i2 > 0 && i == 0) || (i2 < scrollLimit && i == scrollLimit)) {
                    float currVelocity = this.mScroller.getCurrVelocity();
                    if (i == scrollLimit) {
                        currVelocity = -currVelocity;
                    }
                    if (!Float.isNaN(currVelocity)) {
                        this.mPaper.edgeReached(currVelocity);
                    }
                }
                advanceAnimation = this.mPaper.advanceAnimation();
            } else {
                advanceAnimation = false;
            }
            boolean z = advanceAnimation2 | advanceAnimation;
            if (this.mAnimation != null) {
                z |= this.mAnimation.calculate(j);
            }
            gLCanvas.translate((float) (-this.mScrollX), (float) (-this.mScrollY));
            int[] expandIntArray = expandIntArray(this.mRequestRenderSlots, this.mLayout.mVisibleEnd - this.mLayout.mVisibleStart);
            boolean z2 = z;
            i = 0;
            for (advanceAnimation2 = this.mLayout.mVisibleEnd - 1; advanceAnimation2 >= this.mLayout.mVisibleStart; advanceAnimation2--) {
                renderItem = renderItem(gLCanvas, advanceAnimation2, 0, advanceAnimation);
                if ((renderItem & 2) != 0) {
                    z2 = true;
                }
                if ((renderItem & 1) != 0) {
                    renderItem = i + 1;
                    expandIntArray[i] = advanceAnimation2;
                    i = renderItem;
                }
            }
            scrollLimit = 1;
            int i3 = i;
            z = z2;
            while (i3 != 0) {
                renderItem = 0;
                i = 0;
                while (renderItem < i3) {
                    int renderItem2 = renderItem(gLCanvas, expandIntArray[renderItem], scrollLimit, advanceAnimation);
                    z2 = (renderItem2 & 2) != 0 ? true : z;
                    if ((renderItem2 & 1) != 0) {
                        advanceAnimation2 = i + 1;
                        expandIntArray[i] = renderItem;
                    } else {
                        advanceAnimation2 = i;
                    }
                    renderItem++;
                    i = advanceAnimation2;
                    z = z2;
                }
                scrollLimit++;
                i3 = i;
            }
            gLCanvas.translate((float) this.mScrollX, (float) this.mScrollY);
            if (z) {
                invalidate();
            }
            final UserInteractionListener userInteractionListener = this.mUIListener;
            if (!(!this.mMoreAnimation || z || userInteractionListener == null)) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        userInteractionListener.onUserInteractionEnd();
                    }
                });
            }
            this.mMoreAnimation = z;
        }
    }

    public void setCenterIndex(int i) {
        int access$300 = this.mLayout.mSlotCount;
        if (i >= 0 && i < access$300) {
            Rect slotRect = this.mLayout.getSlotRect(i, this.mTempRect);
            setScrollPosition(((slotRect.right + slotRect.left) - getWidth()) / 2);
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void setOverscrollEffect(int i) {
        boolean z = WIDE;
        this.mOverscrollEffect = i;
        ScrollerHelper scrollerHelper = this.mScroller;
        if (i != 1) {
            z = false;
        }
        scrollerHelper.setOverfling(z);
    }

    public void setScrollPosition(int i) {
        int clamp = Utils.clamp(i, 0, this.mLayout.getScrollLimit());
        this.mScroller.setPosition(clamp);
        updateScrollPosition(clamp, false);
    }

    public boolean setSlotCount(int i) {
        boolean slotCount = this.mLayout.setSlotCount(i);
        if (this.mStartIndex != -1) {
            setCenterIndex(this.mStartIndex);
            this.mStartIndex = -1;
        }
        setScrollPosition(this.mScrollX);
        return slotCount;
    }

    public void setSlotRenderer(SlotRenderer slotRenderer) {
        this.mRenderer = slotRenderer;
        if (this.mRenderer != null) {
            this.mRenderer.onSlotSizeChanged(this.mLayout.mSlotWidth, this.mLayout.mSlotHeight);
            this.mRenderer.onVisibleRangeChanged(getVisibleStart(), getVisibleEnd());
        }
    }

    public void setSlotSpec(Spec spec) {
        this.mLayout.setSlotSpec(spec);
    }

    public void setStartIndex(int i) {
        this.mStartIndex = i;
    }

    public void setUserInteractionListener(UserInteractionListener userInteractionListener) {
        this.mUIListener = userInteractionListener;
    }

    public void startRisingAnimation() {
        this.mAnimation = new RisingAnimation();
        this.mAnimation.start();
        if (this.mLayout.mSlotCount != 0) {
            invalidate();
        }
    }

    public void startScatteringAnimation(RelativePosition relativePosition) {
        this.mAnimation = new ScatteringAnimation(relativePosition);
        this.mAnimation.start();
        if (this.mLayout.mSlotCount != 0) {
            invalidate();
        }
    }
}
