package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.internal.uf.C3325a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.ArrayList;
import java.util.List;

@wh
public class uk extends C3325a {
    private final NativeAppInstallAdMapper f10883a;

    public uk(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f10883a = nativeAppInstallAdMapper;
    }

    public String mo4085a() {
        return this.f10883a.getHeadline();
    }

    public void mo4086a(C2309a c2309a) {
        this.f10883a.handleClick((View) C2312b.m7328a(c2309a));
    }

    public List mo4087b() {
        List<Image> images = this.f10883a.getImages();
        if (images == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : images) {
            arrayList.add(new qs(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public void mo4088b(C2309a c2309a) {
        this.f10883a.trackView((View) C2312b.m7328a(c2309a));
    }

    public String mo4089c() {
        return this.f10883a.getBody();
    }

    public void mo4090c(C2309a c2309a) {
        this.f10883a.untrackView((View) C2312b.m7328a(c2309a));
    }

    public rd mo4091d() {
        Image icon = this.f10883a.getIcon();
        return icon != null ? new qs(icon.getDrawable(), icon.getUri(), icon.getScale()) : null;
    }

    public String mo4092e() {
        return this.f10883a.getCallToAction();
    }

    public double mo4093f() {
        return this.f10883a.getStarRating();
    }

    public String mo4094g() {
        return this.f10883a.getStore();
    }

    public String mo4095h() {
        return this.f10883a.getPrice();
    }

    public void mo4096i() {
        this.f10883a.recordImpression();
    }

    public boolean mo4097j() {
        return this.f10883a.getOverrideImpressionRecording();
    }

    public boolean mo4098k() {
        return this.f10883a.getOverrideClickHandling();
    }

    public Bundle mo4099l() {
        return this.f10883a.getExtras();
    }

    public pb mo4100m() {
        return this.f10883a.getVideoController() != null ? this.f10883a.getVideoController().zzbs() : null;
    }

    public C2309a mo4101n() {
        Object adChoicesContent = this.f10883a.getAdChoicesContent();
        return adChoicesContent == null ? null : C2312b.m7327a(adChoicesContent);
    }
}
