package com.domobile.applock.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.domobile.applock.C1150y;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1148d;

public class ProfilesProvider extends ContentProvider {
    private static final UriMatcher f1856a = new UriMatcher(-1);
    private static final Uri f1857b = Uri.parse("content://com.domobile.applock/profiles");

    static {
        f1856a.addURI("com.domobile.applock", "profiles", 0);
        f1856a.addURI("com.domobile.applock", "profiles/#", 1);
        f1856a.addURI("com.domobile.applock", "password", 2);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        switch (f1856a.match(uri)) {
            case 0:
                return "vnd.android.cursor.dir/vnd.profile";
            case 1:
                return "vnd.android.cursor.item/vnd.profile";
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArr3;
        String str3;
        switch (f1856a.match(uri)) {
            case 0:
                strArr3 = strArr2;
                str3 = str;
                break;
            case 1:
                str3 = "_id = ?";
                strArr3 = new String[]{String.valueOf(ContentUris.parseId(uri))};
                break;
            case 2:
                if (!C1150y.m2614c(getContext(), "first_launch")) {
                    return null;
                }
                if (!C1148d.m2535z(getContext(), "image_lock_pattern") && !C1148d.m2535z(getContext(), "password")) {
                    return null;
                }
                return new MatrixCursor(new String[]{"passwd"});
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return C1217c.m2853a().query("scenes", null, str3, strArr3, null, null, str2);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
