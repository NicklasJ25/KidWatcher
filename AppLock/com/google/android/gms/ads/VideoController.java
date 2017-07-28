package com.google.android.gms.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pq;
import com.google.android.gms.internal.wh;

@wh
public final class VideoController {
    private final Object f6683a = new Object();
    @Nullable
    private pb f6684b;
    @Nullable
    private VideoLifecycleCallbacks f6685c;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    public float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.f6683a) {
            if (this.f6684b == null) {
            } else {
                try {
                    f = this.f6684b.mo3457g();
                } catch (Throwable e) {
                    aad.m8422b("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.f6683a) {
            videoLifecycleCallbacks = this.f6685c;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.f6683a) {
            z = this.f6684b != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        C2513c.m7933a((Object) videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f6683a) {
            this.f6685c = videoLifecycleCallbacks;
            if (this.f6684b == null) {
                return;
            }
            try {
                this.f6684b.mo3450a(new pq(videoLifecycleCallbacks));
            } catch (Throwable e) {
                aad.m8422b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void zza(pb pbVar) {
        synchronized (this.f6683a) {
            this.f6684b = pbVar;
            if (this.f6685c != null) {
                setVideoLifecycleCallbacks(this.f6685c);
            }
        }
    }

    public pb zzbs() {
        pb pbVar;
        synchronized (this.f6683a) {
            pbVar = this.f6684b;
        }
        return pbVar;
    }
}
