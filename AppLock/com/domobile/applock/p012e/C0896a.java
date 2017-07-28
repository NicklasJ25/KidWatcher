package com.domobile.applock.p012e;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.p013f.C0903a;
import com.domobile.frame.p000a.C1148d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@TargetApi(18)
public class C0896a {
    private static C0896a f1334a;
    private C0897b f1335b = new C0897b(this.f1336c);
    private Context f1336c = AppLockApplication.m577b();
    private HashMap<String, Notification> f1337d = new HashMap();
    private ArrayList<C0895a> f1338e = new ArrayList();

    class C08921 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ C0896a f1328a;

        C08921(C0896a c0896a) {
            this.f1328a = c0896a;
        }

        protected Object doInBackground(Object... objArr) {
            this.f1328a.f1337d.clear();
            Iterator it = C0900e.m1582b().iterator();
            while (it.hasNext()) {
                C0903a.m1592a(((C0899d) it.next()).m1575a(this.f1328a.f1336c));
            }
            C0900e.m1580a();
            return null;
        }

        protected void onPostExecute(Object obj) {
            this.f1328a.m1553e();
        }
    }

    public interface C0895a {
        void mo2475a(C0899d c0899d);

        void mo2476b();

        void mo2478b(C0899d c0899d);
    }

    private C0896a() {
    }

    public static synchronized C0896a m1545a() {
        C0896a c0896a;
        synchronized (C0896a.class) {
            if (f1334a == null) {
                f1334a = new C0896a();
            }
            c0896a = f1334a;
        }
        return c0896a;
    }

    private void m1550b(C0899d c0899d) {
        Iterator it = this.f1338e.iterator();
        while (it.hasNext()) {
            ((C0895a) it.next()).mo2475a(c0899d);
        }
    }

    private void m1552c(C0899d c0899d) {
        Iterator it = this.f1338e.iterator();
        while (it.hasNext()) {
            ((C0895a) it.next()).mo2478b(c0899d);
        }
    }

    private void m1553e() {
        Iterator it = this.f1338e.iterator();
        while (it.hasNext()) {
            ((C0895a) it.next()).mo2476b();
        }
    }

    @Nullable
    public Notification m1554a(String str) {
        return (Notification) this.f1337d.get(str);
    }

    public void m1555a(C0895a c0895a) {
        if (!this.f1338e.contains(c0895a)) {
            this.f1338e.add(c0895a);
        }
    }

    public void m1556a(final C0899d c0899d) {
        C1148d.m2513a(new AsyncTask<Object, Object, Object>(this) {
            final /* synthetic */ C0896a f1330b;

            protected Object doInBackground(Object... objArr) {
                this.f1330b.f1337d.remove(c0899d.f1340a);
                C0900e.m1584b(c0899d.f1340a);
                C0903a.m1592a(c0899d.m1575a(this.f1330b.f1336c));
                return null;
            }

            protected void onPostExecute(Object obj) {
                this.f1330b.m1552c(c0899d);
            }
        }, new Object[0]);
    }

    public void m1557a(final C0899d c0899d, final Notification notification) {
        C1148d.m2513a(new AsyncTask<Object, Object, Object>(this) {
            final /* synthetic */ C0896a f1333c;

            protected Object doInBackground(Object... objArr) {
                this.f1333c.f1337d.put(c0899d.f1340a, notification);
                Bitmap bitmap = notification.largeIcon;
                if (bitmap == null) {
                    bitmap = C0898c.m1571c(this.f1333c.f1336c, c0899d.f1342c);
                }
                C0903a.m1593a(c0899d.m1575a(this.f1333c.f1336c), bitmap);
                C0899d a = C0900e.m1579a(c0899d.f1340a);
                if (a == null) {
                    C0900e.m1581a(c0899d);
                } else {
                    C0903a.m1592a(a.m1575a(this.f1333c.f1336c));
                    C0900e.m1583b(c0899d);
                }
                return null;
            }

            protected void onPostExecute(Object obj) {
                this.f1333c.m1550b(c0899d);
            }
        }, new Object[0]);
    }

    public SQLiteDatabase m1558b() {
        return this.f1335b.getWritableDatabase();
    }

    public void m1559b(C0895a c0895a) {
        this.f1338e.remove(c0895a);
    }

    public SQLiteDatabase m1560c() {
        return this.f1335b.getReadableDatabase();
    }

    public void m1561d() {
        C1148d.m2513a(new C08921(this), new Object[0]);
    }
}
