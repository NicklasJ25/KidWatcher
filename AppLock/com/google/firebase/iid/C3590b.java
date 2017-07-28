package com.google.firebase.iid;

import android.app.Service;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.stats.C2574a;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class C3590b extends Service {
    private Binder f12220a;
    private final Object f12221b = new Object();
    @VisibleForTesting
    final ExecutorService f12222c = Executors.newSingleThreadExecutor();
    private int f12223d;
    private int f12224e = 0;

    static class C3594a {
        final Intent f12233a;
        private final PendingResult f12234b;
        private boolean f12235c = false;
        private final ScheduledFuture<?> f12236d;

        C3594a(final Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
            this.f12233a = intent;
            this.f12234b = pendingResult;
            this.f12236d = scheduledExecutorService.schedule(new Runnable(this) {
                final /* synthetic */ C3594a f12232b;

                public void run() {
                    String valueOf = String.valueOf(intent.getAction());
                    Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 61).append("Service took too long to process intent: ").append(valueOf).append(" App may get closed.").toString());
                    this.f12232b.m15650a();
                }
            }, 9500, TimeUnit.MILLISECONDS);
        }

        synchronized void m15650a() {
            if (!this.f12235c) {
                this.f12234b.finish();
                this.f12236d.cancel(false);
                this.f12235c = true;
            }
        }
    }

    public static class C3596b extends Binder {
        private final C3590b f12239a;

        C3596b(C3590b c3590b) {
            this.f12239a = c3590b;
        }

        public void m15652a(final C3594a c3594a) {
            if (Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException("Binding only allowed within app");
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.f12239a.mo4311a(c3594a.f12233a)) {
                c3594a.m15650a();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f12239a.f12222c.execute(new Runnable(this) {
                final /* synthetic */ C3596b f12238b;

                public void run() {
                    if (Log.isLoggable("EnhancedIntentService", 3)) {
                        Log.d("EnhancedIntentService", "bg processing of the intent starting now");
                    }
                    this.f12238b.f12239a.mo4312b(c3594a.f12233a);
                    c3594a.m15650a();
                }
            });
        }
    }

    public static class C3597c implements ServiceConnection {
        private final Context f12240a;
        private final Intent f12241b;
        private final ScheduledExecutorService f12242c;
        private final Queue<C3594a> f12243d;
        private C3596b f12244e;
        private boolean f12245f;

        public C3597c(Context context, String str) {
            this(context, str, new ScheduledThreadPoolExecutor(0));
        }

        @VisibleForTesting
        C3597c(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            this.f12243d = new LinkedList();
            this.f12245f = false;
            this.f12240a = context.getApplicationContext();
            this.f12241b = new Intent(str).setPackage(this.f12240a.getPackageName());
            this.f12242c = scheduledExecutorService;
        }

        private synchronized void m15653a() {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "flush queue called");
            }
            while (!this.f12243d.isEmpty()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "found intent to be delivered");
                }
                if (this.f12244e == null || !this.f12244e.isBinderAlive()) {
                    if (Log.isLoggable("EnhancedIntentService", 3)) {
                        Log.d("EnhancedIntentService", "binder is dead. start connection? " + (!this.f12245f));
                    }
                    if (!this.f12245f) {
                        this.f12245f = true;
                        try {
                            if (!C2574a.m8252a().m8256a(this.f12240a, this.f12241b, (ServiceConnection) this, 65)) {
                                Log.e("EnhancedIntentService", "binding to the service failed");
                                while (!this.f12243d.isEmpty()) {
                                    ((C3594a) this.f12243d.poll()).m15650a();
                                }
                            }
                        } catch (Throwable e) {
                            Log.e("EnhancedIntentService", "Exception while binding the service", e);
                        }
                    }
                } else {
                    if (Log.isLoggable("EnhancedIntentService", 3)) {
                        Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                    }
                    this.f12244e.m15652a((C3594a) this.f12243d.poll());
                }
            }
        }

        public synchronized void m15654a(Intent intent, PendingResult pendingResult) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
            }
            this.f12243d.add(new C3594a(intent, pendingResult, this.f12242c));
            m15653a();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                this.f12245f = false;
                this.f12244e = (C3596b) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String valueOf = String.valueOf(componentName);
                    Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf).toString());
                }
                m15653a();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf).toString());
            }
            m15653a();
        }
    }

    private void mo4314d(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.f12221b) {
            this.f12224e--;
            if (this.f12224e == 0) {
                m15629b(this.f12223d);
            }
        }
    }

    public boolean mo4311a(Intent intent) {
        return false;
    }

    public abstract void mo4312b(Intent intent);

    boolean m15629b(int i) {
        return stopSelfResult(i);
    }

    protected Intent mo4313c(Intent intent) {
        return intent;
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f12220a == null) {
            this.f12220a = new C3596b(this);
        }
        return this.f12220a;
    }

    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.f12221b) {
            this.f12223d = i2;
            this.f12224e++;
        }
        final Intent c = mo4313c(intent);
        if (c == null) {
            mo4314d(intent);
            return 2;
        } else if (mo4311a(c)) {
            mo4314d(intent);
            return 2;
        } else {
            this.f12222c.execute(new Runnable(this) {
                final /* synthetic */ C3590b f12230c;

                public void run() {
                    this.f12230c.mo4312b(c);
                    this.f12230c.mo4314d(intent);
                }
            });
            return 3;
        }
    }
}
