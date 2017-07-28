package com.google.android.exoplayer2.p045c.p047b;

import android.util.SparseArray;
import com.google.android.exoplayer2.C1961b;
import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p043j.C2257f;
import com.google.android.exoplayer2.p043j.C2258h;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1973a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p064k.C2275a;
import com.google.android.exoplayer2.p064k.C2276b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class C1982d implements C1966f {
    public static final C1964i f5215a = new C19791();
    private static final byte[] f5216b = new byte[]{(byte) 49, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, (byte) 45, (byte) 45, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    private static final byte[] f5217c = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static final UUID f5218d = new UUID(72057594037932032L, -9223371306706625679L);
    private boolean f5219A;
    private long f5220B;
    private long f5221C;
    private long f5222D;
    private C2257f f5223E;
    private C2257f f5224F;
    private boolean f5225G;
    private int f5226H;
    private long f5227I;
    private long f5228J;
    private int f5229K;
    private int f5230L;
    private int[] f5231M;
    private int f5232N;
    private int f5233O;
    private int f5234P;
    private int f5235Q;
    private boolean f5236R;
    private boolean f5237S;
    private boolean f5238T;
    private boolean f5239U;
    private byte f5240V;
    private int f5241W;
    private int f5242X;
    private int f5243Y;
    private boolean f5244Z;
    private boolean aa;
    private C2090h ab;
    private final C1976b f5245e;
    private final C1984f f5246f;
    private final SparseArray<C1981b> f5247g;
    private final C2263k f5248h;
    private final C2263k f5249i;
    private final C2263k f5250j;
    private final C2263k f5251k;
    private final C2263k f5252l;
    private final C2263k f5253m;
    private final C2263k f5254n;
    private final C2263k f5255o;
    private final C2263k f5256p;
    private ByteBuffer f5257q;
    private long f5258r;
    private long f5259s;
    private long f5260t;
    private long f5261u;
    private long f5262v;
    private C1981b f5263w;
    private boolean f5264x;
    private int f5265y;
    private long f5266z;

    static class C19791 implements C1964i {
        C19791() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C1982d()};
        }
    }

    private final class C1980a implements C1978c {
        final /* synthetic */ C1982d f5188a;

        private C1980a(C1982d c1982d) {
            this.f5188a = c1982d;
        }

        public int mo2951a(int i) {
            return this.f5188a.m5828a(i);
        }

        public void mo2952a(int i, double d) {
            this.f5188a.m5830a(i, d);
        }

        public void mo2953a(int i, int i2, C1985g c1985g) {
            this.f5188a.m5831a(i, i2, c1985g);
        }

        public void mo2954a(int i, long j) {
            this.f5188a.m5832a(i, j);
        }

        public void mo2955a(int i, long j, long j2) {
            this.f5188a.m5833a(i, j, j2);
        }

        public void mo2956a(int i, String str) {
            this.f5188a.m5834a(i, str);
        }

        public boolean mo2957b(int i) {
            return this.f5188a.m5838b(i);
        }

        public void mo2958c(int i) {
            this.f5188a.m5840c(i);
        }
    }

    private static final class C1981b {
        public String f5189a;
        public int f5190b;
        public int f5191c;
        public int f5192d;
        public boolean f5193e;
        public byte[] f5194f;
        public byte[] f5195g;
        public byte[] f5196h;
        public DrmInitData f5197i;
        public int f5198j;
        public int f5199k;
        public int f5200l;
        public int f5201m;
        public int f5202n;
        public byte[] f5203o;
        public int f5204p;
        public int f5205q;
        public int f5206r;
        public int f5207s;
        public long f5208t;
        public long f5209u;
        public boolean f5210v;
        public boolean f5211w;
        public C2025o f5212x;
        public int f5213y;
        private String f5214z;

        private C1981b() {
            this.f5198j = -1;
            this.f5199k = -1;
            this.f5200l = -1;
            this.f5201m = -1;
            this.f5202n = 0;
            this.f5203o = null;
            this.f5204p = -1;
            this.f5205q = 1;
            this.f5206r = -1;
            this.f5207s = 8000;
            this.f5208t = 0;
            this.f5209u = 0;
            this.f5211w = true;
            this.f5214z = "eng";
        }

        private static List<byte[]> m5810a(C2263k c2263k) {
            try {
                c2263k.m7075d(16);
                if (c2263k.m7085m() != 826496599) {
                    return null;
                }
                int d = c2263k.m7074d() + 20;
                byte[] bArr = c2263k.f6454a;
                while (d < bArr.length - 4) {
                    if (bArr[d] == (byte) 0 && bArr[d + 1] == (byte) 0 && bArr[d + 2] == (byte) 1 && bArr[d + 3] == (byte) 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d, bArr.length));
                    }
                    d++;
                }
                throw new C1970k("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new C1970k("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> m5811a(byte[] bArr) {
            int i = 0;
            try {
                if (bArr[0] != (byte) 2) {
                    throw new C1970k("Error parsing vorbis codec private");
                }
                int i2 = 0;
                int i3 = 1;
                while (bArr[i3] == (byte) -1) {
                    i3++;
                    i2 += 255;
                }
                int i4 = i3 + 1;
                i2 += bArr[i3];
                while (bArr[i4] == (byte) -1) {
                    i += 255;
                    i4++;
                }
                i3 = i4 + 1;
                i += bArr[i4];
                if (bArr[i3] != (byte) 1) {
                    throw new C1970k("Error parsing vorbis codec private");
                }
                Object obj = new byte[i2];
                System.arraycopy(bArr, i3, obj, 0, i2);
                i2 += i3;
                if (bArr[i2] != (byte) 3) {
                    throw new C1970k("Error parsing vorbis codec private");
                }
                i += i2;
                if (bArr[i] != (byte) 5) {
                    throw new C1970k("Error parsing vorbis codec private");
                }
                Object obj2 = new byte[(bArr.length - i)];
                System.arraycopy(bArr, i, obj2, 0, bArr.length - i);
                List<byte[]> arrayList = new ArrayList(2);
                arrayList.add(obj);
                arrayList.add(obj2);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new C1970k("Error parsing vorbis codec private");
            }
        }

        private static boolean m5812b(C2263k c2263k) {
            try {
                int i = c2263k.m7081i();
                if (i == 1) {
                    return true;
                }
                if (i != 65534) {
                    return false;
                }
                c2263k.m7073c(24);
                return c2263k.m7088p() == C1982d.f5218d.getMostSignificantBits() && c2263k.m7088p() == C1982d.f5218d.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new C1970k("Error parsing MS/ACM codec private");
            }
        }

        public void m5813a(C2090h c2090h, int i) {
            Format a;
            int i2 = -1;
            int i3 = -1;
            List list = null;
            String str = this.f5189a;
            Object obj = -1;
            switch (str.hashCode()) {
                case -2095576542:
                    if (str.equals("V_MPEG4/ISO/AP")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -2095575984:
                    if (str.equals("V_MPEG4/ISO/SP")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str.equals("A_MS/ACM")) {
                        obj = 21;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str.equals("A_TRUEHD")) {
                        obj = 16;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str.equals("A_VORBIS")) {
                        obj = 10;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str.equals("A_MPEG/L3")) {
                        obj = 13;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str.equals("V_MS/VFW/FOURCC")) {
                        obj = 8;
                        break;
                    }
                    break;
                case -538363189:
                    if (str.equals("V_MPEG4/ISO/ASP")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -538363109:
                    if (str.equals("V_MPEG4/ISO/AVC")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -425012669:
                    if (str.equals("S_VOBSUB")) {
                        obj = 24;
                        break;
                    }
                    break;
                case -356037306:
                    if (str.equals("A_DTS/LOSSLESS")) {
                        obj = 19;
                        break;
                    }
                    break;
                case 62923557:
                    if (str.equals("A_AAC")) {
                        obj = 12;
                        break;
                    }
                    break;
                case 62923603:
                    if (str.equals("A_AC3")) {
                        obj = 14;
                        break;
                    }
                    break;
                case 62927045:
                    if (str.equals("A_DTS")) {
                        obj = 17;
                        break;
                    }
                    break;
                case 82338133:
                    if (str.equals("V_VP8")) {
                        obj = null;
                        break;
                    }
                    break;
                case 82338134:
                    if (str.equals("V_VP9")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 99146302:
                    if (str.equals("S_HDMV/PGS")) {
                        obj = 25;
                        break;
                    }
                    break;
                case 444813526:
                    if (str.equals("V_THEORA")) {
                        obj = 9;
                        break;
                    }
                    break;
                case 542569478:
                    if (str.equals("A_DTS/EXPRESS")) {
                        obj = 18;
                        break;
                    }
                    break;
                case 725957860:
                    if (str.equals("A_PCM/INT/LIT")) {
                        obj = 22;
                        break;
                    }
                    break;
                case 855502857:
                    if (str.equals("V_MPEGH/ISO/HEVC")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str.equals("S_TEXT/UTF8")) {
                        obj = 23;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str.equals("V_MPEG2")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str.equals("A_EAC3")) {
                        obj = 15;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str.equals("A_FLAC")) {
                        obj = 20;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str.equals("A_OPUS")) {
                        obj = 11;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    str = "video/x-vnd.on2.vp8";
                    break;
                case 1:
                    str = "video/x-vnd.on2.vp9";
                    break;
                case 2:
                    str = "video/mpeg2";
                    break;
                case 3:
                case 4:
                case 5:
                    str = "video/mp4v-es";
                    list = this.f5196h == null ? null : Collections.singletonList(this.f5196h);
                    break;
                case 6:
                    str = "video/avc";
                    C2275a a2 = C2275a.m7150a(new C2263k(this.f5196h));
                    list = a2.f6487a;
                    this.f5213y = a2.f6488b;
                    break;
                case 7:
                    str = "video/hevc";
                    C2276b a3 = C2276b.m7152a(new C2263k(this.f5196h));
                    list = a3.f6492a;
                    this.f5213y = a3.f6493b;
                    break;
                case 8:
                    list = C1981b.m5810a(new C2263k(this.f5196h));
                    str = list == null ? "video/x-unknown" : "video/wvc1";
                    break;
                case 9:
                    str = "video/x-unknown";
                    break;
                case 10:
                    str = "audio/vorbis";
                    i2 = 8192;
                    list = C1981b.m5811a(this.f5196h);
                    break;
                case 11:
                    str = "audio/opus";
                    i2 = 5760;
                    list = new ArrayList(3);
                    list.add(this.f5196h);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.f5208t).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.f5209u).array());
                    break;
                case 12:
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.f5196h);
                    break;
                case 13:
                    str = "audio/mpeg";
                    i2 = 4096;
                    break;
                case 14:
                    str = "audio/ac3";
                    break;
                case 15:
                    str = "audio/eac3";
                    break;
                case 16:
                    str = "audio/true-hd";
                    break;
                case 17:
                case 18:
                    str = "audio/vnd.dts";
                    break;
                case 19:
                    str = "audio/vnd.dts.hd";
                    break;
                case 20:
                    str = "audio/x-flac";
                    list = Collections.singletonList(this.f5196h);
                    break;
                case 21:
                    str = "audio/raw";
                    if (C1981b.m5812b(new C2263k(this.f5196h))) {
                        i3 = C2273r.m7124a(this.f5206r);
                        if (i3 == 0) {
                            throw new C1970k("Unsupported PCM bit depth: " + this.f5206r);
                        }
                    }
                    throw new C1970k("Non-PCM MS/ACM is unsupported");
                    break;
                case 22:
                    str = "audio/raw";
                    i3 = C2273r.m7124a(this.f5206r);
                    if (i3 == 0) {
                        throw new C1970k("Unsupported PCM bit depth: " + this.f5206r);
                    }
                    break;
                case 23:
                    str = "application/x-subrip";
                    break;
                case 24:
                    str = "application/vobsub";
                    list = Collections.singletonList(this.f5196h);
                    break;
                case 25:
                    str = "application/pgs";
                    break;
                default:
                    throw new C1970k("Unrecognized codec identifier.");
            }
            int i4 = (0 | (this.f5211w ? 1 : 0)) | (this.f5210v ? 2 : 0);
            if (C2258h.m7043a(str)) {
                a = Format.m5479a(Integer.toString(i), str, null, -1, i2, this.f5205q, this.f5207s, i3, list, this.f5197i, i4, this.f5214z);
            } else if (C2258h.m7044b(str)) {
                if (this.f5202n == 0) {
                    this.f5200l = this.f5200l == -1 ? this.f5198j : this.f5200l;
                    this.f5201m = this.f5201m == -1 ? this.f5199k : this.f5201m;
                }
                float f = -1.0f;
                if (!(this.f5200l == -1 || this.f5201m == -1)) {
                    f = ((float) (this.f5199k * this.f5200l)) / ((float) (this.f5198j * this.f5201m));
                }
                a = Format.m5477a(Integer.toString(i), str, null, -1, i2, this.f5198j, this.f5199k, -1.0f, list, -1, f, this.f5203o, this.f5204p, this.f5197i);
            } else if ("application/x-subrip".equals(str)) {
                a = Format.m5481a(Integer.toString(i), str, null, -1, i4, this.f5214z, this.f5197i);
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str)) {
                a = Format.m5484a(Integer.toString(i), str, null, -1, list, this.f5214z, this.f5197i);
            } else {
                throw new C1970k("Unexpected MIME type.");
            }
            this.f5212x = c2090h.mo3019a(this.f5190b);
            this.f5212x.mo2978a(a);
        }
    }

    public C1982d() {
        this(new C1977a());
    }

    C1982d(C1976b c1976b) {
        this.f5259s = -1;
        this.f5260t = -9223372036854775807L;
        this.f5261u = -9223372036854775807L;
        this.f5262v = -9223372036854775807L;
        this.f5220B = -1;
        this.f5221C = -1;
        this.f5222D = -9223372036854775807L;
        this.f5245e = c1976b;
        this.f5245e.mo2949a(new C1980a());
        this.f5246f = new C1984f();
        this.f5247g = new SparseArray();
        this.f5250j = new C2263k(4);
        this.f5251k = new C2263k(ByteBuffer.allocate(4).putInt(-1).array());
        this.f5252l = new C2263k(4);
        this.f5248h = new C2263k(C2261i.f6446a);
        this.f5249i = new C2263k(4);
        this.f5253m = new C2263k();
        this.f5254n = new C2263k();
        this.f5255o = new C2263k(8);
        this.f5256p = new C2263k();
    }

    private int m5814a(C1985g c1985g, C2025o c2025o, int i) {
        int b = this.f5253m.m7070b();
        if (b > 0) {
            b = Math.min(i, b);
            c2025o.mo2979a(this.f5253m, b);
        } else {
            b = c2025o.mo2976a(c1985g, i, false);
        }
        this.f5235Q += b;
        this.f5243Y += b;
        return b;
    }

    private void m5816a(C1981b c1981b) {
        C1982d.m5821a(this.f5254n.f6454a, this.f5228J);
        c1981b.f5212x.mo2979a(this.f5254n, this.f5254n.m7072c());
        this.f5243Y += this.f5254n.m7072c();
    }

    private void m5817a(C1981b c1981b, long j) {
        if ("S_TEXT/UTF8".equals(c1981b.f5189a)) {
            m5816a(c1981b);
        }
        c1981b.f5212x.mo2977a(j, this.f5234P, this.f5243Y, 0, c1981b.f5195g);
        this.f5244Z = true;
        m5826b();
    }

    private void m5818a(C1985g c1985g, int i) {
        if (this.f5250j.m7072c() < i) {
            if (this.f5250j.m7076e() < i) {
                this.f5250j.m7068a(Arrays.copyOf(this.f5250j.f6454a, Math.max(this.f5250j.f6454a.length * 2, i)), this.f5250j.m7072c());
            }
            c1985g.mo2965b(this.f5250j.f6454a, this.f5250j.m7072c(), i - this.f5250j.m7072c());
            this.f5250j.m7071b(i);
        }
    }

    private void m5819a(C1985g c1985g, C1981b c1981b, int i) {
        int length;
        if ("S_TEXT/UTF8".equals(c1981b.f5189a)) {
            length = f5216b.length + i;
            if (this.f5254n.m7076e() < length) {
                this.f5254n.f6454a = Arrays.copyOf(f5216b, length + i);
            }
            c1985g.mo2965b(this.f5254n.f6454a, f5216b.length, i);
            this.f5254n.m7073c(0);
            this.f5254n.m7071b(length);
            return;
        }
        int t;
        C2025o c2025o = c1981b.f5212x;
        if (!this.f5236R) {
            if (c1981b.f5193e) {
                this.f5234P &= -1073741825;
                if (!this.f5237S) {
                    c1985g.mo2965b(this.f5250j.f6454a, 0, 1);
                    this.f5235Q++;
                    if ((this.f5250j.f6454a[0] & 128) == 128) {
                        throw new C1970k("Extension bit is set in signal byte");
                    }
                    this.f5240V = this.f5250j.f6454a[0];
                    this.f5237S = true;
                }
                if ((this.f5240V & 1) == 1) {
                    boolean z = (this.f5240V & 2) == 2;
                    this.f5234P |= 1073741824;
                    if (!this.f5238T) {
                        c1985g.mo2965b(this.f5255o.f6454a, 0, 8);
                        this.f5235Q += 8;
                        this.f5238T = true;
                        this.f5250j.f6454a[0] = (byte) ((z ? 128 : 0) | 8);
                        this.f5250j.m7073c(0);
                        c2025o.mo2979a(this.f5250j, 1);
                        this.f5243Y++;
                        this.f5255o.m7073c(0);
                        c2025o.mo2979a(this.f5255o, 8);
                        this.f5243Y += 8;
                    }
                    if (z) {
                        if (!this.f5239U) {
                            c1985g.mo2965b(this.f5250j.f6454a, 0, 1);
                            this.f5235Q++;
                            this.f5250j.m7073c(0);
                            this.f5241W = this.f5250j.m7079g();
                            this.f5239U = true;
                        }
                        length = this.f5241W * 4;
                        this.f5250j.m7066a(length);
                        c1985g.mo2965b(this.f5250j.f6454a, 0, length);
                        this.f5235Q = length + this.f5235Q;
                        short s = (short) ((this.f5241W / 2) + 1);
                        int i2 = (s * 6) + 2;
                        if (this.f5257q == null || this.f5257q.capacity() < i2) {
                            this.f5257q = ByteBuffer.allocate(i2);
                        }
                        this.f5257q.position(0);
                        this.f5257q.putShort(s);
                        length = 0;
                        int i3 = 0;
                        while (length < this.f5241W) {
                            t = this.f5250j.m7092t();
                            if (length % 2 == 0) {
                                this.f5257q.putShort((short) (t - i3));
                            } else {
                                this.f5257q.putInt(t - i3);
                            }
                            length++;
                            i3 = t;
                        }
                        length = (i - this.f5235Q) - i3;
                        if (this.f5241W % 2 == 1) {
                            this.f5257q.putInt(length);
                        } else {
                            this.f5257q.putShort((short) length);
                            this.f5257q.putInt(0);
                        }
                        this.f5256p.m7068a(this.f5257q.array(), i2);
                        c2025o.mo2979a(this.f5256p, i2);
                        this.f5243Y += i2;
                    }
                }
            } else if (c1981b.f5194f != null) {
                this.f5253m.m7068a(c1981b.f5194f, c1981b.f5194f.length);
            }
            this.f5236R = true;
        }
        length = this.f5253m.m7072c() + i;
        if ("V_MPEG4/ISO/AVC".equals(c1981b.f5189a) || "V_MPEGH/ISO/HEVC".equals(c1981b.f5189a)) {
            byte[] bArr = this.f5249i.f6454a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            int i4 = c1981b.f5213y;
            t = 4 - c1981b.f5213y;
            while (this.f5235Q < length) {
                if (this.f5242X == 0) {
                    m5820a(c1985g, bArr, t, i4);
                    this.f5249i.m7073c(0);
                    this.f5242X = this.f5249i.m7092t();
                    this.f5248h.m7073c(0);
                    c2025o.mo2979a(this.f5248h, 4);
                    this.f5243Y += 4;
                } else {
                    this.f5242X -= m5814a(c1985g, c2025o, this.f5242X);
                }
            }
        } else {
            while (this.f5235Q < length) {
                m5814a(c1985g, c2025o, length - this.f5235Q);
            }
        }
        if ("A_VORBIS".equals(c1981b.f5189a)) {
            this.f5251k.m7073c(0);
            c2025o.mo2979a(this.f5251k, 4);
            this.f5243Y += 4;
        }
    }

    private void m5820a(C1985g c1985g, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.f5253m.m7070b());
        c1985g.mo2965b(bArr, i + min, i2 - min);
        if (min > 0) {
            this.f5253m.m7069a(bArr, i, min);
        }
        this.f5235Q += i2;
    }

    private static void m5821a(byte[] bArr, long j) {
        Object obj;
        if (j == -9223372036854775807L) {
            obj = f5217c;
        } else {
            long j2 = j - (((long) ((int) (j / 3600000000L))) * 3600000000L);
            j2 -= (long) (60000000 * ((int) (j2 / 60000000)));
            int i = (int) ((j2 - ((long) (1000000 * ((int) (j2 / 1000000))))) / 1000);
            obj = C2273r.m7140c(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf((int) (j / 3600000000L)), Integer.valueOf(r1), Integer.valueOf(r4), Integer.valueOf(i)}));
        }
        System.arraycopy(obj, 0, bArr, 19, 12);
    }

    private boolean m5822a(C2093l c2093l, long j) {
        if (this.f5219A) {
            this.f5221C = j;
            c2093l.f5889a = this.f5220B;
            this.f5219A = false;
            return true;
        } else if (!this.f5264x || this.f5221C == -1) {
            return false;
        } else {
            c2093l.f5889a = this.f5221C;
            this.f5221C = -1;
            return true;
        }
    }

    private static boolean m5823a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str);
    }

    private static int[] m5824a(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }

    private long m5825b(long j) {
        if (this.f5260t == -9223372036854775807L) {
            throw new C1970k("Can't scale timecode prior to timecodeScale being set.");
        }
        return C2273r.m7128a(j, this.f5260t, 1000);
    }

    private void m5826b() {
        this.f5235Q = 0;
        this.f5243Y = 0;
        this.f5242X = 0;
        this.f5236R = false;
        this.f5237S = false;
        this.f5239U = false;
        this.f5241W = 0;
        this.f5240V = (byte) 0;
        this.f5238T = false;
        this.f5253m.m7065a();
    }

    private C1967m m5827d() {
        int i = 0;
        if (this.f5259s == -1 || this.f5262v == -9223372036854775807L || this.f5223E == null || this.f5223E.m7039a() == 0 || this.f5224F == null || this.f5224F.m7039a() != this.f5223E.m7039a()) {
            this.f5223E = null;
            this.f5224F = null;
            return new C2094a(this.f5262v);
        }
        int a = this.f5223E.m7039a();
        int[] iArr = new int[a];
        long[] jArr = new long[a];
        long[] jArr2 = new long[a];
        long[] jArr3 = new long[a];
        for (int i2 = 0; i2 < a; i2++) {
            jArr3[i2] = this.f5223E.m7040a(i2);
            jArr[i2] = this.f5259s + this.f5224F.m7040a(i2);
        }
        while (i < a - 1) {
            iArr[i] = (int) (jArr[i + 1] - jArr[i]);
            jArr2[i] = jArr3[i + 1] - jArr3[i];
            i++;
        }
        iArr[a - 1] = (int) ((this.f5259s + this.f5258r) - jArr[a - 1]);
        jArr2[a - 1] = this.f5262v - jArr3[a - 1];
        this.f5223E = null;
        this.f5224F = null;
        return new C1973a(iArr, jArr, jArr2, jArr3);
    }

    int m5828a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        this.f5244Z = false;
        boolean z = true;
        while (z && !this.f5244Z) {
            z = this.f5245e.mo2950a(c1985g);
            if (z && m5822a(c2093l, c1985g.mo2967c())) {
                return 1;
            }
        }
        return !z ? -1 : 0;
    }

    void m5830a(int i, double d) {
        switch (i) {
            case 181:
                this.f5263w.f5207s = (int) d;
                return;
            case 17545:
                this.f5261u = (long) d;
                return;
            default:
                return;
        }
    }

    void m5831a(int i, int i2, C1985g c1985g) {
        switch (i) {
            case 161:
            case 163:
                if (this.f5226H == 0) {
                    this.f5232N = (int) this.f5246f.m5845a(c1985g, false, true, 8);
                    this.f5233O = this.f5246f.m5847b();
                    this.f5228J = -9223372036854775807L;
                    this.f5226H = 1;
                    this.f5250j.m7065a();
                }
                C1981b c1981b = (C1981b) this.f5247g.get(this.f5232N);
                if (c1981b == null) {
                    c1985g.mo2964b(i2 - this.f5233O);
                    this.f5226H = 0;
                    return;
                }
                if (this.f5226H == 1) {
                    m5818a(c1985g, 3);
                    int i3 = (this.f5250j.f6454a[2] & 6) >> 1;
                    if (i3 == 0) {
                        this.f5230L = 1;
                        this.f5231M = C1982d.m5824a(this.f5231M, 1);
                        this.f5231M[0] = (i2 - this.f5233O) - 3;
                    } else if (i != 163) {
                        throw new C1970k("Lacing only supported in SimpleBlocks.");
                    } else {
                        m5818a(c1985g, 4);
                        this.f5230L = (this.f5250j.f6454a[3] & 255) + 1;
                        this.f5231M = C1982d.m5824a(this.f5231M, this.f5230L);
                        if (i3 == 2) {
                            Arrays.fill(this.f5231M, 0, this.f5230L, ((i2 - this.f5233O) - 4) / this.f5230L);
                        } else if (i3 == 1) {
                            r5 = 0;
                            r4 = 4;
                            for (i3 = 0; i3 < this.f5230L - 1; i3++) {
                                this.f5231M[i3] = 0;
                                do {
                                    r4++;
                                    m5818a(c1985g, r4);
                                    r6 = this.f5250j.f6454a[r4 - 1] & 255;
                                    r7 = this.f5231M;
                                    r7[i3] = r7[i3] + r6;
                                } while (r6 == 255);
                                r5 += this.f5231M[i3];
                            }
                            this.f5231M[this.f5230L - 1] = ((i2 - this.f5233O) - r4) - r5;
                        } else if (i3 == 3) {
                            r5 = 0;
                            r4 = 4;
                            i3 = 0;
                            while (i3 < this.f5230L - 1) {
                                this.f5231M[i3] = 0;
                                r4++;
                                m5818a(c1985g, r4);
                                if (this.f5250j.f6454a[r4 - 1] == (byte) 0) {
                                    throw new C1970k("No valid varint length mask found");
                                }
                                long j = 0;
                                int i4 = 0;
                                while (i4 < 8) {
                                    int i5 = 1 << (7 - i4);
                                    if ((this.f5250j.f6454a[r4 - 1] & i5) != 0) {
                                        int i6 = r4 - 1;
                                        r4 += i4;
                                        m5818a(c1985g, r4);
                                        j = (long) ((this.f5250j.f6454a[i6] & 255) & (i5 ^ -1));
                                        for (i5 = i6 + 1; i5 < r4; i5++) {
                                            j = ((long) (this.f5250j.f6454a[i5] & 255)) | (j << 8);
                                        }
                                        if (i3 > 0) {
                                            j -= (1 << ((i4 * 7) + 6)) - 1;
                                        }
                                        if (j >= -2147483648L || j > 2147483647L) {
                                            throw new C1970k("EBML lacing sample size out of range.");
                                        }
                                        r6 = (int) j;
                                        r7 = this.f5231M;
                                        if (i3 != 0) {
                                            r6 += this.f5231M[i3 - 1];
                                        }
                                        r7[i3] = r6;
                                        r5 += this.f5231M[i3];
                                        i3++;
                                    } else {
                                        i4++;
                                    }
                                }
                                if (j >= -2147483648L) {
                                    break;
                                }
                                throw new C1970k("EBML lacing sample size out of range.");
                            }
                            this.f5231M[this.f5230L - 1] = ((i2 - this.f5233O) - r4) - r5;
                        } else {
                            throw new C1970k("Unexpected lacing value: " + i3);
                        }
                    }
                    this.f5227I = this.f5222D + m5825b((long) ((this.f5250j.f6454a[0] << 8) | (this.f5250j.f6454a[1] & 255)));
                    Object obj = (this.f5250j.f6454a[2] & 8) == 8 ? 1 : null;
                    Object obj2 = (c1981b.f5191c == 2 || (i == 163 && (this.f5250j.f6454a[2] & 128) == 128)) ? 1 : null;
                    this.f5234P = (obj != null ? Integer.MIN_VALUE : 0) | (obj2 != null ? 1 : 0);
                    this.f5226H = 2;
                    this.f5229K = 0;
                }
                if (i == 163) {
                    while (this.f5229K < this.f5230L) {
                        m5819a(c1985g, c1981b, this.f5231M[this.f5229K]);
                        m5817a(c1981b, this.f5227I + ((long) ((this.f5229K * c1981b.f5192d) / 1000)));
                        this.f5229K++;
                    }
                    this.f5226H = 0;
                    return;
                }
                m5819a(c1985g, c1981b, this.f5231M[0]);
                return;
            case 16981:
                this.f5263w.f5194f = new byte[i2];
                c1985g.mo2965b(this.f5263w.f5194f, 0, i2);
                return;
            case 18402:
                this.f5263w.f5195g = new byte[i2];
                c1985g.mo2965b(this.f5263w.f5195g, 0, i2);
                return;
            case 21419:
                Arrays.fill(this.f5252l.f6454a, (byte) 0);
                c1985g.mo2965b(this.f5252l.f6454a, 4 - i2, i2);
                this.f5252l.m7073c(0);
                this.f5265y = (int) this.f5252l.m7084l();
                return;
            case 25506:
                this.f5263w.f5196h = new byte[i2];
                c1985g.mo2965b(this.f5263w.f5196h, 0, i2);
                return;
            case 30322:
                this.f5263w.f5203o = new byte[i2];
                c1985g.mo2965b(this.f5263w.f5203o, 0, i2);
                return;
            default:
                throw new C1970k("Unexpected id: " + i);
        }
    }

    void m5832a(int i, long j) {
        boolean z = true;
        C1981b c1981b;
        switch (i) {
            case 131:
                this.f5263w.f5191c = (int) j;
                return;
            case 136:
                c1981b = this.f5263w;
                if (j != 1) {
                    z = false;
                }
                c1981b.f5210v = z;
                return;
            case 155:
                this.f5228J = m5825b(j);
                return;
            case 159:
                this.f5263w.f5205q = (int) j;
                return;
            case 176:
                this.f5263w.f5198j = (int) j;
                return;
            case 179:
                this.f5223E.m7041a(m5825b(j));
                return;
            case 186:
                this.f5263w.f5199k = (int) j;
                return;
            case 215:
                this.f5263w.f5190b = (int) j;
                return;
            case 231:
                this.f5222D = m5825b(j);
                return;
            case 241:
                if (!this.f5225G) {
                    this.f5224F.m7041a(j);
                    this.f5225G = true;
                    return;
                }
                return;
            case 251:
                this.aa = true;
                return;
            case 16980:
                if (j != 3) {
                    throw new C1970k("ContentCompAlgo " + j + " not supported");
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw new C1970k("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j != 1) {
                    throw new C1970k("EBMLReadVersion " + j + " not supported");
                }
                return;
            case 18401:
                if (j != 5) {
                    throw new C1970k("ContentEncAlgo " + j + " not supported");
                }
                return;
            case 18408:
                if (j != 1) {
                    throw new C1970k("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case 20529:
                if (j != 0) {
                    throw new C1970k("ContentEncodingOrder " + j + " not supported");
                }
                return;
            case 20530:
                if (j != 1) {
                    throw new C1970k("ContentEncodingScope " + j + " not supported");
                }
                return;
            case 21420:
                this.f5266z = this.f5259s + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.f5263w.f5204p = 0;
                        return;
                    case 1:
                        this.f5263w.f5204p = 2;
                        return;
                    case 3:
                        this.f5263w.f5204p = 1;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.f5263w.f5200l = (int) j;
                return;
            case 21682:
                this.f5263w.f5202n = (int) j;
                return;
            case 21690:
                this.f5263w.f5201m = (int) j;
                return;
            case 21930:
                c1981b = this.f5263w;
                if (j != 1) {
                    z = false;
                }
                c1981b.f5211w = z;
                return;
            case 22186:
                this.f5263w.f5208t = j;
                return;
            case 22203:
                this.f5263w.f5209u = j;
                return;
            case 25188:
                this.f5263w.f5206r = (int) j;
                return;
            case 2352003:
                this.f5263w.f5192d = (int) j;
                return;
            case 2807729:
                this.f5260t = j;
                return;
            default:
                return;
        }
    }

    void m5833a(int i, long j, long j2) {
        switch (i) {
            case 160:
                this.aa = false;
                return;
            case 174:
                this.f5263w = new C1981b();
                return;
            case 187:
                this.f5225G = false;
                return;
            case 19899:
                this.f5265y = -1;
                this.f5266z = -1;
                return;
            case 20533:
                this.f5263w.f5193e = true;
                return;
            case 408125543:
                if (this.f5259s == -1 || this.f5259s == j) {
                    this.f5259s = j;
                    this.f5258r = j2;
                    return;
                }
                throw new C1970k("Multiple Segment elements not supported");
            case 475249515:
                this.f5223E = new C2257f();
                this.f5224F = new C2257f();
                return;
            case 524531317:
                if (!this.f5264x) {
                    if (this.f5220B != -1) {
                        this.f5219A = true;
                        return;
                    }
                    this.ab.mo3022a(new C2094a(this.f5262v));
                    this.f5264x = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    void m5834a(int i, String str) {
        switch (i) {
            case 134:
                this.f5263w.f5189a = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new C1970k("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.f5263w.f5214z = str;
                return;
            default:
                return;
        }
    }

    public void mo2941a(long j) {
        this.f5222D = -9223372036854775807L;
        this.f5226H = 0;
        this.f5245e.mo2948a();
        this.f5246f.m5846a();
        m5826b();
    }

    public void mo2942a(C2090h c2090h) {
        this.ab = c2090h;
    }

    public boolean mo2944a(C1985g c1985g) {
        return new C1983e().m5842a(c1985g);
    }

    boolean m5838b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public void mo2947c() {
    }

    void m5840c(int i) {
        switch (i) {
            case 160:
                if (this.f5226H == 2) {
                    if (!this.aa) {
                        this.f5234P |= 1;
                    }
                    m5817a((C1981b) this.f5247g.get(this.f5232N), this.f5227I);
                    this.f5226H = 0;
                    return;
                }
                return;
            case 174:
                if (this.f5247g.get(this.f5263w.f5190b) == null && C1982d.m5823a(this.f5263w.f5189a)) {
                    this.f5263w.m5813a(this.ab, this.f5263w.f5190b);
                    this.f5247g.put(this.f5263w.f5190b, this.f5263w);
                }
                this.f5263w = null;
                return;
            case 19899:
                if (this.f5265y == -1 || this.f5266z == -1) {
                    throw new C1970k("Mandatory element SeekID or SeekPosition not found");
                } else if (this.f5265y == 475249515) {
                    this.f5220B = this.f5266z;
                    return;
                } else {
                    return;
                }
            case 25152:
                if (!this.f5263w.f5193e) {
                    return;
                }
                if (this.f5263w.f5195g == null) {
                    throw new C1970k("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.f5263w.f5197i = new DrmInitData(new SchemeData(C1961b.f5145b, "video/webm", this.f5263w.f5195g));
                return;
            case 28032:
                if (this.f5263w.f5193e && this.f5263w.f5194f != null) {
                    throw new C1970k("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.f5260t == -9223372036854775807L) {
                    this.f5260t = 1000000;
                }
                if (this.f5261u != -9223372036854775807L) {
                    this.f5262v = m5825b(this.f5261u);
                    return;
                }
                return;
            case 374648427:
                if (this.f5247g.size() == 0) {
                    throw new C1970k("No valid tracks were found");
                }
                this.ab.mo3020a();
                return;
            case 475249515:
                if (!this.f5264x) {
                    this.ab.mo3022a(m5827d());
                    this.f5264x = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
