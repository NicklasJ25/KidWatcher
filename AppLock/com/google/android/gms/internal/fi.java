package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class fi {
    public static final Uri f8914a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri f8915b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern f8916c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern f8917d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    static HashMap<String, String> f8918e;
    static String[] f8919f = new String[0];
    private static final AtomicBoolean f8920g = new AtomicBoolean();
    private static Object f8921h;
    private static boolean f8922i;

    class C28601 extends ContentObserver {
        C28601(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            fi.f8920g.set(true);
        }
    }

    public static long m10761a(ContentResolver contentResolver, String str, long j) {
        String a = m10762a(contentResolver, str);
        if (a != null) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    @Deprecated
    public static String m10762a(ContentResolver contentResolver, String str) {
        return m10763a(contentResolver, str, null);
    }

    public static String m10763a(ContentResolver contentResolver, String str, String str2) {
        synchronized (fi.class) {
            m10766a(contentResolver);
            Object obj = f8921h;
            String str3;
            if (f8918e.containsKey(str)) {
                str3 = (String) f8918e.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                String[] strArr = f8919f;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (str.startsWith(strArr[i])) {
                        if (!f8922i || f8918e.isEmpty()) {
                            m10770c(contentResolver, f8919f);
                            if (f8918e.containsKey(str)) {
                                str3 = (String) f8918e.get(str);
                                if (str3 != null) {
                                    str2 = str3;
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
                Cursor query = contentResolver.query(f8914a, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str3 = query.getString(1);
                            if (str3 != null && str3.equals(str2)) {
                                str3 = str2;
                            }
                            m10767a(obj, str, str3);
                            if (str3 != null) {
                                str2 = str3;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                m10767a(obj, str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str2;
    }

    public static Map<String, String> m10764a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f8915b, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void m10766a(ContentResolver contentResolver) {
        if (f8918e == null) {
            f8920g.set(false);
            f8918e = new HashMap();
            f8921h = new Object();
            f8922i = false;
            contentResolver.registerContentObserver(f8914a, true, new C28601(null));
        } else if (f8920g.getAndSet(false)) {
            f8918e.clear();
            f8921h = new Object();
            f8922i = false;
        }
    }

    private static void m10767a(Object obj, String str, String str2) {
        synchronized (fi.class) {
            if (obj == f8921h) {
                f8918e.put(str, str2);
            }
        }
    }

    private static String[] m10768a(String[] strArr) {
        HashSet hashSet = new HashSet((((f8919f.length + strArr.length) * 4) / 3) + 1);
        hashSet.addAll(Arrays.asList(f8919f));
        ArrayList arrayList = new ArrayList();
        for (Object obj : strArr) {
            if (hashSet.add(obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return new String[0];
        }
        f8919f = (String[]) hashSet.toArray(new String[hashSet.size()]);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void m10769b(ContentResolver contentResolver, String... strArr) {
        if (strArr.length != 0) {
            synchronized (fi.class) {
                m10766a(contentResolver);
                String[] a = m10768a(strArr);
                if (!f8922i || f8918e.isEmpty()) {
                    m10770c(contentResolver, f8919f);
                } else if (a.length != 0) {
                    m10770c(contentResolver, a);
                }
            }
        }
    }

    private static void m10770c(ContentResolver contentResolver, String[] strArr) {
        f8918e.putAll(m10764a(contentResolver, strArr));
        f8922i = true;
    }
}
