package com.android.gallery3d.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.app.OrientationManager.Listener;
import com.android.gallery3d.app.PhotoDataAdapter.DataListener;
import com.android.gallery3d.data.HidedMediaItem;
import com.android.gallery3d.data.HidedMediaItem.OnActionDoneListener;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.GLView;
import com.android.gallery3d.ui.PhotoView;
import com.android.gallery3d.ui.SynchronizedHandler;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.frame.C0415f;
import com.domobile.frame.C1263b;
import com.domobile.frame.ui.C1279a;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;

public class PhotoPage extends ActivityState implements OnMenuItemClickListener, Listener, OnActionDoneListener, PhotoView.Listener {
    public static final String ACTION_NEXTGEN_EDIT = "action_nextgen_edit";
    private static final long CAMERA_SWITCH_CUTOFF_THRESHOLD_MS = 300;
    private static final long DEFERRED_UPDATE_MS = 250;
    private static final long FADE_DELAY_TIME = 3000;
    public static final String KEY_ALBUMPAGE_TRANSITION = "albumpage-transition";
    public static final String KEY_APP_BRIDGE = "app-bridge";
    public static final String KEY_INDEX_HINT = "index-hint";
    public static final String KEY_IN_CAMERA_ROLL = "in_camera_roll";
    public static final String KEY_MEDIA_ITEM_PATH = "media-item-path";
    public static final String KEY_MEDIA_SET_PATH = "media-set-path";
    public static final String KEY_OPEN_ANIMATION_RECT = "open-animation-rect";
    public static final String KEY_RETURN_INDEX_HINT = "return-index-hint";
    public static final String KEY_SHOW_WHEN_LOCKED = "show_when_locked";
    public static final String KEY_START_IN_FILMSTRIP = "start-in-filmstrip";
    public static final String KEY_TREAT_BACK_AS_UP = "treat-back-as-up";
    public static final int MSG_ALBUMPAGE_NONE = 0;
    public static final int MSG_ALBUMPAGE_PICKED = 4;
    public static final int MSG_ALBUMPAGE_RESUMED = 2;
    public static final int MSG_ALBUMPAGE_STARTED = 1;
    private static final int MSG_ON_CAMERA_CENTER = 9;
    private static final int MSG_ON_PICTURE_CENTER = 10;
    private static final int MSG_REFRESH_BOTTOM_CONTROLS = 8;
    private static final int MSG_REFRESH_IMAGE = 11;
    private static final int MSG_UNFREEZE_GLROOT = 6;
    private static final int MSG_UPDATE_DEFERRED = 14;
    private static final int MSG_UPDATE_PHOTO_UI = 12;
    private static final int REQUEST_CROP = 2;
    private static final int REQUEST_EDIT = 4;
    private static final int REQUEST_SLIDESHOW = 1;
    private static final String TAG = "PhotoPage";
    private static final int UNFREEZE_GLROOT_TIMEOUT = 250;
    private Handler aHandler = new Handler();
    private GalleryApp mApplication;
    private long mCameraSwitchCutoff = 0;
    private int mCurrentIndex = 0;
    private MediaItem mCurrentPhoto = null;
    private long mDeferUpdateUntil = Format.OFFSET_SAMPLE_RELATIVE;
    private boolean mDeferredUpdateWaiting = false;
    private boolean mDeleteIsFocus;
    private Path mDeletePath;
    private Runnable mFadeInRunnable = new C05168();
    private Runnable mFadeOutRunnable = new C05147();
    private Handler mHandler;
    private boolean mHasCameraScreennailOrPlaceholder = false;
    private boolean mHaveImageEditor;
    private boolean mIsActive;
    private MediaSet mMediaSet;
    private MenuInflater mMenuInflater;
    private Model mModel;
    private OrientationManager mOrientationManager;
    private String mOriginalSetPathString;
    private PhotoView mPhotoView;
    private final GLView mRootPane = new C05071();
    private String mSetPathString;
    private boolean mSkipUpdateCurrentPhoto = false;
    private boolean mStartInFilmstrip;
    private C1279a mToolbarMenus;

    public interface Model extends com.android.gallery3d.ui.PhotoView.Model {
        boolean isEmpty();

        void pause();

        void resume();

        void setCurrentPhoto(Path path, int i);
    }

    class C05071 extends GLView {
        C05071() {
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            PhotoPage.this.mPhotoView.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    class C05093 implements DataListener {
        C05093() {
        }

        public void onLoadingFinished(boolean z) {
            if (!PhotoPage.this.mModel.isEmpty()) {
                MediaItem mediaItem = PhotoPage.this.mModel.getMediaItem(0);
                if (mediaItem != null) {
                    PhotoPage.this.updateCurrentPhoto(mediaItem);
                }
            } else if (PhotoPage.this.mIsActive) {
                PhotoPage.this.mActivity.getStateManager().finishState(PhotoPage.this);
            }
        }

        public void onLoadingStarted() {
        }

        public void onPhotoChanged(int i, Path path) {
            int access$1100 = PhotoPage.this.mCurrentIndex;
            PhotoPage.this.mCurrentIndex = i;
            if (PhotoPage.this.mHasCameraScreennailOrPlaceholder) {
                if (PhotoPage.this.mCurrentIndex > 0) {
                    PhotoPage.this.mSkipUpdateCurrentPhoto = false;
                }
                if (access$1100 == 0 && PhotoPage.this.mCurrentIndex > 0 && !PhotoPage.this.mPhotoView.getFilmMode()) {
                    PhotoPage.this.mPhotoView.setFilmMode(true);
                } else if (access$1100 == 2 && PhotoPage.this.mCurrentIndex == 1) {
                    PhotoPage.this.mCameraSwitchCutoff = SystemClock.uptimeMillis() + PhotoPage.CAMERA_SWITCH_CUTOFF_THRESHOLD_MS;
                    PhotoPage.this.mPhotoView.stopScrolling();
                } else if (access$1100 >= 1 && PhotoPage.this.mCurrentIndex == 0) {
                    PhotoPage.this.mPhotoView.setWantPictureCenterCallbacks(true);
                    PhotoPage.this.mSkipUpdateCurrentPhoto = true;
                }
            }
            if (!PhotoPage.this.mSkipUpdateCurrentPhoto && path != null) {
                MediaItem mediaItem = PhotoPage.this.mModel.getMediaItem(0);
                if (mediaItem != null) {
                    PhotoPage.this.updateCurrentPhoto(mediaItem);
                }
            }
        }
    }

    class C05104 implements OnClickListener {
        C05104() {
        }

        public void onClick(View view) {
            PhotoPage.this.mHandler.removeCallbacks(PhotoPage.this.mFadeOutRunnable);
        }
    }

    class C05115 extends Thread {
        C05115() {
        }

        public void run() {
            if (PhotoPage.this.mCurrentPhoto != null && (PhotoPage.this.mCurrentPhoto instanceof HidedMediaItem)) {
                try {
                    PhotoPage.this.mActivity.showCancelableLoadingDialog();
                    ((HidedMediaItem) PhotoPage.this.mCurrentPhoto).shareHidedMedia(PhotoPage.this.mActivity);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    PhotoPage.this.mActivity.hideLoadingDialog();
                }
            }
        }
    }

    class C05126 implements Runnable {
        C05126() {
        }

        public void run() {
            PhotoPage.this.broadcastAlbumChanged();
            PhotoPage.this.mMediaSet.setDataDirtyNow();
            PhotoPage.this.mMediaSet.notifyContentChanged();
            if (PhotoPage.this.mCurrentIndex > 0) {
                PhotoPage.this.mPhotoView.switchToImage(PhotoPage.this.mCurrentIndex - 1);
            } else if (PhotoPage.this.mMediaSet.getMediaItemCount() == 0) {
                PhotoPage.this.mActivity.setResult(-1);
                PhotoPage.this.mActivity.finish();
            }
        }
    }

    class C05147 implements Runnable {
        C05147() {
        }

        public void run() {
            final C1263b doMoActionBar = PhotoPage.this.mActivity.getDoMoActionBar();
            Animation loadAnimation = AnimationUtils.loadAnimation(PhotoPage.this.mActivity, 17432577);
            loadAnimation.setAnimationListener(new C0415f() {
                public void onAnimationEnd(Animation animation) {
                    PhotoPage.this.mActivity.mToolbar.setVisibility(8);
                    doMoActionBar.m3008c(false);
                }
            });
            PhotoPage.this.mActivity.mToolbar.startAnimation(loadAnimation);
            doMoActionBar.m3013f().startAnimation(loadAnimation);
        }
    }

    class C05168 implements Runnable {
        C05168() {
        }

        public void run() {
            final C1263b doMoActionBar = PhotoPage.this.mActivity.getDoMoActionBar();
            Animation loadAnimation = AnimationUtils.loadAnimation(PhotoPage.this.mActivity, 17432576);
            loadAnimation.setAnimationListener(new C0415f() {
                public void onAnimationStart(Animation animation) {
                    PhotoPage.this.mActivity.mToolbar.setVisibility(0);
                    doMoActionBar.m3008c(true);
                }
            });
            PhotoPage.this.mActivity.mToolbar.startAnimation(loadAnimation);
            doMoActionBar.m3013f().startAnimation(loadAnimation);
        }
    }

    private void broadcastAlbumChanged() {
        if (this.mCurrentIndex < 3) {
            ArrayList mediaItem = this.mMediaSet.getMediaItem(0, 4);
            int size = mediaItem.size();
            String str = "";
            int i = 0;
            while (i < 3 && i < size) {
                str = str + (TextUtils.isEmpty(str) ? "" : ",") + ((HidedMediaItem) mediaItem.get(i)).getMediaID();
                i++;
            }
            ((HidedMediaItem) this.mCurrentPhoto).broadcastAlbumThumbChanged(this.mActivity, str);
        }
    }

    private void fadeInOrOutTitleBarAndToolBar() {
        this.mHandler.removeCallbacks(this.mFadeInRunnable);
        this.mHandler.removeCallbacks(this.mFadeOutRunnable);
        if (this.mActivity.getDoMoActionBar().m3013f().isShown()) {
            this.aHandler.post(this.mFadeOutRunnable);
        } else {
            this.aHandler.post(this.mFadeInRunnable);
        }
    }

    private void fadeOutTitleBarAndToolBar(long j) {
        this.mHandler.removeCallbacks(this.mFadeOutRunnable);
        this.mHandler.postDelayed(this.mFadeOutRunnable, j);
    }

    private void forceRefreshPhotoView() {
        this.mActivity.getGLRoot().unfreeze();
        this.mHandler.removeMessages(6);
        if (this.mModel != null) {
            this.mModel.pause();
        }
        this.mPhotoView.pause();
        this.mActivity.getGLRoot().freeze();
        this.mIsActive = true;
        setContentPane(this.mRootPane);
        this.mModel.resume();
        this.mPhotoView.resume();
        this.mHandler.sendEmptyMessageDelayed(6, DEFERRED_UPDATE_MS);
    }

    private void launchCamera() {
    }

    private void requestDeferredUpdate() {
        this.mDeferUpdateUntil = SystemClock.uptimeMillis() + DEFERRED_UPDATE_MS;
        if (!this.mDeferredUpdateWaiting) {
            this.mDeferredUpdateWaiting = true;
            this.mHandler.sendEmptyMessageDelayed(14, DEFERRED_UPDATE_MS);
        }
    }

    private void revertCurrentHidedMedia() {
        if (this.mCurrentPhoto != null && (this.mCurrentPhoto instanceof HidedMediaItem)) {
            HidedMediaItem hidedMediaItem = (HidedMediaItem) this.mCurrentPhoto;
            hidedMediaItem.setOnActionDoneListener(this);
            hidedMediaItem.revertHidedMediaConfirm(this.mActivity);
        }
    }

    private void setCurrentPhotoByIntent(Intent intent) {
        if (intent != null) {
            Path findPathByUri = this.mApplication.getDataManager().findPathByUri(intent.getData(), intent.getType());
            if (findPathByUri != null) {
                Path defaultSetOf = this.mApplication.getDataManager().getDefaultSetOf(findPathByUri);
                if (defaultSetOf.equalsIgnoreCase(this.mOriginalSetPathString)) {
                    this.mModel.setCurrentPhoto(findPathByUri, this.mCurrentIndex);
                    return;
                }
                Bundle bundle = new Bundle(getData());
                bundle.putString("media-set-path", defaultSetOf.toString());
                bundle.putString("media-item-path", findPathByUri.toString());
                this.mActivity.getStateManager().startState(PhotoPage.class, bundle);
            }
        }
    }

    private void shareCurrentHidedMedia() {
        new C05115().start();
    }

    private void transitionFromAlbumPageIfNeeded() {
        TransitionStore transitionStore = this.mActivity.getTransitionStore();
        int intValue = ((Integer) transitionStore.get(KEY_ALBUMPAGE_TRANSITION, Integer.valueOf(0))).intValue();
        int intValue2 = ((Integer) transitionStore.get(KEY_INDEX_HINT, Integer.valueOf(-1))).intValue();
        if (intValue2 >= 0) {
            if (this.mHasCameraScreennailOrPlaceholder) {
                intValue2++;
            }
            if (intValue2 < this.mMediaSet.getMediaItemCount()) {
                this.mCurrentIndex = intValue2;
                this.mModel.moveTo(this.mCurrentIndex);
            }
        }
        if (intValue == 2) {
            this.mPhotoView.setFilmMode(this.mStartInFilmstrip);
        } else if (intValue == 4) {
            this.mPhotoView.setFilmMode(false);
        }
    }

    private void updateCurrentPhoto(MediaItem mediaItem) {
        if (this.mCurrentPhoto != mediaItem) {
            this.mCurrentPhoto = mediaItem;
            if (this.mPhotoView.getFilmMode()) {
                requestDeferredUpdate();
            } else {
                updateUIForCurrentPhoto();
            }
        }
    }

    private void updateUIForCurrentPhoto() {
        if (this.mCurrentPhoto != null) {
            if (!((this.mCurrentPhoto.getSupportedOperations() & 32768) == 0 || this.mPhotoView.getFilmMode())) {
                this.mPhotoView.setWantPictureCenterCallbacks(true);
            }
            this.mActivity.getToolbar().setTitle(this.mCurrentPhoto.getName());
            refreshBottomControlsWhenReady();
        }
    }

    public void deleteHidedMediaDone(boolean z) {
        if (z) {
            this.aHandler.post(new C05126());
        }
    }

    protected int getBackgroundColorId() {
        return C0488R.color.photo_background;
    }

    protected void onBackPressed() {
        this.mActivity.finish();
    }

    public void onCommitDeleteImage() {
        if (this.mDeletePath != null) {
            this.mDeletePath = null;
        }
    }

    public void onCreate(Bundle bundle, Bundle bundle2) {
        boolean z = false;
        super.onCreate(bundle, bundle2);
        this.mPhotoView = new PhotoView(this.mActivity);
        this.mPhotoView.setListener(this);
        this.mRootPane.addComponent(this.mPhotoView);
        this.mMenuInflater = new MenuInflater(this.mActivity);
        this.mApplication = (GalleryApp) this.mActivity.getApplication();
        this.mOrientationManager = this.mActivity.getOrientationManager();
        this.mOrientationManager.addListener(this);
        this.mActivity.getGLRoot().setOrientationSource(this.mOrientationManager);
        this.mHandler = new SynchronizedHandler(this.mActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                boolean z = false;
                switch (message.what) {
                    case 6:
                        PhotoPage.this.mActivity.getGLRoot().unfreeze();
                        return;
                    case 8:
                        return;
                    case 9:
                        PhotoPage.this.mSkipUpdateCurrentPhoto = false;
                        if (!PhotoPage.this.mPhotoView.getFilmMode()) {
                            z = true;
                        } else if (SystemClock.uptimeMillis() >= PhotoPage.this.mCameraSwitchCutoff || PhotoPage.this.mMediaSet.getMediaItemCount() <= 1) {
                            z = true;
                        } else {
                            PhotoPage.this.mPhotoView.switchToImage(1);
                        }
                        if (z) {
                            PhotoPage.this.launchCamera();
                            PhotoPage.this.mPhotoView.switchToImage(1);
                            return;
                        }
                        return;
                    case 10:
                        if (!PhotoPage.this.mPhotoView.getFilmMode() && PhotoPage.this.mCurrentPhoto != null && (PhotoPage.this.mCurrentPhoto.getSupportedOperations() & 32768) != 0) {
                            PhotoPage.this.mPhotoView.setFilmMode(true);
                            return;
                        }
                        return;
                    case 11:
                        MediaItem access$900 = PhotoPage.this.mCurrentPhoto;
                        PhotoPage.this.mCurrentPhoto = null;
                        PhotoPage.this.updateCurrentPhoto(access$900);
                        return;
                    case 12:
                        PhotoPage.this.updateUIForCurrentPhoto();
                        return;
                    case 14:
                        long access$100 = PhotoPage.this.mDeferUpdateUntil - SystemClock.uptimeMillis();
                        if (access$100 <= 0) {
                            PhotoPage.this.mDeferredUpdateWaiting = false;
                            PhotoPage.this.updateUIForCurrentPhoto();
                            return;
                        }
                        PhotoPage.this.mHandler.sendEmptyMessageDelayed(14, access$100);
                        return;
                    default:
                        throw new AssertionError(message.what);
                }
            }
        };
        this.mSetPathString = bundle.getString("media-set-path");
        this.mOriginalSetPathString = this.mSetPathString;
        Path fromString = bundle.getString("media-item-path") != null ? Path.fromString(bundle.getString("media-item-path")) : null;
        this.mStartInFilmstrip = bundle.getBoolean(KEY_START_IN_FILMSTRIP, false);
        this.mCurrentIndex = bundle.getInt(KEY_INDEX_HINT, 0);
        if (this.mSetPathString != null) {
            Path path;
            this.mMediaSet = this.mActivity.getDataManager().getMediaSet(this.mSetPathString);
            if (this.mMediaSet == null) {
                Log.m437w(TAG, "failed to restore " + this.mSetPathString);
            }
            if (fromString == null) {
                int mediaItemCount = this.mMediaSet.getMediaItemCount();
                if (mediaItemCount > 0) {
                    if (this.mCurrentIndex >= mediaItemCount) {
                        this.mCurrentIndex = 0;
                    }
                    path = ((MediaItem) this.mMediaSet.getMediaItem(this.mCurrentIndex, 1).get(0)).getPath();
                } else {
                    return;
                }
            }
            path = fromString;
            Object photoDataAdapter = new PhotoDataAdapter(this.mActivity, this.mPhotoView, this.mMediaSet, path, this.mCurrentIndex, -1, false);
            this.mModel = photoDataAdapter;
            this.mPhotoView.setModel(this.mModel);
            photoDataAdapter.setDataListener(new C05093());
        } else {
            MediaItem mediaItem = (MediaItem) this.mActivity.getDataManager().getMediaObject(fromString);
            this.mModel = new SinglePhotoDataAdapter(this.mActivity, this.mPhotoView, mediaItem);
            this.mPhotoView.setModel(this.mModel);
            updateCurrentPhoto(mediaItem);
        }
        PhotoView photoView = this.mPhotoView;
        if (this.mStartInFilmstrip && this.mMediaSet.getMediaItemCount() > 1) {
            z = true;
        }
        photoView.setFilmMode(z);
        fadeOutTitleBarAndToolBar(FADE_DELAY_TIME);
    }

    public void onCurrentImageUpdated() {
        this.mActivity.getGLRoot().unfreeze();
    }

    public void onDeleteImage(Path path, int i) {
        onCommitDeleteImage();
        this.mDeletePath = path;
        this.mDeleteIsFocus = i == 0;
    }

    protected void onDestroy() {
        this.mOrientationManager.removeListener(this);
        this.mActivity.getGLRoot().setOrientationSource(null);
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public void onFilmModeChanged(boolean z) {
        refreshBottomControlsWhenReady();
    }

    public void onFullScreenChanged(boolean z) {
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.mCurrentPhoto != null || (this.mCurrentPhoto instanceof HidedMediaItem)) {
            int itemId = menuItem.getItemId();
            if (itemId == C0488R.id.gallery_toolbar_menu_detail) {
                ((HidedMediaItem) this.mCurrentPhoto).showHidedMediaDetail(this.mActivity);
            } else if (itemId == C0488R.id.gallery_toolbar_menu_revert) {
                this.mHandler.removeCallbacks(this.mFadeOutRunnable);
                revertCurrentHidedMedia();
            } else if (itemId == C0488R.id.gallery_toolbar_menu_rotate_left) {
                this.mCurrentPhoto.rotate(this.mActivity, -90);
                forceRefreshPhotoView();
            } else if (itemId == C0488R.id.gallery_toolbar_menu_rotate_right) {
                this.mCurrentPhoto.rotate(this.mActivity, 90);
                forceRefreshPhotoView();
            } else if (itemId == C0488R.id.gallery_toolbar_menu_share) {
                this.mHandler.removeCallbacks(this.mFadeOutRunnable);
                shareCurrentHidedMedia();
            } else if (itemId == C0488R.id.gallery_toolbar_menu_delete) {
                this.mHandler.removeCallbacks(this.mFadeOutRunnable);
                ((HidedMediaItem) this.mCurrentPhoto).setOnActionDoneListener(this);
                ((HidedMediaItem) this.mCurrentPhoto).deleteHidedMedia(this.mActivity);
            }
        }
        return false;
    }

    public void onOrientationCompensationChanged() {
        this.mActivity.getGLRoot().requestLayoutContentPane();
    }

    public void onPause() {
        super.onPause();
        this.mIsActive = false;
        this.mActivity.getGLRoot().unfreeze();
        this.mHandler.removeMessages(6);
        if (this.mModel != null) {
            this.mModel.pause();
        }
        this.mPhotoView.pause();
        this.mHandler.removeMessages(8);
        refreshBottomControlsWhenReady();
        onCommitDeleteImage();
    }

    public void onPictureCenter(boolean z) {
        boolean z2 = z || this.mHasCameraScreennailOrPlaceholder;
        this.mPhotoView.setWantPictureCenterCallbacks(false);
        this.mHandler.removeMessages(9);
        this.mHandler.removeMessages(10);
        this.mHandler.sendEmptyMessage(z2 ? 9 : 10);
    }

    protected void onResume() {
        super.onResume();
        if (this.mModel == null) {
            this.mActivity.getStateManager().finishState(this);
            return;
        }
        transitionFromAlbumPageIfNeeded();
        this.mActivity.getGLRoot().freeze();
        this.mIsActive = true;
        setContentPane(this.mRootPane);
        this.mModel.resume();
        this.mPhotoView.resume();
        refreshBottomControlsWhenReady();
        boolean isEditorAvailable = GalleryUtils.isEditorAvailable(this.mActivity, GalleryUtils.MIME_TYPE_IMAGE);
        if (isEditorAvailable != this.mHaveImageEditor) {
            this.mHaveImageEditor = isEditorAvailable;
        }
        this.mHandler.sendEmptyMessageDelayed(6, DEFERRED_UPDATE_MS);
        this.mActivity.getDoMoActionBar().m3008c(true);
        if (this.mToolbarMenus == null) {
            this.mToolbarMenus = new C1279a(this.mActivity);
            this.mMenuInflater.inflate(C0488R.menu.gallery_toolbar_menus, this.mToolbarMenus);
            this.mActivity.getDoMoActionBar().m2998a(new C05104());
        }
        this.mActivity.getDoMoActionBar().m3005b(this.mToolbarMenus, C0488R.drawable.badge_overlay_more_dark, this);
    }

    public void onSingleTapUp(int i, int i2) {
        int i3 = 0;
        MediaItem mediaItem = this.mModel.getMediaItem(0);
        if (mediaItem != null) {
            int supportedOperations = mediaItem.getSupportedOperations();
            boolean z = (supportedOperations & 8192) != 0;
            boolean z2 = (supportedOperations & 16384) != 0;
            if ((supportedOperations & 65536) != 0) {
                i3 = 1;
            }
            fadeInOrOutTitleBarAndToolBar();
            if (z2) {
                onBackPressed();
            } else if (z) {
                Intent intent = new Intent(this.mActivity, Gallery.class);
                intent.putExtra(Gallery.KEY_DISMISS_KEYGUARD, true);
                this.mActivity.startActivity(intent);
            } else if (i3 != 0) {
                launchCamera();
            }
        }
    }

    protected void onStateResult(int i, int i2, Intent intent) {
        if (i2 != 0) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("media-item-path");
                        int intExtra = intent.getIntExtra(SlideshowPage.KEY_PHOTO_INDEX, 0);
                        if (stringExtra != null) {
                            this.mModel.setCurrentPhoto(Path.fromString(stringExtra), intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == -1) {
                        setCurrentPhotoByIntent(intent);
                        return;
                    }
                    return;
                case 4:
                    setCurrentPhotoByIntent(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public void onUndoBarVisibilityChanged(boolean z) {
        refreshBottomControlsWhenReady();
    }

    public void onUndoDeleteImage() {
        if (this.mDeletePath != null) {
            if (this.mDeleteIsFocus) {
                this.mModel.setFocusHintPath(this.mDeletePath);
            }
            this.mDeletePath = null;
        }
    }

    public void refreshBottomControlsWhenReady() {
        MediaItem mediaItem = this.mCurrentPhoto;
        if (mediaItem == null) {
            this.mHandler.obtainMessage(8, 0, 0, mediaItem).sendToTarget();
        }
    }

    public void revertHidedMediaDone(boolean z) {
        deleteHidedMediaDone(z);
    }
}
