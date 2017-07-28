package com.domobile.frame.p000a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.http.image.CacheImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class C1257b {
    private static C1257b f2562j;
    private LruCache<Object, BitmapDrawable> f2563a = new LruCache<Object, BitmapDrawable>(this, ((int) Runtime.getRuntime().maxMemory()) / 6) {
        final /* synthetic */ C1257b f2545a;

        protected int m2945a(Object obj, BitmapDrawable bitmapDrawable) {
            if (bitmapDrawable != null) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    if (VERSION.SDK_INT >= 19) {
                        return bitmap.getByteCount();
                    }
                    return bitmap.getHeight() * bitmap.getRowBytes();
                }
            }
            return super.sizeOf(obj, bitmapDrawable);
        }

        protected void m2946a(boolean z, Object obj, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
            if (bitmapDrawable != null && bitmapDrawable != bitmapDrawable2) {
                this.f2545a.f2565c.remove(bitmapDrawable);
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            m2946a(z, obj, (BitmapDrawable) obj2, (BitmapDrawable) obj3);
        }

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m2945a(obj, (BitmapDrawable) obj2);
        }
    };
    private ArrayList<Map<String, Object>> f2564b = new ArrayList();
    private HashMap<Object, Object> f2565c = new HashMap();
    private C1253c f2566d;
    private C1252a f2567e;
    private int f2568f = 3;
    private int f2569g = 0;
    private Context f2570h;
    private boolean f2571i = false;
    private Handler f2572k = new C12502(this);

    public interface C0421b {
        BitmapDrawable mo2069a(Object obj);
    }

    public interface C0422e {
        boolean mo2070a(CacheImageView cacheImageView, BitmapDrawable bitmapDrawable);
    }

    class C12502 extends Handler {
        final /* synthetic */ C1257b f2546a;

        C12502(C1257b c1257b) {
            this.f2546a = c1257b;
        }

        public void handleMessage(Message message) {
            if (this.f2546a.f2566d != null) {
                try {
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr != null && ((View) objArr[0]).getTag().equals(objArr[1])) {
                        this.f2546a.f2566d.m2955a((ImageView) objArr[0], objArr[1]);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static class C1252a {
        protected final Context f2548a;
        protected final int f2549b = 5000;
        protected final int f2550c = 20000;

        public C1252a(Context context) {
            this.f2548a = context.getApplicationContext();
        }

        private HttpURLConnection m2947g(String str) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
            httpURLConnection.setConnectTimeout(this.f2549b);
            httpURLConnection.setReadTimeout(this.f2550c);
            httpURLConnection.connect();
            return httpURLConnection;
        }

        public InputStream m2948a(Uri uri) {
            return m2949a(uri.toString());
        }

        public InputStream m2949a(String str) {
            switch (C1256g.m2961a(str)) {
                case HTTP:
                case HTTPS:
                    return m2950b(str);
                case FILE:
                    return m2951c(str);
                case CONTENT:
                    return m2952d(str);
                case ASSETS:
                    return m2953e(str);
                case DRAWABLE:
                    return m2954f(str);
                default:
                    return null;
            }
        }

        protected InputStream m2950b(String str) {
            HttpURLConnection g = m2947g(str);
            int i = 0;
            while (g.getResponseCode() / 100 == 3 && i < 5) {
                g = m2947g(g.getHeaderField("Location"));
                i++;
            }
            return new BufferedInputStream(g.getInputStream(), 8192);
        }

        protected InputStream m2951c(String str) {
            return new BufferedInputStream(new FileInputStream(C1256g.FILE.m2963b(str)), 8192);
        }

        protected InputStream m2952d(String str) {
            return this.f2548a.getContentResolver().openInputStream(Uri.parse(str));
        }

        protected InputStream m2953e(String str) {
            return this.f2548a.getAssets().open(C1256g.ASSETS.m2963b(str));
        }

        protected InputStream m2954f(String str) {
            Bitmap bitmap = ((BitmapDrawable) this.f2548a.getResources().getDrawable(Integer.parseInt(C1256g.DRAWABLE.m2963b(str)))).getBitmap();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
    }

    public interface C1253c {
        void m2955a(ImageView imageView, Object obj);
    }

    public interface C1254d {
        boolean mo2525a(BitmapDrawable bitmapDrawable);

        BitmapDrawable mo2526b(Object obj);

        File mo2527c(Object obj);
    }

    private class C1255f extends AsyncTask<Object, Integer, Map<String, Object>> {
        final /* synthetic */ C1257b f2551a;

        private C1255f(C1257b c1257b) {
            this.f2551a = c1257b;
        }

        protected Map<String, Object> m2959a(Object... objArr) {
            Map map = (Map) objArr[0];
            this.f2551a.f2569g = this.f2551a.f2569g + 1;
            this.f2551a.m2974b(map);
            return map;
        }

        protected void m2960a(Map<String, Object> map) {
            this.f2551a.f2569g = this.f2551a.f2569g - 1;
            this.f2551a.m2971a((Map) map);
            this.f2551a.m2976c();
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2959a(objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2960a((Map) obj);
        }
    }

    public enum C1256g {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        
        private String f2560h;
        private String f2561i;

        private C1256g(String str) {
            this.f2560h = str;
            this.f2561i = str + "://";
        }

        public static C1256g m2961a(String str) {
            if (str != null) {
                for (C1256g c1256g : C1256g.values()) {
                    if (c1256g.m2962c(str)) {
                        return c1256g;
                    }
                }
            }
            return UNKNOWN;
        }

        private boolean m2962c(String str) {
            return str.startsWith(this.f2561i);
        }

        public String m2963b(String str) {
            if (m2962c(str)) {
                return str.substring(this.f2561i.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{str, this.f2560h}));
        }
    }

    private C1257b() {
    }

    private C1257b(Context context) {
        this.f2570h = context;
    }

    public static Options m2965a() {
        Options options = new Options();
        options.inPurgeable = true;
        try {
            options.getClass().getField("inNativeAlloc").setBoolean(options, true);
        } catch (Exception e) {
        }
        return options;
    }

    public static C1257b m2966a(Context context) {
        if (f2562j == null) {
            f2562j = new C1257b(context);
        }
        return f2562j;
    }

    public static File m2967a(Context context, String str) {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = context.getExternalCacheDir();
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        return new File(file, str);
    }

    private void m2970a(CacheImageView cacheImageView, Drawable drawable) {
        if (!(drawable instanceof BitmapDrawable)) {
            cacheImageView.setImageDrawable(drawable);
        } else if (!cacheImageView.mo2070a(cacheImageView, (BitmapDrawable) drawable)) {
            cacheImageView.setImageDrawable(drawable);
        }
    }

    private void m2971a(Map<String, Object> map) {
        CacheImageView cacheImageView = (CacheImageView) map.get("view");
        Object obj = map.get("bean");
        if (cacheImageView.getTag() != null && cacheImageView.getTag().equals(obj)) {
            if (map.containsKey("bitmap")) {
                Object obj2 = map.get("bitmap");
                if (obj2 != null) {
                    m2970a(cacheImageView, (Drawable) obj2);
                    map.clear();
                    return;
                }
            }
            m2982a(cacheImageView, obj);
            m2970a(cacheImageView, cacheImageView.getPlaceHolder());
        }
    }

    private void m2974b(Map<String, Object> map) {
        BitmapDrawable a;
        CacheImageView cacheImageView = (CacheImageView) map.get("view");
        Object obj = map.get("bean");
        BitmapDrawable bitmapDrawable = null;
        if (cacheImageView.getTag() != null && cacheImageView.getTag().equals(obj)) {
            try {
                a = m2979a(obj, cacheImageView);
                if (a == null) {
                    try {
                        bitmapDrawable = cacheImageView.mo2526b(obj);
                        a = bitmapDrawable == null ? new BitmapDrawable(this.f2570h.getResources(), C1277a.m3054a(cacheImageView.mo2527c(obj))) : bitmapDrawable;
                    } catch (Exception e) {
                        bitmapDrawable = a;
                        a = bitmapDrawable;
                        if (a == null) {
                            try {
                                a = cacheImageView.mo2069a(obj);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (a != null) {
                            if (!cacheImageView.mo2525a(a)) {
                                try {
                                    C1277a.m3058a(cacheImageView.mo2527c(obj), a.getBitmap(), CompressFormat.PNG);
                                } catch (Exception e3) {
                                }
                            }
                            if (!cacheImageView.m3047a()) {
                                m2984a(obj, a);
                                this.f2565c.put(a, cacheImageView.getDecoder());
                            }
                            map.put("bitmap", a);
                            return;
                        }
                        map.put("bitmap", cacheImageView.getPlaceHolder());
                    }
                }
            } catch (Exception e4) {
                a = bitmapDrawable;
                if (a == null) {
                    a = cacheImageView.mo2069a(obj);
                }
                if (a != null) {
                    map.put("bitmap", cacheImageView.getPlaceHolder());
                }
                if (cacheImageView.mo2525a(a)) {
                    C1277a.m3058a(cacheImageView.mo2527c(obj), a.getBitmap(), CompressFormat.PNG);
                }
                if (cacheImageView.m3047a()) {
                    m2984a(obj, a);
                    this.f2565c.put(a, cacheImageView.getDecoder());
                }
                map.put("bitmap", a);
                return;
            }
            if (a == null) {
                a = cacheImageView.mo2069a(obj);
            }
            if (a != null) {
                if (cacheImageView.mo2525a(a)) {
                    C1277a.m3058a(cacheImageView.mo2527c(obj), a.getBitmap(), CompressFormat.PNG);
                }
                if (cacheImageView.m3047a()) {
                    m2984a(obj, a);
                    this.f2565c.put(a, cacheImageView.getDecoder());
                }
                map.put("bitmap", a);
                return;
            }
            map.put("bitmap", cacheImageView.getPlaceHolder());
        }
    }

    private void m2976c() {
        if (this.f2569g < this.f2568f && this.f2564b.size() > 0) {
            Map map = (Map) this.f2564b.get(0);
            C1148d.m2521b(new C1255f(), map);
            this.f2564b.remove(map);
        }
    }

    public BitmapDrawable m2978a(Uri uri) {
        if (this.f2567e == null) {
            this.f2567e = new C1252a(this.f2570h);
        }
        Options a = C1257b.m2965a();
        InputStream a2 = this.f2567e.m2948a(uri);
        return a2 != null ? new BitmapDrawable(this.f2570h.getResources(), BitmapFactory.decodeStream(a2, null, a)) : null;
    }

    public BitmapDrawable m2979a(Object obj, CacheImageView cacheImageView) {
        if (cacheImageView.m3047a()) {
            return null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f2563a.get(obj);
        if (this.f2565c.get(bitmapDrawable) != cacheImageView.getDecoder()) {
            bitmapDrawable = null;
        }
        return bitmapDrawable;
    }

    public C1257b m2980a(int i) {
        this.f2568f = i;
        return this;
    }

    public C1257b m2981a(boolean z) {
        this.f2571i = z;
        return this;
    }

    public void m2982a(CacheImageView cacheImageView, Object obj) {
        if (!this.f2571i) {
            Drawable a = m2979a(obj, cacheImageView);
            if (a != null) {
                m2970a(cacheImageView, a);
                return;
            }
        }
        m2970a(cacheImageView, cacheImageView.getPlaceHolder());
        HashMap hashMap = new HashMap();
        hashMap.put("bean", obj);
        hashMap.put("view", cacheImageView);
        if (this.f2571i) {
            this.f2564b.add(hashMap);
        } else {
            this.f2564b.add(0, hashMap);
        }
        m2976c();
    }

    public void m2983a(Object obj) {
        this.f2563a.remove(obj);
    }

    public void m2984a(Object obj, BitmapDrawable bitmapDrawable) {
        try {
            if (((BitmapDrawable) this.f2563a.get(obj)).getBitmap() == bitmapDrawable.getBitmap()) {
                return;
            }
        } catch (Exception e) {
        }
        this.f2563a.remove(obj);
        this.f2563a.put(obj, bitmapDrawable);
    }

    public void m2985b() {
        this.f2564b.clear();
        this.f2563a.evictAll();
        System.gc();
        System.runFinalization();
    }
}
