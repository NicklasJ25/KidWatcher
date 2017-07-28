package com.domobile.cropimage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class C1179b implements C1175g {
    private static final Pattern f2298h = Pattern.compile("(.*)/\\d+");
    protected ContentResolver f2299a;
    protected int f2300b;
    protected Uri f2301c;
    protected Cursor f2302d;
    protected String f2303e;
    protected boolean f2304f = false;
    private final C1209m<Integer, C1178a> f2305g = new C1209m(512);

    public C1179b(ContentResolver contentResolver, Uri uri, int i, String str) {
        this.f2300b = i;
        this.f2301c = uri;
        this.f2303e = str;
        this.f2299a = contentResolver;
        this.f2302d = mo2515d();
        if (this.f2302d == null) {
            Log.w("BaseImageList", "createCursor returns null.");
        }
        this.f2305g.m2823a();
    }

    private static String m2739b(Uri uri) {
        Object path = uri.getPath();
        Matcher matcher = f2298h.matcher(path);
        return matcher.matches() ? matcher.group(1) : path;
    }

    private boolean m2740c(Uri uri) {
        Uri uri2 = this.f2301c;
        return C1203k.m2817a(uri2.getScheme(), uri.getScheme()) && C1203k.m2817a(uri2.getHost(), uri.getHost()) && C1203k.m2817a(uri2.getAuthority(), uri.getAuthority()) && C1203k.m2817a(uri2.getPath(), C1179b.m2739b(uri));
    }

    private Cursor mo2516g() {
        Cursor cursor;
        synchronized (this) {
            if (this.f2302d == null || this.f2302d.isClosed()) {
                cursor = null;
            } else {
                if (this.f2304f) {
                    this.f2302d.requery();
                    this.f2304f = false;
                }
                cursor = this.f2302d;
            }
        }
        return cursor;
    }

    public Uri m2742a(long j) {
        try {
            if (ContentUris.parseId(this.f2301c) != j) {
                Log.e("BaseImageList", "id mismatch");
            }
            return this.f2301c;
        } catch (NumberFormatException e) {
            return ContentUris.withAppendedId(this.f2301c, j);
        }
    }

    protected abstract C1178a mo2513a(Cursor cursor);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.domobile.cropimage.C1177f mo2505a(int r4) {
        /*
        r3 = this;
        r1 = 0;
        r0 = r3.f2305g;
        r2 = java.lang.Integer.valueOf(r4);
        r0 = r0.m2821a(r2);
        r0 = (com.domobile.cropimage.C1178a) r0;
        if (r0 != 0) goto L_0x001e;
    L_0x000f:
        r0 = r3.mo2516g();
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
        r0 = r3.mo2513a(r0);	 Catch:{ all -> 0x0034 }
    L_0x0029:
        r1 = r3.f2305g;	 Catch:{ all -> 0x0034 }
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0034 }
        r1.m2822a(r2, r0);	 Catch:{ all -> 0x0034 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.cropimage.b.a(int):com.domobile.cropimage.f");
    }

    public C1177f mo2506a(Uri uri) {
        C1177f c1177f = null;
        if (m2740c(uri)) {
            try {
                long parseId = ContentUris.parseId(uri);
                Cursor g = mo2516g();
                synchronized (this) {
                    if (g != null) {
                        if (!g.isClosed()) {
                            g.moveToPosition(-1);
                            int i = 0;
                            while (g.moveToNext()) {
                                if (mo2514b(g) == parseId) {
                                    c1177f = (C1178a) this.f2305g.m2821a(Integer.valueOf(i));
                                    if (c1177f == null) {
                                        c1177f = mo2513a(g);
                                        this.f2305g.m2822a(Integer.valueOf(i), c1177f);
                                    }
                                } else {
                                    i++;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                Log.i("BaseImageList", "fail to get id in: " + uri, e);
            }
        }
        return c1177f;
    }

    public void mo2507a() {
        try {
            m2751e();
        } catch (Throwable e) {
            Log.e("BaseImageList", "Caught exception while deactivating cursor.", e);
        }
        this.f2299a = null;
        if (this.f2302d != null) {
            this.f2302d.close();
            this.f2302d = null;
        }
    }

    public int mo2508b() {
        int count;
        Cursor g = mo2516g();
        synchronized (this) {
            if (g != null) {
                if (!g.isClosed()) {
                    count = g.getCount();
                }
            }
            count = 0;
        }
        return count;
    }

    protected abstract long mo2514b(Cursor cursor);

    public boolean m2749c() {
        return mo2508b() == 0;
    }

    protected abstract Cursor mo2515d();

    protected void m2751e() {
        if (this.f2302d != null) {
            this.f2302d.deactivate();
            this.f2304f = true;
        }
    }

    protected String m2752f() {
        String str = this.f2300b == 1 ? " ASC" : " DESC";
        return "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str;
    }
}
