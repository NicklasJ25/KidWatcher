package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.C2605a;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.bz.C2613a;
import com.google.android.gms.p065a.C2312b;

public class by {
    private boolean f8173a = false;
    private bz f8174b = null;

    public <T> T m9252a(bw<T> bwVar) {
        synchronized (this) {
            if (this.f8173a) {
                return bwVar.mo3513a(this.f8174b);
            }
            T b = bwVar.m9239b();
            return b;
        }
    }

    public void m9253a(Context context) {
        Throwable e;
        synchronized (this) {
            if (this.f8173a) {
                return;
            }
            try {
                this.f8174b = C2613a.asInterface(DynamiteModule.m8341a(context, DynamiteModule.f7578e, ModuleDescriptor.MODULE_ID).m8353a("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.f8174b.init(C2312b.m7327a((Object) context));
                this.f8173a = true;
            } catch (C2605a e2) {
                e = e2;
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            } catch (RemoteException e3) {
                e = e3;
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            }
        }
    }
}
