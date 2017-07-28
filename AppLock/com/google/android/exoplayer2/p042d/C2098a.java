package com.google.android.exoplayer2.p042d;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2258h;
import com.google.android.exoplayer2.p043j.C2273r;

@TargetApi(16)
public final class C2098a {
    public final String f5901a;
    public final boolean f5902b;
    private final String f5903c;
    private final CodecCapabilities f5904d;

    private C2098a(String str, String str2, CodecCapabilities codecCapabilities) {
        this.f5901a = (String) C2252a.m7020a((Object) str);
        this.f5903c = str2;
        this.f5904d = codecCapabilities;
        boolean z = codecCapabilities != null && C2098a.m6378a(codecCapabilities);
        this.f5902b = z;
    }

    public static C2098a m6376a(String str) {
        return new C2098a(str, null, null);
    }

    public static C2098a m6377a(String str, String str2, CodecCapabilities codecCapabilities) {
        return new C2098a(str, str2, codecCapabilities);
    }

    private static boolean m6378a(CodecCapabilities codecCapabilities) {
        return C2273r.f6478a >= 19 && C2098a.m6379b(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean m6379b(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    @TargetApi(21)
    public boolean m6380a(int i) {
        if (this.f5904d == null) {
            return false;
        }
        AudioCapabilities audioCapabilities = this.f5904d.getAudioCapabilities();
        return audioCapabilities != null && audioCapabilities.isSampleRateSupported(i);
    }

    @TargetApi(21)
    public boolean m6381a(int i, int i2) {
        if (this.f5904d == null) {
            return false;
        }
        VideoCapabilities videoCapabilities = this.f5904d.getVideoCapabilities();
        return videoCapabilities != null && videoCapabilities.isSizeSupported(i, i2);
    }

    @TargetApi(21)
    public boolean m6382a(int i, int i2, double d) {
        if (this.f5904d == null) {
            return false;
        }
        VideoCapabilities videoCapabilities = this.f5904d.getVideoCapabilities();
        return videoCapabilities != null && videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    public CodecProfileLevel[] m6383a() {
        return (this.f5904d == null || this.f5904d.profileLevels == null) ? new CodecProfileLevel[0] : this.f5904d.profileLevels;
    }

    @TargetApi(21)
    public boolean m6384b(int i) {
        if (this.f5904d == null) {
            return false;
        }
        AudioCapabilities audioCapabilities = this.f5904d.getAudioCapabilities();
        return audioCapabilities != null && audioCapabilities.getMaxInputChannelCount() >= i;
    }

    public boolean m6385b(String str) {
        if (str == null || this.f5903c == null) {
            return true;
        }
        String d = C2258h.m7046d(str);
        if (d == null) {
            return true;
        }
        if (!this.f5903c.equals(d)) {
            return false;
        }
        Pair a = C2108d.m6406a(str);
        if (a == null) {
            return true;
        }
        for (CodecProfileLevel codecProfileLevel : m6383a()) {
            if (codecProfileLevel.profile == ((Integer) a.first).intValue() && codecProfileLevel.level >= ((Integer) a.second).intValue()) {
                return true;
            }
        }
        return false;
    }
}
