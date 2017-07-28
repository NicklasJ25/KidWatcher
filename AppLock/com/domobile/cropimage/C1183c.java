package com.domobile.cropimage;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public class C1183c {
    private static C1183c f2312b = null;
    private final WeakHashMap<Thread, C1182b> f2313a = new WeakHashMap();

    private enum C1181a {
        CANCEL,
        ALLOW
    }

    private static class C1182b {
        public C1181a f2309a;
        public Options f2310b;
        public boolean f2311c;

        private C1182b() {
            this.f2309a = C1181a.ALLOW;
        }

        public String toString() {
            String str = this.f2309a == C1181a.CANCEL ? "Cancel" : this.f2309a == C1181a.ALLOW ? "Allow" : "?";
            return "thread state = " + str + ", options = " + this.f2310b;
        }
    }

    private C1183c() {
    }

    public static synchronized C1183c m2753a() {
        C1183c c1183c;
        synchronized (C1183c.class) {
            if (f2312b == null) {
                f2312b = new C1183c();
            }
            c1183c = f2312b;
        }
        return c1183c;
    }

    private synchronized void m2754a(Thread thread, Options options) {
        m2755c(thread).f2310b = options;
    }

    private synchronized C1182b m2755c(Thread thread) {
        C1182b c1182b;
        c1182b = (C1182b) this.f2313a.get(thread);
        if (c1182b == null) {
            c1182b = new C1182b();
            this.f2313a.put(thread, c1182b);
        }
        return c1182b;
    }

    public Bitmap m2756a(ContentResolver contentResolver, long j, int i, Options options, boolean z) {
        Bitmap bitmap = null;
        Thread currentThread = Thread.currentThread();
        C1182b c = m2755c(currentThread);
        if (m2759b(currentThread)) {
            boolean z2;
            try {
                synchronized (c) {
                    c.f2311c = true;
                    if (z) {
                        long id = currentThread.getId();
                        z2 = contentResolver;
                        bitmap = Thumbnails.getThumbnail(z2, j, id, i, null);
                        c.f2311c = z2;
                        c.notifyAll();
                    } else {
                        bitmap = Images.Thumbnails.getThumbnail(contentResolver, j, currentThread.getId(), i, null);
                        synchronized (c) {
                            c.f2311c = false;
                            c.notifyAll();
                        }
                    }
                }
            } finally {
                synchronized (c) {
                    z2 = false;
                    c.f2311c = false;
                    c.notifyAll();
                }
            }
        } else {
            Log.d("BitmapManager", "Thread " + currentThread + " is not allowed to decode.");
        }
        return bitmap;
    }

    public Bitmap m2757a(FileDescriptor fileDescriptor, Options options) {
        if (options.mCancel) {
            return null;
        }
        Thread currentThread = Thread.currentThread();
        if (m2759b(currentThread)) {
            m2754a(currentThread, options);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            m2758a(currentThread);
            return decodeFileDescriptor;
        }
        Log.d("BitmapManager", "Thread " + currentThread + " is not allowed to decode.");
        return null;
    }

    synchronized void m2758a(Thread thread) {
        ((C1182b) this.f2313a.get(thread)).f2310b = null;
    }

    public synchronized boolean m2759b(Thread thread) {
        boolean z = true;
        synchronized (this) {
            C1182b c1182b = (C1182b) this.f2313a.get(thread);
            if (c1182b != null) {
                z = c1182b.f2309a != C1181a.CANCEL;
            }
        }
        return z;
    }
}
