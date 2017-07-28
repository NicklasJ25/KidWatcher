package com.domobile.cropimage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.data.DownloadEntry;
import com.android.gallery3d.data.MediaItem;

public class C1193i extends C1179b implements C1175g {
    static final String[] f2349g = new String[]{Columns.ID, DownloadEntry.Columns.DATA, "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified"};
    private static final String[] f2350h = new String[]{MediaItem.MIME_TYPE_JPEG, "image/png", "image/gif"};

    public C1193i(ContentResolver contentResolver, Uri uri, int i, String str) {
        super(contentResolver, uri, i, str);
    }

    protected C1178a mo2513a(Cursor cursor) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        long j2 = cursor.getLong(2);
        if (j2 == 0) {
            j2 = cursor.getLong(7) * 1000;
        }
        cursor.getLong(3);
        int i = cursor.getInt(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(6);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return new C1192h(this, this.a, j, cursor.getPosition(), m2742a(j), string, string3, j2, string2, i);
    }

    protected long mo2514b(Cursor cursor) {
        return cursor.getLong(0);
    }

    protected Cursor mo2515d() {
        return Media.query(this.a, this.c, f2349g, mo2516g(), m2785h(), m2752f());
    }

    protected String mo2516g() {
        return this.e == null ? "(mime_type in (?, ?, ?))" : "(mime_type in (?, ?, ?)) AND bucket_id = ?";
    }

    protected String[] m2785h() {
        if (this.e == null) {
            return f2350h;
        }
        int length = f2350h.length;
        Object obj = new String[(length + 1)];
        System.arraycopy(f2350h, 0, obj, 0, length);
        obj[length] = this.e;
        return obj;
    }
}
