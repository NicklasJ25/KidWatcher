package com.google.firebase.iid;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import android.util.Log;

public class FirebaseInstanceIdService extends C3590b {
    @VisibleForTesting
    static final Object f12225a = new Object();
    @VisibleForTesting
    static boolean f12226b = false;
    private boolean f12227d = false;

    private static class C3589a extends BroadcastReceiver {
        @Nullable
        static BroadcastReceiver f12218a;
        final int f12219b;

        C3589a(int i) {
            this.f12219b = i;
        }

        static synchronized void m15624a(Context context, int i) {
            synchronized (C3589a.class) {
                if (f12218a == null) {
                    f12218a = new C3589a(i);
                    context.getApplicationContext().registerReceiver(f12218a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (C3589a.class) {
                if (f12218a != this) {
                } else if (FirebaseInstanceIdService.m15641c(context)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                    }
                    context.getApplicationContext().unregisterReceiver(this);
                    f12218a = null;
                    C3606g.m15695a().m15700a(context, FirebaseInstanceIdService.m15640c(this.f12219b));
                }
            }
        }
    }

    private int m15631a(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        return (intExtra >= 10 || z) ? intExtra >= 10 ? intExtra > 28800 ? 28800 : intExtra : 10 : 30;
    }

    private C3599d m15633a(String str) {
        if (str == null) {
            return C3599d.m15657a(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return C3599d.m15657a(this, bundle);
    }

    static void m15634a(Context context) {
        if (C3605f.m15672a(context) != null) {
            synchronized (f12225a) {
                if (!f12226b) {
                    C3606g.m15695a().m15700a(context, m15640c(0));
                    f12226b = true;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m15635a(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
        r1 = f12225a;
        monitor-enter(r1);
        r0 = f12226b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        r0 = r3.m15618d();
        if (r0 == 0) goto L_0x0022;
    L_0x0010:
        r1 = com.google.firebase.iid.C3599d.f12248e;
        r0 = r0.m15704b(r1);
        if (r0 != 0) goto L_0x0022;
    L_0x0018:
        r0 = r3.m15620f();
        r0 = r0.m15665a();
        if (r0 == 0) goto L_0x0008;
    L_0x0022:
        m15634a(r2);
        goto L_0x0008;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    private void m15636a(Intent intent, String str) {
        boolean c = m15641c((Context) this);
        int a = m15631a(intent, c);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(a).append("s").toString());
        synchronized (f12225a) {
            m15642d(a);
            f12226b = true;
        }
        if (!c) {
            if (this.f12227d) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            C3589a.m15624a(this, a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15637a(android.content.Intent r9, boolean r10, boolean r11) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = f12225a;
        monitor-enter(r3);
        r0 = 0;
        f12226b = r0;	 Catch:{ all -> 0x0010 }
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        r0 = com.google.firebase.iid.C3605f.m15672a(r8);
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        return;
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m15605a();
        r3 = r0.m15618d();
        if (r3 == 0) goto L_0x0025;
    L_0x001d:
        r4 = com.google.firebase.iid.C3599d.f12248e;
        r4 = r3.m15704b(r4);
        if (r4 == 0) goto L_0x0063;
    L_0x0025:
        r1 = r0.m15619e();	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r1 == 0) goto L_0x0054;
    L_0x002b:
        r2 = r8.f12227d;	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r2 == 0) goto L_0x0036;
    L_0x002f:
        r2 = "FirebaseInstanceId";
        r4 = "get master token succeeded";
        android.util.Log.d(r2, r4);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
    L_0x0036:
        m15635a(r8, r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r11 != 0) goto L_0x0047;
    L_0x003b:
        if (r3 == 0) goto L_0x0047;
    L_0x003d:
        if (r3 == 0) goto L_0x000f;
    L_0x003f:
        r0 = r3.f12284a;	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        r0 = r1.equals(r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r0 != 0) goto L_0x000f;
    L_0x0047:
        r8.m15644a();	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        goto L_0x000f;
    L_0x004b:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m15636a(r9, r0);
        goto L_0x000f;
    L_0x0054:
        r0 = "returned token is null";
        r8.m15636a(r9, r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        goto L_0x000f;
    L_0x005a:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x000f;
    L_0x0063:
        r4 = r0.m15620f();
        r0 = r4.m15665a();
        r3 = r0;
    L_0x006c:
        if (r3 == 0) goto L_0x00d4;
    L_0x006e:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x0087;
    L_0x0078:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x00b7 }
        switch(r7) {
            case 83: goto L_0x0090;
            case 84: goto L_0x0084;
            case 85: goto L_0x009a;
            default: goto L_0x0084;
        };
    L_0x0084:
        switch(r0) {
            case 0: goto L_0x00a4;
            case 1: goto L_0x00c1;
            default: goto L_0x0087;
        };
    L_0x0087:
        r4.m15666a(r3);
        r0 = r4.m15665a();
        r3 = r0;
        goto L_0x006c;
    L_0x0090:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r5 == 0) goto L_0x0084;
    L_0x0098:
        r0 = r1;
        goto L_0x0084;
    L_0x009a:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r5 == 0) goto L_0x0084;
    L_0x00a2:
        r0 = r2;
        goto L_0x0084;
    L_0x00a4:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m15605a();	 Catch:{ IOException -> 0x00b7 }
        r0.m15614a(r6);	 Catch:{ IOException -> 0x00b7 }
        r0 = r8.f12227d;	 Catch:{ IOException -> 0x00b7 }
        if (r0 == 0) goto L_0x0087;
    L_0x00af:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0087;
    L_0x00b7:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m15636a(r9, r0);
        goto L_0x000f;
    L_0x00c1:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m15605a();	 Catch:{ IOException -> 0x00b7 }
        r0.m15616b(r6);	 Catch:{ IOException -> 0x00b7 }
        r0 = r8.f12227d;	 Catch:{ IOException -> 0x00b7 }
        if (r0 == 0) goto L_0x0087;
    L_0x00cc:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0087;
    L_0x00d4:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Intent, boolean, boolean):void");
    }

    private void m15638a(Bundle bundle) {
        String a = C3605f.m15672a((Context) this);
        if (a == null) {
            Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
            return;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.setPackage(a);
        intent.putExtras(bundle);
        C3605f.m15674a((Context) this, intent);
        intent.putExtra("google.to", "google.com/iid");
        intent.putExtra("google.message_id", C3605f.m15683c());
        sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    private static Intent m15640c(int i) {
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return intent;
    }

    private static boolean m15641c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m15642d(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), C3606g.m15693a(this, 0, m15640c(i * 2), 134217728));
    }

    private String m15643e(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    @WorkerThread
    public void m15644a() {
    }

    public boolean mo4311a(Intent intent) {
        this.f12227d = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return false;
        }
        String e = m15643e(intent);
        if (this.f12227d) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(e);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m15633a(e).m15664d().m15692c(intent);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4312b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = "";
    L_0x0009:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x0019;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r2;
    L_0x0012:
        switch(r0) {
            case 0: goto L_0x0023;
            default: goto L_0x0015;
        };
    L_0x0015:
        r4.mo4314d(r5);
    L_0x0018:
        return;
    L_0x0019:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r0 = r1;
        goto L_0x0012;
    L_0x0023:
        r4.m15637a(r5, r1, r1);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.b(android.content.Intent):void");
    }

    protected Intent mo4313c(Intent intent) {
        return C3606g.m15695a().m15701b();
    }

    public void mo4314d(Intent intent) {
        String e = m15643e(intent);
        C3599d a = m15633a(e);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.f12227d) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(((String.valueOf(e).length() + 18) + String.valueOf(stringExtra).length()) + String.valueOf(valueOf).length()).append("Service command ").append(e).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            C3608h c = a.m15662c();
            if (e == null) {
                e = "";
            }
            c.m15717c(e);
            a.m15664d().m15692c(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            a.m15662c().m15717c(e);
            m15637a(intent, false, true);
        } else if ("RST".equals(stringExtra)) {
            a.m15661b();
            m15637a(intent, true, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!a.m15662c().m15715b()) {
                a.m15661b();
                a.m15662c().m15716c();
                m15637a(intent, true, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            a.m15662c().m15717c(e);
            m15637a(intent, false, true);
        } else if ("PING".equals(stringExtra)) {
            m15638a(intent.getExtras());
        }
    }
}
