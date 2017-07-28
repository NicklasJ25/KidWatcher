package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.internal.ug.C3327a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.ArrayList;
import java.util.List;

@wh
public class ul extends C3327a {
    private final NativeContentAdMapper f10884a;

    public ul(NativeContentAdMapper nativeContentAdMapper) {
        this.f10884a = nativeContentAdMapper;
    }

    public String mo4102a() {
        return this.f10884a.getHeadline();
    }

    public void mo4103a(C2309a c2309a) {
        this.f10884a.handleClick((View) C2312b.m7328a(c2309a));
    }

    public List mo4104b() {
        List<Image> images = this.f10884a.getImages();
        if (images == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : images) {
            arrayList.add(new qs(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public void mo4105b(C2309a c2309a) {
        this.f10884a.trackView((View) C2312b.m7328a(c2309a));
    }

    public String mo4106c() {
        return this.f10884a.getBody();
    }

    public void mo4107c(C2309a c2309a) {
        this.f10884a.untrackView((View) C2312b.m7328a(c2309a));
    }

    public rd mo4108d() {
        Image logo = this.f10884a.getLogo();
        return logo != null ? new qs(logo.getDrawable(), logo.getUri(), logo.getScale()) : null;
    }

    public String mo4109e() {
        return this.f10884a.getCallToAction();
    }

    public String mo4110f() {
        return this.f10884a.getAdvertiser();
    }

    public void mo4111g() {
        this.f10884a.recordImpression();
    }

    public boolean mo4112h() {
        return this.f10884a.getOverrideImpressionRecording();
    }

    public boolean mo4113i() {
        return this.f10884a.getOverrideClickHandling();
    }

    public Bundle mo4114j() {
        return this.f10884a.getExtras();
    }

    public C2309a mo4115k() {
        Object adChoicesContent = this.f10884a.getAdChoicesContent();
        return adChoicesContent == null ? null : C2312b.m7327a(adChoicesContent);
    }

    public pb mo4116l() {
        return this.f10884a.getVideoController() != null ? this.f10884a.getVideoController().zzbs() : null;
    }
}
