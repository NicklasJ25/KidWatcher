package com.android.gallery3d.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.widget.Toast;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.app.EyePosition.EyePositionListener;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.MediaSet.SyncListener;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.AlbumSetSlotRenderer;
import com.android.gallery3d.ui.GLCanvas;
import com.android.gallery3d.ui.GLRoot;
import com.android.gallery3d.ui.GLView;
import com.android.gallery3d.ui.SelectionManager;
import com.android.gallery3d.ui.SelectionManager.SelectionListener;
import com.android.gallery3d.ui.SlotView;
import com.android.gallery3d.ui.SlotView.SimpleListener;
import com.android.gallery3d.ui.SynchronizedHandler;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.GalleryUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AlbumSetPage extends ActivityState implements EyePositionListener, SyncListener, SelectionListener {
    private static final int BIT_LOADING_RELOAD = 1;
    private static final int BIT_LOADING_SYNC = 2;
    private static final int DATA_CACHE_SIZE = 256;
    public static final String KEY_MEDIA_PATH = "media-path";
    public static final String KEY_SELECTED_CLUSTER_TYPE = "selected-cluster";
    public static final String KEY_SET_SUBTITLE = "set-subtitle";
    public static final String KEY_SET_TITLE = "set-title";
    private static final int MSG_PICK_ALBUM = 1;
    private static final int REQUEST_DO_ANIMATION = 1;
    private static final String TAG = "AlbumSetPage";
    private AlbumSetDataLoader mAlbumSetDataAdapter;
    private AlbumSetSlotRenderer mAlbumSetView;
    private com.android.gallery3d.app.Config.AlbumSetPage mConfig;
    WeakReference<Toast> mEmptyAlbumToast = null;
    private EyePosition mEyePosition;
    private boolean mGetAlbum;
    private boolean mGetContent;
    private Handler mHandler;
    private boolean mInitialSynced = false;
    private boolean mIsActive = false;
    private int mLoadingBits = 0;
    private MediaSet mMediaSet;
    private final GLView mRootPane = new C05001();
    protected SelectionManager mSelectionManager;
    private boolean mShowDetails;
    private boolean mShowedEmptyToastForSelf = false;
    private SlotView mSlotView;
    private String mSubtitle;
    private Future<Integer> mSyncTask = null;
    private String mTitle;
    private Vibrator mVibrator;
    private float mX;
    private float mY;
    private float mZ;

    class C05001 extends GLView {
        private final float[] mMatrix = new float[16];

        C05001() {
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            AlbumSetPage.this.mEyePosition.resetPosition();
            int i5 = AlbumSetPage.this.mConfig.paddingTop;
            int i6 = (i4 - i2) - AlbumSetPage.this.mConfig.paddingBottom;
            int i7 = i3 - i;
            AlbumSetPage.this.mAlbumSetView.setHighlightItemPath(null);
            AlbumSetPage.this.mSlotView.layout(0, i5, i7, i6);
        }

        protected void render(GLCanvas gLCanvas) {
            gLCanvas.save(2);
            GalleryUtils.setViewPointMatrix(this.mMatrix, ((float) (getWidth() / 2)) + AlbumSetPage.this.mX, ((float) (getHeight() / 2)) + AlbumSetPage.this.mY, AlbumSetPage.this.mZ);
            gLCanvas.multiplyMatrix(this.mMatrix, 0);
            super.render(gLCanvas);
            gLCanvas.restore();
        }
    }

    class C05023 extends SimpleListener {
        C05023() {
        }

        public void onDown(int i) {
            AlbumSetPage.this.onDown(i);
        }

        public void onLongTap(int i) {
            AlbumSetPage.this.onLongTap(i);
        }

        public void onSingleTapUp(int i) {
            AlbumSetPage.this.onSingleTapUp(i);
        }

        public void onUp(boolean z) {
            AlbumSetPage.this.onUp(z);
        }
    }

    private class MyLoadingListener implements LoadingListener {
        private MyLoadingListener() {
        }

        public void onLoadingFinished(boolean z) {
            AlbumSetPage.this.clearLoadingBit(1);
        }

        public void onLoadingStarted() {
            AlbumSetPage.this.setLoadingBit(1);
        }
    }

    private static boolean albumShouldOpenInFilmstrip(MediaSet mediaSet) {
        ArrayList mediaItem = mediaSet.getMediaItemCount() == 1 ? mediaSet.getMediaItem(0, 1) : null;
        return (mediaItem == null || mediaItem.isEmpty()) ? false : true;
    }

    private void clearLoadingBit(int i) {
        this.mLoadingBits &= i ^ -1;
        if (this.mLoadingBits == 0 && this.mIsActive && this.mAlbumSetDataAdapter.size() == 0) {
            if (this.mActivity.getStateManager().getStateCount() > 1) {
                Intent intent = new Intent();
                intent.putExtra(AlbumPage.KEY_EMPTY_ALBUM, true);
                setStateResult(-1, intent);
                this.mActivity.getStateManager().finishState(this);
                return;
            }
            this.mShowedEmptyToastForSelf = true;
            showEmptyAlbumToast(1);
            this.mSlotView.invalidate();
        } else if (this.mShowedEmptyToastForSelf) {
            this.mShowedEmptyToastForSelf = false;
            hideEmptyAlbumToast();
        }
    }

    private void getSlotCenter(int i, int[] iArr) {
        Rect rect = new Rect();
        this.mRootPane.getBoundsOf(this.mSlotView, rect);
        Rect slotRect = this.mSlotView.getSlotRect(i);
        int scrollX = this.mSlotView.getScrollX();
        int scrollY = this.mSlotView.getScrollY();
        iArr[0] = (rect.left + ((slotRect.left + slotRect.right) / 2)) - scrollX;
        iArr[1] = (rect.top + ((slotRect.bottom + slotRect.top) / 2)) - scrollY;
    }

    private void hideDetails() {
        this.mShowDetails = false;
        this.mAlbumSetView.setHighlightItemPath(null);
        this.mSlotView.invalidate();
    }

    private void hideEmptyAlbumToast() {
        if (this.mEmptyAlbumToast != null) {
            Toast toast = (Toast) this.mEmptyAlbumToast.get();
            if (toast != null) {
                toast.cancel();
            }
        }
    }

    private void initializeData(Bundle bundle) {
        this.mMediaSet = this.mActivity.getDataManager().getMediaSet(bundle.getString("media-path"));
        this.mSelectionManager.setSourceMediaSet(this.mMediaSet);
        this.mAlbumSetDataAdapter = new AlbumSetDataLoader(this.mActivity, this.mMediaSet, 256);
        this.mAlbumSetDataAdapter.setLoadingListener(new MyLoadingListener());
        this.mAlbumSetView.setModel(this.mAlbumSetDataAdapter);
    }

    private void initializeViews() {
        this.mSelectionManager = new SelectionManager(this.mActivity, true);
        this.mSelectionManager.setSelectionListener(this);
        this.mConfig = com.android.gallery3d.app.Config.AlbumSetPage.get(this.mActivity);
        this.mSlotView = new SlotView(this.mActivity, this.mConfig.slotViewSpec);
        this.mAlbumSetView = new AlbumSetSlotRenderer(this.mActivity, this.mSelectionManager, this.mSlotView, this.mConfig.labelSpec, this.mConfig.placeholderColor);
        this.mSlotView.setSlotRenderer(this.mAlbumSetView);
        this.mSlotView.setListener(new C05023());
        this.mRootPane.addComponent(this.mSlotView);
    }

    private void onDown(int i) {
        this.mAlbumSetView.setPressedIndex(i);
    }

    private void onUp(boolean z) {
        if (z) {
            this.mAlbumSetView.setPressedIndex(-1);
        } else {
            this.mAlbumSetView.setPressedUp();
        }
    }

    private void pickAlbum(int i) {
        boolean z = false;
        if (this.mIsActive) {
            MediaSet mediaSet = this.mAlbumSetDataAdapter.getMediaSet(i);
            if (mediaSet == null) {
                return;
            }
            if (mediaSet.getTotalMediaItemCount() == 0) {
                showEmptyAlbumToast(0);
                return;
            }
            hideEmptyAlbumToast();
            String path = mediaSet.getPath().toString();
            Bundle bundle = new Bundle(getData());
            int[] iArr = new int[2];
            getSlotCenter(i, iArr);
            bundle.putIntArray(AlbumPage.KEY_SET_CENTER, iArr);
            if (this.mGetAlbum && mediaSet.isLeafAlbum()) {
                this.mActivity.finish();
            } else if (mediaSet.getSubMediaSetCount() > 0) {
                bundle.putString("media-path", path);
                this.mActivity.getStateManager().startStateForResult(AlbumSetPage.class, 1, bundle);
            } else {
                if (!this.mGetContent && (mediaSet.getSupportedOperations() & 2048) != 0) {
                    bundle.putBoolean(AlbumPage.KEY_AUTO_SELECT_ALL, true);
                } else if (!this.mGetContent && albumShouldOpenInFilmstrip(mediaSet)) {
                    bundle.putParcelable(PhotoPage.KEY_OPEN_ANIMATION_RECT, this.mSlotView.getSlotRect(i, this.mRootPane));
                    bundle.putInt(PhotoPage.KEY_INDEX_HINT, 0);
                    bundle.putString("media-set-path", path);
                    bundle.putBoolean(PhotoPage.KEY_START_IN_FILMSTRIP, true);
                    bundle.putBoolean(PhotoPage.KEY_IN_CAMERA_ROLL, mediaSet.isCameraRoll());
                    this.mActivity.getStateManager().startStateForResult(PhotoPage.class, 2, bundle);
                    return;
                }
                bundle.putString("media-path", path);
                boolean hasStateClass = this.mActivity.getStateManager().hasStateClass(AlbumPage.class);
                path = AlbumPage.KEY_SHOW_CLUSTER_MENU;
                if (!hasStateClass) {
                    z = true;
                }
                bundle.putBoolean(path, z);
                this.mActivity.getStateManager().startStateForResult(AlbumPage.class, 1, bundle);
            }
        }
    }

    private void setLoadingBit(int i) {
        this.mLoadingBits |= i;
    }

    private void showEmptyAlbumToast(int i) {
        Toast toast;
        if (this.mEmptyAlbumToast != null) {
            toast = (Toast) this.mEmptyAlbumToast.get();
            if (toast != null) {
                toast.show();
                return;
            }
        }
        toast = Toast.makeText(this.mActivity, C0488R.string.empty_album, i);
        this.mEmptyAlbumToast = new WeakReference(toast);
        toast.show();
    }

    protected int getBackgroundColorId() {
        return C0488R.color.albumset_background;
    }

    public void onBackPressed() {
        if (this.mShowDetails) {
            hideDetails();
        } else if (this.mSelectionManager.inSelectionMode()) {
            this.mSelectionManager.leaveSelectionMode();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle, Bundle bundle2) {
        super.onCreate(bundle, bundle2);
        initializeViews();
        initializeData(bundle);
        Context androidContext = this.mActivity.getAndroidContext();
        this.mGetContent = bundle.getBoolean(Gallery.KEY_GET_CONTENT, false);
        this.mGetAlbum = bundle.getBoolean(Gallery.KEY_GET_ALBUM, false);
        this.mTitle = bundle.getString(KEY_SET_TITLE);
        this.mSubtitle = bundle.getString(KEY_SET_SUBTITLE);
        this.mEyePosition = new EyePosition(androidContext, this);
        this.mVibrator = (Vibrator) androidContext.getSystemService("vibrator");
        this.mHandler = new SynchronizedHandler(this.mActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        AlbumSetPage.this.pickAlbum(message.arg1);
                        return;
                    default:
                        throw new AssertionError(message.what);
                }
            }
        };
    }

    public void onEyePositionChanged(float f, float f2, float f3) {
        this.mRootPane.lockRendering();
        this.mX = f;
        this.mY = f2;
        this.mZ = f3;
        this.mRootPane.unlockRendering();
        this.mRootPane.invalidate();
    }

    public void onLongTap(int i) {
        if (!this.mGetContent && !this.mGetAlbum) {
            MediaSet mediaSet = this.mAlbumSetDataAdapter.getMediaSet(i);
            if (mediaSet != null) {
                this.mSelectionManager.setAutoLeaveSelectionMode(true);
                this.mSelectionManager.toggle(mediaSet.getPath());
                this.mSlotView.invalidate();
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.mIsActive = false;
        this.mAlbumSetDataAdapter.pause();
        this.mAlbumSetView.pause();
        this.mEyePosition.pause();
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
            this.mSyncTask = null;
            clearLoadingBit(2);
        }
    }

    public void onResume() {
        super.onResume();
        this.mIsActive = true;
        setContentPane(this.mRootPane);
        setLoadingBit(1);
        this.mAlbumSetDataAdapter.resume();
        this.mAlbumSetView.resume();
        this.mEyePosition.resume();
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

    public void onSingleTapUp(int i) {
        if (!this.mIsActive) {
            return;
        }
        if (this.mSelectionManager.inSelectionMode()) {
            MediaSet mediaSet = this.mAlbumSetDataAdapter.getMediaSet(i);
            if (mediaSet != null) {
                this.mSelectionManager.toggle(mediaSet.getPath());
                this.mSlotView.invalidate();
                return;
            }
            return;
        }
        this.mAlbumSetView.setPressedIndex(i);
        this.mAlbumSetView.setPressedUp();
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, i, 0), 180);
    }

    protected void onStateResult(int i, int i2, Intent intent) {
        if (intent != null && intent.getBooleanExtra(AlbumPage.KEY_EMPTY_ALBUM, false)) {
            showEmptyAlbumToast(0);
        }
        switch (i) {
            case 1:
                this.mSlotView.startRisingAnimation();
                return;
            default:
                return;
        }
    }

    public void onSyncDone(MediaSet mediaSet, final int i) {
        if (i == 2) {
            Log.m429d(TAG, "onSyncDone: " + Utils.maskDebugInfo(mediaSet.getName()) + " result=" + i);
        }
        this.mActivity.runOnUiThread(new Runnable() {
            public void run() {
                GLRoot gLRoot = AlbumSetPage.this.mActivity.getGLRoot();
                gLRoot.lockRenderThread();
                try {
                    if (i == 0) {
                        AlbumSetPage.this.mInitialSynced = true;
                    }
                    AlbumSetPage.this.clearLoadingBit(2);
                    if (i == 2 && AlbumSetPage.this.mIsActive) {
                        Log.m437w(AlbumSetPage.TAG, "failed to load album set");
                    }
                    gLRoot.unlockRenderThread();
                } catch (Throwable th) {
                    gLRoot.unlockRenderThread();
                }
            }
        });
    }
}
