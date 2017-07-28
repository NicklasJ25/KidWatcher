package com.android.gallery3d.data;

import com.android.gallery3d.util.MediaSetUtils;

public final class DataSourceType {
    private static final Path LOCAL_ROOT = Path.fromString("/local");
    private static final Path MTP_ROOT = Path.fromString("/mtp");
    private static final Path PICASA_ROOT = Path.fromString("/picasa");
    public static final int TYPE_CAMERA = 4;
    public static final int TYPE_LOCAL = 1;
    public static final int TYPE_MTP = 3;
    public static final int TYPE_NOT_CATEGORIZED = 0;
    public static final int TYPE_PICASA = 2;

    public static int identifySourceType(MediaSet mediaSet) {
        if (mediaSet == null) {
            return 0;
        }
        Path path = mediaSet.getPath();
        if (MediaSetUtils.isCameraSource(path)) {
            return 4;
        }
        path = path.getPrefixPath();
        return path == PICASA_ROOT ? 2 : path == MTP_ROOT ? 3 : path == LOCAL_ROOT ? 1 : 0;
    }
}
