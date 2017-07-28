package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.abq.C2669b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class aby implements C2669b {
    static Boolean f7877a = null;
    private static final Charset f7878c = Charset.forName("UTF-8");
    final C2681a f7879b;

    static class C2681a {
        final ContentResolver f7873a;

        C2681a(Context context) {
            if (context == null || !C2681a.m8913a(context)) {
                this.f7873a = null;
                return;
            }
            this.f7873a = context.getContentResolver();
            fi.m10769b(this.f7873a, "gms:playlog:service:sampling_");
        }

        private static boolean m8913a(Context context) {
            if (aby.f7877a == null) {
                aby.f7877a = Boolean.valueOf(bm.m9120b(context).m9112a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
            }
            return aby.f7877a.booleanValue();
        }

        long m8914a() {
            return this.f7873a == null ? 0 : fi.m10761a(this.f7873a, "android_id", 0);
        }

        String m8915a(String str) {
            if (this.f7873a == null) {
                return null;
            }
            ContentResolver contentResolver = this.f7873a;
            String valueOf = String.valueOf("gms:playlog:service:sampling_");
            String valueOf2 = String.valueOf(str);
            return fi.m10763a(contentResolver, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), null);
        }
    }

    static class C2682b {
        public final String f7874a;
        public final long f7875b;
        public final long f7876c;

        public C2682b(String str, long j, long j2) {
            this.f7874a = str;
            this.f7875b = j;
            this.f7876c = j2;
        }
    }

    public aby() {
        this(new C2681a(null));
    }

    public aby(Context context) {
        this(new C2681a(context));
    }

    aby(C2681a c2681a) {
        this.f7879b = (C2681a) C2513c.m7932a((Object) c2681a);
    }

    static long m8916a(long j) {
        return abv.m8890a(ByteBuffer.allocate(8).putLong(j).array());
    }

    static long m8917a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return m8916a(j);
        }
        byte[] bytes = str.getBytes(f7878c);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return abv.m8890a(allocate.array());
    }

    static C2682b m8918a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String str2 = "";
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            String str3 = "Failed to parse the rule: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new C2682b(str2, parseLong, parseLong2);
            }
            Log.e("LogSamplerImpl", "negative values not supported: " + parseLong + "/" + parseLong2);
            return null;
        } catch (Throwable e) {
            Throwable th = e;
            str3 = "LogSamplerImpl";
            String str4 = "parseLong() failed while parsing: ";
            valueOf = String.valueOf(str);
            Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
            return null;
        }
    }

    static boolean m8919a(long j, long j2, long j3) {
        if (j2 >= 0 && j3 >= 0) {
            return j3 > 0 && aca.m8933a(j, j3) < j2;
        } else {
            throw new IllegalArgumentException("negative values not supported: " + j2 + "/" + j3);
        }
    }

    public boolean mo3483a(String str, int i) {
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        long a = this.f7879b.m8914a();
        C2682b a2 = m8918a(this.f7879b.m8915a(str));
        return a2 != null ? m8919a(m8917a(a2.f7874a, a), a2.f7875b, a2.f7876c) : true;
    }
}
