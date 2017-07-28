package com.google.android.exoplayer2.p057g.p062e;

import android.text.TextUtils;
import com.google.android.exoplayer2.p043j.C2254c;
import com.google.android.exoplayer2.p043j.C2263k;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class C2178a {
    private static final Pattern f6121a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final C2263k f6122b = new C2263k();
    private final StringBuilder f6123c = new StringBuilder();

    private static char m6720a(C2263k c2263k, int i) {
        return (char) c2263k.f6454a[i];
    }

    static String m6721a(C2263k c2263k, StringBuilder stringBuilder) {
        C2178a.m6725b(c2263k);
        if (c2263k.m7070b() == 0) {
            return null;
        }
        String d = C2178a.m6729d(c2263k, stringBuilder);
        return "".equals(d) ? "" + ((char) c2263k.m7079g()) : d;
    }

    private void m6722a(C2181d c2181d, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f6121a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    c2181d.m6752c(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                c2181d.m6750b(str2.substring(0, indexOf2));
                c2181d.m6745a(str2.substring(indexOf2 + 1));
            } else {
                c2181d.m6750b(str2);
            }
            if (split.length > 1) {
                c2181d.m6746a((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
    }

    private static void m6723a(C2263k c2263k, C2181d c2181d, StringBuilder stringBuilder) {
        C2178a.m6725b(c2263k);
        String d = C2178a.m6729d(c2263k, stringBuilder);
        if (!"".equals(d) && ":".equals(C2178a.m6721a(c2263k, stringBuilder))) {
            C2178a.m6725b(c2263k);
            String c = C2178a.m6726c(c2263k, stringBuilder);
            if (c != null && !"".equals(c)) {
                int d2 = c2263k.m7074d();
                String a = C2178a.m6721a(c2263k, stringBuilder);
                if (!";".equals(a)) {
                    if ("}".equals(a)) {
                        c2263k.m7073c(d2);
                    } else {
                        return;
                    }
                }
                if ("color".equals(d)) {
                    c2181d.m6742a(C2254c.m7033b(c));
                } else if ("background-color".equals(d)) {
                    c2181d.m6748b(C2254c.m7033b(c));
                } else if ("text-decoration".equals(d)) {
                    if ("underline".equals(c)) {
                        c2181d.m6743a(true);
                    }
                } else if ("font-family".equals(d)) {
                    c2181d.m6754d(c);
                } else if ("font-weight".equals(d)) {
                    if ("bold".equals(c)) {
                        c2181d.m6749b(true);
                    }
                } else if ("font-style".equals(d) && "italic".equals(c)) {
                    c2181d.m6751c(true);
                }
            }
        }
    }

    private static String m6724b(C2263k c2263k, StringBuilder stringBuilder) {
        C2178a.m6725b(c2263k);
        if (c2263k.m7070b() < 5) {
            return null;
        }
        if (!"::cue".equals(c2263k.m7077e(5))) {
            return null;
        }
        int d = c2263k.m7074d();
        String a = C2178a.m6721a(c2263k, stringBuilder);
        if (a == null) {
            return null;
        }
        if ("{".equals(a)) {
            c2263k.m7073c(d);
            return "";
        }
        String d2 = "(".equals(a) ? C2178a.m6728d(c2263k) : null;
        a = C2178a.m6721a(c2263k, stringBuilder);
        return (!")".equals(a) || a == null) ? null : d2;
    }

    static void m6725b(C2263k c2263k) {
        Object obj = 1;
        while (c2263k.m7070b() > 0 && r0 != null) {
            obj = (C2178a.m6730e(c2263k) || C2178a.m6731f(c2263k)) ? 1 : null;
        }
    }

    private static String m6726c(C2263k c2263k, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        Object obj = null;
        while (obj == null) {
            int d = c2263k.m7074d();
            String a = C2178a.m6721a(c2263k, stringBuilder);
            if (a == null) {
                return null;
            }
            if ("}".equals(a) || ";".equals(a)) {
                c2263k.m7073c(d);
                obj = 1;
            } else {
                stringBuilder2.append(a);
            }
        }
        return stringBuilder2.toString();
    }

    static void m6727c(C2263k c2263k) {
        do {
        } while (!TextUtils.isEmpty(c2263k.m7096x()));
    }

    private static String m6728d(C2263k c2263k) {
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        int i = d;
        Object obj = null;
        while (i < c && r0 == null) {
            int i2 = i + 1;
            obj = ((char) c2263k.f6454a[i]) == ')' ? 1 : null;
            i = i2;
        }
        return c2263k.m7077e((i - 1) - c2263k.m7074d()).trim();
    }

    private static String m6729d(C2263k c2263k, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        while (d < c && r0 == 0) {
            char c2 = (char) c2263k.f6454a[d];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                i = 1;
            } else {
                d++;
                stringBuilder.append(c2);
            }
        }
        c2263k.m7075d(d - c2263k.m7074d());
        return stringBuilder.toString();
    }

    private static boolean m6730e(C2263k c2263k) {
        switch (C2178a.m6720a(c2263k, c2263k.m7074d())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                c2263k.m7075d(1);
                return true;
            default:
                return false;
        }
    }

    private static boolean m6731f(C2263k c2263k) {
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        byte[] bArr = c2263k.f6454a;
        if (d + 2 <= c) {
            int i = d + 1;
            if (bArr[d] == (byte) 47) {
                d = i + 1;
                if (bArr[i] == (byte) 42) {
                    i = d;
                    while (i + 1 < c) {
                        d = i + 1;
                        if (((char) bArr[i]) == '*' && ((char) bArr[d]) == '/') {
                            c = d + 1;
                            d = c;
                        }
                        i = d;
                    }
                    c2263k.m7075d(c - c2263k.m7074d());
                    return true;
                }
            }
        }
        return false;
    }

    public C2181d m6732a(C2263k c2263k) {
        this.f6123c.setLength(0);
        int d = c2263k.m7074d();
        C2178a.m6727c(c2263k);
        this.f6122b.m7068a(c2263k.f6454a, c2263k.m7074d());
        this.f6122b.m7073c(d);
        String b = C2178a.m6724b(this.f6122b, this.f6123c);
        if (b == null || !"{".equals(C2178a.m6721a(this.f6122b, this.f6123c))) {
            return null;
        }
        C2181d c2181d = new C2181d();
        m6722a(c2181d, b);
        int i = 0;
        Object obj = null;
        while (i == 0) {
            int d2 = this.f6122b.m7074d();
            obj = C2178a.m6721a(this.f6122b, this.f6123c);
            i = (obj == null || "}".equals(obj)) ? 1 : 0;
            if (i == 0) {
                this.f6122b.m7073c(d2);
                C2178a.m6723a(this.f6122b, c2181d, this.f6123c);
            }
        }
        return !"}".equals(obj) ? null : c2181d;
    }
}
