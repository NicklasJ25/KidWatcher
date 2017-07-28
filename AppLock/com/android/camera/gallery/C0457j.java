package com.android.camera.gallery;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.data.DownloadEntry;
import com.android.gallery3d.data.MediaItem;
import java.util.HashMap;

public class C0457j extends C0452b implements C0382g {
    public static final String[] f231h = new String[]{Columns.ID, DownloadEntry.Columns.DATA, "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified"};
    private static final String[] f232i = new String[]{MediaItem.MIME_TYPE_JPEG, "image/png", "image/gif"};

    public C0457j(Context context, Uri uri, int i, String str) {
        super(context, uri, i, str);
    }

    public static C0451a m320a(Context context, Cursor cursor, Uri uri) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        long j2 = cursor.getLong(2);
        if (j2 == 0) {
            j2 = cursor.getLong(7) * 1000;
        }
        int i = cursor.getInt(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(6);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return new C0456i(null, context, j, cursor.getPosition(), uri, string, string3, j2, string2, i);
    }

    protected C0451a mo2119a(Cursor cursor) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        long j2 = cursor.getLong(2);
        if (j2 == 0) {
            j2 = cursor.getLong(7) * 1000;
        }
        int i = cursor.getInt(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(6);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return new C0456i(this, m307d(), j, cursor.getPosition(), m302a(j), string, string3, j2, string2, i);
    }

    public HashMap<String, String> mo2038b() {
        Uri build = this.c.buildUpon().appendQueryParameter("distinct", "true").build();
        Cursor query = Media.query(this.a, build, new String[]{"bucket_display_name", "bucket_id"}, mo2121i(), m325j(), null);
        HashMap<String, String> hashMap = new HashMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(1), query.getString(0));
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return hashMap;
    }

    protected Cursor mo2120f() {
        return Media.query(this.a, this.c, f231h, mo2121i(), m325j(), m311h());
    }

    protected String mo2121i() {
        return this.e == null ? "(mime_type in (?, ?, ?))" : "(mime_type in (?, ?, ?)) AND bucket_id = ?";
    }

    protected String[] m325j() {
        if (this.e == null) {
            return f232i;
        }
        int length = f232i.length;
        Object obj = new String[(length + 1)];
        System.arraycopy(f232i, 0, obj, 0, length);
        obj[length] = this.e;
        return obj;
    }
}
