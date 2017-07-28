package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.media.AudioManager;
import com.domobile.applock.chamber.model.FileInfo;
import java.util.Map;

public class C1718k {
    public static float m4931a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(FileInfo.MIME_AUDIO);
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume > 0) {
                return (((float) streamVolume) * 1.0f) / ((float) streamMaxVolume);
            }
        }
        return 0.0f;
    }

    public static void m4932a(Map<String, String> map, boolean z, boolean z2) {
        map.put("autoplay", z ? "1" : "0");
        map.put("inline", z2 ? "1" : "0");
    }
}
