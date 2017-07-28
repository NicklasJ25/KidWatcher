package com.google.android.gms.internal;

import java.net.URI;

public class gn {
    private final String f9035a;
    private final String f9036b;
    private final boolean f9037c;

    public gn(String str, String str2, boolean z) {
        this.f9035a = str;
        this.f9036b = str2;
        this.f9037c = z;
    }

    public static URI m11077a(String str, boolean z, String str2, String str3) {
        String str4 = z ? "wss" : "ws";
        String valueOf = String.valueOf("v");
        String valueOf2 = String.valueOf("5");
        str4 = new StringBuilder(((((String.valueOf(str4).length() + 13) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append(str4).append("://").append(str).append("/.ws?ns=").append(str2).append("&").append(valueOf).append("=").append(valueOf2).toString();
        if (str3 != null) {
            str4 = String.valueOf(str4);
            valueOf = String.valueOf("&ls=");
            str4 = new StringBuilder((String.valueOf(str4).length() + String.valueOf(valueOf).length()) + String.valueOf(str3).length()).append(str4).append(valueOf).append(str3).toString();
        }
        return URI.create(str4);
    }

    public String m11078a() {
        return this.f9035a;
    }

    public String m11079b() {
        return this.f9036b;
    }

    public boolean m11080c() {
        return this.f9037c;
    }

    public String toString() {
        String str = this.f9037c ? "s" : "";
        String str2 = this.f9035a;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
