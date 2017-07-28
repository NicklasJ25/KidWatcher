package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.rd.C3178a;
import com.google.android.gms.p065a.C2309a;
import java.util.ArrayList;
import java.util.List;

@wh
public class rk extends NativeContentAd {
    private final rj f10510a;
    private final List<Image> f10511b = new ArrayList();
    private final re f10512c;
    private final VideoController f10513d = new VideoController();

    public rk(rj rjVar) {
        re reVar;
        this.f10510a = rjVar;
        try {
            List<Object> b = this.f10510a.mo3924b();
            if (b != null) {
                for (Object a : b) {
                    rd a2 = m13629a(a);
                    if (a2 != null) {
                        this.f10511b.add(new re(a2));
                    }
                }
            }
        } catch (Throwable e) {
            aad.m8422b("Failed to get image.", e);
        }
        try {
            rd d = this.f10510a.mo3941d();
            if (d != null) {
                reVar = new re(d);
                this.f10512c = reVar;
            }
        } catch (Throwable e2) {
            aad.m8422b("Failed to get icon.", e2);
        }
        reVar = null;
        this.f10512c = reVar;
    }

    rd m13629a(Object obj) {
        return obj instanceof IBinder ? C3178a.m13348a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object mo3979a() {
        return m13631b();
    }

    protected C2309a m13631b() {
        try {
            return this.f10510a.mo3945h();
        } catch (Throwable e) {
            aad.m8422b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public void destroy() {
        try {
            this.f10510a.mo3947j();
        } catch (Throwable e) {
            aad.m8422b("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.f10510a.mo3943f();
        } catch (Throwable e) {
            aad.m8422b("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.f10510a.mo3940c();
        } catch (Throwable e) {
            aad.m8422b("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.f10510a.mo3942e();
        } catch (Throwable e) {
            aad.m8422b("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.f10510a.mo3946i();
        } catch (Throwable e) {
            aad.m8424c("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.f10510a.mo3939a();
        } catch (Throwable e) {
            aad.m8422b("Failed to get headline.", e);
            return null;
        }
    }

    public List<Image> getImages() {
        return this.f10511b;
    }

    public Image getLogo() {
        return this.f10512c;
    }

    public VideoController getVideoController() {
        try {
            if (this.f10510a.mo3944g() != null) {
                this.f10513d.zza(this.f10510a.mo3944g());
            }
        } catch (Throwable e) {
            aad.m8422b("Exception occurred while getting video controller", e);
        }
        return this.f10513d;
    }
}
