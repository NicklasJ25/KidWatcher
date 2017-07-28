package com.google.android.exoplayer2.p043j;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C2254c {
    private static final Pattern f6418a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern f6419b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern f6420c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> f6421d = new HashMap();

    static {
        f6421d.put("aliceblue", Integer.valueOf(-984833));
        f6421d.put("antiquewhite", Integer.valueOf(-332841));
        f6421d.put("aqua", Integer.valueOf(-16711681));
        f6421d.put("aquamarine", Integer.valueOf(-8388652));
        f6421d.put("azure", Integer.valueOf(-983041));
        f6421d.put("beige", Integer.valueOf(-657956));
        f6421d.put("bisque", Integer.valueOf(-6972));
        f6421d.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        f6421d.put("blanchedalmond", Integer.valueOf(-5171));
        f6421d.put("blue", Integer.valueOf(-16776961));
        f6421d.put("blueviolet", Integer.valueOf(-7722014));
        f6421d.put("brown", Integer.valueOf(-5952982));
        f6421d.put("burlywood", Integer.valueOf(-2180985));
        f6421d.put("cadetblue", Integer.valueOf(-10510688));
        f6421d.put("chartreuse", Integer.valueOf(-8388864));
        f6421d.put("chocolate", Integer.valueOf(-2987746));
        f6421d.put("coral", Integer.valueOf(-32944));
        f6421d.put("cornflowerblue", Integer.valueOf(-10185235));
        f6421d.put("cornsilk", Integer.valueOf(-1828));
        f6421d.put("crimson", Integer.valueOf(-2354116));
        f6421d.put("cyan", Integer.valueOf(-16711681));
        f6421d.put("darkblue", Integer.valueOf(-16777077));
        f6421d.put("darkcyan", Integer.valueOf(-16741493));
        f6421d.put("darkgoldenrod", Integer.valueOf(-4684277));
        f6421d.put("darkgray", Integer.valueOf(-5658199));
        f6421d.put("darkgreen", Integer.valueOf(-16751616));
        f6421d.put("darkgrey", Integer.valueOf(-5658199));
        f6421d.put("darkkhaki", Integer.valueOf(-4343957));
        f6421d.put("darkmagenta", Integer.valueOf(-7667573));
        f6421d.put("darkolivegreen", Integer.valueOf(-11179217));
        f6421d.put("darkorange", Integer.valueOf(-29696));
        f6421d.put("darkorchid", Integer.valueOf(-6737204));
        f6421d.put("darkred", Integer.valueOf(-7667712));
        f6421d.put("darksalmon", Integer.valueOf(-1468806));
        f6421d.put("darkseagreen", Integer.valueOf(-7357297));
        f6421d.put("darkslateblue", Integer.valueOf(-12042869));
        f6421d.put("darkslategray", Integer.valueOf(-13676721));
        f6421d.put("darkslategrey", Integer.valueOf(-13676721));
        f6421d.put("darkturquoise", Integer.valueOf(-16724271));
        f6421d.put("darkviolet", Integer.valueOf(-7077677));
        f6421d.put("deeppink", Integer.valueOf(-60269));
        f6421d.put("deepskyblue", Integer.valueOf(-16728065));
        f6421d.put("dimgray", Integer.valueOf(-9868951));
        f6421d.put("dimgrey", Integer.valueOf(-9868951));
        f6421d.put("dodgerblue", Integer.valueOf(-14774017));
        f6421d.put("firebrick", Integer.valueOf(-5103070));
        f6421d.put("floralwhite", Integer.valueOf(-1296));
        f6421d.put("forestgreen", Integer.valueOf(-14513374));
        f6421d.put("fuchsia", Integer.valueOf(-65281));
        f6421d.put("gainsboro", Integer.valueOf(-2302756));
        f6421d.put("ghostwhite", Integer.valueOf(-460545));
        f6421d.put("gold", Integer.valueOf(-10496));
        f6421d.put("goldenrod", Integer.valueOf(-2448096));
        f6421d.put("gray", Integer.valueOf(-8355712));
        f6421d.put("green", Integer.valueOf(-16744448));
        f6421d.put("greenyellow", Integer.valueOf(-5374161));
        f6421d.put("grey", Integer.valueOf(-8355712));
        f6421d.put("honeydew", Integer.valueOf(-983056));
        f6421d.put("hotpink", Integer.valueOf(-38476));
        f6421d.put("indianred", Integer.valueOf(-3318692));
        f6421d.put("indigo", Integer.valueOf(-11861886));
        f6421d.put("ivory", Integer.valueOf(-16));
        f6421d.put("khaki", Integer.valueOf(-989556));
        f6421d.put("lavender", Integer.valueOf(-1644806));
        f6421d.put("lavenderblush", Integer.valueOf(-3851));
        f6421d.put("lawngreen", Integer.valueOf(-8586240));
        f6421d.put("lemonchiffon", Integer.valueOf(-1331));
        f6421d.put("lightblue", Integer.valueOf(-5383962));
        f6421d.put("lightcoral", Integer.valueOf(-1015680));
        f6421d.put("lightcyan", Integer.valueOf(-2031617));
        f6421d.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        f6421d.put("lightgray", Integer.valueOf(-2894893));
        f6421d.put("lightgreen", Integer.valueOf(-7278960));
        f6421d.put("lightgrey", Integer.valueOf(-2894893));
        f6421d.put("lightpink", Integer.valueOf(-18751));
        f6421d.put("lightsalmon", Integer.valueOf(-24454));
        f6421d.put("lightseagreen", Integer.valueOf(-14634326));
        f6421d.put("lightskyblue", Integer.valueOf(-7876870));
        f6421d.put("lightslategray", Integer.valueOf(-8943463));
        f6421d.put("lightslategrey", Integer.valueOf(-8943463));
        f6421d.put("lightsteelblue", Integer.valueOf(-5192482));
        f6421d.put("lightyellow", Integer.valueOf(-32));
        f6421d.put("lime", Integer.valueOf(-16711936));
        f6421d.put("limegreen", Integer.valueOf(-13447886));
        f6421d.put("linen", Integer.valueOf(-331546));
        f6421d.put("magenta", Integer.valueOf(-65281));
        f6421d.put("maroon", Integer.valueOf(-8388608));
        f6421d.put("mediumaquamarine", Integer.valueOf(-10039894));
        f6421d.put("mediumblue", Integer.valueOf(-16777011));
        f6421d.put("mediumorchid", Integer.valueOf(-4565549));
        f6421d.put("mediumpurple", Integer.valueOf(-7114533));
        f6421d.put("mediumseagreen", Integer.valueOf(-12799119));
        f6421d.put("mediumslateblue", Integer.valueOf(-8689426));
        f6421d.put("mediumspringgreen", Integer.valueOf(-16713062));
        f6421d.put("mediumturquoise", Integer.valueOf(-12004916));
        f6421d.put("mediumvioletred", Integer.valueOf(-3730043));
        f6421d.put("midnightblue", Integer.valueOf(-15132304));
        f6421d.put("mintcream", Integer.valueOf(-655366));
        f6421d.put("mistyrose", Integer.valueOf(-6943));
        f6421d.put("moccasin", Integer.valueOf(-6987));
        f6421d.put("navajowhite", Integer.valueOf(-8531));
        f6421d.put("navy", Integer.valueOf(-16777088));
        f6421d.put("oldlace", Integer.valueOf(-133658));
        f6421d.put("olive", Integer.valueOf(-8355840));
        f6421d.put("olivedrab", Integer.valueOf(-9728477));
        f6421d.put("orange", Integer.valueOf(-23296));
        f6421d.put("orangered", Integer.valueOf(-47872));
        f6421d.put("orchid", Integer.valueOf(-2461482));
        f6421d.put("palegoldenrod", Integer.valueOf(-1120086));
        f6421d.put("palegreen", Integer.valueOf(-6751336));
        f6421d.put("paleturquoise", Integer.valueOf(-5247250));
        f6421d.put("palevioletred", Integer.valueOf(-2396013));
        f6421d.put("papayawhip", Integer.valueOf(-4139));
        f6421d.put("peachpuff", Integer.valueOf(-9543));
        f6421d.put("peru", Integer.valueOf(-3308225));
        f6421d.put("pink", Integer.valueOf(-16181));
        f6421d.put("plum", Integer.valueOf(-2252579));
        f6421d.put("powderblue", Integer.valueOf(-5185306));
        f6421d.put("purple", Integer.valueOf(-8388480));
        f6421d.put("rebeccapurple", Integer.valueOf(-10079335));
        f6421d.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
        f6421d.put("rosybrown", Integer.valueOf(-4419697));
        f6421d.put("royalblue", Integer.valueOf(-12490271));
        f6421d.put("saddlebrown", Integer.valueOf(-7650029));
        f6421d.put("salmon", Integer.valueOf(-360334));
        f6421d.put("sandybrown", Integer.valueOf(-744352));
        f6421d.put("seagreen", Integer.valueOf(-13726889));
        f6421d.put("seashell", Integer.valueOf(-2578));
        f6421d.put("sienna", Integer.valueOf(-6270419));
        f6421d.put("silver", Integer.valueOf(-4144960));
        f6421d.put("skyblue", Integer.valueOf(-7876885));
        f6421d.put("slateblue", Integer.valueOf(-9807155));
        f6421d.put("slategray", Integer.valueOf(-9404272));
        f6421d.put("slategrey", Integer.valueOf(-9404272));
        f6421d.put("snow", Integer.valueOf(-1286));
        f6421d.put("springgreen", Integer.valueOf(-16711809));
        f6421d.put("steelblue", Integer.valueOf(-12156236));
        f6421d.put("tan", Integer.valueOf(-2968436));
        f6421d.put("teal", Integer.valueOf(-16744320));
        f6421d.put("thistle", Integer.valueOf(-2572328));
        f6421d.put("tomato", Integer.valueOf(-40121));
        f6421d.put("transparent", Integer.valueOf(0));
        f6421d.put("turquoise", Integer.valueOf(-12525360));
        f6421d.put("violet", Integer.valueOf(-1146130));
        f6421d.put("wheat", Integer.valueOf(-663885));
        f6421d.put("white", Integer.valueOf(-1));
        f6421d.put("whitesmoke", Integer.valueOf(-657931));
        f6421d.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        f6421d.put("yellowgreen", Integer.valueOf(-6632142));
    }

    private static int m7029a(int i, int i2, int i3) {
        return C2254c.m7030a(255, i, i2, i3);
    }

    private static int m7030a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    public static int m7031a(String str) {
        return C2254c.m7032a(str, false);
    }

    private static int m7032a(String str, boolean z) {
        C2252a.m7022a(!TextUtils.isEmpty(str));
        Object replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return parseLong | ViewCompat.MEASURED_STATE_MASK;
            }
            if (replace.length() == 9) {
                return (parseLong >>> 8) | ((parseLong & 255) << 24);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? f6420c : f6419b).matcher(replace);
            if (matcher.matches()) {
                return C2254c.m7030a(z ? (int) (255.0f * Float.parseFloat(matcher.group(4))) : Integer.parseInt(matcher.group(4), 10), Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f6418a.matcher(replace);
            if (matcher2.matches()) {
                return C2254c.m7029a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = (Integer) f6421d.get(C2273r.m7141d(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    public static int m7033b(String str) {
        return C2254c.m7032a(str, true);
    }
}
