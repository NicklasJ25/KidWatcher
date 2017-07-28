package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class as extends Fragment implements af {
    private static WeakHashMap<FragmentActivity, WeakReference<as>> f7922a = new WeakHashMap();
    private Map<String, ae> f7923b = new ArrayMap();
    private int f7924c = 0;
    private Bundle f7925d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.as m9008a(android.support.v4.app.FragmentActivity r3) {
        /*
        r0 = f7922a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.internal.as) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getSupportFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.internal.as) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.internal.as;
        r0.<init>();
        r1 = r3.getSupportFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = f7922a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.as.a(android.support.v4.app.FragmentActivity):com.google.android.gms.internal.as");
    }

    private void m9010b(final String str, @NonNull final ae aeVar) {
        if (this.f7924c > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ as f7921c;

                public void run() {
                    if (this.f7921c.f7924c >= 1) {
                        aeVar.mo3516a(this.f7921c.f7925d != null ? this.f7921c.f7925d.getBundle(str) : null);
                    }
                    if (this.f7921c.f7924c >= 2) {
                        aeVar.mo3514a();
                    }
                    if (this.f7921c.f7924c >= 3) {
                        aeVar.mo3517b();
                    }
                    if (this.f7921c.f7924c >= 4) {
                        aeVar.m8963g();
                    }
                }
            });
        }
    }

    public /* synthetic */ Activity mo3488a() {
        return m9014b();
    }

    public <T extends ae> T mo3489a(String str, Class<T> cls) {
        return (ae) cls.cast(this.f7923b.get(str));
    }

    public void mo3490a(String str, @NonNull ae aeVar) {
        if (this.f7923b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f7923b.put(str, aeVar);
        m9010b(str, aeVar);
    }

    public FragmentActivity m9014b() {
        return getActivity();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (ae a : this.f7923b.values()) {
            a.mo3520a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (ae a : this.f7923b.values()) {
            a.mo3515a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7924c = 1;
        this.f7925d = bundle;
        for (Entry entry : this.f7923b.entrySet()) {
            ((ae) entry.getValue()).mo3516a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7924c = 4;
        for (ae g : this.f7923b.values()) {
            g.m8963g();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f7923b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((ae) entry.getValue()).mo3518b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.f7924c = 2;
        for (ae a : this.f7923b.values()) {
            a.mo3514a();
        }
    }

    public void onStop() {
        super.onStop();
        this.f7924c = 3;
        for (ae b : this.f7923b.values()) {
            b.mo3517b();
        }
    }
}
