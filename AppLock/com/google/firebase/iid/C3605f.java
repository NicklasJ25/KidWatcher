package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.Random;

public class C3605f {
    static String f12261a = null;
    static boolean f12262b = false;
    static int f12263c = 0;
    static int f12264d = 0;
    static int f12265e = 0;
    static BroadcastReceiver f12266f = null;
    static PendingIntent f12267k;
    Context f12268g;
    Messenger f12269h;
    Messenger f12270i;
    MessengerCompat f12271j;
    long f12272l;
    long f12273m;
    int f12274n;
    int f12275o;
    long f12276p;
    private final SimpleArrayMap<String, C3603b> f12277q = new SimpleArrayMap();

    class C36022 extends BroadcastReceiver {
        final /* synthetic */ C3605f f12257a;

        C36022(C3605f c3605f) {
            this.f12257a = c3605f;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 44).append("Received GSF callback via dynamic receiver: ").append(valueOf).toString());
            }
            this.f12257a.m15692c(intent);
        }
    }

    private interface C3603b {
        void mo4315a(Intent intent);

        void mo4316a(String str);
    }

    private static class C3604a implements C3603b {
        private final ConditionVariable f12258a;
        private Intent f12259b;
        private String f12260c;

        private C3604a() {
            this.f12258a = new ConditionVariable();
        }

        public Intent m15669a() {
            if (!this.f12258a.block(30000)) {
                Log.w("InstanceID/Rpc", "No response");
                throw new IOException("TIMEOUT");
            } else if (this.f12260c == null) {
                return this.f12259b;
            } else {
                throw new IOException(this.f12260c);
            }
        }

        public void mo4315a(Intent intent) {
            this.f12259b = intent;
            this.f12258a.open();
        }

        public void mo4316a(String str) {
            this.f12260c = str;
            this.f12258a.open();
        }
    }

    public C3605f(Context context) {
        this.f12268g = context;
    }

    public static String m15672a(Context context) {
        if (f12261a != null) {
            return f12261a;
        }
        f12263c = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (C3605f.m15682b(packageManager)) {
            return f12261a;
        }
        if (!C2590o.m8318m() && C3605f.m15678a(packageManager)) {
            return f12261a;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (C3605f.m15679a(packageManager, "com.google.android.gms")) {
            f12262b = C2590o.m8318m();
            return f12261a;
        } else if (C2590o.m8315j() || !C3605f.m15679a(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            f12262b = false;
            return f12261a;
        }
    }

    static String m15673a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.m15607a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    public static synchronized void m15674a(Context context, Intent intent) {
        synchronized (C3605f.class) {
            if (f12267k == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f12267k = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f12267k);
        }
    }

    private void m15675a(String str) {
        if ("com.google.android.gsf".equals(f12261a)) {
            this.f12274n++;
            if (this.f12274n >= 3) {
                if (this.f12274n == 3) {
                    this.f12275o = new Random().nextInt(1000) + 1000;
                }
                this.f12275o *= 2;
                this.f12276p = SystemClock.elapsedRealtime() + ((long) this.f12275o);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f12275o).toString());
            }
        }
    }

    private void m15676a(String str, Intent intent) {
        synchronized (this.f12277q) {
            C3603b c3603b = (C3603b) this.f12277q.remove(str);
            if (c3603b == null) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Missing callback for ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return;
            }
            c3603b.mo4315a(intent);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15677a(java.lang.String r6, java.lang.String r7) {
        /*
        r5 = this;
        r2 = r5.f12277q;
        monitor-enter(r2);
        if (r6 != 0) goto L_0x0025;
    L_0x0005:
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r0 = r5.f12277q;	 Catch:{ all -> 0x0046 }
        r0 = r0.size();	 Catch:{ all -> 0x0046 }
        if (r1 >= r0) goto L_0x001e;
    L_0x000f:
        r0 = r5.f12277q;	 Catch:{ all -> 0x0046 }
        r0 = r0.valueAt(r1);	 Catch:{ all -> 0x0046 }
        r0 = (com.google.firebase.iid.C3605f.C3603b) r0;	 Catch:{ all -> 0x0046 }
        r0.mo4316a(r7);	 Catch:{ all -> 0x0046 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0007;
    L_0x001e:
        r0 = r5.f12277q;	 Catch:{ all -> 0x0046 }
        r0.clear();	 Catch:{ all -> 0x0046 }
    L_0x0023:
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
    L_0x0024:
        return;
    L_0x0025:
        r0 = r5.f12277q;	 Catch:{ all -> 0x0046 }
        r0 = r0.remove(r6);	 Catch:{ all -> 0x0046 }
        r0 = (com.google.firebase.iid.C3605f.C3603b) r0;	 Catch:{ all -> 0x0046 }
        if (r0 != 0) goto L_0x004f;
    L_0x002f:
        r1 = "InstanceID/Rpc";
        r3 = "Missing callback for ";
        r0 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x0046 }
        r4 = r0.length();	 Catch:{ all -> 0x0046 }
        if (r4 == 0) goto L_0x0049;
    L_0x003d:
        r0 = r3.concat(r0);	 Catch:{ all -> 0x0046 }
    L_0x0041:
        android.util.Log.w(r1, r0);	 Catch:{ all -> 0x0046 }
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
        goto L_0x0024;
    L_0x0046:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
        throw r0;
    L_0x0049:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0046 }
        r0.<init>(r3);	 Catch:{ all -> 0x0046 }
        goto L_0x0041;
    L_0x004f:
        r0.mo4316a(r7);	 Catch:{ all -> 0x0046 }
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.f.a(java.lang.String, java.lang.String):void");
    }

    private static boolean m15678a(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (C3605f.m15680a(packageManager, resolveInfo.serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                f12262b = false;
                return true;
            }
        }
        return false;
    }

    private static boolean m15679a(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            f12261a = applicationInfo.packageName;
            f12264d = applicationInfo.uid;
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean m15680a(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return C3605f.m15679a(packageManager, str);
        }
        Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    private Intent m15681b(Bundle bundle, KeyPair keyPair) {
        String c = C3605f.m15683c();
        C3604a c3604a = new C3604a();
        synchronized (this.f12277q) {
            this.f12277q.put(c, c3604a);
        }
        m15688a(bundle, keyPair, c);
        try {
            Intent a = c3604a.m15669a();
            synchronized (this.f12277q) {
                this.f12277q.remove(c);
            }
            return a;
        } catch (Throwable th) {
            synchronized (this.f12277q) {
                this.f12277q.remove(c);
            }
        }
    }

    private static boolean m15682b(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (C3605f.m15680a(packageManager, resolveInfo.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                f12262b = true;
                return true;
            }
        }
        return false;
    }

    public static synchronized String m15683c() {
        String num;
        synchronized (C3605f.class) {
            int i = f12265e;
            f12265e = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m15684a(Bundle bundle, KeyPair keyPair) {
        Intent b = m15681b(bundle, keyPair);
        if (b == null || !b.hasExtra("google.messenger")) {
            return b;
        }
        b = m15681b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : null;
    }

    String m15685a(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void m15686a() {
        if (this.f12269h == null) {
            C3605f.m15672a(this.f12268g);
            this.f12269h = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ C3605f f12256a;

                public void handleMessage(Message message) {
                    this.f12256a.m15689a(message);
                }
            });
        }
    }

    protected void m15687a(Intent intent, String str) {
        this.f12272l = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f12261a);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            m15690b();
            this.f12268g.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.f12269h);
        if (!(this.f12270i == null && this.f12271j == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f12270i != null) {
                    this.f12270i.send(obtain);
                    return;
                } else {
                    this.f12271j.m8377a(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (f12262b) {
            this.f12268g.sendBroadcast(intent);
        } else {
            this.f12268g.startService(intent);
        }
    }

    public void m15688a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f12276p == 0 || elapsedRealtime > this.f12276p) {
            m15686a();
            if (f12261a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f12272l = SystemClock.elapsedRealtime();
            Intent intent = new Intent(f12262b ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f12261a);
            bundle.putString("gmsv", Integer.toString(FirebaseInstanceId.m15604a(this.f12268g, C3605f.m15672a(this.f12268g))));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.m15603a(this.f12268g)));
            bundle.putString("app_ver_name", FirebaseInstanceId.m15610b(this.f12268g));
            bundle.putString("cliv", "fiid-10260000");
            bundle.putString("appid", FirebaseInstanceId.m15606a(keyPair));
            bundle.putString("pub2", FirebaseInstanceId.m15607a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", C3605f.m15673a(keyPair, this.f12268g.getPackageName(), r0));
            intent.putExtras(bundle);
            C3605f.m15674a(this.f12268g, intent);
            m15687a(intent, str);
            return;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.f12276p - elapsedRealtime) + " interval: " + this.f12275o);
        throw new IOException("RETRY_LATER");
    }

    void m15689a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f12271j = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f12270i = (Messenger) parcelableExtra;
                    }
                }
                m15692c((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    void m15690b() {
        synchronized (this) {
            if (f12266f == null) {
                f12266f = new C36022(this);
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Registered GSF callback receiver");
                }
                IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                intentFilter.addCategory(this.f12268g.getPackageName());
                this.f12268g.registerReceiver(f12266f, intentFilter, "com.google.android.c2dm.permission.SEND", null);
            }
        }
    }

    void m15691b(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        String valueOf2;
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        m15677a(valueOf2, valueOf);
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f12273m = SystemClock.elapsedRealtime();
            this.f12275o = ((int) longExtra) * 1000;
            this.f12276p = SystemClock.elapsedRealtime() + ((long) this.f12275o);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f12275o);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            m15675a(valueOf);
        }
    }

    void m15692c(Intent intent) {
        if (intent != null) {
            String stringExtra;
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    m15691b(intent);
                    return;
                }
                this.f12272l = SystemClock.elapsedRealtime();
                this.f12276p = 0;
                this.f12274n = 0;
                this.f12275o = 0;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    str = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.m15611c(this.f12268g);
                        } else if ("RST".equals(split[3])) {
                            FirebaseInstanceId.m15608a(this.f12268g, C3599d.m15657a(this.f12268g, null).m15662c());
                            intent.removeExtra("registration_id");
                            m15676a(str, intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    stringExtra = str;
                } else {
                    stringExtra = null;
                }
                if (stringExtra != null) {
                    m15676a(stringExtra, intent);
                } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Ignoring response without a request ID");
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                String str3 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? str3.concat(stringExtra) : new String(str3));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
