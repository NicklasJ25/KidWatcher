package com.android.camera.gallery;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.regex.Pattern;

public abstract class C0452b implements C0382g {
    private static final Pattern f210i = Pattern.compile("(.*)/\\d+");
    protected ContentResolver f211a;
    protected int f212b;
    protected Uri f213c;
    protected Cursor f214d;
    protected String f215e;
    protected Context f216f;
    protected boolean f217g = false;
    private final C0465l<Integer, C0451a> f218h = new C0465l(512);

    public C0452b(Context context, Uri uri, int i, String str) {
        this.f212b = i;
        this.f213c = uri;
        this.f215e = str;
        this.f216f = context;
        this.f211a = context.getContentResolver();
        this.f214d = mo2120f();
        if (this.f214d == null) {
            Log.w("BaseImageList", "createCursor returns null.");
        }
        this.f218h.m337a();
    }

    private Cursor mo2121i() {
        Cursor cursor;
        synchronized (this) {
            if (this.f214d == null || this.f214d.isClosed()) {
                cursor = null;
            } else {
                if (this.f217g) {
                    this.f214d.requery();
                    this.f217g = false;
                }
                cursor = this.f214d;
            }
        }
        return cursor;
    }

    public Uri m302a(long j) {
        try {
            if (ContentUris.parseId(this.f213c) != j) {
                Log.e("BaseImageList", "id mismatch");
            }
            return this.f213c;
        } catch (NumberFormatException e) {
            return ContentUris.withAppendedId(this.f213c, j);
        }
    }

    protected abstract C0451a mo2119a(Cursor cursor);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.camera.gallery.C0450f mo2036a(int r4) {
        /*
        r3 = this;
        r1 = 0;
        r0 = r3.f218h;
        r2 = java.lang.Integer.valueOf(r4);
        r0 = r0.m335a(r2);
        r0 = (com.android.camera.gallery.C0451a) r0;
        if (r0 != 0) goto L_0x001e;
    L_0x000f:
        r0 = r3.mo2121i();
        monitor-enter(r3);
        if (r0 == 0) goto L_0x001c;
    L_0x0016:
        r2 = r0.isClosed();	 Catch:{ all -> 0x0034 }
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x0034 }
        r0 = r1;
    L_0x001e:
        return r0;
    L_0x001f:
        r2 = r0.moveToPosition(r4);	 Catch:{ all -> 0x0034 }
        if (r2 == 0) goto L_0x0037;
    L_0x0025:
        r0 = r3.mo2119a(r0);	 Catch:{ all -> 0x0034 }
    L_0x0029:
        r1 = r3.f218h;	 Catch:{ all -> 0x0034 }
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0034 }
        r1.m336a(r2, r0);	 Catch:{ all -> 0x0034 }
        monitor-exit(r3);	 Catch:{ all -> 0x0034 }
        goto L_0x001e;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r0 = r1;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.camera.gallery.b.a(int):com.android.camera.gallery.f");
    }

    public void mo2037a() {
        try {
            m310g();
        } catch (Throwable e) {
            Log.e("BaseImageList", "Caught exception while deactivating cursor.", e);
        }
        this.f211a = null;
        if (this.f214d != null) {
            this.f214d.close();
            this.f214d = null;
        }
    }

    public int mo2039c() {
        int count;
        Cursor i = mo2121i();
        synchronized (this) {
            if (i != null) {
                if (!i.isClosed()) {
                    count = i.getCount();
                }
            }
            count = 0;
        }
        return count;
    }

    public Context m307d() {
        return this.f216f;
    }

    public boolean m308e() {
        return mo2039c() == 0;
    }

    protected abstract Cursor mo2120f();

    protected void m310g() {
        if (this.f214d != null) {
            this.f214d.deactivate();
            this.f217g = true;
        }
    }

    protected String m311h() {
        String str = this.f212b == 1 ? " ASC" : " DESC";
        return "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str;
    }
}
