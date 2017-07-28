package com.android.gallery3d.exif;

import java.util.HashMap;
import java.util.Map;

class IfdData {
    private final Map<Short, ExifTag> mExifTags = new HashMap();
    private final int mIfdId;
    private int mOffsetToNextIfd = 0;

    public IfdData(int i) {
        this.mIfdId = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IfdData) {
            IfdData ifdData = (IfdData) obj;
            if (ifdData.getId() == this.mIfdId && ifdData.getTagCount() == getTagCount()) {
                for (ExifTag exifTag : ifdData.getAllTags()) {
                    if (!ExifTag.isOffsetTag(exifTag.getTagId()) && !exifTag.equals((ExifTag) this.mExifTags.get(Short.valueOf(exifTag.getTagId())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public ExifTag[] getAllTags() {
        return (ExifTag[]) this.mExifTags.values().toArray(new ExifTag[this.mExifTags.size()]);
    }

    public int getId() {
        return this.mIfdId;
    }

    int getOffsetToNextIfd() {
        return this.mOffsetToNextIfd;
    }

    public ExifTag getTag(short s) {
        return (ExifTag) this.mExifTags.get(Short.valueOf(s));
    }

    public int getTagCount() {
        return this.mExifTags.size();
    }

    void setOffsetToNextIfd(int i) {
        this.mOffsetToNextIfd = i;
    }

    public void setTag(ExifTag exifTag) {
        this.mExifTags.put(Short.valueOf(exifTag.getTagId()), exifTag);
    }
}
