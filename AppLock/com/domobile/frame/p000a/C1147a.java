package com.domobile.frame.p000a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1165i;
import com.domobile.p015b.C1168b.C1166j;
import java.io.File;

public class C1147a {
    public static final String f2193L = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String f2194M = C1147a.m2480a(f2193L, File.separator, "domobile", File.separator);
    public static final String f2195N = C1147a.m2480a(f2194M, ".cache", File.separator);
    public static final int f2196O = VERSION.SDK_INT;
    public static final String f2197P = Build.MODEL;
    public static final boolean f2198Q = (f2196O >= 14);
    public static final boolean f2199R;
    public static final C1161e f2200S = new C1161e();
    public static final C1165i f2201T = new C1165i();
    public static final C1163g f2202U = new C1163g();
    public static final C1166j f2203V = new C1166j();
    public static final C1162f f2204W = new C1162f();

    static {
        boolean z = true;
        if (f2196O < 21) {
            z = false;
        }
        f2199R = z;
    }

    public static String m2480a(Object... objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (objArr != null) {
            for (Object append : objArr) {
                stringBuffer.append(append);
            }
        }
        return stringBuffer.toString();
    }

    public static void m2481a(Object obj) {
        C1258c.m2986a(obj);
    }

    public static int ac(Context context) {
        return context.getSharedPreferences("eLock", 0).getInt("version", 0);
    }

    public static void m2482b(Object... objArr) {
        C1258c.m2986a(objArr);
    }

    public static void m2483c(Context context, int i) {
        Editor edit = context.getSharedPreferences("eLock", 0).edit();
        edit.putInt("version", i);
        edit.commit();
    }

    public static boolean m2484c() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static final void m2485d(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }

    public static final void m2486e(Context context, int i) {
        Toast.makeText(context, i, 1).show();
    }

    public static final void m2487w(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static final void m2488x(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }
}
