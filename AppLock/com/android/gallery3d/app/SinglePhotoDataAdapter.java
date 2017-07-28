package com.android.gallery3d.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.android.gallery3d.app.PhotoPage.Model;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.BitmapScreenNail;
import com.android.gallery3d.ui.PhotoView;
import com.android.gallery3d.ui.PhotoView.Size;
import com.android.gallery3d.ui.ScreenNail;
import com.android.gallery3d.ui.SynchronizedHandler;
import com.android.gallery3d.ui.TileImageViewAdapter;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import com.android.gallery3d.util.ThreadPool;

public class SinglePhotoDataAdapter extends TileImageViewAdapter implements Model {
    private static final int MSG_UPDATE_IMAGE = 1;
    private static final int SIZE_BACKUP = 1024;
    private static final String TAG = "SinglePhotoDataAdapter";
    private BitmapScreenNail mBitmapScreenNail;
    private Handler mHandler;
    private boolean mHasFullImage;
    private MediaItem mItem;
    private FutureListener<BitmapRegionDecoder> mLargeListener = new C05182();
    private int mLoadingState = 0;
    private PhotoView mPhotoView;
    private Future<?> mTask;
    private ThreadPool mThreadPool;
    private FutureListener<Bitmap> mThumbListener = new C05193();

    class C05182 implements FutureListener<BitmapRegionDecoder> {
        C05182() {
        }

        public void onFutureDone(Future<BitmapRegionDecoder> future) {
            BitmapRegionDecoder bitmapRegionDecoder = (BitmapRegionDecoder) future.get();
            if (bitmapRegionDecoder != null) {
                int width = bitmapRegionDecoder.getWidth();
                int height = bitmapRegionDecoder.getHeight();
                Options options = new Options();
                options.inSampleSize = BitmapUtils.computeSampleSize(1024.0f / ((float) Math.max(width, height)));
                SinglePhotoDataAdapter.this.mHandler.sendMessage(SinglePhotoDataAdapter.this.mHandler.obtainMessage(1, new ImageBundle(bitmapRegionDecoder, bitmapRegionDecoder.decodeRegion(new Rect(0, 0, width, height), options))));
            }
        }
    }

    class C05193 implements FutureListener<Bitmap> {
        C05193() {
        }

        public void onFutureDone(Future<Bitmap> future) {
            SinglePhotoDataAdapter.this.mHandler.sendMessage(SinglePhotoDataAdapter.this.mHandler.obtainMessage(1, future));
        }
    }

    private static class ImageBundle {
        public final Bitmap backupImage;
        public final BitmapRegionDecoder decoder;

        public ImageBundle(BitmapRegionDecoder bitmapRegionDecoder, Bitmap bitmap) {
            this.decoder = bitmapRegionDecoder;
            this.backupImage = bitmap;
        }
    }

    public SinglePhotoDataAdapter(AbstractGalleryActivity abstractGalleryActivity, PhotoView photoView, MediaItem mediaItem) {
        this.mItem = (MediaItem) Utils.checkNotNull(mediaItem);
        this.mHasFullImage = (mediaItem.getSupportedOperations() & 64) != 0;
        this.mPhotoView = (PhotoView) Utils.checkNotNull(photoView);
        this.mHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                boolean z = true;
                if (message.what != 1) {
                    z = false;
                }
                Utils.assertTrue(z);
                if (SinglePhotoDataAdapter.this.mHasFullImage) {
                    SinglePhotoDataAdapter.this.onDecodeLargeComplete((ImageBundle) message.obj);
                } else {
                    SinglePhotoDataAdapter.this.onDecodeThumbComplete((Future) message.obj);
                }
            }
        };
        this.mThreadPool = abstractGalleryActivity.getThreadPool();
    }

    private void onDecodeLargeComplete(ImageBundle imageBundle) {
        try {
            setScreenNail(imageBundle.backupImage, imageBundle.decoder.getWidth(), imageBundle.decoder.getHeight());
            setRegionDecoder(imageBundle.decoder);
            this.mPhotoView.notifyImageChange(0);
        } catch (Throwable th) {
            Log.m438w(TAG, "fail to decode large", th);
        }
    }

    private void onDecodeThumbComplete(Future<Bitmap> future) {
        try {
            Bitmap bitmap = (Bitmap) future.get();
            if (bitmap == null) {
                this.mLoadingState = 2;
                return;
            }
            this.mLoadingState = 1;
            setScreenNail(bitmap, bitmap.getWidth(), bitmap.getHeight());
            this.mPhotoView.notifyImageChange(0);
        } catch (Throwable th) {
            Log.m438w(TAG, "fail to decode thumb", th);
        }
    }

    private void setScreenNail(Bitmap bitmap, int i, int i2) {
        this.mBitmapScreenNail = new BitmapScreenNail(bitmap);
        setScreenNail(this.mBitmapScreenNail, i, i2);
    }

    public int getCurrentIndex() {
        return 0;
    }

    public int getImageRotation(int i) {
        return i == 0 ? this.mItem.getFullImageRotation() : 0;
    }

    public void getImageSize(int i, Size size) {
        if (i == 0) {
            size.width = this.mItem.getWidth();
            size.height = this.mItem.getHeight();
            return;
        }
        size.width = 0;
        size.height = 0;
    }

    public int getLoadingState(int i) {
        return this.mLoadingState;
    }

    public MediaItem getMediaItem(int i) {
        return i == 0 ? this.mItem : null;
    }

    public ScreenNail getScreenNail(int i) {
        return i == 0 ? getScreenNail() : null;
    }

    public boolean isCamera(int i) {
        return false;
    }

    public boolean isDeletable(int i) {
        return (this.mItem.getSupportedOperations() & 1) != 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isStaticCamera(int i) {
        return false;
    }

    public boolean isVideo(int i) {
        return this.mItem.getMediaType() == 4;
    }

    public void moveTo(int i) {
        throw new UnsupportedOperationException();
    }

    public void pause() {
        Future future = this.mTask;
        future.cancel();
        future.waitDone();
        if (future.get() == null) {
            this.mTask = null;
        }
        if (this.mBitmapScreenNail != null) {
            this.mBitmapScreenNail.recycle();
            this.mBitmapScreenNail = null;
        }
    }

    public void resume() {
        if (this.mTask != null) {
            return;
        }
        if (this.mHasFullImage) {
            this.mTask = this.mThreadPool.submit(this.mItem.requestLargeImage(), this.mLargeListener);
        } else {
            this.mTask = this.mThreadPool.submit(this.mItem.requestImage(1), this.mThumbListener);
        }
    }

    public void setCurrentPhoto(Path path, int i) {
    }

    public void setFocusHintDirection(int i) {
    }

    public void setFocusHintPath(Path path) {
    }

    public void setNeedFullImage(boolean z) {
    }
}
