package com.google.android.exoplayer2.p043j;

import com.domobile.applock.chamber.model.FileInfo;

public final class C2258h {
    public static boolean m7043a(String str) {
        return C2258h.m7047e(str).equals(FileInfo.MIME_AUDIO);
    }

    public static boolean m7044b(String str) {
        return C2258h.m7047e(str).equals("video");
    }

    public static boolean m7045c(String str) {
        return C2258h.m7047e(str).equals("text");
    }

    public static String m7046d(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return (trim.startsWith("avc1") || trim.startsWith("avc3")) ? "video/avc" : (trim.startsWith("hev1") || trim.startsWith("hvc1")) ? "video/hevc" : trim.startsWith("vp9") ? "video/x-vnd.on2.vp9" : trim.startsWith("vp8") ? "video/x-vnd.on2.vp8" : trim.startsWith("mp4a") ? "audio/mp4a-latm" : (trim.startsWith("ac-3") || trim.startsWith("dac3")) ? "audio/ac3" : (trim.startsWith("ec-3") || trim.startsWith("dec3")) ? "audio/eac3" : (trim.startsWith("dtsc") || trim.startsWith("dtse")) ? "audio/vnd.dts" : (trim.startsWith("dtsh") || trim.startsWith("dtsl")) ? "audio/vnd.dts.hd" : trim.startsWith("opus") ? "audio/opus" : trim.startsWith("vorbis") ? "audio/vorbis" : null;
    }

    private static String m7047e(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }
}
