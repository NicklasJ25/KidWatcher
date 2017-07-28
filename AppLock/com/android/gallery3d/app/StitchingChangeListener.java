package com.android.gallery3d.app;

import android.net.Uri;

public interface StitchingChangeListener {
    void onStitchingProgress(Uri uri, int i);

    void onStitchingQueued(Uri uri);

    void onStitchingResult(Uri uri);
}
