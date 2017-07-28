package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.C2579d;
import java.util.Collections;
import java.util.List;

public class C2574a {
    private static final Object f7551a = new Object();
    private static C2574a f7552b;
    private final List<String> f7553c = Collections.EMPTY_LIST;
    private final List<String> f7554d = Collections.EMPTY_LIST;
    private final List<String> f7555e = Collections.EMPTY_LIST;
    private final List<String> f7556f = Collections.EMPTY_LIST;

    private C2574a() {
    }

    public static C2574a m8252a() {
        synchronized (f7551a) {
            if (f7552b == null) {
                f7552b = new C2574a();
            }
        }
        return f7552b;
    }

    private boolean m8253a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : C2579d.m8272a(context, component.getPackageName());
    }

    @SuppressLint({"UntrackedBindService"})
    public void m8254a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void m8255a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    public boolean m8256a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m8257a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m8257a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (!m8253a(context, intent)) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public void m8258b(Context context, ServiceConnection serviceConnection) {
    }
}
