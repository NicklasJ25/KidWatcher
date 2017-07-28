package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.internal.qz.C3181b;
import com.google.android.gms.internal.rh.C3179a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.List;

@wh
public class qt extends C3179a implements C3181b {
    private String f10372a;
    private List<qs> f10373b;
    private String f10374c;
    private rd f10375d;
    private String f10376e;
    private double f10377f;
    private String f10378g;
    private String f10379h;
    @Nullable
    private qq f10380i;
    private Bundle f10381j;
    @Nullable
    private pb f10382k;
    @Nullable
    private View f10383l;
    private Object f10384m = new Object();
    private qz f10385n;

    public qt(String str, List list, String str2, rd rdVar, String str3, double d, String str4, String str5, @Nullable qq qqVar, Bundle bundle, pb pbVar, View view) {
        this.f10372a = str;
        this.f10373b = list;
        this.f10374c = str2;
        this.f10375d = rdVar;
        this.f10376e = str3;
        this.f10377f = d;
        this.f10378g = str4;
        this.f10379h = str5;
        this.f10380i = qqVar;
        this.f10381j = bundle;
        this.f10382k = pbVar;
        this.f10383l = view;
    }

    public String mo3922a() {
        return this.f10372a;
    }

    public void mo3923a(qz qzVar) {
        synchronized (this.f10384m) {
            this.f10385n = qzVar;
        }
    }

    public List mo3924b() {
        return this.f10373b;
    }

    public String mo3925c() {
        return this.f10374c;
    }

    public rd mo3926d() {
        return this.f10375d;
    }

    public String mo3927e() {
        return this.f10376e;
    }

    public double mo3928f() {
        return this.f10377f;
    }

    public String mo3929g() {
        return this.f10378g;
    }

    public String mo3930h() {
        return this.f10379h;
    }

    public pb mo3931i() {
        return this.f10382k;
    }

    public C2309a mo3932j() {
        return C2312b.m7327a(this.f10385n);
    }

    public String mo3933k() {
        return GpsMeasureMode.MODE_2_DIMENSIONAL;
    }

    public String mo3934l() {
        return "";
    }

    public qq mo3935m() {
        return this.f10380i;
    }

    public Bundle mo3936n() {
        return this.f10381j;
    }

    public View mo3937o() {
        return this.f10383l;
    }

    public void mo3938p() {
        this.f10372a = null;
        this.f10373b = null;
        this.f10374c = null;
        this.f10375d = null;
        this.f10376e = null;
        this.f10377f = 0.0d;
        this.f10378g = null;
        this.f10379h = null;
        this.f10380i = null;
        this.f10381j = null;
        this.f10384m = null;
        this.f10385n = null;
        this.f10382k = null;
        this.f10383l = null;
    }
}
