package com.google.android.exoplayer2.p056i;

import android.text.TextUtils;
import com.google.android.exoplayer2.p043j.C2243m;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p056i.C2222f.C2228a;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface C2237p extends C2222f {
    public static final C2243m<String> f6369a = new C22441();

    public interface C2239a extends C2228a {
    }

    static class C22441 implements C2243m<String> {
        C22441() {
        }

        public boolean m7002a(String str) {
            String d = C2273r.m7141d(str);
            return (TextUtils.isEmpty(d) || ((d.contains("text") && !d.contains("text/vtt")) || d.contains("html") || d.contains("xml"))) ? false : true;
        }
    }

    public static class C2245b extends IOException {
        public final int f6397a;
        public final C2230h f6398b;

        public C2245b(IOException iOException, C2230h c2230h, int i) {
            super(iOException);
            this.f6398b = c2230h;
            this.f6397a = i;
        }

        public C2245b(String str, C2230h c2230h, int i) {
            super(str);
            this.f6398b = c2230h;
            this.f6397a = i;
        }

        public C2245b(String str, IOException iOException, C2230h c2230h, int i) {
            super(str, iOException);
            this.f6398b = c2230h;
            this.f6397a = i;
        }
    }

    public static final class C2246c extends C2245b {
        public final String f6399c;

        public C2246c(String str, C2230h c2230h) {
            super("Invalid content type: " + str, c2230h, 1);
            this.f6399c = str;
        }
    }

    public static final class C2247d extends C2245b {
        public final int f6400c;
        public final Map<String, List<String>> f6401d;

        public C2247d(int i, Map<String, List<String>> map, C2230h c2230h) {
            super("Response code: " + i, c2230h, 1);
            this.f6400c = i;
            this.f6401d = map;
        }
    }
}
