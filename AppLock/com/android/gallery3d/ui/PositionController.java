package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import com.android.gallery3d.common.Scroller;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.ui.PhotoView.Size;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.RangeArray;
import com.android.gallery3d.util.RangeIntArray;

class PositionController {
    private static final int ANIM_KIND_CAPTURE = 9;
    private static final int ANIM_KIND_DELETE = 8;
    private static final int ANIM_KIND_FLING = 6;
    private static final int ANIM_KIND_FLING_X = 7;
    private static final int ANIM_KIND_NONE = -1;
    private static final int ANIM_KIND_OPENING = 5;
    private static final int ANIM_KIND_SCALE = 1;
    private static final int ANIM_KIND_SCROLL = 0;
    private static final int ANIM_KIND_SLIDE = 3;
    private static final int ANIM_KIND_SNAPBACK = 2;
    private static final int ANIM_KIND_ZOOM = 4;
    private static final int[] ANIM_TIME = new int[]{0, 0, SNAPBACK_ANIMATION_TIME, MAX_DELETE_ANIMATION_DURATION, 300, 300, 0, 0, 0, CAPTURE_ANIMATION_TIME};
    private static final int BOX_MAX = 3;
    public static final int CAPTURE_ANIMATION_TIME = 700;
    private static final int[] CENTER_OUT_INDEX = new int[7];
    private static final int DEFAULT_DELETE_ANIMATION_DURATION = 200;
    private static final float FILM_MODE_LANDSCAPE_HEIGHT = 0.7f;
    private static final float FILM_MODE_LANDSCAPE_WIDTH = 0.7f;
    private static final float FILM_MODE_PORTRAIT_HEIGHT = 0.48f;
    private static final float FILM_MODE_PORTRAIT_WIDTH = 0.7f;
    private static final int HORIZONTAL_SLACK = GalleryUtils.dpToPixel(12);
    public static final int IMAGE_AT_BOTTOM_EDGE = 8;
    public static final int IMAGE_AT_LEFT_EDGE = 1;
    public static final int IMAGE_AT_RIGHT_EDGE = 2;
    public static final int IMAGE_AT_TOP_EDGE = 4;
    private static final int IMAGE_GAP = GalleryUtils.dpToPixel(16);
    private static final long LAST_ANIMATION = -2;
    private static final int MAX_DELETE_ANIMATION_DURATION = 400;
    private static final long NO_ANIMATION = -1;
    private static final float SCALE_LIMIT = 4.0f;
    private static final float SCALE_MAX_EXTRA = 1.4f;
    private static final float SCALE_MIN_EXTRA = 0.7f;
    public static final int SNAPBACK_ANIMATION_TIME = 600;
    private static final String TAG = "PositionController";
    private int mBoundBottom;
    private int mBoundLeft;
    private int mBoundRight;
    private int mBoundTop;
    private RangeArray<Box> mBoxes = new RangeArray(-3, 3);
    private boolean mConstrained = true;
    private Rect mConstrainedFrame = new Rect();
    private boolean mExtraScalingRange = false;
    private boolean mFilmMode = false;
    private FilmRatio mFilmRatio = new FilmRatio();
    private Scroller mFilmScroller;
    private float mFocusX;
    private float mFocusY;
    private RangeArray<Gap> mGaps = new RangeArray(-3, 2);
    private boolean mHasNext;
    private boolean mHasPrev;
    private boolean mInScale;
    private Listener mListener;
    private volatile Rect mOpenAnimationRect;
    private FlingScroller mPageScroller;
    private Platform mPlatform = new Platform();
    boolean mPopFromTop;
    private RangeArray<Rect> mRects = new RangeArray(-3, 3);
    private RangeArray<Box> mTempBoxes = new RangeArray(-3, 3);
    private RangeArray<Gap> mTempGaps = new RangeArray(-3, 2);
    private int mViewH = 1200;
    private int mViewW = 1200;

    public interface Listener {
        void invalidate();

        boolean isHoldingDelete();

        boolean isHoldingDown();

        void onAbsorb(int i, int i2);

        void onPull(int i, int i2);

        void onRelease();
    }

    private static abstract class Animatable {
        public int mAnimationDuration;
        public int mAnimationKind;
        public long mAnimationStartTime;

        private Animatable() {
        }

        private static float applyInterpolationCurve(int i, float f) {
            float f2 = 1.0f - f;
            switch (i) {
                case 0:
                case 6:
                case 7:
                case 8:
                case 9:
                    return 1.0f - f2;
                case 1:
                case 5:
                    return 1.0f - (f2 * f2);
                case 2:
                case 3:
                case 4:
                    return 1.0f - (f2 * (((f2 * f2) * f2) * f2));
                default:
                    return f;
            }
        }

        public boolean advanceAnimation() {
            float f = 1.0f;
            if (this.mAnimationStartTime == -1) {
                return false;
            }
            if (this.mAnimationStartTime == PositionController.LAST_ANIMATION) {
                this.mAnimationStartTime = -1;
                return startSnapback();
            }
            float f2 = this.mAnimationDuration == 0 ? 1.0f : ((float) (AnimationTime.get() - this.mAnimationStartTime)) / ((float) this.mAnimationDuration);
            if (f2 < 1.0f) {
                f = applyInterpolationCurve(this.mAnimationKind, f2);
            }
            if (interpolate(f)) {
                this.mAnimationStartTime = PositionController.LAST_ANIMATION;
            }
            return true;
        }

        protected abstract boolean interpolate(float f);

        public abstract boolean startSnapback();
    }

    private class Box extends Animatable {
        public int mAbsoluteX;
        public float mCurrentScale;
        public int mCurrentY;
        public float mFromScale;
        public int mFromY;
        public int mImageH;
        public int mImageW;
        public float mScaleMax;
        public float mScaleMin;
        public float mToScale;
        public int mToY;
        public boolean mUseViewSize;

        private Box() {
            super();
        }

        private boolean doAnimation(int i, float f, int i2) {
            float clampScale = clampScale(f);
            if (this.mCurrentY == i && this.mCurrentScale == clampScale && i2 != 9) {
                return false;
            }
            this.mAnimationKind = i2;
            this.mFromY = this.mCurrentY;
            this.mFromScale = this.mCurrentScale;
            this.mToY = i;
            this.mToScale = clampScale;
            this.mAnimationStartTime = AnimationTime.startTime();
            this.mAnimationDuration = PositionController.ANIM_TIME[i2];
            advanceAnimation();
            return true;
        }

        private boolean interpolateFlingPage(float f) {
            PositionController.this.mPageScroller.computeScrollOffset(f);
            PositionController.this.calculateStableBound(this.mCurrentScale);
            int i = this.mCurrentY;
            this.mCurrentY = PositionController.this.mPageScroller.getCurrY();
            if (i > PositionController.this.mBoundTop && this.mCurrentY == PositionController.this.mBoundTop) {
                PositionController.this.mListener.onAbsorb((int) (((float) (-PositionController.this.mPageScroller.getCurrVelocityY())) + 0.5f), 2);
            } else if (i < PositionController.this.mBoundBottom && this.mCurrentY == PositionController.this.mBoundBottom) {
                PositionController.this.mListener.onAbsorb((int) (((float) PositionController.this.mPageScroller.getCurrVelocityY()) + 0.5f), 0);
            }
            return f >= 1.0f;
        }

        private boolean interpolateLinear(float f) {
            if (f >= 1.0f) {
                this.mCurrentY = this.mToY;
                this.mCurrentScale = this.mToScale;
                return true;
            }
            this.mCurrentY = (int) (((float) this.mFromY) + (((float) (this.mToY - this.mFromY)) * f));
            this.mCurrentScale = this.mFromScale + ((this.mToScale - this.mFromScale) * f);
            if (this.mAnimationKind != 9) {
                return this.mCurrentY == this.mToY && this.mCurrentScale == this.mToScale;
            } else {
                this.mCurrentScale = CaptureAnimation.calculateScale(f) * this.mCurrentScale;
                return false;
            }
        }

        public float clampScale(float f) {
            return Utils.clamp(f, 0.7f * this.mScaleMin, PositionController.SCALE_MAX_EXTRA * this.mScaleMax);
        }

        protected boolean interpolate(float f) {
            return this.mAnimationKind == 6 ? interpolateFlingPage(f) : interpolateLinear(f);
        }

        public boolean startSnapback() {
            if (this.mAnimationStartTime != -1) {
                return false;
            }
            if (this.mAnimationKind == 0 && PositionController.this.mListener.isHoldingDown()) {
                return false;
            }
            if (this.mAnimationKind == 8 && PositionController.this.mListener.isHoldingDelete()) {
                return false;
            }
            if (PositionController.this.mInScale && this == PositionController.this.mBoxes.get(0)) {
                return false;
            }
            int i;
            float f;
            int i2 = this.mCurrentY;
            if (this == PositionController.this.mBoxes.get(0)) {
                int i3;
                float clamp = Utils.clamp(this.mCurrentScale, PositionController.this.mExtraScalingRange ? this.mScaleMin * 0.7f : this.mScaleMin, PositionController.this.mExtraScalingRange ? this.mScaleMax * PositionController.SCALE_MAX_EXTRA : this.mScaleMax);
                if (PositionController.this.mFilmMode) {
                    i3 = 0;
                } else {
                    PositionController.this.calculateStableBound(clamp, PositionController.HORIZONTAL_SLACK);
                    i3 = Utils.clamp(!PositionController.this.viewTallerThanScaledImage(clamp) ? ((int) (((this.mCurrentScale - clamp) * PositionController.this.mFocusY) + 0.5f)) + i2 : i2, PositionController.this.mBoundTop, PositionController.this.mBoundBottom);
                }
                float f2 = clamp;
                i = i3;
                f = f2;
            } else {
                f = this.mScaleMin;
                i = 0;
            }
            return (this.mCurrentY == i && this.mCurrentScale == f) ? false : doAnimation(i, f, 2);
        }
    }

    private class FilmRatio extends Animatable {
        public float mCurrentRatio;
        public float mFromRatio;
        public float mToRatio;

        private FilmRatio() {
            super();
        }

        private boolean doAnimation(float f, int i) {
            this.mAnimationKind = i;
            this.mFromRatio = this.mCurrentRatio;
            this.mToRatio = f;
            this.mAnimationStartTime = AnimationTime.startTime();
            this.mAnimationDuration = PositionController.ANIM_TIME[this.mAnimationKind];
            advanceAnimation();
            return true;
        }

        protected boolean interpolate(float f) {
            if (f >= 1.0f) {
                this.mCurrentRatio = this.mToRatio;
                return true;
            }
            this.mCurrentRatio = this.mFromRatio + ((this.mToRatio - this.mFromRatio) * f);
            return this.mCurrentRatio == this.mToRatio;
        }

        public boolean startSnapback() {
            float f = PositionController.this.mFilmMode ? 1.0f : 0.0f;
            return f == this.mToRatio ? false : doAnimation(f, 2);
        }
    }

    private class Gap extends Animatable {
        public int mCurrentGap;
        public int mDefaultSize;
        public int mFromGap;
        public int mToGap;

        private Gap() {
            super();
        }

        public boolean doAnimation(int i, int i2) {
            if (this.mCurrentGap == i && i2 != 9) {
                return false;
            }
            this.mAnimationKind = i2;
            this.mFromGap = this.mCurrentGap;
            this.mToGap = i;
            this.mAnimationStartTime = AnimationTime.startTime();
            this.mAnimationDuration = PositionController.ANIM_TIME[this.mAnimationKind];
            advanceAnimation();
            return true;
        }

        protected boolean interpolate(float f) {
            if (f >= 1.0f) {
                this.mCurrentGap = this.mToGap;
                return true;
            }
            this.mCurrentGap = (int) (((float) this.mFromGap) + (((float) (this.mToGap - this.mFromGap)) * f));
            if (this.mAnimationKind != 9) {
                return this.mCurrentGap == this.mToGap;
            } else {
                this.mCurrentGap = (int) (CaptureAnimation.calculateScale(f) * ((float) this.mCurrentGap));
                return false;
            }
        }

        public boolean startSnapback() {
            return this.mAnimationStartTime != -1 ? false : doAnimation(this.mDefaultSize, 2);
        }
    }

    private class Platform extends Animatable {
        public int mCurrentX;
        public int mCurrentY;
        public int mDefaultX;
        public int mDefaultY;
        public int mFlingOffset;
        public int mFromX;
        public int mFromY;
        public int mToX;
        public int mToY;

        private Platform() {
            super();
        }

        private boolean doAnimation(int i, int i2, int i3) {
            if (this.mCurrentX == i && this.mCurrentY == i2) {
                return false;
            }
            this.mAnimationKind = i3;
            this.mFromX = this.mCurrentX;
            this.mFromY = this.mCurrentY;
            this.mToX = i;
            this.mToY = i2;
            this.mAnimationStartTime = AnimationTime.startTime();
            this.mAnimationDuration = PositionController.ANIM_TIME[i3];
            this.mFlingOffset = 0;
            advanceAnimation();
            return true;
        }

        private boolean interpolateFlingFilm(float f) {
            boolean z;
            PositionController.this.mFilmScroller.computeScrollOffset();
            this.mCurrentX = PositionController.this.mFilmScroller.getCurrX() + this.mFlingOffset;
            if (this.mCurrentX < this.mDefaultX) {
                if (!PositionController.this.mHasNext) {
                    z = true;
                }
                z = true;
            } else {
                if (this.mCurrentX > this.mDefaultX && !PositionController.this.mHasPrev) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                PositionController.this.mFilmScroller.forceFinished(true);
                this.mCurrentX = this.mDefaultX;
            }
            return PositionController.this.mFilmScroller.isFinished();
        }

        private boolean interpolateFlingPage(float f) {
            PositionController.this.mPageScroller.computeScrollOffset(f);
            PositionController.this.calculateStableBound(((Box) PositionController.this.mBoxes.get(0)).mCurrentScale);
            int i = this.mCurrentX;
            this.mCurrentX = PositionController.this.mPageScroller.getCurrX();
            if (i > PositionController.this.mBoundLeft && this.mCurrentX == PositionController.this.mBoundLeft) {
                PositionController.this.mListener.onAbsorb((int) (((float) (-PositionController.this.mPageScroller.getCurrVelocityX())) + 0.5f), 3);
            } else if (i < PositionController.this.mBoundRight && this.mCurrentX == PositionController.this.mBoundRight) {
                PositionController.this.mListener.onAbsorb((int) (((float) PositionController.this.mPageScroller.getCurrVelocityX()) + 0.5f), 1);
            }
            return f >= 1.0f;
        }

        private boolean interpolateLinear(float f) {
            if (f >= 1.0f) {
                this.mCurrentX = this.mToX;
                this.mCurrentY = this.mToY;
                return true;
            }
            if (this.mAnimationKind == 9) {
                f = CaptureAnimation.calculateSlide(f);
            }
            this.mCurrentX = (int) (((float) this.mFromX) + (((float) (this.mToX - this.mFromX)) * f));
            this.mCurrentY = (int) (((float) this.mFromY) + (((float) (this.mToY - this.mFromY)) * f));
            return this.mAnimationKind == 9 ? false : this.mCurrentX == this.mToX && this.mCurrentY == this.mToY;
        }

        protected boolean interpolate(float f) {
            return this.mAnimationKind == 6 ? interpolateFlingPage(f) : this.mAnimationKind == 7 ? interpolateFlingFilm(f) : interpolateLinear(f);
        }

        public boolean startSnapback() {
            if (this.mAnimationStartTime != -1) {
                return false;
            }
            if (this.mAnimationKind == 0 && PositionController.this.mListener.isHoldingDown()) {
                return false;
            }
            if (PositionController.this.mInScale) {
                return false;
            }
            int i;
            Box box = (Box) PositionController.this.mBoxes.get(0);
            float clamp = Utils.clamp(box.mCurrentScale, PositionController.this.mExtraScalingRange ? box.mScaleMin * 0.7f : box.mScaleMin, PositionController.this.mExtraScalingRange ? box.mScaleMax * PositionController.SCALE_MAX_EXTRA : box.mScaleMax);
            int i2 = this.mCurrentX;
            int i3 = this.mDefaultY;
            if (PositionController.this.mFilmMode) {
                i = this.mDefaultX;
            } else {
                PositionController.this.calculateStableBound(clamp, PositionController.HORIZONTAL_SLACK);
                i = Utils.clamp(!PositionController.this.viewWiderThanScaledImage(clamp) ? ((int) (((box.mCurrentScale - clamp) * PositionController.this.mFocusX) + 0.5f)) + i2 : i2, PositionController.this.mBoundLeft, PositionController.this.mBoundRight);
            }
            return (this.mCurrentX == i && this.mCurrentY == i3) ? false : doAnimation(i, i3, 2);
        }

        public void updateDefaultXY() {
            int i = 0;
            if (!PositionController.this.mConstrained || PositionController.this.mConstrainedFrame.isEmpty()) {
                this.mDefaultX = 0;
                this.mDefaultY = 0;
                return;
            }
            this.mDefaultX = PositionController.this.mConstrainedFrame.centerX() - (PositionController.this.mViewW / 2);
            if (!PositionController.this.mFilmMode) {
                i = PositionController.this.mConstrainedFrame.centerY() - (PositionController.this.mViewH / 2);
            }
            this.mDefaultY = i;
        }
    }

    static {
        for (int i = 0; i < CENTER_OUT_INDEX.length; i++) {
            int i2 = (i + 1) / 2;
            if ((i & 1) == 0) {
                i2 = -i2;
            }
            CENTER_OUT_INDEX[i] = i2;
        }
    }

    public PositionController(Context context, Listener listener) {
        int i = -3;
        this.mListener = listener;
        this.mPageScroller = new FlingScroller();
        this.mFilmScroller = new Scroller(context, null, false);
        initPlatform();
        for (int i2 = -3; i2 <= 3; i2++) {
            this.mBoxes.put(i2, new Box());
            initBox(i2);
            this.mRects.put(i2, new Rect());
        }
        while (i < 3) {
            this.mGaps.put(i, new Gap());
            initGap(i);
            i++;
        }
    }

    private void calculateStableBound(float f) {
        calculateStableBound(f, 0);
    }

    private void calculateStableBound(float f, int i) {
        Box box = (Box) this.mBoxes.get(0);
        int widthOf = widthOf(box, f);
        int heightOf = heightOf(box, f);
        this.mBoundLeft = (((this.mViewW + 1) / 2) - ((widthOf + 1) / 2)) - i;
        this.mBoundRight = ((widthOf / 2) - (this.mViewW / 2)) + i;
        this.mBoundTop = ((this.mViewH + 1) / 2) - ((heightOf + 1) / 2);
        this.mBoundBottom = (heightOf / 2) - (this.mViewH / 2);
        if (viewTallerThanScaledImage(f)) {
            this.mBoundBottom = 0;
            this.mBoundTop = 0;
        }
        if (viewWiderThanScaledImage(f)) {
            heightOf = this.mPlatform.mDefaultX;
            this.mBoundRight = heightOf;
            this.mBoundLeft = heightOf;
        }
    }

    private boolean canScroll() {
        Box box = (Box) this.mBoxes.get(0);
        if (box.mAnimationStartTime == -1) {
            return true;
        }
        switch (box.mAnimationKind) {
            case 0:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    private void convertBoxToRect(int i) {
        Box box = (Box) this.mBoxes.get(i);
        Rect rect = (Rect) this.mRects.get(i);
        int i2 = (this.mViewH / 2) + (box.mCurrentY + this.mPlatform.mCurrentY);
        int widthOf = widthOf(box);
        int heightOf = heightOf(box);
        if (i == 0) {
            rect.left = (this.mPlatform.mCurrentX + (this.mViewW / 2)) - (widthOf / 2);
            rect.right = rect.left + widthOf;
        } else if (i > 0) {
            rect.left = ((Rect) this.mRects.get(i - 1)).right + ((Gap) this.mGaps.get(i - 1)).mCurrentGap;
            rect.right = rect.left + widthOf;
        } else {
            rect.right = ((Rect) this.mRects.get(i + 1)).left - ((Gap) this.mGaps.get(i)).mCurrentGap;
            rect.left = rect.right - widthOf;
        }
        rect.top = i2 - (heightOf / 2);
        rect.bottom = rect.top + heightOf;
    }

    private void debugMoveBox(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder("moveBox:");
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == Integer.MAX_VALUE) {
                stringBuilder.append(" N");
            } else {
                stringBuilder.append(" ");
                stringBuilder.append(iArr[i]);
            }
        }
        Log.d(TAG, stringBuilder.toString());
    }

    private void dumpRect(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        Rect rect = (Rect) this.mRects.get(i);
        stringBuilder.append("Rect " + i + ":");
        stringBuilder.append("(");
        stringBuilder.append(rect.centerX());
        stringBuilder.append(",");
        stringBuilder.append(rect.centerY());
        stringBuilder.append(") [");
        stringBuilder.append(rect.width());
        stringBuilder.append("x");
        stringBuilder.append(rect.height());
        stringBuilder.append("]");
        Log.d(TAG, stringBuilder.toString());
    }

    private void dumpState() {
        int i;
        for (i = -3; i < 3; i++) {
            Log.d(TAG, "Gap " + i + ": " + ((Gap) this.mGaps.get(i)).mCurrentGap);
        }
        for (int i2 = 0; i2 < 7; i2++) {
            dumpRect(CENTER_OUT_INDEX[i2]);
        }
        for (int i3 = -3; i3 <= 3; i3++) {
            for (i = i3 + 1; i <= 3; i++) {
                if (Rect.intersects((Rect) this.mRects.get(i3), (Rect) this.mRects.get(i))) {
                    Log.d(TAG, "rect " + i3 + " and rect " + i + "intersects!");
                }
            }
        }
    }

    private int gapToSide(Box box) {
        return (int) (((((float) this.mViewW) - (getMinimalScale(box) * ((float) box.mImageW))) / 2.0f) + 0.5f);
    }

    private int getDefaultGapSize(int i) {
        if (this.mFilmMode) {
            return IMAGE_GAP;
        }
        Box box = (Box) this.mBoxes.get(i);
        Box box2 = (Box) this.mBoxes.get(i + 1);
        return Math.max(gapToSide(box), gapToSide(box2)) + IMAGE_GAP;
    }

    private float getMaximalScale(Box box) {
        return this.mFilmMode ? getMinimalScale(box) : (!this.mConstrained || this.mConstrainedFrame.isEmpty()) ? SCALE_LIMIT : getMinimalScale(box);
    }

    private float getMinimalScale(Box box) {
        int i;
        int i2;
        float f = 1.0f;
        float f2 = 0.7f;
        if (this.mFilmMode || !this.mConstrained || this.mConstrainedFrame.isEmpty() || box != this.mBoxes.get(0)) {
            i = this.mViewW;
            i2 = this.mViewH;
        } else {
            i = this.mConstrainedFrame.width();
            i2 = this.mConstrainedFrame.height();
        }
        if (this.mFilmMode) {
            f = this.mViewH > this.mViewW ? FILM_MODE_PORTRAIT_HEIGHT : 0.7f;
        } else {
            f2 = 1.0f;
        }
        return Math.min(SCALE_LIMIT, Math.min((((float) i) * f2) / ((float) box.mImageW), (((float) i2) * f) / ((float) box.mImageH)));
    }

    private float getTargetScale(Box box) {
        return box.mAnimationStartTime == -1 ? box.mCurrentScale : box.mToScale;
    }

    private int heightOf(Box box) {
        return (int) ((((float) box.mImageH) * box.mCurrentScale) + 0.5f);
    }

    private int heightOf(Box box, float f) {
        return (int) ((((float) box.mImageH) * f) + 0.5f);
    }

    private void initBox(int i) {
        Box box = (Box) this.mBoxes.get(i);
        box.mImageW = this.mViewW;
        box.mImageH = this.mViewH;
        box.mUseViewSize = true;
        box.mScaleMin = getMinimalScale(box);
        box.mScaleMax = getMaximalScale(box);
        box.mCurrentY = 0;
        box.mCurrentScale = box.mScaleMin;
        box.mAnimationStartTime = -1;
        box.mAnimationKind = -1;
    }

    private void initBox(int i, Size size) {
        if (size.width == 0 || size.height == 0) {
            initBox(i);
            return;
        }
        Box box = (Box) this.mBoxes.get(i);
        box.mImageW = size.width;
        box.mImageH = size.height;
        box.mUseViewSize = false;
        box.mScaleMin = getMinimalScale(box);
        box.mScaleMax = getMaximalScale(box);
        box.mCurrentY = 0;
        box.mCurrentScale = box.mScaleMin;
        box.mAnimationStartTime = -1;
        box.mAnimationKind = -1;
    }

    private void initGap(int i) {
        Gap gap = (Gap) this.mGaps.get(i);
        gap.mDefaultSize = getDefaultGapSize(i);
        gap.mCurrentGap = gap.mDefaultSize;
        gap.mAnimationStartTime = -1;
    }

    private void initGap(int i, int i2) {
        Gap gap = (Gap) this.mGaps.get(i);
        gap.mDefaultSize = getDefaultGapSize(i);
        gap.mCurrentGap = i2;
        gap.mAnimationStartTime = -1;
    }

    private void initPlatform() {
        this.mPlatform.updateDefaultXY();
        this.mPlatform.mCurrentX = this.mPlatform.mDefaultX;
        this.mPlatform.mCurrentY = this.mPlatform.mDefaultY;
        this.mPlatform.mAnimationStartTime = -1;
    }

    private static boolean isAlmostEqual(float f, float f2) {
        float f3 = f - f2;
        if (f3 < 0.0f) {
            f3 = -f3;
        }
        return f3 < 0.02f;
    }

    private void layoutAndSetPosition() {
        for (int i = 0; i < 7; i++) {
            convertBoxToRect(CENTER_OUT_INDEX[i]);
        }
    }

    private void redraw() {
        layoutAndSetPosition();
        this.mListener.invalidate();
    }

    private boolean setBoxSize(int i, int i2, int i3, boolean z) {
        Box box = (Box) this.mBoxes.get(i);
        boolean z2 = box.mUseViewSize;
        if (!z2 && z) {
            return false;
        }
        box.mUseViewSize = z;
        if (i2 == box.mImageW && i3 == box.mImageH) {
            return false;
        }
        float f = i2 > i3 ? ((float) box.mImageW) / ((float) i2) : ((float) box.mImageH) / ((float) i3);
        box.mImageW = i2;
        box.mImageH = i3;
        if ((!z2 || z) && this.mFilmMode) {
            box.mCurrentScale *= f;
            box.mFromScale *= f;
            box.mToScale *= f;
        } else {
            box.mCurrentScale = getMinimalScale(box);
            box.mAnimationStartTime = -1;
        }
        if (i == 0) {
            this.mFocusX /= f;
            this.mFocusY /= f;
        }
        return true;
    }

    private void snapAndRedraw() {
        int i = -3;
        this.mPlatform.startSnapback();
        for (int i2 = -3; i2 <= 3; i2++) {
            ((Box) this.mBoxes.get(i2)).startSnapback();
        }
        while (i < 3) {
            ((Gap) this.mGaps.get(i)).startSnapback();
            i++;
        }
        this.mFilmRatio.startSnapback();
        redraw();
    }

    private boolean startAnimation(int i, int i2, float f, int i3) {
        boolean access$500 = ((Box) this.mBoxes.get(0)).doAnimation(i2, f, i3) | (0 | this.mPlatform.doAnimation(i, this.mPlatform.mDefaultY, i3));
        if (access$500) {
            redraw();
        }
        return access$500;
    }

    private boolean startOpeningAnimationIfNeeded() {
        if (this.mOpenAnimationRect == null) {
            return false;
        }
        Box box = (Box) this.mBoxes.get(0);
        if (box.mUseViewSize) {
            return false;
        }
        Rect rect = this.mOpenAnimationRect;
        this.mOpenAnimationRect = null;
        this.mPlatform.mCurrentX = rect.centerX() - (this.mViewW / 2);
        box.mCurrentY = rect.centerY() - (this.mViewH / 2);
        box.mCurrentScale = Math.max(((float) rect.width()) / ((float) box.mImageW), ((float) rect.height()) / ((float) box.mImageH));
        startAnimation(this.mPlatform.mDefaultX, 0, box.mScaleMin, 5);
        for (int i = -1; i < 1; i++) {
            Gap gap = (Gap) this.mGaps.get(i);
            gap.mCurrentGap = this.mViewW;
            gap.doAnimation(gap.mDefaultSize, 5);
        }
        return true;
    }

    private void updateScaleAndGapLimit() {
        int i = -3;
        for (int i2 = -3; i2 <= 3; i2++) {
            Box box = (Box) this.mBoxes.get(i2);
            box.mScaleMin = getMinimalScale(box);
            box.mScaleMax = getMaximalScale(box);
        }
        while (i < 3) {
            ((Gap) this.mGaps.get(i)).mDefaultSize = getDefaultGapSize(i);
            i++;
        }
    }

    private boolean viewTallerThanScaledImage(float f) {
        return this.mViewH >= heightOf((Box) this.mBoxes.get(0), f);
    }

    private boolean viewWiderThanScaledImage(float f) {
        return this.mViewW >= widthOf((Box) this.mBoxes.get(0), f);
    }

    private int widthOf(Box box) {
        return (int) ((((float) box.mImageW) * box.mCurrentScale) + 0.5f);
    }

    private int widthOf(Box box, float f) {
        return (int) ((((float) box.mImageW) * f) + 0.5f);
    }

    public void advanceAnimation() {
        int i;
        int i2 = -3;
        int advanceAnimation = this.mPlatform.advanceAnimation() | 0;
        int i3 = -3;
        while (i3 <= 3) {
            try {
                advanceAnimation |= ((Box) this.mBoxes.get(i3)).advanceAnimation();
                i3++;
            } catch (Exception e) {
                i = advanceAnimation;
            }
        }
        while (i2 < 3) {
            advanceAnimation |= ((Gap) this.mGaps.get(i2)).advanceAnimation();
            i2++;
        }
        i = advanceAnimation;
        if ((i | this.mFilmRatio.advanceAnimation()) != 0) {
            redraw();
        }
    }

    public void beginScale(float f, float f2) {
        float f3 = f - ((float) (this.mViewW / 2));
        float f4 = f2 - ((float) (this.mViewH / 2));
        Box box = (Box) this.mBoxes.get(0);
        Platform platform = this.mPlatform;
        this.mInScale = true;
        this.mFocusX = (float) ((int) (((f3 - ((float) platform.mCurrentX)) / box.mCurrentScale) + 0.5f));
        this.mFocusY = (float) ((int) (((f4 - ((float) box.mCurrentY)) / box.mCurrentScale) + 0.5f));
    }

    public void endScale() {
        this.mInScale = false;
        snapAndRedraw();
    }

    public boolean flingFilmX(int i) {
        if (i == 0) {
            return false;
        }
        Box box = (Box) this.mBoxes.get(0);
        Platform platform = this.mPlatform;
        int i2 = platform.mDefaultX;
        if (!this.mHasPrev && platform.mCurrentX >= i2) {
            return false;
        }
        if (!this.mHasNext && platform.mCurrentX <= i2) {
            return false;
        }
        this.mFilmScroller.fling(platform.mCurrentX, 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        return startAnimation(this.mFilmScroller.getFinalX(), box.mCurrentY, box.mCurrentScale, 7);
    }

    public int flingFilmY(int i, int i2) {
        Box box = (Box) this.mBoxes.get(i);
        int heightOf = heightOf(box);
        int i3 = (i2 < 0 || (i2 == 0 && box.mCurrentY <= 0)) ? (((-this.mViewH) / 2) - ((heightOf + 1) / 2)) - 3 : ((heightOf / 2) + ((this.mViewH + 1) / 2)) + 3;
        heightOf = i2 != 0 ? Math.min(MAX_DELETE_ANIMATION_DURATION, (int) ((((float) Math.abs(i3 - box.mCurrentY)) * 1000.0f) / ((float) Math.abs(i2)))) : 200;
        ANIM_TIME[8] = heightOf;
        if (!box.doAnimation(i3, box.mCurrentScale, 8)) {
            return -1;
        }
        redraw();
        return heightOf;
    }

    public boolean flingPage(int i, int i2) {
        Box box = (Box) this.mBoxes.get(0);
        Platform platform = this.mPlatform;
        if (viewWiderThanScaledImage(box.mCurrentScale) && viewTallerThanScaledImage(box.mCurrentScale)) {
            return false;
        }
        int imageAtEdges = getImageAtEdges();
        int i3 = ((i <= 0 || (imageAtEdges & 1) == 0) && (i >= 0 || (imageAtEdges & 2) == 0)) ? i : 0;
        int i4 = ((i2 <= 0 || (imageAtEdges & 4) == 0) && (i2 >= 0 || (imageAtEdges & 8) == 0)) ? i2 : 0;
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        this.mPageScroller.fling(platform.mCurrentX, box.mCurrentY, i3, i4, this.mBoundLeft, this.mBoundRight, this.mBoundTop, this.mBoundBottom);
        imageAtEdges = this.mPageScroller.getFinalX();
        int finalY = this.mPageScroller.getFinalY();
        ANIM_TIME[6] = this.mPageScroller.getDuration();
        return startAnimation(imageAtEdges, finalY, box.mCurrentScale, 6);
    }

    public void forceImageSize(int i, Size size) {
        if (size.width != 0 && size.height != 0) {
            Box box = (Box) this.mBoxes.get(i);
            box.mImageW = size.width;
            box.mImageH = size.height;
        }
    }

    public float getFilmRatio() {
        return this.mFilmRatio.mCurrentRatio;
    }

    public int getImageAtEdges() {
        int i = 0;
        Box box = (Box) this.mBoxes.get(0);
        Platform platform = this.mPlatform;
        calculateStableBound(box.mCurrentScale);
        if (platform.mCurrentX <= this.mBoundLeft) {
            i = 2;
        }
        if (platform.mCurrentX >= this.mBoundRight) {
            i |= 1;
        }
        if (box.mCurrentY <= this.mBoundTop) {
            i |= 8;
        }
        return box.mCurrentY >= this.mBoundBottom ? i | 4 : i;
    }

    public int getImageHeight() {
        return ((Box) this.mBoxes.get(0)).mImageH;
    }

    public float getImageScale() {
        try {
            return ((Box) this.mBoxes.get(0)).mCurrentScale;
        } catch (Exception e) {
            return 0.3f;
        }
    }

    public int getImageWidth() {
        return ((Box) this.mBoxes.get(0)).mImageW;
    }

    public Rect getPosition(int i) {
        return (Rect) this.mRects.get(i);
    }

    public boolean hasDeletingBox() {
        for (int i = -3; i <= 3; i++) {
            if (((Box) this.mBoxes.get(i)).mAnimationKind == 8) {
                return true;
            }
        }
        return false;
    }

    public int hitTest(int i, int i2) {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = CENTER_OUT_INDEX[i3];
            if (((Rect) this.mRects.get(i4)).contains(i, i2)) {
                return i4;
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean inOpeningAnimation() {
        return (this.mPlatform.mAnimationKind == 5 && this.mPlatform.mAnimationStartTime != -1) || (((Box) this.mBoxes.get(0)).mAnimationKind == 5 && ((Box) this.mBoxes.get(0)).mAnimationStartTime != -1);
    }

    public boolean isAtMinimalScale() {
        Box box = (Box) this.mBoxes.get(0);
        return isAlmostEqual(box.mCurrentScale, box.mScaleMin);
    }

    public boolean isCenter() {
        return this.mPlatform.mCurrentX == this.mPlatform.mDefaultX && ((Box) this.mBoxes.get(0)).mCurrentY == 0;
    }

    public boolean isScrolling() {
        return (this.mPlatform.mAnimationStartTime == -1 || this.mPlatform.mCurrentX == this.mPlatform.mToX) ? false : true;
    }

    public void moveBox(int[] iArr, boolean z, boolean z2, boolean z3, Size[] sizeArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int max;
        Box box;
        this.mHasPrev = z;
        this.mHasNext = z2;
        RangeIntArray rangeIntArray = new RangeIntArray(iArr, -3, 3);
        layoutAndSetPosition();
        for (i = -3; i <= 3; i++) {
            ((Box) this.mBoxes.get(i)).mAbsoluteX = ((Rect) this.mRects.get(i)).centerX() - (this.mViewW / 2);
        }
        for (i2 = -3; i2 <= 3; i2++) {
            this.mTempBoxes.put(i2, this.mBoxes.get(i2));
            this.mBoxes.put(i2, null);
        }
        for (i2 = -3; i2 < 3; i2++) {
            this.mTempGaps.put(i2, this.mGaps.get(i2));
            this.mGaps.put(i2, null);
        }
        for (i2 = -3; i2 <= 3; i2++) {
            i3 = rangeIntArray.get(i2);
            if (i3 != Integer.MAX_VALUE) {
                this.mBoxes.put(i2, this.mTempBoxes.get(i3));
                this.mTempBoxes.put(i3, null);
            }
        }
        for (i2 = -3; i2 < 3; i2++) {
            i3 = rangeIntArray.get(i2);
            if (i3 != Integer.MAX_VALUE) {
                i = rangeIntArray.get(i2 + 1);
                if (i != Integer.MAX_VALUE && i3 + 1 == i) {
                    this.mGaps.put(i2, this.mTempGaps.get(i3));
                    this.mTempGaps.put(i3, null);
                }
            }
        }
        i2 = -3;
        for (i = -3; i <= 3; i++) {
            if (this.mBoxes.get(i) == null) {
                while (this.mTempBoxes.get(i2) == null) {
                    i2++;
                }
                i3 = i2 + 1;
                this.mBoxes.put(i, this.mTempBoxes.get(i2));
                initBox(i, sizeArr[i + 3]);
                i2 = i3;
            }
        }
        i3 = -3;
        while (i3 <= 3 && rangeIntArray.get(i3) == Integer.MAX_VALUE) {
            i3++;
        }
        i2 = 3;
        while (i2 >= -3 && rangeIntArray.get(i2) == Integer.MAX_VALUE) {
            i2--;
        }
        if (i3 > 3) {
            ((Box) this.mBoxes.get(0)).mAbsoluteX = this.mPlatform.mCurrentX;
            i4 = 0;
            i = 0;
        } else {
            i4 = i2;
            i = i3;
        }
        for (max = Math.max(0, i + 1); max < i4; max++) {
            if (rangeIntArray.get(max) == Integer.MAX_VALUE) {
                Box box2 = (Box) this.mBoxes.get(max - 1);
                box = (Box) this.mBoxes.get(max);
                int widthOf = widthOf(box2);
                box.mAbsoluteX = ((box2.mAbsoluteX + (widthOf - (widthOf / 2))) + (widthOf(box) / 2)) + getDefaultGapSize(max);
                if (this.mPopFromTop) {
                    box.mCurrentY = -((this.mViewH / 2) + (heightOf(box) / 2));
                } else {
                    box.mCurrentY = (this.mViewH / 2) + (heightOf(box) / 2);
                }
            }
        }
        for (max = Math.min(-1, i4 - 1); max > i; max--) {
            if (rangeIntArray.get(max) == Integer.MAX_VALUE) {
                box2 = (Box) this.mBoxes.get(max + 1);
                box = (Box) this.mBoxes.get(max);
                widthOf = widthOf(box2);
                int widthOf2 = widthOf(box);
                box.mAbsoluteX = ((box2.mAbsoluteX - (widthOf / 2)) - (widthOf2 - (widthOf2 / 2))) - getDefaultGapSize(max);
                if (this.mPopFromTop) {
                    box.mCurrentY = -((this.mViewH / 2) + (heightOf(box) / 2));
                } else {
                    box.mCurrentY = (this.mViewH / 2) + (heightOf(box) / 2);
                }
            }
        }
        int i5 = -3;
        i2 = -3;
        while (i5 < 3) {
            if (this.mGaps.get(i5) == null) {
                while (this.mTempGaps.get(i2) == null) {
                    i2++;
                }
                max = i2 + 1;
                this.mGaps.put(i5, this.mTempGaps.get(i2));
                box2 = (Box) this.mBoxes.get(i5);
                box = (Box) this.mBoxes.get(i5 + 1);
                widthOf = widthOf(box2);
                widthOf2 = widthOf(box);
                if (i5 < i || i5 >= i4) {
                    initGap(i5);
                    i2 = max;
                } else {
                    initGap(i5, ((box.mAbsoluteX - box2.mAbsoluteX) - (widthOf2 / 2)) - (widthOf - (widthOf / 2)));
                    i2 = max;
                }
            }
            i5++;
        }
        for (max = i - 1; max >= -3; max--) {
            box2 = (Box) this.mBoxes.get(max + 1);
            box = (Box) this.mBoxes.get(max);
            i5 = widthOf(box2);
            widthOf = widthOf(box);
            box.mAbsoluteX = ((box2.mAbsoluteX - (i5 / 2)) - (widthOf - (widthOf / 2))) - ((Gap) this.mGaps.get(max)).mCurrentGap;
        }
        for (i4++; i4 <= 3; i4++) {
            box2 = (Box) this.mBoxes.get(i4 - 1);
            box = (Box) this.mBoxes.get(i4);
            max = widthOf(box2);
            box.mAbsoluteX = ((box2.mAbsoluteX + (max - (max / 2))) + (widthOf(box) / 2)) + ((Gap) this.mGaps.get(i4 - 1)).mCurrentGap;
        }
        i2 = ((Box) this.mBoxes.get(0)).mAbsoluteX - this.mPlatform.mCurrentX;
        Platform platform = this.mPlatform;
        platform.mCurrentX += i2;
        platform = this.mPlatform;
        platform.mFromX += i2;
        platform = this.mPlatform;
        platform.mToX += i2;
        platform = this.mPlatform;
        platform.mFlingOffset = i2 + platform.mFlingOffset;
        if (this.mConstrained != z3) {
            this.mConstrained = z3;
            this.mPlatform.updateDefaultXY();
            updateScaleAndGapLimit();
        }
        snapAndRedraw();
    }

    public void resetToFullView() {
        startAnimation(this.mPlatform.mDefaultX, 0, ((Box) this.mBoxes.get(0)).mScaleMin, 4);
    }

    public int scaleBy(float f, float f2, float f3) {
        float f4 = f2 - ((float) (this.mViewW / 2));
        float f5 = f3 - ((float) (this.mViewH / 2));
        Box box = (Box) this.mBoxes.get(0);
        Platform platform = this.mPlatform;
        float clampScale = box.clampScale(getTargetScale(box) * f);
        startAnimation(this.mFilmMode ? platform.mCurrentX : (int) ((f4 - (this.mFocusX * clampScale)) + 0.5f), this.mFilmMode ? box.mCurrentY : (int) ((f5 - (this.mFocusY * clampScale)) + 0.5f), clampScale, 1);
        return clampScale < box.mScaleMin ? -1 : clampScale > box.mScaleMax ? 1 : 0;
    }

    public void scrollFilmX(int i) {
        if (canScroll()) {
            Box box = (Box) this.mBoxes.get(0);
            Platform platform = this.mPlatform;
            if (box.mAnimationStartTime != -1) {
                switch (box.mAnimationKind) {
                    case 0:
                    case 6:
                    case 7:
                        break;
                    default:
                        return;
                }
            }
            int i2 = (platform.mCurrentX + i) - this.mPlatform.mDefaultX;
            if (!this.mHasPrev && i2 > 0) {
                this.mListener.onPull(i2, 1);
                i2 = 0;
            } else if (!this.mHasNext && i2 < 0) {
                this.mListener.onPull(-i2, 3);
                i2 = 0;
            }
            startAnimation(i2 + this.mPlatform.mDefaultX, box.mCurrentY, box.mCurrentScale, 0);
        }
    }

    public void scrollFilmY(int i, int i2) {
        if (canScroll()) {
            Box box = (Box) this.mBoxes.get(i);
            box.doAnimation(box.mCurrentY + i2, box.mCurrentScale, 0);
            redraw();
        }
    }

    public void scrollPage(int i, int i2) {
        if (canScroll()) {
            Box box = (Box) this.mBoxes.get(0);
            Platform platform = this.mPlatform;
            calculateStableBound(box.mCurrentScale);
            int i3 = platform.mCurrentX + i;
            int i4 = box.mCurrentY + i2;
            if (this.mBoundTop != this.mBoundBottom) {
                if (i4 < this.mBoundTop) {
                    this.mListener.onPull(this.mBoundTop - i4, 2);
                } else if (i4 > this.mBoundBottom) {
                    this.mListener.onPull(i4 - this.mBoundBottom, 0);
                }
            }
            i4 = Utils.clamp(i4, this.mBoundTop, this.mBoundBottom);
            if (!this.mHasPrev && i3 > this.mBoundRight) {
                this.mListener.onPull(i3 - this.mBoundRight, 1);
                i3 = this.mBoundRight;
            } else if (!this.mHasNext && i3 < this.mBoundLeft) {
                this.mListener.onPull(this.mBoundLeft - i3, 3);
                i3 = this.mBoundLeft;
            }
            startAnimation(i3, i4, box.mCurrentScale, 0);
        }
    }

    public void setConstrainedFrame(Rect rect) {
        if (!this.mConstrainedFrame.equals(rect)) {
            this.mConstrainedFrame.set(rect);
            this.mPlatform.updateDefaultXY();
            updateScaleAndGapLimit();
            snapAndRedraw();
        }
    }

    public void setExtraScalingRange(boolean z) {
        if (this.mExtraScalingRange != z) {
            this.mExtraScalingRange = z;
            if (!z) {
                snapAndRedraw();
            }
        }
    }

    public void setFilmMode(boolean z) {
        if (z != this.mFilmMode) {
            this.mFilmMode = z;
            this.mPlatform.updateDefaultXY();
            updateScaleAndGapLimit();
            stopAnimation();
            snapAndRedraw();
        }
    }

    public void setImageSize(int i, Size size, Rect rect) {
        if (size.width != 0 && size.height != 0) {
            int i2;
            if (rect == null || this.mConstrainedFrame.equals(rect)) {
                i2 = 0;
            } else {
                this.mConstrainedFrame.set(rect);
                this.mPlatform.updateDefaultXY();
                i2 = 1;
            }
            if ((i2 | setBoxSize(i, size.width, size.height, false)) != 0) {
                updateScaleAndGapLimit();
                snapAndRedraw();
            }
        }
    }

    public void setOpenAnimationRect(Rect rect) {
        this.mOpenAnimationRect = rect;
    }

    public void setPopFromTop(boolean z) {
        this.mPopFromTop = z;
    }

    public void setViewSize(int i, int i2) {
        if (i != this.mViewW || i2 != this.mViewH) {
            boolean isAtMinimalScale = isAtMinimalScale();
            this.mViewW = i;
            this.mViewH = i2;
            initPlatform();
            for (int i3 = -3; i3 <= 3; i3++) {
                setBoxSize(i3, i, i2, true);
            }
            updateScaleAndGapLimit();
            if (isAtMinimalScale) {
                Box box = (Box) this.mBoxes.get(0);
                box.mCurrentScale = box.mScaleMin;
            }
            if (!startOpeningAnimationIfNeeded()) {
                skipToFinalPosition();
            }
        }
    }

    public void skipAnimation() {
        int i = -3;
        if (this.mPlatform.mAnimationStartTime != -1) {
            this.mPlatform.mCurrentX = this.mPlatform.mToX;
            this.mPlatform.mCurrentY = this.mPlatform.mToY;
            this.mPlatform.mAnimationStartTime = -1;
        }
        for (int i2 = -3; i2 <= 3; i2++) {
            Box box = (Box) this.mBoxes.get(i2);
            if (box.mAnimationStartTime != -1) {
                box.mCurrentY = box.mToY;
                box.mCurrentScale = box.mToScale;
                box.mAnimationStartTime = -1;
            }
        }
        while (i < 3) {
            Gap gap = (Gap) this.mGaps.get(i);
            if (gap.mAnimationStartTime != -1) {
                gap.mCurrentGap = gap.mToGap;
                gap.mAnimationStartTime = -1;
            }
            i++;
        }
        redraw();
    }

    public void skipToFinalPosition() {
        stopAnimation();
        snapAndRedraw();
        skipAnimation();
    }

    public void snapback() {
        snapAndRedraw();
    }

    public void startCaptureAnimationSlide(int i) {
        Box box = (Box) this.mBoxes.get(0);
        Box box2 = (Box) this.mBoxes.get(i);
        Gap gap = (Gap) this.mGaps.get(i);
        this.mPlatform.doAnimation(this.mPlatform.mDefaultX, this.mPlatform.mDefaultY, 9);
        box.doAnimation(0, box.mScaleMin, 9);
        box2.doAnimation(0, box2.mScaleMin, 9);
        gap.doAnimation(gap.mDefaultSize, 9);
        redraw();
    }

    public void startHorizontalSlide() {
        startAnimation(this.mPlatform.mDefaultX, 0, ((Box) this.mBoxes.get(0)).mScaleMin, 3);
    }

    public void stopAnimation() {
        int i = -3;
        this.mPlatform.mAnimationStartTime = -1;
        for (int i2 = -3; i2 <= 3; i2++) {
            ((Box) this.mBoxes.get(i2)).mAnimationStartTime = -1;
        }
        while (i < 3) {
            ((Gap) this.mGaps.get(i)).mAnimationStartTime = -1;
            i++;
        }
    }

    public void stopScrolling() {
        if (this.mPlatform.mAnimationStartTime != -1) {
            if (this.mFilmMode) {
                this.mFilmScroller.forceFinished(true);
            }
            Platform platform = this.mPlatform;
            Platform platform2 = this.mPlatform;
            int i = this.mPlatform.mCurrentX;
            platform2.mToX = i;
            platform.mFromX = i;
        }
    }

    public void zoomIn(float f, float f2, float f3) {
        Box box = (Box) this.mBoxes.get(0);
        int i = (int) (((-(((f - ((float) (this.mViewW / 2))) - ((float) this.mPlatform.mCurrentX)) / box.mCurrentScale)) * f3) + 0.5f);
        int i2 = (int) (((-(((f2 - ((float) (this.mViewH / 2))) - ((float) box.mCurrentY)) / box.mCurrentScale)) * f3) + 0.5f);
        calculateStableBound(f3);
        startAnimation(Utils.clamp(i, this.mBoundLeft, this.mBoundRight), Utils.clamp(i2, this.mBoundTop, this.mBoundBottom), Utils.clamp(f3, box.mScaleMin, box.mScaleMax), 4);
    }
}
