package com.domobile.applock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.android.gallery3d.common.Entry.Columns;
import com.domobile.applock.aj.C0721a;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.C1371j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class C1017n {
    public static final int m2031a(long j) {
        return C1217c.m2853a().delete("locks", C1147a.m2480a("sid=", Long.valueOf(j)), null);
    }

    public static final Cursor m2032a() {
        return C1217c.m2853a().rawQuery("select * from lock", null);
    }

    public static final void m2033a(long j, HashMap<String, Integer> hashMap) {
        C1217c.m2853a().beginTransaction();
        try {
            Object[] toArray = hashMap.keySet().toArray();
            int length = toArray.length;
            for (int i = 0; i < length; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("sid", Long.valueOf(j));
                contentValues.put("pname", (String) toArray[i]);
                contentValues.put("type", (Integer) hashMap.get(toArray[i]));
                C1217c.m2853a().insert("locks", null, contentValues);
            }
            C1217c.m2853a().setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C1217c.m2853a().endTransaction();
        }
    }

    private static final void m2034a(Context context) {
        try {
            C1217c.m2853a().delete("lock", null, null);
            C0721a.m994a(context);
        } catch (Exception e) {
        }
    }

    public static final void m2035a(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", str);
        contentValues.put("type", Integer.valueOf(i));
        C1217c.m2853a().insert("lock", null, contentValues);
    }

    public static final void m2036a(ArrayList<String> arrayList, int i) {
        C1217c.m2853a().beginTransaction();
        try {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1017n.m2035a((String) arrayList.get(i2), i);
            }
            C1217c.m2853a().setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C1217c.m2853a().endTransaction();
        }
    }

    public static final void m2037a(String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            C1217c.m2853a().delete("lock", "pname=?", new String[]{strArr[i]});
        }
    }

    public static final Cursor m2038b(long j) {
        return C1217c.m2853a().query("locks", new String[]{Columns.ID, "pname", "type"}, C1147a.m2480a("sid=", Long.valueOf(j)), null, null, null, null);
    }

    public static ArrayList<C1371j> m2039b() {
        ArrayList<C1371j> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = C1017n.m2032a();
            if (cursor != null && cursor.getCount() != 0) {
                while (cursor.moveToNext()) {
                    C1371j c1371j = new C1371j();
                    if (cursor.getString(0) != null) {
                        c1371j.f2960a = cursor.getInt(0);
                    }
                    if (cursor.getString(1) != null) {
                        c1371j.f2962c = cursor.getString(1);
                    }
                    if (cursor.getString(2) != null) {
                        c1371j.f2961b = cursor.getInt(2);
                    }
                    arrayList.add(c1371j);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m2040b(android.content.Context r5) {
        /*
        r2 = -3;
        r1 = new java.util.HashMap;
        r1.<init>();
        com.domobile.applock.C1017n.m2031a(r2);
        r0 = 0;
        r0 = com.domobile.applock.C1017n.m2032a();	 Catch:{ Exception -> 0x003a, all -> 0x00ba }
        if (r0 == 0) goto L_0x0041;
    L_0x0011:
        r2 = r0.getCount();	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 <= 0) goto L_0x0041;
    L_0x0017:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x0041;
    L_0x001d:
        r2 = 1;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 != 0) goto L_0x0017;
    L_0x0028:
        r2 = 1;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r3 = 2;
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        goto L_0x0017;
    L_0x003a:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0040;
    L_0x003d:
        r0.close();
    L_0x0040:
        return;
    L_0x0041:
        r2 = "incall_locked";
        r3 = 0;
        r2 = com.domobile.applock.C1150y.m2592a(r5, r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x0054;
    L_0x004a:
        r2 = "com.android.phone";
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
    L_0x0054:
        r2 = "appdetail_locked";
        r3 = 0;
        r2 = com.domobile.applock.C1150y.m2592a(r5, r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x0067;
    L_0x005d:
        r2 = "com.domobile.elock.appdetail";
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
    L_0x0067:
        r2 = "key_locked_2g3g_state";
        r2 = com.domobile.applock.aj.C0721a.m998b(r5, r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x0079;
    L_0x006f:
        r2 = "key_locked_2g3g_state";
        r3 = 2;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
    L_0x0079:
        r2 = "key_locked_bluetooth_state";
        r2 = com.domobile.applock.aj.C0721a.m998b(r5, r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x008b;
    L_0x0081:
        r2 = "key_locked_bluetooth_state";
        r3 = 2;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
    L_0x008b:
        r2 = "key_locked_autosync_state";
        r2 = com.domobile.applock.aj.C0721a.m998b(r5, r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x009d;
    L_0x0093:
        r2 = "key_locked_autosync_state";
        r3 = 2;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
    L_0x009d:
        r2 = "key_locked_wifi_state";
        r2 = com.domobile.applock.aj.C0721a.m998b(r5, r2);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r2 == 0) goto L_0x00af;
    L_0x00a5:
        r2 = "key_locked_wifi_state";
        r3 = 2;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
    L_0x00af:
        r2 = -3;
        com.domobile.applock.C1017n.m2033a(r2, r1);	 Catch:{ Exception -> 0x003a, all -> 0x00c4 }
        if (r0 == 0) goto L_0x0040;
    L_0x00b6:
        r0.close();
        goto L_0x0040;
    L_0x00ba:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x00be:
        if (r1 == 0) goto L_0x00c3;
    L_0x00c0:
        r1.close();
    L_0x00c3:
        throw r0;
    L_0x00c4:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.n.b(android.content.Context):void");
    }

    public static boolean m2041c(long j) {
        Exception e;
        boolean z;
        Throwable th;
        Context b = AppLockApplication.m577b();
        C1150y.m2598b(b).m2665a(b, true);
        if (j == -1) {
            C1017n.m2040b(b);
            C1148d.m2520b(b, "incall_locked", (Object) Boolean.valueOf(false));
            C1148d.m2520b(b, "appdetail_locked", (Object) Boolean.valueOf(false));
            C1017n.m2034a(b);
            C1148d.m2520b(b, "actived_profile", (Object) Long.valueOf(j));
            C1148d.m2489A(b, "com.domobile.applock.ACTION_ACTIVED_PROFILE");
            return true;
        }
        Cursor query;
        try {
            query = C1217c.m2853a().query("locks", new String[]{"pname", "type"}, C1147a.m2480a("sid=", Long.valueOf(j)), null, null, null, null);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (query != null && query.getCount() > 0) {
                while (query.moveToNext() && !query.isAfterLast()) {
                    int i = query.getInt(1);
                    if (i == 0) {
                        arrayList.add(query.getString(0));
                    } else if (i == 2) {
                        try {
                            arrayList3.add(query.getString(0));
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } else {
                        arrayList2.add(query.getString(0));
                    }
                }
            }
            C1148d.m2520b(b, "incall_locked", (Object) Boolean.valueOf(arrayList.contains("com.android.phone")));
            arrayList.remove("com.android.phone");
            C1148d.m2520b(b, "appdetail_locked", (Object) Boolean.valueOf(arrayList.contains("com.domobile.elock.appdetail")));
            arrayList.remove("com.domobile.elock.appdetail");
            C1017n.m2034a(b);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                C0721a.m995a(b, (String) it.next(), true);
            }
            if (!arrayList2.isEmpty()) {
                C1017n.m2036a(arrayList2, 1);
            }
            if (!arrayList.isEmpty()) {
                C1017n.m2036a(arrayList, 0);
            }
            C1148d.m2520b(b, "actived_profile", (Object) Long.valueOf(j));
            if (query != null) {
                query.close();
            }
            C1148d.m2489A(b, "com.domobile.applock.ACTION_ACTIVED_PROFILE");
            z = true;
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                e.printStackTrace();
                if (query != null) {
                    query.close();
                }
                z = false;
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return z;
    }
}
