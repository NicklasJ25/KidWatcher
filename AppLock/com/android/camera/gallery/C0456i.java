package com.android.camera.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import java.io.File;
import java.io.FileOutputStream;

public class C0456i extends C0451a {
    private int f228h;
    private Context f229i;
    private int f230j = 320;

    public C0456i(C0452b c0452b, Context context, long j, int i, Uri uri, String str, String str2, long j2, String str3, int i2) {
        super(c0452b, context.getContentResolver(), j, i, uri, str, str2, j2, str3);
        this.f229i = context;
        this.f228h = i2;
        if (this.f229i != null) {
            this.f230j = C1150y.m2548M(this.f229i).x;
        }
    }

    public int mo2085d() {
        return this.f228h;
    }

    public Bitmap mo2089f() {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        if (TextUtils.isEmpty(mo2082a()) || !new File(mo2082a()).exists()) {
            return null;
        }
        Bitmap a = C0453c.m314a(mo2082a(), this.f230j);
        try {
            FileOutputStream fileOutputStream2;
            File file = new File(mo2099h());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                fileOutputStream2 = null;
            } else {
                fileOutputStream2 = new FileOutputStream(file);
                try {
                    a.compress(CompressFormat.JPEG, 80, fileOutputStream2);
                    fileOutputStream2.flush();
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        return a;
                    }
                    try {
                        fileOutputStream.close();
                        return a;
                    } catch (Exception e2) {
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
            if (fileOutputStream2 == null) {
                return a;
            }
            try {
                fileOutputStream2.close();
                return a;
            } catch (Exception e4) {
                return a;
            }
        } catch (Exception e5) {
            if (fileOutputStream != null) {
                return a;
            }
            fileOutputStream.close();
            return a;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
