package com.domobile.applock.chamber.p010b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.domobile.applock.chamber.model.FileInfo;
import java.util.ArrayList;

public class C0781d {
    @NonNull
    private static FileInfo m1194a(Cursor cursor) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.f1287a = cursor.getString(cursor.getColumnIndex("fileId"));
        fileInfo.f1288b = cursor.getString(cursor.getColumnIndex("name"));
        fileInfo.f1289c = cursor.getString(cursor.getColumnIndex("path"));
        fileInfo.f1290d = cursor.getString(cursor.getColumnIndex("url"));
        fileInfo.f1293g = cursor.getInt(cursor.getColumnIndex("state"));
        fileInfo.f1292f = Long.parseLong(cursor.getString(cursor.getColumnIndex("time")));
        fileInfo.f1291e = Long.parseLong(cursor.getString(cursor.getColumnIndex(Columns.SIZE)));
        return fileInfo;
    }

    public static void m1195a() {
        C0780c.m1191a().m1192b().delete("FileInfoTable", null, null);
    }

    public static void m1196a(@NonNull FileInfo fileInfo) {
        C0780c.m1191a().m1192b().insert("FileInfoTable", null, C0781d.m1201b(fileInfo));
    }

    public static void m1197a(String str) {
        C0780c.m1191a().m1192b().delete("FileInfoTable", "fileId = ?", new String[]{str});
    }

    public static void m1198a(String str, int i) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        b.update("FileInfoTable", contentValues, "fileId = ?", new String[]{str});
    }

    public static void m1199a(String str, int i, long j) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        contentValues.put(Columns.SIZE, j + "");
        b.update("FileInfoTable", contentValues, "fileId = ?", new String[]{str});
    }

    public static void m1200a(ArrayList<FileInfo> arrayList) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            StringBuilder stringBuilder = new StringBuilder();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    stringBuilder.append("fileId = ? ");
                } else {
                    stringBuilder.append("fileId = ? or ");
                }
                strArr[i] = ((FileInfo) arrayList.get(i)).f1287a;
            }
            b.delete("FileInfoTable", stringBuilder.toString(), strArr);
        }
    }

    private static ContentValues m1201b(FileInfo fileInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileId", fileInfo.f1287a);
        contentValues.put("name", fileInfo.f1288b);
        contentValues.put("path", fileInfo.f1289c);
        contentValues.put("url", fileInfo.f1290d);
        contentValues.put("state", Integer.valueOf(fileInfo.f1293g));
        contentValues.put("time", fileInfo.f1292f + "");
        contentValues.put(Columns.SIZE, fileInfo.f1291e + "");
        return contentValues;
    }

    @NonNull
    public static ArrayList<FileInfo> m1202b() {
        ArrayList<FileInfo> arrayList = new ArrayList();
        Cursor query = C0780c.m1191a().m1193c().query("FileInfoTable", null, null, null, null, null, "time DESC");
        while (query.moveToNext()) {
            arrayList.add(C0781d.m1194a(query));
        }
        query.close();
        return arrayList;
    }
}
