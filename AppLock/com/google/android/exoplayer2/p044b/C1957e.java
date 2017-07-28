package com.google.android.exoplayer2.p044b;

import java.nio.ByteBuffer;

public class C1957e extends C1953a {
    public final C1954b f5124a = new C1954b();
    public ByteBuffer f5125b;
    public long f5126c;
    private final int f5127d;

    public C1957e(int i) {
        this.f5127d = i;
    }

    private ByteBuffer m5706f(int i) {
        if (this.f5127d == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.f5127d == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.f5125b == null ? 0 : this.f5125b.capacity()) + " < " + i + ")");
    }

    public void mo2931a() {
        super.mo2931a();
        if (this.f5125b != null) {
            this.f5125b.clear();
        }
    }

    public final boolean m5708d() {
        return m5695d(1073741824);
    }

    public final void m5709e() {
        this.f5125b.flip();
    }

    public void m5710e(int i) {
        if (this.f5125b == null) {
            this.f5125b = m5706f(i);
            return;
        }
        int capacity = this.f5125b.capacity();
        int position = this.f5125b.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer f = m5706f(i2);
            if (position > 0) {
                this.f5125b.position(0);
                this.f5125b.limit(position);
                f.put(this.f5125b);
            }
            this.f5125b = f;
        }
    }
}
