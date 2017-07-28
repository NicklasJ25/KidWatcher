package com.domobile.applock.chamber.p010b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class C0779b extends SQLiteOpenHelper {
    private static final String[][] f1030a = new String[][]{new String[0], new String[0]};

    public C0779b(Context context) {
        super(context, "Browser.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BookmarkInfoTable (_id INTEGER PRIMARY KEY AUTOINCREMENT,bookmarkId TEXT, url TEXT, name TEXT, time TEXT, sort TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileInfoTable (_id INTEGER PRIMARY KEY AUTOINCREMENT,fileId TEXT, name TEXT, path TEXT, url TEXT, state INTEGER, time TEXT, size TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SocialInfoTable (_id INTEGER PRIMARY KEY AUTOINCREMENT,uuid TEXT, platform INTEGER, account TEXT, nickname TEXT, avatar TEXT,time TEXT, sort TEXT);");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onCreate(sQLiteDatabase);
        sQLiteDatabase.beginTransaction();
        while (i < i2) {
            try {
                for (String execSQL : f1030a[i]) {
                    sQLiteDatabase.execSQL(execSQL);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }
}
