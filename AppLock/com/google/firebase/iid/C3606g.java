package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.android.gallery3d.data.MediaSet;
import java.util.LinkedList;
import java.util.Queue;

public class C3606g {
    private static C3606g f12278c;
    @VisibleForTesting
    final Queue<Intent> f12279a = new LinkedList();
    @VisibleForTesting
    final Queue<Intent> f12280b = new LinkedList();
    private final SimpleArrayMap<String, String> f12281d = new SimpleArrayMap();
    private Boolean f12282e = null;

    private C3606g() {
    }

    public static PendingIntent m15693a(Context context, int i, Intent intent, int i2) {
        return C3606g.m15694a(context, i, "com.google.firebase.INSTANCE_ID_EVENT", intent, i2);
    }

    private static PendingIntent m15694a(Context context, int i, String str, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, i2);
    }

    public static synchronized C3606g m15695a() {
        C3606g c3606g;
        synchronized (C3606g.class) {
            if (f12278c == null) {
                f12278c = new C3606g();
            }
            c3606g = f12278c;
        }
        return c3606g;
    }

    private boolean m15696a(Context context) {
        if (this.f12282e == null) {
            this.f12282e = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        return this.f12282e.booleanValue();
    }

    private int m15697b(Context context, Intent intent) {
        m15698c(context, intent);
        try {
            ComponentName startWakefulService;
            if (m15696a(context)) {
                startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                startWakefulService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startWakefulService != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (Throwable e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        } catch (IllegalStateException e2) {
            String valueOf = String.valueOf(e2);
            Log.e("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 45).append("Failed to start service while in background: ").append(valueOf).toString());
            return 402;
        }
    }

    private void m15698c(Context context, Intent intent) {
        String str;
        synchronized (this.f12281d) {
            str = (String) this.f12281d.get(intent.getAction());
        }
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                return;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String valueOf = String.valueOf(serviceInfo.packageName);
                str = String.valueOf(serviceInfo.name);
                Log.e("FirebaseInstanceId", new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(str).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(valueOf).append("/").append(str).toString());
                return;
            }
            str = serviceInfo.name;
            if (str.startsWith(".")) {
                String valueOf2 = String.valueOf(context.getPackageName());
                str = String.valueOf(str);
                str = str.length() != 0 ? valueOf2.concat(str) : new String(valueOf2);
            }
            synchronized (this.f12281d) {
                this.f12281d.put(intent.getAction(), str);
            }
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            String str2 = "Restricting intent to a specific service: ";
            valueOf2 = String.valueOf(str);
            Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        intent.setClassName(context.getPackageName(), str);
    }

    public int m15699a(Context context, String str, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    obj = null;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.f12279a.offer(intent);
                break;
            case 1:
                this.f12280b.offer(intent);
                break;
            default:
                String str2 = "FirebaseInstanceId";
                String str3 = "Unknown service action: ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return MediaSet.MEDIAITEM_BATCH_FETCH_COUNT;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return m15697b(context, intent2);
    }

    public void m15700a(Context context, Intent intent) {
        m15699a(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }

    public Intent m15701b() {
        return (Intent) this.f12279a.poll();
    }
}
