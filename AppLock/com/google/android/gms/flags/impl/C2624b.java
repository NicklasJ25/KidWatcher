package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.cb;
import java.util.concurrent.Callable;

public class C2624b {
    private static SharedPreferences f7603a = null;

    class C26231 implements Callable<SharedPreferences> {
        final /* synthetic */ Context f7602a;

        C26231(Context context) {
            this.f7602a = context;
        }

        public SharedPreferences m8372a() {
            return this.f7602a.getSharedPreferences("google_sdk_flags", 1);
        }

        public /* synthetic */ Object call() {
            return m8372a();
        }
    }

    public static SharedPreferences m8373a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f7603a == null) {
                f7603a = (SharedPreferences) cb.m9280a(new C26231(context));
            }
            sharedPreferences = f7603a;
        }
        return sharedPreferences;
    }
}
