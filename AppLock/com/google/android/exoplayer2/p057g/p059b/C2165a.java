package com.google.android.exoplayer2.p057g.p059b;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p043j.C2257f;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2164c;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C2165a extends C2164c {
    private static final Pattern f6062a = Pattern.compile("(\\S*)\\s*-->\\s*(\\S*)");
    private static final Pattern f6063b = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+),(\\d+)");
    private final StringBuilder f6064c = new StringBuilder();

    public C2165a() {
        super("SubripDecoder");
    }

    private static long m6648a(String str) {
        Matcher matcher = f6063b.matcher(str);
        if (matcher.matches()) {
            return (Long.parseLong(matcher.group(4)) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000)) + (Long.parseLong(matcher.group(3)) * 1000))) * 1000;
        }
        throw new NumberFormatException("has invalid format");
    }

    protected /* synthetic */ C2159e mo3062a(byte[] bArr, int i) {
        return m6650b(bArr, i);
    }

    protected C2166b m6650b(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        C2257f c2257f = new C2257f();
        C2263k c2263k = new C2263k(bArr, i);
        while (true) {
            String x = c2263k.m7096x();
            if (x == null) {
                C2167b[] c2167bArr = new C2167b[arrayList.size()];
                arrayList.toArray(c2167bArr);
                return new C2166b(c2167bArr, c2257f.m7042b());
            } else if (x.length() != 0) {
                try {
                    Integer.parseInt(x);
                    Object x2 = c2263k.m7096x();
                    Matcher matcher = f6062a.matcher(x2);
                    if (matcher.find()) {
                        int i2;
                        c2257f.m7041a(C2165a.m6648a(matcher.group(1)));
                        if (TextUtils.isEmpty(matcher.group(2))) {
                            i2 = 0;
                        } else {
                            c2257f.m7041a(C2165a.m6648a(matcher.group(2)));
                            i2 = 1;
                        }
                        this.f6064c.setLength(0);
                        while (true) {
                            Object x3 = c2263k.m7096x();
                            if (TextUtils.isEmpty(x3)) {
                                break;
                            }
                            if (this.f6064c.length() > 0) {
                                this.f6064c.append("<br>");
                            }
                            this.f6064c.append(x3.trim());
                        }
                        arrayList.add(new C2167b(Html.fromHtml(this.f6064c.toString())));
                        if (i2 != 0) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w("SubripDecoder", "Skipping invalid timing: " + x2);
                    }
                } catch (NumberFormatException e) {
                    Log.w("SubripDecoder", "Skipping invalid index: " + x);
                }
            }
        }
    }
}
