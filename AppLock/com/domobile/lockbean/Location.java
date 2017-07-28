package com.domobile.lockbean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.android.gallery3d.common.Entry.Columns;
import com.domobile.applock.R;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1147a;
import java.util.ArrayList;

public final class Location implements Parcelable {
    public static final String CODE_SCENE = "scene:";
    public static final String CODE_START = "start";
    public static final String CODE_STOP = "stop";
    public static final Creator<Location> CREATOR = new C13541();
    public static final int INVALID_ID = -1;
    public static final String LOCATION_DISCONNECT_EXTRA = "intent.extra.disconnect";
    public static final String LOCATION_INTENT_EXTRA = "intent.extra.location";
    public static final String pk_location_lock_wifis = "pk_location_lock_wifis";
    public int f2915a;
    public boolean f2916b;
    public String f2917c;
    public String f2918d;
    public String f2919e;
    public String f2920f;

    static class C13541 implements Creator<Location> {
        C13541() {
        }

        public Location m3374a(Parcel parcel) {
            return new Location(parcel);
        }

        public Location[] m3375a(int i) {
            return new Location[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m3374a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m3375a(i);
        }
    }

    public static class C1355a implements BaseColumns {
        public static final String[] f2914a = new String[]{Columns.ID, "wifi", "enabled", "label", "code", "out_code"};
    }

    public Location() {
        this.f2915a = -1;
        this.f2919e = "";
        this.f2920f = "";
    }

    public Location(Cursor cursor) {
        boolean z = false;
        this.f2915a = cursor.getInt(0);
        if (cursor.getInt(2) == 1) {
            z = true;
        }
        this.f2916b = z;
        this.f2917c = cursor.getString(1);
        this.f2918d = cursor.getString(3);
        this.f2919e = cursor.getString(4);
        this.f2920f = cursor.getString(5);
    }

    public Location(Parcel parcel) {
        boolean z = true;
        this.f2915a = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f2916b = z;
        this.f2917c = parcel.readString();
        this.f2918d = parcel.readString();
        this.f2919e = parcel.readString();
        this.f2920f = parcel.readString();
    }

    public Location(Location location) {
        this.f2915a = location.f2915a;
        this.f2919e = location.f2919e;
        this.f2920f = location.f2920f;
        this.f2917c = location.f2917c;
        this.f2918d = location.f2918d;
        this.f2916b = location.f2916b;
    }

    public static int m3376a(Context context, int i) {
        return i == -1 ? 0 : C1217c.m2853a().delete("locations", "_id=" + i, null);
    }

    public static long m3377a(Context context, Location location) {
        location.f2915a = (int) C1217c.m2853a().insert("locations", null, m3378a(location));
        return (long) location.f2915a;
    }

    private static ContentValues m3378a(Location location) {
        ContentValues contentValues = new ContentValues(8);
        contentValues.put("enabled", Integer.valueOf(location.f2916b ? 1 : 0));
        contentValues.put("wifi", location.f2917c);
        contentValues.put("label", location.f2918d);
        contentValues.put("code", location.f2919e);
        contentValues.put("out_code", location.f2920f);
        return contentValues;
    }

    public static Cursor m3379a() {
        return C1217c.m2853a().query("locations", C1355a.f2914a, null, null, null, null, "_id ASC");
    }

    public static String m3380a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        return (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') ? str.substring(1, length - 1) : str;
    }

    public static ArrayList<Location> m3381a(String str, boolean z, boolean z2) {
        Object obj;
        ArrayList<Location> arrayList;
        if (z) {
            String str2 = " and enabled=1";
        } else {
            obj = "";
        }
        String str3 = !z2 ? " and code is not null and code<>''" : " and out_code is not null and out_code<>''";
        String a = C1147a.m2480a("(wifi=?", obj, str3, ")");
        if (C1217c.m2853a() == null) {
            return null;
        }
        Cursor query = C1217c.m2853a().query("locations", C1355a.f2914a, a, new String[]{str}, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(new Location(query));
            }
            return arrayList;
        } catch (Exception e) {
            arrayList = e;
            arrayList.printStackTrace();
            return null;
        } finally {
            query.close();
        }
    }

    public static void m3382a(Context context, Location location, boolean z) {
        location.f2916b = z;
        m3383b(context, location);
    }

    public static long m3383b(Context context, Location location) {
        String str = "_id=" + location.f2915a;
        return (long) C1217c.m2853a().update("locations", m3378a(location), str, null);
    }

    public String m3384a(Context context) {
        return TextUtils.isEmpty(this.f2918d) ? context.getString(R.string.location_lock) : this.f2918d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        }
        return this.f2915a == ((Location) obj).f2915a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2915a);
        parcel.writeInt(this.f2916b ? 1 : 0);
        parcel.writeString(this.f2917c);
        parcel.writeString(this.f2918d);
        parcel.writeString(this.f2919e);
        parcel.writeString(this.f2920f);
    }
}
