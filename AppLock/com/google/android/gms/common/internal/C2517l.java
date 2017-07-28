package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2457b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2531y.C2532a;
import com.google.android.gms.common.internal.C2561z.C2563a;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class C2517l<T extends IInterface> {
    public static final String[] f7397d = new String[]{"service_esmobile", "service_googleme"};
    final Handler f7398a;
    protected C2530f f7399b;
    protected AtomicInteger f7400c;
    private int f7401e;
    private long f7402f;
    private long f7403g;
    private int f7404h;
    private long f7405i;
    private final Context f7406j;
    private final Looper f7407k;
    private final C2549s f7408l;
    private final C2480k f7409m;
    private final Object f7410n;
    private final Object f7411o;
    private C2561z f7412p;
    private T f7413q;
    private final ArrayList<C2525e<?>> f7414r;
    private C2534h f7415s;
    private int f7416t;
    private final C2527b f7417u;
    private final C2528c f7418v;
    private final int f7419w;
    private final String f7420x;

    protected abstract class C2525e<TListener> {
        private TListener f7427a;
        private boolean f7428b = false;
        final /* synthetic */ C2517l f7429d;

        public C2525e(C2517l c2517l, TListener tListener) {
            this.f7429d = c2517l;
            this.f7427a = tListener;
        }

        protected abstract void mo3339a(TListener tListener);

        public void m8022b() {
            synchronized (this) {
                Object obj = this.f7427a;
                if (this.f7428b) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    mo3339a(obj);
                } catch (RuntimeException e) {
                    throw e;
                }
            }
            synchronized (this) {
                this.f7428b = true;
            }
            m8023c();
        }

        public void m8023c() {
            m8024d();
            synchronized (this.f7429d.f7414r) {
                this.f7429d.f7414r.remove(this);
            }
        }

        public void m8024d() {
            synchronized (this) {
                this.f7427a = null;
            }
        }
    }

    private abstract class C2526a extends C2525e<Boolean> {
        public final int f7430a;
        public final Bundle f7431b;
        final /* synthetic */ C2517l f7432c;

        @BinderThread
        protected C2526a(C2517l c2517l, int i, Bundle bundle) {
            this.f7432c = c2517l;
            super(c2517l, Boolean.valueOf(true));
            this.f7430a = i;
            this.f7431b = bundle;
        }

        protected abstract void mo3343a(ConnectionResult connectionResult);

        protected void m8026a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f7432c.m7956a(1, null);
                return;
            }
            switch (this.f7430a) {
                case 0:
                    if (!mo3344a()) {
                        this.f7432c.m7956a(1, null);
                        mo3343a(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.f7432c.m7956a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f7432c.m7956a(1, null);
                    if (this.f7431b != null) {
                        pendingIntent = (PendingIntent) this.f7431b.getParcelable("pendingIntent");
                    }
                    mo3343a(new ConnectionResult(this.f7430a, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo3339a(Object obj) {
            m8026a((Boolean) obj);
        }

        protected abstract boolean mo3344a();
    }

    public interface C2527b {
        void mo3346a(int i);

        void mo3347a(@Nullable Bundle bundle);
    }

    public interface C2528c {
        void mo3348a(@NonNull ConnectionResult connectionResult);
    }

    final class C2529d extends Handler {
        final /* synthetic */ C2517l f7433a;

        public C2529d(C2517l c2517l, Looper looper) {
            this.f7433a = c2517l;
            super(looper);
        }

        private void m8032a(Message message) {
            ((C2525e) message.obj).m8023c();
        }

        private boolean m8033b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.f7433a.f7400c.get() != message.arg1) {
                if (m8033b(message)) {
                    m8032a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f7433a.m7978c()) {
                m8032a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f7433a.f7399b.mo3342a(connectionResult);
                this.f7433a.m7971a(connectionResult);
            } else if (message.what == 4) {
                this.f7433a.m7956a(4, null);
                if (this.f7433a.f7417u != null) {
                    this.f7433a.f7417u.mo3346a(message.arg2);
                }
                this.f7433a.m7967a(message.arg2);
                this.f7433a.m7958a(4, 1, null);
            } else if (message.what == 2 && !this.f7433a.m7977b()) {
                m8032a(message);
            } else if (m8033b(message)) {
                ((C2525e) message.obj).m8022b();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public interface C2530f {
        void mo3342a(@NonNull ConnectionResult connectionResult);
    }

    public static final class C2533g extends C2532a {
        private C2517l f7434a;
        private final int f7435b;

        public C2533g(@NonNull C2517l c2517l, int i) {
            this.f7434a = c2517l;
            this.f7435b = i;
        }

        private void m8038a() {
            this.f7434a = null;
        }

        @BinderThread
        public void mo3340a(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @BinderThread
        public void mo3341a(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            C2513c.m7933a(this.f7434a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f7434a.m7969a(i, iBinder, bundle, this.f7435b);
            m8038a();
        }
    }

    public final class C2534h implements ServiceConnection {
        final /* synthetic */ C2517l f7436a;
        private final int f7437b;

        public C2534h(C2517l c2517l, int i) {
            this.f7436a = c2517l;
            this.f7437b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                this.f7436a.m7968a(8, null, this.f7437b);
                return;
            }
            synchronized (this.f7436a.f7411o) {
                this.f7436a.f7412p = C2563a.m8184a(iBinder);
            }
            this.f7436a.m7968a(0, null, this.f7437b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f7436a.f7411o) {
                this.f7436a.f7412p = null;
            }
            this.f7436a.f7398a.sendMessage(this.f7436a.f7398a.obtainMessage(4, this.f7437b, 1));
        }
    }

    protected class C2535i implements C2530f {
        final /* synthetic */ C2517l f7438a;

        public C2535i(C2517l c2517l) {
            this.f7438a = c2517l;
        }

        public void mo3342a(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.m7713b()) {
                this.f7438a.m7974a(null, this.f7438a.mo3334x());
            } else if (this.f7438a.f7418v != null) {
                this.f7438a.f7418v.mo3348a(connectionResult);
            }
        }
    }

    protected final class C2536j extends C2526a {
        public final IBinder f7439e;
        final /* synthetic */ C2517l f7440f;

        @BinderThread
        public C2536j(C2517l c2517l, int i, IBinder iBinder, Bundle bundle) {
            this.f7440f = c2517l;
            super(c2517l, i, bundle);
            this.f7439e = iBinder;
        }

        protected void mo3343a(ConnectionResult connectionResult) {
            if (this.f7440f.f7418v != null) {
                this.f7440f.f7418v.mo3348a(connectionResult);
            }
            this.f7440f.m7971a(connectionResult);
        }

        protected boolean mo3344a() {
            try {
                String interfaceDescriptor = this.f7439e.getInterfaceDescriptor();
                if (this.f7440f.mo3337j().equals(interfaceDescriptor)) {
                    IInterface a = this.f7440f.mo3335a(this.f7439e);
                    if (a == null || !this.f7440f.m7958a(2, 3, a)) {
                        return false;
                    }
                    Bundle u = this.f7440f.m7994u();
                    if (this.f7440f.f7417u != null) {
                        this.f7440f.f7417u.mo3347a(u);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.f7440f.mo3337j());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class C2537k extends C2526a {
        final /* synthetic */ C2517l f7441e;

        @BinderThread
        public C2537k(C2517l c2517l, int i, @Nullable Bundle bundle) {
            this.f7441e = c2517l;
            super(c2517l, i, bundle);
        }

        protected void mo3343a(ConnectionResult connectionResult) {
            this.f7441e.f7399b.mo3342a(connectionResult);
            this.f7441e.m7971a(connectionResult);
        }

        protected boolean mo3344a() {
            this.f7441e.f7399b.mo3342a(ConnectionResult.zzayj);
            return true;
        }
    }

    protected C2517l(Context context, Looper looper, int i, C2527b c2527b, C2528c c2528c, String str) {
        this(context, looper, C2549s.m8086a(context), C2480k.m7807b(), i, (C2527b) C2513c.m7932a((Object) c2527b), (C2528c) C2513c.m7932a((Object) c2528c), str);
    }

    protected C2517l(Context context, Looper looper, C2549s c2549s, C2480k c2480k, int i, C2527b c2527b, C2528c c2528c, String str) {
        this.f7410n = new Object();
        this.f7411o = new Object();
        this.f7414r = new ArrayList();
        this.f7416t = 1;
        this.f7400c = new AtomicInteger(0);
        this.f7406j = (Context) C2513c.m7933a((Object) context, (Object) "Context must not be null");
        this.f7407k = (Looper) C2513c.m7933a((Object) looper, (Object) "Looper must not be null");
        this.f7408l = (C2549s) C2513c.m7933a((Object) c2549s, (Object) "Supervisor must not be null");
        this.f7409m = (C2480k) C2513c.m7933a((Object) c2480k, (Object) "API availability must not be null");
        this.f7398a = new C2529d(this, looper);
        this.f7419w = i;
        this.f7417u = c2527b;
        this.f7418v = c2528c;
        this.f7420x = str;
    }

    private void m7956a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        C2513c.m7941b(z);
        synchronized (this.f7410n) {
            this.f7416t = i;
            this.f7413q = t;
            switch (i) {
                case 1:
                    m7964y();
                    break;
                case 2:
                    mo3338k();
                    break;
                case 3:
                    m7970a((IInterface) t);
                    break;
            }
        }
    }

    private boolean m7958a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f7410n) {
            if (this.f7416t != i) {
                z = false;
            } else {
                m7956a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private void mo3338k() {
        if (this.f7415s != null) {
            String valueOf = String.valueOf(mo3336i());
            String valueOf2 = String.valueOf(e_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f7408l.m8090b(mo3336i(), e_(), this.f7415s, m7986m());
            this.f7400c.incrementAndGet();
        }
        this.f7415s = new C2534h(this, this.f7400c.get());
        if (!this.f7408l.m8088a(mo3336i(), e_(), this.f7415s, m7986m())) {
            valueOf = String.valueOf(mo3336i());
            valueOf2 = String.valueOf(e_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m7968a(16, null, this.f7400c.get());
        }
    }

    private void m7964y() {
        if (this.f7415s != null) {
            this.f7408l.m8090b(mo3336i(), e_(), this.f7415s, m7986m());
            this.f7415s = null;
        }
    }

    @Nullable
    protected abstract T mo3335a(IBinder iBinder);

    public void m7966a() {
        this.f7400c.incrementAndGet();
        synchronized (this.f7414r) {
            int size = this.f7414r.size();
            for (int i = 0; i < size; i++) {
                ((C2525e) this.f7414r.get(i)).m8024d();
            }
            this.f7414r.clear();
        }
        synchronized (this.f7411o) {
            this.f7412p = null;
        }
        m7956a(1, null);
    }

    @CallSuper
    protected void m7967a(int i) {
        this.f7401e = i;
        this.f7402f = System.currentTimeMillis();
    }

    protected void m7968a(int i, @Nullable Bundle bundle, int i2) {
        this.f7398a.sendMessage(this.f7398a.obtainMessage(5, i2, -1, new C2537k(this, i, bundle)));
    }

    protected void m7969a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f7398a.sendMessage(this.f7398a.obtainMessage(1, i2, -1, new C2536j(this, i, iBinder, bundle)));
    }

    @CallSuper
    protected void m7970a(@NonNull T t) {
        this.f7403g = System.currentTimeMillis();
    }

    @CallSuper
    protected void m7971a(ConnectionResult connectionResult) {
        this.f7404h = connectionResult.m7714c();
        this.f7405i = System.currentTimeMillis();
    }

    public void m7972a(@NonNull C2530f c2530f) {
        this.f7399b = (C2530f) C2513c.m7933a((Object) c2530f, (Object) "Connection progress callbacks cannot be null.");
        m7956a(2, null);
    }

    public void m7973a(@NonNull C2530f c2530f, int i, @Nullable PendingIntent pendingIntent) {
        this.f7399b = (C2530f) C2513c.m7933a((Object) c2530f, (Object) "Connection progress callbacks cannot be null.");
        this.f7398a.sendMessage(this.f7398a.obtainMessage(3, this.f7400c.get(), i, pendingIntent));
    }

    @WorkerThread
    public void m7974a(C2503v c2503v, Set<Scope> set) {
        Throwable e;
        zzj a = new zzj(this.f7419w).m8201a(this.f7406j.getPackageName()).m8199a(mo3586s());
        if (set != null) {
            a.m8202a((Collection) set);
        }
        if (mo3584d()) {
            a.m8198a(m7991r()).m8200a(c2503v);
        } else if (m7996w()) {
            a.m8198a(mo3332p());
        }
        a.m8203a(mo3333q());
        try {
            synchronized (this.f7411o) {
                if (this.f7412p != null) {
                    this.f7412p.mo3351a(new C2533g(this, this.f7400c.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (Throwable e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            m7976b(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException e4) {
            e2 = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            m7969a(8, null, null, this.f7400c.get());
        } catch (RuntimeException e5) {
            e2 = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            m7969a(8, null, null, this.f7400c.get());
        }
    }

    public void m7975a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f7410n) {
            int i = this.f7416t;
            IInterface iInterface = this.f7413q;
        }
        synchronized (this.f7411o) {
            C2561z c2561z = this.f7412p;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(mo3337j()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (c2561z == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(c2561z.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f7403g > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f7403g;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f7403g)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f7402f > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f7401e) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f7401e));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f7402f;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f7402f)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f7405i > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C2457b.m7753a(this.f7404h));
            append = printWriter.append(" lastFailedTime=");
            j = this.f7405i;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f7405i)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(" ").append(valueOf2).toString());
        }
    }

    public void m7976b(int i) {
        this.f7398a.sendMessage(this.f7398a.obtainMessage(4, this.f7400c.get(), i));
    }

    public boolean m7977b() {
        boolean z;
        synchronized (this.f7410n) {
            z = this.f7416t == 3;
        }
        return z;
    }

    public boolean m7978c() {
        boolean z;
        synchronized (this.f7410n) {
            z = this.f7416t == 2;
        }
        return z;
    }

    public boolean mo3584d() {
        return false;
    }

    public boolean m7980e() {
        return true;
    }

    protected String e_() {
        return "com.google.android.gms";
    }

    public boolean m7981f() {
        return false;
    }

    public Intent m7982g() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @Nullable
    public IBinder m7983h() {
        IBinder iBinder;
        synchronized (this.f7411o) {
            if (this.f7412p == null) {
                iBinder = null;
            } else {
                iBinder = this.f7412p.asBinder();
            }
        }
        return iBinder;
    }

    @NonNull
    protected abstract String mo3336i();

    @NonNull
    protected abstract String mo3337j();

    @Nullable
    protected final String m7986m() {
        return this.f7420x == null ? this.f7406j.getClass().getName() : this.f7420x;
    }

    public void m7987n() {
        int a = this.f7409m.mo3314a(this.f7406j);
        if (a != 0) {
            m7956a(1, null);
            m7973a(new C2535i(this), a, null);
            return;
        }
        m7972a(new C2535i(this));
    }

    public final Context m7988o() {
        return this.f7406j;
    }

    public Account mo3332p() {
        return null;
    }

    public zzc[] mo3333q() {
        return new zzc[0];
    }

    public final Account m7991r() {
        return mo3332p() != null ? mo3332p() : new Account("<<default account>>", "com.google");
    }

    protected Bundle mo3586s() {
        return new Bundle();
    }

    protected final void m7993t() {
        if (!m7977b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle m7994u() {
        return null;
    }

    public final T m7995v() {
        T t;
        synchronized (this.f7410n) {
            if (this.f7416t == 4) {
                throw new DeadObjectException();
            }
            m7993t();
            C2513c.m7938a(this.f7413q != null, (Object) "Client is connected but service is null");
            t = this.f7413q;
        }
        return t;
    }

    public boolean m7996w() {
        return false;
    }

    protected Set<Scope> mo3334x() {
        return Collections.EMPTY_SET;
    }
}
