package com.android.gallery3d.data;

import android.net.Uri;
import com.android.gallery3d.app.GalleryApp;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChangeNotifier {
    private AtomicBoolean mContentDirty = new AtomicBoolean(true);
    private MediaSet mMediaSet;

    public ChangeNotifier(MediaSet mediaSet, Uri uri, GalleryApp galleryApp) {
        this.mMediaSet = mediaSet;
        galleryApp.getDataManager().registerChangeNotifier(uri, this);
    }

    public ChangeNotifier(MediaSet mediaSet, Uri[] uriArr, GalleryApp galleryApp) {
        this.mMediaSet = mediaSet;
        for (Uri registerChangeNotifier : uriArr) {
            galleryApp.getDataManager().registerChangeNotifier(registerChangeNotifier, this);
        }
    }

    public void fakeChange() {
        onChange(false);
    }

    public boolean isDirty() {
        return this.mContentDirty.compareAndSet(true, false);
    }

    protected void onChange(boolean z) {
        if (this.mContentDirty.compareAndSet(false, true)) {
            this.mMediaSet.notifyContentChanged();
        }
    }
}
