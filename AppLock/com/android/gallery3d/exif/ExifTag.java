package com.android.gallery3d.exif;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ExifTag {
    private static final long LONG_MAX = 2147483647L;
    private static final long LONG_MIN = -2147483648L;
    private static final int SIZE_UNDEFINED = 0;
    public static final short TAG_APERTURE_VALUE = (short) -28158;
    public static final short TAG_ARTIST = (short) 315;
    public static final short TAG_BITS_PER_SAMPLE = (short) 258;
    public static final short TAG_BRIGHTNESS_VALUE = (short) -28157;
    public static final short TAG_CFA_PATTERN = (short) -23806;
    public static final short TAG_COLOR_SPACE = (short) -24575;
    public static final short TAG_COMPONENTS_CONFIGURATION = (short) -28415;
    public static final short TAG_COMPRESSED_BITS_PER_PIXEL = (short) -28414;
    public static final short TAG_COMPRESSION = (short) 259;
    public static final short TAG_CONTRAST = (short) -23544;
    public static final short TAG_COPYRIGHT = (short) -32104;
    public static final short TAG_CUSTOM_RENDERED = (short) -23551;
    public static final short TAG_DATE_TIME = (short) 306;
    public static final short TAG_DATE_TIME_DIGITIZED = (short) -28668;
    public static final short TAG_DATE_TIME_ORIGINAL = (short) -28669;
    public static final short TAG_DEVICE_SETTING_DESCRIPTION = (short) -23541;
    public static final short TAG_DIGITAL_ZOOM_RATIO = (short) -23548;
    public static final short TAG_EXIF_IFD = (short) -30871;
    public static final short TAG_EXIF_VERSION = (short) -28672;
    public static final short TAG_EXPOSURE_BIAS_VALUE = (short) -28156;
    public static final short TAG_EXPOSURE_INDEX = (short) -24043;
    public static final short TAG_EXPOSURE_MODE = (short) -23550;
    public static final short TAG_EXPOSURE_PROGRAM = (short) -30686;
    public static final short TAG_EXPOSURE_TIME = (short) -32102;
    public static final short TAG_FILE_SOURCE = (short) -23808;
    public static final short TAG_FLASH = (short) -28151;
    public static final short TAG_FLASHPIX_VERSION = (short) -24576;
    public static final short TAG_FLASH_ENERGY = (short) -24053;
    public static final short TAG_FOCAL_LENGTH = (short) -28150;
    public static final short TAG_FOCAL_LENGTH_IN_35_MM_FILE = (short) -23547;
    public static final short TAG_FOCAL_PLANE_RESOLUTION_UNIT = (short) -24048;
    public static final short TAG_FOCAL_PLANE_X_RESOLUTION = (short) -24050;
    public static final short TAG_FOCAL_PLANE_Y_RESOLUTION = (short) -24049;
    public static final short TAG_F_NUMBER = (short) -32099;
    public static final short TAG_GAIN_CONTROL = (short) -23545;
    public static final short TAG_GPS_ALTITUDE = (short) 6;
    public static final short TAG_GPS_ALTITUDE_REF = (short) 5;
    public static final short TAG_GPS_AREA_INFORMATION = (short) 28;
    public static final short TAG_GPS_DATA_STAMP = (short) 29;
    public static final short TAG_GPS_DEST_BEARING = (short) 24;
    public static final short TAG_GPS_DEST_BEARING_REF = (short) 23;
    public static final short TAG_GPS_DEST_DISTANCE = (short) 26;
    public static final short TAG_GPS_DEST_DISTANCE_REF = (short) 25;
    public static final short TAG_GPS_DEST_LATITUDE = (short) 20;
    public static final short TAG_GPS_DEST_LATITUDE_REF = (short) 19;
    public static final short TAG_GPS_DEST_LONGITUDE = (short) 22;
    public static final short TAG_GPS_DEST_LONGITUDE_REF = (short) 21;
    public static final short TAG_GPS_DIFFERENTIAL = (short) 30;
    public static final short TAG_GPS_DOP = (short) 11;
    public static final short TAG_GPS_IFD = (short) -30683;
    public static final short TAG_GPS_IMG_DIRECTION = (short) 17;
    public static final short TAG_GPS_IMG_DIRECTION_REF = (short) 16;
    public static final short TAG_GPS_LATITUDE = (short) 2;
    public static final short TAG_GPS_LATITUDE_REF = (short) 1;
    public static final short TAG_GPS_LONGITUDE = (short) 4;
    public static final short TAG_GPS_LONGITUDE_REF = (short) 3;
    public static final short TAG_GPS_MAP_DATUM = (short) 18;
    public static final short TAG_GPS_MEASURE_MODE = (short) 10;
    public static final short TAG_GPS_PROCESSING_METHOD = (short) 27;
    public static final short TAG_GPS_SATTELLITES = (short) 8;
    public static final short TAG_GPS_SPEED = (short) 13;
    public static final short TAG_GPS_SPEED_REF = (short) 12;
    public static final short TAG_GPS_STATUS = (short) 9;
    public static final short TAG_GPS_TIME_STAMP = (short) 7;
    public static final short TAG_GPS_TRACK = (short) 15;
    public static final short TAG_GPS_TRACK_REF = (short) 14;
    public static final short TAG_GPS_VERSION_ID = (short) 0;
    public static final short TAG_IMAGE_DESCRIPTION = (short) 270;
    public static final short TAG_IMAGE_LENGTH = (short) 257;
    public static final short TAG_IMAGE_UNIQUE_ID = (short) -23520;
    public static final short TAG_IMAGE_WIDTH = (short) 256;
    public static final short TAG_INTEROPERABILITY_IFD = (short) -24571;
    public static final short TAG_INTEROPERABILITY_INDEX = (short) 1;
    public static final short TAG_ISO_SPEED_RATINGS = (short) -30681;
    public static final short TAG_JPEG_INTERCHANGE_FORMAT = (short) 513;
    public static final short TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = (short) 514;
    public static final short TAG_LIGHT_SOURCE = (short) -28152;
    public static final short TAG_MAKE = (short) 271;
    public static final short TAG_MAKER_NOTE = (short) -28036;
    public static final short TAG_MAX_APERTURE_VALUE = (short) -28155;
    public static final short TAG_METERING_MODE = (short) -28153;
    public static final short TAG_MODEL = (short) 272;
    public static final short TAG_OECF = (short) -30680;
    public static final short TAG_ORIENTATION = (short) 274;
    public static final short TAG_PHOTOMETRIC_INTERPRETATION = (short) 262;
    public static final short TAG_PIXEL_X_DIMENSION = (short) -24574;
    public static final short TAG_PIXEL_Y_DIMENSION = (short) -24573;
    public static final short TAG_PLANAR_CONFIGURATION = (short) 284;
    public static final short TAG_PRIMARY_CHROMATICITIES = (short) 319;
    public static final short TAG_REFERENCE_BLACK_WHITE = (short) 532;
    public static final short TAG_RELATED_SOUND_FILE = (short) -24572;
    public static final short TAG_RESOLUTION_UNIT = (short) 296;
    public static final short TAG_ROWS_PER_STRIP = (short) 278;
    public static final short TAG_SAMPLES_PER_PIXEL = (short) 277;
    public static final short TAG_SATURATION = (short) -23543;
    public static final short TAG_SCENE_CAPTURE_TYPE = (short) -23546;
    public static final short TAG_SCENE_TYPE = (short) -23807;
    public static final short TAG_SENSING_METHOD = (short) -24041;
    public static final short TAG_SHARPNESS = (short) -23542;
    public static final short TAG_SHUTTER_SPEED_VALUE = (short) -28159;
    public static final short TAG_SOFTWARE = (short) 305;
    public static final short TAG_SPATIAL_FREQUENCY_RESPONSE = (short) -24052;
    public static final short TAG_SPECTRAL_SENSITIVITY = (short) -30684;
    public static final short TAG_STRIP_BYTE_COUNTS = (short) 279;
    public static final short TAG_STRIP_OFFSETS = (short) 273;
    public static final short TAG_SUBJECT_AREA = (short) -28140;
    public static final short TAG_SUBJECT_DISTANCE = (short) -28154;
    public static final short TAG_SUBJECT_DISTANCE_RANGE = (short) -23540;
    public static final short TAG_SUBJECT_LOCATION = (short) -24044;
    public static final short TAG_SUB_SEC_TIME = (short) -28016;
    public static final short TAG_SUB_SEC_TIME_DIGITIZED = (short) -28014;
    public static final short TAG_SUB_SEC_TIME_ORIGINAL = (short) -28015;
    public static final short TAG_TRANSFER_FUNCTION = (short) 301;
    public static final short TAG_USER_COMMENT = (short) -28026;
    public static final short TAG_WHITE_BALANCE = (short) -23549;
    public static final short TAG_WHITE_POINT = (short) 318;
    public static final short TAG_X_RESOLUTION = (short) 282;
    public static final short TAG_Y_CB_CR_COEFFICIENTS = (short) 529;
    public static final short TAG_Y_CB_CR_POSITIONING = (short) 531;
    public static final short TAG_Y_CB_CR_SUB_SAMPLING = (short) 530;
    public static final short TAG_Y_RESOLUTION = (short) 283;
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    public static final short TYPE_ASCII = (short) 2;
    public static final short TYPE_LONG = (short) 9;
    public static final short TYPE_RATIONAL = (short) 10;
    private static final int[] TYPE_TO_SIZE_MAP = new int[11];
    public static final short TYPE_UNDEFINED = (short) 7;
    public static final short TYPE_UNSIGNED_BYTE = (short) 1;
    public static final short TYPE_UNSIGNED_LONG = (short) 4;
    public static final short TYPE_UNSIGNED_RATIONAL = (short) 5;
    public static final short TYPE_UNSIGNED_SHORT = (short) 3;
    private static final long UNSIGNED_LONG_MAX = 4294967295L;
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private static volatile SparseArray<Integer> sInteroperTagInfo = null;
    private static volatile SparseArray<Integer> sTagInfo = null;
    private int mComponentCount;
    private final boolean mComponentCountDefined;
    private final short mDataType;
    private final int mIfd;
    private int mOffset;
    private final short mTagId;
    private Object mValue;

    public interface ColorSpace {
        public static final short SRGB = (short) 1;
        public static final short UNCALIBRATED = (short) -1;
    }

    public interface Compression {
        public static final short JPEG = (short) 6;
        public static final short UNCOMPRESSION = (short) 1;
    }

    public interface Contrast {
        public static final short HARD = (short) 2;
        public static final short NORMAL = (short) 0;
        public static final short SOFT = (short) 1;
    }

    public interface ExposureMode {
        public static final short AUTO_BRACKET = (short) 2;
        public static final short AUTO_EXPOSURE = (short) 0;
        public static final short MANUAL_EXPOSURE = (short) 1;
    }

    public interface ExposureProgram {
        public static final short ACTION_PROGRAM = (short) 6;
        public static final short APERTURE_PRIORITY = (short) 3;
        public static final short CREATIVE_PROGRAM = (short) 5;
        public static final short LANDSCAPE_MODE = (short) 8;
        public static final short MANUAL = (short) 1;
        public static final short NORMAL_PROGRAM = (short) 2;
        public static final short NOT_DEFINED = (short) 0;
        public static final short PROTRAIT_MODE = (short) 7;
        public static final short SHUTTER_PRIORITY = (short) 4;
    }

    public interface FileSource {
        public static final short DSC = (short) 3;
    }

    public interface Flash {
        public static final short DID_NOT_FIRED = (short) 0;
        public static final short FIRED = (short) 1;
        public static final short FUNCTION_NO_FUNCTION = (short) 32;
        public static final short FUNCTION_PRESENT = (short) 0;
        public static final short MODE_AUTO_MODE = (short) 24;
        public static final short MODE_COMPULSORY_FLASH_FIRING = (short) 8;
        public static final short MODE_COMPULSORY_FLASH_SUPPRESSION = (short) 16;
        public static final short MODE_UNKNOWN = (short) 0;
        public static final short RED_EYE_REDUCTION_NO_OR_UNKNOWN = (short) 0;
        public static final short RED_EYE_REDUCTION_SUPPORT = (short) 64;
        public static final short RETURN_NO_STROBE_RETURN_DETECTION_FUNCTION = (short) 0;
        public static final short RETURN_STROBE_RETURN_LIGHT_DETECTED = (short) 6;
        public static final short RETURN_STROBE_RETURN_LIGHT_NOT_DETECTED = (short) 4;
    }

    public interface GainControl {
        public static final short HIGH_DOWN = (short) 4;
        public static final short HIGH_UP = (short) 2;
        public static final short LOW_DOWN = (short) 3;
        public static final short LOW_UP = (short) 1;
        public static final short NONE = (short) 0;
    }

    public interface GpsAltitudeRef {
        public static final short SEA_LEVEL = (short) 0;
        public static final short SEA_LEVEL_NEGATIVE = (short) 1;
    }

    public interface GpsDifferential {
        public static final short DIFFERENTIAL_CORRECTION_APPLIED = (short) 1;
        public static final short WITHOUT_DIFFERENTIAL_CORRECTION = (short) 0;
    }

    public interface GpsLatitudeRef {
        public static final String NORTH = "N";
        public static final String SOUTH = "S";
    }

    public interface GpsLongitudeRef {
        public static final String EAST = "E";
        public static final String WEST = "W";
    }

    public interface GpsMeasureMode {
        public static final String MODE_2_DIMENSIONAL = "2";
        public static final String MODE_3_DIMENSIONAL = "3";
    }

    public interface GpsSpeedRef {
        public static final String KILOMETERS = "K";
        public static final String KNOTS = "N";
        public static final String MILES = "M";
    }

    public interface GpsStatus {
        public static final String INTEROPERABILITY = "V";
        public static final String IN_PROGRESS = "A";
    }

    public interface GpsTrackRef {
        public static final String MAGNETIC_DIRECTION = "M";
        public static final String TRUE_DIRECTION = "T";
    }

    public interface LightSource {
        public static final short CLOUDY_WEATHER = (short) 10;
        public static final short COOL_WHITE_FLUORESCENT = (short) 14;
        public static final short D50 = (short) 23;
        public static final short D55 = (short) 20;
        public static final short D65 = (short) 21;
        public static final short D75 = (short) 22;
        public static final short DAYLIGHT = (short) 1;
        public static final short DAYLIGHT_FLUORESCENT = (short) 12;
        public static final short DAY_WHITE_FLUORESCENT = (short) 13;
        public static final short FINE_WEATHER = (short) 9;
        public static final short FLASH = (short) 4;
        public static final short FLUORESCENT = (short) 2;
        public static final short ISO_STUDIO_TUNGSTEN = (short) 24;
        public static final short OTHER = (short) 255;
        public static final short SHADE = (short) 11;
        public static final short STANDARD_LIGHT_A = (short) 17;
        public static final short STANDARD_LIGHT_B = (short) 18;
        public static final short STANDARD_LIGHT_C = (short) 19;
        public static final short TUNGSTEN = (short) 3;
        public static final short UNKNOWN = (short) 0;
        public static final short WHITE_FLUORESCENT = (short) 15;
    }

    public interface MeteringMode {
        public static final short AVERAGE = (short) 1;
        public static final short CENTER_WEIGHTED_AVERAGE = (short) 2;
        public static final short MULTISPOT = (short) 4;
        public static final short OTHER = (short) 255;
        public static final short PARTAIL = (short) 6;
        public static final short PATTERN = (short) 5;
        public static final short SPOT = (short) 3;
        public static final short UNKNOWN = (short) 0;
    }

    public interface Orientation {
        public static final short BOTTOM_LEFT = (short) 3;
        public static final short BOTTOM_RIGHT = (short) 4;
        public static final short LEFT_BOTTOM = (short) 7;
        public static final short LEFT_TOP = (short) 5;
        public static final short RIGHT_BOTTOM = (short) 8;
        public static final short RIGHT_TOP = (short) 6;
        public static final short TOP_LEFT = (short) 1;
        public static final short TOP_RIGHT = (short) 2;
    }

    public interface PhotometricInterpretation {
        public static final short RGB = (short) 2;
        public static final short YCBCR = (short) 6;
    }

    public interface PlanarConfiguration {
        public static final short CHUNKY = (short) 1;
        public static final short PLANAR = (short) 2;
    }

    public interface ResolutionUnit {
        public static final short CENTIMETERS = (short) 3;
        public static final short INCHES = (short) 2;
    }

    public interface Saturation {
        public static final short HIGH = (short) 2;
        public static final short LOW = (short) 1;
        public static final short NORMAL = (short) 0;
    }

    public interface SceneCapture {
        public static final short LANDSCAPE = (short) 1;
        public static final short NIGHT_SCENE = (short) 3;
        public static final short PROTRAIT = (short) 2;
        public static final short STANDARD = (short) 0;
    }

    public interface SceneType {
        public static final short DIRECT_PHOTOGRAPHED = (short) 1;
    }

    public interface SensingMethod {
        public static final short COLOR_SEQUENTIAL_AREA = (short) 5;
        public static final short COLOR_SEQUENTIAL_LINEAR = (short) 8;
        public static final short NOT_DEFINED = (short) 1;
        public static final short ONE_CHIP_COLOR = (short) 2;
        public static final short THREE_CHIP_COLOR = (short) 4;
        public static final short TRILINEAR = (short) 7;
        public static final short TWO_CHIP_COLOR = (short) 3;
    }

    public interface Sharpness {
        public static final short HARD = (short) 2;
        public static final short NORMAL = (short) 0;
        public static final short SOFT = (short) 1;
    }

    public interface SubjectDistance {
        public static final short CLOSE_VIEW = (short) 2;
        public static final short DISTANT_VIEW = (short) 3;
        public static final short MACRO = (short) 1;
        public static final short UNKNOWN = (short) 0;
    }

    public interface WhiteBalance {
        public static final short AUTO = (short) 0;
        public static final short MANUAL = (short) 1;
    }

    public interface YCbCrPositioning {
        public static final short CENTERED = (short) 1;
        public static final short CO_SITED = (short) 2;
    }

    static {
        TYPE_TO_SIZE_MAP[1] = 1;
        TYPE_TO_SIZE_MAP[2] = 1;
        TYPE_TO_SIZE_MAP[3] = 2;
        TYPE_TO_SIZE_MAP[4] = 4;
        TYPE_TO_SIZE_MAP[5] = 8;
        TYPE_TO_SIZE_MAP[7] = 1;
        TYPE_TO_SIZE_MAP[9] = 4;
        TYPE_TO_SIZE_MAP[10] = 8;
    }

    ExifTag(short s, short s2, int i, int i2) {
        this.mTagId = s;
        this.mDataType = s2;
        this.mComponentCount = i;
        this.mComponentCountDefined = getComponentCountDefined(s, i2);
        this.mIfd = i2;
    }

    public static ExifTag buildInteroperabilityTag(short s) {
        Integer num = (Integer) getInteroperTagInfo().get(s);
        if (num != null && getIfdIdFromInfo(num.intValue()) == 3) {
            return new ExifTag(s, getTypeFromInfo(num.intValue()), getComponentCountFromInfo(num.intValue()), 3);
        }
        throw new RuntimeException("Unknown Interoperability Tag ID: " + s);
    }

    public static ExifTag buildTag(short s) {
        Integer num = (Integer) getTagInfo().get(s);
        if (num != null) {
            return new ExifTag(s, getTypeFromInfo(num.intValue()), getComponentCountFromInfo(num.intValue()), getIfdIdFromInfo(num.intValue()));
        }
        throw new IllegalArgumentException("Unknown Tag ID: " + s);
    }

    public static ExifTag buildThumbnailTag(short s) {
        Integer num = (Integer) getTagInfo().get(s);
        if (num != null && getIfdIdFromInfo(num.intValue()) == 0) {
            return new ExifTag(s, getTypeFromInfo(num.intValue()), getComponentCountFromInfo(num.intValue()), 1);
        }
        throw new IllegalArgumentException("Unknown Thumnail Tag ID: " + s);
    }

    private void checkComponentCountOrThrow(int i) {
        if (this.mComponentCountDefined && this.mComponentCount != i) {
            throw new IllegalArgumentException("Tag " + this.mTagId + ": Required " + this.mComponentCount + " components but was given " + i + " component(s)");
        }
    }

    private void checkOverflowForRational(Rational[] rationalArr) {
        for (Rational rational : rationalArr) {
            if (rational.getNominator() < LONG_MIN || rational.getDenominator() < LONG_MIN || rational.getNominator() > LONG_MAX || rational.getDenominator() > LONG_MAX) {
                throw new IllegalArgumentException("Tag " + this.mTagId + ": Value" + rational + " is illegal for type RATIONAL");
            }
        }
    }

    private void checkOverflowForUnsignedLong(int[] iArr) {
        for (int i : iArr) {
            if (i < 0) {
                throw new IllegalArgumentException("Tag " + this.mTagId + ": Value" + i + " is illegal for type UNSIGNED_LONG");
            }
        }
    }

    private void checkOverflowForUnsignedLong(long[] jArr) {
        for (long j : jArr) {
            if (j < 0 || j > UNSIGNED_LONG_MAX) {
                throw new IllegalArgumentException("Tag " + this.mTagId + ": Value" + j + " is illegal for type UNSIGNED_LONG");
            }
        }
    }

    private void checkOverflowForUnsignedRational(Rational[] rationalArr) {
        for (Rational rational : rationalArr) {
            if (rational.getNominator() < 0 || rational.getDenominator() < 0 || rational.getNominator() > UNSIGNED_LONG_MAX || rational.getDenominator() > UNSIGNED_LONG_MAX) {
                throw new IllegalArgumentException("Tag " + this.mTagId + ": Value" + rational + " is illegal for type UNSIGNED_RATIONAL");
            }
        }
    }

    private void checkOverflowForUnsignedShort(int[] iArr) {
        for (int i : iArr) {
            if (i > 65535 || i < 0) {
                throw new IllegalArgumentException("Tag " + this.mTagId + ": Value" + i + " is illegal for type UNSIGNED_SHORT");
            }
        }
    }

    private static String convertTypeToString(short s) {
        switch (s) {
            case (short) 1:
                return "UNSIGNED_BYTE";
            case (short) 2:
                return "ASCII";
            case (short) 3:
                return "UNSIGNED_SHORT";
            case (short) 4:
                return "UNSIGNED_LONG";
            case (short) 5:
                return "UNSIGNED_RATIONAL";
            case (short) 7:
                return "UNDEFINED";
            case (short) 9:
                return "LONG";
            case (short) 10:
                return "RATIONAL";
            default:
                return "";
        }
    }

    private static boolean getComponentCountDefined(short s, int i) {
        Integer num = i == 3 ? (Integer) getInteroperTagInfo().get(s) : (Integer) getTagInfo().get(s);
        if (num == null) {
            return false;
        }
        return getComponentCountFromInfo(num.intValue()) != 0;
    }

    private static int getComponentCountFromInfo(int i) {
        return 65535 & i;
    }

    public static int getElementSize(short s) {
        return TYPE_TO_SIZE_MAP[s];
    }

    private static int getIfdIdFromInfo(int i) {
        return (i >> 24) & 255;
    }

    static int getIfdIdFromTagId(short s) {
        Integer num = (Integer) getTagInfo().get(s);
        if (num != null) {
            return getIfdIdFromInfo(num.intValue());
        }
        throw new IllegalArgumentException("Unknown Tag ID: " + s);
    }

    private static SparseArray<Integer> getInteroperTagInfo() {
        if (sInteroperTagInfo == null) {
            synchronized (ExifTag.class) {
                if (sInteroperTagInfo == null) {
                    sInteroperTagInfo = new SparseArray();
                    sInteroperTagInfo.put(1, Integer.valueOf(50462720));
                }
            }
        }
        return sInteroperTagInfo;
    }

    private static SparseArray<Integer> getTagInfo() {
        if (sTagInfo == null) {
            synchronized (ExifTag.class) {
                if (sTagInfo == null) {
                    sTagInfo = new SparseArray();
                    initTagInfo();
                }
            }
        }
        return sTagInfo;
    }

    private static short getTypeFromInfo(int i) {
        return (short) ((i >> 16) & 255);
    }

    private static void initTagInfo() {
        sTagInfo.put(271, Integer.valueOf(131072));
        sTagInfo.put(256, Integer.valueOf(262145));
        sTagInfo.put(InputDeviceCompat.SOURCE_KEYBOARD, Integer.valueOf(262145));
        sTagInfo.put(258, Integer.valueOf(196611));
        sTagInfo.put(259, Integer.valueOf(196609));
        sTagInfo.put(262, Integer.valueOf(196609));
        sTagInfo.put(274, Integer.valueOf(196609));
        sTagInfo.put(277, Integer.valueOf(196609));
        sTagInfo.put(284, Integer.valueOf(196609));
        sTagInfo.put(530, Integer.valueOf(196610));
        sTagInfo.put(531, Integer.valueOf(196609));
        sTagInfo.put(282, Integer.valueOf(327681));
        sTagInfo.put(283, Integer.valueOf(327681));
        sTagInfo.put(296, Integer.valueOf(196609));
        sTagInfo.put(273, Integer.valueOf(262144));
        sTagInfo.put(278, Integer.valueOf(262145));
        sTagInfo.put(279, Integer.valueOf(262144));
        sTagInfo.put(InputDeviceCompat.SOURCE_DPAD, Integer.valueOf(262145));
        sTagInfo.put(514, Integer.valueOf(262145));
        sTagInfo.put(301, Integer.valueOf(197376));
        sTagInfo.put(318, Integer.valueOf(327682));
        sTagInfo.put(319, Integer.valueOf(327686));
        sTagInfo.put(529, Integer.valueOf(327683));
        sTagInfo.put(532, Integer.valueOf(327686));
        sTagInfo.put(306, Integer.valueOf(131092));
        sTagInfo.put(270, Integer.valueOf(131072));
        sTagInfo.put(271, Integer.valueOf(131072));
        sTagInfo.put(272, Integer.valueOf(131072));
        sTagInfo.put(305, Integer.valueOf(131072));
        sTagInfo.put(315, Integer.valueOf(131072));
        sTagInfo.put(-32104, Integer.valueOf(131072));
        sTagInfo.put(-30871, Integer.valueOf(262145));
        sTagInfo.put(-30683, Integer.valueOf(262145));
        sTagInfo.put(-28672, Integer.valueOf(34013188));
        sTagInfo.put(-24576, Integer.valueOf(34013188));
        sTagInfo.put(-24575, Integer.valueOf(33751041));
        sTagInfo.put(-28415, Integer.valueOf(34013188));
        sTagInfo.put(-28414, Integer.valueOf(33882113));
        sTagInfo.put(-24574, Integer.valueOf(33816577));
        sTagInfo.put(-24573, Integer.valueOf(33816577));
        sTagInfo.put(-28036, Integer.valueOf(34013184));
        sTagInfo.put(-28026, Integer.valueOf(34013184));
        sTagInfo.put(-24572, Integer.valueOf(33685517));
        sTagInfo.put(-28669, Integer.valueOf(33685524));
        sTagInfo.put(-28668, Integer.valueOf(33685524));
        sTagInfo.put(-28016, Integer.valueOf(33685504));
        sTagInfo.put(-28015, Integer.valueOf(33685504));
        sTagInfo.put(-28014, Integer.valueOf(33685504));
        sTagInfo.put(-23520, Integer.valueOf(33685537));
        sTagInfo.put(-32102, Integer.valueOf(33882113));
        sTagInfo.put(-32099, Integer.valueOf(33882113));
        sTagInfo.put(-30686, Integer.valueOf(33751041));
        sTagInfo.put(-30684, Integer.valueOf(33685504));
        sTagInfo.put(-30681, Integer.valueOf(33751040));
        sTagInfo.put(-30680, Integer.valueOf(34013184));
        sTagInfo.put(-28159, Integer.valueOf(34209793));
        sTagInfo.put(-28158, Integer.valueOf(33882113));
        sTagInfo.put(-28157, Integer.valueOf(34209793));
        sTagInfo.put(-28156, Integer.valueOf(34209793));
        sTagInfo.put(-28155, Integer.valueOf(33882113));
        sTagInfo.put(-28154, Integer.valueOf(33882113));
        sTagInfo.put(-28153, Integer.valueOf(33751041));
        sTagInfo.put(-28152, Integer.valueOf(33751041));
        sTagInfo.put(-28151, Integer.valueOf(33751041));
        sTagInfo.put(-28150, Integer.valueOf(33882113));
        sTagInfo.put(-28140, Integer.valueOf(33751040));
        sTagInfo.put(-24053, Integer.valueOf(33882113));
        sTagInfo.put(-24052, Integer.valueOf(34013184));
        sTagInfo.put(-24050, Integer.valueOf(33882113));
        sTagInfo.put(-24049, Integer.valueOf(33882113));
        sTagInfo.put(-24048, Integer.valueOf(33751041));
        sTagInfo.put(-24044, Integer.valueOf(33751042));
        sTagInfo.put(-24043, Integer.valueOf(33882113));
        sTagInfo.put(-24041, Integer.valueOf(33751041));
        sTagInfo.put(-23808, Integer.valueOf(34013185));
        sTagInfo.put(-23807, Integer.valueOf(34013185));
        sTagInfo.put(-23806, Integer.valueOf(34013184));
        sTagInfo.put(-23551, Integer.valueOf(33751041));
        sTagInfo.put(-23550, Integer.valueOf(33751041));
        sTagInfo.put(-23549, Integer.valueOf(33751041));
        sTagInfo.put(-23548, Integer.valueOf(33882113));
        sTagInfo.put(-23547, Integer.valueOf(33751041));
        sTagInfo.put(-23546, Integer.valueOf(33751041));
        sTagInfo.put(-23545, Integer.valueOf(33882113));
        sTagInfo.put(-23544, Integer.valueOf(33751041));
        sTagInfo.put(-23543, Integer.valueOf(33751041));
        sTagInfo.put(-23542, Integer.valueOf(33751041));
        sTagInfo.put(-23541, Integer.valueOf(34013184));
        sTagInfo.put(-23540, Integer.valueOf(33751041));
        sTagInfo.put(0, Integer.valueOf(67174404));
        sTagInfo.put(1, Integer.valueOf(67239938));
        sTagInfo.put(3, Integer.valueOf(67239938));
        sTagInfo.put(2, Integer.valueOf(67764227));
        sTagInfo.put(4, Integer.valueOf(67764227));
        sTagInfo.put(5, Integer.valueOf(67174401));
        sTagInfo.put(6, Integer.valueOf(67436545));
        sTagInfo.put(7, Integer.valueOf(67436547));
        sTagInfo.put(8, Integer.valueOf(67239936));
        sTagInfo.put(9, Integer.valueOf(67239938));
        sTagInfo.put(10, Integer.valueOf(67239938));
        sTagInfo.put(11, Integer.valueOf(67436545));
        sTagInfo.put(12, Integer.valueOf(67239938));
        sTagInfo.put(13, Integer.valueOf(67436545));
        sTagInfo.put(14, Integer.valueOf(67239938));
        sTagInfo.put(15, Integer.valueOf(67436545));
        sTagInfo.put(16, Integer.valueOf(67239938));
        sTagInfo.put(17, Integer.valueOf(67436545));
        sTagInfo.put(18, Integer.valueOf(67239936));
        sTagInfo.put(19, Integer.valueOf(67239938));
        sTagInfo.put(20, Integer.valueOf(67436545));
        sTagInfo.put(23, Integer.valueOf(67239938));
        sTagInfo.put(24, Integer.valueOf(67436545));
        sTagInfo.put(25, Integer.valueOf(67239938));
        sTagInfo.put(26, Integer.valueOf(67436545));
        sTagInfo.put(27, Integer.valueOf(67567616));
        sTagInfo.put(28, Integer.valueOf(67567616));
        sTagInfo.put(29, Integer.valueOf(67239947));
        sTagInfo.put(30, Integer.valueOf(67305483));
    }

    static boolean isOffsetTag(short s) {
        return s == TAG_EXIF_IFD || s == TAG_GPS_IFD || s == TAG_JPEG_INTERCHANGE_FORMAT || s == TAG_STRIP_OFFSETS || s == TAG_INTEROPERABILITY_IFD;
    }

    private void throwTypeNotMatchedException(String str) {
        throw new IllegalArgumentException("Tag " + this.mTagId + ": expect type " + convertTypeToString(this.mDataType) + " but got " + str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExifTag)) {
            return false;
        }
        ExifTag exifTag = (ExifTag) obj;
        return this.mValue != null ? this.mValue instanceof long[] ? !(exifTag.mValue instanceof long[]) ? false : Arrays.equals((long[]) this.mValue, (long[]) exifTag.mValue) : this.mValue instanceof Rational[] ? exifTag.mValue instanceof Rational[] ? Arrays.equals((Rational[]) this.mValue, (Rational[]) exifTag.mValue) : false : this.mValue instanceof byte[] ? exifTag.mValue instanceof byte[] ? Arrays.equals((byte[]) this.mValue, (byte[]) exifTag.mValue) : false : this.mValue.equals(exifTag.mValue) : exifTag.mValue == null;
    }

    public void getBytes(byte[] bArr) {
        getBytes(bArr, 0, bArr.length);
    }

    public void getBytes(byte[] bArr, int i, int i2) {
        if (this.mDataType == (short) 7 || this.mDataType == (short) 1) {
            Object obj = this.mValue;
            if (i2 > this.mComponentCount) {
                i2 = this.mComponentCount;
            }
            System.arraycopy(obj, 0, bArr, i, i2);
            return;
        }
        throw new IllegalArgumentException("Cannot get BYTE value from " + convertTypeToString(this.mDataType));
    }

    public int getComponentCount() {
        return this.mComponentCount;
    }

    public int getDataSize() {
        return getComponentCount() * getElementSize(getDataType());
    }

    public short getDataType() {
        return this.mDataType;
    }

    public int getIfd() {
        return this.mIfd;
    }

    public int getLong(int i) {
        if (this.mDataType == (short) 9) {
            return (int) ((long[]) this.mValue)[i];
        }
        throw new IllegalArgumentException("Cannot get LONG value from " + convertTypeToString(this.mDataType));
    }

    public int getOffset() {
        return this.mOffset;
    }

    public Rational getRational(int i) {
        if (this.mDataType == (short) 10 || this.mDataType == (short) 5) {
            return ((Rational[]) this.mValue)[i];
        }
        throw new IllegalArgumentException("Cannot get RATIONAL value from " + convertTypeToString(this.mDataType));
    }

    public String getString() {
        if (this.mDataType == (short) 2) {
            return (String) this.mValue;
        }
        throw new IllegalArgumentException("Cannot get ASCII value from " + convertTypeToString(this.mDataType));
    }

    public short getTagId() {
        return this.mTagId;
    }

    public long getUnsignedLong(int i) {
        if (this.mDataType == (short) 4) {
            return ((long[]) this.mValue)[i];
        }
        throw new IllegalArgumentException("Cannot get UNSIGNED LONG value from " + convertTypeToString(this.mDataType));
    }

    public int getUnsignedShort(int i) {
        if (this.mDataType == (short) 3) {
            return (int) ((long[]) this.mValue)[i];
        }
        throw new IllegalArgumentException("Cannot get UNSIGNED_SHORT value from " + convertTypeToString(this.mDataType));
    }

    public boolean hasValue() {
        return this.mValue != null;
    }

    void setOffset(int i) {
        this.mOffset = i;
    }

    public void setTimeValue(long j) {
        synchronized (TIME_FORMAT) {
            setValue(TIME_FORMAT.format(new Date(j)));
        }
    }

    public void setValue(int i) {
        checkComponentCountOrThrow(1);
        setValue(new int[]{i});
    }

    public void setValue(long j) {
        setValue(new long[]{j});
    }

    public void setValue(Rational rational) {
        setValue(new Rational[]{rational});
    }

    public void setValue(String str) {
        checkComponentCountOrThrow(str.length() + 1);
        if (this.mDataType != (short) 2) {
            throwTypeNotMatchedException("String");
        }
        this.mComponentCount = str.length() + 1;
        this.mValue = str;
    }

    public void setValue(byte[] bArr) {
        setValue(bArr, 0, bArr.length);
    }

    public void setValue(byte[] bArr, int i, int i2) {
        checkComponentCountOrThrow(i2);
        if (!(this.mDataType == (short) 1 || this.mDataType == (short) 7)) {
            throwTypeNotMatchedException("byte");
        }
        this.mValue = new byte[i2];
        System.arraycopy(bArr, i, this.mValue, 0, i2);
        this.mComponentCount = i2;
    }

    public void setValue(int[] iArr) {
        checkComponentCountOrThrow(iArr.length);
        if (!(this.mDataType == (short) 3 || this.mDataType == (short) 9 || this.mDataType == (short) 4)) {
            throwTypeNotMatchedException("int");
        }
        if (this.mDataType == (short) 3) {
            checkOverflowForUnsignedShort(iArr);
        } else if (this.mDataType == (short) 4) {
            checkOverflowForUnsignedLong(iArr);
        }
        Object obj = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            obj[i] = (long) iArr[i];
        }
        this.mValue = obj;
        this.mComponentCount = iArr.length;
    }

    public void setValue(long[] jArr) {
        checkComponentCountOrThrow(jArr.length);
        if (this.mDataType != (short) 4) {
            throwTypeNotMatchedException("long");
        }
        checkOverflowForUnsignedLong(jArr);
        this.mValue = jArr;
        this.mComponentCount = jArr.length;
    }

    public void setValue(Rational[] rationalArr) {
        if (this.mDataType == (short) 5) {
            checkOverflowForUnsignedRational(rationalArr);
        } else if (this.mDataType == (short) 10) {
            checkOverflowForRational(rationalArr);
        } else {
            throwTypeNotMatchedException("Rational");
        }
        checkComponentCountOrThrow(rationalArr.length);
        this.mValue = rationalArr;
        this.mComponentCount = rationalArr.length;
    }

    public String valueToString() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int i2;
        switch (getDataType()) {
            case (short) 1:
            case (short) 7:
                getBytes(new byte[getComponentCount()]);
                int componentCount = getComponentCount();
                for (i2 = 0; i2 < componentCount; i2++) {
                    if (i2 != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(r3[i2])}));
                }
                break;
            case (short) 2:
                stringBuilder.append(getString());
                break;
            case (short) 3:
                i2 = getComponentCount();
                while (i < i2) {
                    if (i != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(getUnsignedShort(i));
                    i++;
                }
                break;
            case (short) 4:
                i2 = getComponentCount();
                while (i < i2) {
                    if (i != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(getUnsignedLong(i));
                    i++;
                }
                break;
            case (short) 5:
            case (short) 10:
                i2 = getComponentCount();
                while (i < i2) {
                    Rational rational = getRational(i);
                    if (i != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(rational.getNominator()).append("/").append(rational.getDenominator());
                    i++;
                }
                break;
            case (short) 9:
                i2 = getComponentCount();
                while (i < i2) {
                    if (i != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(getLong(i));
                    i++;
                }
                break;
        }
        return stringBuilder.toString();
    }
}
