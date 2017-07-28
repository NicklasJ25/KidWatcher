package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.rl.C3184a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.Arrays;
import java.util.List;

@wh
public class qv extends C3184a implements C3180a {
    private final qq f10399a;
    private final String f10400b;
    private final SimpleArrayMap<String, qs> f10401c;
    private final SimpleArrayMap<String, String> f10402d;
    @Nullable
    private pb f10403e;
    @Nullable
    private View f10404f;
    private final Object f10405g = new Object();
    private qz f10406h;

    class C31831 implements qw {
        final /* synthetic */ qv f10398a;

        C31831(qv qvVar) {
            this.f10398a = qvVar;
        }

        public void mo3948a() {
            this.f10398a.mo3956c(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
        }

        public void mo3949a(MotionEvent motionEvent) {
        }
    }

    public qv(String str, SimpleArrayMap<String, qs> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, qq qqVar, pb pbVar, View view) {
        this.f10400b = str;
        this.f10401c = simpleArrayMap;
        this.f10402d = simpleArrayMap2;
        this.f10399a = qqVar;
        this.f10403e = pbVar;
        this.f10404f = view;
    }

    public String mo3950a(String str) {
        return (String) this.f10402d.get(str);
    }

    public List<String> mo3951a() {
        int i = 0;
        String[] strArr = new String[(this.f10401c.size() + this.f10402d.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f10401c.size(); i3++) {
            strArr[i2] = (String) this.f10401c.keyAt(i3);
            i2++;
        }
        while (i < this.f10402d.size()) {
            strArr[i2] = (String) this.f10402d.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public void mo3923a(qz qzVar) {
        synchronized (this.f10405g) {
            this.f10406h = qzVar;
        }
    }

    public boolean mo3952a(C2309a c2309a) {
        if (this.f10406h == null) {
            aad.m8423c("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.f10404f == null) {
            return false;
        } else {
            View view = (FrameLayout) C2312b.m7328a(c2309a);
            this.f10406h.mo3962a(view, new C31831(this));
            return true;
        }
    }

    public pb mo3953b() {
        return this.f10403e;
    }

    public rd mo3954b(String str) {
        return (rd) this.f10401c.get(str);
    }

    public void mo3955c() {
        synchronized (this.f10405g) {
            if (this.f10406h == null) {
                aad.m8423c("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.f10406h.mo3964a(null, null);
        }
    }

    public void mo3956c(String str) {
        synchronized (this.f10405g) {
            if (this.f10406h == null) {
                aad.m8423c("Attempt to call performClick before ad initialized.");
                return;
            }
            this.f10406h.mo3963a(null, str, null, null, null);
        }
    }

    public C2309a mo3957d() {
        return C2312b.m7327a(this.f10406h.mo3970f().getApplicationContext());
    }

    public void mo3958e() {
        this.f10406h = null;
        this.f10403e = null;
        this.f10404f = null;
    }

    public String mo3933k() {
        return GpsMeasureMode.MODE_3_DIMENSIONAL;
    }

    public String mo3934l() {
        return this.f10400b;
    }

    public qq mo3935m() {
        return this.f10399a;
    }

    public View mo3937o() {
        return this.f10404f;
    }
}
