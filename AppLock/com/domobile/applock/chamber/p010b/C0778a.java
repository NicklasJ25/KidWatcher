package com.domobile.applock.chamber.p010b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.domobile.applock.chamber.model.BookmarkInfo;
import java.util.ArrayList;

public class C0778a {
    @NonNull
    private static BookmarkInfo m1179a(Cursor cursor) {
        BookmarkInfo bookmarkInfo = new BookmarkInfo();
        bookmarkInfo.f1281a = cursor.getString(cursor.getColumnIndex("bookmarkId"));
        bookmarkInfo.f1282b = cursor.getString(cursor.getColumnIndex("url"));
        bookmarkInfo.f1283c = cursor.getString(cursor.getColumnIndex("name"));
        bookmarkInfo.f1284d = cursor.getString(cursor.getColumnIndex("time"));
        bookmarkInfo.f1285e = cursor.getString(cursor.getColumnIndex("sort"));
        return bookmarkInfo;
    }

    public static void m1180a() {
        C0780c.m1191a().m1192b().delete("BookmarkInfoTable", null, null);
    }

    public static void m1181a(@NonNull BookmarkInfo bookmarkInfo) {
        C0780c.m1191a().m1192b().insert("BookmarkInfoTable", null, C0778a.m1190d(bookmarkInfo));
    }

    public static void m1182a(@NonNull BookmarkInfo bookmarkInfo, @NonNull BookmarkInfo bookmarkInfo2) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        b.beginTransaction();
        try {
            String str = bookmarkInfo.f1285e;
            bookmarkInfo.f1285e = bookmarkInfo2.f1285e;
            bookmarkInfo2.f1285e = str;
            b.update("BookmarkInfoTable", C0778a.m1190d(bookmarkInfo), "bookmarkId = ?", new String[]{bookmarkInfo.f1281a});
            b.update("BookmarkInfoTable", C0778a.m1190d(bookmarkInfo2), "bookmarkId = ?", new String[]{bookmarkInfo2.f1281a});
            b.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b.endTransaction();
        }
    }

    public static void m1183a(ArrayList<BookmarkInfo> arrayList) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            StringBuilder stringBuilder = new StringBuilder();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    stringBuilder.append("bookmarkId = ? ");
                } else {
                    stringBuilder.append("bookmarkId = ? or ");
                }
                strArr[i] = ((BookmarkInfo) arrayList.get(i)).f1281a;
            }
            b.delete("BookmarkInfoTable", stringBuilder.toString(), strArr);
        }
    }

    public static boolean m1184a(@NonNull String str) {
        Cursor query = C0780c.m1191a().m1192b().query("BookmarkInfoTable", null, "url = ?", new String[]{str}, null, null, null);
        boolean z = query.moveToNext();
        query.close();
        return z;
    }

    @NonNull
    public static ArrayList<BookmarkInfo> m1185b() {
        ArrayList<BookmarkInfo> arrayList = new ArrayList();
        Cursor query = C0780c.m1191a().m1193c().query("BookmarkInfoTable", null, null, null, null, null, "sort DESC");
        while (query.moveToNext()) {
            arrayList.add(C0778a.m1179a(query));
        }
        query.close();
        return arrayList;
    }

    public static void m1186b(@NonNull BookmarkInfo bookmarkInfo) {
        C0780c.m1191a().m1192b().update("BookmarkInfoTable", C0778a.m1190d(bookmarkInfo), "bookmarkId = ?", new String[]{bookmarkInfo.f1281a});
    }

    public static void m1187b(String str) {
        C0780c.m1191a().m1192b().delete("BookmarkInfoTable", "bookmarkId = ?", new String[]{str});
    }

    public static void m1188c(@NonNull BookmarkInfo bookmarkInfo) {
        if (!C0778a.m1184a(bookmarkInfo.f1282b)) {
            C0778a.m1181a(bookmarkInfo);
        }
    }

    public static boolean m1189c(String str) {
        Cursor query = C0780c.m1191a().m1193c().query("BookmarkInfoTable", null, "url like '%" + str + "%'", null, null, null, null);
        boolean z = query.moveToNext();
        query.close();
        return z;
    }

    private static ContentValues m1190d(BookmarkInfo bookmarkInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookmarkId", bookmarkInfo.f1281a);
        contentValues.put("url", bookmarkInfo.f1282b);
        contentValues.put("name", bookmarkInfo.f1283c);
        contentValues.put("time", bookmarkInfo.f1284d);
        contentValues.put("sort", bookmarkInfo.f1285e);
        return contentValues;
    }
}
