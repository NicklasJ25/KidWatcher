package com.domobile.cropimage;

import android.content.ContentResolver;
import android.net.Uri;

public class C1211p implements C1175g {
    private C1177f f2386a;
    private Uri f2387b;

    public C1211p(ContentResolver contentResolver, Uri uri) {
        this.f2387b = uri;
        this.f2386a = new C1212q(this, contentResolver, uri);
    }

    public C1177f mo2505a(int i) {
        return i == 0 ? this.f2386a : null;
    }

    public C1177f mo2506a(Uri uri) {
        return uri.equals(this.f2387b) ? this.f2386a : null;
    }

    public void mo2507a() {
        this.f2386a = null;
        this.f2387b = null;
    }

    public int mo2508b() {
        return 1;
    }
}
