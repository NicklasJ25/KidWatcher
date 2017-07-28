package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.p023d.C1552c;
import com.facebook.ads.internal.view.C1849d;
import java.lang.ref.WeakReference;

public class ab extends AsyncTask<String, Void, Bitmap[]> {
    private static final String f4190a = ab.class.getSimpleName();
    private final WeakReference<Context> f4191b;
    private final WeakReference<ImageView> f4192c;
    private final WeakReference<C1849d> f4193d;
    private ac f4194e;

    public ab(ImageView imageView) {
        this.f4191b = new WeakReference(imageView.getContext());
        this.f4193d = null;
        this.f4192c = new WeakReference(imageView);
    }

    public ab(C1849d c1849d) {
        this.f4191b = new WeakReference(c1849d.getContext());
        this.f4193d = new WeakReference(c1849d);
        this.f4192c = null;
    }

    public ab m4807a(ac acVar) {
        this.f4194e = acVar;
        return this;
    }

    protected void m4808a(Bitmap[] bitmapArr) {
        if (this.f4192c != null) {
            ImageView imageView = (ImageView) this.f4192c.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmapArr[0]);
            }
        }
        if (this.f4193d != null) {
            C1849d c1849d = (C1849d) this.f4193d.get();
            if (c1849d != null) {
                c1849d.m5199a(bitmapArr[0], bitmapArr[1]);
            }
        }
        if (this.f4194e != null) {
            this.f4194e.mo2706a();
        }
    }

    public void m4809a(String... strArr) {
        executeOnExecutor(THREAD_POOL_EXECUTOR, strArr);
    }

    protected Bitmap[] m4810b(String... strArr) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2;
        String str = strArr[0];
        Context context = (Context) this.f4191b.get();
        if (context == null) {
            return new Bitmap[]{null, null};
        }
        Bitmap a;
        try {
            a = C1552c.m4311a(context).m4315a(str);
            try {
                if (this.f4193d == null || this.f4193d.get() == null || a == null) {
                    bitmap = null;
                } else {
                    try {
                        C1709e c1709e = new C1709e(a);
                        c1709e.m4916a(Math.round(((float) a.getWidth()) / 40.0f));
                        bitmap = c1709e.m4915a();
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap = a;
                        Log.e(f4190a, "Error downloading image: " + str, th);
                        C1723o.m4943a(C1722n.m4940a(th, null));
                        bitmap2 = a;
                        return new Bitmap[]{bitmap2, bitmap};
                    }
                }
                bitmap2 = a;
            } catch (Throwable th22) {
                th = th22;
                bitmap = null;
                Log.e(f4190a, "Error downloading image: " + str, th);
                C1723o.m4943a(C1722n.m4940a(th, null));
                bitmap2 = a;
                return new Bitmap[]{bitmap2, bitmap};
            }
        } catch (Throwable th222) {
            th = th222;
            a = null;
            bitmap = null;
            Log.e(f4190a, "Error downloading image: " + str, th);
            C1723o.m4943a(C1722n.m4940a(th, null));
            bitmap2 = a;
            return new Bitmap[]{bitmap2, bitmap};
        }
        return new Bitmap[]{bitmap2, bitmap};
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4810b((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4808a((Bitmap[]) obj);
    }
}
