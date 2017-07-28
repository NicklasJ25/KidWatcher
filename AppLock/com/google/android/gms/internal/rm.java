package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.p065a.C2312b;
import java.util.List;

@wh
public class rm implements NativeCustomTemplateAd {
    private final rl f10515a;
    private final MediaView f10516b;
    private final VideoController f10517c = new VideoController();

    public rm(rl rlVar) {
        Context context;
        Throwable e;
        MediaView a;
        MediaView mediaView = null;
        this.f10515a = rlVar;
        try {
            context = (Context) C2312b.m7328a(rlVar.mo3957d());
        } catch (NullPointerException e2) {
            e = e2;
            aad.m8422b("Unable to inflate MediaView.", e);
            context = null;
            if (context != null) {
                a = m13642a(context);
                try {
                    if (!this.f10515a.mo3952a(C2312b.m7327a((Object) a))) {
                        a = null;
                    }
                    mediaView = a;
                } catch (Throwable e3) {
                    aad.m8422b("Unable to render video in MediaView.", e3);
                }
            }
            this.f10516b = mediaView;
        } catch (RemoteException e4) {
            e3 = e4;
            aad.m8422b("Unable to inflate MediaView.", e3);
            context = null;
            if (context != null) {
                a = m13642a(context);
                if (this.f10515a.mo3952a(C2312b.m7327a((Object) a))) {
                    a = null;
                }
                mediaView = a;
            }
            this.f10516b = mediaView;
        }
        if (context != null) {
            a = m13642a(context);
            if (this.f10515a.mo3952a(C2312b.m7327a((Object) a))) {
                a = null;
            }
            mediaView = a;
        }
        this.f10516b = mediaView;
    }

    protected MediaView m13642a(Context context) {
        return new MediaView(context);
    }

    public void destroy() {
        try {
            this.f10515a.mo3958e();
        } catch (Throwable e) {
            aad.m8422b("Failed to destroy ad.", e);
        }
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.f10515a.mo3951a();
        } catch (Throwable e) {
            aad.m8422b("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.f10515a.mo3934l();
        } catch (Throwable e) {
            aad.m8422b("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String str) {
        try {
            rd b = this.f10515a.mo3954b(str);
            if (b != null) {
                return new re(b);
            }
        } catch (Throwable e) {
            aad.m8422b("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.f10515a.mo3950a(str);
        } catch (Throwable e) {
            aad.m8422b("Failed to get string.", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            pb b = this.f10515a.mo3953b();
            if (b != null) {
                this.f10517c.zza(b);
            }
        } catch (Throwable e) {
            aad.m8422b("Exception occurred while getting video controller", e);
        }
        return this.f10517c;
    }

    public MediaView getVideoMediaView() {
        return this.f10516b;
    }

    public void performClick(String str) {
        try {
            this.f10515a.mo3956c(str);
        } catch (Throwable e) {
            aad.m8422b("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.f10515a.mo3955c();
        } catch (Throwable e) {
            aad.m8422b("Failed to record impression.", e);
        }
    }
}
