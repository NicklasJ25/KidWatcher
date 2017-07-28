package com.android.camera.gallery;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.data.DownloadEntry;
import java.util.HashMap;

public class C0468o extends C0452b {
    public static final String[] f255h = new String[]{Columns.ID, DownloadEntry.Columns.DATA, "datetaken", "title", "mini_thumb_magic", "mime_type", "date_modified"};

    public C0468o(Context context, Uri uri, int i, String str) {
        super(context, uri, i, str);
    }

    public static C0451a m354a(Context context, Cursor cursor, Uri uri) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        long j2 = cursor.getLong(2);
        if (j2 == 0) {
            j2 = cursor.getLong(6) * 1000;
        }
        String string2 = cursor.getString(3);
        String string3 = cursor.getString(5);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return new C0456i(null, context, j, cursor.getPosition(), uri, string, string3, j2, string2, 0);
    }

    protected C0451a mo2119a(Cursor cursor) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        long j2 = cursor.getLong(2);
        if (j2 == 0) {
            j2 = cursor.getLong(6) * 1000;
        }
        cursor.getLong(4);
        String string2 = cursor.getString(3);
        String string3 = cursor.getString(5);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return new C0469p(this, this.a, j, cursor.getPosition(), m302a(j), string, string3, j2, string2);
    }

    public HashMap<String, String> mo2038b() {
        Uri build = this.c.buildUpon().appendQueryParameter("distinct", "true").build();
        Cursor query = Media.query(this.a, build, new String[]{"bucket_display_name", "bucket_id"}, mo2121i(), m359j(), m311h());
        try {
            HashMap<String, String> hashMap = new HashMap();
            while (query.moveToNext()) {
                hashMap.put(query.getString(1), query.getString(0));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    protected Cursor mo2120f() {
        return Media.query(this.a, this.c, f255h, mo2121i(), m359j(), m311h());
    }

    protected String mo2121i() {
        return this.e != null ? "bucket_id = '" + this.e + "'" : null;
    }

    protected String[] m359j() {
        return null;
    }
}
