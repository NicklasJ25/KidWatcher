package com.android.gallery3d.ui;

import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SelectionManager {
    public static final int ENTER_SELECTION_MODE = 1;
    public static final int LEAVE_SELECTION_MODE = 2;
    public static final int SELECT_ALL_MODE = 3;
    private static final String TAG = "SelectionManager";
    private boolean mAutoLeave = true;
    private Set<Path> mClickedSet;
    private DataManager mDataManager;
    private boolean mInSelectionMode;
    private boolean mInverseSelection;
    private boolean mIsAlbumSet;
    private SelectionListener mListener;
    private MediaSet mSourceMediaSet;
    private int mTotal;

    public interface SelectionListener {
        void onSelectionChange(Path path, boolean z);

        void onSelectionModeChange(int i);
    }

    public SelectionManager(AbstractGalleryActivity abstractGalleryActivity, boolean z) {
        this.mDataManager = abstractGalleryActivity.getDataManager();
        this.mClickedSet = new HashSet();
        this.mIsAlbumSet = z;
        this.mTotal = -1;
    }

    private static void expandMediaSet(ArrayList<Path> arrayList, MediaSet mediaSet) {
        int subMediaSetCount = mediaSet.getSubMediaSetCount();
        for (int i = 0; i < subMediaSetCount; i++) {
            expandMediaSet(arrayList, mediaSet.getSubMediaSet(i));
        }
        int mediaItemCount = mediaSet.getMediaItemCount();
        subMediaSetCount = 0;
        while (subMediaSetCount < mediaItemCount) {
            Iterator it = mediaSet.getMediaItem(subMediaSetCount, subMediaSetCount + 50 < mediaItemCount ? 50 : mediaItemCount - subMediaSetCount).iterator();
            while (it.hasNext()) {
                arrayList.add(((MediaItem) it.next()).getPath());
            }
            subMediaSetCount += 50;
        }
    }

    private int getTotalCount() {
        if (this.mSourceMediaSet == null) {
            return -1;
        }
        if (this.mTotal < 0) {
            this.mTotal = this.mIsAlbumSet ? this.mSourceMediaSet.getSubMediaSetCount() : this.mSourceMediaSet.getMediaItemCount();
        }
        return this.mTotal;
    }

    public void deSelectAll() {
        leaveSelectionMode();
        this.mInverseSelection = false;
        this.mClickedSet.clear();
    }

    public void enterSelectionMode() {
        if (!this.mInSelectionMode) {
            this.mInSelectionMode = true;
            if (this.mListener != null) {
                this.mListener.onSelectionModeChange(1);
            }
        }
    }

    public ArrayList<Path> getSelected(boolean z) {
        int i = 0;
        ArrayList<Path> arrayList = new ArrayList();
        int totalCount;
        Path path;
        if (this.mIsAlbumSet) {
            if (this.mInverseSelection) {
                totalCount = getTotalCount();
                while (i < totalCount) {
                    MediaSet subMediaSet = this.mSourceMediaSet.getSubMediaSet(i);
                    Path path2 = subMediaSet.getPath();
                    if (!this.mClickedSet.contains(path2)) {
                        if (z) {
                            expandMediaSet(arrayList, subMediaSet);
                        } else {
                            arrayList.add(path2);
                        }
                    }
                    i++;
                }
            } else {
                for (Path path3 : this.mClickedSet) {
                    if (z) {
                        expandMediaSet(arrayList, this.mDataManager.getMediaSet(path3));
                    } else {
                        arrayList.add(path3);
                    }
                }
            }
        } else if (this.mInverseSelection) {
            int totalCount2 = getTotalCount();
            totalCount = 0;
            while (totalCount < totalCount2) {
                int min = Math.min(totalCount2 - totalCount, MediaSet.MEDIAITEM_BATCH_FETCH_COUNT);
                Iterator it = this.mSourceMediaSet.getMediaItem(totalCount, min).iterator();
                while (it.hasNext()) {
                    path3 = ((MediaItem) it.next()).getPath();
                    if (!this.mClickedSet.contains(path3)) {
                        arrayList.add(path3);
                    }
                }
                totalCount += min;
            }
        } else {
            for (Path path32 : this.mClickedSet) {
                arrayList.add(path32);
            }
        }
        return arrayList;
    }

    public int getSelectedCount() {
        int size = this.mClickedSet.size();
        return this.mInverseSelection ? getTotalCount() - size : size;
    }

    public boolean inSelectAllMode() {
        return this.mInverseSelection;
    }

    public boolean inSelectionMode() {
        return this.mInSelectionMode;
    }

    public boolean isItemSelected(Path path) {
        return this.mInverseSelection ^ this.mClickedSet.contains(path);
    }

    public void leaveSelectionMode() {
        if (this.mInSelectionMode) {
            this.mInSelectionMode = false;
            this.mInverseSelection = false;
            this.mClickedSet.clear();
            if (this.mListener != null) {
                this.mListener.onSelectionModeChange(2);
            }
        }
    }

    public void selectAll() {
        this.mInverseSelection = true;
        this.mClickedSet.clear();
        enterSelectionMode();
        if (this.mListener != null) {
            this.mListener.onSelectionModeChange(3);
        }
    }

    public void setAutoLeaveSelectionMode(boolean z) {
        this.mAutoLeave = z;
    }

    public void setSelectionListener(SelectionListener selectionListener) {
        this.mListener = selectionListener;
    }

    public void setSourceMediaSet(MediaSet mediaSet) {
        this.mSourceMediaSet = mediaSet;
        this.mTotal = -1;
    }

    public void toggle(Path path) {
        if (this.mClickedSet.contains(path)) {
            this.mClickedSet.remove(path);
        } else {
            enterSelectionMode();
            this.mClickedSet.add(path);
        }
        int selectedCount = getSelectedCount();
        if (selectedCount == getTotalCount()) {
            selectAll();
        }
        if (this.mListener != null) {
            this.mListener.onSelectionChange(path, isItemSelected(path));
        }
        if (selectedCount == 0 && this.mAutoLeave) {
            leaveSelectionMode();
        }
    }
}
