package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.C2580e;
import java.util.ArrayList;
import java.util.List;

public class da extends dn {
    private final C2757a f8350a = new C2757a(this, mo3541n(), m9769z());
    private boolean f8351b;

    @TargetApi(11)
    private class C2757a extends SQLiteOpenHelper {
        final /* synthetic */ da f8349a;

        C2757a(da daVar, Context context, String str) {
            this.f8349a = daVar;
            super(context, str, null, 1);
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                if (VERSION.SDK_INT < 11 || !(e instanceof SQLiteDatabaseLockedException)) {
                    this.f8349a.mo3548u().m9815x().m9774a("Opening the local database failed, dropping and recreating it");
                    String z = this.f8349a.m9769z();
                    if (!this.f8349a.mo3541n().getDatabasePath(z).delete()) {
                        this.f8349a.mo3548u().m9815x().m9775a("Failed to delete corrupted local db file", z);
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e2) {
                        this.f8349a.mo3548u().m9815x().m9775a("Failed to open local database. Events will bypass local storage", e2);
                        return null;
                    }
                }
                throw e2;
            }
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            cq.m9545a(this.f8349a.mo3548u(), sQLiteDatabase);
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
            cq.m9546a(this.f8349a.mo3548u(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    da(dk dkVar) {
        super(dkVar);
    }

    @WorkerThread
    @TargetApi(11)
    private boolean m9739a(int i, byte[] bArr) {
        mo3530c();
        mo3532e();
        if (this.f8351b) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        mo3550w().ai();
        int i2 = 0;
        int i3 = 5;
        while (i2 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = m9767x();
                if (sQLiteDatabase == null) {
                    this.f8351b = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                long j = 0;
                Cursor rawQuery = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    j = rawQuery.getLong(0);
                }
                if (j >= 100000) {
                    mo3548u().m9815x().m9774a("Data loss, local db full");
                    j = (100000 - j) + 1;
                    long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j)});
                    if (delete != j) {
                        mo3548u().m9815x().m9777a("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j), Long.valueOf(delete), Long.valueOf(j - delete));
                    }
                }
                sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                mo3548u().m9815x().m9775a("Error writing entry to local database", e);
                this.f8351b = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i2++;
            } catch (SQLiteException e2) {
                if (VERSION.SDK_INT < 11 || !(e2 instanceof SQLiteDatabaseLockedException)) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    mo3548u().m9815x().m9775a("Error writing entry to local database", e2);
                    this.f8351b = true;
                } else {
                    SystemClock.sleep((long) i3);
                    i3 += 20;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i2++;
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        mo3548u().m9817z().m9774a("Failed to write entry to local database");
        return false;
    }

    @TargetApi(11)
    public List<zza> m9740a(int i) {
        Object obj;
        Throwable th;
        mo3532e();
        mo3530c();
        int i2 = VERSION.SDK_INT;
        if (this.f8351b) {
            return null;
        }
        List<zza> arrayList = new ArrayList();
        if (!m9768y()) {
            return arrayList;
        }
        int i3 = 5;
        int i4 = 0;
        while (i4 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase x = m9767x();
                if (x == null) {
                    try {
                        this.f8351b = true;
                        if (x != null) {
                            x.close();
                        }
                        return null;
                    } catch (SQLiteFullException e) {
                        SQLiteFullException sQLiteFullException = e;
                        sQLiteDatabase = x;
                        obj = sQLiteFullException;
                    } catch (SQLiteException e2) {
                        SQLiteException sQLiteException = e2;
                        sQLiteDatabase = x;
                        obj = sQLiteException;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        sQLiteDatabase = x;
                        th = th3;
                    }
                } else {
                    x.beginTransaction();
                    Cursor query = x.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(i));
                    long j = -1;
                    while (query.moveToNext()) {
                        long j2 = query.getLong(0);
                        int i5 = query.getInt(1);
                        byte[] blob = query.getBlob(2);
                        Object obj2;
                        if (i5 == 0) {
                            Parcel obtain = Parcel.obtain();
                            try {
                                obtain.unmarshall(blob, 0, blob.length);
                                obtain.setDataPosition(0);
                                obj2 = (zzatq) zzatq.CREATOR.createFromParcel(obtain);
                                if (obj2 != null) {
                                    arrayList.add(obj2);
                                }
                            } catch (C2550a e3) {
                                obj2 = mo3548u().m9815x();
                                obj2.m9774a("Failed to load event from local database");
                                j = j2;
                            } finally {
                                obtain.recycle();
                            }
                        } else if (i5 == 1) {
                            r7 = Parcel.obtain();
                            try {
                                r7.unmarshall(blob, 0, blob.length);
                                r7.setDataPosition(0);
                                obj2 = (zzauq) zzauq.CREATOR.createFromParcel(r7);
                            } catch (C2550a e4) {
                                obj2 = mo3548u().m9815x();
                                obj2.m9774a("Failed to load user property from local database");
                                obj2 = null;
                                if (obj2 != null) {
                                    arrayList.add(obj2);
                                }
                                j = j2;
                            } finally {
                                r7.recycle();
                            }
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                        } else if (i5 == 2) {
                            r7 = Parcel.obtain();
                            try {
                                r7.unmarshall(blob, 0, blob.length);
                                r7.setDataPosition(0);
                                obj2 = (zzatg) zzatg.CREATOR.createFromParcel(r7);
                            } catch (C2550a e5) {
                                obj2 = mo3548u().m9815x();
                                obj2.m9774a("Failed to load user property from local database");
                                obj2 = null;
                                if (obj2 != null) {
                                    arrayList.add(obj2);
                                }
                                j = j2;
                            } finally {
                                r7.recycle();
                            }
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                        } else {
                            mo3548u().m9815x().m9774a("Unknown record type in local database");
                        }
                        j = j2;
                    }
                    query.close();
                    if (x.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                        mo3548u().m9815x().m9774a("Fewer entries removed from local database than expected");
                    }
                    x.setTransactionSuccessful();
                    x.endTransaction();
                    if (x != null) {
                        x.close();
                    }
                    return arrayList;
                }
            } catch (SQLiteFullException e6) {
                obj = e6;
                mo3548u().m9815x().m9775a("Error reading entries from local database", obj);
                this.f8351b = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i2 = i3;
                } else {
                    i2 = i3;
                }
                i4++;
                i3 = i2;
            } catch (SQLiteException e7) {
                obj = e7;
                if (VERSION.SDK_INT < 11 || !(obj instanceof SQLiteDatabaseLockedException)) {
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    mo3548u().m9815x().m9775a("Error reading entries from local database", obj);
                    this.f8351b = true;
                    i2 = i3;
                } else {
                    SystemClock.sleep((long) i3);
                    i2 = i3 + 20;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i4++;
                i3 = i2;
            }
        }
        mo3548u().m9817z().m9774a("Failed to read events from database in reasonable time");
        return null;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        throw th;
    }

    protected void mo3551a() {
    }

    public boolean m9742a(zzatg com_google_android_gms_internal_zzatg) {
        int i = VERSION.SDK_INT;
        byte[] a = mo3544q().m10409a((Parcelable) com_google_android_gms_internal_zzatg);
        if (a.length <= 131072) {
            return m9739a(2, a);
        }
        mo3548u().m9817z().m9774a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public boolean m9743a(zzatq com_google_android_gms_internal_zzatq) {
        int i = VERSION.SDK_INT;
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzatq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m9739a(0, marshall);
        }
        mo3548u().m9817z().m9774a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public boolean m9744a(zzauq com_google_android_gms_internal_zzauq) {
        int i = VERSION.SDK_INT;
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzauq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m9739a(1, marshall);
        }
        mo3548u().m9817z().m9774a("User property too long for local database. Sending directly to service");
        return false;
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    @WorkerThread
    SQLiteDatabase m9767x() {
        int i = VERSION.SDK_INT;
        if (this.f8351b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f8350a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f8351b = true;
        return null;
    }

    boolean m9768y() {
        return mo3541n().getDatabasePath(m9769z()).exists();
    }

    String m9769z() {
        return mo3550w().m9488U();
    }
}
