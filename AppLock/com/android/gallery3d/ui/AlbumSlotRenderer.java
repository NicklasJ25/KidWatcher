package com.android.gallery3d.ui;

import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.app.AlbumDataLoader;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.AlbumSlidingWindow.AlbumEntry;
import com.android.gallery3d.ui.AlbumSlidingWindow.Listener;

public class AlbumSlotRenderer extends AbstractSlotRenderer {
    private static final int CACHE_SIZE = 96;
    private static final String TAG = "AlbumView";
    private final AbstractGalleryActivity mActivity;
    private boolean mAnimatePressedUp;
    private AlbumSlidingWindow mDataWindow;
    private Path mHighlightItemPath = null;
    private boolean mInSelectionMode;
    private final int mPlaceholderColor;
    private int mPressedIndex = -1;
    private final SelectionManager mSelectionManager;
    private SlotFilter mSlotFilter;
    private final SlotView mSlotView;
    private final ColorTexture mWaitLoadingTexture;

    private class MyDataModelListener implements Listener {
        private MyDataModelListener() {
        }

        public void onContentChanged() {
            AlbumSlotRenderer.this.mSlotView.invalidate();
        }

        public void onSizeChanged(int i) {
            AlbumSlotRenderer.this.mSlotView.setSlotCount(i);
        }
    }

    public interface SlotFilter {
        boolean acceptSlot(int i);
    }

    public AlbumSlotRenderer(AbstractGalleryActivity abstractGalleryActivity, SlotView slotView, SelectionManager selectionManager, int i) {
        super(abstractGalleryActivity);
        this.mActivity = abstractGalleryActivity;
        this.mSlotView = slotView;
        this.mSelectionManager = selectionManager;
        this.mPlaceholderColor = i;
        this.mWaitLoadingTexture = new ColorTexture(this.mPlaceholderColor);
        this.mWaitLoadingTexture.setSize(1, 1);
    }

    private static Texture checkTexture(Texture texture) {
        return (!(texture instanceof TiledTexture) || ((TiledTexture) texture).isReady()) ? texture : null;
    }

    private int renderOverlay(GLCanvas gLCanvas, int i, AlbumEntry albumEntry, int i2, int i3) {
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
        } else if (albumEntry.path == null || this.mHighlightItemPath != albumEntry.path) {
            if (this.mInSelectionMode && this.mSelectionManager.isItemSelected(albumEntry.path)) {
                drawSelectedFrame(gLCanvas, i2, i3);
            }
            return 0;
        } else {
            drawSelectedFrame(gLCanvas, i2, i3);
            return 0;
        }
    }

    public void onSlotSizeChanged(int i, int i2) {
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

    public int renderSlot(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (this.mSlotFilter != null && !this.mSlotFilter.acceptSlot(i)) {
            return 0;
        }
        AlbumEntry albumEntry = this.mDataWindow.get(i);
        Texture checkTexture = checkTexture(albumEntry.content);
        if (checkTexture == null) {
            checkTexture = this.mWaitLoadingTexture;
            albumEntry.isWaitDisplayed = true;
        } else if (albumEntry.isWaitDisplayed) {
            albumEntry.isWaitDisplayed = false;
            checkTexture = new FadeInTexture(this.mPlaceholderColor, albumEntry.bitmapTexture);
            albumEntry.content = checkTexture;
        }
        drawContent(gLCanvas, checkTexture, i3, i4, albumEntry.rotation);
        if ((checkTexture instanceof FadeInTexture) && ((FadeInTexture) checkTexture).isAnimating()) {
            i5 = 2;
        }
        return i5 | renderOverlay(gLCanvas, i, albumEntry, i3, i4);
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

    public void setModel(AlbumDataLoader albumDataLoader) {
        if (this.mDataWindow != null) {
            this.mDataWindow.setListener(null);
            this.mSlotView.setSlotCount(0);
            this.mDataWindow = null;
        }
        if (albumDataLoader != null) {
            this.mDataWindow = new AlbumSlidingWindow(this.mActivity, albumDataLoader, 96);
            this.mDataWindow.setListener(new MyDataModelListener());
            this.mSlotView.setSlotCount(albumDataLoader.size());
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

    public void setSlotFilter(SlotFilter slotFilter) {
        this.mSlotFilter = slotFilter;
    }
}
