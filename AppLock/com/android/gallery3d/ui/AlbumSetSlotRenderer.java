package com.android.gallery3d.ui;

import com.android.gallery3d.C0488R;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.app.AlbumSetDataLoader;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.AlbumSetSlidingWindow.AlbumSetEntry;
import com.android.gallery3d.ui.AlbumSetSlidingWindow.Listener;

public class AlbumSetSlotRenderer extends AbstractSlotRenderer {
    private static final int CACHE_SIZE = 96;
    private static final String TAG = "AlbumSetView";
    private final AbstractGalleryActivity mActivity;
    private boolean mAnimatePressedUp;
    private final ResourceTexture mCameraOverlay;
    protected AlbumSetSlidingWindow mDataWindow;
    private Path mHighlightItemPath = null;
    private boolean mInSelectionMode;
    protected final LabelSpec mLabelSpec;
    private final int mPlaceholderColor;
    private int mPressedIndex = -1;
    private final SelectionManager mSelectionManager;
    private SlotView mSlotView;
    private final ColorTexture mWaitLoadingTexture;

    public static class LabelSpec {
        public int backgroundColor;
        public int borderSize;
        public int countColor;
        public int countFontSize;
        public int countOffset;
        public int iconSize;
        public int labelBackgroundHeight;
        public int leftMargin;
        public int titleColor;
        public int titleFontSize;
        public int titleOffset;
        public int titleRightMargin;
    }

    private class MyCacheListener implements Listener {
        private MyCacheListener() {
        }

        public void onContentChanged() {
            AlbumSetSlotRenderer.this.mSlotView.invalidate();
        }

        public void onSizeChanged(int i) {
            AlbumSetSlotRenderer.this.mSlotView.setSlotCount(i);
        }
    }

    public AlbumSetSlotRenderer(AbstractGalleryActivity abstractGalleryActivity, SelectionManager selectionManager, SlotView slotView, LabelSpec labelSpec, int i) {
        super(abstractGalleryActivity);
        this.mActivity = abstractGalleryActivity;
        this.mSelectionManager = selectionManager;
        this.mSlotView = slotView;
        this.mLabelSpec = labelSpec;
        this.mPlaceholderColor = i;
        this.mWaitLoadingTexture = new ColorTexture(this.mPlaceholderColor);
        this.mWaitLoadingTexture.setSize(1, 1);
        this.mCameraOverlay = new ResourceTexture(abstractGalleryActivity, C0488R.drawable.transparent);
    }

    private static Texture checkContentTexture(Texture texture) {
        return (!(texture instanceof TiledTexture) || ((TiledTexture) texture).isReady()) ? texture : null;
    }

    private static Texture checkLabelTexture(Texture texture) {
        return ((texture instanceof UploadedTexture) && ((UploadedTexture) texture).isUploading()) ? null : texture;
    }

    public void onSlotSizeChanged(int i, int i2) {
        if (this.mDataWindow != null) {
            this.mDataWindow.onSlotSizeChanged(i, i2);
        }
    }

    public void onVisibleRangeChanged(int i, int i2) {
        if (this.mDataWindow != null) {
            this.mDataWindow.setActiveWindow(i, i2);
        }
    }

    public void pause() {
        this.mDataWindow.pause();
    }

    public void prepareDrawing() {
        this.mInSelectionMode = this.mSelectionManager.inSelectionMode();
    }

    protected int renderContent(GLCanvas gLCanvas, AlbumSetEntry albumSetEntry, int i, int i2) {
        Texture checkContentTexture = checkContentTexture(albumSetEntry.content);
        if (checkContentTexture == null) {
            checkContentTexture = this.mWaitLoadingTexture;
            albumSetEntry.isWaitLoadingDisplayed = true;
        } else if (albumSetEntry.isWaitLoadingDisplayed) {
            albumSetEntry.isWaitLoadingDisplayed = false;
            checkContentTexture = new FadeInTexture(this.mPlaceholderColor, albumSetEntry.bitmapTexture);
            albumSetEntry.content = checkContentTexture;
        }
        drawContent(gLCanvas, checkContentTexture, i, i2, albumSetEntry.rotation);
        return ((checkContentTexture instanceof FadeInTexture) && ((FadeInTexture) checkContentTexture).isAnimating()) ? 2 : 0;
    }

    protected int renderLabel(GLCanvas gLCanvas, AlbumSetEntry albumSetEntry, int i, int i2) {
        Texture checkLabelTexture = checkLabelTexture(albumSetEntry.labelTexture);
        if (checkLabelTexture == null) {
            checkLabelTexture = this.mWaitLoadingTexture;
        }
        int borderSize = AlbumLabelMaker.getBorderSize();
        int i3 = this.mLabelSpec.labelBackgroundHeight;
        checkLabelTexture.draw(gLCanvas, -borderSize, (i2 - i3) + borderSize, (i + borderSize) + borderSize, i3);
        return 0;
    }

    protected int renderOverlay(GLCanvas gLCanvas, int i, AlbumSetEntry albumSetEntry, int i2, int i3) {
        if (albumSetEntry.album != null && albumSetEntry.album.isCameraRoll()) {
            int i4 = i3 - this.mLabelSpec.labelBackgroundHeight;
            int i5 = i4 / 2;
            int i6 = (i4 - i5) / 2;
            this.mCameraOverlay.draw(gLCanvas, (i2 - i5) / 2, i6, i5, i5);
        }
        if (this.mPressedIndex == i) {
            if (this.mAnimatePressedUp) {
                drawPressedUpFrame(gLCanvas, i2, i3);
                if (!isPressedUpFrameFinished()) {
                    return 2;
                }
                this.mAnimatePressedUp = false;
                this.mPressedIndex = -1;
                return 2;
            }
            drawPressedFrame(gLCanvas, i2, i3);
            return 0;
        } else if (this.mHighlightItemPath == null || this.mHighlightItemPath != albumSetEntry.setPath) {
            if (this.mInSelectionMode && this.mSelectionManager.isItemSelected(albumSetEntry.setPath)) {
                drawSelectedFrame(gLCanvas, i2, i3);
            }
            return 0;
        } else {
            drawSelectedFrame(gLCanvas, i2, i3);
            return 0;
        }
    }

    public int renderSlot(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        AlbumSetEntry albumSetEntry = this.mDataWindow.get(i);
        return renderOverlay(gLCanvas, i, albumSetEntry, i3, i4) | ((0 | renderContent(gLCanvas, albumSetEntry, i3, i4)) | renderLabel(gLCanvas, albumSetEntry, i3, i4));
    }

    public void resume() {
        this.mDataWindow.resume();
    }

    public void setHighlightItemPath(Path path) {
        if (this.mHighlightItemPath != path) {
            this.mHighlightItemPath = path;
            this.mSlotView.invalidate();
        }
    }

    public void setModel(AlbumSetDataLoader albumSetDataLoader) {
        if (this.mDataWindow != null) {
            this.mDataWindow.setListener(null);
            this.mDataWindow = null;
            this.mSlotView.setSlotCount(0);
        }
        if (albumSetDataLoader != null) {
            this.mDataWindow = new AlbumSetSlidingWindow(this.mActivity, albumSetDataLoader, this.mLabelSpec, 96);
            this.mDataWindow.setListener(new MyCacheListener());
            this.mSlotView.setSlotCount(this.mDataWindow.size());
        }
    }

    public void setPressedIndex(int i) {
        if (this.mPressedIndex != i) {
            this.mPressedIndex = i;
            this.mSlotView.invalidate();
        }
    }

    public void setPressedUp() {
        if (this.mPressedIndex != -1) {
            this.mAnimatePressedUp = true;
            this.mSlotView.invalidate();
        }
    }
}
