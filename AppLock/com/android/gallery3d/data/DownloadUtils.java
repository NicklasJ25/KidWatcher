package com.android.gallery3d.data;

import com.android.gallery3d.common.Utils;
import com.android.gallery3d.util.ThreadPool.CancelListener;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.URL;

public class DownloadUtils {
    private static final String TAG = "DownloadService";

    public static boolean download(JobContext jobContext, URL url, OutputStream outputStream) {
        boolean z;
        Closeable closeable = null;
        try {
            closeable = url.openStream();
            dump(jobContext, closeable, outputStream);
            z = true;
        } catch (Throwable th) {
            Log.m449w(TAG, "fail to download", th);
            z = false;
        } finally {
            Utils.closeSilently(closeable);
        }
        return z;
    }

    public static void dump(JobContext jobContext, InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        int read = inputStream.read(bArr, 0, bArr.length);
        final Thread currentThread = Thread.currentThread();
        jobContext.setCancelListener(new CancelListener() {
            public void onCancel() {
                currentThread.interrupt();
            }
        });
        while (read > 0) {
            if (jobContext.isCancelled()) {
                throw new InterruptedIOException();
            }
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr, 0, bArr.length);
        }
        jobContext.setCancelListener(null);
        Thread.interrupted();
    }

    public static boolean requestDownload(JobContext jobContext, URL url, File file) {
        Throwable th;
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                boolean download = download(jobContext, url, fileOutputStream);
                Utils.closeSilently(fileOutputStream);
                return download;
            } catch (Throwable th2) {
                th = th2;
                Utils.closeSilently(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            Utils.closeSilently(fileOutputStream);
            throw th;
        }
    }
}
