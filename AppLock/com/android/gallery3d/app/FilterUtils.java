package com.android.gallery3d.app;

import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.android.gallery3d.data.Path;

public class FilterUtils {
    public static final int CLUSTER_BY_ALBUM = 1;
    public static final int CLUSTER_BY_FACE = 32;
    public static final int CLUSTER_BY_LOCATION = 4;
    public static final int CLUSTER_BY_SIZE = 16;
    public static final int CLUSTER_BY_TAG = 8;
    public static final int CLUSTER_BY_TIME = 2;
    public static final int FILTER_ALL = 4;
    public static final int FILTER_IMAGE_ONLY = 1;
    public static final int FILTER_VIDEO_ONLY = 2;
    private static final String TAG = "FilterUtils";

    public static String newClusterPath(String str, int i) {
        String str2;
        switch (i) {
            case 2:
                str2 = "time";
                break;
            case 4:
                str2 = "location";
                break;
            case 8:
                str2 = "tag";
                break;
            case 16:
                str2 = Columns.SIZE;
                break;
            case 32:
                str2 = "face";
                break;
            default:
                return str;
        }
        return "/cluster/{" + str + "}/" + str2;
    }

    public static String newFilterPath(String str, int i) {
        int i2;
        switch (i) {
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 4;
                break;
            default:
                return str;
        }
        return "/filter/mediatype/" + i2 + "/{" + str + "}";
    }

    private static String removeOneClusterFromPath(String str) {
        return removeOneClusterFromPath(str, new boolean[1]);
    }

    private static String removeOneClusterFromPath(String str, boolean[] zArr) {
        if (zArr[0]) {
            return str;
        }
        String[] split = Path.split(str);
        if (split[0].equals("cluster")) {
            zArr[0] = true;
            return Path.splitSequence(split[1])[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append("/");
            if (split[i].startsWith("{")) {
                stringBuilder.append("{");
                String[] splitSequence = Path.splitSequence(split[i]);
                for (int i2 = 0; i2 < splitSequence.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(removeOneClusterFromPath(splitSequence[i2], zArr));
                }
                stringBuilder.append("}");
            } else {
                stringBuilder.append(split[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static String switchClusterPath(String str, int i) {
        return newClusterPath(removeOneClusterFromPath(str), i);
    }
}
