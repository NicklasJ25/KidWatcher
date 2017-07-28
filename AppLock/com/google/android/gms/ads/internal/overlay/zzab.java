package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.domobile.applock.chamber.model.FileInfo;
import com.google.android.gms.internal.wh;

@TargetApi(14)
@wh
public class zzab implements OnAudioFocusChangeListener {
    private final AudioManager f6732a;
    private final C2331a f6733b;
    private boolean f6734c;
    private boolean f6735d;
    private boolean f6736e;
    private float f6737f = 1.0f;

    interface C2331a {
        void zzhC();
    }

    public zzab(Context context, C2331a c2331a) {
        this.f6732a = (AudioManager) context.getSystemService(FileInfo.MIME_AUDIO);
        this.f6733b = c2331a;
    }

    private void m7387a() {
        Object obj = (!this.f6735d || this.f6736e || this.f6737f <= 0.0f) ? null : 1;
        if (obj != null && !this.f6734c) {
            m7388b();
            this.f6733b.zzhC();
        } else if (obj == null && this.f6734c) {
            m7389c();
            this.f6733b.zzhC();
        }
    }

    private void m7388b() {
        boolean z = true;
        if (this.f6732a != null && !this.f6734c) {
            if (this.f6732a.requestAudioFocus(this, 3, 2) != 1) {
                z = false;
            }
            this.f6734c = z;
        }
    }

    private void m7389c() {
        if (this.f6732a != null && this.f6734c) {
            this.f6734c = this.f6732a.abandonAudioFocus(this) == 0;
        }
    }

    public void onAudioFocusChange(int i) {
        this.f6734c = i > 0;
        this.f6733b.zzhC();
    }

    public void setMuted(boolean z) {
        this.f6736e = z;
        m7387a();
    }

    public void zzb(float f) {
        this.f6737f = f;
        m7387a();
    }

    public float zziA() {
        return this.f6734c ? this.f6736e ? 0.0f : this.f6737f : 0.0f;
    }

    public void zzix() {
        this.f6735d = true;
        m7387a();
    }

    public void zziy() {
        this.f6735d = false;
        m7387a();
    }
}
