package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.rd.C3178a;
import com.google.android.gms.p065a.C2309a;
import java.util.ArrayList;
import java.util.List;

@wh
public class ri extends NativeAppInstallAd {
    private final rh f10505a;
    private final List<Image> f10506b = new ArrayList();
    private final re f10507c;
    private final VideoController f10508d = new VideoController();

    public ri(rh rhVar) {
        re reVar;
        this.f10505a = rhVar;
        try {
            List<Object> b = this.f10505a.mo3924b();
            if (b != null) {
                for (Object a : b) {
                    rd a2 = m13616a(a);
                    if (a2 != null) {
                        this.f10506b.add(new re(a2));
                    }
                }
            }
        } catch (Throwable e) {
            aad.m8422b("Failed to get image.", e);
        }
        try {
            rd d = this.f10505a.mo3926d();
            if (d != null) {
                reVar = new re(d);
                this.f10507c = reVar;
            }
        } catch (Throwable e2) {
            aad.m8422b("Failed to get icon.", e2);
        }
        reVar = null;
        this.f10507c = reVar;
    }

    rd m13616a(Object obj) {
        return obj instanceof IBinder ? C3178a.m13348a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object mo3979a() {
        return m13618b();
    }

    protected C2309a m13618b() {
        try {
            return this.f10505a.mo3932j();
        } catch (Throwable e) {
            aad.m8422b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public void destroy() {
        try {
            this.f10505a.mo3938p();
        } catch (Throwable e) {
            aad.m8422b("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.f10505a.mo3925c();
        } catch (Throwable e) {
            aad.m8422b("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.f10505a.mo3927e();
        } catch (Throwable e) {
            aad.m8422b("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.f10505a.mo3936n();
        } catch (Throwable e) {
            aad.m8422b("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.f10505a.mo3922a();
        } catch (Throwable e) {
            aad.m8422b("Failed to get headline.", e);
            return null;
        }
    }

    public Image getIcon() {
        return this.f10507c;
    }

    public List<Image> getImages() {
        return this.f10506b;
    }

    public CharSequence getPrice() {
        try {
            return this.f10505a.mo3930h();
        } catch (Throwable e) {
            aad.m8422b("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        Double d = null;
        try {
            double f = this.f10505a.mo3928f();
            if (f != -1.0d) {
                d = Double.valueOf(f);
            }
        } catch (Throwable e) {
            aad.m8422b("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence getStore() {
        try {
            return this.f10505a.mo3929g();
        } catch (Throwable e) {
            aad.m8422b("Failed to get store", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            if (this.f10505a.mo3931i() != null) {
                this.f10508d.zza(this.f10505a.mo3931i());
            }
        } catch (Throwable e) {
            aad.m8422b("Exception occurred while getting video controller", e);
        }
        return this.f10508d;
    }
}
