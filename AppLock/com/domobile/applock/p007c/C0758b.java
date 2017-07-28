package com.domobile.applock.p007c;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@TargetApi(23)
@RestrictTo({Scope.GROUP_ID})
public final class C0758b {

    public static abstract class C0746a {
        public void mo2414a() {
        }

        public void mo2415a(int i, CharSequence charSequence) {
        }

        public void mo2416a(C0756b c0756b) {
        }

        public void mo2417b(int i, CharSequence charSequence) {
        }
    }

    public static final class C0756b {
        private C0757c f979a;

        public C0756b(C0757c c0757c) {
            this.f979a = c0757c;
        }

        public C0757c m1096a() {
            return this.f979a;
        }
    }

    public static class C0757c {
        private final Signature f980a;
        private final Cipher f981b;
        private final Mac f982c;

        public C0757c(Signature signature) {
            this.f980a = signature;
            this.f981b = null;
            this.f982c = null;
        }

        public C0757c(Cipher cipher) {
            this.f981b = cipher;
            this.f980a = null;
            this.f982c = null;
        }

        public C0757c(Mac mac) {
            this.f982c = mac;
            this.f981b = null;
            this.f980a = null;
        }

        public Signature m1097a() {
            return this.f980a;
        }

        public Cipher m1098b() {
            return this.f981b;
        }

        public Mac m1099c() {
            return this.f982c;
        }
    }

    private static AuthenticationCallback m1100a(final C0746a c0746a) {
        return new AuthenticationCallback() {
            public void onAuthenticationError(int i, CharSequence charSequence) {
                c0746a.mo2415a(i, charSequence);
            }

            public void onAuthenticationFailed() {
                c0746a.mo2414a();
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                c0746a.mo2417b(i, charSequence);
            }

            public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
                c0746a.mo2416a(new C0756b(C0758b.m1105b(authenticationResult.getCryptoObject())));
            }
        };
    }

    private static CryptoObject m1101a(C0757c c0757c) {
        return c0757c == null ? null : c0757c.m1098b() != null ? new CryptoObject(c0757c.m1098b()) : c0757c.m1097a() != null ? new CryptoObject(c0757c.m1097a()) : c0757c.m1099c() != null ? new CryptoObject(c0757c.m1099c()) : null;
    }

    public static void m1103a(Context context, C0757c c0757c, int i, Object obj, C0746a c0746a, Handler handler) {
        C0758b.m1107c(context).authenticate(C0758b.m1101a(c0757c), (CancellationSignal) obj, i, C0758b.m1100a(c0746a), handler);
    }

    public static boolean m1104a(Context context) {
        return C0758b.m1107c(context).hasEnrolledFingerprints();
    }

    private static C0757c m1105b(CryptoObject cryptoObject) {
        return cryptoObject == null ? null : cryptoObject.getCipher() != null ? new C0757c(cryptoObject.getCipher()) : cryptoObject.getSignature() != null ? new C0757c(cryptoObject.getSignature()) : cryptoObject.getMac() != null ? new C0757c(cryptoObject.getMac()) : null;
    }

    public static boolean m1106b(Context context) {
        return C0758b.m1107c(context).isHardwareDetected();
    }

    private static FingerprintManager m1107c(Context context) {
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }
}
