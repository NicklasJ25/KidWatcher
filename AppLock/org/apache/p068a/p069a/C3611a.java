package org.apache.p068a.p069a;

import java.nio.charset.Charset;

public class C3611a {
    public static final Charset f12296a = Charset.forName("ISO-8859-1");
    public static final Charset f12297b = Charset.forName("US-ASCII");
    public static final Charset f12298c = Charset.forName("UTF-16");
    public static final Charset f12299d = Charset.forName("UTF-16BE");
    public static final Charset f12300e = Charset.forName("UTF-16LE");
    public static final Charset f12301f = Charset.forName("UTF-8");

    public static Charset m15722a(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    public static Charset m15723a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
