package com.android.camera.gallery;

import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.data.MediaObject;
import com.android.gallery3d.data.MediaSource;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.data.PathMatcher;
import com.domobile.frame.p000a.C1147a;

public class C0455e extends MediaSource {
    private GalleryApp f226a;
    private PathMatcher f227b = new PathMatcher();

    public C0455e(GalleryApp galleryApp) {
        super("applock");
        this.f226a = galleryApp;
        this.f227b.add("/applock/*", 1);
    }

    public MediaObject createMediaObject(Path path) {
        String[] split = path.split();
        if (split.length >= 2) {
            return this.f227b.match(path) == 1 ? new C0454d(path, this.f226a, split[1]) : null;
        } else {
            throw new RuntimeException("bad path: " + path);
        }
    }

    public Path getDefaultSetOf(Path path) {
        int length = path.split().length;
        String str = "";
        for (int i = 0; i < length - 1; i++) {
            str = C1147a.m2480a(str, "/", r3[i]);
        }
        return Path.fromString(str);
    }
}
