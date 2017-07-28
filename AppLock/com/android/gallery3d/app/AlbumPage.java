package com.android.gallery3d.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.widget.Toast;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.MediaSet.SyncListener;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.AlbumSlotRenderer;
import com.android.gallery3d.ui.GLCanvas;
import com.android.gallery3d.ui.GLRoot;
import com.android.gallery3d.ui.GLView;
import com.android.gallery3d.ui.PhotoFallbackEffect;
import com.android.gallery3d.ui.PhotoFallbackEffect.PositionProvider;
import com.android.gallery3d.ui.RelativePosition;
import com.android.gallery3d.ui.SelectionManager;
import com.android.gallery3d.ui.SelectionManager.SelectionListener;
import com.android.gallery3d.ui.SlotView;
import com.android.gallery3d.ui.SlotView.SimpleListener;
import com.android.gallery3d.ui.SynchronizedHandler;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.GalleryUtils;

public class AlbumPage extends ActivityState implements SyncListener, SelectionListener {
    private static final int BIT_LOADING_RELOAD = 1;
    private static final int BIT_LOADING_SYNC = 2;
    public static final String KEY_AUTO_SELECT_ALL = "auto-select-all";
    public static final String KEY_EMPTY_ALBUM = "empty-album";
    public static final String KEY_MEDIA_PATH = "media-path";
    public static final String KEY_PARENT_MEDIA_PATH = "parent-media-path";
    public static final String KEY_RESUME_ANIMATION = "resume_animation";
    public static final String KEY_SET_CENTER = "set-center";
    public static final String KEY_SHOW_CLUSTER_MENU = "cluster-menu";
    private static final int MSG_PICK_PHOTO = 0;
    private static final int REQUEST_DO_ANIMATION = 3;
    public static final int REQUEST_PHOTO = 2;
    private static final int REQUEST_SLIDESHOW = 1;
    private static final String TAG = "AlbumPage";
    private static final float USER_DISTANCE_METER = 0.3f;
    private AlbumDataLoader mAlbumDataAdapter;
    private AlbumSlotRenderer mAlbumView;
    private int mFocusIndex = 0;
    private boolean mGetContent;
    private Handler mHandler;
    private boolean mInCameraApp;
    private boolean mInitialSynced = false;
    private boolean mIsActive = false;
    private boolean mLaunchedFromPhotoPage;
    private int mLoadingBits = 0;
    private boolean mLoadingFailed;
    private MediaSet mMediaSet;
    private Path mMediaSetPath;
    private RelativePosition mOpenCenter = new RelativePosition();
    private String mParentMediaSetString;
    private PositionProvider mPositionProvider = new C04941();
    private PhotoFallbackEffect mResumeEffect;
    private final GLView mRootPane = new C04952();
    protected SelectionManager mSelectionManager;
    private boolean mShowDetails;
    private SlotView mSlotView;
    private int mSyncResult;
    private Future<Integer> mSyncTask = null;
    private float mUserDistance;
    private Vibrator mVibrator;

    class C04941 implements PositionProvider {
        C04941() {
        }

        public int getItemIndex(Path path) {
            int visibleEnd = AlbumPage.this.mSlotView.getVisibleEnd();
            for (int visibleStart = AlbumPage.this.mSlotView.getVisibleStart(); visibleStart < visibleEnd; visibleStart++) {
                MediaItem mediaItem = AlbumPage.this.mAlbumDataAdapter.get(visibleStart);
                if (mediaItem != null && mediaItem.getPath() == path) {
                    return visibleStart;
                }
            }
            return -1;
        }

        public Rect getPosition(int i) {
            Rect slotRect = AlbumPage.this.mSlotView.getSlotRect(i);
            Rect bounds = AlbumPage.this.mSlotView.bounds();
            slotRect.offset(bounds.left - AlbumPage.this.mSlotView.getScrollX(), bounds.top - AlbumPage.this.mSlotView.getScrollY());
            return slotRect;
        }
    }

    class C04952 extends GLView {
        private final float[] mMatrix = new float[16];

        C04952() {
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i4 - i2;
            int i6 = i3 - i;
            AlbumPage.this.mAlbumView.setHighlightItemPath(null);
            AlbumPage.this.mOpenCenter.setReferencePosition(0, 0);
            AlbumPage.this.mSlotView.layout(0, 0, i6, i5);
            GalleryUtils.setViewPointMatrix(this.mMatrix, (float) ((i3 - i) / 2), (float) ((i4 - i2) / 2), -AlbumPage.this.mUserDistance);
        }

        protected void render(GLCanvas gLCanvas) {
            gLCanvas.save(2);
            gLCanvas.multiplyMatrix(this.mMatrix, 0);
            super.render(gLCanvas);
            if (AlbumPage.this.mResumeEffect != null) {
                if (!AlbumPage.this.mResumeEffect.draw(gLCanvas)) {
                    AlbumPage.this.mResumeEffect = null;
                    AlbumPage.this.mAlbumView.setSlotFilter(null);
                }
                invalidate();
            }
            gLCanvas.restore();
        }
    }

    class C04974 extends SimpleListener {
        C04974() {
        }

        public void onDown(int i) {
            AlbumPage.this.onDown(i);
        }

        public void onLongTap(int i) {
            AlbumPage.this.onLongTap(i);
        }

        public void onSingleTapUp(int i) {
            AlbumPage.this.onSingleTapUp(i);
        }

        public void onUp(boolean z) {
            AlbumPage.this.onUp(z);
        }
    }

    private class MyLoadingListener implements LoadingListener {
        private MyLoadingListener() {
        }

        public void onLoadingFinished(boolean z) {
            AlbumPage.this.clearLoadingBit(1);
            AlbumPage.this.mLoadingFailed = z;
            AlbumPage.this.showSyncErrorIfNecessary(z);
        }

        public void onLoadingStarted() {
            AlbumPage.this.setLoadingBit(1);
            AlbumPage.this.mLoadingFailed = false;
        }
    }

    private void clearLoadingBit(int i) {
        this.mLoadingBits &= i ^ -1;
        if (this.mLoadingBits == 0 && this.mIsActive && this.mAlbumDataAdapter.size() == 0) {
            Intent intent = new Intent();
            intent.putExtra(KEY_EMPTY_ALBUM, true);
            setStateResult(-1, intent);
            this.mActivity.getStateManager().finishState(this);
        }
    }

    private void hideDetails() {
        this.mShowDetails = false;
        this.mAlbumView.setHighlightItemPath(null);
        this.mSlotView.invalidate();
    }

    private void initializeData(Bundle bundle) {
        this.mMediaSetPath = Path.fromString(bundle.getString("media-path"));
        this.mParentMediaSetString = bundle.getString(KEY_PARENT_MEDIA_PATH);
        this.mMediaSet = this.mActivity.getDataManager().getMediaSet(this.mMediaSetPath);
        if (this.mMediaSet == null) {
            Utils.fail("MediaSet is null. Path = %s", this.mMediaSetPath);
        }
        this.mSelectionManager.setSourceMediaSet(this.mMediaSet);
        this.mAlbumDataAdapter = new AlbumDataLoader(this.mActivity, this.mMediaSet);
        this.mAlbumDataAdapter.setLoadingListener(new MyLoadingListener());
        this.mAlbumView.setModel(this.mAlbumDataAdapter);
    }

    private void initializeViews() {
        this.mSelectionManager = new SelectionManager(this.mActivity, false);
        this.mSelectionManager.setSelectionListener(this);
        com.android.gallery3d.app.Config.AlbumPage albumPage = com.android.gallery3d.app.Config.AlbumPage.get(this.mActivity);
        this.mSlotView = new SlotView(this.mActivity, albumPage.slotViewSpec);
        this.mAlbumView = new AlbumSlotRenderer(this.mActivity, this.mSlotView, this.mSelectionManager, albumPage.placeholderColor);
        this.mSlotView.setSlotRenderer(this.mAlbumView);
        this.mRootPane.addComponent(this.mSlotView);
        this.mSlotView.setListener(new C04974());
    }

    private void onDown(int i) {
        this.mAlbumView.setPressedIndex(i);
    }

    private void onGetContent(MediaItem mediaItem) {
        this.mActivity.getDataManager();
        Activity activity = this.mActivity;
        if (this.mData.getString(Gallery.EXTRA_CROP) == null) {
            activity.setResult(-1, new Intent(null, mediaItem.getContentUri()).addFlags(1));
            activity.finish();
        }
    }

    private void onSingleTapUp(int i) {
        if (!this.mIsActive) {
            return;
        }
        if (this.mSelectionManager.inSelectionMode()) {
            MediaItem mediaItem = this.mAlbumDataAdapter.get(i);
            if (mediaItem != null) {
                this.mSelectionManager.toggle(mediaItem.getPath());
                this.mSlotView.invalidate();
                return;
            }
            return;
        }
        this.mAlbumView.setPressedIndex(i);
        this.mAlbumView.setPressedUp();
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, i, 0), 180);
    }

    private void onUp(boolean z) {
        if (z) {
            this.mAlbumView.setPressedIndex(-1);
        } else {
            this.mAlbumView.setPressedUp();
        }
    }

    private void onUpPressed() {
        if (this.mInCameraApp) {
            GalleryUtils.startGalleryActivity(this.mActivity);
        } else if (this.mActivity.getStateManager().getStateCount() > 1) {
            super.onBackPressed();
        } else if (this.mParentMediaSetString != null) {
            Bundle bundle = new Bundle(getData());
            bundle.putString("media-path", this.mParentMediaSetString);
            this.mActivity.getStateManager().switchState(this, AlbumSetPage.class, bundle);
        }
    }

    private void pickPhoto(int i) {
        pickPhoto(i, false);
    }

    private void pickPhoto(int i, boolean z) {
        if (this.mIsActive) {
            MediaItem mediaItem = this.mAlbumDataAdapter.get(i);
            if (mediaItem == null) {
                return;
            }
            if (this.mGetContent) {
                onGetContent(mediaItem);
            } else if (this.mLaunchedFromPhotoPage) {
                TransitionStore transitionStore = this.mActivity.getTransitionStore();
                transitionStore.put(PhotoPage.KEY_ALBUMPAGE_TRANSITION, Integer.valueOf(4));
                transitionStore.put(PhotoPage.KEY_INDEX_HINT, Integer.valueOf(i));
                onBackPressed();
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt(PhotoPage.KEY_INDEX_HINT, i);
                bundle.putParcelable(PhotoPage.KEY_OPEN_ANIMATION_RECT, this.mSlotView.getSlotRect(i, this.mRootPane));
                bundle.putString("media-set-path", this.mMediaSetPath.toString());
                bundle.putString("media-item-path", mediaItem.getPath().toString());
                bundle.putInt(PhotoPage.KEY_ALBUMPAGE_TRANSITION, 1);
                bundle.putBoolean(PhotoPage.KEY_START_IN_FILMSTRIP, z);
                bundle.putBoolean(PhotoPage.KEY_IN_CAMERA_ROLL, this.mMediaSet.isCameraRoll());
                if (z) {
                    this.mActivity.getStateManager().switchState(this, PhotoPage.class, bundle);
                } else {
                    this.mActivity.getStateManager().startStateForResult(PhotoPage.class, 2, bundle);
                }
            }
        }
    }

    private void setLoadingBit(int i) {
        this.mLoadingBits |= i;
    }

    private void showSyncErrorIfNecessary(boolean z) {
        if (this.mLoadingBits != 0 || this.mSyncResult != 2 || !this.mIsActive) {
            return;
        }
        if (z || this.mAlbumDataAdapter.size() == 0) {
            Toast.makeText(this.mActivity, C0488R.string.sync_album_error, 1).show();
        }
    }

    protected int getBackgroundColorId() {
        return C0488R.color.album_background;
    }

    protected void onBackPressed() {
        if (this.mShowDetails) {
            hideDetails();
        } else if (this.mSelectionManager.inSelectionMode()) {
            this.mSelectionManager.leaveSelectionMode();
        } else {
            if (this.mLaunchedFromPhotoPage) {
                this.mActivity.getTransitionStore().putIfNotPresent(PhotoPage.KEY_ALBUMPAGE_TRANSITION, Integer.valueOf(2));
            }
            if (this.mInCameraApp) {
                super.onBackPressed();
            } else {
                onUpPressed();
            }
        }
    }

    protected void onCreate(Bundle bundle, Bundle bundle2) {
        super.onCreate(bundle, bundle2);
        this.mUserDistance = (float) GalleryUtils.meterToPixel(USER_DISTANCE_METER);
        initializeViews();
        initializeData(bundle);
        this.mGetContent = bundle.getBoolean(Gallery.KEY_GET_CONTENT, false);
        this.mVibrator = (Vibrator) this.mActivity.getAndroidContext().getSystemService("vibrator");
        if (bundle.getBoolean(KEY_AUTO_SELECT_ALL)) {
            this.mSelectionManager.selectAll();
        }
        this.mLaunchedFromPhotoPage = this.mActivity.getStateManager().hasStateClass(PhotoPage.class);
        this.mInCameraApp = bundle.getBoolean(PhotoPage.KEY_APP_BRIDGE, false);
        this.mHandler = new SynchronizedHandler(this.mActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        AlbumPage.this.pickPhoto(message.arg1);
                        return;
                    default:
                        throw new AssertionError(message.what);
                }
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mAlbumDataAdapter != null) {
            this.mAlbumDataAdapter.setLoadingListener(null);
        }
    }

    public void onLongTap(int i) {
        if (!this.mGetContent) {
            MediaItem mediaItem = this.mAlbumDataAdapter.get(i);
            if (mediaItem != null) {
                this.mSelectionManager.setAutoLeaveSelectionMode(true);
                this.mSelectionManager.toggle(mediaItem.getPath());
                this.mSlotView.invalidate();
            }
        }
    }

    protected void onPause() {
        super.onPause();
        this.mIsActive = false;
        if (this.mSelectionManager.inSelectionMode()) {
            this.mSelectionManager.leaveSelectionMode();
        }
        this.mAlbumView.setSlotFilter(null);
        this.mAlbumDataAdapter.pause();
        this.mAlbumView.pause();
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
            this.mSyncTask = null;
            clearLoadingBit(2);
        }
    }

    protected void onResume() {
        super.onResume();
        this.mIsActive = true;
        this.mResumeEffect = (PhotoFallbackEffect) this.mActivity.getTransitionStore().get(KEY_RESUME_ANIMATION);
        if (this.mResumeEffect != null) {
            this.mAlbumView.setSlotFilter(this.mResumeEffect);
            this.mResumeEffect.setPositionProvider(this.mPositionProvider);
            this.mResumeEffect.start();
        }
        setContentPane(this.mRootPane);
        setLoadingBit(1);
        this.mLoadingFailed = false;
        this.mAlbumDataAdapter.resume();
        this.mAlbumView.resume();
        this.mAlbumView.setPressedIndex(-1);
        if (!this.mInitialSynced) {
            setLoadingBit(2);
            this.mSyncTask = this.mMediaSet.requestSync(this);
        }
    }

    public void onSelectionChange(Path path, boolean z) {
    }

    public void onSelectionModeChange(int i) {
        switch (i) {
            case 1:
                if (this.mHapticsEnabled) {
                    this.mVibrator.vibrate(100);
                    return;
                }
                return;
            case 2:
                this.mRootPane.invalidate();
                return;
            case 3:
                this.mRootPane.invalidate();
                return;
            default:
                return;
        }
    }

    protected void onStateResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (intent != null) {
                    this.mFocusIndex = intent.getIntExtra(SlideshowPage.KEY_PHOTO_INDEX, 0);
                    this.mSlotView.setCenterIndex(this.mFocusIndex);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    this.mFocusIndex = intent.getIntExtra(PhotoPage.KEY_RETURN_INDEX_HINT, 0);
                    this.mSlotView.makeSlotVisible(this.mFocusIndex);
                    return;
                }
                return;
            case 3:
                this.mSlotView.startRisingAnimation();
                return;
            default:
                return;
        }
    }

    public void onSyncDone(MediaSet mediaSet, final int i) {
        Log.m429d(TAG, "onSyncDone: " + Utils.maskDebugInfo(mediaSet.getName()) + " result=" + i);
        this.mActivity.runOnUiThread(new Runnable() {
            public void run() {
                GLRoot gLRoot = AlbumPage.this.mActivity.getGLRoot();
                gLRoot.lockRenderThread();
                AlbumPage.this.mSyncResult = i;
                try {
                    if (i == 0) {
                        AlbumPage.this.mInitialSynced = true;
                    }
                    AlbumPage.this.clearLoadingBit(2);
                    AlbumPage.this.showSyncErrorIfNecessary(AlbumPage.this.mLoadingFailed);
                } finally {
                    gLRoot.unlockRenderThread();
                }
            }
        });
    }
}
