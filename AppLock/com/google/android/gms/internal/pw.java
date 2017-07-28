package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzw;

@wh
public abstract class pw<T> {
    private final int f10243a;
    private final String f10244b;
    private final T f10245c;

    class C31571 extends pw<Boolean> {
        C31571(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        public /* synthetic */ Object mo3898a(SharedPreferences sharedPreferences) {
            return m13227b(sharedPreferences);
        }

        public Boolean m13227b(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(m13223a(), ((Boolean) m13224b()).booleanValue()));
        }
    }

    class C31582 extends pw<Integer> {
        C31582(int i, String str, Integer num) {
            super(i, str, num);
        }

        public /* synthetic */ Object mo3898a(SharedPreferences sharedPreferences) {
            return m13229b(sharedPreferences);
        }

        public Integer m13229b(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(m13223a(), ((Integer) m13224b()).intValue()));
        }
    }

    class C31593 extends pw<Long> {
        C31593(int i, String str, Long l) {
            super(i, str, l);
        }

        public /* synthetic */ Object mo3898a(SharedPreferences sharedPreferences) {
            return m13231b(sharedPreferences);
        }

        public Long m13231b(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(m13223a(), ((Long) m13224b()).longValue()));
        }
    }

    class C31604 extends pw<Float> {
        C31604(int i, String str, Float f) {
            super(i, str, f);
        }

        public /* synthetic */ Object mo3898a(SharedPreferences sharedPreferences) {
            return m13233b(sharedPreferences);
        }

        public Float m13233b(SharedPreferences sharedPreferences) {
            return Float.valueOf(sharedPreferences.getFloat(m13223a(), ((Float) m13224b()).floatValue()));
        }
    }

    class C31615 extends pw<String> {
        C31615(int i, String str, String str2) {
            super(i, str, str2);
        }

        public /* synthetic */ Object mo3898a(SharedPreferences sharedPreferences) {
            return m13235b(sharedPreferences);
        }

        public String m13235b(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(m13223a(), (String) m13224b());
        }
    }

    private pw(int i, String str, T t) {
        this.f10243a = i;
        this.f10244b = str;
        this.f10245c = t;
        zzw.zzcX().m13237a(this);
    }

    public static pw<String> m13215a(int i, String str) {
        pw<String> a = m13220a(i, str, null);
        zzw.zzcX().m13239b(a);
        return a;
    }

    public static pw<Float> m13216a(int i, String str, float f) {
        return new C31604(i, str, Float.valueOf(f));
    }

    public static pw<Integer> m13217a(int i, String str, int i2) {
        return new C31582(i, str, Integer.valueOf(i2));
    }

    public static pw<Long> m13218a(int i, String str, long j) {
        return new C31593(i, str, Long.valueOf(j));
    }

    public static pw<Boolean> m13219a(int i, String str, Boolean bool) {
        return new C31571(i, str, bool);
    }

    public static pw<String> m13220a(int i, String str, String str2) {
        return new C31615(i, str, str2);
    }

    public static pw<String> m13221b(int i, String str) {
        pw<String> a = m13220a(i, str, null);
        zzw.zzcX().m13240c(a);
        return a;
    }

    protected abstract T mo3898a(SharedPreferences sharedPreferences);

    public String m13223a() {
        return this.f10244b;
    }

    public T m13224b() {
        return this.f10245c;
    }

    public T m13225c() {
        return zzw.zzcY().m13264a(this);
    }
}
