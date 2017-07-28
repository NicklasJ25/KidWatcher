package com.google.android.exoplayer2.p045c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C2091j {
    private static final Pattern f5872c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int f5873a = -1;
    public int f5874b = -1;

    public boolean m6346a() {
        return (this.f5873a == -1 || this.f5874b == -1) ? false : true;
    }

    public boolean m6347a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f5873a = i2;
        this.f5874b = i3;
        return true;
    }

    public boolean m6348a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f5872c.matcher(str2);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f5873a = parseInt;
            this.f5874b = parseInt2;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
