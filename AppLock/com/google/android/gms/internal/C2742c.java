package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.internal.C2513c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C2742c extends C2741g {
    private final SparseArray<C2740a> f8186e = new SparseArray();

    private class C2740a implements C2460c {
        public final int f8176a;
        public final C2461c f8177b;
        public final C2460c f8178c;
        final /* synthetic */ C2742c f8179d;

        public C2740a(C2742c c2742c, int i, C2461c c2461c, C2460c c2460c) {
            this.f8179d = c2742c;
            this.f8176a = i;
            this.f8177b = c2461c;
            this.f8178c = c2460c;
            c2461c.mo3869a((C2460c) this);
        }

        public void m9254a() {
            this.f8177b.mo3872b((C2460c) this);
            this.f8177b.mo3873c();
        }

        public void mo3498a(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.f8179d.m9265b(connectionResult, this.f8176a);
        }

        public void m9256a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.f8176a);
            printWriter.println(":");
            this.f8177b.mo3870a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    private C2742c(af afVar) {
        super(afVar);
        this.d.mo3490a("AutoManageHelper", (ae) this);
    }

    public static C2742c m9268a(ad adVar) {
        af b = ae.m8955b(adVar);
        C2742c c2742c = (C2742c) b.mo3489a("AutoManageHelper", C2742c.class);
        return c2742c != null ? c2742c : new C2742c(b);
    }

    public void mo3514a() {
        super.mo3514a();
        boolean z = this.a;
        String valueOf = String.valueOf(this.f8186e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.b) {
            for (int i = 0; i < this.f8186e.size(); i++) {
                ((C2740a) this.f8186e.valueAt(i)).f8177b.mo3871b();
            }
        }
    }

    public void m9270a(int i) {
        C2740a c2740a = (C2740a) this.f8186e.get(i);
        this.f8186e.remove(i);
        if (c2740a != null) {
            c2740a.m9254a();
        }
    }

    public void m9271a(int i, C2461c c2461c, C2460c c2460c) {
        C2513c.m7933a((Object) c2461c, (Object) "GoogleApiClient instance cannot be null");
        C2513c.m7938a(this.f8186e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.a + " " + this.b);
        this.f8186e.put(i, new C2740a(this, i, c2461c, c2460c));
        if (this.a && !this.b) {
            String valueOf = String.valueOf(c2461c);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            c2461c.mo3871b();
        }
    }

    protected void mo3519a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C2740a c2740a = (C2740a) this.f8186e.get(i);
        if (c2740a != null) {
            m9270a(i);
            C2460c c2460c = c2740a.f8178c;
            if (c2460c != null) {
                c2460c.mo3498a(connectionResult);
            }
        }
    }

    public void mo3520a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f8186e.size(); i++) {
            ((C2740a) this.f8186e.valueAt(i)).m9256a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void mo3517b() {
        super.mo3517b();
        for (int i = 0; i < this.f8186e.size(); i++) {
            ((C2740a) this.f8186e.valueAt(i)).f8177b.mo3873c();
        }
    }

    protected void mo3521c() {
        for (int i = 0; i < this.f8186e.size(); i++) {
            ((C2740a) this.f8186e.valueAt(i)).f8177b.mo3871b();
        }
    }
}
