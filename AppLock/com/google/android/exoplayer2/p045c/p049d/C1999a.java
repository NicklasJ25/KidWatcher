package com.google.android.exoplayer2.p045c.p049d;

import android.support.v4.view.ViewCompat;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class C1999a {
    public static final int f5331A = C2273r.m7142e("moov");
    public static final int f5332B = C2273r.m7142e("mvhd");
    public static final int f5333C = C2273r.m7142e("trak");
    public static final int f5334D = C2273r.m7142e("mdia");
    public static final int f5335E = C2273r.m7142e("minf");
    public static final int f5336F = C2273r.m7142e("stbl");
    public static final int f5337G = C2273r.m7142e("avcC");
    public static final int f5338H = C2273r.m7142e("hvcC");
    public static final int f5339I = C2273r.m7142e("esds");
    public static final int f5340J = C2273r.m7142e("moof");
    public static final int f5341K = C2273r.m7142e("traf");
    public static final int f5342L = C2273r.m7142e("mvex");
    public static final int f5343M = C2273r.m7142e("mehd");
    public static final int f5344N = C2273r.m7142e("tkhd");
    public static final int f5345O = C2273r.m7142e("edts");
    public static final int f5346P = C2273r.m7142e("elst");
    public static final int f5347Q = C2273r.m7142e("mdhd");
    public static final int f5348R = C2273r.m7142e("hdlr");
    public static final int f5349S = C2273r.m7142e("stsd");
    public static final int f5350T = C2273r.m7142e("pssh");
    public static final int f5351U = C2273r.m7142e("sinf");
    public static final int f5352V = C2273r.m7142e("schm");
    public static final int f5353W = C2273r.m7142e("schi");
    public static final int f5354X = C2273r.m7142e("tenc");
    public static final int f5355Y = C2273r.m7142e("encv");
    public static final int f5356Z = C2273r.m7142e("enca");
    public static final int f5357a = C2273r.m7142e("ftyp");
    public static final int aA = C2273r.m7142e("meta");
    public static final int aB = C2273r.m7142e("ilst");
    public static final int aC = C2273r.m7142e("mean");
    public static final int aD = C2273r.m7142e("name");
    public static final int aE = C2273r.m7142e("data");
    public static final int aF = C2273r.m7142e("st3d");
    public static final int aG = C2273r.m7142e("sv3d");
    public static final int aH = C2273r.m7142e("proj");
    public static final int aI = C2273r.m7142e("vp08");
    public static final int aJ = C2273r.m7142e("vp09");
    public static final int aK = C2273r.m7142e("vpcC");
    public static final int aL = C2273r.m7142e("----");
    public static final int aa = C2273r.m7142e("frma");
    public static final int ab = C2273r.m7142e("saiz");
    public static final int ac = C2273r.m7142e("saio");
    public static final int ad = C2273r.m7142e("sbgp");
    public static final int ae = C2273r.m7142e("sgpd");
    public static final int af = C2273r.m7142e("uuid");
    public static final int ag = C2273r.m7142e("senc");
    public static final int ah = C2273r.m7142e("pasp");
    public static final int ai = C2273r.m7142e("TTML");
    public static final int aj = C2273r.m7142e("vmhd");
    public static final int ak = C2273r.m7142e("mp4v");
    public static final int al = C2273r.m7142e("stts");
    public static final int am = C2273r.m7142e("stss");
    public static final int an = C2273r.m7142e("ctts");
    public static final int ao = C2273r.m7142e("stsc");
    public static final int ap = C2273r.m7142e("stsz");
    public static final int aq = C2273r.m7142e("stz2");
    public static final int ar = C2273r.m7142e("stco");
    public static final int as = C2273r.m7142e("co64");
    public static final int at = C2273r.m7142e("tx3g");
    public static final int au = C2273r.m7142e("wvtt");
    public static final int av = C2273r.m7142e("stpp");
    public static final int aw = C2273r.m7142e("c608");
    public static final int ax = C2273r.m7142e("samr");
    public static final int ay = C2273r.m7142e("sawb");
    public static final int az = C2273r.m7142e("udta");
    public static final int f5358b = C2273r.m7142e("avc1");
    public static final int f5359c = C2273r.m7142e("avc3");
    public static final int f5360d = C2273r.m7142e("hvc1");
    public static final int f5361e = C2273r.m7142e("hev1");
    public static final int f5362f = C2273r.m7142e("s263");
    public static final int f5363g = C2273r.m7142e("d263");
    public static final int f5364h = C2273r.m7142e("mdat");
    public static final int f5365i = C2273r.m7142e("mp4a");
    public static final int f5366j = C2273r.m7142e("wave");
    public static final int f5367k = C2273r.m7142e("lpcm");
    public static final int f5368l = C2273r.m7142e("sowt");
    public static final int f5369m = C2273r.m7142e("ac-3");
    public static final int f5370n = C2273r.m7142e("dac3");
    public static final int f5371o = C2273r.m7142e("ec-3");
    public static final int f5372p = C2273r.m7142e("dec3");
    public static final int f5373q = C2273r.m7142e("dtsc");
    public static final int f5374r = C2273r.m7142e("dtsh");
    public static final int f5375s = C2273r.m7142e("dtsl");
    public static final int f5376t = C2273r.m7142e("dtse");
    public static final int f5377u = C2273r.m7142e("ddts");
    public static final int f5378v = C2273r.m7142e("tfdt");
    public static final int f5379w = C2273r.m7142e("tfhd");
    public static final int f5380x = C2273r.m7142e("trex");
    public static final int f5381y = C2273r.m7142e("trun");
    public static final int f5382z = C2273r.m7142e("sidx");
    public final int aM;

    static final class C2000a extends C1999a {
        public final long aN;
        public final List<C2001b> aO = new ArrayList();
        public final List<C2000a> aP = new ArrayList();

        public C2000a(int i, long j) {
            super(i);
            this.aN = j;
        }

        public void m5931a(C2000a c2000a) {
            this.aP.add(c2000a);
        }

        public void m5932a(C2001b c2001b) {
            this.aO.add(c2001b);
        }

        public C2001b m5933d(int i) {
            int size = this.aO.size();
            for (int i2 = 0; i2 < size; i2++) {
                C2001b c2001b = (C2001b) this.aO.get(i2);
                if (c2001b.aM == i) {
                    return c2001b;
                }
            }
            return null;
        }

        public C2000a m5934e(int i) {
            int size = this.aP.size();
            for (int i2 = 0; i2 < size; i2++) {
                C2000a c2000a = (C2000a) this.aP.get(i2);
                if (c2000a.aM == i) {
                    return c2000a;
                }
            }
            return null;
        }

        public String toString() {
            return C1999a.m5930c(this.aM) + " leaves: " + Arrays.toString(this.aO.toArray()) + " containers: " + Arrays.toString(this.aP.toArray());
        }
    }

    static final class C2001b extends C1999a {
        public final C2263k aN;

        public C2001b(int i, C2263k c2263k) {
            super(i);
            this.aN = c2263k;
        }
    }

    public C1999a(int i) {
        this.aM = i;
    }

    public static int m5928a(int i) {
        return (i >> 24) & 255;
    }

    public static int m5929b(int i) {
        return ViewCompat.MEASURED_SIZE_MASK & i;
    }

    public static String m5930c(int i) {
        return "" + ((char) (i >> 24)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public String toString() {
        return C1999a.m5930c(this.aM);
    }
}
