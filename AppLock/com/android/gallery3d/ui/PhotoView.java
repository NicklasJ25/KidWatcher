package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.RangeArray;

public class PhotoView extends GLView {
    private static final boolean CARD_EFFECT = true;
    private static final float DEFAULT_TEXT_SIZE = 20.0f;
    private static final int HOLD_CAPTURE_ANIMATION = 2;
    private static final int HOLD_DELETE = 4;
    private static final int HOLD_TOUCH_DOWN = 1;
    private static final int ICON_RATIO = 6;
    public static final long INVALID_DATA_VERSION = -1;
    public static final int INVALID_SIZE = -1;
    private static final int MAX_DISMISS_VELOCITY = 4000;
    private static final int MSG_CANCEL_EXTRA_SCALING = 2;
    private static final int MSG_CAPTURE_ANIMATION_DONE = 4;
    private static final int MSG_DELETE_ANIMATION_DONE = 5;
    private static final int MSG_DELETE_DONE = 6;
    private static final int MSG_SWITCH_FOCUS = 3;
    private static final int MSG_UNDO_BAR_FULL_CAMERA = 8;
    private static final int MSG_UNDO_BAR_TIMEOUT = 7;
    private static final boolean OFFSET_EFFECT = true;
    public static final int SCREEN_NAIL_MAX = 3;
    private static final int SWIPE_ESCAPE_VELOCITY = 2500;
    private static final float SWIPE_THRESHOLD = 300.0f;
    private static final String TAG = "PhotoView";
    private static float TRANSITION_SCALE_FACTOR = 0.74f;
    private static final int UNDO_BAR_DELETE_LAST = 16;
    private static final int UNDO_BAR_FULL_CAMERA = 8;
    private static final int UNDO_BAR_SHOW = 1;
    private static final int UNDO_BAR_TIMEOUT = 2;
    private static final int UNDO_BAR_TOUCHED = 4;
    private AccelerateInterpolator mAlphaInterpolator = new AccelerateInterpolator(0.9f);
    private Rect mCameraRect = new Rect();
    private Rect mCameraRelativeFrame = new Rect();
    private boolean mCancelExtraScalingPending;
    private int mCompensation = 0;
    private Context mContext;
    private int mDisplayRotation = 0;
    private boolean mFilmMode = false;
    private boolean mFullScreenCamera;
    private final MyGestureListener mGestureListener;
    private final GestureRecognizer mGestureRecognizer;
    private SynchronizedHandler mHandler;
    private int mHolding;
    private Listener mListener;
    private Model mModel;
    private int mNextBound;
    private StringTexture mNoThumbnailText;
    private final RangeArray<Picture> mPictures = new RangeArray(-3, 3);
    private final int mPlaceholderColor;
    private final PositionController mPositionController;
    private int mPrevBound;
    private ZInterpolator mScaleInterpolator = new ZInterpolator(0.5f);
    private Size[] mSizes = new Size[7];
    private TileImageView mTileView;
    private boolean mTouchBoxDeletable;
    private int mTouchBoxIndex = Integer.MAX_VALUE;
    private int mUndoBarState;
    private int mUndoIndexHint = Integer.MAX_VALUE;
    private boolean mWantPictureCenterCallbacks = false;

    public interface Model extends com.android.gallery3d.ui.TileImageView.Model {
        public static final int FOCUS_HINT_NEXT = 0;
        public static final int FOCUS_HINT_PREVIOUS = 1;
        public static final int LOADING_COMPLETE = 1;
        public static final int LOADING_FAIL = 2;
        public static final int LOADING_INIT = 0;

        int getCurrentIndex();

        int getImageRotation(int i);

        void getImageSize(int i, Size size);

        int getLoadingState(int i);

        MediaItem getMediaItem(int i);

        ScreenNail getScreenNail(int i);

        boolean isCamera(int i);

        boolean isDeletable(int i);

        boolean isStaticCamera(int i);

        boolean isVideo(int i);

        void moveTo(int i);

        void setFocusHintDirection(int i);

        void setFocusHintPath(Path path);

        void setNeedFullImage(boolean z);
    }

    public interface Listener {
        void onCommitDeleteImage();

        void onCurrentImageUpdated();

        void onDeleteImage(Path path, int i);

        void onFilmModeChanged(boolean z);

        void onFullScreenChanged(boolean z);

        void onPictureCenter(boolean z);

        void onSingleTapUp(int i, int i2);

        void onUndoBarVisibilityChanged(boolean z);

        void onUndoDeleteImage();
    }

    class C05441 implements com.android.gallery3d.ui.PositionController.Listener {
        C05441() {
        }

        public void invalidate() {
            PhotoView.this.invalidate();
        }

        public boolean isHoldingDelete() {
            return (PhotoView.this.mHolding & 4) != 0;
        }

        public boolean isHoldingDown() {
            return (PhotoView.this.mHolding & 1) != 0;
        }

        public void onAbsorb(int i, int i2) {
        }

        public void onPull(int i, int i2) {
        }

        public void onRelease() {
        }
    }

    private interface Picture {
        void draw(GLCanvas gLCanvas, Rect rect);

        void forceSize();

        Size getSize();

        boolean isCamera();

        boolean isDeletable();

        void reload();

        void setScreenNail(ScreenNail screenNail);
    }

    class FullPicture implements Picture {
        private boolean mIsCamera;
        private boolean mIsDeletable;
        private boolean mIsStaticCamera;
        private boolean mIsVideo;
        private int mLoadingState = 0;
        private int mRotation;
        private Size mSize = new Size();

        FullPicture() {
        }

        private void drawTileView(GLCanvas gLCanvas, Rect rect) {
            float imageScale = PhotoView.this.mPositionController.getImageScale();
            int width = PhotoView.this.getWidth();
            int height = PhotoView.this.getHeight();
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            gLCanvas.save(3);
            float filmRatio = PhotoView.this.mPositionController.getFilmRatio();
            Object obj = (this.mIsCamera || filmRatio == 1.0f || ((Picture) PhotoView.this.mPictures.get(-1)).isCamera() || PhotoView.this.mPositionController.inOpeningAnimation()) ? null : 1;
            Object obj2 = (this.mIsDeletable && filmRatio == 1.0f && rect.centerY() != height / 2) ? 1 : null;
            if (obj != null) {
                float access$2300;
                int i = rect.left;
                int i2 = rect.right;
                float clamp = Utils.clamp(PhotoView.calculateMoveOutProgress(i, i2, width), -1.0f, 1.0f);
                if (clamp < 0.0f) {
                    float access$2100 = PhotoView.this.getScrollScale(clamp);
                    clamp = PhotoView.this.getScrollAlpha(clamp);
                    access$2100 = PhotoView.interpolate(filmRatio, access$2100, 1.0f);
                    imageScale *= access$2100;
                    gLCanvas.multiplyAlpha(PhotoView.interpolate(filmRatio, clamp, 1.0f));
                    access$2300 = PhotoView.interpolate(filmRatio, i2 - i <= width ? ((float) width) / 2.0f : (((float) (i2 - i)) * access$2100) / 2.0f, exactCenterX);
                    exactCenterX = imageScale;
                } else {
                    access$2300 = exactCenterX;
                    exactCenterX = imageScale;
                }
                imageScale = exactCenterX;
                exactCenterX = access$2300;
            } else if (obj2 != null) {
                gLCanvas.multiplyAlpha(PhotoView.this.getOffsetAlpha(((float) (rect.centerY() - (height / 2))) / ((float) height)));
            }
            setTileViewPosition(exactCenterX, exactCenterY, width, height, imageScale);
            PhotoView.this.renderChild(gLCanvas, PhotoView.this.mTileView);
            gLCanvas.translate((float) ((int) (0.5f + exactCenterX)), (float) ((int) (0.5f + exactCenterY)));
            if (this.mLoadingState == 2) {
                PhotoView.this.drawLoadingFailMessage(gLCanvas);
            }
            gLCanvas.restore();
        }

        private void setTileViewPosition(float f, float f2, int i, int i2, float f3) {
            int imageWidth = PhotoView.this.mPositionController.getImageWidth();
            int imageHeight = PhotoView.this.mPositionController.getImageHeight();
            int i3 = (int) (((((float) imageWidth) / 2.0f) + (((((float) i) / 2.0f) - f) / f3)) + 0.5f);
            int i4 = (int) (((((float) imageHeight) / 2.0f) + (((((float) i2) / 2.0f) - f2) / f3)) + 0.5f);
            imageWidth -= i3;
            imageHeight -= i4;
            switch (this.mRotation) {
                case 0:
                    break;
                case 90:
                    i3 = i4;
                    i4 = imageWidth;
                    break;
                case FadeTexture.DURATION /*180*/:
                    i4 = imageHeight;
                    i3 = imageWidth;
                    break;
                case 270:
                    i4 = i3;
                    i3 = imageHeight;
                    break;
                default:
                    throw new RuntimeException(String.valueOf(this.mRotation));
            }
            PhotoView.this.mTileView.setPosition(i3, i4, f3, this.mRotation);
        }

        private void updateSize() {
            if (!this.mIsCamera || this.mIsStaticCamera) {
                this.mRotation = PhotoView.this.mModel.getImageRotation(0);
            } else {
                this.mRotation = PhotoView.this.getCameraRotation();
            }
            int i = PhotoView.this.mTileView.mImageWidth;
            int i2 = PhotoView.this.mTileView.mImageHeight;
            this.mSize.width = PhotoView.getRotated(this.mRotation, i, i2);
            this.mSize.height = PhotoView.getRotated(this.mRotation, i2, i);
        }

        public void draw(GLCanvas gLCanvas, Rect rect) {
            drawTileView(gLCanvas, rect);
            if ((PhotoView.this.mHolding & -2) == 0 && PhotoView.this.mWantPictureCenterCallbacks && PhotoView.this.mPositionController.isCenter()) {
                PhotoView.this.mListener.onPictureCenter(this.mIsCamera);
            }
        }

        public void forceSize() {
            updateSize();
            PhotoView.this.mPositionController.forceImageSize(0, this.mSize);
        }

        public Size getSize() {
            return this.mSize;
        }

        public boolean isCamera() {
            return this.mIsCamera;
        }

        public boolean isDeletable() {
            return this.mIsDeletable;
        }

        public void reload() {
            PhotoView.this.mTileView.notifyModelInvalidated();
            this.mIsCamera = PhotoView.this.mModel.isCamera(0);
            this.mIsStaticCamera = PhotoView.this.mModel.isStaticCamera(0);
            this.mIsVideo = PhotoView.this.mModel.isVideo(0);
            this.mIsDeletable = PhotoView.this.mModel.isDeletable(0);
            this.mLoadingState = PhotoView.this.mModel.getLoadingState(0);
            setScreenNail(PhotoView.this.mModel.getScreenNail(0));
            updateSize();
        }

        public void setScreenNail(ScreenNail screenNail) {
            PhotoView.this.mTileView.setScreenNail(screenNail);
        }
    }

    private class MyGestureListener implements com.android.gallery3d.ui.GestureRecognizer.Listener {
        private float mAccScale;
        private boolean mCanChangeMode;
        private int mDeltaY;
        private boolean mDownInScrolling;
        private boolean mFirstScrollX;
        private boolean mHadFling;
        private boolean mIgnoreScalingGesture;
        private boolean mIgnoreSwipingGesture;
        private boolean mIgnoreUpEvent;
        private boolean mModeChanged;
        private boolean mScrolledAfterDown;

        private MyGestureListener() {
            this.mIgnoreUpEvent = false;
        }

        private int calculateDeltaY(float f) {
            if (PhotoView.this.mTouchBoxDeletable) {
                return (int) (f + 0.5f);
            }
            int height = PhotoView.this.getHeight();
            float f2 = 0.15f * ((float) height);
            if (Math.abs(f) < ((float) height)) {
                f2 *= (float) Math.sin((double) ((f / ((float) height)) * 1.5707964f));
            } else if (f <= 0.0f) {
                f2 = -f2;
            }
            return (int) (f2 + 0.5f);
        }

        private void deleteAfterAnimation(int i) {
            MediaItem mediaItem = PhotoView.this.mModel.getMediaItem(PhotoView.this.mTouchBoxIndex);
            if (mediaItem != null) {
                PhotoView.this.mListener.onCommitDeleteImage();
                PhotoView.this.mUndoIndexHint = PhotoView.this.mModel.getCurrentIndex() + PhotoView.this.mTouchBoxIndex;
                PhotoView.this.mHolding = PhotoView.this.mHolding | 4;
                Message obtainMessage = PhotoView.this.mHandler.obtainMessage(5);
                obtainMessage.obj = mediaItem.getPath();
                obtainMessage.arg1 = PhotoView.this.mTouchBoxIndex;
                PhotoView.this.mHandler.sendMessageDelayed(obtainMessage, (long) i);
            }
        }

        private boolean flingImages(float f, float f2) {
            boolean z = false;
            int i = (int) (f + 0.5f);
            int i2 = (int) (0.5f + f2);
            if (!PhotoView.this.mFilmMode) {
                return PhotoView.this.mPositionController.flingPage(i, i2);
            }
            if (Math.abs(f) > Math.abs(f2)) {
                return PhotoView.this.mPositionController.flingFilmX(i);
            }
            if (!PhotoView.this.mFilmMode || PhotoView.this.mTouchBoxIndex == Integer.MAX_VALUE || !PhotoView.this.mTouchBoxDeletable) {
                return false;
            }
            boolean z2;
            int dpToPixel = GalleryUtils.dpToPixel((int) PhotoView.MAX_DISMISS_VELOCITY);
            int dpToPixel2 = GalleryUtils.dpToPixel((int) PhotoView.SWIPE_ESCAPE_VELOCITY);
            int centerY = PhotoView.this.mPositionController.getPosition(PhotoView.this.mTouchBoxIndex).centerY();
            if (Math.abs(i2) > dpToPixel2 && Math.abs(i2) > Math.abs(i)) {
                if ((i2 > 0) == (centerY > PhotoView.this.getHeight() / 2)) {
                    z2 = true;
                    if (z2) {
                        return false;
                    }
                    i = Math.min(i2, dpToPixel);
                    dpToPixel2 = PhotoView.this.mPositionController.flingFilmY(PhotoView.this.mTouchBoxIndex, i);
                    if (dpToPixel2 >= 0) {
                        return false;
                    }
                    PositionController access$300 = PhotoView.this.mPositionController;
                    if (i < 0) {
                        z = true;
                    }
                    access$300.setPopFromTop(z);
                    deleteAfterAnimation(dpToPixel2);
                    PhotoView.this.mTouchBoxIndex = Integer.MAX_VALUE;
                    return true;
                }
            }
            z2 = false;
            if (z2) {
                return false;
            }
            i = Math.min(i2, dpToPixel);
            dpToPixel2 = PhotoView.this.mPositionController.flingFilmY(PhotoView.this.mTouchBoxIndex, i);
            if (dpToPixel2 >= 0) {
                return false;
            }
            PositionController access$3002 = PhotoView.this.mPositionController;
            if (i < 0) {
                z = true;
            }
            access$3002.setPopFromTop(z);
            deleteAfterAnimation(dpToPixel2);
            PhotoView.this.mTouchBoxIndex = Integer.MAX_VALUE;
            return true;
        }

        private void startExtraScalingIfNeeded() {
            if (!PhotoView.this.mCancelExtraScalingPending) {
                PhotoView.this.mHandler.sendEmptyMessageDelayed(2, 700);
                PhotoView.this.mPositionController.setExtraScalingRange(true);
                PhotoView.this.mCancelExtraScalingPending = true;
            }
        }

        private void stopExtraScalingIfNeeded() {
            if (PhotoView.this.mCancelExtraScalingPending) {
                PhotoView.this.mHandler.removeMessages(2);
                PhotoView.this.mPositionController.setExtraScalingRange(false);
                PhotoView.this.mCancelExtraScalingPending = false;
            }
        }

        public boolean onDoubleTap(float f, float f2) {
            if (this.mIgnoreSwipingGesture) {
                return true;
            }
            if (((Picture) PhotoView.this.mPictures.get(0)).isCamera()) {
                return false;
            }
            PositionController access$300 = PhotoView.this.mPositionController;
            float imageScale = access$300.getImageScale();
            this.mIgnoreUpEvent = true;
            if (imageScale <= 0.75f || access$300.isAtMinimalScale()) {
                access$300.zoomIn(f, f2, Math.max(1.0f, imageScale * 1.5f));
            } else {
                access$300.resetToFullView();
            }
            return true;
        }

        public void onDown(float f, float f2) {
            PhotoView.this.checkHideUndoBar(4);
            this.mDeltaY = 0;
            this.mModeChanged = false;
            if (!this.mIgnoreSwipingGesture) {
                PhotoView.this.mHolding = PhotoView.this.mHolding | 1;
                if (PhotoView.this.mFilmMode && PhotoView.this.mPositionController.isScrolling()) {
                    this.mDownInScrolling = true;
                    PhotoView.this.mPositionController.stopScrolling();
                } else {
                    this.mDownInScrolling = false;
                }
                this.mHadFling = false;
                this.mScrolledAfterDown = false;
                if (PhotoView.this.mFilmMode) {
                    PhotoView.this.mTouchBoxIndex = PhotoView.this.mPositionController.hitTest((int) (f + 0.5f), (int) (f2 + 0.5f));
                    if (PhotoView.this.mTouchBoxIndex < PhotoView.this.mPrevBound || PhotoView.this.mTouchBoxIndex > PhotoView.this.mNextBound) {
                        PhotoView.this.mTouchBoxIndex = Integer.MAX_VALUE;
                        return;
                    } else {
                        PhotoView.this.mTouchBoxDeletable = ((Picture) PhotoView.this.mPictures.get(PhotoView.this.mTouchBoxIndex)).isDeletable();
                        return;
                    }
                }
                PhotoView.this.mTouchBoxIndex = Integer.MAX_VALUE;
            }
        }

        public boolean onFling(float f, float f2) {
            if (!(this.mIgnoreSwipingGesture || this.mModeChanged)) {
                if (PhotoView.this.swipeImages(f, f2)) {
                    this.mIgnoreUpEvent = true;
                } else {
                    flingImages(f, f2);
                }
                this.mHadFling = true;
            }
            return true;
        }

        public boolean onScale(float f, float f2, float f3) {
            boolean z = false;
            if (this.mIgnoreSwipingGesture || this.mIgnoreScalingGesture || this.mModeChanged) {
                return true;
            }
            if (Float.isNaN(f3) || Float.isInfinite(f3)) {
                return false;
            }
            int scaleBy = PhotoView.this.mPositionController.scaleBy(f3, f, f2);
            this.mAccScale *= f3;
            boolean z2 = this.mAccScale < 0.97f || this.mAccScale > 1.03f;
            if (this.mCanChangeMode && z2 && ((scaleBy < 0 && !PhotoView.this.mFilmMode) || (scaleBy > 0 && PhotoView.this.mFilmMode))) {
                stopExtraScalingIfNeeded();
                PhotoView.this.mHolding = PhotoView.this.mHolding & -2;
                PhotoView photoView = PhotoView.this;
                if (!PhotoView.this.mFilmMode) {
                    z = true;
                }
                photoView.setFilmMode(z);
                onScaleEnd();
                this.mModeChanged = true;
                return true;
            } else if (scaleBy != 0) {
                startExtraScalingIfNeeded();
                return true;
            } else {
                stopExtraScalingIfNeeded();
                return true;
            }
        }

        public boolean onScaleBegin(float f, float f2) {
            if (!this.mIgnoreSwipingGesture) {
                this.mIgnoreScalingGesture = ((Picture) PhotoView.this.mPictures.get(0)).isCamera();
                if (!this.mIgnoreScalingGesture) {
                    PhotoView.this.mPositionController.beginScale(f, f2);
                    boolean z = PhotoView.this.mFilmMode || PhotoView.this.mPositionController.isAtMinimalScale();
                    this.mCanChangeMode = z;
                    this.mAccScale = 1.0f;
                }
            }
            return true;
        }

        public void onScaleEnd() {
            if (!this.mIgnoreSwipingGesture && !this.mIgnoreScalingGesture && !this.mModeChanged) {
                PhotoView.this.mPositionController.endScale();
            }
        }

        public boolean onScroll(float f, float f2, float f3, float f4) {
            if (!this.mIgnoreSwipingGesture) {
                if (!this.mScrolledAfterDown) {
                    this.mScrolledAfterDown = true;
                    this.mFirstScrollX = Math.abs(f) > Math.abs(f2);
                }
                int i = (int) ((-f) + 0.5f);
                int i2 = (int) ((-f2) + 0.5f);
                if (!PhotoView.this.mFilmMode) {
                    PhotoView.this.mPositionController.scrollPage(i, i2);
                } else if (this.mFirstScrollX) {
                    PhotoView.this.mPositionController.scrollFilmX(i);
                } else if (PhotoView.this.mTouchBoxIndex != Integer.MAX_VALUE) {
                    i = calculateDeltaY(f4);
                    i2 = i - this.mDeltaY;
                    if (i2 != 0) {
                        PhotoView.this.mPositionController.scrollFilmY(PhotoView.this.mTouchBoxIndex, i2);
                        this.mDeltaY = i;
                    }
                }
            }
            return true;
        }

        public boolean onSingleTapUp(float f, float f2) {
            if (VERSION.SDK_INT >= 14 || (PhotoView.this.mHolding & 1) != 0) {
                PhotoView.this.mHolding = PhotoView.this.mHolding & -2;
                if (PhotoView.this.mFilmMode && !this.mDownInScrolling) {
                    PhotoView.this.switchToHitPicture((int) (f + 0.5f), (int) (f2 + 0.5f));
                    MediaItem mediaItem = PhotoView.this.mModel.getMediaItem(0);
                    if (((mediaItem != null ? mediaItem.getSupportedOperations() : 0) & 32768) == 0) {
                        PhotoView.this.setFilmMode(false);
                        this.mIgnoreUpEvent = true;
                    }
                }
                if (PhotoView.this.mListener != null) {
                    Matrix compensationMatrix = PhotoView.this.getGLRoot().getCompensationMatrix();
                    Matrix matrix = new Matrix();
                    compensationMatrix.invert(matrix);
                    float[] fArr = new float[]{f, f2};
                    matrix.mapPoints(fArr);
                    PhotoView.this.mListener.onSingleTapUp((int) (fArr[0] + 0.5f), (int) (fArr[1] + 0.5f));
                }
            }
            return true;
        }

        public void onUp() {
            if (!this.mIgnoreSwipingGesture) {
                PhotoView.this.mHolding = PhotoView.this.mHolding & -2;
                if (PhotoView.this.mFilmMode && this.mScrolledAfterDown && !this.mFirstScrollX && PhotoView.this.mTouchBoxIndex != Integer.MAX_VALUE) {
                    Rect position = PhotoView.this.mPositionController.getPosition(PhotoView.this.mTouchBoxIndex);
                    int height = PhotoView.this.getHeight();
                    if (Math.abs(((float) position.centerY()) - (((float) height) * 0.5f)) > 0.4f * ((float) height)) {
                        int flingFilmY = PhotoView.this.mPositionController.flingFilmY(PhotoView.this.mTouchBoxIndex, 0);
                        if (flingFilmY >= 0) {
                            PhotoView.this.mPositionController.setPopFromTop(((float) position.centerY()) < ((float) height) * 0.5f);
                            deleteAfterAnimation(flingFilmY);
                        }
                    }
                }
                if (this.mIgnoreUpEvent) {
                    this.mIgnoreUpEvent = false;
                } else if (!PhotoView.this.mFilmMode || this.mHadFling || !this.mFirstScrollX || !PhotoView.this.snapToNeighborImage()) {
                    PhotoView.this.snapback();
                }
            }
        }

        public void setSwipingEnabled(boolean z) {
            this.mIgnoreSwipingGesture = !z;
        }
    }

    class MyHandler extends SynchronizedHandler {
        public MyHandler(GLRoot gLRoot) {
            super(gLRoot);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    PhotoView.this.mGestureRecognizer.cancelScale();
                    PhotoView.this.mPositionController.setExtraScalingRange(false);
                    PhotoView.this.mCancelExtraScalingPending = false;
                    return;
                case 3:
                    PhotoView.this.switchFocus();
                    return;
                case 4:
                    PhotoView.this.captureAnimationDone(message.arg1);
                    return;
                case 5:
                    PhotoView.this.mListener.onDeleteImage((Path) message.obj, message.arg1);
                    PhotoView.this.mHandler.removeMessages(6);
                    PhotoView.this.mHandler.sendMessageDelayed(PhotoView.this.mHandler.obtainMessage(6), 2000);
                    int access$900 = (PhotoView.this.mNextBound - PhotoView.this.mPrevBound) + 1;
                    if (access$900 == 2 && (PhotoView.this.mModel.isCamera(PhotoView.this.mNextBound) || PhotoView.this.mModel.isCamera(PhotoView.this.mPrevBound))) {
                        access$900--;
                    }
                    PhotoView.this.showUndoBar(access$900 <= 1);
                    return;
                case 6:
                    if (!PhotoView.this.mHandler.hasMessages(5)) {
                        PhotoView.this.mHolding = PhotoView.this.mHolding & -5;
                        PhotoView.this.snapback();
                        return;
                    }
                    return;
                case 7:
                    PhotoView.this.checkHideUndoBar(2);
                    return;
                case 8:
                    PhotoView.this.checkHideUndoBar(8);
                    return;
                default:
                    throw new AssertionError(message.what);
            }
        }
    }

    private class ScreenNailPicture implements Picture {
        private int mIndex;
        private boolean mIsCamera;
        private boolean mIsDeletable;
        private boolean mIsPanorama;
        private boolean mIsStaticCamera;
        private boolean mIsVideo;
        private int mLoadingState = 0;
        private int mRotation;
        private ScreenNail mScreenNail;
        private Size mSize = new Size();

        public ScreenNailPicture(int i) {
            this.mIndex = i;
        }

        private boolean isScreenNailAnimating() {
            return (this.mScreenNail instanceof TiledScreenNail) && ((TiledScreenNail) this.mScreenNail).isAnimating();
        }

        private void updateSize() {
            if (!this.mIsCamera || this.mIsStaticCamera) {
                this.mRotation = PhotoView.this.mModel.getImageRotation(this.mIndex);
            } else {
                this.mRotation = PhotoView.this.getCameraRotation();
            }
            if (this.mScreenNail != null) {
                this.mSize.width = this.mScreenNail.getWidth();
                this.mSize.height = this.mScreenNail.getHeight();
            } else {
                PhotoView.this.mModel.getImageSize(this.mIndex, this.mSize);
            }
            int i = this.mSize.width;
            int i2 = this.mSize.height;
            this.mSize.width = PhotoView.getRotated(this.mRotation, i, i2);
            this.mSize.height = PhotoView.getRotated(this.mRotation, i2, i);
        }

        public void draw(GLCanvas gLCanvas, Rect rect) {
            int i = 0;
            if (this.mScreenNail != null) {
                int width = PhotoView.this.getWidth();
                int height = PhotoView.this.getHeight();
                if (rect.left >= width || rect.right <= 0 || rect.top >= height || rect.bottom <= 0) {
                    this.mScreenNail.noDraw();
                    return;
                }
                float filmRatio = PhotoView.this.mPositionController.getFilmRatio();
                int i2 = (this.mIndex <= 0 || filmRatio == 1.0f || ((Picture) PhotoView.this.mPictures.get(0)).isCamera()) ? 0 : 1;
                if (this.mIsDeletable && filmRatio == 1.0f && rect.centerY() != height / 2) {
                    i = 1;
                }
                int access$2300 = i2 != 0 ? (int) (PhotoView.interpolate(filmRatio, (float) (width / 2), (float) rect.centerX()) + 0.5f) : rect.centerX();
                int centerY = rect.centerY();
                gLCanvas.save(3);
                gLCanvas.translate((float) access$2300, (float) centerY);
                if (i2 != 0) {
                    float clamp = Utils.clamp(((float) ((width / 2) - rect.centerX())) / ((float) width), -1.0f, 1.0f);
                    float access$2200 = PhotoView.this.getScrollAlpha(clamp);
                    clamp = PhotoView.this.getScrollScale(clamp);
                    access$2200 = PhotoView.interpolate(filmRatio, access$2200, 1.0f);
                    clamp = PhotoView.interpolate(filmRatio, clamp, 1.0f);
                    gLCanvas.multiplyAlpha(access$2200);
                    gLCanvas.scale(clamp, clamp, 1.0f);
                } else if (i != 0) {
                    gLCanvas.multiplyAlpha(PhotoView.this.getOffsetAlpha(((float) (rect.centerY() - (height / 2))) / ((float) height)));
                }
                if (this.mRotation != 0) {
                    gLCanvas.rotate((float) this.mRotation, 0.0f, 0.0f, 1.0f);
                }
                height = PhotoView.getRotated(this.mRotation, rect.width(), rect.height());
                int access$1700 = PhotoView.getRotated(this.mRotation, rect.height(), rect.width());
                this.mScreenNail.draw(gLCanvas, (-height) / 2, (-access$1700) / 2, height, access$1700);
                if (isScreenNailAnimating()) {
                    PhotoView.this.invalidate();
                }
                if (this.mLoadingState == 2) {
                    PhotoView.this.drawLoadingFailMessage(gLCanvas);
                }
                gLCanvas.restore();
            } else if (this.mIndex >= PhotoView.this.mPrevBound && this.mIndex <= PhotoView.this.mNextBound) {
                PhotoView.this.drawPlaceHolder(gLCanvas, rect);
            }
        }

        public void forceSize() {
            updateSize();
            PhotoView.this.mPositionController.forceImageSize(this.mIndex, this.mSize);
        }

        public Size getSize() {
            return this.mSize;
        }

        public boolean isCamera() {
            return this.mIsCamera;
        }

        public boolean isDeletable() {
            return this.mIsDeletable;
        }

        public void reload() {
            this.mIsCamera = PhotoView.this.mModel.isCamera(this.mIndex);
            this.mIsStaticCamera = PhotoView.this.mModel.isStaticCamera(this.mIndex);
            this.mIsVideo = PhotoView.this.mModel.isVideo(this.mIndex);
            this.mIsDeletable = PhotoView.this.mModel.isDeletable(this.mIndex);
            this.mLoadingState = PhotoView.this.mModel.getLoadingState(this.mIndex);
            setScreenNail(PhotoView.this.mModel.getScreenNail(this.mIndex));
            updateSize();
        }

        public void setScreenNail(ScreenNail screenNail) {
            this.mScreenNail = screenNail;
        }
    }

    public static class Size {
        public int height;
        public int width;
    }

    private static class ZInterpolator {
        private float focalLength;

        public ZInterpolator(float f) {
            this.focalLength = f;
        }

        public float getInterpolation(float f) {
            return (1.0f - (this.focalLength / (this.focalLength + f))) / (1.0f - (this.focalLength / (this.focalLength + 1.0f)));
        }
    }

    public PhotoView(AbstractGalleryActivity abstractGalleryActivity) {
        int i = -3;
        this.mTileView = new TileImageView(abstractGalleryActivity);
        addComponent(this.mTileView);
        this.mContext = abstractGalleryActivity.getAndroidContext();
        this.mPlaceholderColor = this.mContext.getResources().getColor(C0488R.color.photo_placeholder);
        this.mNoThumbnailText = StringTexture.newInstance(this.mContext.getString(C0488R.string.no_thumbnail), DEFAULT_TEXT_SIZE, -1);
        this.mHandler = new MyHandler(abstractGalleryActivity.getGLRoot());
        this.mGestureListener = new MyGestureListener();
        this.mGestureRecognizer = new GestureRecognizer(this.mContext, this.mGestureListener);
        this.mPositionController = new PositionController(this.mContext, new C05441());
        while (i <= 3) {
            if (i == 0) {
                this.mPictures.put(i, new FullPicture());
            } else {
                this.mPictures.put(i, new ScreenNailPicture(i));
            }
            i++;
        }
    }

    private static float calculateMoveOutProgress(int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i4 >= i3) {
            return i > 0 ? ((float) (-i)) / ((float) i3) : i2 < i3 ? ((float) (i3 - i2)) / ((float) i3) : 0.0f;
        } else {
            int i5 = (i3 / 2) - (i4 / 2);
            return i > i5 ? ((float) (-(i - i5))) / ((float) (i3 - i5)) : ((float) (i - i5)) / ((float) ((-i4) - i5));
        }
    }

    private void captureAnimationDone(int i) {
        this.mHolding &= -3;
        snapback();
    }

    private void checkFocusSwitching() {
        if (this.mFilmMode && !this.mHandler.hasMessages(3) && switchPosition() != 0) {
            this.mHandler.sendEmptyMessage(3);
        }
    }

    private void checkHideUndoBar(int i) {
        Object obj = 1;
        this.mUndoBarState |= i;
        if ((this.mUndoBarState & 1) != 0) {
            Object obj2 = (this.mUndoBarState & 2) != 0 ? 1 : null;
            Object obj3 = (this.mUndoBarState & 4) != 0 ? 1 : null;
            Object obj4 = (this.mUndoBarState & 8) != 0 ? 1 : null;
            if ((this.mUndoBarState & 16) == 0) {
                obj = null;
            }
            if ((obj2 != null && r1 != null) || obj4 != null || obj3 != null) {
                hideUndoBar();
            }
        }
    }

    private void drawLoadingFailMessage(GLCanvas gLCanvas) {
        StringTexture stringTexture = this.mNoThumbnailText;
        stringTexture.draw(gLCanvas, (-stringTexture.getWidth()) / 2, (-stringTexture.getHeight()) / 2);
    }

    private void drawPlaceHolder(GLCanvas gLCanvas, Rect rect) {
        gLCanvas.fillRect((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height(), this.mPlaceholderColor);
    }

    private static int gapToSide(int i, int i2) {
        return Math.max(0, (i2 - i) / 2);
    }

    private int getCameraRotation() {
        return ((this.mCompensation - this.mDisplayRotation) + 360) % 360;
    }

    private float getOffsetAlpha(float f) {
        float f2 = f / 0.5f;
        return Utils.clamp(f2 > 0.0f ? 1.0f - f2 : f2 + 1.0f, 0.03f, 1.0f);
    }

    private static int getRotated(int i, int i2, int i3) {
        return i % FadeTexture.DURATION == 0 ? i2 : i3;
    }

    private float getScrollAlpha(float f) {
        return f < 0.0f ? this.mAlphaInterpolator.getInterpolation(1.0f - Math.abs(f)) : 1.0f;
    }

    private float getScrollScale(float f) {
        float interpolation = this.mScaleInterpolator.getInterpolation(Math.abs(f));
        return (interpolation * TRANSITION_SCALE_FACTOR) + (1.0f - interpolation);
    }

    private void hideUndoBar() {
        this.mHandler.removeMessages(7);
        this.mListener.onCommitDeleteImage();
        this.mUndoBarState = 0;
        this.mUndoIndexHint = Integer.MAX_VALUE;
        this.mListener.onUndoBarVisibilityChanged(false);
    }

    private static float interpolate(float f, float f2, float f3) {
        return (((f3 - f2) * f) * f) + f2;
    }

    private void setPictureSize(int i) {
        Picture picture = (Picture) this.mPictures.get(i);
        PositionController positionController = this.mPositionController;
        Size size = picture.getSize();
        Rect rect = (i == 0 && picture.isCamera()) ? this.mCameraRect : null;
        positionController.setImageSize(i, size, rect);
    }

    private void showUndoBar(boolean z) {
        this.mHandler.removeMessages(7);
        this.mUndoBarState = 1;
        if (z) {
            this.mUndoBarState |= 16;
        }
        this.mHandler.sendEmptyMessageDelayed(7, 3000);
        if (this.mListener != null) {
            this.mListener.onUndoBarVisibilityChanged(true);
        }
    }

    private boolean slideToNextPicture() {
        if (this.mNextBound <= 0) {
            return false;
        }
        switchToNextImage();
        this.mPositionController.startHorizontalSlide();
        return true;
    }

    private boolean slideToPrevPicture() {
        if (this.mPrevBound >= 0) {
            return false;
        }
        switchToPrevImage();
        this.mPositionController.startHorizontalSlide();
        return true;
    }

    private boolean snapToNeighborImage() {
        Rect position = this.mPositionController.getPosition(0);
        int width = getWidth();
        int gapToSide = (width / 5) + gapToSide(position.width(), width);
        return width - position.right > gapToSide ? slideToNextPicture() : position.left > gapToSide ? slideToPrevPicture() : false;
    }

    private void snapback() {
        if ((this.mHolding & -5) == 0) {
            if (this.mFilmMode || !snapToNeighborImage()) {
                this.mPositionController.snapback();
            }
        }
    }

    private boolean swipeImages(float f, float f2) {
        if (this.mFilmMode) {
            return false;
        }
        PositionController positionController = this.mPositionController;
        boolean isAtMinimalScale = positionController.isAtMinimalScale();
        int imageAtEdges = positionController.getImageAtEdges();
        return (isAtMinimalScale || Math.abs(f2) <= Math.abs(f) || !((imageAtEdges & 4) == 0 || (imageAtEdges & 8) == 0)) ? (f >= -300.0f || (!isAtMinimalScale && (imageAtEdges & 2) == 0)) ? f > SWIPE_THRESHOLD ? (isAtMinimalScale || (imageAtEdges & 1) != 0) ? slideToPrevPicture() : false : false : slideToNextPicture() : false;
    }

    private void switchFocus() {
        if (this.mHolding == 0) {
            switch (switchPosition()) {
                case -1:
                    switchToPrevImage();
                    return;
                case 1:
                    switchToNextImage();
                    return;
                default:
                    return;
            }
        }
    }

    private int switchPosition() {
        Rect position = this.mPositionController.getPosition(0);
        int width = getWidth() / 2;
        if (position.left > width && this.mPrevBound < 0) {
            if (width - this.mPositionController.getPosition(-1).right < position.left - width) {
                return -1;
            }
        } else if (position.right < width && this.mNextBound > 0) {
            if (this.mPositionController.getPosition(1).left - width < width - position.right) {
                return 1;
            }
        }
        return 0;
    }

    private void switchToFirstImage() {
        this.mModel.moveTo(0);
    }

    private void switchToHitPicture(int i, int i2) {
        if (this.mPrevBound < 0 && this.mPositionController.getPosition(-1).right >= i) {
            slideToPrevPicture();
        } else if (this.mNextBound > 0 && this.mPositionController.getPosition(1).left <= i) {
            slideToNextPicture();
        }
    }

    private void switchToNextImage() {
        this.mModel.moveTo(this.mModel.getCurrentIndex() + 1);
    }

    private void switchToPrevImage() {
        this.mModel.moveTo(this.mModel.getCurrentIndex() - 1);
    }

    private boolean switchWithCaptureAnimationLocked(int i) {
        if (this.mHolding != 0) {
            return true;
        }
        if (i == 1) {
            if (this.mNextBound <= 0) {
                return false;
            }
            switchToNextImage();
            this.mPositionController.startCaptureAnimationSlide(-1);
        } else if (i != -1) {
            return false;
        } else {
            if (this.mPrevBound >= 0) {
                return false;
            }
            if (this.mFilmMode) {
                setFilmMode(false);
            }
            if (this.mModel.getCurrentIndex() > 3) {
                switchToFirstImage();
                this.mPositionController.skipToFinalPosition();
                return true;
            }
            switchToFirstImage();
            this.mPositionController.startCaptureAnimationSlide(1);
        }
        this.mHolding |= 2;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4, i, 0), 700);
        return true;
    }

    private void updateCameraRect() {
        int width = getWidth();
        int height = getHeight();
        if (this.mCompensation % FadeTexture.DURATION == 0) {
            int i = height;
            height = width;
            width = i;
        }
        int i2 = this.mCameraRelativeFrame.left;
        int i3 = this.mCameraRelativeFrame.top;
        int i4 = this.mCameraRelativeFrame.right;
        int i5 = this.mCameraRelativeFrame.bottom;
        switch (this.mCompensation) {
            case 0:
                this.mCameraRect.set(i2, i3, i4, i5);
                break;
            case 90:
                this.mCameraRect.set(width - i5, i2, width - i3, i4);
                break;
            case FadeTexture.DURATION /*180*/:
                this.mCameraRect.set(height - i4, width - i5, height - i2, width - i3);
                break;
            case 270:
                this.mCameraRect.set(i3, height - i4, i5, height - i2);
                break;
        }
        Log.m451d(TAG, "compensation = " + this.mCompensation + ", CameraRelativeFrame = " + this.mCameraRelativeFrame + ", mCameraRect = " + this.mCameraRect);
    }

    public PhotoFallbackEffect buildFallbackEffect(GLView gLView, GLCanvas gLCanvas) {
        Rect rect = new Rect();
        Utils.assertTrue(gLView.getBoundsOf(this, rect));
        Rect bounds = bounds();
        PhotoFallbackEffect photoFallbackEffect = new PhotoFallbackEffect();
        for (int i = -3; i <= 3; i++) {
            MediaItem mediaItem = this.mModel.getMediaItem(i);
            if (mediaItem != null) {
                ScreenNail screenNail = this.mModel.getScreenNail(i);
                if ((screenNail instanceof TiledScreenNail) && !((TiledScreenNail) screenNail).isShowingPlaceholder()) {
                    Rect rect2 = new Rect(getPhotoRect(i));
                    if (Rect.intersects(bounds, rect2)) {
                        RawTexture rawTexture;
                        rect2.offset(rect.left, rect.top);
                        int width = screenNail.getWidth();
                        int height = screenNail.getHeight();
                        int imageRotation = this.mModel.getImageRotation(i);
                        RawTexture rawTexture2;
                        if (imageRotation % FadeTexture.DURATION == 0) {
                            rawTexture2 = new RawTexture(width, height, true);
                            gLCanvas.beginRenderTarget(rawTexture2);
                            gLCanvas.translate(((float) width) / 2.0f, ((float) height) / 2.0f);
                            rawTexture = rawTexture2;
                        } else {
                            rawTexture2 = new RawTexture(height, width, true);
                            gLCanvas.beginRenderTarget(rawTexture2);
                            gLCanvas.translate(((float) height) / 2.0f, ((float) width) / 2.0f);
                            rawTexture = rawTexture2;
                        }
                        gLCanvas.rotate((float) imageRotation, 0.0f, 0.0f, 1.0f);
                        gLCanvas.translate(((float) (-width)) / 2.0f, ((float) (-height)) / 2.0f);
                        screenNail.draw(gLCanvas, 0, 0, width, height);
                        gLCanvas.endRenderTarget();
                        photoFallbackEffect.addEntry(mediaItem.getPath(), rect2, rawTexture);
                    }
                }
            }
        }
        return photoFallbackEffect;
    }

    public boolean canUndo() {
        return (this.mUndoBarState & 1) != 0;
    }

    public boolean getFilmMode() {
        return this.mFilmMode;
    }

    public Rect getPhotoRect(int i) {
        return this.mPositionController.getPosition(i);
    }

    public boolean isDeleting() {
        return (this.mHolding & 4) != 0 && this.mPositionController.hasDeletingBox();
    }

    public void notifyDataChange(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        this.mPrevBound = i;
        this.mNextBound = i2;
        if (this.mTouchBoxIndex != Integer.MAX_VALUE) {
            i3 = this.mTouchBoxIndex;
            this.mTouchBoxIndex = Integer.MAX_VALUE;
            for (i4 = 0; i4 < 7; i4++) {
                if (iArr[i4] == i3) {
                    this.mTouchBoxIndex = i4 - 3;
                    break;
                }
            }
        }
        if (this.mUndoIndexHint != Integer.MAX_VALUE && Math.abs(this.mUndoIndexHint - this.mModel.getCurrentIndex()) >= 3) {
            hideUndoBar();
        }
        for (i3 = -3; i3 <= 3; i3++) {
            Picture picture = (Picture) this.mPictures.get(i3);
            picture.reload();
            this.mSizes[i3 + 3] = picture.getSize();
        }
        boolean hasDeletingBox = this.mPositionController.hasDeletingBox();
        this.mPositionController.moveBox(iArr, this.mPrevBound < 0, this.mNextBound > 0, this.mModel.isCamera(0), this.mSizes);
        for (i4 = -3; i4 <= 3; i4++) {
            setPictureSize(i4);
        }
        boolean hasDeletingBox2 = this.mPositionController.hasDeletingBox();
        if (hasDeletingBox && !hasDeletingBox2) {
            this.mHandler.removeMessages(6);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(6), 600);
        }
        invalidate();
    }

    public void notifyImageChange(int i) {
        if (i == 0) {
            this.mListener.onCurrentImageUpdated();
        }
        ((Picture) this.mPictures.get(i)).reload();
        setPictureSize(i);
        invalidate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mTileView.layout(0, 0, i3 - i, i4 - i2);
        GLRoot gLRoot = getGLRoot();
        int displayRotation = gLRoot.getDisplayRotation();
        int compensation = gLRoot.getCompensation();
        if (!(this.mDisplayRotation == displayRotation && this.mCompensation == compensation)) {
            this.mDisplayRotation = displayRotation;
            this.mCompensation = compensation;
            for (displayRotation = -3; displayRotation <= 3; displayRotation++) {
                Picture picture = (Picture) this.mPictures.get(displayRotation);
                if (picture.isCamera()) {
                    picture.forceSize();
                }
            }
        }
        updateCameraRect();
        this.mPositionController.setConstrainedFrame(this.mCameraRect);
        if (z) {
            this.mPositionController.setViewSize(getWidth(), getHeight());
        }
    }

    protected boolean onTouch(MotionEvent motionEvent) {
        this.mGestureRecognizer.onTouchEvent(motionEvent);
        return true;
    }

    public void pause() {
        this.mPositionController.skipAnimation();
        this.mTileView.freeTextures();
        for (int i = -3; i <= 3; i++) {
            ((Picture) this.mPictures.get(i)).setScreenNail(null);
        }
        hideUndoBar();
    }

    protected void render(GLCanvas gLCanvas) {
        int i = 0;
        boolean z = !this.mFilmMode && ((Picture) this.mPictures.get(0)).isCamera() && this.mPositionController.isCenter() && this.mPositionController.isAtMinimalScale();
        if (z != this.mFullScreenCamera) {
            this.mFullScreenCamera = z;
            this.mListener.onFullScreenChanged(z);
            if (z) {
                this.mHandler.sendEmptyMessage(8);
            }
        }
        if (!this.mFullScreenCamera) {
            int i2 = this.mPositionController.getFilmRatio() == 0.0f ? 1 : 0;
            if ((this.mHolding & 2) != 0) {
                i = 1;
            }
            i = (i2 == 0 || i != 0) ? 3 : 1;
        }
        for (int i3 = i; i3 >= (-i); i3--) {
            ((Picture) this.mPictures.get(i3)).draw(gLCanvas, this.mPositionController.getPosition(i3));
        }
        this.mPositionController.advanceAnimation();
        checkFocusSwitching();
    }

    public void resetToFirstPicture() {
        this.mModel.moveTo(0);
        setFilmMode(false);
    }

    public void resume() {
        this.mTileView.prepareTextures();
        this.mPositionController.skipToFinalPosition();
    }

    public void setCameraRelativeFrame(Rect rect) {
        this.mCameraRelativeFrame.set(rect);
        updateCameraRect();
    }

    public void setFilmMode(boolean z) {
        int i = 1;
        if (this.mFilmMode != z) {
            this.mFilmMode = z;
            this.mPositionController.setFilmMode(this.mFilmMode);
            this.mModel.setNeedFullImage(!z);
            Model model = this.mModel;
            if (!this.mFilmMode) {
                i = 0;
            }
            model.setFocusHintDirection(i);
            this.mListener.onFilmModeChanged(z);
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void setModel(Model model) {
        this.mModel = model;
        this.mTileView.setModel(this.mModel);
    }

    public void setOpenAnimationRect(Rect rect) {
        this.mPositionController.setOpenAnimationRect(rect);
    }

    public void setSwipingEnabled(boolean z) {
        this.mGestureListener.setSwipingEnabled(z);
    }

    public void setWantPictureCenterCallbacks(boolean z) {
        this.mWantPictureCenterCallbacks = z;
    }

    public void stopScrolling() {
        this.mPositionController.stopScrolling();
    }

    public void switchToImage(int i) {
        this.mModel.moveTo(i);
    }

    public boolean switchWithCaptureAnimation(int i) {
        GLRoot gLRoot = getGLRoot();
        if (gLRoot == null) {
            return false;
        }
        gLRoot.lockRenderThread();
        try {
            boolean switchWithCaptureAnimationLocked = switchWithCaptureAnimationLocked(i);
            return switchWithCaptureAnimationLocked;
        } finally {
            gLRoot.unlockRenderThread();
        }
    }
}
