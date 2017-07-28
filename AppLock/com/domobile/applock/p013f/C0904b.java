package com.domobile.applock.p013f;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class C0904b {
    public static String m1594a(long j, String str) {
        return C0904b.m1595a(j, str, Locale.getDefault());
    }

    public static String m1595a(long j, String str, Locale locale) {
        return new SimpleDateFormat(str, locale).format(new Date(j));
    }
}
