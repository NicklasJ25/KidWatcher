package com.android.gallery3d.ui;

import com.android.gallery3d.ui.GLRoot.OnGLIdleListener;
import java.util.ArrayDeque;

public class TextureUploader implements OnGLIdleListener {
    private static final int INIT_CAPACITY = 64;
    private static final int QUOTA_PER_FRAME = 1;
    private final ArrayDeque<UploadedTexture> mBgTextures = new ArrayDeque(64);
    private final ArrayDeque<UploadedTexture> mFgTextures = new ArrayDeque(64);
    private final GLRoot mGLRoot;
    private volatile boolean mIsQueued = false;

    public TextureUploader(GLRoot gLRoot) {
        this.mGLRoot = gLRoot;
    }

    private void queueSelfIfNeed() {
        if (!this.mIsQueued) {
            this.mIsQueued = true;
            this.mGLRoot.addOnGLIdleListener(this);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int upload(com.android.gallery3d.ui.GLCanvas r4, java.util.ArrayDeque<com.android.gallery3d.ui.UploadedTexture> r5, int r6, boolean r7) {
        /*
        r3 = this;
        r2 = 0;
    L_0x0001:
        if (r6 <= 0) goto L_0x000b;
    L_0x0003:
        monitor-enter(r3);
        r0 = r5.isEmpty();	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
    L_0x000b:
        return r6;
    L_0x000c:
        r0 = r5.removeFirst();	 Catch:{ all -> 0x001e }
        r0 = (com.android.gallery3d.ui.UploadedTexture) r0;	 Catch:{ all -> 0x001e }
        r1 = 0;
        r0.setIsUploading(r1);	 Catch:{ all -> 0x001e }
        r1 = r0.isContentValid();	 Catch:{ all -> 0x001e }
        if (r1 == 0) goto L_0x0021;
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
        goto L_0x0001;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
        throw r0;
    L_0x0021:
        r0.updateContent(r4);	 Catch:{ all -> 0x001e }
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
        if (r7 == 0) goto L_0x002a;
    L_0x0027:
        r0.draw(r4, r2, r2);
    L_0x002a:
        r6 = r6 + -1;
        goto L_0x0001;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.TextureUploader.upload(com.android.gallery3d.ui.GLCanvas, java.util.ArrayDeque, int, boolean):int");
    }

    public synchronized void addBgTexture(UploadedTexture uploadedTexture) {
        if (!uploadedTexture.isContentValid()) {
            this.mBgTextures.addLast(uploadedTexture);
            uploadedTexture.setIsUploading(true);
            queueSelfIfNeed();
        }
    }

    public synchronized void addFgTexture(UploadedTexture uploadedTexture) {
        if (!uploadedTexture.isContentValid()) {
            this.mFgTextures.addLast(uploadedTexture);
            uploadedTexture.setIsUploading(true);
            queueSelfIfNeed();
        }
    }

    public synchronized void clear() {
        while (!this.mFgTextures.isEmpty()) {
            ((UploadedTexture) this.mFgTextures.pop()).setIsUploading(false);
        }
        while (!this.mBgTextures.isEmpty()) {
            ((UploadedTexture) this.mBgTextures.pop()).setIsUploading(false);
        }
    }

    public boolean onGLIdle(GLCanvas gLCanvas, boolean z) {
        boolean z2 = false;
        int upload = upload(gLCanvas, this.mFgTextures, 1, false);
        if (upload < 1) {
            this.mGLRoot.requestRender();
        }
        upload(gLCanvas, this.mBgTextures, upload, true);
        synchronized (this) {
            if (!(this.mFgTextures.isEmpty() && this.mBgTextures.isEmpty())) {
                z2 = true;
            }
            this.mIsQueued = z2;
            z2 = this.mIsQueued;
        }
        return z2;
    }
}
