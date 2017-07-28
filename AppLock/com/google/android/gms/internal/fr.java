package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.TimeUnit;

public final class fr {
    public static final bw<Boolean> f8935a = bw.m9233a(0, "crash:enabled", Boolean.valueOf(true));
    public static final bw<String> f8936b = bw.m9236a(0, "crash:gateway_url", "https://mobilecrashreporting.googleapis.com/v1/crashes:batchCreate?key=");
    public static final bw<Integer> f8937c = bw.m9234a(0, "crash:log_buffer_capacity", 100);
    public static final bw<Integer> f8938d = bw.m9234a(0, "crash:log_buffer_max_total_size", 32768);
    public static final bw<Integer> f8939e = bw.m9234a(0, "crash:crash_backlog_capacity", 5);
    public static final bw<Long> f8940f = bw.m9235a(0, "crash:crash_backlog_max_age", 604800000);
    public static final bw<Long> f8941g = bw.m9235a(0, "crash:starting_backoff", TimeUnit.SECONDS.toMillis(1));
    public static final bw<Long> f8942h = bw.m9235a(0, "crash:backoff_limit", TimeUnit.MINUTES.toMillis(60));
    public static final bw<Integer> f8943i = bw.m9234a(0, "crash:retry_num_attempts", 12);
    public static final bw<Integer> f8944j = bw.m9234a(0, "crash:batch_size", 5);
    public static final bw<Long> f8945k = bw.m9235a(0, "crash:batch_throttle", TimeUnit.MINUTES.toMillis(5));
    public static final bw<Integer> f8946l = bw.m9234a(0, "crash:frame_depth", 60);
    public static final bw<Integer> f8947m = bw.m9234a(0, "crash:receiver_delay", 100);
    public static final bw<Integer> f8948n = bw.m9234a(0, "crash:thread_idle_timeout", 10);

    public static final void m10797a(Context context) {
        ca.m9276a();
        bx.m9250a(context);
    }
}
