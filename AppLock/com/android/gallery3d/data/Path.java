package com.android.gallery3d.data;

import android.text.TextUtils;
import com.android.gallery3d.util.IdentityCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class Path {
    private static final String TAG = "Path";
    private static Path sRoot = new Path(null, "ROOT");
    private IdentityCache<String, Path> mChildren;
    private WeakReference<MediaObject> mObject;
    private final Path mParent;
    private final String mSegment;

    private Path(Path path, String str) {
        this.mParent = path;
        this.mSegment = str;
    }

    static void clearAll() {
        synchronized (Path.class) {
            sRoot = new Path(null, "");
        }
    }

    static void dumpAll() {
        dumpAll(sRoot, "", "");
    }

    static void dumpAll(Path path, String str, String str2) {
        synchronized (Path.class) {
            MediaObject object = path.getObject();
            Log.m440d(TAG, str + path.mSegment + ":" + (object == null ? "null" : object.getClass().getSimpleName()));
            if (path.mChildren != null) {
                ArrayList keys = path.mChildren.keys();
                int size = keys.size();
                Iterator it = keys.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Path path2 = (Path) path.mChildren.get((String) it.next());
                    if (path2 == null) {
                        i++;
                    } else {
                        Log.m440d(TAG, str2 + "|");
                        i++;
                        if (i < size) {
                            dumpAll(path2, str2 + "+-- ", str2 + "|   ");
                        } else {
                            dumpAll(path2, str2 + "+-- ", str2 + "    ");
                        }
                    }
                }
            }
        }
    }

    public static Path fromString(String str) {
        Path path;
        synchronized (Path.class) {
            if (!TextUtils.isEmpty(str)) {
                str = str.replaceAll("\\{", "").replaceAll("\\}", "");
            }
            String[] split = split(str);
            path = sRoot;
            for (String child : split) {
                path = path.getChild(child);
            }
        }
        return path;
    }

    public static String[] split(String str) {
        int length = str.length();
        if (length == 0) {
            return new String[0];
        }
        if (str.charAt(0) != '/') {
            throw new RuntimeException("malformed path:" + str);
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < length) {
            int i2 = i;
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt != '{') {
                    if (charAt != '}') {
                        if (i3 == 0 && charAt == '/') {
                            break;
                        }
                    }
                    i3--;
                } else {
                    i3++;
                }
                i2++;
            }
            if (i3 != 0) {
                throw new RuntimeException("unbalanced brace in path:" + str);
            }
            arrayList.add(str.substring(i, i2));
            i = i2 + 1;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String[] splitSequence(String str) {
        int length = str.length();
        if (str.charAt(0) == '{' && str.charAt(length - 1) == '}') {
            ArrayList arrayList = new ArrayList();
            int i;
            for (int i2 = 1; i2 < length - 1; i2 = i + 1) {
                i = i2;
                int i3 = 0;
                while (i < length - 1) {
                    char charAt = str.charAt(i);
                    if (charAt != '{') {
                        if (charAt != '}') {
                            if (i3 == 0 && charAt == ',') {
                                break;
                            }
                        }
                        i3--;
                    } else {
                        i3++;
                    }
                    i++;
                }
                if (i3 != 0) {
                    throw new RuntimeException("unbalanced brace in path:" + str);
                }
                arrayList.add(str.substring(i2, i));
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            return strArr;
        }
        throw new RuntimeException("bad sequence: " + str);
    }

    public boolean equalsIgnoreCase(String str) {
        return toString().equalsIgnoreCase(str);
    }

    public Path getChild(int i) {
        return getChild(String.valueOf(i));
    }

    public Path getChild(long j) {
        return getChild(String.valueOf(j));
    }

    public Path getChild(String str) {
        Path path;
        synchronized (this) {
            if (this.mChildren == null) {
                this.mChildren = new IdentityCache();
            } else {
                path = (Path) this.mChildren.get(str);
                if (path != null) {
                }
            }
            path = new Path(this, str);
            this.mChildren.put(str, path);
        }
        return path;
    }

    MediaObject getObject() {
        MediaObject mediaObject;
        synchronized (this) {
            mediaObject = this.mObject == null ? null : (MediaObject) this.mObject.get();
        }
        return mediaObject;
    }

    public Path getParent() {
        Path path;
        synchronized (this) {
            path = this.mParent;
        }
        return path;
    }

    public String getPrefix() {
        return this == sRoot ? "" : getPrefixPath().mSegment;
    }

    public Path getPrefixPath() {
        Path path;
        synchronized (this) {
            if (this == sRoot) {
                throw new IllegalStateException();
            }
            path = this;
            while (path.mParent != sRoot) {
                path = path.mParent;
            }
        }
        return path;
    }

    public String getSuffix() {
        return this.mSegment;
    }

    public final void setObject(MediaObject mediaObject) {
        this.mObject = new WeakReference(mediaObject);
    }

    public String[] split() {
        String[] strArr;
        synchronized (this) {
            Path path;
            int i = 0;
            for (path = this; path != sRoot; path = path.mParent) {
                i++;
            }
            strArr = new String[i];
            i--;
            path = this;
            while (path != sRoot) {
                int i2 = i - 1;
                strArr[i] = path.mSegment;
                path = path.mParent;
                i = i2;
            }
        }
        return strArr;
    }

    public String toString() {
        StringBuilder stringBuilder;
        synchronized (this) {
            stringBuilder = new StringBuilder();
            String[] split = split();
            for (String append : split) {
                stringBuilder.append("/");
                stringBuilder.append(append);
            }
        }
        return stringBuilder.toString();
    }
}
