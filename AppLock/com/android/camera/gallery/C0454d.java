package com.android.camera.gallery;

import android.database.Cursor;
import com.android.camera.C0411e;
import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaObject;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.frame.p000a.C1147a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class C0454d extends MediaSet {
    private static final String[] f219a = new String[]{"COUNT(*)"};
    private static final String f220b = C1147a.m2480a("file_type like '%image%'", " and ", "album = ?");
    private final GalleryApp f221c;
    private final String f222d;
    private ArrayList<MediaItem> f223e;
    private final Path f224f;
    private int f225g = -1;

    public C0454d(Path path, GalleryApp galleryApp, String str) {
        super(path, MediaObject.nextVersionNumber());
        this.f224f = Path.fromString(C1147a.m2480a("/applock/", str));
        this.f221c = galleryApp;
        this.f222d = str;
    }

    private static MediaItem m317a(Path path, Cursor cursor, DataManager dataManager, GalleryApp galleryApp) {
        HidedPictureItem hidedPictureItem = (HidedPictureItem) dataManager.peekMediaObject(path);
        if (hidedPictureItem == null) {
            return new HidedPictureItem(path, galleryApp.getAndroidContext(), cursor);
        }
        hidedPictureItem.m279a(galleryApp.getAndroidContext(), cursor);
        return hidedPictureItem;
    }

    public void delete() {
        GalleryUtils.assertNotInRenderThread();
    }

    public ArrayList<MediaItem> getMediaItem(int i, int i2) {
        DataManager dataManager = this.f221c.getDataManager();
        AppLockApplication a = C1150y.m2566a(this.f221c.getAndroidContext());
        ArrayList arrayList = (ArrayList) a.m589c(this.f222d).clone();
        arrayList.addAll(a.m598l());
        if (this.f223e == null) {
            Cursor query;
            this.f223e = new ArrayList();
            Collection arrayList2 = new ArrayList();
            try {
                query = C0411e.m157a().query("medias", null, f220b, new String[]{this.f222d}, null, null, null, null);
            } catch (Exception e) {
                query = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        if (!arrayList.contains(query.getString(query.getColumnIndex(Columns.ID)))) {
                            arrayList2.add(C0454d.m317a(this.f224f.getChild(query.getInt(query.getColumnIndex(Columns.ID))), query, dataManager, this.f221c));
                        }
                    } finally {
                        query.close();
                        this.f223e.addAll(arrayList2);
                    }
                }
            }
        } else {
            Iterator it = ((ArrayList) this.f223e.clone()).iterator();
            while (it.hasNext()) {
                MediaItem mediaItem = (MediaItem) it.next();
                try {
                    if (arrayList.contains(((HidedPictureItem) mediaItem).f182a) || !new File(mediaItem.getFilePath()).exists()) {
                        this.f223e.remove(mediaItem);
                    }
                } catch (Exception e2) {
                }
            }
        }
        int size = this.f223e.size();
        ArrayList<MediaItem> arrayList3 = new ArrayList();
        int i3 = i;
        while (i3 < i + i2 && i3 < size) {
            arrayList3.add(this.f223e.get(i3));
            i3++;
        }
        return arrayList3;
    }

    public int getMediaItemCount() {
        if (this.f225g == -1) {
            getMediaItem(0, 0);
            if (this.f223e == null && this.f223e.size() == 0) {
                return 0;
            }
            this.f225g = this.f223e.size();
        }
        return this.f225g;
    }

    public String getName() {
        return this.f222d;
    }

    public int getSupportedOperations() {
        return 1029;
    }

    public boolean isLeafAlbum() {
        return true;
    }

    public long reload() {
        if (this.f225g == -1) {
            this.mDataVersion = MediaObject.nextVersionNumber();
            this.f225g = -1;
        }
        return this.mDataVersion;
    }

    public void setDataDirtyNow() {
        this.f225g = -1;
    }
}
