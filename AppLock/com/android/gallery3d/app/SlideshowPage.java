package com.android.gallery3d.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.app.SlideshowDataAdapter.SlideshowSource;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.ContentListener;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.GLCanvas;
import com.android.gallery3d.ui.GLView;
import com.android.gallery3d.ui.SlideshowView;
import com.android.gallery3d.ui.SynchronizedHandler;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import java.util.ArrayList;
import java.util.Random;

public class SlideshowPage extends ActivityState {
    public static final String KEY_DREAM = "dream";
    public static final String KEY_ITEM_PATH = "media-item-path";
    public static final String KEY_PHOTO_INDEX = "photo-index";
    public static final String KEY_RANDOM_ORDER = "random-order";
    public static final String KEY_REPEAT = "repeat";
    public static final String KEY_SET_PATH = "media-set-path";
    private static final int MSG_LOAD_NEXT_BITMAP = 1;
    private static final int MSG_SHOW_PENDING_BITMAP = 2;
    private static final long SLIDESHOW_DELAY = 3000;
    private static final String TAG = "SlideshowPage";
    private Handler mHandler;
    private boolean mIsActive = false;
    private Model mModel;
    private Slide mPendingSlide = null;
    private final Intent mResultIntent = new Intent();
    private final GLView mRootPane = new C05211();
    private SlideshowView mSlideshowView;

    public interface Model {
        Future<Slide> nextSlide(FutureListener<Slide> futureListener);

        void pause();

        void resume();
    }

    class C05211 extends GLView {
        C05211() {
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            SlideshowPage.this.mSlideshowView.layout(0, 0, i3 - i, i4 - i2);
        }

        protected boolean onTouch(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                SlideshowPage.this.onBackPressed();
            }
            return true;
        }

        protected void renderBackground(GLCanvas gLCanvas) {
            gLCanvas.clearBuffer(getBackgroundColor());
        }
    }

    class C05233 implements FutureListener<Slide> {
        C05233() {
        }

        public void onFutureDone(Future<Slide> future) {
            SlideshowPage.this.mPendingSlide = (Slide) future.get();
            SlideshowPage.this.mHandler.sendEmptyMessage(2);
        }
    }

    private static class SequentialSource implements SlideshowSource {
        private static final int DATA_SIZE = 32;
        private ArrayList<MediaItem> mData = new ArrayList();
        private int mDataStart = 0;
        private long mDataVersion = -1;
        private final MediaSet mMediaSet;
        private final boolean mRepeat;

        public SequentialSource(MediaSet mediaSet, boolean z) {
            this.mMediaSet = mediaSet;
            this.mRepeat = z;
        }

        public void addContentListener(ContentListener contentListener) {
            this.mMediaSet.addContentListener(contentListener);
        }

        public int findItemIndex(Path path, int i) {
            return this.mMediaSet.getIndexOfItem(path, i);
        }

        public MediaItem getMediaItem(int i) {
            int size = this.mDataStart + this.mData.size();
            if (this.mRepeat) {
                int mediaItemCount = this.mMediaSet.getMediaItemCount();
                if (mediaItemCount == 0) {
                    return null;
                }
                i %= mediaItemCount;
            }
            if (i < this.mDataStart || i >= size) {
                this.mData = this.mMediaSet.getMediaItem(i, 32);
                this.mDataStart = i;
                size = this.mData.size() + i;
            }
            MediaItem mediaItem = (i < this.mDataStart || i >= size) ? null : (MediaItem) this.mData.get(i - this.mDataStart);
            return mediaItem;
        }

        public long reload() {
            long reload = this.mMediaSet.reload();
            if (reload != this.mDataVersion) {
                this.mDataVersion = reload;
                this.mData.clear();
            }
            return this.mDataVersion;
        }

        public void removeContentListener(ContentListener contentListener) {
            this.mMediaSet.removeContentListener(contentListener);
        }
    }

    private static class ShuffleSource implements SlideshowSource {
        private static final int RETRY_COUNT = 5;
        private int mLastIndex = -1;
        private final MediaSet mMediaSet;
        private int[] mOrder = new int[0];
        private final Random mRandom = new Random();
        private final boolean mRepeat;
        private long mSourceVersion = -1;

        public ShuffleSource(MediaSet mediaSet, boolean z) {
            this.mMediaSet = (MediaSet) Utils.checkNotNull(mediaSet);
            this.mRepeat = z;
        }

        private void generateOrderArray(int i) {
            int i2;
            if (this.mOrder.length != i) {
                this.mOrder = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    this.mOrder[i2] = i2;
                }
            }
            for (i2 = i - 1; i2 > 0; i2--) {
                Utils.swap(this.mOrder, i2, this.mRandom.nextInt(i2 + 1));
            }
            if (this.mOrder[0] == this.mLastIndex && i > 1) {
                Utils.swap(this.mOrder, 0, this.mRandom.nextInt(i - 1) + 1);
            }
        }

        public void addContentListener(ContentListener contentListener) {
            this.mMediaSet.addContentListener(contentListener);
        }

        public int findItemIndex(Path path, int i) {
            return i;
        }

        public MediaItem getMediaItem(int i) {
            MediaItem mediaItem = null;
            if ((this.mRepeat || i < this.mOrder.length) && this.mOrder.length != 0) {
                this.mLastIndex = this.mOrder[i % this.mOrder.length];
                mediaItem = SlideshowPage.findMediaItem(this.mMediaSet, this.mLastIndex);
                int i2 = 0;
                while (i2 < 5 && r0 == null) {
                    Log.m437w(SlideshowPage.TAG, "fail to find image: " + this.mLastIndex);
                    this.mLastIndex = this.mRandom.nextInt(this.mOrder.length);
                    i2++;
                    mediaItem = SlideshowPage.findMediaItem(this.mMediaSet, this.mLastIndex);
                }
            }
            return mediaItem;
        }

        public long reload() {
            long reload = this.mMediaSet.reload();
            if (reload != this.mSourceVersion) {
                this.mSourceVersion = reload;
                int totalMediaItemCount = this.mMediaSet.getTotalMediaItemCount();
                if (totalMediaItemCount != this.mOrder.length) {
                    generateOrderArray(totalMediaItemCount);
                }
            }
            return reload;
        }

        public void removeContentListener(ContentListener contentListener) {
            this.mMediaSet.removeContentListener(contentListener);
        }
    }

    public static class Slide {
        public Bitmap bitmap;
        public int index;
        public MediaItem item;

        public Slide(MediaItem mediaItem, int i, Bitmap bitmap) {
            this.bitmap = bitmap;
            this.item = mediaItem;
            this.index = i;
        }
    }

    private static MediaItem findMediaItem(MediaSet mediaSet, int i) {
        int subMediaSetCount = mediaSet.getSubMediaSetCount();
        for (int i2 = 0; i2 < subMediaSetCount; i2++) {
            MediaSet subMediaSet = mediaSet.getSubMediaSet(i2);
            int totalMediaItemCount = subMediaSet.getTotalMediaItemCount();
            if (i < totalMediaItemCount) {
                return findMediaItem(subMediaSet, i);
            }
            i -= totalMediaItemCount;
        }
        ArrayList mediaItem = mediaSet.getMediaItem(i, 1);
        return mediaItem.isEmpty() ? null : (MediaItem) mediaItem.get(0);
    }

    private void initializeData(Bundle bundle) {
        Path path = null;
        boolean z = bundle.getBoolean(KEY_RANDOM_ORDER, false);
        MediaSet mediaSet = this.mActivity.getDataManager().getMediaSet(FilterUtils.newFilterPath(bundle.getString("media-set-path"), 1));
        if (z) {
            this.mModel = new SlideshowDataAdapter(this.mActivity, new ShuffleSource(mediaSet, bundle.getBoolean(KEY_REPEAT)), 0, null);
            setStateResult(-1, this.mResultIntent.putExtra(KEY_PHOTO_INDEX, 0));
            return;
        }
        int i = bundle.getInt(KEY_PHOTO_INDEX);
        String string = bundle.getString("media-item-path");
        if (string != null) {
            path = Path.fromString(string);
        }
        this.mModel = new SlideshowDataAdapter(this.mActivity, new SequentialSource(mediaSet, bundle.getBoolean(KEY_REPEAT)), i, path);
        setStateResult(-1, this.mResultIntent.putExtra(KEY_PHOTO_INDEX, i));
    }

    private void initializeViews() {
        this.mSlideshowView = new SlideshowView();
        this.mRootPane.addComponent(this.mSlideshowView);
        setContentPane(this.mRootPane);
    }

    private void loadNextBitmap() {
        this.mModel.nextSlide(new C05233());
    }

    private void showPendingBitmap() {
        Slide slide = this.mPendingSlide;
        if (slide != null) {
            this.mSlideshowView.next(slide.bitmap, slide.item.getRotation());
            setStateResult(-1, this.mResultIntent.putExtra("media-item-path", slide.item.getPath().toString()).putExtra(KEY_PHOTO_INDEX, slide.index));
            this.mHandler.sendEmptyMessageDelayed(1, SLIDESHOW_DELAY);
        } else if (this.mIsActive) {
            this.mActivity.getStateManager().finishState(this);
        }
    }

    protected int getBackgroundColorId() {
        return C0488R.color.slideshow_background;
    }

    public void onCreate(Bundle bundle, Bundle bundle2) {
        super.onCreate(bundle, bundle2);
        this.mFlags |= 51;
        if (bundle.getBoolean(KEY_DREAM)) {
            this.mFlags |= 4;
        } else {
            this.mFlags |= 8;
        }
        this.mHandler = new SynchronizedHandler(this.mActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        SlideshowPage.this.loadNextBitmap();
                        return;
                    case 2:
                        SlideshowPage.this.showPendingBitmap();
                        return;
                    default:
                        throw new AssertionError();
                }
            }
        };
        initializeViews();
        initializeData(bundle);
    }

    public void onPause() {
        super.onPause();
        this.mIsActive = false;
        this.mModel.pause();
        this.mSlideshowView.release();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void onResume() {
        super.onResume();
        this.mIsActive = true;
        this.mModel.resume();
        if (this.mPendingSlide != null) {
            showPendingBitmap();
        } else {
            loadNextBitmap();
        }
    }
}
