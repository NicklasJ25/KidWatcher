package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C2513c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C2492h implements ServiceConnection {
    boolean f7352a = false;
    private final BlockingQueue<IBinder> f7353b = new LinkedBlockingQueue();

    public IBinder m7877a(long j, TimeUnit timeUnit) {
        C2513c.m7944c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f7352a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f7352a = true;
        IBinder iBinder = (IBinder) this.f7353b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7353b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
