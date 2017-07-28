package com.android.gallery3d.data;

import android.net.Uri;
import com.android.gallery3d.data.MediaSet.ItemConsumer;
import java.util.ArrayList;

public abstract class MediaSource {
    private static final String TAG = "MediaSource";
    private String mPrefix;

    public static class PathId {
        public int id;
        public Path path;

        public PathId(Path path, int i) {
            this.path = path;
            this.id = i;
        }
    }

    protected MediaSource(String str) {
        this.mPrefix = str;
    }

    public abstract MediaObject createMediaObject(Path path);

    public Path findPathByUri(Uri uri, String str) {
        return null;
    }

    public Path getDefaultSetOf(Path path) {
        return null;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public long getTotalTargetCacheSize() {
        return 0;
    }

    public long getTotalUsedCacheSize() {
        return 0;
    }

    public void mapMediaItems(ArrayList<PathId> arrayList, ItemConsumer itemConsumer) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MediaObject createMediaObject;
            PathId pathId = (PathId) arrayList.get(i);
            synchronized (DataManager.LOCK) {
                MediaObject object = pathId.path.getObject();
                if (object == null) {
                    try {
                        createMediaObject = createMediaObject(pathId.path);
                    } catch (Throwable th) {
                        Log.m449w(TAG, "cannot create media object: " + pathId.path, th);
                    }
                }
                createMediaObject = object;
            }
            if (createMediaObject != null) {
                itemConsumer.consume(pathId.id, (MediaItem) createMediaObject);
            }
        }
    }

    public void pause() {
    }

    public void resume() {
    }
}
