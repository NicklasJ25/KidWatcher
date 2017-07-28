package com.domobile.applock.p003a;

import java.security.GeneralSecurityException;

public class C0611b {
    public static String m697a(String str, String str2) {
        try {
            return C0610a.m692a(str, str2);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String m698b(String str, String str2) {
        try {
            return C0610a.m695b(str, str2);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return "";
        }
    }
}
