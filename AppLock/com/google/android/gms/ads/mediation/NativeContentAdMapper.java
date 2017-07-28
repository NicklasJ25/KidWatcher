package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private String f4916e;
    private List<Image> f4917f;
    private String f4918g;
    private Image f4919h;
    private String f4920i;
    private String f4921j;
    private VideoController f4922k;

    public final String getAdvertiser() {
        return this.f4921j;
    }

    public final String getBody() {
        return this.f4918g;
    }

    public final String getCallToAction() {
        return this.f4920i;
    }

    public final String getHeadline() {
        return this.f4916e;
    }

    public final List<Image> getImages() {
        return this.f4917f;
    }

    public final Image getLogo() {
        return this.f4919h;
    }

    public final VideoController getVideoController() {
        return this.f4922k;
    }

    public final void setAdvertiser(String str) {
        this.f4921j = str;
    }

    public final void setBody(String str) {
        this.f4918g = str;
    }

    public final void setCallToAction(String str) {
        this.f4920i = str;
    }

    public final void setHeadline(String str) {
        this.f4916e = str;
    }

    public final void setImages(List<Image> list) {
        this.f4917f = list;
    }

    public final void setLogo(Image image) {
        this.f4919h = image;
    }

    public final void zza(VideoController videoController) {
        this.f4922k = videoController;
    }
}
