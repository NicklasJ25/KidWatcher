package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private String f4906e;
    private List<Image> f4907f;
    private String f4908g;
    private Image f4909h;
    private String f4910i;
    private double f4911j;
    private String f4912k;
    private String f4913l;
    private VideoController f4914m;

    public final String getBody() {
        return this.f4908g;
    }

    public final String getCallToAction() {
        return this.f4910i;
    }

    public final String getHeadline() {
        return this.f4906e;
    }

    public final Image getIcon() {
        return this.f4909h;
    }

    public final List<Image> getImages() {
        return this.f4907f;
    }

    public final String getPrice() {
        return this.f4913l;
    }

    public final double getStarRating() {
        return this.f4911j;
    }

    public final String getStore() {
        return this.f4912k;
    }

    public final VideoController getVideoController() {
        return this.f4914m;
    }

    public final void setBody(String str) {
        this.f4908g = str;
    }

    public final void setCallToAction(String str) {
        this.f4910i = str;
    }

    public final void setHeadline(String str) {
        this.f4906e = str;
    }

    public final void setIcon(Image image) {
        this.f4909h = image;
    }

    public final void setImages(List<Image> list) {
        this.f4907f = list;
    }

    public final void setPrice(String str) {
        this.f4913l = str;
    }

    public final void setStarRating(double d) {
        this.f4911j = d;
    }

    public final void setStore(String str) {
        this.f4912k = str;
    }

    public final void zza(VideoController videoController) {
        this.f4914m = videoController;
    }
}
