package com.google.android.exoplayer2.p041a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class C1927b {
    public static final C1927b f4974a = new C1927b(new int[]{2}, 2);
    private final int[] f4975b;
    private final int f4976c;

    C1927b(int[] iArr, int i) {
        if (iArr != null) {
            this.f4975b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f4975b);
        } else {
            this.f4975b = new int[0];
        }
        this.f4976c = i;
    }

    public static C1927b m5504a(Context context) {
        return C1927b.m5505a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static C1927b m5505a(Intent intent) {
        return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f4974a : new C1927b(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public boolean m5506a(int i) {
        return Arrays.binarySearch(this.f4975b, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1927b)) {
            return false;
        }
        C1927b c1927b = (C1927b) obj;
        return Arrays.equals(this.f4975b, c1927b.f4975b) && this.f4976c == c1927b.f4976c;
    }

    public int hashCode() {
        return this.f4976c + (Arrays.hashCode(this.f4975b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f4976c + ", supportedEncodings=" + Arrays.toString(this.f4975b) + "]";
    }
}
