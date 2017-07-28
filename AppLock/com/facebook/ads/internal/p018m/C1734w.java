package com.facebook.ads.internal.p018m;

import java.util.HashMap;
import java.util.Map;

public class C1734w {
    public final String f4372a;
    public final long f4373b;
    public final long f4374c;
    public final long f4375d;
    public final long f4376e;
    public final long f4377f;
    public final long f4378g;
    public final long f4379h;

    public static class C1733a {
        private final String f4364a;
        private long f4365b = -1;
        private long f4366c = -1;
        private long f4367d = -1;
        private long f4368e = -1;
        private long f4369f = -1;
        private long f4370g = -1;
        private long f4371h = -1;

        public C1733a(String str) {
            this.f4364a = str;
        }

        public C1733a m4984a(long j) {
            this.f4365b = j;
            return this;
        }

        public C1734w m4985a() {
            return new C1734w(this.f4364a, this.f4365b, this.f4366c, this.f4367d, this.f4368e, this.f4369f, this.f4370g, this.f4371h);
        }

        public C1733a m4986b(long j) {
            this.f4366c = j;
            return this;
        }

        public C1733a m4987c(long j) {
            this.f4367d = j;
            return this;
        }

        public C1733a m4988d(long j) {
            this.f4368e = j;
            return this;
        }

        public C1733a m4989e(long j) {
            this.f4369f = j;
            return this;
        }

        public C1733a m4990f(long j) {
            this.f4370g = j;
            return this;
        }

        public C1733a m4991g(long j) {
            this.f4371h = j;
            return this;
        }
    }

    private C1734w(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.f4372a = str;
        this.f4373b = j;
        this.f4374c = j2;
        this.f4375d = j3;
        this.f4376e = j4;
        this.f4377f = j5;
        this.f4378g = j6;
        this.f4379h = j7;
    }

    public Map<String, String> m4992a() {
        Map<String, String> hashMap = new HashMap(7);
        hashMap.put("initial_url", this.f4372a);
        hashMap.put("handler_time_ms", String.valueOf(this.f4373b));
        hashMap.put("load_start_ms", String.valueOf(this.f4374c));
        hashMap.put("response_end_ms", String.valueOf(this.f4375d));
        hashMap.put("dom_content_loaded_ms", String.valueOf(this.f4376e));
        hashMap.put("scroll_ready_ms", String.valueOf(this.f4377f));
        hashMap.put("load_finish_ms", String.valueOf(this.f4378g));
        hashMap.put("session_finish_ms", String.valueOf(this.f4379h));
        return hashMap;
    }
}
