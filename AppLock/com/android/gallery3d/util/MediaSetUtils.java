package com.android.gallery3d.util;

import android.os.Environment;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import java.util.Comparator;

public class MediaSetUtils {
    public static final int CAMERA_BUCKET_ID = GalleryUtils.getBucketId(Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera");
    private static final Path[] CAMERA_PATHS = new Path[]{Path.fromString("/local/all/" + CAMERA_BUCKET_ID), Path.fromString("/local/image/" + CAMERA_BUCKET_ID), Path.fromString("/local/video/" + CAMERA_BUCKET_ID)};
    public static final int DOWNLOAD_BUCKET_ID = GalleryUtils.getBucketId(Environment.getExternalStorageDirectory().toString() + "/" + BucketNames.DOWNLOAD);
    public static final int EDITED_ONLINE_PHOTOS_BUCKET_ID = GalleryUtils.getBucketId(Environment.getExternalStorageDirectory().toString() + "/" + BucketNames.EDITED_ONLINE_PHOTOS);
    public static final int IMPORTED_BUCKET_ID = GalleryUtils.getBucketId(Environment.getExternalStorageDirectory().toString() + "/" + BucketNames.IMPORTED);
    public static final Comparator<MediaSet> NAME_COMPARATOR = new NameComparator();
    public static final int SNAPSHOT_BUCKET_ID = GalleryUtils.getBucketId(Environment.getExternalStorageDirectory().toString() + "/Pictures/Screenshots");

    public static class NameComparator implements Comparator<MediaSet> {
        public int compare(MediaSet mediaSet, MediaSet mediaSet2) {
            int compareToIgnoreCase = mediaSet.getName().compareToIgnoreCase(mediaSet2.getName());
            return compareToIgnoreCase != 0 ? compareToIgnoreCase : mediaSet.getPath().toString().compareTo(mediaSet2.getPath().toString());
        }
    }

    public static boolean isCameraSource(Path path) {
        return CAMERA_PATHS[0] == path || CAMERA_PATHS[1] == path || CAMERA_PATHS[2] == path;
    }
}
