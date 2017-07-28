package com.domobile.applock.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.android.camera.C0411e;
import com.android.camera.C0487k;
import com.android.camera.C0487k.C0486a;
import com.android.camera.ImageManager;
import com.android.camera.MediaTransferActivity;
import com.android.camera.gallery.C0449h;
import com.android.camera.gallery.HidedPictureItem;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.p003a.C0633m;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.p068a.p069a.C3612b;
import org.apache.p068a.p069a.C3613c;
import org.apache.p068a.p069a.C3614d;

public class HidedMediasActionService extends Service {
    private static HidedMediasActionService f1903b;
    private static boolean f1904d = false;
    public boolean f1905a = false;
    private boolean f1906c = false;
    private ContentResolver f1907e;
    private AppLockApplication f1908f;
    private long f1909g;
    private String f1910h;
    private boolean f1911i;
    private RemoteViews f1912j;
    private Notification f1913k;
    private PendingIntent f1914l;
    private long f1915m = 0;
    private ArrayList<HidedPictureItem> f1916n;
    private ArrayList<HidedPictureItem> f1917o;
    private C0425d f1918p;
    private Handler f1919q = new C10491(this);
    private BroadcastReceiver f1920r = new C10513(this);

    public interface C0425d {
        void mo2071a(int i, int i2);

        void mo2072a(HidedPictureItem hidedPictureItem);

        void mo2073a(ArrayList<HidedPictureItem> arrayList);

        void mo2074a(ArrayList<HidedPictureItem> arrayList, String str);

        void mo2075b(HidedPictureItem hidedPictureItem);

        void mo2076b(ArrayList<HidedPictureItem> arrayList);
    }

    class C10491 extends Handler {
        final /* synthetic */ HidedMediasActionService f1900a;

        C10491(HidedMediasActionService hidedMediasActionService) {
            this.f1900a = hidedMediasActionService;
        }

        public void handleMessage(Message message) {
            if (message != null) {
                int i = message.arg1;
                int i2 = message.arg2;
                if (System.currentTimeMillis() - this.f1900a.f1915m > 1000 || i2 < 50 || i <= 1) {
                    this.f1900a.f1915m = System.currentTimeMillis();
                    this.f1900a.m2134a(i, i2, (HidedPictureItem) message.obj);
                }
            }
        }
    }

    class C10502 implements Runnable {
        final /* synthetic */ HidedMediasActionService f1901a;

        C10502(HidedMediasActionService hidedMediasActionService) {
            this.f1901a = hidedMediasActionService;
        }

        public void run() {
            HidedMediasActionService.f1904d = true;
            while (!this.f1901a.f1908f.m596j().isEmpty()) {
                this.f1901a.f1906c = false;
                this.f1901a.m2152e();
            }
            HidedMediasActionService.f1904d = false;
            this.f1901a.stopForeground(true);
            this.f1901a.stopSelf();
        }
    }

    class C10513 extends BroadcastReceiver {
        final /* synthetic */ HidedMediasActionService f1902a;

        C10513(HidedMediasActionService hidedMediasActionService) {
            this.f1902a = hidedMediasActionService;
        }

        public void onReceive(Context context, Intent intent) {
            this.f1902a.f1906c = true;
        }
    }

    public static class C1052a extends Exception {
    }

    public static class C1053b extends Exception {
        public C1053b(String str) {
            super(str);
        }
    }

    public static class C1054c extends Exception {
    }

    private long m2130a(HidedPictureItem hidedPictureItem, long j, int i) {
        if (this.f1917o.contains(hidedPictureItem)) {
            return 250 - (System.currentTimeMillis() - j);
        }
        return ((long) (i > 200 ? 20 : 50)) - (System.currentTimeMillis() - j);
    }

    public static HidedMediasActionService m2133a() {
        return f1903b;
    }

    private void m2134a(int i, int i2, HidedPictureItem hidedPictureItem) {
        int i3;
        int i4 = R.drawable.stat_unhide_medias_icon;
        if (hidedPictureItem.f192k == 0) {
            i3 = R.string.deleting_media;
        } else if (hidedPictureItem.f192k == 1) {
            i3 = R.string.reverting_media;
        } else {
            i4 = R.drawable.stat_hide_medias_icon;
            i3 = R.string.hiding_media;
        }
        this.f1912j = new RemoteViews(getPackageName(), R.layout.hided_medias_action_progress);
        this.f1912j.setOnClickPendingIntent(16908295, this.f1914l);
        if (this.f1913k == null) {
            Builder builder = new Builder(this);
            CharSequence a = C1147a.m2480a(Integer.valueOf(i + 1), "/", Integer.valueOf(i2));
            builder.setSmallIcon(i4).setTicker(a);
            builder.setOngoing(true).setContentTitle(a);
            builder.setWhen(System.currentTimeMillis());
            builder.setContent(this.f1912j);
            if (C1150y.O < 11) {
                builder.setContentIntent(this.f1914l);
            } else {
                builder.setContentIntent(PendingIntent.getBroadcast(this, 0, new Intent(), 0));
            }
            this.f1913k = builder.build();
            Notification notification = this.f1913k;
            notification.flags |= 32;
        } else {
            this.f1913k.contentView = this.f1912j;
        }
        this.f1912j.setProgressBar(16908301, i2, i, false);
        RemoteViews remoteViews = this.f1912j;
        Object[] objArr = new Object[1];
        objArr[0] = C1147a.m2480a(Integer.valueOf(i), "/", Integer.valueOf(i2));
        remoteViews.setTextViewText(R.id.progress_num, getString(i3, objArr));
        C1148d.m2508a((Context) this, (int) R.id.notify_hided_medias_action, this.f1913k);
    }

    public static void m2135a(Context context) {
        m2136a(context, true);
    }

    public static void m2136a(Context context, boolean z) {
        context.startService(new Intent(context, HidedMediasActionService.class));
        if (z) {
            Intent intent = new Intent(context, MediaTransferActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    private void m2137a(HidedPictureItem hidedPictureItem) {
        getContentResolver().delete(!hidedPictureItem.m289g() ? ImageManager.f32a : ImageManager.f33b, "_data like '" + hidedPictureItem.f189h + "'", null);
    }

    public static void m2139a(File file, File file2, HidedMediasActionService hidedMediasActionService) {
        if (m2144a(file) || m2144a(file2)) {
            throw new C1053b("can not modify the /data/data folder");
        } else if (file2.exists()) {
            throw new C3612b("Destination '" + file2 + "' already exists");
        } else if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        } else if (!file.renameTo(file2)) {
            m2148b(file, file2, hidedMediasActionService);
        }
    }

    private void m2140a(String str, boolean z, boolean z2) {
        Intent intent = new Intent("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
        if (z) {
            intent.setAction("com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED");
        }
        intent.putExtra("com.domobile.elock.EXTRA_FORCE_RELOAD", z2);
        intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", str);
        C1148d.m2510a((Context) this, intent);
    }

    public static boolean m2141a(Context context, HidedPictureItem hidedPictureItem, boolean z, HidedMediasActionService hidedMediasActionService) {
        return m2142a(context, hidedPictureItem, z, hidedMediasActionService, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2142a(android.content.Context r8, com.android.camera.gallery.HidedPictureItem r9, boolean r10, com.domobile.applock.service.HidedMediasActionService r11, boolean r12) {
        /*
        r0 = 1;
        r5 = new java.io.File;
        r1 = r9.f185d;
        r5.<init>(r1);
        r2 = new java.io.File;
        r1 = r9.f189h;
        r2.<init>(r1);
        r1 = r9.f189h;
        r3 = com.android.camera.C0487k.m417a(r8, r5, r2);
        if (r3 != 0) goto L_0x001d;
    L_0x0017:
        r0 = new com.domobile.applock.service.HidedMediasActionService$c;
        r0.<init>();
        throw r0;
    L_0x001d:
        r3 = r2.exists();	 Catch:{ Exception -> 0x00a1 }
        if (r3 == 0) goto L_0x00ee;
    L_0x0023:
        r6 = org.apache.p068a.p069a.C3614d.m15752d(r1);	 Catch:{ Exception -> 0x00a1 }
        r3 = 0;
        r4 = r1.length();	 Catch:{ Exception -> 0x00a1 }
        r7 = r6.length();	 Catch:{ Exception -> 0x00a1 }
        r4 = r4 - r7;
        r4 = r4 + -1;
        r7 = r1.substring(r3, r4);	 Catch:{ Exception -> 0x00a1 }
        r3 = r0;
    L_0x0038:
        r4 = r2.exists();	 Catch:{ Exception -> 0x00a1 }
        if (r4 == 0) goto L_0x0067;
    L_0x003e:
        r1 = 5;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00a1 }
        r2 = 0;
        r1[r2] = r7;	 Catch:{ Exception -> 0x00a1 }
        r2 = 1;
        r4 = "_";
        r1[r2] = r4;	 Catch:{ Exception -> 0x00a1 }
        r2 = 2;
        r4 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x00a1 }
        r1[r2] = r4;	 Catch:{ Exception -> 0x00a1 }
        r2 = 3;
        r4 = ".";
        r1[r2] = r4;	 Catch:{ Exception -> 0x00a1 }
        r2 = 4;
        r1[r2] = r6;	 Catch:{ Exception -> 0x00a1 }
        r2 = com.domobile.frame.p000a.C1147a.m2480a(r1);	 Catch:{ Exception -> 0x00a1 }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x00a1 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x00a1 }
        r1 = r3 + 1;
        r3 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x0038;
    L_0x0067:
        r3 = r2;
        r2 = r1;
    L_0x0069:
        r1 = r9.f187f;	 Catch:{ Exception -> 0x009c }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x009c }
        if (r1 != 0) goto L_0x0083;
    L_0x0071:
        r1 = r9.f187f;	 Catch:{ Exception -> 0x009c }
        r1 = m2145a(r1);	 Catch:{ Exception -> 0x009c }
        if (r1 != 0) goto L_0x0083;
    L_0x0079:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x009c }
        r4 = r9.f187f;	 Catch:{ Exception -> 0x009c }
        r1.<init>(r4);	 Catch:{ Exception -> 0x009c }
        org.apache.p068a.p069a.C3613c.m15740d(r1);	 Catch:{ Exception -> 0x009c }
    L_0x0083:
        r1 = r5.exists();	 Catch:{ Exception -> 0x00a1 }
        if (r1 == 0) goto L_0x008c;
    L_0x0089:
        m2139a(r5, r3, r11);	 Catch:{ b -> 0x00a8, Exception -> 0x00af }
    L_0x008c:
        r9.m282b(r8, r10);	 Catch:{ Exception -> 0x00a1 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00a1 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00a1 }
        r2 = r9.m289g();	 Catch:{ Exception -> 0x00a1 }
        com.android.camera.C0487k.m412a(r8, r1, r9, r2);	 Catch:{ Exception -> 0x00a1 }
    L_0x009b:
        return r0;
    L_0x009c:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x00a1 }
        goto L_0x0083;
    L_0x00a1:
        r0 = move-exception;
        r0 = new java.io.IOException;
        r0.<init>();
        throw r0;
    L_0x00a8:
        r0 = move-exception;
        r0 = new com.domobile.applock.service.HidedMediasActionService$b;	 Catch:{ Exception -> 0x00a1 }
        r0.<init>();	 Catch:{ Exception -> 0x00a1 }
        throw r0;	 Catch:{ Exception -> 0x00a1 }
    L_0x00af:
        r0 = move-exception;
        r0 = com.domobile.applock.C1150y.O;	 Catch:{ Exception -> 0x00a1 }
        r1 = 19;
        if (r0 < r1) goto L_0x00e8;
    L_0x00b6:
        if (r12 != 0) goto L_0x00e8;
    L_0x00b8:
        r0 = new com.android.camera.gallery.HidedPictureItem;	 Catch:{ Exception -> 0x00a1 }
        r0.<init>(r9);	 Catch:{ Exception -> 0x00a1 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00a1 }
        r2 = com.domobile.applock.C1150y.f2214a;	 Catch:{ Exception -> 0x00a1 }
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00a1 }
        r5 = 0;
        r6 = r9.f184c;	 Catch:{ Exception -> 0x00a1 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00a1 }
        r5 = 1;
        r6 = java.io.File.separator;	 Catch:{ Exception -> 0x00a1 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00a1 }
        r5 = 2;
        r3 = r3.getName();	 Catch:{ Exception -> 0x00a1 }
        r4[r5] = r3;	 Catch:{ Exception -> 0x00a1 }
        r3 = com.domobile.frame.p000a.C1147a.m2480a(r4);	 Catch:{ Exception -> 0x00a1 }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x00a1 }
        r1 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x00a1 }
        r0.f189h = r1;	 Catch:{ Exception -> 0x00a1 }
        r1 = 1;
        r0 = m2142a(r8, r0, r10, r11, r1);	 Catch:{ Exception -> 0x00a1 }
        goto L_0x009b;
    L_0x00e8:
        r0 = new java.io.IOException;	 Catch:{ Exception -> 0x00a1 }
        r0.<init>();	 Catch:{ Exception -> 0x00a1 }
        throw r0;	 Catch:{ Exception -> 0x00a1 }
    L_0x00ee:
        r3 = r2;
        r2 = r1;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.service.HidedMediasActionService.a(android.content.Context, com.android.camera.gallery.HidedPictureItem, boolean, com.domobile.applock.service.HidedMediasActionService, boolean):boolean");
    }

    public static boolean m2144a(File file) {
        return m2145a(file.getAbsolutePath());
    }

    public static boolean m2145a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("/data/data/");
    }

    public static void m2148b(File file, File file2, HidedMediasActionService hidedMediasActionService) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                try {
                    m2150c(file, file2, hidedMediasActionService);
                    file2.setLastModified(file.lastModified());
                } catch (C1052a e) {
                    file2.delete();
                    throw new C1052a();
                } catch (Exception e2) {
                    file2.delete();
                    throw new IOException("copy " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + " failed, will delete dest file");
                }
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    public static void m2150c(File file, File file2, HidedMediasActionService hidedMediasActionService) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[65536];
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (hidedMediasActionService == null || !hidedMediasActionService.f1906c) {
                    bufferedOutputStream.write(bArr, 0, read);
                    i2++;
                    if (i2 == 512 && hidedMediasActionService != null) {
                        i2 = (int) (32000 / (System.currentTimeMillis() - currentTimeMillis));
                        i += 32;
                        currentTimeMillis = System.currentTimeMillis();
                        if (!(hidedMediasActionService.f1918p == null || i2 == 0)) {
                            hidedMediasActionService.f1918p.mo2071a(i2, i);
                        }
                        i2 = 0;
                    }
                } else {
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    throw new C1052a();
                }
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e2) {
            }
        } finally {
            if (!(hidedMediasActionService == null || hidedMediasActionService.f1918p == null)) {
                hidedMediasActionService.f1918p.mo2071a(0, 0);
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e3) {
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e4) {
            }
        }
    }

    public static boolean m2151d() {
        return f1904d;
    }

    private void m2152e() {
        int i;
        String str = (String) this.f1908f.m596j().keySet().iterator().next();
        C0633m c0633m = (C0633m) this.f1908f.m596j().get(str);
        this.f1908f.m596j().remove(str);
        this.f1916n = c0633m.f574b;
        this.f1910h = c0633m.f573a;
        if (this.f1918p != null) {
            this.f1918p.mo2073a(this.f1916n);
        }
        this.f1908f.m598l().clear();
        Iterator it = this.f1916n.iterator();
        while (it.hasNext()) {
            HidedPictureItem hidedPictureItem = (HidedPictureItem) it.next();
            if (hidedPictureItem.f192k == 2) {
                this.f1908f.m598l().add(hidedPictureItem.f190i);
            } else {
                this.f1908f.m598l().add(hidedPictureItem.f182a);
            }
        }
        try {
            Thread.sleep(1500);
            i = 0;
            while (!this.f1905a && i < 20) {
                Thread.sleep(500);
                i++;
            }
        } catch (Exception e) {
        }
        if (!this.f1916n.isEmpty()) {
            this.f1911i = ((HidedPictureItem) this.f1916n.get(0)).m289g();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int size = this.f1916n.size();
        int i2 = 0;
        while (i2 < size) {
            if (this.f1906c) {
                Intent intent = new Intent("com.domobile.elock.action.ACTION_RELOAD_ALBUM_IMAGE");
                intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", this.f1910h);
                C1148d.m2510a((Context) this, intent);
                Object obj = 1;
                break;
            }
            hidedPictureItem = (HidedPictureItem) this.f1916n.get(0);
            Message obtainMessage = this.f1919q.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = size;
            obtainMessage.obj = hidedPictureItem;
            this.f1919q.removeMessages(obtainMessage.what);
            this.f1919q.sendMessage(obtainMessage);
            if (this.f1918p != null) {
                this.f1918p.mo2075b(hidedPictureItem);
            }
            long a;
            float length;
            long currentTimeMillis2;
            if (hidedPictureItem.f192k == 1) {
                try {
                    a = m2130a(hidedPictureItem, currentTimeMillis, size);
                    if (a < 0) {
                        a = 0;
                    }
                    Thread.sleep(a);
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e2) {
                }
                try {
                    length = (((float) new File(hidedPictureItem.f185d).length()) / 1024.0f) / 1024.0f;
                    currentTimeMillis2 = System.currentTimeMillis();
                    m2141a((Context) this, hidedPictureItem, false, this);
                    C1148d.m2520b((Context) this, "move_out_vault_speed", (Object) Integer.valueOf((int) ((length * 1000.0f) / ((float) (System.currentTimeMillis() - currentTimeMillis2)))));
                    if (this.f1918p != null) {
                        this.f1918p.mo2072a(hidedPictureItem);
                    }
                } catch (C1054c e3) {
                    if (this.f1918p != null) {
                        this.f1918p.mo2074a(this.f1916n, getString(R.string.not_enough_space));
                    }
                    obj = null;
                    m2153f();
                } catch (Exception e4) {
                    if (this.f1918p != null) {
                        this.f1918p.mo2074a(this.f1916n, getString(R.string.move_file_error));
                    }
                    obj = null;
                    m2153f();
                }
            } else if (hidedPictureItem.f192k == 0) {
                try {
                    if (this.f1917o.contains(hidedPictureItem)) {
                        Thread.sleep(250);
                    } else {
                        Thread.sleep(size > 200 ? 10 : 50);
                    }
                } catch (Exception e5) {
                }
                File file = new File(hidedPictureItem.f185d);
                if (m2144a(file) || (file.exists() && !file.delete())) {
                    if (this.f1918p != null) {
                        this.f1918p.mo2074a(this.f1916n, getString(R.string.move_file_error));
                    }
                    obj = null;
                    m2153f();
                } else {
                    if (!(TextUtils.isEmpty(hidedPictureItem.f187f) || m2145a(hidedPictureItem.f187f))) {
                        new File(hidedPictureItem.f187f).delete();
                    }
                    hidedPictureItem.m282b((Context) this, false);
                    if (this.f1918p != null) {
                        this.f1918p.mo2072a(hidedPictureItem);
                    }
                }
            } else if (hidedPictureItem.f192k == 2) {
                try {
                    a = m2130a(hidedPictureItem, currentTimeMillis, size);
                    if (a < 0) {
                        a = 0;
                    }
                    Thread.sleep(a);
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e6) {
                }
                try {
                    length = (((float) new File(hidedPictureItem.m281b()).length()) / 1024.0f) / 1024.0f;
                    currentTimeMillis2 = System.currentTimeMillis();
                    boolean a2 = m2155a((Context) this, hidedPictureItem);
                    C1148d.m2520b((Context) this, "move_in_vault_speed", (Object) Integer.valueOf((int) ((length * 1000.0f) / ((float) (System.currentTimeMillis() - currentTimeMillis2)))));
                    if (a2) {
                        if (this.f1918p != null) {
                            this.f1918p.mo2072a(hidedPictureItem);
                        }
                        if (TextUtils.isEmpty(hidedPictureItem.f190i)) {
                            m2137a(hidedPictureItem);
                        } else {
                            try {
                                this.f1907e.delete(Uri.parse(hidedPictureItem.f190i), null, null);
                            } catch (SecurityException e7) {
                                m2137a(hidedPictureItem);
                            }
                        }
                    } else {
                        if (this.f1918p != null) {
                            this.f1918p.mo2074a(this.f1916n, getString(R.string.move_file_error));
                        }
                        obj = null;
                        m2153f();
                    }
                } catch (C1054c e8) {
                    if (this.f1918p != null) {
                        this.f1918p.mo2074a(this.f1916n, getString(R.string.not_enough_space));
                    }
                    obj = null;
                    m2153f();
                } catch (Exception e9) {
                    if (this.f1918p != null) {
                        this.f1918p.mo2074a(this.f1916n, getString(R.string.move_file_error));
                    }
                    obj = null;
                    m2153f();
                }
            }
            boolean g = hidedPictureItem.m289g();
            if (g != this.f1911i || i2 == size - 1) {
                this.f1911i = g;
                m2140a(this.f1910h, g, true);
            } else if (System.currentTimeMillis() - this.f1909g > 1000) {
                this.f1909g = System.currentTimeMillis();
                m2140a(this.f1910h, g, false);
            }
            if (hidedPictureItem.f192k == 2) {
                this.f1908f.m598l().remove(hidedPictureItem.f190i);
            } else {
                this.f1908f.m598l().remove(hidedPictureItem.f182a);
            }
            this.f1916n.remove(0);
            i2++;
        }
        i = 1;
        if (this.f1918p != null) {
            this.f1918p.mo2075b(null);
        }
        if (!(obj == null || this.f1918p == null)) {
            this.f1918p.mo2076b(this.f1916n);
        }
        m2140a(this.f1910h, this.f1911i, true);
        C0411e.m161c(this);
    }

    private void m2153f() {
        this.f1908f.m596j().clear();
        this.f1908f.m598l().clear();
        this.f1916n.clear();
    }

    public void m2154a(C0425d c0425d) {
        this.f1918p = c0425d;
    }

    public boolean m2155a(Context context, HidedPictureItem hidedPictureItem) {
        if (hidedPictureItem == null || !C0487k.m418a(hidedPictureItem) || TextUtils.isEmpty(hidedPictureItem.mo2082a())) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(hidedPictureItem.mo2082a());
        File a = C0487k.m409a(context, String.valueOf(currentTimeMillis), C0487k.m408a((C0449h) hidedPictureItem));
        File a2 = C0487k.m409a(context, String.valueOf(currentTimeMillis), C0486a.TYPE_THUMB);
        String d = C3614d.m15752d(file.getName());
        if (hidedPictureItem.m289g()) {
        }
        if (C0487k.m417a(context, file, a)) {
            try {
                m2139a(file, a, this);
                try {
                    String h = hidedPictureItem.mo2099h();
                    if (!(m2145a(h) || m2144a(a2))) {
                        C3613c.m15736b(new File(h), a2);
                    }
                } catch (Exception e) {
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("from_path", hidedPictureItem.mo2082a());
                contentValues.put("album", file.getParentFile().getName());
                contentValues.put("dest_path", C0487k.m428d(this, a.getAbsolutePath()));
                contentValues.put("thumb_path", a2.getAbsolutePath());
                contentValues.put("file_name", String.valueOf(currentTimeMillis));
                contentValues.put("file_type", hidedPictureItem.getMimeType());
                contentValues.put("rotation", Integer.valueOf(hidedPictureItem.getRotation()));
                contentValues.put("file_ext", d);
                contentValues.put("timestamp", Long.valueOf(currentTimeMillis));
                hidedPictureItem.f185d = a.getAbsolutePath();
                hidedPictureItem.f187f = a2.getAbsolutePath();
                return C0411e.m157a().insert("medias", null, contentValues) != -1;
            } catch (Exception e2) {
                throw new IOException("move File failed");
            }
        }
        throw new C1054c();
    }

    public ArrayList<HidedPictureItem> m2156b() {
        return this.f1916n;
    }

    public ArrayList<HidedPictureItem> m2157c() {
        return this.f1917o;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        f1903b = this;
        this.f1908f = C1150y.m2566a((Context) this);
        this.f1907e = getContentResolver();
        this.f1917o = new ArrayList();
        this.f1914l = PendingIntent.getBroadcast(this, 0, new Intent("com.domobile.applock.ACTION_MEDIAS_ACTION_ABORT"), 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.applock.ACTION_MEDIAS_ACTION_ABORT");
        registerReceiver(this.f1920r, intentFilter);
    }

    public void onDestroy() {
        this.f1908f.m598l().clear();
        C1148d.m2509a((Context) this, this.f1920r);
        C1148d.m2530f(this, R.id.notify_hided_medias_action);
        C1148d.m2530f(this, R.id.notify_hided_medias_progress);
        f1904d = false;
        f1903b = null;
        super.onDestroy();
    }

    @Deprecated
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!(this.f1912j == null || this.f1913k == null)) {
            C1148d.m2508a((Context) this, (int) R.id.notify_hided_medias_action, this.f1913k);
        }
        if (!f1904d) {
            if (this.f1908f.m596j() == null || this.f1908f.m596j().isEmpty()) {
                stopForeground(true);
                stopSelf();
                return;
            }
            startForeground(R.id.notify_foreground, C1150y.m2555T(this));
            new Thread(new C10502(this)).start();
        }
    }
}
