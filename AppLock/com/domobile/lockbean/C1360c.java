package com.domobile.lockbean;

import android.annotation.TargetApi;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.domobile.applock.C1150y;
import com.domobile.applock.p007c.C0754a;
import com.domobile.applock.p007c.C0754a.C0752d;
import com.domobile.lockbean.C1365d.C0743a;
import com.domobile.lockbean.C1365d.C1364b;
import com.domobile.widget.FingerPrintStateView;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class C1360c implements C0743a {
    public static final boolean f2927a = (C1150y.O > 22);
    public C1365d f2928b;
    private C0752d f2929c;
    private C0754a f2930d;
    private KeyGenerator f2931e;
    private KeyStore f2932f;
    private Cipher f2933g;
    private C0964f f2934h;
    private Context f2935i;

    public C1360c(Context context, FingerPrintStateView fingerPrintStateView, C0743a c0743a) {
        this.f2935i = context;
        try {
            this.f2930d = C0754a.m1092a(context);
            if (this.f2930d.m1095b() && this.f2930d.m1094a()) {
                this.f2931e = m3434h();
                this.f2932f = m3433g();
                if (m3432f()) {
                    this.f2933g = m3424a(this.f2932f);
                    if (m3423i()) {
                        this.f2929c = new C0752d(this.f2933g);
                        m3427a(fingerPrintStateView, c0743a);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean m3423i() {
        try {
            this.f2932f.load(null);
            this.f2933g.init(1, (SecretKey) this.f2932f.getKey("DoMobileAppLockFingerPrintLock", null));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Cipher m3424a(KeyStore keyStore) {
        try {
            return Cipher.getInstance("AES/CBC/PKCS7Padding");
        } catch (Exception e) {
            return null;
        }
    }

    public void m3425a() {
        if (this.f2928b != null) {
            this.f2928b.m3442a(this.f2929c);
        }
    }

    public void m3426a(C0964f c0964f) {
        this.f2934h = c0964f;
    }

    public void m3427a(FingerPrintStateView fingerPrintStateView, C0743a c0743a) {
        C1364b c1364b = new C1364b(this.f2930d);
        Context a = C1150y.m2566a(this.f2935i);
        if (c0743a == null) {
            Object obj = this;
        }
        this.f2928b = c1364b.m3435a(a, fingerPrintStateView, c0743a);
        if (!this.f2928b.m3445b()) {
        }
    }

    public void mo2410b() {
        if (this.f2934h != null) {
            this.f2934h.mo2463n();
        }
    }

    public void mo2411c() {
    }

    public void mo2412d() {
        if (this.f2934h != null) {
            this.f2934h.mo2464o();
        }
    }

    public void m3431e() {
        this.f2934h = null;
        if (this.f2928b != null) {
            this.f2928b.m3446c();
        }
    }

    @TargetApi(23)
    public boolean m3432f() {
        try {
            this.f2932f.load(null);
            this.f2931e.init(new Builder("DoMobileAppLockFingerPrintLock", 3).setBlockModes(new String[]{"CBC"}).setUserAuthenticationRequired(true).setEncryptionPaddings(new String[]{"PKCS7Padding"}).build());
            this.f2931e.generateKey();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public KeyStore m3433g() {
        try {
            return KeyStore.getInstance("AndroidKeyStore");
        } catch (KeyStoreException e) {
            return null;
        }
    }

    public KeyGenerator m3434h() {
        try {
            return KeyGenerator.getInstance("AES", "AndroidKeyStore");
        } catch (Exception e) {
            return null;
        }
    }
}
