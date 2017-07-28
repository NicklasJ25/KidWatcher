package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.C2489m;
import java.util.concurrent.Callable;

@TargetApi(17)
@wh
public class aaa {
    private static aaa f7612b = null;
    String f7613a;

    private aaa() {
    }

    public static aaa m8384a() {
        if (f7612b == null) {
            f7612b = new aaa();
        }
        return f7612b;
    }

    public void m8385a(final Context context) {
        if (TextUtils.isEmpty(this.f7613a)) {
            final Context g = C2489m.m7870g(context);
            this.f7613a = (String) zz.m15285a(new Callable<String>(this) {
                public String m8383a() {
                    SharedPreferences sharedPreferences;
                    int i = 1;
                    if (g != null) {
                        zh.m15051a("Attempting to read user agent from Google Play Services.");
                        sharedPreferences = g.getSharedPreferences("admob_user_agent", 1);
                        i = 0;
                    } else {
                        zh.m15051a("Attempting to read user agent from local cache.");
                        sharedPreferences = context.getSharedPreferences("admob_user_agent", 0);
                    }
                    String string = sharedPreferences.getString("user_agent", "");
                    if (TextUtils.isEmpty(string)) {
                        zh.m15051a("Reading user agent from WebSettings");
                        string = WebSettings.getDefaultUserAgent(context);
                        if (i != 0) {
                            context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", string).apply();
                            zh.m15051a("Persisting user agent.");
                        }
                    }
                    return string;
                }

                public /* synthetic */ Object call() {
                    return m8383a();
                }
            });
        }
    }

    public void m8386b(Context context) {
        zh.m15051a("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(this.f7613a)) {
            if (C2489m.m7870g(context) == null) {
                context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context)).apply();
            }
            this.f7613a = defaultUserAgent;
        }
        zh.m15051a("User agent is updated.");
    }

    public String m8387c(Context context) {
        m8385a(context);
        return this.f7613a;
    }
}
