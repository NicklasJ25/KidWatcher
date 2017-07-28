package com.android.gallery3d.data;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.app.StitchingChangeListener;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.MediaObject.PanoramaSupportCallback;
import com.android.gallery3d.data.MediaSet.ItemConsumer;
import com.android.gallery3d.data.MediaSource.PathId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class DataManager implements StitchingChangeListener {
    public static final int APPLOCK_IMAGE = 1;
    private static final String APPLOCK_PATH = "/applock";
    public static final Object LOCK = new Object();
    private static final String TAG = "DataManager";
    public static final Comparator<MediaItem> sDateTakenComparator = new DateTakenComparator();
    private int mActiveCount = 0;
    private GalleryApp mApplication;
    private final Handler mDefaultMainHandler;
    private HashMap<Uri, NotifyBroker> mNotifierMap = new HashMap();
    private HashMap<String, MediaSource> mSourceMap = new LinkedHashMap();

    private static class DateTakenComparator implements Comparator<MediaItem> {
        private DateTakenComparator() {
        }

        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return -Utils.compare(mediaItem.getDateInMs(), mediaItem2.getDateInMs());
        }
    }

    private static class NotifyBroker extends ContentObserver {
        private WeakHashMap<ChangeNotifier, Object> mNotifiers = new WeakHashMap();

        public NotifyBroker(Handler handler) {
            super(handler);
        }

        public synchronized void onChange(boolean z) {
            for (ChangeNotifier onChange : this.mNotifiers.keySet()) {
                onChange.onChange(z);
            }
        }

        public synchronized void registerNotifier(ChangeNotifier changeNotifier) {
            this.mNotifiers.put(changeNotifier, null);
        }
    }

    public DataManager(GalleryApp galleryApp) {
        this.mApplication = galleryApp;
        this.mDefaultMainHandler = new Handler(galleryApp.getMainLooper());
    }

    public void addSource(MediaSource mediaSource) {
        if (mediaSource != null) {
            this.mSourceMap.put(mediaSource.getPrefix(), mediaSource);
        }
    }

    public void delete(Path path) {
        getMediaObject(path).delete();
    }

    public Path findPathByUri(Uri uri, String str) {
        if (uri == null) {
            return null;
        }
        for (MediaSource findPathByUri : this.mSourceMap.values()) {
            Path findPathByUri2 = findPathByUri.findPathByUri(uri, str);
            if (findPathByUri2 != null) {
                return findPathByUri2;
            }
        }
        return null;
    }

    public int getActiveCount() {
        return this.mActiveCount;
    }

    public Uri getContentUri(Path path) {
        return getMediaObject(path).getContentUri();
    }

    public Path getDefaultSetOf(Path path) {
        MediaSource mediaSource = (MediaSource) this.mSourceMap.get(path.getPrefix());
        return mediaSource == null ? null : mediaSource.getDefaultSetOf(path);
    }

    public MediaObject getMediaObject(Path path) {
        synchronized (LOCK) {
            MediaObject object = path.getObject();
            if (object != null) {
                return object;
            }
            MediaSource mediaSource = (MediaSource) this.mSourceMap.get(path.getPrefix());
            if (mediaSource == null) {
                Log.m448w(TAG, "cannot find media source for path: " + path);
                return null;
            }
            try {
                object = mediaSource.createMediaObject(path);
                if (object == null) {
                    Log.m448w(TAG, "cannot create media object: " + path);
                }
                return object;
            } catch (Throwable th) {
                Log.m449w(TAG, "exception in creating media object: " + path, th);
                return null;
            }
        }
    }

    public MediaObject getMediaObject(String str) {
        return getMediaObject(Path.fromString(str));
    }

    public MediaSet getMediaSet(Path path) {
        return (MediaSet) getMediaObject(path);
    }

    public MediaSet getMediaSet(String str) {
        return (MediaSet) getMediaObject(str);
    }

    public MediaSet[] getMediaSetsFromString(String str) {
        String[] splitSequence = Path.splitSequence(str);
        int length = splitSequence.length;
        MediaSet[] mediaSetArr = new MediaSet[length];
        for (int i = 0; i < length; i++) {
            mediaSetArr[i] = getMediaSet(splitSequence[i]);
        }
        return mediaSetArr;
    }

    public int getMediaType(Path path) {
        return getMediaObject(path).getMediaType();
    }

    public void getPanoramaSupport(Path path, PanoramaSupportCallback panoramaSupportCallback) {
        getMediaObject(path).getPanoramaSupport(panoramaSupportCallback);
    }

    public HashMap<String, MediaSource> getSourceMap() {
        return this.mSourceMap;
    }

    public int getSupportedOperations(Path path) {
        return getMediaObject(path).getSupportedOperations();
    }

    public String getTopSetPath(int i) {
        switch (i) {
            case 1:
                return APPLOCK_PATH;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long getTotalTargetCacheSize() {
        long j = 0;
        for (MediaSource totalTargetCacheSize : this.mSourceMap.values()) {
            j = totalTargetCacheSize.getTotalTargetCacheSize() + j;
        }
        return j;
    }

    public long getTotalUsedCacheSize() {
        long j = 0;
        for (MediaSource totalUsedCacheSize : this.mSourceMap.values()) {
            j = totalUsedCacheSize.getTotalUsedCacheSize() + j;
        }
        return j;
    }

    public void mapMediaItems(ArrayList<Path> arrayList, ItemConsumer itemConsumer, int i) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Path path = (Path) arrayList.get(i2);
            String prefix = path.getPrefix();
            ArrayList arrayList2 = (ArrayList) hashMap.get(prefix);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(prefix, arrayList2);
            }
            arrayList2.add(new PathId(path, i2 + i));
        }
        for (Entry entry : hashMap.entrySet()) {
            ((MediaSource) this.mSourceMap.get((String) entry.getKey())).mapMediaItems((ArrayList) entry.getValue(), itemConsumer);
        }
    }

    public void onStitchingProgress(Uri uri, int i) {
    }

    public void onStitchingQueued(Uri uri) {
    }

    public void onStitchingResult(Uri uri) {
        Path findPathByUri = findPathByUri(uri, null);
        if (findPathByUri != null) {
            MediaObject mediaObject = getMediaObject(findPathByUri);
            if (mediaObject != null) {
                mediaObject.clearCachedPanoramaSupport();
            }
        }
    }

    public void pause() {
        int i = this.mActiveCount - 1;
        this.mActiveCount = i;
        if (i == 0) {
            for (MediaSource pause : this.mSourceMap.values()) {
                pause.pause();
            }
        }
    }

    public MediaObject peekMediaObject(Path path) {
        return path.getObject();
    }

    public void registerChangeNotifier(Uri uri, ChangeNotifier changeNotifier) {
        NotifyBroker notifyBroker;
        synchronized (this.mNotifierMap) {
            notifyBroker = (NotifyBroker) this.mNotifierMap.get(uri);
            if (notifyBroker == null) {
                notifyBroker = new NotifyBroker(this.mDefaultMainHandler);
                this.mApplication.getContentResolver().registerContentObserver(uri, true, notifyBroker);
                this.mNotifierMap.put(uri, notifyBroker);
            }
        }
        notifyBroker.registerNotifier(changeNotifier);
    }

    public void resume() {
        int i = this.mActiveCount + 1;
        this.mActiveCount = i;
        if (i == 1) {
            for (MediaSource resume : this.mSourceMap.values()) {
                resume.resume();
            }
        }
    }

    public void rotate(Path path, int i) {
        Context context = null;
        if (this.mApplication != null) {
            context = this.mApplication.getAndroidContext();
        }
        getMediaObject(path).rotate(context, i);
    }
}
