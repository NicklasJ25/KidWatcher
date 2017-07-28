package com.domobile.lockbean;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.android.gallery3d.common.Entry.Columns;
import com.domobile.applock.ActiveProfileActivity;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1147a;
import java.util.ArrayList;
import java.util.HashMap;

public class Scene implements Parcelable {
    public static final Creator<Scene> CREATOR = new C13561();
    public static final int GUEST_ID = -2;
    public static final int MASTER_ID = -1;
    public static final int PAST_ID = -3;
    public long f2922a;
    public String f2923b;
    private String f2924c;

    static class C13561 implements Creator<Scene> {
        C13561() {
        }

        public Scene m3385a(Parcel parcel) {
            return new Scene(parcel);
        }

        public Scene[] m3386a(int i) {
            return new Scene[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m3385a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m3386a(i);
        }
    }

    public static class C1357a implements BaseColumns {
        static final String[] f2921a = new String[]{Columns.ID, "name"};
    }

    public Scene() {
        this.f2922a = -1;
    }

    public Scene(long j, String str) {
        this.f2922a = j;
        this.f2923b = str;
        this.f2924c = "";
    }

    private Scene(Cursor cursor) {
        this.f2922a = cursor.getLong(0);
        this.f2923b = cursor.getString(1);
        if (cursor.getColumnCount() > 2) {
            this.f2924c = C1147a.m2480a(cursor.getString(2), ",");
        }
    }

    public Scene(Parcel parcel) {
        this.f2922a = parcel.readLong();
        this.f2923b = parcel.readString();
        this.f2924c = parcel.readString();
    }

    public static Cursor m3387a(boolean z) {
        return z ? C1217c.m2853a().query("scenes", C1357a.f2921a, null, null, null, null, null) : C1217c.m2853a().rawQuery("select s._id,s.name,l.pname from scenes as s left outer JOIN locks as l on l.sid=s._id", null);
    }

    public static ArrayList<Scene> m3388a(Context context) {
        return m3389a(context, true);
    }

    public static ArrayList<Scene> m3389a(Context context, boolean z) {
        Cursor a = m3387a(z);
        HashMap hashMap = new HashMap();
        PackageManager packageManager = context.getPackageManager();
        if (a != null) {
            while (a.moveToNext()) {
                int i = a.getInt(0);
                if (z) {
                    hashMap.put(Integer.valueOf(i), new Scene(a));
                } else {
                    if (!m3391a(packageManager, a.getString(2))) {
                        continue;
                    } else if (hashMap.containsKey(Integer.valueOf(i))) {
                        Scene scene = (Scene) hashMap.get(Integer.valueOf(i));
                        if (!scene.f2924c.contains(C1147a.m2480a(r2, ","))) {
                            scene.f2924c = C1147a.m2480a(scene.f2924c, C1147a.m2480a(r2, ","));
                        }
                    } else {
                        try {
                            hashMap.put(Integer.valueOf(i), new Scene(a));
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            a.close();
                        }
                    }
                }
            }
        }
        ArrayList<Scene> arrayList = new ArrayList();
        arrayList.add(new Scene(-1, context.getString(R.string.default_profile)));
        Scene scene2 = new Scene(-2, context.getString(R.string.guest_profile));
        if (!z) {
            a = C1217c.m2853a().query("locks", new String[]{"pname"}, "sid=-2", null, null, null, null);
            if (a != null) {
                while (a.moveToNext()) {
                    try {
                        if (m3391a(packageManager, a.getString(0))) {
                            if (!scene2.f2924c.contains(C1147a.m2480a(a.getString(0), ","))) {
                                scene2.f2924c = C1147a.m2480a(scene2.f2924c, C1147a.m2480a(a.getString(0), ","));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } finally {
                        a.close();
                    }
                }
            }
        }
        arrayList.add(scene2);
        if (hashMap.values() != null) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public static void m3390a(String str, int i) {
        Cursor a = m3387a(true);
        if (a != null) {
            try {
                if (a.getCount() > 0) {
                    C1217c.m2853a().beginTransaction();
                    int i2 = -2;
                    boolean moveToNext;
                    do {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("sid", Integer.valueOf(i2));
                        contentValues.put("pname", str);
                        contentValues.put("type", Integer.valueOf(i));
                        C1217c.m2853a().insert("locks", null, contentValues);
                        moveToNext = a.moveToNext();
                        if (moveToNext) {
                            i2 = a.getInt(0);
                            continue;
                        }
                    } while (moveToNext);
                    C1217c.m2853a().setTransactionSuccessful();
                }
            } catch (Exception e) {
                if (a != null) {
                    a.close();
                }
                try {
                    C1217c.m2853a().endTransaction();
                    return;
                } catch (Exception e2) {
                    return;
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
                try {
                    C1217c.m2853a().endTransaction();
                } catch (Exception e3) {
                }
            }
        }
        if (a != null) {
            a.close();
        }
        try {
            C1217c.m2853a().endTransaction();
        } catch (Exception e4) {
        }
    }

    static boolean m3391a(PackageManager packageManager, String str) {
        return TextUtils.isEmpty(str) ? false : C1150y.m2593a(packageManager, str) || str.startsWith("key_locked_") || "com.domobile.notification".equals(str);
    }

    public static final int deleteScene(long j) {
        String a = C1147a.m2480a("_id=", Long.valueOf(j));
        C1359b.m3416a(j);
        return C1217c.m2853a().delete("scenes", a, null);
    }

    public static final long insertScenes(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        return C1217c.m2853a().insert("scenes", null, contentValues);
    }

    public static final long updateScenes(long j, String str) {
        String a = C1147a.m2480a("_id=", Long.valueOf(j));
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        C1359b.m3421b(new Scene(j, str));
        return (long) C1217c.m2853a().update("scenes", contentValues, a, null);
    }

    public String m3392a() {
        if (TextUtils.isEmpty(this.f2924c)) {
            return this.f2924c;
        }
        if (this.f2924c.startsWith(",")) {
            this.f2924c = this.f2924c.substring(1);
        }
        if (this.f2924c.endsWith(",")) {
            this.f2924c = this.f2924c.substring(0, this.f2924c.length() - 1);
        }
        return this.f2924c;
    }

    public Intent m3393b(Context context) {
        return m3394b(context, true);
    }

    public Intent m3394b(Context context, boolean z) {
        Parcelable intent = new Intent(context, ActiveProfileActivity.class);
        intent.putExtra("com.domobile.applock.EXTRA_PROFILE_ID", this.f2922a);
        intent.putExtra("com.domobile.applock.EXTRA_PROFILE_NAME", this.f2923b);
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", this.f2923b);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.drawable.icon));
        if (z) {
            context.sendBroadcast(intent2);
        }
        return intent2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2922a);
        parcel.writeString(this.f2923b);
        parcel.writeString(this.f2924c);
    }
}
