package com.android.gallery3d.data;

import android.media.ExifInterface;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.common.ExifTags;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MediaDetails implements Iterable<Entry<Integer, Object>> {
    public static final int INDEX_APERTURE = 105;
    public static final int INDEX_DATETIME = 3;
    public static final int INDEX_DESCRIPTION = 2;
    public static final int INDEX_DURATION = 8;
    public static final int INDEX_EXPOSURE_TIME = 107;
    public static final int INDEX_FLASH = 102;
    public static final int INDEX_FOCAL_LENGTH = 103;
    public static final int INDEX_HEIGHT = 6;
    public static final int INDEX_ISO = 108;
    public static final int INDEX_LOCATION = 4;
    public static final int INDEX_MAKE = 100;
    public static final int INDEX_MIMETYPE = 9;
    public static final int INDEX_MODEL = 101;
    public static final int INDEX_ORIENTATION = 7;
    public static final int INDEX_PATH = 200;
    public static final int INDEX_SHUTTER_SPEED = 106;
    public static final int INDEX_SIZE = 10;
    public static final int INDEX_TITLE = 1;
    public static final int INDEX_WHITE_BALANCE = 104;
    public static final int INDEX_WIDTH = 5;
    private static final String TAG = "MediaDetails";
    private TreeMap<Integer, Object> mDetails = new TreeMap();
    private HashMap<Integer, Integer> mUnits = new HashMap();

    public static class FlashState {
        private static int FLASH_FIRED_MASK = 1;
        private static int FLASH_FUNCTION_MASK = 32;
        private static int FLASH_MODE_MASK = 24;
        private static int FLASH_RED_EYE_MASK = 64;
        private static int FLASH_RETURN_MASK = 6;
        private int mState;

        public FlashState(int i) {
            this.mState = i;
        }

        public boolean isFlashFired() {
            return (this.mState & FLASH_FIRED_MASK) != 0;
        }
    }

    public static void extractExifInfo(MediaDetails mediaDetails, String str) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            setExifData(mediaDetails, exifInterface, "Flash", 102);
            setExifData(mediaDetails, exifInterface, "ImageWidth", 5);
            setExifData(mediaDetails, exifInterface, "ImageLength", 6);
            setExifData(mediaDetails, exifInterface, "Make", 100);
            setExifData(mediaDetails, exifInterface, "Model", 101);
            setExifData(mediaDetails, exifInterface, ExifTags.TAG_APERTURE, 105);
            setExifData(mediaDetails, exifInterface, ExifTags.TAG_ISO, 108);
            setExifData(mediaDetails, exifInterface, "WhiteBalance", 104);
            setExifData(mediaDetails, exifInterface, ExifTags.TAG_EXPOSURE_TIME, 107);
            double attributeDouble = exifInterface.getAttributeDouble("FocalLength", 0.0d);
            if (attributeDouble != 0.0d) {
                mediaDetails.addDetail(103, Double.valueOf(attributeDouble));
                mediaDetails.setUnit(103, C0488R.string.unit_mm);
            }
        } catch (Throwable e) {
            Log.m449w(TAG, "", e);
        }
    }

    private static void setExifData(MediaDetails mediaDetails, ExifInterface exifInterface, String str, int i) {
        String attribute = exifInterface.getAttribute(str);
        if (attribute == null) {
            return;
        }
        if (i == 102) {
            mediaDetails.addDetail(i, new FlashState(Integer.valueOf(attribute.toString()).intValue()));
        } else {
            mediaDetails.addDetail(i, attribute);
        }
    }

    public void addDetail(int i, Object obj) {
        this.mDetails.put(Integer.valueOf(i), obj);
    }

    public Object getDetail(int i) {
        return this.mDetails.get(Integer.valueOf(i));
    }

    public int getUnit(int i) {
        return ((Integer) this.mUnits.get(Integer.valueOf(i))).intValue();
    }

    public boolean hasUnit(int i) {
        return this.mUnits.containsKey(Integer.valueOf(i));
    }

    public Iterator<Entry<Integer, Object>> iterator() {
        return this.mDetails.entrySet().iterator();
    }

    public void setUnit(int i, int i2) {
        this.mUnits.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public int size() {
        return this.mDetails.size();
    }
}
