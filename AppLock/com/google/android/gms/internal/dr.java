package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.stats.C2574a;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.internal.cy.C2755a;
import com.google.android.gms.measurement.AppMeasurement.C2803f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class dr extends dn {
    private final C2819a f8670a;
    private cy f8671b;
    private Boolean f8672c;
    private final cr f8673d;
    private final du f8674e;
    private final List<Runnable> f8675f = new ArrayList();
    private final cr f8676g;

    class C28106 implements Runnable {
        final /* synthetic */ dr f8654a;

        C28106(dr drVar) {
            this.f8654a = drVar;
        }

        public void run() {
            cy d = this.f8654a.f8671b;
            if (d == null) {
                this.f8654a.mo3548u().m9815x().m9774a("Discarding data. Failed to send app launch");
                return;
            }
            try {
                d.mo3558a(this.f8654a.mo3536i().m9707a(this.f8654a.mo3548u().m9787E()));
                this.f8654a.m10241a(d, null);
                this.f8654a.m10222D();
            } catch (RemoteException e) {
                this.f8654a.mo3548u().m9815x().m9775a("Failed to send app launch to the service", e);
            }
        }
    }

    class C28139 implements Runnable {
        final /* synthetic */ dr f8658a;

        C28139(dr drVar) {
            this.f8658a = drVar;
        }

        public void run() {
            cy d = this.f8658a.f8671b;
            if (d == null) {
                this.f8658a.mo3548u().m9815x().m9774a("Failed to send measurementEnabled to service");
                return;
            }
            try {
                d.mo3565b(this.f8658a.mo3536i().m9707a(this.f8658a.mo3548u().m9787E()));
                this.f8658a.m10222D();
            } catch (RemoteException e) {
                this.f8658a.mo3548u().m9815x().m9775a("Failed to send measurementEnabled to the service", e);
            }
        }
    }

    protected class C2819a implements ServiceConnection, C2527b, C2528c {
        final /* synthetic */ dr f8667a;
        private volatile boolean f8668b;
        private volatile db f8669c;

        class C28174 implements Runnable {
            final /* synthetic */ C2819a f8665a;

            C28174(C2819a c2819a) {
                this.f8665a = c2819a;
            }

            public void run() {
                dr drVar = this.f8665a.f8667a;
                Context n = this.f8665a.f8667a.mo3541n();
                this.f8665a.f8667a.mo3550w().m9490W();
                drVar.m10229a(new ComponentName(n, "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        class C28185 implements Runnable {
            final /* synthetic */ C2819a f8666a;

            C28185(C2819a c2819a) {
                this.f8666a = c2819a;
            }

            public void run() {
                this.f8666a.f8667a.f8671b = null;
                this.f8666a.f8667a.m10226H();
            }
        }

        protected C2819a(dr drVar) {
            this.f8667a = drVar;
        }

        @WorkerThread
        public void m10217a() {
            this.f8667a.mo3532e();
            Context n = this.f8667a.mo3541n();
            synchronized (this) {
                if (this.f8668b) {
                    this.f8667a.mo3548u().m9786D().m9774a("Connection attempt already in progress");
                } else if (this.f8669c != null) {
                    this.f8667a.mo3548u().m9786D().m9774a("Already awaiting connection attempt");
                } else {
                    this.f8669c = new db(n, Looper.getMainLooper(), this, this);
                    this.f8667a.mo3548u().m9786D().m9774a("Connecting to remote service");
                    this.f8668b = true;
                    this.f8669c.m7987n();
                }
            }
        }

        @MainThread
        public void mo3346a(int i) {
            C2513c.m7940b("MeasurementServiceConnection.onConnectionSuspended");
            this.f8667a.mo3548u().m9785C().m9774a("Service connection suspended");
            this.f8667a.mo3547t().m9938a(new C28174(this));
        }

        @WorkerThread
        public void m10219a(Intent intent) {
            this.f8667a.mo3532e();
            Context n = this.f8667a.mo3541n();
            C2574a a = C2574a.m8252a();
            synchronized (this) {
                if (this.f8668b) {
                    this.f8667a.mo3548u().m9786D().m9774a("Connection attempt already in progress");
                    return;
                }
                this.f8668b = true;
                a.m8256a(n, intent, this.f8667a.f8670a, 129);
            }
        }

        @MainThread
        public void mo3347a(@Nullable Bundle bundle) {
            C2513c.m7940b("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final cy cyVar = (cy) this.f8669c.m7995v();
                    this.f8669c = null;
                    this.f8667a.mo3547t().m9938a(new Runnable(this) {
                        final /* synthetic */ C2819a f8664b;

                        public void run() {
                            synchronized (this.f8664b) {
                                this.f8664b.f8668b = false;
                                if (!this.f8664b.f8667a.m10272x()) {
                                    this.f8664b.f8667a.mo3548u().m9785C().m9774a("Connected to remote service");
                                    this.f8664b.f8667a.m10240a(cyVar);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException e) {
                    this.f8669c = null;
                    this.f8668b = false;
                } catch (IllegalStateException e2) {
                    this.f8669c = null;
                    this.f8668b = false;
                }
            }
        }

        @MainThread
        public void mo3348a(@NonNull ConnectionResult connectionResult) {
            C2513c.m7940b("MeasurementServiceConnection.onConnectionFailed");
            dc g = this.f8667a.n.m10035g();
            if (g != null) {
                g.m9817z().m9775a("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.f8668b = false;
                this.f8669c = null;
            }
            this.f8667a.mo3547t().m9938a(new C28185(this));
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2513c.m7940b("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.f8668b = false;
                    this.f8667a.mo3548u().m9815x().m9774a("Service connected with null binder");
                    return;
                }
                cy cyVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        cyVar = C2755a.m9700a(iBinder);
                        this.f8667a.mo3548u().m9786D().m9774a("Bound to IMeasurementService interface");
                    } else {
                        this.f8667a.mo3548u().m9815x().m9775a("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.f8667a.mo3548u().m9815x().m9774a("Service connect failed to get IMeasurementService");
                }
                if (cyVar == null) {
                    this.f8668b = false;
                    try {
                        C2574a.m8252a().m8254a(this.f8667a.mo3541n(), this.f8667a.f8670a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.f8667a.mo3547t().m9938a(new Runnable(this) {
                        final /* synthetic */ C2819a f8660b;

                        public void run() {
                            synchronized (this.f8660b) {
                                this.f8660b.f8668b = false;
                                if (!this.f8660b.f8667a.m10272x()) {
                                    this.f8660b.f8667a.mo3548u().m9786D().m9774a("Connected to service");
                                    this.f8660b.f8667a.m10240a(cyVar);
                                }
                            }
                        }
                    });
                }
            }
        }

        @MainThread
        public void onServiceDisconnected(final ComponentName componentName) {
            C2513c.m7940b("MeasurementServiceConnection.onServiceDisconnected");
            this.f8667a.mo3548u().m9785C().m9774a("Service disconnected");
            this.f8667a.mo3547t().m9938a(new Runnable(this) {
                final /* synthetic */ C2819a f8662b;

                public void run() {
                    this.f8662b.f8667a.m10229a(componentName);
                }
            });
        }
    }

    protected dr(dk dkVar) {
        super(dkVar);
        this.f8674e = new du(dkVar.m10048t());
        this.f8670a = new C2819a(this);
        this.f8673d = new cr(this, dkVar) {
            final /* synthetic */ dr f8639a;

            public void mo3570a() {
                this.f8639a.m10224F();
            }
        };
        this.f8676g = new cr(this, dkVar) {
            final /* synthetic */ dr f8657a;

            public void mo3570a() {
                this.f8657a.mo3548u().m9817z().m9774a("Tasks have been queued for a long time");
            }
        };
    }

    @WorkerThread
    private void m10222D() {
        mo3532e();
        this.f8674e.m10323a();
        this.f8673d.m9618a(mo3550w().m9486S());
    }

    private boolean m10223E() {
        mo3550w().m9490W();
        List queryIntentServices = mo3541n().getPackageManager().queryIntentServices(new Intent().setClassName(mo3541n(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    @WorkerThread
    private void m10224F() {
        mo3532e();
        if (m10272x()) {
            mo3548u().m9786D().m9774a("Inactivity, disconnecting from the service");
            m10238C();
        }
    }

    @WorkerThread
    private void m10225G() {
        mo3532e();
        m10236A();
    }

    @WorkerThread
    private void m10226H() {
        mo3532e();
        mo3548u().m9786D().m9775a("Processing queued up service tasks", Integer.valueOf(this.f8675f.size()));
        for (Runnable a : this.f8675f) {
            mo3547t().m9938a(a);
        }
        this.f8675f.clear();
        this.f8676g.m9620c();
    }

    @WorkerThread
    private void m10229a(ComponentName componentName) {
        mo3532e();
        if (this.f8671b != null) {
            this.f8671b = null;
            mo3548u().m9786D().m9775a("Disconnected from device MeasurementService", componentName);
            m10225G();
        }
    }

    @WorkerThread
    private void m10231a(Runnable runnable) {
        mo3532e();
        if (m10272x()) {
            runnable.run();
        } else if (((long) this.f8675f.size()) >= mo3550w().ae()) {
            mo3548u().m9815x().m9774a("Discarding data. Max runnable queue size reached");
        } else {
            this.f8675f.add(runnable);
            this.f8676g.m9618a(60000);
            m10236A();
        }
    }

    @WorkerThread
    void m10236A() {
        mo3532e();
        m9448R();
        if (!m10272x()) {
            if (this.f8672c == null) {
                this.f8672c = mo3549v().m9872D();
                if (this.f8672c == null) {
                    mo3548u().m9786D().m9774a("State of service unknown");
                    this.f8672c = Boolean.valueOf(m10237B());
                    mo3549v().m9877a(this.f8672c.booleanValue());
                }
            }
            if (this.f8672c.booleanValue()) {
                mo3548u().m9786D().m9774a("Using measurement service");
                this.f8670a.m10217a();
            } else if (m10223E()) {
                mo3548u().m9786D().m9774a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context n = mo3541n();
                mo3550w().m9490W();
                intent.setComponent(new ComponentName(n, "com.google.android.gms.measurement.AppMeasurementService"));
                this.f8670a.m10219a(intent);
            } else {
                mo3548u().m9815x().m9774a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    @WorkerThread
    protected boolean m10237B() {
        mo3532e();
        m9448R();
        mo3550w().m9490W();
        mo3548u().m9786D().m9774a("Checking service availability");
        switch (C2480k.m7807b().mo3314a(mo3541n())) {
            case 0:
                mo3548u().m9786D().m9774a("Service available");
                return true;
            case 1:
                mo3548u().m9786D().m9774a("Service missing");
                return false;
            case 2:
                mo3548u().m9785C().m9774a("Service container out of date");
                return true;
            case 3:
                mo3548u().m9817z().m9774a("Service disabled");
                return false;
            case 9:
                mo3548u().m9817z().m9774a("Service invalid");
                return false;
            case 18:
                mo3548u().m9817z().m9774a("Service updating");
                return true;
            default:
                return false;
        }
    }

    @WorkerThread
    public void m10238C() {
        mo3532e();
        m9448R();
        try {
            C2574a.m8252a().m8254a(mo3541n(), this.f8670a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f8671b = null;
    }

    protected void mo3551a() {
    }

    @WorkerThread
    protected void m10240a(cy cyVar) {
        mo3532e();
        C2513c.m7932a((Object) cyVar);
        this.f8671b = cyVar;
        m10222D();
        m10226H();
    }

    @WorkerThread
    void m10241a(cy cyVar, zza com_google_android_gms_common_internal_safeparcel_zza) {
        mo3532e();
        mo3530c();
        m9448R();
        int i = VERSION.SDK_INT;
        mo3550w().m9490W();
        List<zza> arrayList = new ArrayList();
        mo3550w().ai();
        int i2 = 100;
        for (int i3 = 0; i3 < PointerIconCompat.TYPE_CONTEXT_MENU && r1 == 100; i3++) {
            Object a = mo3542o().m9740a(100);
            if (a != null) {
                arrayList.addAll(a);
                i2 = a.size();
            } else {
                i2 = 0;
            }
            if (com_google_android_gms_common_internal_safeparcel_zza != null && r1 < 100) {
                arrayList.add(com_google_android_gms_common_internal_safeparcel_zza);
            }
            for (zza com_google_android_gms_common_internal_safeparcel_zza2 : arrayList) {
                if (com_google_android_gms_common_internal_safeparcel_zza2 instanceof zzatq) {
                    try {
                        cyVar.mo3561a((zzatq) com_google_android_gms_common_internal_safeparcel_zza2, mo3536i().m9707a(mo3548u().m9787E()));
                    } catch (RemoteException e) {
                        mo3548u().m9815x().m9775a("Failed to send event to the service", e);
                    }
                } else if (com_google_android_gms_common_internal_safeparcel_zza2 instanceof zzauq) {
                    try {
                        cyVar.mo3563a((zzauq) com_google_android_gms_common_internal_safeparcel_zza2, mo3536i().m9707a(mo3548u().m9787E()));
                    } catch (RemoteException e2) {
                        mo3548u().m9815x().m9775a("Failed to send attribute to the service", e2);
                    }
                } else if (com_google_android_gms_common_internal_safeparcel_zza2 instanceof zzatg) {
                    try {
                        cyVar.mo3560a((zzatg) com_google_android_gms_common_internal_safeparcel_zza2, mo3536i().m9707a(mo3548u().m9787E()));
                    } catch (RemoteException e22) {
                        mo3548u().m9815x().m9775a("Failed to send conditional property to the service", e22);
                    }
                } else {
                    mo3548u().m9815x().m9774a("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    @WorkerThread
    protected void m10242a(zzatg com_google_android_gms_internal_zzatg) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        mo3532e();
        m9448R();
        mo3550w().m9490W();
        final boolean z = mo3542o().m9742a(com_google_android_gms_internal_zzatg);
        final zzatg com_google_android_gms_internal_zzatg2 = new zzatg(com_google_android_gms_internal_zzatg);
        final zzatg com_google_android_gms_internal_zzatg3 = com_google_android_gms_internal_zzatg;
        m10231a(new Runnable(this, true) {
            final /* synthetic */ dr f8633e;

            public void run() {
                cy d = this.f8633e.f8671b;
                if (d == null) {
                    this.f8633e.mo3548u().m9815x().m9774a("Discarding data. Failed to send conditional user property to service");
                    return;
                }
                if (true) {
                    this.f8633e.m10241a(d, z ? null : com_google_android_gms_internal_zzatg2);
                } else {
                    try {
                        if (TextUtils.isEmpty(com_google_android_gms_internal_zzatg3.f11812b)) {
                            d.mo3560a(com_google_android_gms_internal_zzatg2, this.f8633e.mo3536i().m9707a(this.f8633e.mo3548u().m9787E()));
                        } else {
                            d.mo3559a(com_google_android_gms_internal_zzatg2);
                        }
                    } catch (RemoteException e) {
                        this.f8633e.mo3548u().m9815x().m9775a("Failed to send conditional user property to the service", e);
                    }
                }
                this.f8633e.m10222D();
            }
        });
    }

    @WorkerThread
    protected void m10243a(zzatq com_google_android_gms_internal_zzatq, String str) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        mo3532e();
        m9448R();
        int i = VERSION.SDK_INT;
        mo3550w().m9490W();
        final boolean z = mo3542o().m9743a(com_google_android_gms_internal_zzatq);
        final zzatq com_google_android_gms_internal_zzatq2 = com_google_android_gms_internal_zzatq;
        final String str2 = str;
        m10231a(new Runnable(this, true) {
            final /* synthetic */ dr f8628e;

            public void run() {
                cy d = this.f8628e.f8671b;
                if (d == null) {
                    this.f8628e.mo3548u().m9815x().m9774a("Discarding data. Failed to send event to service");
                    return;
                }
                if (true) {
                    this.f8628e.m10241a(d, z ? null : com_google_android_gms_internal_zzatq2);
                } else {
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            d.mo3561a(com_google_android_gms_internal_zzatq2, this.f8628e.mo3536i().m9707a(this.f8628e.mo3548u().m9787E()));
                        } else {
                            d.mo3562a(com_google_android_gms_internal_zzatq2, str2, this.f8628e.mo3548u().m9787E());
                        }
                    } catch (RemoteException e) {
                        this.f8628e.mo3548u().m9815x().m9775a("Failed to send event to the service", e);
                    }
                }
                this.f8628e.m10222D();
            }
        });
    }

    @WorkerThread
    protected void m10244a(final zzauq com_google_android_gms_internal_zzauq) {
        mo3532e();
        m9448R();
        int i = VERSION.SDK_INT;
        mo3550w().m9490W();
        final boolean z = mo3542o().m9744a(com_google_android_gms_internal_zzauq);
        m10231a(new Runnable(this) {
            final /* synthetic */ dr f8648c;

            public void run() {
                cy d = this.f8648c.f8671b;
                if (d == null) {
                    this.f8648c.mo3548u().m9815x().m9774a("Discarding data. Failed to set user attribute");
                    return;
                }
                this.f8648c.m10241a(d, z ? null : com_google_android_gms_internal_zzauq);
                this.f8648c.m10222D();
            }
        });
    }

    @WorkerThread
    protected void m10245a(final C2803f c2803f) {
        mo3532e();
        m9448R();
        m10231a(new Runnable(this) {
            final /* synthetic */ dr f8656b;

            public void run() {
                cy d = this.f8656b.f8671b;
                if (d == null) {
                    this.f8656b.mo3548u().m9815x().m9774a("Failed to send current screen to service");
                    return;
                }
                try {
                    if (c2803f == null) {
                        d.mo3557a(0, null, null, this.f8656b.mo3541n().getPackageName());
                    } else {
                        d.mo3557a(c2803f.f8613d, c2803f.f8611b, c2803f.f8612c, this.f8656b.mo3541n().getPackageName());
                    }
                    this.f8656b.m10222D();
                } catch (RemoteException e) {
                    this.f8656b.mo3548u().m9815x().m9775a("Failed to send current screen to the service", e);
                }
            }
        });
    }

    @WorkerThread
    public void m10246a(final AtomicReference<String> atomicReference) {
        mo3532e();
        m9448R();
        m10231a(new Runnable(this) {
            final /* synthetic */ dr f8653b;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r5 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r5.f8653b;	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.f8671b;	 Catch:{ RemoteException -> 0x0044 }
                if (r0 != 0) goto L_0x0021;
            L_0x000b:
                r0 = r5.f8653b;	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.mo3548u();	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.m9815x();	 Catch:{ RemoteException -> 0x0044 }
                r2 = "Failed to get app instance id";
                r0.m9774a(r2);	 Catch:{ RemoteException -> 0x0044 }
                r0 = r2;	 Catch:{ all -> 0x0041 }
                r0.notify();	 Catch:{ all -> 0x0041 }
                monitor-exit(r1);	 Catch:{ all -> 0x0041 }
            L_0x0020:
                return;
            L_0x0021:
                r2 = r2;	 Catch:{ RemoteException -> 0x0044 }
                r3 = r5.f8653b;	 Catch:{ RemoteException -> 0x0044 }
                r3 = r3.mo3536i();	 Catch:{ RemoteException -> 0x0044 }
                r4 = 0;
                r3 = r3.m9707a(r4);	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.mo3566c(r3);	 Catch:{ RemoteException -> 0x0044 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0044 }
                r0 = r5.f8653b;	 Catch:{ RemoteException -> 0x0044 }
                r0.m10222D();	 Catch:{ RemoteException -> 0x0044 }
                r0 = r2;	 Catch:{ all -> 0x0041 }
                r0.notify();	 Catch:{ all -> 0x0041 }
            L_0x003f:
                monitor-exit(r1);	 Catch:{ all -> 0x0041 }
                goto L_0x0020;
            L_0x0041:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0041 }
                throw r0;
            L_0x0044:
                r0 = move-exception;
                r2 = r5.f8653b;	 Catch:{ all -> 0x005a }
                r2 = r2.mo3548u();	 Catch:{ all -> 0x005a }
                r2 = r2.m9815x();	 Catch:{ all -> 0x005a }
                r3 = "Failed to get app instance id";
                r2.m9775a(r3, r0);	 Catch:{ all -> 0x005a }
                r0 = r2;	 Catch:{ all -> 0x0041 }
                r0.notify();	 Catch:{ all -> 0x0041 }
                goto L_0x003f;
            L_0x005a:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x0041 }
                r2.notify();	 Catch:{ all -> 0x0041 }
                throw r0;	 Catch:{ all -> 0x0041 }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dr.5.run():void");
            }
        });
    }

    @WorkerThread
    protected void m10247a(AtomicReference<List<zzatg>> atomicReference, String str, String str2, String str3) {
        mo3532e();
        m9448R();
        final AtomicReference<List<zzatg>> atomicReference2 = atomicReference;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        m10231a(new Runnable(this) {
            final /* synthetic */ dr f8638e;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r7 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r7.f8638e;	 Catch:{ RemoteException -> 0x007c }
                r0 = r0.f8671b;	 Catch:{ RemoteException -> 0x007c }
                if (r0 != 0) goto L_0x0034;
            L_0x000b:
                r0 = r7.f8638e;	 Catch:{ RemoteException -> 0x007c }
                r0 = r0.mo3548u();	 Catch:{ RemoteException -> 0x007c }
                r0 = r0.m9815x();	 Catch:{ RemoteException -> 0x007c }
                r2 = "Failed to get conditional properties";
                r3 = r3;	 Catch:{ RemoteException -> 0x007c }
                r3 = com.google.android.gms.internal.dc.m9779a(r3);	 Catch:{ RemoteException -> 0x007c }
                r4 = r4;	 Catch:{ RemoteException -> 0x007c }
                r5 = r5;	 Catch:{ RemoteException -> 0x007c }
                r0.m9777a(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x007c }
                r0 = r2;	 Catch:{ RemoteException -> 0x007c }
                r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x007c }
                r0.set(r2);	 Catch:{ RemoteException -> 0x007c }
                r0 = r2;	 Catch:{ all -> 0x0069 }
                r0.notify();	 Catch:{ all -> 0x0069 }
                monitor-exit(r1);	 Catch:{ all -> 0x0069 }
            L_0x0033:
                return;
            L_0x0034:
                r2 = r3;	 Catch:{ RemoteException -> 0x007c }
                r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x007c }
                if (r2 == 0) goto L_0x006c;
            L_0x003c:
                r2 = r2;	 Catch:{ RemoteException -> 0x007c }
                r3 = r4;	 Catch:{ RemoteException -> 0x007c }
                r4 = r5;	 Catch:{ RemoteException -> 0x007c }
                r5 = r7.f8638e;	 Catch:{ RemoteException -> 0x007c }
                r5 = r5.mo3536i();	 Catch:{ RemoteException -> 0x007c }
                r6 = r7.f8638e;	 Catch:{ RemoteException -> 0x007c }
                r6 = r6.mo3548u();	 Catch:{ RemoteException -> 0x007c }
                r6 = r6.m9787E();	 Catch:{ RemoteException -> 0x007c }
                r5 = r5.m9707a(r6);	 Catch:{ RemoteException -> 0x007c }
                r0 = r0.mo3553a(r3, r4, r5);	 Catch:{ RemoteException -> 0x007c }
                r2.set(r0);	 Catch:{ RemoteException -> 0x007c }
            L_0x005d:
                r0 = r7.f8638e;	 Catch:{ RemoteException -> 0x007c }
                r0.m10222D();	 Catch:{ RemoteException -> 0x007c }
                r0 = r2;	 Catch:{ all -> 0x0069 }
                r0.notify();	 Catch:{ all -> 0x0069 }
            L_0x0067:
                monitor-exit(r1);	 Catch:{ all -> 0x0069 }
                goto L_0x0033;
            L_0x0069:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0069 }
                throw r0;
            L_0x006c:
                r2 = r2;	 Catch:{ RemoteException -> 0x007c }
                r3 = r3;	 Catch:{ RemoteException -> 0x007c }
                r4 = r4;	 Catch:{ RemoteException -> 0x007c }
                r5 = r5;	 Catch:{ RemoteException -> 0x007c }
                r0 = r0.mo3554a(r3, r4, r5);	 Catch:{ RemoteException -> 0x007c }
                r2.set(r0);	 Catch:{ RemoteException -> 0x007c }
                goto L_0x005d;
            L_0x007c:
                r0 = move-exception;
                r2 = r7.f8638e;	 Catch:{ all -> 0x00a3 }
                r2 = r2.mo3548u();	 Catch:{ all -> 0x00a3 }
                r2 = r2.m9815x();	 Catch:{ all -> 0x00a3 }
                r3 = "Failed to get conditional properties";
                r4 = r3;	 Catch:{ all -> 0x00a3 }
                r4 = com.google.android.gms.internal.dc.m9779a(r4);	 Catch:{ all -> 0x00a3 }
                r5 = r4;	 Catch:{ all -> 0x00a3 }
                r2.m9777a(r3, r4, r5, r0);	 Catch:{ all -> 0x00a3 }
                r0 = r2;	 Catch:{ all -> 0x00a3 }
                r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00a3 }
                r0.set(r2);	 Catch:{ all -> 0x00a3 }
                r0 = r2;	 Catch:{ all -> 0x0069 }
                r0.notify();	 Catch:{ all -> 0x0069 }
                goto L_0x0067;
            L_0x00a3:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x0069 }
                r2.notify();	 Catch:{ all -> 0x0069 }
                throw r0;	 Catch:{ all -> 0x0069 }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dr.12.run():void");
            }
        });
    }

    @WorkerThread
    protected void m10248a(AtomicReference<List<zzauq>> atomicReference, String str, String str2, String str3, boolean z) {
        mo3532e();
        m9448R();
        final AtomicReference<List<zzauq>> atomicReference2 = atomicReference;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z2 = z;
        m10231a(new Runnable(this) {
            final /* synthetic */ dr f8645f;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r8 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r8.f8645f;	 Catch:{ RemoteException -> 0x0080 }
                r0 = r0.f8671b;	 Catch:{ RemoteException -> 0x0080 }
                if (r0 != 0) goto L_0x0034;
            L_0x000b:
                r0 = r8.f8645f;	 Catch:{ RemoteException -> 0x0080 }
                r0 = r0.mo3548u();	 Catch:{ RemoteException -> 0x0080 }
                r0 = r0.m9815x();	 Catch:{ RemoteException -> 0x0080 }
                r2 = "Failed to get user properties";
                r3 = r3;	 Catch:{ RemoteException -> 0x0080 }
                r3 = com.google.android.gms.internal.dc.m9779a(r3);	 Catch:{ RemoteException -> 0x0080 }
                r4 = r4;	 Catch:{ RemoteException -> 0x0080 }
                r5 = r5;	 Catch:{ RemoteException -> 0x0080 }
                r0.m9777a(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x0080 }
                r0 = r2;	 Catch:{ RemoteException -> 0x0080 }
                r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x0080 }
                r0.set(r2);	 Catch:{ RemoteException -> 0x0080 }
                r0 = r2;	 Catch:{ all -> 0x006b }
                r0.notify();	 Catch:{ all -> 0x006b }
                monitor-exit(r1);	 Catch:{ all -> 0x006b }
            L_0x0033:
                return;
            L_0x0034:
                r2 = r3;	 Catch:{ RemoteException -> 0x0080 }
                r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x0080 }
                if (r2 == 0) goto L_0x006e;
            L_0x003c:
                r2 = r2;	 Catch:{ RemoteException -> 0x0080 }
                r3 = r4;	 Catch:{ RemoteException -> 0x0080 }
                r4 = r5;	 Catch:{ RemoteException -> 0x0080 }
                r5 = r6;	 Catch:{ RemoteException -> 0x0080 }
                r6 = r8.f8645f;	 Catch:{ RemoteException -> 0x0080 }
                r6 = r6.mo3536i();	 Catch:{ RemoteException -> 0x0080 }
                r7 = r8.f8645f;	 Catch:{ RemoteException -> 0x0080 }
                r7 = r7.mo3548u();	 Catch:{ RemoteException -> 0x0080 }
                r7 = r7.m9787E();	 Catch:{ RemoteException -> 0x0080 }
                r6 = r6.m9707a(r7);	 Catch:{ RemoteException -> 0x0080 }
                r0 = r0.mo3556a(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x0080 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0080 }
            L_0x005f:
                r0 = r8.f8645f;	 Catch:{ RemoteException -> 0x0080 }
                r0.m10222D();	 Catch:{ RemoteException -> 0x0080 }
                r0 = r2;	 Catch:{ all -> 0x006b }
                r0.notify();	 Catch:{ all -> 0x006b }
            L_0x0069:
                monitor-exit(r1);	 Catch:{ all -> 0x006b }
                goto L_0x0033;
            L_0x006b:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x006b }
                throw r0;
            L_0x006e:
                r2 = r2;	 Catch:{ RemoteException -> 0x0080 }
                r3 = r3;	 Catch:{ RemoteException -> 0x0080 }
                r4 = r4;	 Catch:{ RemoteException -> 0x0080 }
                r5 = r5;	 Catch:{ RemoteException -> 0x0080 }
                r6 = r6;	 Catch:{ RemoteException -> 0x0080 }
                r0 = r0.mo3555a(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x0080 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0080 }
                goto L_0x005f;
            L_0x0080:
                r0 = move-exception;
                r2 = r8.f8645f;	 Catch:{ all -> 0x00a7 }
                r2 = r2.mo3548u();	 Catch:{ all -> 0x00a7 }
                r2 = r2.m9815x();	 Catch:{ all -> 0x00a7 }
                r3 = "Failed to get user properties";
                r4 = r3;	 Catch:{ all -> 0x00a7 }
                r4 = com.google.android.gms.internal.dc.m9779a(r4);	 Catch:{ all -> 0x00a7 }
                r5 = r4;	 Catch:{ all -> 0x00a7 }
                r2.m9777a(r3, r4, r5, r0);	 Catch:{ all -> 0x00a7 }
                r0 = r2;	 Catch:{ all -> 0x00a7 }
                r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00a7 }
                r0.set(r2);	 Catch:{ all -> 0x00a7 }
                r0 = r2;	 Catch:{ all -> 0x006b }
                r0.notify();	 Catch:{ all -> 0x006b }
                goto L_0x0069;
            L_0x00a7:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x006b }
                r2.notify();	 Catch:{ all -> 0x006b }
                throw r0;	 Catch:{ all -> 0x006b }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dr.2.run():void");
            }
        });
    }

    @WorkerThread
    protected void m10249a(final AtomicReference<List<zzauq>> atomicReference, final boolean z) {
        mo3532e();
        m9448R();
        m10231a(new Runnable(this) {
            final /* synthetic */ dr f8651c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r5 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r5.f8651c;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.f8671b;	 Catch:{ RemoteException -> 0x0046 }
                if (r0 != 0) goto L_0x0021;
            L_0x000b:
                r0 = r5.f8651c;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.mo3548u();	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.m9815x();	 Catch:{ RemoteException -> 0x0046 }
                r2 = "Failed to get user properties";
                r0.m9774a(r2);	 Catch:{ RemoteException -> 0x0046 }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
            L_0x0020:
                return;
            L_0x0021:
                r2 = r2;	 Catch:{ RemoteException -> 0x0046 }
                r3 = r5.f8651c;	 Catch:{ RemoteException -> 0x0046 }
                r3 = r3.mo3536i();	 Catch:{ RemoteException -> 0x0046 }
                r4 = 0;
                r3 = r3.m9707a(r4);	 Catch:{ RemoteException -> 0x0046 }
                r4 = r3;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.mo3552a(r3, r4);	 Catch:{ RemoteException -> 0x0046 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0046 }
                r0 = r5.f8651c;	 Catch:{ RemoteException -> 0x0046 }
                r0.m10222D();	 Catch:{ RemoteException -> 0x0046 }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
            L_0x0041:
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                goto L_0x0020;
            L_0x0043:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                throw r0;
            L_0x0046:
                r0 = move-exception;
                r2 = r5.f8651c;	 Catch:{ all -> 0x005c }
                r2 = r2.mo3548u();	 Catch:{ all -> 0x005c }
                r2 = r2.m9815x();	 Catch:{ all -> 0x005c }
                r3 = "Failed to get user properties";
                r2.m9775a(r3, r0);	 Catch:{ all -> 0x005c }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
                goto L_0x0041;
            L_0x005c:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x0043 }
                r2.notify();	 Catch:{ all -> 0x0043 }
                throw r0;	 Catch:{ all -> 0x0043 }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dr.4.run():void");
            }
        });
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    @WorkerThread
    public boolean m10272x() {
        mo3532e();
        m9448R();
        return this.f8671b != null;
    }

    @WorkerThread
    protected void m10273y() {
        mo3532e();
        m9448R();
        m10231a(new C28139(this));
    }

    @WorkerThread
    protected void m10274z() {
        mo3532e();
        m9448R();
        m10231a(new C28106(this));
    }
}
