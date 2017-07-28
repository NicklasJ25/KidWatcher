package com.facebook.ads.internal.p030j.p032b;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class C1647d {
    private static final Pattern f4054d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern f4055e = Pattern.compile("GET /(.*) HTTP");
    public final String f4056a;
    public final long f4057b;
    public final boolean f4058c;

    public C1647d(String str) {
        C1663j.m4705a(str);
        long a = m4636a(str);
        this.f4057b = Math.max(0, a);
        this.f4058c = a >= 0;
        this.f4056a = m4638b(str);
    }

    private long m4636a(String str) {
        Matcher matcher = f4054d.matcher(str);
        return matcher.find() ? Long.parseLong(matcher.group(1)) : -1;
    }

    public static C1647d m4637a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new C1647d(stringBuilder.toString());
            }
            stringBuilder.append(readLine).append('\n');
        }
    }

    private String m4638b(String str) {
        Matcher matcher = f4055e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f4057b + ", partial=" + this.f4058c + ", uri='" + this.f4056a + '\'' + '}';
    }
}
