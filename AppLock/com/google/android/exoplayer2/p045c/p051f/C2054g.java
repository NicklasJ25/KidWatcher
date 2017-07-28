package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2090h;

public abstract class C2054g {

    public interface C2059b {
        C2054g mo2992a(int i, C2062a c2062a);
    }

    public static final class C2062a {
        public final int f5681a;
        public String f5682b;
        public byte[] f5683c;

        public C2062a(int i, String str, byte[] bArr) {
            this.f5681a = i;
            this.f5682b = str;
            this.f5683c = bArr;
        }
    }

    public static final class C2063c {
        private final int f5684a;
        private final int f5685b;
        private int f5686c;

        public C2063c(int i, int i2) {
            this.f5684a = i;
            this.f5685b = i2;
        }

        public int m6212a() {
            int i = this.f5684a;
            int i2 = this.f5685b;
            int i3 = this.f5686c;
            this.f5686c = i3 + 1;
            return i + (i2 * i3);
        }
    }

    public abstract void mo2987a();

    public abstract void mo2988a(long j, boolean z);

    public abstract void mo2989a(C2090h c2090h, C2063c c2063c);

    public abstract void mo2990a(C2263k c2263k);

    public abstract void mo2991b();
}
