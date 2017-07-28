package com.domobile.eframe;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.domobile.applock.C1140x.C1133a;
import com.domobile.applock.C1140x.C1134b;
import com.domobile.applock.C1140x.C1135c;
import com.domobile.applock.C1140x.C1137e;
import com.domobile.applock.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class C1230g {
    public static final String f2424a = C1230g.m2895a("https://www.domobile.com/", "/apps/apks/");
    public static final String f2425b = C1230g.m2895a("https://www.domobile.com/", "/apps/icons/");
    public static final String f2426c = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final C1133a f2427d = new C1133a();
    public static final C1137e f2428e = new C1137e();
    public static final C1135c f2429f = new C1135c();
    public static final C1134b f2430g = new C1134b();

    public static class C1229a {
        private static final String[] f2423a = new String[]{"0", "1", GpsMeasureMode.MODE_2_DIMENSIONAL, GpsMeasureMode.MODE_3_DIMENSIONAL, "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        private C1229a() {
        }

        public static C1229a m2886a() {
            return new C1229a();
        }

        private static String m2887a(byte b) {
            int i;
            if (b < (byte) 0) {
                i = b + 256;
            }
            return f2423a[i / 16] + f2423a[i % 16];
        }

        private static String m2888a(byte[] bArr) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte a : bArr) {
                stringBuffer.append(C1229a.m2887a(a));
            }
            return stringBuffer.toString();
        }

        public String m2889a(String str) {
            String str2 = null;
            try {
                str2 = C1229a.m2888a(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
            } catch (Exception e) {
            }
            return str2;
        }
    }

    public static int m2890a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String m2891a() {
        return Locale.getDefault().getCountry().toLowerCase();
    }

    public static String m2892a(Context context, String str) {
        return context.getSharedPreferences("domo_push_prefs", 0).getString(str, null);
    }

    public static String m2893a(String str) {
        String str2 = "";
        try {
            String readLine = new BufferedReader(new FileReader(C1230g.m2899b(str))).readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2.trim();
    }

    public static String m2894a(JSONObject jSONObject, String str) {
        if (jSONObject.has(str) && !jSONObject.isNull(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public static String m2895a(Object... objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object append : objArr) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public static void m2896a(Context context, String str, Object obj) {
        Editor edit = context.getSharedPreferences("domo_push_prefs", 0).edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        }
        edit.commit();
    }

    public static void m2897a(String str, String str2) {
        Throwable th;
        File file = new File(C1230g.m2899b(str));
        BufferedWriter bufferedWriter = null;
        BufferedWriter bufferedWriter2;
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(str2);
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedWriter2 = null;
            th = th4;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            throw th;
        }
    }

    public static String m2898b(Context context) {
        return context.getString(R.string.language_values);
    }

    public static String m2899b(String str) {
        return C1230g.m2895a(f2426c, "/domobile/.cache/", C1229a.m2886a().m2889a(str));
    }
}
