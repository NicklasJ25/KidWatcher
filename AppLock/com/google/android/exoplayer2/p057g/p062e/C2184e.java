package com.google.android.exoplayer2.p057g.p062e;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.google.android.exoplayer2.p057g.C2167b;

final class C2184e extends C2167b {
    public final long f6157i;
    public final long f6158j;

    static /* synthetic */ class C21821 {
        static final /* synthetic */ int[] f6146a = new int[Alignment.values().length];

        static {
            try {
                f6146a[Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6146a[Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6146a[Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static final class C2183a {
        private long f6147a;
        private long f6148b;
        private SpannableStringBuilder f6149c;
        private Alignment f6150d;
        private float f6151e;
        private int f6152f;
        private int f6153g;
        private float f6154h;
        private int f6155i;
        private float f6156j;

        public C2183a() {
            m6770a();
        }

        private C2183a m6764c() {
            if (this.f6150d != null) {
                switch (C21821.f6146a[this.f6150d.ordinal()]) {
                    case 1:
                        this.f6155i = 0;
                        break;
                    case 2:
                        this.f6155i = 1;
                        break;
                    case 3:
                        this.f6155i = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.f6150d);
                        this.f6155i = 0;
                        break;
                }
            }
            this.f6155i = Integer.MIN_VALUE;
            return this;
        }

        public C2183a m6765a(float f) {
            this.f6151e = f;
            return this;
        }

        public C2183a m6766a(int i) {
            this.f6152f = i;
            return this;
        }

        public C2183a m6767a(long j) {
            this.f6147a = j;
            return this;
        }

        public C2183a m6768a(Alignment alignment) {
            this.f6150d = alignment;
            return this;
        }

        public C2183a m6769a(SpannableStringBuilder spannableStringBuilder) {
            this.f6149c = spannableStringBuilder;
            return this;
        }

        public void m6770a() {
            this.f6147a = 0;
            this.f6148b = 0;
            this.f6149c = null;
            this.f6150d = null;
            this.f6151e = Float.MIN_VALUE;
            this.f6152f = Integer.MIN_VALUE;
            this.f6153g = Integer.MIN_VALUE;
            this.f6154h = Float.MIN_VALUE;
            this.f6155i = Integer.MIN_VALUE;
            this.f6156j = Float.MIN_VALUE;
        }

        public C2183a m6771b(float f) {
            this.f6154h = f;
            return this;
        }

        public C2183a m6772b(int i) {
            this.f6153g = i;
            return this;
        }

        public C2183a m6773b(long j) {
            this.f6148b = j;
            return this;
        }

        public C2184e m6774b() {
            if (this.f6154h != Float.MIN_VALUE && this.f6155i == Integer.MIN_VALUE) {
                m6764c();
            }
            return new C2184e(this.f6147a, this.f6148b, this.f6149c, this.f6150d, this.f6151e, this.f6152f, this.f6153g, this.f6154h, this.f6155i, this.f6156j);
        }

        public C2183a m6775c(float f) {
            this.f6156j = f;
            return this;
        }

        public C2183a m6776c(int i) {
            this.f6155i = i;
            return this;
        }
    }

    public C2184e(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public C2184e(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.f6157i = j;
        this.f6158j = j2;
    }

    public C2184e(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public boolean m6777a() {
        return this.c == Float.MIN_VALUE && this.f == Float.MIN_VALUE;
    }
}
