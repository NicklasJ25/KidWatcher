package com.google.android.exoplayer2.p057g.p062e;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p057g.C2191g;
import java.util.regex.Pattern;

public final class C2189h {
    private static final Pattern f6174a = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern f6175b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static long m6800a(String str) {
        int i = 0;
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(":");
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        return (Long.parseLong(split[1]) + (j * 1000)) * 1000;
    }

    public static void m6801a(C2263k c2263k) {
        Object x = c2263k.m7096x();
        if (x == null || !f6175b.matcher(x).matches()) {
            throw new C2191g("Expected WEBVTT. Got " + x);
        }
    }

    public static float m6802b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
