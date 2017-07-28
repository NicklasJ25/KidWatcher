package com.domobile.applock.p012e;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class C0900e {
    @NonNull
    private static C0899d m1578a(Cursor cursor) {
        C0899d c0899d = new C0899d();
        c0899d.f1340a = cursor.getString(cursor.getColumnIndex("logicId"));
        c0899d.f1341b = cursor.getInt(cursor.getColumnIndex("notificationId"));
        c0899d.f1342c = cursor.getString(cursor.getColumnIndex("packageName"));
        c0899d.f1343d = cursor.getLong(cursor.getColumnIndex("postTime"));
        c0899d.f1344e = cursor.getString(cursor.getColumnIndex("title"));
        c0899d.f1345f = cursor.getString(cursor.getColumnIndex("content"));
        c0899d.f1346g = cursor.getString(cursor.getColumnIndex("iconName"));
        c0899d.f1347h = cursor.getInt(cursor.getColumnIndex("ledARGB"));
        c0899d.f1348i = cursor.getInt(cursor.getColumnIndex("ledOnMS"));
        c0899d.f1349j = cursor.getInt(cursor.getColumnIndex("ledOffMS"));
        c0899d.f1350k = cursor.getString(cursor.getColumnIndex("jsonData"));
        c0899d.f1351l = C0901f.m1587a(cursor.getString(cursor.getColumnIndex("jsonContentIntent")));
        return c0899d;
    }

    @Nullable
    public static C0899d m1579a(String str) {
        C0899d c0899d = null;
        Cursor query = C0896a.m1545a().m1560c().query("NotificationInfoTable", null, "logicId = ?", new String[]{str}, null, null, null);
        if (query.moveToNext()) {
            c0899d = C0900e.m1578a(query);
        }
        query.close();
        return c0899d;
    }

    public static void m1580a() {
        C0896a.m1545a().m1558b().delete("NotificationInfoTable", null, null);
    }

    public static void m1581a(C0899d c0899d) {
        C0896a.m1545a().m1558b().insert("NotificationInfoTable", null, C0900e.m1585c(c0899d));
    }

    @NonNull
    public static ArrayList<C0899d> m1582b() {
        ArrayList<C0899d> arrayList = new ArrayList();
        Cursor query = C0896a.m1545a().m1560c().query("NotificationInfoTable", null, null, null, null, null, "postTime DESC");
        while (query.moveToNext()) {
            arrayList.add(C0900e.m1578a(query));
        }
        query.close();
        return arrayList;
    }

    public static void m1583b(C0899d c0899d) {
        C0896a.m1545a().m1558b().update("NotificationInfoTable", C0900e.m1585c(c0899d), "logicId = ?", new String[]{c0899d.f1340a});
    }

    public static void m1584b(String str) {
        C0896a.m1545a().m1558b().delete("NotificationInfoTable", "logicId = ?", new String[]{str});
    }

    private static ContentValues m1585c(C0899d c0899d) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("logicId", c0899d.f1340a);
        contentValues.put("notificationId", Integer.valueOf(c0899d.f1341b));
        contentValues.put("packageName", c0899d.f1342c);
        contentValues.put("postTime", c0899d.f1343d + "");
        contentValues.put("title", c0899d.f1344e);
        contentValues.put("content", c0899d.f1345f);
        contentValues.put("iconName", c0899d.f1346g);
        contentValues.put("ledARGB", Integer.valueOf(c0899d.f1347h));
        contentValues.put("ledOnMS", Integer.valueOf(c0899d.f1348i));
        contentValues.put("ledOffMS", Integer.valueOf(c0899d.f1349j));
        contentValues.put("jsonData", c0899d.f1350k);
        contentValues.put("jsonContentIntent", c0899d.m1574a());
        return contentValues;
    }

    @NonNull
    public static ArrayList<C0899d> m1586c() {
        ArrayList<C0899d> arrayList = new ArrayList();
        Cursor query = C0896a.m1545a().m1560c().query("NotificationInfoTable", null, null, null, "packageName", null, "postTime DESC");
        while (query.moveToNext()) {
            arrayList.add(C0900e.m1578a(query));
        }
        query.close();
        return arrayList;
    }
}
