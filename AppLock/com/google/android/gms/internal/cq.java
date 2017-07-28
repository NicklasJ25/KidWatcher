package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.dz.C2828a;
import com.google.android.gms.internal.dz.C2829b;
import com.google.android.gms.internal.dz.C2832e;
import com.google.android.gms.internal.eb.C2840b;
import com.google.android.gms.internal.eb.C2841c;
import com.google.android.gms.internal.eb.C2843e;
import com.google.android.gms.internal.eb.C2844f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cq extends dn {
    private static final Map<String, String> f8266a = new ArrayMap(1);
    private static final Map<String, String> f8267b = new ArrayMap(18);
    private static final Map<String, String> f8268c = new ArrayMap(1);
    private static final Map<String, String> f8269d = new ArrayMap(1);
    private static final Map<String, String> f8270e = new ArrayMap(1);
    private final C2751c f8271f = new C2751c(this, mo3541n(), m9554B());
    private final du f8272g = new du(mo3540m());

    public static class C2749a {
        long f8260a;
        long f8261b;
        long f8262c;
        long f8263d;
        long f8264e;
    }

    interface C2750b {
        void mo3568a(C2843e c2843e);

        boolean mo3569a(long j, C2840b c2840b);
    }

    private class C2751c extends SQLiteOpenHelper {
        final /* synthetic */ cq f8265a;

        C2751c(cq cqVar, Context context, String str) {
            this.f8265a = cqVar;
            super(context, str, null, 1);
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            if (this.f8265a.f8272g.m10324a(this.f8265a.mo3550w().m9483P())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f8265a.f8272g.m10323a();
                    this.f8265a.mo3548u().m9815x().m9774a("Opening the database failed, dropping and recreating it");
                    String B = this.f8265a.m9554B();
                    if (!this.f8265a.mo3541n().getDatabasePath(B).delete()) {
                        this.f8265a.mo3548u().m9815x().m9775a("Failed to delete corrupted db file", B);
                    }
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.f8265a.f8272g.m10325b();
                    } catch (SQLiteException e2) {
                        this.f8265a.mo3548u().m9815x().m9775a("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            cq.m9545a(this.f8265a.mo3548u(), sQLiteDatabase);
        }

        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, triggered_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,triggered_timestamp,value", cq.f8266a);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", cq.f8267b);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", cq.f8269d);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", cq.f8268c);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
            cq.m9546a(this.f8265a.mo3548u(), sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", cq.f8270e);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        f8266a.put("origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;");
        f8267b.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f8267b.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f8267b.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f8267b.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f8267b.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        f8267b.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        f8267b.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        f8267b.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        f8267b.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        f8267b.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        f8267b.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        f8267b.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        f8267b.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        f8267b.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        f8267b.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        f8267b.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
        f8267b.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
        f8267b.put("health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;");
        f8267b.put("android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;");
        f8268c.put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
        f8269d.put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
        f8270e.put("previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;");
    }

    cq(dk dkVar) {
        super(dkVar);
    }

    private boolean m9540T() {
        return mo3541n().getDatabasePath(m9554B()).exists();
    }

    @WorkerThread
    @TargetApi(11)
    static int m9541a(Cursor cursor, int i) {
        int i2 = VERSION.SDK_INT;
        return cursor.getType(i);
    }

    @WorkerThread
    private long m9542a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m9553A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @WorkerThread
    static Set<String> m9544a(SQLiteDatabase sQLiteDatabase, String str) {
        Set<String> hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    static void m9545a(dc dcVar, SQLiteDatabase sQLiteDatabase) {
        if (dcVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        int i = VERSION.SDK_INT;
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            dcVar.m9817z().m9774a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            dcVar.m9817z().m9774a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            dcVar.m9817z().m9774a("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            dcVar.m9817z().m9774a("Failed to turn on database write permission for owner");
        }
    }

    @WorkerThread
    static void m9546a(dc dcVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
        if (dcVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!m9549a(dcVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            m9547a(dcVar, sQLiteDatabase, str, str3, map);
        } catch (SQLiteException e) {
            dcVar.m9815x().m9775a("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    @WorkerThread
    static void m9547a(dc dcVar, SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
        if (dcVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Iterable a = m9544a(sQLiteDatabase, str);
        String[] split = str2.split(",");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str3 = split[i];
            if (a.remove(str3)) {
                i++;
            } else {
                throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
            }
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!a.remove(entry.getKey())) {
                    sQLiteDatabase.execSQL((String) entry.getValue());
                }
            }
        }
        if (!a.isEmpty()) {
            dcVar.m9817z().m9776a("Table has extra columns. table, columns", str, TextUtils.join(", ", a));
        }
    }

    @WorkerThread
    private void m9548a(String str, C2828a c2828a) {
        Object obj = null;
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7932a((Object) c2828a);
        C2513c.m7932a(c2828a.f8711c);
        C2513c.m7932a(c2828a.f8710b);
        if (c2828a.f8709a == null) {
            mo3548u().m9817z().m9775a("Audience with no ID. appId", dc.m9779a(str));
            return;
        }
        int intValue = c2828a.f8709a.intValue();
        for (C2829b c2829b : c2828a.f8711c) {
            if (c2829b.f8713a == null) {
                mo3548u().m9817z().m9776a("Event filter with no ID. Audience definition ignored. appId, audienceId", dc.m9779a(str), c2828a.f8709a);
                return;
            }
        }
        for (C2832e c2832e : c2828a.f8710b) {
            if (c2832e.f8729a == null) {
                mo3548u().m9817z().m9776a("Property filter with no ID. Audience definition ignored. appId, audienceId", dc.m9779a(str), c2828a.f8709a);
                return;
            }
        }
        Object obj2 = 1;
        for (C2829b a : c2828a.f8711c) {
            if (!m9550a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (C2832e a2 : c2828a.f8710b) {
                if (!m9551a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            m9594b(str, intValue);
        }
    }

    @WorkerThread
    static boolean m9549a(dc dcVar, SQLiteDatabase sQLiteDatabase, String str) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        if (dcVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    dcVar.m9817z().m9776a("Error querying for table", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            dcVar.m9817z().m9776a("Error querying for table", str, e);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private boolean m9550a(String str, int i, C2829b c2829b) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7932a((Object) c2829b);
        if (TextUtils.isEmpty(c2829b.f8714b)) {
            mo3548u().m9817z().m9777a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", dc.m9779a(str), Integer.valueOf(i), String.valueOf(c2829b.f8713a));
            return false;
        }
        try {
            byte[] bArr = new byte[c2829b.m9131g()];
            lu a = lu.m12365a(bArr);
            c2829b.mo3506a(a);
            a.m12409b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", c2829b.f8713a);
            contentValues.put("event_name", c2829b.f8714b);
            contentValues.put("data", bArr);
            try {
                if (m9553A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    mo3548u().m9815x().m9775a("Failed to insert event filter (got -1). appId", dc.m9779a(str));
                }
                return true;
            } catch (SQLiteException e) {
                mo3548u().m9815x().m9776a("Error storing event filter. appId", dc.m9779a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo3548u().m9815x().m9776a("Configuration loss. Failed to serialize event filter. appId", dc.m9779a(str), e2);
            return false;
        }
    }

    @WorkerThread
    private boolean m9551a(String str, int i, C2832e c2832e) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7932a((Object) c2832e);
        if (TextUtils.isEmpty(c2832e.f8730b)) {
            mo3548u().m9817z().m9777a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", dc.m9779a(str), Integer.valueOf(i), String.valueOf(c2832e.f8729a));
            return false;
        }
        try {
            byte[] bArr = new byte[c2832e.m9131g()];
            lu a = lu.m12365a(bArr);
            c2832e.mo3506a(a);
            a.m12409b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", c2832e.f8729a);
            contentValues.put("property_name", c2832e.f8730b);
            contentValues.put("data", bArr);
            try {
                if (m9553A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                mo3548u().m9815x().m9775a("Failed to insert property filter (got -1). appId", dc.m9779a(str));
                return false;
            } catch (SQLiteException e) {
                mo3548u().m9815x().m9776a("Error storing property filter. appId", dc.m9779a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo3548u().m9815x().m9776a("Configuration loss. Failed to serialize property filter. appId", dc.m9779a(str), e2);
            return false;
        }
    }

    @WorkerThread
    private long m9552b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = m9553A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @WorkerThread
    SQLiteDatabase m9553A() {
        mo3532e();
        try {
            return this.f8271f.getWritableDatabase();
        } catch (SQLiteException e) {
            mo3548u().m9817z().m9775a("Error opening database", e);
            throw e;
        }
    }

    String m9554B() {
        return mo3550w().m9487T();
    }

    @WorkerThread
    public String m9555C() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = m9553A().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo3548u().m9815x().m9775a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo3548u().m9815x().m9775a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public boolean m9556D() {
        return m9552b("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    void m9557E() {
        mo3532e();
        m9448R();
        if (m9540T()) {
            long a = mo3549v().f8409f.m9858a();
            long b = mo3540m().mo3361b();
            if (Math.abs(b - a) > mo3550w().ac()) {
                mo3549v().f8409f.m9859a(b);
                m9558F();
            }
        }
    }

    @WorkerThread
    void m9558F() {
        mo3532e();
        m9448R();
        if (m9540T()) {
            int delete = m9553A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo3540m().mo3360a()), String.valueOf(mo3550w().ab())});
            if (delete > 0) {
                mo3548u().m9786D().m9775a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    @WorkerThread
    public long m9559G() {
        return m9542a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    @WorkerThread
    public long m9560H() {
        return m9542a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean m9561I() {
        return m9552b("select count(1) > 0 from raw_events", null) != 0;
    }

    public boolean m9562J() {
        return m9552b("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public long m9563K() {
        long j = -1;
        Cursor cursor = null;
        try {
            cursor = m9553A().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9775a("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return j;
    }

    public long m9564a(C2843e c2843e) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) c2843e);
        C2513c.m7934a(c2843e.f8795o);
        try {
            byte[] bArr = new byte[c2843e.m9131g()];
            lu a = lu.m12365a(bArr);
            c2843e.mo3506a(a);
            a.m12409b();
            long d = mo3544q().m10424d(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c2843e.f8795o);
            contentValues.put("metadata_fingerprint", Long.valueOf(d));
            contentValues.put("metadata", bArr);
            try {
                m9553A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return d;
            } catch (SQLiteException e) {
                mo3548u().m9815x().m9776a("Error storing raw event metadata. appId", dc.m9779a(c2843e.f8795o), e);
                throw e;
            }
        } catch (IOException e2) {
            mo3548u().m9815x().m9776a("Data loss. Failed to serialize event metadata. appId", dc.m9779a(c2843e.f8795o), e2);
            throw e2;
        }
    }

    @WorkerThread
    public C2749a m9565a(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Cursor query;
        Object e;
        Throwable th;
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        String[] strArr = new String[]{str};
        C2749a c2749a = new C2749a();
        try {
            SQLiteDatabase A = m9553A();
            query = A.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        c2749a.f8261b = query.getLong(1);
                        c2749a.f8260a = query.getLong(2);
                        c2749a.f8262c = query.getLong(3);
                        c2749a.f8263d = query.getLong(4);
                        c2749a.f8264e = query.getLong(5);
                    }
                    if (z) {
                        c2749a.f8261b++;
                    }
                    if (z2) {
                        c2749a.f8260a++;
                    }
                    if (z3) {
                        c2749a.f8262c++;
                    }
                    if (z4) {
                        c2749a.f8263d++;
                    }
                    if (z5) {
                        c2749a.f8264e++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(c2749a.f8260a));
                    contentValues.put("daily_events_count", Long.valueOf(c2749a.f8261b));
                    contentValues.put("daily_conversions_count", Long.valueOf(c2749a.f8262c));
                    contentValues.put("daily_error_events_count", Long.valueOf(c2749a.f8263d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(c2749a.f8264e));
                    A.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return c2749a;
                }
                mo3548u().m9817z().m9775a("Not updating daily counts, app is not known. appId", dc.m9779a(str));
                if (query != null) {
                    query.close();
                }
                return c2749a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo3548u().m9815x().m9776a("Error updating daily counts. appId", dc.m9779a(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return c2749a;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo3548u().m9815x().m9776a("Error updating daily counts. appId", dc.m9779a(str), e);
            if (query != null) {
                query.close();
            }
            return c2749a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public cu m9566a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        try {
            Cursor query = m9553A().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    cu cuVar = new cu(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        mo3548u().m9815x().m9775a("Got multiple records for event aggregates, expected one. appId", dc.m9779a(str));
                    }
                    if (query == null) {
                        return cuVar;
                    }
                    query.close();
                    return cuVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo3548u().m9815x().m9777a("Error querying events. appId", dc.m9779a(str), str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo3548u().m9815x().m9777a("Error querying events. appId", dc.m9779a(str), str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public List<dx> m9567a(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        List<dx> arrayList = new ArrayList();
        try {
            Cursor query = m9553A().query("user_attributes", new String[]{"name", "origin", "triggered_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(mo3550w().m9478K()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        long j = query.getLong(2);
                        Object b = m9590b(query, 3);
                        if (b == null) {
                            mo3548u().m9815x().m9775a("Read invalid user property value, ignoring it. appId", dc.m9779a(str));
                        } else {
                            arrayList.add(new dx(str, string2, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                mo3548u().m9815x().m9776a("Error querying user properties. appId", dc.m9779a(str), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public List<Pair<C2843e, Long>> m9568a(String str, int i, int i2) {
        List<Pair<C2843e, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        mo3532e();
        m9448R();
        C2513c.m7941b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        C2513c.m7941b(z);
        C2513c.m7934a(str);
        Cursor query;
        try {
            query = m9553A().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = mo3544q().m10418b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            lt a = lt.m12332a(b);
                            C2843e c2843e = new C2843e();
                            try {
                                c2843e.mo3509b(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(c2843e, Long.valueOf(j)));
                            } catch (IOException e2) {
                                mo3548u().m9815x().m9776a("Failed to merge queued bundle. appId", dc.m9779a(str), e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            mo3548u().m9815x().m9776a("Failed to unzip queued bundle. appId", dc.m9779a(str), e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo3548u().m9815x().m9776a("Error querying bundles. appId", dc.m9779a(str), e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    @WorkerThread
    public List<zzatg> m9569a(String str, long j) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        if (j < 0) {
            mo3548u().m9817z().m9776a("Invalid time querying timed out conditional properties", dc.m9779a(str), Long.valueOf(j));
            return Collections.emptyList();
        }
        return m9572a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
    }

    @WorkerThread
    public List<zzatg> m9570a(String str, String str2, long j) {
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        if (j < 0) {
            mo3548u().m9817z().m9777a("Invalid time querying triggered conditional properties", dc.m9779a(str), str2, Long.valueOf(j));
            return Collections.emptyList();
        }
        return m9572a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
    }

    @WorkerThread
    public List<dx> m9571a(String str, String str2, String str3) {
        String string;
        Object obj;
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        List<dx> arrayList = new ArrayList();
        try {
            List arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder stringBuilder = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                stringBuilder.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                stringBuilder.append(" and name glob ?");
            }
            String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String[] strArr2 = new String[]{"name", "triggered_timestamp", "value", "origin"};
            mo3550w().m9478K();
            Cursor query = m9553A().query("user_attributes", strArr2, stringBuilder.toString(), strArr, null, null, "rowid", String.valueOf(PointerIconCompat.TYPE_CONTEXT_MENU));
            try {
                if (query.moveToFirst()) {
                    while (arrayList.size() < mo3550w().m9478K()) {
                        try {
                            String string2 = query.getString(0);
                            long j = query.getLong(1);
                            Object b = m9590b(query, 2);
                            string = query.getString(3);
                            if (b == null) {
                                mo3548u().m9815x().m9777a("(2)Read invalid user property value, ignoring it", dc.m9779a(str), string, str3);
                            } else {
                                arrayList.add(new dx(str, string, string2, j, b));
                            }
                            if (!query.moveToNext()) {
                                break;
                            }
                            obj = string;
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursor = query;
                            obj = string;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = query;
                        }
                    }
                    mo3548u().m9815x().m9775a("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(mo3550w().m9478K()));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th22) {
                th = th22;
                cursor2 = query;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo3548u().m9815x().m9777a("(2)Error querying user properties", dc.m9779a(str), obj, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<zzatg> m9572a(String str, String[] strArr) {
        Object e;
        Cursor cursor;
        Throwable th;
        mo3532e();
        m9448R();
        List<zzatg> arrayList = new ArrayList();
        Cursor query;
        try {
            String[] strArr2 = new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"};
            mo3550w().m9480M();
            query = m9553A().query("conditional_properties", strArr2, str, strArr, null, null, "rowid", String.valueOf(PointerIconCompat.TYPE_CONTEXT_MENU));
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= mo3550w().m9480M()) {
                            mo3548u().m9815x().m9775a("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(mo3550w().m9480M()));
                            break;
                        }
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object b = m9590b(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzatq com_google_android_gms_internal_zzatq = (zzatq) mo3544q().m10389a(query.getBlob(7), zzatq.CREATOR);
                        long j2 = query.getLong(8);
                        zzatq com_google_android_gms_internal_zzatq2 = (zzatq) mo3544q().m10389a(query.getBlob(9), zzatq.CREATOR);
                        long j3 = query.getLong(10);
                        List<zzatg> list = arrayList;
                        list.add(new zzatg(string, string2, new zzauq(string3, j3, b, string2), j2, z, string4, com_google_android_gms_internal_zzatq, j, com_google_android_gms_internal_zzatq2, query.getLong(11), (zzatq) mo3544q().m10389a(query.getBlob(12), zzatq.CREATOR)));
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                mo3548u().m9815x().m9775a("Error querying conditional user property value", e);
                List<zzatg> emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void mo3551a() {
    }

    @WorkerThread
    public void m9574a(long j) {
        mo3532e();
        m9448R();
        try {
            if (m9553A().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9775a("Failed to delete a bundle in a queue table", e);
            throw e;
        }
    }

    @WorkerThread
    void m9575a(ContentValues contentValues, String str, Object obj) {
        C2513c.m7934a(str);
        C2513c.m7932a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public void m9576a(cl clVar) {
        C2513c.m7932a((Object) clVar);
        mo3532e();
        m9448R();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", clVar.m9399b());
        contentValues.put("app_instance_id", clVar.m9402c());
        contentValues.put("gmp_app_id", clVar.m9405d());
        contentValues.put("resettable_device_id_hash", clVar.m9408e());
        contentValues.put("last_bundle_index", Long.valueOf(clVar.m9431o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(clVar.m9414g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(clVar.m9417h()));
        contentValues.put("app_version", clVar.m9419i());
        contentValues.put("app_store", clVar.m9423k());
        contentValues.put("gmp_version", Long.valueOf(clVar.m9425l()));
        contentValues.put("dev_cert_hash", Long.valueOf(clVar.m9427m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(clVar.m9430n()));
        contentValues.put("day", Long.valueOf(clVar.m9436s()));
        contentValues.put("daily_public_events_count", Long.valueOf(clVar.m9437t()));
        contentValues.put("daily_events_count", Long.valueOf(clVar.m9438u()));
        contentValues.put("daily_conversions_count", Long.valueOf(clVar.m9439v()));
        contentValues.put("config_fetched_time", Long.valueOf(clVar.m9433p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(clVar.m9434q()));
        contentValues.put("app_version_int", Long.valueOf(clVar.m9421j()));
        contentValues.put("firebase_instance_id", clVar.m9411f());
        contentValues.put("daily_error_events_count", Long.valueOf(clVar.m9441x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(clVar.m9440w()));
        contentValues.put("health_monitor_sample", clVar.m9442y());
        contentValues.put("android_id", Long.valueOf(clVar.m9394A()));
        try {
            SQLiteDatabase A = m9553A();
            if (((long) A.update("apps", contentValues, "app_id = ?", new String[]{clVar.m9399b()})) == 0 && A.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo3548u().m9815x().m9775a("Failed to insert/update app (got -1). appId", dc.m9779a(clVar.m9399b()));
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error storing app. appId", dc.m9779a(clVar.m9399b()), e);
        }
    }

    @WorkerThread
    public void m9577a(cu cuVar) {
        C2513c.m7932a((Object) cuVar);
        mo3532e();
        m9448R();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", cuVar.f8288a);
        contentValues.put("name", cuVar.f8289b);
        contentValues.put("lifetime_count", Long.valueOf(cuVar.f8290c));
        contentValues.put("current_bundle_count", Long.valueOf(cuVar.f8291d));
        contentValues.put("last_fire_timestamp", Long.valueOf(cuVar.f8292e));
        try {
            if (m9553A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo3548u().m9815x().m9775a("Failed to insert/update event aggregates (got -1). appId", dc.m9779a(cuVar.f8288a));
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error storing event aggregates. appId", dc.m9779a(cuVar.f8288a), e);
        }
    }

    @WorkerThread
    public void m9578a(String str, int i) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        try {
            m9553A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by triggered_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error pruning currencies. appId", dc.m9779a(str), e);
        }
    }

    void m9579a(String str, int i, C2844f c2844f) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7932a((Object) c2844f);
        try {
            byte[] bArr = new byte[c2844f.m9131g()];
            lu a = lu.m12365a(bArr);
            c2844f.mo3506a(a);
            a.m12409b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (m9553A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    mo3548u().m9815x().m9775a("Failed to insert filter results (got -1). appId", dc.m9779a(str));
                }
            } catch (SQLiteException e) {
                mo3548u().m9815x().m9776a("Error storing filter results. appId", dc.m9779a(str), e);
            }
        } catch (IOException e2) {
            mo3548u().m9815x().m9776a("Configuration loss. Failed to serialize filter results. appId", dc.m9779a(str), e2);
        }
    }

    public void m9580a(String str, long j, long j2, C2750b c2750b) {
        Object e;
        Throwable th;
        C2513c.m7932a((Object) c2750b);
        mo3532e();
        m9448R();
        Cursor cursor = null;
        SQLiteDatabase A = m9553A();
        String str2;
        if (TextUtils.isEmpty(str)) {
            String[] strArr = j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
            str2 = j2 != -1 ? "rowid <= ? and " : "";
            cursor = A.rawQuery(new StringBuilder(String.valueOf(str2).length() + 148).append("select app_id, metadata_fingerprint from raw_events where ").append(str2).append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;").toString(), strArr);
            if (cursor.moveToFirst()) {
                str = cursor.getString(0);
                str2 = cursor.getString(1);
                cursor.close();
                String str3 = str2;
                Cursor cursor2 = cursor;
            } else if (cursor != null) {
                cursor.close();
                return;
            } else {
                return;
            }
        }
        strArr = j2 != -1 ? new String[]{str, String.valueOf(j2)} : new String[]{str};
        str2 = j2 != -1 ? " and rowid <= ?" : "";
        cursor = A.rawQuery(new StringBuilder(String.valueOf(str2).length() + 84).append("select metadata_fingerprint from raw_events where app_id = ?").append(str2).append(" order by rowid limit 1;").toString(), strArr);
        if (cursor.moveToFirst()) {
            str2 = cursor.getString(0);
            cursor.close();
            str3 = str2;
            cursor2 = cursor;
        } else if (cursor != null) {
            cursor.close();
            return;
        } else {
            return;
        }
        try {
            cursor2 = A.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, str3}, null, null, "rowid", GpsMeasureMode.MODE_2_DIMENSIONAL);
            if (cursor2.moveToFirst()) {
                lt a = lt.m12332a(cursor2.getBlob(0));
                C2843e c2843e = new C2843e();
                try {
                    String str4;
                    String[] strArr2;
                    c2843e.mo3509b(a);
                    if (cursor2.moveToNext()) {
                        mo3548u().m9817z().m9775a("Get multiple raw event metadata records, expected one. appId", dc.m9779a(str));
                    }
                    cursor2.close();
                    c2750b.mo3568a(c2843e);
                    if (j2 != -1) {
                        str4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr2 = new String[]{str, str3, String.valueOf(j2)};
                    } else {
                        str4 = "app_id = ? and metadata_fingerprint = ?";
                        strArr2 = new String[]{str, str3};
                    }
                    cursor = A.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str4, strArr2, null, null, "rowid", null);
                    if (cursor.moveToFirst()) {
                        do {
                            try {
                                long j3 = cursor.getLong(0);
                                lt a2 = lt.m12332a(cursor.getBlob(3));
                                C2840b c2840b = new C2840b();
                                try {
                                    c2840b.mo3509b(a2);
                                    c2840b.f8761b = cursor.getString(1);
                                    c2840b.f8762c = Long.valueOf(cursor.getLong(2));
                                    if (!c2750b.mo3569a(j3, c2840b)) {
                                        if (cursor != null) {
                                            cursor.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (IOException e2) {
                                    mo3548u().m9815x().m9776a("Data loss. Failed to merge raw event. appId", dc.m9779a(str), e2);
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                            }
                        } while (cursor.moveToNext());
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                    mo3548u().m9817z().m9775a("Raw event data disappeared while in transaction. appId", dc.m9779a(str));
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                } catch (IOException e22) {
                    mo3548u().m9815x().m9776a("Data loss. Failed to merge raw event metadata. appId", dc.m9779a(str), e22);
                    if (cursor2 != null) {
                        cursor2.close();
                        return;
                    }
                    return;
                }
            }
            mo3548u().m9815x().m9775a("Raw event metadata record is missing. appId", dc.m9779a(str));
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = cursor2;
            try {
                mo3548u().m9815x().m9776a("Data loss. Error selecting raw event. appId", dc.m9779a(str), e);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public void m9581a(String str, byte[] bArr) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) m9553A().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                mo3548u().m9815x().m9775a("Failed to update remote config (got 0). appId", dc.m9779a(str));
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error storing remote config. appId", dc.m9779a(str), e);
        }
    }

    @WorkerThread
    void m9582a(String str, C2828a[] c2828aArr) {
        int i = 0;
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7932a((Object) c2828aArr);
        SQLiteDatabase A = m9553A();
        A.beginTransaction();
        try {
            m9601e(str);
            for (C2828a a : c2828aArr) {
                m9548a(str, a);
            }
            List arrayList = new ArrayList();
            int length = c2828aArr.length;
            while (i < length) {
                arrayList.add(c2828aArr[i].f8709a);
                i++;
            }
            m9588a(str, arrayList);
            A.setTransactionSuccessful();
        } finally {
            A.endTransaction();
        }
    }

    public void m9583a(List<Long> list) {
        C2513c.m7932a((Object) list);
        mo3532e();
        m9448R();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = m9553A().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            mo3548u().m9815x().m9776a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean m9584a(ct ctVar, long j, boolean z) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) ctVar);
        C2513c.m7934a(ctVar.f8282a);
        C2840b c2840b = new C2840b();
        c2840b.f8763d = Long.valueOf(ctVar.f8286e);
        c2840b.f8760a = new C2841c[ctVar.f8287f.m15351a()];
        Iterator it = ctVar.f8287f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            C2841c c2841c = new C2841c();
            int i2 = i + 1;
            c2840b.f8760a[i] = c2841c;
            c2841c.f8766a = str;
            mo3544q().m10397a(c2841c, ctVar.f8287f.m15352a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[c2840b.m9131g()];
            lu a = lu.m12365a(bArr);
            c2840b.mo3506a(a);
            a.m12409b();
            mo3548u().m9786D().m9776a("Saving event, name, data size", ctVar.f8283b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", ctVar.f8282a);
            contentValues.put("name", ctVar.f8283b);
            contentValues.put("timestamp", Long.valueOf(ctVar.f8285d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (m9553A().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                mo3548u().m9815x().m9775a("Failed to insert raw event (got -1). appId", dc.m9779a(ctVar.f8282a));
                return false;
            } catch (SQLiteException e) {
                mo3548u().m9815x().m9776a("Error storing raw event. appId", dc.m9779a(ctVar.f8282a), e);
                return false;
            }
        } catch (IOException e2) {
            mo3548u().m9815x().m9776a("Data loss. Failed to serialize event params/data. appId", dc.m9779a(ctVar.f8282a), e2);
            return false;
        }
    }

    @WorkerThread
    public boolean m9585a(dx dxVar) {
        C2513c.m7932a((Object) dxVar);
        mo3532e();
        m9448R();
        if (m9597c(dxVar.f8701a, dxVar.f8703c) == null) {
            long b;
            if (dy.m10374a(dxVar.f8703c)) {
                b = m9552b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{dxVar.f8701a});
                mo3550w().m9477J();
                if (b >= 25) {
                    return false;
                }
            }
            b = m9552b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{dxVar.f8701a, dxVar.f8702b});
            mo3550w().m9479L();
            if (b >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", dxVar.f8701a);
        contentValues.put("origin", dxVar.f8702b);
        contentValues.put("name", dxVar.f8703c);
        contentValues.put("triggered_timestamp", Long.valueOf(dxVar.f8704d));
        m9575a(contentValues, "value", dxVar.f8705e);
        try {
            if (m9553A().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo3548u().m9815x().m9775a("Failed to insert/update user property (got -1). appId", dc.m9779a(dxVar.f8701a));
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error storing user property. appId", dc.m9779a(dxVar.f8701a), e);
        }
        return true;
    }

    @WorkerThread
    public boolean m9586a(C2843e c2843e, boolean z) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) c2843e);
        C2513c.m7934a(c2843e.f8795o);
        C2513c.m7932a(c2843e.f8786f);
        m9557E();
        long a = mo3540m().mo3360a();
        if (c2843e.f8786f.longValue() < a - mo3550w().ab() || c2843e.f8786f.longValue() > mo3550w().ab() + a) {
            mo3548u().m9817z().m9777a("Storing bundle outside of the max uploading time span. appId, now, timestamp", dc.m9779a(c2843e.f8795o), Long.valueOf(a), c2843e.f8786f);
        }
        try {
            byte[] bArr = new byte[c2843e.m9131g()];
            lu a2 = lu.m12365a(bArr);
            c2843e.mo3506a(a2);
            a2.m12409b();
            bArr = mo3544q().m10411a(bArr);
            mo3548u().m9786D().m9775a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c2843e.f8795o);
            contentValues.put("bundle_end_timestamp", c2843e.f8786f);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (m9553A().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo3548u().m9815x().m9775a("Failed to insert bundle (got -1). appId", dc.m9779a(c2843e.f8795o));
                return false;
            } catch (SQLiteException e) {
                mo3548u().m9815x().m9776a("Error storing bundle. appId", dc.m9779a(c2843e.f8795o), e);
                return false;
            }
        } catch (IOException e2) {
            mo3548u().m9815x().m9776a("Data loss. Failed to serialize bundle. appId", dc.m9779a(c2843e.f8795o), e2);
            return false;
        }
    }

    @WorkerThread
    public boolean m9587a(zzatg com_google_android_gms_internal_zzatg) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        mo3532e();
        m9448R();
        if (m9597c(com_google_android_gms_internal_zzatg.f11812b, com_google_android_gms_internal_zzatg.f11814d.f11831b) == null) {
            long b = m9552b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{com_google_android_gms_internal_zzatg.f11812b});
            mo3550w().m9480M();
            if (b >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzatg.f11812b);
        contentValues.put("origin", com_google_android_gms_internal_zzatg.f11813c);
        contentValues.put("name", com_google_android_gms_internal_zzatg.f11814d.f11831b);
        m9575a(contentValues, "value", com_google_android_gms_internal_zzatg.f11814d.m15354a());
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_zzatg.f11816f));
        contentValues.put("trigger_event_name", com_google_android_gms_internal_zzatg.f11817g);
        contentValues.put("trigger_timeout", Long.valueOf(com_google_android_gms_internal_zzatg.f11819i));
        contentValues.put("timed_out_event", mo3544q().m10409a(com_google_android_gms_internal_zzatg.f11818h));
        contentValues.put("creation_timestamp", Long.valueOf(com_google_android_gms_internal_zzatg.f11815e));
        contentValues.put("triggered_event", mo3544q().m10409a(com_google_android_gms_internal_zzatg.f11820j));
        contentValues.put("triggered_timestamp", Long.valueOf(com_google_android_gms_internal_zzatg.f11814d.f11832c));
        contentValues.put("time_to_live", Long.valueOf(com_google_android_gms_internal_zzatg.f11821k));
        contentValues.put("expired_event", mo3544q().m10409a(com_google_android_gms_internal_zzatg.f11822l));
        try {
            if (m9553A().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                mo3548u().m9815x().m9775a("Failed to insert/update conditional user property (got -1)", dc.m9779a(com_google_android_gms_internal_zzatg.f11812b));
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error storing conditional user property", dc.m9779a(com_google_android_gms_internal_zzatg.f11812b), e);
        }
        return true;
    }

    boolean m9588a(String str, List<Integer> list) {
        C2513c.m7934a(str);
        m9448R();
        mo3532e();
        SQLiteDatabase A = m9553A();
        try {
            if (m9552b("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) mo3550w().m9507f(str))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Integer num = (Integer) list.get(i);
                    if (num == null || !(num instanceof Integer)) {
                        return false;
                    }
                    arrayList.add(Integer.toString(num.intValue()));
                }
            }
            String valueOf = String.valueOf(TextUtils.join(",", arrayList));
            valueOf = new StringBuilder(String.valueOf(valueOf).length() + 2).append("(").append(valueOf).append(")").toString();
            return A.delete("audience_filter_values", new StringBuilder(String.valueOf(valueOf).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(valueOf).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(r5)}) > 0;
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Database error querying filters. appId", dc.m9779a(str), e);
            return false;
        }
    }

    @WorkerThread
    public cl m9589b(String str) {
        Cursor query;
        Object e;
        Throwable th;
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        try {
            query = m9553A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    cl clVar = new cl(this.n, str);
                    clVar.m9397a(query.getString(0));
                    clVar.m9401b(query.getString(1));
                    clVar.m9404c(query.getString(2));
                    clVar.m9412f(query.getLong(3));
                    clVar.m9396a(query.getLong(4));
                    clVar.m9400b(query.getLong(5));
                    clVar.m9410e(query.getString(6));
                    clVar.m9413f(query.getString(7));
                    clVar.m9406d(query.getLong(8));
                    clVar.m9409e(query.getLong(9));
                    clVar.m9398a((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    clVar.m9420i(query.getLong(11));
                    clVar.m9422j(query.getLong(12));
                    clVar.m9424k(query.getLong(13));
                    clVar.m9426l(query.getLong(14));
                    clVar.m9415g(query.getLong(15));
                    clVar.m9418h(query.getLong(16));
                    clVar.m9403c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    clVar.m9407d(query.getString(18));
                    clVar.m9429n(query.getLong(19));
                    clVar.m9428m(query.getLong(20));
                    clVar.m9416g(query.getString(21));
                    clVar.m9432o(query.isNull(22) ? 0 : query.getLong(22));
                    clVar.m9395a();
                    if (query.moveToNext()) {
                        mo3548u().m9815x().m9775a("Got multiple records for app, expected one. appId", dc.m9779a(str));
                    }
                    if (query == null) {
                        return clVar;
                    }
                    query.close();
                    return clVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo3548u().m9815x().m9776a("Error querying app. appId", dc.m9779a(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo3548u().m9815x().m9776a("Error querying app. appId", dc.m9779a(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    Object m9590b(Cursor cursor, int i) {
        int a = m9541a(cursor, i);
        switch (a) {
            case 0:
                mo3548u().m9815x().m9774a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                mo3548u().m9815x().m9774a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo3548u().m9815x().m9775a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public String m9591b(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        mo3532e();
        m9448R();
        try {
            rawQuery = m9553A().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    mo3548u().m9786D().m9774a("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo3548u().m9815x().m9775a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            mo3548u().m9815x().m9775a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    @WorkerThread
    public List<zzatg> m9592b(String str, long j) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        if (j < 0) {
            mo3548u().m9817z().m9776a("Invalid time querying expired conditional properties", dc.m9779a(str), Long.valueOf(j));
            return Collections.emptyList();
        }
        return m9572a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
    }

    @WorkerThread
    public List<zzatg> m9593b(String str, String str2, String str3) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return m9572a(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    void m9594b(String str, int i) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        SQLiteDatabase A = m9553A();
        A.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        A.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    @WorkerThread
    public void m9595b(String str, String str2) {
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        try {
            mo3548u().m9786D().m9775a("Deleted user attribute rows", Integer.valueOf(m9553A().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9777a("Error deleting user attribute. appId", dc.m9779a(str), str2, e);
        }
    }

    public long m9596c(String str) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        try {
            SQLiteDatabase A = m9553A();
            String valueOf = String.valueOf(mo3550w().m9515j(str));
            return (long) A.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error deleting over the limit events. appId", dc.m9779a(str), e);
            return 0;
        }
    }

    @WorkerThread
    public dx m9597c(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        try {
            Cursor query = m9553A().query("user_attributes", new String[]{"triggered_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String str3 = str;
                    dx dxVar = new dx(str3, query.getString(2), str2, query.getLong(0), m9590b(query, 1));
                    if (query.moveToNext()) {
                        mo3548u().m9815x().m9775a("Got multiple records for user property, expected one. appId", dc.m9779a(str));
                    }
                    if (query == null) {
                        return dxVar;
                    }
                    query.close();
                    return dxVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo3548u().m9815x().m9777a("Error querying user property. appId", dc.m9779a(str), str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo3548u().m9815x().m9777a("Error querying user property. appId", dc.m9779a(str), str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public zzatg m9598d(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        Cursor query;
        try {
            query = m9553A().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    Object b = m9590b(query, 1);
                    boolean z = query.getInt(2) != 0;
                    String string2 = query.getString(3);
                    long j = query.getLong(4);
                    zzatq com_google_android_gms_internal_zzatq = (zzatq) mo3544q().m10389a(query.getBlob(5), zzatq.CREATOR);
                    long j2 = query.getLong(6);
                    zzatq com_google_android_gms_internal_zzatq2 = (zzatq) mo3544q().m10389a(query.getBlob(7), zzatq.CREATOR);
                    long j3 = query.getLong(8);
                    zzatg com_google_android_gms_internal_zzatg = new zzatg(str, string, new zzauq(str2, j3, b, string), j2, z, string2, com_google_android_gms_internal_zzatq, j, com_google_android_gms_internal_zzatq2, query.getLong(9), (zzatq) mo3544q().m10389a(query.getBlob(10), zzatq.CREATOR));
                    if (query.moveToNext()) {
                        mo3548u().m9815x().m9776a("Got multiple records for conditional property, expected one", dc.m9779a(str), str2);
                    }
                    if (query == null) {
                        return com_google_android_gms_internal_zzatg;
                    }
                    query.close();
                    return com_google_android_gms_internal_zzatg;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo3548u().m9815x().m9777a("Error querying conditional property", dc.m9779a(str), str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo3548u().m9815x().m9777a("Error querying conditional property", dc.m9779a(str), str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public byte[] m9599d(String str) {
        Object e;
        Throwable th;
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        Cursor query;
        try {
            query = m9553A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        mo3548u().m9815x().m9775a("Got multiple records for app config, expected one. appId", dc.m9779a(str));
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo3548u().m9815x().m9776a("Error querying remote config. appId", dc.m9779a(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo3548u().m9815x().m9776a("Error querying remote config. appId", dc.m9779a(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public int m9600e(String str, String str2) {
        int i = 0;
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        try {
            i = m9553A().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9777a("Error deleting conditional property", dc.m9779a(str), str2, e);
        }
        return i;
    }

    @WorkerThread
    void m9601e(String str) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        SQLiteDatabase A = m9553A();
        A.delete("property_filters", "app_id=?", new String[]{str});
        A.delete("event_filters", "app_id=?", new String[]{str});
    }

    Map<Integer, C2844f> m9602f(String str) {
        Cursor query;
        Object e;
        Throwable th;
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        try {
            query = m9553A().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            if (query.moveToFirst()) {
                Map<Integer, C2844f> arrayMap = new ArrayMap();
                do {
                    int i = query.getInt(0);
                    lt a = lt.m12332a(query.getBlob(1));
                    C2844f c2844f = new C2844f();
                    try {
                        c2844f.mo3509b(a);
                        try {
                            arrayMap.put(Integer.valueOf(i), c2844f);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        mo3548u().m9815x().m9777a("Failed to merge filter results. appId, audienceId, error", dc.m9779a(str), Integer.valueOf(i), e3);
                    }
                } while (query.moveToNext());
                if (query == null) {
                    return arrayMap;
                }
                query.close();
                return arrayMap;
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo3548u().m9815x().m9776a("Database error querying filter results. appId", dc.m9779a(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
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
    }

    Map<Integer, List<C2829b>> m9603f(String str, String str2) {
        Object e;
        Throwable th;
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        Map<Integer, List<C2829b>> arrayMap = new ArrayMap();
        Cursor query;
        try {
            query = m9553A().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    lt a = lt.m12332a(query.getBlob(1));
                    C2829b c2829b = new C2829b();
                    try {
                        c2829b.mo3509b(a);
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(c2829b);
                    } catch (IOException e2) {
                        try {
                            mo3548u().m9815x().m9776a("Failed to merge filter. appId", dc.m9779a(str), e2);
                        } catch (SQLiteException e3) {
                            e = e3;
                        }
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            }
            Map<Integer, List<C2829b>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo3548u().m9815x().m9776a("Database error querying filters. appId", dc.m9779a(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
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
    }

    Map<Integer, List<C2832e>> m9604g(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        Map<Integer, List<C2832e>> arrayMap = new ArrayMap();
        try {
            query = m9553A().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    lt a = lt.m12332a(query.getBlob(1));
                    C2832e c2832e = new C2832e();
                    try {
                        c2832e.mo3509b(a);
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(c2832e);
                    } catch (IOException e2) {
                        try {
                            mo3548u().m9815x().m9776a("Failed to merge filter", dc.m9779a(str), e2);
                        } catch (SQLiteException e3) {
                            e = e3;
                        }
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            }
            Map<Integer, List<C2832e>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo3548u().m9815x().m9776a("Database error querying filters. appId", dc.m9779a(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
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
    }

    @WorkerThread
    void m9605g(String str) {
        m9448R();
        mo3532e();
        C2513c.m7934a(str);
        try {
            SQLiteDatabase A = m9553A();
            String[] strArr = new String[]{str};
            int delete = A.delete("audience_filter_values", "app_id=?", strArr) + ((((((((A.delete("events", "app_id=?", strArr) + 0) + A.delete("user_attributes", "app_id=?", strArr)) + A.delete("conditional_properties", "app_id=?", strArr)) + A.delete("apps", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("event_filters", "app_id=?", strArr)) + A.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                mo3548u().m9786D().m9776a("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Error deleting application data. appId, error", dc.m9779a(str), e);
        }
    }

    @WorkerThread
    public long m9606h(String str) {
        C2513c.m7934a(str);
        mo3532e();
        m9448R();
        return m9607h(str, "first_open_count");
    }

    @WorkerThread
    protected long m9607h(String str, String str2) {
        Object e;
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        m9448R();
        SQLiteDatabase A = m9553A();
        A.beginTransaction();
        long a;
        try {
            a = m9542a(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (a == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (A.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    mo3548u().m9815x().m9776a("Failed to insert column (got -1). appId", dc.m9779a(str), str2);
                    A.endTransaction();
                    return -1;
                }
                a = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + a));
                if (((long) A.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    mo3548u().m9815x().m9776a("Failed to update column (got 0). appId", dc.m9779a(str), str2);
                    A.endTransaction();
                    return -1;
                }
                A.setTransactionSuccessful();
                A.endTransaction();
                return a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo3548u().m9815x().m9777a("Error inserting column. appId", dc.m9779a(str), str2, e);
                    return a;
                } finally {
                    A.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            a = 0;
            mo3548u().m9815x().m9777a("Error inserting column. appId", dc.m9779a(str), str2, e);
            return a;
        }
    }

    public void m9608i(String str) {
        try {
            m9553A().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            mo3548u().m9815x().m9776a("Failed to remove unused event metadata. appId", dc.m9779a(str), e);
        }
    }

    public long m9609j(String str) {
        C2513c.m7934a(str);
        return m9542a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @WorkerThread
    public void m9610x() {
        m9448R();
        m9553A().beginTransaction();
    }

    @WorkerThread
    public void m9611y() {
        m9448R();
        m9553A().setTransactionSuccessful();
    }

    @WorkerThread
    public void m9612z() {
        m9448R();
        m9553A().endTransaction();
    }
}
