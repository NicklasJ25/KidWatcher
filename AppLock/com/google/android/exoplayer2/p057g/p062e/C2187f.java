package com.google.android.exoplayer2.p057g.p062e;

import android.text.Layout.Alignment;
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
import android.util.Log;
import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.domobile.lockbean.Location;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p057g.p062e.C2184e.C2183a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class C2187f {
    public static final Pattern f6166a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern f6167b = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder f6168c = new StringBuilder();

    private static final class C2185a {
        private static final String[] f6159e = new String[0];
        public final String f6160a;
        public final int f6161b;
        public final String f6162c;
        public final String[] f6163d;

        private C2185a(String str, int i, String str2, String[] strArr) {
            this.f6161b = i;
            this.f6160a = str;
            this.f6162c = str2;
            this.f6163d = strArr;
        }

        public static C2185a m6778a() {
            return new C2185a("", 0, "", new String[0]);
        }

        public static C2185a m6779a(String str, int i) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            String str2;
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = trim;
                trim = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                str2 = trim.substring(0, indexOf);
                trim = trim2;
            }
            String[] split = str2.split("\\.");
            return new C2185a(split[0], i, trim, split.length > 1 ? (String[]) Arrays.copyOfRange(split, 1, split.length) : f6159e);
        }
    }

    private static final class C2186b implements Comparable<C2186b> {
        public final int f6164a;
        public final C2181d f6165b;

        public C2186b(int i, C2181d c2181d) {
            this.f6164a = i;
            this.f6165b = c2181d;
        }

        public int m6780a(C2186b c2186b) {
            return this.f6164a - c2186b.f6164a;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m6780a((C2186b) obj);
        }
    }

    private static int m6781a(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(Location.CODE_START)) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                Log.w("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int m6782a(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void m6783a(SpannableStringBuilder spannableStringBuilder, C2181d c2181d, int i, int i2) {
        if (c2181d != null) {
            if (c2181d.m6747b() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(c2181d.m6747b()), i, i2, 33);
            }
            if (c2181d.m6753c()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
            if (c2181d.m6755d()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (c2181d.m6758g()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(c2181d.m6757f()), i, i2, 33);
            }
            if (c2181d.m6760i()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(c2181d.m6759h()), i, i2, 33);
            }
            if (c2181d.m6756e() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(c2181d.m6756e()), i, i2, 33);
            }
            if (c2181d.m6761j() != null) {
                spannableStringBuilder.setSpan(new Standard(c2181d.m6761j()), i, i2, 33);
            }
            if (c2181d.m6762k() != -1) {
                switch (c2181d.m6762k()) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c2181d.m6763l(), true), i, i2, 33);
                        return;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(c2181d.m6763l()), i, i2, 33);
                        return;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(c2181d.m6763l() / 100.0f), i, i2, 33);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static void m6784a(String str, SpannableStringBuilder spannableStringBuilder) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    obj = 1;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    obj = null;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    obj = 3;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                spannableStringBuilder.append('<');
                return;
            case 1:
                spannableStringBuilder.append('>');
                return;
            case 2:
                spannableStringBuilder.append(' ');
                return;
            case 3:
                spannableStringBuilder.append('&');
                return;
            default:
                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    static void m6785a(String str, C2183a c2183a) {
        Matcher matcher = f6167b.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    C2187f.m6791b(group2, c2183a);
                } else if ("align".equals(group)) {
                    c2183a.m6768a(C2187f.m6790b(group2));
                } else if ("position".equals(group)) {
                    C2187f.m6792c(group2, c2183a);
                } else if (Columns.SIZE.equals(group)) {
                    c2183a.m6775c(C2189h.m6802b(group2));
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException e) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    private static void m6786a(String str, C2185a c2185a, SpannableStringBuilder spannableStringBuilder, List<C2181d> list, List<C2186b> list2) {
        int i = c2185a.f6161b;
        int length = spannableStringBuilder.length();
        String str2 = c2185a.f6160a;
        int i2 = -1;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    i2 = 6;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    i2 = 0;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    i2 = 3;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    i2 = 1;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    i2 = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    i2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    i2 = 4;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                return;
        }
        list2.clear();
        C2187f.m6788a((List) list, str, c2185a, (List) list2);
        int size = list2.size();
        for (i2 = 0; i2 < size; i2++) {
            C2187f.m6783a(spannableStringBuilder, ((C2186b) list2.get(i2)).f6165b, i, length);
        }
    }

    static void m6787a(String str, String str2, C2183a c2183a, List<C2181d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        List arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int indexOf;
            switch (charAt) {
                case '&':
                    indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                    C2187f.m6784a(str2.substring(i + 1, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                    break;
                case '<':
                    if (i + 1 < str2.length()) {
                        Object obj = str2.charAt(i + 1) == '/' ? 1 : null;
                        indexOf = C2187f.m6782a(str2, i + 1);
                        Object obj2 = str2.charAt(indexOf + -2) == '/' ? 1 : null;
                        String substring = str2.substring((obj != null ? 2 : 1) + i, obj2 != null ? indexOf - 2 : indexOf - 1);
                        String d = C2187f.m6794d(substring);
                        if (d != null) {
                            if (C2187f.m6793c(d)) {
                                if (obj == null) {
                                    if (obj2 == null) {
                                        stack.push(C2185a.m6779a(substring, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    C2185a c2185a = (C2185a) stack.pop();
                                    C2187f.m6786a(str, c2185a, spannableStringBuilder, list, arrayList);
                                    if (c2185a.f6160a.equals(d)) {
                                        i = indexOf;
                                        break;
                                    }
                                }
                                i = indexOf;
                            } else {
                                i = indexOf;
                                break;
                            }
                        }
                        i = indexOf;
                        break;
                    }
                    i++;
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            C2187f.m6786a(str, (C2185a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        C2187f.m6786a(str, C2185a.m6778a(), spannableStringBuilder, list, arrayList);
        c2183a.m6769a(spannableStringBuilder);
    }

    private static void m6788a(List<C2181d> list, String str, C2185a c2185a, List<C2186b> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2181d c2181d = (C2181d) list.get(i);
            int a = c2181d.m6741a(str, c2185a.f6160a, c2185a.f6163d, c2185a.f6162c);
            if (a > 0) {
                list2.add(new C2186b(a, c2181d));
            }
        }
        Collections.sort(list2);
    }

    private static boolean m6789a(String str, Matcher matcher, C2263k c2263k, C2183a c2183a, StringBuilder stringBuilder, List<C2181d> list) {
        try {
            c2183a.m6767a(C2189h.m6800a(matcher.group(1))).m6773b(C2189h.m6800a(matcher.group(2)));
            C2187f.m6785a(matcher.group(3), c2183a);
            stringBuilder.setLength(0);
            while (true) {
                String x = c2263k.m7096x();
                if (x == null || x.isEmpty()) {
                    C2187f.m6787a(str, stringBuilder.toString(), c2183a, (List) list);
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(x.trim());
                }
            }
            C2187f.m6787a(str, stringBuilder.toString(), c2183a, (List) list);
            return true;
        } catch (NumberFormatException e) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static Alignment m6790b(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    obj = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    obj = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    obj = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    obj = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    obj = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(Location.CODE_START)) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
                return Alignment.ALIGN_NORMAL;
            case 2:
            case 3:
                return Alignment.ALIGN_CENTER;
            case 4:
            case 5:
                return Alignment.ALIGN_OPPOSITE;
            default:
                Log.w("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    private static void m6791b(String str, C2183a c2183a) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            c2183a.m6772b(C2187f.m6781a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            c2183a.m6772b(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            c2183a.m6765a(C2189h.m6802b(str)).m6766a(0);
        } else {
            c2183a.m6765a((float) Integer.parseInt(str)).m6766a(1);
        }
    }

    private static void m6792c(String str, C2183a c2183a) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            c2183a.m6776c(C2187f.m6781a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            c2183a.m6776c(Integer.MIN_VALUE);
        }
        c2183a.m6771b(C2189h.m6802b(str));
    }

    private static boolean m6793c(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    z = false;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    z = true;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    z = true;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    z = true;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    z = true;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    private static String m6794d(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? null : trim.split("[ \\.]")[0];
    }

    boolean m6795a(C2263k c2263k, C2183a c2183a, List<C2181d> list) {
        Object x = c2263k.m7096x();
        Matcher matcher = f6166a.matcher(x);
        if (matcher.matches()) {
            return C2187f.m6789a(null, matcher, c2263k, c2183a, this.f6168c, list);
        }
        matcher = f6166a.matcher(c2263k.m7096x());
        if (!matcher.matches()) {
            return false;
        }
        return C2187f.m6789a(x.trim(), matcher, c2263k, c2183a, this.f6168c, list);
    }
}
