package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.C3531b;
import com.google.firebase.iid.C3608h.C3607a;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> f12210a = new ArrayMap();
    private static C3600e f12211b;
    private final C3531b f12212c;
    private final C3599d f12213d;
    private final String f12214e = m15615b();

    private FirebaseInstanceId(C3531b c3531b, C3599d c3599d) {
        this.f12212c = c3531b;
        this.f12213d = c3599d;
        if (this.f12214e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.m15635a(this.f12212c.m15431a(), this);
    }

    static int m15603a(Context context) {
        return m15604a(context, context.getPackageName());
    }

    static int m15604a(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf).toString());
            return i;
        }
    }

    public static FirebaseInstanceId m15605a() {
        return getInstance(C3531b.m15427d());
    }

    static String m15606a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m15607a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static void m15608a(Context context, C3608h c3608h) {
        c3608h.m15716c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        C3606g.m15695a().m15700a(context, intent);
    }

    private void m15609a(Bundle bundle) {
        bundle.putString("gmp_app_id", this.f12212c.m15436c().m15450b());
    }

    static String m15610b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void m15611c(Context context) {
        Intent intent = new Intent();
        intent.putExtra("CMD", "SYNC");
        C3606g.m15695a().m15700a(context, intent);
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull C3531b c3531b) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) f12210a.get(c3531b.m15436c().m15450b());
            if (firebaseInstanceId == null) {
                C3599d a = C3599d.m15657a(c3531b.m15431a(), null);
                if (f12211b == null) {
                    f12211b = new C3600e(a.m15662c());
                }
                firebaseInstanceId = new FirebaseInstanceId(c3531b, a);
                f12210a.put(c3531b.m15436c().m15450b(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    @WorkerThread
    public String m15612a(String str, String str2) {
        Bundle bundle = new Bundle();
        m15609a(bundle);
        return this.f12213d.m15660b(str, str2, bundle);
    }

    public String m15613a(String str, String str2, Bundle bundle) {
        m15609a(bundle);
        return this.f12213d.m15663c(str, str2, bundle);
    }

    void m15614a(String str) {
        C3607a d = m15618d();
        if (d == null || d.m15704b(C3599d.f12248e)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str3 = d.f12284a;
        str2 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        m15613a(str3, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), bundle);
    }

    String m15615b() {
        String d = this.f12212c.m15436c().m15452d();
        if (d != null) {
            return d;
        }
        d = this.f12212c.m15436c().m15450b();
        if (!d.startsWith("1:")) {
            return d;
        }
        String[] split = d.split(":");
        if (split.length < 2) {
            return null;
        }
        d = split[1];
        return d.isEmpty() ? null : d;
    }

    void m15616b(String str) {
        C3607a d = m15618d();
        if (d == null || d.m15704b(C3599d.f12248e)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C3599d c3599d = this.f12213d;
        String str3 = d.f12284a;
        valueOf = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        c3599d.m15659a(str3, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), bundle);
    }

    public String m15617c() {
        return m15606a(this.f12213d.m15658a());
    }

    @Nullable
    C3607a m15618d() {
        return this.f12213d.m15662c().m15710a("", this.f12214e, "*");
    }

    String m15619e() {
        return m15612a(this.f12214e, "*");
    }

    C3600e m15620f() {
        return f12211b;
    }
}
