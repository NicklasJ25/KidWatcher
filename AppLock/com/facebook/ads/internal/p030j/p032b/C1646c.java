package com.facebook.ads.internal.p030j.p032b;

import com.facebook.ads.internal.p030j.p032b.p033a.C1634a;
import com.facebook.ads.internal.p030j.p032b.p033a.C1637c;
import java.io.File;

class C1646c {
    public final File f4051a;
    public final C1637c f4052b;
    public final C1634a f4053c;

    C1646c(File file, C1637c c1637c, C1634a c1634a) {
        this.f4051a = file;
        this.f4052b = c1637c;
        this.f4053c = c1634a;
    }

    File m4635a(String str) {
        return new File(this.f4051a, this.f4052b.mo2767a(str));
    }
}
