package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.C2513c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class C2424c {
    private static final Lock f7218a = new ReentrantLock();
    private static C2424c f7219b;
    private final Lock f7220c = new ReentrantLock();
    private final SharedPreferences f7221d;

    C2424c(Context context) {
        this.f7221d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C2424c m7661a(Context context) {
        C2513c.m7932a((Object) context);
        f7218a.lock();
        try {
            if (f7219b == null) {
                f7219b = new C2424c(context.getApplicationContext());
            }
            C2424c c2424c = f7219b;
            return c2424c;
        } finally {
            f7218a.unlock();
        }
    }

    private String m7662a(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder((String.valueOf(str).length() + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public GoogleSignInAccount m7663a() {
        return m7664a(m7667c("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount m7664a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m7667c(m7662a("googleSignInAccount", str));
            if (c != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m7619a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    public GoogleSignInOptions m7665b() {
        return m7666b(m7667c("defaultGoogleSignInAccount"));
    }

    GoogleSignInOptions m7666b(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m7667c(m7662a("googleSignInOptions", str));
            if (c != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.m7639a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    protected String m7667c(String str) {
        this.f7220c.lock();
        try {
            String string = this.f7221d.getString(str, null);
            return string;
        } finally {
            this.f7220c.unlock();
        }
    }
}
