package com.facebook.ads.internal.p027f;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p022h.C1589d;
import com.facebook.ads.internal.p027f.C1564f.C1569a;

public class C1567d {
    private static final String f3825a = ("SELECT tokens." + C1570h.f3839a.f3805b + ", " + "tokens" + "." + C1570h.f3840b.f3805b + ", " + "events" + "." + C1562c.f3808a.f3805b + ", " + "events" + "." + C1562c.f3810c.f3805b + ", " + "events" + "." + C1562c.f3811d.f3805b + ", " + "events" + "." + C1562c.f3812e.f3805b + ", " + "events" + "." + C1562c.f3813f.f3805b + ", " + "events" + "." + C1562c.f3814g.f3805b + ", " + "events" + "." + C1562c.f3815h.f3805b + " FROM " + "events" + " JOIN " + "tokens" + " ON " + "events" + "." + C1562c.f3809b.f3805b + " = " + "tokens" + "." + C1570h.f3839a.f3805b + " ORDER BY " + "events" + "." + C1562c.f3812e.f3805b + " ASC");
    private final Context f3826b;
    private final C1570h f3827c = new C1570h(this);
    private final C1562c f3828d = new C1562c(this);
    private SQLiteOpenHelper f3829e;

    public C1567d(Context context) {
        this.f3826b = context;
    }

    private synchronized SQLiteDatabase m4355h() {
        if (this.f3829e == null) {
            this.f3829e = new C1568e(this.f3826b, this);
        }
        return this.f3829e.getWritableDatabase();
    }

    @WorkerThread
    public Cursor m4356a(int i) {
        return m4357a().rawQuery(f3825a + " LIMIT " + String.valueOf(i), null);
    }

    public SQLiteDatabase m4357a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m4355h();
        }
        throw new IllegalStateException("Cannot call getDatabase from the UI thread!");
    }

    public <T> AsyncTask m4358a(final C1564f<T> c1564f, final C1559a<T> c1559a) {
        return C1729s.m4956a(new AsyncTask<Void, Void, T>(this) {
            final /* synthetic */ C1567d f3820c;
            private C1569a f3821d;

            protected T m4347a(Void... voidArr) {
                T t = null;
                try {
                    t = c1564f.mo2731b();
                    this.f3821d = c1564f.m4350c();
                    return t;
                } catch (SQLiteException e) {
                    this.f3821d = C1569a.UNKNOWN;
                    return t;
                }
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m4347a((Void[]) objArr);
            }

            protected void onPostExecute(T t) {
                if (this.f3821d == null) {
                    c1559a.mo2736a(t);
                } else {
                    c1559a.mo2735a(this.f3821d.m4367a(), this.f3821d.m4368b());
                }
                c1559a.m4328a();
            }
        }, new Void[0]);
    }

    public AsyncTask m4359a(final C1589d c1589d, C1559a<String> c1559a) {
        return m4358a(new C1565i<String>(this) {
            final /* synthetic */ C1567d f3824b;

            public String m4351a() {
                try {
                    SQLiteDatabase a = this.f3824b.m4357a();
                    a.beginTransaction();
                    String a2 = c1589d.m4423d() != null ? this.f3824b.f3828d.m4342a(this.f3824b.f3827c.m4370a(c1589d.m4423d()), c1589d.mo2732a().f3994c, c1589d.mo2733b(), c1589d.m4424e(), c1589d.m4425f(), c1589d.m4426g(), c1589d.m4427h()) : null;
                    a.setTransactionSuccessful();
                    a.endTransaction();
                    return a2;
                } catch (Exception e) {
                    m4348a(C1569a.DATABASE_INSERT);
                    return null;
                }
            }

            public /* synthetic */ Object mo2731b() {
                return m4351a();
            }
        }, (C1559a) c1559a);
    }

    @WorkerThread
    public boolean m4360a(String str) {
        return this.f3828d.m4343a(str);
    }

    public void m4361b() {
        for (C1561g e : m4362c()) {
            e.m4339e();
        }
        if (this.f3829e != null) {
            this.f3829e.close();
            this.f3829e = null;
        }
    }

    public C1561g[] m4362c() {
        return new C1561g[]{this.f3827c, this.f3828d};
    }

    public Cursor m4363d() {
        return this.f3828d.mo2730c();
    }

    @WorkerThread
    public Cursor m4364e() {
        return this.f3828d.m4346d();
    }

    @WorkerThread
    public Cursor m4365f() {
        return this.f3827c.mo2730c();
    }

    @WorkerThread
    public void m4366g() {
        this.f3827c.m4373d();
    }
}
