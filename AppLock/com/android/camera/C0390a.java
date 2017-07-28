package com.android.camera;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public class C0390a {
    private static C0390a f55b = null;
    private final WeakHashMap<Thread, C0389b> f56a = new WeakHashMap();

    private enum C0388a {
        CANCEL,
        ALLOW
    }

    private static class C0389b {
        public C0388a f52a;
        public Options f53b;
        public boolean f54c;

        private C0389b() {
            this.f52a = C0388a.ALLOW;
        }

        public String toString() {
            String str = this.f52a == C0388a.CANCEL ? "Cancel" : this.f52a == C0388a.ALLOW ? "Allow" : "?";
            return "thread state = " + str + ", options = " + this.f53b;
        }
    }

    private C0390a() {
    }

    public static synchronized C0390a m84a() {
        C0390a c0390a;
        synchronized (C0390a.class) {
            if (f55b == null) {
                f55b = new C0390a();
            }
            c0390a = f55b;
        }
        return c0390a;
    }

    private synchronized void m85a(Thread thread, Options options) {
        m86d(thread).f53b = options;
    }

    private synchronized C0389b m86d(Thread thread) {
        C0389b c0389b;
        c0389b = (C0389b) this.f56a.get(thread);
        if (c0389b == null) {
            c0389b = new C0389b();
            this.f56a.put(thread, c0389b);
        }
        return c0389b;
    }

    public Bitmap m87a(ContentResolver contentResolver, long j, int i, Options options, boolean z) {
        Bitmap bitmap = null;
        Thread currentThread = Thread.currentThread();
        C0389b d = m86d(currentThread);
        if (m90b(currentThread)) {
            boolean z2;
            try {
                synchronized (d) {
                    d.f54c = true;
                    if (z) {
                        long id = currentThread.getId();
                        z2 = contentResolver;
                        bitmap = Thumbnails.getThumbnail(z2, j, id, i, null);
                        d.f54c = z2;
                        d.notifyAll();
                    } else {
                        bitmap = Images.Thumbnails.getThumbnail(contentResolver, j, currentThread.getId(), i, null);
                        synchronized (d) {
                            d.f54c = false;
                            d.notifyAll();
                        }
                    }
                }
            } finally {
                synchronized (d) {
                    z2 = false;
                    d.f54c = false;
                    d.notifyAll();
                }
            }
        } else {
            Log.d("BitmapManager", "Thread " + currentThread + " is not allowed to decode.");
        }
        return bitmap;
    }

    public Bitmap m88a(FileDescriptor fileDescriptor, Options options) {
        if (options.mCancel) {
            return null;
        }
        Thread currentThread = Thread.currentThread();
        if (m90b(currentThread)) {
            m85a(currentThread, options);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            m89a(currentThread);
            return decodeFileDescriptor;
        }
        Log.d("BitmapManager", "Thread " + currentThread + " is not allowed to decode.");
        return null;
    }

    synchronized void m89a(Thread thread) {
        ((C0389b) this.f56a.get(thread)).f53b = null;
    }

    public synchronized boolean m90b(Thread thread) {
        boolean z = true;
        synchronized (this) {
            C0389b c0389b = (C0389b) this.f56a.get(thread);
            if (c0389b != null) {
                z = c0389b.f52a != C0388a.CANCEL;
            }
        }
        return z;
    }

    public synchronized void m91c(Thread thread) {
        m86d(thread).f52a = C0388a.ALLOW;
    }
}
