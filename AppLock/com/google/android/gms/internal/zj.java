package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

@wh
public final class zj {

    public interface C3460b {
        void mo4246a(Bundle bundle);
    }

    private static abstract class C3462a extends zg {
        private C3462a() {
        }

        public void onStop() {
        }
    }

    class AnonymousClass10 extends C3462a {
        final /* synthetic */ Context f11623a;
        final /* synthetic */ C3460b f11624b;

        AnonymousClass10(Context context, C3460b c3460b) {
            this.f11623a = context;
            this.f11624b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11623a);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", a.getString("content_url_hashes", ""));
            if (this.f11624b != null) {
                this.f11624b.mo4246a(bundle);
            }
        }
    }

    class AnonymousClass11 extends C3462a {
        final /* synthetic */ Context f11625a;
        final /* synthetic */ String f11626b;

        AnonymousClass11(Context context, String str) {
            this.f11625a = context;
            this.f11626b = str;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11625a).edit();
            edit.putString("content_vertical_hashes", this.f11626b);
            edit.apply();
        }
    }

    class AnonymousClass12 extends C3462a {
        final /* synthetic */ Context f11627a;
        final /* synthetic */ boolean f11628b;

        AnonymousClass12(Context context, boolean z) {
            this.f11627a = context;
            this.f11628b = z;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11627a).edit();
            edit.putBoolean("auto_collect_location", this.f11628b);
            edit.apply();
        }
    }

    class AnonymousClass13 extends C3462a {
        final /* synthetic */ Context f11629a;
        final /* synthetic */ C3460b f11630b;

        AnonymousClass13(Context context, C3460b c3460b) {
            this.f11629a = context;
            this.f11630b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11629a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", a.getBoolean("auto_collect_location", false));
            if (this.f11630b != null) {
                this.f11630b.mo4246a(bundle);
            }
        }
    }

    class AnonymousClass14 extends C3462a {
        final /* synthetic */ Context f11631a;
        final /* synthetic */ String f11632b;
        final /* synthetic */ long f11633c;

        AnonymousClass14(Context context, String str, long j) {
            this.f11631a = context;
            this.f11632b = str;
            this.f11633c = j;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11631a).edit();
            edit.putString("app_settings_json", this.f11632b);
            edit.putLong("app_settings_last_update_ms", this.f11633c);
            edit.apply();
        }
    }

    class AnonymousClass15 extends C3462a {
        final /* synthetic */ Context f11634a;
        final /* synthetic */ C3460b f11635b;

        AnonymousClass15(Context context, C3460b c3460b) {
            this.f11634a = context;
            this.f11635b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11634a);
            Bundle bundle = new Bundle();
            bundle.putString("app_settings_json", a.getString("app_settings_json", ""));
            bundle.putLong("app_settings_last_update_ms", a.getLong("app_settings_last_update_ms", 0));
            if (this.f11635b != null) {
                this.f11635b.mo4246a(bundle);
            }
        }
    }

    class AnonymousClass16 extends C3462a {
        final /* synthetic */ Context f11636a;
        final /* synthetic */ long f11637b;

        AnonymousClass16(Context context, long j) {
            this.f11636a = context;
            this.f11637b = j;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11636a).edit();
            edit.putLong("app_last_background_time_ms", this.f11637b);
            edit.apply();
        }
    }

    class AnonymousClass17 extends C3462a {
        final /* synthetic */ Context f11638a;
        final /* synthetic */ C3460b f11639b;

        AnonymousClass17(Context context, C3460b c3460b) {
            this.f11638a = context;
            this.f11639b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11638a);
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", a.getLong("app_last_background_time_ms", 0));
            if (this.f11639b != null) {
                this.f11639b.mo4246a(bundle);
            }
        }
    }

    class AnonymousClass18 extends C3462a {
        final /* synthetic */ Context f11640a;
        final /* synthetic */ int f11641b;

        AnonymousClass18(Context context, int i) {
            this.f11640a = context;
            this.f11641b = i;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11640a).edit();
            edit.putInt("request_in_session_count", this.f11641b);
            edit.apply();
        }
    }

    class C34631 extends C3462a {
        final /* synthetic */ Context f11642a;
        final /* synthetic */ boolean f11643b;

        C34631(Context context, boolean z) {
            this.f11642a = context;
            this.f11643b = z;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11642a).edit();
            edit.putBoolean("use_https", this.f11643b);
            edit.apply();
        }
    }

    class C34642 extends C3462a {
        final /* synthetic */ Context f11644a;
        final /* synthetic */ C3460b f11645b;

        C34642(Context context, C3460b c3460b) {
            this.f11644a = context;
            this.f11645b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11644a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", a.getBoolean("use_https", true));
            if (this.f11645b != null) {
                this.f11645b.mo4246a(bundle);
            }
        }
    }

    class C34653 extends C3462a {
        final /* synthetic */ Context f11646a;
        final /* synthetic */ C3460b f11647b;

        C34653(Context context, C3460b c3460b) {
            this.f11646a = context;
            this.f11647b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11646a);
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", a.getInt("request_in_session_count", -1));
            if (this.f11647b != null) {
                this.f11647b.mo4246a(bundle);
            }
        }
    }

    class C34664 extends C3462a {
        final /* synthetic */ Context f11648a;
        final /* synthetic */ long f11649b;

        C34664(Context context, long j) {
            this.f11648a = context;
            this.f11649b = j;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11648a).edit();
            edit.putLong("first_ad_req_time_ms", this.f11649b);
            edit.apply();
        }
    }

    class C34675 extends C3462a {
        final /* synthetic */ Context f11650a;
        final /* synthetic */ C3460b f11651b;

        C34675(Context context, C3460b c3460b) {
            this.f11650a = context;
            this.f11651b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11650a);
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", a.getLong("first_ad_req_time_ms", 0));
            if (this.f11651b != null) {
                this.f11651b.mo4246a(bundle);
            }
        }
    }

    class C34686 extends C3462a {
        final /* synthetic */ Context f11652a;
        final /* synthetic */ C3460b f11653b;

        C34686(Context context, C3460b c3460b) {
            this.f11652a = context;
            this.f11653b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11652a);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", a.getInt("webview_cache_version", 0));
            if (this.f11653b != null) {
                this.f11653b.mo4246a(bundle);
            }
        }
    }

    class C34697 extends C3462a {
        final /* synthetic */ Context f11654a;
        final /* synthetic */ boolean f11655b;

        C34697(Context context, boolean z) {
            this.f11654a = context;
            this.f11655b = z;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11654a).edit();
            edit.putBoolean("content_url_opted_out", this.f11655b);
            edit.apply();
        }
    }

    class C34708 extends C3462a {
        final /* synthetic */ Context f11656a;
        final /* synthetic */ C3460b f11657b;

        C34708(Context context, C3460b c3460b) {
            this.f11656a = context;
            this.f11657b = c3460b;
            super();
        }

        public void zzco() {
            SharedPreferences a = zj.m15054a(this.f11656a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", a.getBoolean("content_url_opted_out", true));
            if (this.f11657b != null) {
                this.f11657b.mo4246a(bundle);
            }
        }
    }

    class C34719 extends C3462a {
        final /* synthetic */ Context f11658a;
        final /* synthetic */ String f11659b;

        C34719(Context context, String str) {
            this.f11658a = context;
            this.f11659b = str;
            super();
        }

        public void zzco() {
            Editor edit = zj.m15054a(this.f11658a).edit();
            edit.putString("content_url_hashes", this.f11659b);
            edit.apply();
        }
    }

    public static SharedPreferences m15054a(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future m15055a(Context context, int i) {
        return (Future) new AnonymousClass18(context, i).zziP();
    }

    public static Future m15056a(Context context, long j) {
        return (Future) new AnonymousClass16(context, j).zziP();
    }

    public static Future m15057a(Context context, C3460b c3460b) {
        return (Future) new C34642(context, c3460b).zziP();
    }

    public static Future m15058a(Context context, String str) {
        return (Future) new C34719(context, str).zziP();
    }

    public static Future m15059a(Context context, String str, long j) {
        return (Future) new AnonymousClass14(context, str, j).zziP();
    }

    public static Future m15060a(Context context, boolean z) {
        return (Future) new C34631(context, z).zziP();
    }

    public static Future m15061b(Context context, long j) {
        return (Future) new C34664(context, j).zziP();
    }

    public static Future m15062b(Context context, C3460b c3460b) {
        return (Future) new C34686(context, c3460b).zziP();
    }

    public static Future m15063b(Context context, String str) {
        return (Future) new AnonymousClass11(context, str).zziP();
    }

    public static Future m15064b(Context context, boolean z) {
        return (Future) new C34697(context, z).zziP();
    }

    public static Future m15065c(Context context, C3460b c3460b) {
        return (Future) new C34708(context, c3460b).zziP();
    }

    public static Future m15066c(Context context, boolean z) {
        return (Future) new AnonymousClass12(context, z).zziP();
    }

    public static void m15067c(Context context, String str) {
        SharedPreferences a = m15054a(context);
        Collection stringSet = a.getStringSet("never_pool_slots", Collections.emptySet());
        if (!stringSet.contains(str)) {
            Set hashSet = new HashSet(stringSet);
            hashSet.add(str);
            Editor edit = a.edit();
            edit.putStringSet("never_pool_slots", hashSet);
            edit.apply();
        }
    }

    public static Future m15068d(Context context, C3460b c3460b) {
        return (Future) new AnonymousClass10(context, c3460b).zziP();
    }

    public static void m15069d(Context context, String str) {
        SharedPreferences a = m15054a(context);
        Collection stringSet = a.getStringSet("never_pool_slots", Collections.emptySet());
        if (stringSet.contains(str)) {
            Set hashSet = new HashSet(stringSet);
            hashSet.remove(str);
            Editor edit = a.edit();
            edit.putStringSet("never_pool_slots", hashSet);
            edit.apply();
        }
    }

    public static Future m15070e(Context context, C3460b c3460b) {
        return (Future) new AnonymousClass13(context, c3460b).zziP();
    }

    public static boolean m15071e(Context context, String str) {
        return m15054a(context).getStringSet("never_pool_slots", Collections.emptySet()).contains(str);
    }

    public static Future m15072f(Context context, C3460b c3460b) {
        return (Future) new AnonymousClass15(context, c3460b).zziP();
    }

    public static Future m15073g(Context context, C3460b c3460b) {
        return (Future) new AnonymousClass17(context, c3460b).zziP();
    }

    public static Future m15074h(Context context, C3460b c3460b) {
        return (Future) new C34653(context, c3460b).zziP();
    }

    public static Future m15075i(Context context, C3460b c3460b) {
        return (Future) new C34675(context, c3460b).zziP();
    }
}
