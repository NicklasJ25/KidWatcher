package com.domobile.applock.chamber.p009c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p010b.C0778a;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.p003a.C0615f;
import com.domobile.applock.p013f.C0903a;
import com.domobile.frame.p000a.C1148d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class C0793b {

    static class C07861 implements ValueCallback<Boolean> {
        C07861() {
        }

        public void m1216a(Boolean bool) {
        }

        public /* synthetic */ void onReceiveValue(Object obj) {
            m1216a((Boolean) obj);
        }
    }

    static class C07872 implements ValueCallback<Boolean> {
        C07872() {
        }

        public void m1217a(Boolean bool) {
        }

        public /* synthetic */ void onReceiveValue(Object obj) {
            m1217a((Boolean) obj);
        }
    }

    private static String m1218a(int i, String str) {
        int lastIndexOf = str.lastIndexOf(".");
        String str2 = lastIndexOf == -1 ? str + "(" + i + ")" : str.substring(0, lastIndexOf) + "(" + i + ")" + str.substring(lastIndexOf);
        return new File(str2).exists() ? C0793b.m1218a(i + 1, str) : str2;
    }

    public static String m1219a(Context context) {
        return context.getFilesDir() + File.separator + "Browser" + File.separator + "Download";
    }

    @Nullable
    public static String m1220a(@NonNull Context context, @NonNull FileInfo fileInfo) {
        File file = new File(fileInfo.f1289c);
        String str = C0615f.f552e + File.separator + file.getName();
        if (!C0614e.m709a(file, new File(str))) {
            return null;
        }
        if (fileInfo.m1515b() != 10 && fileInfo.m1515b() != 11) {
            return str;
        }
        C0814g.m1297a(context, str);
        return str;
    }

    public static String m1221a(Context context, String str) {
        return C0793b.m1219a(context) + File.separator + str;
    }

    public static String m1222a(String str, String str2) {
        Object replaceAll;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str2) && str2.contains(Columns.FILENAME)) {
                str3 = str2.substring(str2.indexOf(";") + 1).split("=")[1];
            }
            replaceAll = str3.replaceAll("\\\"", "");
        } catch (Exception e) {
            Exception exception = e;
            String str4 = str3;
            exception.printStackTrace();
        }
        if (TextUtils.isEmpty(replaceAll)) {
            str3 = C0614e.m712c(str);
            if (str3.startsWith(".")) {
                replaceAll = System.currentTimeMillis() + str3;
            }
        }
        return TextUtils.isEmpty(replaceAll) ? System.currentTimeMillis() + "" : replaceAll;
    }

    public static void m1223a(Context context, String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            C0903a.m1593a(C0793b.m1229b(context, str), bitmap);
        }
    }

    public static void m1224a(final Context context, final ArrayList<BookmarkInfo> arrayList) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(Object... objArr) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    BookmarkInfo bookmarkInfo = (BookmarkInfo) it.next();
                    if (!C0778a.m1189c(bookmarkInfo.m1507a().getHost())) {
                        C0614e.m707a(bookmarkInfo.m1508a(context));
                    }
                }
                return null;
            }
        }, new Object[0]);
    }

    public static void m1225a(@NonNull WebView webView) {
        try {
            CookieManager instance = CookieManager.getInstance();
            if (VERSION.SDK_INT >= 21) {
                instance.setAcceptThirdPartyCookies(webView, true);
                instance.removeAllCookies(new C07861());
                instance.removeSessionCookies(new C07872());
            } else {
                instance.setAcceptCookie(true);
                instance.removeAllCookie();
            }
            if (VERSION.SDK_INT >= 21) {
                instance.flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            webView.clearMatches();
            webView.clearSslPreferences();
        } catch (Exception e) {
        }
    }

    public static void m1226a(@NonNull final FileInfo fileInfo) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(Object... objArr) {
                C0614e.m707a(fileInfo.f1289c);
                return null;
            }
        }, new Object[0]);
    }

    public static void m1227a(@NonNull final ArrayList<FileInfo> arrayList) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(Object... objArr) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0614e.m707a(((FileInfo) it.next()).f1289c);
                }
                return null;
            }
        }, new Object[0]);
    }

    public static String m1228b(Context context) {
        return context.getFilesDir() + File.separator + "Browser" + File.separator + "Favicon";
    }

    public static String m1229b(Context context, String str) {
        return C0793b.m1228b(context) + File.separator + str;
    }

    public static void m1230b(@NonNull Context context, @NonNull ArrayList<FileInfo> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0793b.m1220a(context, (FileInfo) it.next());
        }
    }

    public static String m1231c(Context context, String str) {
        String b = C0793b.m1229b(context, str);
        if (new File(b).exists()) {
            return b;
        }
        String str2 = "";
        do {
            int indexOf = str.indexOf(".");
            if (indexOf == -1) {
                return str2;
            }
            str = str.substring(indexOf + 1);
            b = C0793b.m1229b(context, "www." + str);
        } while (!new File(b).exists());
        return b;
    }

    public static void m1232c(final Context context) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(Object... objArr) {
                C0614e.m710b(C0793b.m1228b(context));
                return null;
            }
        }, new Object[0]);
    }

    public static String m1233d(Context context, String str) {
        String a = C0793b.m1221a(context, str);
        return !new File(a).exists() ? a : C0793b.m1218a(1, a);
    }

    public static void m1234d(@NonNull final Context context) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(Object... objArr) {
                C0614e.m710b(C0793b.m1219a(context));
                return null;
            }
        }, new Object[0]);
    }

    public static String m1235e(Context context, String str) {
        return "CN".equals(context.getResources().getConfiguration().locale.getCountry()) ? "https://www.baidu.com/s?wd=" + str : "https://www.google.com/search?q=" + str;
    }
}
