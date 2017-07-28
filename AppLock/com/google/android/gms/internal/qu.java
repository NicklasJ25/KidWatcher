package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.internal.qz.C3181b;
import com.google.android.gms.internal.rj.C3182a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.List;

@wh
public class qu extends C3182a implements C3181b {
    private String f10386a;
    private List<qs> f10387b;
    private String f10388c;
    private rd f10389d;
    private String f10390e;
    private String f10391f;
    @Nullable
    private qq f10392g;
    private Bundle f10393h;
    @Nullable
    private pb f10394i;
    @Nullable
    private View f10395j;
    private Object f10396k = new Object();
    private qz f10397l;

    public qu(String str, List list, String str2, rd rdVar, String str3, String str4, @Nullable qq qqVar, Bundle bundle, pb pbVar, View view) {
        this.f10386a = str;
        this.f10387b = list;
        this.f10388c = str2;
        this.f10389d = rdVar;
        this.f10390e = str3;
        this.f10391f = str4;
        this.f10392g = qqVar;
        this.f10393h = bundle;
        this.f10394i = pbVar;
        this.f10395j = view;
    }

    public String mo3939a() {
        return this.f10386a;
    }

    public void mo3923a(qz qzVar) {
        synchronized (this.f10396k) {
            this.f10397l = qzVar;
        }
    }

    public List mo3924b() {
        return this.f10387b;
    }

    public String mo3940c() {
        return this.f10388c;
    }

    public rd mo3941d() {
        return this.f10389d;
    }

    public String mo3942e() {
        return this.f10390e;
    }

    public String mo3943f() {
        return this.f10391f;
    }

    public pb mo3944g() {
        return this.f10394i;
    }

    public C2309a mo3945h() {
        return C2312b.m7327a(this.f10397l);
    }

    public Bundle mo3946i() {
        return this.f10393h;
    }

    public void mo3947j() {
        this.f10386a = null;
        this.f10387b = null;
        this.f10388c = null;
        this.f10389d = null;
        this.f10390e = null;
        this.f10391f = null;
        this.f10392g = null;
        this.f10393h = null;
        this.f10396k = null;
        this.f10397l = null;
        this.f10394i = null;
        this.f10395j = null;
    }

    public String mo3933k() {
        return "1";
    }

    public String mo3934l() {
        return "";
    }

    public qq mo3935m() {
        return this.f10392g;
    }

    public View mo3937o() {
        return this.f10395j;
    }
}
