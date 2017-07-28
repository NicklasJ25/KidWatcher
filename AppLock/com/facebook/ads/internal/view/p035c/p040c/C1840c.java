package com.facebook.ads.internal.view.p035c.p040c;

import android.net.Uri;
import android.view.View;

public interface C1840c {
    void mo2789a(boolean z);

    void mo2793c();

    void mo2794d();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    C1847d getState();

    C1847d getTargetState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void pause();

    void seekTo(int i);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(C1848e c1848e);

    void setup(Uri uri);

    void start();
}
