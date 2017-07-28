package com.google.android.exoplayer2.p045c.p051f;

import android.support.v4.media.TransportMediator;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2059b;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2062a;

public final class C2060e implements C2059b {
    private final int f5670a;

    public C2060e() {
        this(0);
    }

    public C2060e(int i) {
        this.f5670a = i;
    }

    public C2054g mo2992a(int i, C2062a c2062a) {
        boolean z = true;
        switch (i) {
            case 2:
                return new C2065h();
            case 3:
            case 4:
                return new C2073l(c2062a.f5682b);
            case 15:
                return (this.f5670a & 2) == 0 ? new C2058d(false, c2062a.f5682b) : null;
            case 21:
                return new C2072k();
            case 27:
                if ((this.f5670a & 4) != 0) {
                    return null;
                }
                boolean z2 = (this.f5670a & 1) != 0;
                if ((this.f5670a & 8) == 0) {
                    z = false;
                }
                return new C2069i(z2, z);
            case 36:
                return new C2071j();
            case 129:
            case 135:
                return new C2055b(c2062a.f5682b);
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 138:
                return new C2061f(c2062a.f5682b);
            default:
                return null;
        }
    }
}
