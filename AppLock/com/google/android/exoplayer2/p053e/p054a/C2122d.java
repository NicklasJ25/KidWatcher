package com.google.android.exoplayer2.p053e.p054a;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p053e.C2121a;
import com.google.android.exoplayer2.p053e.C2126b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class C2122d implements C2121a<List<C2117e>> {
    private static int m6434a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int m6435a(C2263k c2263k) {
        int g = c2263k.m7079g();
        int g2 = c2263k.m7079g();
        int g3 = c2263k.m7079g();
        if (g == 73 && g2 == 68 && g3 == 51) {
            c2263k.m7075d(2);
            g2 = c2263k.m7079g();
            g = c2263k.m7091s();
            if ((g2 & 2) != 0) {
                g3 = c2263k.m7091s();
                if (g3 > 4) {
                    c2263k.m7075d(g3 - 4);
                }
                g -= g3;
            }
            return (g2 & 8) != 0 ? g - 10 : g;
        } else {
            throw new C2126b(String.format(Locale.US, "Unexpected ID3 file identifier, expected \"ID3\", actual \"%c%c%c\".", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3)}));
        }
    }

    private static int m6436a(byte[] bArr, int i, int i2) {
        int c = C2122d.m6442c(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return c;
        }
        while (c < bArr.length - 1) {
            if (c % 2 == 0 && bArr[c + 1] == (byte) 0) {
                return c;
            }
            c = C2122d.m6442c(bArr, c + 1);
        }
        return bArr.length;
    }

    private static C2124g m6437a(C2263k c2263k, int i, String str) {
        int g = c2263k.m7079g();
        String b = C2122d.m6441b(g);
        byte[] bArr = new byte[(i - 1)];
        c2263k.m7069a(bArr, 0, i - 1);
        return new C2124g(str, new String(bArr, 0, C2122d.m6436a(bArr, 0, g), b));
    }

    private static C2125h m6438a(C2263k c2263k, int i) {
        int g = c2263k.m7079g();
        String b = C2122d.m6441b(g);
        byte[] bArr = new byte[(i - 1)];
        c2263k.m7069a(bArr, 0, i - 1);
        int a = C2122d.m6436a(bArr, 0, g);
        String str = new String(bArr, 0, a, b);
        a += C2122d.m6434a(g);
        return new C2125h(str, new String(bArr, a, C2122d.m6436a(bArr, a, g) - a, b));
    }

    private static C2119b m6439b(C2263k c2263k, int i, String str) {
        byte[] bArr = new byte[i];
        c2263k.m7069a(bArr, 0, i);
        return new C2119b(str, bArr);
    }

    private static C2123f m6440b(C2263k c2263k, int i) {
        byte[] bArr = new byte[i];
        c2263k.m7069a(bArr, 0, i);
        int c = C2122d.m6442c(bArr, 0);
        return new C2123f(new String(bArr, 0, c, "ISO-8859-1"), Arrays.copyOfRange(bArr, c + 1, bArr.length));
    }

    private static String m6441b(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    private static int m6442c(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static C2120c m6443c(C2263k c2263k, int i) {
        int g = c2263k.m7079g();
        String b = C2122d.m6441b(g);
        byte[] bArr = new byte[(i - 1)];
        c2263k.m7069a(bArr, 0, i - 1);
        int c = C2122d.m6442c(bArr, 0);
        String str = new String(bArr, 0, c, "ISO-8859-1");
        c++;
        int a = C2122d.m6436a(bArr, c, g);
        String str2 = new String(bArr, c, a - c, b);
        c = C2122d.m6434a(g) + a;
        a = C2122d.m6436a(bArr, c, g);
        return new C2120c(str, str2, new String(bArr, c, a - c, b), Arrays.copyOfRange(bArr, C2122d.m6434a(g) + a, bArr.length));
    }

    private static C2118a m6444d(C2263k c2263k, int i) {
        int g = c2263k.m7079g();
        String b = C2122d.m6441b(g);
        byte[] bArr = new byte[(i - 1)];
        c2263k.m7069a(bArr, 0, i - 1);
        int c = C2122d.m6442c(bArr, 0);
        String str = new String(bArr, 0, c, "ISO-8859-1");
        int i2 = bArr[c + 1] & 255;
        c += 2;
        int a = C2122d.m6436a(bArr, c, g);
        return new C2118a(str, new String(bArr, c, a - c, b), i2, Arrays.copyOfRange(bArr, C2122d.m6434a(g) + a, bArr.length));
    }

    public /* synthetic */ Object mo3008a(byte[] bArr, int i) {
        return m6447b(bArr, i);
    }

    public boolean mo3009a(String str) {
        return str.equals("application/id3");
    }

    public List<C2117e> m6447b(byte[] bArr, int i) {
        List arrayList = new ArrayList();
        C2263k c2263k = new C2263k(bArr, i);
        int a = C2122d.m6435a(c2263k);
        while (a > 0) {
            int g = c2263k.m7079g();
            int g2 = c2263k.m7079g();
            int g3 = c2263k.m7079g();
            int g4 = c2263k.m7079g();
            int s = c2263k.m7091s();
            if (s <= 1) {
                break;
            }
            Object a2;
            c2263k.m7075d(2);
            if (g == 84 && g2 == 88 && g3 == 88 && g4 == 88) {
                try {
                    a2 = C2122d.m6438a(c2263k, s);
                } catch (Throwable e) {
                    throw new C2126b("Unsupported encoding", e);
                }
            } else if (g == 80 && g2 == 82 && g3 == 73 && g4 == 86) {
                a2 = C2122d.m6440b(c2263k, s);
            } else if (g == 71 && g2 == 69 && g3 == 79 && g4 == 66) {
                a2 = C2122d.m6443c(c2263k, s);
            } else if (g == 65 && g2 == 80 && g3 == 73 && g4 == 67) {
                a2 = C2122d.m6444d(c2263k, s);
            } else if (g == 84) {
                a2 = C2122d.m6437a(c2263k, s, String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3), Integer.valueOf(g4)}));
            } else {
                a2 = C2122d.m6439b(c2263k, s, String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3), Integer.valueOf(g4)}));
            }
            arrayList.add(a2);
            a -= s + 10;
        }
        return Collections.unmodifiableList(arrayList);
    }
}
