package com.android.gallery3d.app;

import android.view.View;

public interface ControllerOverlay {

    public interface Listener {
        void onHidden();

        void onPlayPause();

        void onReplay();

        void onSeekEnd(int i, int i2, int i3);

        void onSeekMove(int i);

        void onSeekStart();

        void onShown();
    }

    View getView();

    void setCanReplay(boolean z);

    void setListener(Listener listener);

    void setTimes(int i, int i2, int i3, int i4);

    void show();

    void showEnded();

    void showErrorMessage(String str);

    void showLoading();

    void showPaused();

    void showPlaying();
}
