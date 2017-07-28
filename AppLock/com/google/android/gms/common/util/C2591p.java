package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class C2591p {
    private static String f7565a = null;
    private static final int f7566b = Process.myPid();

    public static String m8319a() {
        if (f7565a == null) {
            f7565a = C2591p.m8320a(f7566b);
        }
        return f7565a;
    }

    static String m8320a(int i) {
        Throwable th;
        String str = null;
        if (i > 0) {
            ThreadPolicy allowThreadDiskReads;
            Closeable bufferedReader;
            try {
                allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
                try {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    str = bufferedReader.readLine().trim();
                    C2586k.m8301a(bufferedReader);
                } catch (IOException e) {
                    C2586k.m8301a(bufferedReader);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C2586k.m8301a(bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = str;
                C2586k.m8301a(bufferedReader);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = str;
                th = th4;
                C2586k.m8301a(bufferedReader);
                throw th;
            }
        }
        return str;
    }
}
