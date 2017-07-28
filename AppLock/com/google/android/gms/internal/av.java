package com.google.android.gms.internal;

import com.google.android.gms.internal.wx.C3415a;
import com.google.android.gms.internal.wx.C3416b;
import java.io.UnsupportedEncodingException;

public class av extends vb<String> {
    private final C3416b<String> f7960a;

    public av(int i, String str, C3416b<String> c3416b, C3415a c3415a) {
        super(i, str, c3415a);
        this.f7960a = c3416b;
    }

    protected wx<String> mo3502a(sz szVar) {
        Object str;
        try {
            str = new String(szVar.f10641b, abo.m8804a(szVar.f10642c));
        } catch (UnsupportedEncodingException e) {
            str = new String(szVar.f10641b);
        }
        return wx.m14581a(str, abo.m8803a(szVar));
    }

    protected /* synthetic */ void mo3503a(Object obj) {
        mo3504a((String) obj);
    }

    protected void mo3504a(String str) {
        this.f7960a.mo4271a(str);
    }
}
