package com.facebook.ads.internal.p027f;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.WorkerThread;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class C1562c extends C1561g {
    public static final C1560b f3808a = new C1560b(0, "event_id", "TEXT PRIMARY KEY");
    public static final C1560b f3809b = new C1560b(1, "token_id", "TEXT REFERENCES tokens ON UPDATE CASCADE ON DELETE RESTRICT");
    public static final C1560b f3810c = new C1560b(2, "priority", "INTEGER");
    public static final C1560b f3811d = new C1560b(3, "type", "TEXT");
    public static final C1560b f3812e = new C1560b(4, "time", "REAL");
    public static final C1560b f3813f = new C1560b(5, "session_time", "REAL");
    public static final C1560b f3814g = new C1560b(6, "session_id", "TEXT");
    public static final C1560b f3815h = new C1560b(7, "data", "TEXT");
    public static final C1560b[] f3816i = new C1560b[]{f3808a, f3809b, f3810c, f3811d, f3812e, f3813f, f3814g, f3815h};
    private static final String f3817k = C1561g.m4332a("events", f3816i);

    public C1562c(C1567d c1567d) {
        super(c1567d);
    }

    public String mo2728a() {
        return "events";
    }

    @WorkerThread
    String m4342a(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(7);
        contentValues.put(f3808a.f3805b, uuid);
        contentValues.put(f3809b.f3805b, str);
        contentValues.put(f3810c.f3805b, Integer.valueOf(i));
        contentValues.put(f3811d.f3805b, str2);
        contentValues.put(f3812e.f3805b, Double.valueOf(d));
        contentValues.put(f3813f.f3805b, Double.valueOf(d2));
        contentValues.put(f3814g.f3805b, str3);
        contentValues.put(f3815h.f3805b, map != null ? new JSONObject(map).toString() : null);
        m4340f().insertOrThrow("events", null, contentValues);
        return uuid;
    }

    boolean m4343a(String str) {
        return m4340f().delete("events", new StringBuilder().append(f3808a.f3805b).append(" = ?").toString(), new String[]{str}) > 0;
    }

    public C1560b[] mo2729b() {
        return f3816i;
    }

    @WorkerThread
    Cursor mo2730c() {
        return m4340f().rawQuery("SELECT count(*) FROM events", null);
    }

    @WorkerThread
    Cursor m4346d() {
        return m4340f().rawQuery(f3817k, null);
    }
}
