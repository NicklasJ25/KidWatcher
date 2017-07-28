package com.facebook.ads.internal.p027f;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.UUID;

public class C1570h extends C1561g {
    public static final C1560b f3839a = new C1560b(0, "token_id", "TEXT PRIMARY KEY");
    public static final C1560b f3840b = new C1560b(1, "token", "TEXT");
    public static final C1560b[] f3841c = new C1560b[]{f3839a, f3840b};
    private static final String f3842d = C1570h.class.getSimpleName();
    private static final String f3843e = C1561g.m4332a("tokens", f3841c);
    private static final String f3844f = C1561g.m4333a("tokens", f3841c, f3840b);
    private static final String f3845g = ("DELETE FROM tokens WHERE NOT EXISTS (SELECT 1 FROM events WHERE tokens." + f3839a.f3805b + " = " + "events" + "." + C1562c.f3809b.f3805b + ")");

    public C1570h(C1567d c1567d) {
        super(c1567d);
    }

    public String mo2728a() {
        return "tokens";
    }

    @WorkerThread
    String m4370a(String str) {
        Cursor rawQuery;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid token.");
        }
        try {
            rawQuery = m4340f().rawQuery(f3844f, new String[]{str});
            try {
                String string = rawQuery.moveToNext() ? rawQuery.getString(f3839a.f3804a) : null;
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    ContentValues contentValues = new ContentValues(2);
                    contentValues.put(f3839a.f3805b, string);
                    contentValues.put(f3840b.f3805b, str);
                    m4340f().insertOrThrow("tokens", null, contentValues);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public C1560b[] mo2729b() {
        return f3841c;
    }

    @WorkerThread
    Cursor mo2730c() {
        return m4340f().rawQuery(f3843e, null);
    }

    @WorkerThread
    public void m4373d() {
        try {
            m4340f().execSQL(f3845g);
        } catch (SQLException e) {
        }
    }
}
