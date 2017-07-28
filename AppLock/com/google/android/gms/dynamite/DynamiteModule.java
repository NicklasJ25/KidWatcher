package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamite.C2607a.C2609a;
import com.google.android.gms.dynamite.C2610b.C2612a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class DynamiteModule {
    public static final C2597b f7574a = new C25982();
    public static final C2597b f7575b = new C25993();
    public static final C2597b f7576c = new C26004();
    public static final C2597b f7577d = new C26015();
    public static final C2597b f7578e = new C26026();
    private static Boolean f7579f;
    private static C2607a f7580g;
    private static C2610b f7581h;
    private static final HashMap<String, byte[]> f7582i = new HashMap();
    private static String f7583j;
    private static final C2595a f7584k = new C25961();
    private final Context f7585l;

    class C25961 implements C2595a {
        C25961() {
        }

        public int mo3363a(Context context, String str) {
            return DynamiteModule.m8338a(context, str);
        }

        public int mo3364a(Context context, String str, boolean z) {
            return DynamiteModule.m8339a(context, str, z);
        }
    }

    public interface C2597b {

        public interface C2595a {
            int mo3363a(Context context, String str);

            int mo3364a(Context context, String str, boolean z);
        }

        public static class C2606b {
            public int f7571a = 0;
            public int f7572b = 0;
            public int f7573c = 0;
        }

        C2606b mo3365a(Context context, String str, C2595a c2595a);
    }

    class C25982 implements C2597b {
        C25982() {
        }

        public C2606b mo3365a(Context context, String str, C2595a c2595a) {
            C2606b c2606b = new C2606b();
            c2606b.f7572b = c2595a.mo3364a(context, str, true);
            if (c2606b.f7572b != 0) {
                c2606b.f7573c = 1;
            } else {
                c2606b.f7571a = c2595a.mo3363a(context, str);
                if (c2606b.f7571a != 0) {
                    c2606b.f7573c = -1;
                }
            }
            return c2606b;
        }
    }

    class C25993 implements C2597b {
        C25993() {
        }

        public C2606b mo3365a(Context context, String str, C2595a c2595a) {
            C2606b c2606b = new C2606b();
            c2606b.f7571a = c2595a.mo3363a(context, str);
            if (c2606b.f7571a != 0) {
                c2606b.f7573c = -1;
            } else {
                c2606b.f7572b = c2595a.mo3364a(context, str, true);
                if (c2606b.f7572b != 0) {
                    c2606b.f7573c = 1;
                }
            }
            return c2606b;
        }
    }

    class C26004 implements C2597b {
        C26004() {
        }

        public C2606b mo3365a(Context context, String str, C2595a c2595a) {
            C2606b c2606b = new C2606b();
            c2606b.f7571a = c2595a.mo3363a(context, str);
            c2606b.f7572b = c2595a.mo3364a(context, str, true);
            if (c2606b.f7571a == 0 && c2606b.f7572b == 0) {
                c2606b.f7573c = 0;
            } else if (c2606b.f7571a >= c2606b.f7572b) {
                c2606b.f7573c = -1;
            } else {
                c2606b.f7573c = 1;
            }
            return c2606b;
        }
    }

    class C26015 implements C2597b {
        C26015() {
        }

        public C2606b mo3365a(Context context, String str, C2595a c2595a) {
            C2606b c2606b = new C2606b();
            c2606b.f7571a = c2595a.mo3363a(context, str);
            c2606b.f7572b = c2595a.mo3364a(context, str, true);
            if (c2606b.f7571a == 0 && c2606b.f7572b == 0) {
                c2606b.f7573c = 0;
            } else if (c2606b.f7572b >= c2606b.f7571a) {
                c2606b.f7573c = 1;
            } else {
                c2606b.f7573c = -1;
            }
            return c2606b;
        }
    }

    class C26026 implements C2597b {
        C26026() {
        }

        public C2606b mo3365a(Context context, String str, C2595a c2595a) {
            C2606b c2606b = new C2606b();
            c2606b.f7571a = c2595a.mo3363a(context, str);
            if (c2606b.f7571a != 0) {
                c2606b.f7572b = c2595a.mo3364a(context, str, false);
            } else {
                c2606b.f7572b = c2595a.mo3364a(context, str, true);
            }
            if (c2606b.f7571a == 0 && c2606b.f7572b == 0) {
                c2606b.f7573c = 0;
            } else if (c2606b.f7572b >= c2606b.f7571a) {
                c2606b.f7573c = 1;
            } else {
                c2606b.f7573c = -1;
            }
            return c2606b;
        }
    }

    class C26037 implements C2595a {
        final /* synthetic */ int f7570a;

        C26037(int i) {
            this.f7570a = i;
        }

        public int mo3363a(Context context, String str) {
            return this.f7570a;
        }

        public int mo3364a(Context context, String str, boolean z) {
            return 0;
        }
    }

    class C26048 extends PathClassLoader {
        C26048(String str, ClassLoader classLoader) {
            super(str, classLoader);
        }

        protected Class<?> loadClass(String str, boolean z) {
            if (!(str.startsWith("java.") || str.startsWith("android."))) {
                try {
                    return findClass(str);
                } catch (ClassNotFoundException e) {
                }
            }
            return super.loadClass(str, z);
        }
    }

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class C2605a extends Exception {
        private C2605a(String str) {
            super(str);
        }

        private C2605a(String str, Throwable th) {
            super(str, th);
        }
    }

    private DynamiteModule(Context context) {
        this.f7585l = (Context) C2513c.m7932a((Object) context);
    }

    public static int m8338a(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int m8339a(Context context, String str, boolean z) {
        Object e;
        synchronized (DynamiteModule.class) {
            Boolean bool = f7579f;
            if (bool == null) {
                try {
                    Class loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                    Field declaredField = loadClass.getDeclaredField("sClassLoader");
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    m8344a(classLoader);
                                } catch (C2605a e2) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int d = m8351d(context, str, z);
                                if (f7583j == null || f7583j.isEmpty()) {
                                    return d;
                                }
                                ClassLoader b = m8348b();
                                m8344a(b);
                                declaredField.set(null, b);
                                f7579f = Boolean.TRUE;
                                return d;
                            } catch (C2605a e3) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                                f7579f = bool;
                                if (!bool.booleanValue()) {
                                    try {
                                    } catch (C2605a e4) {
                                        String str2 = "DynamiteModule";
                                        String str3 = "Failed to retrieve remote module version: ";
                                        String valueOf = String.valueOf(e4.getMessage());
                                        Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                } catch (ClassNotFoundException e5) {
                    e = e5;
                } catch (IllegalAccessException e6) {
                    e = e6;
                } catch (NoSuchFieldException e7) {
                    e = e7;
                }
            }
        }
        valueOf = String.valueOf(e);
        Log.w("DynamiteModule", new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to load module via V2: ").append(valueOf).toString());
        bool = Boolean.FALSE;
        f7579f = bool;
        return !bool.booleanValue() ? m8349c(context, str, z) : m8351d(context, str, z);
    }

    private static Context m8340a(Context context, String str, byte[] bArr, C2610b c2610b) {
        try {
            return (Context) C2312b.m7328a(c2610b.mo3369a(C2312b.m7327a((Object) context), str, bArr));
        } catch (Exception e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static DynamiteModule m8341a(Context context, C2597b c2597b, String str) {
        C2606b a = c2597b.mo3365a(context, str, f7584k);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(a.f7571a).append(" and remote module ").append(str).append(":").append(a.f7572b).toString());
        if (a.f7573c == 0 || ((a.f7573c == -1 && a.f7571a == 0) || (a.f7573c == 1 && a.f7572b == 0))) {
            throw new C2605a("No acceptable module found. Local version is " + a.f7571a + " and remote version is " + a.f7572b + ".");
        } else if (a.f7573c == -1) {
            return m8346b(context, str);
        } else {
            if (a.f7573c == 1) {
                try {
                    return m8342a(context, str, a.f7572b);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (a.f7571a != 0 && c2597b.mo3365a(context, str, new C26037(a.f7571a)).f7573c == -1) {
                        return m8346b(context, str);
                    }
                    throw new C2605a("Remote load failed. No local fallback found.", th);
                }
            }
            throw new C2605a("VersionPolicy returned invalid code:" + a.f7573c);
        }
    }

    private static DynamiteModule m8342a(Context context, String str, int i) {
        synchronized (DynamiteModule.class) {
            Boolean bool = f7579f;
        }
        if (bool != null) {
            return bool.booleanValue() ? m8350c(context, str, i) : m8347b(context, str, i);
        } else {
            throw new C2605a("Failed to determine which loading route to use.");
        }
    }

    private static C2607a m8343a(Context context) {
        synchronized (DynamiteModule.class) {
            C2607a c2607a;
            if (f7580g != null) {
                c2607a = f7580g;
                return c2607a;
            } else if (C2480k.m7807b().mo3314a(context) != 0) {
                return null;
            } else {
                try {
                    c2607a = C2609a.m8360a((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (c2607a != null) {
                        f7580g = c2607a;
                        return c2607a;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    private static void m8344a(ClassLoader classLoader) {
        Throwable e;
        try {
            f7581h = C2612a.m8363a((IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new C2605a("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new C2605a("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new C2605a("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new C2605a("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new C2605a("Failed to instantiate dynamite loader", e);
        }
    }

    public static Cursor m8345b(Context context, String str, boolean z) {
        String str2 = z ? "api_force_staging" : "api";
        String valueOf = String.valueOf("content://com.google.android.gms.chimera/");
        return context.getContentResolver().query(Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str2).length()) + String.valueOf(str).length()).append(valueOf).append(str2).append("/").append(str).toString()), null, null, null, null);
    }

    private static DynamiteModule m8346b(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule m8347b(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        C2607a a = m8343a(context);
        if (a == null) {
            throw new C2605a("Failed to create IDynamiteLoader.");
        }
        try {
            C2309a a2 = a.mo3368a(C2312b.m7327a((Object) context), str, i);
            if (C2312b.m7328a(a2) != null) {
                return new DynamiteModule((Context) C2312b.m7328a(a2));
            }
            throw new C2605a("Failed to load remote module.");
        } catch (Throwable e) {
            throw new C2605a("Failed to load remote module.", e);
        }
    }

    private static ClassLoader m8348b() {
        return new C26048(f7583j, ClassLoader.getSystemClassLoader());
    }

    private static int m8349c(Context context, String str, boolean z) {
        C2607a a = m8343a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.mo3367a(C2312b.m7327a((Object) context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    private static DynamiteModule m8350c(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            byte[] bArr = (byte[]) f7582i.get(new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(i).toString());
            C2610b c2610b = f7581h;
        }
        if (bArr == null) {
            throw new C2605a("Module implementation could not be found.");
        } else if (c2610b == null) {
            throw new C2605a("DynamiteLoaderV2 was not cached.");
        } else {
            Context a = m8340a(context.getApplicationContext(), str, bArr, c2610b);
            if (a != null) {
                return new DynamiteModule(a);
            }
            throw new C2605a("Failed to get module context");
        }
    }

    private static int m8351d(Context context, String str, boolean z) {
        Cursor cursor = null;
        try {
            cursor = m8345b(context, str, z);
            if (cursor == null || !cursor.moveToFirst()) {
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new C2605a("Failed to connect to dynamite module ContentResolver.");
            }
            int i = cursor.getInt(0);
            if (i > 0) {
                synchronized (DynamiteModule.class) {
                    f7582i.put(new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(i).toString(), Base64.decode(cursor.getString(3), 0));
                    f7583j = cursor.getString(2);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return i;
        } catch (Throwable e) {
            if (e instanceof C2605a) {
                throw e;
            }
            throw new C2605a("V2 version check failed", e);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public Context m8352a() {
        return this.f7585l;
    }

    public IBinder m8353a(String str) {
        Throwable e;
        String str2;
        String valueOf;
        try {
            return (IBinder) this.f7585l.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            throw new C2605a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new C2605a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new C2605a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        }
    }
}
