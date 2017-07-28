package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.domobile.applock.chamber.model.FileInfo;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import java.lang.ref.WeakReference;

public class C1791b extends C1785n implements OnAudioFocusChangeListener {
    private WeakReference<OnAudioFocusChangeListener> f4460b = null;
    private final C1759c f4461c = new C17871(this);
    private final C1765i f4462d = new C17882(this);
    private final C1767k f4463e = new C17903(this);

    class C17871 extends C1759c {
        final /* synthetic */ C1791b f4456a;

        C17871(C1791b c1791b) {
            this.f4456a = c1791b;
        }

        public void m5063a(C1758b c1758b) {
            ((AudioManager) this.f4456a.getContext().getApplicationContext().getSystemService(FileInfo.MIME_AUDIO)).abandonAudioFocus(this.f4456a.f4460b == null ? null : (OnAudioFocusChangeListener) this.f4456a.f4460b.get());
        }
    }

    class C17882 extends C1765i {
        final /* synthetic */ C1791b f4457a;

        C17882(C1791b c1791b) {
            this.f4457a = c1791b;
        }

        public void m5065a(C1764h c1764h) {
            ((AudioManager) this.f4457a.getContext().getApplicationContext().getSystemService(FileInfo.MIME_AUDIO)).abandonAudioFocus(this.f4457a.f4460b == null ? null : (OnAudioFocusChangeListener) this.f4457a.f4460b.get());
        }
    }

    class C17903 extends C1767k {
        final /* synthetic */ C1791b f4459a;

        class C17891 implements OnAudioFocusChangeListener {
            final /* synthetic */ C17903 f4458a;

            C17891(C17903 c17903) {
                this.f4458a = c17903;
            }

            public void onAudioFocusChange(int i) {
                if (this.f4458a.f4459a.getVideoView() != null && i <= 0) {
                    this.f4458a.f4459a.getVideoView().m5256e();
                }
            }
        }

        C17903(C1791b c1791b) {
            this.f4459a = c1791b;
        }

        public void m5067a(C1766j c1766j) {
            if (this.f4459a.f4460b == null || this.f4459a.f4460b.get() == null) {
                this.f4459a.f4460b = new WeakReference(new C17891(this));
            }
            ((AudioManager) this.f4459a.getContext().getApplicationContext().getSystemService(FileInfo.MIME_AUDIO)).requestAudioFocus((OnAudioFocusChangeListener) this.f4459a.f4460b.get(), 3, 1);
        }
    }

    public C1791b(Context context) {
        super(context);
    }

    protected void a_(C1864k c1864k) {
        c1864k.getEventBus().m4513a(this.f4463e);
        c1864k.getEventBus().m4513a(this.f4461c);
        c1864k.getEventBus().m4513a(this.f4462d);
        super.a_(c1864k);
    }

    public void onAudioFocusChange(int i) {
        if (getVideoView() != null && i <= 0) {
            getVideoView().m5256e();
        }
    }

    protected void onDetachedFromWindow() {
        ((AudioManager) getContext().getApplicationContext().getSystemService(FileInfo.MIME_AUDIO)).abandonAudioFocus(this.f4460b == null ? null : (OnAudioFocusChangeListener) this.f4460b.get());
        super.onDetachedFromWindow();
    }
}
