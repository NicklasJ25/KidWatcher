package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.common.util.C2591p;
import com.google.android.gms.internal.C2835e;
import com.google.android.gms.internal.C2835e.C2834a;
import com.google.android.gms.internal.lk;
import com.google.android.gms.internal.ll;
import com.google.android.gms.p004b.C2428e;
import com.google.android.gms.p004b.C2434h;
import com.google.firebase.p067a.C3527a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class C3531b {
    static final Map<String, C3531b> f12118a = new ArrayMap();
    private static final List<String> f12119b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> f12120c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> f12121d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> f12122e = Arrays.asList(new String[0]);
    private static final Set<String> f12123f = Collections.emptySet();
    private static final Object f12124g = new Object();
    private final Context f12125h;
    private final String f12126i;
    private final C3532d f12127j;
    private final AtomicBoolean f12128k = new AtomicBoolean(false);
    private final AtomicBoolean f12129l = new AtomicBoolean();
    private final List<C2869a> f12130m = new CopyOnWriteArrayList();
    private final List<C2873b> f12131n = new CopyOnWriteArrayList();
    private final List<Object> f12132o = new CopyOnWriteArrayList();
    private ll f12133p;

    public interface C2869a {
    }

    public interface C2873b {
        void mo3604a(boolean z);
    }

    class C35291 implements C2834a {
        C35291() {
        }

        public void mo4190a(boolean z) {
            C3531b.m15424a(z);
        }
    }

    @TargetApi(24)
    private static class C3530c extends BroadcastReceiver {
        private static AtomicReference<C3530c> f12116a = new AtomicReference();
        private final Context f12117b;

        public C3530c(Context context) {
            this.f12117b = context;
        }

        private static void m15416b(Context context) {
            if (f12116a.get() == null) {
                BroadcastReceiver c3530c = new C3530c(context);
                if (f12116a.compareAndSet(null, c3530c)) {
                    context.registerReceiver(c3530c, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void m15417a() {
            this.f12117b.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (C3531b.f12124g) {
                for (C3531b a : C3531b.f12118a.values()) {
                    a.m15430h();
                }
            }
            m15417a();
        }
    }

    protected C3531b(Context context, String str, C3532d c3532d) {
        this.f12125h = (Context) C2513c.m7932a((Object) context);
        this.f12126i = C2513c.m7934a(str);
        this.f12127j = (C3532d) C2513c.m7932a((Object) c3532d);
    }

    @Nullable
    public static C3531b m15418a(Context context) {
        C3531b d;
        synchronized (f12124g) {
            if (f12118a.containsKey("[DEFAULT]")) {
                d = C3531b.m15427d();
            } else {
                C3532d a = C3532d.m15448a(context);
                if (a == null) {
                    d = null;
                } else {
                    d = C3531b.m15419a(context, a);
                }
            }
        }
        return d;
    }

    public static C3531b m15419a(Context context, C3532d c3532d) {
        return C3531b.m15420a(context, c3532d, "[DEFAULT]");
    }

    public static C3531b m15420a(Context context, C3532d c3532d, String str) {
        Object c3531b;
        lk a = lk.m12322a(context);
        C3531b.m15425b(context);
        String a2 = C3531b.m15421a(str);
        if (context.getApplicationContext() != null) {
            Object applicationContext = context.getApplicationContext();
        }
        synchronized (f12124g) {
            C2513c.m7938a(!f12118a.containsKey(a2), new StringBuilder(String.valueOf(a2).length() + 33).append("FirebaseApp name ").append(a2).append(" already exists!").toString());
            C2513c.m7933a(applicationContext, (Object) "Application context cannot be null.");
            c3531b = new C3531b(applicationContext, a2, c3532d);
            f12118a.put(a2, c3531b);
        }
        a.m12323a((C3531b) c3531b);
        c3531b.m15423a(C3531b.class, c3531b, f12119b);
        if (c3531b.m15437e()) {
            c3531b.m15423a(C3531b.class, c3531b, f12120c);
            c3531b.m15423a(Context.class, c3531b.m15431a(), f12121d);
        }
        return c3531b;
    }

    private static String m15421a(@NonNull String str) {
        return str.trim();
    }

    private <T> void m15423a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.f12125h);
        if (isDeviceProtectedStorage) {
            C3530c.m15416b(this.f12125h);
        }
        for (String valueOf2 : iterable) {
            if (isDeviceProtectedStorage) {
                try {
                    if (!f12122e.contains(valueOf2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (f12123f.contains(valueOf2)) {
                        throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str = "FirebaseApp";
                    String str2 = "Failed to initialize ";
                    valueOf2 = String.valueOf(valueOf2);
                    Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
                }
            }
            Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    public static void m15424a(boolean z) {
        synchronized (f12124g) {
            Iterator it = new ArrayList(f12118a.values()).iterator();
            while (it.hasNext()) {
                C3531b c3531b = (C3531b) it.next();
                if (c3531b.f12128k.get()) {
                    c3531b.m15426c(z);
                }
            }
        }
    }

    @TargetApi(14)
    private static void m15425b(Context context) {
        C2590o.m8307b();
        if (context.getApplicationContext() instanceof Application) {
            C2835e.m10492a((Application) context.getApplicationContext());
            C2835e.m10491a().m10494a(new C35291());
        }
    }

    private void m15426c(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C2873b a : this.f12131n) {
            a.mo3604a(z);
        }
    }

    @Nullable
    public static C3531b m15427d() {
        C3531b c3531b;
        synchronized (f12124g) {
            c3531b = (C3531b) f12118a.get("[DEFAULT]");
            if (c3531b == null) {
                String valueOf = String.valueOf(C2591p.m8319a());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(valueOf).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return c3531b;
    }

    private void m15429g() {
        C2513c.m7938a(!this.f12129l.get(), (Object) "FirebaseApp was deleted");
    }

    private void m15430h() {
        m15423a(C3531b.class, (Object) this, f12119b);
        if (m15437e()) {
            m15423a(C3531b.class, (Object) this, f12120c);
            m15423a(Context.class, this.f12125h, f12121d);
        }
    }

    @NonNull
    public Context m15431a() {
        m15429g();
        return this.f12125h;
    }

    public void m15432a(@NonNull C2869a c2869a) {
        m15429g();
        C2513c.m7932a((Object) c2869a);
        this.f12130m.add(c2869a);
    }

    public void m15433a(C2873b c2873b) {
        m15429g();
        if (this.f12128k.get() && C2835e.m10491a().m10496b()) {
            c2873b.mo3604a(true);
        }
        this.f12131n.add(c2873b);
    }

    public C2428e<C3527a> m15434b(boolean z) {
        m15429g();
        return this.f12133p == null ? C2434h.m7683a(new C3528a("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.f12133p.m12324a(z);
    }

    @NonNull
    public String m15435b() {
        m15429g();
        return this.f12126i;
    }

    @NonNull
    public C3532d m15436c() {
        m15429g();
        return this.f12127j;
    }

    public boolean m15437e() {
        return "[DEFAULT]".equals(m15435b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C3531b) ? false : this.f12126i.equals(((C3531b) obj).m15435b());
    }

    public int hashCode() {
        return this.f12126i.hashCode();
    }

    public String toString() {
        return C2512b.m7930a((Object) this).m7928a("name", this.f12126i).m7928a("options", this.f12127j).toString();
    }
}
