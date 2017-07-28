package com.google.android.exoplayer2.p057g.p060c;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

final class C2172d {
    public static C2173e m6681a(C2173e c2173e, String[] strArr, Map<String, C2173e> map) {
        if (c2173e == null && strArr == null) {
            return null;
        }
        if (c2173e == null && strArr.length == 1) {
            return (C2173e) map.get(strArr[0]);
        }
        if (c2173e == null && strArr.length > 1) {
            c2173e = new C2173e();
            for (Object obj : strArr) {
                c2173e.m6690a((C2173e) map.get(obj));
            }
            return c2173e;
        } else if (c2173e != null && strArr != null && strArr.length == 1) {
            return c2173e.m6690a((C2173e) map.get(strArr[0]));
        } else {
            if (c2173e == null || strArr == null || strArr.length <= 1) {
                return c2173e;
            }
            for (Object obj2 : strArr) {
                c2173e.m6690a((C2173e) map.get(obj2));
            }
            return c2173e;
        }
    }

    static String m6682a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void m6683a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    public static void m6684a(SpannableStringBuilder spannableStringBuilder, int i, int i2, C2173e c2173e) {
        if (c2173e.m6686a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(c2173e.m6686a()), i, i2, 33);
        }
        if (c2173e.m6696b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (c2173e.m6699c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (c2173e.m6703f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c2173e.m6702e()), i, i2, 33);
        }
        if (c2173e.m6705h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(c2173e.m6704g()), i, i2, 33);
        }
        if (c2173e.m6701d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(c2173e.m6701d()), i, i2, 33);
        }
        if (c2173e.m6707j() != null) {
            spannableStringBuilder.setSpan(new Standard(c2173e.m6707j()), i, i2, 33);
        }
        if (c2173e.m6708k() != -1) {
            switch (c2173e.m6708k()) {
                case 1:
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c2173e.m6709l(), true), i, i2, 33);
                    return;
                case 2:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(c2173e.m6709l()), i, i2, 33);
                    return;
                case 3:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(c2173e.m6709l() / 100.0f), i, i2, 33);
                    return;
                default:
                    return;
            }
        }
    }
}
