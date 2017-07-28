package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;

@wh
public class qe {
    @Nullable
    public qd m13284a(@Nullable qc qcVar) {
        if (qcVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!qcVar.m13270a()) {
            zh.m15051a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (qcVar.m13272c() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(qcVar.m13273d())) {
            return new qd(qcVar.m13272c(), qcVar.m13273d(), qcVar.m13271b(), qcVar.m13274e());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
