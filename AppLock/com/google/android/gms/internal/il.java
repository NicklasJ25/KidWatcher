package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class il implements im {
    private boolean f9425a = false;

    private void m11707b() {
        lh.m12296a(this.f9425a, "Transaction expected to already be in progress.");
    }

    public iv mo3740a(je jeVar) {
        return new iv(jz.m12108a(jx.m12080j(), jeVar.m11871c()), false, false);
    }

    public <T> T mo3741a(Callable<T> callable) {
        lh.m12296a(!this.f9425a, "runInTransaction called when an existing transaction is already in progress.");
        this.f9425a = true;
        try {
            T call = callable.call();
            this.f9425a = false;
            return call;
        } catch (Throwable th) {
            this.f9425a = false;
        }
    }

    public List<hv> mo3742a() {
        return Collections.emptyList();
    }

    public void mo3743a(long j) {
        m11707b();
    }

    public void mo3744a(hh hhVar, gx gxVar) {
        m11707b();
    }

    public void mo3745a(hh hhVar, gx gxVar, long j) {
        m11707b();
    }

    public void mo3746a(hh hhVar, kf kfVar) {
        m11707b();
    }

    public void mo3747a(hh hhVar, kf kfVar, long j) {
        m11707b();
    }

    public void mo3748a(je jeVar, kf kfVar) {
        m11707b();
    }

    public void mo3749a(je jeVar, Set<js> set) {
        m11707b();
    }

    public void mo3750a(je jeVar, Set<js> set, Set<js> set2) {
        m11707b();
    }

    public void mo3751b(hh hhVar, gx gxVar) {
        m11707b();
    }

    public void mo3752b(je jeVar) {
        m11707b();
    }

    public void mo3753c(je jeVar) {
        m11707b();
    }

    public void mo3754d(je jeVar) {
        m11707b();
    }
}
