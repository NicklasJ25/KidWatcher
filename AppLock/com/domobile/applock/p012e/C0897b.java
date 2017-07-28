package com.domobile.applock.p012e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class C0897b extends SQLiteOpenHelper {
    private static final String[][] f1339a = new String[][]{new String[0], new String[0]};

    public C0897b(Context context) {
        super(context, "Notification.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS NotificationInfoTable (_id INTEGER PRIMARY KEY AUTOINCREMENT,logicId TEXT, notificationId INTEGER, packageName TEXT, postTime TEXT,title TEXT,content TEXT,iconName TEXT,ledARGB INTEGER,ledOnMS INTEGER,ledOffMS INTEGER, jsonData TEXT,jsonContentIntent TEXT);");
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
                for (String execSQL : f1339a[i]) {
                    sQLiteDatabase.execSQL(execSQL);
                }
                i++;
            } catch (Exception e) {
                sQLiteDatabase.endTransaction();
                return;
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }
}
