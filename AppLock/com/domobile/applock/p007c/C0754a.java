package com.domobile.applock.p007c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.CancellationSignal;
import com.domobile.applock.p007c.C0758b.C0746a;
import com.domobile.applock.p007c.C0758b.C0756b;
import com.domobile.applock.p007c.C0758b.C0757c;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class C0754a {
    static final C0748e f976a;
    private Context f977b;

    private interface C0748e {
        void mo2418a(Context context, C0752d c0752d, int i, CancellationSignal cancellationSignal, C0750b c0750b, Handler handler);

        boolean mo2419a(Context context);

        boolean mo2420b(Context context);
    }

    private static class C0749a implements C0748e {
        static C0752d m1076a(C0757c c0757c) {
            return c0757c == null ? null : c0757c.m1098b() != null ? new C0752d(c0757c.m1098b()) : c0757c.m1097a() != null ? new C0752d(c0757c.m1097a()) : c0757c.m1099c() != null ? new C0752d(c0757c.m1099c()) : null;
        }

        private static C0746a m1077a(final C0750b c0750b) {
            return new C0746a() {
                public void mo2414a() {
                    c0750b.mo2574a();
                }

                public void mo2415a(int i, CharSequence charSequence) {
                    c0750b.mo2575a(i, charSequence);
                }

                public void mo2416a(C0756b c0756b) {
                    c0750b.mo2576a(new C0751c(C0749a.m1076a(c0756b.m1096a())));
                }

                public void mo2417b(int i, CharSequence charSequence) {
                    c0750b.mo2577b(i, charSequence);
                }
            };
        }

        private static C0757c m1078a(C0752d c0752d) {
            return c0752d == null ? null : c0752d.m1087b() != null ? new C0757c(c0752d.m1087b()) : c0752d.m1086a() != null ? new C0757c(c0752d.m1086a()) : c0752d.m1088c() != null ? new C0757c(c0752d.m1088c()) : null;
        }

        public void mo2418a(Context context, C0752d c0752d, int i, CancellationSignal cancellationSignal, C0750b c0750b, Handler handler) {
            C0758b.m1103a(context, C0749a.m1078a(c0752d), i, cancellationSignal != null ? cancellationSignal.getCancellationSignalObject() : null, C0749a.m1077a(c0750b), handler);
        }

        public boolean mo2419a(Context context) {
            return C0758b.m1104a(context);
        }

        public boolean mo2420b(Context context) {
            return C0758b.m1106b(context);
        }
    }

    public static abstract class C0750b {
        public void mo2574a() {
        }

        public void mo2575a(int i, CharSequence charSequence) {
        }

        public void mo2576a(C0751c c0751c) {
        }

        public void mo2577b(int i, CharSequence charSequence) {
        }
    }

    public static final class C0751c {
        private C0752d f972a;

        public C0751c(C0752d c0752d) {
            this.f972a = c0752d;
        }
    }

    public static class C0752d {
        private final Signature f973a;
        private final Cipher f974b;
        private final Mac f975c;

        public C0752d(Signature signature) {
            this.f973a = signature;
            this.f974b = null;
            this.f975c = null;
        }

        public C0752d(Cipher cipher) {
            this.f974b = cipher;
            this.f973a = null;
            this.f975c = null;
        }

        public C0752d(Mac mac) {
            this.f975c = mac;
            this.f974b = null;
            this.f973a = null;
        }

        public Signature m1086a() {
            return this.f973a;
        }

        public Cipher m1087b() {
            return this.f974b;
        }

        public Mac m1088c() {
            return this.f975c;
        }
    }

    private static class C0753f implements C0748e {
        public void mo2418a(Context context, C0752d c0752d, int i, CancellationSignal cancellationSignal, C0750b c0750b, Handler handler) {
        }

        public boolean mo2419a(Context context) {
            return false;
        }

        public boolean mo2420b(Context context) {
            return false;
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f976a = new C0749a();
        } else {
            f976a = new C0753f();
        }
    }

    private C0754a(Context context) {
        this.f977b = context;
    }

    public static C0754a m1092a(Context context) {
        return new C0754a(context);
    }

    public void m1093a(@Nullable C0752d c0752d, int i, @Nullable CancellationSignal cancellationSignal, @NonNull C0750b c0750b, @Nullable Handler handler) {
        f976a.mo2418a(this.f977b, c0752d, i, cancellationSignal, c0750b, handler);
    }

    public boolean m1094a() {
        return f976a.mo2419a(this.f977b);
    }

    public boolean m1095b() {
        return f976a.mo2420b(this.f977b);
    }
}
