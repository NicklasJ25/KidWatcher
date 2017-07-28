package com.android.gallery3d.ui;

import android.os.Handler;
import android.os.Message;
import com.android.gallery3d.common.Utils;

public class SynchronizedHandler extends Handler {
    private final GLRoot mRoot;

    public SynchronizedHandler(GLRoot gLRoot) {
        this.mRoot = (GLRoot) Utils.checkNotNull(gLRoot);
    }

    public void dispatchMessage(Message message) {
        this.mRoot.lockRenderThread();
        try {
            super.dispatchMessage(message);
        } finally {
            this.mRoot.unlockRenderThread();
        }
    }
}
