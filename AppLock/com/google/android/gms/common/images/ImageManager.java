package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.C2499a.C2498a;
import com.google.android.gms.common.images.C2499a.C2500b;
import com.google.android.gms.common.internal.C2523j;
import com.google.android.gms.internal.ax;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object f7365a = new Object();
    private static HashSet<Uri> f7366b = new HashSet();
    private final Context f7367c;
    private final Handler f7368d;
    private final ExecutorService f7369e;
    private final C2495b f7370f;
    private final ax f7371g;
    private final Map<C2499a, ImageReceiver> f7372h;
    private final Map<Uri, ImageReceiver> f7373i;
    private final Map<Uri, Long> f7374j;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        final /* synthetic */ ImageManager f7354a;
        private final Uri f7355b;
        private final ArrayList<C2499a> f7356c;

        public void onReceiveResult(int i, Bundle bundle) {
            this.f7354a.f7369e.execute(new C2496c(this.f7354a, this.f7355b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface C2494a {
        void m7882a(Uri uri, Drawable drawable, boolean z);
    }

    private static final class C2495b extends LruCache<C2498a, Bitmap> {
        protected int m7883a(C2498a c2498a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void m7884a(boolean z, C2498a c2498a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c2498a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            m7884a(z, (C2498a) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m7883a((C2498a) obj, (Bitmap) obj2);
        }
    }

    private final class C2496c implements Runnable {
        final /* synthetic */ ImageManager f7357a;
        private final Uri f7358b;
        private final ParcelFileDescriptor f7359c;

        public C2496c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f7357a = imageManager;
            this.f7358b = uri;
            this.f7359c = parcelFileDescriptor;
        }

        public void run() {
            C2523j.m8017b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f7359c != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f7359c.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.f7358b);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.f7359c.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f7357a.f7368d.post(new C2497d(this.f7357a, this.f7358b, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.f7358b);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class C2497d implements Runnable {
        final /* synthetic */ ImageManager f7360a;
        private final Uri f7361b;
        private final Bitmap f7362c;
        private final CountDownLatch f7363d;
        private boolean f7364e;

        public C2497d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f7360a = imageManager;
            this.f7361b = uri;
            this.f7362c = bitmap;
            this.f7364e = z;
            this.f7363d = countDownLatch;
        }

        private void m7885a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.f7356c;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C2499a c2499a = (C2499a) a.get(i);
                if (z) {
                    c2499a.m7900a(this.f7360a.f7367c, this.f7362c, false);
                } else {
                    this.f7360a.f7374j.put(this.f7361b, Long.valueOf(SystemClock.elapsedRealtime()));
                    c2499a.m7901a(this.f7360a.f7367c, this.f7360a.f7371g, false);
                }
                if (!(c2499a instanceof C2500b)) {
                    this.f7360a.f7372h.remove(c2499a);
                }
            }
        }

        public void run() {
            C2523j.m8016a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f7362c != null;
            if (this.f7360a.f7370f != null) {
                if (this.f7364e) {
                    this.f7360a.f7370f.evictAll();
                    System.gc();
                    this.f7364e = false;
                    this.f7360a.f7368d.post(this);
                    return;
                } else if (z) {
                    this.f7360a.f7370f.put(new C2498a(this.f7361b), this.f7362c);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.f7360a.f7373i.remove(this.f7361b);
            if (imageReceiver != null) {
                m7885a(imageReceiver, z);
            }
            this.f7363d.countDown();
            synchronized (ImageManager.f7365a) {
                ImageManager.f7366b.remove(this.f7361b);
            }
        }
    }
}
