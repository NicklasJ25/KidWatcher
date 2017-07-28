package com.google.android.gms.internal;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class gu {
    private final ScheduledExecutorService f9136a;
    private final jp f9137b;
    private final long f9138c;
    private final long f9139d;
    private final double f9140e;
    private final double f9141f;
    private final Random f9142g;
    private ScheduledFuture<?> f9143h;
    private long f9144i;
    private boolean f9145j;

    public static class C2924a {
        private final ScheduledExecutorService f9130a;
        private long f9131b = 1000;
        private double f9132c = 0.5d;
        private long f9133d = 30000;
        private double f9134e = 1.3d;
        private final jp f9135f;

        public C2924a(ScheduledExecutorService scheduledExecutorService, jq jqVar, String str) {
            this.f9130a = scheduledExecutorService;
            this.f9135f = new jp(jqVar, str);
        }

        public C2924a m11253a(double d) {
            this.f9134e = d;
            return this;
        }

        public C2924a m11254a(long j) {
            this.f9131b = j;
            return this;
        }

        public gu m11255a() {
            return new gu(this.f9130a, this.f9135f, this.f9131b, this.f9133d, this.f9134e, this.f9132c);
        }

        public C2924a m11256b(double d) {
            if (d < 0.0d || d > 1.0d) {
                throw new IllegalArgumentException("Argument out of range: " + d);
            }
            this.f9132c = d;
            return this;
        }

        public C2924a m11257b(long j) {
            this.f9133d = j;
            return this;
        }
    }

    private gu(ScheduledExecutorService scheduledExecutorService, jp jpVar, long j, long j2, double d, double d2) {
        this.f9142g = new Random();
        this.f9145j = true;
        this.f9136a = scheduledExecutorService;
        this.f9137b = jpVar;
        this.f9138c = j;
        this.f9139d = j2;
        this.f9141f = d;
        this.f9140e = d2;
    }

    public void m11259a() {
        this.f9145j = true;
        this.f9144i = 0;
    }

    public void m11260a(final Runnable runnable) {
        long j = 0;
        Runnable c29231 = new Runnable(this) {
            final /* synthetic */ gu f9129b;

            public void run() {
                this.f9129b.f9143h = null;
                runnable.run();
            }
        };
        if (this.f9143h != null) {
            this.f9137b.m11960a("Cancelling previous scheduled retry", new Object[0]);
            this.f9143h.cancel(false);
            this.f9143h = null;
        }
        if (!this.f9145j) {
            if (this.f9144i == 0) {
                this.f9144i = this.f9138c;
            } else {
                this.f9144i = Math.min((long) (((double) this.f9144i) * this.f9141f), this.f9139d);
            }
            j = (long) (((1.0d - this.f9140e) * ((double) this.f9144i)) + ((this.f9140e * ((double) this.f9144i)) * this.f9142g.nextDouble()));
        }
        this.f9145j = false;
        this.f9137b.m11960a("Scheduling retry in %dms", Long.valueOf(j));
        this.f9143h = this.f9136a.schedule(c29231, j, TimeUnit.MILLISECONDS);
    }

    public void m11261b() {
        this.f9144i = this.f9139d;
    }

    public void m11262c() {
        if (this.f9143h != null) {
            this.f9137b.m11960a("Cancelling existing retry attempt", new Object[0]);
            this.f9143h.cancel(false);
            this.f9143h = null;
        } else {
            this.f9137b.m11960a("No existing retry attempt to cancel", new Object[0]);
        }
        this.f9144i = 0;
    }
}
