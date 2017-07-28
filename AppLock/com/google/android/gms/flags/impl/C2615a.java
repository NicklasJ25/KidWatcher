package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.cb;
import java.util.concurrent.Callable;

public abstract class C2615a<T> {

    public static class C2616a extends C2615a<Boolean> {

        class C26141 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences f7590a;
            final /* synthetic */ String f7591b;
            final /* synthetic */ Boolean f7592c;

            C26141(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.f7590a = sharedPreferences;
                this.f7591b = str;
                this.f7592c = bool;
            }

            public Boolean m8364a() {
                return Boolean.valueOf(this.f7590a.getBoolean(this.f7591b, this.f7592c.booleanValue()));
            }

            public /* synthetic */ Object call() {
                return m8364a();
            }
        }

        public static Boolean m8365a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) cb.m9280a(new C26141(sharedPreferences, str, bool));
        }
    }

    public static class C2618b extends C2615a<Integer> {

        class C26171 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences f7593a;
            final /* synthetic */ String f7594b;
            final /* synthetic */ Integer f7595c;

            C26171(SharedPreferences sharedPreferences, String str, Integer num) {
                this.f7593a = sharedPreferences;
                this.f7594b = str;
                this.f7595c = num;
            }

            public Integer m8366a() {
                return Integer.valueOf(this.f7593a.getInt(this.f7594b, this.f7595c.intValue()));
            }

            public /* synthetic */ Object call() {
                return m8366a();
            }
        }

        public static Integer m8367a(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) cb.m9280a(new C26171(sharedPreferences, str, num));
        }
    }

    public static class C2620c extends C2615a<Long> {

        class C26191 implements Callable<Long> {
            final /* synthetic */ SharedPreferences f7596a;
            final /* synthetic */ String f7597b;
            final /* synthetic */ Long f7598c;

            C26191(SharedPreferences sharedPreferences, String str, Long l) {
                this.f7596a = sharedPreferences;
                this.f7597b = str;
                this.f7598c = l;
            }

            public Long m8368a() {
                return Long.valueOf(this.f7596a.getLong(this.f7597b, this.f7598c.longValue()));
            }

            public /* synthetic */ Object call() {
                return m8368a();
            }
        }

        public static Long m8369a(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) cb.m9280a(new C26191(sharedPreferences, str, l));
        }
    }

    public static class C2622d extends C2615a<String> {

        class C26211 implements Callable<String> {
            final /* synthetic */ SharedPreferences f7599a;
            final /* synthetic */ String f7600b;
            final /* synthetic */ String f7601c;

            C26211(SharedPreferences sharedPreferences, String str, String str2) {
                this.f7599a = sharedPreferences;
                this.f7600b = str;
                this.f7601c = str2;
            }

            public String m8370a() {
                return this.f7599a.getString(this.f7600b, this.f7601c);
            }

            public /* synthetic */ Object call() {
                return m8370a();
            }
        }

        public static String m8371a(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) cb.m9280a(new C26211(sharedPreferences, str, str2));
        }
    }
}
