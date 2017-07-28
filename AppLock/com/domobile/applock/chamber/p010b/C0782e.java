package com.domobile.applock.chamber.p010b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.domobile.applock.chamber.model.SocialInfo;
import com.domobile.applock.p003a.C0630k;
import java.util.ArrayList;

public class C0782e {
    @NonNull
    private static SocialInfo m1203a(Cursor cursor) {
        SocialInfo socialInfo = new SocialInfo();
        socialInfo.f1299a = cursor.getString(cursor.getColumnIndex("uuid"));
        socialInfo.f1300b = cursor.getInt(cursor.getColumnIndex("platform"));
        socialInfo.f1301c = cursor.getString(cursor.getColumnIndex("account"));
        socialInfo.f1302d = cursor.getString(cursor.getColumnIndex("nickname"));
        socialInfo.f1305g = cursor.getString(cursor.getColumnIndex("avatar"));
        socialInfo.f1303e = cursor.getString(cursor.getColumnIndex("time"));
        socialInfo.f1304f = cursor.getString(cursor.getColumnIndex("sort"));
        return socialInfo;
    }

    public static ArrayList<SocialInfo> m1204a(Context context, int i) {
        ArrayList<SocialInfo> arrayList = new ArrayList();
        SocialInfo socialInfo = new SocialInfo();
        socialInfo.f1299a = C0630k.m753a();
        socialInfo.f1300b = i;
        socialInfo.f1301c = "";
        socialInfo.f1302d = "";
        socialInfo.f1303e = System.currentTimeMillis() + "";
        socialInfo.f1304f = socialInfo.f1303e;
        arrayList.add(socialInfo);
        Cursor query = C0780c.m1191a().m1193c().query("SocialInfoTable", null, "platform = ?", new String[]{i + ""}, null, null, "time DESC");
        while (query.moveToNext()) {
            arrayList.add(C0782e.m1203a(query));
        }
        query.close();
        return arrayList;
    }

    public static void m1205a(@NonNull SocialInfo socialInfo) {
        C0780c.m1191a().m1192b().insert("SocialInfoTable", null, C0782e.m1212d(socialInfo));
    }

    public static void m1206a(String str) {
        C0780c.m1191a().m1192b().delete("SocialInfoTable", "uuid = ?", new String[]{str});
    }

    public static void m1207a(@NonNull String str, @Nullable String str2) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nickname", str2);
        b.update("SocialInfoTable", contentValues, "uuid = ?", new String[]{str});
    }

    public static boolean m1208a(int i, String str) {
        Cursor query = C0780c.m1191a().m1192b().query("SocialInfoTable", null, "platform = ? AND account = ?", new String[]{i + "", str}, null, null, null);
        boolean z = query.moveToNext();
        query.close();
        return z;
    }

    public static void m1209b(@NonNull SocialInfo socialInfo) {
        C0780c.m1191a().m1192b().update("SocialInfoTable", C0782e.m1212d(socialInfo), "uuid = ?", new String[]{socialInfo.f1299a});
    }

    public static void m1210b(@NonNull String str, @Nullable String str2) {
        SQLiteDatabase b = C0780c.m1191a().m1192b();
        ContentValues contentValues = new ContentValues();
        contentValues.put("avatar", str2);
        b.update("SocialInfoTable", contentValues, "uuid = ?", new String[]{str});
    }

    public static void m1211c(@NonNull SocialInfo socialInfo) {
        if (C0782e.m1208a(socialInfo.f1300b, socialInfo.f1301c)) {
            C0782e.m1209b(socialInfo);
        } else {
            C0782e.m1205a(socialInfo);
        }
    }

    private static ContentValues m1212d(SocialInfo socialInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uuid", socialInfo.f1299a);
        contentValues.put("platform", Integer.valueOf(socialInfo.f1300b));
        contentValues.put("account", socialInfo.f1301c);
        contentValues.put("nickname", socialInfo.f1302d);
        contentValues.put("avatar", socialInfo.f1305g);
        contentValues.put("time", socialInfo.f1303e);
        contentValues.put("sort", socialInfo.f1304f);
        return contentValues;
    }
}
