package com.google.android.exoplayer2.p053e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C1949a;
import com.google.android.exoplayer2.C2109d;
import com.google.android.exoplayer2.C2251i;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p044b.C1957e;
import java.nio.ByteBuffer;

public final class C2128c<T> extends C1949a implements Callback {
    private final C2121a<T> f5950a;
    private final C2127a<T> f5951b;
    private final Handler f5952c;
    private final C2251i f5953d;
    private final C1957e f5954e;
    private boolean f5955f;
    private long f5956g;
    private T f5957h;

    public interface C2127a<T> {
        void mo3118a(T t);
    }

    public C2128c(C2127a<T> c2127a, Looper looper, C2121a<T> c2121a) {
        super(4);
        this.f5951b = (C2127a) C2252a.m7020a((Object) c2127a);
        this.f5952c = looper == null ? null : new Handler(looper, this);
        this.f5950a = (C2121a) C2252a.m7020a((Object) c2121a);
        this.f5953d = new C2251i();
        this.f5954e = new C1957e(1);
    }

    private void m6449a(T t) {
        if (this.f5952c != null) {
            this.f5952c.obtainMessage(0, t).sendToTarget();
        } else {
            m6450b(t);
        }
    }

    private void m6450b(T t) {
        this.f5951b.mo3118a(t);
    }

    public int mo2911a(Format format) {
        return this.f5950a.mo3009a(format.f4947e) ? 3 : 0;
    }

    public void mo2912a(long j, long j2) {
        if (!this.f5955f && this.f5957h == null) {
            this.f5954e.mo2931a();
            if (m5601a(this.f5953d, this.f5954e) == -4) {
                if (this.f5954e.m5694c()) {
                    this.f5955f = true;
                } else {
                    this.f5956g = this.f5954e.f5126c;
                    try {
                        this.f5954e.m5709e();
                        ByteBuffer byteBuffer = this.f5954e.f5125b;
                        this.f5957h = this.f5950a.mo3008a(byteBuffer.array(), byteBuffer.limit());
                    } catch (Exception e) {
                        throw C2109d.m6416a(e, m5625p());
                    }
                }
            }
        }
        if (this.f5957h != null && this.f5956g <= j) {
            m6449a(this.f5957h);
            this.f5957h = null;
        }
    }

    protected void mo2913a(long j, boolean z) {
        this.f5957h = null;
        this.f5955f = false;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m6450b(message.obj);
                return true;
            default:
                return false;
        }
    }

    protected void mo2917o() {
        this.f5957h = null;
        super.mo2917o();
    }

    public boolean mo2918r() {
        return true;
    }

    public boolean mo2919s() {
        return this.f5955f;
    }
}
