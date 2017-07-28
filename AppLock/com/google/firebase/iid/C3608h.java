package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.C2593r;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class C3608h {
    SharedPreferences f12287a;
    Context f12288b;

    static class C3607a {
        private static final long f12283d = TimeUnit.DAYS.toMillis(7);
        final String f12284a;
        final String f12285b;
        final long f12286c;

        private C3607a(String str, String str2, long j) {
            this.f12284a = str;
            this.f12285b = str2;
            this.f12286c = j;
        }

        static C3607a m15702a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new C3607a(str, null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new C3607a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf).toString());
                return null;
            }
        }

        static String m15703a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to encode token: ").append(valueOf).toString());
                return null;
            }
        }

        boolean m15704b(String str) {
            return System.currentTimeMillis() > this.f12286c + f12283d || !str.equals(this.f12285b);
        }
    }

    public C3608h(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C3608h(Context context, String str) {
        this.f12288b = context;
        this.f12287a = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m15707e(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String m15705a(String str, String str2) {
        String valueOf = String.valueOf("|S|");
        return new StringBuilder((String.valueOf(str).length() + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    private String m15706c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void m15707e(String str) {
        File file = new File(C2593r.m8322a(this.f12288b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m15715b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m15608a(this.f12288b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    private void m15708f(String str) {
        Editor edit = this.f12287a.edit();
        for (String str2 : this.f12287a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public SharedPreferences m15709a() {
        return this.f12287a;
    }

    public synchronized C3607a m15710a(String str, String str2, String str3) {
        return C3607a.m15702a(this.f12287a.getString(m15706c(str, str2, str3), null));
    }

    synchronized KeyPair m15711a(String str) {
        KeyPair a;
        a = C3591a.m15649a();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.f12287a.edit();
        edit.putString(m15705a(str, "|P|"), FirebaseInstanceId.m15607a(a.getPublic().getEncoded()));
        edit.putString(m15705a(str, "|K|"), FirebaseInstanceId.m15607a(a.getPrivate().getEncoded()));
        edit.putString(m15705a(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return a;
    }

    public synchronized void m15712a(String str, String str2, String str3, String str4, String str5) {
        String a = C3607a.m15703a(str4, str5, System.currentTimeMillis());
        if (a != null) {
            Editor edit = this.f12287a.edit();
            edit.putString(m15706c(str, str2, str3), a);
            edit.commit();
        }
    }

    synchronized void m15713b(String str) {
        m15708f(String.valueOf(str).concat("|"));
    }

    public synchronized void m15714b(String str, String str2, String str3) {
        String c = m15706c(str, str2, str3);
        Editor edit = this.f12287a.edit();
        edit.remove(c);
        edit.commit();
    }

    public synchronized boolean m15715b() {
        return this.f12287a.getAll().isEmpty();
    }

    public synchronized void m15716c() {
        this.f12287a.edit().clear().commit();
    }

    public synchronized void m15717c(String str) {
        m15708f(String.valueOf(str).concat("|T|"));
    }

    public synchronized KeyPair m15718d(String str) {
        KeyPair keyPair;
        Object e;
        String string = this.f12287a.getString(m15705a(str, "|P|"), null);
        String string2 = this.f12287a.getString(m15705a(str, "|K|"), null);
        if (string == null || string2 == null) {
            keyPair = null;
        } else {
            try {
                byte[] decode = Base64.decode(string, 8);
                byte[] decode2 = Base64.decode(string2, 8);
                KeyFactory instance = KeyFactory.getInstance("RSA");
                keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (InvalidKeySpecException e2) {
                e = e2;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m15608a(this.f12288b, this);
                keyPair = null;
                return keyPair;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m15608a(this.f12288b, this);
                keyPair = null;
                return keyPair;
            }
        }
        return keyPair;
    }
}
