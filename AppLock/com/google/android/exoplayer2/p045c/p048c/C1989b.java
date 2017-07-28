package com.google.android.exoplayer2.p045c.p048c;

import android.support.v4.media.TransportMediator;
import android.util.Pair;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2091j;
import java.nio.charset.Charset;

final class C1989b {
    private static final int f5283a = C2273r.m7142e("ID3");
    private static final Charset[] f5284b = new Charset[]{Charset.forName("ISO-8859-1"), Charset.forName("UTF-16LE"), Charset.forName("UTF-16BE"), Charset.forName("UTF-8")};

    private static Pair<String, String> m5885a(int i, C2263k c2263k) {
        int k;
        int h;
        while (true) {
            if (i == 2) {
                if (c2263k.m7070b() < 6) {
                    return null;
                }
                String a = c2263k.m7064a(3, Charset.forName("US-ASCII"));
                if (a.equals("\u0000\u0000\u0000")) {
                    return null;
                }
                k = c2263k.m7083k();
                if (k == 0 || k > c2263k.m7070b()) {
                    return null;
                }
                if (a.equals("COM")) {
                    break;
                }
                c2263k.m7075d(k);
            } else if (c2263k.m7070b() < 10) {
                return null;
            } else {
                String a2 = c2263k.m7064a(4, Charset.forName("US-ASCII"));
                if (a2.equals("\u0000\u0000\u0000\u0000")) {
                    return null;
                }
                k = i == 4 ? c2263k.m7091s() : c2263k.m7092t();
                if (k == 0 || k > c2263k.m7070b() - 2) {
                    return null;
                }
                h = c2263k.m7080h();
                h = ((i != 4 || (h & 12) == 0) && (i != 3 || (h & 192) == 0)) ? 0 : 1;
                if (h == 0 && a2.equals("COMM")) {
                    break;
                }
                c2263k.m7075d(k);
            }
        }
        h = c2263k.m7079g();
        if (h < 0 || h >= f5284b.length) {
            return null;
        }
        String[] split = c2263k.m7064a(k - 1, f5284b[h]).split("\u0000");
        return split.length == 2 ? Pair.create(split[0], split[1]) : null;
    }

    public static void m5886a(C1985g c1985g, C2091j c2091j) {
        C2263k c2263k = new C2263k(10);
        int i = 0;
        while (true) {
            c1985g.mo2969c(c2263k.f6454a, 0, 10);
            c2263k.m7073c(0);
            if (c2263k.m7083k() != f5283a) {
                c1985g.mo2961a();
                c1985g.mo2968c(i);
                return;
            }
            int g = c2263k.m7079g();
            int g2 = c2263k.m7079g();
            int g3 = c2263k.m7079g();
            int s = c2263k.m7091s();
            if (c2091j.m6346a() || !C1989b.m5889a(g, g2, g3, s)) {
                c1985g.mo2968c(s);
            } else {
                byte[] bArr = new byte[s];
                c1985g.mo2969c(bArr, 0, s);
                C1989b.m5887a(new C2263k(bArr), g, g3, c2091j);
            }
            i += s + 10;
        }
    }

    private static void m5887a(C2263k c2263k, int i, int i2, C2091j c2091j) {
        C1989b.m5890a(c2263k, i, i2);
        c2263k.m7073c(0);
        int s;
        if (i != 3 || (i2 & 64) == 0) {
            if (i == 4 && (i2 & 64) != 0) {
                if (c2263k.m7070b() >= 4) {
                    s = c2263k.m7091s();
                    if (s >= 6 && s <= c2263k.m7070b() + 4) {
                        c2263k.m7073c(s);
                    } else {
                        return;
                    }
                }
                return;
            }
        } else if (c2263k.m7070b() >= 4) {
            s = c2263k.m7092t();
            if (s <= c2263k.m7070b()) {
                if (s >= 6) {
                    c2263k.m7075d(2);
                    int t = c2263k.m7092t();
                    c2263k.m7073c(4);
                    c2263k.m7071b(c2263k.m7072c() - t);
                    if (c2263k.m7070b() < s) {
                        return;
                    }
                }
                c2263k.m7075d(s);
            } else {
                return;
            }
        } else {
            return;
        }
        while (true) {
            Pair a = C1989b.m5885a(i, c2263k);
            if (a == null) {
                return;
            }
            if (((String) a.first).length() > 3 && c2091j.m6348a(((String) a.first).substring(3), (String) a.second)) {
                return;
            }
        }
    }

    private static void m5888a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >> 21) & TransportMediator.KEYCODE_MEDIA_PAUSE);
        bArr[i + 1] = (byte) ((i2 >> 14) & TransportMediator.KEYCODE_MEDIA_PAUSE);
        bArr[i + 2] = (byte) ((i2 >> 7) & TransportMediator.KEYCODE_MEDIA_PAUSE);
        bArr[i + 3] = (byte) (i2 & TransportMediator.KEYCODE_MEDIA_PAUSE);
    }

    private static boolean m5889a(int i, int i2, int i3, int i4) {
        return i2 != 255 && i >= 2 && i <= 4 && i4 <= 3145728 && ((i != 2 || ((i3 & 63) == 0 && (i3 & 64) == 0)) && ((i != 3 || (i3 & 31) == 0) && (i != 4 || (i3 & 15) == 0)));
    }

    private static boolean m5890a(C2263k c2263k, int i, int i2) {
        if (i != 4) {
            if ((i2 & 128) != 0) {
                Object obj = c2263k.f6454a;
                int length = obj.length;
                int i3 = false;
                while (i3 + 1 < length) {
                    if ((obj[i3] & 255) == 255 && obj[i3 + 1] == (byte) 0) {
                        System.arraycopy(obj, i3 + 2, obj, i3 + 1, (length - i3) - 2);
                        length--;
                    }
                    i3++;
                }
                c2263k.m7071b(length);
            }
        } else if (C1989b.m5891a(c2263k, false)) {
            C1989b.m5892b(c2263k, false);
        } else if (!C1989b.m5891a(c2263k, true)) {
            return false;
        } else {
            C1989b.m5892b(c2263k, true);
        }
        return true;
    }

    private static boolean m5891a(C2263k c2263k, boolean z) {
        c2263k.m7073c(0);
        while (c2263k.m7070b() >= 10) {
            if (c2263k.m7086n() == 0) {
                return true;
            }
            long l = c2263k.m7084l();
            if (!z) {
                if ((8421504 & l) != 0) {
                    return false;
                }
                l = (((l >> 24) & 127) << 21) | (((l & 127) | (((l >> 8) & 127) << 7)) | (((l >> 16) & 127) << 14));
            }
            if (l > ((long) (c2263k.m7070b() - 2))) {
                return false;
            }
            if ((c2263k.m7080h() & 1) != 0 && c2263k.m7070b() < 4) {
                return false;
            }
            c2263k.m7075d((int) l);
        }
        return true;
    }

    private static void m5892b(C2263k c2263k, boolean z) {
        c2263k.m7073c(0);
        byte[] bArr = c2263k.f6454a;
        while (c2263k.m7070b() >= 10 && c2263k.m7086n() != 0) {
            int d;
            int i;
            int t = z ? c2263k.m7092t() : c2263k.m7091s();
            int h = c2263k.m7080h();
            if ((h & 1) != 0) {
                d = c2263k.m7074d();
                System.arraycopy(bArr, d + 4, bArr, d, c2263k.m7070b() - 4);
                d = t - 4;
                i = h & -2;
                c2263k.m7071b(c2263k.m7072c() - 4);
            } else {
                i = h;
                d = t;
            }
            if ((i & 2) != 0) {
                t = c2263k.m7074d() + 1;
                int i2 = 0;
                int i3 = t;
                while (i2 + 1 < d) {
                    if ((bArr[t - 1] & 255) == 255 && bArr[t] == (byte) 0) {
                        t++;
                        d--;
                    }
                    int i4 = i3 + 1;
                    int i5 = t + 1;
                    bArr[i3] = bArr[t];
                    i2++;
                    i3 = i4;
                    t = i5;
                }
                c2263k.m7071b(c2263k.m7072c() - (t - i3));
                System.arraycopy(bArr, t, bArr, i3, c2263k.m7070b() - t);
                t = i & -3;
            } else {
                t = i;
            }
            if (t != h || z) {
                i = c2263k.m7074d() - 6;
                C1989b.m5888a(bArr, i, d);
                bArr[i + 4] = (byte) (t >> 8);
                bArr[i + 5] = (byte) (t & 255);
            }
            c2263k.m7075d(d);
        }
    }
}
