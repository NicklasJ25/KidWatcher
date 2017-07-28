package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C2587l {
    private static final Pattern f7563a = Pattern.compile("\\\\.");
    private static final Pattern f7564b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String m8303a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f7564b.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case '\b':
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case '\t':
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case '\n':
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case '\f':
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case '\r':
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case '\"':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case '/':
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case '\\':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
