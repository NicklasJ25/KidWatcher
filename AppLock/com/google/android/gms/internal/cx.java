package com.google.android.gms.internal;

import com.android.gallery3d.data.MediaSet;
import com.google.android.gms.common.internal.C2513c;

public final class cx {
    public static C2753a<Long> f8296A = C2753a.m9661a("measurement.upload.realtime_upload_interval", 10000);
    public static C2753a<Long> f8297B = C2753a.m9661a("measurement.upload.debug_upload_interval", 1000);
    public static C2753a<Long> f8298C = C2753a.m9661a("measurement.upload.minimum_delay", 500);
    public static C2753a<Long> f8299D = C2753a.m9661a("measurement.alarm_manager.minimum_interval", 60000);
    public static C2753a<Long> f8300E = C2753a.m9661a("measurement.upload.stale_data_deletion_interval", 86400000);
    public static C2753a<Long> f8301F = C2753a.m9661a("measurement.upload.refresh_blacklisted_config_interval", 604800000);
    public static C2753a<Long> f8302G = C2753a.m9661a("measurement.upload.initial_upload_delay_time", 15000);
    public static C2753a<Long> f8303H = C2753a.m9661a("measurement.upload.retry_time", 1800000);
    public static C2753a<Integer> f8304I = C2753a.m9659a("measurement.upload.retry_count", 6);
    public static C2753a<Long> f8305J = C2753a.m9661a("measurement.upload.max_queue_time", 2419200000L);
    public static C2753a<Integer> f8306K = C2753a.m9659a("measurement.lifetimevalue.max_currency_tracked", 4);
    public static C2753a<Integer> f8307L = C2753a.m9659a("measurement.audience.filter_result_max_count", 200);
    public static C2753a<Long> f8308M = C2753a.m9661a("measurement.service_client.idle_disconnect_millis", 5000);
    public static C2753a<Boolean> f8309a = C2753a.m9665a("measurement.service_enabled", true);
    public static C2753a<Boolean> f8310b = C2753a.m9665a("measurement.service_client_enabled", true);
    public static C2753a<Boolean> f8311c = C2753a.m9665a("measurement.log_third_party_store_events_enabled", false);
    public static C2753a<Boolean> f8312d = C2753a.m9665a("measurement.log_installs_enabled", false);
    public static C2753a<Boolean> f8313e = C2753a.m9665a("measurement.log_upgrades_enabled", false);
    public static C2753a<Boolean> f8314f = C2753a.m9665a("measurement.log_androidId_enabled", false);
    public static C2753a<String> f8315g = C2753a.m9664a("measurement.log_tag", "FA", "FA-SVC");
    public static C2753a<Long> f8316h = C2753a.m9661a("measurement.ad_id_cache_time", 10000);
    public static C2753a<Long> f8317i = C2753a.m9661a("measurement.monitoring.sample_period_millis", 86400000);
    public static C2753a<Long> f8318j = C2753a.m9662a("measurement.config.cache_time", 86400000, 3600000);
    public static C2753a<String> f8319k = C2753a.m9663a("measurement.config.url_scheme", "https");
    public static C2753a<String> f8320l = C2753a.m9663a("measurement.config.url_authority", "app-measurement.com");
    public static C2753a<Integer> f8321m = C2753a.m9659a("measurement.upload.max_bundles", 100);
    public static C2753a<Integer> f8322n = C2753a.m9659a("measurement.upload.max_batch_size", 65536);
    public static C2753a<Integer> f8323o = C2753a.m9659a("measurement.upload.max_bundle_size", 65536);
    public static C2753a<Integer> f8324p = C2753a.m9659a("measurement.upload.max_events_per_bundle", 1000);
    public static C2753a<Integer> f8325q = C2753a.m9659a("measurement.upload.max_events_per_day", 100000);
    public static C2753a<Integer> f8326r = C2753a.m9659a("measurement.upload.max_error_events_per_day", 1000);
    public static C2753a<Integer> f8327s = C2753a.m9659a("measurement.upload.max_public_events_per_day", 50000);
    public static C2753a<Integer> f8328t = C2753a.m9659a("measurement.upload.max_conversions_per_day", (int) MediaSet.MEDIAITEM_BATCH_FETCH_COUNT);
    public static C2753a<Integer> f8329u = C2753a.m9659a("measurement.upload.max_realtime_events_per_day", 10);
    public static C2753a<Integer> f8330v = C2753a.m9659a("measurement.store.max_stored_events_per_app", 100000);
    public static C2753a<String> f8331w = C2753a.m9663a("measurement.upload.url", "https://app-measurement.com/a");
    public static C2753a<Long> f8332x = C2753a.m9661a("measurement.upload.backoff_period", 43200000);
    public static C2753a<Long> f8333y = C2753a.m9661a("measurement.upload.window_interval", 3600000);
    public static C2753a<Long> f8334z = C2753a.m9661a("measurement.upload.interval", 3600000);

    public static final class C2753a<V> {
        private final V f8293a;
        private final aw<V> f8294b;
        private final String f8295c;

        private C2753a(String str, aw<V> awVar, V v) {
            C2513c.m7932a((Object) awVar);
            this.f8294b = awVar;
            this.f8293a = v;
            this.f8295c = str;
        }

        static C2753a<Integer> m9659a(String str, int i) {
            return C2753a.m9660a(str, i, i);
        }

        static C2753a<Integer> m9660a(String str, int i, int i2) {
            return new C2753a(str, aw.m9073a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static C2753a<Long> m9661a(String str, long j) {
            return C2753a.m9662a(str, j, j);
        }

        static C2753a<Long> m9662a(String str, long j, long j2) {
            return new C2753a(str, aw.m9074a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static C2753a<String> m9663a(String str, String str2) {
            return C2753a.m9664a(str, str2, str2);
        }

        static C2753a<String> m9664a(String str, String str2, String str3) {
            return new C2753a(str, aw.m9075a(str, str3), str2);
        }

        static C2753a<Boolean> m9665a(String str, boolean z) {
            return C2753a.m9666a(str, z, z);
        }

        static C2753a<Boolean> m9666a(String str, boolean z, boolean z2) {
            return new C2753a(str, aw.m9076a(str, z2), Boolean.valueOf(z));
        }

        public V m9667a(V v) {
            return v != null ? v : this.f8293a;
        }

        public String m9668a() {
            return this.f8295c;
        }

        public V m9669b() {
            return this.f8293a;
        }
    }
}
