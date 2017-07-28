package com.google.android.gms.internal;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.internal.pc.C3145a;

public final class pq extends C3145a {
    private final VideoLifecycleCallbacks f10240a;

    public pq(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f10240a = videoLifecycleCallbacks;
    }

    public void mo3877a() {
    }

    public void mo3878b() {
    }

    public void mo3879c() {
    }

    public void mo3880d() {
        this.f10240a.onVideoEnd();
    }
}
