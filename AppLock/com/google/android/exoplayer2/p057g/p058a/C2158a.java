package com.google.android.exoplayer2.p057g.p058a;

import android.support.v4.media.TransportMediator;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2160j;
import com.google.android.exoplayer2.p057g.C2167b;
import com.google.android.exoplayer2.p057g.C2194i;

public final class C2158a extends C2157b {
    private static final int[] f6037a = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] f6038b = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] f6039c = new int[]{193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] f6040d = new int[]{195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, TransportMediator.KEYCODE_MEDIA_PLAY, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final C2263k f6041e = new C2263k();
    private final StringBuilder f6042f = new StringBuilder();
    private int f6043g;
    private int f6044h;
    private String f6045i;
    private String f6046j;
    private boolean f6047k;
    private byte f6048l;
    private byte f6049m;

    public C2158a() {
        m6597a(0);
        this.f6044h = 4;
    }

    private void m6596a(byte b) {
        switch (b) {
            case (byte) 32:
                m6597a(2);
                return;
            case (byte) 37:
                this.f6044h = 2;
                m6597a(1);
                return;
            case (byte) 38:
                this.f6044h = 3;
                m6597a(1);
                return;
            case (byte) 39:
                this.f6044h = 4;
                m6597a(1);
                return;
            case (byte) 41:
                m6597a(3);
                return;
            default:
                if (this.f6043g != 0) {
                    switch (b) {
                        case (byte) 33:
                            if (this.f6042f.length() > 0) {
                                this.f6042f.setLength(this.f6042f.length() - 1);
                                return;
                            }
                            return;
                        case (byte) 44:
                            this.f6045i = null;
                            if (this.f6043g == 1 || this.f6043g == 3) {
                                this.f6042f.setLength(0);
                                return;
                            }
                            return;
                        case (byte) 45:
                            m6608j();
                            return;
                        case (byte) 46:
                            this.f6042f.setLength(0);
                            return;
                        case (byte) 47:
                            this.f6045i = m6609k();
                            this.f6042f.setLength(0);
                            return;
                        default:
                            return;
                    }
                }
                return;
        }
    }

    private void m6597a(int i) {
        if (this.f6043g != i) {
            this.f6043g = i;
            this.f6042f.setLength(0);
            if (i == 1 || i == 0) {
                this.f6045i = null;
            }
        }
    }

    private boolean m6598a(byte b, byte b2) {
        boolean f = C2158a.m6606f(b);
        if (f) {
            if (this.f6047k && this.f6048l == b && this.f6049m == b2) {
                this.f6047k = false;
                return true;
            }
            this.f6047k = true;
            this.f6048l = b;
            this.f6049m = b2;
        }
        if (C2158a.m6601b(b, b2)) {
            m6596a(b2);
        } else if (C2158a.m6603c(b, b2)) {
            m6608j();
        }
        return f;
    }

    public static boolean m6599a(int i, int i2, C2263k c2263k) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int d = c2263k.m7074d();
        int g = c2263k.m7079g();
        int h = c2263k.m7080h();
        int n = c2263k.m7086n();
        int g2 = c2263k.m7079g();
        c2263k.m7073c(d);
        return g == 181 && h == 49 && n == 1195456820 && g2 == 3;
    }

    private static char m6600b(byte b) {
        return (char) f6037a[(b & TransportMediator.KEYCODE_MEDIA_PAUSE) - 32];
    }

    private static boolean m6601b(byte b, byte b2) {
        return (b == (byte) 20 || b == (byte) 28) && b2 >= (byte) 32 && b2 <= (byte) 47;
    }

    private static char m6602c(byte b) {
        return (char) f6038b[b & 15];
    }

    private static boolean m6603c(byte b, byte b2) {
        return b >= (byte) 16 && b <= (byte) 31 && b2 >= (byte) 64 && b2 <= Byte.MAX_VALUE;
    }

    private static char m6604d(byte b) {
        return (char) f6039c[b & 31];
    }

    private static char m6605e(byte b) {
        return (char) f6040d[b & 31];
    }

    private static boolean m6606f(byte b) {
        return b >= (byte) 16 && b <= (byte) 31;
    }

    private void m6607i() {
        if (this.f6042f.length() > 0) {
            this.f6042f.setLength(this.f6042f.length() - 1);
        }
    }

    private void m6608j() {
        int length = this.f6042f.length();
        if (length > 0 && this.f6042f.charAt(length - 1) != '\n') {
            this.f6042f.append('\n');
        }
    }

    private String m6609k() {
        int length = this.f6042f.length();
        if (length == 0) {
            return null;
        }
        int i = this.f6042f.charAt(length + -1) == '\n' ? 1 : 0;
        if (length == 1 && i != 0) {
            return null;
        }
        if (i != 0) {
            length--;
        }
        if (this.f6043g != 1) {
            return this.f6042f.substring(0, length);
        }
        int i2;
        i = length;
        for (i2 = 0; i2 < this.f6044h && i != -1; i2++) {
            i = this.f6042f.lastIndexOf("\n", i - 1);
        }
        i2 = i != -1 ? i + 1 : 0;
        this.f6042f.delete(0, i2);
        return this.f6042f.substring(0, length - i2);
    }

    protected void mo3045a(C2194i c2194i) {
        this.f6041e.m7068a(c2194i.b.array(), c2194i.b.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.f6041e.m7070b() > 0) {
            byte g = (byte) (this.f6041e.m7079g() & TransportMediator.KEYCODE_MEDIA_PAUSE);
            byte g2 = (byte) (this.f6041e.m7079g() & TransportMediator.KEYCODE_MEDIA_PAUSE);
            if (((byte) (this.f6041e.m7079g() & 7)) == (byte) 4 && !(g == (byte) 0 && g2 == (byte) 0)) {
                if ((g == (byte) 17 || g == (byte) 25) && (g2 & 112) == 48) {
                    this.f6042f.append(C2158a.m6602c(g2));
                    z2 = true;
                } else {
                    if ((g2 & 96) == 32) {
                        if (g == (byte) 18 || g == (byte) 26) {
                            m6607i();
                            this.f6042f.append(C2158a.m6604d(g2));
                            z2 = true;
                        } else if (g == (byte) 19 || g == (byte) 27) {
                            m6607i();
                            this.f6042f.append(C2158a.m6605e(g2));
                            z2 = true;
                        }
                    }
                    if (g < (byte) 32) {
                        z = m6598a(g, g2);
                        z2 = true;
                    } else {
                        this.f6042f.append(C2158a.m6600b(g));
                        if (g2 >= (byte) 32) {
                            this.f6042f.append(C2158a.m6600b(g2));
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.f6047k = false;
            }
            if (this.f6043g == 1 || this.f6043g == 3) {
                this.f6045i = m6609k();
            }
        }
    }

    public void mo2935c() {
        super.mo2935c();
        m6597a(0);
        this.f6044h = 4;
        this.f6042f.setLength(0);
        this.f6045i = null;
        this.f6046j = null;
        this.f6047k = false;
        this.f6048l = (byte) 0;
        this.f6049m = (byte) 0;
    }

    public void mo2936d() {
    }

    protected boolean mo3047e() {
        return !TextUtils.equals(this.f6045i, this.f6046j);
    }

    protected C2159e mo3048f() {
        this.f6046j = this.f6045i;
        return new C2162d(new C2167b(this.f6045i));
    }

    public /* bridge */ /* synthetic */ C2160j mo3049g() {
        return super.mo3049g();
    }

    public /* bridge */ /* synthetic */ C2194i mo3050h() {
        return super.mo3050h();
    }
}
