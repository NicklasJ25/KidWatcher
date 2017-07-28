package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

public class C2593r {
    @TargetApi(21)
    public static File m8322a(Context context) {
        return C2590o.m8315j() ? context.getNoBackupFilesDir() : C2593r.m8323a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m8323a(File file) {
        synchronized (C2593r.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                String str = "SupportV4Utils";
                String str2 = "Unable to create no-backup dir ";
                String valueOf = String.valueOf(file.getPath());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                file = null;
            }
        }
        return file;
    }
}
