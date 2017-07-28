package com.google.android.exoplayer2.p057g.p060c;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.p043j.C2274s;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2164c;
import com.google.android.exoplayer2.p057g.C2191g;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class C2169a extends C2164c {
    private static final Pattern f6078a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern f6079b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern f6080c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern f6081d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C2168a f6082e = new C2168a(30.0f, 1, 1);
    private final XmlPullParserFactory f6083f;

    private static final class C2168a {
        final float f6075a;
        final int f6076b;
        final int f6077c;

        C2168a(float f, int i, int i2) {
            this.f6075a = f;
            this.f6076b = i;
            this.f6077c = i2;
        }
    }

    public C2169a() {
        super("TtmlDecoder");
        try {
            this.f6083f = XmlPullParserFactory.newInstance();
            this.f6083f.setNamespaceAware(true);
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private static long m6655a(String str, C2168a c2168a) {
        double d = 0.0d;
        Matcher matcher = f6078a.matcher(str);
        if (matcher.matches()) {
            double parseLong = ((double) Long.parseLong(matcher.group(3))) + (((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)));
            String group = matcher.group(4);
            parseLong += group != null ? Double.parseDouble(group) : 0.0d;
            group = matcher.group(5);
            double parseLong2 = (group != null ? (double) (((float) Long.parseLong(group)) / c2168a.f6075a) : 0.0d) + parseLong;
            String group2 = matcher.group(6);
            if (group2 != null) {
                d = (((double) Long.parseLong(group2)) / ((double) c2168a.f6076b)) / ((double) c2168a.f6075a);
            }
            return (long) ((parseLong2 + d) * 1000000.0d);
        }
        Matcher matcher2 = f6079b.matcher(str);
        if (matcher2.matches()) {
            parseLong2 = Double.parseDouble(matcher2.group(1));
            String group3 = matcher2.group(2);
            int i = -1;
            switch (group3.hashCode()) {
                case 102:
                    if (group3.equals("f")) {
                        i = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group3.equals("h")) {
                        i = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group3.equals("m")) {
                        i = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group3.equals("s")) {
                        i = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group3.equals("t")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group3.equals("ms")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    parseLong2 *= 3600.0d;
                    break;
                case 1:
                    parseLong2 *= 60.0d;
                    break;
                case 3:
                    parseLong2 /= 1000.0d;
                    break;
                case 4:
                    parseLong2 /= (double) c2168a.f6075a;
                    break;
                case 5:
                    parseLong2 /= (double) c2168a.f6077c;
                    break;
            }
            return (long) (parseLong2 * 1000000.0d);
        }
        throw new C2191g("Malformed time expression: " + str);
    }

    private C2168a m6656a(XmlPullParser xmlPullParser) {
        int i = 30;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        }
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(" ");
            if (split.length != 2) {
                throw new C2191g("frameRateMultiplier doesn't have 2 parts");
            }
            f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
        }
        int i2 = f6082e.f6076b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = f6082e.f6077c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new C2168a(((float) i) * f, i2, i3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.p057g.p060c.C2170b m6657a(org.xmlpull.v1.XmlPullParser r20, com.google.android.exoplayer2.p057g.p060c.C2170b r21, java.util.Map<java.lang.String, com.google.android.exoplayer2.p057g.p060c.C2171c> r22, com.google.android.exoplayer2.p057g.p060c.C2169a.C2168a r23) {
        /*
        r19 = this;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r10 = "";
        r9 = 0;
        r14 = r20.getAttributeCount();
        r2 = 0;
        r0 = r19;
        r1 = r20;
        r8 = r0.m6659a(r1, r2);
        r2 = 0;
        r11 = r2;
    L_0x0021:
        if (r11 >= r14) goto L_0x00b3;
    L_0x0023:
        r0 = r20;
        r15 = r0.getAttributeName(r11);
        r0 = r20;
        r2 = r0.getAttributeValue(r11);
        r3 = -1;
        r16 = r15.hashCode();
        switch(r16) {
            case -934795532: goto L_0x006b;
            case 99841: goto L_0x0057;
            case 100571: goto L_0x004d;
            case 93616297: goto L_0x0043;
            case 109780401: goto L_0x0061;
            default: goto L_0x0037;
        };
    L_0x0037:
        switch(r3) {
            case 0: goto L_0x0075;
            case 1: goto L_0x0082;
            case 2: goto L_0x008b;
            case 3: goto L_0x0098;
            case 4: goto L_0x00a6;
            default: goto L_0x003a;
        };
    L_0x003a:
        r2 = r4;
        r4 = r6;
        r6 = r12;
    L_0x003d:
        r11 = r11 + 1;
        r12 = r6;
        r6 = r4;
        r4 = r2;
        goto L_0x0021;
    L_0x0043:
        r16 = "begin";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x004b:
        r3 = 0;
        goto L_0x0037;
    L_0x004d:
        r16 = "end";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0055:
        r3 = 1;
        goto L_0x0037;
    L_0x0057:
        r16 = "dur";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x005f:
        r3 = 2;
        goto L_0x0037;
    L_0x0061:
        r16 = "style";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0069:
        r3 = 3;
        goto L_0x0037;
    L_0x006b:
        r16 = "region";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0073:
        r3 = 4;
        goto L_0x0037;
    L_0x0075:
        r0 = r23;
        r2 = com.google.android.exoplayer2.p057g.p060c.C2169a.m6655a(r2, r0);
        r6 = r12;
        r17 = r2;
        r2 = r4;
        r4 = r17;
        goto L_0x003d;
    L_0x0082:
        r0 = r23;
        r2 = com.google.android.exoplayer2.p057g.p060c.C2169a.m6655a(r2, r0);
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x008b:
        r0 = r23;
        r2 = com.google.android.exoplayer2.p057g.p060c.C2169a.m6655a(r2, r0);
        r17 = r4;
        r4 = r6;
        r6 = r2;
        r2 = r17;
        goto L_0x003d;
    L_0x0098:
        r0 = r19;
        r2 = r0.m6662a(r2);
        r3 = r2.length;
        if (r3 <= 0) goto L_0x003a;
    L_0x00a1:
        r9 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x00a6:
        r0 = r22;
        r3 = r0.containsKey(r2);
        if (r3 == 0) goto L_0x003a;
    L_0x00ae:
        r10 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x00b3:
        if (r21 == 0) goto L_0x0114;
    L_0x00b5:
        r0 = r21;
        r2 = r0.f6087d;
        r14 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 == 0) goto L_0x0114;
    L_0x00c2:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x00d0;
    L_0x00cb:
        r0 = r21;
        r2 = r0.f6087d;
        r6 = r6 + r2;
    L_0x00d0:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0114;
    L_0x00d9:
        r0 = r21;
        r2 = r0.f6087d;
        r4 = r4 + r2;
        r17 = r4;
        r4 = r6;
        r6 = r17;
    L_0x00e3:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x00f7;
    L_0x00ec:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0100;
    L_0x00f5:
        r6 = r4 + r12;
    L_0x00f7:
        r3 = r20.getName();
        r2 = com.google.android.exoplayer2.p057g.p060c.C2170b.m6670a(r3, r4, r6, r8, r9, r10);
        return r2;
    L_0x0100:
        if (r21 == 0) goto L_0x00f7;
    L_0x0102:
        r0 = r21;
        r2 = r0.f6088e;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r2 == 0) goto L_0x00f7;
    L_0x010f:
        r0 = r21;
        r6 = r0.f6088e;
        goto L_0x00f7;
    L_0x0114:
        r17 = r4;
        r4 = r6;
        r6 = r17;
        goto L_0x00e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.c.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.g.c.b, java.util.Map, com.google.android.exoplayer2.g.c.a$a):com.google.android.exoplayer2.g.c.b");
    }

    private C2173e m6658a(C2173e c2173e) {
        return c2173e == null ? new C2173e() : c2173e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.p057g.p060c.C2173e m6659a(org.xmlpull.v1.XmlPullParser r13, com.google.android.exoplayer2.p057g.p060c.C2173e r14) {
        /*
        r12 = this;
        r6 = 3;
        r5 = 2;
        r3 = -1;
        r4 = 1;
        r2 = 0;
        r8 = r13.getAttributeCount();
        r7 = r2;
        r0 = r14;
    L_0x000b:
        if (r7 >= r8) goto L_0x0223;
    L_0x000d:
        r9 = r13.getAttributeValue(r7);
        r1 = r13.getAttributeName(r7);
        r10 = r1.hashCode();
        switch(r10) {
            case -1550943582: goto L_0x0060;
            case -1224696685: goto L_0x0042;
            case -1065511464: goto L_0x006a;
            case -879295043: goto L_0x0074;
            case -734428249: goto L_0x0056;
            case 3355: goto L_0x0024;
            case 94842723: goto L_0x0038;
            case 365601008: goto L_0x004c;
            case 1287124693: goto L_0x002e;
            default: goto L_0x001c;
        };
    L_0x001c:
        r1 = r3;
    L_0x001d:
        switch(r1) {
            case 0: goto L_0x007f;
            case 1: goto L_0x0094;
            case 2: goto L_0x00c1;
            case 3: goto L_0x00ef;
            case 4: goto L_0x00f9;
            case 5: goto L_0x0123;
            case 6: goto L_0x0133;
            case 7: goto L_0x0143;
            case 8: goto L_0x01c2;
            default: goto L_0x0020;
        };
    L_0x0020:
        r1 = r7 + 1;
        r7 = r1;
        goto L_0x000b;
    L_0x0024:
        r10 = "id";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x002c:
        r1 = r2;
        goto L_0x001d;
    L_0x002e:
        r10 = "backgroundColor";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0036:
        r1 = r4;
        goto L_0x001d;
    L_0x0038:
        r10 = "color";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0040:
        r1 = r5;
        goto L_0x001d;
    L_0x0042:
        r10 = "fontFamily";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x004a:
        r1 = r6;
        goto L_0x001d;
    L_0x004c:
        r10 = "fontSize";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0054:
        r1 = 4;
        goto L_0x001d;
    L_0x0056:
        r10 = "fontWeight";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x005e:
        r1 = 5;
        goto L_0x001d;
    L_0x0060:
        r10 = "fontStyle";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0068:
        r1 = 6;
        goto L_0x001d;
    L_0x006a:
        r10 = "textAlign";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0072:
        r1 = 7;
        goto L_0x001d;
    L_0x0074:
        r10 = "textDecoration";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x007c:
        r1 = 8;
        goto L_0x001d;
    L_0x007f:
        r1 = "style";
        r10 = r13.getName();
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0020;
    L_0x008b:
        r0 = r12.m6658a(r0);
        r0 = r0.m6694b(r9);
        goto L_0x0020;
    L_0x0094:
        r0 = r12.m6658a(r0);
        r1 = com.google.android.exoplayer2.p043j.C2254c.m7031a(r9);	 Catch:{ IllegalArgumentException -> 0x00a0 }
        r0.m6693b(r1);	 Catch:{ IllegalArgumentException -> 0x00a0 }
        goto L_0x0020;
    L_0x00a0:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing background value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x00c1:
        r0 = r12.m6658a(r0);
        r1 = com.google.android.exoplayer2.p043j.C2254c.m7031a(r9);	 Catch:{ IllegalArgumentException -> 0x00ce }
        r0.m6688a(r1);	 Catch:{ IllegalArgumentException -> 0x00ce }
        goto L_0x0020;
    L_0x00ce:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing color value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x00ef:
        r0 = r12.m6658a(r0);
        r0 = r0.m6691a(r9);
        goto L_0x0020;
    L_0x00f9:
        r0 = r12.m6658a(r0);	 Catch:{ g -> 0x0102 }
        com.google.android.exoplayer2.p057g.p060c.C2169a.m6661a(r9, r0);	 Catch:{ g -> 0x0102 }
        goto L_0x0020;
    L_0x0102:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing fontSize value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x0123:
        r0 = r12.m6658a(r0);
        r1 = "bold";
        r1 = r1.equalsIgnoreCase(r9);
        r0 = r0.m6698c(r1);
        goto L_0x0020;
    L_0x0133:
        r0 = r12.m6658a(r0);
        r1 = "italic";
        r1 = r1.equalsIgnoreCase(r9);
        r0 = r0.m6700d(r1);
        goto L_0x0020;
    L_0x0143:
        r1 = com.google.android.exoplayer2.p043j.C2273r.m7141d(r9);
        r9 = r1.hashCode();
        switch(r9) {
            case -1364013995: goto L_0x0188;
            case 100571: goto L_0x017e;
            case 3317767: goto L_0x0160;
            case 108511772: goto L_0x0174;
            case 109757538: goto L_0x016a;
            default: goto L_0x014e;
        };
    L_0x014e:
        r1 = r3;
    L_0x014f:
        switch(r1) {
            case 0: goto L_0x0154;
            case 1: goto L_0x0192;
            case 2: goto L_0x019e;
            case 3: goto L_0x01aa;
            case 4: goto L_0x01b6;
            default: goto L_0x0152;
        };
    L_0x0152:
        goto L_0x0020;
    L_0x0154:
        r0 = r12.m6658a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r0 = r0.m6689a(r1);
        goto L_0x0020;
    L_0x0160:
        r9 = "left";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0168:
        r1 = r2;
        goto L_0x014f;
    L_0x016a:
        r9 = "start";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0172:
        r1 = r4;
        goto L_0x014f;
    L_0x0174:
        r9 = "right";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x017c:
        r1 = r5;
        goto L_0x014f;
    L_0x017e:
        r9 = "end";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0186:
        r1 = r6;
        goto L_0x014f;
    L_0x0188:
        r9 = "center";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0190:
        r1 = 4;
        goto L_0x014f;
    L_0x0192:
        r0 = r12.m6658a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r0 = r0.m6689a(r1);
        goto L_0x0020;
    L_0x019e:
        r0 = r12.m6658a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r0 = r0.m6689a(r1);
        goto L_0x0020;
    L_0x01aa:
        r0 = r12.m6658a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r0 = r0.m6689a(r1);
        goto L_0x0020;
    L_0x01b6:
        r0 = r12.m6658a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_CENTER;
        r0 = r0.m6689a(r1);
        goto L_0x0020;
    L_0x01c2:
        r1 = com.google.android.exoplayer2.p043j.C2273r.m7141d(r9);
        r9 = r1.hashCode();
        switch(r9) {
            case -1461280213: goto L_0x01fb;
            case -1026963764: goto L_0x01f1;
            case 913457136: goto L_0x01e7;
            case 1679736913: goto L_0x01dd;
            default: goto L_0x01cd;
        };
    L_0x01cd:
        r1 = r3;
    L_0x01ce:
        switch(r1) {
            case 0: goto L_0x01d3;
            case 1: goto L_0x0205;
            case 2: goto L_0x020f;
            case 3: goto L_0x0219;
            default: goto L_0x01d1;
        };
    L_0x01d1:
        goto L_0x0020;
    L_0x01d3:
        r0 = r12.m6658a(r0);
        r0 = r0.m6692a(r4);
        goto L_0x0020;
    L_0x01dd:
        r9 = "linethrough";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01e5:
        r1 = r2;
        goto L_0x01ce;
    L_0x01e7:
        r9 = "nolinethrough";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01ef:
        r1 = r4;
        goto L_0x01ce;
    L_0x01f1:
        r9 = "underline";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01f9:
        r1 = r5;
        goto L_0x01ce;
    L_0x01fb:
        r9 = "nounderline";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x0203:
        r1 = r6;
        goto L_0x01ce;
    L_0x0205:
        r0 = r12.m6658a(r0);
        r0 = r0.m6692a(r2);
        goto L_0x0020;
    L_0x020f:
        r0 = r12.m6658a(r0);
        r0 = r0.m6695b(r4);
        goto L_0x0020;
    L_0x0219:
        r0 = r12.m6658a(r0);
        r0 = r0.m6695b(r2);
        goto L_0x0020;
    L_0x0223:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.c.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.g.c.e):com.google.android.exoplayer2.g.c.e");
    }

    private Map<String, C2173e> m6660a(XmlPullParser xmlPullParser, Map<String, C2173e> map, Map<String, C2171c> map2) {
        do {
            xmlPullParser.next();
            if (C2274s.m7148b(xmlPullParser, "style")) {
                String c = C2274s.m7149c(xmlPullParser, "style");
                C2173e a = m6659a(xmlPullParser, new C2173e());
                if (c != null) {
                    for (Object obj : m6662a(c)) {
                        a.m6690a((C2173e) map.get(obj));
                    }
                }
                if (a.m6706i() != null) {
                    map.put(a.m6706i(), a);
                }
            } else if (C2274s.m7148b(xmlPullParser, "region")) {
                Pair b = m6663b(xmlPullParser);
                if (b != null) {
                    map2.put(b.first, b.second);
                }
            }
        } while (!C2274s.m7146a(xmlPullParser, "head"));
        return map;
    }

    private static void m6661a(String str, C2173e c2173e) {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = f6080c.matcher(str);
        } else if (split.length == 2) {
            matcher = f6080c.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new C2191g("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            int i = -1;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        i = 2;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    c2173e.m6697c(1);
                    break;
                case 1:
                    c2173e.m6697c(2);
                    break;
                case 2:
                    c2173e.m6697c(3);
                    break;
                default:
                    throw new C2191g("Invalid unit for fontSize: '" + group + "'.");
            }
            c2173e.m6687a(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new C2191g("Invalid expression for fontSize: '" + str + "'.");
    }

    private String[] m6662a(String str) {
        return str.split("\\s+");
    }

    private Pair<String, C2171c> m6663b(XmlPullParser xmlPullParser) {
        String c = C2274s.m7149c(xmlPullParser, "id");
        Object c2 = C2274s.m7149c(xmlPullParser, "origin");
        Object c3 = C2274s.m7149c(xmlPullParser, "extent");
        if (c2 == null || c == null) {
            return null;
        }
        float parseFloat;
        float parseFloat2;
        float parseFloat3;
        Matcher matcher = f6081d.matcher(c2);
        if (matcher.matches()) {
            try {
                parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
            } catch (Throwable e) {
                Log.w("TtmlDecoder", "Ignoring region with malformed origin: '" + c2 + "'", e);
                parseFloat2 = Float.MIN_VALUE;
                parseFloat = Float.MIN_VALUE;
            }
        } else {
            parseFloat2 = Float.MIN_VALUE;
            parseFloat = Float.MIN_VALUE;
        }
        if (c3 != null) {
            matcher = f6081d.matcher(c3);
            if (matcher.matches()) {
                try {
                    parseFloat3 = Float.parseFloat(matcher.group(1)) / 100.0f;
                } catch (Throwable e2) {
                    Log.w("TtmlDecoder", "Ignoring malformed region extent: '" + c3 + "'", e2);
                }
                return parseFloat == Float.MIN_VALUE ? new Pair(c, new C2171c(parseFloat, parseFloat2, 0, parseFloat3)) : null;
            }
        }
        parseFloat3 = Float.MIN_VALUE;
        if (parseFloat == Float.MIN_VALUE) {
        }
    }

    private static boolean m6664b(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    protected /* synthetic */ C2159e mo3062a(byte[] bArr, int i) {
        return m6666b(bArr, i);
    }

    protected C2174f m6666b(byte[] bArr, int i) {
        C2174f c2174f = null;
        int i2 = 0;
        try {
            XmlPullParser newPullParser = this.f6083f.newPullParser();
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap2.put("", new C2171c());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            C2168a c2168a = f6082e;
            for (int i3 = eventType; i3 != 1; i3 = newPullParser.getEventType()) {
                C2170b c2170b = (C2170b) linkedList.peekLast();
                if (i2 == 0) {
                    C2174f c2174f2;
                    C2168a c2168a2;
                    int i4;
                    String name = newPullParser.getName();
                    if (i3 == 2) {
                        if ("tt".equals(name)) {
                            c2168a = m6656a(newPullParser);
                        }
                        int i5;
                        if (!C2169a.m6664b(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            eventType = i2 + 1;
                            c2174f2 = c2174f;
                            i5 = eventType;
                            c2168a2 = c2168a;
                            i4 = i5;
                        } else if ("head".equals(name)) {
                            m6660a(newPullParser, hashMap, hashMap2);
                            c2168a2 = c2168a;
                            i4 = i2;
                            c2174f2 = c2174f;
                        } else {
                            try {
                                C2170b a = m6657a(newPullParser, c2170b, hashMap2, c2168a);
                                linkedList.addLast(a);
                                if (c2170b != null) {
                                    c2170b.m6678a(a);
                                }
                                c2168a2 = c2168a;
                                i4 = i2;
                                c2174f2 = c2174f;
                            } catch (Throwable e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                eventType = i2 + 1;
                                c2174f2 = c2174f;
                                i5 = eventType;
                                c2168a2 = c2168a;
                                i4 = i5;
                            }
                        }
                    } else if (i3 == 4) {
                        c2170b.m6678a(C2170b.m6669a(newPullParser.getText()));
                        c2168a2 = c2168a;
                        i4 = i2;
                        c2174f2 = c2174f;
                    } else if (i3 == 3) {
                        C2174f c2174f3 = newPullParser.getName().equals("tt") ? new C2174f((C2170b) linkedList.getLast(), hashMap, hashMap2) : c2174f;
                        linkedList.removeLast();
                        C2168a c2168a3 = c2168a;
                        i4 = i2;
                        c2174f2 = c2174f3;
                        c2168a2 = c2168a3;
                    } else {
                        c2168a2 = c2168a;
                        i4 = i2;
                        c2174f2 = c2174f;
                    }
                    c2174f = c2174f2;
                    i2 = i4;
                    c2168a = c2168a2;
                } else if (i3 == 2) {
                    i2++;
                } else if (i3 == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            return c2174f;
        } catch (Throwable e2) {
            throw new C2191g("Unable to decode source", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Unexpected error when reading input.", e22);
        }
    }
}
