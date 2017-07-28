package com.android.camera.gallery;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;

public class C0466m implements C0382g {
    private C0450f f250a;
    private Uri f251b;

    public C0466m(ContentResolver contentResolver, Uri uri) {
        this.f251b = uri;
        this.f250a = new C0467n(this, contentResolver, uri);
    }

    public C0450f mo2036a(int i) {
        return i == 0 ? this.f250a : null;
    }

    public void mo2037a() {
        this.f250a = null;
        this.f251b = null;
    }

    public HashMap<String, String> mo2038b() {
        throw new UnsupportedOperationException();
    }

    public int mo2039c() {
        return 1;
    }
}
