package com.domobile.applock.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.domobile.applock.C1017n;
import com.domobile.applock.MainActivity;
import com.domobile.applock.R;
import com.domobile.applock.p012e.C0896a;
import com.domobile.applock.p012e.C0896a.C0895a;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.p012e.C0899d;
import com.domobile.applock.p012e.C0900e;
import com.domobile.applock.p013f.C0903a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1258c;
import com.domobile.lockbean.C1365d;
import com.domobile.lockbean.C1371j;
import java.util.ArrayList;

@TargetApi(18)
public class NotificationService extends NotificationListenerService implements C0895a {
    private Handler f1984a = new Handler(Looper.getMainLooper());
    private Handler f1985b = new Handler(Looper.getMainLooper());
    private PowerManager f1986c;
    private Runnable f1987d = new C10631(this);

    class C10631 implements Runnable {
        final /* synthetic */ NotificationService f1980a;

        C10631(NotificationService notificationService) {
            this.f1980a = notificationService;
        }

        public void run() {
            this.f1980a.m2234a(false);
            this.f1980a.m2240d();
        }
    }

    private void m2229a() {
        try {
            if (!LockService.m2172a()) {
                startService(new Intent(this, LockService.class));
            }
        } catch (Exception e) {
        }
    }

    private void m2230a(C0899d c0899d, Bitmap bitmap, boolean z) {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (z) {
                notificationManager.cancel(77);
            }
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("com.domobile.elock.EXTRA_NOTIFICATION_LOCK", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            Builder builder = new Builder(this);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            if (z) {
                builder.setSmallIcon(R.drawable.privacy_notification_anim);
            } else {
                builder.setSmallIcon(R.drawable.privacy_notification_anim_1);
            }
            builder.setTicker(getString(R.string.notification_lock_title));
            builder.setContentTitle(getString(R.string.notification_lock_title));
            builder.setContentText("");
            builder.setContentIntent(activity);
            builder.setWhen(System.currentTimeMillis());
            if (VERSION.SDK_INT < 24 || C1365d.m3438a(this.f1986c)) {
                builder.setPriority(0);
            } else {
                builder.setPriority(1).setVibrate(new long[]{100});
            }
            builder.setLights(c0899d.f1347h, c0899d.f1348i, c0899d.f1349j);
            if (VERSION.SDK_INT >= 21) {
                builder.setVisibility(1);
            }
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_lock_remoteviews);
            builder.setCustomContentView(remoteViews);
            remoteViews.setImageViewBitmap(R.id.imvAppList, bitmap);
            remoteViews.setTextViewText(R.id.txvPostTime, c0899d.m1577b());
            Notification build = builder.build();
            build.flags |= 32;
            notificationManager.notify(77, build);
        } catch (Exception e) {
            m2236b(c0899d, bitmap, z);
        }
    }

    private void m2234a(final boolean z) {
        final ArrayList c = C0900e.m1586c();
        if (c.size() <= 0) {
            mo2476b();
        } else {
            C1148d.m2513a(new AsyncTask<Object, Object, Bitmap>(this) {
                final /* synthetic */ NotificationService f1983c;

                protected Bitmap m2227a(Object... objArr) {
                    return this.f1983c.m2242a(c);
                }

                protected void m2228a(Bitmap bitmap) {
                    this.f1983c.m2230a((C0899d) c.get(0), bitmap, z);
                    this.f1983c.m2238c();
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m2227a(objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m2228a((Bitmap) obj);
                }
            }, new Object[0]);
        }
    }

    private void m2235b(StatusBarNotification statusBarNotification) {
        ArrayList b = C1017n.m2039b();
        if (b.contains(new C1371j("com.domobile.notification")) && b.contains(new C1371j(statusBarNotification.getPackageName()))) {
            C0899d a = m2243a(statusBarNotification);
            if (a != null) {
                C1258c.m2987b("Receive Notification:" + a.toString());
                m2239c(statusBarNotification);
                C0896a.m1545a().m1557a(a, statusBarNotification.getNotification());
            }
        }
    }

    private void m2236b(C0899d c0899d, Bitmap bitmap, boolean z) {
        int i = 1;
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (z) {
                notificationManager.cancel(77);
            }
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("com.domobile.elock.EXTRA_NOTIFICATION_LOCK", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            Notification notification = new Notification();
            if (z) {
                notification.icon = R.drawable.privacy_notification_anim;
            } else {
                notification.icon = R.drawable.privacy_notification_anim_1;
            }
            notification.tickerText = getString(R.string.notification_lock_title);
            notification.contentIntent = activity;
            notification.when = System.currentTimeMillis();
            if (VERSION.SDK_INT < 24 || C1365d.m3438a(this.f1986c)) {
                notification.priority = 0;
                notification.ledARGB = c0899d.f1347h;
                notification.ledOnMS = c0899d.f1348i;
                notification.ledOffMS = c0899d.f1349j;
                int i2 = (notification.ledOnMS == 0 || notification.ledOffMS == 0) ? 0 : 1;
                int i3 = notification.flags & -2;
                if (i2 == 0) {
                    i = 0;
                }
                notification.flags = i | i3;
            } else {
                notification.priority = 1;
                notification.vibrate = new long[]{100};
            }
            if (VERSION.SDK_INT >= 21) {
                notification.visibility = 1;
            }
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_lock_remoteviews);
            notification.contentView = remoteViews;
            remoteViews.setImageViewBitmap(R.id.imvAppList, bitmap);
            remoteViews.setTextViewText(R.id.txvPostTime, c0899d.m1577b());
            notification.flags |= 32;
            notification.flags |= 2;
            notificationManager.notify(77, notification);
            C1258c.m2987b("compatDisplayNotification");
        } catch (Exception e) {
        }
    }

    private synchronized void m2238c() {
        m2241e();
        m2240d();
    }

    private void m2239c(StatusBarNotification statusBarNotification) {
        if (VERSION.SDK_INT >= 21) {
            cancelNotification(statusBarNotification.getKey());
        } else {
            cancelNotification(statusBarNotification.getPackageName(), statusBarNotification.getTag(), statusBarNotification.getId());
        }
    }

    private synchronized void m2240d() {
        this.f1984a.postDelayed(this.f1987d, 60000);
    }

    private synchronized void m2241e() {
        this.f1984a.removeCallbacks(this.f1987d);
    }

    public Bitmap m2242a(@NonNull ArrayList<C0899d> arrayList) {
        int i = 0;
        Resources resources = getResources();
        int i2 = resources.getDisplayMetrics().widthPixels;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.icon_size_mid);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.PaddingSizeSmall);
        dimensionPixelSize = (i2 - dimensionPixelSize) - (dimensionPixelSize2 * 4);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.icon_size_tin);
        int i3 = dimensionPixelSize / (dimensionPixelSize3 + dimensionPixelSize2);
        i2 = arrayList.size();
        if (i2 > i3) {
            i2 = i3;
        }
        Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize3, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0, Mode.CLEAR);
        dimensionPixelSize = 0;
        while (dimensionPixelSize < i2) {
            Bitmap c = C0898c.m1571c(this, ((C0899d) arrayList.get(dimensionPixelSize)).f1342c);
            if (c == null) {
                i3 = i;
            } else {
                Bitmap a = C0903a.m1590a(c, dimensionPixelSize3, dimensionPixelSize3);
                canvas.drawBitmap(a, (float) i, 0.0f, null);
                i3 = (dimensionPixelSize3 + dimensionPixelSize2) + i;
                if (!(a == c || a.isRecycled())) {
                    a.recycle();
                }
            }
            dimensionPixelSize++;
            i = i3;
        }
        return createBitmap;
    }

    @Nullable
    @TargetApi(18)
    public C0899d m2243a(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null || statusBarNotification.isOngoing() || !statusBarNotification.isClearable()) {
            return null;
        }
        if (statusBarNotification.getPackageName().equals(getPackageName())) {
            return null;
        }
        if (statusBarNotification.getPackageName().startsWith("com.android")) {
            return null;
        }
        try {
            if (VERSION.SDK_INT >= 19) {
                Object obj = statusBarNotification.getNotification().extras.get(NotificationCompat.EXTRA_PROGRESS_MAX);
                if (obj != null && ((Integer) obj).intValue() > 0) {
                    return null;
                }
            }
        } catch (Exception e) {
        }
        try {
            CharSequence charSequence;
            CharSequence charSequence2;
            Context createPackageContext = createPackageContext(statusBarNotification.getPackageName(), 3);
            Resources resources = createPackageContext.getResources();
            C0899d c0899d = new C0899d();
            String str = "";
            str = "";
            c0899d.f1347h = statusBarNotification.getNotification().ledARGB;
            c0899d.f1348i = statusBarNotification.getNotification().ledOnMS;
            c0899d.f1349j = statusBarNotification.getNotification().ledOffMS;
            if (VERSION.SDK_INT >= 19) {
                Bundle bundle = statusBarNotification.getNotification().extras;
                charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
                charSequence2 = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            } else {
                RemoteViews remoteViews = statusBarNotification.getNotification().contentView;
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(createPackageContext).inflate(remoteViews.getLayoutId(), null);
                remoteViews.reapply(this, viewGroup);
                int identifier = resources.getIdentifier("android:id/title", null, null);
                int identifier2 = resources.getIdentifier("android:id/text", null, null);
                TextView textView = (TextView) viewGroup.findViewById(identifier);
                TextView textView2 = (TextView) viewGroup.findViewById(identifier2);
                charSequence = textView.getText();
                charSequence2 = textView2.getText();
            }
            if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(charSequence2)) {
                return null;
            }
            c0899d.f1344e = charSequence.toString();
            c0899d.f1345f = charSequence2.toString();
            c0899d.f1341b = statusBarNotification.getId();
            c0899d.f1342c = statusBarNotification.getPackageName();
            c0899d.f1343d = statusBarNotification.getPostTime();
            c0899d.f1340a = statusBarNotification.getPackageName() + "_" + statusBarNotification.getId();
            c0899d.f1346g = C0898c.m1565a() + ".png";
            c0899d.f1351l = C0898c.m1564a(statusBarNotification.getNotification().contentIntent);
            return c0899d;
        } catch (Exception e2) {
            return null;
        }
    }

    public void mo2475a(C0899d c0899d) {
        m2234a(true);
    }

    public void mo2476b() {
        C1258c.m2987b("onNotificationCleared");
        m2241e();
        this.f1985b.removeCallbacksAndMessages(null);
        ((NotificationManager) getSystemService("notification")).cancel(77);
    }

    public void mo2478b(C0899d c0899d) {
        m2234a(false);
    }

    public IBinder onBind(Intent intent) {
        C1258c.m2987b("NotificationService onBind");
        m2229a();
        m2234a(false);
        return super.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        this.f1986c = (PowerManager) getSystemService("power");
        C1258c.m2987b("NotificationService onCreate");
        C0896a.m1545a().m1555a((C0895a) this);
    }

    public void onDestroy() {
        super.onDestroy();
        C1258c.m2987b("NotificationService onDestroy");
        C0896a.m1545a().m1559b((C0895a) this);
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        m2235b(statusBarNotification);
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
