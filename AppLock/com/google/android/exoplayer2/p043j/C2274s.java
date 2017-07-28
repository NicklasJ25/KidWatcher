package com.google.android.exoplayer2.p043j;

import org.xmlpull.v1.XmlPullParser;

public final class C2274s {
    public static boolean m7145a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean m7146a(XmlPullParser xmlPullParser, String str) {
        return C2274s.m7145a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean m7147b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean m7148b(XmlPullParser xmlPullParser, String str) {
        return C2274s.m7147b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static String m7149c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
