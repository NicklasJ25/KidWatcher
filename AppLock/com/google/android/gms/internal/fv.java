package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.ir.C2875a;
import com.google.firebase.database.C3537c;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fv implements in {
    static final /* synthetic */ boolean f8971a = (!fv.class.desiredAssertionStatus());
    private static final Charset f8972b = Charset.forName("UTF-8");
    private final SQLiteDatabase f8973c;
    private final jp f8974d;
    private boolean f8975e;
    private long f8976f = 0;

    private static class C2878a extends SQLiteOpenHelper {
        static final /* synthetic */ boolean f8970a = (!fv.class.desiredAssertionStatus());

        public C2878a(Context context, String str) {
            super(context, str, null, 2);
        }

        private void m10843a(SQLiteDatabase sQLiteDatabase, String str) {
            String str2 = "DROP TABLE IF EXISTS ";
            String valueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (!f8970a && i2 != 2) {
                throw new AssertionError("Why is onUpgrade() called with a different version?");
            } else if (i <= 1) {
                m10843a(sQLiteDatabase, "serverCache");
                sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
                m10843a(sQLiteDatabase, "complete");
                sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            } else {
                throw new AssertionError("We don't handle upgrading to " + i2);
            }
        }
    }

    public fv(Context context, ha haVar, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.f8974d = haVar.m11314a("Persistence");
            this.f8973c = m10868a(context, encode);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private int m10865a(hh hhVar, List<String> list, int i) {
        int i2 = i + 1;
        String c = m10882c(hhVar);
        if (((String) list.get(i)).startsWith(c)) {
            while (i2 < list.size() && ((String) list.get(i2)).equals(m10870a(hhVar, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                String valueOf = String.valueOf(c);
                c = String.valueOf(".part-");
                if (str.startsWith(c.length() != 0 ? valueOf.concat(c) : new String(valueOf))) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private int m10866a(String str, hh hhVar) {
        String a = m10871a(m10882c(hhVar));
        return this.f8973c.delete(str, "path >= ? AND path < ?", new String[]{r1, a});
    }

    private Cursor m10867a(hh hhVar, String[] strArr) {
        String c = m10882c(hhVar);
        String a = m10871a(c);
        String[] strArr2 = new String[(hhVar.m11392i() + 3)];
        String valueOf = String.valueOf(m10880b(hhVar, strArr2));
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        valueOf2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[hhVar.m11392i() + 1] = c;
        strArr2[hhVar.m11392i() + 2] = a;
        return this.f8973c.query("serverCache", strArr, valueOf2, strArr2, null, null, "path");
    }

    private SQLiteDatabase m10868a(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new C2878a(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (Throwable e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new C3537c("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private kf m10869a(byte[] bArr) {
        try {
            return kg.m12177a(ky.m12274b(new String(bArr, f8972b)));
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Could not deserialize node: ";
            String valueOf = String.valueOf(new String(bArr, f8972b));
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }

    private String m10870a(hh hhVar, int i) {
        String valueOf = String.valueOf(m10882c(hhVar));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private static String m10871a(String str) {
        if (f8971a || str.endsWith("/")) {
            String valueOf = String.valueOf(str.substring(0, str.length() - 1));
            return new StringBuilder(String.valueOf(valueOf).length() + 1).append(valueOf).append('0').toString();
        }
        throw new AssertionError("Path keys must end with a '/'");
    }

    private String m10872a(Collection<Long> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append(longValue2);
            obj = null;
        }
        return stringBuilder.toString();
    }

    private static List<byte[]> m10873a(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        List<byte[]> arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min(i, bArr.length - (i2 * i));
            Object obj = new byte[min];
            System.arraycopy(bArr, i2 * i, obj, 0, min);
            arrayList.add(obj);
        }
        return arrayList;
    }

    private void m10874a(hh hhVar, long j, String str, byte[] bArr) {
        m10884g();
        this.f8973c.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= 262144) {
            List a = m10873a(bArr, 262144);
            for (int i = 0; i < a.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j));
                contentValues.put("path", m10882c(hhVar));
                contentValues.put("type", str);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", (byte[]) a.get(i));
                this.f8973c.insertWithOnConflict("writes", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Long.valueOf(j));
        contentValues2.put("path", m10882c(hhVar));
        contentValues2.put("type", str);
        contentValues2.put("part", null);
        contentValues2.put("node", bArr);
        this.f8973c.insertWithOnConflict("writes", null, contentValues2, 5);
    }

    private void m10875a(hh hhVar, hh hhVar2, ir<Long> irVar, final ir<Long> irVar2, io ioVar, List<lf<hh, kf>> list) {
        if (irVar.m11788b() != null) {
            if (((Integer) ioVar.m11730a(Integer.valueOf(0), new C2875a<Void, Integer>(this) {
                public Integer m10839a(hh hhVar, Void voidR, Integer num) {
                    return Integer.valueOf(irVar2.m11796e(hhVar) == null ? num.intValue() + 1 : num.intValue());
                }
            })).intValue() > 0) {
                hh a = hhVar.m11381a(hhVar2);
                if (this.f8974d.m11961a()) {
                    this.f8974d.m11960a(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(r0), a}), new Object[0]);
                }
                final kf b = m10879b(a);
                final ir<Long> irVar3 = irVar2;
                final List<lf<hh, kf>> list2 = list;
                final hh hhVar3 = hhVar2;
                ioVar.m11730a(null, new C2875a<Void, Void>(this) {
                    public Void m10842a(hh hhVar, Void voidR, Void voidR2) {
                        if (irVar3.m11796e(hhVar) == null) {
                            list2.add(new lf(hhVar3.m11381a(hhVar), b.mo3772a(hhVar)));
                        }
                        return null;
                    }
                });
                return;
            }
            return;
        }
        Iterator it = irVar.m11791c().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            js jsVar = (js) entry.getKey();
            io a2 = ioVar.m11729a((js) entry.getKey());
            m10875a(hhVar, hhVar2.m11382a(jsVar), (ir) entry.getValue(), irVar2.m11784a(jsVar), a2, list);
        }
    }

    private void m10876a(hh hhVar, kf kfVar, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            i = 0;
            i2 = 0;
            for (ke keVar : kfVar) {
                i2 += m10866a("serverCache", hhVar.m11382a(keVar.m12169c()));
                i = m10881c(hhVar.m11382a(keVar.m12169c()), keVar.m12170d()) + i;
            }
        } else {
            i2 = m10866a("serverCache", hhVar);
            i = m10881c(hhVar, kfVar);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), hhVar.toString(), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    private byte[] m10877a(Object obj) {
        try {
            return ky.m12267a(obj).getBytes(f8972b);
        } catch (Throwable e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private byte[] m10878a(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i = length.length + i;
        }
        Object obj = new byte[i];
        i = 0;
        for (byte[] length2 : list) {
            System.arraycopy(length2, 0, obj, i, length2.length);
            i = length2.length + i;
        }
        return obj;
    }

    private kf m10879b(hh hhVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = m10867a(hhVar, new String[]{"path", "value"});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (a.moveToNext()) {
            try {
                arrayList.add(a.getString(0));
                arrayList2.add(a.getBlob(1));
            } finally {
                a.close();
            }
        }
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        kf j = jx.m12080j();
        Object obj = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < arrayList2.size()) {
            int a2;
            hh hhVar2;
            kf a3;
            Object obj2;
            kf kfVar;
            if (((String) arrayList.get(i)).endsWith(".part-0000")) {
                String str = (String) arrayList.get(i);
                hh hhVar3 = new hh(str.substring(0, str.length() - ".part-0000".length()));
                a2 = m10865a(hhVar3, arrayList, i);
                if (this.f8974d.m11961a()) {
                    this.f8974d.m11960a("Loading split node with " + a2 + " parts.", new Object[0]);
                }
                byte[] a4 = m10878a(arrayList2.subList(i, i + a2));
                a2 = (i + a2) - 1;
                hhVar2 = hhVar3;
                a3 = m10869a(a4);
            } else {
                kf a5 = m10869a((byte[]) arrayList2.get(i));
                hh hhVar4 = new hh((String) arrayList.get(i));
                a3 = a5;
                a2 = i;
                hhVar2 = hhVar4;
            }
            if (hhVar2.m11390g() != null && hhVar2.m11390g().m12011e()) {
                hashMap.put(hhVar2, a3);
                obj2 = obj;
                kfVar = j;
            } else if (hhVar2.m11384b(hhVar)) {
                lh.m12296a(obj == null, "Descendants of path must come after ancestors.");
                Object obj3 = obj;
                kfVar = a3.mo3772a(hh.m11377a(hhVar2, hhVar));
                obj2 = obj3;
            } else if (hhVar.m11384b(hhVar2)) {
                obj2 = 1;
                kfVar = j.mo3773a(hh.m11377a(hhVar, hhVar2), a3);
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{hhVar2, hhVar}));
            }
            i = a2 + 1;
            j = kfVar;
            obj = obj2;
        }
        for (Entry entry : hashMap.entrySet()) {
            j = j.mo3773a(hh.m11377a(hhVar, (hh) entry.getKey()), (kf) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(lc.m12282b(j)), hhVar, Long.valueOf(currentTimeMillis7), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)}), new Object[0]);
        }
        return j;
    }

    private static String m10880b(hh hhVar, String[] strArr) {
        if (f8971a || strArr.length >= hhVar.m11392i() + 1) {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder("(");
            while (!hhVar.m11391h()) {
                stringBuilder.append("path");
                stringBuilder.append(" = ? OR ");
                strArr[i] = m10882c(hhVar);
                hhVar = hhVar.m11389f();
                i++;
            }
            stringBuilder.append("path");
            stringBuilder.append(" = ?)");
            strArr[i] = m10882c(hh.m11376a());
            return stringBuilder.toString();
        }
        throw new AssertionError();
    }

    private int m10881c(hh hhVar, kf kfVar) {
        long a = lc.m12281a(kfVar);
        if (!(kfVar instanceof jt) || a <= PlaybackStateCompat.ACTION_PREPARE) {
            m10883d(hhVar, kfVar);
            return 1;
        }
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{hhVar, Long.valueOf(a), Integer.valueOf(16384)}), new Object[0]);
        }
        int i = 0;
        for (ke keVar : kfVar) {
            i = m10881c(hhVar.m11382a(keVar.m12169c()), keVar.m12170d()) + i;
        }
        if (!kfVar.mo3783f().mo3778b()) {
            m10883d(hhVar.m11382a(js.m12008c()), kfVar.mo3783f());
            i++;
        }
        m10883d(hhVar, jx.m12080j());
        return i + 1;
    }

    private static String m10882c(hh hhVar) {
        return hhVar.m11391h() ? "/" : String.valueOf(hhVar.toString()).concat("/");
    }

    private void m10883d(hh hhVar, kf kfVar) {
        byte[] a = m10877a(kfVar.mo3775a(true));
        if (a.length >= 262144) {
            List a2 = m10873a(a, 262144);
            if (this.f8974d.m11961a()) {
                this.f8974d.m11960a("Saving huge leaf node with " + a2.size() + " parts.", new Object[0]);
            }
            for (int i = 0; i < a2.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", m10870a(hhVar, i));
                contentValues.put("value", (byte[]) a2.get(i));
                this.f8973c.insertWithOnConflict("serverCache", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("path", m10882c(hhVar));
        contentValues2.put("value", a);
        this.f8973c.insertWithOnConflict("serverCache", null, contentValues2, 5);
    }

    private void m10884g() {
        lh.m12296a(this.f8975e, "Transaction expected to already be in progress.");
    }

    public kf mo3613a(hh hhVar) {
        return m10879b(hhVar);
    }

    public List<hv> mo3614a() {
        String[] strArr = new String[]{"id", "path", "type", "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f8973c.query("writes", strArr, null, null, null, null, "id, part");
        List<hv> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                byte[] blob;
                Object hvVar;
                long j = query.getLong(0);
                hh hhVar = new hh(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    blob = query.getBlob(4);
                } else {
                    List arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } while (query.getLong(0) == j);
                    query.moveToPrevious();
                    blob = m10878a(arrayList2);
                }
                Object b = ky.m12274b(new String(blob, f8972b));
                if ("o".equals(string)) {
                    hvVar = new hv(j, hhVar, kg.m12177a(b), true);
                } else if ("m".equals(string)) {
                    hvVar = new hv(j, hhVar, gx.m11276a((Map) b));
                } else {
                    String str = "Got invalid write type: ";
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                arrayList.add(hvVar);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public Set<js> mo3615a(Set<Long> set) {
        String[] strArr = new String[]{"key"};
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf("id IN (");
        String valueOf2 = String.valueOf(m10872a((Collection) set));
        Cursor query = this.f8973c.query(true, "trackedKeys", strArr, new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append(")").toString(), null, null, null, null, null);
        Set<js> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(js.m12005a(query.getString(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return hashSet;
    }

    public void mo3616a(long j) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.f8973c.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void mo3617a(long j, Set<js> set) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.f8973c.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (js jsVar : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", jsVar.m12010d());
            this.f8973c.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo3618a(long j, Set<js> set, Set<js> set2) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id = ? AND key = ?";
        String valueOf = String.valueOf(j);
        for (js jsVar : set2) {
            this.f8973c.delete("trackedKeys", str, new String[]{valueOf, jsVar.m12010d()});
        }
        for (js jsVar2 : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", jsVar2.m12010d());
            this.f8973c.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo3619a(hh hhVar, gx gxVar) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = gxVar.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i += m10866a("serverCache", hhVar.m11381a((hh) entry.getKey()));
            i2 = m10881c(hhVar.m11381a((hh) entry.getKey()), (kf) entry.getValue()) + i2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), hhVar.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo3620a(hh hhVar, gx gxVar, long j) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        hh hhVar2 = hhVar;
        long j2 = j;
        m10874a(hhVar2, j2, "m", m10877a(gxVar.m11284a(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo3621a(hh hhVar, io ioVar) {
        if (ioVar.m11731a()) {
            m10884g();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = m10867a(hhVar, new String[]{"rowid", "path"});
            ir irVar = new ir(null);
            ir irVar2 = new ir(null);
            while (a.moveToNext()) {
                long j = a.getLong(0);
                hh hhVar2 = new hh(a.getString(1));
                jp jpVar;
                String valueOf;
                String valueOf2;
                if (hhVar.m11384b(hhVar2)) {
                    hh a2 = hh.m11377a(hhVar, hhVar2);
                    if (ioVar.m11732a(a2)) {
                        irVar = irVar.m11783a(a2, Long.valueOf(j));
                    } else if (ioVar.m11733b(a2)) {
                        irVar2 = irVar2.m11783a(a2, Long.valueOf(j));
                    } else {
                        jpVar = this.f8974d;
                        valueOf = String.valueOf(hhVar);
                        valueOf2 = String.valueOf(hhVar2);
                        jpVar.m11957a(new StringBuilder((String.valueOf(valueOf).length() + 88) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" and have data at ").append(valueOf2).append(" that isn't marked for pruning or keeping. Ignoring.").toString());
                    }
                } else {
                    jpVar = this.f8974d;
                    valueOf = String.valueOf(hhVar);
                    valueOf2 = String.valueOf(hhVar2);
                    jpVar.m11957a(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" but we have data stored higher up at ").append(valueOf2).append(". Ignoring.").toString());
                }
            }
            int i = 0;
            int i2 = 0;
            if (!irVar.m11795d()) {
                List<lf> arrayList = new ArrayList();
                m10875a(hhVar, hh.m11376a(), irVar, irVar2, ioVar, arrayList);
                Collection e = irVar.m11797e();
                String valueOf3 = String.valueOf(m10872a(e));
                this.f8973c.delete("serverCache", new StringBuilder(String.valueOf(valueOf3).length() + 11).append("rowid IN (").append(valueOf3).append(")").toString(), null);
                for (lf lfVar : arrayList) {
                    m10881c(hhVar.m11381a((hh) lfVar.m12286a()), (kf) lfVar.m12287b());
                }
                i = e.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.f8974d.m11961a()) {
                this.f8974d.m11960a(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), new Object[0]);
            }
        }
    }

    public void mo3622a(hh hhVar, kf kfVar) {
        m10884g();
        m10876a(hhVar, kfVar, false);
    }

    public void mo3623a(hh hhVar, kf kfVar, long j) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        hh hhVar2 = hhVar;
        long j2 = j;
        m10874a(hhVar2, j2, "o", m10877a(kfVar.mo3775a(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo3624a(ip ipVar) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(ipVar.f9432a));
        contentValues.put("path", m10882c(ipVar.f9433b.m11869a()));
        contentValues.put("queryParams", ipVar.f9433b.m11870b().m11865n());
        contentValues.put("lastUse", Long.valueOf(ipVar.f9434c));
        contentValues.put("complete", Boolean.valueOf(ipVar.f9435d));
        contentValues.put("active", Boolean.valueOf(ipVar.f9436e));
        this.f8973c.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public long mo3625b() {
        long j = null;
        Cursor rawQuery = this.f8973c.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{"value", "path", "serverCache"}), null);
        try {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                return j;
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public void mo3626b(long j) {
        m10884g();
        String valueOf = String.valueOf(j);
        this.f8973c.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.f8973c.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public void mo3627b(hh hhVar, kf kfVar) {
        m10884g();
        m10876a(hhVar, kfVar, true);
    }

    public List<ip> mo3628c() {
        String[] strArr = new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f8973c.query("trackedQueries", strArr, null, null, null, null, "id");
        List<ip> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new ip(query.getLong(0), je.m11868a(new hh(query.getString(1)), ky.m12270a(query.getString(2))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public void mo3629c(long j) {
        m10884g();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.valueOf(false));
        contentValues.put("lastUse", Long.valueOf(j));
        this.f8973c.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public Set<js> mo3630d(long j) {
        return mo3615a(Collections.singleton(Long.valueOf(j)));
    }

    public void mo3631d() {
        lh.m12296a(!this.f8975e, "runInTransaction called when an existing transaction is already in progress.");
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a("Starting transaction.", new Object[0]);
        }
        this.f8973c.beginTransaction();
        this.f8975e = true;
        this.f8976f = System.currentTimeMillis();
    }

    public void mo3632e() {
        this.f8973c.endTransaction();
        this.f8975e = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f8976f;
        if (this.f8974d.m11961a()) {
            this.f8974d.m11960a(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void mo3633f() {
        this.f8973c.setTransactionSuccessful();
    }
}
