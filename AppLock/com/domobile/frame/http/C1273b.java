package com.domobile.frame.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;

public class C1273b {
    public static String f2621a = null;
    private static CookieManager f2622b;

    public static final String m3035a(C1275d c1275d) {
        if (f2622b == null) {
            CookieHandler.setDefault(new CookieManager());
        }
        return C1274c.m3037a(c1275d.f2627e, c1275d.f2623a, c1275d.f2626d, c1275d.f2624b);
    }

    public static String m3036a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(readLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
